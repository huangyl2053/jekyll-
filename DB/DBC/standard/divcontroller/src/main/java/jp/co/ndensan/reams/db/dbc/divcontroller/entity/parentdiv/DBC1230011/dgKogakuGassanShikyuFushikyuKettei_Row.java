package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sun Sep 18 11:33:27 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * dgKogakuGassanShikyuFushikyuKettei_Row のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class dgKogakuGassanShikyuFushikyuKettei_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBoxFlexibleDate txtTaishoNendo;
    private RString txtShokisaiNo;
    private RString txtRenrakuhyoSeiriNo;
    private RString txtRirekiNo;
    private RString txtJikoFutangaku;
    private RString txtShikyuKubun;
    private RString txtShikyugaku;
    private TextBoxFlexibleDate txtUketoriNengetsu;
    private RString chkisDeleted;

    public dgKogakuGassanShikyuFushikyuKettei_Row() {
        super();
        this.txtTaishoNendo = new TextBoxFlexibleDate();
        this.txtShokisaiNo = RString.EMPTY;
        this.txtRenrakuhyoSeiriNo = RString.EMPTY;
        this.txtRirekiNo = RString.EMPTY;
        this.txtJikoFutangaku = RString.EMPTY;
        this.txtShikyuKubun = RString.EMPTY;
        this.txtShikyugaku = RString.EMPTY;
        this.txtUketoriNengetsu = new TextBoxFlexibleDate();
        this.chkisDeleted = RString.EMPTY;
        this.setOriginalData("txtTaishoNendo", txtTaishoNendo);
        this.setOriginalData("txtShokisaiNo", txtShokisaiNo);
        this.setOriginalData("txtRenrakuhyoSeiriNo", txtRenrakuhyoSeiriNo);
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.setOriginalData("txtJikoFutangaku", txtJikoFutangaku);
        this.setOriginalData("txtShikyuKubun", txtShikyuKubun);
        this.setOriginalData("txtShikyugaku", txtShikyugaku);
        this.setOriginalData("txtUketoriNengetsu", txtUketoriNengetsu);
        this.setOriginalData("chkisDeleted", chkisDeleted);
    }

    public dgKogakuGassanShikyuFushikyuKettei_Row(TextBoxFlexibleDate txtTaishoNendo, RString txtShokisaiNo, RString txtRenrakuhyoSeiriNo, RString txtRirekiNo, RString txtJikoFutangaku, RString txtShikyuKubun, RString txtShikyugaku, TextBoxFlexibleDate txtUketoriNengetsu, RString chkisDeleted) {
        super();
        this.setOriginalData("txtTaishoNendo", txtTaishoNendo);
        this.setOriginalData("txtShokisaiNo", txtShokisaiNo);
        this.setOriginalData("txtRenrakuhyoSeiriNo", txtRenrakuhyoSeiriNo);
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.setOriginalData("txtJikoFutangaku", txtJikoFutangaku);
        this.setOriginalData("txtShikyuKubun", txtShikyuKubun);
        this.setOriginalData("txtShikyugaku", txtShikyugaku);
        this.setOriginalData("txtUketoriNengetsu", txtUketoriNengetsu);
        this.setOriginalData("chkisDeleted", chkisDeleted);
        this.txtTaishoNendo = txtTaishoNendo;
        this.txtShokisaiNo = txtShokisaiNo;
        this.txtRenrakuhyoSeiriNo = txtRenrakuhyoSeiriNo;
        this.txtRirekiNo = txtRirekiNo;
        this.txtJikoFutangaku = txtJikoFutangaku;
        this.txtShikyuKubun = txtShikyuKubun;
        this.txtShikyugaku = txtShikyugaku;
        this.txtUketoriNengetsu = txtUketoriNengetsu;
        this.chkisDeleted = chkisDeleted;
    }

    public TextBoxFlexibleDate getTxtTaishoNendo() {
        return txtTaishoNendo;
    }

    public RString getTxtShokisaiNo() {
        return txtShokisaiNo;
    }

    public RString getTxtRenrakuhyoSeiriNo() {
        return txtRenrakuhyoSeiriNo;
    }

    public RString getTxtRirekiNo() {
        return txtRirekiNo;
    }

    public RString getTxtJikoFutangaku() {
        return txtJikoFutangaku;
    }

    public RString getTxtShikyuKubun() {
        return txtShikyuKubun;
    }

    public RString getTxtShikyugaku() {
        return txtShikyugaku;
    }

    public TextBoxFlexibleDate getTxtUketoriNengetsu() {
        return txtUketoriNengetsu;
    }

    public RString getChkisDeleted() {
        return chkisDeleted;
    }

    public void setTxtTaishoNendo(TextBoxFlexibleDate txtTaishoNendo) {
        this.setOriginalData("txtTaishoNendo", txtTaishoNendo);
        this.txtTaishoNendo = txtTaishoNendo;
    }

    public void setTxtShokisaiNo(RString txtShokisaiNo) {
        this.setOriginalData("txtShokisaiNo", txtShokisaiNo);
        this.txtShokisaiNo = txtShokisaiNo;
    }

    public void setTxtRenrakuhyoSeiriNo(RString txtRenrakuhyoSeiriNo) {
        this.setOriginalData("txtRenrakuhyoSeiriNo", txtRenrakuhyoSeiriNo);
        this.txtRenrakuhyoSeiriNo = txtRenrakuhyoSeiriNo;
    }

    public void setTxtRirekiNo(RString txtRirekiNo) {
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.txtRirekiNo = txtRirekiNo;
    }

    public void setTxtJikoFutangaku(RString txtJikoFutangaku) {
        this.setOriginalData("txtJikoFutangaku", txtJikoFutangaku);
        this.txtJikoFutangaku = txtJikoFutangaku;
    }

    public void setTxtShikyuKubun(RString txtShikyuKubun) {
        this.setOriginalData("txtShikyuKubun", txtShikyuKubun);
        this.txtShikyuKubun = txtShikyuKubun;
    }

    public void setTxtShikyugaku(RString txtShikyugaku) {
        this.setOriginalData("txtShikyugaku", txtShikyugaku);
        this.txtShikyugaku = txtShikyugaku;
    }

    public void setTxtUketoriNengetsu(TextBoxFlexibleDate txtUketoriNengetsu) {
        this.setOriginalData("txtUketoriNengetsu", txtUketoriNengetsu);
        this.txtUketoriNengetsu = txtUketoriNengetsu;
    }

    public void setChkisDeleted(RString chkisDeleted) {
        this.setOriginalData("chkisDeleted", chkisDeleted);
        this.chkisDeleted = chkisDeleted;
    }

    // </editor-fold>
}
