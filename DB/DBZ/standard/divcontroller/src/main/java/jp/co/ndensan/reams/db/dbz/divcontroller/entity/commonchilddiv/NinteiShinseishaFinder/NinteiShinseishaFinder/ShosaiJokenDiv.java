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
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShosaiJoken のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class ShosaiJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
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
    public CheckBoxList getChkShisetsuNyusho() {
        return this.getKihonJoho().getChkShisetsuNyusho();
    }

    @JsonIgnore
    public void  setChkShisetsuNyusho(CheckBoxList chkShisetsuNyusho) {
        this.getKihonJoho().setChkShisetsuNyusho(chkShisetsuNyusho);
    }

    @JsonIgnore
    public TextBoxDomainCode getTxtNinteiChosaIinItakuSaki() {
        return this.getNinteiChosa().getTxtNinteiChosaIinItakuSaki();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaIinItakuSaki(TextBoxDomainCode txtNinteiChosaIinItakuSaki) {
        this.getNinteiChosa().setTxtNinteiChosaIinItakuSaki(txtNinteiChosaIinItakuSaki);
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
    public TextBoxDomainCode getTxtNinteiChosaInShimei() {
        return this.getNinteiChosa().getTxtNinteiChosaInShimei();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaInShimei(TextBoxDomainCode txtNinteiChosaInShimei) {
        this.getNinteiChosa().setTxtNinteiChosaInShimei(txtNinteiChosaInShimei);
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
    public TextBoxDateRange getTxtChosaJisshiDateRange() {
        return this.getNinteiChosa().getTxtChosaJisshiDateRange();
    }

    @JsonIgnore
    public void  setTxtChosaJisshiDateRange(TextBoxDateRange txtChosaJisshiDateRange) {
        this.getNinteiChosa().setTxtChosaJisshiDateRange(txtChosaJisshiDateRange);
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
    public TextBoxDomainCode getTxtShujiiIryokikan() {
        return this.getShujiiJoho().getTxtShujiiIryokikan();
    }

    @JsonIgnore
    public void  setTxtShujiiIryokikan(TextBoxDomainCode txtShujiiIryokikan) {
        this.getShujiiJoho().setTxtShujiiIryokikan(txtShujiiIryokikan);
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
    public TextBoxDomainCode getTxtShujiiShimei() {
        return this.getShujiiJoho().getTxtShujiiShimei();
    }

    @JsonIgnore
    public void  setTxtShujiiShimei(TextBoxDomainCode txtShujiiShimei) {
        this.getShujiiJoho().setTxtShujiiShimei(txtShujiiShimei);
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
    public TextBoxDateRange getTxtIkenshoKinyuDateRange() {
        return this.getShujiiJoho().getTxtIkenshoKinyuDateRange();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyuDateRange(TextBoxDateRange txtIkenshoKinyuDateRange) {
        this.getShujiiJoho().setTxtIkenshoKinyuDateRange(txtIkenshoKinyuDateRange);
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
    public TextBoxDateRange getTxtIchijiHanteiDateRange() {
        return this.getIchijiHantei().getTxtIchijiHanteiDateRange();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiDateRange(TextBoxDateRange txtIchijiHanteiDateRange) {
        this.getIchijiHantei().setTxtIchijiHanteiDateRange(txtIchijiHanteiDateRange);
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
    public TextBoxDateRange getTxtIchiGoHanteiDateRange() {
        return this.getIchiGoHantei().getTxtIchiGoHanteiDateRange();
    }

    @JsonIgnore
    public void  setTxtIchiGoHanteiDateRange(TextBoxDateRange txtIchiGoHanteiDateRange) {
        this.getIchiGoHantei().setTxtIchiGoHanteiDateRange(txtIchiGoHanteiDateRange);
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
    public TextBoxDate getTxtCheckDay() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtCheckDay();
    }

    @JsonIgnore
    public void  setTxtCheckDay(TextBoxDate txtCheckDay) {
        this.getKaigoNinteiShinsakaiJoho().setTxtCheckDay(txtCheckDay);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYukoKaishiDateRange() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoKaishiDateRange();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKaishiDateRange(TextBoxDateRange txtNinteiYukoKaishiDateRange) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoKaishiDateRange(txtNinteiYukoKaishiDateRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYukoShuryoDateRange() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoShuryoDateRange();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryoDateRange(TextBoxDateRange txtNinteiYukoShuryoDateRange) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoShuryoDateRange(txtNinteiYukoShuryoDateRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNijiHanteiDateRange() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtNijiHanteiDateRange();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiDateRange(TextBoxDateRange txtNijiHanteiDateRange) {
        this.getKaigoNinteiShinsakaiJoho().setTxtNijiHanteiDateRange(txtNijiHanteiDateRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKaisaiDateRange() {
        return this.getKaigoNinteiShinsakaiJoho().getTxtKaisaiDateRange();
    }

    @JsonIgnore
    public void  setTxtKaisaiDateRange(TextBoxDateRange txtKaisaiDateRange) {
        this.getKaigoNinteiShinsakaiJoho().setTxtKaisaiDateRange(txtKaisaiDateRange);
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
    public TextBoxDomainCode getTxtZenkaiChosaItakusaki() {
        return this.getZenkaiJoho().getTxtZenkaiChosaItakusaki();
    }

    @JsonIgnore
    public void  setTxtZenkaiChosaItakusaki(TextBoxDomainCode txtZenkaiChosaItakusaki) {
        this.getZenkaiJoho().setTxtZenkaiChosaItakusaki(txtZenkaiChosaItakusaki);
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
    public TextBoxDomainCode getTxtZenkaiShujiiIryokikan() {
        return this.getZenkaiJoho().getTxtZenkaiShujiiIryokikan();
    }

    @JsonIgnore
    public void  setTxtZenkaiShujiiIryokikan(TextBoxDomainCode txtZenkaiShujiiIryokikan) {
        this.getZenkaiJoho().setTxtZenkaiShujiiIryokikan(txtZenkaiShujiiIryokikan);
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
    public TextBoxDateRange getTxtZenkaiYukoKaishiDateRange() {
        return this.getZenkaiJoho().getTxtZenkaiYukoKaishiDateRange();
    }

    @JsonIgnore
    public void  setTxtZenkaiYukoKaishiDateRange(TextBoxDateRange txtZenkaiYukoKaishiDateRange) {
        this.getZenkaiJoho().setTxtZenkaiYukoKaishiDateRange(txtZenkaiYukoKaishiDateRange);
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

    // </editor-fold>
}
