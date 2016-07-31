package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * KihonChosaInput4 のクラスファイル
 *
 * @reamsid_L DBE-3000-093 wangjie2
 */
public class KihonChosaInput4Div extends Panel implements IKihonChosaInput4Div {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    private Label ZenkaiHyojiTeiji;
    @JsonProperty("KoudoShogai")
    private KoudoShogaiDiv KoudoShogai;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnBack")
    private Button btnBack;

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
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnBack
     * @return btnBack
     */
    @JsonProperty("btnBack")
    public Button getBtnBack() {
        return btnBack;
    }

    /*
     * setbtnBack
     * @param btnBack btnBack
     */
    @JsonProperty("btnBack")
    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HiryakuDiv getHiryaku() {
        return this.getKoudoShogai().getHiryaku();
    }

    @JsonIgnore
    public void  setHiryaku(HiryakuDiv Hiryaku) {
        this.getKoudoShogai().setHiryaku(Hiryaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiryaku() {
        return this.getKoudoShogai().getHiryaku().getBtnHiryaku();
    }

    @JsonIgnore
    public void  setBtnHiryaku(ButtonDialog btnHiryaku) {
        this.getKoudoShogai().getHiryaku().setBtnHiryaku(btnHiryaku);
    }

    @JsonIgnore
    public RadioButton getRadbtnHiryaku() {
        return this.getKoudoShogai().getHiryaku().getRadbtnHiryaku();
    }

    @JsonIgnore
    public void  setRadbtnHiryaku(RadioButton radbtnHiryaku) {
        this.getKoudoShogai().getHiryaku().setRadbtnHiryaku(radbtnHiryaku);
    }

    @JsonIgnore
    public TukuriHanashiDiv getTukuriHanashi() {
        return this.getKoudoShogai().getTukuriHanashi();
    }

    @JsonIgnore
    public void  setTukuriHanashi(TukuriHanashiDiv TukuriHanashi) {
        this.getKoudoShogai().setTukuriHanashi(TukuriHanashi);
    }

    @JsonIgnore
    public ButtonDialog getBtnTukuriHanashi() {
        return this.getKoudoShogai().getTukuriHanashi().getBtnTukuriHanashi();
    }

    @JsonIgnore
    public void  setBtnTukuriHanashi(ButtonDialog btnTukuriHanashi) {
        this.getKoudoShogai().getTukuriHanashi().setBtnTukuriHanashi(btnTukuriHanashi);
    }

    @JsonIgnore
    public RadioButton getRadTukuriHanashi() {
        return this.getKoudoShogai().getTukuriHanashi().getRadTukuriHanashi();
    }

    @JsonIgnore
    public void  setRadTukuriHanashi(RadioButton radTukuriHanashi) {
        this.getKoudoShogai().getTukuriHanashi().setRadTukuriHanashi(radTukuriHanashi);
    }

    @JsonIgnore
    public KanjyoDiv getKanjyo() {
        return this.getKoudoShogai().getKanjyo();
    }

    @JsonIgnore
    public void  setKanjyo(KanjyoDiv Kanjyo) {
        this.getKoudoShogai().setKanjyo(Kanjyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnKanjyo() {
        return this.getKoudoShogai().getKanjyo().getBtnKanjyo();
    }

    @JsonIgnore
    public void  setBtnKanjyo(ButtonDialog btnKanjyo) {
        this.getKoudoShogai().getKanjyo().setBtnKanjyo(btnKanjyo);
    }

    @JsonIgnore
    public RadioButton getRadKanjyo() {
        return this.getKoudoShogai().getKanjyo().getRadKanjyo();
    }

    @JsonIgnore
    public void  setRadKanjyo(RadioButton radKanjyo) {
        this.getKoudoShogai().getKanjyo().setRadKanjyo(radKanjyo);
    }

    @JsonIgnore
    public ChuyakuDiv getChuyaku() {
        return this.getKoudoShogai().getChuyaku();
    }

    @JsonIgnore
    public void  setChuyaku(ChuyakuDiv Chuyaku) {
        this.getKoudoShogai().setChuyaku(Chuyaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnChuyaku() {
        return this.getKoudoShogai().getChuyaku().getBtnChuyaku();
    }

    @JsonIgnore
    public void  setBtnChuyaku(ButtonDialog btnChuyaku) {
        this.getKoudoShogai().getChuyaku().setBtnChuyaku(btnChuyaku);
    }

    @JsonIgnore
    public RadioButton getRadChuyaku() {
        return this.getKoudoShogai().getChuyaku().getRadChuyaku();
    }

    @JsonIgnore
    public void  setRadChuyaku(RadioButton radChuyaku) {
        this.getKoudoShogai().getChuyaku().setRadChuyaku(radChuyaku);
    }

    @JsonIgnore
    public OnajiHanashiDiv getOnajiHanashi() {
        return this.getKoudoShogai().getOnajiHanashi();
    }

    @JsonIgnore
    public void  setOnajiHanashi(OnajiHanashiDiv OnajiHanashi) {
        this.getKoudoShogai().setOnajiHanashi(OnajiHanashi);
    }

    @JsonIgnore
    public ButtonDialog getBtnOnajiHanashi() {
        return this.getKoudoShogai().getOnajiHanashi().getBtnOnajiHanashi();
    }

    @JsonIgnore
    public void  setBtnOnajiHanashi(ButtonDialog btnOnajiHanashi) {
        this.getKoudoShogai().getOnajiHanashi().setBtnOnajiHanashi(btnOnajiHanashi);
    }

    @JsonIgnore
    public RadioButton getRadOnajiHanashi() {
        return this.getKoudoShogai().getOnajiHanashi().getRadOnajiHanashi();
    }

    @JsonIgnore
    public void  setRadOnajiHanashi(RadioButton radOnajiHanashi) {
        this.getKoudoShogai().getOnajiHanashi().setRadOnajiHanashi(radOnajiHanashi);
    }

    @JsonIgnore
    public BigVoiceDiv getBigVoice() {
        return this.getKoudoShogai().getBigVoice();
    }

    @JsonIgnore
    public void  setBigVoice(BigVoiceDiv BigVoice) {
        this.getKoudoShogai().setBigVoice(BigVoice);
    }

    @JsonIgnore
    public ButtonDialog getBtnBigVoice() {
        return this.getKoudoShogai().getBigVoice().getBtnBigVoice();
    }

    @JsonIgnore
    public void  setBtnBigVoice(ButtonDialog btnBigVoice) {
        this.getKoudoShogai().getBigVoice().setBtnBigVoice(btnBigVoice);
    }

    @JsonIgnore
    public RadioButton getRadBigVoice() {
        return this.getKoudoShogai().getBigVoice().getRadBigVoice();
    }

    @JsonIgnore
    public void  setRadBigVoice(RadioButton radBigVoice) {
        this.getKoudoShogai().getBigVoice().setRadBigVoice(radBigVoice);
    }

    @JsonIgnore
    public TeikouDiv getTeikou() {
        return this.getKoudoShogai().getTeikou();
    }

    @JsonIgnore
    public void  setTeikou(TeikouDiv Teikou) {
        this.getKoudoShogai().setTeikou(Teikou);
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikou() {
        return this.getKoudoShogai().getTeikou().getBtnTeikou();
    }

    @JsonIgnore
    public void  setBtnTeikou(ButtonDialog btnTeikou) {
        this.getKoudoShogai().getTeikou().setBtnTeikou(btnTeikou);
    }

    @JsonIgnore
    public RadioButton getRadTeikou() {
        return this.getKoudoShogai().getTeikou().getRadTeikou();
    }

    @JsonIgnore
    public void  setRadTeikou(RadioButton radTeikou) {
        this.getKoudoShogai().getTeikou().setRadTeikou(radTeikou);
    }

    @JsonIgnore
    public OchitukiDiv getOchituki() {
        return this.getKoudoShogai().getOchituki();
    }

    @JsonIgnore
    public void  setOchituki(OchitukiDiv Ochituki) {
        this.getKoudoShogai().setOchituki(Ochituki);
    }

    @JsonIgnore
    public ButtonDialog getBtnOchituki() {
        return this.getKoudoShogai().getOchituki().getBtnOchituki();
    }

    @JsonIgnore
    public void  setBtnOchituki(ButtonDialog btnOchituki) {
        this.getKoudoShogai().getOchituki().setBtnOchituki(btnOchituki);
    }

    @JsonIgnore
    public RadioButton getRadOchituki() {
        return this.getKoudoShogai().getOchituki().getRadOchituki();
    }

    @JsonIgnore
    public void  setRadOchituki(RadioButton radOchituki) {
        this.getKoudoShogai().getOchituki().setRadOchituki(radOchituki);
    }

    @JsonIgnore
    public OutLonlyDiv getOutLonly() {
        return this.getKoudoShogai().getOutLonly();
    }

    @JsonIgnore
    public void  setOutLonly(OutLonlyDiv OutLonly) {
        this.getKoudoShogai().setOutLonly(OutLonly);
    }

    @JsonIgnore
    public ButtonDialog getBtnOutLonly() {
        return this.getKoudoShogai().getOutLonly().getBtnOutLonly();
    }

    @JsonIgnore
    public void  setBtnOutLonly(ButtonDialog btnOutLonly) {
        this.getKoudoShogai().getOutLonly().setBtnOutLonly(btnOutLonly);
    }

    @JsonIgnore
    public RadioButton getRadOutLonly() {
        return this.getKoudoShogai().getOutLonly().getRadOutLonly();
    }

    @JsonIgnore
    public void  setRadOutLonly(RadioButton radOutLonly) {
        this.getKoudoShogai().getOutLonly().setRadOutLonly(radOutLonly);
    }

    @JsonIgnore
    public ShushuDiv getShushu() {
        return this.getKoudoShogai().getShushu();
    }

    @JsonIgnore
    public void  setShushu(ShushuDiv Shushu) {
        this.getKoudoShogai().setShushu(Shushu);
    }

    @JsonIgnore
    public ButtonDialog getBtnShushu() {
        return this.getKoudoShogai().getShushu().getBtnShushu();
    }

    @JsonIgnore
    public void  setBtnShushu(ButtonDialog btnShushu) {
        this.getKoudoShogai().getShushu().setBtnShushu(btnShushu);
    }

    @JsonIgnore
    public RadioButton getRadShushu() {
        return this.getKoudoShogai().getShushu().getRadShushu();
    }

    @JsonIgnore
    public void  setRadShushu(RadioButton radShushu) {
        this.getKoudoShogai().getShushu().setRadShushu(radShushu);
    }

    @JsonIgnore
    public KowasuDiv getKowasu() {
        return this.getKoudoShogai().getKowasu();
    }

    @JsonIgnore
    public void  setKowasu(KowasuDiv Kowasu) {
        this.getKoudoShogai().setKowasu(Kowasu);
    }

    @JsonIgnore
    public ButtonDialog getBtnKowasu() {
        return this.getKoudoShogai().getKowasu().getBtnKowasu();
    }

    @JsonIgnore
    public void  setBtnKowasu(ButtonDialog btnKowasu) {
        this.getKoudoShogai().getKowasu().setBtnKowasu(btnKowasu);
    }

    @JsonIgnore
    public RadioButton getRadKowasu() {
        return this.getKoudoShogai().getKowasu().getRadKowasu();
    }

    @JsonIgnore
    public void  setRadKowasu(RadioButton radKowasu) {
        this.getKoudoShogai().getKowasu().setRadKowasu(radKowasu);
    }

    @JsonIgnore
    public MonoWasureDiv getMonoWasure() {
        return this.getKoudoShogai().getMonoWasure();
    }

    @JsonIgnore
    public void  setMonoWasure(MonoWasureDiv MonoWasure) {
        this.getKoudoShogai().setMonoWasure(MonoWasure);
    }

    @JsonIgnore
    public ButtonDialog getBtnMonoWasure() {
        return this.getKoudoShogai().getMonoWasure().getBtnMonoWasure();
    }

    @JsonIgnore
    public void  setBtnMonoWasure(ButtonDialog btnMonoWasure) {
        this.getKoudoShogai().getMonoWasure().setBtnMonoWasure(btnMonoWasure);
    }

    @JsonIgnore
    public RadioButton getRadMonoWasure() {
        return this.getKoudoShogai().getMonoWasure().getRadMonoWasure();
    }

    @JsonIgnore
    public void  setRadMonoWasure(RadioButton radMonoWasure) {
        this.getKoudoShogai().getMonoWasure().setRadMonoWasure(radMonoWasure);
    }

    @JsonIgnore
    public HitoriWaraiDiv getHitoriWarai() {
        return this.getKoudoShogai().getHitoriWarai();
    }

    @JsonIgnore
    public void  setHitoriWarai(HitoriWaraiDiv HitoriWarai) {
        this.getKoudoShogai().setHitoriWarai(HitoriWarai);
    }

    @JsonIgnore
    public ButtonDialog getBtnHitoriWarai() {
        return this.getKoudoShogai().getHitoriWarai().getBtnHitoriWarai();
    }

    @JsonIgnore
    public void  setBtnHitoriWarai(ButtonDialog btnHitoriWarai) {
        this.getKoudoShogai().getHitoriWarai().setBtnHitoriWarai(btnHitoriWarai);
    }

    @JsonIgnore
    public RadioButton getRadHitoriWarai() {
        return this.getKoudoShogai().getHitoriWarai().getRadHitoriWarai();
    }

    @JsonIgnore
    public void  setRadHitoriWarai(RadioButton radHitoriWarai) {
        this.getKoudoShogai().getHitoriWarai().setRadHitoriWarai(radHitoriWarai);
    }

    @JsonIgnore
    public KateKodoDiv getKateKodo() {
        return this.getKoudoShogai().getKateKodo();
    }

    @JsonIgnore
    public void  setKateKodo(KateKodoDiv KateKodo) {
        this.getKoudoShogai().setKateKodo(KateKodo);
    }

    @JsonIgnore
    public ButtonDialog getBtnKateKodo() {
        return this.getKoudoShogai().getKateKodo().getBtnKateKodo();
    }

    @JsonIgnore
    public void  setBtnKateKodo(ButtonDialog btnKateKodo) {
        this.getKoudoShogai().getKateKodo().setBtnKateKodo(btnKateKodo);
    }

    @JsonIgnore
    public RadioButton getRadKateKodo() {
        return this.getKoudoShogai().getKateKodo().getRadKateKodo();
    }

    @JsonIgnore
    public void  setRadKateKodo(RadioButton radKateKodo) {
        this.getKoudoShogai().getKateKodo().setRadKateKodo(radKateKodo);
    }

    @JsonIgnore
    public MatomeNaiDiv getMatomeNai() {
        return this.getKoudoShogai().getMatomeNai();
    }

    @JsonIgnore
    public void  setMatomeNai(MatomeNaiDiv MatomeNai) {
        this.getKoudoShogai().setMatomeNai(MatomeNai);
    }

    @JsonIgnore
    public ButtonDialog getBtnMatomeNai() {
        return this.getKoudoShogai().getMatomeNai().getBtnMatomeNai();
    }

    @JsonIgnore
    public void  setBtnMatomeNai(ButtonDialog btnMatomeNai) {
        this.getKoudoShogai().getMatomeNai().setBtnMatomeNai(btnMatomeNai);
    }

    @JsonIgnore
    public RadioButton getRadMatomeNai() {
        return this.getKoudoShogai().getMatomeNai().getRadMatomeNai();
    }

    @JsonIgnore
    public void  setRadMatomeNai(RadioButton radMatomeNai) {
        this.getKoudoShogai().getMatomeNai().setRadMatomeNai(radMatomeNai);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        KihonChosaInputHandler4 handler = new KihonChosaInputHandler4(this);
        handler.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
    }

}
