package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 03 19:42:20 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShinsakaiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiList_Row extends DataRow {

    private RString shinsakaiNo;
    private TextBoxFlexibleDate kaisaiDate;
    private RString startTime;
    private RString endTime;
    private RString kaisaiBasho;
    private RString gogitai;
    private RString yoteiTeiin;
    private RString maxTeiin;
    private RString autoBindTeiin;

    public dgShinsakaiList_Row() {
        super();
    }

    public dgShinsakaiList_Row(RString shinsakaiNo, TextBoxFlexibleDate kaisaiDate, RString startTime, RString endTime, RString kaisaiBasho, RString gogitai, RString yoteiTeiin, RString maxTeiin, RString autoBindTeiin) {
        super();
        this.setOriginalData("shinsakaiNo", shinsakaiNo);
        this.setOriginalData("kaisaiDate", kaisaiDate);
        this.setOriginalData("startTime", startTime);
        this.setOriginalData("endTime", endTime);
        this.setOriginalData("kaisaiBasho", kaisaiBasho);
        this.setOriginalData("gogitai", gogitai);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("maxTeiin", maxTeiin);
        this.setOriginalData("autoBindTeiin", autoBindTeiin);
        this.shinsakaiNo = shinsakaiNo;
        this.kaisaiDate = kaisaiDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.kaisaiBasho = kaisaiBasho;
        this.gogitai = gogitai;
        this.yoteiTeiin = yoteiTeiin;
        this.maxTeiin = maxTeiin;
        this.autoBindTeiin = autoBindTeiin;
    }

    public RString getShinsakaiNo() {
        return shinsakaiNo;
    }

    public TextBoxFlexibleDate getKaisaiDate() {
        return kaisaiDate;
    }

    public RString getStartTime() {
        return startTime;
    }

    public RString getEndTime() {
        return endTime;
    }

    public RString getKaisaiBasho() {
        return kaisaiBasho;
    }

    public RString getGogitai() {
        return gogitai;
    }

    public RString getYoteiTeiin() {
        return yoteiTeiin;
    }

    public RString getMaxTeiin() {
        return maxTeiin;
    }

    public RString getAutoBindTeiin() {
        return autoBindTeiin;
    }

    public void setShinsakaiNo(RString shinsakaiNo) {
        this.setOriginalData("shinsakaiNo", shinsakaiNo);
        this.shinsakaiNo = shinsakaiNo;
    }

    public void setKaisaiDate(TextBoxFlexibleDate kaisaiDate) {
        this.setOriginalData("kaisaiDate", kaisaiDate);
        this.kaisaiDate = kaisaiDate;
    }

    public void setStartTime(RString startTime) {
        this.setOriginalData("startTime", startTime);
        this.startTime = startTime;
    }

    public void setEndTime(RString endTime) {
        this.setOriginalData("endTime", endTime);
        this.endTime = endTime;
    }

    public void setKaisaiBasho(RString kaisaiBasho) {
        this.setOriginalData("kaisaiBasho", kaisaiBasho);
        this.kaisaiBasho = kaisaiBasho;
    }

    public void setGogitai(RString gogitai) {
        this.setOriginalData("gogitai", gogitai);
        this.gogitai = gogitai;
    }

    public void setYoteiTeiin(RString yoteiTeiin) {
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.yoteiTeiin = yoteiTeiin;
    }

    public void setMaxTeiin(RString maxTeiin) {
        this.setOriginalData("maxTeiin", maxTeiin);
        this.maxTeiin = maxTeiin;
    }

    public void setAutoBindTeiin(RString autoBindTeiin) {
        this.setOriginalData("autoBindTeiin", autoBindTeiin);
        this.autoBindTeiin = autoBindTeiin;
    }

}