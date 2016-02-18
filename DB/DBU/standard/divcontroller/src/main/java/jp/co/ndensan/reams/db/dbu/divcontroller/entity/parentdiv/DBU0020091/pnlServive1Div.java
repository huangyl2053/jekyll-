package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlServive1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlServive1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlDaiyon")
    private pnlDaiyonDiv pnlDaiyon;
    @JsonProperty("pnlDaisan")
    private pnlDaisanDiv pnlDaisan;
    @JsonProperty("pnlDaini")
    private pnlDainiDiv pnlDaini;
    @JsonProperty("pnlDaiitu")
    private pnlDaiituDiv pnlDaiitu;
    @JsonProperty("pnlGokei")
    private pnlGokeiDiv pnlGokei;
    @JsonProperty("pnlSaikeiDaisan")
    private pnlSaikeiDaisanDiv pnlSaikeiDaisan;
    @JsonProperty("pnlSaikeiDaini")
    private pnlSaikeiDainiDiv pnlSaikeiDaini;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlDaiyon
     * @return pnlDaiyon
     */
    @JsonProperty("pnlDaiyon")
    public pnlDaiyonDiv getPnlDaiyon() {
        return pnlDaiyon;
    }

    /*
     * setpnlDaiyon
     * @param pnlDaiyon pnlDaiyon
     */
    @JsonProperty("pnlDaiyon")
    public void setPnlDaiyon(pnlDaiyonDiv pnlDaiyon) {
        this.pnlDaiyon = pnlDaiyon;
    }

    /*
     * getpnlDaisan
     * @return pnlDaisan
     */
    @JsonProperty("pnlDaisan")
    public pnlDaisanDiv getPnlDaisan() {
        return pnlDaisan;
    }

    /*
     * setpnlDaisan
     * @param pnlDaisan pnlDaisan
     */
    @JsonProperty("pnlDaisan")
    public void setPnlDaisan(pnlDaisanDiv pnlDaisan) {
        this.pnlDaisan = pnlDaisan;
    }

    /*
     * getpnlDaini
     * @return pnlDaini
     */
    @JsonProperty("pnlDaini")
    public pnlDainiDiv getPnlDaini() {
        return pnlDaini;
    }

    /*
     * setpnlDaini
     * @param pnlDaini pnlDaini
     */
    @JsonProperty("pnlDaini")
    public void setPnlDaini(pnlDainiDiv pnlDaini) {
        this.pnlDaini = pnlDaini;
    }

    /*
     * getpnlDaiitu
     * @return pnlDaiitu
     */
    @JsonProperty("pnlDaiitu")
    public pnlDaiituDiv getPnlDaiitu() {
        return pnlDaiitu;
    }

    /*
     * setpnlDaiitu
     * @param pnlDaiitu pnlDaiitu
     */
    @JsonProperty("pnlDaiitu")
    public void setPnlDaiitu(pnlDaiituDiv pnlDaiitu) {
        this.pnlDaiitu = pnlDaiitu;
    }

    /*
     * getpnlGokei
     * @return pnlGokei
     */
    @JsonProperty("pnlGokei")
    public pnlGokeiDiv getPnlGokei() {
        return pnlGokei;
    }

    /*
     * setpnlGokei
     * @param pnlGokei pnlGokei
     */
    @JsonProperty("pnlGokei")
    public void setPnlGokei(pnlGokeiDiv pnlGokei) {
        this.pnlGokei = pnlGokei;
    }

    /*
     * getpnlSaikeiDaisan
     * @return pnlSaikeiDaisan
     */
    @JsonProperty("pnlSaikeiDaisan")
    public pnlSaikeiDaisanDiv getPnlSaikeiDaisan() {
        return pnlSaikeiDaisan;
    }

    /*
     * setpnlSaikeiDaisan
     * @param pnlSaikeiDaisan pnlSaikeiDaisan
     */
    @JsonProperty("pnlSaikeiDaisan")
    public void setPnlSaikeiDaisan(pnlSaikeiDaisanDiv pnlSaikeiDaisan) {
        this.pnlSaikeiDaisan = pnlSaikeiDaisan;
    }

    /*
     * getpnlSaikeiDaini
     * @return pnlSaikeiDaini
     */
    @JsonProperty("pnlSaikeiDaini")
    public pnlSaikeiDainiDiv getPnlSaikeiDaini() {
        return pnlSaikeiDaini;
    }

    /*
     * setpnlSaikeiDaini
     * @param pnlSaikeiDaini pnlSaikeiDaini
     */
    @JsonProperty("pnlSaikeiDaini")
    public void setPnlSaikeiDaini(pnlSaikeiDainiDiv pnlSaikeiDaini) {
        this.pnlSaikeiDaini = pnlSaikeiDaini;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tbp1Div getTbp1() {
        return this.getPnlDaiyon().getTbp1();
    }

    @JsonIgnore
    public void  setTbp1(tbp1Div tbp1) {
        this.getPnlDaiyon().setTbp1(tbp1);
    }

    @JsonIgnore
    public tbp2Div getTbp2() {
        return this.getPnlDaisan().getTbp2();
    }

    @JsonIgnore
    public void  setTbp2(tbp2Div tbp2) {
        this.getPnlDaisan().setTbp2(tbp2);
    }

    @JsonIgnore
    public tbp3Div getTbp3() {
        return this.getPnlDaini().getTbp3();
    }

    @JsonIgnore
    public void  setTbp3(tbp3Div tbp3) {
        this.getPnlDaini().setTbp3(tbp3);
    }

    @JsonIgnore
    public tbp4Div getTbp4() {
        return this.getPnlDaiitu().getTbp4();
    }

    @JsonIgnore
    public void  setTbp4(tbp4Div tbp4) {
        this.getPnlDaiitu().setTbp4(tbp4);
    }

    @JsonIgnore
    public tbp5Div getTbp5() {
        return this.getPnlGokei().getTbp5();
    }

    @JsonIgnore
    public void  setTbp5(tbp5Div tbp5) {
        this.getPnlGokei().setTbp5(tbp5);
    }

    @JsonIgnore
    public tbp6Div getTbp6() {
        return this.getPnlSaikeiDaisan().getTbp6();
    }

    @JsonIgnore
    public void  setTbp6(tbp6Div tbp6) {
        this.getPnlSaikeiDaisan().setTbp6(tbp6);
    }

    @JsonIgnore
    public tbp7Div getTbp7() {
        return this.getPnlSaikeiDaini().getTbp7();
    }

    @JsonIgnore
    public void  setTbp7(tbp7Div tbp7) {
        this.getPnlSaikeiDaini().setTbp7(tbp7);
    }

    // </editor-fold>
}
