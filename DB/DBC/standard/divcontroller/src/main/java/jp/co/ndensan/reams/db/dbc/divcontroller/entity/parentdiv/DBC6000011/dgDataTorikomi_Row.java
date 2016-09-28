package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 18 19:09:06 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgDataTorikomi_Row のクラスファイル
 *
 * @reamsid_L DBC-2930-010 liuxiaoyu
 */
public class dgDataTorikomi_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtTorikomiShorimei;
    private DropDownList txtTorikomiShoriJokyo;
    private TextBoxDate txtTorikomiShoribi;
    private RString txtKokanJohoSikibetsuBango;

    public dgDataTorikomi_Row() {
        super();
        this.txtTorikomiShorimei = RString.EMPTY;
        this.txtTorikomiShoriJokyo = new DropDownList();
        this.txtTorikomiShoribi = new TextBoxDate();
        this.txtKokanJohoSikibetsuBango = RString.EMPTY;
        this.setOriginalData("txtTorikomiShorimei", txtTorikomiShorimei);
        this.setOriginalData("txtTorikomiShoriJokyo", txtTorikomiShoriJokyo);
        this.setOriginalData("txtTorikomiShoribi", txtTorikomiShoribi);
        this.setOriginalData("txtKokanJohoSikibetsuBango", txtKokanJohoSikibetsuBango);
    }

    public dgDataTorikomi_Row(RString txtTorikomiShorimei, DropDownList txtTorikomiShoriJokyo, TextBoxDate txtTorikomiShoribi, RString txtKokanJohoSikibetsuBango) {
        super();
        this.setOriginalData("txtTorikomiShorimei", txtTorikomiShorimei);
        this.setOriginalData("txtTorikomiShoriJokyo", txtTorikomiShoriJokyo);
        this.setOriginalData("txtTorikomiShoribi", txtTorikomiShoribi);
        this.setOriginalData("txtKokanJohoSikibetsuBango", txtKokanJohoSikibetsuBango);
        this.txtTorikomiShorimei = txtTorikomiShorimei;
        this.txtTorikomiShoriJokyo = txtTorikomiShoriJokyo;
        this.txtTorikomiShoribi = txtTorikomiShoribi;
        this.txtKokanJohoSikibetsuBango = txtKokanJohoSikibetsuBango;
    }

    public dgDataTorikomi_Row(DataGridSetting gridSetting) {
        super();
        this.txtTorikomiShorimei = RString.EMPTY;
        this.txtTorikomiShoriJokyo = DropDownList.createInstance(gridSetting.getColumn("txtTorikomiShoriJokyo").getCellDetails());
        this.txtTorikomiShoribi = new TextBoxDate();
        this.txtKokanJohoSikibetsuBango = RString.EMPTY;
        this.setOriginalData("txtTorikomiShorimei", txtTorikomiShorimei);
        this.setOriginalData("txtTorikomiShoriJokyo", txtTorikomiShoriJokyo);
        this.setOriginalData("txtTorikomiShoribi", txtTorikomiShoribi);
        this.setOriginalData("txtKokanJohoSikibetsuBango", txtKokanJohoSikibetsuBango);
    }

    public RString getTxtTorikomiShorimei() {
        return txtTorikomiShorimei;
    }

    public DropDownList getTxtTorikomiShoriJokyo() {
        return txtTorikomiShoriJokyo;
    }

    public TextBoxDate getTxtTorikomiShoribi() {
        return txtTorikomiShoribi;
    }

    public RString getTxtKokanJohoSikibetsuBango() {
        return txtKokanJohoSikibetsuBango;
    }

    public void setTxtTorikomiShorimei(RString txtTorikomiShorimei) {
        this.setOriginalData("txtTorikomiShorimei", txtTorikomiShorimei);
        this.txtTorikomiShorimei = txtTorikomiShorimei;
    }

    public void setTxtTorikomiShoriJokyo(DropDownList txtTorikomiShoriJokyo) {
        this.setOriginalData("txtTorikomiShoriJokyo", txtTorikomiShoriJokyo);
        this.txtTorikomiShoriJokyo = txtTorikomiShoriJokyo;
    }

    public void setTxtTorikomiShoribi(TextBoxDate txtTorikomiShoribi) {
        this.setOriginalData("txtTorikomiShoribi", txtTorikomiShoribi);
        this.txtTorikomiShoribi = txtTorikomiShoribi;
    }

    public void setTxtKokanJohoSikibetsuBango(RString txtKokanJohoSikibetsuBango) {
        this.setOriginalData("txtKokanJohoSikibetsuBango", txtKokanJohoSikibetsuBango);
        this.txtKokanJohoSikibetsuBango = txtKokanJohoSikibetsuBango;
    }

    // </editor-fold>
}
