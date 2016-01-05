package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Dec 29 11:20:20 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsainList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsainList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private Boolean gogitaicho;
    private Boolean fukuGogitaicho;
    private RString shinsakaiIinCode;
    private RString shinsakaiIinShimei;

    public dgShinsainList_Row() {
        super();
        this.gogitaicho = false;
        this.fukuGogitaicho = false;
        this.shinsakaiIinCode = RString.EMPTY;
        this.shinsakaiIinShimei = RString.EMPTY;
        this.setOriginalData("gogitaicho", gogitaicho);
        this.setOriginalData("fukuGogitaicho", fukuGogitaicho);
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shinsakaiIinShimei", shinsakaiIinShimei);
    }

    public dgShinsainList_Row(Boolean gogitaicho, Boolean fukuGogitaicho, RString shinsakaiIinCode, RString shinsakaiIinShimei) {
        super();
        this.setOriginalData("gogitaicho", gogitaicho);
        this.setOriginalData("fukuGogitaicho", fukuGogitaicho);
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shinsakaiIinShimei", shinsakaiIinShimei);
        this.gogitaicho = gogitaicho;
        this.fukuGogitaicho = fukuGogitaicho;
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.shinsakaiIinShimei = shinsakaiIinShimei;
    }

    public Boolean getGogitaicho() {
        return gogitaicho;
    }

    public Boolean getFukuGogitaicho() {
        return fukuGogitaicho;
    }

    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    public RString getShinsakaiIinShimei() {
        return shinsakaiIinShimei;
    }

    public void setGogitaicho(Boolean gogitaicho) {
        this.setOriginalData("gogitaicho", gogitaicho);
        this.gogitaicho = gogitaicho;
    }

    public void setFukuGogitaicho(Boolean fukuGogitaicho) {
        this.setOriginalData("fukuGogitaicho", fukuGogitaicho);
        this.fukuGogitaicho = fukuGogitaicho;
    }

    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    public void setShinsakaiIinShimei(RString shinsakaiIinShimei) {
        this.setOriginalData("shinsakaiIinShimei", shinsakaiIinShimei);
        this.shinsakaiIinShimei = shinsakaiIinShimei;
    }

    // </editor-fold>
}
