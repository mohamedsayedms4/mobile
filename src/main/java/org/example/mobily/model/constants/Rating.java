    package org.example.mobily.model.constants;

    import com.fasterxml.jackson.annotation.JsonCreator;
    import org.example.mobily.exceptions.InvalidRatingException;

    public enum Rating {
        ONE_STAR(1, "ضعيف"),
        TWO_STARS(2, "متوسط"),
        THREE_STARS(3, "جيد"),
        FOUR_STARS(4, "جيد جداً"),
        FIVE_STARS(5, "ممتاز");

        private final int stars;
        private final String arabicName;

        Rating(int stars, String arabicName) {
            this.stars = stars;
            this.arabicName = arabicName;
        }

        public int getStars() {
            return stars;
        }

        public String getArabicName() {
            return arabicName;
        }

        @Override
        public String toString() {
            return stars + " ⭐ - " + arabicName;
        }

        // ✅ يرجع Rating بناءً على رقم (ممكن متوسط تقييم)
        public static Rating fromValue(double value) {
            int rounded = (int) Math.round(value); // تقريب لأقرب رقم صحيح
            return switch (rounded) {
                case 1 -> ONE_STAR;
                case 2 -> TWO_STARS;
                case 3 -> THREE_STARS;
                case 4 -> FOUR_STARS;
                case 5 -> FIVE_STARS;
                default -> THREE_STARS; // default لو حصل رقم خارج النطاق
            };
        }
        public Rating parseRating(int value) {
            return switch (value) {
                case 1 -> Rating.ONE_STAR;
                case 2 -> Rating.TWO_STARS;
                case 3 -> Rating.THREE_STARS;
                case 4 -> Rating.FOUR_STARS;
                case 5 -> Rating.FIVE_STARS;
                default -> throw new InvalidRatingException(value);
            };
        }

//        @JsonCreator
//        public static Rating fromString(String value) {
//            for (Rating m : Rating.values()) {
//                if (m.name().equalsIgnoreCase(value)) {
//                    return m;
//                }
//            }
//            throw new org.example.mobily.exceptions.InvalidRatingException();
//        }

    }
