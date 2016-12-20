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
 * dgHoketsuShinsakai_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHoketsuShinsakai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">

    private Boolean iincho;
    private RString hoketsuShinsakaiIinCode;
    private RString hoketsuShinsakaiIinShimei;
    private RString hoketsuShinsakaiIinShikaku;

    public dgHoketsuShinsakai_Row() {
        super();
        this.iincho = false;
        this.hoketsuShinsakaiIinCode = RString.EMPTY;
        this.hoketsuShinsakaiIinShimei = RString.EMPTY;
        this.hoketsuShinsakaiIinShikaku = RString.EMPTY;
        this.setOriginalData("iincho", iincho);
        this.setOriginalData("hoketsuShinsakaiIinCode", hoketsuShinsakaiIinCode);
        this.setOriginalData("hoketsuShinsakaiIinShimei", hoketsuShinsakaiIinShimei);
        this.setOriginalData("hoketsuShinsakaiIinShikaku", hoketsuShinsakaiIinShikaku);
    }

    public dgHoketsuShinsakai_Row(Boolean iincho, RString hoketsuShinsakaiIinCode, RString hoketsuShinsakaiIinShimei, RString hoketsuShinsakaiIinShikaku) {
        super();
        this.setOriginalData("iincho", iincho);
        this.setOriginalData("hoketsuShinsakaiIinCode", hoketsuShinsakaiIinCode);
        this.setOriginalData("hoketsuShinsakaiIinShimei", hoketsuShinsakaiIinShimei);
        this.setOriginalData("hoketsuShinsakaiIinShikaku", hoketsuShinsakaiIinShikaku);
        this.iincho = iincho;
        this.hoketsuShinsakaiIinCode = hoketsuShinsakaiIinCode;
        this.hoketsuShinsakaiIinShimei = hoketsuShinsakaiIinShimei;
        this.hoketsuShinsakaiIinShikaku = hoketsuShinsakaiIinShikaku;
    }

    public Boolean getIincho() {
        return iincho;
    }

    public RString getHoketsuShinsakaiIinCode() {
        return hoketsuShinsakaiIinCode;
    }

    public RString getHoketsuShinsakaiIinShimei() {
        return hoketsuShinsakaiIinShimei;
    }

    public RString getHoketsuShinsakaiIinShikaku() {
        return hoketsuShinsakaiIinShikaku;
    }

    public void setIincho(Boolean iincho) {
        this.setOriginalData("iincho", iincho);
        this.iincho = iincho;
    }

    public void setHoketsuShinsakaiIinCode(RString hoketsuShinsakaiIinCode) {
        this.setOriginalData("hoketsuShinsakaiIinCode", hoketsuShinsakaiIinCode);
        this.hoketsuShinsakaiIinCode = hoketsuShinsakaiIinCode;
    }

    public void setHoketsuShinsakaiIinShimei(RString hoketsuShinsakaiIinShimei) {
        this.setOriginalData("hoketsuShinsakaiIinShimei", hoketsuShinsakaiIinShimei);
        this.hoketsuShinsakaiIinShimei = hoketsuShinsakaiIinShimei;
    }

    public void setHoketsuShinsakaiIinShikaku(RString hoketsuShinsakaiIinShikaku) {
        this.setOriginalData("hoketsuShinsakaiIinShikaku", hoketsuShinsakaiIinShikaku);
        this.hoketsuShinsakaiIinShikaku = hoketsuShinsakaiIinShikaku;
    }

    // </editor-fold>
}
