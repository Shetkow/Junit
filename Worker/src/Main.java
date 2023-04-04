public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListner errorListner = System.out::println;
        Worker worker = new Worker(listener,errorListner);
        //worker.start();
        worker.onError();
    }

    public static class Worker {

        private OnTaskDoneListener callback;
        private OnTaskErrorListner errorCallback;

        public Worker(OnTaskDoneListener callback,OnTaskErrorListner errorCallback) {
            this.errorCallback = errorCallback;
            this.callback = callback;
        }
        public void onError(){
            for(int i = 0;i < 100;i++){
                if(i == 33){
                    errorCallback.onError( i +" Произошла ошибка");
                }else{
                    callback.OnDone("Task " + i + " is Done");
                }
            }
        }
        public void start() {
            for (int i = 0; i < 100; i++) {
                callback.OnDone("Task " + i + " is Done");
            }
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void OnDone(String result);
    }
@FunctionalInterface
    public interface OnTaskErrorListner{
        void onError(String result);
}
}
