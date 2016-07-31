package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jul 27 19:37:44 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumnCheckBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgTokubetChoshuMidoteiIchiran_Row のクラスファイル
 *
 * @reamsid_L DBB-1860-010 liuyang
 */
public class dgTokubetChoshuMidoteiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private DataGridColumnCheckBox chkKakunin;
    private RString txtKakuninJokyo;
    private RString txtFuichiRiyu;
    private TextBox txtHosokuM;
    private TextBox txtKisoNenkinNo;
    private TextBox txtNenkinCode;
    private TextBox txtTokuchoGimusha;
    private TextBox txtShimeiKana;
    private TextBoxDate txtUmareYMD;
    private TextBox txtSeibetsu;

    public dgTokubetChoshuMidoteiIchiran_Row() {
        super();
        this.chkKakunin = new DataGridColumnCheckBox();
        this.txtKakuninJokyo = RString.EMPTY;
        this.txtFuichiRiyu = RString.EMPTY;
        this.txtHosokuM = new TextBox();
        this.txtKisoNenkinNo = new TextBox();
        this.txtNenkinCode = new TextBox();
        this.txtTokuchoGimusha = new TextBox();
        this.txtShimeiKana = new TextBox();
        this.txtUmareYMD = new TextBoxDate();
        this.txtSeibetsu = new TextBox();
        this.setOriginalData("chkKakunin", chkKakunin);
        this.setOriginalData("txtKakuninJokyo", txtKakuninJokyo);
        this.setOriginalData("txtFuichiRiyu", txtFuichiRiyu);
        this.setOriginalData("txtHosokuM", txtHosokuM);
        this.setOriginalData("txtKisoNenkinNo", txtKisoNenkinNo);
        this.setOriginalData("txtNenkinCode", txtNenkinCode);
        this.setOriginalData("txtTokuchoGimusha", txtTokuchoGimusha);
        this.setOriginalData("txtShimeiKana", txtShimeiKana);
        this.setOriginalData("txtUmareYMD", txtUmareYMD);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
    }

    public dgTokubetChoshuMidoteiIchiran_Row(DataGridColumnCheckBox chkKakunin, RString txtKakuninJokyo, RString txtFuichiRiyu, TextBox txtHosokuM, TextBox txtKisoNenkinNo, TextBox txtNenkinCode, TextBox txtTokuchoGimusha, TextBox txtShimeiKana, TextBoxDate txtUmareYMD, TextBox txtSeibetsu, RString txtFuichiRiyuCode) {
        super();
        this.setOriginalData("chkKakunin", chkKakunin);
        this.setOriginalData("txtKakuninJokyo", txtKakuninJokyo);
        this.setOriginalData("txtFuichiRiyu", txtFuichiRiyu);
        this.setOriginalData("txtHosokuM", txtHosokuM);
        this.setOriginalData("txtKisoNenkinNo", txtKisoNenkinNo);
        this.setOriginalData("txtNenkinCode", txtNenkinCode);
        this.setOriginalData("txtTokuchoGimusha", txtTokuchoGimusha);
        this.setOriginalData("txtShimeiKana", txtShimeiKana);
        this.setOriginalData("txtUmareYMD", txtUmareYMD);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.chkKakunin = chkKakunin;
        this.txtKakuninJokyo = txtKakuninJokyo;
        this.txtFuichiRiyu = txtFuichiRiyu;
        this.txtHosokuM = txtHosokuM;
        this.txtKisoNenkinNo = txtKisoNenkinNo;
        this.txtNenkinCode = txtNenkinCode;
        this.txtTokuchoGimusha = txtTokuchoGimusha;
        this.txtShimeiKana = txtShimeiKana;
        this.txtUmareYMD = txtUmareYMD;
        this.txtSeibetsu = txtSeibetsu;
    }

    public dgTokubetChoshuMidoteiIchiran_Row(DataGridSetting gridSetting) {
        super();
        this.chkKakunin = DataGridColumnCheckBox.createInstance(gridSetting.getColumn("chkKakunin").getCellDetails());
        this.txtKakuninJokyo = RString.EMPTY;
        this.txtFuichiRiyu = RString.EMPTY;
        this.txtHosokuM = new TextBox();
        this.txtKisoNenkinNo = new TextBox();
        this.txtNenkinCode = new TextBox();
        this.txtTokuchoGimusha = new TextBox();
        this.txtShimeiKana = new TextBox();
        this.txtUmareYMD = new TextBoxDate();
        this.txtSeibetsu = new TextBox();
        this.setOriginalData("chkKakunin", chkKakunin);
        this.setOriginalData("txtKakuninJokyo", txtKakuninJokyo);
        this.setOriginalData("txtFuichiRiyu", txtFuichiRiyu);
        this.setOriginalData("txtHosokuM", txtHosokuM);
        this.setOriginalData("txtKisoNenkinNo", txtKisoNenkinNo);
        this.setOriginalData("txtNenkinCode", txtNenkinCode);
        this.setOriginalData("txtTokuchoGimusha", txtTokuchoGimusha);
        this.setOriginalData("txtShimeiKana", txtShimeiKana);
        this.setOriginalData("txtUmareYMD", txtUmareYMD);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
    }

    public DataGridColumnCheckBox getChkKakunin() {
        return chkKakunin;
    }

    public RString getTxtKakuninJokyo() {
        return txtKakuninJokyo;
    }

    public RString getTxtFuichiRiyu() {
        return txtFuichiRiyu;
    }

    public TextBox getTxtHosokuM() {
        return txtHosokuM;
    }

    public TextBox getTxtKisoNenkinNo() {
        return txtKisoNenkinNo;
    }

    public TextBox getTxtNenkinCode() {
        return txtNenkinCode;
    }

    public TextBox getTxtTokuchoGimusha() {
        return txtTokuchoGimusha;
    }

    public TextBox getTxtShimeiKana() {
        return txtShimeiKana;
    }

    public TextBoxDate getTxtUmareYMD() {
        return txtUmareYMD;
    }

    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    public void setChkKakunin(DataGridColumnCheckBox chkKakunin) {
        this.setOriginalData("chkKakunin", chkKakunin);
        this.chkKakunin = chkKakunin;
    }

    public void setTxtKakuninJokyo(RString txtKakuninJokyo) {
        this.setOriginalData("txtKakuninJokyo", txtKakuninJokyo);
        this.txtKakuninJokyo = txtKakuninJokyo;
    }

    public void setTxtFuichiRiyu(RString txtFuichiRiyu) {
        this.setOriginalData("txtFuichiRiyu", txtFuichiRiyu);
        this.txtFuichiRiyu = txtFuichiRiyu;
    }

    public void setTxtHosokuM(TextBox txtHosokuM) {
        this.setOriginalData("txtHosokuM", txtHosokuM);
        this.txtHosokuM = txtHosokuM;
    }

    public void setTxtKisoNenkinNo(TextBox txtKisoNenkinNo) {
        this.setOriginalData("txtKisoNenkinNo", txtKisoNenkinNo);
        this.txtKisoNenkinNo = txtKisoNenkinNo;
    }

    public void setTxtNenkinCode(TextBox txtNenkinCode) {
        this.setOriginalData("txtNenkinCode", txtNenkinCode);
        this.txtNenkinCode = txtNenkinCode;
    }

    public void setTxtTokuchoGimusha(TextBox txtTokuchoGimusha) {
        this.setOriginalData("txtTokuchoGimusha", txtTokuchoGimusha);
        this.txtTokuchoGimusha = txtTokuchoGimusha;
    }

    public void setTxtShimeiKana(TextBox txtShimeiKana) {
        this.setOriginalData("txtShimeiKana", txtShimeiKana);
        this.txtShimeiKana = txtShimeiKana;
    }

    public void setTxtUmareYMD(TextBoxDate txtUmareYMD) {
        this.setOriginalData("txtUmareYMD", txtUmareYMD);
        this.txtUmareYMD = txtUmareYMD;
    }

    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.txtSeibetsu = txtSeibetsu;
    }

    // </editor-fold>
}
