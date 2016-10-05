package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011;
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
 * tblChushutsuKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChushutsuKikanDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChushutsuKikan")
    private celChushutsuKikanAttblChushutsuKikan celChushutsuKikan;
    @JsonProperty("celShoriKijunYMD")
    private celShoriKijunYMDAttblChushutsuKikan celShoriKijunYMD;
    @JsonProperty("celIdoTaishoKikan")
    private celIdoTaishoKikanAttblChushutsuKikan celIdoTaishoKikan;
    @JsonProperty("cellYMD1")
    private cellYMD1AttblChushutsuKikan cellYMD1;
    @JsonProperty("celTime1")
    private celTime1AttblChushutsuKikan celTime1;
    @JsonProperty("cellYMD2")
    private cellYMD2AttblChushutsuKikan cellYMD2;
    @JsonProperty("celTime2")
    private celTime2AttblChushutsuKikan celTime2;
    @JsonProperty("celNull")
    private celNullAttblChushutsuKikan celNull;
    @JsonProperty("celYMD3")
    private celYMD3AttblChushutsuKikan celYMD3;
    @JsonProperty("celTime3")
    private celTime3AttblChushutsuKikan celTime3;
    @JsonProperty("celZenkaiChushutsu")
    private celZenkaiChushutsuAttblChushutsuKikan celZenkaiChushutsu;
    @JsonProperty("celZenkaiChushutsuFromYMD")
    private celZenkaiChushutsuFromYMDAttblChushutsuKikan celZenkaiChushutsuFromYMD;
    @JsonProperty("celZenkaiChushutsuFromTime")
    private celZenkaiChushutsuFromTimeAttblChushutsuKikan celZenkaiChushutsuFromTime;
    @JsonProperty("celZenkaiChushutsuToYMD")
    private celZenkaiChushutsuToYMDAttblChushutsuKikan celZenkaiChushutsuToYMD;
    @JsonProperty("celZenkaiChushutsuToTime")
    private celZenkaiChushutsuToTimeAttblChushutsuKikan celZenkaiChushutsuToTime;
    @JsonProperty("celZenkaiKijunKIkan")
    private celZenkaiKijunKIkanAttblChushutsuKikan celZenkaiKijunKIkan;
    @JsonProperty("celZenkaiShoriKijunYMD")
    private celZenkaiShoriKijunYMDAttblChushutsuKikan celZenkaiShoriKijunYMD;
    @JsonProperty("celZenkaiShoriKijunTime")
    private celZenkaiShoriKijunTimeAttblChushutsuKikan celZenkaiShoriKijunTime;
    @JsonProperty("celKonkaiChushutsu")
    private celKonkaiChushutsuAttblChushutsuKikan celKonkaiChushutsu;
    @JsonProperty("celKonkaiChushutsuFromYMD")
    private celKonkaiChushutsuFromYMDAttblChushutsuKikan celKonkaiChushutsuFromYMD;
    @JsonProperty("celKonkaiChushutsuFromTime")
    private celKonkaiChushutsuFromTimeAttblChushutsuKikan celKonkaiChushutsuFromTime;
    @JsonProperty("celKonkaiChushutsuToYMD")
    private celKonkaiChushutsuToYMDAttblChushutsuKikan celKonkaiChushutsuToYMD;
    @JsonProperty("celKonkaiChushutsuToTime")
    private celKonkaiChushutsuToTimeAttblChushutsuKikan celKonkaiChushutsuToTime;
    @JsonProperty("celKonkaiKijunKIkan")
    private celKonkaiKijunKIkanAttblChushutsuKikan celKonkaiKijunKIkan;
    @JsonProperty("celKonkaiShoriKijunYMD")
    private celKonkaiShoriKijunYMDAttblChushutsuKikan celKonkaiShoriKijunYMD;
    @JsonProperty("celKonkaiShoriKijunTime")
    private celKonkaiShoriKijunTimeAttblChushutsuKikan celKonkaiShoriKijunTime;
    @JsonProperty("celComment")
    private celCommentAttblChushutsuKikan celComment;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChushutsuKikan() {
        return this.celChushutsuKikan.getLblChushutsuKikan();
    }

    @JsonIgnore
    public Label getLblShoriKijunYMD() {
        return this.celShoriKijunYMD.getLblShoriKijunYMD();
    }

    @JsonIgnore
    public Label getLblIdoTaishoKikan() {
        return this.celIdoTaishoKikan.getLblIdoTaishoKikan();
    }

    @JsonIgnore
    public Label getLblYMD1() {
        return this.cellYMD1.getLblYMD1();
    }

    @JsonIgnore
    public Label getLblTime1() {
        return this.celTime1.getLblTime1();
    }

    @JsonIgnore
    public Label getLblYMD2() {
        return this.cellYMD2.getLblYMD2();
    }

    @JsonIgnore
    public Label getLblTime2() {
        return this.celTime2.getLblTime2();
    }

    @JsonIgnore
    public Label getLblYMD3() {
        return this.celYMD3.getLblYMD3();
    }

    @JsonIgnore
    public Label getLblTime3() {
        return this.celTime3.getLblTime3();
    }

    @JsonIgnore
    public Label getLblZenkaiChushutsu() {
        return this.celZenkaiChushutsu.getLblZenkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return this.celZenkaiChushutsuFromYMD.getTxtZenkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return this.celZenkaiChushutsuFromTime.getTxtZenkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.celZenkaiChushutsuFromTime.getLblKara1();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return this.celZenkaiChushutsuToYMD.getTxtZenkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return this.celZenkaiChushutsuToTime.getTxtZenkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblZenkaiKijunKIkan() {
        return this.celZenkaiKijunKIkan.getLblZenkaiKijunKIkan();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShoriKijunYMD() {
        return this.celZenkaiShoriKijunYMD.getTxtZenkaiShoriKijunYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShoriKijunTime() {
        return this.celZenkaiShoriKijunTime.getTxtZenkaiShoriKijunTime();
    }

    @JsonIgnore
    public Label getLblKonkaiChushutsu() {
        return this.celKonkaiChushutsu.getLblKonkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return this.celKonkaiChushutsuFromYMD.getTxtKonkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return this.celKonkaiChushutsuFromTime.getTxtKonkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.celKonkaiChushutsuFromTime.getLblKara2();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuToYMD() {
        return this.celKonkaiChushutsuToYMD.getTxtKonkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuToTime() {
        return this.celKonkaiChushutsuToTime.getTxtKonkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblKonkaiKijunKIkan() {
        return this.celKonkaiKijunKIkan.getLblKonkaiKijunKIkan();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShoriKijunYMD() {
        return this.celKonkaiShoriKijunYMD.getTxtKonkaiShoriKijunYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShoriKijunTime() {
        return this.celKonkaiShoriKijunTime.getTxtKonkaiShoriKijunTime();
    }

    @JsonIgnore
    public Label getLblComment() {
        return this.celComment.getLblComment();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelChushutsuKikan
     * @return celChushutsuKikan
     */
    @JsonProperty("celChushutsuKikan")
    private celChushutsuKikanAttblChushutsuKikan getCelChushutsuKikan() {
        return celChushutsuKikan;
    }

    /*
     * setcelChushutsuKikan
     * @param celChushutsuKikan celChushutsuKikan
     */
    @JsonProperty("celChushutsuKikan")
    private void setCelChushutsuKikan(celChushutsuKikanAttblChushutsuKikan celChushutsuKikan) {
        this.celChushutsuKikan = celChushutsuKikan;
    }

    /*
     * getcelShoriKijunYMD
     * @return celShoriKijunYMD
     */
    @JsonProperty("celShoriKijunYMD")
    private celShoriKijunYMDAttblChushutsuKikan getCelShoriKijunYMD() {
        return celShoriKijunYMD;
    }

    /*
     * setcelShoriKijunYMD
     * @param celShoriKijunYMD celShoriKijunYMD
     */
    @JsonProperty("celShoriKijunYMD")
    private void setCelShoriKijunYMD(celShoriKijunYMDAttblChushutsuKikan celShoriKijunYMD) {
        this.celShoriKijunYMD = celShoriKijunYMD;
    }

    /*
     * getcelIdoTaishoKikan
     * @return celIdoTaishoKikan
     */
    @JsonProperty("celIdoTaishoKikan")
    private celIdoTaishoKikanAttblChushutsuKikan getCelIdoTaishoKikan() {
        return celIdoTaishoKikan;
    }

    /*
     * setcelIdoTaishoKikan
     * @param celIdoTaishoKikan celIdoTaishoKikan
     */
    @JsonProperty("celIdoTaishoKikan")
    private void setCelIdoTaishoKikan(celIdoTaishoKikanAttblChushutsuKikan celIdoTaishoKikan) {
        this.celIdoTaishoKikan = celIdoTaishoKikan;
    }

    /*
     * getcellYMD1
     * @return cellYMD1
     */
    @JsonProperty("cellYMD1")
    private cellYMD1AttblChushutsuKikan getCellYMD1() {
        return cellYMD1;
    }

    /*
     * setcellYMD1
     * @param cellYMD1 cellYMD1
     */
    @JsonProperty("cellYMD1")
    private void setCellYMD1(cellYMD1AttblChushutsuKikan cellYMD1) {
        this.cellYMD1 = cellYMD1;
    }

    /*
     * getcelTime1
     * @return celTime1
     */
    @JsonProperty("celTime1")
    private celTime1AttblChushutsuKikan getCelTime1() {
        return celTime1;
    }

    /*
     * setcelTime1
     * @param celTime1 celTime1
     */
    @JsonProperty("celTime1")
    private void setCelTime1(celTime1AttblChushutsuKikan celTime1) {
        this.celTime1 = celTime1;
    }

    /*
     * getcellYMD2
     * @return cellYMD2
     */
    @JsonProperty("cellYMD2")
    private cellYMD2AttblChushutsuKikan getCellYMD2() {
        return cellYMD2;
    }

    /*
     * setcellYMD2
     * @param cellYMD2 cellYMD2
     */
    @JsonProperty("cellYMD2")
    private void setCellYMD2(cellYMD2AttblChushutsuKikan cellYMD2) {
        this.cellYMD2 = cellYMD2;
    }

    /*
     * getcelTime2
     * @return celTime2
     */
    @JsonProperty("celTime2")
    private celTime2AttblChushutsuKikan getCelTime2() {
        return celTime2;
    }

    /*
     * setcelTime2
     * @param celTime2 celTime2
     */
    @JsonProperty("celTime2")
    private void setCelTime2(celTime2AttblChushutsuKikan celTime2) {
        this.celTime2 = celTime2;
    }

    /*
     * getcelNull
     * @return celNull
     */
    @JsonProperty("celNull")
    private celNullAttblChushutsuKikan getCelNull() {
        return celNull;
    }

    /*
     * setcelNull
     * @param celNull celNull
     */
    @JsonProperty("celNull")
    private void setCelNull(celNullAttblChushutsuKikan celNull) {
        this.celNull = celNull;
    }

    /*
     * getcelYMD3
     * @return celYMD3
     */
    @JsonProperty("celYMD3")
    private celYMD3AttblChushutsuKikan getCelYMD3() {
        return celYMD3;
    }

    /*
     * setcelYMD3
     * @param celYMD3 celYMD3
     */
    @JsonProperty("celYMD3")
    private void setCelYMD3(celYMD3AttblChushutsuKikan celYMD3) {
        this.celYMD3 = celYMD3;
    }

    /*
     * getcelTime3
     * @return celTime3
     */
    @JsonProperty("celTime3")
    private celTime3AttblChushutsuKikan getCelTime3() {
        return celTime3;
    }

    /*
     * setcelTime3
     * @param celTime3 celTime3
     */
    @JsonProperty("celTime3")
    private void setCelTime3(celTime3AttblChushutsuKikan celTime3) {
        this.celTime3 = celTime3;
    }

    /*
     * getcelZenkaiChushutsu
     * @return celZenkaiChushutsu
     */
    @JsonProperty("celZenkaiChushutsu")
    private celZenkaiChushutsuAttblChushutsuKikan getCelZenkaiChushutsu() {
        return celZenkaiChushutsu;
    }

    /*
     * setcelZenkaiChushutsu
     * @param celZenkaiChushutsu celZenkaiChushutsu
     */
    @JsonProperty("celZenkaiChushutsu")
    private void setCelZenkaiChushutsu(celZenkaiChushutsuAttblChushutsuKikan celZenkaiChushutsu) {
        this.celZenkaiChushutsu = celZenkaiChushutsu;
    }

    /*
     * getcelZenkaiChushutsuFromYMD
     * @return celZenkaiChushutsuFromYMD
     */
    @JsonProperty("celZenkaiChushutsuFromYMD")
    private celZenkaiChushutsuFromYMDAttblChushutsuKikan getCelZenkaiChushutsuFromYMD() {
        return celZenkaiChushutsuFromYMD;
    }

    /*
     * setcelZenkaiChushutsuFromYMD
     * @param celZenkaiChushutsuFromYMD celZenkaiChushutsuFromYMD
     */
    @JsonProperty("celZenkaiChushutsuFromYMD")
    private void setCelZenkaiChushutsuFromYMD(celZenkaiChushutsuFromYMDAttblChushutsuKikan celZenkaiChushutsuFromYMD) {
        this.celZenkaiChushutsuFromYMD = celZenkaiChushutsuFromYMD;
    }

    /*
     * getcelZenkaiChushutsuFromTime
     * @return celZenkaiChushutsuFromTime
     */
    @JsonProperty("celZenkaiChushutsuFromTime")
    private celZenkaiChushutsuFromTimeAttblChushutsuKikan getCelZenkaiChushutsuFromTime() {
        return celZenkaiChushutsuFromTime;
    }

    /*
     * setcelZenkaiChushutsuFromTime
     * @param celZenkaiChushutsuFromTime celZenkaiChushutsuFromTime
     */
    @JsonProperty("celZenkaiChushutsuFromTime")
    private void setCelZenkaiChushutsuFromTime(celZenkaiChushutsuFromTimeAttblChushutsuKikan celZenkaiChushutsuFromTime) {
        this.celZenkaiChushutsuFromTime = celZenkaiChushutsuFromTime;
    }

    /*
     * getcelZenkaiChushutsuToYMD
     * @return celZenkaiChushutsuToYMD
     */
    @JsonProperty("celZenkaiChushutsuToYMD")
    private celZenkaiChushutsuToYMDAttblChushutsuKikan getCelZenkaiChushutsuToYMD() {
        return celZenkaiChushutsuToYMD;
    }

    /*
     * setcelZenkaiChushutsuToYMD
     * @param celZenkaiChushutsuToYMD celZenkaiChushutsuToYMD
     */
    @JsonProperty("celZenkaiChushutsuToYMD")
    private void setCelZenkaiChushutsuToYMD(celZenkaiChushutsuToYMDAttblChushutsuKikan celZenkaiChushutsuToYMD) {
        this.celZenkaiChushutsuToYMD = celZenkaiChushutsuToYMD;
    }

    /*
     * getcelZenkaiChushutsuToTime
     * @return celZenkaiChushutsuToTime
     */
    @JsonProperty("celZenkaiChushutsuToTime")
    private celZenkaiChushutsuToTimeAttblChushutsuKikan getCelZenkaiChushutsuToTime() {
        return celZenkaiChushutsuToTime;
    }

    /*
     * setcelZenkaiChushutsuToTime
     * @param celZenkaiChushutsuToTime celZenkaiChushutsuToTime
     */
    @JsonProperty("celZenkaiChushutsuToTime")
    private void setCelZenkaiChushutsuToTime(celZenkaiChushutsuToTimeAttblChushutsuKikan celZenkaiChushutsuToTime) {
        this.celZenkaiChushutsuToTime = celZenkaiChushutsuToTime;
    }

    /*
     * getcelZenkaiKijunKIkan
     * @return celZenkaiKijunKIkan
     */
    @JsonProperty("celZenkaiKijunKIkan")
    private celZenkaiKijunKIkanAttblChushutsuKikan getCelZenkaiKijunKIkan() {
        return celZenkaiKijunKIkan;
    }

    /*
     * setcelZenkaiKijunKIkan
     * @param celZenkaiKijunKIkan celZenkaiKijunKIkan
     */
    @JsonProperty("celZenkaiKijunKIkan")
    private void setCelZenkaiKijunKIkan(celZenkaiKijunKIkanAttblChushutsuKikan celZenkaiKijunKIkan) {
        this.celZenkaiKijunKIkan = celZenkaiKijunKIkan;
    }

    /*
     * getcelZenkaiShoriKijunYMD
     * @return celZenkaiShoriKijunYMD
     */
    @JsonProperty("celZenkaiShoriKijunYMD")
    private celZenkaiShoriKijunYMDAttblChushutsuKikan getCelZenkaiShoriKijunYMD() {
        return celZenkaiShoriKijunYMD;
    }

    /*
     * setcelZenkaiShoriKijunYMD
     * @param celZenkaiShoriKijunYMD celZenkaiShoriKijunYMD
     */
    @JsonProperty("celZenkaiShoriKijunYMD")
    private void setCelZenkaiShoriKijunYMD(celZenkaiShoriKijunYMDAttblChushutsuKikan celZenkaiShoriKijunYMD) {
        this.celZenkaiShoriKijunYMD = celZenkaiShoriKijunYMD;
    }

    /*
     * getcelZenkaiShoriKijunTime
     * @return celZenkaiShoriKijunTime
     */
    @JsonProperty("celZenkaiShoriKijunTime")
    private celZenkaiShoriKijunTimeAttblChushutsuKikan getCelZenkaiShoriKijunTime() {
        return celZenkaiShoriKijunTime;
    }

    /*
     * setcelZenkaiShoriKijunTime
     * @param celZenkaiShoriKijunTime celZenkaiShoriKijunTime
     */
    @JsonProperty("celZenkaiShoriKijunTime")
    private void setCelZenkaiShoriKijunTime(celZenkaiShoriKijunTimeAttblChushutsuKikan celZenkaiShoriKijunTime) {
        this.celZenkaiShoriKijunTime = celZenkaiShoriKijunTime;
    }

    /*
     * getcelKonkaiChushutsu
     * @return celKonkaiChushutsu
     */
    @JsonProperty("celKonkaiChushutsu")
    private celKonkaiChushutsuAttblChushutsuKikan getCelKonkaiChushutsu() {
        return celKonkaiChushutsu;
    }

    /*
     * setcelKonkaiChushutsu
     * @param celKonkaiChushutsu celKonkaiChushutsu
     */
    @JsonProperty("celKonkaiChushutsu")
    private void setCelKonkaiChushutsu(celKonkaiChushutsuAttblChushutsuKikan celKonkaiChushutsu) {
        this.celKonkaiChushutsu = celKonkaiChushutsu;
    }

    /*
     * getcelKonkaiChushutsuFromYMD
     * @return celKonkaiChushutsuFromYMD
     */
    @JsonProperty("celKonkaiChushutsuFromYMD")
    private celKonkaiChushutsuFromYMDAttblChushutsuKikan getCelKonkaiChushutsuFromYMD() {
        return celKonkaiChushutsuFromYMD;
    }

    /*
     * setcelKonkaiChushutsuFromYMD
     * @param celKonkaiChushutsuFromYMD celKonkaiChushutsuFromYMD
     */
    @JsonProperty("celKonkaiChushutsuFromYMD")
    private void setCelKonkaiChushutsuFromYMD(celKonkaiChushutsuFromYMDAttblChushutsuKikan celKonkaiChushutsuFromYMD) {
        this.celKonkaiChushutsuFromYMD = celKonkaiChushutsuFromYMD;
    }

    /*
     * getcelKonkaiChushutsuFromTime
     * @return celKonkaiChushutsuFromTime
     */
    @JsonProperty("celKonkaiChushutsuFromTime")
    private celKonkaiChushutsuFromTimeAttblChushutsuKikan getCelKonkaiChushutsuFromTime() {
        return celKonkaiChushutsuFromTime;
    }

    /*
     * setcelKonkaiChushutsuFromTime
     * @param celKonkaiChushutsuFromTime celKonkaiChushutsuFromTime
     */
    @JsonProperty("celKonkaiChushutsuFromTime")
    private void setCelKonkaiChushutsuFromTime(celKonkaiChushutsuFromTimeAttblChushutsuKikan celKonkaiChushutsuFromTime) {
        this.celKonkaiChushutsuFromTime = celKonkaiChushutsuFromTime;
    }

    /*
     * getcelKonkaiChushutsuToYMD
     * @return celKonkaiChushutsuToYMD
     */
    @JsonProperty("celKonkaiChushutsuToYMD")
    private celKonkaiChushutsuToYMDAttblChushutsuKikan getCelKonkaiChushutsuToYMD() {
        return celKonkaiChushutsuToYMD;
    }

    /*
     * setcelKonkaiChushutsuToYMD
     * @param celKonkaiChushutsuToYMD celKonkaiChushutsuToYMD
     */
    @JsonProperty("celKonkaiChushutsuToYMD")
    private void setCelKonkaiChushutsuToYMD(celKonkaiChushutsuToYMDAttblChushutsuKikan celKonkaiChushutsuToYMD) {
        this.celKonkaiChushutsuToYMD = celKonkaiChushutsuToYMD;
    }

    /*
     * getcelKonkaiChushutsuToTime
     * @return celKonkaiChushutsuToTime
     */
    @JsonProperty("celKonkaiChushutsuToTime")
    private celKonkaiChushutsuToTimeAttblChushutsuKikan getCelKonkaiChushutsuToTime() {
        return celKonkaiChushutsuToTime;
    }

    /*
     * setcelKonkaiChushutsuToTime
     * @param celKonkaiChushutsuToTime celKonkaiChushutsuToTime
     */
    @JsonProperty("celKonkaiChushutsuToTime")
    private void setCelKonkaiChushutsuToTime(celKonkaiChushutsuToTimeAttblChushutsuKikan celKonkaiChushutsuToTime) {
        this.celKonkaiChushutsuToTime = celKonkaiChushutsuToTime;
    }

    /*
     * getcelKonkaiKijunKIkan
     * @return celKonkaiKijunKIkan
     */
    @JsonProperty("celKonkaiKijunKIkan")
    private celKonkaiKijunKIkanAttblChushutsuKikan getCelKonkaiKijunKIkan() {
        return celKonkaiKijunKIkan;
    }

    /*
     * setcelKonkaiKijunKIkan
     * @param celKonkaiKijunKIkan celKonkaiKijunKIkan
     */
    @JsonProperty("celKonkaiKijunKIkan")
    private void setCelKonkaiKijunKIkan(celKonkaiKijunKIkanAttblChushutsuKikan celKonkaiKijunKIkan) {
        this.celKonkaiKijunKIkan = celKonkaiKijunKIkan;
    }

    /*
     * getcelKonkaiShoriKijunYMD
     * @return celKonkaiShoriKijunYMD
     */
    @JsonProperty("celKonkaiShoriKijunYMD")
    private celKonkaiShoriKijunYMDAttblChushutsuKikan getCelKonkaiShoriKijunYMD() {
        return celKonkaiShoriKijunYMD;
    }

    /*
     * setcelKonkaiShoriKijunYMD
     * @param celKonkaiShoriKijunYMD celKonkaiShoriKijunYMD
     */
    @JsonProperty("celKonkaiShoriKijunYMD")
    private void setCelKonkaiShoriKijunYMD(celKonkaiShoriKijunYMDAttblChushutsuKikan celKonkaiShoriKijunYMD) {
        this.celKonkaiShoriKijunYMD = celKonkaiShoriKijunYMD;
    }

    /*
     * getcelKonkaiShoriKijunTime
     * @return celKonkaiShoriKijunTime
     */
    @JsonProperty("celKonkaiShoriKijunTime")
    private celKonkaiShoriKijunTimeAttblChushutsuKikan getCelKonkaiShoriKijunTime() {
        return celKonkaiShoriKijunTime;
    }

    /*
     * setcelKonkaiShoriKijunTime
     * @param celKonkaiShoriKijunTime celKonkaiShoriKijunTime
     */
    @JsonProperty("celKonkaiShoriKijunTime")
    private void setCelKonkaiShoriKijunTime(celKonkaiShoriKijunTimeAttblChushutsuKikan celKonkaiShoriKijunTime) {
        this.celKonkaiShoriKijunTime = celKonkaiShoriKijunTime;
    }

    /*
     * getcelComment
     * @return celComment
     */
    @JsonProperty("celComment")
    private celCommentAttblChushutsuKikan getCelComment() {
        return celComment;
    }

    /*
     * setcelComment
     * @param celComment celComment
     */
    @JsonProperty("celComment")
    private void setCelComment(celCommentAttblChushutsuKikan celComment) {
        this.celComment = celComment;
    }

    // </editor-fold>
}
/**
 * celChushutsuKikan のクラスファイル 
 * 
 * @author 自動生成
 */
class celChushutsuKikanAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblChushutsuKikan")
    private Label lblChushutsuKikan;

    /*
     * getlblChushutsuKikan
     * @return lblChushutsuKikan
     */
    @JsonProperty("lblChushutsuKikan")
    public Label getLblChushutsuKikan() {
        return lblChushutsuKikan;
    }

    /*
     * setlblChushutsuKikan
     * @param lblChushutsuKikan lblChushutsuKikan
     */
    @JsonProperty("lblChushutsuKikan")
    public void setLblChushutsuKikan(Label lblChushutsuKikan) {
        this.lblChushutsuKikan = lblChushutsuKikan;
    }

    // </editor-fold>
}
/**
 * celShoriKijunYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celShoriKijunYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblShoriKijunYMD")
    private Label lblShoriKijunYMD;

    /*
     * getlblShoriKijunYMD
     * @return lblShoriKijunYMD
     */
    @JsonProperty("lblShoriKijunYMD")
    public Label getLblShoriKijunYMD() {
        return lblShoriKijunYMD;
    }

    /*
     * setlblShoriKijunYMD
     * @param lblShoriKijunYMD lblShoriKijunYMD
     */
    @JsonProperty("lblShoriKijunYMD")
    public void setLblShoriKijunYMD(Label lblShoriKijunYMD) {
        this.lblShoriKijunYMD = lblShoriKijunYMD;
    }

    // </editor-fold>
}
/**
 * celIdoTaishoKikan のクラスファイル 
 * 
 * @author 自動生成
 */
class celIdoTaishoKikanAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblIdoTaishoKikan")
    private Label lblIdoTaishoKikan;

    /*
     * getlblIdoTaishoKikan
     * @return lblIdoTaishoKikan
     */
    @JsonProperty("lblIdoTaishoKikan")
    public Label getLblIdoTaishoKikan() {
        return lblIdoTaishoKikan;
    }

    /*
     * setlblIdoTaishoKikan
     * @param lblIdoTaishoKikan lblIdoTaishoKikan
     */
    @JsonProperty("lblIdoTaishoKikan")
    public void setLblIdoTaishoKikan(Label lblIdoTaishoKikan) {
        this.lblIdoTaishoKikan = lblIdoTaishoKikan;
    }

    // </editor-fold>
}
/**
 * cellYMD1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellYMD1AttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYMD1")
    private Label lblYMD1;

    /*
     * getlblYMD1
     * @return lblYMD1
     */
    @JsonProperty("lblYMD1")
    public Label getLblYMD1() {
        return lblYMD1;
    }

    /*
     * setlblYMD1
     * @param lblYMD1 lblYMD1
     */
    @JsonProperty("lblYMD1")
    public void setLblYMD1(Label lblYMD1) {
        this.lblYMD1 = lblYMD1;
    }

    // </editor-fold>
}
/**
 * celTime1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTime1AttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblTime1")
    private Label lblTime1;

    /*
     * getlblTime1
     * @return lblTime1
     */
    @JsonProperty("lblTime1")
    public Label getLblTime1() {
        return lblTime1;
    }

    /*
     * setlblTime1
     * @param lblTime1 lblTime1
     */
    @JsonProperty("lblTime1")
    public void setLblTime1(Label lblTime1) {
        this.lblTime1 = lblTime1;
    }

    // </editor-fold>
}
/**
 * cellYMD2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellYMD2AttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYMD2")
    private Label lblYMD2;

    /*
     * getlblYMD2
     * @return lblYMD2
     */
    @JsonProperty("lblYMD2")
    public Label getLblYMD2() {
        return lblYMD2;
    }

    /*
     * setlblYMD2
     * @param lblYMD2 lblYMD2
     */
    @JsonProperty("lblYMD2")
    public void setLblYMD2(Label lblYMD2) {
        this.lblYMD2 = lblYMD2;
    }

    // </editor-fold>
}
/**
 * celTime2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTime2AttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblTime2")
    private Label lblTime2;

    /*
     * getlblTime2
     * @return lblTime2
     */
    @JsonProperty("lblTime2")
    public Label getLblTime2() {
        return lblTime2;
    }

    /*
     * setlblTime2
     * @param lblTime2 lblTime2
     */
    @JsonProperty("lblTime2")
    public void setLblTime2(Label lblTime2) {
        this.lblTime2 = lblTime2;
    }

    // </editor-fold>
}
/**
 * celNull のクラスファイル 
 * 
 * @author 自動生成
 */
class celNullAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    // </editor-fold>
}
/**
 * celYMD3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYMD3AttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYMD3")
    private Label lblYMD3;

    /*
     * getlblYMD3
     * @return lblYMD3
     */
    @JsonProperty("lblYMD3")
    public Label getLblYMD3() {
        return lblYMD3;
    }

    /*
     * setlblYMD3
     * @param lblYMD3 lblYMD3
     */
    @JsonProperty("lblYMD3")
    public void setLblYMD3(Label lblYMD3) {
        this.lblYMD3 = lblYMD3;
    }

    // </editor-fold>
}
/**
 * celTime3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTime3AttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblTime3")
    private Label lblTime3;

    /*
     * getlblTime3
     * @return lblTime3
     */
    @JsonProperty("lblTime3")
    public Label getLblTime3() {
        return lblTime3;
    }

    /*
     * setlblTime3
     * @param lblTime3 lblTime3
     */
    @JsonProperty("lblTime3")
    public void setLblTime3(Label lblTime3) {
        this.lblTime3 = lblTime3;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblZenkaiChushutsu")
    private Label lblZenkaiChushutsu;

    /*
     * getlblZenkaiChushutsu
     * @return lblZenkaiChushutsu
     */
    @JsonProperty("lblZenkaiChushutsu")
    public Label getLblZenkaiChushutsu() {
        return lblZenkaiChushutsu;
    }

    /*
     * setlblZenkaiChushutsu
     * @param lblZenkaiChushutsu lblZenkaiChushutsu
     */
    @JsonProperty("lblZenkaiChushutsu")
    public void setLblZenkaiChushutsu(Label lblZenkaiChushutsu) {
        this.lblZenkaiChushutsu = lblZenkaiChushutsu;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsuFromYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuFromYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtZenkaiChushutsuFromYMD")
    private TextBoxDate txtZenkaiChushutsuFromYMD;

    /*
     * gettxtZenkaiChushutsuFromYMD
     * @return txtZenkaiChushutsuFromYMD
     */
    @JsonProperty("txtZenkaiChushutsuFromYMD")
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return txtZenkaiChushutsuFromYMD;
    }

    /*
     * settxtZenkaiChushutsuFromYMD
     * @param txtZenkaiChushutsuFromYMD txtZenkaiChushutsuFromYMD
     */
    @JsonProperty("txtZenkaiChushutsuFromYMD")
    public void setTxtZenkaiChushutsuFromYMD(TextBoxDate txtZenkaiChushutsuFromYMD) {
        this.txtZenkaiChushutsuFromYMD = txtZenkaiChushutsuFromYMD;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsuFromTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuFromTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtZenkaiChushutsuFromTime")
    private TextBoxTime txtZenkaiChushutsuFromTime;
    @JsonProperty("lblKara1")
    private Label lblKara1;

    /*
     * gettxtZenkaiChushutsuFromTime
     * @return txtZenkaiChushutsuFromTime
     */
    @JsonProperty("txtZenkaiChushutsuFromTime")
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return txtZenkaiChushutsuFromTime;
    }

    /*
     * settxtZenkaiChushutsuFromTime
     * @param txtZenkaiChushutsuFromTime txtZenkaiChushutsuFromTime
     */
    @JsonProperty("txtZenkaiChushutsuFromTime")
    public void setTxtZenkaiChushutsuFromTime(TextBoxTime txtZenkaiChushutsuFromTime) {
        this.txtZenkaiChushutsuFromTime = txtZenkaiChushutsuFromTime;
    }

    /*
     * getlblKara1
     * @return lblKara1
     */
    @JsonProperty("lblKara1")
    public Label getLblKara1() {
        return lblKara1;
    }

    /*
     * setlblKara1
     * @param lblKara1 lblKara1
     */
    @JsonProperty("lblKara1")
    public void setLblKara1(Label lblKara1) {
        this.lblKara1 = lblKara1;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsuToYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuToYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtZenkaiChushutsuToYMD")
    private TextBoxDate txtZenkaiChushutsuToYMD;

    /*
     * gettxtZenkaiChushutsuToYMD
     * @return txtZenkaiChushutsuToYMD
     */
    @JsonProperty("txtZenkaiChushutsuToYMD")
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return txtZenkaiChushutsuToYMD;
    }

    /*
     * settxtZenkaiChushutsuToYMD
     * @param txtZenkaiChushutsuToYMD txtZenkaiChushutsuToYMD
     */
    @JsonProperty("txtZenkaiChushutsuToYMD")
    public void setTxtZenkaiChushutsuToYMD(TextBoxDate txtZenkaiChushutsuToYMD) {
        this.txtZenkaiChushutsuToYMD = txtZenkaiChushutsuToYMD;
    }

    // </editor-fold>
}
/**
 * celZenkaiChushutsuToTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiChushutsuToTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtZenkaiChushutsuToTime")
    private TextBoxTime txtZenkaiChushutsuToTime;

    /*
     * gettxtZenkaiChushutsuToTime
     * @return txtZenkaiChushutsuToTime
     */
    @JsonProperty("txtZenkaiChushutsuToTime")
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return txtZenkaiChushutsuToTime;
    }

    /*
     * settxtZenkaiChushutsuToTime
     * @param txtZenkaiChushutsuToTime txtZenkaiChushutsuToTime
     */
    @JsonProperty("txtZenkaiChushutsuToTime")
    public void setTxtZenkaiChushutsuToTime(TextBoxTime txtZenkaiChushutsuToTime) {
        this.txtZenkaiChushutsuToTime = txtZenkaiChushutsuToTime;
    }

    // </editor-fold>
}
/**
 * celZenkaiKijunKIkan のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiKijunKIkanAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblZenkaiKijunKIkan")
    private Label lblZenkaiKijunKIkan;

    /*
     * getlblZenkaiKijunKIkan
     * @return lblZenkaiKijunKIkan
     */
    @JsonProperty("lblZenkaiKijunKIkan")
    public Label getLblZenkaiKijunKIkan() {
        return lblZenkaiKijunKIkan;
    }

    /*
     * setlblZenkaiKijunKIkan
     * @param lblZenkaiKijunKIkan lblZenkaiKijunKIkan
     */
    @JsonProperty("lblZenkaiKijunKIkan")
    public void setLblZenkaiKijunKIkan(Label lblZenkaiKijunKIkan) {
        this.lblZenkaiKijunKIkan = lblZenkaiKijunKIkan;
    }

    // </editor-fold>
}
/**
 * celZenkaiShoriKijunYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiShoriKijunYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtZenkaiShoriKijunYMD")
    private TextBoxDate txtZenkaiShoriKijunYMD;

    /*
     * gettxtZenkaiShoriKijunYMD
     * @return txtZenkaiShoriKijunYMD
     */
    @JsonProperty("txtZenkaiShoriKijunYMD")
    public TextBoxDate getTxtZenkaiShoriKijunYMD() {
        return txtZenkaiShoriKijunYMD;
    }

    /*
     * settxtZenkaiShoriKijunYMD
     * @param txtZenkaiShoriKijunYMD txtZenkaiShoriKijunYMD
     */
    @JsonProperty("txtZenkaiShoriKijunYMD")
    public void setTxtZenkaiShoriKijunYMD(TextBoxDate txtZenkaiShoriKijunYMD) {
        this.txtZenkaiShoriKijunYMD = txtZenkaiShoriKijunYMD;
    }

    // </editor-fold>
}
/**
 * celZenkaiShoriKijunTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celZenkaiShoriKijunTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtZenkaiShoriKijunTime")
    private TextBoxTime txtZenkaiShoriKijunTime;

    /*
     * gettxtZenkaiShoriKijunTime
     * @return txtZenkaiShoriKijunTime
     */
    @JsonProperty("txtZenkaiShoriKijunTime")
    public TextBoxTime getTxtZenkaiShoriKijunTime() {
        return txtZenkaiShoriKijunTime;
    }

    /*
     * settxtZenkaiShoriKijunTime
     * @param txtZenkaiShoriKijunTime txtZenkaiShoriKijunTime
     */
    @JsonProperty("txtZenkaiShoriKijunTime")
    public void setTxtZenkaiShoriKijunTime(TextBoxTime txtZenkaiShoriKijunTime) {
        this.txtZenkaiShoriKijunTime = txtZenkaiShoriKijunTime;
    }

    // </editor-fold>
}
/**
 * celKonkaiChushutsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiChushutsuAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblKonkaiChushutsu")
    private Label lblKonkaiChushutsu;

    /*
     * getlblKonkaiChushutsu
     * @return lblKonkaiChushutsu
     */
    @JsonProperty("lblKonkaiChushutsu")
    public Label getLblKonkaiChushutsu() {
        return lblKonkaiChushutsu;
    }

    /*
     * setlblKonkaiChushutsu
     * @param lblKonkaiChushutsu lblKonkaiChushutsu
     */
    @JsonProperty("lblKonkaiChushutsu")
    public void setLblKonkaiChushutsu(Label lblKonkaiChushutsu) {
        this.lblKonkaiChushutsu = lblKonkaiChushutsu;
    }

    // </editor-fold>
}
/**
 * celKonkaiChushutsuFromYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiChushutsuFromYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtKonkaiChushutsuFromYMD")
    private TextBoxDate txtKonkaiChushutsuFromYMD;

    /*
     * gettxtKonkaiChushutsuFromYMD
     * @return txtKonkaiChushutsuFromYMD
     */
    @JsonProperty("txtKonkaiChushutsuFromYMD")
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return txtKonkaiChushutsuFromYMD;
    }

    /*
     * settxtKonkaiChushutsuFromYMD
     * @param txtKonkaiChushutsuFromYMD txtKonkaiChushutsuFromYMD
     */
    @JsonProperty("txtKonkaiChushutsuFromYMD")
    public void setTxtKonkaiChushutsuFromYMD(TextBoxDate txtKonkaiChushutsuFromYMD) {
        this.txtKonkaiChushutsuFromYMD = txtKonkaiChushutsuFromYMD;
    }

    // </editor-fold>
}
/**
 * celKonkaiChushutsuFromTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiChushutsuFromTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtKonkaiChushutsuFromTime")
    private TextBoxTime txtKonkaiChushutsuFromTime;
    @JsonProperty("lblKara2")
    private Label lblKara2;

    /*
     * gettxtKonkaiChushutsuFromTime
     * @return txtKonkaiChushutsuFromTime
     */
    @JsonProperty("txtKonkaiChushutsuFromTime")
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return txtKonkaiChushutsuFromTime;
    }

    /*
     * settxtKonkaiChushutsuFromTime
     * @param txtKonkaiChushutsuFromTime txtKonkaiChushutsuFromTime
     */
    @JsonProperty("txtKonkaiChushutsuFromTime")
    public void setTxtKonkaiChushutsuFromTime(TextBoxTime txtKonkaiChushutsuFromTime) {
        this.txtKonkaiChushutsuFromTime = txtKonkaiChushutsuFromTime;
    }

    /*
     * getlblKara2
     * @return lblKara2
     */
    @JsonProperty("lblKara2")
    public Label getLblKara2() {
        return lblKara2;
    }

    /*
     * setlblKara2
     * @param lblKara2 lblKara2
     */
    @JsonProperty("lblKara2")
    public void setLblKara2(Label lblKara2) {
        this.lblKara2 = lblKara2;
    }

    // </editor-fold>
}
/**
 * celKonkaiChushutsuToYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiChushutsuToYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtKonkaiChushutsuToYMD")
    private TextBoxDate txtKonkaiChushutsuToYMD;

    /*
     * gettxtKonkaiChushutsuToYMD
     * @return txtKonkaiChushutsuToYMD
     */
    @JsonProperty("txtKonkaiChushutsuToYMD")
    public TextBoxDate getTxtKonkaiChushutsuToYMD() {
        return txtKonkaiChushutsuToYMD;
    }

    /*
     * settxtKonkaiChushutsuToYMD
     * @param txtKonkaiChushutsuToYMD txtKonkaiChushutsuToYMD
     */
    @JsonProperty("txtKonkaiChushutsuToYMD")
    public void setTxtKonkaiChushutsuToYMD(TextBoxDate txtKonkaiChushutsuToYMD) {
        this.txtKonkaiChushutsuToYMD = txtKonkaiChushutsuToYMD;
    }

    // </editor-fold>
}
/**
 * celKonkaiChushutsuToTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiChushutsuToTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtKonkaiChushutsuToTime")
    private TextBoxTime txtKonkaiChushutsuToTime;

    /*
     * gettxtKonkaiChushutsuToTime
     * @return txtKonkaiChushutsuToTime
     */
    @JsonProperty("txtKonkaiChushutsuToTime")
    public TextBoxTime getTxtKonkaiChushutsuToTime() {
        return txtKonkaiChushutsuToTime;
    }

    /*
     * settxtKonkaiChushutsuToTime
     * @param txtKonkaiChushutsuToTime txtKonkaiChushutsuToTime
     */
    @JsonProperty("txtKonkaiChushutsuToTime")
    public void setTxtKonkaiChushutsuToTime(TextBoxTime txtKonkaiChushutsuToTime) {
        this.txtKonkaiChushutsuToTime = txtKonkaiChushutsuToTime;
    }

    // </editor-fold>
}
/**
 * celKonkaiKijunKIkan のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiKijunKIkanAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblKonkaiKijunKIkan")
    private Label lblKonkaiKijunKIkan;

    /*
     * getlblKonkaiKijunKIkan
     * @return lblKonkaiKijunKIkan
     */
    @JsonProperty("lblKonkaiKijunKIkan")
    public Label getLblKonkaiKijunKIkan() {
        return lblKonkaiKijunKIkan;
    }

    /*
     * setlblKonkaiKijunKIkan
     * @param lblKonkaiKijunKIkan lblKonkaiKijunKIkan
     */
    @JsonProperty("lblKonkaiKijunKIkan")
    public void setLblKonkaiKijunKIkan(Label lblKonkaiKijunKIkan) {
        this.lblKonkaiKijunKIkan = lblKonkaiKijunKIkan;
    }

    // </editor-fold>
}
/**
 * celKonkaiShoriKijunYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiShoriKijunYMDAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtKonkaiShoriKijunYMD")
    private TextBoxDate txtKonkaiShoriKijunYMD;

    /*
     * gettxtKonkaiShoriKijunYMD
     * @return txtKonkaiShoriKijunYMD
     */
    @JsonProperty("txtKonkaiShoriKijunYMD")
    public TextBoxDate getTxtKonkaiShoriKijunYMD() {
        return txtKonkaiShoriKijunYMD;
    }

    /*
     * settxtKonkaiShoriKijunYMD
     * @param txtKonkaiShoriKijunYMD txtKonkaiShoriKijunYMD
     */
    @JsonProperty("txtKonkaiShoriKijunYMD")
    public void setTxtKonkaiShoriKijunYMD(TextBoxDate txtKonkaiShoriKijunYMD) {
        this.txtKonkaiShoriKijunYMD = txtKonkaiShoriKijunYMD;
    }

    // </editor-fold>
}
/**
 * celKonkaiShoriKijunTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celKonkaiShoriKijunTimeAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtKonkaiShoriKijunTime")
    private TextBoxTime txtKonkaiShoriKijunTime;

    /*
     * gettxtKonkaiShoriKijunTime
     * @return txtKonkaiShoriKijunTime
     */
    @JsonProperty("txtKonkaiShoriKijunTime")
    public TextBoxTime getTxtKonkaiShoriKijunTime() {
        return txtKonkaiShoriKijunTime;
    }

    /*
     * settxtKonkaiShoriKijunTime
     * @param txtKonkaiShoriKijunTime txtKonkaiShoriKijunTime
     */
    @JsonProperty("txtKonkaiShoriKijunTime")
    public void setTxtKonkaiShoriKijunTime(TextBoxTime txtKonkaiShoriKijunTime) {
        this.txtKonkaiShoriKijunTime = txtKonkaiShoriKijunTime;
    }

    // </editor-fold>
}
/**
 * celComment のクラスファイル 
 * 
 * @author 自動生成
 */
class celCommentAttblChushutsuKikan extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblComment")
    private Label lblComment;

    /*
     * getlblComment
     * @return lblComment
     */
    @JsonProperty("lblComment")
    public Label getLblComment() {
        return lblComment;
    }

    /*
     * setlblComment
     * @param lblComment lblComment
     */
    @JsonProperty("lblComment")
    public void setLblComment(Label lblComment) {
        this.lblComment = lblComment;
    }

    // </editor-fold>
}
