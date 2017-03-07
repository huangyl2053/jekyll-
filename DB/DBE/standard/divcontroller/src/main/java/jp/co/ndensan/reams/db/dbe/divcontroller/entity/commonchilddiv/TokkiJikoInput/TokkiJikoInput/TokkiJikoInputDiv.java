package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.IChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.INinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokkiJikoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkiJikoInputDiv extends Panel implements ITokkiJikoInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaTaishosha")
    private ChosaTaishoshaDiv ChosaTaishosha;
    @JsonProperty("ChosaJisshisha")
    private ChosaJisshishaDiv ChosaJisshisha;
    @JsonProperty("TokkiJikoNyuryoku")
    private TokkiJikoNyuryokuDiv TokkiJikoNyuryoku;
    @JsonProperty("hdnDdlSelectedKey")
    private RString hdnDdlSelectedKey;
    @JsonProperty("hdnRadSelectedKey")
    private RString hdnRadSelectedKey;
    @JsonProperty("hdnTokkiJiko")
    private RString hdnTokkiJiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosaTaishosha
     * @return ChosaTaishosha
     */
    @JsonProperty("ChosaTaishosha")
    public ChosaTaishoshaDiv getChosaTaishosha() {
        return ChosaTaishosha;
    }

    /*
     * setChosaTaishosha
     * @param ChosaTaishosha ChosaTaishosha
     */
    @JsonProperty("ChosaTaishosha")
    public void setChosaTaishosha(ChosaTaishoshaDiv ChosaTaishosha) {
        this.ChosaTaishosha = ChosaTaishosha;
    }

    /*
     * getChosaJisshisha
     * @return ChosaJisshisha
     */
    @JsonProperty("ChosaJisshisha")
    public ChosaJisshishaDiv getChosaJisshisha() {
        return ChosaJisshisha;
    }

    /*
     * setChosaJisshisha
     * @param ChosaJisshisha ChosaJisshisha
     */
    @JsonProperty("ChosaJisshisha")
    public void setChosaJisshisha(ChosaJisshishaDiv ChosaJisshisha) {
        this.ChosaJisshisha = ChosaJisshisha;
    }

    /*
     * getTokkiJikoNyuryoku
     * @return TokkiJikoNyuryoku
     */
    @JsonProperty("TokkiJikoNyuryoku")
    public TokkiJikoNyuryokuDiv getTokkiJikoNyuryoku() {
        return TokkiJikoNyuryoku;
    }

    /*
     * setTokkiJikoNyuryoku
     * @param TokkiJikoNyuryoku TokkiJikoNyuryoku
     */
    @JsonProperty("TokkiJikoNyuryoku")
    public void setTokkiJikoNyuryoku(TokkiJikoNyuryokuDiv TokkiJikoNyuryoku) {
        this.TokkiJikoNyuryoku = TokkiJikoNyuryoku;
    }

    /*
     * gethdnDdlSelectedKey
     * @return hdnDdlSelectedKey
     */
    @JsonProperty("hdnDdlSelectedKey")
    public RString getHdnDdlSelectedKey() {
        return hdnDdlSelectedKey;
    }

    /*
     * sethdnDdlSelectedKey
     * @param hdnDdlSelectedKey hdnDdlSelectedKey
     */
    @JsonProperty("hdnDdlSelectedKey")
    public void setHdnDdlSelectedKey(RString hdnDdlSelectedKey) {
        this.hdnDdlSelectedKey = hdnDdlSelectedKey;
    }

    /*
     * gethdnRadSelectedKey
     * @return hdnRadSelectedKey
     */
    @JsonProperty("hdnRadSelectedKey")
    public RString getHdnRadSelectedKey() {
        return hdnRadSelectedKey;
    }

    /*
     * sethdnRadSelectedKey
     * @param hdnRadSelectedKey hdnRadSelectedKey
     */
    @JsonProperty("hdnRadSelectedKey")
    public void setHdnRadSelectedKey(RString hdnRadSelectedKey) {
        this.hdnRadSelectedKey = hdnRadSelectedKey;
    }

    /*
     * gethdnTokkiJiko
     * @return hdnTokkiJiko
     */
    @JsonProperty("hdnTokkiJiko")
    public RString getHdnTokkiJiko() {
        return hdnTokkiJiko;
    }

    /*
     * sethdnTokkiJiko
     * @param hdnTokkiJiko hdnTokkiJiko
     */
    @JsonProperty("hdnTokkiJiko")
    public void setHdnTokkiJiko(RString hdnTokkiJiko) {
        this.hdnTokkiJiko = hdnTokkiJiko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihon() {
        return this.getChosaTaishosha().getCcdNinteiShinseishaKihon();
    }

    @JsonIgnore
    public INinteiShinseiRenrakusakiKihonDiv getCcdNinteiShinseiRenrakusakiKihon() {
        return this.getChosaTaishosha().getCcdNinteiShinseiRenrakusakiKihon();
    }

    @JsonIgnore
    public IChosaJisshishaJohoDiv getCcdChosaJisshishaJoho() {
        return this.getChosaJisshisha().getCcdChosaJisshishaJoho();
    }

    @JsonIgnore
    public RadioButton getRadTokkiJikoGroup() {
        return this.getTokkiJikoNyuryoku().getRadTokkiJikoGroup();
    }

    @JsonIgnore
    public void  setRadTokkiJikoGroup(RadioButton radTokkiJikoGroup) {
        this.getTokkiJikoNyuryoku().setRadTokkiJikoGroup(radTokkiJikoGroup);
    }

    @JsonIgnore
    public DropDownList getDdlTokkiJikoNo() {
        return this.getTokkiJikoNyuryoku().getDdlTokkiJikoNo();
    }

    @JsonIgnore
    public void  setDdlTokkiJikoNo(DropDownList ddlTokkiJikoNo) {
        this.getTokkiJikoNyuryoku().setDdlTokkiJikoNo(ddlTokkiJikoNo);
    }

    @JsonIgnore
    public Button getBtnInput() {
        return this.getTokkiJikoNyuryoku().getBtnInput();
    }

    @JsonIgnore
    public void  setBtnInput(Button btnInput) {
        this.getTokkiJikoNyuryoku().setBtnInput(btnInput);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokkiJiko() {
        return this.getTokkiJikoNyuryoku().getTxtTokkiJiko();
    }

    @JsonIgnore
    public void  setTxtTokkiJiko(TextBoxMultiLine txtTokkiJiko) {
        this.getTokkiJikoNyuryoku().setTxtTokkiJiko(txtTokkiJiko);
    }

    @JsonIgnore
    public Button getBtnSave() {
        return this.getTokkiJikoNyuryoku().getBtnSave();
    }

    @JsonIgnore
    public void  setBtnSave(Button btnSave) {
        this.getTokkiJikoNyuryoku().setBtnSave(btnSave);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getTokkiJikoNyuryoku().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getTokkiJikoNyuryoku().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnDelete() {
        return this.getTokkiJikoNyuryoku().getBtnDelete();
    }

    @JsonIgnore
    public void  setBtnDelete(Button btnDelete) {
        this.getTokkiJikoNyuryoku().setBtnDelete(btnDelete);
    }

    @JsonIgnore
    public Button getBtnDeleteCancel() {
        return this.getTokkiJikoNyuryoku().getBtnDeleteCancel();
    }

    @JsonIgnore
    public void  setBtnDeleteCancel(Button btnDeleteCancel) {
        this.getTokkiJikoNyuryoku().setBtnDeleteCancel(btnDeleteCancel);
    }

    @JsonIgnore
    public DataGrid<dgTokkiJikoJoho_Row> getDgTokkiJikoJoho() {
        return this.getTokkiJikoNyuryoku().getDgTokkiJikoJoho();
    }

    @JsonIgnore
    public void  setDgTokkiJikoJoho(DataGrid<dgTokkiJikoJoho_Row> dgTokkiJikoJoho) {
        this.getTokkiJikoNyuryoku().setDgTokkiJikoJoho(dgTokkiJikoJoho);
    }

    @JsonIgnore
    public Button getBtnReturn() {
        return this.getTokkiJikoNyuryoku().getBtnReturn();
    }

    @JsonIgnore
    public void  setBtnReturn(Button btnReturn) {
        this.getTokkiJikoNyuryoku().setBtnReturn(btnReturn);
    }

    @JsonIgnore
    public Button getBtnUpdateCancel() {
        return this.getTokkiJikoNyuryoku().getBtnUpdateCancel();
    }

    @JsonIgnore
    public void  setBtnUpdateCancel(Button btnUpdateCancel) {
        this.getTokkiJikoNyuryoku().setBtnUpdateCancel(btnUpdateCancel);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
