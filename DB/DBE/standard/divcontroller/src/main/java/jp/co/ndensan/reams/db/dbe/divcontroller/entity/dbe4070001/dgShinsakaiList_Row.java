package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 01 11:52:34 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiList_Row extends DataRow {

    private Button btnToSelect;
    private TextBoxFlexibleDate kaisaiYoteiDate;
    private RString kaisaiNo;
    private RString gogitaiNo;
    private RString gogitaiName;
    private RString yoteiTeiin;
    private RString wariateNinzu;
    private RString shinsakaiKaijo;
    private RString kaishiYoteiTime;
    private RString endYoteiTime;
    private RString shiryoSakuseiKubun;

    public dgShinsakaiList_Row() {
        super();
        this.btnToSelect = new Button();
        this.kaisaiYoteiDate = new TextBoxFlexibleDate();
        this.kaisaiNo = RString.EMPTY;
        this.gogitaiNo = RString.EMPTY;
        this.gogitaiName = RString.EMPTY;
        this.yoteiTeiin = RString.EMPTY;
        this.wariateNinzu = RString.EMPTY;
        this.shinsakaiKaijo = RString.EMPTY;
        this.kaishiYoteiTime = RString.EMPTY;
        this.endYoteiTime = RString.EMPTY;
        this.shiryoSakuseiKubun = RString.EMPTY;
    }

    public dgShinsakaiList_Row(Button btnToSelect, TextBoxFlexibleDate kaisaiYoteiDate, RString kaisaiNo, RString gogitaiNo, RString gogitaiName, RString yoteiTeiin, RString wariateNinzu, RString shinsakaiKaijo, RString kaishiYoteiTime, RString endYoteiTime, RString shiryoSakuseiKubun) {
        super();
        this.setOriginalData("btnToSelect", btnToSelect);
        this.setOriginalData("kaisaiYoteiDate", kaisaiYoteiDate);
        this.setOriginalData("kaisaiNo", kaisaiNo);
        this.setOriginalData("gogitaiNo", gogitaiNo);
        this.setOriginalData("gogitaiName", gogitaiName);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("wariateNinzu", wariateNinzu);
        this.setOriginalData("shinsakaiKaijo", shinsakaiKaijo);
        this.setOriginalData("kaishiYoteiTime", kaishiYoteiTime);
        this.setOriginalData("endYoteiTime", endYoteiTime);
        this.setOriginalData("shiryoSakuseiKubun", shiryoSakuseiKubun);
        this.btnToSelect = btnToSelect;
        this.kaisaiYoteiDate = kaisaiYoteiDate;
        this.kaisaiNo = kaisaiNo;
        this.gogitaiNo = gogitaiNo;
        this.gogitaiName = gogitaiName;
        this.yoteiTeiin = yoteiTeiin;
        this.wariateNinzu = wariateNinzu;
        this.shinsakaiKaijo = shinsakaiKaijo;
        this.kaishiYoteiTime = kaishiYoteiTime;
        this.endYoteiTime = endYoteiTime;
        this.shiryoSakuseiKubun = shiryoSakuseiKubun;
    }

    public Button getBtnToSelect() {
        return btnToSelect;
    }

    public TextBoxFlexibleDate getKaisaiYoteiDate() {
        return kaisaiYoteiDate;
    }

    public RString getKaisaiNo() {
        return kaisaiNo;
    }

    public RString getGogitaiNo() {
        return gogitaiNo;
    }

    public RString getGogitaiName() {
        return gogitaiName;
    }

    public RString getYoteiTeiin() {
        return yoteiTeiin;
    }

    public RString getWariateNinzu() {
        return wariateNinzu;
    }

    public RString getShinsakaiKaijo() {
        return shinsakaiKaijo;
    }

    public RString getKaishiYoteiTime() {
        return kaishiYoteiTime;
    }

    public RString getEndYoteiTime() {
        return endYoteiTime;
    }

    public RString getShiryoSakuseiKubun() {
        return shiryoSakuseiKubun;
    }

    public void setBtnToSelect(Button btnToSelect) {
        this.setOriginalData("btnToSelect", btnToSelect);
        this.btnToSelect = btnToSelect;
    }

    public void setKaisaiYoteiDate(TextBoxFlexibleDate kaisaiYoteiDate) {
        this.setOriginalData("kaisaiYoteiDate", kaisaiYoteiDate);
        this.kaisaiYoteiDate = kaisaiYoteiDate;
    }

    public void setKaisaiNo(RString kaisaiNo) {
        this.setOriginalData("kaisaiNo", kaisaiNo);
        this.kaisaiNo = kaisaiNo;
    }

    public void setGogitaiNo(RString gogitaiNo) {
        this.setOriginalData("gogitaiNo", gogitaiNo);
        this.gogitaiNo = gogitaiNo;
    }

    public void setGogitaiName(RString gogitaiName) {
        this.setOriginalData("gogitaiName", gogitaiName);
        this.gogitaiName = gogitaiName;
    }

    public void setYoteiTeiin(RString yoteiTeiin) {
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.yoteiTeiin = yoteiTeiin;
    }

    public void setWariateNinzu(RString wariateNinzu) {
        this.setOriginalData("wariateNinzu", wariateNinzu);
        this.wariateNinzu = wariateNinzu;
    }

    public void setShinsakaiKaijo(RString shinsakaiKaijo) {
        this.setOriginalData("shinsakaiKaijo", shinsakaiKaijo);
        this.shinsakaiKaijo = shinsakaiKaijo;
    }

    public void setKaishiYoteiTime(RString kaishiYoteiTime) {
        this.setOriginalData("kaishiYoteiTime", kaishiYoteiTime);
        this.kaishiYoteiTime = kaishiYoteiTime;
    }

    public void setEndYoteiTime(RString endYoteiTime) {
        this.setOriginalData("endYoteiTime", endYoteiTime);
        this.endYoteiTime = endYoteiTime;
    }

    public void setShiryoSakuseiKubun(RString shiryoSakuseiKubun) {
        this.setOriginalData("shiryoSakuseiKubun", shiryoSakuseiKubun);
        this.shiryoSakuseiKubun = shiryoSakuseiKubun;
    }

}