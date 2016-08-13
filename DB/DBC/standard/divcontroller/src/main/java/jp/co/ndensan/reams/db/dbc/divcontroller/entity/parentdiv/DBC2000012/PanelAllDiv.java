package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000012;
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
 * PanelAll のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelAllDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNenjiShoriDate")
    private TextBoxDate txtNenjiShoriDate;
    @JsonProperty("txtNenjiShoriTime")
    private TextBoxTime txtNenjiShoriTime;
    @JsonProperty("PanelIdoTaishoKikan")
    private PanelIdoTaishoKikanDiv PanelIdoTaishoKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNenjiShoriDate
     * @return txtNenjiShoriDate
     */
    @JsonProperty("txtNenjiShoriDate")
    public TextBoxDate getTxtNenjiShoriDate() {
        return txtNenjiShoriDate;
    }

    /*
     * settxtNenjiShoriDate
     * @param txtNenjiShoriDate txtNenjiShoriDate
     */
    @JsonProperty("txtNenjiShoriDate")
    public void setTxtNenjiShoriDate(TextBoxDate txtNenjiShoriDate) {
        this.txtNenjiShoriDate = txtNenjiShoriDate;
    }

    /*
     * gettxtNenjiShoriTime
     * @return txtNenjiShoriTime
     */
    @JsonProperty("txtNenjiShoriTime")
    public TextBoxTime getTxtNenjiShoriTime() {
        return txtNenjiShoriTime;
    }

    /*
     * settxtNenjiShoriTime
     * @param txtNenjiShoriTime txtNenjiShoriTime
     */
    @JsonProperty("txtNenjiShoriTime")
    public void setTxtNenjiShoriTime(TextBoxTime txtNenjiShoriTime) {
        this.txtNenjiShoriTime = txtNenjiShoriTime;
    }

    /*
     * getPanelIdoTaishoKikan
     * @return PanelIdoTaishoKikan
     */
    @JsonProperty("PanelIdoTaishoKikan")
    public PanelIdoTaishoKikanDiv getPanelIdoTaishoKikan() {
        return PanelIdoTaishoKikan;
    }

    /*
     * setPanelIdoTaishoKikan
     * @param PanelIdoTaishoKikan PanelIdoTaishoKikan
     */
    @JsonProperty("PanelIdoTaishoKikan")
    public void setPanelIdoTaishoKikan(PanelIdoTaishoKikanDiv PanelIdoTaishoKikan) {
        this.PanelIdoTaishoKikan = PanelIdoTaishoKikan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKaishiDate() {
        return this.getPanelIdoTaishoKikan().getLblKaishiDate();
    }

    @JsonIgnore
    public void  setLblKaishiDate(Label lblKaishiDate) {
        this.getPanelIdoTaishoKikan().setLblKaishiDate(lblKaishiDate);
    }

    @JsonIgnore
    public Label getLblKaishiTime() {
        return this.getPanelIdoTaishoKikan().getLblKaishiTime();
    }

    @JsonIgnore
    public void  setLblKaishiTime(Label lblKaishiTime) {
        this.getPanelIdoTaishoKikan().setLblKaishiTime(lblKaishiTime);
    }

    @JsonIgnore
    public Label getLblShuryoDate() {
        return this.getPanelIdoTaishoKikan().getLblShuryoDate();
    }

    @JsonIgnore
    public void  setLblShuryoDate(Label lblShuryoDate) {
        this.getPanelIdoTaishoKikan().setLblShuryoDate(lblShuryoDate);
    }

    @JsonIgnore
    public Label getLblShuryoTime() {
        return this.getPanelIdoTaishoKikan().getLblShuryoTime();
    }

    @JsonIgnore
    public void  setLblShuryoTime(Label lblShuryoTime) {
        this.getPanelIdoTaishoKikan().setLblShuryoTime(lblShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiKaishiDate() {
        return this.getPanelIdoTaishoKikan().getTxtZenkaiKaishiDate();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiDate(TextBoxDate txtZenkaiKaishiDate) {
        this.getPanelIdoTaishoKikan().setTxtZenkaiKaishiDate(txtZenkaiKaishiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiKaishiTime() {
        return this.getPanelIdoTaishoKikan().getTxtZenkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiTime(TextBoxTime txtZenkaiKaishiTime) {
        this.getPanelIdoTaishoKikan().setTxtZenkaiKaishiTime(txtZenkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblNamisen1() {
        return this.getPanelIdoTaishoKikan().getLblNamisen1();
    }

    @JsonIgnore
    public void  setLblNamisen1(Label lblNamisen1) {
        this.getPanelIdoTaishoKikan().setLblNamisen1(lblNamisen1);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShuryoDate() {
        return this.getPanelIdoTaishoKikan().getTxtZenkaiShuryoDate();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoDate(TextBoxDate txtZenkaiShuryoDate) {
        this.getPanelIdoTaishoKikan().setTxtZenkaiShuryoDate(txtZenkaiShuryoDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShuryoTime() {
        return this.getPanelIdoTaishoKikan().getTxtZenkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoTime(TextBoxTime txtZenkaiShuryoTime) {
        this.getPanelIdoTaishoKikan().setTxtZenkaiShuryoTime(txtZenkaiShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiKaishiDate() {
        return this.getPanelIdoTaishoKikan().getTxtKonkaiKaishiDate();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiDate(TextBoxDate txtKonkaiKaishiDate) {
        this.getPanelIdoTaishoKikan().setTxtKonkaiKaishiDate(txtKonkaiKaishiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiKaishiTime() {
        return this.getPanelIdoTaishoKikan().getTxtKonkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiTime(TextBoxTime txtKonkaiKaishiTime) {
        this.getPanelIdoTaishoKikan().setTxtKonkaiKaishiTime(txtKonkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblNamisen2() {
        return this.getPanelIdoTaishoKikan().getLblNamisen2();
    }

    @JsonIgnore
    public void  setLblNamisen2(Label lblNamisen2) {
        this.getPanelIdoTaishoKikan().setLblNamisen2(lblNamisen2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShuryoDate() {
        return this.getPanelIdoTaishoKikan().getTxtKonkaiShuryoDate();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoDate(TextBoxDate txtKonkaiShuryoDate) {
        this.getPanelIdoTaishoKikan().setTxtKonkaiShuryoDate(txtKonkaiShuryoDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShuryoTime() {
        return this.getPanelIdoTaishoKikan().getTxtKonkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoTime(TextBoxTime txtKonkaiShuryoTime) {
        this.getPanelIdoTaishoKikan().setTxtKonkaiShuryoTime(txtKonkaiShuryoTime);
    }

    // </editor-fold>
}
