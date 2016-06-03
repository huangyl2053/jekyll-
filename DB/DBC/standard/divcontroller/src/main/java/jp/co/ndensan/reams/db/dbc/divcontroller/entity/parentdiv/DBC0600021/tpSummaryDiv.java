package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * tpSummary のクラスファイル
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class tpSummaryDiv extends TablePanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tc11")
    private tc11AttpSummary tc11;
    @JsonProperty("tc12")
    private tc12AttpSummary tc12;
    @JsonProperty("tc13")
    private tc13AttpSummary tc13;
    @JsonProperty("tc14")
    private tc14AttpSummary tc14;
    @JsonProperty("tc15")
    private tc15AttpSummary tc15;
    @JsonProperty("tc21")
    private tc21AttpSummary tc21;
    @JsonProperty("tc22")
    private tc22AttpSummary tc22;
    @JsonProperty("tc23")
    private tc23AttpSummary tc23;
    @JsonProperty("tc24")
    private tc24AttpSummary tc24;
    @JsonProperty("tc25")
    private tc25AttpSummary tc25;
    @JsonProperty("tc26")
    private tc26AttpSummary tc26;
    @JsonProperty("tc31")
    private tc31AttpSummary tc31;
    @JsonProperty("tc32")
    private tc32AttpSummary tc32;
    @JsonProperty("tc33")
    private tc33AttpSummary tc33;
    @JsonProperty("tc34")
    private tc34AttpSummary tc34;
    @JsonProperty("tc35")
    private tc35AttpSummary tc35;
    @JsonProperty("tc36")
    private tc36AttpSummary tc36;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblShukei() {
        return this.tc11.getLblShukei();
    }

    @JsonIgnore
    public Label getLblHiyogakuGokei() {
        return this.tc12.getLblHiyogakuGokei();
    }

    @JsonIgnore
    public Label getLblHokenTaishoHiyogakuGokei() {
        return this.tc13.getLblHokenTaishoHiyogakuGokei();
    }

    @JsonIgnore
    public Label getLblHokenkyufugakuGokei() {
        return this.tc14.getLblHokenkyufugakuGokei();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutangakuGokei() {
        return this.tc15.getLblRiyoshaFutangakuGokei();
    }

    @JsonIgnore
    public Label getLblZenkaimadeshiharaikeka() {
        return this.tc21.getLblZenkaimadeshiharaikeka();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiHiyogakuGokei() {
        return this.tc22.getTxtZenkaiHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiHokenTaishoHiyogakuGokei() {
        return this.tc23.getTxtZenkaiHokenTaishoHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiHokenkyufugakuGokei() {
        return this.tc24.getTxtZenkaiHokenkyufugakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiRiyoshaFutangakuGokei() {
        return this.tc25.getTxtZenkaiRiyoshaFutangakuGokei();
    }

    @JsonIgnore
    public Button getBtnKakoFukushiyogukonyuhiKakutei() {
        return this.tc26.getBtnKakoFukushiyogukonyuhiKakutei();
    }

    @JsonIgnore
    public Label getLblKonkaiShiharaiJyokyo() {
        return this.tc31.getLblKonkaiShiharaiJyokyo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiHiyogakuGokei() {
        return this.tc32.getTxtKonkaiHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiHokenTaishoHiyogakuGokei() {
        return this.tc33.getTxtKonkaiHokenTaishoHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiHokenkyufugakuGokei() {
        return this.tc34.getTxtKonkaiHokenkyufugakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiRiyoshaFutangakuGokei() {
        return this.tc35.getTxtKonkaiRiyoshaFutangakuGokei();
    }

    @JsonIgnore
    public Button getBtnGendogakuCheck() {
        return this.tc36.getBtnGendogakuCheck();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettc11
     * @return tc11
     */
    @JsonProperty("tc11")
    private tc11AttpSummary getTc11() {
        return tc11;
    }

    /*
     * settc11
     * @param tc11 tc11
     */
    @JsonProperty("tc11")
    private void setTc11(tc11AttpSummary tc11) {
        this.tc11 = tc11;
    }

    /*
     * gettc12
     * @return tc12
     */
    @JsonProperty("tc12")
    private tc12AttpSummary getTc12() {
        return tc12;
    }

    /*
     * settc12
     * @param tc12 tc12
     */
    @JsonProperty("tc12")
    private void setTc12(tc12AttpSummary tc12) {
        this.tc12 = tc12;
    }

    /*
     * gettc13
     * @return tc13
     */
    @JsonProperty("tc13")
    private tc13AttpSummary getTc13() {
        return tc13;
    }

    /*
     * settc13
     * @param tc13 tc13
     */
    @JsonProperty("tc13")
    private void setTc13(tc13AttpSummary tc13) {
        this.tc13 = tc13;
    }

    /*
     * gettc14
     * @return tc14
     */
    @JsonProperty("tc14")
    private tc14AttpSummary getTc14() {
        return tc14;
    }

    /*
     * settc14
     * @param tc14 tc14
     */
    @JsonProperty("tc14")
    private void setTc14(tc14AttpSummary tc14) {
        this.tc14 = tc14;
    }

    /*
     * gettc15
     * @return tc15
     */
    @JsonProperty("tc15")
    private tc15AttpSummary getTc15() {
        return tc15;
    }

    /*
     * settc15
     * @param tc15 tc15
     */
    @JsonProperty("tc15")
    private void setTc15(tc15AttpSummary tc15) {
        this.tc15 = tc15;
    }

    /*
     * gettc21
     * @return tc21
     */
    @JsonProperty("tc21")
    private tc21AttpSummary getTc21() {
        return tc21;
    }

    /*
     * settc21
     * @param tc21 tc21
     */
    @JsonProperty("tc21")
    private void setTc21(tc21AttpSummary tc21) {
        this.tc21 = tc21;
    }

    /*
     * gettc22
     * @return tc22
     */
    @JsonProperty("tc22")
    private tc22AttpSummary getTc22() {
        return tc22;
    }

    /*
     * settc22
     * @param tc22 tc22
     */
    @JsonProperty("tc22")
    private void setTc22(tc22AttpSummary tc22) {
        this.tc22 = tc22;
    }

    /*
     * gettc23
     * @return tc23
     */
    @JsonProperty("tc23")
    private tc23AttpSummary getTc23() {
        return tc23;
    }

    /*
     * settc23
     * @param tc23 tc23
     */
    @JsonProperty("tc23")
    private void setTc23(tc23AttpSummary tc23) {
        this.tc23 = tc23;
    }

    /*
     * gettc24
     * @return tc24
     */
    @JsonProperty("tc24")
    private tc24AttpSummary getTc24() {
        return tc24;
    }

    /*
     * settc24
     * @param tc24 tc24
     */
    @JsonProperty("tc24")
    private void setTc24(tc24AttpSummary tc24) {
        this.tc24 = tc24;
    }

    /*
     * gettc25
     * @return tc25
     */
    @JsonProperty("tc25")
    private tc25AttpSummary getTc25() {
        return tc25;
    }

    /*
     * settc25
     * @param tc25 tc25
     */
    @JsonProperty("tc25")
    private void setTc25(tc25AttpSummary tc25) {
        this.tc25 = tc25;
    }

    /*
     * gettc26
     * @return tc26
     */
    @JsonProperty("tc26")
    private tc26AttpSummary getTc26() {
        return tc26;
    }

    /*
     * settc26
     * @param tc26 tc26
     */
    @JsonProperty("tc26")
    private void setTc26(tc26AttpSummary tc26) {
        this.tc26 = tc26;
    }

    /*
     * gettc31
     * @return tc31
     */
    @JsonProperty("tc31")
    private tc31AttpSummary getTc31() {
        return tc31;
    }

    /*
     * settc31
     * @param tc31 tc31
     */
    @JsonProperty("tc31")
    private void setTc31(tc31AttpSummary tc31) {
        this.tc31 = tc31;
    }

    /*
     * gettc32
     * @return tc32
     */
    @JsonProperty("tc32")
    private tc32AttpSummary getTc32() {
        return tc32;
    }

    /*
     * settc32
     * @param tc32 tc32
     */
    @JsonProperty("tc32")
    private void setTc32(tc32AttpSummary tc32) {
        this.tc32 = tc32;
    }

    /*
     * gettc33
     * @return tc33
     */
    @JsonProperty("tc33")
    private tc33AttpSummary getTc33() {
        return tc33;
    }

    /*
     * settc33
     * @param tc33 tc33
     */
    @JsonProperty("tc33")
    private void setTc33(tc33AttpSummary tc33) {
        this.tc33 = tc33;
    }

    /*
     * gettc34
     * @return tc34
     */
    @JsonProperty("tc34")
    private tc34AttpSummary getTc34() {
        return tc34;
    }

    /*
     * settc34
     * @param tc34 tc34
     */
    @JsonProperty("tc34")
    private void setTc34(tc34AttpSummary tc34) {
        this.tc34 = tc34;
    }

    /*
     * gettc35
     * @return tc35
     */
    @JsonProperty("tc35")
    private tc35AttpSummary getTc35() {
        return tc35;
    }

    /*
     * settc35
     * @param tc35 tc35
     */
    @JsonProperty("tc35")
    private void setTc35(tc35AttpSummary tc35) {
        this.tc35 = tc35;
    }

    /*
     * gettc36
     * @return tc36
     */
    @JsonProperty("tc36")
    private tc36AttpSummary getTc36() {
        return tc36;
    }

    /*
     * settc36
     * @param tc36 tc36
     */
    @JsonProperty("tc36")
    private void setTc36(tc36AttpSummary tc36) {
        this.tc36 = tc36;
    }

    // </editor-fold>
}

/**
 * tc11 のクラスファイル
 *
 * @author 自動生成
 */
class tc11AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblShukei")
    private Label lblShukei;

    /*
     * getlblShukei
     * @return lblShukei
     */
    @JsonProperty("lblShukei")
    public Label getLblShukei() {
        return lblShukei;
    }

    /*
     * setlblShukei
     * @param lblShukei lblShukei
     */
    @JsonProperty("lblShukei")
    public void setLblShukei(Label lblShukei) {
        this.lblShukei = lblShukei;
    }

    // </editor-fold>
}

/**
 * tc12 のクラスファイル
 *
 * @author 自動生成
 */
class tc12AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblHiyogakuGokei")
    private Label lblHiyogakuGokei;

    /*
     * getlblHiyogakuGokei
     * @return lblHiyogakuGokei
     */
    @JsonProperty("lblHiyogakuGokei")
    public Label getLblHiyogakuGokei() {
        return lblHiyogakuGokei;
    }

    /*
     * setlblHiyogakuGokei
     * @param lblHiyogakuGokei lblHiyogakuGokei
     */
    @JsonProperty("lblHiyogakuGokei")
    public void setLblHiyogakuGokei(Label lblHiyogakuGokei) {
        this.lblHiyogakuGokei = lblHiyogakuGokei;
    }

    // </editor-fold>
}

/**
 * tc13 のクラスファイル
 *
 * @author 自動生成
 */
class tc13AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblHokenTaishoHiyogakuGokei")
    private Label lblHokenTaishoHiyogakuGokei;

    /*
     * getlblHokenTaishoHiyogakuGokei
     * @return lblHokenTaishoHiyogakuGokei
     */
    @JsonProperty("lblHokenTaishoHiyogakuGokei")
    public Label getLblHokenTaishoHiyogakuGokei() {
        return lblHokenTaishoHiyogakuGokei;
    }

    /*
     * setlblHokenTaishoHiyogakuGokei
     * @param lblHokenTaishoHiyogakuGokei lblHokenTaishoHiyogakuGokei
     */
    @JsonProperty("lblHokenTaishoHiyogakuGokei")
    public void setLblHokenTaishoHiyogakuGokei(Label lblHokenTaishoHiyogakuGokei) {
        this.lblHokenTaishoHiyogakuGokei = lblHokenTaishoHiyogakuGokei;
    }

    // </editor-fold>
}

/**
 * tc14 のクラスファイル
 *
 * @author 自動生成
 */
class tc14AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblHokenkyufugakuGokei")
    private Label lblHokenkyufugakuGokei;

    /*
     * getlblHokenkyufugakuGokei
     * @return lblHokenkyufugakuGokei
     */
    @JsonProperty("lblHokenkyufugakuGokei")
    public Label getLblHokenkyufugakuGokei() {
        return lblHokenkyufugakuGokei;
    }

    /*
     * setlblHokenkyufugakuGokei
     * @param lblHokenkyufugakuGokei lblHokenkyufugakuGokei
     */
    @JsonProperty("lblHokenkyufugakuGokei")
    public void setLblHokenkyufugakuGokei(Label lblHokenkyufugakuGokei) {
        this.lblHokenkyufugakuGokei = lblHokenkyufugakuGokei;
    }

    // </editor-fold>
}

/**
 * tc15 のクラスファイル
 *
 * @author 自動生成
 */
class tc15AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblRiyoshaFutangakuGokei")
    private Label lblRiyoshaFutangakuGokei;

    /*
     * getlblRiyoshaFutangakuGokei
     * @return lblRiyoshaFutangakuGokei
     */
    @JsonProperty("lblRiyoshaFutangakuGokei")
    public Label getLblRiyoshaFutangakuGokei() {
        return lblRiyoshaFutangakuGokei;
    }

    /*
     * setlblRiyoshaFutangakuGokei
     * @param lblRiyoshaFutangakuGokei lblRiyoshaFutangakuGokei
     */
    @JsonProperty("lblRiyoshaFutangakuGokei")
    public void setLblRiyoshaFutangakuGokei(Label lblRiyoshaFutangakuGokei) {
        this.lblRiyoshaFutangakuGokei = lblRiyoshaFutangakuGokei;
    }

    // </editor-fold>
}

/**
 * tc21 のクラスファイル
 *
 * @author 自動生成
 */
class tc21AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblZenkaimadeshiharaikeka")
    private Label lblZenkaimadeshiharaikeka;

    /*
     * getlblZenkaimadeshiharaikeka
     * @return lblZenkaimadeshiharaikeka
     */
    @JsonProperty("lblZenkaimadeshiharaikeka")
    public Label getLblZenkaimadeshiharaikeka() {
        return lblZenkaimadeshiharaikeka;
    }

    /*
     * setlblZenkaimadeshiharaikeka
     * @param lblZenkaimadeshiharaikeka lblZenkaimadeshiharaikeka
     */
    @JsonProperty("lblZenkaimadeshiharaikeka")
    public void setLblZenkaimadeshiharaikeka(Label lblZenkaimadeshiharaikeka) {
        this.lblZenkaimadeshiharaikeka = lblZenkaimadeshiharaikeka;
    }

    // </editor-fold>
}

/**
 * tc22 のクラスファイル
 *
 * @author 自動生成
 */
class tc22AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtZenkaiHiyogakuGokei")
    private TextBoxNum txtZenkaiHiyogakuGokei;

    /*
     * gettxtZenkaiHiyogakuGokei
     * @return txtZenkaiHiyogakuGokei
     */
    @JsonProperty("txtZenkaiHiyogakuGokei")
    public TextBoxNum getTxtZenkaiHiyogakuGokei() {
        return txtZenkaiHiyogakuGokei;
    }

    /*
     * settxtZenkaiHiyogakuGokei
     * @param txtZenkaiHiyogakuGokei txtZenkaiHiyogakuGokei
     */
    @JsonProperty("txtZenkaiHiyogakuGokei")
    public void setTxtZenkaiHiyogakuGokei(TextBoxNum txtZenkaiHiyogakuGokei) {
        this.txtZenkaiHiyogakuGokei = txtZenkaiHiyogakuGokei;
    }

    // </editor-fold>
}

/**
 * tc23 のクラスファイル
 *
 * @author 自動生成
 */
class tc23AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtZenkaiHokenTaishoHiyogakuGokei")
    private TextBoxNum txtZenkaiHokenTaishoHiyogakuGokei;

    /*
     * gettxtZenkaiHokenTaishoHiyogakuGokei
     * @return txtZenkaiHokenTaishoHiyogakuGokei
     */
    @JsonProperty("txtZenkaiHokenTaishoHiyogakuGokei")
    public TextBoxNum getTxtZenkaiHokenTaishoHiyogakuGokei() {
        return txtZenkaiHokenTaishoHiyogakuGokei;
    }

    /*
     * settxtZenkaiHokenTaishoHiyogakuGokei
     * @param txtZenkaiHokenTaishoHiyogakuGokei txtZenkaiHokenTaishoHiyogakuGokei
     */
    @JsonProperty("txtZenkaiHokenTaishoHiyogakuGokei")
    public void setTxtZenkaiHokenTaishoHiyogakuGokei(TextBoxNum txtZenkaiHokenTaishoHiyogakuGokei) {
        this.txtZenkaiHokenTaishoHiyogakuGokei = txtZenkaiHokenTaishoHiyogakuGokei;
    }

    // </editor-fold>
}

/**
 * tc24 のクラスファイル
 *
 * @author 自動生成
 */
class tc24AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtZenkaiHokenkyufugakuGokei")
    private TextBoxNum txtZenkaiHokenkyufugakuGokei;

    /*
     * gettxtZenkaiHokenkyufugakuGokei
     * @return txtZenkaiHokenkyufugakuGokei
     */
    @JsonProperty("txtZenkaiHokenkyufugakuGokei")
    public TextBoxNum getTxtZenkaiHokenkyufugakuGokei() {
        return txtZenkaiHokenkyufugakuGokei;
    }

    /*
     * settxtZenkaiHokenkyufugakuGokei
     * @param txtZenkaiHokenkyufugakuGokei txtZenkaiHokenkyufugakuGokei
     */
    @JsonProperty("txtZenkaiHokenkyufugakuGokei")
    public void setTxtZenkaiHokenkyufugakuGokei(TextBoxNum txtZenkaiHokenkyufugakuGokei) {
        this.txtZenkaiHokenkyufugakuGokei = txtZenkaiHokenkyufugakuGokei;
    }

    // </editor-fold>
}

