package ohcna;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="BookingList_table")
public class BookingList {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long bookingId;
        private Long confirmId;
        private String bookingUserId;
        private String bookingDtm;
        private Long roomId;
        private String useStartDtm;
        private String useEndDtm;
        private String confirmStatus;
        private String confirmUserId;
        private String confirmDtm;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getBookingId() {
            return bookingId;
        }

        public void setBookingId(Long bookingId) {
            this.bookingId = bookingId;
        }
        public Long getConfirmId() {
            return confirmId;
        }

        public void setConfirmId(Long confirmId) {
            this.confirmId = confirmId;
        }
        public String getBookingUserId() {
            return bookingUserId;
        }

        public void setBookingUserId(String bookingUserId) {
            this.bookingUserId = bookingUserId;
        }
        public String getBookingDtm() {
            return bookingDtm;
        }

        public void setBookingDtm(String bookingDtm) {
            this.bookingDtm = bookingDtm;
        }
        public Long getRoomId() {
            return roomId;
        }

        public void setRoomId(Long roomId) {
            this.roomId = roomId;
        }
        public String getUseStartDtm() {
            return useStartDtm;
        }

        public void setUseStartDtm(String useStartDtm) {
            this.useStartDtm = useStartDtm;
        }
        public String getUseEndDtm() {
            return useEndDtm;
        }

        public void setUseEndDtm(String useEndDtm) {
            this.useEndDtm = useEndDtm;
        }
        public String getConfirmStatus() {
            return confirmStatus;
        }

        public void setConfirmStatus(String confirmStatus) {
            this.confirmStatus = confirmStatus;
        }
        public String getConfirmUserId() {
            return confirmUserId;
        }

        public void setConfirmUserId(String confirmUserId) {
            this.confirmUserId = confirmUserId;
        }
        public String getConfirmDtm() {
            return confirmDtm;
        }

        public void setConfirmDtm(String confirmDtm) {
            this.confirmDtm = confirmDtm;
        }

}
