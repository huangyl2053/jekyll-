package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblGendogaku のクラスファイル
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class tblGendogakuDiv extends TablePanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celGendogaku01")
    private celGendogaku01AttblGendogaku celGendogaku01;
    @JsonProperty("celGendogaku02")
    private celGendogaku02AttblGendogaku celGendogaku02;
    @JsonProperty("celGendogaku11")
    private celGendogaku11AttblGendogaku celGendogaku11;
    @JsonProperty("celGendogaku12")
    private celGendogaku12AttblGendogaku celGendogaku12;
    @JsonProperty("celGendogaku13")
    private celGendogaku13AttblGendogaku celGendogaku13;
    @JsonProperty("celGendogaku14")
    private celGendogaku14AttblGendogaku celGendogaku14;
    @JsonProperty("celGendogaku21")
    private celGendogaku21AttblGendogaku celGendogaku21;
    @JsonProperty("celGendogaku22")
    private celGendogaku22AttblGendogaku celGendogaku22;
    @JsonProperty("celGendogaku23")
    private celGendogaku23AttblGendogaku celGendogaku23;
    @JsonProperty("celGendogaku24")
    private celGendogaku24AttblGendogaku celGendogaku24;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblKyotakuKaigo() {
        return this.celGendogaku01.getLblKyotakuKaigo();
    }

    @JsonIgnore
    public Label getLblKyotakuShien() {
        return this.celGendogaku02.getLblKyotakuShien();
    }

    @JsonIgnore
    public Label getLblKyotakuKaigoFukushiYogu() {
        return this.celGendogaku11.getLblKyotakuKaigoFukushiYogu();
    }

    @JsonIgnore
    public Label getLblKyotakuKaigoJutakuKaishu() {
        return this.celGendogaku12.getLblKyotakuKaigoJutakuKaishu();
    }

    @JsonIgnore
    public Label getLblKyotakuShienFukushiYogu() {
        return this.celGendogaku13.getLblKyotakuShienFukushiYogu();
    }

    @JsonIgnore
    public Label getLblKyotakuShienJutakuKaishu() {
        return this.celGendogaku14.getLblKyotakuShienJutakuKaishu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuKaigoFukushiYogu() {
        return this.celGendogaku21.getTxtKyotakuKaigoFukushiYogu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuKaigoJutakuKaishu() {
        return this.celGendogaku22.getTxtKyotakuKaigoJutakuKaishu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuShienFukushiYogu() {
        return this.celGendogaku23.getTxtKyotakuShienFukushiYogu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuShienJutakuKaishu() {
        return this.celGendogaku24.getTxtKyotakuShienJutakuKaishu();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelGendogaku01
     * @return celGendogaku01
     */
    @JsonProperty("celGendogaku01")
    private celGendogaku01AttblGendogaku getCelGendogaku01() {
        return celGendogaku01;
    }

    /*
     * setcelGendogaku01
     * @param celGendogaku01 celGendogaku01
     */
    @JsonProperty("celGendogaku01")
    private void setCelGendogaku01(celGendogaku01AttblGendogaku celGendogaku01) {
        this.celGendogaku01 = celGendogaku01;
    }

    /*
     * getcelGendogaku02
     * @return celGendogaku02
     */
    @JsonProperty("celGendogaku02")
    private celGendogaku02AttblGendogaku getCelGendogaku02() {
        return celGendogaku02;
    }

    /*
     * setcelGendogaku02
     * @param celGendogaku02 celGendogaku02
     */
    @JsonProperty("celGendogaku02")
    private void setCelGendogaku02(celGendogaku02AttblGendogaku celGendogaku02) {
        this.celGendogaku02 = celGendogaku02;
    }

    /*
     * getcelGendogaku11
     * @return celGendogaku11
     */
    @JsonProperty("celGendogaku11")
    private celGendogaku11AttblGendogaku getCelGendogaku11() {
        return celGendogaku11;
    }

    /*
     * setcelGendogaku11
     * @param celGendogaku11 celGendogaku11
     */
    @JsonProperty("celGendogaku11")
    private void setCelGendogaku11(celGendogaku11AttblGendogaku celGendogaku11) {
        this.celGendogaku11 = celGendogaku11;
    }

    /*
     * getcelGendogaku12
     * @return celGendogaku12
     */
    @JsonProperty("celGendogaku12")
    private celGendogaku12AttblGendogaku getCelGendogaku12() {
        return celGendogaku12;
    }

    /*
     * setcelGendogaku12
     * @param celGendogaku12 celGendogaku12
     */
    @JsonProperty("celGendogaku12")
    private void setCelGendogaku12(celGendogaku12AttblGendogaku celGendogaku12) {
        this.celGendogaku12 = celGendogaku12;
    }

    /*
     * getcelGendogaku13
     * @return celGendogaku13
     */
    @JsonProperty("celGendogaku13")
    private celGendogaku13AttblGendogaku getCelGendogaku13() {
        return celGendogaku13;
    }

    /*
     * setcelGendogaku13
     * @param celGendogaku13 celGendogaku13
     */
    @JsonProperty("celGendogaku13")
    private void setCelGendogaku13(celGendogaku13AttblGendogaku celGendogaku13) {
        this.celGendogaku13 = celGendogaku13;
    }

    /*
     * getcelGendogaku14
     * @return celGendogaku14
     */
    @JsonProperty("celGendogaku14")
    private celGendogaku14AttblGendogaku getCelGendogaku14() {
        return celGendogaku14;
    }

    /*
     * setcelGendogaku14
     * @param celGendogaku14 celGendogaku14
     */
    @JsonProperty("celGendogaku14")
    private void setCelGendogaku14(celGendogaku14AttblGendogaku celGendogaku14) {
        this.celGendogaku14 = celGendogaku14;
    }

    /*
     * getcelGendogaku21
     * @return celGendogaku21
     */
    @JsonProperty("celGendogaku21")
    private celGendogaku21AttblGendogaku getCelGendogaku21() {
        return celGendogaku21;
    }

    /*
     * setcelGendogaku21
     * @param celGendogaku21 celGendogaku21
     */
    @JsonProperty("celGendogaku21")
    private void setCelGendogaku21(celGendogaku21AttblGendogaku celGendogaku21) {
        this.celGendogaku21 = celGendogaku21;
    }

    /*
     * getcelGendogaku22
     * @return celGendogaku22
     */
    @JsonProperty("celGendogaku22")
    private celGendogaku22AttblGendogaku getCelGendogaku22() {
        return celGendogaku22;
    }

    /*
     * setcelGendogaku22
     * @param celGendogaku22 celGendogaku22
     */
    @JsonProperty("celGendogaku22")
    private void setCelGendogaku22(celGendogaku22AttblGendogaku celGendogaku22) {
        this.celGendogaku22 = celGendogaku22;
    }

    /*
     * getcelGendogaku23
     * @return celGendogaku23
     */
    @JsonProperty("celGendogaku23")
    private celGendogaku23AttblGendogaku getCelGendogaku23() {
        return celGendogaku23;
    }

    /*
     * setcelGendogaku23
     * @param celGendogaku23 celGendogaku23
     */
    @JsonProperty("celGendogaku23")
    private void setCelGendogaku23(celGendogaku23AttblGendogaku celGendogaku23) {
        this.celGendogaku23 = celGendogaku23;
    }

    /*
     * getcelGendogaku24
     * @return celGendogaku24
     */
    @JsonProperty("celGendogaku24")
    private celGendogaku24AttblGendogaku getCelGendogaku24() {
        return celGendogaku24;
    }

    /*
     * setcelGendogaku24
     * @param celGendogaku24 celGendogaku24
     */
    @JsonProperty("celGendogaku24")
    private void setCelGendogaku24(celGendogaku24AttblGendogaku celGendogaku24) {
        this.celGendogaku24 = celGendogaku24;
    }

    // </editor-fold>
}

/**
 * celGendogaku01 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku01AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKyotakuKaigo")
    private Label lblKyotakuKaigo;

    /*
     * getlblKyotakuKaigo
     * @return lblKyotakuKaigo
     */
    @JsonProperty("lblKyotakuKaigo")
    public Label getLblKyotakuKaigo() {
        return lblKyotakuKaigo;
    }

    /*
     * setlblKyotakuKaigo
     * @param lblKyotakuKaigo lblKyotakuKaigo
     */
    @JsonProperty("lblKyotakuKaigo")
    public void setLblKyotakuKaigo(Label lblKyotakuKaigo) {
        this.lblKyotakuKaigo = lblKyotakuKaigo;
    }

    // </editor-fold>
}

/**
 * celGendogaku02 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku02AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKyotakuShien")
    private Label lblKyotakuShien;

    /*
     * getlblKyotakuShien
     * @return lblKyotakuShien
     */
    @JsonProperty("lblKyotakuShien")
    public Label getLblKyotakuShien() {
        return lblKyotakuShien;
    }

    /*
     * setlblKyotakuShien
     * @param lblKyotakuShien lblKyotakuShien
     */
    @JsonProperty("lblKyotakuShien")
    public void setLblKyotakuShien(Label lblKyotakuShien) {
        this.lblKyotakuShien = lblKyotakuShien;
    }

    // </editor-fold>
}

/**
 * celGendogaku11 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku11AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKyotakuKaigoFukushiYogu")
    private Label lblKyotakuKaigoFukushiYogu;

    /*
     * getlblKyotakuKaigoFukushiYogu
     * @return lblKyotakuKaigoFukushiYogu
     */
    @JsonProperty("lblKyotakuKaigoFukushiYogu")
    public Label getLblKyotakuKaigoFukushiYogu() {
        return lblKyotakuKaigoFukushiYogu;
    }

    /*
     * setlblKyotakuKaigoFukushiYogu
     * @param lblKyotakuKaigoFukushiYogu lblKyotakuKaigoFukushiYogu
     */
    @JsonProperty("lblKyotakuKaigoFukushiYogu")
    public void setLblKyotakuKaigoFukushiYogu(Label lblKyotakuKaigoFukushiYogu) {
        this.lblKyotakuKaigoFukushiYogu = lblKyotakuKaigoFukushiYogu;
    }

    // </editor-fold>
}

/**
 * celGendogaku12 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku12AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKyotakuKaigoJutakuKaishu")
    private Label lblKyotakuKaigoJutakuKaishu;

    /*
     * getlblKyotakuKaigoJutakuKaishu
     * @return lblKyotakuKaigoJutakuKaishu
     */
    @JsonProperty("lblKyotakuKaigoJutakuKaishu")
    public Label getLblKyotakuKaigoJutakuKaishu() {
        return lblKyotakuKaigoJutakuKaishu;
    }

    /*
     * setlblKyotakuKaigoJutakuKaishu
     * @param lblKyotakuKaigoJutakuKaishu lblKyotakuKaigoJutakuKaishu
     */
    @JsonProperty("lblKyotakuKaigoJutakuKaishu")
    public void setLblKyotakuKaigoJutakuKaishu(Label lblKyotakuKaigoJutakuKaishu) {
        this.lblKyotakuKaigoJutakuKaishu = lblKyotakuKaigoJutakuKaishu;
    }

    // </editor-fold>
}