/**
 * tc25 のクラスファイル
 *
 * @author 自動生成
 */
class tc25AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtZenkaiRiyoshaFutangakuGokei")
    private TextBoxNum txtZenkaiRiyoshaFutangakuGokei;

    /*
     * gettxtZenkaiRiyoshaFutangakuGokei
     * @return txtZenkaiRiyoshaFutangakuGokei
     */
    @JsonProperty("txtZenkaiRiyoshaFutangakuGokei")
    public TextBoxNum getTxtZenkaiRiyoshaFutangakuGokei() {
        return txtZenkaiRiyoshaFutangakuGokei;
    }

    /*
     * settxtZenkaiRiyoshaFutangakuGokei
     * @param txtZenkaiRiyoshaFutangakuGokei txtZenkaiRiyoshaFutangakuGokei
     */
    @JsonProperty("txtZenkaiRiyoshaFutangakuGokei")
    public void setTxtZenkaiRiyoshaFutangakuGokei(TextBoxNum txtZenkaiRiyoshaFutangakuGokei) {
        this.txtZenkaiRiyoshaFutangakuGokei = txtZenkaiRiyoshaFutangakuGokei;
    }

    // </editor-fold>
}

/**
 * tc26 のクラスファイル
 *
 * @author 自動生成
 */
