import com.ssau.btc.model.IndexSnapshot;
import com.ssau.btc.model.SnapshotMode;
import com.ssau.btc.sys.WebDataLoader;
import com.ssau.btc.sys.WebLoaderAPI;
import org.junit.Test;

import java.util.Collection;

/**
 * @author Sergey Saiyan
 * @version $Id$
 */
public class WebDataLoadTest {

    @Test
    public void run() {
        WebDataLoader webDataLoader = new WebDataLoader();
        Collection<IndexSnapshot> indexSnapshotsClosePrice = webDataLoader.
                loadCoinDeskIndexes("2014-01-01", "2014-01-03", SnapshotMode.CLOSING_PRICE, WebLoaderAPI.HOUR);

        Collection<IndexSnapshot> indexSnapshotsOHLC = webDataLoader.loadCoinDeskIndexes
                ("2014-01-01", "2014-02-01", SnapshotMode.OHLC, WebLoaderAPI.DAY);

        if (indexSnapshotsClosePrice.isEmpty() || indexSnapshotsOHLC.isEmpty()) {
            throw new RuntimeException("Snapshots are empty");
        }
    }
}
