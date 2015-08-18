package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaWariateInput.NinteiChosaWariateInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaWariateInput.NinteiChosaWariateInput.INinteiChosaWariateInputDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaWariateInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaWariateInputDiv extends Panel implements INinteiChosaWariateInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("WariateJokyo")
    private WariateJokyoDiv WariateJokyo;
    @JsonProperty("btnSearchTaishosha")
    private ButtonDialog btnSearchTaishosha;
    @JsonProperty("btnDisplayLatestInformation")
    private Button btnDisplayLatestInformation;
    @JsonProperty("TaishoshaShosai")
    private TaishoshaShosaiDiv TaishoshaShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("WariateJokyo")
    public WariateJokyoDiv getWariateJokyo() {
        return WariateJokyo;
    }

    @JsonProperty("WariateJokyo")
    public void setWariateJokyo(WariateJokyoDiv WariateJokyo) {
        this.WariateJokyo=WariateJokyo;
    }

    @JsonProperty("btnSearchTaishosha")
    public ButtonDialog getBtnSearchTaishosha() {
        return btnSearchTaishosha;
    }

    @JsonProperty("btnSearchTaishosha")
    public void setBtnSearchTaishosha(ButtonDialog btnSearchTaishosha) {
        this.btnSearchTaishosha=btnSearchTaishosha;
    }

    @JsonProperty("btnDisplayLatestInformation")
    public Button getBtnDisplayLatestInformation() {
        return btnDisplayLatestInformation;
    }

    @JsonProperty("btnDisplayLatestInformation")
    public void setBtnDisplayLatestInformation(Button btnDisplayLatestInformation) {
        this.btnDisplayLatestInformation=btnDisplayLatestInformation;
    }

    @JsonProperty("TaishoshaShosai")
    public TaishoshaShosaiDiv getTaishoshaShosai() {
        return TaishoshaShosai;
    }

    @JsonProperty("TaishoshaShosai")
    public void setTaishoshaShosai(TaishoshaShosaiDiv TaishoshaShosai) {
        this.TaishoshaShosai=TaishoshaShosai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtNinteiChosainCode() {
        return this.getWariateJokyo().getTxtNinteiChosainCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainCode(TextBoxCode txtNinteiChosainCode) {
        this.getWariateJokyo().setTxtNinteiChosainCode(txtNinteiChosainCode);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getWariateJokyo().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getWariateJokyo().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public TextBoxCode getTxtNinteiChosaItakusakiCode() {
        return this.getWariateJokyo().getTxtNinteiChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiCode(TextBoxCode txtNinteiChosaItakusakiCode) {
        this.getWariateJokyo().setTxtNinteiChosaItakusakiCode(txtNinteiChosaItakusakiCode);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiName() {
        return this.getWariateJokyo().getTxtNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.getWariateJokyo().setTxtNinteiChosaItakusakiName(txtNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaDate() {
        return this.getWariateJokyo().getTxtNinteiChosaDate();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaDate(TextBoxFlexibleDate txtNinteiChosaDate) {
        this.getWariateJokyo().setTxtNinteiChosaDate(txtNinteiChosaDate);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaTime() {
        return this.getWariateJokyo().getTxtNinteiChosaTime();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaTime(TextBox txtNinteiChosaTime) {
        this.getWariateJokyo().setTxtNinteiChosaTime(txtNinteiChosaTime);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaTimeFrame() {
        return this.getWariateJokyo().getTxtNinteiChosaTimeFrame();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaTimeFrame(TextBox txtNinteiChosaTimeFrame) {
        this.getWariateJokyo().setTxtNinteiChosaTimeFrame(txtNinteiChosaTimeFrame);
    }

    @JsonIgnore
    public RadioButton getRadYoyakuKahi() {
        return this.getWariateJokyo().getRadYoyakuKahi();
    }

    @JsonIgnore
    public void  setRadYoyakuKahi(RadioButton radYoyakuKahi) {
        this.getWariateJokyo().setRadYoyakuKahi(radYoyakuKahi);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaBiko() {
        return this.getWariateJokyo().getTxtNinteiChosaBiko();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaBiko(TextBox txtNinteiChosaBiko) {
        this.getWariateJokyo().setTxtNinteiChosaBiko(txtNinteiChosaBiko);
    }

    @JsonIgnore
    public RadioButton getRadYoyakuJokyo() {
        return this.getWariateJokyo().getRadYoyakuJokyo();
    }

    @JsonIgnore
    public void  setRadYoyakuJokyo(RadioButton radYoyakuJokyo) {
        this.getWariateJokyo().setRadYoyakuJokyo(radYoyakuJokyo);
    }

    @JsonIgnore
    public TextBox getTxtHihoBangoNumber() {
        return this.getTaishoshaShosai().getTxtHihoBangoNumber();
    }

    @JsonIgnore
    public void  setTxtHihoBangoNumber(TextBox txtHihoBangoNumber) {
        this.getTaishoshaShosai().setTxtHihoBangoNumber(txtHihoBangoNumber);
    }

    @JsonIgnore
    public TextBox getTxtHihoBangoGosu() {
        return this.getTaishoshaShosai().getTxtHihoBangoGosu();
    }

    @JsonIgnore
    public void  setTxtHihoBangoGosu(TextBox txtHihoBangoGosu) {
        this.getTaishoshaShosai().setTxtHihoBangoGosu(txtHihoBangoGosu);
    }

    @JsonIgnore
    public TextBox getTxtHokenshaName() {
        return this.getTaishoshaShosai().getTxtHokenshaName();
    }

    @JsonIgnore
    public void  setTxtHokenshaName(TextBox txtHokenshaName) {
        this.getTaishoshaShosai().setTxtHokenshaName(txtHokenshaName);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiShinseiDate() {
        return this.getTaishoshaShosai().getTxtNinteiShinseiDate();
    }

    @JsonIgnore
    public void  setTxtNinteiShinseiDate(TextBoxFlexibleDate txtNinteiShinseiDate) {
        this.getTaishoshaShosai().setTxtNinteiShinseiDate(txtNinteiShinseiDate);
    }

    @JsonIgnore
    public TextBox getTxtNinteiShinseiKubun() {
        return this.getTaishoshaShosai().getTxtNinteiShinseiKubun();
    }

    @JsonIgnore
    public void  setTxtNinteiShinseiKubun(TextBox txtNinteiShinseiKubun) {
        this.getTaishoshaShosai().setTxtNinteiShinseiKubun(txtNinteiShinseiKubun);
    }

    @JsonIgnore
    public TextBox getTxtTaishoshaName() {
        return this.getTaishoshaShosai().getTxtTaishoshaName();
    }

    @JsonIgnore
    public void  setTxtTaishoshaName(TextBox txtTaishoshaName) {
        this.getTaishoshaShosai().setTxtTaishoshaName(txtTaishoshaName);
    }

    @JsonIgnore
    public TextBox getTxtTaishoshaNameKana() {
        return this.getTaishoshaShosai().getTxtTaishoshaNameKana();
    }

    @JsonIgnore
    public void  setTxtTaishoshaNameKana(TextBox txtTaishoshaNameKana) {
        this.getTaishoshaShosai().setTxtTaishoshaNameKana(txtTaishoshaNameKana);
    }

    @JsonIgnore
    public TextBox getTxtBasho() {
        return this.getTaishoshaShosai().getTxtBasho();
    }

    @JsonIgnore
    public void  setTxtBasho(TextBox txtBasho) {
        this.getTaishoshaShosai().setTxtBasho(txtBasho);
    }

    @JsonIgnore
    public TextBox getTxtChushajo() {
        return this.getTaishoshaShosai().getTxtChushajo();
    }

    @JsonIgnore
    public void  setTxtChushajo(TextBox txtChushajo) {
        this.getTaishoshaShosai().setTxtChushajo(txtChushajo);
    }

    @JsonIgnore
    public TextBox getTxtTachiainin1() {
        return this.getTaishoshaShosai().getTxtTachiainin1();
    }

    @JsonIgnore
    public void  setTxtTachiainin1(TextBox txtTachiainin1) {
        this.getTaishoshaShosai().setTxtTachiainin1(txtTachiainin1);
    }

    @JsonIgnore
    public TextBox getTxtRenrakusaki1() {
        return this.getTaishoshaShosai().getTxtRenrakusaki1();
    }

    @JsonIgnore
    public void  setTxtRenrakusaki1(TextBox txtRenrakusaki1) {
        this.getTaishoshaShosai().setTxtRenrakusaki1(txtRenrakusaki1);
    }

    @JsonIgnore
    public TextBox getTxtTachiainin2() {
        return this.getTaishoshaShosai().getTxtTachiainin2();
    }

    @JsonIgnore
    public void  setTxtTachiainin2(TextBox txtTachiainin2) {
        this.getTaishoshaShosai().setTxtTachiainin2(txtTachiainin2);
    }

    @JsonIgnore
    public TextBox getTxtRenrakusaki2() {
        return this.getTaishoshaShosai().getTxtRenrakusaki2();
    }

    @JsonIgnore
    public void  setTxtRenrakusaki2(TextBox txtRenrakusaki2) {
        this.getTaishoshaShosai().setTxtRenrakusaki2(txtRenrakusaki2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTaishoshaShosaiMemo() {
        return this.getTaishoshaShosai().getTxtTaishoshaShosaiMemo();
    }

    @JsonIgnore
    public void  setTxtTaishoshaShosaiMemo(TextBoxMultiLine txtTaishoshaShosaiMemo) {
        this.getTaishoshaShosai().setTxtTaishoshaShosaiMemo(txtTaishoshaShosaiMemo);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getTaishoshaShosai().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getTaishoshaShosai().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getTaishoshaShosai().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getTaishoshaShosai().setBtnClear(btnClear);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
