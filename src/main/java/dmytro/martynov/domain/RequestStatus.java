package dmytro.martynov.domain;

    public enum RequestStatus {
        PROCESSED, ERROR, HELD;

        public static RequestStatus getRandom() {
            return  values()[(int) (Math.random() * values().length)];
        }

    }

