package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Dec 17 15:00:47 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgShinsaInJohoIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsaInJohoIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">

    private RString status;
    private RString shinsainCode;
    private TextBoxDate shinsakaiIinKaishiYMD;
    private TextBoxDate shinsakaiIinShuryoYMD;
    private RString shimei;
    private RString kanaShimei;
    private RString seibetsu;
    private TextBoxDate barthYMD;
    private RString shikakuCode;
    private RString jokyo;
    private RString biko;
    private RString shinsakaiChikuCode;
    private RString yubinNo;
    private RString yusoKubun;
    private RString jusho;
    private TextBoxDate haishiYMD;
    private RString telNo1;
    private RString faxNo;

    public dgShinsaInJohoIchiran_Row() {
        super();
        this.status = RString.EMPTY;
        this.shinsainCode = RString.EMPTY;
        this.shinsakaiIinKaishiYMD = new TextBoxDate();
        this.shinsakaiIinShuryoYMD = new TextBoxDate();
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.barthYMD = new TextBoxDate();
        this.shikakuCode = RString.EMPTY;
        this.jokyo = RString.EMPTY;
        this.biko = RString.EMPTY;
        this.shinsakaiChikuCode = RString.EMPTY;
        this.yubinNo = RString.EMPTY;
        this.yusoKubun = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.haishiYMD = new TextBoxDate();
        this.telNo1 = RString.EMPTY;
        this.faxNo = RString.EMPTY;
        this.setOriginalData("status", status);
        this.setOriginalData("shinsainCode", shinsainCode);
        this.setOriginalData("shinsakaiIinKaishiYMD", shinsakaiIinKaishiYMD);
        this.setOriginalData("shinsakaiIinShuryoYMD", shinsakaiIinShuryoYMD);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("barthYMD", barthYMD);
        this.setOriginalData("shikakuCode", shikakuCode);
        this.setOriginalData("jokyo", jokyo);
        this.setOriginalData("biko", biko);
        this.setOriginalData("shinsakaiChikuCode", shinsakaiChikuCode);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("yusoKubun", yusoKubun);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("haishiYMD", haishiYMD);
        this.setOriginalData("telNo1", telNo1);
        this.setOriginalData("faxNo", faxNo);
    }

    public dgShinsaInJohoIchiran_Row(RString status, RString shinsainCode, TextBoxDate shinsakaiIinKaishiYMD, TextBoxDate shinsakaiIinShuryoYMD, RString shimei, RString kanaShimei, RString seibetsu, TextBoxDate barthYMD, RString shikakuCode, RString jokyo, RString biko, RString shinsakaiChikuCode, RString yubinNo, RString yusoKubun, RString jusho, TextBoxDate haishiYMD, RString telNo1, RString faxNo) {
        super();
        this.setOriginalData("status", status);
        this.setOriginalData("shinsainCode", shinsainCode);
        this.setOriginalData("shinsakaiIinKaishiYMD", shinsakaiIinKaishiYMD);
        this.setOriginalData("shinsakaiIinShuryoYMD", shinsakaiIinShuryoYMD);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("barthYMD", barthYMD);
        this.setOriginalData("shikakuCode", shikakuCode);
        this.setOriginalData("jokyo", jokyo);
        this.setOriginalData("biko", biko);
        this.setOriginalData("shinsakaiChikuCode", shinsakaiChikuCode);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("yusoKubun", yusoKubun);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("haishiYMD", haishiYMD);
        this.setOriginalData("telNo1", telNo1);
        this.setOriginalData("faxNo", faxNo);
        this.status = status;
        this.shinsainCode = shinsainCode;
        this.shinsakaiIinKaishiYMD = shinsakaiIinKaishiYMD;
        this.shinsakaiIinShuryoYMD = shinsakaiIinShuryoYMD;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.seibetsu = seibetsu;
        this.barthYMD = barthYMD;
        this.shikakuCode = shikakuCode;
        this.jokyo = jokyo;
        this.biko = biko;
        this.shinsakaiChikuCode = shinsakaiChikuCode;
        this.yubinNo = yubinNo;
        this.yusoKubun = yusoKubun;
        this.jusho = jusho;
        this.haishiYMD = haishiYMD;
        this.telNo1 = telNo1;
        this.faxNo = faxNo;
    }

    public RString getStatus() {
        return status;
    }

    public RString getShinsainCode() {
        return shinsainCode;
    }

    public TextBoxDate getShinsakaiIinKaishiYMD() {
        return shinsakaiIinKaishiYMD;
    }

    public TextBoxDate getShinsakaiIinShuryoYMD() {
        return shinsakaiIinShuryoYMD;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimei() {
        return kanaShimei;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public TextBoxDate getBarthYMD() {
        return barthYMD;
    }

    public RString getShikakuCode() {
        return shikakuCode;
    }

    public RString getJokyo() {
        return jokyo;
    }

    public RString getBiko() {
        return biko;
    }

    public RString getShinsakaiChikuCode() {
        return shinsakaiChikuCode;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getYusoKubun() {
        return yusoKubun;
    }

    public RString getJusho() {
        return jusho;
    }

    public TextBoxDate getHaishiYMD() {
        return haishiYMD;
    }

    public RString getTelNo1() {
        return telNo1;
    }

    public RString getFaxNo() {
        return faxNo;
    }

    public void setStatus(RString status) {
        this.setOriginalData("status", status);
        this.status = status;
    }

    public void setShinsainCode(RString shinsainCode) {
        this.setOriginalData("shinsainCode", shinsainCode);
        this.shinsainCode = shinsainCode;
    }

    public void setShinsakaiIinKaishiYMD(TextBoxDate shinsakaiIinKaishiYMD) {
        this.setOriginalData("shinsakaiIinKaishiYMD", shinsakaiIinKaishiYMD);
        this.shinsakaiIinKaishiYMD = shinsakaiIinKaishiYMD;
    }

    public void setShinsakaiIinShuryoYMD(TextBoxDate shinsakaiIinShuryoYMD) {
        this.setOriginalData("shinsakaiIinShuryoYMD", shinsakaiIinShuryoYMD);
        this.shinsakaiIinShuryoYMD = shinsakaiIinShuryoYMD;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimei(RString kanaShimei) {
        this.setOriginalData("kanaShimei", kanaShimei);
        this.kanaShimei = kanaShimei;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setBarthYMD(TextBoxDate barthYMD) {
        this.setOriginalData("barthYMD", barthYMD);
        this.barthYMD = barthYMD;
    }

    public void setShikakuCode(RString shikakuCode) {
        this.setOriginalData("shikakuCode", shikakuCode);
        this.shikakuCode = shikakuCode;
    }

    public void setJokyo(RString jokyo) {
        this.setOriginalData("jokyo", jokyo);
        this.jokyo = jokyo;
    }

    public void setBiko(RString biko) {
        this.setOriginalData("biko", biko);
        this.biko = biko;
    }

    public void setShinsakaiChikuCode(RString shinsakaiChikuCode) {
        this.setOriginalData("shinsakaiChikuCode", shinsakaiChikuCode);
        this.shinsakaiChikuCode = shinsakaiChikuCode;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
    }

    public void setYusoKubun(RString yusoKubun) {
        this.setOriginalData("yusoKubun", yusoKubun);
        this.yusoKubun = yusoKubun;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setHaishiYMD(TextBoxDate haishiYMD) {
        this.setOriginalData("haishiYMD", haishiYMD);
        this.haishiYMD = haishiYMD;
    }

    public void setTelNo1(RString telNo1) {
        this.setOriginalData("telNo1", telNo1);
        this.telNo1 = telNo1;
    }

    public void setFaxNo(RString faxNo) {
        this.setOriginalData("faxNo", faxNo);
        this.faxNo = faxNo;
    }

    // </editor-fold>
}
