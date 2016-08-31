package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;
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
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class tblGendogakuDiv extends TablePanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
    @JsonProperty("celGendogaku03")
    private celGendogaku03AttblGendogaku celGendogaku03;
    @JsonProperty("celGendogaku04")
    private celGendogaku04AttblGendogaku celGendogaku04;
    @JsonProperty("celGendogaku05")
    private celGendogaku05AttblGendogaku celGendogaku05;
    @JsonProperty("celGendogaku06")
    private celGendogaku06AttblGendogaku celGendogaku06;
    @JsonProperty("celGendogaku07")
    private celGendogaku07AttblGendogaku celGendogaku07;
    @JsonProperty("celGendogaku08")
    private celGendogaku08AttblGendogaku celGendogaku08;
    @JsonProperty("celGendogaku11")
    private celGendogaku11AttblGendogaku celGendogaku11;
    @JsonProperty("celGendogaku12")
    private celGendogaku12AttblGendogaku celGendogaku12;
    @JsonProperty("celGendogaku13")
    private celGendogaku13AttblGendogaku celGendogaku13;
    @JsonProperty("celGendogaku14")
    private celGendogaku14AttblGendogaku celGendogaku14;
    @JsonProperty("celGendogaku15")
    private celGendogaku15AttblGendogaku celGendogaku15;
    @JsonProperty("celGendogaku16")
    private celGendogaku16AttblGendogaku celGendogaku16;
    @JsonProperty("celGendogaku17")
    private celGendogaku17AttblGendogaku celGendogaku17;
    @JsonProperty("celGendogaku18")
    private celGendogaku18AttblGendogaku celGendogaku18;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblYokaigo1() {
        return this.celGendogaku01.getLblYokaigo1();
    }

    @JsonIgnore
    public Label getLblYokaigo2() {
        return this.celGendogaku02.getLblYokaigo2();
    }

    @JsonIgnore
    public Label getLblYokaigo3() {
        return this.celGendogaku03.getLblYokaigo3();
    }

    @JsonIgnore
    public Label getLblYokaigo4() {
        return this.celGendogaku04.getLblYokaigo4();
    }

    @JsonIgnore
    public Label getLblYokaigo5() {
        return this.celGendogaku05.getLblYokaigo5();
    }

    @JsonIgnore
    public Label getLblKeikaKaigo() {
        return this.celGendogaku06.getLblKeikaKaigo();
    }

    @JsonIgnore
    public Label getLblYoshien1() {
        return this.celGendogaku07.getLblYoshien1();
    }

    @JsonIgnore
    public Label getLblYoshien2() {
        return this.celGendogaku08.getLblYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo1ShikyuGendogaku() {
        return this.celGendogaku11.getTxtYokaigo1ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo2ShikyuGendogaku() {
        return this.celGendogaku12.getTxtYokaigo2ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo3ShikyuGendogaku() {
        return this.celGendogaku13.getTxtYokaigo3ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo4ShikyuGendogaku() {
        return this.celGendogaku14.getTxtYokaigo4ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo5ShikyuGendogaku() {
        return this.celGendogaku15.getTxtYokaigo5ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikaKaigoShikyuGendogaku() {
        return this.celGendogaku16.getTxtKeikaKaigoShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoshien1ShikyuGendogaku() {
        return this.celGendogaku17.getTxtYoshien1ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoshien2ShikyuGendogaku() {
        return this.celGendogaku18.getTxtYoshien2ShikyuGendogaku();
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
     * getcelGendogaku03
     * @return celGendogaku03
     */
    @JsonProperty("celGendogaku03")
    private celGendogaku03AttblGendogaku getCelGendogaku03() {
        return celGendogaku03;
    }

    /*
     * setcelGendogaku03
     * @param celGendogaku03 celGendogaku03
     */
    @JsonProperty("celGendogaku03")
    private void setCelGendogaku03(celGendogaku03AttblGendogaku celGendogaku03) {
        this.celGendogaku03 = celGendogaku03;
    }

    /*
     * getcelGendogaku04
     * @return celGendogaku04
     */
    @JsonProperty("celGendogaku04")
    private celGendogaku04AttblGendogaku getCelGendogaku04() {
        return celGendogaku04;
    }

    /*
     * setcelGendogaku04
     * @param celGendogaku04 celGendogaku04
     */
    @JsonProperty("celGendogaku04")
    private void setCelGendogaku04(celGendogaku04AttblGendogaku celGendogaku04) {
        this.celGendogaku04 = celGendogaku04;
    }

    /*
     * getcelGendogaku05
     * @return celGendogaku05
     */
    @JsonProperty("celGendogaku05")
    private celGendogaku05AttblGendogaku getCelGendogaku05() {
        return celGendogaku05;
    }

    /*
     * setcelGendogaku05
     * @param celGendogaku05 celGendogaku05
     */
    @JsonProperty("celGendogaku05")
    private void setCelGendogaku05(celGendogaku05AttblGendogaku celGendogaku05) {
        this.celGendogaku05 = celGendogaku05;
    }

    /*
     * getcelGendogaku06
     * @return celGendogaku06
     */
    @JsonProperty("celGendogaku06")
    private celGendogaku06AttblGendogaku getCelGendogaku06() {
        return celGendogaku06;
    }

    /*
     * setcelGendogaku06
     * @param celGendogaku06 celGendogaku06
     */
    @JsonProperty("celGendogaku06")
    private void setCelGendogaku06(celGendogaku06AttblGendogaku celGendogaku06) {
        this.celGendogaku06 = celGendogaku06;
    }

    /*
     * getcelGendogaku07
     * @return celGendogaku07
     */
    @JsonProperty("celGendogaku07")
    private celGendogaku07AttblGendogaku getCelGendogaku07() {
        return celGendogaku07;
    }

    /*
     * setcelGendogaku07
     * @param celGendogaku07 celGendogaku07
     */
    @JsonProperty("celGendogaku07")
    private void setCelGendogaku07(celGendogaku07AttblGendogaku celGendogaku07) {
        this.celGendogaku07 = celGendogaku07;
    }

    /*
     * getcelGendogaku08
     * @return celGendogaku08
     */
    @JsonProperty("celGendogaku08")
    private celGendogaku08AttblGendogaku getCelGendogaku08() {
        return celGendogaku08;
    }

    /*
     * setcelGendogaku08
     * @param celGendogaku08 celGendogaku08
     */
    @JsonProperty("celGendogaku08")
    private void setCelGendogaku08(celGendogaku08AttblGendogaku celGendogaku08) {
        this.celGendogaku08 = celGendogaku08;
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
     * getcelGendogaku15
     * @return celGendogaku15
     */
    @JsonProperty("celGendogaku15")
    private celGendogaku15AttblGendogaku getCelGendogaku15() {
        return celGendogaku15;
    }

    /*
     * setcelGendogaku15
     * @param celGendogaku15 celGendogaku15
     */
    @JsonProperty("celGendogaku15")
    private void setCelGendogaku15(celGendogaku15AttblGendogaku celGendogaku15) {
        this.celGendogaku15 = celGendogaku15;
    }

    /*
     * getcelGendogaku16
     * @return celGendogaku16
     */
    @JsonProperty("celGendogaku16")
    private celGendogaku16AttblGendogaku getCelGendogaku16() {
        return celGendogaku16;
    }

    /*
     * setcelGendogaku16
     * @param celGendogaku16 celGendogaku16
     */
    @JsonProperty("celGendogaku16")
    private void setCelGendogaku16(celGendogaku16AttblGendogaku celGendogaku16) {
        this.celGendogaku16 = celGendogaku16;
    }

    /*
     * getcelGendogaku17
     * @return celGendogaku17
     */
    @JsonProperty("celGendogaku17")
    private celGendogaku17AttblGendogaku getCelGendogaku17() {
        return celGendogaku17;
    }

    /*
     * setcelGendogaku17
     * @param celGendogaku17 celGendogaku17
     */
    @JsonProperty("celGendogaku17")
    private void setCelGendogaku17(celGendogaku17AttblGendogaku celGendogaku17) {
        this.celGendogaku17 = celGendogaku17;
    }

    /*
     * getcelGendogaku18
     * @return celGendogaku18
     */
    @JsonProperty("celGendogaku18")
    private celGendogaku18AttblGendogaku getCelGendogaku18() {
        return celGendogaku18;
    }

    /*
     * setcelGendogaku18
     * @param celGendogaku18 celGendogaku18
     */
    @JsonProperty("celGendogaku18")
    private void setCelGendogaku18(celGendogaku18AttblGendogaku celGendogaku18) {
        this.celGendogaku18 = celGendogaku18;
    }

    // </editor-fold>
}

/**
 * celGendogaku01 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku01AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYokaigo1")
    private Label lblYokaigo1;

    /*
     * getlblYokaigo1
     * @return lblYokaigo1
     */
    @JsonProperty("lblYokaigo1")
    public Label getLblYokaigo1() {
        return lblYokaigo1;
    }

    /*
     * setlblYokaigo1
     * @param lblYokaigo1 lblYokaigo1
     */
    @JsonProperty("lblYokaigo1")
    public void setLblYokaigo1(Label lblYokaigo1) {
        this.lblYokaigo1 = lblYokaigo1;
    }

    // </editor-fold>
}

/**
 * celGendogaku02 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku02AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYokaigo2")
    private Label lblYokaigo2;

    /*
     * getlblYokaigo2
     * @return lblYokaigo2
     */
    @JsonProperty("lblYokaigo2")
    public Label getLblYokaigo2() {
        return lblYokaigo2;
    }

    /*
     * setlblYokaigo2
     * @param lblYokaigo2 lblYokaigo2
     */
    @JsonProperty("lblYokaigo2")
    public void setLblYokaigo2(Label lblYokaigo2) {
        this.lblYokaigo2 = lblYokaigo2;
    }

    // </editor-fold>
}

/**
 * celGendogaku03 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku03AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYokaigo3")
    private Label lblYokaigo3;

    /*
     * getlblYokaigo3
     * @return lblYokaigo3
     */
    @JsonProperty("lblYokaigo3")
    public Label getLblYokaigo3() {
        return lblYokaigo3;
    }

    /*
     * setlblYokaigo3
     * @param lblYokaigo3 lblYokaigo3
     */
    @JsonProperty("lblYokaigo3")
    public void setLblYokaigo3(Label lblYokaigo3) {
        this.lblYokaigo3 = lblYokaigo3;
    }

    // </editor-fold>
}

/**
 * celGendogaku04 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku04AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYokaigo4")
    private Label lblYokaigo4;

    /*
     * getlblYokaigo4
     * @return lblYokaigo4
     */
    @JsonProperty("lblYokaigo4")
    public Label getLblYokaigo4() {
        return lblYokaigo4;
    }

    /*
     * setlblYokaigo4
     * @param lblYokaigo4 lblYokaigo4
     */
    @JsonProperty("lblYokaigo4")
    public void setLblYokaigo4(Label lblYokaigo4) {
        this.lblYokaigo4 = lblYokaigo4;
    }

    // </editor-fold>
}

/**
 * celGendogaku05 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku05AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYokaigo5")
    private Label lblYokaigo5;

    /*
     * getlblYokaigo5
     * @return lblYokaigo5
     */
    @JsonProperty("lblYokaigo5")
    public Label getLblYokaigo5() {
        return lblYokaigo5;
    }

    /*
     * setlblYokaigo5
     * @param lblYokaigo5 lblYokaigo5
     */
    @JsonProperty("lblYokaigo5")
    public void setLblYokaigo5(Label lblYokaigo5) {
        this.lblYokaigo5 = lblYokaigo5;
    }

    // </editor-fold>
}

/**
 * celGendogaku06 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku06AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblKeikaKaigo")
    private Label lblKeikaKaigo;

    /*
     * getlblKeikaKaigo
     * @return lblKeikaKaigo
     */
    @JsonProperty("lblKeikaKaigo")
    public Label getLblKeikaKaigo() {
        return lblKeikaKaigo;
    }

    /*
     * setlblKeikaKaigo
     * @param lblKeikaKaigo lblKeikaKaigo
     */
    @JsonProperty("lblKeikaKaigo")
    public void setLblKeikaKaigo(Label lblKeikaKaigo) {
        this.lblKeikaKaigo = lblKeikaKaigo;
    }

    // </editor-fold>
}

/**
 * celGendogaku07 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku07AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYoshien1")
    private Label lblYoshien1;

    /*
     * getlblYoshien1
     * @return lblYoshien1
     */
    @JsonProperty("lblYoshien1")
    public Label getLblYoshien1() {
        return lblYoshien1;
    }

    /*
     * setlblYoshien1
     * @param lblYoshien1 lblYoshien1
     */
    @JsonProperty("lblYoshien1")
    public void setLblYoshien1(Label lblYoshien1) {
        this.lblYoshien1 = lblYoshien1;
    }

    // </editor-fold>
}

/**
 * celGendogaku08 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku08AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYoshien2")
    private Label lblYoshien2;

    /*
     * getlblYoshien2
     * @return lblYoshien2
     */
    @JsonProperty("lblYoshien2")
    public Label getLblYoshien2() {
        return lblYoshien2;
    }

    /*
     * setlblYoshien2
     * @param lblYoshien2 lblYoshien2
     */
    @JsonProperty("lblYoshien2")
    public void setLblYoshien2(Label lblYoshien2) {
        this.lblYoshien2 = lblYoshien2;
    }

    // </editor-fold>
}

/**
 * celGendogaku11 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku11AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtYokaigo1ShikyuGendogaku")
    private TextBoxNum txtYokaigo1ShikyuGendogaku;

    /*
     * gettxtYokaigo1ShikyuGendogaku
     * @return txtYokaigo1ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo1ShikyuGendogaku")
    public TextBoxNum getTxtYokaigo1ShikyuGendogaku() {
        return txtYokaigo1ShikyuGendogaku;
    }

    /*
     * settxtYokaigo1ShikyuGendogaku
     * @param txtYokaigo1ShikyuGendogaku txtYokaigo1ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo1ShikyuGendogaku")
    public void setTxtYokaigo1ShikyuGendogaku(TextBoxNum txtYokaigo1ShikyuGendogaku) {
        this.txtYokaigo1ShikyuGendogaku = txtYokaigo1ShikyuGendogaku;
    }

    // </editor-fold>
}

/**
 * celGendogaku12 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku12AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtYokaigo2ShikyuGendogaku")
    private TextBoxNum txtYokaigo2ShikyuGendogaku;

    /*
     * gettxtYokaigo2ShikyuGendogaku
     * @return txtYokaigo2ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo2ShikyuGendogaku")
    public TextBoxNum getTxtYokaigo2ShikyuGendogaku() {
        return txtYokaigo2ShikyuGendogaku;
    }

    /*
     * settxtYokaigo2ShikyuGendogaku
     * @param txtYokaigo2ShikyuGendogaku txtYokaigo2ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo2ShikyuGendogaku")
    public void setTxtYokaigo2ShikyuGendogaku(TextBoxNum txtYokaigo2ShikyuGendogaku) {
        this.txtYokaigo2ShikyuGendogaku = txtYokaigo2ShikyuGendogaku;
    }

    // </editor-fold>
}

/**
 * celGendogaku13 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku13AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtYokaigo3ShikyuGendogaku")
    private TextBoxNum txtYokaigo3ShikyuGendogaku;

    /*
     * gettxtYokaigo3ShikyuGendogaku
     * @return txtYokaigo3ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo3ShikyuGendogaku")
    public TextBoxNum getTxtYokaigo3ShikyuGendogaku() {
        return txtYokaigo3ShikyuGendogaku;
    }

    /*
     * settxtYokaigo3ShikyuGendogaku
     * @param txtYokaigo3ShikyuGendogaku txtYokaigo3ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo3ShikyuGendogaku")
    public void setTxtYokaigo3ShikyuGendogaku(TextBoxNum txtYokaigo3ShikyuGendogaku) {
        this.txtYokaigo3ShikyuGendogaku = txtYokaigo3ShikyuGendogaku;
    }

    // </editor-fold>
}

/**
 * celGendogaku14 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku14AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtYokaigo4ShikyuGendogaku")
    private TextBoxNum txtYokaigo4ShikyuGendogaku;

    /*
     * gettxtYokaigo4ShikyuGendogaku
     * @return txtYokaigo4ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo4ShikyuGendogaku")
    public TextBoxNum getTxtYokaigo4ShikyuGendogaku() {
        return txtYokaigo4ShikyuGendogaku;
    }

    /*
     * settxtYokaigo4ShikyuGendogaku
     * @param txtYokaigo4ShikyuGendogaku txtYokaigo4ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo4ShikyuGendogaku")
    public void setTxtYokaigo4ShikyuGendogaku(TextBoxNum txtYokaigo4ShikyuGendogaku) {
        this.txtYokaigo4ShikyuGendogaku = txtYokaigo4ShikyuGendogaku;
    }

    // </editor-fold>
}

/**
 * celGendogaku15 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku15AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtYokaigo5ShikyuGendogaku")
    private TextBoxNum txtYokaigo5ShikyuGendogaku;

    /*
     * gettxtYokaigo5ShikyuGendogaku
     * @return txtYokaigo5ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo5ShikyuGendogaku")
    public TextBoxNum getTxtYokaigo5ShikyuGendogaku() {
        return txtYokaigo5ShikyuGendogaku;
    }

    /*
     * settxtYokaigo5ShikyuGendogaku
     * @param txtYokaigo5ShikyuGendogaku txtYokaigo5ShikyuGendogaku
     */
    @JsonProperty("txtYokaigo5ShikyuGendogaku")
    public void setTxtYokaigo5ShikyuGendogaku(TextBoxNum txtYokaigo5ShikyuGendogaku) {
        this.txtYokaigo5ShikyuGendogaku = txtYokaigo5ShikyuGendogaku;
    }

    // </editor-fold>
}

