package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0030011;
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
 * tblShutsuryokuTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblShutsuryokuTaishoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celShutsuryokuTaishoTitle")
    private celShutsuryokuTaishoTitleAttblShutsuryokuTaisho celShutsuryokuTaishoTitle;
    @JsonProperty("celShukeiHohoTitle")
    private celShukeiHohoTitleAttblShutsuryokuTaisho celShukeiHohoTitle;
    @JsonProperty("celShutsuryokuTaishoAll")
    private celShutsuryokuTaishoAllAttblShutsuryokuTaisho celShutsuryokuTaishoAll;
    @JsonProperty("celShukeiYM0")
    private celShukeiYM0AttblShutsuryokuTaisho celShukeiYM0;
    @JsonProperty("celShukeiType0")
    private celShukeiType0AttblShutsuryokuTaisho celShukeiType0;
    @JsonProperty("celShutsuryokuTaihoIppan1to10")
    private celShutsuryokuTaihoIppan1to10AttblShutsuryokuTaisho celShutsuryokuTaihoIppan1to10;
    @JsonProperty("celShukeiYM1")
    private celShukeiYM1AttblShutsuryokuTaisho celShukeiYM1;
    @JsonProperty("celShukeiType1")
    private celShukeiType1AttblShutsuryokuTaisho celShukeiType1;
    @JsonProperty("celShutsuryokuTaishoGassanIppan")
    private celShutsuryokuTaishoGassanIppanAttblShutsuryokuTaisho celShutsuryokuTaishoGassanIppan;
    @JsonProperty("celShutsuryokuTaishoIppanGembutsu")
    private celShutsuryokuTaishoIppanGembutsuAttblShutsuryokuTaisho celShutsuryokuTaishoIppanGembutsu;
    @JsonProperty("celShukeiYM2")
    private celShukeiYM2AttblShutsuryokuTaisho celShukeiYM2;
    @JsonProperty("celShukeiType2")
    private celShukeiType2AttblShutsuryokuTaisho celShukeiType2;
    @JsonProperty("celShutsuryokuTaishoIppanShokan")
    private celShutsuryokuTaishoIppanShokanAttblShutsuryokuTaisho celShutsuryokuTaishoIppanShokan;
    @JsonProperty("celShukeiYM3")
    private celShukeiYM3AttblShutsuryokuTaisho celShukeiYM3;
    @JsonProperty("celShukeiType3")
    private celShukeiType3AttblShutsuryokuTaisho celShukeiType3;
    @JsonProperty("celShutsuryokuTaishoGassanHoken")
    private celShutsuryokuTaishoGassanHokenAttblShutsuryokuTaisho celShutsuryokuTaishoGassanHoken;
    @JsonProperty("celShutsuryokuTaishoHokenGembutsu")
    private celShutsuryokuTaishoHokenGembutsuAttblShutsuryokuTaisho celShutsuryokuTaishoHokenGembutsu;
    @JsonProperty("celShukeiYM4")
    private celShukeiYM4AttblShutsuryokuTaisho celShukeiYM4;
    @JsonProperty("celShukeiType4")
    private celShukeiType4AttblShutsuryokuTaisho celShukeiType4;
    @JsonProperty("celShutsuryokuTaishoHokenShokan")
    private celShutsuryokuTaishoHokenShokanAttblShutsuryokuTaisho celShutsuryokuTaishoHokenShokan;
    @JsonProperty("celShukeiYM5")
    private celShukeiYM5AttblShutsuryokuTaisho celShukeiYM5;
    @JsonProperty("celShukeiType5")
    private celShukeiType5AttblShutsuryokuTaisho celShukeiType5;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblShutsuryokuTaisho() {
        return this.celShutsuryokuTaishoTitle.getLblShutsuryokuTaisho();
    }

    @JsonIgnore
    public Label getLblShukeiHoho() {
        return this.celShukeiHohoTitle.getLblShukeiHoho();
    }

    @JsonIgnore
    public CheckBoxList getCblShutsuryokuAll() {
        return this.celShutsuryokuTaishoAll.getCblShutsuryokuAll();
    }

    @JsonIgnore
    public CheckBoxList getCblIppan1to10() {
        return this.celShutsuryokuTaihoIppan1to10.getCblIppan1to10();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM1() {
        return this.celShukeiYM1.getTxtShukeiYM1();
    }

    @JsonIgnore
    public Label getLblShukeiType1() {
        return this.celShukeiType1.getLblShukeiType1();
    }

    @JsonIgnore
    public Gassan1Div getGassan1() {
        return this.celShutsuryokuTaishoGassanIppan.getGassan1();
    }

    @JsonIgnore
    public CheckBoxList getCblIppanGembutsu() {
        return this.celShutsuryokuTaishoIppanGembutsu.getCblIppanGembutsu();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM2() {
        return this.celShukeiYM2.getTxtShukeiYM2();
    }

    @JsonIgnore
    public Label getLblShukeiType2() {
        return this.celShukeiType2.getLblShukeiType2();
    }

    @JsonIgnore
    public CheckBoxList getCblIppanShokan() {
        return this.celShutsuryokuTaishoIppanShokan.getCblIppanShokan();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM3() {
        return this.celShukeiYM3.getTxtShukeiYM3();
    }

    @JsonIgnore
    public RadioButton getRadShukeiType3() {
        return this.celShukeiType3.getRadShukeiType3();
    }

    @JsonIgnore
    public Gassan2Div getGassan2() {
        return this.celShutsuryokuTaishoGassanHoken.getGassan2();
    }

    @JsonIgnore
    public CheckBoxList getCblHokenKyufuGembutsu() {
        return this.celShutsuryokuTaishoHokenGembutsu.getCblHokenKyufuGembutsu();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM4() {
        return this.celShukeiYM4.getTxtShukeiYM4();
    }

    @JsonIgnore
    public Label getLblShukeiType4() {
        return this.celShukeiType4.getLblShukeiType4();
    }

    @JsonIgnore
    public CheckBoxList getCblHokenKyufuShokan() {
        return this.celShutsuryokuTaishoHokenShokan.getCblHokenKyufuShokan();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM5() {
        return this.celShukeiYM5.getTxtShukeiYM5();
    }

    @JsonIgnore
    public RadioButton getRadShukeiType5() {
        return this.celShukeiType5.getRadShukeiType5();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelShutsuryokuTaishoTitle
     * @return celShutsuryokuTaishoTitle
     */
    @JsonProperty("celShutsuryokuTaishoTitle")
    private celShutsuryokuTaishoTitleAttblShutsuryokuTaisho getCelShutsuryokuTaishoTitle() {
        return celShutsuryokuTaishoTitle;
    }

    /*
     * setcelShutsuryokuTaishoTitle
     * @param celShutsuryokuTaishoTitle celShutsuryokuTaishoTitle
     */
    @JsonProperty("celShutsuryokuTaishoTitle")
    private void setCelShutsuryokuTaishoTitle(celShutsuryokuTaishoTitleAttblShutsuryokuTaisho celShutsuryokuTaishoTitle) {
        this.celShutsuryokuTaishoTitle = celShutsuryokuTaishoTitle;
    }

    /*
     * getcelShukeiHohoTitle
     * @return celShukeiHohoTitle
     */
    @JsonProperty("celShukeiHohoTitle")
    private celShukeiHohoTitleAttblShutsuryokuTaisho getCelShukeiHohoTitle() {
        return celShukeiHohoTitle;
    }

    /*
     * setcelShukeiHohoTitle
     * @param celShukeiHohoTitle celShukeiHohoTitle
     */
    @JsonProperty("celShukeiHohoTitle")
    private void setCelShukeiHohoTitle(celShukeiHohoTitleAttblShutsuryokuTaisho celShukeiHohoTitle) {
        this.celShukeiHohoTitle = celShukeiHohoTitle;
    }

    /*
     * getcelShutsuryokuTaishoAll
     * @return celShutsuryokuTaishoAll
     */
    @JsonProperty("celShutsuryokuTaishoAll")
    private celShutsuryokuTaishoAllAttblShutsuryokuTaisho getCelShutsuryokuTaishoAll() {
        return celShutsuryokuTaishoAll;
    }

    /*
     * setcelShutsuryokuTaishoAll
     * @param celShutsuryokuTaishoAll celShutsuryokuTaishoAll
     */
    @JsonProperty("celShutsuryokuTaishoAll")
    private void setCelShutsuryokuTaishoAll(celShutsuryokuTaishoAllAttblShutsuryokuTaisho celShutsuryokuTaishoAll) {
        this.celShutsuryokuTaishoAll = celShutsuryokuTaishoAll;
    }

    /*
     * getcelShukeiYM0
     * @return celShukeiYM0
     */
    @JsonProperty("celShukeiYM0")
    private celShukeiYM0AttblShutsuryokuTaisho getCelShukeiYM0() {
        return celShukeiYM0;
    }

    /*
     * setcelShukeiYM0
     * @param celShukeiYM0 celShukeiYM0
     */
    @JsonProperty("celShukeiYM0")
    private void setCelShukeiYM0(celShukeiYM0AttblShutsuryokuTaisho celShukeiYM0) {
        this.celShukeiYM0 = celShukeiYM0;
    }

    /*
     * getcelShukeiType0
     * @return celShukeiType0
     */
    @JsonProperty("celShukeiType0")
    private celShukeiType0AttblShutsuryokuTaisho getCelShukeiType0() {
        return celShukeiType0;
    }

    /*
     * setcelShukeiType0
     * @param celShukeiType0 celShukeiType0
     */
    @JsonProperty("celShukeiType0")
    private void setCelShukeiType0(celShukeiType0AttblShutsuryokuTaisho celShukeiType0) {
        this.celShukeiType0 = celShukeiType0;
    }

    /*
     * getcelShutsuryokuTaihoIppan1to10
     * @return celShutsuryokuTaihoIppan1to10
     */
    @JsonProperty("celShutsuryokuTaihoIppan1to10")
    private celShutsuryokuTaihoIppan1to10AttblShutsuryokuTaisho getCelShutsuryokuTaihoIppan1to10() {
        return celShutsuryokuTaihoIppan1to10;
    }

    /*
     * setcelShutsuryokuTaihoIppan1to10
     * @param celShutsuryokuTaihoIppan1to10 celShutsuryokuTaihoIppan1to10
     */
    @JsonProperty("celShutsuryokuTaihoIppan1to10")
    private void setCelShutsuryokuTaihoIppan1to10(celShutsuryokuTaihoIppan1to10AttblShutsuryokuTaisho celShutsuryokuTaihoIppan1to10) {
        this.celShutsuryokuTaihoIppan1to10 = celShutsuryokuTaihoIppan1to10;
    }

    /*
     * getcelShukeiYM1
     * @return celShukeiYM1
     */
    @JsonProperty("celShukeiYM1")
    private celShukeiYM1AttblShutsuryokuTaisho getCelShukeiYM1() {
        return celShukeiYM1;
    }

    /*
     * setcelShukeiYM1
     * @param celShukeiYM1 celShukeiYM1
     */
    @JsonProperty("celShukeiYM1")
    private void setCelShukeiYM1(celShukeiYM1AttblShutsuryokuTaisho celShukeiYM1) {
        this.celShukeiYM1 = celShukeiYM1;
    }

    /*
     * getcelShukeiType1
     * @return celShukeiType1
     */
    @JsonProperty("celShukeiType1")
    private celShukeiType1AttblShutsuryokuTaisho getCelShukeiType1() {
        return celShukeiType1;
    }

    /*
     * setcelShukeiType1
     * @param celShukeiType1 celShukeiType1
     */
    @JsonProperty("celShukeiType1")
    private void setCelShukeiType1(celShukeiType1AttblShutsuryokuTaisho celShukeiType1) {
        this.celShukeiType1 = celShukeiType1;
    }

    /*
     * getcelShutsuryokuTaishoGassanIppan
     * @return celShutsuryokuTaishoGassanIppan
     */
    @JsonProperty("celShutsuryokuTaishoGassanIppan")
    private celShutsuryokuTaishoGassanIppanAttblShutsuryokuTaisho getCelShutsuryokuTaishoGassanIppan() {
        return celShutsuryokuTaishoGassanIppan;
    }

    /*
     * setcelShutsuryokuTaishoGassanIppan
     * @param celShutsuryokuTaishoGassanIppan celShutsuryokuTaishoGassanIppan
     */
    @JsonProperty("celShutsuryokuTaishoGassanIppan")
    private void setCelShutsuryokuTaishoGassanIppan(celShutsuryokuTaishoGassanIppanAttblShutsuryokuTaisho celShutsuryokuTaishoGassanIppan) {
        this.celShutsuryokuTaishoGassanIppan = celShutsuryokuTaishoGassanIppan;
    }

    /*
     * getcelShutsuryokuTaishoIppanGembutsu
     * @return celShutsuryokuTaishoIppanGembutsu
     */
    @JsonProperty("celShutsuryokuTaishoIppanGembutsu")
    private celShutsuryokuTaishoIppanGembutsuAttblShutsuryokuTaisho getCelShutsuryokuTaishoIppanGembutsu() {
        return celShutsuryokuTaishoIppanGembutsu;
    }

    /*
     * setcelShutsuryokuTaishoIppanGembutsu
     * @param celShutsuryokuTaishoIppanGembutsu celShutsuryokuTaishoIppanGembutsu
     */
    @JsonProperty("celShutsuryokuTaishoIppanGembutsu")
    private void setCelShutsuryokuTaishoIppanGembutsu(celShutsuryokuTaishoIppanGembutsuAttblShutsuryokuTaisho celShutsuryokuTaishoIppanGembutsu) {
        this.celShutsuryokuTaishoIppanGembutsu = celShutsuryokuTaishoIppanGembutsu;
    }

    /*
     * getcelShukeiYM2
     * @return celShukeiYM2
     */
    @JsonProperty("celShukeiYM2")
    private celShukeiYM2AttblShutsuryokuTaisho getCelShukeiYM2() {
        return celShukeiYM2;
    }

    /*
     * setcelShukeiYM2
     * @param celShukeiYM2 celShukeiYM2
     */
    @JsonProperty("celShukeiYM2")
    private void setCelShukeiYM2(celShukeiYM2AttblShutsuryokuTaisho celShukeiYM2) {
        this.celShukeiYM2 = celShukeiYM2;
    }

    /*
     * getcelShukeiType2
     * @return celShukeiType2
     */
    @JsonProperty("celShukeiType2")
    private celShukeiType2AttblShutsuryokuTaisho getCelShukeiType2() {
        return celShukeiType2;
    }

    /*
     * setcelShukeiType2
     * @param celShukeiType2 celShukeiType2
     */
    @JsonProperty("celShukeiType2")
    private void setCelShukeiType2(celShukeiType2AttblShutsuryokuTaisho celShukeiType2) {
        this.celShukeiType2 = celShukeiType2;
    }

    /*
     * getcelShutsuryokuTaishoIppanShokan
     * @return celShutsuryokuTaishoIppanShokan
     */
    @JsonProperty("celShutsuryokuTaishoIppanShokan")
    private celShutsuryokuTaishoIppanShokanAttblShutsuryokuTaisho getCelShutsuryokuTaishoIppanShokan() {
        return celShutsuryokuTaishoIppanShokan;
    }

    /*
     * setcelShutsuryokuTaishoIppanShokan
     * @param celShutsuryokuTaishoIppanShokan celShutsuryokuTaishoIppanShokan
     */
    @JsonProperty("celShutsuryokuTaishoIppanShokan")
    private void setCelShutsuryokuTaishoIppanShokan(celShutsuryokuTaishoIppanShokanAttblShutsuryokuTaisho celShutsuryokuTaishoIppanShokan) {
        this.celShutsuryokuTaishoIppanShokan = celShutsuryokuTaishoIppanShokan;
    }

    /*
     * getcelShukeiYM3
     * @return celShukeiYM3
     */
    @JsonProperty("celShukeiYM3")
    private celShukeiYM3AttblShutsuryokuTaisho getCelShukeiYM3() {
        return celShukeiYM3;
    }

    /*
     * setcelShukeiYM3
     * @param celShukeiYM3 celShukeiYM3
     */
    @JsonProperty("celShukeiYM3")
    private void setCelShukeiYM3(celShukeiYM3AttblShutsuryokuTaisho celShukeiYM3) {
        this.celShukeiYM3 = celShukeiYM3;
    }

    /*
     * getcelShukeiType3
     * @return celShukeiType3
     */
    @JsonProperty("celShukeiType3")
    private celShukeiType3AttblShutsuryokuTaisho getCelShukeiType3() {
        return celShukeiType3;
    }

    /*
     * setcelShukeiType3
     * @param celShukeiType3 celShukeiType3
     */
    @JsonProperty("celShukeiType3")
    private void setCelShukeiType3(celShukeiType3AttblShutsuryokuTaisho celShukeiType3) {
        this.celShukeiType3 = celShukeiType3;
    }

    /*
     * getcelShutsuryokuTaishoGassanHoken
     * @return celShutsuryokuTaishoGassanHoken
     */
    @JsonProperty("celShutsuryokuTaishoGassanHoken")
    private celShutsuryokuTaishoGassanHokenAttblShutsuryokuTaisho getCelShutsuryokuTaishoGassanHoken() {
        return celShutsuryokuTaishoGassanHoken;
    }

    /*
     * setcelShutsuryokuTaishoGassanHoken
     * @param celShutsuryokuTaishoGassanHoken celShutsuryokuTaishoGassanHoken
     */
    @JsonProperty("celShutsuryokuTaishoGassanHoken")
    private void setCelShutsuryokuTaishoGassanHoken(celShutsuryokuTaishoGassanHokenAttblShutsuryokuTaisho celShutsuryokuTaishoGassanHoken) {
        this.celShutsuryokuTaishoGassanHoken = celShutsuryokuTaishoGassanHoken;
    }

    /*
     * getcelShutsuryokuTaishoHokenGembutsu
     * @return celShutsuryokuTaishoHokenGembutsu
     */
    @JsonProperty("celShutsuryokuTaishoHokenGembutsu")
    private celShutsuryokuTaishoHokenGembutsuAttblShutsuryokuTaisho getCelShutsuryokuTaishoHokenGembutsu() {
        return celShutsuryokuTaishoHokenGembutsu;
    }

    /*
     * setcelShutsuryokuTaishoHokenGembutsu
     * @param celShutsuryokuTaishoHokenGembutsu celShutsuryokuTaishoHokenGembutsu
     */
    @JsonProperty("celShutsuryokuTaishoHokenGembutsu")
    private void setCelShutsuryokuTaishoHokenGembutsu(celShutsuryokuTaishoHokenGembutsuAttblShutsuryokuTaisho celShutsuryokuTaishoHokenGembutsu) {
        this.celShutsuryokuTaishoHokenGembutsu = celShutsuryokuTaishoHokenGembutsu;
    }

    /*
     * getcelShukeiYM4
     * @return celShukeiYM4
     */
    @JsonProperty("celShukeiYM4")
    private celShukeiYM4AttblShutsuryokuTaisho getCelShukeiYM4() {
        return celShukeiYM4;
    }

    /*
     * setcelShukeiYM4
     * @param celShukeiYM4 celShukeiYM4
     */
    @JsonProperty("celShukeiYM4")
    private void setCelShukeiYM4(celShukeiYM4AttblShutsuryokuTaisho celShukeiYM4) {
        this.celShukeiYM4 = celShukeiYM4;
    }

    /*
     * getcelShukeiType4
     * @return celShukeiType4
     */
    @JsonProperty("celShukeiType4")
    private celShukeiType4AttblShutsuryokuTaisho getCelShukeiType4() {
        return celShukeiType4;
    }

    /*
     * setcelShukeiType4
     * @param celShukeiType4 celShukeiType4
     */
    @JsonProperty("celShukeiType4")
    private void setCelShukeiType4(celShukeiType4AttblShutsuryokuTaisho celShukeiType4) {
        this.celShukeiType4 = celShukeiType4;
    }

    /*
     * getcelShutsuryokuTaishoHokenShokan
     * @return celShutsuryokuTaishoHokenShokan
     */
    @JsonProperty("celShutsuryokuTaishoHokenShokan")
    private celShutsuryokuTaishoHokenShokanAttblShutsuryokuTaisho getCelShutsuryokuTaishoHokenShokan() {
        return celShutsuryokuTaishoHokenShokan;
    }

    /*
     * setcelShutsuryokuTaishoHokenShokan
     * @param celShutsuryokuTaishoHokenShokan celShutsuryokuTaishoHokenShokan
     */
    @JsonProperty("celShutsuryokuTaishoHokenShokan")
    private void setCelShutsuryokuTaishoHokenShokan(celShutsuryokuTaishoHokenShokanAttblShutsuryokuTaisho celShutsuryokuTaishoHokenShokan) {
        this.celShutsuryokuTaishoHokenShokan = celShutsuryokuTaishoHokenShokan;
    }

    /*
     * getcelShukeiYM5
     * @return celShukeiYM5
     */
    @JsonProperty("celShukeiYM5")
    private celShukeiYM5AttblShutsuryokuTaisho getCelShukeiYM5() {
        return celShukeiYM5;
    }

    /*
     * setcelShukeiYM5
     * @param celShukeiYM5 celShukeiYM5
     */
    @JsonProperty("celShukeiYM5")
    private void setCelShukeiYM5(celShukeiYM5AttblShutsuryokuTaisho celShukeiYM5) {
        this.celShukeiYM5 = celShukeiYM5;
    }

    /*
     * getcelShukeiType5
     * @return celShukeiType5
     */
    @JsonProperty("celShukeiType5")
    private celShukeiType5AttblShutsuryokuTaisho getCelShukeiType5() {
        return celShukeiType5;
    }

    /*
     * setcelShukeiType5
     * @param celShukeiType5 celShukeiType5
     */
    @JsonProperty("celShukeiType5")
    private void setCelShukeiType5(celShukeiType5AttblShutsuryokuTaisho celShukeiType5) {
        this.celShukeiType5 = celShukeiType5;
    }

    // </editor-fold>
}
/**
 * celShutsuryokuTaishoTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutsuryokuTaishoTitleAttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblShutsuryokuTaisho")
    private Label lblShutsuryokuTaisho;

    /*
     * getlblShutsuryokuTaisho
     * @return lblShutsuryokuTaisho
     */
    @JsonProperty("lblShutsuryokuTaisho")
    public Label getLblShutsuryokuTaisho() {
        return lblShutsuryokuTaisho;
    }

    /*
     * setlblShutsuryokuTaisho
     * @param lblShutsuryokuTaisho lblShutsuryokuTaisho
     */
    @JsonProperty("lblShutsuryokuTaisho")
    public void setLblShutsuryokuTaisho(Label lblShutsuryokuTaisho) {
        this.lblShutsuryokuTaisho = lblShutsuryokuTaisho;
    }

    // </editor-fold>
}
/**
 * celShukeiHohoTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiHohoTitleAttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblShukeiHoho")
    private Label lblShukeiHoho;

    /*
     * getlblShukeiHoho
     * @return lblShukeiHoho
     */
    @JsonProperty("lblShukeiHoho")
    public Label getLblShukeiHoho() {
        return lblShukeiHoho;
    }

    /*
     * setlblShukeiHoho
     * @param lblShukeiHoho lblShukeiHoho
     */
    @JsonProperty("lblShukeiHoho")
    public void setLblShukeiHoho(Label lblShukeiHoho) {
        this.lblShukeiHoho = lblShukeiHoho;
    }

    // </editor-fold>
}
/**
 * celShutsuryokuTaishoAll のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutsuryokuTaishoAllAttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("cblShutsuryokuAll")
    private CheckBoxList cblShutsuryokuAll;

    /*
     * getcblShutsuryokuAll
     * @return cblShutsuryokuAll
     */
    @JsonProperty("cblShutsuryokuAll")
    public CheckBoxList getCblShutsuryokuAll() {
        return cblShutsuryokuAll;
    }

    /*
     * setcblShutsuryokuAll
     * @param cblShutsuryokuAll cblShutsuryokuAll
     */
    @JsonProperty("cblShutsuryokuAll")
    public void setCblShutsuryokuAll(CheckBoxList cblShutsuryokuAll) {
        this.cblShutsuryokuAll = cblShutsuryokuAll;
    }

    // </editor-fold>
}
/**
 * celShukeiYM0 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM0AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    // </editor-fold>
}
/**
 * celShukeiType0 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiType0AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    // </editor-fold>
}
/**
 * celShutsuryokuTaihoIppan1to10 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutsuryokuTaihoIppan1to10AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("cblIppan1to10")
    private CheckBoxList cblIppan1to10;

    /*
     * getcblIppan1to10
     * @return cblIppan1to10
     */
    @JsonProperty("cblIppan1to10")
    public CheckBoxList getCblIppan1to10() {
        return cblIppan1to10;
    }

    /*
     * setcblIppan1to10
     * @param cblIppan1to10 cblIppan1to10
     */
    @JsonProperty("cblIppan1to10")
    public void setCblIppan1to10(CheckBoxList cblIppan1to10) {
        this.cblIppan1to10 = cblIppan1to10;
    }

    // </editor-fold>
}
/**
 * celShukeiYM1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM1AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtShukeiYM1")
    private TextBoxFlexibleDate txtShukeiYM1;

    /*
     * gettxtShukeiYM1
     * @return txtShukeiYM1
     */
    @JsonProperty("txtShukeiYM1")
    public TextBoxFlexibleDate getTxtShukeiYM1() {
        return txtShukeiYM1;
    }

    /*
     * settxtShukeiYM1
     * @param txtShukeiYM1 txtShukeiYM1
     */
    @JsonProperty("txtShukeiYM1")
    public void setTxtShukeiYM1(TextBoxFlexibleDate txtShukeiYM1) {
        this.txtShukeiYM1 = txtShukeiYM1;
    }

    // </editor-fold>
}
/**
 * celShukeiType1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiType1AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblShukeiType1")
    private Label lblShukeiType1;

    /*
     * getlblShukeiType1
     * @return lblShukeiType1
     */
    @JsonProperty("lblShukeiType1")
    public Label getLblShukeiType1() {
        return lblShukeiType1;
    }

    /*
     * setlblShukeiType1
     * @param lblShukeiType1 lblShukeiType1
     */
    @JsonProperty("lblShukeiType1")
    public void setLblShukeiType1(Label lblShukeiType1) {
        this.lblShukeiType1 = lblShukeiType1;
    }

    // </editor-fold>
}
/**
 * celShutsuryokuTaishoGassanIppan のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutsuryokuTaishoGassanIppanAttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("Gassan1")
    private Gassan1Div Gassan1;

    /*
     * getGassan1
     * @return Gassan1
     */
    @JsonProperty("Gassan1")
    public Gassan1Div getGassan1() {
        return Gassan1;
    }

    /*
     * setGassan1
     * @param Gassan1 Gassan1
     */
    @JsonProperty("Gassan1")
    public void setGassan1(Gassan1Div Gassan1) {
        this.Gassan1 = Gassan1;
    }

    // </editor-fold>
}
/**
 * celShutsuryokuTaishoIppanGembutsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutsuryokuTaishoIppanGembutsuAttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("cblIppanGembutsu")
    private CheckBoxList cblIppanGembutsu;

    /*
     * getcblIppanGembutsu
     * @return cblIppanGembutsu
     */
    @JsonProperty("cblIppanGembutsu")
    public CheckBoxList getCblIppanGembutsu() {
        return cblIppanGembutsu;
    }

    /*
     * setcblIppanGembutsu
     * @param cblIppanGembutsu cblIppanGembutsu
     */
    @JsonProperty("cblIppanGembutsu")
    public void setCblIppanGembutsu(CheckBoxList cblIppanGembutsu) {
        this.cblIppanGembutsu = cblIppanGembutsu;
    }

    // </editor-fold>
}
/**
 * celShukeiYM2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM2AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtShukeiYM2")
    private TextBoxFlexibleDate txtShukeiYM2;

    /*
     * gettxtShukeiYM2
     * @return txtShukeiYM2
     */
    @JsonProperty("txtShukeiYM2")
    public TextBoxFlexibleDate getTxtShukeiYM2() {
        return txtShukeiYM2;
    }

    /*
     * settxtShukeiYM2
     * @param txtShukeiYM2 txtShukeiYM2
     */
    @JsonProperty("txtShukeiYM2")
    public void setTxtShukeiYM2(TextBoxFlexibleDate txtShukeiYM2) {
        this.txtShukeiYM2 = txtShukeiYM2;
    }

    // </editor-fold>
}
/**
 * celShukeiType2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiType2AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblShukeiType2")
    private Label lblShukeiType2;

    /*
     * getlblShukeiType2
     * @return lblShukeiType2
     */
    @JsonProperty("lblShukeiType2")
    public Label getLblShukeiType2() {
        return lblShukeiType2;
    }

    /*
     * setlblShukeiType2
     * @param lblShukeiType2 lblShukeiType2
     */
    @JsonProperty("lblShukeiType2")
    public void setLblShukeiType2(Label lblShukeiType2) {
        this.lblShukeiType2 = lblShukeiType2;
    }

    // </editor-fold>
}
/**
 * celShutsuryokuTaishoIppanShokan のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutsuryokuTaishoIppanShokanAttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("cblIppanShokan")
    private CheckBoxList cblIppanShokan;

    /*
     * getcblIppanShokan
     * @return cblIppanShokan
     */
    @JsonProperty("cblIppanShokan")
    public CheckBoxList getCblIppanShokan() {
        return cblIppanShokan;
    }

    /*
     * setcblIppanShokan
     * @param cblIppanShokan cblIppanShokan
     */
    @JsonProperty("cblIppanShokan")
    public void setCblIppanShokan(CheckBoxList cblIppanShokan) {
        this.cblIppanShokan = cblIppanShokan;
    }

    // </editor-fold>
}
/**
 * celShukeiYM3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM3AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtShukeiYM3")
    private TextBoxFlexibleDate txtShukeiYM3;

    /*
     * gettxtShukeiYM3
     * @return txtShukeiYM3
     */
    @JsonProperty("txtShukeiYM3")
    public TextBoxFlexibleDate getTxtShukeiYM3() {
        return txtShukeiYM3;
    }

    /*
     * settxtShukeiYM3
     * @param txtShukeiYM3 txtShukeiYM3
     */
    @JsonProperty("txtShukeiYM3")
    public void setTxtShukeiYM3(TextBoxFlexibleDate txtShukeiYM3) {
        this.txtShukeiYM3 = txtShukeiYM3;
    }

    // </editor-fold>
}
/**
 * celShukeiType3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiType3AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("radShukeiType3")
    private RadioButton radShukeiType3;

    /*
     * getradShukeiType3
     * @return radShukeiType3
     */
    @JsonProperty("radShukeiType3")
    public RadioButton getRadShukeiType3() {
        return radShukeiType3;
    }

    /*
     * setradShukeiType3
     * @param radShukeiType3 radShukeiType3
     */
    @JsonProperty("radShukeiType3")
    public void setRadShukeiType3(RadioButton radShukeiType3) {
        this.radShukeiType3 = radShukeiType3;
    }

    // </editor-fold>
}
/**
 * celShutsuryokuTaishoGassanHoken のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutsuryokuTaishoGassanHokenAttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("Gassan2")
    private Gassan2Div Gassan2;

    /*
     * getGassan2
     * @return Gassan2
     */
    @JsonProperty("Gassan2")
    public Gassan2Div getGassan2() {
        return Gassan2;
    }

    /*
     * setGassan2
     * @param Gassan2 Gassan2
     */
    @JsonProperty("Gassan2")
    public void setGassan2(Gassan2Div Gassan2) {
        this.Gassan2 = Gassan2;
    }

    // </editor-fold>
}
/**
 * celShutsuryokuTaishoHokenGembutsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutsuryokuTaishoHokenGembutsuAttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("cblHokenKyufuGembutsu")
    private CheckBoxList cblHokenKyufuGembutsu;

    /*
     * getcblHokenKyufuGembutsu
     * @return cblHokenKyufuGembutsu
     */
    @JsonProperty("cblHokenKyufuGembutsu")
    public CheckBoxList getCblHokenKyufuGembutsu() {
        return cblHokenKyufuGembutsu;
    }

    /*
     * setcblHokenKyufuGembutsu
     * @param cblHokenKyufuGembutsu cblHokenKyufuGembutsu
     */
    @JsonProperty("cblHokenKyufuGembutsu")
    public void setCblHokenKyufuGembutsu(CheckBoxList cblHokenKyufuGembutsu) {
        this.cblHokenKyufuGembutsu = cblHokenKyufuGembutsu;
    }

    // </editor-fold>
}
/**
 * celShukeiYM4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM4AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtShukeiYM4")
    private TextBoxFlexibleDate txtShukeiYM4;

    /*
     * gettxtShukeiYM4
     * @return txtShukeiYM4
     */
    @JsonProperty("txtShukeiYM4")
    public TextBoxFlexibleDate getTxtShukeiYM4() {
        return txtShukeiYM4;
    }

    /*
     * settxtShukeiYM4
     * @param txtShukeiYM4 txtShukeiYM4
     */
    @JsonProperty("txtShukeiYM4")
    public void setTxtShukeiYM4(TextBoxFlexibleDate txtShukeiYM4) {
        this.txtShukeiYM4 = txtShukeiYM4;
    }

    // </editor-fold>
}
/**
 * celShukeiType4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiType4AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("lblShukeiType4")
    private Label lblShukeiType4;

    /*
     * getlblShukeiType4
     * @return lblShukeiType4
     */
    @JsonProperty("lblShukeiType4")
    public Label getLblShukeiType4() {
        return lblShukeiType4;
    }

    /*
     * setlblShukeiType4
     * @param lblShukeiType4 lblShukeiType4
     */
    @JsonProperty("lblShukeiType4")
    public void setLblShukeiType4(Label lblShukeiType4) {
        this.lblShukeiType4 = lblShukeiType4;
    }

    // </editor-fold>
}
/**
 * celShutsuryokuTaishoHokenShokan のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutsuryokuTaishoHokenShokanAttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("cblHokenKyufuShokan")
    private CheckBoxList cblHokenKyufuShokan;

    /*
     * getcblHokenKyufuShokan
     * @return cblHokenKyufuShokan
     */
    @JsonProperty("cblHokenKyufuShokan")
    public CheckBoxList getCblHokenKyufuShokan() {
        return cblHokenKyufuShokan;
    }

    /*
     * setcblHokenKyufuShokan
     * @param cblHokenKyufuShokan cblHokenKyufuShokan
     */
    @JsonProperty("cblHokenKyufuShokan")
    public void setCblHokenKyufuShokan(CheckBoxList cblHokenKyufuShokan) {
        this.cblHokenKyufuShokan = cblHokenKyufuShokan;
    }

    // </editor-fold>
}
/**
 * celShukeiYM5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM5AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("txtShukeiYM5")
    private TextBoxFlexibleDate txtShukeiYM5;

    /*
     * gettxtShukeiYM5
     * @return txtShukeiYM5
     */
    @JsonProperty("txtShukeiYM5")
    public TextBoxFlexibleDate getTxtShukeiYM5() {
        return txtShukeiYM5;
    }

    /*
     * settxtShukeiYM5
     * @param txtShukeiYM5 txtShukeiYM5
     */
    @JsonProperty("txtShukeiYM5")
    public void setTxtShukeiYM5(TextBoxFlexibleDate txtShukeiYM5) {
        this.txtShukeiYM5 = txtShukeiYM5;
    }

    // </editor-fold>
}
/**
 * celShukeiType5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiType5AttblShutsuryokuTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    @JsonProperty("radShukeiType5")
    private RadioButton radShukeiType5;

    /*
     * getradShukeiType5
     * @return radShukeiType5
     */
    @JsonProperty("radShukeiType5")
    public RadioButton getRadShukeiType5() {
        return radShukeiType5;
    }

    /*
     * setradShukeiType5
     * @param radShukeiType5 radShukeiType5
     */
    @JsonProperty("radShukeiType5")
    public void setRadShukeiType5(RadioButton radShukeiType5) {
        this.radShukeiType5 = radShukeiType5;
    }

    // </editor-fold>
}
