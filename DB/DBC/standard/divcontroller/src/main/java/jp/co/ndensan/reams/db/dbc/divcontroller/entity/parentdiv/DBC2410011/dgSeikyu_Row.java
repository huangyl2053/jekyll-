package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Oct 31 16:57:54 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgSeikyu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSeikyu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">

    private RString jigyoshaNo;
    private RString jigyoshaMei;
    private TextBoxDate seikyuJohoSakuseiYMD;
    private TextBoxNum seikyuKensu;
    private TextBoxNum seikyuKingaku;
    private TextBoxDate uketsukeYMD;
    private TextBoxDate ketteiYMD;
    private RString ketteiKubun;
    private RString hdnShukeiNo;

    public dgSeikyu_Row() {
        super();
        this.jigyoshaNo = RString.EMPTY;
        this.jigyoshaMei = RString.EMPTY;
        this.seikyuJohoSakuseiYMD = new TextBoxDate();
        this.seikyuKensu = new TextBoxNum();
        this.seikyuKingaku = new TextBoxNum();
        this.uketsukeYMD = new TextBoxDate();
        this.ketteiYMD = new TextBoxDate();
        this.ketteiKubun = RString.EMPTY;
        this.hdnShukeiNo = RString.EMPTY;
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("jigyoshaMei", jigyoshaMei);
        this.setOriginalData("seikyuJohoSakuseiYMD", seikyuJohoSakuseiYMD);
        this.setOriginalData("seikyuKensu", seikyuKensu);
        this.setOriginalData("seikyuKingaku", seikyuKingaku);
        this.setOriginalData("uketsukeYMD", uketsukeYMD);
        this.setOriginalData("ketteiYMD", ketteiYMD);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("hdnShukeiNo", hdnShukeiNo);
    }

    public dgSeikyu_Row(RString jigyoshaNo, RString jigyoshaMei, TextBoxDate seikyuJohoSakuseiYMD, TextBoxNum seikyuKensu, TextBoxNum seikyuKingaku, TextBoxDate uketsukeYMD, TextBoxDate ketteiYMD, RString ketteiKubun, RString hdnShukeiNo) {
        super();
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("jigyoshaMei", jigyoshaMei);
        this.setOriginalData("seikyuJohoSakuseiYMD", seikyuJohoSakuseiYMD);
        this.setOriginalData("seikyuKensu", seikyuKensu);
        this.setOriginalData("seikyuKingaku", seikyuKingaku);
        this.setOriginalData("uketsukeYMD", uketsukeYMD);
        this.setOriginalData("ketteiYMD", ketteiYMD);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("hdnShukeiNo", hdnShukeiNo);
        this.jigyoshaNo = jigyoshaNo;
        this.jigyoshaMei = jigyoshaMei;
        this.seikyuJohoSakuseiYMD = seikyuJohoSakuseiYMD;
        this.seikyuKensu = seikyuKensu;
        this.seikyuKingaku = seikyuKingaku;
        this.uketsukeYMD = uketsukeYMD;
        this.ketteiYMD = ketteiYMD;
        this.ketteiKubun = ketteiKubun;
        this.hdnShukeiNo = hdnShukeiNo;
    }

    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    public RString getJigyoshaMei() {
        return jigyoshaMei;
    }

    public TextBoxDate getSeikyuJohoSakuseiYMD() {
        return seikyuJohoSakuseiYMD;
    }

    public TextBoxNum getSeikyuKensu() {
        return seikyuKensu;
    }

    public TextBoxNum getSeikyuKingaku() {
        return seikyuKingaku;
    }

    public TextBoxDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    public TextBoxDate getKetteiYMD() {
        return ketteiYMD;
    }

    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    public RString getHdnShukeiNo() {
        return hdnShukeiNo;
    }

    public void setJigyoshaNo(RString jigyoshaNo) {
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setJigyoshaMei(RString jigyoshaMei) {
        this.setOriginalData("jigyoshaMei", jigyoshaMei);
        this.jigyoshaMei = jigyoshaMei;
    }

    public void setSeikyuJohoSakuseiYMD(TextBoxDate seikyuJohoSakuseiYMD) {
        this.setOriginalData("seikyuJohoSakuseiYMD", seikyuJohoSakuseiYMD);
        this.seikyuJohoSakuseiYMD = seikyuJohoSakuseiYMD;
    }

    public void setSeikyuKensu(TextBoxNum seikyuKensu) {
        this.setOriginalData("seikyuKensu", seikyuKensu);
        this.seikyuKensu = seikyuKensu;
    }

    public void setSeikyuKingaku(TextBoxNum seikyuKingaku) {
        this.setOriginalData("seikyuKingaku", seikyuKingaku);
        this.seikyuKingaku = seikyuKingaku;
    }

    public void setUketsukeYMD(TextBoxDate uketsukeYMD) {
        this.setOriginalData("uketsukeYMD", uketsukeYMD);
        this.uketsukeYMD = uketsukeYMD;
    }

    public void setKetteiYMD(TextBoxDate ketteiYMD) {
        this.setOriginalData("ketteiYMD", ketteiYMD);
        this.ketteiYMD = ketteiYMD;
    }

    public void setKetteiKubun(RString ketteiKubun) {
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.ketteiKubun = ketteiKubun;
    }

    public void setHdnShukeiNo(RString hdnShukeiNo) {
        this.setOriginalData("hdnShukeiNo", hdnShukeiNo);
        this.hdnShukeiNo = hdnShukeiNo;
    }

    // </editor-fold>
}
