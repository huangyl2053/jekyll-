package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Aug 19 17:31:05 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;


/**
 * dgShoriSettei_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShoriSettei_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtTuki;
    private RString txtShori;
    private DropDownList txtShoriJotai;
    private RString txtShoriNitchiji;
    private RString hdnTukiCode;
    private RString hdnShoriCode;
    private RString hdnNendoNaiRenban;

    public dgShoriSettei_Row() {
        super();
        this.txtTuki = RString.EMPTY;
        this.txtShori = RString.EMPTY;
        this.txtShoriJotai = new DropDownList();
        this.txtShoriNitchiji = RString.EMPTY;
        this.hdnTukiCode = RString.EMPTY;
        this.hdnShoriCode = RString.EMPTY;
        this.hdnNendoNaiRenban = RString.EMPTY;
        this.setOriginalData("txtTuki", txtTuki);
        this.setOriginalData("txtShori", txtShori);
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
        this.setOriginalData("hdnTukiCode", hdnTukiCode);
        this.setOriginalData("hdnShoriCode", hdnShoriCode);
        this.setOriginalData("hdnNendoNaiRenban", hdnNendoNaiRenban);
    }

    public dgShoriSettei_Row(RString txtTuki, RString txtShori, DropDownList txtShoriJotai, RString txtShoriNitchiji, RString hdnTukiCode, RString hdnShoriCode, RString hdnNendoNaiRenban) {
        super();
        this.setOriginalData("txtTuki", txtTuki);
        this.setOriginalData("txtShori", txtShori);
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
        this.setOriginalData("hdnTukiCode", hdnTukiCode);
        this.setOriginalData("hdnShoriCode", hdnShoriCode);
        this.setOriginalData("hdnNendoNaiRenban", hdnNendoNaiRenban);
        this.txtTuki = txtTuki;
        this.txtShori = txtShori;
        this.txtShoriJotai = txtShoriJotai;
        this.txtShoriNitchiji = txtShoriNitchiji;
        this.hdnTukiCode = hdnTukiCode;
        this.hdnShoriCode = hdnShoriCode;
        this.hdnNendoNaiRenban = hdnNendoNaiRenban;
    }

    public dgShoriSettei_Row(DataGridSetting gridSetting) {
        super();
        this.txtTuki = RString.EMPTY;
        this.txtShori = RString.EMPTY;
        this.txtShoriJotai = DropDownList.createInstance(gridSetting.getColumn("txtShoriJotai").getCellDetails());
        this.txtShoriNitchiji = RString.EMPTY;
        this.hdnTukiCode = RString.EMPTY;
        this.hdnShoriCode = RString.EMPTY;
        this.hdnNendoNaiRenban = RString.EMPTY;
        this.setOriginalData("txtTuki", txtTuki);
        this.setOriginalData("txtShori", txtShori);
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
        this.setOriginalData("hdnTukiCode", hdnTukiCode);
        this.setOriginalData("hdnShoriCode", hdnShoriCode);
        this.setOriginalData("hdnNendoNaiRenban", hdnNendoNaiRenban);
    }

    public RString getTxtTuki() {
        return txtTuki;
    }

    public RString getTxtShori() {
        return txtShori;
    }

    public DropDownList getTxtShoriJotai() {
        return txtShoriJotai;
    }

    public RString getTxtShoriNitchiji() {
        return txtShoriNitchiji;
    }

    public RString getHdnTukiCode() {
        return hdnTukiCode;
    }

    public RString getHdnShoriCode() {
        return hdnShoriCode;
    }

    public RString getHdnNendoNaiRenban() {
        return hdnNendoNaiRenban;
    }

    public void setTxtTuki(RString txtTuki) {
        this.setOriginalData("txtTuki", txtTuki);
        this.txtTuki = txtTuki;
    }

    public void setTxtShori(RString txtShori) {
        this.setOriginalData("txtShori", txtShori);
        this.txtShori = txtShori;
    }

    public void setTxtShoriJotai(DropDownList txtShoriJotai) {
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.txtShoriJotai = txtShoriJotai;
    }

    public void setTxtShoriNitchiji(RString txtShoriNitchiji) {
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
        this.txtShoriNitchiji = txtShoriNitchiji;
    }

    public void setHdnTukiCode(RString hdnTukiCode) {
        this.setOriginalData("hdnTukiCode", hdnTukiCode);
        this.hdnTukiCode = hdnTukiCode;
    }

    public void setHdnShoriCode(RString hdnShoriCode) {
        this.setOriginalData("hdnShoriCode", hdnShoriCode);
        this.hdnShoriCode = hdnShoriCode;
    }

    public void setHdnNendoNaiRenban(RString hdnNendoNaiRenban) {
        this.setOriginalData("hdnNendoNaiRenban", hdnNendoNaiRenban);
        this.hdnNendoNaiRenban = hdnNendoNaiRenban;
    }

    // </editor-fold>
}
