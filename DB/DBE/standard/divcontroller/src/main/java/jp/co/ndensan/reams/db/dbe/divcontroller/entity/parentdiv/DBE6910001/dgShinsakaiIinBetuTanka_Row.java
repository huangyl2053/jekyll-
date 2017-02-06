package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Feb 06 17:28:45 JST 2017 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">

    private RString columnState;
    private RString shinsakaiIinCode;
    private RString shinsakaiIinName;
    private TextBoxFlexibleDate kaishiYM;
    private TextBoxFlexibleDate shuryoYM;
    private TextBoxFlexibleDate shuryoYMbak;
    private TextBoxNum tanka;
    private TextBoxNum sonotaTanka;

    public dgShinsakaiIinBetuTanka_Row() {
        super();
        this.columnState = RString.EMPTY;
        this.shinsakaiIinCode = RString.EMPTY;
        this.shinsakaiIinName = RString.EMPTY;
        this.kaishiYM = new TextBoxFlexibleDate();
        this.shuryoYM = new TextBoxFlexibleDate();
        this.shuryoYMbak = new TextBoxFlexibleDate();
        this.tanka = new TextBoxNum();
        this.sonotaTanka = new TextBoxNum();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shinsakaiIinName", shinsakaiIinName);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("shuryoYMbak", shuryoYMbak);
        this.setOriginalData("tanka", tanka);
        this.setOriginalData("sonotaTanka", sonotaTanka);
    }

    public dgShinsakaiIinBetuTanka_Row(RString columnState, RString shinsakaiIinCode, RString shinsakaiIinName, TextBoxFlexibleDate kaishiYM, TextBoxFlexibleDate shuryoYM, TextBoxFlexibleDate shuryoYMbak, TextBoxNum tanka, TextBoxNum sonotaTanka) {
        super();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shinsakaiIinName", shinsakaiIinName);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("shuryoYMbak", shuryoYMbak);
        this.setOriginalData("tanka", tanka);
        this.setOriginalData("sonotaTanka", sonotaTanka);
        this.columnState = columnState;
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.shinsakaiIinName = shinsakaiIinName;
        this.kaishiYM = kaishiYM;
        this.shuryoYM = shuryoYM;
        this.shuryoYMbak = shuryoYMbak;
        this.tanka = tanka;
        this.sonotaTanka = sonotaTanka;
    }

    public RString getColumnState() {
        return columnState;
    }

    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    public RString getShinsakaiIinName() {
        return shinsakaiIinName;
    }

    public TextBoxFlexibleDate getKaishiYM() {
        return kaishiYM;
    }

    public TextBoxFlexibleDate getShuryoYM() {
        return shuryoYM;
    }

    public TextBoxFlexibleDate getShuryoYMbak() {
        return shuryoYMbak;
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

    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    public void setShinsakaiIinName(RString shinsakaiIinName) {
        this.setOriginalData("shinsakaiIinName", shinsakaiIinName);
        this.shinsakaiIinName = shinsakaiIinName;
    }

    public void setKaishiYM(TextBoxFlexibleDate kaishiYM) {
        this.setOriginalData("kaishiYM", kaishiYM);
        this.kaishiYM = kaishiYM;
    }

    public void setShuryoYM(TextBoxFlexibleDate shuryoYM) {
        this.setOriginalData("shuryoYM", shuryoYM);
        this.shuryoYM = shuryoYM;
    }

    public void setShuryoYMbak(TextBoxFlexibleDate shuryoYMbak) {
        this.setOriginalData("shuryoYMbak", shuryoYMbak);
        this.shuryoYMbak = shuryoYMbak;
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
