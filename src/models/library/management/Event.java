package models.library.management;

import java.time.LocalDateTime;

public abstract class Event {
    // Static nested classes ------------------------------------------------------------

    public static class Talk extends LibraryEvent{
        // Private Attributes ***********************************************************
        private final String talker;

        // Constructor ******************************************************************
        public Talk(String topic, LocalDateTime dateTime, String place, String talker) {
            super(EventType.TALK, topic, dateTime, place);
            this.talker = talker;
        }

        // Getters **********************************************************************
        public String getTalker() {
            return talker;
        }
    }

    public static class Workshop extends LibraryEvent {
        // Private Attributes ***********************************************************
        private final String instructor;
        private final String[] materials;

        // Constructor ******************************************************************
        public Workshop(String topic, LocalDateTime dateTime, String place, String instructor,
                        String[] materials) {
            super(EventType.WORKSHOP, topic, dateTime, place);
            this.instructor = instructor;
            this.materials = materials;
        }

        // Getters **********************************************************************
        public String getInstructor() {
            return instructor;
        }

        public String[] getMaterials() {
            return materials;
        }
    }

    public static class Exhibit extends LibraryEvent {
        // Private Attributes ***********************************************************
        private final String[] exhibitors;
        private final String duration;

        // Constructor ******************************************************************
        public Exhibit(String topic, LocalDateTime dateTime, String place, String[] exhibitors,
                       String duration) {
            super(EventType.EXHIBIT, topic, dateTime, place);
            this.exhibitors = exhibitors;
            this.duration = duration;
        }

        // Getters **********************************************************************
        public String[] getExhibitors() {
            return exhibitors;
        }

        public String getDuration() {
            return duration;
        }
    }
}
