import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class ClockPanel extends JPanel {
    private JLabel timeLabel;
    private TimeZone timeZone;
    private SimpleDateFormat dateFormat;

    public ClockPanel(String timeZoneId) {
        timeZone = TimeZone.getTimeZone("GMT" + timeZoneId);
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        timeLabel = new JLabel();
        updateTime();
        add(timeLabel);

        Thread updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        updateTime();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        updateThread.start();
    }

    public void updateTime() {
        dateFormat.setTimeZone(timeZone);
        timeLabel.setText(dateFormat.format(new Date()));
    }
}
