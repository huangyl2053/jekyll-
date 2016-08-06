package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 04 09:53:32 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShokanJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShokanJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString seiriNo;
    private TextBoxFlexibleDate txtTeikyoYM;
    private RString jigyoshaNo;
    private RString serviceShurui;
    private TextBoxNum txtShiharaiKingaku;

    public dgShokanJoho_Row() {
        super();
        this.seiriNo = RString.EMPTY;
        this.txtTeikyoYM = new TextBoxFlexibleDate();
        this.jigyoshaNo = RString.EMPTY;
        this.serviceShurui = RString.EMPTY;
        this.txtShiharaiKingaku = new TextBoxNum();
        this.setOriginalData("seiriNo", seiriNo);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("serviceShurui", serviceShurui);
        this.setOriginalData("txtShiharaiKingaku", txtShiharaiKingaku);
    }

    public dgShokanJoho_Row(RString seiriNo, TextBoxFlexibleDate txtTeikyoYM, RString jigyoshaNo, RString serviceShurui, TextBoxNum txtShiharaiKingaku) {
        super();
        this.setOriginalData("seiriNo", seiriNo);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("serviceShurui", serviceShurui);
        this.setOriginalData("txtShiharaiKingaku", txtShiharaiKingaku);
        this.seiriNo = seiriNo;
        this.txtTeikyoYM = txtTeikyoYM;
        this.jigyoshaNo = jigyoshaNo;
        this.serviceShurui = serviceShurui;
        this.txtShiharaiKingaku = txtShiharaiKingaku;
    }

    public RString getSeiriNo() {
        return seiriNo;
    }

    public TextBoxFlexibleDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    public RString getServiceShurui() {
        return serviceShurui;
    }

    public TextBoxNum getTxtShiharaiKingaku() {
        return txtShiharaiKingaku;
    }

    public void setSeiriNo(RString seiriNo) {
        this.setOriginalData("seiriNo", seiriNo);
        this.seiriNo = seiriNo;
    }

    public void setTxtTeikyoYM(TextBoxFlexibleDate txtTeikyoYM) {
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.txtTeikyoYM = txtTeikyoYM;
    }

    public void setJigyoshaNo(RString jigyoshaNo) {
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setServiceShurui(RString serviceShurui) {
        this.setOriginalData("serviceShurui", serviceShurui);
        this.serviceShurui = serviceShurui;
    }

    public void setTxtShiharaiKingaku(TextBoxNum txtShiharaiKingaku) {
        this.setOriginalData("txtShiharaiKingaku", txtShiharaiKingaku);
        this.txtShiharaiKingaku = txtShiharaiKingaku;
    }

    // </editor-fold>
}
