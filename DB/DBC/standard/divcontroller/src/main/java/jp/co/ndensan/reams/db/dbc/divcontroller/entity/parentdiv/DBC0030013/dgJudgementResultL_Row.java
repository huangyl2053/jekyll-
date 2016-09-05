package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Sep 05 10:58:40 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgJudgementResultL_Row のクラスファイル
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class dgJudgementResultL_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtJigyosha;
    private RString txtServiceShurui;
    private TextBoxNum txtServiceHiyoGokeigaku;
    private TextBoxNum txtRiyoshaFutangaku;
    private TextBoxNum txtSanteiKijungaku;
    private TextBoxNum txtShiharaizumiKingaku;
    private TextBoxNum txtKogakuShikyugaku;

    public dgJudgementResultL_Row() {
        super();
        this.txtJigyosha = RString.EMPTY;
        this.txtServiceShurui = RString.EMPTY;
        this.txtServiceHiyoGokeigaku = new TextBoxNum();
        this.txtRiyoshaFutangaku = new TextBoxNum();
        this.txtSanteiKijungaku = new TextBoxNum();
        this.txtShiharaizumiKingaku = new TextBoxNum();
        this.txtKogakuShikyugaku = new TextBoxNum();
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.setOriginalData("txtServiceHiyoGokeigaku", txtServiceHiyoGokeigaku);
        this.setOriginalData("txtRiyoshaFutangaku", txtRiyoshaFutangaku);
        this.setOriginalData("txtSanteiKijungaku", txtSanteiKijungaku);
        this.setOriginalData("txtShiharaizumiKingaku", txtShiharaizumiKingaku);
        this.setOriginalData("txtKogakuShikyugaku", txtKogakuShikyugaku);
    }

    public dgJudgementResultL_Row(RString txtJigyosha, RString txtServiceShurui, TextBoxNum txtServiceHiyoGokeigaku, TextBoxNum txtRiyoshaFutangaku, TextBoxNum txtSanteiKijungaku, TextBoxNum txtShiharaizumiKingaku, TextBoxNum txtKogakuShikyugaku) {
        super();
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.setOriginalData("txtServiceHiyoGokeigaku", txtServiceHiyoGokeigaku);
        this.setOriginalData("txtRiyoshaFutangaku", txtRiyoshaFutangaku);
        this.setOriginalData("txtSanteiKijungaku", txtSanteiKijungaku);
        this.setOriginalData("txtShiharaizumiKingaku", txtShiharaizumiKingaku);
        this.setOriginalData("txtKogakuShikyugaku", txtKogakuShikyugaku);
        this.txtJigyosha = txtJigyosha;
        this.txtServiceShurui = txtServiceShurui;
        this.txtServiceHiyoGokeigaku = txtServiceHiyoGokeigaku;
        this.txtRiyoshaFutangaku = txtRiyoshaFutangaku;
        this.txtSanteiKijungaku = txtSanteiKijungaku;
        this.txtShiharaizumiKingaku = txtShiharaizumiKingaku;
        this.txtKogakuShikyugaku = txtKogakuShikyugaku;
    }

    public RString getTxtJigyosha() {
        return txtJigyosha;
    }

    public RString getTxtServiceShurui() {
        return txtServiceShurui;
    }

    public TextBoxNum getTxtServiceHiyoGokeigaku() {
        return txtServiceHiyoGokeigaku;
    }

    public TextBoxNum getTxtRiyoshaFutangaku() {
        return txtRiyoshaFutangaku;
    }

    public TextBoxNum getTxtSanteiKijungaku() {
        return txtSanteiKijungaku;
    }

    public TextBoxNum getTxtShiharaizumiKingaku() {
        return txtShiharaizumiKingaku;
    }

    public TextBoxNum getTxtKogakuShikyugaku() {
        return txtKogakuShikyugaku;
    }

    public void setTxtJigyosha(RString txtJigyosha) {
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.txtJigyosha = txtJigyosha;
    }

    public void setTxtServiceShurui(RString txtServiceShurui) {
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.txtServiceShurui = txtServiceShurui;
    }

    public void setTxtServiceHiyoGokeigaku(TextBoxNum txtServiceHiyoGokeigaku) {
        this.setOriginalData("txtServiceHiyoGokeigaku", txtServiceHiyoGokeigaku);
        this.txtServiceHiyoGokeigaku = txtServiceHiyoGokeigaku;
    }

    public void setTxtRiyoshaFutangaku(TextBoxNum txtRiyoshaFutangaku) {
        this.setOriginalData("txtRiyoshaFutangaku", txtRiyoshaFutangaku);
        this.txtRiyoshaFutangaku = txtRiyoshaFutangaku;
    }

    public void setTxtSanteiKijungaku(TextBoxNum txtSanteiKijungaku) {
        this.setOriginalData("txtSanteiKijungaku", txtSanteiKijungaku);
        this.txtSanteiKijungaku = txtSanteiKijungaku;
    }

    public void setTxtShiharaizumiKingaku(TextBoxNum txtShiharaizumiKingaku) {
        this.setOriginalData("txtShiharaizumiKingaku", txtShiharaizumiKingaku);
        this.txtShiharaizumiKingaku = txtShiharaizumiKingaku;
    }

    public void setTxtKogakuShikyugaku(TextBoxNum txtKogakuShikyugaku) {
        this.setOriginalData("txtKogakuShikyugaku", txtKogakuShikyugaku);
        this.txtKogakuShikyugaku = txtKogakuShikyugaku;
    }

    // </editor-fold>
}
