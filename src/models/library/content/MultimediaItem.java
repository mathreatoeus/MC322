package models.library.content;

import java.time.LocalDate;

public abstract class MultimediaItem {
    // Enum -----------------------------------------------------------------------------
    public enum MultimediaType {
        AUDIO, VIDEO, SOFTWARE
    }

    // Static Nested Classes ------------------------------------------------------------

    public static class AudioResource extends Item{
        // Private Attributes ***********************************************************
        private final MultimediaType type;
        private final int size;                                                   // Mbs.
        private final String publisher;

        // Constructor ******************************************************************
        public AudioResource(String title, LocalDate publicationDate, int numCopies,
                             int size, String publisher) {
            super(title, publicationDate, numCopies);
            this.type = MultimediaType.AUDIO;
            this.size = size;
            this.publisher = publisher;
        }

        // Getters **********************************************************************
        public  MultimediaType getType() {
            return type;
        }

        public int getSize() {
            return size;
        }

        public String getPublisher() {
            return publisher;
        }
    }

    public static class VideoResource extends Item {
        // Private Attributes ***********************************************************
        private final MultimediaType type;
        private final int minutes;
        private final String videographer;

        // Constructor ******************************************************************
        public VideoResource(String title, LocalDate publicationDate, int numCopies,
                             int minutes, String videographer) {
            super(title, publicationDate, numCopies);
            this.type = MultimediaType.VIDEO;
            this.minutes = minutes;
            this.videographer = videographer;
        }

        // Getters **********************************************************************
        public  MultimediaType getType() {
            return type;
        }

        public int getMinutes() {
            return minutes;
        }

        public String getVideographer() {
            return videographer;
        }
    }

    public static class SoftwareResource extends Item {
        // Private Attributes ***********************************************************
        private final MultimediaType type;
        private final String owner;
        private boolean licenseIsActive;

        // Constructor ******************************************************************
        public SoftwareResource(String title, LocalDate publicationDate, int numCopies,
                                String owner, boolean licenseIsActive) {
            super(title, publicationDate, numCopies);
            this.type = MultimediaType.SOFTWARE;
            this.owner = owner;
            this.licenseIsActive = licenseIsActive;
        }

        // Getters **********************************************************************
        public  MultimediaType getType() {
            return type;
        }

        public String getOwner() {
            return owner;
        }

        public boolean getLicenseIsActive() {
            return licenseIsActive;
        }

        // Setters **********************************************************************
        private void setLicenseIsActive(boolean newStatus) {
            this.licenseIsActive = newStatus;
        }
    }
}