/**
 * celGendogaku13 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku13AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKyotakuShienFukushiYogu")
    private Label lblKyotakuShienFukushiYogu;

    /*
     * getlblKyotakuShienFukushiYogu
     * @return lblKyotakuShienFukushiYogu
     */
    @JsonProperty("lblKyotakuShienFukushiYogu")
    public Label getLblKyotakuShienFukushiYogu() {
        return lblKyotakuShienFukushiYogu;
    }

    /*
     * setlblKyotakuShienFukushiYogu
     * @param lblKyotakuShienFukushiYogu lblKyotakuShienFukushiYogu
     */
    @JsonProperty("lblKyotakuShienFukushiYogu")
    public void setLblKyotakuShienFukushiYogu(Label lblKyotakuShienFukushiYogu) {
        this.lblKyotakuShienFukushiYogu = lblKyotakuShienFukushiYogu;
    }

    // </editor-fold>
}

/**
 * celGendogaku14 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku14AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKyotakuShienJutakuKaishu")
    private Label lblKyotakuShienJutakuKaishu;

    /*
     * getlblKyotakuShienJutakuKaishu
     * @return lblKyotakuShienJutakuKaishu
     */
    @JsonProperty("lblKyotakuShienJutakuKaishu")
    public Label getLblKyotakuShienJutakuKaishu() {
        return lblKyotakuShienJutakuKaishu;
    }

    /*
     * setlblKyotakuShienJutakuKaishu
     * @param lblKyotakuShienJutakuKaishu lblKyotakuShienJutakuKaishu
     */
    @JsonProperty("lblKyotakuShienJutakuKaishu")
    public void setLblKyotakuShienJutakuKaishu(Label lblKyotakuShienJutakuKaishu) {
        this.lblKyotakuShienJutakuKaishu = lblKyotakuShienJutakuKaishu;
    }

    // </editor-fold>
}

