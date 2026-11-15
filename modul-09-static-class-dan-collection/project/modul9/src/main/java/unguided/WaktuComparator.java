package unguided;

import java.util.Comparator;

public class WaktuComparator implements Comparator<ModelEksperimen> {
    @Override
    public int compare(ModelEksperimen e1, ModelEksperimen e2) {
        // Mengurutkan berdasarkan waktu training dari yang tercepat ke terlama (Ascending)
        return Integer.compare(e1.getWaktuTraining(), e2.getWaktuTraining());
    }
}