class tc26AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("btnKakoFukushiyogukonyuhiKakutei")
    private Button btnKakoFukushiyogukonyuhiKakutei;

    /*
     * getbtnKakoFukushiyogukonyuhiKakutei
     * @return btnKakoFukushiyogukonyuhiKakutei
     */
    @JsonProperty("btnKakoFukushiyogukonyuhiKakutei")
    public Button getBtnKakoFukushiyogukonyuhiKakutei() {
        return btnKakoFukushiyogukonyuhiKakutei;
    }

    /*
     * setbtnKakoFukushiyogukonyuhiKakutei
     * @param btnKakoFukushiyogukonyuhiKakutei btnKakoFukushiyogukonyuhiKakutei
     */
    @JsonProperty("btnKakoFukushiyogukonyuhiKakutei")
    public void setBtnKakoFukushiyogukonyuhiKakutei(Button btnKakoFukushiyogukonyuhiKakutei) {
        this.btnKakoFukushiyogukonyuhiKakutei = btnKakoFukushiyogukonyuhiKakutei;
    }

    // </editor-fold>
}

/**
 * tc31 のクラスファイル
 *
 * @author 自動生成
 */
class tc31AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblKonkaiShiharaiJyokyo")
    private Label lblKonkaiShiharaiJyokyo;

    /*
     * getlblKonkaiShiharaiJyokyo
     * @return lblKonkaiShiharaiJyokyo
     */
    @JsonProperty("lblKonkaiShiharaiJyokyo")
    public Label getLblKonkaiShiharaiJyokyo() {
        return lblKonkaiShiharaiJyokyo;
    }

    /*
     * setlblKonkaiShiharaiJyokyo
     * @param lblKonkaiShiharaiJyokyo lblKonkaiShiharaiJyokyo
     */
    @JsonProperty("lblKonkaiShiharaiJyokyo")
    public void setLblKonkaiShiharaiJyokyo(Label lblKonkaiShiharaiJyokyo) {
        this.lblKonkaiShiharaiJyokyo = lblKonkaiShiharaiJyokyo;
    }

    // </editor-fold>
}

