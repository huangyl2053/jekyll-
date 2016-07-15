package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4;
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

/**
 * KoudoShogai のクラスファイル
 *
 * @author 自動生成
 */
public class KoudoShogaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Hiryaku")
    private HiryakuDiv Hiryaku;
    @JsonProperty("TukuriHanashi")
    private TukuriHanashiDiv TukuriHanashi;
    @JsonProperty("Kanjyo")
    private KanjyoDiv Kanjyo;
    @JsonProperty("Chuyaku")
    private ChuyakuDiv Chuyaku;
    @JsonProperty("OnajiHanashi")
    private OnajiHanashiDiv OnajiHanashi;
    @JsonProperty("BigVoice")
    private BigVoiceDiv BigVoice;
    @JsonProperty("Teikou")
    private TeikouDiv Teikou;
    @JsonProperty("Ochituki")
    private OchitukiDiv Ochituki;
    @JsonProperty("OutLonly")
    private OutLonlyDiv OutLonly;
    @JsonProperty("Shushu")
    private ShushuDiv Shushu;
    @JsonProperty("Kowasu")
    private KowasuDiv Kowasu;
    @JsonProperty("MonoWasure")
    private MonoWasureDiv MonoWasure;
    @JsonProperty("HitoriWarai")
    private HitoriWaraiDiv HitoriWarai;
    @JsonProperty("KateKodo")
    private KateKodoDiv KateKodo;
    @JsonProperty("MatomeNai")
    private MatomeNaiDiv MatomeNai;
    @JsonProperty("shinseishoKanriNo")
    private RString shinseishoKanriNo;
    @JsonProperty("recordNumber")
    private RString recordNumber;
    @JsonProperty("ninteichosaTokkijikoNoList")
    private RString ninteichosaTokkijikoNoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHiryaku
     * @return Hiryaku
     */
    @JsonProperty("Hiryaku")
    public HiryakuDiv getHiryaku() {
        return Hiryaku;
    }

    /*
     * setHiryaku
     * @param Hiryaku Hiryaku
     */
    @JsonProperty("Hiryaku")
    public void setHiryaku(HiryakuDiv Hiryaku) {
        this.Hiryaku = Hiryaku;
    }

    /*
     * getTukuriHanashi
     * @return TukuriHanashi
     */
    @JsonProperty("TukuriHanashi")
    public TukuriHanashiDiv getTukuriHanashi() {
        return TukuriHanashi;
    }

    /*
     * setTukuriHanashi
     * @param TukuriHanashi TukuriHanashi
     */
    @JsonProperty("TukuriHanashi")
    public void setTukuriHanashi(TukuriHanashiDiv TukuriHanashi) {
        this.TukuriHanashi = TukuriHanashi;
    }

    /*
     * getKanjyo
     * @return Kanjyo
     */
    @JsonProperty("Kanjyo")
    public KanjyoDiv getKanjyo() {
        return Kanjyo;
    }

    /*
     * setKanjyo
     * @param Kanjyo Kanjyo
     */
    @JsonProperty("Kanjyo")
    public void setKanjyo(KanjyoDiv Kanjyo) {
        this.Kanjyo = Kanjyo;
    }

    /*
     * getChuyaku
     * @return Chuyaku
     */
    @JsonProperty("Chuyaku")
    public ChuyakuDiv getChuyaku() {
        return Chuyaku;
    }

    /*
     * setChuyaku
     * @param Chuyaku Chuyaku
     */
    @JsonProperty("Chuyaku")
    public void setChuyaku(ChuyakuDiv Chuyaku) {
        this.Chuyaku = Chuyaku;
    }

    /*
     * getOnajiHanashi
     * @return OnajiHanashi
     */
    @JsonProperty("OnajiHanashi")
    public OnajiHanashiDiv getOnajiHanashi() {
        return OnajiHanashi;
    }

    /*
     * setOnajiHanashi
     * @param OnajiHanashi OnajiHanashi
     */
    @JsonProperty("OnajiHanashi")
    public void setOnajiHanashi(OnajiHanashiDiv OnajiHanashi) {
        this.OnajiHanashi = OnajiHanashi;
    }

    /*
     * getBigVoice
     * @return BigVoice
     */
    @JsonProperty("BigVoice")
    public BigVoiceDiv getBigVoice() {
        return BigVoice;
    }

    /*
     * setBigVoice
     * @param BigVoice BigVoice
     */
    @JsonProperty("BigVoice")
    public void setBigVoice(BigVoiceDiv BigVoice) {
        this.BigVoice = BigVoice;
    }

    /*
     * getTeikou
     * @return Teikou
     */
    @JsonProperty("Teikou")
    public TeikouDiv getTeikou() {
        return Teikou;
    }

    /*
     * setTeikou
     * @param Teikou Teikou
     */
    @JsonProperty("Teikou")
    public void setTeikou(TeikouDiv Teikou) {
        this.Teikou = Teikou;
    }

    /*
     * getOchituki
     * @return Ochituki
     */
    @JsonProperty("Ochituki")
    public OchitukiDiv getOchituki() {
        return Ochituki;
    }

    /*
     * setOchituki
     * @param Ochituki Ochituki
     */
    @JsonProperty("Ochituki")
    public void setOchituki(OchitukiDiv Ochituki) {
        this.Ochituki = Ochituki;
    }

    /*
     * getOutLonly
     * @return OutLonly
     */
    @JsonProperty("OutLonly")
    public OutLonlyDiv getOutLonly() {
        return OutLonly;
    }

    /*
     * setOutLonly
     * @param OutLonly OutLonly
     */
    @JsonProperty("OutLonly")
    public void setOutLonly(OutLonlyDiv OutLonly) {
        this.OutLonly = OutLonly;
    }

    /*
     * getShushu
     * @return Shushu
     */
    @JsonProperty("Shushu")
    public ShushuDiv getShushu() {
        return Shushu;
    }

    /*
     * setShushu
     * @param Shushu Shushu
     */
    @JsonProperty("Shushu")
    public void setShushu(ShushuDiv Shushu) {
        this.Shushu = Shushu;
    }

    /*
     * getKowasu
     * @return Kowasu
     */
    @JsonProperty("Kowasu")
    public KowasuDiv getKowasu() {
        return Kowasu;
    }

    /*
     * setKowasu
     * @param Kowasu Kowasu
     */
    @JsonProperty("Kowasu")
    public void setKowasu(KowasuDiv Kowasu) {
        this.Kowasu = Kowasu;
    }

    /*
     * getMonoWasure
     * @return MonoWasure
     */
    @JsonProperty("MonoWasure")
    public MonoWasureDiv getMonoWasure() {
        return MonoWasure;
    }

    /*
     * setMonoWasure
     * @param MonoWasure MonoWasure
     */
    @JsonProperty("MonoWasure")
    public void setMonoWasure(MonoWasureDiv MonoWasure) {
        this.MonoWasure = MonoWasure;
    }

    /*
     * getHitoriWarai
     * @return HitoriWarai
     */
    @JsonProperty("HitoriWarai")
    public HitoriWaraiDiv getHitoriWarai() {
        return HitoriWarai;
    }

    /*
     * setHitoriWarai
     * @param HitoriWarai HitoriWarai
     */
    @JsonProperty("HitoriWarai")
    public void setHitoriWarai(HitoriWaraiDiv HitoriWarai) {
        this.HitoriWarai = HitoriWarai;
    }

    /*
     * getKateKodo
     * @return KateKodo
     */
    @JsonProperty("KateKodo")
    public KateKodoDiv getKateKodo() {
        return KateKodo;
    }

    /*
     * setKateKodo
     * @param KateKodo KateKodo
     */
    @JsonProperty("KateKodo")
    public void setKateKodo(KateKodoDiv KateKodo) {
        this.KateKodo = KateKodo;
    }

    /*
     * getMatomeNai
     * @return MatomeNai
     */
    @JsonProperty("MatomeNai")
    public MatomeNaiDiv getMatomeNai() {
        return MatomeNai;
    }

    /*
     * setMatomeNai
     * @param MatomeNai MatomeNai
     */
    @JsonProperty("MatomeNai")
    public void setMatomeNai(MatomeNaiDiv MatomeNai) {
        this.MatomeNai = MatomeNai;
    }

    /*
     * getshinseishoKanriNo
     * @return shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /*
     * setshinseishoKanriNo
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /*
     * getrecordNumber
     * @return recordNumber
     */
    @JsonProperty("recordNumber")
    public RString getRecordNumber() {
        return recordNumber;
    }

    /*
     * setrecordNumber
     * @param recordNumber recordNumber
     */
    @JsonProperty("recordNumber")
    public void setRecordNumber(RString recordNumber) {
        this.recordNumber = recordNumber;
    }

    /*
     * getninteichosaTokkijikoNoList
     * @return ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public RString getNinteichosaTokkijikoNoList() {
        return ninteichosaTokkijikoNoList;
    }

    /*
     * setninteichosaTokkijikoNoList
     * @param ninteichosaTokkijikoNoList ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public void setNinteichosaTokkijikoNoList(RString ninteichosaTokkijikoNoList) {
        this.ninteichosaTokkijikoNoList = ninteichosaTokkijikoNoList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnHiryaku() {
        return this.getHiryaku().getBtnHiryaku();
    }

    @JsonIgnore
    public void  setBtnHiryaku(ButtonDialog btnHiryaku) {
        this.getHiryaku().setBtnHiryaku(btnHiryaku);
    }

    @JsonIgnore
    public RadioButton getRadbtnHiryaku() {
        return this.getHiryaku().getRadbtnHiryaku();
    }

    @JsonIgnore
    public void  setRadbtnHiryaku(RadioButton radbtnHiryaku) {
        this.getHiryaku().setRadbtnHiryaku(radbtnHiryaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnTukuriHanashi() {
        return this.getTukuriHanashi().getBtnTukuriHanashi();
    }

    @JsonIgnore
    public void  setBtnTukuriHanashi(ButtonDialog btnTukuriHanashi) {
        this.getTukuriHanashi().setBtnTukuriHanashi(btnTukuriHanashi);
    }

    @JsonIgnore
    public RadioButton getRadTukuriHanashi() {
        return this.getTukuriHanashi().getRadTukuriHanashi();
    }

    @JsonIgnore
    public void  setRadTukuriHanashi(RadioButton radTukuriHanashi) {
        this.getTukuriHanashi().setRadTukuriHanashi(radTukuriHanashi);
    }

    @JsonIgnore
    public ButtonDialog getBtnKanjyo() {
        return this.getKanjyo().getBtnKanjyo();
    }

    @JsonIgnore
    public void  setBtnKanjyo(ButtonDialog btnKanjyo) {
        this.getKanjyo().setBtnKanjyo(btnKanjyo);
    }

    @JsonIgnore
    public RadioButton getRadKanjyo() {
        return this.getKanjyo().getRadKanjyo();
    }

    @JsonIgnore
    public void  setRadKanjyo(RadioButton radKanjyo) {
        this.getKanjyo().setRadKanjyo(radKanjyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnChuyaku() {
        return this.getChuyaku().getBtnChuyaku();
    }

    @JsonIgnore
    public void  setBtnChuyaku(ButtonDialog btnChuyaku) {
        this.getChuyaku().setBtnChuyaku(btnChuyaku);
    }

    @JsonIgnore
    public RadioButton getRadChuyaku() {
        return this.getChuyaku().getRadChuyaku();
    }

    @JsonIgnore
    public void  setRadChuyaku(RadioButton radChuyaku) {
        this.getChuyaku().setRadChuyaku(radChuyaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnOnajiHanashi() {
        return this.getOnajiHanashi().getBtnOnajiHanashi();
    }

    @JsonIgnore
    public void  setBtnOnajiHanashi(ButtonDialog btnOnajiHanashi) {
        this.getOnajiHanashi().setBtnOnajiHanashi(btnOnajiHanashi);
    }

    @JsonIgnore
    public RadioButton getRadOnajiHanashi() {
        return this.getOnajiHanashi().getRadOnajiHanashi();
    }

    @JsonIgnore
    public void  setRadOnajiHanashi(RadioButton radOnajiHanashi) {
        this.getOnajiHanashi().setRadOnajiHanashi(radOnajiHanashi);
    }

    @JsonIgnore
    public ButtonDialog getBtnBigVoice() {
        return this.getBigVoice().getBtnBigVoice();
    }

    @JsonIgnore
    public void  setBtnBigVoice(ButtonDialog btnBigVoice) {
        this.getBigVoice().setBtnBigVoice(btnBigVoice);
    }

    @JsonIgnore
    public RadioButton getRadBigVoice() {
        return this.getBigVoice().getRadBigVoice();
    }

    @JsonIgnore
    public void  setRadBigVoice(RadioButton radBigVoice) {
        this.getBigVoice().setRadBigVoice(radBigVoice);
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikou() {
        return this.getTeikou().getBtnTeikou();
    }

    @JsonIgnore
    public void  setBtnTeikou(ButtonDialog btnTeikou) {
        this.getTeikou().setBtnTeikou(btnTeikou);
    }

    @JsonIgnore
    public RadioButton getRadTeikou() {
        return this.getTeikou().getRadTeikou();
    }

    @JsonIgnore
    public void  setRadTeikou(RadioButton radTeikou) {
        this.getTeikou().setRadTeikou(radTeikou);
    }

    @JsonIgnore
    public ButtonDialog getBtnOchituki() {
        return this.getOchituki().getBtnOchituki();
    }

    @JsonIgnore
    public void  setBtnOchituki(ButtonDialog btnOchituki) {
        this.getOchituki().setBtnOchituki(btnOchituki);
    }

    @JsonIgnore
    public RadioButton getRadOchituki() {
        return this.getOchituki().getRadOchituki();
    }

    @JsonIgnore
    public void  setRadOchituki(RadioButton radOchituki) {
        this.getOchituki().setRadOchituki(radOchituki);
    }

    @JsonIgnore
    public ButtonDialog getBtnOutLonly() {
        return this.getOutLonly().getBtnOutLonly();
    }

    @JsonIgnore
    public void  setBtnOutLonly(ButtonDialog btnOutLonly) {
        this.getOutLonly().setBtnOutLonly(btnOutLonly);
    }

    @JsonIgnore
    public RadioButton getRadOutLonly() {
        return this.getOutLonly().getRadOutLonly();
    }

    @JsonIgnore
    public void  setRadOutLonly(RadioButton radOutLonly) {
        this.getOutLonly().setRadOutLonly(radOutLonly);
    }

    @JsonIgnore
    public ButtonDialog getBtnShushu() {
        return this.getShushu().getBtnShushu();
    }

    @JsonIgnore
    public void  setBtnShushu(ButtonDialog btnShushu) {
        this.getShushu().setBtnShushu(btnShushu);
    }

    @JsonIgnore
    public RadioButton getRadShushu() {
        return this.getShushu().getRadShushu();
    }

    @JsonIgnore
    public void  setRadShushu(RadioButton radShushu) {
        this.getShushu().setRadShushu(radShushu);
    }

    @JsonIgnore
    public ButtonDialog getBtnKowasu() {
        return this.getKowasu().getBtnKowasu();
    }

    @JsonIgnore
    public void  setBtnKowasu(ButtonDialog btnKowasu) {
        this.getKowasu().setBtnKowasu(btnKowasu);
    }

    @JsonIgnore
    public RadioButton getRadKowasu() {
        return this.getKowasu().getRadKowasu();
    }

    @JsonIgnore
    public void  setRadKowasu(RadioButton radKowasu) {
        this.getKowasu().setRadKowasu(radKowasu);
    }

    @JsonIgnore
    public ButtonDialog getBtnMonoWasure() {
        return this.getMonoWasure().getBtnMonoWasure();
    }

    @JsonIgnore
    public void  setBtnMonoWasure(ButtonDialog btnMonoWasure) {
        this.getMonoWasure().setBtnMonoWasure(btnMonoWasure);
    }

    @JsonIgnore
    public RadioButton getRadMonoWasure() {
        return this.getMonoWasure().getRadMonoWasure();
    }

    @JsonIgnore
    public void  setRadMonoWasure(RadioButton radMonoWasure) {
        this.getMonoWasure().setRadMonoWasure(radMonoWasure);
    }

    @JsonIgnore
    public ButtonDialog getBtnHitoriWarai() {
        return this.getHitoriWarai().getBtnHitoriWarai();
    }

    @JsonIgnore
    public void  setBtnHitoriWarai(ButtonDialog btnHitoriWarai) {
        this.getHitoriWarai().setBtnHitoriWarai(btnHitoriWarai);
    }

    @JsonIgnore
    public RadioButton getRadHitoriWarai() {
        return this.getHitoriWarai().getRadHitoriWarai();
    }

    @JsonIgnore
    public void  setRadHitoriWarai(RadioButton radHitoriWarai) {
        this.getHitoriWarai().setRadHitoriWarai(radHitoriWarai);
    }

    @JsonIgnore
    public ButtonDialog getBtnKateKodo() {
        return this.getKateKodo().getBtnKateKodo();
    }

    @JsonIgnore
    public void  setBtnKateKodo(ButtonDialog btnKateKodo) {
        this.getKateKodo().setBtnKateKodo(btnKateKodo);
    }

    @JsonIgnore
    public RadioButton getRadKateKodo() {
        return this.getKateKodo().getRadKateKodo();
    }

    @JsonIgnore
    public void  setRadKateKodo(RadioButton radKateKodo) {
        this.getKateKodo().setRadKateKodo(radKateKodo);
    }

    @JsonIgnore
    public ButtonDialog getBtnMatomeNai() {
        return this.getMatomeNai().getBtnMatomeNai();
    }

    @JsonIgnore
    public void  setBtnMatomeNai(ButtonDialog btnMatomeNai) {
        this.getMatomeNai().setBtnMatomeNai(btnMatomeNai);
    }

    @JsonIgnore
    public RadioButton getRadMatomeNai() {
        return this.getMatomeNai().getRadMatomeNai();
    }

    @JsonIgnore
    public void  setRadMatomeNai(RadioButton radMatomeNai) {
        this.getMatomeNai().setRadMatomeNai(radMatomeNai);
    }

    // </editor-fold>
}
