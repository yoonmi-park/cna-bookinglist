package ohcna;

import ohcna.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingListViewHandler {


    @Autowired
    private BookingListRepository bookingListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookingCreated_then_CREATE_1 (@Payload BookingCreated bookingCreated) {
        try {
            if (bookingCreated.isMe()) {
                // view 객체 생성
                BookingList bookingList = new BookingList();

//                private String confirmUserId;
//                private String confirmDtm;

                String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                // view 객체에 이벤트의 Value 를 set 함
                bookingList.setBookingId(bookingCreated.getId());
                bookingList.setRoomId(bookingCreated.getRoomId());
                bookingList.setUseStartDtm(bookingCreated.getUseStartDtm());
                bookingList.setUseEndDtm(bookingCreated.getUseEndDtm());
                bookingList.setBookingUserId(bookingCreated.getBookingUserId());
                bookingList.setBookingDtm(nowDate);
                // view 레파지 토리에 save
                System.out.println("BookingList Create");
                bookingListRepository.save(bookingList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenConfirmCompleted_then_UPDATE_1(@Payload ConfirmCompleted confirmCompleted) {
        try {
            if (confirmCompleted.isMe()) {
                // view 객체 조회
                List<BookingList> bookingListList = bookingListRepository.findByBookingId(confirmCompleted.getId());
                for(BookingList bookingList : bookingListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // bookingList.setConfirmId(confirmCompleted.getConfirmUserId());
                    bookingList.setConfirmStatus(confirmCompleted.getStatus());
                    bookingList.setConfirmUserId(confirmCompleted.getConfirmUserId());
                    String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    bookingList.setConfirmDtm(nowDate);
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookingChanged_then_UPDATE_2(@Payload BookingChanged bookingChanged) {
        try {
            if (bookingChanged.isMe()) {
                // view 객체 조회
                List<BookingList> bookingListList = bookingListRepository.findByBookingId(bookingChanged.getId());
                for(BookingList bookingList : bookingListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setUseStartDtm(bookingChanged.getUseStartDtm());
                    bookingList.setUseEndDtm(bookingChanged.getUseEndDtm());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookingCanceled_then_DELETE_1(@Payload BookingCanceled bookingCanceled) {
        try {
            if (bookingCanceled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                bookingListRepository.deleteByBookingId(bookingCanceled.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}