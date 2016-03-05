package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.kihonchosainput.KihonChosaInputHandler;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * KihonChosaInput のクラスファイル
 *
 * @author 自動生成
 */
public class KihonChosaInputDiv extends Panel implements IKihonChosaInputDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    private Label ZenkaiHyojiTeiji;
    @JsonProperty("DaiichigunShintaiKino")
    private DaiichigunShintaiKinoDiv DaiichigunShintaiKino;
    @JsonProperty("SeikatsuKinou")
    private SeikatsuKinouDiv SeikatsuKinou;
    @JsonProperty("NinchiKinou")
    private NinchiKinouDiv NinchiKinou;
    @JsonProperty("KoudoShogai")
    private KoudoShogaiDiv KoudoShogai;
    @JsonProperty("ShakaiSekatsu")
    private ShakaiSekatsuDiv ShakaiSekatsu;
    @JsonProperty("TokubetsuIryo")
    private TokubetsuIryoDiv TokubetsuIryo;
    @JsonProperty("Jiritsudo")
    private JiritsudoDiv Jiritsudo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getZenkaiHyojiTeiji
     * @return ZenkaiHyojiTeiji
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    public Label getZenkaiHyojiTeiji() {
        return ZenkaiHyojiTeiji;
    }

    /*
     * setZenkaiHyojiTeiji
     * @param ZenkaiHyojiTeiji ZenkaiHyojiTeiji
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    public void setZenkaiHyojiTeiji(Label ZenkaiHyojiTeiji) {
        this.ZenkaiHyojiTeiji = ZenkaiHyojiTeiji;
    }

    /*
     * getDaiichigunShintaiKino
     * @return DaiichigunShintaiKino
     */
    @JsonProperty("DaiichigunShintaiKino")
    public DaiichigunShintaiKinoDiv getDaiichigunShintaiKino() {
        return DaiichigunShintaiKino;
    }

    /*
     * setDaiichigunShintaiKino
     * @param DaiichigunShintaiKino DaiichigunShintaiKino
     */
    @JsonProperty("DaiichigunShintaiKino")
    public void setDaiichigunShintaiKino(DaiichigunShintaiKinoDiv DaiichigunShintaiKino) {
        this.DaiichigunShintaiKino = DaiichigunShintaiKino;
    }

    /*
     * getSeikatsuKinou
     * @return SeikatsuKinou
     */
    @JsonProperty("SeikatsuKinou")
    public SeikatsuKinouDiv getSeikatsuKinou() {
        return SeikatsuKinou;
    }

    /*
     * setSeikatsuKinou
     * @param SeikatsuKinou SeikatsuKinou
     */
    @JsonProperty("SeikatsuKinou")
    public void setSeikatsuKinou(SeikatsuKinouDiv SeikatsuKinou) {
        this.SeikatsuKinou = SeikatsuKinou;
    }

    /*
     * getNinchiKinou
     * @return NinchiKinou
     */
    @JsonProperty("NinchiKinou")
    public NinchiKinouDiv getNinchiKinou() {
        return NinchiKinou;
    }

    /*
     * setNinchiKinou
     * @param NinchiKinou NinchiKinou
     */
    @JsonProperty("NinchiKinou")
    public void setNinchiKinou(NinchiKinouDiv NinchiKinou) {
        this.NinchiKinou = NinchiKinou;
    }

    /*
     * getKoudoShogai
     * @return KoudoShogai
     */
    @JsonProperty("KoudoShogai")
    public KoudoShogaiDiv getKoudoShogai() {
        return KoudoShogai;
    }

    /*
     * setKoudoShogai
     * @param KoudoShogai KoudoShogai
     */
    @JsonProperty("KoudoShogai")
    public void setKoudoShogai(KoudoShogaiDiv KoudoShogai) {
        this.KoudoShogai = KoudoShogai;
    }

    /*
     * getShakaiSekatsu
     * @return ShakaiSekatsu
     */
    @JsonProperty("ShakaiSekatsu")
    public ShakaiSekatsuDiv getShakaiSekatsu() {
        return ShakaiSekatsu;
    }

    /*
     * setShakaiSekatsu
     * @param ShakaiSekatsu ShakaiSekatsu
     */
    @JsonProperty("ShakaiSekatsu")
    public void setShakaiSekatsu(ShakaiSekatsuDiv ShakaiSekatsu) {
        this.ShakaiSekatsu = ShakaiSekatsu;
    }

    /*
     * getTokubetsuIryo
     * @return TokubetsuIryo
     */
    @JsonProperty("TokubetsuIryo")
    public TokubetsuIryoDiv getTokubetsuIryo() {
        return TokubetsuIryo;
    }

    /*
     * setTokubetsuIryo
     * @param TokubetsuIryo TokubetsuIryo
     */
    @JsonProperty("TokubetsuIryo")
    public void setTokubetsuIryo(TokubetsuIryoDiv TokubetsuIryo) {
        this.TokubetsuIryo = TokubetsuIryo;
    }

    /*
     * getJiritsudo
     * @return Jiritsudo
     */
    @JsonProperty("Jiritsudo")
    public JiritsudoDiv getJiritsudo() {
        return Jiritsudo;
    }

    /*
     * setJiritsudo
     * @param Jiritsudo Jiritsudo
     */
    @JsonProperty("Jiritsudo")
    public void setJiritsudo(JiritsudoDiv Jiritsudo) {
        this.Jiritsudo = Jiritsudo;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        Dai1gun("Dai1gun"),
        Dai2gun("Dai2gun"),
        Dai3gun("Dai3gun"),
        Dai4gun("Dai4gun"),
        Dai5gun("Dai5gun"),
        Dai6gun("Dai6gun"),
        Dai7gun("Dai7gun");

        private final String name;

        private State(final String name) {
            this.name = name;
        }

        public static State getEnum(String str) {
            State[] enumArray = State.values();

            for (State enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public State getMode_State() {
        return (State) _CommonChildDivModeUtil.getMode(this.modes, State.class);
    }

    public void setMode_State(State value) {
        _CommonChildDivModeUtil.setMode(this.modes, State.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public MahiDiv getMahi() {
        return this.getDaiichigunShintaiKino().getMahi();
    }

    @JsonIgnore
    public void setMahi(MahiDiv Mahi) {
        this.getDaiichigunShintaiKino().setMahi(Mahi);
    }

    @JsonIgnore
    public ButtonDialog getBtnMahi() {
        return this.getDaiichigunShintaiKino().getMahi().getBtnMahi();
    }

    @JsonIgnore
    public void setBtnMahi(ButtonDialog btnMahi) {
        this.getDaiichigunShintaiKino().getMahi().setBtnMahi(btnMahi);
    }

    @JsonIgnore
    public CheckBoxList getChkMahi() {
        return this.getDaiichigunShintaiKino().getMahi().getChkMahi();
    }

    @JsonIgnore
    public void setChkMahi(CheckBoxList chkMahi) {
        this.getDaiichigunShintaiKino().getMahi().setChkMahi(chkMahi);
    }

    @JsonIgnore
    public KoshukuDiv getKoshuku() {
        return this.getDaiichigunShintaiKino().getKoshuku();
    }

    @JsonIgnore
    public void setKoshuku(KoshukuDiv Koshuku) {
        this.getDaiichigunShintaiKino().setKoshuku(Koshuku);
    }

    @JsonIgnore
    public ButtonDialog getBtnKoshuku() {
        return this.getDaiichigunShintaiKino().getKoshuku().getBtnKoshuku();
    }

    @JsonIgnore
    public void setBtnKoshuku(ButtonDialog btnKoshuku) {
        this.getDaiichigunShintaiKino().getKoshuku().setBtnKoshuku(btnKoshuku);
    }

    @JsonIgnore
    public CheckBoxList getChkKoshuku() {
        return this.getDaiichigunShintaiKino().getKoshuku().getChkKoshuku();
    }

    @JsonIgnore
    public void setChkKoshuku(CheckBoxList chkKoshuku) {
        this.getDaiichigunShintaiKino().getKoshuku().setChkKoshuku(chkKoshuku);
    }

    @JsonIgnore
    public NeKaeriDiv getNeKaeri() {
        return this.getDaiichigunShintaiKino().getNeKaeri();
    }

    @JsonIgnore
    public void setNeKaeri(NeKaeriDiv NeKaeri) {
        this.getDaiichigunShintaiKino().setNeKaeri(NeKaeri);
    }

    @JsonIgnore
    public ButtonDialog getBtnNeKaeri() {
        return this.getDaiichigunShintaiKino().getNeKaeri().getBtnNeKaeri();
    }

    @JsonIgnore
    public void setBtnNeKaeri(ButtonDialog btnNeKaeri) {
        this.getDaiichigunShintaiKino().getNeKaeri().setBtnNeKaeri(btnNeKaeri);
    }

    @JsonIgnore
    public RadioButton getRadNeKaeri() {
        return this.getDaiichigunShintaiKino().getNeKaeri().getRadNeKaeri();
    }

    @JsonIgnore
    public void setRadNeKaeri(RadioButton radNeKaeri) {
        this.getDaiichigunShintaiKino().getNeKaeri().setRadNeKaeri(radNeKaeri);
    }

    @JsonIgnore
    public OkiAgariDiv getOkiAgari() {
        return this.getDaiichigunShintaiKino().getOkiAgari();
    }

    @JsonIgnore
    public void setOkiAgari(OkiAgariDiv OkiAgari) {
        this.getDaiichigunShintaiKino().setOkiAgari(OkiAgari);
    }

    @JsonIgnore
    public ButtonDialog getBtnOkiAgari() {
        return this.getDaiichigunShintaiKino().getOkiAgari().getBtnOkiAgari();
    }

    @JsonIgnore
    public void setBtnOkiAgari(ButtonDialog btnOkiAgari) {
        this.getDaiichigunShintaiKino().getOkiAgari().setBtnOkiAgari(btnOkiAgari);
    }

    @JsonIgnore
    public RadioButton getRadOkiAgari() {
        return this.getDaiichigunShintaiKino().getOkiAgari().getRadOkiAgari();
    }

    @JsonIgnore
    public void setRadOkiAgari(RadioButton radOkiAgari) {
        this.getDaiichigunShintaiKino().getOkiAgari().setRadOkiAgari(radOkiAgari);
    }

    @JsonIgnore
    public ZaiDiv getZai() {
        return this.getDaiichigunShintaiKino().getZai();
    }

    @JsonIgnore
    public void setZai(ZaiDiv Zai) {
        this.getDaiichigunShintaiKino().setZai(Zai);
    }

    @JsonIgnore
    public ButtonDialog getBtnZai() {
        return this.getDaiichigunShintaiKino().getZai().getBtnZai();
    }

    @JsonIgnore
    public void setBtnZai(ButtonDialog btnZai) {
        this.getDaiichigunShintaiKino().getZai().setBtnZai(btnZai);
    }

    @JsonIgnore
    public RadioButton getRadZai() {
        return this.getDaiichigunShintaiKino().getZai().getRadZai();
    }

    @JsonIgnore
    public void setRadZai(RadioButton radZai) {
        this.getDaiichigunShintaiKino().getZai().setRadZai(radZai);
    }

    @JsonIgnore
    public RyoAshiDiv getRyoAshi() {
        return this.getDaiichigunShintaiKino().getRyoAshi();
    }

    @JsonIgnore
    public void setRyoAshi(RyoAshiDiv RyoAshi) {
        this.getDaiichigunShintaiKino().setRyoAshi(RyoAshi);
    }

    @JsonIgnore
    public ButtonDialog getBtnRyoAshi() {
        return this.getDaiichigunShintaiKino().getRyoAshi().getBtnRyoAshi();
    }

    @JsonIgnore
    public void setBtnRyoAshi(ButtonDialog btnRyoAshi) {
        this.getDaiichigunShintaiKino().getRyoAshi().setBtnRyoAshi(btnRyoAshi);
    }

    @JsonIgnore
    public RadioButton getRadRyoAshi() {
        return this.getDaiichigunShintaiKino().getRyoAshi().getRadRyoAshi();
    }

    @JsonIgnore
    public void setRadRyoAshi(RadioButton radRyoAshi) {
        this.getDaiichigunShintaiKino().getRyoAshi().setRadRyoAshi(radRyoAshi);
    }

    @JsonIgnore
    public BukoDiv getBuko() {
        return this.getDaiichigunShintaiKino().getBuko();
    }

    @JsonIgnore
    public void setBuko(BukoDiv Buko) {
        this.getDaiichigunShintaiKino().setBuko(Buko);
    }

    @JsonIgnore
    public ButtonDialog getBtnBuko() {
        return this.getDaiichigunShintaiKino().getBuko().getBtnBuko();
    }

    @JsonIgnore
    public void setBtnBuko(ButtonDialog btnBuko) {
        this.getDaiichigunShintaiKino().getBuko().setBtnBuko(btnBuko);
    }

    @JsonIgnore
    public RadioButton getRadBuko() {
        return this.getDaiichigunShintaiKino().getBuko().getRadBuko();
    }

    @JsonIgnore
    public void setRadBuko(RadioButton radBuko) {
        this.getDaiichigunShintaiKino().getBuko().setRadBuko(radBuko);
    }

    @JsonIgnore
    public TachiAgariDiv getTachiAgari() {
        return this.getDaiichigunShintaiKino().getTachiAgari();
    }

    @JsonIgnore
    public void setTachiAgari(TachiAgariDiv TachiAgari) {
        this.getDaiichigunShintaiKino().setTachiAgari(TachiAgari);
    }

    @JsonIgnore
    public ButtonDialog getBtnTachiAgari() {
        return this.getDaiichigunShintaiKino().getTachiAgari().getBtnTachiAgari();
    }

    @JsonIgnore
    public void setBtnTachiAgari(ButtonDialog btnTachiAgari) {
        this.getDaiichigunShintaiKino().getTachiAgari().setBtnTachiAgari(btnTachiAgari);
    }

    @JsonIgnore
    public RadioButton getRadTachiAgari() {
        return this.getDaiichigunShintaiKino().getTachiAgari().getRadTachiAgari();
    }

    @JsonIgnore
    public void setRadTachiAgari(RadioButton radTachiAgari) {
        this.getDaiichigunShintaiKino().getTachiAgari().setRadTachiAgari(radTachiAgari);
    }

    @JsonIgnore
    public KataAshiDiv getKataAshi() {
        return this.getDaiichigunShintaiKino().getKataAshi();
    }

    @JsonIgnore
    public void setKataAshi(KataAshiDiv KataAshi) {
        this.getDaiichigunShintaiKino().setKataAshi(KataAshi);
    }

    @JsonIgnore
    public ButtonDialog getBtnKataAshi() {
        return this.getDaiichigunShintaiKino().getKataAshi().getBtnKataAshi();
    }

    @JsonIgnore
    public void setBtnKataAshi(ButtonDialog btnKataAshi) {
        this.getDaiichigunShintaiKino().getKataAshi().setBtnKataAshi(btnKataAshi);
    }

    @JsonIgnore
    public RadioButton getRadKataAshi() {
        return this.getDaiichigunShintaiKino().getKataAshi().getRadKataAshi();
    }

    @JsonIgnore
    public void setRadKataAshi(RadioButton radKataAshi) {
        this.getDaiichigunShintaiKino().getKataAshi().setRadKataAshi(radKataAshi);
    }

    @JsonIgnore
    public SenshinDiv getSenshin() {
        return this.getDaiichigunShintaiKino().getSenshin();
    }

    @JsonIgnore
    public void setSenshin(SenshinDiv Senshin) {
        this.getDaiichigunShintaiKino().setSenshin(Senshin);
    }

    @JsonIgnore
    public ButtonDialog getBtnSenshin() {
        return this.getDaiichigunShintaiKino().getSenshin().getBtnSenshin();
    }

    @JsonIgnore
    public void setBtnSenshin(ButtonDialog btnSenshin) {
        this.getDaiichigunShintaiKino().getSenshin().setBtnSenshin(btnSenshin);
    }

    @JsonIgnore
    public RadioButton getRadSenshin() {
        return this.getDaiichigunShintaiKino().getSenshin().getRadSenshin();
    }

    @JsonIgnore
    public void setRadSenshin(RadioButton radSenshin) {
        this.getDaiichigunShintaiKino().getSenshin().setRadSenshin(radSenshin);
    }

    @JsonIgnore
    public TumeKiriDiv getTumeKiri() {
        return this.getDaiichigunShintaiKino().getTumeKiri();
    }

    @JsonIgnore
    public void setTumeKiri(TumeKiriDiv TumeKiri) {
        this.getDaiichigunShintaiKino().setTumeKiri(TumeKiri);
    }

    @JsonIgnore
    public ButtonDialog getBtnTumeKiri() {
        return this.getDaiichigunShintaiKino().getTumeKiri().getBtnTumeKiri();
    }

    @JsonIgnore
    public void setBtnTumeKiri(ButtonDialog btnTumeKiri) {
        this.getDaiichigunShintaiKino().getTumeKiri().setBtnTumeKiri(btnTumeKiri);
    }

    @JsonIgnore
    public RadioButton getRadTumeKiri() {
        return this.getDaiichigunShintaiKino().getTumeKiri().getRadTumeKiri();
    }

    @JsonIgnore
    public void setRadTumeKiri(RadioButton radTumeKiri) {
        this.getDaiichigunShintaiKino().getTumeKiri().setRadTumeKiri(radTumeKiri);
    }

    @JsonIgnore
    public ShiryokuDiv getShiryoku() {
        return this.getDaiichigunShintaiKino().getShiryoku();
    }

    @JsonIgnore
    public void setShiryoku(ShiryokuDiv Shiryoku) {
        this.getDaiichigunShintaiKino().setShiryoku(Shiryoku);
    }

    @JsonIgnore
    public ButtonDialog getBtnShiryoku() {
        return this.getDaiichigunShintaiKino().getShiryoku().getBtnShiryoku();
    }

    @JsonIgnore
    public void setBtnShiryoku(ButtonDialog btnShiryoku) {
        this.getDaiichigunShintaiKino().getShiryoku().setBtnShiryoku(btnShiryoku);
    }

    @JsonIgnore
    public RadioButton getRadShiryoku() {
        return this.getDaiichigunShintaiKino().getShiryoku().getRadShiryoku();
    }

    @JsonIgnore
    public void setRadShiryoku(RadioButton radShiryoku) {
        this.getDaiichigunShintaiKino().getShiryoku().setRadShiryoku(radShiryoku);
    }

    @JsonIgnore
    public ChoryokuDiv getChoryoku() {
        return this.getDaiichigunShintaiKino().getChoryoku();
    }

    @JsonIgnore
    public void setChoryoku(ChoryokuDiv Choryoku) {
        this.getDaiichigunShintaiKino().setChoryoku(Choryoku);
    }

    @JsonIgnore
    public ButtonDialog getBtnChoryoku() {
        return this.getDaiichigunShintaiKino().getChoryoku().getBtnChoryoku();
    }

    @JsonIgnore
    public void setBtnChoryoku(ButtonDialog btnChoryoku) {
        this.getDaiichigunShintaiKino().getChoryoku().setBtnChoryoku(btnChoryoku);
    }

    @JsonIgnore
    public RadioButton getRadChoryoku() {
        return this.getDaiichigunShintaiKino().getChoryoku().getRadChoryoku();
    }

    @JsonIgnore
    public void setRadChoryoku(RadioButton radChoryoku) {
        this.getDaiichigunShintaiKino().getChoryoku().setRadChoryoku(radChoryoku);
    }

    @JsonIgnore
    public IjyoDiv getIjyo() {
        return this.getSeikatsuKinou().getIjyo();
    }

    @JsonIgnore
    public void setIjyo(IjyoDiv Ijyo) {
        this.getSeikatsuKinou().setIjyo(Ijyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnIjyo() {
        return this.getSeikatsuKinou().getIjyo().getBtnIjyo();
    }

    @JsonIgnore
    public void setBtnIjyo(ButtonDialog btnIjyo) {
        this.getSeikatsuKinou().getIjyo().setBtnIjyo(btnIjyo);
    }

    @JsonIgnore
    public RadioButton getRadIjyo() {
        return this.getSeikatsuKinou().getIjyo().getRadIjyo();
    }

    @JsonIgnore
    public void setRadIjyo(RadioButton radIjyo) {
        this.getSeikatsuKinou().getIjyo().setRadIjyo(radIjyo);
    }

    @JsonIgnore
    public IdouDiv getIdou() {
        return this.getSeikatsuKinou().getIdou();
    }

    @JsonIgnore
    public void setIdou(IdouDiv Idou) {
        this.getSeikatsuKinou().setIdou(Idou);
    }

    @JsonIgnore
    public ButtonDialog getBtnIdou() {
        return this.getSeikatsuKinou().getIdou().getBtnIdou();
    }

    @JsonIgnore
    public void setBtnIdou(ButtonDialog btnIdou) {
        this.getSeikatsuKinou().getIdou().setBtnIdou(btnIdou);
    }

    @JsonIgnore
    public RadioButton getRadIdou() {
        return this.getSeikatsuKinou().getIdou().getRadIdou();
    }

    @JsonIgnore
    public void setRadIdou(RadioButton radIdou) {
        this.getSeikatsuKinou().getIdou().setRadIdou(radIdou);
    }

    @JsonIgnore
    public EnkaDiv getEnka() {
        return this.getSeikatsuKinou().getEnka();
    }

    @JsonIgnore
    public void setEnka(EnkaDiv Enka) {
        this.getSeikatsuKinou().setEnka(Enka);
    }

    @JsonIgnore
    public ButtonDialog getBtnEnka() {
        return this.getSeikatsuKinou().getEnka().getBtnEnka();
    }

    @JsonIgnore
    public void setBtnEnka(ButtonDialog btnEnka) {
        this.getSeikatsuKinou().getEnka().setBtnEnka(btnEnka);
    }

    @JsonIgnore
    public RadioButton getRadEnka() {
        return this.getSeikatsuKinou().getEnka().getRadEnka();
    }

    @JsonIgnore
    public void setRadEnka(RadioButton radEnka) {
        this.getSeikatsuKinou().getEnka().setRadEnka(radEnka);
    }

    @JsonIgnore
    public ShokujiDiv getShokuji() {
        return this.getSeikatsuKinou().getShokuji();
    }

    @JsonIgnore
    public void setShokuji(ShokujiDiv Shokuji) {
        this.getSeikatsuKinou().setShokuji(Shokuji);
    }

    @JsonIgnore
    public ButtonDialog getBtnShokuji() {
        return this.getSeikatsuKinou().getShokuji().getBtnShokuji();
    }

    @JsonIgnore
    public void setBtnShokuji(ButtonDialog btnShokuji) {
        this.getSeikatsuKinou().getShokuji().setBtnShokuji(btnShokuji);
    }

    @JsonIgnore
    public RadioButton getRadShokuji() {
        return this.getSeikatsuKinou().getShokuji().getRadShokuji();
    }

    @JsonIgnore
    public void setRadShokuji(RadioButton radShokuji) {
        this.getSeikatsuKinou().getShokuji().setRadShokuji(radShokuji);
    }

    @JsonIgnore
    public HainyoDiv getHainyo() {
        return this.getSeikatsuKinou().getHainyo();
    }

    @JsonIgnore
    public void setHainyo(HainyoDiv Hainyo) {
        this.getSeikatsuKinou().setHainyo(Hainyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHainyo() {
        return this.getSeikatsuKinou().getHainyo().getBtnHainyo();
    }

    @JsonIgnore
    public void setBtnHainyo(ButtonDialog btnHainyo) {
        this.getSeikatsuKinou().getHainyo().setBtnHainyo(btnHainyo);
    }

    @JsonIgnore
    public RadioButton getRadHainyo() {
        return this.getSeikatsuKinou().getHainyo().getRadHainyo();
    }

    @JsonIgnore
    public void setRadHainyo(RadioButton radHainyo) {
        this.getSeikatsuKinou().getHainyo().setRadHainyo(radHainyo);
    }

    @JsonIgnore
    public HaibenDiv getHaiben() {
        return this.getSeikatsuKinou().getHaiben();
    }

    @JsonIgnore
    public void setHaiben(HaibenDiv Haiben) {
        this.getSeikatsuKinou().setHaiben(Haiben);
    }

    @JsonIgnore
    public ButtonDialog getBtnHaiben() {
        return this.getSeikatsuKinou().getHaiben().getBtnHaiben();
    }

    @JsonIgnore
    public void setBtnHaiben(ButtonDialog btnHaiben) {
        this.getSeikatsuKinou().getHaiben().setBtnHaiben(btnHaiben);
    }

    @JsonIgnore
    public RadioButton getRadHaiben() {
        return this.getSeikatsuKinou().getHaiben().getRadHaiben();
    }

    @JsonIgnore
    public void setRadHaiben(RadioButton radHaiben) {
        this.getSeikatsuKinou().getHaiben().setRadHaiben(radHaiben);
    }

    @JsonIgnore
    public KokouDiv getKokou() {
        return this.getSeikatsuKinou().getKokou();
    }

    @JsonIgnore
    public void setKokou(KokouDiv Kokou) {
        this.getSeikatsuKinou().setKokou(Kokou);
    }

    @JsonIgnore
    public ButtonDialog getBtnKokou() {
        return this.getSeikatsuKinou().getKokou().getBtnKokou();
    }

    @JsonIgnore
    public void setBtnKokou(ButtonDialog btnKokou) {
        this.getSeikatsuKinou().getKokou().setBtnKokou(btnKokou);
    }

    @JsonIgnore
    public RadioButton getRadKokou() {
        return this.getSeikatsuKinou().getKokou().getRadKokou();
    }

    @JsonIgnore
    public void setRadKokou(RadioButton radKokou) {
        this.getSeikatsuKinou().getKokou().setRadKokou(radKokou);
    }

    @JsonIgnore
    public SenganDiv getSengan() {
        return this.getSeikatsuKinou().getSengan();
    }

    @JsonIgnore
    public void setSengan(SenganDiv Sengan) {
        this.getSeikatsuKinou().setSengan(Sengan);
    }

    @JsonIgnore
    public ButtonDialog getBtnSengan() {
        return this.getSeikatsuKinou().getSengan().getBtnSengan();
    }

    @JsonIgnore
    public void setBtnSengan(ButtonDialog btnSengan) {
        this.getSeikatsuKinou().getSengan().setBtnSengan(btnSengan);
    }

    @JsonIgnore
    public RadioButton getRadSengan() {
        return this.getSeikatsuKinou().getSengan().getRadSengan();
    }

    @JsonIgnore
    public void setRadSengan(RadioButton radSengan) {
        this.getSeikatsuKinou().getSengan().setRadSengan(radSengan);
    }

    @JsonIgnore
    public SeihatsuDiv getSeihatsu() {
        return this.getSeikatsuKinou().getSeihatsu();
    }

    @JsonIgnore
    public void setSeihatsu(SeihatsuDiv Seihatsu) {
        this.getSeikatsuKinou().setSeihatsu(Seihatsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnSeihatsu() {
        return this.getSeikatsuKinou().getSeihatsu().getBtnSeihatsu();
    }

    @JsonIgnore
    public void setBtnSeihatsu(ButtonDialog btnSeihatsu) {
        this.getSeikatsuKinou().getSeihatsu().setBtnSeihatsu(btnSeihatsu);
    }

    @JsonIgnore
    public RadioButton getRadSeihatsu() {
        return this.getSeikatsuKinou().getSeihatsu().getRadSeihatsu();
    }

    @JsonIgnore
    public void setRadSeihatsu(RadioButton radSeihatsu) {
        this.getSeikatsuKinou().getSeihatsu().setRadSeihatsu(radSeihatsu);
    }

    @JsonIgnore
    public UwagiDiv getUwagi() {
        return this.getSeikatsuKinou().getUwagi();
    }

    @JsonIgnore
    public void setUwagi(UwagiDiv Uwagi) {
        this.getSeikatsuKinou().setUwagi(Uwagi);
    }

    @JsonIgnore
    public ButtonDialog getBtnUwagi() {
        return this.getSeikatsuKinou().getUwagi().getBtnUwagi();
    }

    @JsonIgnore
    public void setBtnUwagi(ButtonDialog btnUwagi) {
        this.getSeikatsuKinou().getUwagi().setBtnUwagi(btnUwagi);
    }

    @JsonIgnore
    public RadioButton getRadUwagi() {
        return this.getSeikatsuKinou().getUwagi().getRadUwagi();
    }

    @JsonIgnore
    public void setRadUwagi(RadioButton radUwagi) {
        this.getSeikatsuKinou().getUwagi().setRadUwagi(radUwagi);
    }

    @JsonIgnore
    public ZubonDiv getZubon() {
        return this.getSeikatsuKinou().getZubon();
    }

    @JsonIgnore
    public void setZubon(ZubonDiv Zubon) {
        this.getSeikatsuKinou().setZubon(Zubon);
    }

    @JsonIgnore
    public ButtonDialog getBtnZubon() {
        return this.getSeikatsuKinou().getZubon().getBtnZubon();
    }

    @JsonIgnore
    public void setBtnZubon(ButtonDialog btnZubon) {
        this.getSeikatsuKinou().getZubon().setBtnZubon(btnZubon);
    }

    @JsonIgnore
    public RadioButton getRadZubon() {
        return this.getSeikatsuKinou().getZubon().getRadZubon();
    }

    @JsonIgnore
    public void setRadZubon(RadioButton radZubon) {
        this.getSeikatsuKinou().getZubon().setRadZubon(radZubon);
    }

    @JsonIgnore
    public HindoDiv getHindo() {
        return this.getSeikatsuKinou().getHindo();
    }

    @JsonIgnore
    public void setHindo(HindoDiv Hindo) {
        this.getSeikatsuKinou().setHindo(Hindo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHindo() {
        return this.getSeikatsuKinou().getHindo().getBtnHindo();
    }

    @JsonIgnore
    public void setBtnHindo(ButtonDialog btnHindo) {
        this.getSeikatsuKinou().getHindo().setBtnHindo(btnHindo);
    }

    @JsonIgnore
    public RadioButton getRadHindo() {
        return this.getSeikatsuKinou().getHindo().getRadHindo();
    }

    @JsonIgnore
    public void setRadHindo(RadioButton radHindo) {
        this.getSeikatsuKinou().getHindo().setRadHindo(radHindo);
    }

    @JsonIgnore
    public IshiDentatsuDiv getIshiDentatsu() {
        return this.getNinchiKinou().getIshiDentatsu();
    }

    @JsonIgnore
    public void setIshiDentatsu(IshiDentatsuDiv IshiDentatsu) {
        this.getNinchiKinou().setIshiDentatsu(IshiDentatsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnIshiDentatsu() {
        return this.getNinchiKinou().getIshiDentatsu().getBtnIshiDentatsu();
    }

    @JsonIgnore
    public void setBtnIshiDentatsu(ButtonDialog btnIshiDentatsu) {
        this.getNinchiKinou().getIshiDentatsu().setBtnIshiDentatsu(btnIshiDentatsu);
    }

    @JsonIgnore
    public RadioButton getRadIshiDentatsu() {
        return this.getNinchiKinou().getIshiDentatsu().getRadIshiDentatsu();
    }

    @JsonIgnore
    public void setRadIshiDentatsu(RadioButton radIshiDentatsu) {
        this.getNinchiKinou().getIshiDentatsu().setRadIshiDentatsu(radIshiDentatsu);
    }

    @JsonIgnore
    public NikkaDiv getNikka() {
        return this.getNinchiKinou().getNikka();
    }

    @JsonIgnore
    public void setNikka(NikkaDiv Nikka) {
        this.getNinchiKinou().setNikka(Nikka);
    }

    @JsonIgnore
    public ButtonDialog getBtnNikka() {
        return this.getNinchiKinou().getNikka().getBtnNikka();
    }

    @JsonIgnore
    public void setBtnNikka(ButtonDialog btnNikka) {
        this.getNinchiKinou().getNikka().setBtnNikka(btnNikka);
    }

    @JsonIgnore
    public RadioButton getRadNikka() {
        return this.getNinchiKinou().getNikka().getRadNikka();
    }

    @JsonIgnore
    public void setRadNikka(RadioButton radNikka) {
        this.getNinchiKinou().getNikka().setRadNikka(radNikka);
    }

    @JsonIgnore
    public InfoDiv getInfo() {
        return this.getNinchiKinou().getInfo();
    }

    @JsonIgnore
    public void setInfo(InfoDiv Info) {
        this.getNinchiKinou().setInfo(Info);
    }

    @JsonIgnore
    public ButtonDialog getBtnInfo() {
        return this.getNinchiKinou().getInfo().getBtnInfo();
    }

    @JsonIgnore
    public void setBtnInfo(ButtonDialog btnInfo) {
        this.getNinchiKinou().getInfo().setBtnInfo(btnInfo);
    }

    @JsonIgnore
    public RadioButton getRadInfo() {
        return this.getNinchiKinou().getInfo().getRadInfo();
    }

    @JsonIgnore
    public void setRadInfo(RadioButton radInfo) {
        this.getNinchiKinou().getInfo().setRadInfo(radInfo);
    }

    @JsonIgnore
    public DankiKiokuDiv getDankiKioku() {
        return this.getNinchiKinou().getDankiKioku();
    }

    @JsonIgnore
    public void setDankiKioku(DankiKiokuDiv DankiKioku) {
        this.getNinchiKinou().setDankiKioku(DankiKioku);
    }

    @JsonIgnore
    public ButtonDialog getBtnDankiKioku() {
        return this.getNinchiKinou().getDankiKioku().getBtnDankiKioku();
    }

    @JsonIgnore
    public void setBtnDankiKioku(ButtonDialog btnDankiKioku) {
        this.getNinchiKinou().getDankiKioku().setBtnDankiKioku(btnDankiKioku);
    }

    @JsonIgnore
    public RadioButton getRadDankiKioku() {
        return this.getNinchiKinou().getDankiKioku().getRadDankiKioku();
    }

    @JsonIgnore
    public void setRadDankiKioku(RadioButton radDankiKioku) {
        this.getNinchiKinou().getDankiKioku().setRadDankiKioku(radDankiKioku);
    }

    @JsonIgnore
    public NameInfoDiv getNameInfo() {
        return this.getNinchiKinou().getNameInfo();
    }

    @JsonIgnore
    public void setNameInfo(NameInfoDiv NameInfo) {
        this.getNinchiKinou().setNameInfo(NameInfo);
    }

    @JsonIgnore
    public ButtonDialog getBtnNameInfo() {
        return this.getNinchiKinou().getNameInfo().getBtnNameInfo();
    }

    @JsonIgnore
    public void setBtnNameInfo(ButtonDialog btnNameInfo) {
        this.getNinchiKinou().getNameInfo().setBtnNameInfo(btnNameInfo);
    }

    @JsonIgnore
    public RadioButton getRadNameInfo() {
        return this.getNinchiKinou().getNameInfo().getRadNameInfo();
    }

    @JsonIgnore
    public void setRadNameInfo(RadioButton radNameInfo) {
        this.getNinchiKinou().getNameInfo().setRadNameInfo(radNameInfo);
    }

    @JsonIgnore
    public KisetsuDiv getKisetsu() {
        return this.getNinchiKinou().getKisetsu();
    }

    @JsonIgnore
    public void setKisetsu(KisetsuDiv Kisetsu) {
        this.getNinchiKinou().setKisetsu(Kisetsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnKisetsu() {
        return this.getNinchiKinou().getKisetsu().getBtnKisetsu();
    }

    @JsonIgnore
    public void setBtnKisetsu(ButtonDialog btnKisetsu) {
        this.getNinchiKinou().getKisetsu().setBtnKisetsu(btnKisetsu);
    }

    @JsonIgnore
    public RadioButton getRadKisetsu() {
        return this.getNinchiKinou().getKisetsu().getRadKisetsu();
    }

    @JsonIgnore
    public void setRadKisetsu(RadioButton radKisetsu) {
        this.getNinchiKinou().getKisetsu().setRadKisetsu(radKisetsu);
    }

    @JsonIgnore
    public BashoDiv getBasho() {
        return this.getNinchiKinou().getBasho();
    }

    @JsonIgnore
    public void setBasho(BashoDiv Basho) {
        this.getNinchiKinou().setBasho(Basho);
    }

    @JsonIgnore
    public ButtonDialog getBtnBasho() {
        return this.getNinchiKinou().getBasho().getBtnBasho();
    }

    @JsonIgnore
    public void setBtnBasho(ButtonDialog btnBasho) {
        this.getNinchiKinou().getBasho().setBtnBasho(btnBasho);
    }

    @JsonIgnore
    public RadioButton getRadBasho() {
        return this.getNinchiKinou().getBasho().getRadBasho();
    }

    @JsonIgnore
    public void setRadBasho(RadioButton radBasho) {
        this.getNinchiKinou().getBasho().setRadBasho(radBasho);
    }

    @JsonIgnore
    public HaikaiDiv getHaikai() {
        return this.getNinchiKinou().getHaikai();
    }

    @JsonIgnore
    public void setHaikai(HaikaiDiv Haikai) {
        this.getNinchiKinou().setHaikai(Haikai);
    }

    @JsonIgnore
    public ButtonDialog getBtnHaikai() {
        return this.getNinchiKinou().getHaikai().getBtnHaikai();
    }

    @JsonIgnore
    public void setBtnHaikai(ButtonDialog btnHaikai) {
        this.getNinchiKinou().getHaikai().setBtnHaikai(btnHaikai);
    }

    @JsonIgnore
    public RadioButton getRadHaikai() {
        return this.getNinchiKinou().getHaikai().getRadHaikai();
    }

    @JsonIgnore
    public void setRadHaikai(RadioButton radHaikai) {
        this.getNinchiKinou().getHaikai().setRadHaikai(radHaikai);
    }

    @JsonIgnore
    public ModoruDiv getModoru() {
        return this.getNinchiKinou().getModoru();
    }

    @JsonIgnore
    public void setModoru(ModoruDiv Modoru) {
        this.getNinchiKinou().setModoru(Modoru);
    }

    @JsonIgnore
    public ButtonDialog getBtnModoru() {
        return this.getNinchiKinou().getModoru().getBtnModoru();
    }

    @JsonIgnore
    public void setBtnModoru(ButtonDialog btnModoru) {
        this.getNinchiKinou().getModoru().setBtnModoru(btnModoru);
    }

    @JsonIgnore
    public RadioButton getRadModoru() {
        return this.getNinchiKinou().getModoru().getRadModoru();
    }

    @JsonIgnore
    public void setRadModoru(RadioButton radModoru) {
        this.getNinchiKinou().getModoru().setRadModoru(radModoru);
    }

    @JsonIgnore
    public HiryakuDiv getHiryaku() {
        return this.getKoudoShogai().getHiryaku();
    }

    @JsonIgnore
    public void setHiryaku(HiryakuDiv Hiryaku) {
        this.getKoudoShogai().setHiryaku(Hiryaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiryaku() {
        return this.getKoudoShogai().getHiryaku().getBtnHiryaku();
    }

    @JsonIgnore
    public void setBtnHiryaku(ButtonDialog btnHiryaku) {
        this.getKoudoShogai().getHiryaku().setBtnHiryaku(btnHiryaku);
    }

    @JsonIgnore
    public RadioButton getRadbtnHiryaku() {
        return this.getKoudoShogai().getHiryaku().getRadbtnHiryaku();
    }

    @JsonIgnore
    public void setRadbtnHiryaku(RadioButton radbtnHiryaku) {
        this.getKoudoShogai().getHiryaku().setRadbtnHiryaku(radbtnHiryaku);
    }

    @JsonIgnore
    public TukuriHanashiDiv getTukuriHanashi() {
        return this.getKoudoShogai().getTukuriHanashi();
    }

    @JsonIgnore
    public void setTukuriHanashi(TukuriHanashiDiv TukuriHanashi) {
        this.getKoudoShogai().setTukuriHanashi(TukuriHanashi);
    }

    @JsonIgnore
    public ButtonDialog getBtnTukuriHanashi() {
        return this.getKoudoShogai().getTukuriHanashi().getBtnTukuriHanashi();
    }

    @JsonIgnore
    public void setBtnTukuriHanashi(ButtonDialog btnTukuriHanashi) {
        this.getKoudoShogai().getTukuriHanashi().setBtnTukuriHanashi(btnTukuriHanashi);
    }

    @JsonIgnore
    public RadioButton getRadTukuriHanashi() {
        return this.getKoudoShogai().getTukuriHanashi().getRadTukuriHanashi();
    }

    @JsonIgnore
    public void setRadTukuriHanashi(RadioButton radTukuriHanashi) {
        this.getKoudoShogai().getTukuriHanashi().setRadTukuriHanashi(radTukuriHanashi);
    }

    @JsonIgnore
    public KanjyoDiv getKanjyo() {
        return this.getKoudoShogai().getKanjyo();
    }

    @JsonIgnore
    public void setKanjyo(KanjyoDiv Kanjyo) {
        this.getKoudoShogai().setKanjyo(Kanjyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnKanjyo() {
        return this.getKoudoShogai().getKanjyo().getBtnKanjyo();
    }

    @JsonIgnore
    public void setBtnKanjyo(ButtonDialog btnKanjyo) {
        this.getKoudoShogai().getKanjyo().setBtnKanjyo(btnKanjyo);
    }

    @JsonIgnore
    public RadioButton getRadKanjyo() {
        return this.getKoudoShogai().getKanjyo().getRadKanjyo();
    }

    @JsonIgnore
    public void setRadKanjyo(RadioButton radKanjyo) {
        this.getKoudoShogai().getKanjyo().setRadKanjyo(radKanjyo);
    }

    @JsonIgnore
    public ChuyakuDiv getChuyaku() {
        return this.getKoudoShogai().getChuyaku();
    }

    @JsonIgnore
    public void setChuyaku(ChuyakuDiv Chuyaku) {
        this.getKoudoShogai().setChuyaku(Chuyaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnChuyaku() {
        return this.getKoudoShogai().getChuyaku().getBtnChuyaku();
    }

    @JsonIgnore
    public void setBtnChuyaku(ButtonDialog btnChuyaku) {
        this.getKoudoShogai().getChuyaku().setBtnChuyaku(btnChuyaku);
    }

    @JsonIgnore
    public RadioButton getRadChuyaku() {
        return this.getKoudoShogai().getChuyaku().getRadChuyaku();
    }

    @JsonIgnore
    public void setRadChuyaku(RadioButton radChuyaku) {
        this.getKoudoShogai().getChuyaku().setRadChuyaku(radChuyaku);
    }

    @JsonIgnore
    public OnajiHanashiDiv getOnajiHanashi() {
        return this.getKoudoShogai().getOnajiHanashi();
    }

    @JsonIgnore
    public void setOnajiHanashi(OnajiHanashiDiv OnajiHanashi) {
        this.getKoudoShogai().setOnajiHanashi(OnajiHanashi);
    }

    @JsonIgnore
    public ButtonDialog getBtnOnajiHanashi() {
        return this.getKoudoShogai().getOnajiHanashi().getBtnOnajiHanashi();
    }

    @JsonIgnore
    public void setBtnOnajiHanashi(ButtonDialog btnOnajiHanashi) {
        this.getKoudoShogai().getOnajiHanashi().setBtnOnajiHanashi(btnOnajiHanashi);
    }

    @JsonIgnore
    public RadioButton getRadOnajiHanashi() {
        return this.getKoudoShogai().getOnajiHanashi().getRadOnajiHanashi();
    }

    @JsonIgnore
    public void setRadOnajiHanashi(RadioButton radOnajiHanashi) {
        this.getKoudoShogai().getOnajiHanashi().setRadOnajiHanashi(radOnajiHanashi);
    }

    @JsonIgnore
    public BigVoiceDiv getBigVoice() {
        return this.getKoudoShogai().getBigVoice();
    }

    @JsonIgnore
    public void setBigVoice(BigVoiceDiv BigVoice) {
        this.getKoudoShogai().setBigVoice(BigVoice);
    }

    @JsonIgnore
    public ButtonDialog getBtnBigVoice() {
        return this.getKoudoShogai().getBigVoice().getBtnBigVoice();
    }

    @JsonIgnore
    public void setBtnBigVoice(ButtonDialog btnBigVoice) {
        this.getKoudoShogai().getBigVoice().setBtnBigVoice(btnBigVoice);
    }

    @JsonIgnore
    public RadioButton getRadBigVoice() {
        return this.getKoudoShogai().getBigVoice().getRadBigVoice();
    }

    @JsonIgnore
    public void setRadBigVoice(RadioButton radBigVoice) {
        this.getKoudoShogai().getBigVoice().setRadBigVoice(radBigVoice);
    }

    @JsonIgnore
    public TeikouDiv getTeikou() {
        return this.getKoudoShogai().getTeikou();
    }

    @JsonIgnore
    public void setTeikou(TeikouDiv Teikou) {
        this.getKoudoShogai().setTeikou(Teikou);
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikou() {
        return this.getKoudoShogai().getTeikou().getBtnTeikou();
    }

    @JsonIgnore
    public void setBtnTeikou(ButtonDialog btnTeikou) {
        this.getKoudoShogai().getTeikou().setBtnTeikou(btnTeikou);
    }

    @JsonIgnore
    public RadioButton getRadTeikou() {
        return this.getKoudoShogai().getTeikou().getRadTeikou();
    }

    @JsonIgnore
    public void setRadTeikou(RadioButton radTeikou) {
        this.getKoudoShogai().getTeikou().setRadTeikou(radTeikou);
    }

    @JsonIgnore
    public OchitukiDiv getOchituki() {
        return this.getKoudoShogai().getOchituki();
    }

    @JsonIgnore
    public void setOchituki(OchitukiDiv Ochituki) {
        this.getKoudoShogai().setOchituki(Ochituki);
    }

    @JsonIgnore
    public ButtonDialog getBtnOchituki() {
        return this.getKoudoShogai().getOchituki().getBtnOchituki();
    }

    @JsonIgnore
    public void setBtnOchituki(ButtonDialog btnOchituki) {
        this.getKoudoShogai().getOchituki().setBtnOchituki(btnOchituki);
    }

    @JsonIgnore
    public RadioButton getRadOchituki() {
        return this.getKoudoShogai().getOchituki().getRadOchituki();
    }

    @JsonIgnore
    public void setRadOchituki(RadioButton radOchituki) {
        this.getKoudoShogai().getOchituki().setRadOchituki(radOchituki);
    }

    @JsonIgnore
    public OutLonlyDiv getOutLonly() {
        return this.getKoudoShogai().getOutLonly();
    }

    @JsonIgnore
    public void setOutLonly(OutLonlyDiv OutLonly) {
        this.getKoudoShogai().setOutLonly(OutLonly);
    }

    @JsonIgnore
    public ButtonDialog getBtnOutLonly() {
        return this.getKoudoShogai().getOutLonly().getBtnOutLonly();
    }

    @JsonIgnore
    public void setBtnOutLonly(ButtonDialog btnOutLonly) {
        this.getKoudoShogai().getOutLonly().setBtnOutLonly(btnOutLonly);
    }

    @JsonIgnore
    public RadioButton getRadOutLonly() {
        return this.getKoudoShogai().getOutLonly().getRadOutLonly();
    }

    @JsonIgnore
    public void setRadOutLonly(RadioButton radOutLonly) {
        this.getKoudoShogai().getOutLonly().setRadOutLonly(radOutLonly);
    }

    @JsonIgnore
    public ShushuDiv getShushu() {
        return this.getKoudoShogai().getShushu();
    }

    @JsonIgnore
    public void setShushu(ShushuDiv Shushu) {
        this.getKoudoShogai().setShushu(Shushu);
    }

    @JsonIgnore
    public ButtonDialog getBtnShushu() {
        return this.getKoudoShogai().getShushu().getBtnShushu();
    }

    @JsonIgnore
    public void setBtnShushu(ButtonDialog btnShushu) {
        this.getKoudoShogai().getShushu().setBtnShushu(btnShushu);
    }

    @JsonIgnore
    public RadioButton getRadShushu() {
        return this.getKoudoShogai().getShushu().getRadShushu();
    }

    @JsonIgnore
    public void setRadShushu(RadioButton radShushu) {
        this.getKoudoShogai().getShushu().setRadShushu(radShushu);
    }

    @JsonIgnore
    public KowasuDiv getKowasu() {
        return this.getKoudoShogai().getKowasu();
    }

    @JsonIgnore
    public void setKowasu(KowasuDiv Kowasu) {
        this.getKoudoShogai().setKowasu(Kowasu);
    }

    @JsonIgnore
    public ButtonDialog getBtnKowasu() {
        return this.getKoudoShogai().getKowasu().getBtnKowasu();
    }

    @JsonIgnore
    public void setBtnKowasu(ButtonDialog btnKowasu) {
        this.getKoudoShogai().getKowasu().setBtnKowasu(btnKowasu);
    }

    @JsonIgnore
    public RadioButton getRadKowasu() {
        return this.getKoudoShogai().getKowasu().getRadKowasu();
    }

    @JsonIgnore
    public void setRadKowasu(RadioButton radKowasu) {
        this.getKoudoShogai().getKowasu().setRadKowasu(radKowasu);
    }

    @JsonIgnore
    public MonoWasureDiv getMonoWasure() {
        return this.getKoudoShogai().getMonoWasure();
    }

    @JsonIgnore
    public void setMonoWasure(MonoWasureDiv MonoWasure) {
        this.getKoudoShogai().setMonoWasure(MonoWasure);
    }

    @JsonIgnore
    public ButtonDialog getBtnMonoWasure() {
        return this.getKoudoShogai().getMonoWasure().getBtnMonoWasure();
    }

    @JsonIgnore
    public void setBtnMonoWasure(ButtonDialog btnMonoWasure) {
        this.getKoudoShogai().getMonoWasure().setBtnMonoWasure(btnMonoWasure);
    }

    @JsonIgnore
    public RadioButton getRadMonoWasure() {
        return this.getKoudoShogai().getMonoWasure().getRadMonoWasure();
    }

    @JsonIgnore
    public void setRadMonoWasure(RadioButton radMonoWasure) {
        this.getKoudoShogai().getMonoWasure().setRadMonoWasure(radMonoWasure);
    }

    @JsonIgnore
    public HitoriWaraiDiv getHitoriWarai() {
        return this.getKoudoShogai().getHitoriWarai();
    }

    @JsonIgnore
    public void setHitoriWarai(HitoriWaraiDiv HitoriWarai) {
        this.getKoudoShogai().setHitoriWarai(HitoriWarai);
    }

    @JsonIgnore
    public ButtonDialog getBtnHitoriWarai() {
        return this.getKoudoShogai().getHitoriWarai().getBtnHitoriWarai();
    }

    @JsonIgnore
    public void setBtnHitoriWarai(ButtonDialog btnHitoriWarai) {
        this.getKoudoShogai().getHitoriWarai().setBtnHitoriWarai(btnHitoriWarai);
    }

    @JsonIgnore
    public RadioButton getRadHitoriWarai() {
        return this.getKoudoShogai().getHitoriWarai().getRadHitoriWarai();
    }

    @JsonIgnore
    public void setRadHitoriWarai(RadioButton radHitoriWarai) {
        this.getKoudoShogai().getHitoriWarai().setRadHitoriWarai(radHitoriWarai);
    }

    @JsonIgnore
    public KateKodoDiv getKateKodo() {
        return this.getKoudoShogai().getKateKodo();
    }

    @JsonIgnore
    public void setKateKodo(KateKodoDiv KateKodo) {
        this.getKoudoShogai().setKateKodo(KateKodo);
    }

    @JsonIgnore
    public ButtonDialog getBtnKateKodo() {
        return this.getKoudoShogai().getKateKodo().getBtnKateKodo();
    }

    @JsonIgnore
    public void setBtnKateKodo(ButtonDialog btnKateKodo) {
        this.getKoudoShogai().getKateKodo().setBtnKateKodo(btnKateKodo);
    }

    @JsonIgnore
    public RadioButton getRadKateKodo() {
        return this.getKoudoShogai().getKateKodo().getRadKateKodo();
    }

    @JsonIgnore
    public void setRadKateKodo(RadioButton radKateKodo) {
        this.getKoudoShogai().getKateKodo().setRadKateKodo(radKateKodo);
    }

    @JsonIgnore
    public MatomeNaiDiv getMatomeNai() {
        return this.getKoudoShogai().getMatomeNai();
    }

    @JsonIgnore
    public void setMatomeNai(MatomeNaiDiv MatomeNai) {
        this.getKoudoShogai().setMatomeNai(MatomeNai);
    }

    @JsonIgnore
    public ButtonDialog getBtnMatomeNai() {
        return this.getKoudoShogai().getMatomeNai().getBtnMatomeNai();
    }

    @JsonIgnore
    public void setBtnMatomeNai(ButtonDialog btnMatomeNai) {
        this.getKoudoShogai().getMatomeNai().setBtnMatomeNai(btnMatomeNai);
    }

    @JsonIgnore
    public RadioButton getRadMatomeNai() {
        return this.getKoudoShogai().getMatomeNai().getRadMatomeNai();
    }

    @JsonIgnore
    public void setRadMatomeNai(RadioButton radMatomeNai) {
        this.getKoudoShogai().getMatomeNai().setRadMatomeNai(radMatomeNai);
    }

    @JsonIgnore
    public KusuriDiv getKusuri() {
        return this.getShakaiSekatsu().getKusuri();
    }

    @JsonIgnore
    public void setKusuri(KusuriDiv Kusuri) {
        this.getShakaiSekatsu().setKusuri(Kusuri);
    }

    @JsonIgnore
    public ButtonDialog getBtnKusuri() {
        return this.getShakaiSekatsu().getKusuri().getBtnKusuri();
    }

    @JsonIgnore
    public void setBtnKusuri(ButtonDialog btnKusuri) {
        this.getShakaiSekatsu().getKusuri().setBtnKusuri(btnKusuri);
    }

    @JsonIgnore
    public RadioButton getRadKusuri() {
        return this.getShakaiSekatsu().getKusuri().getRadKusuri();
    }

    @JsonIgnore
    public void setRadKusuri(RadioButton radKusuri) {
        this.getShakaiSekatsu().getKusuri().setRadKusuri(radKusuri);
    }

    @JsonIgnore
    public KingakuKanriDiv getKingakuKanri() {
        return this.getShakaiSekatsu().getKingakuKanri();
    }

    @JsonIgnore
    public void setKingakuKanri(KingakuKanriDiv KingakuKanri) {
        this.getShakaiSekatsu().setKingakuKanri(KingakuKanri);
    }

    @JsonIgnore
    public ButtonDialog getBtnKingakuKanri() {
        return this.getShakaiSekatsu().getKingakuKanri().getBtnKingakuKanri();
    }

    @JsonIgnore
    public void setBtnKingakuKanri(ButtonDialog btnKingakuKanri) {
        this.getShakaiSekatsu().getKingakuKanri().setBtnKingakuKanri(btnKingakuKanri);
    }

    @JsonIgnore
    public RadioButton getRadKingakuKanri() {
        return this.getShakaiSekatsu().getKingakuKanri().getRadKingakuKanri();
    }

    @JsonIgnore
    public void setRadKingakuKanri(RadioButton radKingakuKanri) {
        this.getShakaiSekatsu().getKingakuKanri().setRadKingakuKanri(radKingakuKanri);
    }

    @JsonIgnore
    public IshiKeteiDiv getIshiKetei() {
        return this.getShakaiSekatsu().getIshiKetei();
    }

    @JsonIgnore
    public void setIshiKetei(IshiKeteiDiv IshiKetei) {
        this.getShakaiSekatsu().setIshiKetei(IshiKetei);
    }

    @JsonIgnore
    public ButtonDialog getBtnIshiKetei() {
        return this.getShakaiSekatsu().getIshiKetei().getBtnIshiKetei();
    }

    @JsonIgnore
    public void setBtnIshiKetei(ButtonDialog btnIshiKetei) {
        this.getShakaiSekatsu().getIshiKetei().setBtnIshiKetei(btnIshiKetei);
    }

    @JsonIgnore
    public RadioButton getRadIshiKetei() {
        return this.getShakaiSekatsu().getIshiKetei().getRadIshiKetei();
    }

    @JsonIgnore
    public void setRadIshiKetei(RadioButton radIshiKetei) {
        this.getShakaiSekatsu().getIshiKetei().setRadIshiKetei(radIshiKetei);
    }

    @JsonIgnore
    public ShudanDiv getShudan() {
        return this.getShakaiSekatsu().getShudan();
    }

    @JsonIgnore
    public void setShudan(ShudanDiv Shudan) {
        this.getShakaiSekatsu().setShudan(Shudan);
    }

    @JsonIgnore
    public ButtonDialog getBtnShudan() {
        return this.getShakaiSekatsu().getShudan().getBtnShudan();
    }

    @JsonIgnore
    public void setBtnShudan(ButtonDialog btnShudan) {
        this.getShakaiSekatsu().getShudan().setBtnShudan(btnShudan);
    }

    @JsonIgnore
    public RadioButton getRadShudan() {
        return this.getShakaiSekatsu().getShudan().getRadShudan();
    }

    @JsonIgnore
    public void setRadShudan(RadioButton radShudan) {
        this.getShakaiSekatsu().getShudan().setRadShudan(radShudan);
    }

    @JsonIgnore
    public KaiMonoDiv getKaiMono() {
        return this.getShakaiSekatsu().getKaiMono();
    }

    @JsonIgnore
    public void setKaiMono(KaiMonoDiv KaiMono) {
        this.getShakaiSekatsu().setKaiMono(KaiMono);
    }

    @JsonIgnore
    public ButtonDialog getBtnKaiMono() {
        return this.getShakaiSekatsu().getKaiMono().getBtnKaiMono();
    }

    @JsonIgnore
    public void setBtnKaiMono(ButtonDialog btnKaiMono) {
        this.getShakaiSekatsu().getKaiMono().setBtnKaiMono(btnKaiMono);
    }

    @JsonIgnore
    public RadioButton getRadKaiMono() {
        return this.getShakaiSekatsu().getKaiMono().getRadKaiMono();
    }

    @JsonIgnore
    public void setRadKaiMono(RadioButton radKaiMono) {
        this.getShakaiSekatsu().getKaiMono().setRadKaiMono(radKaiMono);
    }

    @JsonIgnore
    public KantanChoriDiv getKantanChori() {
        return this.getShakaiSekatsu().getKantanChori();
    }

    @JsonIgnore
    public void setKantanChori(KantanChoriDiv KantanChori) {
        this.getShakaiSekatsu().setKantanChori(KantanChori);
    }

    @JsonIgnore
    public ButtonDialog getBtnKantanChori() {
        return this.getShakaiSekatsu().getKantanChori().getBtnKantanChori();
    }

    @JsonIgnore
    public void setBtnKantanChori(ButtonDialog btnKantanChori) {
        this.getShakaiSekatsu().getKantanChori().setBtnKantanChori(btnKantanChori);
    }

    @JsonIgnore
    public RadioButton getRadKantanChori() {
        return this.getShakaiSekatsu().getKantanChori().getRadKantanChori();
    }

    @JsonIgnore
    public void setRadKantanChori(RadioButton radKantanChori) {
        this.getShakaiSekatsu().getKantanChori().setRadKantanChori(radKantanChori);
    }

    @JsonIgnore
    public ShochiNaiyoDiv getShochiNaiyo() {
        return this.getTokubetsuIryo().getShochiNaiyo();
    }

    @JsonIgnore
    public void setShochiNaiyo(ShochiNaiyoDiv ShochiNaiyo) {
        this.getTokubetsuIryo().setShochiNaiyo(ShochiNaiyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnShochiNaiyo() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnShochiNaiyo();
    }

    @JsonIgnore
    public void setBtnShochiNaiyo(ButtonDialog btnShochiNaiyo) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnShochiNaiyo(btnShochiNaiyo);
    }

    @JsonIgnore
    public CheckBoxList getChkShochiNaiyo() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkShochiNaiyo();
    }

    @JsonIgnore
    public void setChkShochiNaiyo(CheckBoxList chkShochiNaiyo) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkShochiNaiyo(chkShochiNaiyo);
    }

    @JsonIgnore
    public TokiTaiouDiv getTokiTaiou() {
        return this.getTokubetsuIryo().getTokiTaiou();
    }

    @JsonIgnore
    public void setTokiTaiou(TokiTaiouDiv TokiTaiou) {
        this.getTokubetsuIryo().setTokiTaiou(TokiTaiou);
    }

    @JsonIgnore
    public ButtonDialog getBtnTokiTaiou() {
        return this.getTokubetsuIryo().getTokiTaiou().getBtnTokiTaiou();
    }

    @JsonIgnore
    public void setBtnTokiTaiou(ButtonDialog btnTokiTaiou) {
        this.getTokubetsuIryo().getTokiTaiou().setBtnTokiTaiou(btnTokiTaiou);
    }

    @JsonIgnore
    public CheckBoxList getChkTokiTaiou() {
        return this.getTokubetsuIryo().getTokiTaiou().getChkTokiTaiou();
    }

    @JsonIgnore
    public void setChkTokiTaiou(CheckBoxList chkTokiTaiou) {
        this.getTokubetsuIryo().getTokiTaiou().setChkTokiTaiou(chkTokiTaiou);
    }

    @JsonIgnore
    public ShogaiKoreishaDiv getShogaiKoreisha() {
        return this.getJiritsudo().getShogaiKoreisha();
    }

    @JsonIgnore
    public void setShogaiKoreisha(ShogaiKoreishaDiv ShogaiKoreisha) {
        this.getJiritsudo().setShogaiKoreisha(ShogaiKoreisha);
    }

    @JsonIgnore
    public ButtonDialog getBtnShogaiKoreisha() {
        return this.getJiritsudo().getShogaiKoreisha().getBtnShogaiKoreisha();
    }

    @JsonIgnore
    public void setBtnShogaiKoreisha(ButtonDialog btnShogaiKoreisha) {
        this.getJiritsudo().getShogaiKoreisha().setBtnShogaiKoreisha(btnShogaiKoreisha);
    }

    @JsonIgnore
    public RadioButton getRadShogaiKoreisha() {
        return this.getJiritsudo().getShogaiKoreisha().getRadShogaiKoreisha();
    }

    @JsonIgnore
    public void setRadShogaiKoreisha(RadioButton radShogaiKoreisha) {
        this.getJiritsudo().getShogaiKoreisha().setRadShogaiKoreisha(radShogaiKoreisha);
    }

    @JsonIgnore
    public NinchishaJiritsudoDiv getNinchishaJiritsudo() {
        return this.getJiritsudo().getNinchishaJiritsudo();
    }

    @JsonIgnore
    public void setNinchishaJiritsudo(NinchishaJiritsudoDiv NinchishaJiritsudo) {
        this.getJiritsudo().setNinchishaJiritsudo(NinchishaJiritsudo);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinchishaJiritsudo() {
        return this.getJiritsudo().getNinchishaJiritsudo().getBtnNinchishaJiritsudo();
    }

    @JsonIgnore
    public void setBtnNinchishaJiritsudo(ButtonDialog btnNinchishaJiritsudo) {
        this.getJiritsudo().getNinchishaJiritsudo().setBtnNinchishaJiritsudo(btnNinchishaJiritsudo);
    }

    @JsonIgnore
    public RadioButton getRadNinchishaJiritsudo() {
        return this.getJiritsudo().getNinchishaJiritsudo().getRadNinchishaJiritsudo();
    }

    @JsonIgnore
    public void setRadNinchishaJiritsudo(RadioButton radNinchishaJiritsudo) {
        this.getJiritsudo().getNinchishaJiritsudo().setRadNinchishaJiritsudo(radNinchishaJiritsudo);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号) {
        KihonChosaInputHandler handler = new KihonChosaInputHandler(this);
        handler.onload(申請書管理番号, 認定調査依頼履歴番号);
    }
}
