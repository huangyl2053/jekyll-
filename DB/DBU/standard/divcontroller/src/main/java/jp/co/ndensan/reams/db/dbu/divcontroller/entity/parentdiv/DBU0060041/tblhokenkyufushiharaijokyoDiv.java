package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060041;
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
 * tblhokenkyufushiharaijokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblhokenkyufushiharaijokyoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cellgubun")
    private cellgubunAttblhokenkyufushiharaijokyo cellgubun;
    @JsonProperty("cellShiharaigi")
    private cellShiharaigiAttblhokenkyufushiharaijokyo cellShiharaigi;
    @JsonProperty("cellShiharaizu")
    private cellShiharaizuAttblhokenkyufushiharaijokyo cellShiharaizu;
    @JsonProperty("cellchoshu")
    private cellchoshuAttblhokenkyufushiharaijokyo cellchoshu;
    @JsonProperty("cellreinyu")
    private cellreinyuAttblhokenkyufushiharaijokyo cellreinyu;
    @JsonProperty("celllmishiharaigaku")
    private celllmishiharaigakuAttblhokenkyufushiharaijokyo celllmishiharaigaku;
    @JsonProperty("cellkaigoSer")
    private cellkaigoSerAttblhokenkyufushiharaijokyo cellkaigoSer;
    @JsonProperty("cellShiharaigi1")
    private cellShiharaigi1Attblhokenkyufushiharaijokyo cellShiharaigi1;
    @JsonProperty("cellShiharaizu1")
    private cellShiharaizu1Attblhokenkyufushiharaijokyo cellShiharaizu1;
    @JsonProperty("cellChoshu1")
    private cellChoshu1Attblhokenkyufushiharaijokyo cellChoshu1;
    @JsonProperty("cellReinyu1")
    private cellReinyu1Attblhokenkyufushiharaijokyo cellReinyu1;
    @JsonProperty("cellmishiharaigaku1")
    private cellmishiharaigaku1Attblhokenkyufushiharaijokyo cellmishiharaigaku1;
    @JsonProperty("cellkaigoyoboSer")
    private cellkaigoyoboSerAttblhokenkyufushiharaijokyo cellkaigoyoboSer;
    @JsonProperty("cellShiharaigi2")
    private cellShiharaigi2Attblhokenkyufushiharaijokyo cellShiharaigi2;
    @JsonProperty("cellShiharaizu2")
    private cellShiharaizu2Attblhokenkyufushiharaijokyo cellShiharaizu2;
    @JsonProperty("cellChoshu2")
    private cellChoshu2Attblhokenkyufushiharaijokyo cellChoshu2;
    @JsonProperty("cellReinyu2")
    private cellReinyu2Attblhokenkyufushiharaijokyo cellReinyu2;
    @JsonProperty("cellmishiharaigaku2")
    private cellmishiharaigaku2Attblhokenkyufushiharaijokyo cellmishiharaigaku2;
    @JsonProperty("cellkogakukaigoSer")
    private cellkogakukaigoSerAttblhokenkyufushiharaijokyo cellkogakukaigoSer;
    @JsonProperty("cellShiharaigi3")
    private cellShiharaigi3Attblhokenkyufushiharaijokyo cellShiharaigi3;
    @JsonProperty("cellShiharaizu3")
    private cellShiharaizu3Attblhokenkyufushiharaijokyo cellShiharaizu3;
    @JsonProperty("cellChoshu3")
    private cellChoshu3Attblhokenkyufushiharaijokyo cellChoshu3;
    @JsonProperty("cellReinyu3")
    private cellReinyu3Attblhokenkyufushiharaijokyo cellReinyu3;
    @JsonProperty("cellmishiharaigaku3")
    private cellmishiharaigaku3Attblhokenkyufushiharaijokyo cellmishiharaigaku3;
    @JsonProperty("cellkogakuiryo")
    private cellkogakuiryoAttblhokenkyufushiharaijokyo cellkogakuiryo;
    @JsonProperty("cellShiharaigi4")
    private cellShiharaigi4Attblhokenkyufushiharaijokyo cellShiharaigi4;
    @JsonProperty("cellShiharaizu4")
    private cellShiharaizu4Attblhokenkyufushiharaijokyo cellShiharaizu4;
    @JsonProperty("cellChoshu4")
    private cellChoshu4Attblhokenkyufushiharaijokyo cellChoshu4;
    @JsonProperty("cellReinyu4")
    private cellReinyu4Attblhokenkyufushiharaijokyo cellReinyu4;
    @JsonProperty("cellmishiharaigaku4")
    private cellmishiharaigaku4Attblhokenkyufushiharaijokyo cellmishiharaigaku4;
    @JsonProperty("celltokuteinyusho")
    private celltokuteinyushoAttblhokenkyufushiharaijokyo celltokuteinyusho;
    @JsonProperty("cellShiharaigi5")
    private cellShiharaigi5Attblhokenkyufushiharaijokyo cellShiharaigi5;
    @JsonProperty("cellShiharaizu5")
    private cellShiharaizu5Attblhokenkyufushiharaijokyo cellShiharaizu5;
    @JsonProperty("cellchoshu5")
    private cellchoshu5Attblhokenkyufushiharaijokyo cellchoshu5;
    @JsonProperty("cellReinyu5")
    private cellReinyu5Attblhokenkyufushiharaijokyo cellReinyu5;
    @JsonProperty("cellmishiharaigaku5")
    private cellmishiharaigaku5Attblhokenkyufushiharaijokyo cellmishiharaigaku5;
    @JsonProperty("cellsonota")
    private cellsonotaAttblhokenkyufushiharaijokyo cellsonota;
    @JsonProperty("cellShiharaigi6")
    private cellShiharaigi6Attblhokenkyufushiharaijokyo cellShiharaigi6;
    @JsonProperty("cellShiharaizu6")
    private cellShiharaizu6Attblhokenkyufushiharaijokyo cellShiharaizu6;
    @JsonProperty("cellChoshu6")
    private cellChoshu6Attblhokenkyufushiharaijokyo cellChoshu6;
    @JsonProperty("cellReinyu6")
    private cellReinyu6Attblhokenkyufushiharaijokyo cellReinyu6;
    @JsonProperty("cellmishiharaigaku6")
    private cellmishiharaigaku6Attblhokenkyufushiharaijokyo cellmishiharaigaku6;
    @JsonProperty("cellkeii")
    private cellkeiiAttblhokenkyufushiharaijokyo cellkeii;
    @JsonProperty("cellShiharaigi7")
    private cellShiharaigi7Attblhokenkyufushiharaijokyo cellShiharaigi7;
    @JsonProperty("cellShiharaizu7")
    private cellShiharaizu7Attblhokenkyufushiharaijokyo cellShiharaizu7;
    @JsonProperty("cellChoshu7")
    private cellChoshu7Attblhokenkyufushiharaijokyo cellChoshu7;
    @JsonProperty("cellReinyu7")
    private cellReinyu7Attblhokenkyufushiharaijokyo cellReinyu7;
    @JsonProperty("cellmishiharaigaku7")
    private cellmishiharaigaku7Attblhokenkyufushiharaijokyo cellmishiharaigaku7;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblgubun() {
        return this.cellgubun.getLblgubun();
    }

    @JsonIgnore
    public Label getLblShiharaigi() {
        return this.cellShiharaigi.getLblShiharaigi();
    }

    @JsonIgnore
    public Label getLblShiharaizu() {
        return this.cellShiharaizu.getLblShiharaizu();
    }

    @JsonIgnore
    public Label getLblchoshu() {
        return this.cellchoshu.getLblchoshu();
    }

    @JsonIgnore
    public Label getLblreinyu() {
        return this.cellreinyu.getLblreinyu();
    }

    @JsonIgnore
    public Label getLblmishiharaigaku() {
        return this.celllmishiharaigaku.getLblmishiharaigaku();
    }

    @JsonIgnore
    public Label getLblkaigoSer() {
        return this.cellkaigoSer.getLblkaigoSer();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi1() {
        return this.cellShiharaigi1.getTxtShiharaigi1();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu1() {
        return this.cellShiharaizu1.getTxtShiharaizu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu1() {
        return this.cellChoshu1.getTxtChoshu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu1() {
        return this.cellReinyu1.getTxtReinyu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku1() {
        return this.cellmishiharaigaku1.getTxtlmishiharaigaku1();
    }

    @JsonIgnore
    public Label getLblkaigoyoboSer() {
        return this.cellkaigoyoboSer.getLblkaigoyoboSer();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi2() {
        return this.cellShiharaigi2.getTxtShiharaigi2();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu2() {
        return this.cellShiharaizu2.getTxtShiharaizu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu2() {
        return this.cellChoshu2.getTxtChoshu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu2() {
        return this.cellReinyu2.getTxtReinyu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku2() {
        return this.cellmishiharaigaku2.getTxtlmishiharaigaku2();
    }

    @JsonIgnore
    public Label getLblkogakukaigoSer() {
        return this.cellkogakukaigoSer.getLblkogakukaigoSer();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi3() {
        return this.cellShiharaigi3.getTxtShiharaigi3();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu3() {
        return this.cellShiharaizu3.getTxtShiharaizu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu3() {
        return this.cellChoshu3.getTxtChoshu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu3() {
        return this.cellReinyu3.getTxtReinyu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku3() {
        return this.cellmishiharaigaku3.getTxtlmishiharaigaku3();
    }

    @JsonIgnore
    public Label getLblkogakuiryo() {
        return this.cellkogakuiryo.getLblkogakuiryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi4() {
        return this.cellShiharaigi4.getTxtShiharaigi4();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu4() {
        return this.cellShiharaizu4.getTxtShiharaizu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu4() {
        return this.cellChoshu4.getTxtChoshu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu4() {
        return this.cellReinyu4.getTxtReinyu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku4() {
        return this.cellmishiharaigaku4.getTxtlmishiharaigaku4();
    }

    @JsonIgnore
    public Label getLbltokuteinyusho() {
        return this.celltokuteinyusho.getLbltokuteinyusho();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi5() {
        return this.cellShiharaigi5.getTxtShiharaigi5();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu5() {
        return this.cellShiharaizu5.getTxtShiharaizu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu5() {
        return this.cellchoshu5.getTxtChoshu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu5() {
        return this.cellReinyu5.getTxtReinyu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku5() {
        return this.cellmishiharaigaku5.getTxtlmishiharaigaku5();
    }

    @JsonIgnore
    public Label getLblsonota() {
        return this.cellsonota.getLblsonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi6() {
        return this.cellShiharaigi6.getTxtShiharaigi6();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu6() {
        return this.cellShiharaizu6.getTxtShiharaizu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu6() {
        return this.cellChoshu6.getTxtChoshu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu6() {
        return this.cellReinyu6.getTxtReinyu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku6() {
        return this.cellmishiharaigaku6.getTxtlmishiharaigaku6();
    }

    @JsonIgnore
    public Label getLblkeii() {
        return this.cellkeii.getLblkeii();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi7() {
        return this.cellShiharaigi7.getTxtShiharaigi7();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu7() {
        return this.cellShiharaizu7.getTxtShiharaizu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu7() {
        return this.cellChoshu7.getTxtChoshu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu7() {
        return this.cellReinyu7.getTxtReinyu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku7() {
        return this.cellmishiharaigaku7.getTxtlmishiharaigaku7();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcellgubun
     * @return cellgubun
     */
    @JsonProperty("cellgubun")
    private cellgubunAttblhokenkyufushiharaijokyo getCellgubun() {
        return cellgubun;
    }

    /*
     * setcellgubun
     * @param cellgubun cellgubun
     */
    @JsonProperty("cellgubun")
    private void setCellgubun(cellgubunAttblhokenkyufushiharaijokyo cellgubun) {
        this.cellgubun = cellgubun;
    }

    /*
     * getcellShiharaigi
     * @return cellShiharaigi
     */
    @JsonProperty("cellShiharaigi")
    private cellShiharaigiAttblhokenkyufushiharaijokyo getCellShiharaigi() {
        return cellShiharaigi;
    }

    /*
     * setcellShiharaigi
     * @param cellShiharaigi cellShiharaigi
     */
    @JsonProperty("cellShiharaigi")
    private void setCellShiharaigi(cellShiharaigiAttblhokenkyufushiharaijokyo cellShiharaigi) {
        this.cellShiharaigi = cellShiharaigi;
    }

    /*
     * getcellShiharaizu
     * @return cellShiharaizu
     */
    @JsonProperty("cellShiharaizu")
    private cellShiharaizuAttblhokenkyufushiharaijokyo getCellShiharaizu() {
        return cellShiharaizu;
    }

    /*
     * setcellShiharaizu
     * @param cellShiharaizu cellShiharaizu
     */
    @JsonProperty("cellShiharaizu")
    private void setCellShiharaizu(cellShiharaizuAttblhokenkyufushiharaijokyo cellShiharaizu) {
        this.cellShiharaizu = cellShiharaizu;
    }

    /*
     * getcellchoshu
     * @return cellchoshu
     */
    @JsonProperty("cellchoshu")
    private cellchoshuAttblhokenkyufushiharaijokyo getCellchoshu() {
        return cellchoshu;
    }

    /*
     * setcellchoshu
     * @param cellchoshu cellchoshu
     */
    @JsonProperty("cellchoshu")
    private void setCellchoshu(cellchoshuAttblhokenkyufushiharaijokyo cellchoshu) {
        this.cellchoshu = cellchoshu;
    }

    /*
     * getcellreinyu
     * @return cellreinyu
     */
    @JsonProperty("cellreinyu")
    private cellreinyuAttblhokenkyufushiharaijokyo getCellreinyu() {
        return cellreinyu;
    }

    /*
     * setcellreinyu
     * @param cellreinyu cellreinyu
     */
    @JsonProperty("cellreinyu")
    private void setCellreinyu(cellreinyuAttblhokenkyufushiharaijokyo cellreinyu) {
        this.cellreinyu = cellreinyu;
    }

    /*
     * getcelllmishiharaigaku
     * @return celllmishiharaigaku
     */
    @JsonProperty("celllmishiharaigaku")
    private celllmishiharaigakuAttblhokenkyufushiharaijokyo getCelllmishiharaigaku() {
        return celllmishiharaigaku;
    }

    /*
     * setcelllmishiharaigaku
     * @param celllmishiharaigaku celllmishiharaigaku
     */
    @JsonProperty("celllmishiharaigaku")
    private void setCelllmishiharaigaku(celllmishiharaigakuAttblhokenkyufushiharaijokyo celllmishiharaigaku) {
        this.celllmishiharaigaku = celllmishiharaigaku;
    }

    /*
     * getcellkaigoSer
     * @return cellkaigoSer
     */
    @JsonProperty("cellkaigoSer")
    private cellkaigoSerAttblhokenkyufushiharaijokyo getCellkaigoSer() {
        return cellkaigoSer;
    }

    /*
     * setcellkaigoSer
     * @param cellkaigoSer cellkaigoSer
     */
    @JsonProperty("cellkaigoSer")
    private void setCellkaigoSer(cellkaigoSerAttblhokenkyufushiharaijokyo cellkaigoSer) {
        this.cellkaigoSer = cellkaigoSer;
    }

    /*
     * getcellShiharaigi1
     * @return cellShiharaigi1
     */
    @JsonProperty("cellShiharaigi1")
    private cellShiharaigi1Attblhokenkyufushiharaijokyo getCellShiharaigi1() {
        return cellShiharaigi1;
    }

    /*
     * setcellShiharaigi1
     * @param cellShiharaigi1 cellShiharaigi1
     */
    @JsonProperty("cellShiharaigi1")
    private void setCellShiharaigi1(cellShiharaigi1Attblhokenkyufushiharaijokyo cellShiharaigi1) {
        this.cellShiharaigi1 = cellShiharaigi1;
    }

    /*
     * getcellShiharaizu1
     * @return cellShiharaizu1
     */
    @JsonProperty("cellShiharaizu1")
    private cellShiharaizu1Attblhokenkyufushiharaijokyo getCellShiharaizu1() {
        return cellShiharaizu1;
    }

    /*
     * setcellShiharaizu1
     * @param cellShiharaizu1 cellShiharaizu1
     */
    @JsonProperty("cellShiharaizu1")
    private void setCellShiharaizu1(cellShiharaizu1Attblhokenkyufushiharaijokyo cellShiharaizu1) {
        this.cellShiharaizu1 = cellShiharaizu1;
    }

    /*
     * getcellChoshu1
     * @return cellChoshu1
     */
    @JsonProperty("cellChoshu1")
    private cellChoshu1Attblhokenkyufushiharaijokyo getCellChoshu1() {
        return cellChoshu1;
    }

    /*
     * setcellChoshu1
     * @param cellChoshu1 cellChoshu1
     */
    @JsonProperty("cellChoshu1")
    private void setCellChoshu1(cellChoshu1Attblhokenkyufushiharaijokyo cellChoshu1) {
        this.cellChoshu1 = cellChoshu1;
    }

    /*
     * getcellReinyu1
     * @return cellReinyu1
     */
    @JsonProperty("cellReinyu1")
    private cellReinyu1Attblhokenkyufushiharaijokyo getCellReinyu1() {
        return cellReinyu1;
    }

    /*
     * setcellReinyu1
     * @param cellReinyu1 cellReinyu1
     */
    @JsonProperty("cellReinyu1")
    private void setCellReinyu1(cellReinyu1Attblhokenkyufushiharaijokyo cellReinyu1) {
        this.cellReinyu1 = cellReinyu1;
    }

    /*
     * getcellmishiharaigaku1
     * @return cellmishiharaigaku1
     */
    @JsonProperty("cellmishiharaigaku1")
    private cellmishiharaigaku1Attblhokenkyufushiharaijokyo getCellmishiharaigaku1() {
        return cellmishiharaigaku1;
    }

    /*
     * setcellmishiharaigaku1
     * @param cellmishiharaigaku1 cellmishiharaigaku1
     */
    @JsonProperty("cellmishiharaigaku1")
    private void setCellmishiharaigaku1(cellmishiharaigaku1Attblhokenkyufushiharaijokyo cellmishiharaigaku1) {
        this.cellmishiharaigaku1 = cellmishiharaigaku1;
    }

    /*
     * getcellkaigoyoboSer
     * @return cellkaigoyoboSer
     */
    @JsonProperty("cellkaigoyoboSer")
    private cellkaigoyoboSerAttblhokenkyufushiharaijokyo getCellkaigoyoboSer() {
        return cellkaigoyoboSer;
    }

    /*
     * setcellkaigoyoboSer
     * @param cellkaigoyoboSer cellkaigoyoboSer
     */
    @JsonProperty("cellkaigoyoboSer")
    private void setCellkaigoyoboSer(cellkaigoyoboSerAttblhokenkyufushiharaijokyo cellkaigoyoboSer) {
        this.cellkaigoyoboSer = cellkaigoyoboSer;
    }

    /*
     * getcellShiharaigi2
     * @return cellShiharaigi2
     */
    @JsonProperty("cellShiharaigi2")
    private cellShiharaigi2Attblhokenkyufushiharaijokyo getCellShiharaigi2() {
        return cellShiharaigi2;
    }

    /*
     * setcellShiharaigi2
     * @param cellShiharaigi2 cellShiharaigi2
     */
    @JsonProperty("cellShiharaigi2")
    private void setCellShiharaigi2(cellShiharaigi2Attblhokenkyufushiharaijokyo cellShiharaigi2) {
        this.cellShiharaigi2 = cellShiharaigi2;
    }

    /*
     * getcellShiharaizu2
     * @return cellShiharaizu2
     */
    @JsonProperty("cellShiharaizu2")
    private cellShiharaizu2Attblhokenkyufushiharaijokyo getCellShiharaizu2() {
        return cellShiharaizu2;
    }

    /*
     * setcellShiharaizu2
     * @param cellShiharaizu2 cellShiharaizu2
     */
    @JsonProperty("cellShiharaizu2")
    private void setCellShiharaizu2(cellShiharaizu2Attblhokenkyufushiharaijokyo cellShiharaizu2) {
        this.cellShiharaizu2 = cellShiharaizu2;
    }

    /*
     * getcellChoshu2
     * @return cellChoshu2
     */
    @JsonProperty("cellChoshu2")
    private cellChoshu2Attblhokenkyufushiharaijokyo getCellChoshu2() {
        return cellChoshu2;
    }

    /*
     * setcellChoshu2
     * @param cellChoshu2 cellChoshu2
     */
    @JsonProperty("cellChoshu2")
    private void setCellChoshu2(cellChoshu2Attblhokenkyufushiharaijokyo cellChoshu2) {
        this.cellChoshu2 = cellChoshu2;
    }

    /*
     * getcellReinyu2
     * @return cellReinyu2
     */
    @JsonProperty("cellReinyu2")
    private cellReinyu2Attblhokenkyufushiharaijokyo getCellReinyu2() {
        return cellReinyu2;
    }

    /*
     * setcellReinyu2
     * @param cellReinyu2 cellReinyu2
     */
    @JsonProperty("cellReinyu2")
    private void setCellReinyu2(cellReinyu2Attblhokenkyufushiharaijokyo cellReinyu2) {
        this.cellReinyu2 = cellReinyu2;
    }

    /*
     * getcellmishiharaigaku2
     * @return cellmishiharaigaku2
     */
    @JsonProperty("cellmishiharaigaku2")
    private cellmishiharaigaku2Attblhokenkyufushiharaijokyo getCellmishiharaigaku2() {
        return cellmishiharaigaku2;
    }

    /*
     * setcellmishiharaigaku2
     * @param cellmishiharaigaku2 cellmishiharaigaku2
     */
    @JsonProperty("cellmishiharaigaku2")
    private void setCellmishiharaigaku2(cellmishiharaigaku2Attblhokenkyufushiharaijokyo cellmishiharaigaku2) {
        this.cellmishiharaigaku2 = cellmishiharaigaku2;
    }

    /*
     * getcellkogakukaigoSer
     * @return cellkogakukaigoSer
     */
    @JsonProperty("cellkogakukaigoSer")
    private cellkogakukaigoSerAttblhokenkyufushiharaijokyo getCellkogakukaigoSer() {
        return cellkogakukaigoSer;
    }

    /*
     * setcellkogakukaigoSer
     * @param cellkogakukaigoSer cellkogakukaigoSer
     */
    @JsonProperty("cellkogakukaigoSer")
    private void setCellkogakukaigoSer(cellkogakukaigoSerAttblhokenkyufushiharaijokyo cellkogakukaigoSer) {
        this.cellkogakukaigoSer = cellkogakukaigoSer;
    }

    /*
     * getcellShiharaigi3
     * @return cellShiharaigi3
     */
    @JsonProperty("cellShiharaigi3")
    private cellShiharaigi3Attblhokenkyufushiharaijokyo getCellShiharaigi3() {
        return cellShiharaigi3;
    }

    /*
     * setcellShiharaigi3
     * @param cellShiharaigi3 cellShiharaigi3
     */
    @JsonProperty("cellShiharaigi3")
    private void setCellShiharaigi3(cellShiharaigi3Attblhokenkyufushiharaijokyo cellShiharaigi3) {
        this.cellShiharaigi3 = cellShiharaigi3;
    }

    /*
     * getcellShiharaizu3
     * @return cellShiharaizu3
     */
    @JsonProperty("cellShiharaizu3")
    private cellShiharaizu3Attblhokenkyufushiharaijokyo getCellShiharaizu3() {
        return cellShiharaizu3;
    }

    /*
     * setcellShiharaizu3
     * @param cellShiharaizu3 cellShiharaizu3
     */
    @JsonProperty("cellShiharaizu3")
    private void setCellShiharaizu3(cellShiharaizu3Attblhokenkyufushiharaijokyo cellShiharaizu3) {
        this.cellShiharaizu3 = cellShiharaizu3;
    }

    /*
     * getcellChoshu3
     * @return cellChoshu3
     */
    @JsonProperty("cellChoshu3")
    private cellChoshu3Attblhokenkyufushiharaijokyo getCellChoshu3() {
        return cellChoshu3;
    }

    /*
     * setcellChoshu3
     * @param cellChoshu3 cellChoshu3
     */
    @JsonProperty("cellChoshu3")
    private void setCellChoshu3(cellChoshu3Attblhokenkyufushiharaijokyo cellChoshu3) {
        this.cellChoshu3 = cellChoshu3;
    }

    /*
     * getcellReinyu3
     * @return cellReinyu3
     */
    @JsonProperty("cellReinyu3")
    private cellReinyu3Attblhokenkyufushiharaijokyo getCellReinyu3() {
        return cellReinyu3;
    }

    /*
     * setcellReinyu3
     * @param cellReinyu3 cellReinyu3
     */
    @JsonProperty("cellReinyu3")
    private void setCellReinyu3(cellReinyu3Attblhokenkyufushiharaijokyo cellReinyu3) {
        this.cellReinyu3 = cellReinyu3;
    }

    /*
     * getcellmishiharaigaku3
     * @return cellmishiharaigaku3
     */
    @JsonProperty("cellmishiharaigaku3")
    private cellmishiharaigaku3Attblhokenkyufushiharaijokyo getCellmishiharaigaku3() {
        return cellmishiharaigaku3;
    }

    /*
     * setcellmishiharaigaku3
     * @param cellmishiharaigaku3 cellmishiharaigaku3
     */
    @JsonProperty("cellmishiharaigaku3")
    private void setCellmishiharaigaku3(cellmishiharaigaku3Attblhokenkyufushiharaijokyo cellmishiharaigaku3) {
        this.cellmishiharaigaku3 = cellmishiharaigaku3;
    }

    /*
     * getcellkogakuiryo
     * @return cellkogakuiryo
     */
    @JsonProperty("cellkogakuiryo")
    private cellkogakuiryoAttblhokenkyufushiharaijokyo getCellkogakuiryo() {
        return cellkogakuiryo;
    }

    /*
     * setcellkogakuiryo
     * @param cellkogakuiryo cellkogakuiryo
     */
    @JsonProperty("cellkogakuiryo")
    private void setCellkogakuiryo(cellkogakuiryoAttblhokenkyufushiharaijokyo cellkogakuiryo) {
        this.cellkogakuiryo = cellkogakuiryo;
    }

    /*
     * getcellShiharaigi4
     * @return cellShiharaigi4
     */
    @JsonProperty("cellShiharaigi4")
    private cellShiharaigi4Attblhokenkyufushiharaijokyo getCellShiharaigi4() {
        return cellShiharaigi4;
    }

    /*
     * setcellShiharaigi4
     * @param cellShiharaigi4 cellShiharaigi4
     */
    @JsonProperty("cellShiharaigi4")
    private void setCellShiharaigi4(cellShiharaigi4Attblhokenkyufushiharaijokyo cellShiharaigi4) {
        this.cellShiharaigi4 = cellShiharaigi4;
    }

    /*
     * getcellShiharaizu4
     * @return cellShiharaizu4
     */
    @JsonProperty("cellShiharaizu4")
    private cellShiharaizu4Attblhokenkyufushiharaijokyo getCellShiharaizu4() {
        return cellShiharaizu4;
    }

    /*
     * setcellShiharaizu4
     * @param cellShiharaizu4 cellShiharaizu4
     */
    @JsonProperty("cellShiharaizu4")
    private void setCellShiharaizu4(cellShiharaizu4Attblhokenkyufushiharaijokyo cellShiharaizu4) {
        this.cellShiharaizu4 = cellShiharaizu4;
    }

    /*
     * getcellChoshu4
     * @return cellChoshu4
     */
    @JsonProperty("cellChoshu4")
    private cellChoshu4Attblhokenkyufushiharaijokyo getCellChoshu4() {
        return cellChoshu4;
    }

    /*
     * setcellChoshu4
     * @param cellChoshu4 cellChoshu4
     */
    @JsonProperty("cellChoshu4")
    private void setCellChoshu4(cellChoshu4Attblhokenkyufushiharaijokyo cellChoshu4) {
        this.cellChoshu4 = cellChoshu4;
    }

    /*
     * getcellReinyu4
     * @return cellReinyu4
     */
    @JsonProperty("cellReinyu4")
    private cellReinyu4Attblhokenkyufushiharaijokyo getCellReinyu4() {
        return cellReinyu4;
    }

    /*
     * setcellReinyu4
     * @param cellReinyu4 cellReinyu4
     */
    @JsonProperty("cellReinyu4")
    private void setCellReinyu4(cellReinyu4Attblhokenkyufushiharaijokyo cellReinyu4) {
        this.cellReinyu4 = cellReinyu4;
    }

    /*
     * getcellmishiharaigaku4
     * @return cellmishiharaigaku4
     */
    @JsonProperty("cellmishiharaigaku4")
    private cellmishiharaigaku4Attblhokenkyufushiharaijokyo getCellmishiharaigaku4() {
        return cellmishiharaigaku4;
    }

    /*
     * setcellmishiharaigaku4
     * @param cellmishiharaigaku4 cellmishiharaigaku4
     */
    @JsonProperty("cellmishiharaigaku4")
    private void setCellmishiharaigaku4(cellmishiharaigaku4Attblhokenkyufushiharaijokyo cellmishiharaigaku4) {
        this.cellmishiharaigaku4 = cellmishiharaigaku4;
    }

    /*
     * getcelltokuteinyusho
     * @return celltokuteinyusho
     */
    @JsonProperty("celltokuteinyusho")
    private celltokuteinyushoAttblhokenkyufushiharaijokyo getCelltokuteinyusho() {
        return celltokuteinyusho;
    }

    /*
     * setcelltokuteinyusho
     * @param celltokuteinyusho celltokuteinyusho
     */
    @JsonProperty("celltokuteinyusho")
    private void setCelltokuteinyusho(celltokuteinyushoAttblhokenkyufushiharaijokyo celltokuteinyusho) {
        this.celltokuteinyusho = celltokuteinyusho;
    }

    /*
     * getcellShiharaigi5
     * @return cellShiharaigi5
     */
    @JsonProperty("cellShiharaigi5")
    private cellShiharaigi5Attblhokenkyufushiharaijokyo getCellShiharaigi5() {
        return cellShiharaigi5;
    }

    /*
     * setcellShiharaigi5
     * @param cellShiharaigi5 cellShiharaigi5
     */
    @JsonProperty("cellShiharaigi5")
    private void setCellShiharaigi5(cellShiharaigi5Attblhokenkyufushiharaijokyo cellShiharaigi5) {
        this.cellShiharaigi5 = cellShiharaigi5;
    }

    /*
     * getcellShiharaizu5
     * @return cellShiharaizu5
     */
    @JsonProperty("cellShiharaizu5")
    private cellShiharaizu5Attblhokenkyufushiharaijokyo getCellShiharaizu5() {
        return cellShiharaizu5;
    }

    /*
     * setcellShiharaizu5
     * @param cellShiharaizu5 cellShiharaizu5
     */
    @JsonProperty("cellShiharaizu5")
    private void setCellShiharaizu5(cellShiharaizu5Attblhokenkyufushiharaijokyo cellShiharaizu5) {
        this.cellShiharaizu5 = cellShiharaizu5;
    }

    /*
     * getcellchoshu5
     * @return cellchoshu5
     */
    @JsonProperty("cellchoshu5")
    private cellchoshu5Attblhokenkyufushiharaijokyo getCellchoshu5() {
        return cellchoshu5;
    }

    /*
     * setcellchoshu5
     * @param cellchoshu5 cellchoshu5
     */
    @JsonProperty("cellchoshu5")
    private void setCellchoshu5(cellchoshu5Attblhokenkyufushiharaijokyo cellchoshu5) {
        this.cellchoshu5 = cellchoshu5;
    }

    /*
     * getcellReinyu5
     * @return cellReinyu5
     */
    @JsonProperty("cellReinyu5")
    private cellReinyu5Attblhokenkyufushiharaijokyo getCellReinyu5() {
        return cellReinyu5;
    }

    /*
     * setcellReinyu5
     * @param cellReinyu5 cellReinyu5
     */
    @JsonProperty("cellReinyu5")
    private void setCellReinyu5(cellReinyu5Attblhokenkyufushiharaijokyo cellReinyu5) {
        this.cellReinyu5 = cellReinyu5;
    }

    /*
     * getcellmishiharaigaku5
     * @return cellmishiharaigaku5
     */
    @JsonProperty("cellmishiharaigaku5")
    private cellmishiharaigaku5Attblhokenkyufushiharaijokyo getCellmishiharaigaku5() {
        return cellmishiharaigaku5;
    }

    /*
     * setcellmishiharaigaku5
     * @param cellmishiharaigaku5 cellmishiharaigaku5
     */
    @JsonProperty("cellmishiharaigaku5")
    private void setCellmishiharaigaku5(cellmishiharaigaku5Attblhokenkyufushiharaijokyo cellmishiharaigaku5) {
        this.cellmishiharaigaku5 = cellmishiharaigaku5;
    }

    /*
     * getcellsonota
     * @return cellsonota
     */
    @JsonProperty("cellsonota")
    private cellsonotaAttblhokenkyufushiharaijokyo getCellsonota() {
        return cellsonota;
    }

    /*
     * setcellsonota
     * @param cellsonota cellsonota
     */
    @JsonProperty("cellsonota")
    private void setCellsonota(cellsonotaAttblhokenkyufushiharaijokyo cellsonota) {
        this.cellsonota = cellsonota;
    }

    /*
     * getcellShiharaigi6
     * @return cellShiharaigi6
     */
    @JsonProperty("cellShiharaigi6")
    private cellShiharaigi6Attblhokenkyufushiharaijokyo getCellShiharaigi6() {
        return cellShiharaigi6;
    }

    /*
     * setcellShiharaigi6
     * @param cellShiharaigi6 cellShiharaigi6
     */
    @JsonProperty("cellShiharaigi6")
    private void setCellShiharaigi6(cellShiharaigi6Attblhokenkyufushiharaijokyo cellShiharaigi6) {
        this.cellShiharaigi6 = cellShiharaigi6;
    }

    /*
     * getcellShiharaizu6
     * @return cellShiharaizu6
     */
    @JsonProperty("cellShiharaizu6")
    private cellShiharaizu6Attblhokenkyufushiharaijokyo getCellShiharaizu6() {
        return cellShiharaizu6;
    }

    /*
     * setcellShiharaizu6
     * @param cellShiharaizu6 cellShiharaizu6
     */
    @JsonProperty("cellShiharaizu6")
    private void setCellShiharaizu6(cellShiharaizu6Attblhokenkyufushiharaijokyo cellShiharaizu6) {
        this.cellShiharaizu6 = cellShiharaizu6;
    }

    /*
     * getcellChoshu6
     * @return cellChoshu6
     */
    @JsonProperty("cellChoshu6")
    private cellChoshu6Attblhokenkyufushiharaijokyo getCellChoshu6() {
        return cellChoshu6;
    }

    /*
     * setcellChoshu6
     * @param cellChoshu6 cellChoshu6
     */
    @JsonProperty("cellChoshu6")
    private void setCellChoshu6(cellChoshu6Attblhokenkyufushiharaijokyo cellChoshu6) {
        this.cellChoshu6 = cellChoshu6;
    }

    /*
     * getcellReinyu6
     * @return cellReinyu6
     */
    @JsonProperty("cellReinyu6")
    private cellReinyu6Attblhokenkyufushiharaijokyo getCellReinyu6() {
        return cellReinyu6;
    }

    /*
     * setcellReinyu6
     * @param cellReinyu6 cellReinyu6
     */
    @JsonProperty("cellReinyu6")
    private void setCellReinyu6(cellReinyu6Attblhokenkyufushiharaijokyo cellReinyu6) {
        this.cellReinyu6 = cellReinyu6;
    }

    /*
     * getcellmishiharaigaku6
     * @return cellmishiharaigaku6
     */
    @JsonProperty("cellmishiharaigaku6")
    private cellmishiharaigaku6Attblhokenkyufushiharaijokyo getCellmishiharaigaku6() {
        return cellmishiharaigaku6;
    }

    /*
     * setcellmishiharaigaku6
     * @param cellmishiharaigaku6 cellmishiharaigaku6
     */
    @JsonProperty("cellmishiharaigaku6")
    private void setCellmishiharaigaku6(cellmishiharaigaku6Attblhokenkyufushiharaijokyo cellmishiharaigaku6) {
        this.cellmishiharaigaku6 = cellmishiharaigaku6;
    }

    /*
     * getcellkeii
     * @return cellkeii
     */
    @JsonProperty("cellkeii")
    private cellkeiiAttblhokenkyufushiharaijokyo getCellkeii() {
        return cellkeii;
    }

    /*
     * setcellkeii
     * @param cellkeii cellkeii
     */
    @JsonProperty("cellkeii")
    private void setCellkeii(cellkeiiAttblhokenkyufushiharaijokyo cellkeii) {
        this.cellkeii = cellkeii;
    }

    /*
     * getcellShiharaigi7
     * @return cellShiharaigi7
     */
    @JsonProperty("cellShiharaigi7")
    private cellShiharaigi7Attblhokenkyufushiharaijokyo getCellShiharaigi7() {
        return cellShiharaigi7;
    }

    /*
     * setcellShiharaigi7
     * @param cellShiharaigi7 cellShiharaigi7
     */
    @JsonProperty("cellShiharaigi7")
    private void setCellShiharaigi7(cellShiharaigi7Attblhokenkyufushiharaijokyo cellShiharaigi7) {
        this.cellShiharaigi7 = cellShiharaigi7;
    }

    /*
     * getcellShiharaizu7
     * @return cellShiharaizu7
     */
    @JsonProperty("cellShiharaizu7")
    private cellShiharaizu7Attblhokenkyufushiharaijokyo getCellShiharaizu7() {
        return cellShiharaizu7;
    }

    /*
     * setcellShiharaizu7
     * @param cellShiharaizu7 cellShiharaizu7
     */
    @JsonProperty("cellShiharaizu7")
    private void setCellShiharaizu7(cellShiharaizu7Attblhokenkyufushiharaijokyo cellShiharaizu7) {
        this.cellShiharaizu7 = cellShiharaizu7;
    }

    /*
     * getcellChoshu7
     * @return cellChoshu7
     */
    @JsonProperty("cellChoshu7")
    private cellChoshu7Attblhokenkyufushiharaijokyo getCellChoshu7() {
        return cellChoshu7;
    }

    /*
     * setcellChoshu7
     * @param cellChoshu7 cellChoshu7
     */
    @JsonProperty("cellChoshu7")
    private void setCellChoshu7(cellChoshu7Attblhokenkyufushiharaijokyo cellChoshu7) {
        this.cellChoshu7 = cellChoshu7;
    }

    /*
     * getcellReinyu7
     * @return cellReinyu7
     */
    @JsonProperty("cellReinyu7")
    private cellReinyu7Attblhokenkyufushiharaijokyo getCellReinyu7() {
        return cellReinyu7;
    }

    /*
     * setcellReinyu7
     * @param cellReinyu7 cellReinyu7
     */
    @JsonProperty("cellReinyu7")
    private void setCellReinyu7(cellReinyu7Attblhokenkyufushiharaijokyo cellReinyu7) {
        this.cellReinyu7 = cellReinyu7;
    }

    /*
     * getcellmishiharaigaku7
     * @return cellmishiharaigaku7
     */
    @JsonProperty("cellmishiharaigaku7")
    private cellmishiharaigaku7Attblhokenkyufushiharaijokyo getCellmishiharaigaku7() {
        return cellmishiharaigaku7;
    }

    /*
     * setcellmishiharaigaku7
     * @param cellmishiharaigaku7 cellmishiharaigaku7
     */
    @JsonProperty("cellmishiharaigaku7")
    private void setCellmishiharaigaku7(cellmishiharaigaku7Attblhokenkyufushiharaijokyo cellmishiharaigaku7) {
        this.cellmishiharaigaku7 = cellmishiharaigaku7;
    }

    // </editor-fold>
}
/**
 * cellgubun のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgubunAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblgubun")
    private Label lblgubun;

    /*
     * getlblgubun
     * @return lblgubun
     */
    @JsonProperty("lblgubun")
    public Label getLblgubun() {
        return lblgubun;
    }

    /*
     * setlblgubun
     * @param lblgubun lblgubun
     */
    @JsonProperty("lblgubun")
    public void setLblgubun(Label lblgubun) {
        this.lblgubun = lblgubun;
    }

    // </editor-fold>
}
/**
 * cellShiharaigi のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaigiAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblShiharaigi")
    private Label lblShiharaigi;

    /*
     * getlblShiharaigi
     * @return lblShiharaigi
     */
    @JsonProperty("lblShiharaigi")
    public Label getLblShiharaigi() {
        return lblShiharaigi;
    }

    /*
     * setlblShiharaigi
     * @param lblShiharaigi lblShiharaigi
     */
    @JsonProperty("lblShiharaigi")
    public void setLblShiharaigi(Label lblShiharaigi) {
        this.lblShiharaigi = lblShiharaigi;
    }

    // </editor-fold>
}
/**
 * cellShiharaizu のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaizuAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblShiharaizu")
    private Label lblShiharaizu;

    /*
     * getlblShiharaizu
     * @return lblShiharaizu
     */
    @JsonProperty("lblShiharaizu")
    public Label getLblShiharaizu() {
        return lblShiharaizu;
    }

    /*
     * setlblShiharaizu
     * @param lblShiharaizu lblShiharaizu
     */
    @JsonProperty("lblShiharaizu")
    public void setLblShiharaizu(Label lblShiharaizu) {
        this.lblShiharaizu = lblShiharaizu;
    }

    // </editor-fold>
}
/**
 * cellchoshu のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchoshuAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblchoshu")
    private Label lblchoshu;

    /*
     * getlblchoshu
     * @return lblchoshu
     */
    @JsonProperty("lblchoshu")
    public Label getLblchoshu() {
        return lblchoshu;
    }

    /*
     * setlblchoshu
     * @param lblchoshu lblchoshu
     */
    @JsonProperty("lblchoshu")
    public void setLblchoshu(Label lblchoshu) {
        this.lblchoshu = lblchoshu;
    }

    // </editor-fold>
}
/**
 * cellreinyu のクラスファイル 
 * 
 * @author 自動生成
 */
class cellreinyuAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblreinyu")
    private Label lblreinyu;

    /*
     * getlblreinyu
     * @return lblreinyu
     */
    @JsonProperty("lblreinyu")
    public Label getLblreinyu() {
        return lblreinyu;
    }

    /*
     * setlblreinyu
     * @param lblreinyu lblreinyu
     */
    @JsonProperty("lblreinyu")
    public void setLblreinyu(Label lblreinyu) {
        this.lblreinyu = lblreinyu;
    }

    // </editor-fold>
}
/**
 * celllmishiharaigaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celllmishiharaigakuAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblmishiharaigaku")
    private Label lblmishiharaigaku;

    /*
     * getlblmishiharaigaku
     * @return lblmishiharaigaku
     */
    @JsonProperty("lblmishiharaigaku")
    public Label getLblmishiharaigaku() {
        return lblmishiharaigaku;
    }

    /*
     * setlblmishiharaigaku
     * @param lblmishiharaigaku lblmishiharaigaku
     */
    @JsonProperty("lblmishiharaigaku")
    public void setLblmishiharaigaku(Label lblmishiharaigaku) {
        this.lblmishiharaigaku = lblmishiharaigaku;
    }

    // </editor-fold>
}
/**
 * cellkaigoSer のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkaigoSerAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblkaigoSer")
    private Label lblkaigoSer;

    /*
     * getlblkaigoSer
     * @return lblkaigoSer
     */
    @JsonProperty("lblkaigoSer")
    public Label getLblkaigoSer() {
        return lblkaigoSer;
    }

    /*
     * setlblkaigoSer
     * @param lblkaigoSer lblkaigoSer
     */
    @JsonProperty("lblkaigoSer")
    public void setLblkaigoSer(Label lblkaigoSer) {
        this.lblkaigoSer = lblkaigoSer;
    }

    // </editor-fold>
}
/**
 * cellShiharaigi1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaigi1Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaigi1")
    private TextBoxNum txtShiharaigi1;

    /*
     * gettxtShiharaigi1
     * @return txtShiharaigi1
     */
    @JsonProperty("txtShiharaigi1")
    public TextBoxNum getTxtShiharaigi1() {
        return txtShiharaigi1;
    }

    /*
     * settxtShiharaigi1
     * @param txtShiharaigi1 txtShiharaigi1
     */
    @JsonProperty("txtShiharaigi1")
    public void setTxtShiharaigi1(TextBoxNum txtShiharaigi1) {
        this.txtShiharaigi1 = txtShiharaigi1;
    }

    // </editor-fold>
}
/**
 * cellShiharaizu1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaizu1Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaizu1")
    private TextBoxNum txtShiharaizu1;

    /*
     * gettxtShiharaizu1
     * @return txtShiharaizu1
     */
    @JsonProperty("txtShiharaizu1")
    public TextBoxNum getTxtShiharaizu1() {
        return txtShiharaizu1;
    }

    /*
     * settxtShiharaizu1
     * @param txtShiharaizu1 txtShiharaizu1
     */
    @JsonProperty("txtShiharaizu1")
    public void setTxtShiharaizu1(TextBoxNum txtShiharaizu1) {
        this.txtShiharaizu1 = txtShiharaizu1;
    }

    // </editor-fold>
}
/**
 * cellChoshu1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellChoshu1Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtChoshu1")
    private TextBoxNum txtChoshu1;

    /*
     * gettxtChoshu1
     * @return txtChoshu1
     */
    @JsonProperty("txtChoshu1")
    public TextBoxNum getTxtChoshu1() {
        return txtChoshu1;
    }

    /*
     * settxtChoshu1
     * @param txtChoshu1 txtChoshu1
     */
    @JsonProperty("txtChoshu1")
    public void setTxtChoshu1(TextBoxNum txtChoshu1) {
        this.txtChoshu1 = txtChoshu1;
    }

    // </editor-fold>
}
/**
 * cellReinyu1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellReinyu1Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtReinyu1")
    private TextBoxNum txtReinyu1;

    /*
     * gettxtReinyu1
     * @return txtReinyu1
     */
    @JsonProperty("txtReinyu1")
    public TextBoxNum getTxtReinyu1() {
        return txtReinyu1;
    }

    /*
     * settxtReinyu1
     * @param txtReinyu1 txtReinyu1
     */
    @JsonProperty("txtReinyu1")
    public void setTxtReinyu1(TextBoxNum txtReinyu1) {
        this.txtReinyu1 = txtReinyu1;
    }

    // </editor-fold>
}
/**
 * cellmishiharaigaku1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmishiharaigaku1Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtlmishiharaigaku1")
    private TextBoxNum txtlmishiharaigaku1;

    /*
     * gettxtlmishiharaigaku1
     * @return txtlmishiharaigaku1
     */
    @JsonProperty("txtlmishiharaigaku1")
    public TextBoxNum getTxtlmishiharaigaku1() {
        return txtlmishiharaigaku1;
    }

    /*
     * settxtlmishiharaigaku1
     * @param txtlmishiharaigaku1 txtlmishiharaigaku1
     */
    @JsonProperty("txtlmishiharaigaku1")
    public void setTxtlmishiharaigaku1(TextBoxNum txtlmishiharaigaku1) {
        this.txtlmishiharaigaku1 = txtlmishiharaigaku1;
    }

    // </editor-fold>
}
/**
 * cellkaigoyoboSer のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkaigoyoboSerAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblkaigoyoboSer")
    private Label lblkaigoyoboSer;

    /*
     * getlblkaigoyoboSer
     * @return lblkaigoyoboSer
     */
    @JsonProperty("lblkaigoyoboSer")
    public Label getLblkaigoyoboSer() {
        return lblkaigoyoboSer;
    }

    /*
     * setlblkaigoyoboSer
     * @param lblkaigoyoboSer lblkaigoyoboSer
     */
    @JsonProperty("lblkaigoyoboSer")
    public void setLblkaigoyoboSer(Label lblkaigoyoboSer) {
        this.lblkaigoyoboSer = lblkaigoyoboSer;
    }

    // </editor-fold>
}
/**
 * cellShiharaigi2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaigi2Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaigi2")
    private TextBoxNum txtShiharaigi2;

    /*
     * gettxtShiharaigi2
     * @return txtShiharaigi2
     */
    @JsonProperty("txtShiharaigi2")
    public TextBoxNum getTxtShiharaigi2() {
        return txtShiharaigi2;
    }

    /*
     * settxtShiharaigi2
     * @param txtShiharaigi2 txtShiharaigi2
     */
    @JsonProperty("txtShiharaigi2")
    public void setTxtShiharaigi2(TextBoxNum txtShiharaigi2) {
        this.txtShiharaigi2 = txtShiharaigi2;
    }

    // </editor-fold>
}
/**
 * cellShiharaizu2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaizu2Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaizu2")
    private TextBoxNum txtShiharaizu2;

    /*
     * gettxtShiharaizu2
     * @return txtShiharaizu2
     */
    @JsonProperty("txtShiharaizu2")
    public TextBoxNum getTxtShiharaizu2() {
        return txtShiharaizu2;
    }

    /*
     * settxtShiharaizu2
     * @param txtShiharaizu2 txtShiharaizu2
     */
    @JsonProperty("txtShiharaizu2")
    public void setTxtShiharaizu2(TextBoxNum txtShiharaizu2) {
        this.txtShiharaizu2 = txtShiharaizu2;
    }

    // </editor-fold>
}
/**
 * cellChoshu2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellChoshu2Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtChoshu2")
    private TextBoxNum txtChoshu2;

    /*
     * gettxtChoshu2
     * @return txtChoshu2
     */
    @JsonProperty("txtChoshu2")
    public TextBoxNum getTxtChoshu2() {
        return txtChoshu2;
    }

    /*
     * settxtChoshu2
     * @param txtChoshu2 txtChoshu2
     */
    @JsonProperty("txtChoshu2")
    public void setTxtChoshu2(TextBoxNum txtChoshu2) {
        this.txtChoshu2 = txtChoshu2;
    }

    // </editor-fold>
}
/**
 * cellReinyu2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellReinyu2Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtReinyu2")
    private TextBoxNum txtReinyu2;

    /*
     * gettxtReinyu2
     * @return txtReinyu2
     */
    @JsonProperty("txtReinyu2")
    public TextBoxNum getTxtReinyu2() {
        return txtReinyu2;
    }

    /*
     * settxtReinyu2
     * @param txtReinyu2 txtReinyu2
     */
    @JsonProperty("txtReinyu2")
    public void setTxtReinyu2(TextBoxNum txtReinyu2) {
        this.txtReinyu2 = txtReinyu2;
    }

    // </editor-fold>
}
/**
 * cellmishiharaigaku2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmishiharaigaku2Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtlmishiharaigaku2")
    private TextBoxNum txtlmishiharaigaku2;

    /*
     * gettxtlmishiharaigaku2
     * @return txtlmishiharaigaku2
     */
    @JsonProperty("txtlmishiharaigaku2")
    public TextBoxNum getTxtlmishiharaigaku2() {
        return txtlmishiharaigaku2;
    }

    /*
     * settxtlmishiharaigaku2
     * @param txtlmishiharaigaku2 txtlmishiharaigaku2
     */
    @JsonProperty("txtlmishiharaigaku2")
    public void setTxtlmishiharaigaku2(TextBoxNum txtlmishiharaigaku2) {
        this.txtlmishiharaigaku2 = txtlmishiharaigaku2;
    }

    // </editor-fold>
}
/**
 * cellkogakukaigoSer のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkogakukaigoSerAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblkogakukaigoSer")
    private Label lblkogakukaigoSer;

    /*
     * getlblkogakukaigoSer
     * @return lblkogakukaigoSer
     */
    @JsonProperty("lblkogakukaigoSer")
    public Label getLblkogakukaigoSer() {
        return lblkogakukaigoSer;
    }

    /*
     * setlblkogakukaigoSer
     * @param lblkogakukaigoSer lblkogakukaigoSer
     */
    @JsonProperty("lblkogakukaigoSer")
    public void setLblkogakukaigoSer(Label lblkogakukaigoSer) {
        this.lblkogakukaigoSer = lblkogakukaigoSer;
    }

    // </editor-fold>
}
/**
 * cellShiharaigi3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaigi3Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaigi3")
    private TextBoxNum txtShiharaigi3;

    /*
     * gettxtShiharaigi3
     * @return txtShiharaigi3
     */
    @JsonProperty("txtShiharaigi3")
    public TextBoxNum getTxtShiharaigi3() {
        return txtShiharaigi3;
    }

    /*
     * settxtShiharaigi3
     * @param txtShiharaigi3 txtShiharaigi3
     */
    @JsonProperty("txtShiharaigi3")
    public void setTxtShiharaigi3(TextBoxNum txtShiharaigi3) {
        this.txtShiharaigi3 = txtShiharaigi3;
    }

    // </editor-fold>
}
/**
 * cellShiharaizu3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaizu3Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaizu3")
    private TextBoxNum txtShiharaizu3;

    /*
     * gettxtShiharaizu3
     * @return txtShiharaizu3
     */
    @JsonProperty("txtShiharaizu3")
    public TextBoxNum getTxtShiharaizu3() {
        return txtShiharaizu3;
    }

    /*
     * settxtShiharaizu3
     * @param txtShiharaizu3 txtShiharaizu3
     */
    @JsonProperty("txtShiharaizu3")
    public void setTxtShiharaizu3(TextBoxNum txtShiharaizu3) {
        this.txtShiharaizu3 = txtShiharaizu3;
    }

    // </editor-fold>
}
/**
 * cellChoshu3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellChoshu3Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtChoshu3")
    private TextBoxNum txtChoshu3;

    /*
     * gettxtChoshu3
     * @return txtChoshu3
     */
    @JsonProperty("txtChoshu3")
    public TextBoxNum getTxtChoshu3() {
        return txtChoshu3;
    }

    /*
     * settxtChoshu3
     * @param txtChoshu3 txtChoshu3
     */
    @JsonProperty("txtChoshu3")
    public void setTxtChoshu3(TextBoxNum txtChoshu3) {
        this.txtChoshu3 = txtChoshu3;
    }

    // </editor-fold>
}
/**
 * cellReinyu3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellReinyu3Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtReinyu3")
    private TextBoxNum txtReinyu3;

    /*
     * gettxtReinyu3
     * @return txtReinyu3
     */
    @JsonProperty("txtReinyu3")
    public TextBoxNum getTxtReinyu3() {
        return txtReinyu3;
    }

    /*
     * settxtReinyu3
     * @param txtReinyu3 txtReinyu3
     */
    @JsonProperty("txtReinyu3")
    public void setTxtReinyu3(TextBoxNum txtReinyu3) {
        this.txtReinyu3 = txtReinyu3;
    }

    // </editor-fold>
}
/**
 * cellmishiharaigaku3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmishiharaigaku3Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtlmishiharaigaku3")
    private TextBoxNum txtlmishiharaigaku3;

    /*
     * gettxtlmishiharaigaku3
     * @return txtlmishiharaigaku3
     */
    @JsonProperty("txtlmishiharaigaku3")
    public TextBoxNum getTxtlmishiharaigaku3() {
        return txtlmishiharaigaku3;
    }

    /*
     * settxtlmishiharaigaku3
     * @param txtlmishiharaigaku3 txtlmishiharaigaku3
     */
    @JsonProperty("txtlmishiharaigaku3")
    public void setTxtlmishiharaigaku3(TextBoxNum txtlmishiharaigaku3) {
        this.txtlmishiharaigaku3 = txtlmishiharaigaku3;
    }

    // </editor-fold>
}
/**
 * cellkogakuiryo のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkogakuiryoAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblkogakuiryo")
    private Label lblkogakuiryo;

    /*
     * getlblkogakuiryo
     * @return lblkogakuiryo
     */
    @JsonProperty("lblkogakuiryo")
    public Label getLblkogakuiryo() {
        return lblkogakuiryo;
    }

    /*
     * setlblkogakuiryo
     * @param lblkogakuiryo lblkogakuiryo
     */
    @JsonProperty("lblkogakuiryo")
    public void setLblkogakuiryo(Label lblkogakuiryo) {
        this.lblkogakuiryo = lblkogakuiryo;
    }

    // </editor-fold>
}
/**
 * cellShiharaigi4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaigi4Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaigi4")
    private TextBoxNum txtShiharaigi4;

    /*
     * gettxtShiharaigi4
     * @return txtShiharaigi4
     */
    @JsonProperty("txtShiharaigi4")
    public TextBoxNum getTxtShiharaigi4() {
        return txtShiharaigi4;
    }

    /*
     * settxtShiharaigi4
     * @param txtShiharaigi4 txtShiharaigi4
     */
    @JsonProperty("txtShiharaigi4")
    public void setTxtShiharaigi4(TextBoxNum txtShiharaigi4) {
        this.txtShiharaigi4 = txtShiharaigi4;
    }

    // </editor-fold>
}
/**
 * cellShiharaizu4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaizu4Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaizu4")
    private TextBoxNum txtShiharaizu4;

    /*
     * gettxtShiharaizu4
     * @return txtShiharaizu4
     */
    @JsonProperty("txtShiharaizu4")
    public TextBoxNum getTxtShiharaizu4() {
        return txtShiharaizu4;
    }

    /*
     * settxtShiharaizu4
     * @param txtShiharaizu4 txtShiharaizu4
     */
    @JsonProperty("txtShiharaizu4")
    public void setTxtShiharaizu4(TextBoxNum txtShiharaizu4) {
        this.txtShiharaizu4 = txtShiharaizu4;
    }

    // </editor-fold>
}
/**
 * cellChoshu4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellChoshu4Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtChoshu4")
    private TextBoxNum txtChoshu4;

    /*
     * gettxtChoshu4
     * @return txtChoshu4
     */
    @JsonProperty("txtChoshu4")
    public TextBoxNum getTxtChoshu4() {
        return txtChoshu4;
    }

    /*
     * settxtChoshu4
     * @param txtChoshu4 txtChoshu4
     */
    @JsonProperty("txtChoshu4")
    public void setTxtChoshu4(TextBoxNum txtChoshu4) {
        this.txtChoshu4 = txtChoshu4;
    }

    // </editor-fold>
}
/**
 * cellReinyu4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellReinyu4Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtReinyu4")
    private TextBoxNum txtReinyu4;

    /*
     * gettxtReinyu4
     * @return txtReinyu4
     */
    @JsonProperty("txtReinyu4")
    public TextBoxNum getTxtReinyu4() {
        return txtReinyu4;
    }

    /*
     * settxtReinyu4
     * @param txtReinyu4 txtReinyu4
     */
    @JsonProperty("txtReinyu4")
    public void setTxtReinyu4(TextBoxNum txtReinyu4) {
        this.txtReinyu4 = txtReinyu4;
    }

    // </editor-fold>
}
/**
 * cellmishiharaigaku4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmishiharaigaku4Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtlmishiharaigaku4")
    private TextBoxNum txtlmishiharaigaku4;

    /*
     * gettxtlmishiharaigaku4
     * @return txtlmishiharaigaku4
     */
    @JsonProperty("txtlmishiharaigaku4")
    public TextBoxNum getTxtlmishiharaigaku4() {
        return txtlmishiharaigaku4;
    }

    /*
     * settxtlmishiharaigaku4
     * @param txtlmishiharaigaku4 txtlmishiharaigaku4
     */
    @JsonProperty("txtlmishiharaigaku4")
    public void setTxtlmishiharaigaku4(TextBoxNum txtlmishiharaigaku4) {
        this.txtlmishiharaigaku4 = txtlmishiharaigaku4;
    }

    // </editor-fold>
}
/**
 * celltokuteinyusho のクラスファイル 
 * 
 * @author 自動生成
 */
class celltokuteinyushoAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbltokuteinyusho")
    private Label lbltokuteinyusho;

    /*
     * getlbltokuteinyusho
     * @return lbltokuteinyusho
     */
    @JsonProperty("lbltokuteinyusho")
    public Label getLbltokuteinyusho() {
        return lbltokuteinyusho;
    }

    /*
     * setlbltokuteinyusho
     * @param lbltokuteinyusho lbltokuteinyusho
     */
    @JsonProperty("lbltokuteinyusho")
    public void setLbltokuteinyusho(Label lbltokuteinyusho) {
        this.lbltokuteinyusho = lbltokuteinyusho;
    }

    // </editor-fold>
}
/**
 * cellShiharaigi5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaigi5Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaigi5")
    private TextBoxNum txtShiharaigi5;

    /*
     * gettxtShiharaigi5
     * @return txtShiharaigi5
     */
    @JsonProperty("txtShiharaigi5")
    public TextBoxNum getTxtShiharaigi5() {
        return txtShiharaigi5;
    }

    /*
     * settxtShiharaigi5
     * @param txtShiharaigi5 txtShiharaigi5
     */
    @JsonProperty("txtShiharaigi5")
    public void setTxtShiharaigi5(TextBoxNum txtShiharaigi5) {
        this.txtShiharaigi5 = txtShiharaigi5;
    }

    // </editor-fold>
}
/**
 * cellShiharaizu5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaizu5Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaizu5")
    private TextBoxNum txtShiharaizu5;

    /*
     * gettxtShiharaizu5
     * @return txtShiharaizu5
     */
    @JsonProperty("txtShiharaizu5")
    public TextBoxNum getTxtShiharaizu5() {
        return txtShiharaizu5;
    }

    /*
     * settxtShiharaizu5
     * @param txtShiharaizu5 txtShiharaizu5
     */
    @JsonProperty("txtShiharaizu5")
    public void setTxtShiharaizu5(TextBoxNum txtShiharaizu5) {
        this.txtShiharaizu5 = txtShiharaizu5;
    }

    // </editor-fold>
}
/**
 * cellchoshu5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchoshu5Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtChoshu5")
    private TextBoxNum txtChoshu5;

    /*
     * gettxtChoshu5
     * @return txtChoshu5
     */
    @JsonProperty("txtChoshu5")
    public TextBoxNum getTxtChoshu5() {
        return txtChoshu5;
    }

    /*
     * settxtChoshu5
     * @param txtChoshu5 txtChoshu5
     */
    @JsonProperty("txtChoshu5")
    public void setTxtChoshu5(TextBoxNum txtChoshu5) {
        this.txtChoshu5 = txtChoshu5;
    }

    // </editor-fold>
}
/**
 * cellReinyu5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellReinyu5Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtReinyu5")
    private TextBoxNum txtReinyu5;

    /*
     * gettxtReinyu5
     * @return txtReinyu5
     */
    @JsonProperty("txtReinyu5")
    public TextBoxNum getTxtReinyu5() {
        return txtReinyu5;
    }

    /*
     * settxtReinyu5
     * @param txtReinyu5 txtReinyu5
     */
    @JsonProperty("txtReinyu5")
    public void setTxtReinyu5(TextBoxNum txtReinyu5) {
        this.txtReinyu5 = txtReinyu5;
    }

    // </editor-fold>
}
/**
 * cellmishiharaigaku5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmishiharaigaku5Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtlmishiharaigaku5")
    private TextBoxNum txtlmishiharaigaku5;

    /*
     * gettxtlmishiharaigaku5
     * @return txtlmishiharaigaku5
     */
    @JsonProperty("txtlmishiharaigaku5")
    public TextBoxNum getTxtlmishiharaigaku5() {
        return txtlmishiharaigaku5;
    }

    /*
     * settxtlmishiharaigaku5
     * @param txtlmishiharaigaku5 txtlmishiharaigaku5
     */
    @JsonProperty("txtlmishiharaigaku5")
    public void setTxtlmishiharaigaku5(TextBoxNum txtlmishiharaigaku5) {
        this.txtlmishiharaigaku5 = txtlmishiharaigaku5;
    }

    // </editor-fold>
}
/**
 * cellsonota のクラスファイル 
 * 
 * @author 自動生成
 */
class cellsonotaAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblsonota")
    private Label lblsonota;

    /*
     * getlblsonota
     * @return lblsonota
     */
    @JsonProperty("lblsonota")
    public Label getLblsonota() {
        return lblsonota;
    }

    /*
     * setlblsonota
     * @param lblsonota lblsonota
     */
    @JsonProperty("lblsonota")
    public void setLblsonota(Label lblsonota) {
        this.lblsonota = lblsonota;
    }

    // </editor-fold>
}
/**
 * cellShiharaigi6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaigi6Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaigi6")
    private TextBoxNum txtShiharaigi6;

    /*
     * gettxtShiharaigi6
     * @return txtShiharaigi6
     */
    @JsonProperty("txtShiharaigi6")
    public TextBoxNum getTxtShiharaigi6() {
        return txtShiharaigi6;
    }

    /*
     * settxtShiharaigi6
     * @param txtShiharaigi6 txtShiharaigi6
     */
    @JsonProperty("txtShiharaigi6")
    public void setTxtShiharaigi6(TextBoxNum txtShiharaigi6) {
        this.txtShiharaigi6 = txtShiharaigi6;
    }

    // </editor-fold>
}
/**
 * cellShiharaizu6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaizu6Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaizu6")
    private TextBoxNum txtShiharaizu6;

    /*
     * gettxtShiharaizu6
     * @return txtShiharaizu6
     */
    @JsonProperty("txtShiharaizu6")
    public TextBoxNum getTxtShiharaizu6() {
        return txtShiharaizu6;
    }

    /*
     * settxtShiharaizu6
     * @param txtShiharaizu6 txtShiharaizu6
     */
    @JsonProperty("txtShiharaizu6")
    public void setTxtShiharaizu6(TextBoxNum txtShiharaizu6) {
        this.txtShiharaizu6 = txtShiharaizu6;
    }

    // </editor-fold>
}
/**
 * cellChoshu6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellChoshu6Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtChoshu6")
    private TextBoxNum txtChoshu6;

    /*
     * gettxtChoshu6
     * @return txtChoshu6
     */
    @JsonProperty("txtChoshu6")
    public TextBoxNum getTxtChoshu6() {
        return txtChoshu6;
    }

    /*
     * settxtChoshu6
     * @param txtChoshu6 txtChoshu6
     */
    @JsonProperty("txtChoshu6")
    public void setTxtChoshu6(TextBoxNum txtChoshu6) {
        this.txtChoshu6 = txtChoshu6;
    }

    // </editor-fold>
}
/**
 * cellReinyu6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellReinyu6Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtReinyu6")
    private TextBoxNum txtReinyu6;

    /*
     * gettxtReinyu6
     * @return txtReinyu6
     */
    @JsonProperty("txtReinyu6")
    public TextBoxNum getTxtReinyu6() {
        return txtReinyu6;
    }

    /*
     * settxtReinyu6
     * @param txtReinyu6 txtReinyu6
     */
    @JsonProperty("txtReinyu6")
    public void setTxtReinyu6(TextBoxNum txtReinyu6) {
        this.txtReinyu6 = txtReinyu6;
    }

    // </editor-fold>
}
/**
 * cellmishiharaigaku6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmishiharaigaku6Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtlmishiharaigaku6")
    private TextBoxNum txtlmishiharaigaku6;

    /*
     * gettxtlmishiharaigaku6
     * @return txtlmishiharaigaku6
     */
    @JsonProperty("txtlmishiharaigaku6")
    public TextBoxNum getTxtlmishiharaigaku6() {
        return txtlmishiharaigaku6;
    }

    /*
     * settxtlmishiharaigaku6
     * @param txtlmishiharaigaku6 txtlmishiharaigaku6
     */
    @JsonProperty("txtlmishiharaigaku6")
    public void setTxtlmishiharaigaku6(TextBoxNum txtlmishiharaigaku6) {
        this.txtlmishiharaigaku6 = txtlmishiharaigaku6;
    }

    // </editor-fold>
}
/**
 * cellkeii のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkeiiAttblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblkeii")
    private Label lblkeii;

    /*
     * getlblkeii
     * @return lblkeii
     */
    @JsonProperty("lblkeii")
    public Label getLblkeii() {
        return lblkeii;
    }

    /*
     * setlblkeii
     * @param lblkeii lblkeii
     */
    @JsonProperty("lblkeii")
    public void setLblkeii(Label lblkeii) {
        this.lblkeii = lblkeii;
    }

    // </editor-fold>
}
/**
 * cellShiharaigi7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaigi7Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaigi7")
    private TextBoxNum txtShiharaigi7;

    /*
     * gettxtShiharaigi7
     * @return txtShiharaigi7
     */
    @JsonProperty("txtShiharaigi7")
    public TextBoxNum getTxtShiharaigi7() {
        return txtShiharaigi7;
    }

    /*
     * settxtShiharaigi7
     * @param txtShiharaigi7 txtShiharaigi7
     */
    @JsonProperty("txtShiharaigi7")
    public void setTxtShiharaigi7(TextBoxNum txtShiharaigi7) {
        this.txtShiharaigi7 = txtShiharaigi7;
    }

    // </editor-fold>
}
/**
 * cellShiharaizu7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShiharaizu7Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShiharaizu7")
    private TextBoxNum txtShiharaizu7;

    /*
     * gettxtShiharaizu7
     * @return txtShiharaizu7
     */
    @JsonProperty("txtShiharaizu7")
    public TextBoxNum getTxtShiharaizu7() {
        return txtShiharaizu7;
    }

    /*
     * settxtShiharaizu7
     * @param txtShiharaizu7 txtShiharaizu7
     */
    @JsonProperty("txtShiharaizu7")
    public void setTxtShiharaizu7(TextBoxNum txtShiharaizu7) {
        this.txtShiharaizu7 = txtShiharaizu7;
    }

    // </editor-fold>
}
/**
 * cellChoshu7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellChoshu7Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtChoshu7")
    private TextBoxNum txtChoshu7;

    /*
     * gettxtChoshu7
     * @return txtChoshu7
     */
    @JsonProperty("txtChoshu7")
    public TextBoxNum getTxtChoshu7() {
        return txtChoshu7;
    }

    /*
     * settxtChoshu7
     * @param txtChoshu7 txtChoshu7
     */
    @JsonProperty("txtChoshu7")
    public void setTxtChoshu7(TextBoxNum txtChoshu7) {
        this.txtChoshu7 = txtChoshu7;
    }

    // </editor-fold>
}
/**
 * cellReinyu7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellReinyu7Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtReinyu7")
    private TextBoxNum txtReinyu7;

    /*
     * gettxtReinyu7
     * @return txtReinyu7
     */
    @JsonProperty("txtReinyu7")
    public TextBoxNum getTxtReinyu7() {
        return txtReinyu7;
    }

    /*
     * settxtReinyu7
     * @param txtReinyu7 txtReinyu7
     */
    @JsonProperty("txtReinyu7")
    public void setTxtReinyu7(TextBoxNum txtReinyu7) {
        this.txtReinyu7 = txtReinyu7;
    }

    // </editor-fold>
}
/**
 * cellmishiharaigaku7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmishiharaigaku7Attblhokenkyufushiharaijokyo extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtlmishiharaigaku7")
    private TextBoxNum txtlmishiharaigaku7;

    /*
     * gettxtlmishiharaigaku7
     * @return txtlmishiharaigaku7
     */
    @JsonProperty("txtlmishiharaigaku7")
    public TextBoxNum getTxtlmishiharaigaku7() {
        return txtlmishiharaigaku7;
    }

    /*
     * settxtlmishiharaigaku7
     * @param txtlmishiharaigaku7 txtlmishiharaigaku7
     */
    @JsonProperty("txtlmishiharaigaku7")
    public void setTxtlmishiharaigaku7(TextBoxNum txtlmishiharaigaku7) {
        this.txtlmishiharaigaku7 = txtlmishiharaigaku7;
    }

    // </editor-fold>
}
