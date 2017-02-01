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
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoIraiTaishoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoIraiTaishoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IkenshoIraiList")
    private IkenshoIraiListDiv IkenshoIraiList;
    @JsonProperty("ccdKanryoMsg")
    private KanryoMessageDiv ccdKanryoMsg;
    @JsonProperty("hiddenIuputModel")
    private RString hiddenIuputModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIkenshoIraiList
     * @return IkenshoIraiList
     */
    @JsonProperty("IkenshoIraiList")
    public IkenshoIraiListDiv getIkenshoIraiList() {
        return IkenshoIraiList;
    }

    /*
     * setIkenshoIraiList
     * @param IkenshoIraiList IkenshoIraiList
     */
    @JsonProperty("IkenshoIraiList")
    public void setIkenshoIraiList(IkenshoIraiListDiv IkenshoIraiList) {
        this.IkenshoIraiList = IkenshoIraiList;
    }

    /*
     * getccdKanryoMsg
     * @return ccdKanryoMsg
     */
    @JsonProperty("ccdKanryoMsg")
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return ccdKanryoMsg;
    }

    /*
     * gethiddenIuputModel
     * @return hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public RString getHiddenIuputModel() {
        return hiddenIuputModel;
    }

    /*
     * sethiddenIuputModel
     * @param hiddenIuputModel hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public void setHiddenIuputModel(RString hiddenIuputModel) {
        this.hiddenIuputModel = hiddenIuputModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ikenshoiraitaishoichiranDiv getIkenshoiraitaishoichiran() {
        return this.getIkenshoIraiList().getIkenshoiraitaishoichiran();
    }

    @JsonIgnore
    public void  setIkenshoiraitaishoichiran(ikenshoiraitaishoichiranDiv ikenshoiraitaishoichiran) {
        this.getIkenshoIraiList().setIkenshoiraitaishoichiran(ikenshoiraitaishoichiran);
    }

    @JsonIgnore
    public RadioButton getRadShoriJyotai() {
        return this.getIkenshoIraiList().getIkenshoiraitaishoichiran().getRadShoriJyotai();
    }

    @JsonIgnore
    public void  setRadShoriJyotai(RadioButton radShoriJyotai) {
        this.getIkenshoIraiList().getIkenshoiraitaishoichiran().setRadShoriJyotai(radShoriJyotai);
    }

    @JsonIgnore
    public TextBoxNum getTxtTotalCount() {
        return this.getIkenshoIraiList().getIkenshoiraitaishoichiran().getTxtTotalCount();
    }

    @JsonIgnore
    public void  setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.getIkenshoIraiList().getIkenshoiraitaishoichiran().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtCompleteCount() {
        return this.getIkenshoIraiList().getIkenshoiraitaishoichiran().getTxtCompleteCount();
    }

    @JsonIgnore
    public void  setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.getIkenshoIraiList().getIkenshoiraitaishoichiran().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtNoUpdate() {
        return this.getIkenshoIraiList().getIkenshoiraitaishoichiran().getTxtNoUpdate();
    }

    @JsonIgnore
    public void  setTxtNoUpdate(TextBoxNum txtNoUpdate) {
        this.getIkenshoIraiList().getIkenshoiraitaishoichiran().setTxtNoUpdate(txtNoUpdate);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getIkenshoIraiList().getIkenshoiraitaishoichiran().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getIkenshoIraiList().getIkenshoiraitaishoichiran().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return this.getIkenshoIraiList().getIkenshoiraitaishoichiran().getTxtSaidaiHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.getIkenshoIraiList().getIkenshoiraitaishoichiran().setTxtSaidaiHyojiKensu(txtSaidaiHyojiKensu);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getIkenshoIraiList().getIkenshoiraitaishoichiran().getCcdHokenshaList();
    }

    @JsonIgnore
    public ButtonDownLoad getBtnikenshoiraitaishooutput() {
        return this.getIkenshoIraiList().getBtnikenshoiraitaishooutput();
    }

    @JsonIgnore
    public void  setBtnikenshoiraitaishooutput(ButtonDownLoad btnikenshoiraitaishooutput) {
        this.getIkenshoIraiList().setBtnikenshoiraitaishooutput(btnikenshoiraitaishooutput);
    }

    @JsonIgnore
    public Button getBtnShujiiSettei() {
        return this.getIkenshoIraiList().getBtnShujiiSettei();
    }

    @JsonIgnore
    public void  setBtnShujiiSettei(Button btnShujiiSettei) {
        this.getIkenshoIraiList().setBtnShujiiSettei(btnShujiiSettei);
    }

    @JsonIgnore
    public Button getBtnSakuseiIraiYmdSettei() {
        return this.getIkenshoIraiList().getBtnSakuseiIraiYmdSettei();
    }

    @JsonIgnore
    public void  setBtnSakuseiIraiYmdSettei(Button btnSakuseiIraiYmdSettei) {
        this.getIkenshoIraiList().setBtnSakuseiIraiYmdSettei(btnSakuseiIraiYmdSettei);
    }

    @JsonIgnore
    public ButtonDialog getBtnIraishoToOutputDialog() {
        return this.getIkenshoIraiList().getBtnIraishoToOutputDialog();
    }

    @JsonIgnore
    public void  setBtnIraishoToOutputDialog(ButtonDialog btnIraishoToOutputDialog) {
        this.getIkenshoIraiList().setBtnIraishoToOutputDialog(btnIraishoToOutputDialog);
    }

    @JsonIgnore
    public IkenshoIraiTorokuPanelDiv getIkenshoIraiTorokuPanel() {
        return this.getIkenshoIraiList().getIkenshoIraiTorokuPanel();
    }

    @JsonIgnore
    public void  setIkenshoIraiTorokuPanel(IkenshoIraiTorokuPanelDiv IkenshoIraiTorokuPanel) {
        this.getIkenshoIraiList().setIkenshoIraiTorokuPanel(IkenshoIraiTorokuPanel);
    }

    @JsonIgnore
    public DropDownList getDdlIraiKubun() {
        return this.getIkenshoIraiList().getIkenshoIraiTorokuPanel().getDdlIraiKubun();
    }

    @JsonIgnore
    public void  setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.getIkenshoIraiList().getIkenshoIraiTorokuPanel().setDdlIraiKubun(ddlIraiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiIraiYmd() {
        return this.getIkenshoIraiList().getIkenshoIraiTorokuPanel().getTxtSakuseiIraiYmd();
    }

    @JsonIgnore
    public void  setTxtSakuseiIraiYmd(TextBoxDate txtSakuseiIraiYmd) {
        this.getIkenshoIraiList().getIkenshoIraiTorokuPanel().setTxtSakuseiIraiYmd(txtSakuseiIraiYmd);
    }

    @JsonIgnore
    public Button getBtnSettei() {
        return this.getIkenshoIraiList().getIkenshoIraiTorokuPanel().getBtnSettei();
    }

    @JsonIgnore
    public void  setBtnSettei(Button btnSettei) {
        this.getIkenshoIraiList().getIkenshoIraiTorokuPanel().setBtnSettei(btnSettei);
    }

    @JsonIgnore
    public Button getBtnSetteisezuModoru() {
        return this.getIkenshoIraiList().getIkenshoIraiTorokuPanel().getBtnSetteisezuModoru();
    }

    @JsonIgnore
    public void  setBtnSetteisezuModoru(Button btnSetteisezuModoru) {
        this.getIkenshoIraiList().getIkenshoIraiTorokuPanel().setBtnSetteisezuModoru(btnSetteisezuModoru);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiInput() {
        return this.getIkenshoIraiList().getIkenshoIraiTorokuPanel().getCcdShujiiInput();
    }

    // </editor-fold>
}
