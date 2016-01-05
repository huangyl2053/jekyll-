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
 * dgHoketsuShinsainList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHoketsuShinsainList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString hoketsuShinsakaiIinCode;
    private RString hoketsuShinsakaiIinShimei;

    public dgHoketsuShinsainList_Row() {
        super();
        this.hoketsuShinsakaiIinCode = RString.EMPTY;
        this.hoketsuShinsakaiIinShimei = RString.EMPTY;
        this.setOriginalData("hoketsuShinsakaiIinCode", hoketsuShinsakaiIinCode);
        this.setOriginalData("hoketsuShinsakaiIinShimei", hoketsuShinsakaiIinShimei);
    }

    public dgHoketsuShinsainList_Row(RString hoketsuShinsakaiIinCode, RString hoketsuShinsakaiIinShimei) {
        super();
        this.setOriginalData("hoketsuShinsakaiIinCode", hoketsuShinsakaiIinCode);
        this.setOriginalData("hoketsuShinsakaiIinShimei", hoketsuShinsakaiIinShimei);
        this.hoketsuShinsakaiIinCode = hoketsuShinsakaiIinCode;
        this.hoketsuShinsakaiIinShimei = hoketsuShinsakaiIinShimei;
    }

    public RString getHoketsuShinsakaiIinCode() {
        return hoketsuShinsakaiIinCode;
    }

    public RString getHoketsuShinsakaiIinShimei() {
        return hoketsuShinsakaiIinShimei;
    }

    public void setHoketsuShinsakaiIinCode(RString hoketsuShinsakaiIinCode) {
        this.setOriginalData("hoketsuShinsakaiIinCode", hoketsuShinsakaiIinCode);
        this.hoketsuShinsakaiIinCode = hoketsuShinsakaiIinCode;
    }

    public void setHoketsuShinsakaiIinShimei(RString hoketsuShinsakaiIinShimei) {
        this.setOriginalData("hoketsuShinsakaiIinShimei", hoketsuShinsakaiIinShimei);
        this.hoketsuShinsakaiIinShimei = hoketsuShinsakaiIinShimei;
    }

    // </editor-fold>
}