/**
 * tc32 のクラスファイル
 *
 * @author 自動生成
 */
class tc32AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtKonkaiHiyogakuGokei")
    private TextBoxNum txtKonkaiHiyogakuGokei;

    /*
     * gettxtKonkaiHiyogakuGokei
     * @return txtKonkaiHiyogakuGokei
     */
    @JsonProperty("txtKonkaiHiyogakuGokei")
    public TextBoxNum getTxtKonkaiHiyogakuGokei() {
        return txtKonkaiHiyogakuGokei;
    }

    /*
     * settxtKonkaiHiyogakuGokei
     * @param txtKonkaiHiyogakuGokei txtKonkaiHiyogakuGokei
     */
    @JsonProperty("txtKonkaiHiyogakuGokei")
    public void setTxtKonkaiHiyogakuGokei(TextBoxNum txtKonkaiHiyogakuGokei) {
        this.txtKonkaiHiyogakuGokei = txtKonkaiHiyogakuGokei;
    }

    // </editor-fold>
}

/**
 * tc33 のクラスファイル
 *
 * @author 自動生成
 */
class tc33AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtKonkaiHokenTaishoHiyogakuGokei")
    private TextBoxNum txtKonkaiHokenTaishoHiyogakuGokei;

    /*
     * gettxtKonkaiHokenTaishoHiyogakuGokei
     * @return txtKonkaiHokenTaishoHiyogakuGokei
     */
    @JsonProperty("txtKonkaiHokenTaishoHiyogakuGokei")
    public TextBoxNum getTxtKonkaiHokenTaishoHiyogakuGokei() {
        return txtKonkaiHokenTaishoHiyogakuGokei;
    }

    /*
     * settxtKonkaiHokenTaishoHiyogakuGokei
     * @param txtKonkaiHokenTaishoHiyogakuGokei txtKonkaiHokenTaishoHiyogakuGokei
     */
    @JsonProperty("txtKonkaiHokenTaishoHiyogakuGokei")
    public void setTxtKonkaiHokenTaishoHiyogakuGokei(TextBoxNum txtKonkaiHokenTaishoHiyogakuGokei) {
        this.txtKonkaiHokenTaishoHiyogakuGokei = txtKonkaiHokenTaishoHiyogakuGokei;
    }

    // </editor-fold>
}

