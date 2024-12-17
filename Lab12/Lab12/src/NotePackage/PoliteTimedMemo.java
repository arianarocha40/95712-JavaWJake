//Done

package NotePackage;

public class PoliteTimedMemo extends TimedMemo {

    // private static final String DEFAULT_GREETING = "Dear";
    // private static final String DEFAULT_CLOSING = "Yours truly,";

    public static class Builder {
        private String name;
        private String body;
        private String from;
        private String to;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setFrom(String from) {
            this.from = from;
            return this;
        }

        public Builder setTo(String to) {
            this.to = to;
            return this;
        }

        public PoliteTimedMemo build() {
            return new PoliteTimedMemo(this);
        }
    }

    //public PoliteTimedMemo(String name, String body, String from, String to) {
    private PoliteTimedMemo(Builder builder) {
        //super(name, body, from, to);
        super(builder.name, builder.body, builder.from, builder.to);
    }

    @Override
    public String toString() {
        return "Polite Timed Memo\n" + super.toString() + "\nThanks!";
        //return DEFAULT_GREETING + " " + to + ":\n" + body + "\n" + DEFAULT_CLOSING + "\n" + from + "\n" + super.toString();
    }
}
