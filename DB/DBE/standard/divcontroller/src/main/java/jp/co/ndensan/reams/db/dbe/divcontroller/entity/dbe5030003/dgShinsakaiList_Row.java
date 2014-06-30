package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 27 20:13:50 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShinsakaiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiList_Row extends DataRow {

    private Button btnToDecide;
    private RString kaisaiNo;
    private TextBoxFlexibleDate txtKaisaiDate;
    private RString gogitaiMeisho;
    private RString kaisaibasho;
    private RString yoteiTeiin;
    private RString wariateNinzu;
    private RString startTime;
    private RString endTime;

    public dgShinsakaiList_Row() {
        super();
        this.btnToDecide = new Button();
        this.kaisaiNo = RString.EMPTY;
        this.txtKaisaiDate = new TextBoxFlexibleDate();
        this.gogitaiMeisho = RString.EMPTY;
        this.kaisaibasho = RString.EMPTY;
        this.yoteiTeiin = RString.EMPTY;
        this.wariateNinzu = RString.EMPTY;
        this.startTime = RString.EMPTY;
        this.endTime = RString.EMPTY;
    }

    public dgShinsakaiList_Row(Button btnToDecide, RString kaisaiNo, TextBoxFlexibleDate txtKaisaiDate, RString gogitaiMeisho, RString kaisaibasho, RString yoteiTeiin, RString wariateNinzu, RString startTime, RString endTime) {
        super();
        this.setOriginalData("btnToDecide", btnToDecide);
        this.setOriginalData("kaisaiNo", kaisaiNo);
        this.setOriginalData("txtKaisaiDate", txtKaisaiDate);
        this.setOriginalData("gogitaiMeisho", gogitaiMeisho);
        this.setOriginalData("kaisaibasho", kaisaibasho);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("wariateNinzu", wariateNinzu);
        this.setOriginalData("startTime", startTime);
        this.setOriginalData("endTime", endTime);
        this.btnToDecide = btnToDecide;
        this.kaisaiNo = kaisaiNo;
        this.txtKaisaiDate = txtKaisaiDate;
        this.gogitaiMeisho = gogitaiMeisho;
        this.kaisaibasho = kaisaibasho;
        this.yoteiTeiin = yoteiTeiin;
        this.wariateNinzu = wariateNinzu;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Button getBtnToDecide() {
        return btnToDecide;
    }

    public RString getKaisaiNo() {
        return kaisaiNo;
    }

    public TextBoxFlexibleDate getTxtKaisaiDate() {
        return txtKaisaiDate;
    }

    public RString getGogitaiMeisho() {
        return gogitaiMeisho;
    }

    public RString getKaisaibasho() {
        return kaisaibasho;
    }

    public RString getYoteiTeiin() {
        return yoteiTeiin;
    }

    public RString getWariateNinzu() {
        return wariateNinzu;
    }

    public RString getStartTime() {
        return startTime;
    }

    public RString getEndTime() {
        return endTime;
    }

    public void setBtnToDecide(Button btnToDecide) {
        this.setOriginalData("btnToDecide", btnToDecide);
        this.btnToDecide = btnToDecide;
    }

    public void setKaisaiNo(RString kaisaiNo) {
        this.setOriginalData("kaisaiNo", kaisaiNo);
        this.kaisaiNo = kaisaiNo;
    }

    public void setTxtKaisaiDate(TextBoxFlexibleDate txtKaisaiDate) {
        this.setOriginalData("txtKaisaiDate", txtKaisaiDate);
        this.txtKaisaiDate = txtKaisaiDate;
    }

    public void setGogitaiMeisho(RString gogitaiMeisho) {
        this.setOriginalData("gogitaiMeisho", gogitaiMeisho);
        this.gogitaiMeisho = gogitaiMeisho;
    }

    public void setKaisaibasho(RString kaisaibasho) {
        this.setOriginalData("kaisaibasho", kaisaibasho);
        this.kaisaibasho = kaisaibasho;
    }

    public void setYoteiTeiin(RString yoteiTeiin) {
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.yoteiTeiin = yoteiTeiin;
    }

    public void setWariateNinzu(RString wariateNinzu) {
        this.setOriginalData("wariateNinzu", wariateNinzu);
        this.wariateNinzu = wariateNinzu;
    }

    public void setStartTime(RString startTime) {
        this.setOriginalData("startTime", startTime);
        this.startTime = startTime;
    }

    public void setEndTime(RString endTime) {
        this.setOriginalData("endTime", endTime);
        this.endTime = endTime;
    }

}