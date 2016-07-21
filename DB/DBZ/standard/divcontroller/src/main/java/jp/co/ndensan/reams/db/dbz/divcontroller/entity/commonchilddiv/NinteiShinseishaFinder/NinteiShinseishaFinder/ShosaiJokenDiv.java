package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShosaiJoken のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class ShosaiJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("NinteiChosa")
    private NinteiChosaDiv NinteiChosa;
    @JsonProperty("ShujiiJoho")
    private ShujiiJohoDiv ShujiiJoho;
    @JsonProperty("IchijiHantei")
    private IchijiHanteiDiv IchijiHantei;
    @JsonProperty("IchiGoHantei")
    private IchiGoHanteiDiv IchiGoHantei;
    @JsonProperty("KaigoNinteiShinsakaiJoho")
    private KaigoNinteiShinsakaiJohoDiv KaigoNinteiShinsakaiJoho;
    @JsonProperty("ZenkaiJoho")
    private ZenkaiJohoDiv ZenkaiJoho;
    @JsonProperty("SonotaJoho")
    private SonotaJohoDiv SonotaJoho;
    @JsonProperty("KanryoJoho")
    private KanryoJohoDiv KanryoJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKihonJoho
     * @return KihonJoho
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    /*
     * setKihonJoho
     * @param KihonJoho KihonJoho
     */
    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho = KihonJoho;
    }

    /*
     * getNinteiChosa
     * @return NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public NinteiChosaDiv getNinteiChosa() {
        return NinteiChosa;
    }

    /*
     * setNinteiChosa
     * @param NinteiChosa NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.NinteiChosa = NinteiChosa;
    }

    /*
     * getShujiiJoho
     * @return ShujiiJoho
     */
    @JsonProperty("ShujiiJoho")
    public ShujiiJohoDiv getShujiiJoho() {
        return ShujiiJoho;
    }

    /*
     * setShujiiJoho
     * @param ShujiiJoho ShujiiJoho
     */
    @JsonProperty("ShujiiJoho")
    public void setShujiiJoho(ShujiiJohoDiv ShujiiJoho) {
        this.ShujiiJoho = ShujiiJoho;
    }

    /*
     * getIchijiHantei
     * @return IchijiHantei
     */
    @JsonProperty("IchijiHantei")
    public IchijiHanteiDiv getIchijiHantei() {
        return IchijiHantei;
    }

    /*
     * setIchijiHantei
     * @param IchijiHantei IchijiHantei
     */
    @JsonProperty("IchijiHantei")
    public void setIchijiHantei(IchijiHanteiDiv IchijiHantei) {
        this.IchijiHantei = IchijiHantei;
    }

    /*
     * getIchiGoHantei
     * @return IchiGoHantei
     */
    @JsonProperty("IchiGoHantei")
    public IchiGoHanteiDiv getIchiGoHantei() {
        return IchiGoHantei;
    }

    /*
     * setIchiGoHantei
     * @param IchiGoHantei IchiGoHantei
     */
    @JsonProperty("IchiGoHantei")
    public void setIchiGoHantei(IchiGoHanteiDiv IchiGoHantei) {
        this.IchiGoHantei = IchiGoHantei;
    }

    /*
     * getKaigoNinteiShinsakaiJoho
     * @return KaigoNinteiShinsakaiJoho
     */
    @JsonProperty("KaigoNinteiShinsakaiJoho")
    public KaigoNinteiShinsakaiJohoDiv getKaigoNinteiShinsakaiJoho() {
        return KaigoNinteiShinsakaiJoho;
    }

    /*
     * setKaigoNinteiShinsakaiJoho
     * @param KaigoNinteiShinsakaiJoho KaigoNinteiShinsakaiJoho
     */
    @JsonProperty("KaigoNinteiShinsakaiJoho")
    public void setKaigoNinteiShinsakaiJoho(KaigoNinteiShinsakaiJohoDiv KaigoNinteiShinsakaiJoho) {
        this.KaigoNinteiShinsakaiJoho = KaigoNinteiShinsakaiJoho;
    }

    /*
     * getZenkaiJoho
     * @return ZenkaiJoho
     */
    @JsonProperty("ZenkaiJoho")
    public ZenkaiJohoDiv getZenkaiJoho() {
        return ZenkaiJoho;
    }

    /*
     * setZenkaiJoho
     * @param ZenkaiJoho ZenkaiJoho
     */
    @JsonProperty("ZenkaiJoho")
    public void setZenkaiJoho(ZenkaiJohoDiv ZenkaiJoho) {
        this.ZenkaiJoho = ZenkaiJoho;
    }

    /*
     * getSonotaJoho
     * @return SonotaJoho
     */
    @JsonProperty("SonotaJoho")
    public SonotaJohoDiv getSonotaJoho() {
        return SonotaJoho;
    }

    /*
     * setSonotaJoho
     * @param SonotaJoho SonotaJoho
     */
    @JsonProperty("SonotaJoho")
    public void setSonotaJoho(SonotaJohoDiv SonotaJoho) {
        this.SonotaJoho = SonotaJoho;
    }

    /*
     * getKanryoJoho
     * @return KanryoJoho
     */
    @JsonProperty("KanryoJoho")
    public KanryoJohoDiv getKanryoJoho() {
        return KanryoJoho;
    }

    /*
     * setKanryoJoho
     * @param KanryoJoho KanryoJoho
     */
    @JsonProperty("KanryoJoho")
    public void setKanryoJoho(KanryoJohoDiv KanryoJoho) {
        this.KanryoJoho = KanryoJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlHihokenshaKubun() {
        return this.getKihonJoho().getDdlHihokenshaKubun();
    }

    @JsonIgnore
    public void  setDdlHihokenshaKubun(DropDownList ddlHihokenshaKubun) {
        this.getKihonJoho().setDdlHihokenshaKubun(ddlHihokenshaKubun);
    }

    @JsonIgnore
    public DropDownList getDdlHoreiShinseiji() {
        return this.getKihonJoho().getDdlHoreiShinseiji();
    }

    @JsonIgnore
    public void  setDdlHoreiShinseiji(DropDownList ddlHoreiShinseiji) {
        this.getKihonJoho().setDdlHoreiShinseiji(ddlHoreiShinseiji);
    }

    @JsonIgnore
    public DropDownList getDdlShoriKubun() {
        return this.getKihonJoho().getDdlShoriKubun();
    }

    @JsonIgnore
    public void  setDdlShoriKubun(DropDownList ddlShoriKubun) {
        this.getKihonJoho().setDdlShoriKubun(ddlShoriKubun);
    }

    @JsonIgnore
    public DropDownList getDdlKoroshoShikibetsuCode() {
        return this.getKihonJoho().getDdlKoroshoShikibetsuCode();
    }

    @JsonIgnore
    public void  setDdlKoroshoShikibetsuCode(DropDownList ddlKoroshoShikibetsuCode) {
        this.getKihonJoho().setDdlKoroshoShikibetsuCode(ddlKoroshoShikibetsuCode);
    }

    @JsonIgnore
    public Label getLblYubinNo() {
        return this.getKihonJoho().getLblYubinNo();
    }

    @JsonIgnore
    public void  setLblYubinNo(Label lblYubinNo) {
        this.getKihonJoho().setLblYubinNo(lblYubinNo);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getKihonJoho().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getKihonJoho().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public DropDownList getDdlChiku() {
        return this.getKihonJoho().getDdlChiku();
    }

    @JsonIgnore
    public void  setDdlChiku(DropDownList ddlChiku) {
        this.getKihonJoho().setDdlChiku(ddlChiku);
    }

    @JsonIgnore
    public RadioButton getRadShisetsuNyusho() {
        return this.getKihonJoho().getRadShisetsuNyusho();
    }

    @JsonIgnore
    public void  setRadShisetsuNyusho(RadioButton radShisetsuNyusho) {
        this.getKihonJoho().setRadShisetsuNyusho(radShisetsuNyusho);
    }

    @JsonIgnore
    public Label getLblNinteiChosaIinItakuSaki() {
        return this.getNinteiChosa().getLblNinteiChosaIinItakuSaki();
    }

    @JsonIgnore
    public void  setLblNinteiChosaIinItakuSaki(Label lblNinteiChosaIinItakuSaki) {
        this.getNinteiChosa().setLblNinteiChosaIinItakuSaki(lblNinteiChosaIinItakuSaki);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinteiChosaItakusakiGuide() {
        return this.getNinteiChosa().getBtnNinteiChosaItakusakiGuide();
    }

    @JsonIgnore
    public void  setBtnNinteiChosaItakusakiGuide(ButtonDialog btnNinteiChosaItakusakiGuide) {
        this.getNinteiChosa().setBtnNinteiChosaItakusakiGuide(btnNinteiChosaItakusakiGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiName() {
        return this.getNinteiChosa().getTxtNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.getNinteiChosa().setTxtNinteiChosaItakusakiName(txtNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public Label getLblNinteiChosaInShimei() {
        return this.getNinteiChosa().getLblNinteiChosaInShimei();
    }

    @JsonIgnore
    public void  setLblNinteiChosaInShimei(Label lblNinteiChosaInShimei) {
        this.getNinteiChosa().setLblNinteiChosaInShimei(lblNinteiChosaInShimei);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinteiChosainGuide() {
        return this.getNinteiChosa().getBtnNinteiChosainGuide();
    }

    @JsonIgnore
    public void  setBtnNinteiChosainGuide(ButtonDialog btnNinteiChosainGuide) {
        this.getNinteiChosa().setBtnNinteiChosainGuide(btnNinteiChosainGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getNinteiChosa().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getNinteiChosa().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public DropDownList getDdlChosaJisshiBasho() {
        return this.getNinteiChosa().getDdlChosaJisshiBasho();
    }

    @JsonIgnore
    public void  setDdlChosaJisshiBasho(DropDownList ddlChosaJisshiBasho) {
        this.getNinteiChosa().setDdlChosaJisshiBasho(ddlChosaJisshiBasho);
    }

    @JsonIgnore
    public DropDownList getDdlChosaKubun() {
        return this.getNinteiChosa().getDdlChosaKubun();
    }

    @JsonIgnore
    public void  setDdlChosaKubun(DropDownList ddlChosaKubun) {
        this.getNinteiChosa().setDdlChosaKubun(ddlChosaKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtChosaJisshiDateFrom() {
        return this.getNinteiChosa().getTxtChosaJisshiDateFrom();
    }

    @JsonIgnore
    public void  setTxtChosaJisshiDateFrom(TextBoxFlexibleDate txtChosaJisshiDateFrom) {
        this.getNinteiChosa().setTxtChosaJisshiDateFrom(txtChosaJisshiDateFrom);
    }

    @JsonIgnore
    public Label getLblChosaJisshiDate() {
        return this.getNinteiChosa().getLblChosaJisshiDate();
    }

    @JsonIgnore
    public void  setLblChosaJisshiDate(Label lblChosaJisshiDate) {
        this.getNinteiChosa().setLblChosaJisshiDate(lblChosaJisshiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtChosaJisshiDateTo() {
        return this.getNinteiChosa().getTxtChosaJisshiDateTo();
    }

    @JsonIgnore
    public void  setTxtChosaJisshiDateTo(TextBoxFlexibleDate txtChosaJisshiDateTo) {
        this.getNinteiChosa().setTxtChosaJisshiDateTo(txtChosaJisshiDateTo);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaNetakirido() {
        return this.getNinteiChosa().getDdlNinteiChosaNetakirido();
    }

    @JsonIgnore
    public void  setDdlNinteiChosaNetakirido(DropDownList ddlNinteiChosaNetakirido) {
        this.getNinteiChosa().setDdlNinteiChosaNetakirido(ddlNinteiChosaNetakirido);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaNinchido() {
        return this.getNinteiChosa().getDdlNinteiChosaNinchido();
    }

    @JsonIgnore
    public void  setDdlNinteiChosaNinchido(DropDownList ddlNinteiChosaNinchido) {
        this.getNinteiChosa().setDdlNinteiChosaNinchido(ddlNinteiChosaNinchido);
    }

    @JsonIgnore
    public Label getLblShujiiIryokikan() {
        return this.getShujiiJoho().getLblShujiiIryokikan();
    }

    @JsonIgnore
    public void  setLblShujiiIryokikan(Label lblShujiiIryokikan) {
        this.getShujiiJoho().setLblShujiiIryokikan(lblShujiiIryokikan);
    }

    @JsonIgnore
    public ButtonDialog getBtnShujiiIryokikanGuide() {
        return this.getShujiiJoho().getBtnShujiiIryokikanGuide();
    }

    @JsonIgnore
    public void  setBtnShujiiIryokikanGuide(ButtonDialog btnShujiiIryokikanGuide) {
        this.getShujiiJoho().setBtnShujiiIryokikanGuide(btnShujiiIryokikanGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiIryokikanName() {
        return this.getShujiiJoho().getTxtShujiiIryokikanName();
    }

    @JsonIgnore
    public void  setTxtShujiiIryokikanName(TextBox txtShujiiIryokikanName) {
        this.getShujiiJoho().setTxtShujiiIryokikanName(txtShujiiIryokikanName);
    }

    @JsonIgnore
    public Label getLblShujiiName() {
        return this.getShujiiJoho().getLblShujiiName();
    }

    @JsonIgnore
    public void  setLblShujiiName(Label lblShujiiName) {
        this.getShujiiJoho().setLblShujiiName(lblShujiiName);
    }

    @JsonIgnore
    public ButtonDialog getBtnShujiiGuide() {
        return this.getShujiiJoho().getBtnShujiiGuide();
    }

    @JsonIgnore
    public void  setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.getShujiiJoho().setBtnShujiiGuide(btnShujiiGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getShujiiJoho().getTxtShujiiName();
    }

    @JsonIgnore
    public void  setTxtShujiiName(TextBox txtShujiiName) {
        this.getShujiiJoho().setTxtShujiiName(txtShujiiName);
    }

    @JsonIgnore
    public DropDownList getDdlShujiIkubun() {
        return this.getShujiiJoho().getDdlShujiIkubun();
    }

    @JsonIgnore
    public void  setDdlShujiIkubun(DropDownList ddlShujiIkubun) {
        this.getShujiiJoho().setDdlShujiIkubun(ddlShujiIkubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIkenshoKinyuDateFrom() {
        return this.getShujiiJoho().getTxtIkenshoKinyuDateFrom();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyuDateFrom(TextBoxFlexibleDate txtIkenshoKinyuDateFrom) {
        this.getShujiiJoho().setTxtIkenshoKinyuDateFrom(txtIkenshoKinyuDateFrom);
    }

    @JsonIgnore
    public Label getLblIkenshoKinyuDateFrom() {
        return this.getShujiiJoho().getLblIkenshoKinyuDateFrom();
    }

    @JsonIgnore
    public void  setLblIkenshoKinyuDateFrom(Label lblIkenshoKinyuDateFrom) {
        this.getShujiiJoho().setLblIkenshoKinyuDateFrom(lblIkenshoKinyuDateFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIkenshoKinyuDateTo() {
        return this.getShujiiJoho().getTxtIkenshoKinyuDateTo();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyuDateTo(TextBoxFlexibleDate txtIkenshoKinyuDateTo) {
        this.getShujiiJoho().setTxtIkenshoKinyuDateTo(txtIkenshoKinyuDateTo);
    }

    @JsonIgnore
    public DropDownList getDdlShujiJohoNetakirido() {
        return this.getShujiiJoho().getDdlShujiJohoNetakirido();
    }

    @JsonIgnore
    public void  setDdlShujiJohoNetakirido(DropDownList ddlShujiJohoNetakirido) {
        this.getShujiiJoho().setDdlShujiJohoNetakirido(ddlShujiJohoNetakirido);
    }

    @JsonIgnore
    public DropDownList getDdlShujiJohoNinchido() {
        return this.getShujiiJoho().getDdlShujiJohoNinchido();
    }

    @JsonIgnore
    public void  setDdlShujiJohoNinchido(DropDownList ddlShujiJohoNinchido) {
        this.getShujiiJoho().setDdlShujiJohoNinchido(ddlShujiJohoNinchido);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIchijiHanteiDateFrom() {
        return this.getIchijiHantei().getTxtIchijiHanteiDateFrom();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiDateFrom(TextBoxFlexibleDate txtIchijiHanteiDateFrom) {
        this.getIchijiHantei().setTxtIchijiHanteiDateFrom(txtIchijiHanteiDateFrom);
    }

    @JsonIgnore
    public Label getLblIchijiHanteiDate() {
        return this.getIchijiHantei().getLblIchijiHanteiDate();
    }

    @JsonIgnore
    public void  setLblIchijiHanteiDate(Label lblIchijiHanteiDate) {
        this.getIchijiHantei().setLblIchijiHanteiDate(lblIchijiHanteiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIchijiHanteiDateTo() {
        return this.getIchijiHantei().getTxtIchijiHanteiDateTo();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiDateTo(TextBoxFlexibleDate txtIchijiHanteiDateTo) {
        this.getIchijiHantei().setTxtIchijiHanteiDateTo(txtIchijiHanteiDateTo);
    }

    @JsonIgnore
    public DropDownList getDdlIchijiHanteiKekka() {
        return this.getIchijiHantei().getDdlIchijiHanteiKekka();
    }

    @JsonIgnore
    public void  setDdlIchijiHanteiKekka(DropDownList ddlIchijiHanteiKekka) {
        this.getIchijiHantei().setDdlIchijiHanteiKekka(ddlIchijiHanteiKekka);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIchiGoHanteiDateFrom() {
        return this.getIchiGoHantei().getTxtIchiGoHanteiDateFrom();
    }

    @JsonIgnore
    public void  setTxtIchiGoHanteiDateFrom(TextBoxFlexibleDate txtIchiGoHanteiDateFrom) {
        this.getIchiGoHantei().setTxtIchiGoHanteiDateFrom(txtIchiGoHanteiDateFrom);
    }

    @JsonIgnore
    public Label getLblIchiGoHanteiDate() {
        return this.getIchiGoHantei().getLblIchiGoHanteiDate();
    }

    @JsonIgnore
    public void  setLblIchiGoHanteiDate(Label lblIchiGoHanteiDate) {
        this.getIchiGoHantei().setLblIchiGoHanteiDate(lblIchiGoHanteiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIchiGoHanteiDateTo() {
        return this.getIchiGoHantei().getTxtIchiGoHanteiDateTo();
    }

    @JsonIgnore
    public void  setTxtIchiGoHanteiDateTo(TextBoxFlexibleDate txtIchiGoHanteiDateTo) {
        this.getIchiGoHantei().setTxtIchiGoHanteiDateTo(txtIchiGoHanteiDateTo);
    }

    @JsonIgnore
    public DropDownList getDdlIchiGohanteiKekka() {
        return this.getIchiGoHantei().getDdlIchiGohanteiKekka();
    }

    @JsonIgnore
    public void  setDdlIchiGohanteiKekka(DropDownList ddlIchiGohanteiKekka) {
        this.getIchiGoHantei().setDdlIchiGohanteiKekka(ddlIchiGohanteiKekka);
    }

    @JsonIgnore
    public DropDownList getDdlNijiHanteiKekka() {
        return this.getKaigoNinteiShinsakaiJoho().getDdlNijiHanteiKekka();
    }

    @JsonIgnore
    public void  setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.getKaigoNinteiShinsakaiJoho().setDdlNijiHanteiKekka(ddlNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBox getTxtNinteiYukoKikan() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoKikan();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikan(TextBox txtNinteiYukoKikan) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoKikan(txtNinteiYukoKikan);
    }

    @JsonIgnore
    public TextBox getTxtCheckDay() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtCheckDay();
    }

    @JsonIgnore
    public void  setTxtCheckDay(TextBox txtCheckDay) {
        this.getKaigoNinteiShinsakaiJoho().setTxtCheckDay(txtCheckDay);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoKaishiDateFrom() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoKaishiDateFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKaishiDateFrom(TextBoxFlexibleDate txtNinteiYukoKaishiDateFrom) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoKaishiDateFrom(txtNinteiYukoKaishiDateFrom);
    }

    @JsonIgnore
    public Label getLblNinteiYukoKaishiDate() {
        return this.getKaigoNinteiShinsakaiJoho().getLblNinteiYukoKaishiDate();
    }

    @JsonIgnore
    public void  setLblNinteiYukoKaishiDate(Label lblNinteiYukoKaishiDate) {
        this.getKaigoNinteiShinsakaiJoho().setLblNinteiYukoKaishiDate(lblNinteiYukoKaishiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoKaishiDateTo() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoKaishiDateTo();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKaishiDateTo(TextBoxFlexibleDate txtNinteiYukoKaishiDateTo) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoKaishiDateTo(txtNinteiYukoKaishiDateTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryoDateFrom() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoShuryoDateFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryoDateFrom(TextBoxFlexibleDate txtNinteiYukoShuryoDateFrom) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoShuryoDateFrom(txtNinteiYukoShuryoDateFrom);
    }

    @JsonIgnore
    public Label getLblNinteiYukoShuryoDate() {
        return this.getKaigoNinteiShinsakaiJoho().getLblNinteiYukoShuryoDate();
    }

    @JsonIgnore
    public void  setLblNinteiYukoShuryoDate(Label lblNinteiYukoShuryoDate) {
        this.getKaigoNinteiShinsakaiJoho().setLblNinteiYukoShuryoDate(lblNinteiYukoShuryoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryoDate() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoShuryoDate();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryoDate(TextBoxFlexibleDate txtNinteiYukoShuryoDate) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoShuryoDate(txtNinteiYukoShuryoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNijiHanteiDateFrom() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNijiHanteiDateFrom();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiDateFrom(TextBoxFlexibleDate txtNijiHanteiDateFrom) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNijiHanteiDateFrom(txtNijiHanteiDateFrom);
    }

    @JsonIgnore
    public Label getLblNijiHanteiDate() {
        return this.getKaigoNinteiShinsakaiJoho().getLblNijiHanteiDate();
    }

    @JsonIgnore
    public void  setLblNijiHanteiDate(Label lblNijiHanteiDate) {
        this.getKaigoNinteiShinsakaiJoho().setLblNijiHanteiDate(lblNijiHanteiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNijiHnateiDateTo() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNijiHnateiDateTo();
    }

    @JsonIgnore
    public void  setTxtNijiHnateiDateTo(TextBoxFlexibleDate txtNijiHnateiDateTo) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNijiHnateiDateTo(txtNijiHnateiDateTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDateFrom() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtKaisaiDateFrom();
    }

    @JsonIgnore
    public void  setTxtKaisaiDateFrom(TextBoxFlexibleDate txtKaisaiDateFrom) {
        this.getKaigoNinteiShinsakaiJoho().setTxtKaisaiDateFrom(txtKaisaiDateFrom);
    }

    @JsonIgnore
    public Label getLblKaisaiDate() {
        return this.getKaigoNinteiShinsakaiJoho().getLblKaisaiDate();
    }

    @JsonIgnore
    public void  setLblKaisaiDate(Label lblKaisaiDate) {
        this.getKaigoNinteiShinsakaiJoho().setLblKaisaiDate(lblKaisaiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDateTo() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtKaisaiDateTo();
    }

    @JsonIgnore
    public void  setTxtKaisaiDateTo(TextBoxFlexibleDate txtKaisaiDateTo) {
        this.getKaigoNinteiShinsakaiJoho().setTxtKaisaiDateTo(txtKaisaiDateTo);
    }

    @JsonIgnore
    public Label getLblKaisaiNumber() {
        return this.getKaigoNinteiShinsakaiJoho().getLblKaisaiNumber();
    }

    @JsonIgnore
    public void  setLblKaisaiNumber(Label lblKaisaiNumber) {
        this.getKaigoNinteiShinsakaiJoho().setLblKaisaiNumber(lblKaisaiNumber);
    }

    @JsonIgnore
    public TextBox getTxtKaisaiNumberStart() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtKaisaiNumberStart();
    }

    @JsonIgnore
    public void  setTxtKaisaiNumberStart(TextBox txtKaisaiNumberStart) {
        this.getKaigoNinteiShinsakaiJoho().setTxtKaisaiNumberStart(txtKaisaiNumberStart);
    }

    @JsonIgnore
    public Label getLblKaisaiNoFor() {
        return this.getKaigoNinteiShinsakaiJoho().getLblKaisaiNoFor();
    }

    @JsonIgnore
    public void  setLblKaisaiNoFor(Label lblKaisaiNoFor) {
        this.getKaigoNinteiShinsakaiJoho().setLblKaisaiNoFor(lblKaisaiNoFor);
    }

    @JsonIgnore
    public TextBox getTxtKaisaiNumberEnd() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtKaisaiNumberEnd();
    }

    @JsonIgnore
    public void  setTxtKaisaiNumberEnd(TextBox txtKaisaiNumberEnd) {
        this.getKaigoNinteiShinsakaiJoho().setTxtKaisaiNumberEnd(txtKaisaiNumberEnd);
    }

    @JsonIgnore
    public Label getLblZenkaiChosaItakusaki() {
        return this.getZenkaiJoho().getLblZenkaiChosaItakusaki();
    }

    @JsonIgnore
    public void  setLblZenkaiChosaItakusaki(Label lblZenkaiChosaItakusaki) {
        this.getZenkaiJoho().setLblZenkaiChosaItakusaki(lblZenkaiChosaItakusaki);
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiChosaItakusakiGuide() {
        return this.getZenkaiJoho().getBtnZenkaiChosaItakusakiGuide();
    }

    @JsonIgnore
    public void  setBtnZenkaiChosaItakusakiGuide(ButtonDialog btnZenkaiChosaItakusakiGuide) {
        this.getZenkaiJoho().setBtnZenkaiChosaItakusakiGuide(btnZenkaiChosaItakusakiGuide);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiNinteiChosaItakusakiName() {
        return this.getZenkaiJoho().getTxtZenkaiNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtZenkaiNinteiChosaItakusakiName(TextBox txtZenkaiNinteiChosaItakusakiName) {
        this.getZenkaiJoho().setTxtZenkaiNinteiChosaItakusakiName(txtZenkaiNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public Label getLblZenkaiShujiiIryokikan() {
        return this.getZenkaiJoho().getLblZenkaiShujiiIryokikan();
    }

    @JsonIgnore
    public void  setLblZenkaiShujiiIryokikan(Label lblZenkaiShujiiIryokikan) {
        this.getZenkaiJoho().setLblZenkaiShujiiIryokikan(lblZenkaiShujiiIryokikan);
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiShujiiIryokikanGuide() {
        return this.getZenkaiJoho().getBtnZenkaiShujiiIryokikanGuide();
    }

    @JsonIgnore
    public void  setBtnZenkaiShujiiIryokikanGuide(ButtonDialog btnZenkaiShujiiIryokikanGuide) {
        this.getZenkaiJoho().setBtnZenkaiShujiiIryokikanGuide(btnZenkaiShujiiIryokikanGuide);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiShujiiIryokikanName() {
        return this.getZenkaiJoho().getTxtZenkaiShujiiIryokikanName();
    }

    @JsonIgnore
    public void  setTxtZenkaiShujiiIryokikanName(TextBox txtZenkaiShujiiIryokikanName) {
        this.getZenkaiJoho().setTxtZenkaiShujiiIryokikanName(txtZenkaiShujiiIryokikanName);
    }

    @JsonIgnore
    public DropDownList getDdlZenkaiNijiHanteiKekka() {
        return this.getZenkaiJoho().getDdlZenkaiNijiHanteiKekka();
    }

    @JsonIgnore
    public void  setDdlZenkaiNijiHanteiKekka(DropDownList ddlZenkaiNijiHanteiKekka) {
        this.getZenkaiJoho().setDdlZenkaiNijiHanteiKekka(ddlZenkaiNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiNinteiYukoKikan() {
        return this.getZenkaiJoho().getTxtZenkaiNinteiYukoKikan();
    }

    @JsonIgnore
    public void  setTxtZenkaiNinteiYukoKikan(TextBox txtZenkaiNinteiYukoKikan) {
        this.getZenkaiJoho().setTxtZenkaiNinteiYukoKikan(txtZenkaiNinteiYukoKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiYukoKaishiDateFrom() {
        return this.getZenkaiJoho().getTxtZenkaiYukoKaishiDateFrom();
    }

    @JsonIgnore
    public void  setTxtZenkaiYukoKaishiDateFrom(TextBoxFlexibleDate txtZenkaiYukoKaishiDateFrom) {
        this.getZenkaiJoho().setTxtZenkaiYukoKaishiDateFrom(txtZenkaiYukoKaishiDateFrom);
    }

    @JsonIgnore
    public Label getLblZenkaiYukoKaishiDate() {
        return this.getZenkaiJoho().getLblZenkaiYukoKaishiDate();
    }

    @JsonIgnore
    public void  setLblZenkaiYukoKaishiDate(Label lblZenkaiYukoKaishiDate) {
        this.getZenkaiJoho().setLblZenkaiYukoKaishiDate(lblZenkaiYukoKaishiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiYukoKaishiDateTo() {
        return this.getZenkaiJoho().getTxtZenkaiYukoKaishiDateTo();
    }

    @JsonIgnore
    public void  setTxtZenkaiYukoKaishiDateTo(TextBoxFlexibleDate txtZenkaiYukoKaishiDateTo) {
        this.getZenkaiJoho().setTxtZenkaiYukoKaishiDateTo(txtZenkaiYukoKaishiDateTo);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdGeninShikkan() {
        return this.getSonotaJoho().getCcdGeninShikkan();
    }

    @JsonIgnore
    public TextBoxNumRange getTxtShinseiKeikaNissu() {
        return this.getSonotaJoho().getTxtShinseiKeikaNissu();
    }

    @JsonIgnore
    public void  setTxtShinseiKeikaNissu(TextBoxNumRange txtShinseiKeikaNissu) {
        this.getSonotaJoho().setTxtShinseiKeikaNissu(txtShinseiKeikaNissu);
    }

    @JsonIgnore
    public DropDownList getDdlNowPhase() {
        return this.getKanryoJoho().getDdlNowPhase();
    }

    @JsonIgnore
    public void  setDdlNowPhase(DropDownList ddlNowPhase) {
        this.getKanryoJoho().setDdlNowPhase(ddlNowPhase);
    }

    @JsonIgnore
    public CheckBoxList getChkShoriJotai() {
        return this.getKanryoJoho().getChkShoriJotai();
    }

    @JsonIgnore
    public void  setChkShoriJotai(CheckBoxList chkShoriJotai) {
        this.getKanryoJoho().setChkShoriJotai(chkShoriJotai);
    }

    @JsonIgnore
    public Label getLblKoshinTaishoChushutsu() {
        return this.getKanryoJoho().getLblKoshinTaishoChushutsu();
    }

    @JsonIgnore
    public void  setLblKoshinTaishoChushutsu(Label lblKoshinTaishoChushutsu) {
        this.getKanryoJoho().setLblKoshinTaishoChushutsu(lblKoshinTaishoChushutsu);
    }

    @JsonIgnore
    public CheckBoxList getChkKoshinTaishoChushutsu() {
        return this.getKanryoJoho().getChkKoshinTaishoChushutsu();
    }

    @JsonIgnore
    public void  setChkKoshinTaishoChushutsu(CheckBoxList chkKoshinTaishoChushutsu) {
        this.getKanryoJoho().setChkKoshinTaishoChushutsu(chkKoshinTaishoChushutsu);
    }

    @JsonIgnore
    public Label getLblIchijiHantei() {
        return this.getKanryoJoho().getLblIchijiHantei();
    }

    @JsonIgnore
    public void  setLblIchijiHantei(Label lblIchijiHantei) {
        this.getKanryoJoho().setLblIchijiHantei(lblIchijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getChkIchijiHantei() {
        return this.getKanryoJoho().getChkIchijiHantei();
    }

    @JsonIgnore
    public void  setChkIchijiHantei(CheckBoxList chkIchijiHantei) {
        this.getKanryoJoho().setChkIchijiHantei(chkIchijiHantei);
    }

    @JsonIgnore
    public Label getLblShinseiUketsuke() {
        return this.getKanryoJoho().getLblShinseiUketsuke();
    }

    @JsonIgnore
    public void  setLblShinseiUketsuke(Label lblShinseiUketsuke) {
        this.getKanryoJoho().setLblShinseiUketsuke(lblShinseiUketsuke);
    }

    @JsonIgnore
    public CheckBoxList getChkShinseiUketsuke() {
        return this.getKanryoJoho().getChkShinseiUketsuke();
    }

    @JsonIgnore
    public void  setChkShinseiUketsuke(CheckBoxList chkShinseiUketsuke) {
        this.getKanryoJoho().setChkShinseiUketsuke(chkShinseiUketsuke);
    }

    @JsonIgnore
    public Label getLblMasking() {
        return this.getKanryoJoho().getLblMasking();
    }

    @JsonIgnore
    public void  setLblMasking(Label lblMasking) {
        this.getKanryoJoho().setLblMasking(lblMasking);
    }

    @JsonIgnore
    public CheckBoxList getChkMasking() {
        return this.getKanryoJoho().getChkMasking();
    }

    @JsonIgnore
    public void  setChkMasking(CheckBoxList chkMasking) {
        this.getKanryoJoho().setChkMasking(chkMasking);
    }

    @JsonIgnore
    public Label getLblChosaIrai() {
        return this.getKanryoJoho().getLblChosaIrai();
    }

    @JsonIgnore
    public void  setLblChosaIrai(Label lblChosaIrai) {
        this.getKanryoJoho().setLblChosaIrai(lblChosaIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaIrai() {
        return this.getKanryoJoho().getChkChosaIrai();
    }

    @JsonIgnore
    public void  setChkChosaIrai(CheckBoxList chkChosaIrai) {
        this.getKanryoJoho().setChkChosaIrai(chkChosaIrai);
    }

    @JsonIgnore
    public Label getLblShinsakaiToroku() {
        return this.getKanryoJoho().getLblShinsakaiToroku();
    }

    @JsonIgnore
    public void  setLblShinsakaiToroku(Label lblShinsakaiToroku) {
        this.getKanryoJoho().setLblShinsakaiToroku(lblShinsakaiToroku);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiToroku() {
        return this.getKanryoJoho().getChkShinsakaiToroku();
    }

    @JsonIgnore
    public void  setChkShinsakaiToroku(CheckBoxList chkShinsakaiToroku) {
        this.getKanryoJoho().setChkShinsakaiToroku(chkShinsakaiToroku);
    }

    @JsonIgnore
    public Label getLblIkenshoIrai() {
        return this.getKanryoJoho().getLblIkenshoIrai();
    }

    @JsonIgnore
    public void  setLblIkenshoIrai(Label lblIkenshoIrai) {
        this.getKanryoJoho().setLblIkenshoIrai(lblIkenshoIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoIrai() {
        return this.getKanryoJoho().getChkIkenshoIrai();
    }

    @JsonIgnore
    public void  setChkIkenshoIrai(CheckBoxList chkIkenshoIrai) {
        this.getKanryoJoho().setChkIkenshoIrai(chkIkenshoIrai);
    }

    @JsonIgnore
    public Label getLblNijiHantei() {
        return this.getKanryoJoho().getLblNijiHantei();
    }

    @JsonIgnore
    public void  setLblNijiHantei(Label lblNijiHantei) {
        this.getKanryoJoho().setLblNijiHantei(lblNijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getChkNijiHantei() {
        return this.getKanryoJoho().getChkNijiHantei();
    }

    @JsonIgnore
    public void  setChkNijiHantei(CheckBoxList chkNijiHantei) {
        this.getKanryoJoho().setChkNijiHantei(chkNijiHantei);
    }

    @JsonIgnore
    public Label getLblChosaNyushu() {
        return this.getKanryoJoho().getLblChosaNyushu();
    }

    @JsonIgnore
    public void  setLblChosaNyushu(Label lblChosaNyushu) {
        this.getKanryoJoho().setLblChosaNyushu(lblChosaNyushu);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaNyushu() {
        return this.getKanryoJoho().getChkChosaNyushu();
    }

    @JsonIgnore
    public void  setChkChosaNyushu(CheckBoxList chkChosaNyushu) {
        this.getKanryoJoho().setChkChosaNyushu(chkChosaNyushu);
    }

    @JsonIgnore
    public Label getLblTsuchiShori() {
        return this.getKanryoJoho().getLblTsuchiShori();
    }

    @JsonIgnore
    public void  setLblTsuchiShori(Label lblTsuchiShori) {
        this.getKanryoJoho().setLblTsuchiShori(lblTsuchiShori);
    }

    @JsonIgnore
    public CheckBoxList getChkTsuchiShori() {
        return this.getKanryoJoho().getChkTsuchiShori();
    }

    @JsonIgnore
    public void  setChkTsuchiShori(CheckBoxList chkTsuchiShori) {
        this.getKanryoJoho().setChkTsuchiShori(chkTsuchiShori);
    }

    @JsonIgnore
    public Label getLblIkenshoNyushu() {
        return this.getKanryoJoho().getLblIkenshoNyushu();
    }

    @JsonIgnore
    public void  setLblIkenshoNyushu(Label lblIkenshoNyushu) {
        this.getKanryoJoho().setLblIkenshoNyushu(lblIkenshoNyushu);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoNyushu() {
        return this.getKanryoJoho().getChkIkenshoNyushu();
    }

    @JsonIgnore
    public void  setChkIkenshoNyushu(CheckBoxList chkIkenshoNyushu) {
        this.getKanryoJoho().setChkIkenshoNyushu(chkIkenshoNyushu);
    }

    @JsonIgnore
    public Label getLblGetsureiShori() {
        return this.getKanryoJoho().getLblGetsureiShori();
    }

    @JsonIgnore
    public void  setLblGetsureiShori(Label lblGetsureiShori) {
        this.getKanryoJoho().setLblGetsureiShori(lblGetsureiShori);
    }

    @JsonIgnore
    public CheckBoxList getChkGetsureiShori() {
        return this.getKanryoJoho().getChkGetsureiShori();
    }

    @JsonIgnore
    public void  setChkGetsureiShori(CheckBoxList chkGetsureiShori) {
        this.getKanryoJoho().setChkGetsureiShori(chkGetsureiShori);
    }

    // </editor-fold>
}
