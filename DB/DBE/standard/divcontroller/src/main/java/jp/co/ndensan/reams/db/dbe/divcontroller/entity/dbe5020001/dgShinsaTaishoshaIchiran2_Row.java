package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 20 20:23:24 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsaTaishoshaIchiran2_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsaTaishoshaIchiran2_Row extends DataRow {

    private RString 申請;
    private RString 状況;
    private RString 前一次;
    private RString 前二次;
    private RString 一次;
    private RString 二次;
    private RString 前期間;
    private RString 期間;

    public dgShinsaTaishoshaIchiran2_Row() {
        super();
        this.申請 = RString.EMPTY;
        this.状況 = RString.EMPTY;
        this.前一次 = RString.EMPTY;
        this.前二次 = RString.EMPTY;
        this.一次 = RString.EMPTY;
        this.二次 = RString.EMPTY;
        this.前期間 = RString.EMPTY;
        this.期間 = RString.EMPTY;
    }

    public dgShinsaTaishoshaIchiran2_Row(RString 申請, RString 状況, RString 前一次, RString 前二次, RString 一次, RString 二次, RString 前期間, RString 期間) {
        super();
        this.setOriginalData("申請", 申請);
        this.setOriginalData("状況", 状況);
        this.setOriginalData("前一次", 前一次);
        this.setOriginalData("前二次", 前二次);
        this.setOriginalData("一次", 一次);
        this.setOriginalData("二次", 二次);
        this.setOriginalData("前期間", 前期間);
        this.setOriginalData("期間", 期間);
        this.申請 = 申請;
        this.状況 = 状況;
        this.前一次 = 前一次;
        this.前二次 = 前二次;
        this.一次 = 一次;
        this.二次 = 二次;
        this.前期間 = 前期間;
        this.期間 = 期間;
    }

    public RString get申請() {
        return 申請;
    }

    public RString get状況() {
        return 状況;
    }

    public RString get前一次() {
        return 前一次;
    }

    public RString get前二次() {
        return 前二次;
    }

    public RString get一次() {
        return 一次;
    }

    public RString get二次() {
        return 二次;
    }

    public RString get前期間() {
        return 前期間;
    }

    public RString get期間() {
        return 期間;
    }

    public void set申請(RString 申請) {
        this.setOriginalData("申請", 申請);
        this.申請 = 申請;
    }

    public void set状況(RString 状況) {
        this.setOriginalData("状況", 状況);
        this.状況 = 状況;
    }

    public void set前一次(RString 前一次) {
        this.setOriginalData("前一次", 前一次);
        this.前一次 = 前一次;
    }

    public void set前二次(RString 前二次) {
        this.setOriginalData("前二次", 前二次);
        this.前二次 = 前二次;
    }

    public void set一次(RString 一次) {
        this.setOriginalData("一次", 一次);
        this.一次 = 一次;
    }

    public void set二次(RString 二次) {
        this.setOriginalData("二次", 二次);
        this.二次 = 二次;
    }

    public void set前期間(RString 前期間) {
        this.setOriginalData("前期間", 前期間);
        this.前期間 = 前期間;
    }

    public void set期間(RString 期間) {
        this.setOriginalData("期間", 期間);
        this.期間 = 期間;
    }

}