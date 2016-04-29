package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Mar 24 18:11:00 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * dgKibetsuJoho_Row のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class dgKibetsuJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString txtTsuki;
    private RString txtKi;
    private RString txtTsukinoKi;
    private DropDownList ddlTsukiShoriKbn;
    private TextBoxFlexibleDate txtNokigen;

    public dgKibetsuJoho_Row() {
        super();
        this.txtTsuki = RString.EMPTY;
        this.txtKi = RString.EMPTY;
        this.txtTsukinoKi = RString.EMPTY;
        this.ddlTsukiShoriKbn = new DropDownList();
        this.txtNokigen = new TextBoxFlexibleDate();
        this.setOriginalData("txtTsuki", txtTsuki);
        this.setOriginalData("txtKi", txtKi);
        this.setOriginalData("txtTsukinoKi", txtTsukinoKi);
        this.setOriginalData("ddlTsukiShoriKbn", ddlTsukiShoriKbn);
        this.setOriginalData("txtNokigen", txtNokigen);
    }

    public dgKibetsuJoho_Row(RString txtTsuki, RString txtKi, RString txtTsukinoKi, DropDownList ddlTsukiShoriKbn, TextBoxFlexibleDate txtNokigen) {
        super();
        this.setOriginalData("txtTsuki", txtTsuki);
        this.setOriginalData("txtKi", txtKi);
        this.setOriginalData("txtTsukinoKi", txtTsukinoKi);
        this.setOriginalData("ddlTsukiShoriKbn", ddlTsukiShoriKbn);
        this.setOriginalData("txtNokigen", txtNokigen);
        this.txtTsuki = txtTsuki;
        this.txtKi = txtKi;
        this.txtTsukinoKi = txtTsukinoKi;
        this.ddlTsukiShoriKbn = ddlTsukiShoriKbn;
        this.txtNokigen = txtNokigen;
    }

    public dgKibetsuJoho_Row(DataGridSetting gridSetting) {
        super();
        this.txtTsuki = RString.EMPTY;
        this.txtKi = RString.EMPTY;
        this.txtTsukinoKi = RString.EMPTY;
        this.ddlTsukiShoriKbn = DropDownList.createInstance(gridSetting.getColumn("ddlTsukiShoriKbn").getCellDetails());
        this.txtNokigen = new TextBoxFlexibleDate();
        this.setOriginalData("txtTsuki", txtTsuki);
        this.setOriginalData("txtKi", txtKi);
        this.setOriginalData("txtTsukinoKi", txtTsukinoKi);
        this.setOriginalData("ddlTsukiShoriKbn", ddlTsukiShoriKbn);
        this.setOriginalData("txtNokigen", txtNokigen);
    }

    public RString getTxtTsuki() {
        return txtTsuki;
    }

    public RString getTxtKi() {
        return txtKi;
    }

    public RString getTxtTsukinoKi() {
        return txtTsukinoKi;
    }

    public DropDownList getDdlTsukiShoriKbn() {
        return ddlTsukiShoriKbn;
    }

    public TextBoxFlexibleDate getTxtNokigen() {
        return txtNokigen;
    }

    public void setTxtTsuki(RString txtTsuki) {
        this.setOriginalData("txtTsuki", txtTsuki);
        this.txtTsuki = txtTsuki;
    }

    public void setTxtKi(RString txtKi) {
        this.setOriginalData("txtKi", txtKi);
        this.txtKi = txtKi;
    }

    public void setTxtTsukinoKi(RString txtTsukinoKi) {
        this.setOriginalData("txtTsukinoKi", txtTsukinoKi);
        this.txtTsukinoKi = txtTsukinoKi;
    }

    public void setDdlTsukiShoriKbn(DropDownList ddlTsukiShoriKbn) {
        this.setOriginalData("ddlTsukiShoriKbn", ddlTsukiShoriKbn);
        this.ddlTsukiShoriKbn = ddlTsukiShoriKbn;
    }

    public void setTxtNokigen(TextBoxFlexibleDate txtNokigen) {
        this.setOriginalData("txtNokigen", txtNokigen);
        this.txtNokigen = txtNokigen;
    }

    // </editor-fold>
}