/**
 * celGendogaku21 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku21AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKyotakuKaigoFukushiYogu")
    private TextBoxNum txtKyotakuKaigoFukushiYogu;

    /*
     * gettxtKyotakuKaigoFukushiYogu
     * @return txtKyotakuKaigoFukushiYogu
     */
    @JsonProperty("txtKyotakuKaigoFukushiYogu")
    public TextBoxNum getTxtKyotakuKaigoFukushiYogu() {
        return txtKyotakuKaigoFukushiYogu;
    }

    /*
     * settxtKyotakuKaigoFukushiYogu
     * @param txtKyotakuKaigoFukushiYogu txtKyotakuKaigoFukushiYogu
     */
    @JsonProperty("txtKyotakuKaigoFukushiYogu")
    public void setTxtKyotakuKaigoFukushiYogu(TextBoxNum txtKyotakuKaigoFukushiYogu) {
        this.txtKyotakuKaigoFukushiYogu = txtKyotakuKaigoFukushiYogu;
    }

    // </editor-fold>
}

/**
 * celGendogaku22 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku22AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKyotakuKaigoJutakuKaishu")
    private TextBoxNum txtKyotakuKaigoJutakuKaishu;

    /*
     * gettxtKyotakuKaigoJutakuKaishu
     * @return txtKyotakuKaigoJutakuKaishu
     */
    @JsonProperty("txtKyotakuKaigoJutakuKaishu")
    public TextBoxNum getTxtKyotakuKaigoJutakuKaishu() {
        return txtKyotakuKaigoJutakuKaishu;
    }

    /*
     * settxtKyotakuKaigoJutakuKaishu
     * @param txtKyotakuKaigoJutakuKaishu txtKyotakuKaigoJutakuKaishu
     */
    @JsonProperty("txtKyotakuKaigoJutakuKaishu")
    public void setTxtKyotakuKaigoJutakuKaishu(TextBoxNum txtKyotakuKaigoJutakuKaishu) {
        this.txtKyotakuKaigoJutakuKaishu = txtKyotakuKaigoJutakuKaishu;
    }

    // </editor-fold>
}

