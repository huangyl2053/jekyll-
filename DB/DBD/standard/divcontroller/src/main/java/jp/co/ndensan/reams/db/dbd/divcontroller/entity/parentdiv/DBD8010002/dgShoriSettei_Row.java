package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Aug 20 16:25:40 CST 2016 
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
    private RString hdnSyokiShoriJotai;
    private RString hdnTuki;
    private RString hdnShori;

    public dgShoriSettei_Row() {
        super();
        this.txtTuki = RString.EMPTY;
        this.txtShori = RString.EMPTY;
        this.txtShoriJotai = new DropDownList();
        this.txtShoriNitchiji = RString.EMPTY;
        this.hdnSyokiShoriJotai = RString.EMPTY;
        this.hdnTuki = RString.EMPTY;
        this.hdnShori = RString.EMPTY;
        this.setOriginalData("txtTuki", txtTuki);
        this.setOriginalData("txtShori", txtShori);
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
        this.setOriginalData("hdnSyokiShoriJotai", hdnSyokiShoriJotai);
        this.setOriginalData("hdnTuki", hdnTuki);
        this.setOriginalData("hdnShori", hdnShori);
    }

    public dgShoriSettei_Row(RString txtTuki, RString txtShori, DropDownList txtShoriJotai, RString txtShoriNitchiji, RString hdnSyokiShoriJotai, RString hdnTuki, RString hdnShori) {
        super();
        this.setOriginalData("txtTuki", txtTuki);
        this.setOriginalData("txtShori", txtShori);
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
        this.setOriginalData("hdnSyokiShoriJotai", hdnSyokiShoriJotai);
        this.setOriginalData("hdnTuki", hdnTuki);
        this.setOriginalData("hdnShori", hdnShori);
        this.txtTuki = txtTuki;
        this.txtShori = txtShori;
        this.txtShoriJotai = txtShoriJotai;
        this.txtShoriNitchiji = txtShoriNitchiji;
        this.hdnSyokiShoriJotai = hdnSyokiShoriJotai;
        this.hdnTuki = hdnTuki;
        this.hdnShori = hdnShori;
    }

    public dgShoriSettei_Row(DataGridSetting gridSetting) {
        super();
        this.txtTuki = RString.EMPTY;
        this.txtShori = RString.EMPTY;
        this.txtShoriJotai = DropDownList.createInstance(gridSetting.getColumn("txtShoriJotai").getCellDetails());
        this.txtShoriNitchiji = RString.EMPTY;
        this.hdnSyokiShoriJotai = RString.EMPTY;
        this.hdnTuki = RString.EMPTY;
        this.hdnShori = RString.EMPTY;
        this.setOriginalData("txtTuki", txtTuki);
        this.setOriginalData("txtShori", txtShori);
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
        this.setOriginalData("hdnSyokiShoriJotai", hdnSyokiShoriJotai);
        this.setOriginalData("hdnTuki", hdnTuki);
        this.setOriginalData("hdnShori", hdnShori);
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

    public RString getHdnSyokiShoriJotai() {
        return hdnSyokiShoriJotai;
    }

    public RString getHdnTuki() {
        return hdnTuki;
    }

    public RString getHdnShori() {
        return hdnShori;
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

    public void setHdnSyokiShoriJotai(RString hdnSyokiShoriJotai) {
        this.setOriginalData("hdnSyokiShoriJotai", hdnSyokiShoriJotai);
        this.hdnSyokiShoriJotai = hdnSyokiShoriJotai;
    }

    public void setHdnTuki(RString hdnTuki) {
        this.setOriginalData("hdnTuki", hdnTuki);
        this.hdnTuki = hdnTuki;
    }

    public void setHdnShori(RString hdnShori) {
        this.setOriginalData("hdnShori", hdnShori);
        this.hdnShori = hdnShori;
    }

    // </editor-fold>
}
