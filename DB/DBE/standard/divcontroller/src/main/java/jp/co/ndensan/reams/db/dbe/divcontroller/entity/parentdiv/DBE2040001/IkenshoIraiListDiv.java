package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoIraiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoIraiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ikenshoiraitaishoichiran")
    private ikenshoiraitaishoichiranDiv ikenshoiraitaishoichiran;
    @JsonProperty("btnikenshoiraitaishooutput")
    private ButtonDownLoad btnikenshoiraitaishooutput;
    @JsonProperty("btnShujiiSettei")
    private Button btnShujiiSettei;
    @JsonProperty("btnSakuseiIraiYmdSettei")
    private Button btnSakuseiIraiYmdSettei;
    @JsonProperty("btnIraishoToOutputDialog")
    private ButtonDialog btnIraishoToOutputDialog;
    @JsonProperty("IkenshoIraiTorokuPanel")
    private IkenshoIraiTorokuPanelDiv IkenshoIraiTorokuPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getikenshoiraitaishoichiran
     * @return ikenshoiraitaishoichiran
     */
    @JsonProperty("ikenshoiraitaishoichiran")
    public ikenshoiraitaishoichiranDiv getIkenshoiraitaishoichiran() {
        return ikenshoiraitaishoichiran;
    }

    /*
     * setikenshoiraitaishoichiran
     * @param ikenshoiraitaishoichiran ikenshoiraitaishoichiran
     */
    @JsonProperty("ikenshoiraitaishoichiran")
    public void setIkenshoiraitaishoichiran(ikenshoiraitaishoichiranDiv ikenshoiraitaishoichiran) {
        this.ikenshoiraitaishoichiran = ikenshoiraitaishoichiran;
    }

    /*
     * getbtnikenshoiraitaishooutput
     * @return btnikenshoiraitaishooutput
     */
    @JsonProperty("btnikenshoiraitaishooutput")
    public ButtonDownLoad getBtnikenshoiraitaishooutput() {
        return btnikenshoiraitaishooutput;
    }

    /*
     * setbtnikenshoiraitaishooutput
     * @param btnikenshoiraitaishooutput btnikenshoiraitaishooutput
     */
    @JsonProperty("btnikenshoiraitaishooutput")
    public void setBtnikenshoiraitaishooutput(ButtonDownLoad btnikenshoiraitaishooutput) {
        this.btnikenshoiraitaishooutput = btnikenshoiraitaishooutput;
    }

    /*
     * getbtnShujiiSettei
     * @return btnShujiiSettei
     */
    @JsonProperty("btnShujiiSettei")
    public Button getBtnShujiiSettei() {
        return btnShujiiSettei;
    }

    /*
     * setbtnShujiiSettei
     * @param btnShujiiSettei btnShujiiSettei
     */
    @JsonProperty("btnShujiiSettei")
    public void setBtnShujiiSettei(Button btnShujiiSettei) {
        this.btnShujiiSettei = btnShujiiSettei;
    }

    /*
     * getbtnSakuseiIraiYmdSettei
     * @return btnSakuseiIraiYmdSettei
     */
    @JsonProperty("btnSakuseiIraiYmdSettei")
    public Button getBtnSakuseiIraiYmdSettei() {
        return btnSakuseiIraiYmdSettei;
    }

    /*
     * setbtnSakuseiIraiYmdSettei
     * @param btnSakuseiIraiYmdSettei btnSakuseiIraiYmdSettei
     */
    @JsonProperty("btnSakuseiIraiYmdSettei")
    public void setBtnSakuseiIraiYmdSettei(Button btnSakuseiIraiYmdSettei) {
        this.btnSakuseiIraiYmdSettei = btnSakuseiIraiYmdSettei;
    }

    /*
     * getbtnIraishoToOutputDialog
     * @return btnIraishoToOutputDialog
     */
    @JsonProperty("btnIraishoToOutputDialog")
    public ButtonDialog getBtnIraishoToOutputDialog() {
        return btnIraishoToOutputDialog;
    }

    /*
     * setbtnIraishoToOutputDialog
     * @param btnIraishoToOutputDialog btnIraishoToOutputDialog
     */
    @JsonProperty("btnIraishoToOutputDialog")
    public void setBtnIraishoToOutputDialog(ButtonDialog btnIraishoToOutputDialog) {
        this.btnIraishoToOutputDialog = btnIraishoToOutputDialog;
    }

    /*
     * getIkenshoIraiTorokuPanel
     * @return IkenshoIraiTorokuPanel
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    public IkenshoIraiTorokuPanelDiv getIkenshoIraiTorokuPanel() {
        return IkenshoIraiTorokuPanel;
    }

    /*
     * setIkenshoIraiTorokuPanel
     * @param IkenshoIraiTorokuPanel IkenshoIraiTorokuPanel
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    public void setIkenshoIraiTorokuPanel(IkenshoIraiTorokuPanelDiv IkenshoIraiTorokuPanel) {
        this.IkenshoIraiTorokuPanel = IkenshoIraiTorokuPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShoriJyotai() {
        return this.getIkenshoiraitaishoichiran().getRadShoriJyotai();
    }

    @JsonIgnore
    public void  setRadShoriJyotai(RadioButton radShoriJyotai) {
        this.getIkenshoiraitaishoichiran().setRadShoriJyotai(radShoriJyotai);
    }

    @JsonIgnore
    public TextBoxNum getTxtTotalCount() {
        return this.getIkenshoiraitaishoichiran().getTxtTotalCount();
    }

    @JsonIgnore
    public void  setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.getIkenshoiraitaishoichiran().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtCompleteCount() {
        return this.getIkenshoiraitaishoichiran().getTxtCompleteCount();
    }

    @JsonIgnore
    public void  setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.getIkenshoiraitaishoichiran().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtNoUpdate() {
        return this.getIkenshoiraitaishoichiran().getTxtNoUpdate();
    }

    @JsonIgnore
    public void  setTxtNoUpdate(TextBoxNum txtNoUpdate) {
        this.getIkenshoiraitaishoichiran().setTxtNoUpdate(txtNoUpdate);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getIkenshoiraitaishoichiran().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getIkenshoiraitaishoichiran().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return this.getIkenshoiraitaishoichiran().getTxtSaidaiHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.getIkenshoiraitaishoichiran().setTxtSaidaiHyojiKensu(txtSaidaiHyojiKensu);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getIkenshoiraitaishoichiran().getCcdHokenshaList();
    }

    @JsonIgnore
    public DropDownList getDdlIraiKubun() {
        return this.getIkenshoIraiTorokuPanel().getDdlIraiKubun();
    }

    @JsonIgnore
    public void  setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.getIkenshoIraiTorokuPanel().setDdlIraiKubun(ddlIraiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiIraiYmd() {
        return this.getIkenshoIraiTorokuPanel().getTxtSakuseiIraiYmd();
    }

    @JsonIgnore
    public void  setTxtSakuseiIraiYmd(TextBoxDate txtSakuseiIraiYmd) {
        this.getIkenshoIraiTorokuPanel().setTxtSakuseiIraiYmd(txtSakuseiIraiYmd);
    }

    @JsonIgnore
    public Button getBtnSettei() {
        return this.getIkenshoIraiTorokuPanel().getBtnSettei();
    }

    @JsonIgnore
    public void  setBtnSettei(Button btnSettei) {
        this.getIkenshoIraiTorokuPanel().setBtnSettei(btnSettei);
    }

    @JsonIgnore
    public Button getBtnSetteisezuModoru() {
        return this.getIkenshoIraiTorokuPanel().getBtnSetteisezuModoru();
    }

    @JsonIgnore
    public void  setBtnSetteisezuModoru(Button btnSetteisezuModoru) {
        this.getIkenshoIraiTorokuPanel().setBtnSetteisezuModoru(btnSetteisezuModoru);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiInput() {
        return this.getIkenshoIraiTorokuPanel().getCcdShujiiInput();
    }

    // </editor-fold>
}
