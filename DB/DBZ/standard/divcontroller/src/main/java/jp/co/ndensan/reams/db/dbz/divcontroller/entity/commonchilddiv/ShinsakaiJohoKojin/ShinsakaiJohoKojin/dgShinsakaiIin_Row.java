package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Dec 19 20:11:04 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiIin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIin_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">

    private Boolean iincho;
    private RString shinsakaiIinCode;
    private RString shinsakaiIinShimei;
    private RString shinsakaiIinShikaku;

    public dgShinsakaiIin_Row() {
        super();
        this.iincho = false;
        this.shinsakaiIinCode = RString.EMPTY;
        this.shinsakaiIinShimei = RString.EMPTY;
        this.shinsakaiIinShikaku = RString.EMPTY;
        this.setOriginalData("iincho", iincho);
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shinsakaiIinShimei", shinsakaiIinShimei);
        this.setOriginalData("shinsakaiIinShikaku", shinsakaiIinShikaku);
    }

    public dgShinsakaiIin_Row(Boolean iincho, RString shinsakaiIinCode, RString shinsakaiIinShimei, RString shinsakaiIinShikaku) {
        super();
        this.setOriginalData("iincho", iincho);
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shinsakaiIinShimei", shinsakaiIinShimei);
        this.setOriginalData("shinsakaiIinShikaku", shinsakaiIinShikaku);
        this.iincho = iincho;
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.shinsakaiIinShimei = shinsakaiIinShimei;
        this.shinsakaiIinShikaku = shinsakaiIinShikaku;
    }

    public Boolean getIincho() {
        return iincho;
    }

    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    public RString getShinsakaiIinShimei() {
        return shinsakaiIinShimei;
    }

    public RString getShinsakaiIinShikaku() {
        return shinsakaiIinShikaku;
    }

    public void setIincho(Boolean iincho) {
        this.setOriginalData("iincho", iincho);
        this.iincho = iincho;
    }

    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    public void setShinsakaiIinShimei(RString shinsakaiIinShimei) {
        this.setOriginalData("shinsakaiIinShimei", shinsakaiIinShimei);
        this.shinsakaiIinShimei = shinsakaiIinShimei;
    }

    public void setShinsakaiIinShikaku(RString shinsakaiIinShikaku) {
        this.setOriginalData("shinsakaiIinShikaku", shinsakaiIinShikaku);
        this.shinsakaiIinShikaku = shinsakaiIinShikaku;
    }

    // </editor-fold>
}