/**
 * tc34 のクラスファイル
 *
 * @author 自動生成
 */
class tc34AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtKonkaiHokenkyufugakuGokei")
    private TextBoxNum txtKonkaiHokenkyufugakuGokei;

    /*
     * gettxtKonkaiHokenkyufugakuGokei
     * @return txtKonkaiHokenkyufugakuGokei
     */
    @JsonProperty("txtKonkaiHokenkyufugakuGokei")
    public TextBoxNum getTxtKonkaiHokenkyufugakuGokei() {
        return txtKonkaiHokenkyufugakuGokei;
    }

    /*
     * settxtKonkaiHokenkyufugakuGokei
     * @param txtKonkaiHokenkyufugakuGokei txtKonkaiHokenkyufugakuGokei
     */
    @JsonProperty("txtKonkaiHokenkyufugakuGokei")
    public void setTxtKonkaiHokenkyufugakuGokei(TextBoxNum txtKonkaiHokenkyufugakuGokei) {
        this.txtKonkaiHokenkyufugakuGokei = txtKonkaiHokenkyufugakuGokei;
    }

    // </editor-fold>
}

/**
 * tc35 のクラスファイル
 *
 * @author 自動生成
 */
class tc35AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtKonkaiRiyoshaFutangakuGokei")
    private TextBoxNum txtKonkaiRiyoshaFutangakuGokei;

    /*
     * gettxtKonkaiRiyoshaFutangakuGokei
     * @return txtKonkaiRiyoshaFutangakuGokei
     */
    @JsonProperty("txtKonkaiRiyoshaFutangakuGokei")
    public TextBoxNum getTxtKonkaiRiyoshaFutangakuGokei() {
        return txtKonkaiRiyoshaFutangakuGokei;
    }

    /*
     * settxtKonkaiRiyoshaFutangakuGokei
     * @param txtKonkaiRiyoshaFutangakuGokei txtKonkaiRiyoshaFutangakuGokei
     */
    @JsonProperty("txtKonkaiRiyoshaFutangakuGokei")
    public void setTxtKonkaiRiyoshaFutangakuGokei(TextBoxNum txtKonkaiRiyoshaFutangakuGokei) {
        this.txtKonkaiRiyoshaFutangakuGokei = txtKonkaiRiyoshaFutangakuGokei;
    }

    // </editor-fold>
}

/**
 * tc36 のクラスファイル
 *
 * @author 自動生成
 */
class tc36AttpSummary extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("btnGendogakuCheck")
    private Button btnGendogakuCheck;

    /*
     * getbtnGendogakuCheck
     * @return btnGendogakuCheck
     */
    @JsonProperty("btnGendogakuCheck")
    public Button getBtnGendogakuCheck() {
        return btnGendogakuCheck;
    }

    /*
     * setbtnGendogakuCheck
     * @param btnGendogakuCheck btnGendogakuCheck
     */
    @JsonProperty("btnGendogakuCheck")
    public void setBtnGendogakuCheck(Button btnGendogakuCheck) {
        this.btnGendogakuCheck = btnGendogakuCheck;
    }

    // </editor-fold>
}
