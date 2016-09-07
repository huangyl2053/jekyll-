package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * KihonChosaInput1 のクラスファイル
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class KihonChosaInput1Div extends Panel implements IKihonChosaInput1Div {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    public MahiDiv getMahi() {
        return this.getDaiichigunShintaiKino().getMahi();
    }

    @JsonIgnore
    public void  setMahi(MahiDiv Mahi) {
        this.getDaiichigunShintaiKino().setMahi(Mahi);
    }

    @JsonIgnore
    public ButtonDialog getBtnMahi() {
        return this.getDaiichigunShintaiKino().getMahi().getBtnMahi();
    }

    @JsonIgnore
    public void  setBtnMahi(ButtonDialog btnMahi) {
        this.getDaiichigunShintaiKino().getMahi().setBtnMahi(btnMahi);
    }

    @JsonIgnore
    public CheckBoxList getChkMahi() {
        return this.getDaiichigunShintaiKino().getMahi().getChkMahi();
    }

    @JsonIgnore
    public void  setChkMahi(CheckBoxList chkMahi) {
        this.getDaiichigunShintaiKino().getMahi().setChkMahi(chkMahi);
    }

    @JsonIgnore
    public KoshukuDiv getKoshuku() {
        return this.getDaiichigunShintaiKino().getKoshuku();
    }

    @JsonIgnore
    public void  setKoshuku(KoshukuDiv Koshuku) {
        this.getDaiichigunShintaiKino().setKoshuku(Koshuku);
    }

    @JsonIgnore
    public ButtonDialog getBtnKoshuku() {
        return this.getDaiichigunShintaiKino().getKoshuku().getBtnKoshuku();
    }

    @JsonIgnore
    public void  setBtnKoshuku(ButtonDialog btnKoshuku) {
        this.getDaiichigunShintaiKino().getKoshuku().setBtnKoshuku(btnKoshuku);
    }

    @JsonIgnore
    public CheckBoxList getChkKoshuku() {
        return this.getDaiichigunShintaiKino().getKoshuku().getChkKoshuku();
    }

    @JsonIgnore
    public void  setChkKoshuku(CheckBoxList chkKoshuku) {
        this.getDaiichigunShintaiKino().getKoshuku().setChkKoshuku(chkKoshuku);
    }

    @JsonIgnore
    public NeKaeriDiv getNeKaeri() {
        return this.getDaiichigunShintaiKino().getNeKaeri();
    }

    @JsonIgnore
    public void  setNeKaeri(NeKaeriDiv NeKaeri) {
        this.getDaiichigunShintaiKino().setNeKaeri(NeKaeri);
    }

    @JsonIgnore
    public ButtonDialog getBtnNeKaeri() {
        return this.getDaiichigunShintaiKino().getNeKaeri().getBtnNeKaeri();
    }

    @JsonIgnore
    public void  setBtnNeKaeri(ButtonDialog btnNeKaeri) {
        this.getDaiichigunShintaiKino().getNeKaeri().setBtnNeKaeri(btnNeKaeri);
    }

    @JsonIgnore
    public RadioButton getRadNeKaeri() {
        return this.getDaiichigunShintaiKino().getNeKaeri().getRadNeKaeri();
    }

    @JsonIgnore
    public void  setRadNeKaeri(RadioButton radNeKaeri) {
        this.getDaiichigunShintaiKino().getNeKaeri().setRadNeKaeri(radNeKaeri);
    }

    @JsonIgnore
    public OkiAgariDiv getOkiAgari() {
        return this.getDaiichigunShintaiKino().getOkiAgari();
    }

    @JsonIgnore
    public void  setOkiAgari(OkiAgariDiv OkiAgari) {
        this.getDaiichigunShintaiKino().setOkiAgari(OkiAgari);
    }

    @JsonIgnore
    public ButtonDialog getBtnOkiAgari() {
        return this.getDaiichigunShintaiKino().getOkiAgari().getBtnOkiAgari();
    }

    @JsonIgnore
    public void  setBtnOkiAgari(ButtonDialog btnOkiAgari) {
        this.getDaiichigunShintaiKino().getOkiAgari().setBtnOkiAgari(btnOkiAgari);
    }

    @JsonIgnore
    public RadioButton getRadOkiAgari() {
        return this.getDaiichigunShintaiKino().getOkiAgari().getRadOkiAgari();
    }

    @JsonIgnore
    public void  setRadOkiAgari(RadioButton radOkiAgari) {
        this.getDaiichigunShintaiKino().getOkiAgari().setRadOkiAgari(radOkiAgari);
    }

    @JsonIgnore
    public ZaiDiv getZai() {
        return this.getDaiichigunShintaiKino().getZai();
    }

    @JsonIgnore
    public void  setZai(ZaiDiv Zai) {
        this.getDaiichigunShintaiKino().setZai(Zai);
    }

    @JsonIgnore
    public ButtonDialog getBtnZai() {
        return this.getDaiichigunShintaiKino().getZai().getBtnZai();
    }

    @JsonIgnore
    public void  setBtnZai(ButtonDialog btnZai) {
        this.getDaiichigunShintaiKino().getZai().setBtnZai(btnZai);
    }

    @JsonIgnore
    public RadioButton getRadZai() {
        return this.getDaiichigunShintaiKino().getZai().getRadZai();
    }

    @JsonIgnore
    public void  setRadZai(RadioButton radZai) {
        this.getDaiichigunShintaiKino().getZai().setRadZai(radZai);
    }

    @JsonIgnore
    public RyoAshiDiv getRyoAshi() {
        return this.getDaiichigunShintaiKino().getRyoAshi();
    }

    @JsonIgnore
    public void  setRyoAshi(RyoAshiDiv RyoAshi) {
        this.getDaiichigunShintaiKino().setRyoAshi(RyoAshi);
    }

    @JsonIgnore
    public ButtonDialog getBtnRyoAshi() {
        return this.getDaiichigunShintaiKino().getRyoAshi().getBtnRyoAshi();
    }

    @JsonIgnore
    public void  setBtnRyoAshi(ButtonDialog btnRyoAshi) {
        this.getDaiichigunShintaiKino().getRyoAshi().setBtnRyoAshi(btnRyoAshi);
    }

    @JsonIgnore
    public RadioButton getRadRyoAshi() {
        return this.getDaiichigunShintaiKino().getRyoAshi().getRadRyoAshi();
    }

    @JsonIgnore
    public void  setRadRyoAshi(RadioButton radRyoAshi) {
        this.getDaiichigunShintaiKino().getRyoAshi().setRadRyoAshi(radRyoAshi);
    }

    @JsonIgnore
    public BukoDiv getBuko() {
        return this.getDaiichigunShintaiKino().getBuko();
    }

    @JsonIgnore
    public void  setBuko(BukoDiv Buko) {
        this.getDaiichigunShintaiKino().setBuko(Buko);
    }

    @JsonIgnore
    public ButtonDialog getBtnBuko() {
        return this.getDaiichigunShintaiKino().getBuko().getBtnBuko();
    }

    @JsonIgnore
    public void  setBtnBuko(ButtonDialog btnBuko) {
        this.getDaiichigunShintaiKino().getBuko().setBtnBuko(btnBuko);
    }

    @JsonIgnore
    public RadioButton getRadBuko() {
        return this.getDaiichigunShintaiKino().getBuko().getRadBuko();
    }

    @JsonIgnore
    public void  setRadBuko(RadioButton radBuko) {
        this.getDaiichigunShintaiKino().getBuko().setRadBuko(radBuko);
    }

    @JsonIgnore
    public TachiAgariDiv getTachiAgari() {
        return this.getDaiichigunShintaiKino().getTachiAgari();
    }

    @JsonIgnore
    public void  setTachiAgari(TachiAgariDiv TachiAgari) {
        this.getDaiichigunShintaiKino().setTachiAgari(TachiAgari);
    }

    @JsonIgnore
    public ButtonDialog getBtnTachiAgari() {
        return this.getDaiichigunShintaiKino().getTachiAgari().getBtnTachiAgari();
    }

    @JsonIgnore
    public void  setBtnTachiAgari(ButtonDialog btnTachiAgari) {
        this.getDaiichigunShintaiKino().getTachiAgari().setBtnTachiAgari(btnTachiAgari);
    }

    @JsonIgnore
    public RadioButton getRadTachiAgari() {
        return this.getDaiichigunShintaiKino().getTachiAgari().getRadTachiAgari();
    }

    @JsonIgnore
    public void  setRadTachiAgari(RadioButton radTachiAgari) {
        this.getDaiichigunShintaiKino().getTachiAgari().setRadTachiAgari(radTachiAgari);
    }

    @JsonIgnore
    public KataAshiDiv getKataAshi() {
        return this.getDaiichigunShintaiKino().getKataAshi();
    }

    @JsonIgnore
    public void  setKataAshi(KataAshiDiv KataAshi) {
        this.getDaiichigunShintaiKino().setKataAshi(KataAshi);
    }

    @JsonIgnore
    public ButtonDialog getBtnKataAshi() {
        return this.getDaiichigunShintaiKino().getKataAshi().getBtnKataAshi();
    }

    @JsonIgnore
    public void  setBtnKataAshi(ButtonDialog btnKataAshi) {
        this.getDaiichigunShintaiKino().getKataAshi().setBtnKataAshi(btnKataAshi);
    }

    @JsonIgnore
    public RadioButton getRadKataAshi() {
        return this.getDaiichigunShintaiKino().getKataAshi().getRadKataAshi();
    }

    @JsonIgnore
    public void  setRadKataAshi(RadioButton radKataAshi) {
        this.getDaiichigunShintaiKino().getKataAshi().setRadKataAshi(radKataAshi);
    }

    @JsonIgnore
    public SenshinDiv getSenshin() {
        return this.getDaiichigunShintaiKino().getSenshin();
    }

    @JsonIgnore
    public void  setSenshin(SenshinDiv Senshin) {
        this.getDaiichigunShintaiKino().setSenshin(Senshin);
    }

    @JsonIgnore
    public ButtonDialog getBtnSenshin() {
        return this.getDaiichigunShintaiKino().getSenshin().getBtnSenshin();
    }

    @JsonIgnore
    public void  setBtnSenshin(ButtonDialog btnSenshin) {
        this.getDaiichigunShintaiKino().getSenshin().setBtnSenshin(btnSenshin);
    }

    @JsonIgnore
    public RadioButton getRadSenshin() {
        return this.getDaiichigunShintaiKino().getSenshin().getRadSenshin();
    }

    @JsonIgnore
    public void  setRadSenshin(RadioButton radSenshin) {
        this.getDaiichigunShintaiKino().getSenshin().setRadSenshin(radSenshin);
    }

    @JsonIgnore
    public TumeKiriDiv getTumeKiri() {
        return this.getDaiichigunShintaiKino().getTumeKiri();
    }

    @JsonIgnore
    public void  setTumeKiri(TumeKiriDiv TumeKiri) {
        this.getDaiichigunShintaiKino().setTumeKiri(TumeKiri);
    }

    @JsonIgnore
    public ButtonDialog getBtnTumeKiri() {
        return this.getDaiichigunShintaiKino().getTumeKiri().getBtnTumeKiri();
    }

    @JsonIgnore
    public void  setBtnTumeKiri(ButtonDialog btnTumeKiri) {
        this.getDaiichigunShintaiKino().getTumeKiri().setBtnTumeKiri(btnTumeKiri);
    }

    @JsonIgnore
    public RadioButton getRadTumeKiri() {
        return this.getDaiichigunShintaiKino().getTumeKiri().getRadTumeKiri();
    }

    @JsonIgnore
    public void  setRadTumeKiri(RadioButton radTumeKiri) {
        this.getDaiichigunShintaiKino().getTumeKiri().setRadTumeKiri(radTumeKiri);
    }

    @JsonIgnore
    public ShiryokuDiv getShiryoku() {
        return this.getDaiichigunShintaiKino().getShiryoku();
    }

    @JsonIgnore
    public void  setShiryoku(ShiryokuDiv Shiryoku) {
        this.getDaiichigunShintaiKino().setShiryoku(Shiryoku);
    }

    @JsonIgnore
    public ButtonDialog getBtnShiryoku() {
        return this.getDaiichigunShintaiKino().getShiryoku().getBtnShiryoku();
    }

    @JsonIgnore
    public void  setBtnShiryoku(ButtonDialog btnShiryoku) {
        this.getDaiichigunShintaiKino().getShiryoku().setBtnShiryoku(btnShiryoku);
    }

    @JsonIgnore
    public RadioButton getRadShiryoku() {
        return this.getDaiichigunShintaiKino().getShiryoku().getRadShiryoku();
    }

    @JsonIgnore
    public void  setRadShiryoku(RadioButton radShiryoku) {
        this.getDaiichigunShintaiKino().getShiryoku().setRadShiryoku(radShiryoku);
    }

    @JsonIgnore
    public ChoryokuDiv getChoryoku() {
        return this.getDaiichigunShintaiKino().getChoryoku();
    }

    @JsonIgnore
    public void  setChoryoku(ChoryokuDiv Choryoku) {
        this.getDaiichigunShintaiKino().setChoryoku(Choryoku);
    }

    @JsonIgnore
    public ButtonDialog getBtnChoryoku() {
        return this.getDaiichigunShintaiKino().getChoryoku().getBtnChoryoku();
    }

    @JsonIgnore
    public void  setBtnChoryoku(ButtonDialog btnChoryoku) {
        this.getDaiichigunShintaiKino().getChoryoku().setBtnChoryoku(btnChoryoku);
    }

    @JsonIgnore
    public RadioButton getRadChoryoku() {
        return this.getDaiichigunShintaiKino().getChoryoku().getRadChoryoku();
    }

    @JsonIgnore
    public void  setRadChoryoku(RadioButton radChoryoku) {
        this.getDaiichigunShintaiKino().getChoryoku().setRadChoryoku(radChoryoku);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        KihonChosaInputHandler1 handler = new KihonChosaInputHandler1(this);
        handler.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
    }

}
