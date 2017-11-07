package apps.ahqmrf.easybus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewSeatStatusActivity extends AppCompatActivity implements OnSeatClickCallback{

    @BindView(R.id.seatStatusList)   RecyclerView seatStatusListView;
    @BindView(R.id.inputCheckerName) EditText     checkerNameInputView;
    @BindView(R.id.inputPassword)    EditText     passwordInputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_seat_status);
        ButterKnife.bind(this);

        ViewTreeObserver vto = seatStatusListView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                ViewTreeObserver vto = seatStatusListView.getViewTreeObserver();
                vto.removeGlobalOnLayoutListener(this);
                setUpRecycler(seatStatusListView.getMeasuredWidth() / 4);
            }
        });
    }

    private void setUpRecycler(int itemSize) {
        // Gain seat list and then
        // for demo, we have taken a list of 40 seats
        ArrayList<Seat> seats = new ArrayList<>();
        for (int i = 0; i < 40; i++) seats.add(new Seat());
        SeatListAdapter adapter = new SeatListAdapter(itemSize, seats, this);
        seatStatusListView.setLayoutManager(new GridLayoutManager(this, 4));
        seatStatusListView.setAdapter(adapter);
    }

    @OnClick(R.id.sendData)
    void onSendDataClick() {
        // TODO what happens if user clicks on send data
        String name = checkerNameInputView.getText().toString();
        String password = passwordInputView.getText().toString();
    }

    @OnClick(R.id.complainBox)
    void onComplainBoxClick() {
        // TODO what happens if user clicks on complain box
    }

    @Override
    public void onSeatClick(Seat seat) {
        // TODO what happens on a seat click
    }
}
