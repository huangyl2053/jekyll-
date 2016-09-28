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
 * dgDataSofu_Row のクラスファイル
 *
 * @reamsid_L DBC-2930-010 liuxiaoyu
 */
public class dgDataSofu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtSofuShoriMei;
    private DropDownList txtSofuShoriJokyo;
    private TextBoxDate txtSofuShoribi;
    private RString txtSofuChushutsuKaishiNitiji;
    private RString txtSofuChushutsuShuryoNitiji;
    private RString txtKokanJohoSikibetsuBango;

    public dgDataSofu_Row() {
        super();
        this.txtSofuShoriMei = RString.EMPTY;
        this.txtSofuShoriJokyo = new DropDownList();
        this.txtSofuShoribi = new TextBoxDate();
        this.txtSofuChushutsuKaishiNitiji = RString.EMPTY;
        this.txtSofuChushutsuShuryoNitiji = RString.EMPTY;
        this.txtKokanJohoSikibetsuBango = RString.EMPTY;
        this.setOriginalData("txtSofuShoriMei", txtSofuShoriMei);
        this.setOriginalData("txtSofuShoriJokyo", txtSofuShoriJokyo);
        this.setOriginalData("txtSofuShoribi", txtSofuShoribi);
        this.setOriginalData("txtSofuChushutsuKaishiNitiji", txtSofuChushutsuKaishiNitiji);
        this.setOriginalData("txtSofuChushutsuShuryoNitiji", txtSofuChushutsuShuryoNitiji);
        this.setOriginalData("txtKokanJohoSikibetsuBango", txtKokanJohoSikibetsuBango);
    }

    public dgDataSofu_Row(RString txtSofuShoriMei, DropDownList txtSofuShoriJokyo, TextBoxDate txtSofuShoribi, RString txtSofuChushutsuKaishiNitiji, RString txtSofuChushutsuShuryoNitiji, RString txtKokanJohoSikibetsuBango) {
        super();
        this.setOriginalData("txtSofuShoriMei", txtSofuShoriMei);
        this.setOriginalData("txtSofuShoriJokyo", txtSofuShoriJokyo);
        this.setOriginalData("txtSofuShoribi", txtSofuShoribi);
        this.setOriginalData("txtSofuChushutsuKaishiNitiji", txtSofuChushutsuKaishiNitiji);
        this.setOriginalData("txtSofuChushutsuShuryoNitiji", txtSofuChushutsuShuryoNitiji);
        this.setOriginalData("txtKokanJohoSikibetsuBango", txtKokanJohoSikibetsuBango);
        this.txtSofuShoriMei = txtSofuShoriMei;
        this.txtSofuShoriJokyo = txtSofuShoriJokyo;
        this.txtSofuShoribi = txtSofuShoribi;
        this.txtSofuChushutsuKaishiNitiji = txtSofuChushutsuKaishiNitiji;
        this.txtSofuChushutsuShuryoNitiji = txtSofuChushutsuShuryoNitiji;
        this.txtKokanJohoSikibetsuBango = txtKokanJohoSikibetsuBango;
    }

    public dgDataSofu_Row(DataGridSetting gridSetting) {
        super();
        this.txtSofuShoriMei = RString.EMPTY;
        this.txtSofuShoriJokyo = DropDownList.createInstance(gridSetting.getColumn("txtSofuShoriJokyo").getCellDetails());
        this.txtSofuShoribi = new TextBoxDate();
        this.txtSofuChushutsuKaishiNitiji = RString.EMPTY;
        this.txtSofuChushutsuShuryoNitiji = RString.EMPTY;
        this.txtKokanJohoSikibetsuBango = RString.EMPTY;
        this.setOriginalData("txtSofuShoriMei", txtSofuShoriMei);
        this.setOriginalData("txtSofuShoriJokyo", txtSofuShoriJokyo);
        this.setOriginalData("txtSofuShoribi", txtSofuShoribi);
        this.setOriginalData("txtSofuChushutsuKaishiNitiji", txtSofuChushutsuKaishiNitiji);
        this.setOriginalData("txtSofuChushutsuShuryoNitiji", txtSofuChushutsuShuryoNitiji);
        this.setOriginalData("txtKokanJohoSikibetsuBango", txtKokanJohoSikibetsuBango);
    }

    public RString getTxtSofuShoriMei() {
        return txtSofuShoriMei;
    }

    public DropDownList getTxtSofuShoriJokyo() {
        return txtSofuShoriJokyo;
    }

    public TextBoxDate getTxtSofuShoribi() {
        return txtSofuShoribi;
    }

    public RString getTxtSofuChushutsuKaishiNitiji() {
        return txtSofuChushutsuKaishiNitiji;
    }

    public RString getTxtSofuChushutsuShuryoNitiji() {
        return txtSofuChushutsuShuryoNitiji;
    }

    public RString getTxtKokanJohoSikibetsuBango() {
        return txtKokanJohoSikibetsuBango;
    }

    public void setTxtSofuShoriMei(RString txtSofuShoriMei) {
        this.setOriginalData("txtSofuShoriMei", txtSofuShoriMei);
        this.txtSofuShoriMei = txtSofuShoriMei;
    }

    public void setTxtSofuShoriJokyo(DropDownList txtSofuShoriJokyo) {
        this.setOriginalData("txtSofuShoriJokyo", txtSofuShoriJokyo);
        this.txtSofuShoriJokyo = txtSofuShoriJokyo;
    }

    public void setTxtSofuShoribi(TextBoxDate txtSofuShoribi) {
        this.setOriginalData("txtSofuShoribi", txtSofuShoribi);
        this.txtSofuShoribi = txtSofuShoribi;
    }

    public void setTxtSofuChushutsuKaishiNitiji(RString txtSofuChushutsuKaishiNitiji) {
        this.setOriginalData("txtSofuChushutsuKaishiNitiji", txtSofuChushutsuKaishiNitiji);
        this.txtSofuChushutsuKaishiNitiji = txtSofuChushutsuKaishiNitiji;
    }

    public void setTxtSofuChushutsuShuryoNitiji(RString txtSofuChushutsuShuryoNitiji) {
        this.setOriginalData("txtSofuChushutsuShuryoNitiji", txtSofuChushutsuShuryoNitiji);
        this.txtSofuChushutsuShuryoNitiji = txtSofuChushutsuShuryoNitiji;
    }

    public void setTxtKokanJohoSikibetsuBango(RString txtKokanJohoSikibetsuBango) {
        this.setOriginalData("txtKokanJohoSikibetsuBango", txtKokanJohoSikibetsuBango);
        this.txtKokanJohoSikibetsuBango = txtKokanJohoSikibetsuBango;
    }

    // </editor-fold>
}
