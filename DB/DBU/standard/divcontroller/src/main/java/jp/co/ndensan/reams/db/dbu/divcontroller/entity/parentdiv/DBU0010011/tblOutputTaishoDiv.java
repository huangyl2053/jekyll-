package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0010011;
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
 * tblOutputTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblOutputTaishoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celOutputTaishoTitle")
    private celOutputTaishoTitleAttblOutputTaisho celOutputTaishoTitle;
    @JsonProperty("celShukeiHohoTitle")
    private celShukeiHohoTitleAttblOutputTaisho celShukeiHohoTitle;
    @JsonProperty("celSakuseiDateTitle")
    private celSakuseiDateTitleAttblOutputTaisho celSakuseiDateTitle;
    @JsonProperty("celOutputTaishoAllSelect")
    private celOutputTaishoAllSelectAttblOutputTaisho celOutputTaishoAllSelect;
    @JsonProperty("celShukeiYM0")
    private celShukeiYM0AttblOutputTaisho celShukeiYM0;
    @JsonProperty("celShukeiType0")
    private celShukeiType0AttblOutputTaisho celShukeiType0;
    @JsonProperty("celSakuseiDate0")
    private celSakuseiDate0AttblOutputTaisho celSakuseiDate0;
    @JsonProperty("celOutputTaisho1")
    private celOutputTaisho1AttblOutputTaisho celOutputTaisho1;
    @JsonProperty("celShukeiYM1")
    private celShukeiYM1AttblOutputTaisho celShukeiYM1;
    @JsonProperty("celShukeiType1")
    private celShukeiType1AttblOutputTaisho celShukeiType1;
    @JsonProperty("celSakuseiDate1")
    private celSakuseiDate1AttblOutputTaisho celSakuseiDate1;
    @JsonProperty("celOutputTaisho2")
    private celOutputTaisho2AttblOutputTaisho celOutputTaisho2;
    @JsonProperty("celShukeiYM2")
    private celShukeiYM2AttblOutputTaisho celShukeiYM2;
    @JsonProperty("celShukeiType2")
    private celShukeiType2AttblOutputTaisho celShukeiType2;
    @JsonProperty("celSakuseiDate2")
    private celSakuseiDate2AttblOutputTaisho celSakuseiDate2;
    @JsonProperty("celOutputTaisho3")
    private celOutputTaisho3AttblOutputTaisho celOutputTaisho3;
    @JsonProperty("celShukeiYM3")
    private celShukeiYM3AttblOutputTaisho celShukeiYM3;
    @JsonProperty("celShukeiType3")
    private celShukeiType3AttblOutputTaisho celShukeiType3;
    @JsonProperty("celSakuseiDate3")
    private celSakuseiDate3AttblOutputTaisho celSakuseiDate3;
    @JsonProperty("celOutputTaisho4")
    private celOutputTaisho4AttblOutputTaisho celOutputTaisho4;
    @JsonProperty("celShukeiYM4")
    private celShukeiYM4AttblOutputTaisho celShukeiYM4;
    @JsonProperty("celShukeiType4")
    private celShukeiType4AttblOutputTaisho celShukeiType4;
    @JsonProperty("celSakuseiDate4")
    private celSakuseiDate4AttblOutputTaisho celSakuseiDate4;
    @JsonProperty("celOutputTaisho5")
    private celOutputTaisho5AttblOutputTaisho celOutputTaisho5;
    @JsonProperty("celShukeiYM5")
    private celShukeiYM5AttblOutputTaisho celShukeiYM5;
    @JsonProperty("celShukeiType5")
    private celShukeiType5AttblOutputTaisho celShukeiType5;
    @JsonProperty("celSakuseiDate5")
    private celSakuseiDate5AttblOutputTaisho celSakuseiDate5;
    @JsonProperty("celOutputTaisho6")
    private celOutputTaisho6AttblOutputTaisho celOutputTaisho6;
    @JsonProperty("celShukeiYM6")
    private celShukeiYM6AttblOutputTaisho celShukeiYM6;
    @JsonProperty("celShukeiType6")
    private celShukeiType6AttblOutputTaisho celShukeiType6;
    @JsonProperty("celSakuseiDate6")
    private celSakuseiDate6AttblOutputTaisho celSakuseiDate6;
    @JsonProperty("celOutputTaisho7")
    private celOutputTaisho7AttblOutputTaisho celOutputTaisho7;
    @JsonProperty("celShukeiYM7")
    private celShukeiYM7AttblOutputTaisho celShukeiYM7;
    @JsonProperty("celShukeiType7")
    private celShukeiType7AttblOutputTaisho celShukeiType7;
    @JsonProperty("celSakuseiDate7")
    private celSakuseiDate7AttblOutputTaisho celSakuseiDate7;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblOutputTaishoTitle() {
        return this.celOutputTaishoTitle.getLblOutputTaishoTitle();
    }

    @JsonIgnore
    public Label getLblShukeiHohoTitle() {
        return this.celShukeiHohoTitle.getLblShukeiHohoTitle();
    }

    @JsonIgnore
    public Label getLblSakuseiDateTitle() {
        return this.celSakuseiDateTitle.getLblSakuseiDateTitle();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaishoAll() {
        return this.celOutputTaishoAllSelect.getCblOutputTaishoAll();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho1() {
        return this.celOutputTaisho1.getCblOutputTaisho1();
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
    public TextBoxDate getTxtSakuseiYMD1() {
        return this.celSakuseiDate1.getTxtSakuseiYMD1();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime1() {
        return this.celSakuseiDate1.getTxtSakuseiTime1();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho2() {
        return this.celOutputTaisho2.getCblOutputTaisho2();
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
    public TextBoxDate getTxtSakuseiYMD2() {
        return this.celSakuseiDate2.getTxtSakuseiYMD2();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime2() {
        return this.celSakuseiDate2.getTxtSakuseiTime2();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho3() {
        return this.celOutputTaisho3.getCblOutputTaisho3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM3() {
        return this.celShukeiYM3.getTxtShukeiYM3();
    }

    @JsonIgnore
    public Label getLblShukeiType3() {
        return this.celShukeiType3.getLblShukeiType3();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD3() {
        return this.celSakuseiDate3.getTxtSakuseiYMD3();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime3() {
        return this.celSakuseiDate3.getTxtSakuseiTime3();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho4() {
        return this.celOutputTaisho4.getCblOutputTaisho4();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM4() {
        return this.celShukeiYM4.getTxtShukeiYM4();
    }

    @JsonIgnore
    public RadioButton getRadlblShukeiType4() {
        return this.celShukeiType4.getRadlblShukeiType4();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD4() {
        return this.celSakuseiDate4.getTxtSakuseiYMD4();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime4() {
        return this.celSakuseiDate4.getTxtSakuseiTime4();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho5() {
        return this.celOutputTaisho5.getCblOutputTaisho5();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM5() {
        return this.celShukeiYM5.getTxtShukeiYM5();
    }

    @JsonIgnore
    public RadioButton getRadlblShukeiType5() {
        return this.celShukeiType5.getRadlblShukeiType5();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD5() {
        return this.celSakuseiDate5.getTxtSakuseiYMD5();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime5() {
        return this.celSakuseiDate5.getTxtSakuseiTime5();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho6() {
        return this.celOutputTaisho6.getCblOutputTaisho6();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM6() {
        return this.celShukeiYM6.getTxtShukeiYM6();
    }

    @JsonIgnore
    public Label getLblShukeiType6() {
        return this.celShukeiType6.getLblShukeiType6();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD6() {
        return this.celSakuseiDate6.getTxtSakuseiYMD6();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime6() {
        return this.celSakuseiDate6.getTxtSakuseiTime6();
    }

    @JsonIgnore
    public CheckBoxList getCblOutputTaisho7() {
        return this.celOutputTaisho7.getCblOutputTaisho7();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM7() {
        return this.celShukeiYM7.getTxtShukeiYM7();
    }

    @JsonIgnore
    public Label getLblShukeiType7() {
        return this.celShukeiType7.getLblShukeiType7();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD7() {
        return this.celSakuseiDate7.getTxtSakuseiYMD7();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime7() {
        return this.celSakuseiDate7.getTxtSakuseiTime7();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelOutputTaishoTitle
     * @return celOutputTaishoTitle
     */
    @JsonProperty("celOutputTaishoTitle")
    private celOutputTaishoTitleAttblOutputTaisho getCelOutputTaishoTitle() {
        return celOutputTaishoTitle;
    }

    /*
     * setcelOutputTaishoTitle
     * @param celOutputTaishoTitle celOutputTaishoTitle
     */
    @JsonProperty("celOutputTaishoTitle")
    private void setCelOutputTaishoTitle(celOutputTaishoTitleAttblOutputTaisho celOutputTaishoTitle) {
        this.celOutputTaishoTitle = celOutputTaishoTitle;
    }

    /*
     * getcelShukeiHohoTitle
     * @return celShukeiHohoTitle
     */
    @JsonProperty("celShukeiHohoTitle")
    private celShukeiHohoTitleAttblOutputTaisho getCelShukeiHohoTitle() {
        return celShukeiHohoTitle;
    }

    /*
     * setcelShukeiHohoTitle
     * @param celShukeiHohoTitle celShukeiHohoTitle
     */
    @JsonProperty("celShukeiHohoTitle")
    private void setCelShukeiHohoTitle(celShukeiHohoTitleAttblOutputTaisho celShukeiHohoTitle) {
        this.celShukeiHohoTitle = celShukeiHohoTitle;
    }

    /*
     * getcelSakuseiDateTitle
     * @return celSakuseiDateTitle
     */
    @JsonProperty("celSakuseiDateTitle")
    private celSakuseiDateTitleAttblOutputTaisho getCelSakuseiDateTitle() {
        return celSakuseiDateTitle;
    }

    /*
     * setcelSakuseiDateTitle
     * @param celSakuseiDateTitle celSakuseiDateTitle
     */
    @JsonProperty("celSakuseiDateTitle")
    private void setCelSakuseiDateTitle(celSakuseiDateTitleAttblOutputTaisho celSakuseiDateTitle) {
        this.celSakuseiDateTitle = celSakuseiDateTitle;
    }

    /*
     * getcelOutputTaishoAllSelect
     * @return celOutputTaishoAllSelect
     */
    @JsonProperty("celOutputTaishoAllSelect")
    private celOutputTaishoAllSelectAttblOutputTaisho getCelOutputTaishoAllSelect() {
        return celOutputTaishoAllSelect;
    }

    /*
     * setcelOutputTaishoAllSelect
     * @param celOutputTaishoAllSelect celOutputTaishoAllSelect
     */
    @JsonProperty("celOutputTaishoAllSelect")
    private void setCelOutputTaishoAllSelect(celOutputTaishoAllSelectAttblOutputTaisho celOutputTaishoAllSelect) {
        this.celOutputTaishoAllSelect = celOutputTaishoAllSelect;
    }

    /*
     * getcelShukeiYM0
     * @return celShukeiYM0
     */
    @JsonProperty("celShukeiYM0")
    private celShukeiYM0AttblOutputTaisho getCelShukeiYM0() {
        return celShukeiYM0;
    }

    /*
     * setcelShukeiYM0
     * @param celShukeiYM0 celShukeiYM0
     */
    @JsonProperty("celShukeiYM0")
    private void setCelShukeiYM0(celShukeiYM0AttblOutputTaisho celShukeiYM0) {
        this.celShukeiYM0 = celShukeiYM0;
    }

    /*
     * getcelShukeiType0
     * @return celShukeiType0
     */
    @JsonProperty("celShukeiType0")
    private celShukeiType0AttblOutputTaisho getCelShukeiType0() {
        return celShukeiType0;
    }

    /*
     * setcelShukeiType0
     * @param celShukeiType0 celShukeiType0
     */
    @JsonProperty("celShukeiType0")
    private void setCelShukeiType0(celShukeiType0AttblOutputTaisho celShukeiType0) {
        this.celShukeiType0 = celShukeiType0;
    }

    /*
     * getcelSakuseiDate0
     * @return celSakuseiDate0
     */
    @JsonProperty("celSakuseiDate0")
    private celSakuseiDate0AttblOutputTaisho getCelSakuseiDate0() {
        return celSakuseiDate0;
    }

    /*
     * setcelSakuseiDate0
     * @param celSakuseiDate0 celSakuseiDate0
     */
    @JsonProperty("celSakuseiDate0")
    private void setCelSakuseiDate0(celSakuseiDate0AttblOutputTaisho celSakuseiDate0) {
        this.celSakuseiDate0 = celSakuseiDate0;
    }

    /*
     * getcelOutputTaisho1
     * @return celOutputTaisho1
     */
    @JsonProperty("celOutputTaisho1")
    private celOutputTaisho1AttblOutputTaisho getCelOutputTaisho1() {
        return celOutputTaisho1;
    }

    /*
     * setcelOutputTaisho1
     * @param celOutputTaisho1 celOutputTaisho1
     */
    @JsonProperty("celOutputTaisho1")
    private void setCelOutputTaisho1(celOutputTaisho1AttblOutputTaisho celOutputTaisho1) {
        this.celOutputTaisho1 = celOutputTaisho1;
    }

    /*
     * getcelShukeiYM1
     * @return celShukeiYM1
     */
    @JsonProperty("celShukeiYM1")
    private celShukeiYM1AttblOutputTaisho getCelShukeiYM1() {
        return celShukeiYM1;
    }

    /*
     * setcelShukeiYM1
     * @param celShukeiYM1 celShukeiYM1
     */
    @JsonProperty("celShukeiYM1")
    private void setCelShukeiYM1(celShukeiYM1AttblOutputTaisho celShukeiYM1) {
        this.celShukeiYM1 = celShukeiYM1;
    }

    /*
     * getcelShukeiType1
     * @return celShukeiType1
     */
    @JsonProperty("celShukeiType1")
    private celShukeiType1AttblOutputTaisho getCelShukeiType1() {
        return celShukeiType1;
    }

    /*
     * setcelShukeiType1
     * @param celShukeiType1 celShukeiType1
     */
    @JsonProperty("celShukeiType1")
    private void setCelShukeiType1(celShukeiType1AttblOutputTaisho celShukeiType1) {
        this.celShukeiType1 = celShukeiType1;
    }

    /*
     * getcelSakuseiDate1
     * @return celSakuseiDate1
     */
    @JsonProperty("celSakuseiDate1")
    private celSakuseiDate1AttblOutputTaisho getCelSakuseiDate1() {
        return celSakuseiDate1;
    }

    /*
     * setcelSakuseiDate1
     * @param celSakuseiDate1 celSakuseiDate1
     */
    @JsonProperty("celSakuseiDate1")
    private void setCelSakuseiDate1(celSakuseiDate1AttblOutputTaisho celSakuseiDate1) {
        this.celSakuseiDate1 = celSakuseiDate1;
    }

    /*
     * getcelOutputTaisho2
     * @return celOutputTaisho2
     */
    @JsonProperty("celOutputTaisho2")
    private celOutputTaisho2AttblOutputTaisho getCelOutputTaisho2() {
        return celOutputTaisho2;
    }

    /*
     * setcelOutputTaisho2
     * @param celOutputTaisho2 celOutputTaisho2
     */
    @JsonProperty("celOutputTaisho2")
    private void setCelOutputTaisho2(celOutputTaisho2AttblOutputTaisho celOutputTaisho2) {
        this.celOutputTaisho2 = celOutputTaisho2;
    }

    /*
     * getcelShukeiYM2
     * @return celShukeiYM2
     */
    @JsonProperty("celShukeiYM2")
    private celShukeiYM2AttblOutputTaisho getCelShukeiYM2() {
        return celShukeiYM2;
    }

    /*
     * setcelShukeiYM2
     * @param celShukeiYM2 celShukeiYM2
     */
    @JsonProperty("celShukeiYM2")
    private void setCelShukeiYM2(celShukeiYM2AttblOutputTaisho celShukeiYM2) {
        this.celShukeiYM2 = celShukeiYM2;
    }

    /*
     * getcelShukeiType2
     * @return celShukeiType2
     */
    @JsonProperty("celShukeiType2")
    private celShukeiType2AttblOutputTaisho getCelShukeiType2() {
        return celShukeiType2;
    }

    /*
     * setcelShukeiType2
     * @param celShukeiType2 celShukeiType2
     */
    @JsonProperty("celShukeiType2")
    private void setCelShukeiType2(celShukeiType2AttblOutputTaisho celShukeiType2) {
        this.celShukeiType2 = celShukeiType2;
    }

    /*
     * getcelSakuseiDate2
     * @return celSakuseiDate2
     */
    @JsonProperty("celSakuseiDate2")
    private celSakuseiDate2AttblOutputTaisho getCelSakuseiDate2() {
        return celSakuseiDate2;
    }

    /*
     * setcelSakuseiDate2
     * @param celSakuseiDate2 celSakuseiDate2
     */
    @JsonProperty("celSakuseiDate2")
    private void setCelSakuseiDate2(celSakuseiDate2AttblOutputTaisho celSakuseiDate2) {
        this.celSakuseiDate2 = celSakuseiDate2;
    }

    /*
     * getcelOutputTaisho3
     * @return celOutputTaisho3
     */
    @JsonProperty("celOutputTaisho3")
    private celOutputTaisho3AttblOutputTaisho getCelOutputTaisho3() {
        return celOutputTaisho3;
    }

    /*
     * setcelOutputTaisho3
     * @param celOutputTaisho3 celOutputTaisho3
     */
    @JsonProperty("celOutputTaisho3")
    private void setCelOutputTaisho3(celOutputTaisho3AttblOutputTaisho celOutputTaisho3) {
        this.celOutputTaisho3 = celOutputTaisho3;
    }

    /*
     * getcelShukeiYM3
     * @return celShukeiYM3
     */
    @JsonProperty("celShukeiYM3")
    private celShukeiYM3AttblOutputTaisho getCelShukeiYM3() {
        return celShukeiYM3;
    }

    /*
     * setcelShukeiYM3
     * @param celShukeiYM3 celShukeiYM3
     */
    @JsonProperty("celShukeiYM3")
    private void setCelShukeiYM3(celShukeiYM3AttblOutputTaisho celShukeiYM3) {
        this.celShukeiYM3 = celShukeiYM3;
    }

    /*
     * getcelShukeiType3
     * @return celShukeiType3
     */
    @JsonProperty("celShukeiType3")
    private celShukeiType3AttblOutputTaisho getCelShukeiType3() {
        return celShukeiType3;
    }

    /*
     * setcelShukeiType3
     * @param celShukeiType3 celShukeiType3
     */
    @JsonProperty("celShukeiType3")
    private void setCelShukeiType3(celShukeiType3AttblOutputTaisho celShukeiType3) {
        this.celShukeiType3 = celShukeiType3;
    }

    /*
     * getcelSakuseiDate3
     * @return celSakuseiDate3
     */
    @JsonProperty("celSakuseiDate3")
    private celSakuseiDate3AttblOutputTaisho getCelSakuseiDate3() {
        return celSakuseiDate3;
    }

    /*
     * setcelSakuseiDate3
     * @param celSakuseiDate3 celSakuseiDate3
     */
    @JsonProperty("celSakuseiDate3")
    private void setCelSakuseiDate3(celSakuseiDate3AttblOutputTaisho celSakuseiDate3) {
        this.celSakuseiDate3 = celSakuseiDate3;
    }

    /*
     * getcelOutputTaisho4
     * @return celOutputTaisho4
     */
    @JsonProperty("celOutputTaisho4")
    private celOutputTaisho4AttblOutputTaisho getCelOutputTaisho4() {
        return celOutputTaisho4;
    }

    /*
     * setcelOutputTaisho4
     * @param celOutputTaisho4 celOutputTaisho4
     */
    @JsonProperty("celOutputTaisho4")
    private void setCelOutputTaisho4(celOutputTaisho4AttblOutputTaisho celOutputTaisho4) {
        this.celOutputTaisho4 = celOutputTaisho4;
    }

    /*
     * getcelShukeiYM4
     * @return celShukeiYM4
     */
    @JsonProperty("celShukeiYM4")
    private celShukeiYM4AttblOutputTaisho getCelShukeiYM4() {
        return celShukeiYM4;
    }

    /*
     * setcelShukeiYM4
     * @param celShukeiYM4 celShukeiYM4
     */
    @JsonProperty("celShukeiYM4")
    private void setCelShukeiYM4(celShukeiYM4AttblOutputTaisho celShukeiYM4) {
        this.celShukeiYM4 = celShukeiYM4;
    }

    /*
     * getcelShukeiType4
     * @return celShukeiType4
     */
    @JsonProperty("celShukeiType4")
    private celShukeiType4AttblOutputTaisho getCelShukeiType4() {
        return celShukeiType4;
    }

    /*
     * setcelShukeiType4
     * @param celShukeiType4 celShukeiType4
     */
    @JsonProperty("celShukeiType4")
    private void setCelShukeiType4(celShukeiType4AttblOutputTaisho celShukeiType4) {
        this.celShukeiType4 = celShukeiType4;
    }

    /*
     * getcelSakuseiDate4
     * @return celSakuseiDate4
     */
    @JsonProperty("celSakuseiDate4")
    private celSakuseiDate4AttblOutputTaisho getCelSakuseiDate4() {
        return celSakuseiDate4;
    }

    /*
     * setcelSakuseiDate4
     * @param celSakuseiDate4 celSakuseiDate4
     */
    @JsonProperty("celSakuseiDate4")
    private void setCelSakuseiDate4(celSakuseiDate4AttblOutputTaisho celSakuseiDate4) {
        this.celSakuseiDate4 = celSakuseiDate4;
    }

    /*
     * getcelOutputTaisho5
     * @return celOutputTaisho5
     */
    @JsonProperty("celOutputTaisho5")
    private celOutputTaisho5AttblOutputTaisho getCelOutputTaisho5() {
        return celOutputTaisho5;
    }

    /*
     * setcelOutputTaisho5
     * @param celOutputTaisho5 celOutputTaisho5
     */
    @JsonProperty("celOutputTaisho5")
    private void setCelOutputTaisho5(celOutputTaisho5AttblOutputTaisho celOutputTaisho5) {
        this.celOutputTaisho5 = celOutputTaisho5;
    }

    /*
     * getcelShukeiYM5
     * @return celShukeiYM5
     */
    @JsonProperty("celShukeiYM5")
    private celShukeiYM5AttblOutputTaisho getCelShukeiYM5() {
        return celShukeiYM5;
    }

    /*
     * setcelShukeiYM5
     * @param celShukeiYM5 celShukeiYM5
     */
    @JsonProperty("celShukeiYM5")
    private void setCelShukeiYM5(celShukeiYM5AttblOutputTaisho celShukeiYM5) {
        this.celShukeiYM5 = celShukeiYM5;
    }

    /*
     * getcelShukeiType5
     * @return celShukeiType5
     */
    @JsonProperty("celShukeiType5")
    private celShukeiType5AttblOutputTaisho getCelShukeiType5() {
        return celShukeiType5;
    }

    /*
     * setcelShukeiType5
     * @param celShukeiType5 celShukeiType5
     */
    @JsonProperty("celShukeiType5")
    private void setCelShukeiType5(celShukeiType5AttblOutputTaisho celShukeiType5) {
        this.celShukeiType5 = celShukeiType5;
    }

    /*
     * getcelSakuseiDate5
     * @return celSakuseiDate5
     */
    @JsonProperty("celSakuseiDate5")
    private celSakuseiDate5AttblOutputTaisho getCelSakuseiDate5() {
        return celSakuseiDate5;
    }

    /*
     * setcelSakuseiDate5
     * @param celSakuseiDate5 celSakuseiDate5
     */
    @JsonProperty("celSakuseiDate5")
    private void setCelSakuseiDate5(celSakuseiDate5AttblOutputTaisho celSakuseiDate5) {
        this.celSakuseiDate5 = celSakuseiDate5;
    }

    /*
     * getcelOutputTaisho6
     * @return celOutputTaisho6
     */
    @JsonProperty("celOutputTaisho6")
    private celOutputTaisho6AttblOutputTaisho getCelOutputTaisho6() {
        return celOutputTaisho6;
    }

    /*
     * setcelOutputTaisho6
     * @param celOutputTaisho6 celOutputTaisho6
     */
    @JsonProperty("celOutputTaisho6")
    private void setCelOutputTaisho6(celOutputTaisho6AttblOutputTaisho celOutputTaisho6) {
        this.celOutputTaisho6 = celOutputTaisho6;
    }

    /*
     * getcelShukeiYM6
     * @return celShukeiYM6
     */
    @JsonProperty("celShukeiYM6")
    private celShukeiYM6AttblOutputTaisho getCelShukeiYM6() {
        return celShukeiYM6;
    }

    /*
     * setcelShukeiYM6
     * @param celShukeiYM6 celShukeiYM6
     */
    @JsonProperty("celShukeiYM6")
    private void setCelShukeiYM6(celShukeiYM6AttblOutputTaisho celShukeiYM6) {
        this.celShukeiYM6 = celShukeiYM6;
    }

    /*
     * getcelShukeiType6
     * @return celShukeiType6
     */
    @JsonProperty("celShukeiType6")
    private celShukeiType6AttblOutputTaisho getCelShukeiType6() {
        return celShukeiType6;
    }

    /*
     * setcelShukeiType6
     * @param celShukeiType6 celShukeiType6
     */
    @JsonProperty("celShukeiType6")
    private void setCelShukeiType6(celShukeiType6AttblOutputTaisho celShukeiType6) {
        this.celShukeiType6 = celShukeiType6;
    }

    /*
     * getcelSakuseiDate6
     * @return celSakuseiDate6
     */
    @JsonProperty("celSakuseiDate6")
    private celSakuseiDate6AttblOutputTaisho getCelSakuseiDate6() {
        return celSakuseiDate6;
    }

    /*
     * setcelSakuseiDate6
     * @param celSakuseiDate6 celSakuseiDate6
     */
    @JsonProperty("celSakuseiDate6")
    private void setCelSakuseiDate6(celSakuseiDate6AttblOutputTaisho celSakuseiDate6) {
        this.celSakuseiDate6 = celSakuseiDate6;
    }

    /*
     * getcelOutputTaisho7
     * @return celOutputTaisho7
     */
    @JsonProperty("celOutputTaisho7")
    private celOutputTaisho7AttblOutputTaisho getCelOutputTaisho7() {
        return celOutputTaisho7;
    }

    /*
     * setcelOutputTaisho7
     * @param celOutputTaisho7 celOutputTaisho7
     */
    @JsonProperty("celOutputTaisho7")
    private void setCelOutputTaisho7(celOutputTaisho7AttblOutputTaisho celOutputTaisho7) {
        this.celOutputTaisho7 = celOutputTaisho7;
    }

    /*
     * getcelShukeiYM7
     * @return celShukeiYM7
     */
    @JsonProperty("celShukeiYM7")
    private celShukeiYM7AttblOutputTaisho getCelShukeiYM7() {
        return celShukeiYM7;
    }

    /*
     * setcelShukeiYM7
     * @param celShukeiYM7 celShukeiYM7
     */
    @JsonProperty("celShukeiYM7")
    private void setCelShukeiYM7(celShukeiYM7AttblOutputTaisho celShukeiYM7) {
        this.celShukeiYM7 = celShukeiYM7;
    }

    /*
     * getcelShukeiType7
     * @return celShukeiType7
     */
    @JsonProperty("celShukeiType7")
    private celShukeiType7AttblOutputTaisho getCelShukeiType7() {
        return celShukeiType7;
    }

    /*
     * setcelShukeiType7
     * @param celShukeiType7 celShukeiType7
     */
    @JsonProperty("celShukeiType7")
    private void setCelShukeiType7(celShukeiType7AttblOutputTaisho celShukeiType7) {
        this.celShukeiType7 = celShukeiType7;
    }

    /*
     * getcelSakuseiDate7
     * @return celSakuseiDate7
     */
    @JsonProperty("celSakuseiDate7")
    private celSakuseiDate7AttblOutputTaisho getCelSakuseiDate7() {
        return celSakuseiDate7;
    }

    /*
     * setcelSakuseiDate7
     * @param celSakuseiDate7 celSakuseiDate7
     */
    @JsonProperty("celSakuseiDate7")
    private void setCelSakuseiDate7(celSakuseiDate7AttblOutputTaisho celSakuseiDate7) {
        this.celSakuseiDate7 = celSakuseiDate7;
    }

    // </editor-fold>
}
/**
 * celOutputTaishoTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celOutputTaishoTitleAttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblOutputTaishoTitle")
    private Label lblOutputTaishoTitle;

    /*
     * getlblOutputTaishoTitle
     * @return lblOutputTaishoTitle
     */
    @JsonProperty("lblOutputTaishoTitle")
    public Label getLblOutputTaishoTitle() {
        return lblOutputTaishoTitle;
    }

    /*
     * setlblOutputTaishoTitle
     * @param lblOutputTaishoTitle lblOutputTaishoTitle
     */
    @JsonProperty("lblOutputTaishoTitle")
    public void setLblOutputTaishoTitle(Label lblOutputTaishoTitle) {
        this.lblOutputTaishoTitle = lblOutputTaishoTitle;
    }

    // </editor-fold>
}
/**
 * celShukeiHohoTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiHohoTitleAttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblShukeiHohoTitle")
    private Label lblShukeiHohoTitle;

    /*
     * getlblShukeiHohoTitle
     * @return lblShukeiHohoTitle
     */
    @JsonProperty("lblShukeiHohoTitle")
    public Label getLblShukeiHohoTitle() {
        return lblShukeiHohoTitle;
    }

    /*
     * setlblShukeiHohoTitle
     * @param lblShukeiHohoTitle lblShukeiHohoTitle
     */
    @JsonProperty("lblShukeiHohoTitle")
    public void setLblShukeiHohoTitle(Label lblShukeiHohoTitle) {
        this.lblShukeiHohoTitle = lblShukeiHohoTitle;
    }

    // </editor-fold>
}
/**
 * celSakuseiDateTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDateTitleAttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblSakuseiDateTitle")
    private Label lblSakuseiDateTitle;

    /*
     * getlblSakuseiDateTitle
     * @return lblSakuseiDateTitle
     */
    @JsonProperty("lblSakuseiDateTitle")
    public Label getLblSakuseiDateTitle() {
        return lblSakuseiDateTitle;
    }

    /*
     * setlblSakuseiDateTitle
     * @param lblSakuseiDateTitle lblSakuseiDateTitle
     */
    @JsonProperty("lblSakuseiDateTitle")
    public void setLblSakuseiDateTitle(Label lblSakuseiDateTitle) {
        this.lblSakuseiDateTitle = lblSakuseiDateTitle;
    }

    // </editor-fold>
}
/**
 * celOutputTaishoAllSelect のクラスファイル 
 * 
 * @author 自動生成
 */
class celOutputTaishoAllSelectAttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("cblOutputTaishoAll")
    private CheckBoxList cblOutputTaishoAll;

    /*
     * getcblOutputTaishoAll
     * @return cblOutputTaishoAll
     */
    @JsonProperty("cblOutputTaishoAll")
    public CheckBoxList getCblOutputTaishoAll() {
        return cblOutputTaishoAll;
    }

    /*
     * setcblOutputTaishoAll
     * @param cblOutputTaishoAll cblOutputTaishoAll
     */
    @JsonProperty("cblOutputTaishoAll")
    public void setCblOutputTaishoAll(CheckBoxList cblOutputTaishoAll) {
        this.cblOutputTaishoAll = cblOutputTaishoAll;
    }

    // </editor-fold>
}
/**
 * celShukeiYM0 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM0AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    // </editor-fold>
}
/**
 * celShukeiType0 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiType0AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    // </editor-fold>
}
/**
 * celSakuseiDate0 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDate0AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    // </editor-fold>
}
/**
 * celOutputTaisho1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celOutputTaisho1AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("cblOutputTaisho1")
    private CheckBoxList cblOutputTaisho1;

    /*
     * getcblOutputTaisho1
     * @return cblOutputTaisho1
     */
    @JsonProperty("cblOutputTaisho1")
    public CheckBoxList getCblOutputTaisho1() {
        return cblOutputTaisho1;
    }

    /*
     * setcblOutputTaisho1
     * @param cblOutputTaisho1 cblOutputTaisho1
     */
    @JsonProperty("cblOutputTaisho1")
    public void setCblOutputTaisho1(CheckBoxList cblOutputTaisho1) {
        this.cblOutputTaisho1 = cblOutputTaisho1;
    }

    // </editor-fold>
}
/**
 * celShukeiYM1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM1AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
class celShukeiType1AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
 * celSakuseiDate1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDate1AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtSakuseiYMD1")
    private TextBoxDate txtSakuseiYMD1;
    @JsonProperty("txtSakuseiTime1")
    private TextBoxTime txtSakuseiTime1;

    /*
     * gettxtSakuseiYMD1
     * @return txtSakuseiYMD1
     */
    @JsonProperty("txtSakuseiYMD1")
    public TextBoxDate getTxtSakuseiYMD1() {
        return txtSakuseiYMD1;
    }

    /*
     * settxtSakuseiYMD1
     * @param txtSakuseiYMD1 txtSakuseiYMD1
     */
    @JsonProperty("txtSakuseiYMD1")
    public void setTxtSakuseiYMD1(TextBoxDate txtSakuseiYMD1) {
        this.txtSakuseiYMD1 = txtSakuseiYMD1;
    }

    /*
     * gettxtSakuseiTime1
     * @return txtSakuseiTime1
     */
    @JsonProperty("txtSakuseiTime1")
    public TextBoxTime getTxtSakuseiTime1() {
        return txtSakuseiTime1;
    }

    /*
     * settxtSakuseiTime1
     * @param txtSakuseiTime1 txtSakuseiTime1
     */
    @JsonProperty("txtSakuseiTime1")
    public void setTxtSakuseiTime1(TextBoxTime txtSakuseiTime1) {
        this.txtSakuseiTime1 = txtSakuseiTime1;
    }

    // </editor-fold>
}
/**
 * celOutputTaisho2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celOutputTaisho2AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("cblOutputTaisho2")
    private CheckBoxList cblOutputTaisho2;

    /*
     * getcblOutputTaisho2
     * @return cblOutputTaisho2
     */
    @JsonProperty("cblOutputTaisho2")
    public CheckBoxList getCblOutputTaisho2() {
        return cblOutputTaisho2;
    }

    /*
     * setcblOutputTaisho2
     * @param cblOutputTaisho2 cblOutputTaisho2
     */
    @JsonProperty("cblOutputTaisho2")
    public void setCblOutputTaisho2(CheckBoxList cblOutputTaisho2) {
        this.cblOutputTaisho2 = cblOutputTaisho2;
    }

    // </editor-fold>
}
/**
 * celShukeiYM2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM2AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
class celShukeiType2AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
 * celSakuseiDate2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDate2AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtSakuseiYMD2")
    private TextBoxDate txtSakuseiYMD2;
    @JsonProperty("txtSakuseiTime2")
    private TextBoxTime txtSakuseiTime2;

    /*
     * gettxtSakuseiYMD2
     * @return txtSakuseiYMD2
     */
    @JsonProperty("txtSakuseiYMD2")
    public TextBoxDate getTxtSakuseiYMD2() {
        return txtSakuseiYMD2;
    }

    /*
     * settxtSakuseiYMD2
     * @param txtSakuseiYMD2 txtSakuseiYMD2
     */
    @JsonProperty("txtSakuseiYMD2")
    public void setTxtSakuseiYMD2(TextBoxDate txtSakuseiYMD2) {
        this.txtSakuseiYMD2 = txtSakuseiYMD2;
    }

    /*
     * gettxtSakuseiTime2
     * @return txtSakuseiTime2
     */
    @JsonProperty("txtSakuseiTime2")
    public TextBoxTime getTxtSakuseiTime2() {
        return txtSakuseiTime2;
    }

    /*
     * settxtSakuseiTime2
     * @param txtSakuseiTime2 txtSakuseiTime2
     */
    @JsonProperty("txtSakuseiTime2")
    public void setTxtSakuseiTime2(TextBoxTime txtSakuseiTime2) {
        this.txtSakuseiTime2 = txtSakuseiTime2;
    }

    // </editor-fold>
}
/**
 * celOutputTaisho3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celOutputTaisho3AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("cblOutputTaisho3")
    private CheckBoxList cblOutputTaisho3;

    /*
     * getcblOutputTaisho3
     * @return cblOutputTaisho3
     */
    @JsonProperty("cblOutputTaisho3")
    public CheckBoxList getCblOutputTaisho3() {
        return cblOutputTaisho3;
    }

    /*
     * setcblOutputTaisho3
     * @param cblOutputTaisho3 cblOutputTaisho3
     */
    @JsonProperty("cblOutputTaisho3")
    public void setCblOutputTaisho3(CheckBoxList cblOutputTaisho3) {
        this.cblOutputTaisho3 = cblOutputTaisho3;
    }

    // </editor-fold>
}
/**
 * celShukeiYM3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM3AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
class celShukeiType3AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblShukeiType3")
    private Label lblShukeiType3;

    /*
     * getlblShukeiType3
     * @return lblShukeiType3
     */
    @JsonProperty("lblShukeiType3")
    public Label getLblShukeiType3() {
        return lblShukeiType3;
    }

    /*
     * setlblShukeiType3
     * @param lblShukeiType3 lblShukeiType3
     */
    @JsonProperty("lblShukeiType3")
    public void setLblShukeiType3(Label lblShukeiType3) {
        this.lblShukeiType3 = lblShukeiType3;
    }

    // </editor-fold>
}
/**
 * celSakuseiDate3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDate3AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtSakuseiYMD3")
    private TextBoxDate txtSakuseiYMD3;
    @JsonProperty("txtSakuseiTime3")
    private TextBoxTime txtSakuseiTime3;

    /*
     * gettxtSakuseiYMD3
     * @return txtSakuseiYMD3
     */
    @JsonProperty("txtSakuseiYMD3")
    public TextBoxDate getTxtSakuseiYMD3() {
        return txtSakuseiYMD3;
    }

    /*
     * settxtSakuseiYMD3
     * @param txtSakuseiYMD3 txtSakuseiYMD3
     */
    @JsonProperty("txtSakuseiYMD3")
    public void setTxtSakuseiYMD3(TextBoxDate txtSakuseiYMD3) {
        this.txtSakuseiYMD3 = txtSakuseiYMD3;
    }

    /*
     * gettxtSakuseiTime3
     * @return txtSakuseiTime3
     */
    @JsonProperty("txtSakuseiTime3")
    public TextBoxTime getTxtSakuseiTime3() {
        return txtSakuseiTime3;
    }

    /*
     * settxtSakuseiTime3
     * @param txtSakuseiTime3 txtSakuseiTime3
     */
    @JsonProperty("txtSakuseiTime3")
    public void setTxtSakuseiTime3(TextBoxTime txtSakuseiTime3) {
        this.txtSakuseiTime3 = txtSakuseiTime3;
    }

    // </editor-fold>
}
/**
 * celOutputTaisho4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celOutputTaisho4AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("cblOutputTaisho4")
    private CheckBoxList cblOutputTaisho4;

    /*
     * getcblOutputTaisho4
     * @return cblOutputTaisho4
     */
    @JsonProperty("cblOutputTaisho4")
    public CheckBoxList getCblOutputTaisho4() {
        return cblOutputTaisho4;
    }

    /*
     * setcblOutputTaisho4
     * @param cblOutputTaisho4 cblOutputTaisho4
     */
    @JsonProperty("cblOutputTaisho4")
    public void setCblOutputTaisho4(CheckBoxList cblOutputTaisho4) {
        this.cblOutputTaisho4 = cblOutputTaisho4;
    }

    // </editor-fold>
}
/**
 * celShukeiYM4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM4AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
class celShukeiType4AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("radlblShukeiType4")
    private RadioButton radlblShukeiType4;

    /*
     * getradlblShukeiType4
     * @return radlblShukeiType4
     */
    @JsonProperty("radlblShukeiType4")
    public RadioButton getRadlblShukeiType4() {
        return radlblShukeiType4;
    }

    /*
     * setradlblShukeiType4
     * @param radlblShukeiType4 radlblShukeiType4
     */
    @JsonProperty("radlblShukeiType4")
    public void setRadlblShukeiType4(RadioButton radlblShukeiType4) {
        this.radlblShukeiType4 = radlblShukeiType4;
    }

    // </editor-fold>
}
/**
 * celSakuseiDate4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDate4AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtSakuseiYMD4")
    private TextBoxDate txtSakuseiYMD4;
    @JsonProperty("txtSakuseiTime4")
    private TextBoxTime txtSakuseiTime4;

    /*
     * gettxtSakuseiYMD4
     * @return txtSakuseiYMD4
     */
    @JsonProperty("txtSakuseiYMD4")
    public TextBoxDate getTxtSakuseiYMD4() {
        return txtSakuseiYMD4;
    }

    /*
     * settxtSakuseiYMD4
     * @param txtSakuseiYMD4 txtSakuseiYMD4
     */
    @JsonProperty("txtSakuseiYMD4")
    public void setTxtSakuseiYMD4(TextBoxDate txtSakuseiYMD4) {
        this.txtSakuseiYMD4 = txtSakuseiYMD4;
    }

    /*
     * gettxtSakuseiTime4
     * @return txtSakuseiTime4
     */
    @JsonProperty("txtSakuseiTime4")
    public TextBoxTime getTxtSakuseiTime4() {
        return txtSakuseiTime4;
    }

    /*
     * settxtSakuseiTime4
     * @param txtSakuseiTime4 txtSakuseiTime4
     */
    @JsonProperty("txtSakuseiTime4")
    public void setTxtSakuseiTime4(TextBoxTime txtSakuseiTime4) {
        this.txtSakuseiTime4 = txtSakuseiTime4;
    }

    // </editor-fold>
}
/**
 * celOutputTaisho5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celOutputTaisho5AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("cblOutputTaisho5")
    private CheckBoxList cblOutputTaisho5;

    /*
     * getcblOutputTaisho5
     * @return cblOutputTaisho5
     */
    @JsonProperty("cblOutputTaisho5")
    public CheckBoxList getCblOutputTaisho5() {
        return cblOutputTaisho5;
    }

    /*
     * setcblOutputTaisho5
     * @param cblOutputTaisho5 cblOutputTaisho5
     */
    @JsonProperty("cblOutputTaisho5")
    public void setCblOutputTaisho5(CheckBoxList cblOutputTaisho5) {
        this.cblOutputTaisho5 = cblOutputTaisho5;
    }

    // </editor-fold>
}
/**
 * celShukeiYM5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM5AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
class celShukeiType5AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("radlblShukeiType5")
    private RadioButton radlblShukeiType5;

    /*
     * getradlblShukeiType5
     * @return radlblShukeiType5
     */
    @JsonProperty("radlblShukeiType5")
    public RadioButton getRadlblShukeiType5() {
        return radlblShukeiType5;
    }

    /*
     * setradlblShukeiType5
     * @param radlblShukeiType5 radlblShukeiType5
     */
    @JsonProperty("radlblShukeiType5")
    public void setRadlblShukeiType5(RadioButton radlblShukeiType5) {
        this.radlblShukeiType5 = radlblShukeiType5;
    }

    // </editor-fold>
}
/**
 * celSakuseiDate5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDate5AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtSakuseiYMD5")
    private TextBoxDate txtSakuseiYMD5;
    @JsonProperty("txtSakuseiTime5")
    private TextBoxTime txtSakuseiTime5;

    /*
     * gettxtSakuseiYMD5
     * @return txtSakuseiYMD5
     */
    @JsonProperty("txtSakuseiYMD5")
    public TextBoxDate getTxtSakuseiYMD5() {
        return txtSakuseiYMD5;
    }

    /*
     * settxtSakuseiYMD5
     * @param txtSakuseiYMD5 txtSakuseiYMD5
     */
    @JsonProperty("txtSakuseiYMD5")
    public void setTxtSakuseiYMD5(TextBoxDate txtSakuseiYMD5) {
        this.txtSakuseiYMD5 = txtSakuseiYMD5;
    }

    /*
     * gettxtSakuseiTime5
     * @return txtSakuseiTime5
     */
    @JsonProperty("txtSakuseiTime5")
    public TextBoxTime getTxtSakuseiTime5() {
        return txtSakuseiTime5;
    }

    /*
     * settxtSakuseiTime5
     * @param txtSakuseiTime5 txtSakuseiTime5
     */
    @JsonProperty("txtSakuseiTime5")
    public void setTxtSakuseiTime5(TextBoxTime txtSakuseiTime5) {
        this.txtSakuseiTime5 = txtSakuseiTime5;
    }

    // </editor-fold>
}
/**
 * celOutputTaisho6 のクラスファイル 
 * 
 * @author 自動生成
 */
class celOutputTaisho6AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("cblOutputTaisho6")
    private CheckBoxList cblOutputTaisho6;

    /*
     * getcblOutputTaisho6
     * @return cblOutputTaisho6
     */
    @JsonProperty("cblOutputTaisho6")
    public CheckBoxList getCblOutputTaisho6() {
        return cblOutputTaisho6;
    }

    /*
     * setcblOutputTaisho6
     * @param cblOutputTaisho6 cblOutputTaisho6
     */
    @JsonProperty("cblOutputTaisho6")
    public void setCblOutputTaisho6(CheckBoxList cblOutputTaisho6) {
        this.cblOutputTaisho6 = cblOutputTaisho6;
    }

    // </editor-fold>
}
/**
 * celShukeiYM6 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM6AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtShukeiYM6")
    private TextBoxFlexibleDate txtShukeiYM6;

    /*
     * gettxtShukeiYM6
     * @return txtShukeiYM6
     */
    @JsonProperty("txtShukeiYM6")
    public TextBoxFlexibleDate getTxtShukeiYM6() {
        return txtShukeiYM6;
    }

    /*
     * settxtShukeiYM6
     * @param txtShukeiYM6 txtShukeiYM6
     */
    @JsonProperty("txtShukeiYM6")
    public void setTxtShukeiYM6(TextBoxFlexibleDate txtShukeiYM6) {
        this.txtShukeiYM6 = txtShukeiYM6;
    }

    // </editor-fold>
}
/**
 * celShukeiType6 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiType6AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblShukeiType6")
    private Label lblShukeiType6;

    /*
     * getlblShukeiType6
     * @return lblShukeiType6
     */
    @JsonProperty("lblShukeiType6")
    public Label getLblShukeiType6() {
        return lblShukeiType6;
    }

    /*
     * setlblShukeiType6
     * @param lblShukeiType6 lblShukeiType6
     */
    @JsonProperty("lblShukeiType6")
    public void setLblShukeiType6(Label lblShukeiType6) {
        this.lblShukeiType6 = lblShukeiType6;
    }

    // </editor-fold>
}
/**
 * celSakuseiDate6 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDate6AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtSakuseiYMD6")
    private TextBoxDate txtSakuseiYMD6;
    @JsonProperty("txtSakuseiTime6")
    private TextBoxTime txtSakuseiTime6;

    /*
     * gettxtSakuseiYMD6
     * @return txtSakuseiYMD6
     */
    @JsonProperty("txtSakuseiYMD6")
    public TextBoxDate getTxtSakuseiYMD6() {
        return txtSakuseiYMD6;
    }

    /*
     * settxtSakuseiYMD6
     * @param txtSakuseiYMD6 txtSakuseiYMD6
     */
    @JsonProperty("txtSakuseiYMD6")
    public void setTxtSakuseiYMD6(TextBoxDate txtSakuseiYMD6) {
        this.txtSakuseiYMD6 = txtSakuseiYMD6;
    }

    /*
     * gettxtSakuseiTime6
     * @return txtSakuseiTime6
     */
    @JsonProperty("txtSakuseiTime6")
    public TextBoxTime getTxtSakuseiTime6() {
        return txtSakuseiTime6;
    }

    /*
     * settxtSakuseiTime6
     * @param txtSakuseiTime6 txtSakuseiTime6
     */
    @JsonProperty("txtSakuseiTime6")
    public void setTxtSakuseiTime6(TextBoxTime txtSakuseiTime6) {
        this.txtSakuseiTime6 = txtSakuseiTime6;
    }

    // </editor-fold>
}
/**
 * celOutputTaisho7 のクラスファイル 
 * 
 * @author 自動生成
 */
class celOutputTaisho7AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("cblOutputTaisho7")
    private CheckBoxList cblOutputTaisho7;

    /*
     * getcblOutputTaisho7
     * @return cblOutputTaisho7
     */
    @JsonProperty("cblOutputTaisho7")
    public CheckBoxList getCblOutputTaisho7() {
        return cblOutputTaisho7;
    }

    /*
     * setcblOutputTaisho7
     * @param cblOutputTaisho7 cblOutputTaisho7
     */
    @JsonProperty("cblOutputTaisho7")
    public void setCblOutputTaisho7(CheckBoxList cblOutputTaisho7) {
        this.cblOutputTaisho7 = cblOutputTaisho7;
    }

    // </editor-fold>
}
/**
 * celShukeiYM7 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiYM7AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtShukeiYM7")
    private TextBoxFlexibleDate txtShukeiYM7;

    /*
     * gettxtShukeiYM7
     * @return txtShukeiYM7
     */
    @JsonProperty("txtShukeiYM7")
    public TextBoxFlexibleDate getTxtShukeiYM7() {
        return txtShukeiYM7;
    }

    /*
     * settxtShukeiYM7
     * @param txtShukeiYM7 txtShukeiYM7
     */
    @JsonProperty("txtShukeiYM7")
    public void setTxtShukeiYM7(TextBoxFlexibleDate txtShukeiYM7) {
        this.txtShukeiYM7 = txtShukeiYM7;
    }

    // </editor-fold>
}
/**
 * celShukeiType7 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShukeiType7AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblShukeiType7")
    private Label lblShukeiType7;

    /*
     * getlblShukeiType7
     * @return lblShukeiType7
     */
    @JsonProperty("lblShukeiType7")
    public Label getLblShukeiType7() {
        return lblShukeiType7;
    }

    /*
     * setlblShukeiType7
     * @param lblShukeiType7 lblShukeiType7
     */
    @JsonProperty("lblShukeiType7")
    public void setLblShukeiType7(Label lblShukeiType7) {
        this.lblShukeiType7 = lblShukeiType7;
    }

    // </editor-fold>
}
/**
 * celSakuseiDate7 のクラスファイル 
 * 
 * @author 自動生成
 */
class celSakuseiDate7AttblOutputTaisho extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtSakuseiYMD7")
    private TextBoxDate txtSakuseiYMD7;
    @JsonProperty("txtSakuseiTime7")
    private TextBoxTime txtSakuseiTime7;

    /*
     * gettxtSakuseiYMD7
     * @return txtSakuseiYMD7
     */
    @JsonProperty("txtSakuseiYMD7")
    public TextBoxDate getTxtSakuseiYMD7() {
        return txtSakuseiYMD7;
    }

    /*
     * settxtSakuseiYMD7
     * @param txtSakuseiYMD7 txtSakuseiYMD7
     */
    @JsonProperty("txtSakuseiYMD7")
    public void setTxtSakuseiYMD7(TextBoxDate txtSakuseiYMD7) {
        this.txtSakuseiYMD7 = txtSakuseiYMD7;
    }

    /*
     * gettxtSakuseiTime7
     * @return txtSakuseiTime7
     */
    @JsonProperty("txtSakuseiTime7")
    public TextBoxTime getTxtSakuseiTime7() {
        return txtSakuseiTime7;
    }

    /*
     * settxtSakuseiTime7
     * @param txtSakuseiTime7 txtSakuseiTime7
     */
    @JsonProperty("txtSakuseiTime7")
    public void setTxtSakuseiTime7(TextBoxTime txtSakuseiTime7) {
        this.txtSakuseiTime7 = txtSakuseiTime7;
    }

    // </editor-fold>
}
