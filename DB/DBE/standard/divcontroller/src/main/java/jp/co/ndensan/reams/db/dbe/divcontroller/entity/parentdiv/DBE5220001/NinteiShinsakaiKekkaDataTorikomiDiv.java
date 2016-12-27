package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiShinsakaiKekkaDataTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinsakaiKekkaDataTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DataTorikomi")
    private DataTorikomiDiv DataTorikomi;
    @JsonProperty("uploadPanel")
    private uploadPanelDiv uploadPanel;
    @JsonProperty("hdnTxtKaisaiKaisuKekka")
    private RString hdnTxtKaisaiKaisuKekka;
    @JsonProperty("hdnTxtKensuShinsaKekka")
    private RString hdnTxtKensuShinsaKekka;
    @JsonProperty("hdnTxtKensuShinsaIin")
    private RString hdnTxtKensuShinsaIin;
    @JsonProperty("hdnTxtKensuShinsakaiJoho")
    private RString hdnTxtKensuShinsakaiJoho;
    @JsonProperty("hdnTxtKaisaiKaisuIin")
    private RString hdnTxtKaisaiKaisuIin;
    @JsonProperty("hdnTxtKaisaiKaisuJoho")
    private RString hdnTxtKaisaiKaisuJoho;
    @JsonProperty("hdnTxtKensuNintei")
    private RString hdnTxtKensuNintei;
    @JsonProperty("hdnTxtKaisaiKaisuNintei")
    private RString hdnTxtKaisaiKaisuNintei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDataTorikomi
     * @return DataTorikomi
     */
    @JsonProperty("DataTorikomi")
    public DataTorikomiDiv getDataTorikomi() {
        return DataTorikomi;
    }

    /*
     * setDataTorikomi
     * @param DataTorikomi DataTorikomi
     */
    @JsonProperty("DataTorikomi")
    public void setDataTorikomi(DataTorikomiDiv DataTorikomi) {
        this.DataTorikomi = DataTorikomi;
    }

    /*
     * getuploadPanel
     * @return uploadPanel
     */
    @JsonProperty("uploadPanel")
    public uploadPanelDiv getUploadPanel() {
        return uploadPanel;
    }

    /*
     * setuploadPanel
     * @param uploadPanel uploadPanel
     */
    @JsonProperty("uploadPanel")
    public void setUploadPanel(uploadPanelDiv uploadPanel) {
        this.uploadPanel = uploadPanel;
    }

    /*
     * gethdnTxtKaisaiKaisuKekka
     * @return hdnTxtKaisaiKaisuKekka
     */
    @JsonProperty("hdnTxtKaisaiKaisuKekka")
    public RString getHdnTxtKaisaiKaisuKekka() {
        return hdnTxtKaisaiKaisuKekka;
    }

    /*
     * sethdnTxtKaisaiKaisuKekka
     * @param hdnTxtKaisaiKaisuKekka hdnTxtKaisaiKaisuKekka
     */
    @JsonProperty("hdnTxtKaisaiKaisuKekka")
    public void setHdnTxtKaisaiKaisuKekka(RString hdnTxtKaisaiKaisuKekka) {
        this.hdnTxtKaisaiKaisuKekka = hdnTxtKaisaiKaisuKekka;
    }

    /*
     * gethdnTxtKensuShinsaKekka
     * @return hdnTxtKensuShinsaKekka
     */
    @JsonProperty("hdnTxtKensuShinsaKekka")
    public RString getHdnTxtKensuShinsaKekka() {
        return hdnTxtKensuShinsaKekka;
    }

    /*
     * sethdnTxtKensuShinsaKekka
     * @param hdnTxtKensuShinsaKekka hdnTxtKensuShinsaKekka
     */
    @JsonProperty("hdnTxtKensuShinsaKekka")
    public void setHdnTxtKensuShinsaKekka(RString hdnTxtKensuShinsaKekka) {
        this.hdnTxtKensuShinsaKekka = hdnTxtKensuShinsaKekka;
    }

    /*
     * gethdnTxtKensuShinsaIin
     * @return hdnTxtKensuShinsaIin
     */
    @JsonProperty("hdnTxtKensuShinsaIin")
    public RString getHdnTxtKensuShinsaIin() {
        return hdnTxtKensuShinsaIin;
    }

    /*
     * sethdnTxtKensuShinsaIin
     * @param hdnTxtKensuShinsaIin hdnTxtKensuShinsaIin
     */
    @JsonProperty("hdnTxtKensuShinsaIin")
    public void setHdnTxtKensuShinsaIin(RString hdnTxtKensuShinsaIin) {
        this.hdnTxtKensuShinsaIin = hdnTxtKensuShinsaIin;
    }

    /*
     * gethdnTxtKensuShinsakaiJoho
     * @return hdnTxtKensuShinsakaiJoho
     */
    @JsonProperty("hdnTxtKensuShinsakaiJoho")
    public RString getHdnTxtKensuShinsakaiJoho() {
        return hdnTxtKensuShinsakaiJoho;
    }

    /*
     * sethdnTxtKensuShinsakaiJoho
     * @param hdnTxtKensuShinsakaiJoho hdnTxtKensuShinsakaiJoho
     */
    @JsonProperty("hdnTxtKensuShinsakaiJoho")
    public void setHdnTxtKensuShinsakaiJoho(RString hdnTxtKensuShinsakaiJoho) {
        this.hdnTxtKensuShinsakaiJoho = hdnTxtKensuShinsakaiJoho;
    }

    /*
     * gethdnTxtKaisaiKaisuIin
     * @return hdnTxtKaisaiKaisuIin
     */
    @JsonProperty("hdnTxtKaisaiKaisuIin")
    public RString getHdnTxtKaisaiKaisuIin() {
        return hdnTxtKaisaiKaisuIin;
    }

    /*
     * sethdnTxtKaisaiKaisuIin
     * @param hdnTxtKaisaiKaisuIin hdnTxtKaisaiKaisuIin
     */
    @JsonProperty("hdnTxtKaisaiKaisuIin")
    public void setHdnTxtKaisaiKaisuIin(RString hdnTxtKaisaiKaisuIin) {
        this.hdnTxtKaisaiKaisuIin = hdnTxtKaisaiKaisuIin;
    }

    /*
     * gethdnTxtKaisaiKaisuJoho
     * @return hdnTxtKaisaiKaisuJoho
     */
    @JsonProperty("hdnTxtKaisaiKaisuJoho")
    public RString getHdnTxtKaisaiKaisuJoho() {
        return hdnTxtKaisaiKaisuJoho;
    }

    /*
     * sethdnTxtKaisaiKaisuJoho
     * @param hdnTxtKaisaiKaisuJoho hdnTxtKaisaiKaisuJoho
     */
    @JsonProperty("hdnTxtKaisaiKaisuJoho")
    public void setHdnTxtKaisaiKaisuJoho(RString hdnTxtKaisaiKaisuJoho) {
        this.hdnTxtKaisaiKaisuJoho = hdnTxtKaisaiKaisuJoho;
    }

    /*
     * gethdnTxtKensuNintei
     * @return hdnTxtKensuNintei
     */
    @JsonProperty("hdnTxtKensuNintei")
    public RString getHdnTxtKensuNintei() {
        return hdnTxtKensuNintei;
    }

    /*
     * sethdnTxtKensuNintei
     * @param hdnTxtKensuNintei hdnTxtKensuNintei
     */
    @JsonProperty("hdnTxtKensuNintei")
    public void setHdnTxtKensuNintei(RString hdnTxtKensuNintei) {
        this.hdnTxtKensuNintei = hdnTxtKensuNintei;
    }

    /*
     * gethdnTxtKaisaiKaisuNintei
     * @return hdnTxtKaisaiKaisuNintei
     */
    @JsonProperty("hdnTxtKaisaiKaisuNintei")
    public RString getHdnTxtKaisaiKaisuNintei() {
        return hdnTxtKaisaiKaisuNintei;
    }

    /*
     * sethdnTxtKaisaiKaisuNintei
     * @param hdnTxtKaisaiKaisuNintei hdnTxtKaisaiKaisuNintei
     */
    @JsonProperty("hdnTxtKaisaiKaisuNintei")
    public void setHdnTxtKaisaiKaisuNintei(RString hdnTxtKaisaiKaisuNintei) {
        this.hdnTxtKaisaiKaisuNintei = hdnTxtKaisaiKaisuNintei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTorikomiTaishoData() {
        return this.getDataTorikomi().getRadTorikomiTaishoData();
    }

    @JsonIgnore
    public void  setRadTorikomiTaishoData(RadioButton radTorikomiTaishoData) {
        this.getDataTorikomi().setRadTorikomiTaishoData(radTorikomiTaishoData);
    }

    @JsonIgnore
    public RadioButton getRadTorikomiNaiyo() {
        return this.getDataTorikomi().getRadTorikomiNaiyo();
    }

    @JsonIgnore
    public void  setRadTorikomiNaiyo(RadioButton radTorikomiNaiyo) {
        this.getDataTorikomi().setRadTorikomiNaiyo(radTorikomiNaiyo);
    }

    @JsonIgnore
    public RadioButton getRadShinsain() {
        return this.getDataTorikomi().getRadShinsain();
    }

    @JsonIgnore
    public void  setRadShinsain(RadioButton radShinsain) {
        this.getDataTorikomi().setRadShinsain(radShinsain);
    }

    @JsonIgnore
    public Label getLblTorikomiTaisho() {
        return this.getDataTorikomi().getLblTorikomiTaisho();
    }

    @JsonIgnore
    public void  setLblTorikomiTaisho(Label lblTorikomiTaisho) {
        this.getDataTorikomi().setLblTorikomiTaisho(lblTorikomiTaisho);
    }

    @JsonIgnore
    public DataGrid<dgTorikomiTaiasho_Row> getDgTorikomiTaiasho() {
        return this.getDataTorikomi().getDgTorikomiTaiasho();
    }

    @JsonIgnore
    public void  setDgTorikomiTaiasho(DataGrid<dgTorikomiTaiasho_Row> dgTorikomiTaiasho) {
        this.getDataTorikomi().setDgTorikomiTaiasho(dgTorikomiTaiasho);
    }

    @JsonIgnore
    public UploadPanel getUplPanel() {
        return this.getUploadPanel().getUplPanel();
    }

    @JsonIgnore
    public void  setUplPanel(UploadPanel UplPanel) {
        this.getUploadPanel().setUplPanel(UplPanel);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getUploadPanel().getBtnUpload();
    }

    @JsonIgnore
    public void  setBtnUpload(Button btnUpload) {
        this.getUploadPanel().setBtnUpload(btnUpload);
    }

    // </editor-fold>
}
