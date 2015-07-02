package jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinshinIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinshinIken.IShinshinIkenDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinshinIken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinshinIkenDiv extends Panel implements IShinshinIkenDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
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
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("btnKoshin")
    private Button btnKoshin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NichijoJiritsudo")
    public NichijoJiritsudoDiv getNichijoJiritsudo() {
        return NichijoJiritsudo;
    }

    @JsonProperty("NichijoJiritsudo")
    public void setNichijoJiritsudo(NichijoJiritsudoDiv NichijoJiritsudo) {
        this.NichijoJiritsudo=NichijoJiritsudo;
    }

    @JsonProperty("NinchishoChukakuShojo")
    public NinchishoChukakuShojoDiv getNinchishoChukakuShojo() {
        return NinchishoChukakuShojo;
    }

    @JsonProperty("NinchishoChukakuShojo")
    public void setNinchishoChukakuShojo(NinchishoChukakuShojoDiv NinchishoChukakuShojo) {
        this.NinchishoChukakuShojo=NinchishoChukakuShojo;
    }

    @JsonProperty("NinchishoShuhenShojo")
    public NinchishoShuhenShojoDiv getNinchishoShuhenShojo() {
        return NinchishoShuhenShojo;
    }

    @JsonProperty("NinchishoShuhenShojo")
    public void setNinchishoShuhenShojo(NinchishoShuhenShojoDiv NinchishoShuhenShojo) {
        this.NinchishoShuhenShojo=NinchishoShuhenShojo;
    }

    @JsonProperty("SonotaShojo")
    public SonotaShojoDiv getSonotaShojo() {
        return SonotaShojo;
    }

    @JsonProperty("SonotaShojo")
    public void setSonotaShojo(SonotaShojoDiv SonotaShojo) {
        this.SonotaShojo=SonotaShojo;
    }

    @JsonProperty("KaradaJotai")
    public KaradaJotaiDiv getKaradaJotai() {
        return KaradaJotai;
    }

    @JsonProperty("KaradaJotai")
    public void setKaradaJotai(KaradaJotaiDiv KaradaJotai) {
        this.KaradaJotai=KaradaJotai;
    }

    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru=btnModoru;
    }

    @JsonProperty("btnKoshin")
    public Button getBtnKoshin() {
        return btnKoshin;
    }

    @JsonProperty("btnKoshin")
    public void setBtnKoshin(Button btnKoshin) {
        this.btnKoshin=btnKoshin;
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
    public RadioButton getRadShokujiKoi() {
        return this.getNinchishoChukakuShojo().getRadShokujiKoi();
    }

    @JsonIgnore
    public void  setRadShokujiKoi(RadioButton radShokujiKoi) {
        this.getNinchishoChukakuShojo().setRadShokujiKoi(radShokujiKoi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinchishoShuhenShojoUmu() {
        return this.getNinchishoShuhenShojo().getChkNinchishoShuhenShojoUmu();
    }

    @JsonIgnore
    public void  setChkNinchishoShuhenShojoUmu(CheckBoxList chkNinchishoShuhenShojoUmu) {
        this.getNinchishoShuhenShojo().setChkNinchishoShuhenShojoUmu(chkNinchishoShuhenShojoUmu);
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
    public CheckBoxList getChkSonotaShojo() {
        return this.getSonotaShojo().getChkSonotaShojo();
    }

    @JsonIgnore
    public void  setChkSonotaShojo(CheckBoxList chkSonotaShojo) {
        this.getSonotaShojo().setChkSonotaShojo(chkSonotaShojo);
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
    public CheckBoxList getChkSenmonJushin() {
        return this.getSonotaShojo().getChkSenmonJushin();
    }

    @JsonIgnore
    public void  setChkSenmonJushin(CheckBoxList chkSenmonJushin) {
        this.getSonotaShojo().setChkSenmonJushin(chkSenmonJushin);
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
    public CheckBoxList getChkKikiude() {
        return this.getKaradaJotai().getChkKikiude();
    }

    @JsonIgnore
    public void  setChkKikiude(CheckBoxList chkKikiude) {
        this.getKaradaJotai().setChkKikiude(chkKikiude);
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
    public TextBox getTxtTaiju() {
        return this.getKaradaJotai().getTxtTaiju();
    }

    @JsonIgnore
    public void  setTxtTaiju(TextBox txtTaiju) {
        this.getKaradaJotai().setTxtTaiju(txtTaiju);
    }

    @JsonIgnore
    public CheckBoxList getChkKakoTaijuHenka() {
        return this.getKaradaJotai().getChkKakoTaijuHenka();
    }

    @JsonIgnore
    public void  setChkKakoTaijuHenka(CheckBoxList chkKakoTaijuHenka) {
        this.getKaradaJotai().setChkKakoTaijuHenka(chkKakoTaijuHenka);
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
    public CheckBoxList getChkMigiJoshiMahiTeido() {
        return this.getKaradaJotai().getChkMigiJoshiMahiTeido();
    }

    @JsonIgnore
    public void  setChkMigiJoshiMahiTeido(CheckBoxList chkMigiJoshiMahiTeido) {
        this.getKaradaJotai().setChkMigiJoshiMahiTeido(chkMigiJoshiMahiTeido);
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
    public CheckBoxList getChkHidariJoshiMahiTeido() {
        return this.getKaradaJotai().getChkHidariJoshiMahiTeido();
    }

    @JsonIgnore
    public void  setChkHidariJoshiMahiTeido(CheckBoxList chkHidariJoshiMahiTeido) {
        this.getKaradaJotai().setChkHidariJoshiMahiTeido(chkHidariJoshiMahiTeido);
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
    public CheckBoxList getChkMigiKashiMahiTeido() {
        return this.getKaradaJotai().getChkMigiKashiMahiTeido();
    }

    @JsonIgnore
    public void  setChkMigiKashiMahiTeido(CheckBoxList chkMigiKashiMahiTeido) {
        this.getKaradaJotai().setChkMigiKashiMahiTeido(chkMigiKashiMahiTeido);
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
    public CheckBoxList getChkHidariKashiMahiTeido() {
        return this.getKaradaJotai().getChkHidariKashiMahiTeido();
    }

    @JsonIgnore
    public void  setChkHidariKashiMahiTeido(CheckBoxList chkHidariKashiMahiTeido) {
        this.getKaradaJotai().setChkHidariKashiMahiTeido(chkHidariKashiMahiTeido);
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
    public CheckBoxList getSonotaMahiTeido() {
        return this.getKaradaJotai().getSonotaMahiTeido();
    }

    @JsonIgnore
    public void  setSonotaMahiTeido(CheckBoxList SonotaMahiTeido) {
        this.getKaradaJotai().setSonotaMahiTeido(SonotaMahiTeido);
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
    public CheckBoxList getChkKinryokuTeikaTeido() {
        return this.getKaradaJotai().getChkKinryokuTeikaTeido();
    }

    @JsonIgnore
    public void  setChkKinryokuTeikaTeido(CheckBoxList chkKinryokuTeikaTeido) {
        this.getKaradaJotai().setChkKinryokuTeikaTeido(chkKinryokuTeikaTeido);
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
    public CheckBoxList getChkKansetsuKoshukuTeido() {
        return this.getKaradaJotai().getChkKansetsuKoshukuTeido();
    }

    @JsonIgnore
    public void  setChkKansetsuKoshukuTeido(CheckBoxList chkKansetsuKoshukuTeido) {
        this.getKaradaJotai().setChkKansetsuKoshukuTeido(chkKansetsuKoshukuTeido);
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
    public CheckBoxList getChkKansetsuItamiTeido() {
        return this.getKaradaJotai().getChkKansetsuItamiTeido();
    }

    @JsonIgnore
    public void  setChkKansetsuItamiTeido(CheckBoxList chkKansetsuItamiTeido) {
        this.getKaradaJotai().setChkKansetsuItamiTeido(chkKansetsuItamiTeido);
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
    public CheckBoxList getChkJokusoTeido() {
        return this.getKaradaJotai().getChkJokusoTeido();
    }

    @JsonIgnore
    public void  setChkJokusoTeido(CheckBoxList chkJokusoTeido) {
        this.getKaradaJotai().setChkJokusoTeido(chkJokusoTeido);
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
    public CheckBoxList getChkSonotaHifuShikkanTeido() {
        return this.getKaradaJotai().getChkSonotaHifuShikkanTeido();
    }

    @JsonIgnore
    public void  setChkSonotaHifuShikkanTeido(CheckBoxList chkSonotaHifuShikkanTeido) {
        this.getKaradaJotai().setChkSonotaHifuShikkanTeido(chkSonotaHifuShikkanTeido);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
