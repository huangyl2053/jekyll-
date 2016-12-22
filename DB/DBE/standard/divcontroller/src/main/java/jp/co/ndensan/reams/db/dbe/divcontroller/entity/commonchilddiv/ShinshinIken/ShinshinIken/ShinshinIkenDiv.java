package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * ShinshinIken のクラスファイル 
 * 
 */
public class ShinshinIkenDiv extends Panel implements IShinshinIkenDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NichijoJiritsudo")
    private NichijoJiritsudoDiv NichijoJiritsudo;
    @JsonProperty("NinchishoChukakuShojo")
    private NinchishoChukakuShojoDiv NinchishoChukakuShojo;
    @JsonProperty("NinchishoShuhenShojo")
    private NinchishoShuhenShojoDiv NinchishoShuhenShojo;
    @JsonProperty("SonotaShojo")
    private SonotaShojoDiv SonotaShojo;
    @JsonProperty("KaradaJotai")
    private KaradaJotaiDiv KaradaJotai;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("selectKeys")
    private RString selectKeys;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNichijoJiritsudo
     * @return NichijoJiritsudo
     */
    @JsonProperty("NichijoJiritsudo")
    public NichijoJiritsudoDiv getNichijoJiritsudo() {
        return NichijoJiritsudo;
    }

    /*
     * setNichijoJiritsudo
     * @param NichijoJiritsudo NichijoJiritsudo
     */
    @JsonProperty("NichijoJiritsudo")
    public void setNichijoJiritsudo(NichijoJiritsudoDiv NichijoJiritsudo) {
        this.NichijoJiritsudo = NichijoJiritsudo;
    }

    /*
     * getNinchishoChukakuShojo
     * @return NinchishoChukakuShojo
     */
    @JsonProperty("NinchishoChukakuShojo")
    public NinchishoChukakuShojoDiv getNinchishoChukakuShojo() {
        return NinchishoChukakuShojo;
    }

    /*
     * setNinchishoChukakuShojo
     * @param NinchishoChukakuShojo NinchishoChukakuShojo
     */
    @JsonProperty("NinchishoChukakuShojo")
    public void setNinchishoChukakuShojo(NinchishoChukakuShojoDiv NinchishoChukakuShojo) {
        this.NinchishoChukakuShojo = NinchishoChukakuShojo;
    }

    /*
     * getNinchishoShuhenShojo
     * @return NinchishoShuhenShojo
     */
    @JsonProperty("NinchishoShuhenShojo")
    public NinchishoShuhenShojoDiv getNinchishoShuhenShojo() {
        return NinchishoShuhenShojo;
    }

    /*
     * setNinchishoShuhenShojo
     * @param NinchishoShuhenShojo NinchishoShuhenShojo
     */
    @JsonProperty("NinchishoShuhenShojo")
    public void setNinchishoShuhenShojo(NinchishoShuhenShojoDiv NinchishoShuhenShojo) {
        this.NinchishoShuhenShojo = NinchishoShuhenShojo;
    }

    /*
     * getSonotaShojo
     * @return SonotaShojo
     */
    @JsonProperty("SonotaShojo")
    public SonotaShojoDiv getSonotaShojo() {
        return SonotaShojo;
    }

    /*
     * setSonotaShojo
     * @param SonotaShojo SonotaShojo
     */
    @JsonProperty("SonotaShojo")
    public void setSonotaShojo(SonotaShojoDiv SonotaShojo) {
        this.SonotaShojo = SonotaShojo;
    }

    /*
     * getKaradaJotai
     * @return KaradaJotai
     */
    @JsonProperty("KaradaJotai")
    public KaradaJotaiDiv getKaradaJotai() {
        return KaradaJotai;
    }

    /*
     * setKaradaJotai
     * @param KaradaJotai KaradaJotai
     */
    @JsonProperty("KaradaJotai")
    public void setKaradaJotai(KaradaJotaiDiv KaradaJotai) {
        this.KaradaJotai = KaradaJotai;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
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
     * getselectKeys
     * @return selectKeys
     */
    @JsonProperty("selectKeys")
    public RString getSelectKeys() {
        return selectKeys;
    }

    /*
     * setselectKeys
     * @param selectKeys selectKeys
     */
    @JsonProperty("selectKeys")
    public void setSelectKeys(RString selectKeys) {
        this.selectKeys = selectKeys;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShogaiKoreishaNichijoSeikatsuJiritsudo() {
        return this.getNichijoJiritsudo().getRadShogaiKoreishaNichijoSeikatsuJiritsudo();
    }

    @JsonIgnore
    public void  setRadShogaiKoreishaNichijoSeikatsuJiritsudo(RadioButton radShogaiKoreishaNichijoSeikatsuJiritsudo) {
        this.getNichijoJiritsudo().setRadShogaiKoreishaNichijoSeikatsuJiritsudo(radShogaiKoreishaNichijoSeikatsuJiritsudo);
    }

    @JsonIgnore
    public RadioButton getRadNinchishoKoreishaJiritsu() {
        return this.getNichijoJiritsudo().getRadNinchishoKoreishaJiritsu();
    }

    @JsonIgnore
    public void  setRadNinchishoKoreishaJiritsu(RadioButton radNinchishoKoreishaJiritsu) {
        this.getNichijoJiritsudo().setRadNinchishoKoreishaJiritsu(radNinchishoKoreishaJiritsu);
    }

    @JsonIgnore
    public RadioButton getRadTankiKioku() {
        return this.getNinchishoChukakuShojo().getRadTankiKioku();
    }

    @JsonIgnore
    public void  setRadTankiKioku(RadioButton radTankiKioku) {
        this.getNinchishoChukakuShojo().setRadTankiKioku(radTankiKioku);
    }

    @JsonIgnore
    public RadioButton getRadNichijoNinchiNoryoku() {
        return this.getNinchishoChukakuShojo().getRadNichijoNinchiNoryoku();
    }

    @JsonIgnore
    public void  setRadNichijoNinchiNoryoku(RadioButton radNichijoNinchiNoryoku) {
        this.getNinchishoChukakuShojo().setRadNichijoNinchiNoryoku(radNichijoNinchiNoryoku);
    }

    @JsonIgnore
    public RadioButton getRadIshiDentatsuNoryoku() {
        return this.getNinchishoChukakuShojo().getRadIshiDentatsuNoryoku();
    }

    @JsonIgnore
    public void  setRadIshiDentatsuNoryoku(RadioButton radIshiDentatsuNoryoku) {
        this.getNinchishoChukakuShojo().setRadIshiDentatsuNoryoku(radIshiDentatsuNoryoku);
    }

    @JsonIgnore
    public RadioButton getRadNinchishoShuhenShojoUmu() {
        return this.getNinchishoShuhenShojo().getRadNinchishoShuhenShojoUmu();
    }

    @JsonIgnore
    public void  setRadNinchishoShuhenShojoUmu(RadioButton radNinchishoShuhenShojoUmu) {
        this.getNinchishoShuhenShojo().setRadNinchishoShuhenShojoUmu(radNinchishoShuhenShojoUmu);
    }

    @JsonIgnore
    public CheckBoxList getChkNinchishoShuhenShojo() {
        return this.getNinchishoShuhenShojo().getChkNinchishoShuhenShojo();
    }

    @JsonIgnore
    public void  setChkNinchishoShuhenShojo(CheckBoxList chkNinchishoShuhenShojo) {
        this.getNinchishoShuhenShojo().setChkNinchishoShuhenShojo(chkNinchishoShuhenShojo);
    }

    @JsonIgnore
    public CheckBoxList getChkNinchishoShuhenShojoSonota() {
        return this.getNinchishoShuhenShojo().getChkNinchishoShuhenShojoSonota();
    }

    @JsonIgnore
    public void  setChkNinchishoShuhenShojoSonota(CheckBoxList chkNinchishoShuhenShojoSonota) {
        this.getNinchishoShuhenShojo().setChkNinchishoShuhenShojoSonota(chkNinchishoShuhenShojoSonota);
    }

    @JsonIgnore
    public TextBox getTxtSonotaKinyu() {
        return this.getNinchishoShuhenShojo().getTxtSonotaKinyu();
    }

    @JsonIgnore
    public void  setTxtSonotaKinyu(TextBox txtSonotaKinyu) {
        this.getNinchishoShuhenShojo().setTxtSonotaKinyu(txtSonotaKinyu);
    }

    @JsonIgnore
    public RadioButton getRadSonotaShojo() {
        return this.getSonotaShojo().getRadSonotaShojo();
    }

    @JsonIgnore
    public void  setRadSonotaShojo(RadioButton radSonotaShojo) {
        this.getSonotaShojo().setRadSonotaShojo(radSonotaShojo);
    }

    @JsonIgnore
    public TextBox getTxtShojomei() {
        return this.getSonotaShojo().getTxtShojomei();
    }

    @JsonIgnore
    public void  setTxtShojomei(TextBox txtShojomei) {
        this.getSonotaShojo().setTxtShojomei(txtShojomei);
    }

    @JsonIgnore
    public RadioButton getRadSenmonJushin() {
        return this.getSonotaShojo().getRadSenmonJushin();
    }

    @JsonIgnore
    public void  setRadSenmonJushin(RadioButton radSenmonJushin) {
        this.getSonotaShojo().setRadSenmonJushin(radSenmonJushin);
    }

    @JsonIgnore
    public TextBox getTxtShosaiTokkiJiko() {
        return this.getSonotaShojo().getTxtShosaiTokkiJiko();
    }

    @JsonIgnore
    public void  setTxtShosaiTokkiJiko(TextBox txtShosaiTokkiJiko) {
        this.getSonotaShojo().setTxtShosaiTokkiJiko(txtShosaiTokkiJiko);
    }

    @JsonIgnore
    public RadioButton getRadKikiude() {
        return this.getKaradaJotai().getRadKikiude();
    }

    @JsonIgnore
    public void  setRadKikiude(RadioButton radKikiude) {
        this.getKaradaJotai().setRadKikiude(radKikiude);
    }

    @JsonIgnore
    public TextBox getTxtShincho() {
        return this.getKaradaJotai().getTxtShincho();
    }

    @JsonIgnore
    public void  setTxtShincho(TextBox txtShincho) {
        this.getKaradaJotai().setTxtShincho(txtShincho);
    }

    @JsonIgnore
    public RadioButton getRadKakoTaijuHenka() {
        return this.getKaradaJotai().getRadKakoTaijuHenka();
    }

    @JsonIgnore
    public void  setRadKakoTaijuHenka(RadioButton radKakoTaijuHenka) {
        this.getKaradaJotai().setRadKakoTaijuHenka(radKakoTaijuHenka);
    }

    @JsonIgnore
    public TextBox getTxtTaiju() {
        return this.getKaradaJotai().getTxtTaiju();
    }

    @JsonIgnore
    public void  setTxtTaiju(TextBox txtTaiju) {
        this.getKaradaJotai().setTxtTaiju(txtTaiju);
    }

    @JsonIgnore
    public CheckBoxList getChkShishiKesson() {
        return this.getKaradaJotai().getChkShishiKesson();
    }

    @JsonIgnore
    public void  setChkShishiKesson(CheckBoxList chkShishiKesson) {
        this.getKaradaJotai().setChkShishiKesson(chkShishiKesson);
    }

    @JsonIgnore
    public TextBox getTxtShishiKessonBui() {
        return this.getKaradaJotai().getTxtShishiKessonBui();
    }

    @JsonIgnore
    public void  setTxtShishiKessonBui(TextBox txtShishiKessonBui) {
        this.getKaradaJotai().setTxtShishiKessonBui(txtShishiKessonBui);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon1() {
        return this.getKaradaJotai().getLinHorizon1();
    }

    @JsonIgnore
    public void  setLinHorizon1(HorizontalLine linHorizon1) {
        this.getKaradaJotai().setLinHorizon1(linHorizon1);
    }

    @JsonIgnore
    public CheckBoxList getChkMahi() {
        return this.getKaradaJotai().getChkMahi();
    }

    @JsonIgnore
    public void  setChkMahi(CheckBoxList chkMahi) {
        this.getKaradaJotai().setChkMahi(chkMahi);
    }

    @JsonIgnore
    public CheckBoxList getChkMigiJoshiMahi() {
        return this.getKaradaJotai().getChkMigiJoshiMahi();
    }

    @JsonIgnore
    public void  setChkMigiJoshiMahi(CheckBoxList chkMigiJoshiMahi) {
        this.getKaradaJotai().setChkMigiJoshiMahi(chkMigiJoshiMahi);
    }

    @JsonIgnore
    public RadioButton getRadMigiJoshiMahiTeido() {
        return this.getKaradaJotai().getRadMigiJoshiMahiTeido();
    }

    @JsonIgnore
    public void  setRadMigiJoshiMahiTeido(RadioButton radMigiJoshiMahiTeido) {
        this.getKaradaJotai().setRadMigiJoshiMahiTeido(radMigiJoshiMahiTeido);
    }

    @JsonIgnore
    public CheckBoxList getChkHidariJoshiMahi() {
        return this.getKaradaJotai().getChkHidariJoshiMahi();
    }

    @JsonIgnore
    public void  setChkHidariJoshiMahi(CheckBoxList chkHidariJoshiMahi) {
        this.getKaradaJotai().setChkHidariJoshiMahi(chkHidariJoshiMahi);
    }

    @JsonIgnore
    public RadioButton getRadHidariJoshiMahiTeido() {
        return this.getKaradaJotai().getRadHidariJoshiMahiTeido();
    }

    @JsonIgnore
    public void  setRadHidariJoshiMahiTeido(RadioButton radHidariJoshiMahiTeido) {
        this.getKaradaJotai().setRadHidariJoshiMahiTeido(radHidariJoshiMahiTeido);
    }

    @JsonIgnore
    public CheckBoxList getChkMigiKashiMahi() {
        return this.getKaradaJotai().getChkMigiKashiMahi();
    }

    @JsonIgnore
    public void  setChkMigiKashiMahi(CheckBoxList chkMigiKashiMahi) {
        this.getKaradaJotai().setChkMigiKashiMahi(chkMigiKashiMahi);
    }

    @JsonIgnore
    public RadioButton getRadMigiKashiMahiTeido() {
        return this.getKaradaJotai().getRadMigiKashiMahiTeido();
    }

    @JsonIgnore
    public void  setRadMigiKashiMahiTeido(RadioButton radMigiKashiMahiTeido) {
        this.getKaradaJotai().setRadMigiKashiMahiTeido(radMigiKashiMahiTeido);
    }

    @JsonIgnore
    public CheckBoxList getChkHidariKashiMahi() {
        return this.getKaradaJotai().getChkHidariKashiMahi();
    }

    @JsonIgnore
    public void  setChkHidariKashiMahi(CheckBoxList chkHidariKashiMahi) {
        this.getKaradaJotai().setChkHidariKashiMahi(chkHidariKashiMahi);
    }

    @JsonIgnore
    public RadioButton getRadHidariKashiMahiTeido() {
        return this.getKaradaJotai().getRadHidariKashiMahiTeido();
    }

    @JsonIgnore
    public void  setRadHidariKashiMahiTeido(RadioButton radHidariKashiMahiTeido) {
        this.getKaradaJotai().setRadHidariKashiMahiTeido(radHidariKashiMahiTeido);
    }

    @JsonIgnore
    public Space getSp1() {
        return this.getKaradaJotai().getSp1();
    }

    @JsonIgnore
    public void  setSp1(Space Sp1) {
        this.getKaradaJotai().setSp1(Sp1);
    }

    @JsonIgnore
    public CheckBoxList getChkSonotaMahi() {
        return this.getKaradaJotai().getChkSonotaMahi();
    }

    @JsonIgnore
    public void  setChkSonotaMahi(CheckBoxList chkSonotaMahi) {
        this.getKaradaJotai().setChkSonotaMahi(chkSonotaMahi);
    }

    @JsonIgnore
    public TextBox getTxtSonotaMahiBui() {
        return this.getKaradaJotai().getTxtSonotaMahiBui();
    }

    @JsonIgnore
    public void  setTxtSonotaMahiBui(TextBox txtSonotaMahiBui) {
        this.getKaradaJotai().setTxtSonotaMahiBui(txtSonotaMahiBui);
    }

    @JsonIgnore
    public RadioButton getRadSonotaMahiTeido() {
        return this.getKaradaJotai().getRadSonotaMahiTeido();
    }

    @JsonIgnore
    public void  setRadSonotaMahiTeido(RadioButton radSonotaMahiTeido) {
        this.getKaradaJotai().setRadSonotaMahiTeido(radSonotaMahiTeido);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon2() {
        return this.getKaradaJotai().getLinHorizon2();
    }

    @JsonIgnore
    public void  setLinHorizon2(HorizontalLine linHorizon2) {
        this.getKaradaJotai().setLinHorizon2(linHorizon2);
    }

    @JsonIgnore
    public CheckBoxList getChkKinryokuTeika() {
        return this.getKaradaJotai().getChkKinryokuTeika();
    }

    @JsonIgnore
    public void  setChkKinryokuTeika(CheckBoxList chkKinryokuTeika) {
        this.getKaradaJotai().setChkKinryokuTeika(chkKinryokuTeika);
    }

    @JsonIgnore
    public TextBox getTxtKinryokuTeikaBui() {
        return this.getKaradaJotai().getTxtKinryokuTeikaBui();
    }

    @JsonIgnore
    public void  setTxtKinryokuTeikaBui(TextBox txtKinryokuTeikaBui) {
        this.getKaradaJotai().setTxtKinryokuTeikaBui(txtKinryokuTeikaBui);
    }

    @JsonIgnore
    public RadioButton getRadKinryokuTeikaTeido() {
        return this.getKaradaJotai().getRadKinryokuTeikaTeido();
    }

    @JsonIgnore
    public void  setRadKinryokuTeikaTeido(RadioButton radKinryokuTeikaTeido) {
        this.getKaradaJotai().setRadKinryokuTeikaTeido(radKinryokuTeikaTeido);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon3() {
        return this.getKaradaJotai().getLinHorizon3();
    }

    @JsonIgnore
    public void  setLinHorizon3(HorizontalLine linHorizon3) {
        this.getKaradaJotai().setLinHorizon3(linHorizon3);
    }

    @JsonIgnore
    public CheckBoxList getChkKansetsuKoshuku() {
        return this.getKaradaJotai().getChkKansetsuKoshuku();
    }

    @JsonIgnore
    public void  setChkKansetsuKoshuku(CheckBoxList chkKansetsuKoshuku) {
        this.getKaradaJotai().setChkKansetsuKoshuku(chkKansetsuKoshuku);
    }

    @JsonIgnore
    public TextBox getTxtKansetsuKoshukuBui() {
        return this.getKaradaJotai().getTxtKansetsuKoshukuBui();
    }

    @JsonIgnore
    public void  setTxtKansetsuKoshukuBui(TextBox txtKansetsuKoshukuBui) {
        this.getKaradaJotai().setTxtKansetsuKoshukuBui(txtKansetsuKoshukuBui);
    }

    @JsonIgnore
    public RadioButton getRadKansetsuKoshukuTeido() {
        return this.getKaradaJotai().getRadKansetsuKoshukuTeido();
    }

    @JsonIgnore
    public void  setRadKansetsuKoshukuTeido(RadioButton radKansetsuKoshukuTeido) {
        this.getKaradaJotai().setRadKansetsuKoshukuTeido(radKansetsuKoshukuTeido);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon4() {
        return this.getKaradaJotai().getLinHorizon4();
    }

    @JsonIgnore
    public void  setLinHorizon4(HorizontalLine linHorizon4) {
        this.getKaradaJotai().setLinHorizon4(linHorizon4);
    }

    @JsonIgnore
    public CheckBoxList getChkKansetsuItami() {
        return this.getKaradaJotai().getChkKansetsuItami();
    }

    @JsonIgnore
    public void  setChkKansetsuItami(CheckBoxList chkKansetsuItami) {
        this.getKaradaJotai().setChkKansetsuItami(chkKansetsuItami);
    }

    @JsonIgnore
    public TextBox getTxtKansetsuItamiBui() {
        return this.getKaradaJotai().getTxtKansetsuItamiBui();
    }

    @JsonIgnore
    public void  setTxtKansetsuItamiBui(TextBox txtKansetsuItamiBui) {
        this.getKaradaJotai().setTxtKansetsuItamiBui(txtKansetsuItamiBui);
    }

    @JsonIgnore
    public RadioButton getRadKansetsuItamiTeido() {
        return this.getKaradaJotai().getRadKansetsuItamiTeido();
    }

    @JsonIgnore
    public void  setRadKansetsuItamiTeido(RadioButton radKansetsuItamiTeido) {
        this.getKaradaJotai().setRadKansetsuItamiTeido(radKansetsuItamiTeido);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon5() {
        return this.getKaradaJotai().getLinHorizon5();
    }

    @JsonIgnore
    public void  setLinHorizon5(HorizontalLine linHorizon5) {
        this.getKaradaJotai().setLinHorizon5(linHorizon5);
    }

    @JsonIgnore
    public CheckBoxList getChkShicchoFuzuii() {
        return this.getKaradaJotai().getChkShicchoFuzuii();
    }

    @JsonIgnore
    public void  setChkShicchoFuzuii(CheckBoxList chkShicchoFuzuii) {
        this.getKaradaJotai().setChkShicchoFuzuii(chkShicchoFuzuii);
    }

    @JsonIgnore
    public CheckBoxList getChkFuzuiiJoshi() {
        return this.getKaradaJotai().getChkFuzuiiJoshi();
    }

    @JsonIgnore
    public void  setChkFuzuiiJoshi(CheckBoxList chkFuzuiiJoshi) {
        this.getKaradaJotai().setChkFuzuiiJoshi(chkFuzuiiJoshi);
    }

    @JsonIgnore
    public CheckBoxList getChkFuzuiiKashi() {
        return this.getKaradaJotai().getChkFuzuiiKashi();
    }

    @JsonIgnore
    public void  setChkFuzuiiKashi(CheckBoxList chkFuzuiiKashi) {
        this.getKaradaJotai().setChkFuzuiiKashi(chkFuzuiiKashi);
    }

    @JsonIgnore
    public CheckBoxList getChkTaikan() {
        return this.getKaradaJotai().getChkTaikan();
    }

    @JsonIgnore
    public void  setChkTaikan(CheckBoxList chkTaikan) {
        this.getKaradaJotai().setChkTaikan(chkTaikan);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon6() {
        return this.getKaradaJotai().getLinHorizon6();
    }

    @JsonIgnore
    public void  setLinHorizon6(HorizontalLine linHorizon6) {
        this.getKaradaJotai().setLinHorizon6(linHorizon6);
    }

    @JsonIgnore
    public CheckBoxList getChkJokuso() {
        return this.getKaradaJotai().getChkJokuso();
    }

    @JsonIgnore
    public void  setChkJokuso(CheckBoxList chkJokuso) {
        this.getKaradaJotai().setChkJokuso(chkJokuso);
    }

    @JsonIgnore
    public TextBox getTxtJokusoBui() {
        return this.getKaradaJotai().getTxtJokusoBui();
    }

    @JsonIgnore
    public void  setTxtJokusoBui(TextBox txtJokusoBui) {
        this.getKaradaJotai().setTxtJokusoBui(txtJokusoBui);
    }

    @JsonIgnore
    public RadioButton getRadJokusoTeido() {
        return this.getKaradaJotai().getRadJokusoTeido();
    }

    @JsonIgnore
    public void  setRadJokusoTeido(RadioButton radJokusoTeido) {
        this.getKaradaJotai().setRadJokusoTeido(radJokusoTeido);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon7() {
        return this.getKaradaJotai().getLinHorizon7();
    }

    @JsonIgnore
    public void  setLinHorizon7(HorizontalLine linHorizon7) {
        this.getKaradaJotai().setLinHorizon7(linHorizon7);
    }

    @JsonIgnore
    public CheckBoxList getChkSonotaHifuShikkan() {
        return this.getKaradaJotai().getChkSonotaHifuShikkan();
    }

    @JsonIgnore
    public void  setChkSonotaHifuShikkan(CheckBoxList chkSonotaHifuShikkan) {
        this.getKaradaJotai().setChkSonotaHifuShikkan(chkSonotaHifuShikkan);
    }

    @JsonIgnore
    public TextBox getTxtSonotaHifuShikkanBui() {
        return this.getKaradaJotai().getTxtSonotaHifuShikkanBui();
    }

    @JsonIgnore
    public void  setTxtSonotaHifuShikkanBui(TextBox txtSonotaHifuShikkanBui) {
        this.getKaradaJotai().setTxtSonotaHifuShikkanBui(txtSonotaHifuShikkanBui);
    }

    @JsonIgnore
    public RadioButton getRadSonotaHifuShikkanTeido() {
        return this.getKaradaJotai().getRadSonotaHifuShikkanTeido();
    }

    @JsonIgnore
    public void  setRadSonotaHifuShikkanTeido(RadioButton radSonotaHifuShikkanTeido) {
        this.getKaradaJotai().setRadSonotaHifuShikkanTeido(radSonotaHifuShikkanTeido);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
