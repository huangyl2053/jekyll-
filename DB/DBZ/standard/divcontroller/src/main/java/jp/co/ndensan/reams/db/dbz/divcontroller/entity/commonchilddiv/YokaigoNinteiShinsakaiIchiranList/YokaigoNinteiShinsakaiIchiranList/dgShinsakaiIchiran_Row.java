package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Dec 21 18:26:37 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShinsakaiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">

    private TextBoxFlexibleDate kaisaiYoteiDate;
    private TextBoxTime yoteiKaishiTime;
    private TextBoxTime yoteiShuryoTime;
    private RString shinsakaiMeisho;
    private RString gogitaiMeisho;
    private RString shurui;
    private RString shinsakaiKaijo;
    private TextBoxFlexibleDate kaisaiDay;
    private TextBoxTime kaisaiTime;
    private TextBoxTime shuryoTime;
    private TextBoxNum yoteiTeiin;
    private TextBoxNum wariateNinzu;
    private TextBoxNum taishoNinzu;
    private RString onseiKiroku;
    private TextBoxFlexibleDate dataShutsuryoku;
    private RString shiryoSakuseiKubun;
    private RString shinchokuJokyo;
    private Boolean dummyFlag;
    private RString gogitaiNo;

    public dgShinsakaiIchiran_Row() {
        super();
        this.kaisaiYoteiDate = new TextBoxFlexibleDate();
        this.yoteiKaishiTime = new TextBoxTime();
        this.yoteiShuryoTime = new TextBoxTime();
        this.shinsakaiMeisho = RString.EMPTY;
        this.gogitaiMeisho = RString.EMPTY;
        this.shurui = RString.EMPTY;
        this.shinsakaiKaijo = RString.EMPTY;
        this.kaisaiDay = new TextBoxFlexibleDate();
        this.kaisaiTime = new TextBoxTime();
        this.shuryoTime = new TextBoxTime();
        this.yoteiTeiin = new TextBoxNum();
        this.wariateNinzu = new TextBoxNum();
        this.taishoNinzu = new TextBoxNum();
        this.onseiKiroku = RString.EMPTY;
        this.dataShutsuryoku = new TextBoxFlexibleDate();
        this.shiryoSakuseiKubun = RString.EMPTY;
        this.shinchokuJokyo = RString.EMPTY;
        this.dummyFlag = false;
        this.gogitaiNo = RString.EMPTY;
        this.setOriginalData("kaisaiYoteiDate", kaisaiYoteiDate);
        this.setOriginalData("yoteiKaishiTime", yoteiKaishiTime);
        this.setOriginalData("yoteiShuryoTime", yoteiShuryoTime);
        this.setOriginalData("shinsakaiMeisho", shinsakaiMeisho);
        this.setOriginalData("gogitaiMeisho", gogitaiMeisho);
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("shinsakaiKaijo", shinsakaiKaijo);
        this.setOriginalData("kaisaiDay", kaisaiDay);
        this.setOriginalData("kaisaiTime", kaisaiTime);
        this.setOriginalData("shuryoTime", shuryoTime);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("wariateNinzu", wariateNinzu);
        this.setOriginalData("taishoNinzu", taishoNinzu);
        this.setOriginalData("onseiKiroku", onseiKiroku);
        this.setOriginalData("dataShutsuryoku", dataShutsuryoku);
        this.setOriginalData("shiryoSakuseiKubun", shiryoSakuseiKubun);
        this.setOriginalData("shinchokuJokyo", shinchokuJokyo);
        this.setOriginalData("dummyFlag", dummyFlag);
        this.setOriginalData("gogitaiNo", gogitaiNo);
    }

    public dgShinsakaiIchiran_Row(TextBoxFlexibleDate kaisaiYoteiDate, TextBoxTime yoteiKaishiTime, TextBoxTime yoteiShuryoTime, RString shinsakaiMeisho, RString gogitaiMeisho, RString shurui, RString shinsakaiKaijo, TextBoxFlexibleDate kaisaiDay, TextBoxTime kaisaiTime, TextBoxTime shuryoTime, TextBoxNum yoteiTeiin, TextBoxNum wariateNinzu, TextBoxNum taishoNinzu, RString onseiKiroku, TextBoxFlexibleDate dataShutsuryoku, RString shiryoSakuseiKubun, RString shinchokuJokyo, Boolean dummyFlag, RString gogitaiNo) {
        super();
        this.setOriginalData("kaisaiYoteiDate", kaisaiYoteiDate);
        this.setOriginalData("yoteiKaishiTime", yoteiKaishiTime);
        this.setOriginalData("yoteiShuryoTime", yoteiShuryoTime);
        this.setOriginalData("shinsakaiMeisho", shinsakaiMeisho);
        this.setOriginalData("gogitaiMeisho", gogitaiMeisho);
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("shinsakaiKaijo", shinsakaiKaijo);
        this.setOriginalData("kaisaiDay", kaisaiDay);
        this.setOriginalData("kaisaiTime", kaisaiTime);
        this.setOriginalData("shuryoTime", shuryoTime);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("wariateNinzu", wariateNinzu);
        this.setOriginalData("taishoNinzu", taishoNinzu);
        this.setOriginalData("onseiKiroku", onseiKiroku);
        this.setOriginalData("dataShutsuryoku", dataShutsuryoku);
        this.setOriginalData("shiryoSakuseiKubun", shiryoSakuseiKubun);
        this.setOriginalData("shinchokuJokyo", shinchokuJokyo);
        this.setOriginalData("dummyFlag", dummyFlag);
        this.setOriginalData("gogitaiNo", gogitaiNo);
        this.kaisaiYoteiDate = kaisaiYoteiDate;
        this.yoteiKaishiTime = yoteiKaishiTime;
        this.yoteiShuryoTime = yoteiShuryoTime;
        this.shinsakaiMeisho = shinsakaiMeisho;
        this.gogitaiMeisho = gogitaiMeisho;
        this.shurui = shurui;
        this.shinsakaiKaijo = shinsakaiKaijo;
        this.kaisaiDay = kaisaiDay;
        this.kaisaiTime = kaisaiTime;
        this.shuryoTime = shuryoTime;
        this.yoteiTeiin = yoteiTeiin;
        this.wariateNinzu = wariateNinzu;
        this.taishoNinzu = taishoNinzu;
        this.onseiKiroku = onseiKiroku;
        this.dataShutsuryoku = dataShutsuryoku;
        this.shiryoSakuseiKubun = shiryoSakuseiKubun;
        this.shinchokuJokyo = shinchokuJokyo;
        this.dummyFlag = dummyFlag;
        this.gogitaiNo = gogitaiNo;
    }

    public TextBoxFlexibleDate getKaisaiYoteiDate() {
        return kaisaiYoteiDate;
    }

    public TextBoxTime getYoteiKaishiTime() {
        return yoteiKaishiTime;
    }

    public TextBoxTime getYoteiShuryoTime() {
        return yoteiShuryoTime;
    }

    public RString getShinsakaiMeisho() {
        return shinsakaiMeisho;
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

    public TextBoxFlexibleDate getKaisaiDay() {
        return kaisaiDay;
    }

    public TextBoxTime getKaisaiTime() {
        return kaisaiTime;
    }

    public TextBoxTime getShuryoTime() {
        return shuryoTime;
    }

    public TextBoxNum getYoteiTeiin() {
        return yoteiTeiin;
    }

    public TextBoxNum getWariateNinzu() {
        return wariateNinzu;
    }

    public TextBoxNum getTaishoNinzu() {
        return taishoNinzu;
    }

    public RString getOnseiKiroku() {
        return onseiKiroku;
    }

    public TextBoxFlexibleDate getDataShutsuryoku() {
        return dataShutsuryoku;
    }

    public RString getShiryoSakuseiKubun() {
        return shiryoSakuseiKubun;
    }

    public RString getShinchokuJokyo() {
        return shinchokuJokyo;
    }

    public Boolean getDummyFlag() {
        return dummyFlag;
    }

    public RString getGogitaiNo() {
        return gogitaiNo;
    }

    public void setKaisaiYoteiDate(TextBoxFlexibleDate kaisaiYoteiDate) {
        this.setOriginalData("kaisaiYoteiDate", kaisaiYoteiDate);
        this.kaisaiYoteiDate = kaisaiYoteiDate;
    }

    public void setYoteiKaishiTime(TextBoxTime yoteiKaishiTime) {
        this.setOriginalData("yoteiKaishiTime", yoteiKaishiTime);
        this.yoteiKaishiTime = yoteiKaishiTime;
    }

    public void setYoteiShuryoTime(TextBoxTime yoteiShuryoTime) {
        this.setOriginalData("yoteiShuryoTime", yoteiShuryoTime);
        this.yoteiShuryoTime = yoteiShuryoTime;
    }

    public void setShinsakaiMeisho(RString shinsakaiMeisho) {
        this.setOriginalData("shinsakaiMeisho", shinsakaiMeisho);
        this.shinsakaiMeisho = shinsakaiMeisho;
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

    public void setKaisaiDay(TextBoxFlexibleDate kaisaiDay) {
        this.setOriginalData("kaisaiDay", kaisaiDay);
        this.kaisaiDay = kaisaiDay;
    }

    public void setKaisaiTime(TextBoxTime kaisaiTime) {
        this.setOriginalData("kaisaiTime", kaisaiTime);
        this.kaisaiTime = kaisaiTime;
    }

    public void setShuryoTime(TextBoxTime shuryoTime) {
        this.setOriginalData("shuryoTime", shuryoTime);
        this.shuryoTime = shuryoTime;
    }

    public void setYoteiTeiin(TextBoxNum yoteiTeiin) {
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.yoteiTeiin = yoteiTeiin;
    }

    public void setWariateNinzu(TextBoxNum wariateNinzu) {
        this.setOriginalData("wariateNinzu", wariateNinzu);
        this.wariateNinzu = wariateNinzu;
    }

    public void setTaishoNinzu(TextBoxNum taishoNinzu) {
        this.setOriginalData("taishoNinzu", taishoNinzu);
        this.taishoNinzu = taishoNinzu;
    }

    public void setOnseiKiroku(RString onseiKiroku) {
        this.setOriginalData("onseiKiroku", onseiKiroku);
        this.onseiKiroku = onseiKiroku;
    }

    public void setDataShutsuryoku(TextBoxFlexibleDate dataShutsuryoku) {
        this.setOriginalData("dataShutsuryoku", dataShutsuryoku);
        this.dataShutsuryoku = dataShutsuryoku;
    }

    public void setShiryoSakuseiKubun(RString shiryoSakuseiKubun) {
        this.setOriginalData("shiryoSakuseiKubun", shiryoSakuseiKubun);
        this.shiryoSakuseiKubun = shiryoSakuseiKubun;
    }

    public void setShinchokuJokyo(RString shinchokuJokyo) {
        this.setOriginalData("shinchokuJokyo", shinchokuJokyo);
        this.shinchokuJokyo = shinchokuJokyo;
    }

    public void setDummyFlag(Boolean dummyFlag) {
        this.setOriginalData("dummyFlag", dummyFlag);
        this.dummyFlag = dummyFlag;
    }

    public void setGogitaiNo(RString gogitaiNo) {
        this.setOriginalData("gogitaiNo", gogitaiNo);
        this.gogitaiNo = gogitaiNo;
    }

    // </editor-fold>
}
