package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 30 16:43:45 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgIryoHokenRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIryoHokenRireki_Row extends DataRow {

    private RString state;
    private TextBoxFlexibleDate kanyuDate;
    private TextBoxFlexibleDate dattaiDate;
    private RString iryoHokenShubetsuKey;
    private RString iryoHokenShubetsu;
    private RString hokenshaNo;
    private RString hokenshaMeisho;
    private RString hokensha;
    private RString kigoNo;

    public dgIryoHokenRireki_Row() {
        super();
        this.state = RString.EMPTY;
        this.kanyuDate = new TextBoxFlexibleDate();
        this.dattaiDate = new TextBoxFlexibleDate();
        this.iryoHokenShubetsuKey = RString.EMPTY;
        this.iryoHokenShubetsu = RString.EMPTY;
        this.hokenshaNo = RString.EMPTY;
        this.hokenshaMeisho = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.kigoNo = RString.EMPTY;
    }

    public dgIryoHokenRireki_Row(RString state, TextBoxFlexibleDate kanyuDate, TextBoxFlexibleDate dattaiDate, RString iryoHokenShubetsuKey, RString iryoHokenShubetsu, RString hokenshaNo, RString hokenshaMeisho, RString hokensha, RString kigoNo) {
        super();
        this.setOriginalData("state", state);
        this.setOriginalData("kanyuDate", kanyuDate);
        this.setOriginalData("dattaiDate", dattaiDate);
        this.setOriginalData("iryoHokenShubetsuKey", iryoHokenShubetsuKey);
        this.setOriginalData("iryoHokenShubetsu", iryoHokenShubetsu);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("kigoNo", kigoNo);
        this.state = state;
        this.kanyuDate = kanyuDate;
        this.dattaiDate = dattaiDate;
        this.iryoHokenShubetsuKey = iryoHokenShubetsuKey;
        this.iryoHokenShubetsu = iryoHokenShubetsu;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaMeisho = hokenshaMeisho;
        this.hokensha = hokensha;
        this.kigoNo = kigoNo;
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

    public RString getIryoHokenShubetsuKey() {
        return iryoHokenShubetsuKey;
    }

    public RString getIryoHokenShubetsu() {
        return iryoHokenShubetsu;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getHokenshaMeisho() {
        return hokenshaMeisho;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getKigoNo() {
        return kigoNo;
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

    public void setIryoHokenShubetsuKey(RString iryoHokenShubetsuKey) {
        this.setOriginalData("iryoHokenShubetsuKey", iryoHokenShubetsuKey);
        this.iryoHokenShubetsuKey = iryoHokenShubetsuKey;
    }

    public void setIryoHokenShubetsu(RString iryoHokenShubetsu) {
        this.setOriginalData("iryoHokenShubetsu", iryoHokenShubetsu);
        this.iryoHokenShubetsu = iryoHokenShubetsu;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setHokenshaMeisho(RString hokenshaMeisho) {
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.hokenshaMeisho = hokenshaMeisho;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setKigoNo(RString kigoNo) {
        this.setOriginalData("kigoNo", kigoNo);
        this.kigoNo = kigoNo;
    }

}