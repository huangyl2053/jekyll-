package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 04 10:39:21 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHoketsuShinsainList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHoketsuShinsainList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString hoketsuShinsakaiIinCode;
    private RString hoketsuShinsakaiIinShimei;
    private RString state;

    public dgHoketsuShinsainList_Row() {
        super();
        this.hoketsuShinsakaiIinCode = RString.EMPTY;
        this.hoketsuShinsakaiIinShimei = RString.EMPTY;
        this.state = RString.EMPTY;
        this.setOriginalData("hoketsuShinsakaiIinCode", hoketsuShinsakaiIinCode);
        this.setOriginalData("hoketsuShinsakaiIinShimei", hoketsuShinsakaiIinShimei);
        this.setOriginalData("state", state);
    }

    public dgHoketsuShinsainList_Row(RString hoketsuShinsakaiIinCode, RString hoketsuShinsakaiIinShimei, RString state) {
        super();
        this.setOriginalData("hoketsuShinsakaiIinCode", hoketsuShinsakaiIinCode);
        this.setOriginalData("hoketsuShinsakaiIinShimei", hoketsuShinsakaiIinShimei);
        this.setOriginalData("state", state);
        this.hoketsuShinsakaiIinCode = hoketsuShinsakaiIinCode;
        this.hoketsuShinsakaiIinShimei = hoketsuShinsakaiIinShimei;
        this.state = state;
    }

    public RString getHoketsuShinsakaiIinCode() {
        return hoketsuShinsakaiIinCode;
    }

    public RString getHoketsuShinsakaiIinShimei() {
        return hoketsuShinsakaiIinShimei;
    }

    public RString getState() {
        return state;
    }

    public void setHoketsuShinsakaiIinCode(RString hoketsuShinsakaiIinCode) {
        this.setOriginalData("hoketsuShinsakaiIinCode", hoketsuShinsakaiIinCode);
        this.hoketsuShinsakaiIinCode = hoketsuShinsakaiIinCode;
    }

    public void setHoketsuShinsakaiIinShimei(RString hoketsuShinsakaiIinShimei) {
        this.setOriginalData("hoketsuShinsakaiIinShimei", hoketsuShinsakaiIinShimei);
        this.hoketsuShinsakaiIinShimei = hoketsuShinsakaiIinShimei;
    }

    public void setState(RString state) {
        this.setOriginalData("state", state);
        this.state = state;
    }

    // </editor-fold>
}