/**
 * celGendogaku23 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku23AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKyotakuShienFukushiYogu")
    private TextBoxNum txtKyotakuShienFukushiYogu;

    /*
     * gettxtKyotakuShienFukushiYogu
     * @return txtKyotakuShienFukushiYogu
     */
    @JsonProperty("txtKyotakuShienFukushiYogu")
    public TextBoxNum getTxtKyotakuShienFukushiYogu() {
        return txtKyotakuShienFukushiYogu;
    }

    /*
     * settxtKyotakuShienFukushiYogu
     * @param txtKyotakuShienFukushiYogu txtKyotakuShienFukushiYogu
     */
    @JsonProperty("txtKyotakuShienFukushiYogu")
    public void setTxtKyotakuShienFukushiYogu(TextBoxNum txtKyotakuShienFukushiYogu) {
        this.txtKyotakuShienFukushiYogu = txtKyotakuShienFukushiYogu;
    }

    // </editor-fold>
}

/**
 * celGendogaku24 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku24AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKyotakuShienJutakuKaishu")
    private TextBoxNum txtKyotakuShienJutakuKaishu;

    /*
     * gettxtKyotakuShienJutakuKaishu
     * @return txtKyotakuShienJutakuKaishu
     */
    @JsonProperty("txtKyotakuShienJutakuKaishu")
    public TextBoxNum getTxtKyotakuShienJutakuKaishu() {
        return txtKyotakuShienJutakuKaishu;
    }

    /*
     * settxtKyotakuShienJutakuKaishu
     * @param txtKyotakuShienJutakuKaishu txtKyotakuShienJutakuKaishu
     */
    @JsonProperty("txtKyotakuShienJutakuKaishu")
    public void setTxtKyotakuShienJutakuKaishu(TextBoxNum txtKyotakuShienJutakuKaishu) {
        this.txtKyotakuShienJutakuKaishu = txtKyotakuShienJutakuKaishu;
    }

    // </editor-fold>
}
