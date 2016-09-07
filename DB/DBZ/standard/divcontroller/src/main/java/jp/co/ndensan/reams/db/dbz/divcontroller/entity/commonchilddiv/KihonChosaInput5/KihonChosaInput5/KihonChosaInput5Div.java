package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput5.KihonChosaInput5;
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
 * KihonChosaInput5 のクラスファイル
 *
 * @reamsid_L DBE-3000-094 wangjie2
 */
public class KihonChosaInput5Div extends Panel implements IKihonChosaInput5Div {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    private Label ZenkaiHyojiTeiji;
    @JsonProperty("ShakaiSekatsu")
    private ShakaiSekatsuDiv ShakaiSekatsu;
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
    public KusuriDiv getKusuri() {
        return this.getShakaiSekatsu().getKusuri();
    }

    @JsonIgnore
    public void  setKusuri(KusuriDiv Kusuri) {
        this.getShakaiSekatsu().setKusuri(Kusuri);
    }

    @JsonIgnore
    public ButtonDialog getBtnKusuri() {
        return this.getShakaiSekatsu().getKusuri().getBtnKusuri();
    }

    @JsonIgnore
    public void  setBtnKusuri(ButtonDialog btnKusuri) {
        this.getShakaiSekatsu().getKusuri().setBtnKusuri(btnKusuri);
    }

    @JsonIgnore
    public RadioButton getRadKusuri() {
        return this.getShakaiSekatsu().getKusuri().getRadKusuri();
    }

    @JsonIgnore
    public void  setRadKusuri(RadioButton radKusuri) {
        this.getShakaiSekatsu().getKusuri().setRadKusuri(radKusuri);
    }

    @JsonIgnore
    public KingakuKanriDiv getKingakuKanri() {
        return this.getShakaiSekatsu().getKingakuKanri();
    }

    @JsonIgnore
    public void  setKingakuKanri(KingakuKanriDiv KingakuKanri) {
        this.getShakaiSekatsu().setKingakuKanri(KingakuKanri);
    }

    @JsonIgnore
    public ButtonDialog getBtnKingakuKanri() {
        return this.getShakaiSekatsu().getKingakuKanri().getBtnKingakuKanri();
    }

    @JsonIgnore
    public void  setBtnKingakuKanri(ButtonDialog btnKingakuKanri) {
        this.getShakaiSekatsu().getKingakuKanri().setBtnKingakuKanri(btnKingakuKanri);
    }

    @JsonIgnore
    public RadioButton getRadKingakuKanri() {
        return this.getShakaiSekatsu().getKingakuKanri().getRadKingakuKanri();
    }

    @JsonIgnore
    public void  setRadKingakuKanri(RadioButton radKingakuKanri) {
        this.getShakaiSekatsu().getKingakuKanri().setRadKingakuKanri(radKingakuKanri);
    }

    @JsonIgnore
    public IshiKeteiDiv getIshiKetei() {
        return this.getShakaiSekatsu().getIshiKetei();
    }

    @JsonIgnore
    public void  setIshiKetei(IshiKeteiDiv IshiKetei) {
        this.getShakaiSekatsu().setIshiKetei(IshiKetei);
    }

    @JsonIgnore
    public ButtonDialog getBtnIshiKetei() {
        return this.getShakaiSekatsu().getIshiKetei().getBtnIshiKetei();
    }

    @JsonIgnore
    public void  setBtnIshiKetei(ButtonDialog btnIshiKetei) {
        this.getShakaiSekatsu().getIshiKetei().setBtnIshiKetei(btnIshiKetei);
    }

    @JsonIgnore
    public RadioButton getRadIshiKetei() {
        return this.getShakaiSekatsu().getIshiKetei().getRadIshiKetei();
    }

    @JsonIgnore
    public void  setRadIshiKetei(RadioButton radIshiKetei) {
        this.getShakaiSekatsu().getIshiKetei().setRadIshiKetei(radIshiKetei);
    }

    @JsonIgnore
    public ShudanDiv getShudan() {
        return this.getShakaiSekatsu().getShudan();
    }

    @JsonIgnore
    public void  setShudan(ShudanDiv Shudan) {
        this.getShakaiSekatsu().setShudan(Shudan);
    }

    @JsonIgnore
    public ButtonDialog getBtnShudan() {
        return this.getShakaiSekatsu().getShudan().getBtnShudan();
    }

    @JsonIgnore
    public void  setBtnShudan(ButtonDialog btnShudan) {
        this.getShakaiSekatsu().getShudan().setBtnShudan(btnShudan);
    }

    @JsonIgnore
    public RadioButton getRadShudan() {
        return this.getShakaiSekatsu().getShudan().getRadShudan();
    }

    @JsonIgnore
    public void  setRadShudan(RadioButton radShudan) {
        this.getShakaiSekatsu().getShudan().setRadShudan(radShudan);
    }

    @JsonIgnore
    public KaiMonoDiv getKaiMono() {
        return this.getShakaiSekatsu().getKaiMono();
    }

    @JsonIgnore
    public void  setKaiMono(KaiMonoDiv KaiMono) {
        this.getShakaiSekatsu().setKaiMono(KaiMono);
    }

    @JsonIgnore
    public ButtonDialog getBtnKaiMono() {
        return this.getShakaiSekatsu().getKaiMono().getBtnKaiMono();
    }

    @JsonIgnore
    public void  setBtnKaiMono(ButtonDialog btnKaiMono) {
        this.getShakaiSekatsu().getKaiMono().setBtnKaiMono(btnKaiMono);
    }

    @JsonIgnore
    public RadioButton getRadKaiMono() {
        return this.getShakaiSekatsu().getKaiMono().getRadKaiMono();
    }

    @JsonIgnore
    public void  setRadKaiMono(RadioButton radKaiMono) {
        this.getShakaiSekatsu().getKaiMono().setRadKaiMono(radKaiMono);
    }

    @JsonIgnore
    public KantanChoriDiv getKantanChori() {
        return this.getShakaiSekatsu().getKantanChori();
    }

    @JsonIgnore
    public void  setKantanChori(KantanChoriDiv KantanChori) {
        this.getShakaiSekatsu().setKantanChori(KantanChori);
    }

    @JsonIgnore
    public ButtonDialog getBtnKantanChori() {
        return this.getShakaiSekatsu().getKantanChori().getBtnKantanChori();
    }

    @JsonIgnore
    public void  setBtnKantanChori(ButtonDialog btnKantanChori) {
        this.getShakaiSekatsu().getKantanChori().setBtnKantanChori(btnKantanChori);
    }

    @JsonIgnore
    public RadioButton getRadKantanChori() {
        return this.getShakaiSekatsu().getKantanChori().getRadKantanChori();
    }

    @JsonIgnore
    public void  setRadKantanChori(RadioButton radKantanChori) {
        this.getShakaiSekatsu().getKantanChori().setRadKantanChori(radKantanChori);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        KihonChosaInputHandler5 handler = new KihonChosaInputHandler5(this);
        handler.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
    }

}
