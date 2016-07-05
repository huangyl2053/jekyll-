package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ShujiiIkenshoSakuseiryoNyuryoku のクラスファイル
 *
 * @author 自動生成
 */
public class ShujiiIkenshoSakuseiryoNyuryokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiKensakuJoken")
    private ShujiiKensakuJokenDiv ShujiiKensakuJoken;
    @JsonProperty("Shujii")
    private ShujiiDiv Shujii;
    @JsonProperty("ShinseiJoho")
    private ShinseiJohoDiv ShinseiJoho;
    @JsonProperty("ShinseiJohoMeisai")
    private ShinseiJohoMeisaiDiv ShinseiJohoMeisai;
    @JsonProperty("ShinsakaiMessage")
    private ShinsakaiMessageDiv ShinsakaiMessage;
    @JsonProperty("hdnState")
    private RString hdnState;
    @JsonProperty("hdnShichosonCode")
    private RString hdnShichosonCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShujiiKensakuJoken
     * @return ShujiiKensakuJoken
     */
    @JsonProperty("ShujiiKensakuJoken")
    public ShujiiKensakuJokenDiv getShujiiKensakuJoken() {
        return ShujiiKensakuJoken;
    }

    /*
     * setShujiiKensakuJoken
     * @param ShujiiKensakuJoken ShujiiKensakuJoken
     */
    @JsonProperty("ShujiiKensakuJoken")
    public void setShujiiKensakuJoken(ShujiiKensakuJokenDiv ShujiiKensakuJoken) {
        this.ShujiiKensakuJoken = ShujiiKensakuJoken;
    }

    /*
     * getShujii
     * @return Shujii
     */
    @JsonProperty("Shujii")
    public ShujiiDiv getShujii() {
        return Shujii;
    }

    /*
     * setShujii
     * @param Shujii Shujii
     */
    @JsonProperty("Shujii")
    public void setShujii(ShujiiDiv Shujii) {
        this.Shujii = Shujii;
    }

    /*
     * getShinseiJoho
     * @return ShinseiJoho
     */
    @JsonProperty("ShinseiJoho")
    public ShinseiJohoDiv getShinseiJoho() {
        return ShinseiJoho;
    }

    /*
     * setShinseiJoho
     * @param ShinseiJoho ShinseiJoho
     */
    @JsonProperty("ShinseiJoho")
    public void setShinseiJoho(ShinseiJohoDiv ShinseiJoho) {
        this.ShinseiJoho = ShinseiJoho;
    }

    /*
     * getShinseiJohoMeisai
     * @return ShinseiJohoMeisai
     */
    @JsonProperty("ShinseiJohoMeisai")
    public ShinseiJohoMeisaiDiv getShinseiJohoMeisai() {
        return ShinseiJohoMeisai;
    }

    /*
     * setShinseiJohoMeisai
     * @param ShinseiJohoMeisai ShinseiJohoMeisai
     */
    @JsonProperty("ShinseiJohoMeisai")
    public void setShinseiJohoMeisai(ShinseiJohoMeisaiDiv ShinseiJohoMeisai) {
        this.ShinseiJohoMeisai = ShinseiJohoMeisai;
    }

    /*
     * getShinsakaiMessage
     * @return ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public ShinsakaiMessageDiv getShinsakaiMessage() {
        return ShinsakaiMessage;
    }

    /*
     * setShinsakaiMessage
     * @param ShinsakaiMessage ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public void setShinsakaiMessage(ShinsakaiMessageDiv ShinsakaiMessage) {
        this.ShinsakaiMessage = ShinsakaiMessage;
    }

    /*
     * gethdnState
     * @return hdnState
     */
    @JsonProperty("hdnState")
    public RString getHdnState() {
        return hdnState;
    }

    /*
     * sethdnState
     * @param hdnState hdnState
     */
    @JsonProperty("hdnState")
    public void setHdnState(RString hdnState) {
        this.hdnState = hdnState;
    }

    /*
     * gethdnShichosonCode
     * @return hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public RString getHdnShichosonCode() {
        return hdnShichosonCode;
    }

    /*
     * sethdnShichosonCode
     * @param hdnShichosonCode hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public void setHdnShichosonCode(RString hdnShichosonCode) {
        this.hdnShichosonCode = hdnShichosonCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShujiiei() {
        return this.getShujiiKensakuJoken().getTxtShujiiei();
    }

    @JsonIgnore
    public void setTxtShujiiei(TextBox txtShujiiei) {
        this.getShujiiKensakuJoken().setTxtShujiiei(txtShujiiei);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaNameMatchType() {
        return this.getShujiiKensakuJoken().getDdlHihokenshaNameMatchType();
    }

    @JsonIgnore
    public void setDdlHihokenshaNameMatchType(DropDownList ddlHihokenshaNameMatchType) {
        this.getShujiiKensakuJoken().setDdlHihokenshaNameMatchType(ddlHihokenshaNameMatchType);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKensakuNendo() {
        return this.getShujiiKensakuJoken().getTxtKensakuNendo();
    }

    @JsonIgnore
    public void setTxtKensakuNendo(TextBoxDateRange txtKensakuNendo) {
        this.getShujiiKensakuJoken().setTxtKensakuNendo(txtKensakuNendo);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxCount() {
        return this.getShujiiKensakuJoken().getTxtMaxCount();
    }

    @JsonIgnore
    public void setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.getShujiiKensakuJoken().setTxtMaxCount(txtMaxCount);
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiSearchClear() {
        return this.getShujiiKensakuJoken().getBtnKyufuJissekiSearchClear();
    }

    @JsonIgnore
    public void setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.getShujiiKensakuJoken().setBtnKyufuJissekiSearchClear(btnKyufuJissekiSearchClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getShujiiKensakuJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void setBtnKensaku(Button btnKensaku) {
        this.getShujiiKensakuJoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getShujiiKensakuJoken().getCcdHokenshaList();
    }

    @JsonIgnore
    public DataGrid<dgShujii_Row> getDgShujii() {
        return this.getShujii().getDgShujii();
    }

    @JsonIgnore
    public void setDgShujii(DataGrid<dgShujii_Row> dgShujii) {
        this.getShujii().setDgShujii(dgShujii);
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCode() {
        return this.getShinseiJoho().getTxtIryoKikanCode();
    }

    @JsonIgnore
    public void setTxtIryoKikanCode(TextBoxCode txtIryoKikanCode) {
        this.getShinseiJoho().setTxtIryoKikanCode(txtIryoKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanName() {
        return this.getShinseiJoho().getTxtIryoKikanName();
    }

    @JsonIgnore
    public void setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.getShinseiJoho().setTxtIryoKikanName(txtIryoKikanName);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCode() {
        return this.getShinseiJoho().getTxtShujiiCode();
    }

    @JsonIgnore
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.getShinseiJoho().setTxtShujiiCode(txtShujiiCode);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getShinseiJoho().getTxtShujiiName();
    }

    @JsonIgnore
    public void setTxtShujiiName(TextBox txtShujiiName) {
        this.getShinseiJoho().setTxtShujiiName(txtShujiiName);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIin_Row> getDgShinsakaiIin() {
        return this.getShinseiJoho().getDgShinsakaiIin();
    }

    @JsonIgnore
    public void setDgShinsakaiIin(DataGrid<dgShinsakaiIin_Row> dgShinsakaiIin) {
        this.getShinseiJoho().setDgShinsakaiIin(dgShinsakaiIin);
    }

    // </editor-fold>
}
