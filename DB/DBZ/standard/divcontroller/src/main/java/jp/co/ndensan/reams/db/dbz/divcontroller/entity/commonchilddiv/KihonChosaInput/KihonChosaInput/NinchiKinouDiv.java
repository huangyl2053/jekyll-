package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinchiKinou のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinchiKinouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IshiDentatsu")
    private IshiDentatsuDiv IshiDentatsu;
    @JsonProperty("Nikka")
    private NikkaDiv Nikka;
    @JsonProperty("Info")
    private InfoDiv Info;
    @JsonProperty("DankiKioku")
    private DankiKiokuDiv DankiKioku;
    @JsonProperty("NameInfo")
    private NameInfoDiv NameInfo;
    @JsonProperty("Kisetsu")
    private KisetsuDiv Kisetsu;
    @JsonProperty("Basho")
    private BashoDiv Basho;
    @JsonProperty("Haikai")
    private HaikaiDiv Haikai;
    @JsonProperty("Modoru")
    private ModoruDiv Modoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIshiDentatsu
     * @return IshiDentatsu
     */
    @JsonProperty("IshiDentatsu")
    public IshiDentatsuDiv getIshiDentatsu() {
        return IshiDentatsu;
    }

    /*
     * setIshiDentatsu
     * @param IshiDentatsu IshiDentatsu
     */
    @JsonProperty("IshiDentatsu")
    public void setIshiDentatsu(IshiDentatsuDiv IshiDentatsu) {
        this.IshiDentatsu = IshiDentatsu;
    }

    /*
     * getNikka
     * @return Nikka
     */
    @JsonProperty("Nikka")
    public NikkaDiv getNikka() {
        return Nikka;
    }

    /*
     * setNikka
     * @param Nikka Nikka
     */
    @JsonProperty("Nikka")
    public void setNikka(NikkaDiv Nikka) {
        this.Nikka = Nikka;
    }

    /*
     * getInfo
     * @return Info
     */
    @JsonProperty("Info")
    public InfoDiv getInfo() {
        return Info;
    }

    /*
     * setInfo
     * @param Info Info
     */
    @JsonProperty("Info")
    public void setInfo(InfoDiv Info) {
        this.Info = Info;
    }

    /*
     * getDankiKioku
     * @return DankiKioku
     */
    @JsonProperty("DankiKioku")
    public DankiKiokuDiv getDankiKioku() {
        return DankiKioku;
    }

    /*
     * setDankiKioku
     * @param DankiKioku DankiKioku
     */
    @JsonProperty("DankiKioku")
    public void setDankiKioku(DankiKiokuDiv DankiKioku) {
        this.DankiKioku = DankiKioku;
    }

    /*
     * getNameInfo
     * @return NameInfo
     */
    @JsonProperty("NameInfo")
    public NameInfoDiv getNameInfo() {
        return NameInfo;
    }

    /*
     * setNameInfo
     * @param NameInfo NameInfo
     */
    @JsonProperty("NameInfo")
    public void setNameInfo(NameInfoDiv NameInfo) {
        this.NameInfo = NameInfo;
    }

    /*
     * getKisetsu
     * @return Kisetsu
     */
    @JsonProperty("Kisetsu")
    public KisetsuDiv getKisetsu() {
        return Kisetsu;
    }

    /*
     * setKisetsu
     * @param Kisetsu Kisetsu
     */
    @JsonProperty("Kisetsu")
    public void setKisetsu(KisetsuDiv Kisetsu) {
        this.Kisetsu = Kisetsu;
    }

    /*
     * getBasho
     * @return Basho
     */
    @JsonProperty("Basho")
    public BashoDiv getBasho() {
        return Basho;
    }

    /*
     * setBasho
     * @param Basho Basho
     */
    @JsonProperty("Basho")
    public void setBasho(BashoDiv Basho) {
        this.Basho = Basho;
    }

    /*
     * getHaikai
     * @return Haikai
     */
    @JsonProperty("Haikai")
    public HaikaiDiv getHaikai() {
        return Haikai;
    }

    /*
     * setHaikai
     * @param Haikai Haikai
     */
    @JsonProperty("Haikai")
    public void setHaikai(HaikaiDiv Haikai) {
        this.Haikai = Haikai;
    }

    /*
     * getModoru
     * @return Modoru
     */
    @JsonProperty("Modoru")
    public ModoruDiv getModoru() {
        return Modoru;
    }

    /*
     * setModoru
     * @param Modoru Modoru
     */
    @JsonProperty("Modoru")
    public void setModoru(ModoruDiv Modoru) {
        this.Modoru = Modoru;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnIshiDentatsu() {
        return this.getIshiDentatsu().getBtnIshiDentatsu();
    }

    @JsonIgnore
    public void  setBtnIshiDentatsu(Button btnIshiDentatsu) {
        this.getIshiDentatsu().setBtnIshiDentatsu(btnIshiDentatsu);
    }

    @JsonIgnore
    public RadioButton getRadIshiDentatsu() {
        return this.getIshiDentatsu().getRadIshiDentatsu();
    }

    @JsonIgnore
    public void  setRadIshiDentatsu(RadioButton radIshiDentatsu) {
        this.getIshiDentatsu().setRadIshiDentatsu(radIshiDentatsu);
    }

    @JsonIgnore
    public Button getBtnNikka() {
        return this.getNikka().getBtnNikka();
    }

    @JsonIgnore
    public void  setBtnNikka(Button btnNikka) {
        this.getNikka().setBtnNikka(btnNikka);
    }

    @JsonIgnore
    public RadioButton getRadNikka() {
        return this.getNikka().getRadNikka();
    }

    @JsonIgnore
    public void  setRadNikka(RadioButton radNikka) {
        this.getNikka().setRadNikka(radNikka);
    }

    @JsonIgnore
    public Button getBtnInfo() {
        return this.getInfo().getBtnInfo();
    }

    @JsonIgnore
    public void  setBtnInfo(Button btnInfo) {
        this.getInfo().setBtnInfo(btnInfo);
    }

    @JsonIgnore
    public RadioButton getRadInfo() {
        return this.getInfo().getRadInfo();
    }

    @JsonIgnore
    public void  setRadInfo(RadioButton radInfo) {
        this.getInfo().setRadInfo(radInfo);
    }

    @JsonIgnore
    public Button getBtnDankiKioku() {
        return this.getDankiKioku().getBtnDankiKioku();
    }

    @JsonIgnore
    public void  setBtnDankiKioku(Button btnDankiKioku) {
        this.getDankiKioku().setBtnDankiKioku(btnDankiKioku);
    }

    @JsonIgnore
    public RadioButton getRadDankiKioku() {
        return this.getDankiKioku().getRadDankiKioku();
    }

    @JsonIgnore
    public void  setRadDankiKioku(RadioButton radDankiKioku) {
        this.getDankiKioku().setRadDankiKioku(radDankiKioku);
    }

    @JsonIgnore
    public Button getBtnNameInfo() {
        return this.getNameInfo().getBtnNameInfo();
    }

    @JsonIgnore
    public void  setBtnNameInfo(Button btnNameInfo) {
        this.getNameInfo().setBtnNameInfo(btnNameInfo);
    }

    @JsonIgnore
    public RadioButton getRadNameInfo() {
        return this.getNameInfo().getRadNameInfo();
    }

    @JsonIgnore
    public void  setRadNameInfo(RadioButton radNameInfo) {
        this.getNameInfo().setRadNameInfo(radNameInfo);
    }

    @JsonIgnore
    public Button getBtnKisetsu() {
        return this.getKisetsu().getBtnKisetsu();
    }

    @JsonIgnore
    public void  setBtnKisetsu(Button btnKisetsu) {
        this.getKisetsu().setBtnKisetsu(btnKisetsu);
    }

    @JsonIgnore
    public RadioButton getRadKisetsu() {
        return this.getKisetsu().getRadKisetsu();
    }

    @JsonIgnore
    public void  setRadKisetsu(RadioButton radKisetsu) {
        this.getKisetsu().setRadKisetsu(radKisetsu);
    }

    @JsonIgnore
    public Button getBtnBasho() {
        return this.getBasho().getBtnBasho();
    }

    @JsonIgnore
    public void  setBtnBasho(Button btnBasho) {
        this.getBasho().setBtnBasho(btnBasho);
    }

    @JsonIgnore
    public RadioButton getRadBasho() {
        return this.getBasho().getRadBasho();
    }

    @JsonIgnore
    public void  setRadBasho(RadioButton radBasho) {
        this.getBasho().setRadBasho(radBasho);
    }

    @JsonIgnore
    public Button getBtnHaikai() {
        return this.getHaikai().getBtnHaikai();
    }

    @JsonIgnore
    public void  setBtnHaikai(Button btnHaikai) {
        this.getHaikai().setBtnHaikai(btnHaikai);
    }

    @JsonIgnore
    public RadioButton getRadHaikai() {
        return this.getHaikai().getRadHaikai();
    }

    @JsonIgnore
    public void  setRadHaikai(RadioButton radHaikai) {
        this.getHaikai().setRadHaikai(radHaikai);
    }

    @JsonIgnore
    public Button getBtnModoru() {
        return this.getModoru().getBtnModoru();
    }

    @JsonIgnore
    public void  setBtnModoru(Button btnModoru) {
        this.getModoru().setBtnModoru(btnModoru);
    }

    @JsonIgnore
    public RadioButton getRadModoru() {
        return this.getModoru().getRadModoru();
    }

    @JsonIgnore
    public void  setRadModoru(RadioButton radModoru) {
        this.getModoru().setRadModoru(radModoru);
    }

    // </editor-fold>
}
