package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 08 15:15:11 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiIinIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">

    private RString shinsakaiIinCode;
    private RString shimei;
    private RString shozokuKikan;

    public dgShinsakaiIinIchiran_Row() {
        super();
        this.shinsakaiIinCode = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.shozokuKikan = RString.EMPTY;
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("shozokuKikan", shozokuKikan);
    }

    public dgShinsakaiIinIchiran_Row(RString shinsakaiIinCode, RString shimei, RString shozokuKikan) {
        super();
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.shimei = shimei;
        this.shozokuKikan = shozokuKikan;
    }

    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getShozokuKikan() {
        return shozokuKikan;
    }

    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setShozokuKikan(RString shozokuKikan) {
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.shozokuKikan = shozokuKikan;
    }

    // </editor-fold>
}
