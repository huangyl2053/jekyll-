package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 14 10:16:54 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgKogakuServicehiRireki_Row のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class dgKogakuServicehiRireki_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtHihoNo;
    private RString txtHihoName;
    private TextBoxDate txtTeikyoYM;
    private TextBoxNum txtKogakuShikyuAmount;
    private TextBoxDate txtShinseiDate;
    private TextBoxDate txtKetteiDate;
    private RString txtShikyuKubun;
    private TextBoxNum txtShikyuKingaku;
    private RString txtKogakuJidoShokan;
    private RString txtRirekiNo;
    private RString txtHdnShoHokensha;
    private RString txtHdnShikibetsuCode;

    public dgKogakuServicehiRireki_Row() {
        super();
        this.txtHihoNo = RString.EMPTY;
        this.txtHihoName = RString.EMPTY;
        this.txtTeikyoYM = new TextBoxDate();
        this.txtKogakuShikyuAmount = new TextBoxNum();
        this.txtShinseiDate = new TextBoxDate();
        this.txtKetteiDate = new TextBoxDate();
        this.txtShikyuKubun = RString.EMPTY;
        this.txtShikyuKingaku = new TextBoxNum();
        this.txtKogakuJidoShokan = RString.EMPTY;
        this.txtRirekiNo = RString.EMPTY;
        this.txtHdnShoHokensha = RString.EMPTY;
        this.txtHdnShikibetsuCode = RString.EMPTY;
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihoName", txtHihoName);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtKogakuShikyuAmount", txtKogakuShikyuAmount);
        this.setOriginalData("txtShinseiDate", txtShinseiDate);
        this.setOriginalData("txtKetteiDate", txtKetteiDate);
        this.setOriginalData("txtShikyuKubun", txtShikyuKubun);
        this.setOriginalData("txtShikyuKingaku", txtShikyuKingaku);
        this.setOriginalData("txtKogakuJidoShokan", txtKogakuJidoShokan);
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.setOriginalData("txtHdnShoHokensha", txtHdnShoHokensha);
        this.setOriginalData("txtHdnShikibetsuCode", txtHdnShikibetsuCode);
    }

    public dgKogakuServicehiRireki_Row(RString txtHihoNo, RString txtHihoName, TextBoxDate txtTeikyoYM, TextBoxNum txtKogakuShikyuAmount, TextBoxDate txtShinseiDate, TextBoxDate txtKetteiDate, RString txtShikyuKubun, TextBoxNum txtShikyuKingaku, RString txtKogakuJidoShokan, RString txtRirekiNo, RString txtHdnShoHokensha, RString txtHdnShikibetsuCode) {
        super();
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihoName", txtHihoName);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtKogakuShikyuAmount", txtKogakuShikyuAmount);
        this.setOriginalData("txtShinseiDate", txtShinseiDate);
        this.setOriginalData("txtKetteiDate", txtKetteiDate);
        this.setOriginalData("txtShikyuKubun", txtShikyuKubun);
        this.setOriginalData("txtShikyuKingaku", txtShikyuKingaku);
        this.setOriginalData("txtKogakuJidoShokan", txtKogakuJidoShokan);
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.setOriginalData("txtHdnShoHokensha", txtHdnShoHokensha);
        this.setOriginalData("txtHdnShikibetsuCode", txtHdnShikibetsuCode);
        this.txtHihoNo = txtHihoNo;
        this.txtHihoName = txtHihoName;
        this.txtTeikyoYM = txtTeikyoYM;
        this.txtKogakuShikyuAmount = txtKogakuShikyuAmount;
        this.txtShinseiDate = txtShinseiDate;
        this.txtKetteiDate = txtKetteiDate;
        this.txtShikyuKubun = txtShikyuKubun;
        this.txtShikyuKingaku = txtShikyuKingaku;
        this.txtKogakuJidoShokan = txtKogakuJidoShokan;
        this.txtRirekiNo = txtRirekiNo;
        this.txtHdnShoHokensha = txtHdnShoHokensha;
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    public RString getTxtHihoNo() {
        return txtHihoNo;
    }

    public RString getTxtHihoName() {
        return txtHihoName;
    }

    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    public TextBoxNum getTxtKogakuShikyuAmount() {
        return txtKogakuShikyuAmount;
    }

    public TextBoxDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    public TextBoxDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    public RString getTxtShikyuKubun() {
        return txtShikyuKubun;
    }

    public TextBoxNum getTxtShikyuKingaku() {
        return txtShikyuKingaku;
    }

    public RString getTxtKogakuJidoShokan() {
        return txtKogakuJidoShokan;
    }

    public RString getTxtRirekiNo() {
        return txtRirekiNo;
    }

    public RString getTxtHdnShoHokensha() {
        return txtHdnShoHokensha;
    }

    public RString getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    public void setTxtHihoNo(RString txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtHihoName(RString txtHihoName) {
        this.setOriginalData("txtHihoName", txtHihoName);
        this.txtHihoName = txtHihoName;
    }

    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.txtTeikyoYM = txtTeikyoYM;
    }

    public void setTxtKogakuShikyuAmount(TextBoxNum txtKogakuShikyuAmount) {
        this.setOriginalData("txtKogakuShikyuAmount", txtKogakuShikyuAmount);
        this.txtKogakuShikyuAmount = txtKogakuShikyuAmount;
    }

    public void setTxtShinseiDate(TextBoxDate txtShinseiDate) {
        this.setOriginalData("txtShinseiDate", txtShinseiDate);
        this.txtShinseiDate = txtShinseiDate;
    }

    public void setTxtKetteiDate(TextBoxDate txtKetteiDate) {
        this.setOriginalData("txtKetteiDate", txtKetteiDate);
        this.txtKetteiDate = txtKetteiDate;
    }

    public void setTxtShikyuKubun(RString txtShikyuKubun) {
        this.setOriginalData("txtShikyuKubun", txtShikyuKubun);
        this.txtShikyuKubun = txtShikyuKubun;
    }

    public void setTxtShikyuKingaku(TextBoxNum txtShikyuKingaku) {
        this.setOriginalData("txtShikyuKingaku", txtShikyuKingaku);
        this.txtShikyuKingaku = txtShikyuKingaku;
    }

    public void setTxtKogakuJidoShokan(RString txtKogakuJidoShokan) {
        this.setOriginalData("txtKogakuJidoShokan", txtKogakuJidoShokan);
        this.txtKogakuJidoShokan = txtKogakuJidoShokan;
    }

    public void setTxtRirekiNo(RString txtRirekiNo) {
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.txtRirekiNo = txtRirekiNo;
    }

    public void setTxtHdnShoHokensha(RString txtHdnShoHokensha) {
        this.setOriginalData("txtHdnShoHokensha", txtHdnShoHokensha);
        this.txtHdnShoHokensha = txtHdnShoHokensha;
    }

    public void setTxtHdnShikibetsuCode(RString txtHdnShikibetsuCode) {
        this.setOriginalData("txtHdnShikibetsuCode", txtHdnShikibetsuCode);
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    // </editor-fold>
}
