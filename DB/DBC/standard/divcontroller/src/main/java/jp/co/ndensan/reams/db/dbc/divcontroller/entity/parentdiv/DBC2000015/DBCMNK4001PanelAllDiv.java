package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000015;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * DBCMNK4001PanelAll のクラスファイル
 *
 * @reamsid_L DBC-4960-010 dongqianjing
 */
public class DBCMNK4001PanelAllDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PanelChushutsuKikan")
    private PanelChushutsuKikanDiv PanelChushutsuKikan;
    @JsonProperty("PanelSort")
    private PanelSortDiv PanelSort;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPanelChushutsuKikan
     * @return PanelChushutsuKikan
     */
    @JsonProperty("PanelChushutsuKikan")
    public PanelChushutsuKikanDiv getPanelChushutsuKikan() {
        return PanelChushutsuKikan;
    }

    /*
     * setPanelChushutsuKikan
     * @param PanelChushutsuKikan PanelChushutsuKikan
     */
    @JsonProperty("PanelChushutsuKikan")
    public void setPanelChushutsuKikan(PanelChushutsuKikanDiv PanelChushutsuKikan) {
        this.PanelChushutsuKikan = PanelChushutsuKikan;
    }

    /*
     * getPanelSort
     * @return PanelSort
     */
    @JsonProperty("PanelSort")
    public PanelSortDiv getPanelSort() {
        return PanelSort;
    }

    /*
     * setPanelSort
     * @param PanelSort PanelSort
     */
    @JsonProperty("PanelSort")
    public void setPanelSort(PanelSortDiv PanelSort) {
        this.PanelSort = PanelSort;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKaishiDate() {
        return this.getPanelChushutsuKikan().getLblKaishiDate();
    }

    @JsonIgnore
    public void setLblKaishiDate(Label lblKaishiDate) {
        this.getPanelChushutsuKikan().setLblKaishiDate(lblKaishiDate);
    }

    @JsonIgnore
    public Label getLblKaishiTime() {
        return this.getPanelChushutsuKikan().getLblKaishiTime();
    }

    @JsonIgnore
    public void setLblKaishiTime(Label lblKaishiTime) {
        this.getPanelChushutsuKikan().setLblKaishiTime(lblKaishiTime);
    }

    @JsonIgnore
    public Label getLblShuryoDate() {
        return this.getPanelChushutsuKikan().getLblShuryoDate();
    }

    @JsonIgnore
    public void setLblShuryoDate(Label lblShuryoDate) {
        this.getPanelChushutsuKikan().setLblShuryoDate(lblShuryoDate);
    }

    @JsonIgnore
    public Label getLblShuryoTime() {
        return this.getPanelChushutsuKikan().getLblShuryoTime();
    }

    @JsonIgnore
    public void setLblShuryoTime(Label lblShuryoTime) {
        this.getPanelChushutsuKikan().setLblShuryoTime(lblShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiKaishiDate() {
        return this.getPanelChushutsuKikan().getTxtZenkaiKaishiDate();
    }

    @JsonIgnore
    public void setTxtZenkaiKaishiDate(TextBoxDate txtZenkaiKaishiDate) {
        this.getPanelChushutsuKikan().setTxtZenkaiKaishiDate(txtZenkaiKaishiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiKaishiTime() {
        return this.getPanelChushutsuKikan().getTxtZenkaiKaishiTime();
    }

    @JsonIgnore
    public void setTxtZenkaiKaishiTime(TextBoxTime txtZenkaiKaishiTime) {
        this.getPanelChushutsuKikan().setTxtZenkaiKaishiTime(txtZenkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblNamisen1() {
        return this.getPanelChushutsuKikan().getLblNamisen1();
    }

    @JsonIgnore
    public void setLblNamisen1(Label lblNamisen1) {
        this.getPanelChushutsuKikan().setLblNamisen1(lblNamisen1);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShuryoDate() {
        return this.getPanelChushutsuKikan().getTxtZenkaiShuryoDate();
    }

    @JsonIgnore
    public void setTxtZenkaiShuryoDate(TextBoxDate txtZenkaiShuryoDate) {
        this.getPanelChushutsuKikan().setTxtZenkaiShuryoDate(txtZenkaiShuryoDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShuryoTime() {
        return this.getPanelChushutsuKikan().getTxtZenkaiShuryoTime();
    }

    @JsonIgnore
    public void setTxtZenkaiShuryoTime(TextBoxTime txtZenkaiShuryoTime) {
        this.getPanelChushutsuKikan().setTxtZenkaiShuryoTime(txtZenkaiShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiKaishiDate() {
        return this.getPanelChushutsuKikan().getTxtKonkaiKaishiDate();
    }

    @JsonIgnore
    public void setTxtKonkaiKaishiDate(TextBoxDate txtKonkaiKaishiDate) {
        this.getPanelChushutsuKikan().setTxtKonkaiKaishiDate(txtKonkaiKaishiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiKaishiTime() {
        return this.getPanelChushutsuKikan().getTxtKonkaiKaishiTime();
    }

    @JsonIgnore
    public void setTxtKonkaiKaishiTime(TextBoxTime txtKonkaiKaishiTime) {
        this.getPanelChushutsuKikan().setTxtKonkaiKaishiTime(txtKonkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblNamisen2() {
        return this.getPanelChushutsuKikan().getLblNamisen2();
    }

    @JsonIgnore
    public void setLblNamisen2(Label lblNamisen2) {
        this.getPanelChushutsuKikan().setLblNamisen2(lblNamisen2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShuryoDate() {
        return this.getPanelChushutsuKikan().getTxtKonkaiShuryoDate();
    }

    @JsonIgnore
    public void setTxtKonkaiShuryoDate(TextBoxDate txtKonkaiShuryoDate) {
        this.getPanelChushutsuKikan().setTxtKonkaiShuryoDate(txtKonkaiShuryoDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShuryoTime() {
        return this.getPanelChushutsuKikan().getTxtKonkaiShuryoTime();
    }

    @JsonIgnore
    public void setTxtKonkaiShuryoTime(TextBoxTime txtKonkaiShuryoTime) {
        this.getPanelChushutsuKikan().setTxtKonkaiShuryoTime(txtKonkaiShuryoTime);
    }

    @JsonIgnore
    public RadioButton getRadSort() {
        return this.getPanelSort().getRadSort();
    }

    @JsonIgnore
    public void setRadSort(RadioButton radSort) {
        this.getPanelSort().setRadSort(radSort);
    }

    // </editor-fold>
}
