public class Notifications implements Notifier {
    public static Notifications the = null;

        private boolean quietmode = false;

        public Notifications() {}

        public static Notifications the() {
            if (the == null) {
                the = new Notifications();
            }
            return the;
        }

        public boolean toggleQuietMode() {
            quietmode = !quietmode;
            return quietmode;
        }

        public void displayNotification(String notice) {
            if(!quietmode)
                System.out.println("Notification: " + notice);
        }
}
