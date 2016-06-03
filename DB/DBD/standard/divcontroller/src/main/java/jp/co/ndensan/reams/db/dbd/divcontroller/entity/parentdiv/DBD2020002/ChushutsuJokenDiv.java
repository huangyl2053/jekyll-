package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHanteiKijun")
    private Label lblHanteiKijun;
    @JsonProperty("txtKijunYMD")
    private TextBoxFlexibleDate txtKijunYMD;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("ChushutsuJokenDetail")
    private ChushutsuJokenDetailDiv ChushutsuJokenDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHanteiKijun
     * @return lblHanteiKijun
     */
    @JsonProperty("lblHanteiKijun")
    public Label getLblHanteiKijun() {
        return lblHanteiKijun;
    }

    /*
     * setlblHanteiKijun
     * @param lblHanteiKijun lblHanteiKijun
     */
    @JsonProperty("lblHanteiKijun")
    public void setLblHanteiKijun(Label lblHanteiKijun) {
        this.lblHanteiKijun = lblHanteiKijun;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getChushutsuJokenDetail
     * @return ChushutsuJokenDetail
     */
    @JsonProperty("ChushutsuJokenDetail")
    public ChushutsuJokenDetailDiv getChushutsuJokenDetail() {
        return ChushutsuJokenDetail;
    }

    /*
     * setChushutsuJokenDetail
     * @param ChushutsuJokenDetail ChushutsuJokenDetail
     */
    @JsonProperty("ChushutsuJokenDetail")
    public void setChushutsuJokenDetail(ChushutsuJokenDetailDiv ChushutsuJokenDetail) {
        this.ChushutsuJokenDetail = ChushutsuJokenDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTorokusha() {
        return this.getChushutsuJokenDetail().getRadTorokusha();
    }

    @JsonIgnore
    public void  setRadTorokusha(RadioButton radTorokusha) {
        this.getChushutsuJokenDetail().setRadTorokusha(radTorokusha);
    }

    @JsonIgnore
    public TorokushaJokenDiv getTorokushaJoken() {
        return this.getChushutsuJokenDetail().getTorokushaJoken();
    }

    @JsonIgnore
    public void  setTorokushaJoken(TorokushaJokenDiv TorokushaJoken) {
        this.getChushutsuJokenDetail().setTorokushaJoken(TorokushaJoken);
    }

    @JsonIgnore
    public DropDownList getDdl2GoSashitomeYokoku() {
        return this.getChushutsuJokenDetail().getTorokushaJoken().getDdl2GoSashitomeYokoku();
    }

    @JsonIgnore
    public void  setDdl2GoSashitomeYokoku(DropDownList ddl2GoSashitomeYokoku) {
        this.getChushutsuJokenDetail().getTorokushaJoken().setDdl2GoSashitomeYokoku(ddl2GoSashitomeYokoku);
    }

    @JsonIgnore
    public DropDownList getDdlGoSashitomeToroku() {
        return this.getChushutsuJokenDetail().getTorokushaJoken().getDdlGoSashitomeToroku();
    }

    @JsonIgnore
    public void  setDdlGoSashitomeToroku(DropDownList ddlGoSashitomeToroku) {
        this.getChushutsuJokenDetail().getTorokushaJoken().setDdlGoSashitomeToroku(ddlGoSashitomeToroku);
    }

    @JsonIgnore
    public DropDownList getDdl2GoShokanYokoku() {
        return this.getChushutsuJokenDetail().getTorokushaJoken().getDdl2GoShokanYokoku();
    }

    @JsonIgnore
    public void  setDdl2GoShokanYokoku(DropDownList ddl2GoShokanYokoku) {
        this.getChushutsuJokenDetail().getTorokushaJoken().setDdl2GoShokanYokoku(ddl2GoShokanYokoku);
    }

    @JsonIgnore
    public DropDownList getDdl1GoShokanKettei() {
        return this.getChushutsuJokenDetail().getTorokushaJoken().getDdl1GoShokanKettei();
    }

    @JsonIgnore
    public void  setDdl1GoShokanKettei(DropDownList ddl1GoShokanKettei) {
        this.getChushutsuJokenDetail().getTorokushaJoken().setDdl1GoShokanKettei(ddl1GoShokanKettei);
    }

    @JsonIgnore
    public DropDownList getDdl1GoShokanKetteiSashitomeAriOnly() {
        return this.getChushutsuJokenDetail().getTorokushaJoken().getDdl1GoShokanKetteiSashitomeAriOnly();
    }

    @JsonIgnore
    public void  setDdl1GoShokanKetteiSashitomeAriOnly(DropDownList ddl1GoShokanKetteiSashitomeAriOnly) {
        this.getChushutsuJokenDetail().getTorokushaJoken().setDdl1GoShokanKetteiSashitomeAriOnly(ddl1GoShokanKetteiSashitomeAriOnly);
    }

    @JsonIgnore
    public DropDownList getDdl1GoShokanKetteiKojoAriOnly() {
        return this.getChushutsuJokenDetail().getTorokushaJoken().getDdl1GoShokanKetteiKojoAriOnly();
    }

    @JsonIgnore
    public void  setDdl1GoShokanKetteiKojoAriOnly(DropDownList ddl1GoShokanKetteiKojoAriOnly) {
        this.getChushutsuJokenDetail().getTorokushaJoken().setDdl1GoShokanKetteiKojoAriOnly(ddl1GoShokanKetteiKojoAriOnly);
    }

    // </editor-fold>
}
