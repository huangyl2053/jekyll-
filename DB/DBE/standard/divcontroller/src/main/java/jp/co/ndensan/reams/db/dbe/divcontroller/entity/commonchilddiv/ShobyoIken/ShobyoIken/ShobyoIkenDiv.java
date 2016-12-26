package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * ShobyoIken のクラスファイル
 *
 * @reamsid_L DBE-3000-130 zhengshukai
 */
public class ShobyoIkenDiv extends Panel implements IShobyoIkenDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShindanName")
    private ShindanNameDiv ShindanName;
    @JsonProperty("ShojoAnteisei")
    private ShojoAnteiseiDiv ShojoAnteisei;
    @JsonProperty("SeikatsuKinoGenin")
    private SeikatsuKinoGeninDiv SeikatsuKinoGenin;
    @JsonProperty("btnCansel")
    private Button btnCansel;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("Name1")
    private RString Name1;
    @JsonProperty("YMD1")
    private RString YMD1;
    @JsonProperty("Name2")
    private RString Name2;
    @JsonProperty("YMD2")
    private RString YMD2;
    @JsonProperty("Name3")
    private RString Name3;
    @JsonProperty("YMD3")
    private RString YMD3;
    @JsonProperty("Naiyo")
    private RString Naiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShindanName
     * @return ShindanName
     */
    @JsonProperty("ShindanName")
    public ShindanNameDiv getShindanName() {
        return ShindanName;
    }

    /*
     * setShindanName
     * @param ShindanName ShindanName
     */
    @JsonProperty("ShindanName")
    public void setShindanName(ShindanNameDiv ShindanName) {
        this.ShindanName = ShindanName;
    }

    /*
     * getShojoAnteisei
     * @return ShojoAnteisei
     */
    @JsonProperty("ShojoAnteisei")
    public ShojoAnteiseiDiv getShojoAnteisei() {
        return ShojoAnteisei;
    }

    /*
     * setShojoAnteisei
     * @param ShojoAnteisei ShojoAnteisei
     */
    @JsonProperty("ShojoAnteisei")
    public void setShojoAnteisei(ShojoAnteiseiDiv ShojoAnteisei) {
        this.ShojoAnteisei = ShojoAnteisei;
    }

    /*
     * getSeikatsuKinoGenin
     * @return SeikatsuKinoGenin
     */
    @JsonProperty("SeikatsuKinoGenin")
    public SeikatsuKinoGeninDiv getSeikatsuKinoGenin() {
        return SeikatsuKinoGenin;
    }

    /*
     * setSeikatsuKinoGenin
     * @param SeikatsuKinoGenin SeikatsuKinoGenin
     */
    @JsonProperty("SeikatsuKinoGenin")
    public void setSeikatsuKinoGenin(SeikatsuKinoGeninDiv SeikatsuKinoGenin) {
        this.SeikatsuKinoGenin = SeikatsuKinoGenin;
    }

    /*
     * getbtnCansel
     * @return btnCansel
     */
    @JsonProperty("btnCansel")
    public Button getBtnCansel() {
        return btnCansel;
    }

    /*
     * setbtnCansel
     * @param btnCansel btnCansel
     */
    @JsonProperty("btnCansel")
    public void setBtnCansel(Button btnCansel) {
        this.btnCansel = btnCansel;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getName1
     * @return Name1
     */
    @JsonProperty("Name1")
    public RString getName1() {
        return Name1;
    }

    /*
     * setName1
     * @param Name1 Name1
     */
    @JsonProperty("Name1")
    public void setName1(RString Name1) {
        this.Name1 = Name1;
    }

    /*
     * getYMD1
     * @return YMD1
     */
    @JsonProperty("YMD1")
    public RString getYMD1() {
        return YMD1;
    }

    /*
     * setYMD1
     * @param YMD1 YMD1
     */
    @JsonProperty("YMD1")
    public void setYMD1(RString YMD1) {
        this.YMD1 = YMD1;
    }

    /*
     * getName2
     * @return Name2
     */
    @JsonProperty("Name2")
    public RString getName2() {
        return Name2;
    }

    /*
     * setName2
     * @param Name2 Name2
     */
    @JsonProperty("Name2")
    public void setName2(RString Name2) {
        this.Name2 = Name2;
    }

    /*
     * getYMD2
     * @return YMD2
     */
    @JsonProperty("YMD2")
    public RString getYMD2() {
        return YMD2;
    }

    /*
     * setYMD2
     * @param YMD2 YMD2
     */
    @JsonProperty("YMD2")
    public void setYMD2(RString YMD2) {
        this.YMD2 = YMD2;
    }

    /*
     * getName3
     * @return Name3
     */
    @JsonProperty("Name3")
    public RString getName3() {
        return Name3;
    }

    /*
     * setName3
     * @param Name3 Name3
     */
    @JsonProperty("Name3")
    public void setName3(RString Name3) {
        this.Name3 = Name3;
    }

    /*
     * getYMD3
     * @return YMD3
     */
    @JsonProperty("YMD3")
    public RString getYMD3() {
        return YMD3;
    }

    /*
     * setYMD3
     * @param YMD3 YMD3
     */
    @JsonProperty("YMD3")
    public void setYMD3(RString YMD3) {
        this.YMD3 = YMD3;
    }

    /*
     * getNaiyo
     * @return Naiyo
     */
    @JsonProperty("Naiyo")
    public RString getNaiyo() {
        return Naiyo;
    }

    /*
     * setNaiyo
     * @param Naiyo Naiyo
     */
    @JsonProperty("Naiyo")
    public void setNaiyo(RString Naiyo) {
        this.Naiyo = Naiyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShindanName1() {
        return this.getShindanName().getTxtShindanName1();
    }

    @JsonIgnore
    public void  setTxtShindanName1(TextBox txtShindanName1) {
        this.getShindanName().setTxtShindanName1(txtShindanName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShindanYMD1() {
        return this.getShindanName().getTxtShindanYMD1();
    }

    @JsonIgnore
    public void  setTxtShindanYMD1(TextBoxDate txtShindanYMD1) {
        this.getShindanName().setTxtShindanYMD1(txtShindanYMD1);
    }

    @JsonIgnore
    public TextBox getTxtShindanName2() {
        return this.getShindanName().getTxtShindanName2();
    }

    @JsonIgnore
    public void  setTxtShindanName2(TextBox txtShindanName2) {
        this.getShindanName().setTxtShindanName2(txtShindanName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShindanYMD2() {
        return this.getShindanName().getTxtShindanYMD2();
    }

    @JsonIgnore
    public void  setTxtShindanYMD2(TextBoxDate txtShindanYMD2) {
        this.getShindanName().setTxtShindanYMD2(txtShindanYMD2);
    }

    @JsonIgnore
    public TextBox getTxtShindanName() {
        return this.getShindanName().getTxtShindanName();
    }

    @JsonIgnore
    public void  setTxtShindanName(TextBox txtShindanName) {
        this.getShindanName().setTxtShindanName(txtShindanName);
    }

    @JsonIgnore
    public TextBoxDate getTxtShindanYMD3() {
        return this.getShindanName().getTxtShindanYMD3();
    }

    @JsonIgnore
    public void  setTxtShindanYMD3(TextBoxDate txtShindanYMD3) {
        this.getShindanName().setTxtShindanYMD3(txtShindanYMD3);
    }

    @JsonIgnore
    public geninShikkanPanelDiv getGeninShikkanPanel() {
        return this.getShindanName().getGeninShikkanPanel();
    }

    @JsonIgnore
    public void  setGeninShikkanPanel(geninShikkanPanelDiv geninShikkanPanel) {
        this.getShindanName().setGeninShikkanPanel(geninShikkanPanel);
    }

    @JsonIgnore
    public Button getBtnAdd() {
        return this.getShindanName().getGeninShikkanPanel().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getShindanName().getGeninShikkanPanel().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgGenyin_Row> getDgGenyin() {
        return this.getShindanName().getGeninShikkanPanel().getDgGenyin();
    }

    @JsonIgnore
    public void  setDgGenyin(DataGrid<dgGenyin_Row> dgGenyin) {
        this.getShindanName().getGeninShikkanPanel().setDgGenyin(dgGenyin);
    }

    @JsonIgnore
    public geninShikkanShosaiDiv getGeninShikkanShosai() {
        return this.getShindanName().getGeninShikkanPanel().getGeninShikkanShosai();
    }

    @JsonIgnore
    public void  setGeninShikkanShosai(geninShikkanShosaiDiv geninShikkanShosai) {
        this.getShindanName().getGeninShikkanPanel().setGeninShikkanShosai(geninShikkanShosai);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdCodeInputGeninShikkan() {
        return this.getShindanName().getGeninShikkanPanel().getGeninShikkanShosai().getCcdCodeInputGeninShikkan();
    }

    @JsonIgnore
    public RadioButton getRadIsShutaruGeninShikkan() {
        return this.getShindanName().getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan();
    }

    @JsonIgnore
    public void  setRadIsShutaruGeninShikkan(RadioButton radIsShutaruGeninShikkan) {
        this.getShindanName().getGeninShikkanPanel().getGeninShikkanShosai().setRadIsShutaruGeninShikkan(radIsShutaruGeninShikkan);
    }

    @JsonIgnore
    public Button getBtnNo() {
        return this.getShindanName().getGeninShikkanPanel().getGeninShikkanShosai().getBtnNo();
    }

    @JsonIgnore
    public void  setBtnNo(Button btnNo) {
        this.getShindanName().getGeninShikkanPanel().getGeninShikkanShosai().setBtnNo(btnNo);
    }

    @JsonIgnore
    public Button getBtnOK() {
        return this.getShindanName().getGeninShikkanPanel().getGeninShikkanShosai().getBtnOK();
    }

    @JsonIgnore
    public void  setBtnOK(Button btnOK) {
        this.getShindanName().getGeninShikkanPanel().getGeninShikkanShosai().setBtnOK(btnOK);
    }

    @JsonIgnore
    public RadioButton getRadShojoAnteisei() {
        return this.getShojoAnteisei().getRadShojoAnteisei();
    }

    @JsonIgnore
    public void  setRadShojoAnteisei(RadioButton radShojoAnteisei) {
        this.getShojoAnteisei().setRadShojoAnteisei(radShojoAnteisei);
    }

    @JsonIgnore
    public TextBox getTxtFuanteiShosaiJokyo() {
        return this.getShojoAnteisei().getTxtFuanteiShosaiJokyo();
    }

    @JsonIgnore
    public void  setTxtFuanteiShosaiJokyo(TextBox txtFuanteiShosaiJokyo) {
        this.getShojoAnteisei().setTxtFuanteiShosaiJokyo(txtFuanteiShosaiJokyo);
    }

    @JsonIgnore
    public Label getLblChiryoNaiyo() {
        return this.getSeikatsuKinoGenin().getLblChiryoNaiyo();
    }

    @JsonIgnore
    public void  setLblChiryoNaiyo(Label lblChiryoNaiyo) {
        this.getSeikatsuKinoGenin().setLblChiryoNaiyo(lblChiryoNaiyo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNaiyo() {
        return this.getSeikatsuKinoGenin().getTxtNaiyo();
    }

    @JsonIgnore
    public void  setTxtNaiyo(TextBoxMultiLine txtNaiyo) {
        this.getSeikatsuKinoGenin().setTxtNaiyo(txtNaiyo);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private ShobyoIkenHandler getHandler(ShobyoIkenDiv div) {
        return new ShobyoIkenHandler(div);
    }

    /**
     * 傷病の意見入力に初期化を設定します。
     */
    @Override
    public void initialize() {
        getHandler(this).initialize();
    }

}
