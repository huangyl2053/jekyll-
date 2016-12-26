package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput6.KihonChosaInput6;
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

/**
 * KihonChosaInput6 のクラスファイル
 *
 * @reamsid_L DBE-3000-095 wangjie2
 */
public class KihonChosaInput6Div extends Panel implements IKihonChosaInput6Div {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    private Label ZenkaiHyojiTeiji;
    @JsonProperty("TokubetsuIryo")
    private TokubetsuIryoDiv TokubetsuIryo;
    @JsonProperty("btnBack")
    private Button btnBack;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;

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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShochiNaiyoDiv getShochiNaiyo() {
        return this.getTokubetsuIryo().getShochiNaiyo();
    }

    @JsonIgnore
    public void  setShochiNaiyo(ShochiNaiyoDiv ShochiNaiyo) {
        this.getTokubetsuIryo().setShochiNaiyo(ShochiNaiyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnTenteki() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnTenteki();
    }

    @JsonIgnore
    public void  setBtnTenteki(ButtonDialog btnTenteki) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnTenteki(btnTenteki);
    }

    @JsonIgnore
    public CheckBoxList getChkTenteki() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkTenteki();
    }

    @JsonIgnore
    public void  setChkTenteki(CheckBoxList chkTenteki) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkTenteki(chkTenteki);
    }

    @JsonIgnore
    public ButtonDialog getBtnSeimyaku() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnSeimyaku();
    }

    @JsonIgnore
    public void  setBtnSeimyaku(ButtonDialog btnSeimyaku) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnSeimyaku(btnSeimyaku);
    }

    @JsonIgnore
    public CheckBoxList getChkSeimyaku() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkSeimyaku();
    }

    @JsonIgnore
    public void  setChkSeimyaku(CheckBoxList chkSeimyaku) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkSeimyaku(chkSeimyaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnTouseki() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnTouseki();
    }

    @JsonIgnore
    public void  setBtnTouseki(ButtonDialog btnTouseki) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnTouseki(btnTouseki);
    }

    @JsonIgnore
    public CheckBoxList getChkTouseki() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkTouseki();
    }

    @JsonIgnore
    public void  setChkTouseki(CheckBoxList chkTouseki) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkTouseki(chkTouseki);
    }

    @JsonIgnore
    public ButtonDialog getBtnSutoma() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnSutoma();
    }

    @JsonIgnore
    public void  setBtnSutoma(ButtonDialog btnSutoma) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnSutoma(btnSutoma);
    }

    @JsonIgnore
    public CheckBoxList getChkSutoma() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkSutoma();
    }

    @JsonIgnore
    public void  setChkSutoma(CheckBoxList chkSutoma) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkSutoma(chkSutoma);
    }

    @JsonIgnore
    public ButtonDialog getBtnSansou() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnSansou();
    }

    @JsonIgnore
    public void  setBtnSansou(ButtonDialog btnSansou) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnSansou(btnSansou);
    }

    @JsonIgnore
    public CheckBoxList getChkSansou() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkSansou();
    }

    @JsonIgnore
    public void  setChkSansou(CheckBoxList chkSansou) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkSansou(chkSansou);
    }

    @JsonIgnore
    public ButtonDialog getBtnResupireta() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnResupireta();
    }

    @JsonIgnore
    public void  setBtnResupireta(ButtonDialog btnResupireta) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnResupireta(btnResupireta);
    }

    @JsonIgnore
    public CheckBoxList getChkResupireta() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkResupireta();
    }

    @JsonIgnore
    public void  setChkResupireta(CheckBoxList chkResupireta) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkResupireta(chkResupireta);
    }

    @JsonIgnore
    public ButtonDialog getBtnKikan() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnKikan();
    }

    @JsonIgnore
    public void  setBtnKikan(ButtonDialog btnKikan) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnKikan(btnKikan);
    }

    @JsonIgnore
    public CheckBoxList getChkKikan() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkKikan();
    }

    @JsonIgnore
    public void  setChkKikan(CheckBoxList chkKikan) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkKikan(chkKikan);
    }

    @JsonIgnore
    public ButtonDialog getBtnToutsu() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnToutsu();
    }

    @JsonIgnore
    public void  setBtnToutsu(ButtonDialog btnToutsu) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnToutsu(btnToutsu);
    }

    @JsonIgnore
    public CheckBoxList getChkToutsu() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkToutsu();
    }

    @JsonIgnore
    public void  setChkToutsu(CheckBoxList chkToutsu) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkToutsu(chkToutsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnKeikan() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnKeikan();
    }

    @JsonIgnore
    public void  setBtnKeikan(ButtonDialog btnKeikan) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnKeikan(btnKeikan);
    }

    @JsonIgnore
    public CheckBoxList getChkKeikan() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkKeikan();
    }

    @JsonIgnore
    public void  setChkKeikan(CheckBoxList chkKeikan) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkKeikan(chkKeikan);
    }

    @JsonIgnore
    public TokiTaiouDiv getTokiTaiou() {
        return this.getTokubetsuIryo().getTokiTaiou();
    }

    @JsonIgnore
    public void  setTokiTaiou(TokiTaiouDiv TokiTaiou) {
        this.getTokubetsuIryo().setTokiTaiou(TokiTaiou);
    }

    @JsonIgnore
    public ButtonDialog getBtnMonita() {
        return this.getTokubetsuIryo().getTokiTaiou().getBtnMonita();
    }

    @JsonIgnore
    public void  setBtnMonita(ButtonDialog btnMonita) {
        this.getTokubetsuIryo().getTokiTaiou().setBtnMonita(btnMonita);
    }

    @JsonIgnore
    public CheckBoxList getChkMonita() {
        return this.getTokubetsuIryo().getTokiTaiou().getChkMonita();
    }

    @JsonIgnore
    public void  setChkMonita(CheckBoxList chkMonita) {
        this.getTokubetsuIryo().getTokiTaiou().setChkMonita(chkMonita);
    }

    @JsonIgnore
    public ButtonDialog getBtnJyokuso() {
        return this.getTokubetsuIryo().getTokiTaiou().getBtnJyokuso();
    }

    @JsonIgnore
    public void  setBtnJyokuso(ButtonDialog btnJyokuso) {
        this.getTokubetsuIryo().getTokiTaiou().setBtnJyokuso(btnJyokuso);
    }

    @JsonIgnore
    public CheckBoxList getChkJyokuso() {
        return this.getTokubetsuIryo().getTokiTaiou().getChkJyokuso();
    }

    @JsonIgnore
    public void  setChkJyokuso(CheckBoxList chkJyokuso) {
        this.getTokubetsuIryo().getTokiTaiou().setChkJyokuso(chkJyokuso);
    }

    @JsonIgnore
    public ButtonDialog getBtnbtnKateru() {
        return this.getTokubetsuIryo().getTokiTaiou().getBtnbtnKateru();
    }

    @JsonIgnore
    public void  setBtnbtnKateru(ButtonDialog btnbtnKateru) {
        this.getTokubetsuIryo().getTokiTaiou().setBtnbtnKateru(btnbtnKateru);
    }

    @JsonIgnore
    public CheckBoxList getChkKateru() {
        return this.getTokubetsuIryo().getTokiTaiou().getChkKateru();
    }

    @JsonIgnore
    public void  setChkKateru(CheckBoxList chkKateru) {
        this.getTokubetsuIryo().getTokiTaiou().setChkKateru(chkKateru);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        KihonChosaInputHandler6 handler = new KihonChosaInputHandler6(this);
        handler.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
    }

}
