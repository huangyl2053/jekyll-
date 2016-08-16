package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBC2000022PanelAll のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBC2000022PanelAllDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("PanelHyoji")
    private PanelHyojiDiv PanelHyoji;
    @JsonProperty("dgFutanWariai")
    private DataGrid<dgFutanWariai_Row> dgFutanWariai;
    @JsonProperty("PanelEditButton")
    private PanelEditButtonDiv PanelEditButton;
    @JsonProperty("PanelEdit")
    private PanelEditDiv PanelEdit;
    @JsonProperty("PanelHosokuItem")
    private PanelHosokuItemDiv PanelHosokuItem;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;
    @JsonProperty("EditMode")
    private RString EditMode;
    @JsonProperty("hdnShikibetsuCode")
    private RString hdnShikibetsuCode;
    @JsonProperty("hdnGyomuCode")
    private RString hdnGyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getPanelHyoji
     * @return PanelHyoji
     */
    @JsonProperty("PanelHyoji")
    public PanelHyojiDiv getPanelHyoji() {
        return PanelHyoji;
    }

    /*
     * setPanelHyoji
     * @param PanelHyoji PanelHyoji
     */
    @JsonProperty("PanelHyoji")
    public void setPanelHyoji(PanelHyojiDiv PanelHyoji) {
        this.PanelHyoji = PanelHyoji;
    }

    /*
     * getdgFutanWariai
     * @return dgFutanWariai
     */
    @JsonProperty("dgFutanWariai")
    public DataGrid<dgFutanWariai_Row> getDgFutanWariai() {
        return dgFutanWariai;
    }

    /*
     * setdgFutanWariai
     * @param dgFutanWariai dgFutanWariai
     */
    @JsonProperty("dgFutanWariai")
    public void setDgFutanWariai(DataGrid<dgFutanWariai_Row> dgFutanWariai) {
        this.dgFutanWariai = dgFutanWariai;
    }

    /*
     * getPanelEditButton
     * @return PanelEditButton
     */
    @JsonProperty("PanelEditButton")
    public PanelEditButtonDiv getPanelEditButton() {
        return PanelEditButton;
    }

    /*
     * setPanelEditButton
     * @param PanelEditButton PanelEditButton
     */
    @JsonProperty("PanelEditButton")
    public void setPanelEditButton(PanelEditButtonDiv PanelEditButton) {
        this.PanelEditButton = PanelEditButton;
    }

    /*
     * getPanelEdit
     * @return PanelEdit
     */
    @JsonProperty("PanelEdit")
    public PanelEditDiv getPanelEdit() {
        return PanelEdit;
    }

    /*
     * setPanelEdit
     * @param PanelEdit PanelEdit
     */
    @JsonProperty("PanelEdit")
    public void setPanelEdit(PanelEditDiv PanelEdit) {
        this.PanelEdit = PanelEdit;
    }

    /*
     * getPanelHosokuItem
     * @return PanelHosokuItem
     */
    @JsonProperty("PanelHosokuItem")
    public PanelHosokuItemDiv getPanelHosokuItem() {
        return PanelHosokuItem;
    }

    /*
     * setPanelHosokuItem
     * @param PanelHosokuItem PanelHosokuItem
     */
    @JsonProperty("PanelHosokuItem")
    public void setPanelHosokuItem(PanelHosokuItemDiv PanelHosokuItem) {
        this.PanelHosokuItem = PanelHosokuItem;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * getEditMode
     * @return EditMode
     */
    @JsonProperty("EditMode")
    public RString getEditMode() {
        return EditMode;
    }

    /*
     * setEditMode
     * @param EditMode EditMode
     */
    @JsonProperty("EditMode")
    public void setEditMode(RString EditMode) {
        this.EditMode = EditMode;
    }

    /*
     * gethdnShikibetsuCode
     * @return hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public RString getHdnShikibetsuCode() {
        return hdnShikibetsuCode;
    }

    /*
     * sethdnShikibetsuCode
     * @param hdnShikibetsuCode hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public void setHdnShikibetsuCode(RString hdnShikibetsuCode) {
        this.hdnShikibetsuCode = hdnShikibetsuCode;
    }

    /*
     * gethdnGyomuCode
     * @return hdnGyomuCode
     */
    @JsonProperty("hdnGyomuCode")
    public RString getHdnGyomuCode() {
        return hdnGyomuCode;
    }

    /*
     * sethdnGyomuCode
     * @param hdnGyomuCode hdnGyomuCode
     */
    @JsonProperty("hdnGyomuCode")
    public void setHdnGyomuCode(RString hdnGyomuCode) {
        this.hdnGyomuCode = hdnGyomuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlNendo() {
        return this.getPanelHyoji().getDdlNendo();
    }

    @JsonIgnore
    public void  setDdlNendo(DropDownList ddlNendo) {
        this.getPanelHyoji().setDdlNendo(ddlNendo);
    }

    @JsonIgnore
    public DropDownList getDdlRirekiNo() {
        return this.getPanelHyoji().getDdlRirekiNo();
    }

    @JsonIgnore
    public void  setDdlRirekiNo(DropDownList ddlRirekiNo) {
        this.getPanelHyoji().setDdlRirekiNo(ddlRirekiNo);
    }

    @JsonIgnore
    public Button getBtnHyoji() {
        return this.getPanelHyoji().getBtnHyoji();
    }

    @JsonIgnore
    public void  setBtnHyoji(Button btnHyoji) {
        this.getPanelHyoji().setBtnHyoji(btnHyoji);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPanelHyoji().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPanelHyoji().setBtnClear(btnClear);
    }

    @JsonIgnore
    public TextBoxDate getTxtHanteibi() {
        return this.getPanelHyoji().getTxtHanteibi();
    }

    @JsonIgnore
    public void  setTxtHanteibi(TextBoxDate txtHanteibi) {
        this.getPanelHyoji().setTxtHanteibi(txtHanteibi);
    }

    @JsonIgnore
    public TextBox getTxtHanteiKubun() {
        return this.getPanelHyoji().getTxtHanteiKubun();
    }

    @JsonIgnore
    public void  setTxtHanteiKubun(TextBox txtHanteiKubun) {
        this.getPanelHyoji().setTxtHanteiKubun(txtHanteiKubun);
    }

    @JsonIgnore
    public ButtonDialog getBtnSeikatsuHogo() {
        return this.getPanelHyoji().getBtnSeikatsuHogo();
    }

    @JsonIgnore
    public void  setBtnSeikatsuHogo(ButtonDialog btnSeikatsuHogo) {
        this.getPanelHyoji().setBtnSeikatsuHogo(btnSeikatsuHogo);
    }

    @JsonIgnore
    public Button getBtnAddBefore() {
        return this.getPanelEditButton().getBtnAddBefore();
    }

    @JsonIgnore
    public void  setBtnAddBefore(Button btnAddBefore) {
        this.getPanelEditButton().setBtnAddBefore(btnAddBefore);
    }

    @JsonIgnore
    public Button getBtnAddNext() {
        return this.getPanelEditButton().getBtnAddNext();
    }

    @JsonIgnore
    public void  setBtnAddNext(Button btnAddNext) {
        this.getPanelEditButton().setBtnAddNext(btnAddNext);
    }

    @JsonIgnore
    public Button getBtnEdit() {
        return this.getPanelEditButton().getBtnEdit();
    }

    @JsonIgnore
    public void  setBtnEdit(Button btnEdit) {
        this.getPanelEditButton().setBtnEdit(btnEdit);
    }

    @JsonIgnore
    public DropDownList getDdlShikaku() {
        return this.getPanelEdit().getDdlShikaku();
    }

    @JsonIgnore
    public void  setDdlShikaku(DropDownList ddlShikaku) {
        this.getPanelEdit().setDdlShikaku(ddlShikaku);
    }

    @JsonIgnore
    public DropDownList getDdlFutanWariai() {
        return this.getPanelEdit().getDdlFutanWariai();
    }

    @JsonIgnore
    public void  setDdlFutanWariai(DropDownList ddlFutanWariai) {
        this.getPanelEdit().setDdlFutanWariai(ddlFutanWariai);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoKaishibi() {
        return this.getPanelEdit().getTxtTekiyoKaishibi();
    }

    @JsonIgnore
    public void  setTxtTekiyoKaishibi(TextBoxDate txtTekiyoKaishibi) {
        this.getPanelEdit().setTxtTekiyoKaishibi(txtTekiyoKaishibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoShuryobi() {
        return this.getPanelEdit().getTxtTekiyoShuryobi();
    }

    @JsonIgnore
    public void  setTxtTekiyoShuryobi(TextBoxDate txtTekiyoShuryobi) {
        this.getPanelEdit().setTxtTekiyoShuryobi(txtTekiyoShuryobi);
    }

    @JsonIgnore
    public TextBoxNum getTxtHonninGokeiShotoku() {
        return this.getPanelEdit().getTxtHonninGokeiShotoku();
    }

    @JsonIgnore
    public void  setTxtHonninGokeiShotoku(TextBoxNum txtHonninGokeiShotoku) {
        this.getPanelEdit().setTxtHonninGokeiShotoku(txtHonninGokeiShotoku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiinsu() {
        return this.getPanelEdit().getTxtSetaiinsu();
    }

    @JsonIgnore
    public void  setTxtSetaiinsu(TextBoxNum txtSetaiinsu) {
        this.getPanelEdit().setTxtSetaiinsu(txtSetaiinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkinShunyuGokei() {
        return this.getPanelEdit().getTxtNenkinShunyuGokei();
    }

    @JsonIgnore
    public void  setTxtNenkinShunyuGokei(TextBoxNum txtNenkinShunyuGokei) {
        this.getPanelEdit().setTxtNenkinShunyuGokei(txtNenkinShunyuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaGokei() {
        return this.getPanelEdit().getTxtSonotaGokei();
    }

    @JsonIgnore
    public void  setTxtSonotaGokei(TextBoxNum txtSonotaGokei) {
        this.getPanelEdit().setTxtSonotaGokei(txtSonotaGokei);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getPanelEdit().getTxtBiko();
    }

    @JsonIgnore
    public void  setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getPanelEdit().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public PanelEditItemDiv getPanelEditItem() {
        return this.getPanelEdit().getPanelEditItem();
    }

    @JsonIgnore
    public void  setPanelEditItem(PanelEditItemDiv PanelEditItem) {
        this.getPanelEdit().setPanelEditItem(PanelEditItem);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getPanelEdit().getPanelEditItem().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getPanelEdit().getPanelEditItem().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelEdit().getPanelEditItem().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelEdit().getPanelEditItem().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public CheckBoxList getChkShokkenHenko() {
        return this.getPanelHosokuItem().getChkShokkenHenko();
    }

    @JsonIgnore
    public void  setChkShokkenHenko(CheckBoxList chkShokkenHenko) {
        this.getPanelHosokuItem().setChkShokkenHenko(chkShokkenHenko);
    }

    @JsonIgnore
    public CheckBoxList getChkShoHakkoFuyo() {
        return this.getPanelHosokuItem().getChkShoHakkoFuyo();
    }

    @JsonIgnore
    public void  setChkShoHakkoFuyo(CheckBoxList chkShoHakkoFuyo) {
        this.getPanelHosokuItem().setChkShoHakkoFuyo(chkShoHakkoFuyo);
    }

    @JsonIgnore
    public DropDownList getDdlHakkoKubun() {
        return this.getPanelHosokuItem().getDdlHakkoKubun();
    }

    @JsonIgnore
    public void  setDdlHakkoKubun(DropDownList ddlHakkoKubun) {
        this.getPanelHosokuItem().setDdlHakkoKubun(ddlHakkoKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunbi() {
        return this.getPanelHosokuItem().getTxtKijunbi();
    }

    @JsonIgnore
    public void  setTxtKijunbi(TextBoxDate txtKijunbi) {
        this.getPanelHosokuItem().setTxtKijunbi(txtKijunbi);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkobi() {
        return this.getPanelHosokuItem().getTxtHakkobi();
    }

    @JsonIgnore
    public void  setTxtHakkobi(TextBoxDate txtHakkobi) {
        this.getPanelHosokuItem().setTxtHakkobi(txtHakkobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKofubi() {
        return this.getPanelHosokuItem().getTxtKofubi();
    }

    @JsonIgnore
    public void  setTxtKofubi(TextBoxDate txtKofubi) {
        this.getPanelHosokuItem().setTxtKofubi(txtKofubi);
    }

    @JsonIgnore
    public DropDownList getDdlKofuJiyu() {
        return this.getPanelHosokuItem().getDdlKofuJiyu();
    }

    @JsonIgnore
    public void  setDdlKofuJiyu(DropDownList ddlKofuJiyu) {
        this.getPanelHosokuItem().setDdlKofuJiyu(ddlKofuJiyu);
    }

    // </editor-fold>
}
