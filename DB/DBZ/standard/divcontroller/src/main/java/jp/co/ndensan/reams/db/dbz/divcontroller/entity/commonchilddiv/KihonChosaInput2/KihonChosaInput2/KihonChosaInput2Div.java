package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2;
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
 * KihonChosaInput2 のクラスファイル
 *
 * @reamsid_L DBE-3000-091 wangjie2
 */
public class KihonChosaInput2Div extends Panel implements IKihonChosaInput2Div {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    private Label ZenkaiHyojiTeiji;
    @JsonProperty("SeikatsuKinou")
    private SeikatsuKinouDiv SeikatsuKinou;
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
    public IjyoDiv getIjyo() {
        return this.getSeikatsuKinou().getIjyo();
    }

    @JsonIgnore
    public void  setIjyo(IjyoDiv Ijyo) {
        this.getSeikatsuKinou().setIjyo(Ijyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnIjyo() {
        return this.getSeikatsuKinou().getIjyo().getBtnIjyo();
    }

    @JsonIgnore
    public void  setBtnIjyo(ButtonDialog btnIjyo) {
        this.getSeikatsuKinou().getIjyo().setBtnIjyo(btnIjyo);
    }

    @JsonIgnore
    public RadioButton getRadIjyo() {
        return this.getSeikatsuKinou().getIjyo().getRadIjyo();
    }

    @JsonIgnore
    public void  setRadIjyo(RadioButton radIjyo) {
        this.getSeikatsuKinou().getIjyo().setRadIjyo(radIjyo);
    }

    @JsonIgnore
    public IdouDiv getIdou() {
        return this.getSeikatsuKinou().getIdou();
    }

    @JsonIgnore
    public void  setIdou(IdouDiv Idou) {
        this.getSeikatsuKinou().setIdou(Idou);
    }

    @JsonIgnore
    public ButtonDialog getBtnIdou() {
        return this.getSeikatsuKinou().getIdou().getBtnIdou();
    }

    @JsonIgnore
    public void  setBtnIdou(ButtonDialog btnIdou) {
        this.getSeikatsuKinou().getIdou().setBtnIdou(btnIdou);
    }

    @JsonIgnore
    public RadioButton getRadIdou() {
        return this.getSeikatsuKinou().getIdou().getRadIdou();
    }

    @JsonIgnore
    public void  setRadIdou(RadioButton radIdou) {
        this.getSeikatsuKinou().getIdou().setRadIdou(radIdou);
    }

    @JsonIgnore
    public EnkaDiv getEnka() {
        return this.getSeikatsuKinou().getEnka();
    }

    @JsonIgnore
    public void  setEnka(EnkaDiv Enka) {
        this.getSeikatsuKinou().setEnka(Enka);
    }

    @JsonIgnore
    public ButtonDialog getBtnEnka() {
        return this.getSeikatsuKinou().getEnka().getBtnEnka();
    }

    @JsonIgnore
    public void  setBtnEnka(ButtonDialog btnEnka) {
        this.getSeikatsuKinou().getEnka().setBtnEnka(btnEnka);
    }

    @JsonIgnore
    public RadioButton getRadEnka() {
        return this.getSeikatsuKinou().getEnka().getRadEnka();
    }

    @JsonIgnore
    public void  setRadEnka(RadioButton radEnka) {
        this.getSeikatsuKinou().getEnka().setRadEnka(radEnka);
    }

    @JsonIgnore
    public ShokujiDiv getShokuji() {
        return this.getSeikatsuKinou().getShokuji();
    }

    @JsonIgnore
    public void  setShokuji(ShokujiDiv Shokuji) {
        this.getSeikatsuKinou().setShokuji(Shokuji);
    }

    @JsonIgnore
    public ButtonDialog getBtnShokuji() {
        return this.getSeikatsuKinou().getShokuji().getBtnShokuji();
    }

    @JsonIgnore
    public void  setBtnShokuji(ButtonDialog btnShokuji) {
        this.getSeikatsuKinou().getShokuji().setBtnShokuji(btnShokuji);
    }

    @JsonIgnore
    public RadioButton getRadShokuji() {
        return this.getSeikatsuKinou().getShokuji().getRadShokuji();
    }

    @JsonIgnore
    public void  setRadShokuji(RadioButton radShokuji) {
        this.getSeikatsuKinou().getShokuji().setRadShokuji(radShokuji);
    }

    @JsonIgnore
    public HainyoDiv getHainyo() {
        return this.getSeikatsuKinou().getHainyo();
    }

    @JsonIgnore
    public void  setHainyo(HainyoDiv Hainyo) {
        this.getSeikatsuKinou().setHainyo(Hainyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHainyo() {
        return this.getSeikatsuKinou().getHainyo().getBtnHainyo();
    }

    @JsonIgnore
    public void  setBtnHainyo(ButtonDialog btnHainyo) {
        this.getSeikatsuKinou().getHainyo().setBtnHainyo(btnHainyo);
    }

    @JsonIgnore
    public RadioButton getRadHainyo() {
        return this.getSeikatsuKinou().getHainyo().getRadHainyo();
    }

    @JsonIgnore
    public void  setRadHainyo(RadioButton radHainyo) {
        this.getSeikatsuKinou().getHainyo().setRadHainyo(radHainyo);
    }

    @JsonIgnore
    public HaibenDiv getHaiben() {
        return this.getSeikatsuKinou().getHaiben();
    }

    @JsonIgnore
    public void  setHaiben(HaibenDiv Haiben) {
        this.getSeikatsuKinou().setHaiben(Haiben);
    }

    @JsonIgnore
    public ButtonDialog getBtnHaiben() {
        return this.getSeikatsuKinou().getHaiben().getBtnHaiben();
    }

    @JsonIgnore
    public void  setBtnHaiben(ButtonDialog btnHaiben) {
        this.getSeikatsuKinou().getHaiben().setBtnHaiben(btnHaiben);
    }

    @JsonIgnore
    public RadioButton getRadHaiben() {
        return this.getSeikatsuKinou().getHaiben().getRadHaiben();
    }

    @JsonIgnore
    public void  setRadHaiben(RadioButton radHaiben) {
        this.getSeikatsuKinou().getHaiben().setRadHaiben(radHaiben);
    }

    @JsonIgnore
    public KokouDiv getKokou() {
        return this.getSeikatsuKinou().getKokou();
    }

    @JsonIgnore
    public void  setKokou(KokouDiv Kokou) {
        this.getSeikatsuKinou().setKokou(Kokou);
    }

    @JsonIgnore
    public ButtonDialog getBtnKokou() {
        return this.getSeikatsuKinou().getKokou().getBtnKokou();
    }

    @JsonIgnore
    public void  setBtnKokou(ButtonDialog btnKokou) {
        this.getSeikatsuKinou().getKokou().setBtnKokou(btnKokou);
    }

    @JsonIgnore
    public RadioButton getRadKokou() {
        return this.getSeikatsuKinou().getKokou().getRadKokou();
    }

    @JsonIgnore
    public void  setRadKokou(RadioButton radKokou) {
        this.getSeikatsuKinou().getKokou().setRadKokou(radKokou);
    }

    @JsonIgnore
    public SenganDiv getSengan() {
        return this.getSeikatsuKinou().getSengan();
    }

    @JsonIgnore
    public void  setSengan(SenganDiv Sengan) {
        this.getSeikatsuKinou().setSengan(Sengan);
    }

    @JsonIgnore
    public ButtonDialog getBtnSengan() {
        return this.getSeikatsuKinou().getSengan().getBtnSengan();
    }

    @JsonIgnore
    public void  setBtnSengan(ButtonDialog btnSengan) {
        this.getSeikatsuKinou().getSengan().setBtnSengan(btnSengan);
    }

    @JsonIgnore
    public RadioButton getRadSengan() {
        return this.getSeikatsuKinou().getSengan().getRadSengan();
    }

    @JsonIgnore
    public void  setRadSengan(RadioButton radSengan) {
        this.getSeikatsuKinou().getSengan().setRadSengan(radSengan);
    }

    @JsonIgnore
    public SeihatsuDiv getSeihatsu() {
        return this.getSeikatsuKinou().getSeihatsu();
    }

    @JsonIgnore
    public void  setSeihatsu(SeihatsuDiv Seihatsu) {
        this.getSeikatsuKinou().setSeihatsu(Seihatsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnSeihatsu() {
        return this.getSeikatsuKinou().getSeihatsu().getBtnSeihatsu();
    }

    @JsonIgnore
    public void  setBtnSeihatsu(ButtonDialog btnSeihatsu) {
        this.getSeikatsuKinou().getSeihatsu().setBtnSeihatsu(btnSeihatsu);
    }

    @JsonIgnore
    public RadioButton getRadSeihatsu() {
        return this.getSeikatsuKinou().getSeihatsu().getRadSeihatsu();
    }

    @JsonIgnore
    public void  setRadSeihatsu(RadioButton radSeihatsu) {
        this.getSeikatsuKinou().getSeihatsu().setRadSeihatsu(radSeihatsu);
    }

    @JsonIgnore
    public UwagiDiv getUwagi() {
        return this.getSeikatsuKinou().getUwagi();
    }

    @JsonIgnore
    public void  setUwagi(UwagiDiv Uwagi) {
        this.getSeikatsuKinou().setUwagi(Uwagi);
    }

    @JsonIgnore
    public ButtonDialog getBtnUwagi() {
        return this.getSeikatsuKinou().getUwagi().getBtnUwagi();
    }

    @JsonIgnore
    public void  setBtnUwagi(ButtonDialog btnUwagi) {
        this.getSeikatsuKinou().getUwagi().setBtnUwagi(btnUwagi);
    }

    @JsonIgnore
    public RadioButton getRadUwagi() {
        return this.getSeikatsuKinou().getUwagi().getRadUwagi();
    }

    @JsonIgnore
    public void  setRadUwagi(RadioButton radUwagi) {
        this.getSeikatsuKinou().getUwagi().setRadUwagi(radUwagi);
    }

    @JsonIgnore
    public ZubonDiv getZubon() {
        return this.getSeikatsuKinou().getZubon();
    }

    @JsonIgnore
    public void  setZubon(ZubonDiv Zubon) {
        this.getSeikatsuKinou().setZubon(Zubon);
    }

    @JsonIgnore
    public ButtonDialog getBtnZubon() {
        return this.getSeikatsuKinou().getZubon().getBtnZubon();
    }

    @JsonIgnore
    public void  setBtnZubon(ButtonDialog btnZubon) {
        this.getSeikatsuKinou().getZubon().setBtnZubon(btnZubon);
    }

    @JsonIgnore
    public RadioButton getRadZubon() {
        return this.getSeikatsuKinou().getZubon().getRadZubon();
    }

    @JsonIgnore
    public void  setRadZubon(RadioButton radZubon) {
        this.getSeikatsuKinou().getZubon().setRadZubon(radZubon);
    }

    @JsonIgnore
    public HindoDiv getHindo() {
        return this.getSeikatsuKinou().getHindo();
    }

    @JsonIgnore
    public void  setHindo(HindoDiv Hindo) {
        this.getSeikatsuKinou().setHindo(Hindo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHindo() {
        return this.getSeikatsuKinou().getHindo().getBtnHindo();
    }

    @JsonIgnore
    public void  setBtnHindo(ButtonDialog btnHindo) {
        this.getSeikatsuKinou().getHindo().setBtnHindo(btnHindo);
    }

    @JsonIgnore
    public RadioButton getRadHindo() {
        return this.getSeikatsuKinou().getHindo().getRadHindo();
    }

    @JsonIgnore
    public void  setRadHindo(RadioButton radHindo) {
        this.getSeikatsuKinou().getHindo().setRadHindo(radHindo);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        KihonChosaInputHandler2 handler = new KihonChosaInputHandler2(this);
        handler.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
    }

}