/**
 * celGendogaku16 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku16AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtKeikaKaigoShikyuGendogaku")
    private TextBoxNum txtKeikaKaigoShikyuGendogaku;

    /*
     * gettxtKeikaKaigoShikyuGendogaku
     * @return txtKeikaKaigoShikyuGendogaku
     */
    @JsonProperty("txtKeikaKaigoShikyuGendogaku")
    public TextBoxNum getTxtKeikaKaigoShikyuGendogaku() {
        return txtKeikaKaigoShikyuGendogaku;
    }

    /*
     * settxtKeikaKaigoShikyuGendogaku
     * @param txtKeikaKaigoShikyuGendogaku txtKeikaKaigoShikyuGendogaku
     */
    @JsonProperty("txtKeikaKaigoShikyuGendogaku")
    public void setTxtKeikaKaigoShikyuGendogaku(TextBoxNum txtKeikaKaigoShikyuGendogaku) {
        this.txtKeikaKaigoShikyuGendogaku = txtKeikaKaigoShikyuGendogaku;
    }

    // </editor-fold>
}

/**
 * celGendogaku17 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku17AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtYoshien1ShikyuGendogaku")
    private TextBoxNum txtYoshien1ShikyuGendogaku;

    /*
     * gettxtYoshien1ShikyuGendogaku
     * @return txtYoshien1ShikyuGendogaku
     */
    @JsonProperty("txtYoshien1ShikyuGendogaku")
    public TextBoxNum getTxtYoshien1ShikyuGendogaku() {
        return txtYoshien1ShikyuGendogaku;
    }

    /*
     * settxtYoshien1ShikyuGendogaku
     * @param txtYoshien1ShikyuGendogaku txtYoshien1ShikyuGendogaku
     */
    @JsonProperty("txtYoshien1ShikyuGendogaku")
    public void setTxtYoshien1ShikyuGendogaku(TextBoxNum txtYoshien1ShikyuGendogaku) {
        this.txtYoshien1ShikyuGendogaku = txtYoshien1ShikyuGendogaku;
    }

    // </editor-fold>
}

/**
 * celGendogaku18 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku18AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtYoshien2ShikyuGendogaku")
    private TextBoxNum txtYoshien2ShikyuGendogaku;

    /*
     * gettxtYoshien2ShikyuGendogaku
     * @return txtYoshien2ShikyuGendogaku
     */
    @JsonProperty("txtYoshien2ShikyuGendogaku")
    public TextBoxNum getTxtYoshien2ShikyuGendogaku() {
        return txtYoshien2ShikyuGendogaku;
    }

    /*
     * settxtYoshien2ShikyuGendogaku
     * @param txtYoshien2ShikyuGendogaku txtYoshien2ShikyuGendogaku
     */
    @JsonProperty("txtYoshien2ShikyuGendogaku")
    public void setTxtYoshien2ShikyuGendogaku(TextBoxNum txtYoshien2ShikyuGendogaku) {
        this.txtYoshien2ShikyuGendogaku = txtYoshien2ShikyuGendogaku;
    }

    // </editor-fold>
}
