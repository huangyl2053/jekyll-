package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Dec 20 19:21:19 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumnCheckBox;


/**
 * dgShinsakaiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-13_17-59-33">

    private Button btnWritsuke;
    private TextBoxFlexibleDate kaisaiYoteiYmd;
    private TextBoxTime kaisaiYoteiTime;
    private RString shinsakaiKaisaiNo;
    private RString shinsakaiMeisho;
    private RString gogitaiNo;
    private RString gogitaiMeisho;
    private RString shurui;
    private RString shinsakaiKaijo;
    private TextBoxNum yoteiTeiin;
    private TextBoxNum wariateZumiNinzu;
    private DataGridColumnCheckBox dummyFlag;
    private TextBoxNum maxShinsakaiOrder;

    public dgShinsakaiList_Row() {
        super();
        this.btnWritsuke = new Button();
        this.kaisaiYoteiYmd = new TextBoxFlexibleDate();
        this.kaisaiYoteiTime = new TextBoxTime();
        this.shinsakaiKaisaiNo = RString.EMPTY;
        this.shinsakaiMeisho = RString.EMPTY;
        this.gogitaiNo = RString.EMPTY;
        this.gogitaiMeisho = RString.EMPTY;
        this.shurui = RString.EMPTY;
        this.shinsakaiKaijo = RString.EMPTY;
        this.yoteiTeiin = new TextBoxNum();
        this.wariateZumiNinzu = new TextBoxNum();
        this.dummyFlag = new DataGridColumnCheckBox();
        this.maxShinsakaiOrder = new TextBoxNum();
        this.setOriginalData("btnWritsuke", btnWritsuke);
        this.setOriginalData("kaisaiYoteiYmd", kaisaiYoteiYmd);
        this.setOriginalData("kaisaiYoteiTime", kaisaiYoteiTime);
        this.setOriginalData("shinsakaiKaisaiNo", shinsakaiKaisaiNo);
        this.setOriginalData("shinsakaiMeisho", shinsakaiMeisho);
        this.setOriginalData("gogitaiNo", gogitaiNo);
        this.setOriginalData("gogitaiMeisho", gogitaiMeisho);
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("shinsakaiKaijo", shinsakaiKaijo);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("wariateZumiNinzu", wariateZumiNinzu);
        this.setOriginalData("dummyFlag", dummyFlag);
        this.setOriginalData("maxShinsakaiOrder", maxShinsakaiOrder);
    }

    public dgShinsakaiList_Row(Button btnWritsuke, TextBoxFlexibleDate kaisaiYoteiYmd, TextBoxTime kaisaiYoteiTime, RString shinsakaiKaisaiNo, RString shinsakaiMeisho, RString gogitaiNo, RString gogitaiMeisho, RString shurui, RString shinsakaiKaijo, TextBoxNum yoteiTeiin, TextBoxNum wariateZumiNinzu, DataGridColumnCheckBox dummyFlag, TextBoxNum maxShinsakaiOrder) {
        super();
        this.setOriginalData("btnWritsuke", btnWritsuke);
        this.setOriginalData("kaisaiYoteiYmd", kaisaiYoteiYmd);
        this.setOriginalData("kaisaiYoteiTime", kaisaiYoteiTime);
        this.setOriginalData("shinsakaiKaisaiNo", shinsakaiKaisaiNo);
        this.setOriginalData("shinsakaiMeisho", shinsakaiMeisho);
        this.setOriginalData("gogitaiNo", gogitaiNo);
        this.setOriginalData("gogitaiMeisho", gogitaiMeisho);
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("shinsakaiKaijo", shinsakaiKaijo);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("wariateZumiNinzu", wariateZumiNinzu);
        this.setOriginalData("dummyFlag", dummyFlag);
        this.setOriginalData("maxShinsakaiOrder", maxShinsakaiOrder);
        this.btnWritsuke = btnWritsuke;
        this.kaisaiYoteiYmd = kaisaiYoteiYmd;
        this.kaisaiYoteiTime = kaisaiYoteiTime;
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shinsakaiMeisho = shinsakaiMeisho;
        this.gogitaiNo = gogitaiNo;
        this.gogitaiMeisho = gogitaiMeisho;
        this.shurui = shurui;
        this.shinsakaiKaijo = shinsakaiKaijo;
        this.yoteiTeiin = yoteiTeiin;
        this.wariateZumiNinzu = wariateZumiNinzu;
        this.dummyFlag = dummyFlag;
        this.maxShinsakaiOrder = maxShinsakaiOrder;
    }

    public dgShinsakaiList_Row(DataGridSetting gridSetting) {
        super();
        this.btnWritsuke = new Button();
        this.kaisaiYoteiYmd = new TextBoxFlexibleDate();
        this.kaisaiYoteiTime = new TextBoxTime();
        this.shinsakaiKaisaiNo = RString.EMPTY;
        this.shinsakaiMeisho = RString.EMPTY;
        this.gogitaiNo = RString.EMPTY;
        this.gogitaiMeisho = RString.EMPTY;
        this.shurui = RString.EMPTY;
        this.shinsakaiKaijo = RString.EMPTY;
        this.yoteiTeiin = new TextBoxNum();
        this.wariateZumiNinzu = new TextBoxNum();
        this.dummyFlag = DataGridColumnCheckBox.createInstance(gridSetting.getColumn("dummyFlag").getCellDetails());
        this.maxShinsakaiOrder = new TextBoxNum();
        this.setOriginalData("btnWritsuke", btnWritsuke);
        this.setOriginalData("kaisaiYoteiYmd", kaisaiYoteiYmd);
        this.setOriginalData("kaisaiYoteiTime", kaisaiYoteiTime);
        this.setOriginalData("shinsakaiKaisaiNo", shinsakaiKaisaiNo);
        this.setOriginalData("shinsakaiMeisho", shinsakaiMeisho);
        this.setOriginalData("gogitaiNo", gogitaiNo);
        this.setOriginalData("gogitaiMeisho", gogitaiMeisho);
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("shinsakaiKaijo", shinsakaiKaijo);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("wariateZumiNinzu", wariateZumiNinzu);
        this.setOriginalData("dummyFlag", dummyFlag);
        this.setOriginalData("maxShinsakaiOrder", maxShinsakaiOrder);
    }

    public Button getBtnWritsuke() {
        return btnWritsuke;
    }

    public TextBoxFlexibleDate getKaisaiYoteiYmd() {
        return kaisaiYoteiYmd;
    }

    public TextBoxTime getKaisaiYoteiTime() {
        return kaisaiYoteiTime;
    }

    public RString getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    public RString getShinsakaiMeisho() {
        return shinsakaiMeisho;
    }

    public RString getGogitaiNo() {
        return gogitaiNo;
    }

    public RString getGogitaiMeisho() {
        return gogitaiMeisho;
    }

    public RString getShurui() {
        return shurui;
    }

    public RString getShinsakaiKaijo() {
        return shinsakaiKaijo;
    }

    public TextBoxNum getYoteiTeiin() {
        return yoteiTeiin;
    }

    public TextBoxNum getWariateZumiNinzu() {
        return wariateZumiNinzu;
    }

    public DataGridColumnCheckBox getDummyFlag() {
        return dummyFlag;
    }

    public TextBoxNum getMaxShinsakaiOrder() {
        return maxShinsakaiOrder;
    }

    public void setBtnWritsuke(Button btnWritsuke) {
        this.setOriginalData("btnWritsuke", btnWritsuke);
        this.btnWritsuke = btnWritsuke;
    }

    public void setKaisaiYoteiYmd(TextBoxFlexibleDate kaisaiYoteiYmd) {
        this.setOriginalData("kaisaiYoteiYmd", kaisaiYoteiYmd);
        this.kaisaiYoteiYmd = kaisaiYoteiYmd;
    }

    public void setKaisaiYoteiTime(TextBoxTime kaisaiYoteiTime) {
        this.setOriginalData("kaisaiYoteiTime", kaisaiYoteiTime);
        this.kaisaiYoteiTime = kaisaiYoteiTime;
    }

    public void setShinsakaiKaisaiNo(RString shinsakaiKaisaiNo) {
        this.setOriginalData("shinsakaiKaisaiNo", shinsakaiKaisaiNo);
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    public void setShinsakaiMeisho(RString shinsakaiMeisho) {
        this.setOriginalData("shinsakaiMeisho", shinsakaiMeisho);
        this.shinsakaiMeisho = shinsakaiMeisho;
    }

    public void setGogitaiNo(RString gogitaiNo) {
        this.setOriginalData("gogitaiNo", gogitaiNo);
        this.gogitaiNo = gogitaiNo;
    }

    public void setGogitaiMeisho(RString gogitaiMeisho) {
        this.setOriginalData("gogitaiMeisho", gogitaiMeisho);
        this.gogitaiMeisho = gogitaiMeisho;
    }

    public void setShurui(RString shurui) {
        this.setOriginalData("shurui", shurui);
        this.shurui = shurui;
    }

    public void setShinsakaiKaijo(RString shinsakaiKaijo) {
        this.setOriginalData("shinsakaiKaijo", shinsakaiKaijo);
        this.shinsakaiKaijo = shinsakaiKaijo;
    }

    public void setYoteiTeiin(TextBoxNum yoteiTeiin) {
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.yoteiTeiin = yoteiTeiin;
    }

    public void setWariateZumiNinzu(TextBoxNum wariateZumiNinzu) {
        this.setOriginalData("wariateZumiNinzu", wariateZumiNinzu);
        this.wariateZumiNinzu = wariateZumiNinzu;
    }

    public void setDummyFlag(DataGridColumnCheckBox dummyFlag) {
        this.setOriginalData("dummyFlag", dummyFlag);
        this.dummyFlag = dummyFlag;
    }

    public void setMaxShinsakaiOrder(TextBoxNum maxShinsakaiOrder) {
        this.setOriginalData("maxShinsakaiOrder", maxShinsakaiOrder);
        this.maxShinsakaiOrder = maxShinsakaiOrder;
    }

    // </editor-fold>
}
