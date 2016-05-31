package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 23 10:09:04 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * dgKaNendoKibetsuJoho_Row のクラスファイル
 *
 * @reamsid_L DBB-1770-050 xupeng
 */
public class dgKaNendoKibetsuJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString txtTsuki;
    private RString txtKi;
    private RString txtTsukinoKi;
    private TextBoxFlexibleDate txtHakkoYMD;
    private TextBoxFlexibleDate txtNokigenYMD;
    private TextBoxFlexibleDate txtNokigenStYMD;
    private TextBoxFlexibleDate txtNokigenEtYMD;
    private DropDownList ddlNofushoKata;
    private DropDownList ddlInjiIchi;
    private DropDownList ddlCVSCutInjiIchi;
    private DropDownList ddlCVSRenChoInjiIchi;
    private DropDownList ddlBookStInjiIchi;
    private DropDownList ddlRenchoKbn;
    private DropDownList ddlOutputJoken;
    private DropDownList ddlKozaTaishoshaOutput;
    private DropDownList ddlSaiShutsu;

    public dgKaNendoKibetsuJoho_Row() {
        super();
        this.txtTsuki = RString.EMPTY;
        this.txtKi = RString.EMPTY;
        this.txtTsukinoKi = RString.EMPTY;
        this.txtHakkoYMD = new TextBoxFlexibleDate();
        this.txtNokigenYMD = new TextBoxFlexibleDate();
        this.txtNokigenStYMD = new TextBoxFlexibleDate();
        this.txtNokigenEtYMD = new TextBoxFlexibleDate();
        this.ddlNofushoKata = new DropDownList();
        this.ddlInjiIchi = new DropDownList();
        this.ddlCVSCutInjiIchi = new DropDownList();
        this.ddlCVSRenChoInjiIchi = new DropDownList();
        this.ddlBookStInjiIchi = new DropDownList();
        this.ddlRenchoKbn = new DropDownList();
        this.ddlOutputJoken = new DropDownList();
        this.ddlKozaTaishoshaOutput = new DropDownList();
        this.ddlSaiShutsu = new DropDownList();
        this.setOriginalData("txtTsuki", txtTsuki);
        this.setOriginalData("txtKi", txtKi);
        this.setOriginalData("txtTsukinoKi", txtTsukinoKi);
        this.setOriginalData("txtHakkoYMD", txtHakkoYMD);
        this.setOriginalData("txtNokigenYMD", txtNokigenYMD);
        this.setOriginalData("txtNokigenStYMD", txtNokigenStYMD);
        this.setOriginalData("txtNokigenEtYMD", txtNokigenEtYMD);
        this.setOriginalData("ddlNofushoKata", ddlNofushoKata);
        this.setOriginalData("ddlInjiIchi", ddlInjiIchi);
        this.setOriginalData("ddlCVSCutInjiIchi", ddlCVSCutInjiIchi);
        this.setOriginalData("ddlCVSRenChoInjiIchi", ddlCVSRenChoInjiIchi);
        this.setOriginalData("ddlBookStInjiIchi", ddlBookStInjiIchi);
        this.setOriginalData("ddlRenchoKbn", ddlRenchoKbn);
        this.setOriginalData("ddlOutputJoken", ddlOutputJoken);
        this.setOriginalData("ddlKozaTaishoshaOutput", ddlKozaTaishoshaOutput);
        this.setOriginalData("ddlSaiShutsu", ddlSaiShutsu);
    }

    public dgKaNendoKibetsuJoho_Row(RString txtTsuki, RString txtKi, RString txtTsukinoKi, TextBoxFlexibleDate txtHakkoYMD, TextBoxFlexibleDate txtNokigenYMD, TextBoxFlexibleDate txtNokigenStYMD, TextBoxFlexibleDate txtNokigenEtYMD, DropDownList ddlNofushoKata, DropDownList ddlInjiIchi, DropDownList ddlCVSCutInjiIchi, DropDownList ddlCVSRenChoInjiIchi, DropDownList ddlBookStInjiIchi, DropDownList ddlRenchoKbn, DropDownList ddlOutputJoken, DropDownList ddlKozaTaishoshaOutput, DropDownList ddlSaiShutsu) {
        super();
        this.setOriginalData("txtTsuki", txtTsuki);
        this.setOriginalData("txtKi", txtKi);
        this.setOriginalData("txtTsukinoKi", txtTsukinoKi);
        this.setOriginalData("txtHakkoYMD", txtHakkoYMD);
        this.setOriginalData("txtNokigenYMD", txtNokigenYMD);
        this.setOriginalData("txtNokigenStYMD", txtNokigenStYMD);
        this.setOriginalData("txtNokigenEtYMD", txtNokigenEtYMD);
        this.setOriginalData("ddlNofushoKata", ddlNofushoKata);
        this.setOriginalData("ddlInjiIchi", ddlInjiIchi);
        this.setOriginalData("ddlCVSCutInjiIchi", ddlCVSCutInjiIchi);
        this.setOriginalData("ddlCVSRenChoInjiIchi", ddlCVSRenChoInjiIchi);
        this.setOriginalData("ddlBookStInjiIchi", ddlBookStInjiIchi);
        this.setOriginalData("ddlRenchoKbn", ddlRenchoKbn);
        this.setOriginalData("ddlOutputJoken", ddlOutputJoken);
        this.setOriginalData("ddlKozaTaishoshaOutput", ddlKozaTaishoshaOutput);
        this.setOriginalData("ddlSaiShutsu", ddlSaiShutsu);
        this.txtTsuki = txtTsuki;
        this.txtKi = txtKi;
        this.txtTsukinoKi = txtTsukinoKi;
        this.txtHakkoYMD = txtHakkoYMD;
        this.txtNokigenYMD = txtNokigenYMD;
        this.txtNokigenStYMD = txtNokigenStYMD;
        this.txtNokigenEtYMD = txtNokigenEtYMD;
        this.ddlNofushoKata = ddlNofushoKata;
        this.ddlInjiIchi = ddlInjiIchi;
        this.ddlCVSCutInjiIchi = ddlCVSCutInjiIchi;
        this.ddlCVSRenChoInjiIchi = ddlCVSRenChoInjiIchi;
        this.ddlBookStInjiIchi = ddlBookStInjiIchi;
        this.ddlRenchoKbn = ddlRenchoKbn;
        this.ddlOutputJoken = ddlOutputJoken;
        this.ddlKozaTaishoshaOutput = ddlKozaTaishoshaOutput;
        this.ddlSaiShutsu = ddlSaiShutsu;
    }

    public dgKaNendoKibetsuJoho_Row(DataGridSetting gridSetting) {
        super();
        this.txtTsuki = RString.EMPTY;
        this.txtKi = RString.EMPTY;
        this.txtTsukinoKi = RString.EMPTY;
        this.txtHakkoYMD = new TextBoxFlexibleDate();
        this.txtNokigenYMD = new TextBoxFlexibleDate();
        this.txtNokigenStYMD = new TextBoxFlexibleDate();
        this.txtNokigenEtYMD = new TextBoxFlexibleDate();
        this.ddlNofushoKata = DropDownList.createInstance(gridSetting.getColumn("ddlNofushoKata").getCellDetails());
        this.ddlInjiIchi = DropDownList.createInstance(gridSetting.getColumn("ddlInjiIchi").getCellDetails());
        this.ddlCVSCutInjiIchi = DropDownList.createInstance(gridSetting.getColumn("ddlCVSCutInjiIchi").getCellDetails());
        this.ddlCVSRenChoInjiIchi = DropDownList.createInstance(gridSetting.getColumn("ddlCVSRenChoInjiIchi").getCellDetails());
        this.ddlBookStInjiIchi = DropDownList.createInstance(gridSetting.getColumn("ddlBookStInjiIchi").getCellDetails());
        this.ddlRenchoKbn = DropDownList.createInstance(gridSetting.getColumn("ddlRenchoKbn").getCellDetails());
        this.ddlOutputJoken = DropDownList.createInstance(gridSetting.getColumn("ddlOutputJoken").getCellDetails());
        this.ddlKozaTaishoshaOutput = DropDownList.createInstance(gridSetting.getColumn("ddlKozaTaishoshaOutput").getCellDetails());
        this.ddlSaiShutsu = DropDownList.createInstance(gridSetting.getColumn("ddlSaiShutsu").getCellDetails());
        this.setOriginalData("txtTsuki", txtTsuki);
        this.setOriginalData("txtKi", txtKi);
        this.setOriginalData("txtTsukinoKi", txtTsukinoKi);
        this.setOriginalData("txtHakkoYMD", txtHakkoYMD);
        this.setOriginalData("txtNokigenYMD", txtNokigenYMD);
        this.setOriginalData("txtNokigenStYMD", txtNokigenStYMD);
        this.setOriginalData("txtNokigenEtYMD", txtNokigenEtYMD);
        this.setOriginalData("ddlNofushoKata", ddlNofushoKata);
        this.setOriginalData("ddlInjiIchi", ddlInjiIchi);
        this.setOriginalData("ddlCVSCutInjiIchi", ddlCVSCutInjiIchi);
        this.setOriginalData("ddlCVSRenChoInjiIchi", ddlCVSRenChoInjiIchi);
        this.setOriginalData("ddlBookStInjiIchi", ddlBookStInjiIchi);
        this.setOriginalData("ddlRenchoKbn", ddlRenchoKbn);
        this.setOriginalData("ddlOutputJoken", ddlOutputJoken);
        this.setOriginalData("ddlKozaTaishoshaOutput", ddlKozaTaishoshaOutput);
        this.setOriginalData("ddlSaiShutsu", ddlSaiShutsu);
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

    public TextBoxFlexibleDate getTxtHakkoYMD() {
        return txtHakkoYMD;
    }

    public TextBoxFlexibleDate getTxtNokigenYMD() {
        return txtNokigenYMD;
    }

    public TextBoxFlexibleDate getTxtNokigenStYMD() {
        return txtNokigenStYMD;
    }

    public TextBoxFlexibleDate getTxtNokigenEtYMD() {
        return txtNokigenEtYMD;
    }

    public DropDownList getDdlNofushoKata() {
        return ddlNofushoKata;
    }

    public DropDownList getDdlInjiIchi() {
        return ddlInjiIchi;
    }

    public DropDownList getDdlCVSCutInjiIchi() {
        return ddlCVSCutInjiIchi;
    }

    public DropDownList getDdlCVSRenChoInjiIchi() {
        return ddlCVSRenChoInjiIchi;
    }

    public DropDownList getDdlBookStInjiIchi() {
        return ddlBookStInjiIchi;
    }

    public DropDownList getDdlRenchoKbn() {
        return ddlRenchoKbn;
    }

    public DropDownList getDdlOutputJoken() {
        return ddlOutputJoken;
    }

    public DropDownList getDdlKozaTaishoshaOutput() {
        return ddlKozaTaishoshaOutput;
    }

    public DropDownList getDdlSaiShutsu() {
        return ddlSaiShutsu;
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

    public void setTxtHakkoYMD(TextBoxFlexibleDate txtHakkoYMD) {
        this.setOriginalData("txtHakkoYMD", txtHakkoYMD);
        this.txtHakkoYMD = txtHakkoYMD;
    }

    public void setTxtNokigenYMD(TextBoxFlexibleDate txtNokigenYMD) {
        this.setOriginalData("txtNokigenYMD", txtNokigenYMD);
        this.txtNokigenYMD = txtNokigenYMD;
    }

    public void setTxtNokigenStYMD(TextBoxFlexibleDate txtNokigenStYMD) {
        this.setOriginalData("txtNokigenStYMD", txtNokigenStYMD);
        this.txtNokigenStYMD = txtNokigenStYMD;
    }

    public void setTxtNokigenEtYMD(TextBoxFlexibleDate txtNokigenEtYMD) {
        this.setOriginalData("txtNokigenEtYMD", txtNokigenEtYMD);
        this.txtNokigenEtYMD = txtNokigenEtYMD;
    }

    public void setDdlNofushoKata(DropDownList ddlNofushoKata) {
        this.setOriginalData("ddlNofushoKata", ddlNofushoKata);
        this.ddlNofushoKata = ddlNofushoKata;
    }

    public void setDdlInjiIchi(DropDownList ddlInjiIchi) {
        this.setOriginalData("ddlInjiIchi", ddlInjiIchi);
        this.ddlInjiIchi = ddlInjiIchi;
    }

    public void setDdlCVSCutInjiIchi(DropDownList ddlCVSCutInjiIchi) {
        this.setOriginalData("ddlCVSCutInjiIchi", ddlCVSCutInjiIchi);
        this.ddlCVSCutInjiIchi = ddlCVSCutInjiIchi;
    }

    public void setDdlCVSRenChoInjiIchi(DropDownList ddlCVSRenChoInjiIchi) {
        this.setOriginalData("ddlCVSRenChoInjiIchi", ddlCVSRenChoInjiIchi);
        this.ddlCVSRenChoInjiIchi = ddlCVSRenChoInjiIchi;
    }

    public void setDdlBookStInjiIchi(DropDownList ddlBookStInjiIchi) {
        this.setOriginalData("ddlBookStInjiIchi", ddlBookStInjiIchi);
        this.ddlBookStInjiIchi = ddlBookStInjiIchi;
    }

    public void setDdlRenchoKbn(DropDownList ddlRenchoKbn) {
        this.setOriginalData("ddlRenchoKbn", ddlRenchoKbn);
        this.ddlRenchoKbn = ddlRenchoKbn;
    }

    public void setDdlOutputJoken(DropDownList ddlOutputJoken) {
        this.setOriginalData("ddlOutputJoken", ddlOutputJoken);
        this.ddlOutputJoken = ddlOutputJoken;
    }

    public void setDdlKozaTaishoshaOutput(DropDownList ddlKozaTaishoshaOutput) {
        this.setOriginalData("ddlKozaTaishoshaOutput", ddlKozaTaishoshaOutput);
        this.ddlKozaTaishoshaOutput = ddlKozaTaishoshaOutput;
    }

    public void setDdlSaiShutsu(DropDownList ddlSaiShutsu) {
        this.setOriginalData("ddlSaiShutsu", ddlSaiShutsu);
        this.ddlSaiShutsu = ddlSaiShutsu;
    }

    // </editor-fold>
}
