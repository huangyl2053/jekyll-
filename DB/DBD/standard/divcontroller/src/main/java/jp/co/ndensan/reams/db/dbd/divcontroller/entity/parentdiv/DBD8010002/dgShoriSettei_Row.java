package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Aug 15 15:30:40 CST 2016 
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

    public dgShoriSettei_Row() {
        super();
        this.txtTuki = RString.EMPTY;
        this.txtShori = RString.EMPTY;
        this.txtShoriJotai = new DropDownList();
        this.txtShoriNitchiji = RString.EMPTY;
        this.setOriginalData("txtTuki", txtTuki);
        this.setOriginalData("txtShori", txtShori);
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
    }

    public dgShoriSettei_Row(RString txtTuki, RString txtShori, DropDownList txtShoriJotai, RString txtShoriNitchiji) {
        super();
        this.setOriginalData("txtTuki", txtTuki);
        this.setOriginalData("txtShori", txtShori);
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
        this.txtTuki = txtTuki;
        this.txtShori = txtShori;
        this.txtShoriJotai = txtShoriJotai;
        this.txtShoriNitchiji = txtShoriNitchiji;
    }

    public dgShoriSettei_Row(DataGridSetting gridSetting) {
        super();
        this.txtTuki = RString.EMPTY;
        this.txtShori = RString.EMPTY;
        this.txtShoriJotai = DropDownList.createInstance(gridSetting.getColumn("txtShoriJotai").getCellDetails());
        this.txtShoriNitchiji = RString.EMPTY;
        this.setOriginalData("txtTuki", txtTuki);
        this.setOriginalData("txtShori", txtShori);
        this.setOriginalData("txtShoriJotai", txtShoriJotai);
        this.setOriginalData("txtShoriNitchiji", txtShoriNitchiji);
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

    // </editor-fold>
}
