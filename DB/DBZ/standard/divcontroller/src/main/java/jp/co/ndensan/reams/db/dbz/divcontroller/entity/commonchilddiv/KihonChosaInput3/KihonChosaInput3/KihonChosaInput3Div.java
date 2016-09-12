package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput3.KihonChosaInput3;
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
 * KihonChosaInput3 のクラスファイル
 *
 * @reamsid_L DBE-3000-092 wangjie2
 */
public class KihonChosaInput3Div extends Panel implements IKihonChosaInput3Div {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    private Label ZenkaiHyojiTeiji;
    @JsonProperty("NinchiKinou")
    private NinchiKinouDiv NinchiKinou;
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
    public IshiDentatsuDiv getIshiDentatsu() {
        return this.getNinchiKinou().getIshiDentatsu();
    }

    @JsonIgnore
    public void  setIshiDentatsu(IshiDentatsuDiv IshiDentatsu) {
        this.getNinchiKinou().setIshiDentatsu(IshiDentatsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnIshiDentatsu() {
        return this.getNinchiKinou().getIshiDentatsu().getBtnIshiDentatsu();
    }

    @JsonIgnore
    public void  setBtnIshiDentatsu(ButtonDialog btnIshiDentatsu) {
        this.getNinchiKinou().getIshiDentatsu().setBtnIshiDentatsu(btnIshiDentatsu);
    }

    @JsonIgnore
    public RadioButton getRadIshiDentatsu() {
        return this.getNinchiKinou().getIshiDentatsu().getRadIshiDentatsu();
    }

    @JsonIgnore
    public void  setRadIshiDentatsu(RadioButton radIshiDentatsu) {
        this.getNinchiKinou().getIshiDentatsu().setRadIshiDentatsu(radIshiDentatsu);
    }

    @JsonIgnore
    public NikkaDiv getNikka() {
        return this.getNinchiKinou().getNikka();
    }

    @JsonIgnore
    public void  setNikka(NikkaDiv Nikka) {
        this.getNinchiKinou().setNikka(Nikka);
    }

    @JsonIgnore
    public ButtonDialog getBtnNikka() {
        return this.getNinchiKinou().getNikka().getBtnNikka();
    }

    @JsonIgnore
    public void  setBtnNikka(ButtonDialog btnNikka) {
        this.getNinchiKinou().getNikka().setBtnNikka(btnNikka);
    }

    @JsonIgnore
    public RadioButton getRadNikka() {
        return this.getNinchiKinou().getNikka().getRadNikka();
    }

    @JsonIgnore
    public void  setRadNikka(RadioButton radNikka) {
        this.getNinchiKinou().getNikka().setRadNikka(radNikka);
    }

    @JsonIgnore
    public InfoDiv getInfo() {
        return this.getNinchiKinou().getInfo();
    }

    @JsonIgnore
    public void  setInfo(InfoDiv Info) {
        this.getNinchiKinou().setInfo(Info);
    }

    @JsonIgnore
    public ButtonDialog getBtnInfo() {
        return this.getNinchiKinou().getInfo().getBtnInfo();
    }

    @JsonIgnore
    public void  setBtnInfo(ButtonDialog btnInfo) {
        this.getNinchiKinou().getInfo().setBtnInfo(btnInfo);
    }

    @JsonIgnore
    public RadioButton getRadInfo() {
        return this.getNinchiKinou().getInfo().getRadInfo();
    }

    @JsonIgnore
    public void  setRadInfo(RadioButton radInfo) {
        this.getNinchiKinou().getInfo().setRadInfo(radInfo);
    }

    @JsonIgnore
    public DankiKiokuDiv getDankiKioku() {
        return this.getNinchiKinou().getDankiKioku();
    }

    @JsonIgnore
    public void  setDankiKioku(DankiKiokuDiv DankiKioku) {
        this.getNinchiKinou().setDankiKioku(DankiKioku);
    }

    @JsonIgnore
    public ButtonDialog getBtnDankiKioku() {
        return this.getNinchiKinou().getDankiKioku().getBtnDankiKioku();
    }

    @JsonIgnore
    public void  setBtnDankiKioku(ButtonDialog btnDankiKioku) {
        this.getNinchiKinou().getDankiKioku().setBtnDankiKioku(btnDankiKioku);
    }

    @JsonIgnore
    public RadioButton getRadDankiKioku() {
        return this.getNinchiKinou().getDankiKioku().getRadDankiKioku();
    }

    @JsonIgnore
    public void  setRadDankiKioku(RadioButton radDankiKioku) {
        this.getNinchiKinou().getDankiKioku().setRadDankiKioku(radDankiKioku);
    }

    @JsonIgnore
    public NameInfoDiv getNameInfo() {
        return this.getNinchiKinou().getNameInfo();
    }

    @JsonIgnore
    public void  setNameInfo(NameInfoDiv NameInfo) {
        this.getNinchiKinou().setNameInfo(NameInfo);
    }

    @JsonIgnore
    public ButtonDialog getBtnNameInfo() {
        return this.getNinchiKinou().getNameInfo().getBtnNameInfo();
    }

    @JsonIgnore
    public void  setBtnNameInfo(ButtonDialog btnNameInfo) {
        this.getNinchiKinou().getNameInfo().setBtnNameInfo(btnNameInfo);
    }

    @JsonIgnore
    public RadioButton getRadNameInfo() {
        return this.getNinchiKinou().getNameInfo().getRadNameInfo();
    }

    @JsonIgnore
    public void  setRadNameInfo(RadioButton radNameInfo) {
        this.getNinchiKinou().getNameInfo().setRadNameInfo(radNameInfo);
    }

    @JsonIgnore
    public KisetsuDiv getKisetsu() {
        return this.getNinchiKinou().getKisetsu();
    }

    @JsonIgnore
    public void  setKisetsu(KisetsuDiv Kisetsu) {
        this.getNinchiKinou().setKisetsu(Kisetsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnKisetsu() {
        return this.getNinchiKinou().getKisetsu().getBtnKisetsu();
    }

    @JsonIgnore
    public void  setBtnKisetsu(ButtonDialog btnKisetsu) {
        this.getNinchiKinou().getKisetsu().setBtnKisetsu(btnKisetsu);
    }

    @JsonIgnore
    public RadioButton getRadKisetsu() {
        return this.getNinchiKinou().getKisetsu().getRadKisetsu();
    }

    @JsonIgnore
    public void  setRadKisetsu(RadioButton radKisetsu) {
        this.getNinchiKinou().getKisetsu().setRadKisetsu(radKisetsu);
    }

    @JsonIgnore
    public BashoDiv getBasho() {
        return this.getNinchiKinou().getBasho();
    }

    @JsonIgnore
    public void  setBasho(BashoDiv Basho) {
        this.getNinchiKinou().setBasho(Basho);
    }

    @JsonIgnore
    public ButtonDialog getBtnBasho() {
        return this.getNinchiKinou().getBasho().getBtnBasho();
    }

    @JsonIgnore
    public void  setBtnBasho(ButtonDialog btnBasho) {
        this.getNinchiKinou().getBasho().setBtnBasho(btnBasho);
    }

    @JsonIgnore
    public RadioButton getRadBasho() {
        return this.getNinchiKinou().getBasho().getRadBasho();
    }

    @JsonIgnore
    public void  setRadBasho(RadioButton radBasho) {
        this.getNinchiKinou().getBasho().setRadBasho(radBasho);
    }

    @JsonIgnore
    public HaikaiDiv getHaikai() {
        return this.getNinchiKinou().getHaikai();
    }

    @JsonIgnore
    public void  setHaikai(HaikaiDiv Haikai) {
        this.getNinchiKinou().setHaikai(Haikai);
    }

    @JsonIgnore
    public ButtonDialog getBtnHaikai() {
        return this.getNinchiKinou().getHaikai().getBtnHaikai();
    }

    @JsonIgnore
    public void  setBtnHaikai(ButtonDialog btnHaikai) {
        this.getNinchiKinou().getHaikai().setBtnHaikai(btnHaikai);
    }

    @JsonIgnore
    public RadioButton getRadHaikai() {
        return this.getNinchiKinou().getHaikai().getRadHaikai();
    }

    @JsonIgnore
    public void  setRadHaikai(RadioButton radHaikai) {
        this.getNinchiKinou().getHaikai().setRadHaikai(radHaikai);
    }

    @JsonIgnore
    public ModoruDiv getModoru() {
        return this.getNinchiKinou().getModoru();
    }

    @JsonIgnore
    public void  setModoru(ModoruDiv Modoru) {
        this.getNinchiKinou().setModoru(Modoru);
    }

    @JsonIgnore
    public ButtonDialog getBtnModoru() {
        return this.getNinchiKinou().getModoru().getBtnModoru();
    }

    @JsonIgnore
    public void  setBtnModoru(ButtonDialog btnModoru) {
        this.getNinchiKinou().getModoru().setBtnModoru(btnModoru);
    }

    @JsonIgnore
    public RadioButton getRadModoru() {
        return this.getNinchiKinou().getModoru().getRadModoru();
    }

    @JsonIgnore
    public void  setRadModoru(RadioButton radModoru) {
        this.getNinchiKinou().getModoru().setRadModoru(radModoru);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        KihonChosaInputHandler3 handler = new KihonChosaInputHandler3(this);
        handler.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
    }

}
