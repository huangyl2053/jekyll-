package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * IkkatsuGenmenBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkkatsuGenmenBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriTaishoNendo")
    private ShoriTaishoNendoDiv ShoriTaishoNendo;
    @JsonProperty("ShoriJotai")
    private ShoriJotaiDiv ShoriJotai;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("GenmenJoho")
    private GenmenJohoDiv GenmenJoho;
    @JsonProperty("KetteiJoho")
    private KetteiJohoDiv KetteiJoho;
    @JsonProperty("ccdChikuShichosonSelect")
    private ChikuShichosonSelectDiv ccdChikuShichosonSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShoriTaishoNendo
     * @return ShoriTaishoNendo
     */
    @JsonProperty("ShoriTaishoNendo")
    public ShoriTaishoNendoDiv getShoriTaishoNendo() {
        return ShoriTaishoNendo;
    }

    /*
     * setShoriTaishoNendo
     * @param ShoriTaishoNendo ShoriTaishoNendo
     */
    @JsonProperty("ShoriTaishoNendo")
    public void setShoriTaishoNendo(ShoriTaishoNendoDiv ShoriTaishoNendo) {
        this.ShoriTaishoNendo = ShoriTaishoNendo;
    }

    /*
     * getShoriJotai
     * @return ShoriJotai
     */
    @JsonProperty("ShoriJotai")
    public ShoriJotaiDiv getShoriJotai() {
        return ShoriJotai;
    }

    /*
     * setShoriJotai
     * @param ShoriJotai ShoriJotai
     */
    @JsonProperty("ShoriJotai")
    public void setShoriJotai(ShoriJotaiDiv ShoriJotai) {
        this.ShoriJotai = ShoriJotai;
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
     * getGenmenJoho
     * @return GenmenJoho
     */
    @JsonProperty("GenmenJoho")
    public GenmenJohoDiv getGenmenJoho() {
        return GenmenJoho;
    }

    /*
     * setGenmenJoho
     * @param GenmenJoho GenmenJoho
     */
    @JsonProperty("GenmenJoho")
    public void setGenmenJoho(GenmenJohoDiv GenmenJoho) {
        this.GenmenJoho = GenmenJoho;
    }

    /*
     * getKetteiJoho
     * @return KetteiJoho
     */
    @JsonProperty("KetteiJoho")
    public KetteiJohoDiv getKetteiJoho() {
        return KetteiJoho;
    }

    /*
     * setKetteiJoho
     * @param KetteiJoho KetteiJoho
     */
    @JsonProperty("KetteiJoho")
    public void setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.KetteiJoho = KetteiJoho;
    }

    /*
     * getccdChikuShichosonSelect
     * @return ccdChikuShichosonSelect
     */
    @JsonProperty("ccdChikuShichosonSelect")
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return ccdChikuShichosonSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtChoteiNendo() {
        return this.getShoriTaishoNendo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void  setTxtChoteiNendo(TextBoxDate txtChoteiNendo) {
        this.getShoriTaishoNendo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtFukaNendo() {
        return this.getShoriTaishoNendo().getTxtFukaNendo();
    }

    @JsonIgnore
    public void  setTxtFukaNendo(TextBoxDate txtFukaNendo) {
        this.getShoriTaishoNendo().setTxtFukaNendo(txtFukaNendo);
    }

    @JsonIgnore
    public DataGrid<dgShoriJotai_Row> getDgShoriJotai() {
        return this.getShoriJotai().getDgShoriJotai();
    }

    @JsonIgnore
    public void  setDgShoriJotai(DataGrid<dgShoriJotai_Row> dgShoriJotai) {
        this.getShoriJotai().setDgShoriJotai(dgShoriJotai);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getGenmenJoho().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getGenmenJoho().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeiYMD() {
        return this.getGenmenJoho().getTxtUketsukeiYMD();
    }

    @JsonIgnore
    public void  setTxtUketsukeiYMD(TextBoxDate txtUketsukeiYMD) {
        this.getGenmenJoho().setTxtUketsukeiYMD(txtUketsukeiYMD);
    }

    @JsonIgnore
    public Button getBtnGemmenShurui() {
        return this.getGenmenJoho().getBtnGemmenShurui();
    }

    @JsonIgnore
    public void  setBtnGemmenShurui(Button btnGemmenShurui) {
        this.getGenmenJoho().setBtnGemmenShurui(btnGemmenShurui);
    }

    @JsonIgnore
    public TextBox getTxtGemmenShurui() {
        return this.getGenmenJoho().getTxtGemmenShurui();
    }

    @JsonIgnore
    public void  setTxtGemmenShurui(TextBox txtGemmenShurui) {
        this.getGenmenJoho().setTxtGemmenShurui(txtGemmenShurui);
    }

    @JsonIgnore
    public TextBoxNum getTxtGenmenRitsu() {
        return this.getGenmenJoho().getTxtGenmenRitsu();
    }

    @JsonIgnore
    public void  setTxtGenmenRitsu(TextBoxNum txtGenmenRitsu) {
        this.getGenmenJoho().setTxtGenmenRitsu(txtGenmenRitsu);
    }

    @JsonIgnore
    public Label getLblPercent() {
        return this.getGenmenJoho().getLblPercent();
    }

    @JsonIgnore
    public void  setLblPercent(Label lblPercent) {
        this.getGenmenJoho().setLblPercent(lblPercent);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getGenmenJoho().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getGenmenJoho().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getKetteiJoho().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getKetteiJoho().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKetteiRiyu() {
        return this.getKetteiJoho().getTxtKetteiRiyu();
    }

    @JsonIgnore
    public void  setTxtKetteiRiyu(TextBoxMultiLine txtKetteiRiyu) {
        this.getKetteiJoho().setTxtKetteiRiyu(txtKetteiRiyu);
    }

    // </editor-fold>
}
