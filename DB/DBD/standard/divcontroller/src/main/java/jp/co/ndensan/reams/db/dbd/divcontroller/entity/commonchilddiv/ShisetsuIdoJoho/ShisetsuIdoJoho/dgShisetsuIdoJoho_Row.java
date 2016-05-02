package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShisetsuIdoJoho.ShisetsuIdoJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 27 22:13:01 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShisetsuIdoJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShisetsuIdoJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private TextBoxFlexibleDate nyushoDate;
    private TextBoxFlexibleDate taishoDate;
    private RString jigyoshaName;
    private RString jigyoshaCode;
    private RString tenshutsusakiHokenshaNo;

    public dgShisetsuIdoJoho_Row() {
        super();
        this.nyushoDate = new TextBoxFlexibleDate();
        this.taishoDate = new TextBoxFlexibleDate();
        this.jigyoshaName = RString.EMPTY;
        this.jigyoshaCode = RString.EMPTY;
        this.tenshutsusakiHokenshaNo = RString.EMPTY;
        this.setOriginalData("nyushoDate", nyushoDate);
        this.setOriginalData("taishoDate", taishoDate);
        this.setOriginalData("jigyoshaName", jigyoshaName);
        this.setOriginalData("jigyoshaCode", jigyoshaCode);
        this.setOriginalData("tenshutsusakiHokenshaNo", tenshutsusakiHokenshaNo);
    }

    public dgShisetsuIdoJoho_Row(TextBoxFlexibleDate nyushoDate, TextBoxFlexibleDate taishoDate, RString jigyoshaName, RString jigyoshaCode, RString tenshutsusakiHokenshaNo) {
        super();
        this.setOriginalData("nyushoDate", nyushoDate);
        this.setOriginalData("taishoDate", taishoDate);
        this.setOriginalData("jigyoshaName", jigyoshaName);
        this.setOriginalData("jigyoshaCode", jigyoshaCode);
        this.setOriginalData("tenshutsusakiHokenshaNo", tenshutsusakiHokenshaNo);
        this.nyushoDate = nyushoDate;
        this.taishoDate = taishoDate;
        this.jigyoshaName = jigyoshaName;
        this.jigyoshaCode = jigyoshaCode;
        this.tenshutsusakiHokenshaNo = tenshutsusakiHokenshaNo;
    }

    public TextBoxFlexibleDate getNyushoDate() {
        return nyushoDate;
    }

    public TextBoxFlexibleDate getTaishoDate() {
        return taishoDate;
    }

    public RString getJigyoshaName() {
        return jigyoshaName;
    }

    public RString getJigyoshaCode() {
        return jigyoshaCode;
    }

    public RString getTenshutsusakiHokenshaNo() {
        return tenshutsusakiHokenshaNo;
    }

    public void setNyushoDate(TextBoxFlexibleDate nyushoDate) {
        this.setOriginalData("nyushoDate", nyushoDate);
        this.nyushoDate = nyushoDate;
    }

    public void setTaishoDate(TextBoxFlexibleDate taishoDate) {
        this.setOriginalData("taishoDate", taishoDate);
        this.taishoDate = taishoDate;
    }

    public void setJigyoshaName(RString jigyoshaName) {
        this.setOriginalData("jigyoshaName", jigyoshaName);
        this.jigyoshaName = jigyoshaName;
    }

    public void setJigyoshaCode(RString jigyoshaCode) {
        this.setOriginalData("jigyoshaCode", jigyoshaCode);
        this.jigyoshaCode = jigyoshaCode;
    }

    public void setTenshutsusakiHokenshaNo(RString tenshutsusakiHokenshaNo) {
        this.setOriginalData("tenshutsusakiHokenshaNo", tenshutsusakiHokenshaNo);
        this.tenshutsusakiHokenshaNo = tenshutsusakiHokenshaNo;
    }

    // </editor-fold>
}
