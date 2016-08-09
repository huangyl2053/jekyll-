package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 09 09:44:03 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgIryohokenIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIryohokenIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString shikibetsuCode;
    private RString shichosonCode;
    private RString state;
    private TextBoxFlexibleDate kanyuDate;
    private TextBoxFlexibleDate dattaiDate;
    private RString shubetsu;
    private RString shubetsuCode;
    private RString hokensha;
    private RString hokenshaCode;
    private RString hokenshaName;
    private RString kigoNo;
    private TextBoxNum rirekiNo;

    public dgIryohokenIchiran_Row() {
        super();
        this.shikibetsuCode = RString.EMPTY;
        this.shichosonCode = RString.EMPTY;
        this.state = RString.EMPTY;
        this.kanyuDate = new TextBoxFlexibleDate();
        this.dattaiDate = new TextBoxFlexibleDate();
        this.shubetsu = RString.EMPTY;
        this.shubetsuCode = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.hokenshaCode = RString.EMPTY;
        this.hokenshaName = RString.EMPTY;
        this.kigoNo = RString.EMPTY;
        this.rirekiNo = new TextBoxNum();
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("state", state);
        this.setOriginalData("kanyuDate", kanyuDate);
        this.setOriginalData("dattaiDate", dattaiDate);
        this.setOriginalData("shubetsu", shubetsu);
        this.setOriginalData("shubetsuCode", shubetsuCode);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("kigoNo", kigoNo);
        this.setOriginalData("rirekiNo", rirekiNo);
    }

    public dgIryohokenIchiran_Row(RString shikibetsuCode, RString shichosonCode, RString state, TextBoxFlexibleDate kanyuDate, TextBoxFlexibleDate dattaiDate, RString shubetsu, RString shubetsuCode, RString hokensha, RString hokenshaCode, RString hokenshaName, RString kigoNo, TextBoxNum rirekiNo) {
        super();
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("state", state);
        this.setOriginalData("kanyuDate", kanyuDate);
        this.setOriginalData("dattaiDate", dattaiDate);
        this.setOriginalData("shubetsu", shubetsu);
        this.setOriginalData("shubetsuCode", shubetsuCode);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("kigoNo", kigoNo);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.shikibetsuCode = shikibetsuCode;
        this.shichosonCode = shichosonCode;
        this.state = state;
        this.kanyuDate = kanyuDate;
        this.dattaiDate = dattaiDate;
        this.shubetsu = shubetsu;
        this.shubetsuCode = shubetsuCode;
        this.hokensha = hokensha;
        this.hokenshaCode = hokenshaCode;
        this.hokenshaName = hokenshaName;
        this.kigoNo = kigoNo;
        this.rirekiNo = rirekiNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public RString getState() {
        return state;
    }

    public TextBoxFlexibleDate getKanyuDate() {
        return kanyuDate;
    }

    public TextBoxFlexibleDate getDattaiDate() {
        return dattaiDate;
    }

    public RString getShubetsu() {
        return shubetsu;
    }

    public RString getShubetsuCode() {
        return shubetsuCode;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getHokenshaCode() {
        return hokenshaCode;
    }

    public RString getHokenshaName() {
        return hokenshaName;
    }

    public RString getKigoNo() {
        return kigoNo;
    }

    public TextBoxNum getRirekiNo() {
        return rirekiNo;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setState(RString state) {
        this.setOriginalData("state", state);
        this.state = state;
    }

    public void setKanyuDate(TextBoxFlexibleDate kanyuDate) {
        this.setOriginalData("kanyuDate", kanyuDate);
        this.kanyuDate = kanyuDate;
    }

    public void setDattaiDate(TextBoxFlexibleDate dattaiDate) {
        this.setOriginalData("dattaiDate", dattaiDate);
        this.dattaiDate = dattaiDate;
    }

    public void setShubetsu(RString shubetsu) {
        this.setOriginalData("shubetsu", shubetsu);
        this.shubetsu = shubetsu;
    }

    public void setShubetsuCode(RString shubetsuCode) {
        this.setOriginalData("shubetsuCode", shubetsuCode);
        this.shubetsuCode = shubetsuCode;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setHokenshaCode(RString hokenshaCode) {
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.hokenshaCode = hokenshaCode;
    }

    public void setHokenshaName(RString hokenshaName) {
        this.setOriginalData("hokenshaName", hokenshaName);
        this.hokenshaName = hokenshaName;
    }

    public void setKigoNo(RString kigoNo) {
        this.setOriginalData("kigoNo", kigoNo);
        this.kigoNo = kigoNo;
    }

    public void setRirekiNo(TextBoxNum rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    // </editor-fold>
}
