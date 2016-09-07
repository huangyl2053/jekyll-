package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 02 10:49:13 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShinsakaiIinBetuTanka_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinBetuTanka_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString columnState;
    private TextBoxFlexibleDate kaishiYM;
    private TextBoxFlexibleDate shuryoYM;
    private RString shinsakaiIinCode;
    private TextBoxNum tanka;
    private TextBoxNum sonotaTanka;

    public dgShinsakaiIinBetuTanka_Row() {
        super();
        this.columnState = RString.EMPTY;
        this.kaishiYM = new TextBoxFlexibleDate();
        this.shuryoYM = new TextBoxFlexibleDate();
        this.shinsakaiIinCode = RString.EMPTY;
        this.tanka = new TextBoxNum();
        this.sonotaTanka = new TextBoxNum();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("tanka", tanka);
        this.setOriginalData("sonotaTanka", sonotaTanka);
    }

    public dgShinsakaiIinBetuTanka_Row(RString columnState, TextBoxFlexibleDate kaishiYM, TextBoxFlexibleDate shuryoYM, RString shinsakaiIinCode, TextBoxNum tanka, TextBoxNum sonotaTanka) {
        super();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("tanka", tanka);
        this.setOriginalData("sonotaTanka", sonotaTanka);
        this.columnState = columnState;
        this.kaishiYM = kaishiYM;
        this.shuryoYM = shuryoYM;
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.tanka = tanka;
        this.sonotaTanka = sonotaTanka;
    }

    public RString getColumnState() {
        return columnState;
    }

    public TextBoxFlexibleDate getKaishiYM() {
        return kaishiYM;
    }

    public TextBoxFlexibleDate getShuryoYM() {
        return shuryoYM;
    }

    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    public TextBoxNum getTanka() {
        return tanka;
    }

    public TextBoxNum getSonotaTanka() {
        return sonotaTanka;
    }

    public void setColumnState(RString columnState) {
        this.setOriginalData("columnState", columnState);
        this.columnState = columnState;
    }

    public void setKaishiYM(TextBoxFlexibleDate kaishiYM) {
        this.setOriginalData("kaishiYM", kaishiYM);
        this.kaishiYM = kaishiYM;
    }

    public void setShuryoYM(TextBoxFlexibleDate shuryoYM) {
        this.setOriginalData("shuryoYM", shuryoYM);
        this.shuryoYM = shuryoYM;
    }

    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    public void setTanka(TextBoxNum tanka) {
        this.setOriginalData("tanka", tanka);
        this.tanka = tanka;
    }

    public void setSonotaTanka(TextBoxNum sonotaTanka) {
        this.setOriginalData("sonotaTanka", sonotaTanka);
        this.sonotaTanka = sonotaTanka;
    }

    // </editor-fold>
}
