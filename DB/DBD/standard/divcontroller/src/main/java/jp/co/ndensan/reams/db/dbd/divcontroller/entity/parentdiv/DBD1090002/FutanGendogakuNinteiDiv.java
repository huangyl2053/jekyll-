package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002;
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
 * FutanGendogakuNintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanGendogakuNinteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FutanGendogakuNinteiInfo")
    private FutanGendogakuNinteiInfoDiv FutanGendogakuNinteiInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFutanGendogakuNinteiInfo
     * @return FutanGendogakuNinteiInfo
     */
    @JsonProperty("FutanGendogakuNinteiInfo")
    public FutanGendogakuNinteiInfoDiv getFutanGendogakuNinteiInfo() {
        return FutanGendogakuNinteiInfo;
    }

    /*
     * setFutanGendogakuNinteiInfo
     * @param FutanGendogakuNinteiInfo FutanGendogakuNinteiInfo
     */
    @JsonProperty("FutanGendogakuNinteiInfo")
    public void setFutanGendogakuNinteiInfo(FutanGendogakuNinteiInfoDiv FutanGendogakuNinteiInfo) {
        this.FutanGendogakuNinteiInfo = FutanGendogakuNinteiInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiKetteiKubun() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiKetteiKubun(TextBox txtFutanGendogakuNinteiKetteiKubun) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiKetteiKubun(txtFutanGendogakuNinteiKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiShinseiRiyu() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiShinseiRiyu(TextBox txtFutanGendogakuNinteiShinseiRiyu) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiShinseiRiyu(txtFutanGendogakuNinteiShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuNinteiShinseibi() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiShinseibi();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiShinseibi(TextBoxFlexibleDate txtFutanGendogakuNinteiShinseibi) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiShinseibi(txtFutanGendogakuNinteiShinseibi);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiFutanDankai() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiFutanDankai();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiFutanDankai(TextBox txtFutanGendogakuNinteiFutanDankai) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiFutanDankai(txtFutanGendogakuNinteiFutanDankai);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiKyuSochi() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiKyuSochi();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiKyuSochi(TextBox txtFutanGendogakuNinteiKyuSochi) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiKyuSochi(txtFutanGendogakuNinteiKyuSochi);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiKyokaiso() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiKyokaiso();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiKyokaiso(TextBox txtFutanGendogakuNinteiKyokaiso) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiKyokaiso(txtFutanGendogakuNinteiKyokaiso);
    }

    @JsonIgnore
    public TextBox getFutanGendogakuNinteiGekihenKanwa() {
        return this.getFutanGendogakuNinteiInfo().getFutanGendogakuNinteiGekihenKanwa();
    }

    @JsonIgnore
    public void  setFutanGendogakuNinteiGekihenKanwa(TextBox FutanGendogakuNinteiGekihenKanwa) {
        this.getFutanGendogakuNinteiInfo().setFutanGendogakuNinteiGekihenKanwa(FutanGendogakuNinteiGekihenKanwa);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getFutanGendogakuNinteiKetteibi() {
        return this.getFutanGendogakuNinteiInfo().getFutanGendogakuNinteiKetteibi();
    }

    @JsonIgnore
    public void  setFutanGendogakuNinteiKetteibi(TextBoxFlexibleDate FutanGendogakuNinteiKetteibi) {
        this.getFutanGendogakuNinteiInfo().setFutanGendogakuNinteiKetteibi(FutanGendogakuNinteiKetteibi);
    }

    @JsonIgnore
    public Label getLblFutanGendogakuNinteiFutanGendogaku() {
        return this.getFutanGendogakuNinteiInfo().getLblFutanGendogakuNinteiFutanGendogaku();
    }

    @JsonIgnore
    public void  setLblFutanGendogakuNinteiFutanGendogaku(Label lblFutanGendogakuNinteiFutanGendogaku) {
        this.getFutanGendogakuNinteiInfo().setLblFutanGendogakuNinteiFutanGendogaku(lblFutanGendogakuNinteiFutanGendogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiShokuhi() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiShokuhi();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiShokuhi(TextBoxNum txtFutanGendogakuNinteiShokuhi) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiShokuhi(txtFutanGendogakuNinteiShokuhi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuNinteiTekiyobi() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiTekiyobi();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiTekiyobi(TextBoxFlexibleDate txtFutanGendogakuNinteiTekiyobi) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiTekiyobi(txtFutanGendogakuNinteiTekiyobi);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiUnitGataKoshitsu() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiUnitGataKoshitsu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiUnitGataKoshitsu(TextBoxNum txtFutanGendogakuNinteiUnitGataKoshitsu) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiUnitGataKoshitsu(txtFutanGendogakuNinteiUnitGataKoshitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiUnitGataJunkoshitsu() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiUnitGataJunkoshitsu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiUnitGataJunkoshitsu(TextBoxNum txtFutanGendogakuNinteiUnitGataJunkoshitsu) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiUnitGataJunkoshitsu(txtFutanGendogakuNinteiUnitGataJunkoshitsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuNinteiYukoKigen() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiYukoKigen();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiYukoKigen(TextBoxFlexibleDate txtFutanGendogakuNinteiYukoKigen) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiYukoKigen(txtFutanGendogakuNinteiYukoKigen);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo(TextBoxNum txtFutanGendogakuNinteiJuraigataKoshitsuTokuyo) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo(txtFutanGendogakuNinteiJuraigataKoshitsuTokuyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiJuraigataKoshitsuRoken() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiJuraigataKoshitsuRoken();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiJuraigataKoshitsuRoken(TextBoxNum txtFutanGendogakuNinteiJuraigataKoshitsuRoken) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiJuraigataKoshitsuRoken(txtFutanGendogakuNinteiJuraigataKoshitsuRoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiTashoshitsu() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiTashoshitsu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiTashoshitsu(TextBoxNum txtFutanGendogakuNinteiTashoshitsu) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiTashoshitsu(txtFutanGendogakuNinteiTashoshitsu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFutanGendogakuNinteiShoninShinsaiRiyu() {
        return this.getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiShoninShinsaiRiyu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiShoninShinsaiRiyu(TextBoxMultiLine txtFutanGendogakuNinteiShoninShinsaiRiyu) {
        this.getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiShoninShinsaiRiyu(txtFutanGendogakuNinteiShoninShinsaiRiyu);
    }

    // </editor-fold>
}
