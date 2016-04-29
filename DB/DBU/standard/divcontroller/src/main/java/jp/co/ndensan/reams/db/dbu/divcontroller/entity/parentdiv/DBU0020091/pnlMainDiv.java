package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * pnlMain のクラスファイル
 *
 * @reamsid_L DBU-1100-080 lijunjun
 */
public class pnlMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbdHokokuNengetsu")
    private TextBoxDate tbdHokokuNengetsu;
    @JsonProperty("tbdShukeiNengetsu")
    private TextBoxDate tbdShukeiNengetsu;
    @JsonProperty("pnlYosikiHosei")
    private TextBox pnlYosikiHosei;
    @JsonProperty("tbHokensyaName")
    private TextBox tbHokensyaName;
    @JsonProperty("pnlServive1")
    private pnlServive1Div pnlServive1;
    @JsonProperty("pnlService2")
    private pnlService2Div pnlService2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbdHokokuNengetsu
     * @return tbdHokokuNengetsu
     */
    @JsonProperty("tbdHokokuNengetsu")
    public TextBoxDate getTbdHokokuNengetsu() {
        return tbdHokokuNengetsu;
    }

    /*
     * settbdHokokuNengetsu
     * @param tbdHokokuNengetsu tbdHokokuNengetsu
     */
    @JsonProperty("tbdHokokuNengetsu")
    public void setTbdHokokuNengetsu(TextBoxDate tbdHokokuNengetsu) {
        this.tbdHokokuNengetsu = tbdHokokuNengetsu;
    }

    /*
     * gettbdShukeiNengetsu
     * @return tbdShukeiNengetsu
     */
    @JsonProperty("tbdShukeiNengetsu")
    public TextBoxDate getTbdShukeiNengetsu() {
        return tbdShukeiNengetsu;
    }

    /*
     * settbdShukeiNengetsu
     * @param tbdShukeiNengetsu tbdShukeiNengetsu
     */
    @JsonProperty("tbdShukeiNengetsu")
    public void setTbdShukeiNengetsu(TextBoxDate tbdShukeiNengetsu) {
        this.tbdShukeiNengetsu = tbdShukeiNengetsu;
    }

    /*
     * getpnlYosikiHosei
     * @return pnlYosikiHosei
     */
    @JsonProperty("pnlYosikiHosei")
    public TextBox getPnlYosikiHosei() {
        return pnlYosikiHosei;
    }

    /*
     * setpnlYosikiHosei
     * @param pnlYosikiHosei pnlYosikiHosei
     */
    @JsonProperty("pnlYosikiHosei")
    public void setPnlYosikiHosei(TextBox pnlYosikiHosei) {
        this.pnlYosikiHosei = pnlYosikiHosei;
    }

    /*
     * gettbHokensyaName
     * @return tbHokensyaName
     */
    @JsonProperty("tbHokensyaName")
    public TextBox getTbHokensyaName() {
        return tbHokensyaName;
    }

    /*
     * settbHokensyaName
     * @param tbHokensyaName tbHokensyaName
     */
    @JsonProperty("tbHokensyaName")
    public void setTbHokensyaName(TextBox tbHokensyaName) {
        this.tbHokensyaName = tbHokensyaName;
    }

    /*
     * getpnlServive1
     * @return pnlServive1
     */
    @JsonProperty("pnlServive1")
    public pnlServive1Div getPnlServive1() {
        return pnlServive1;
    }

    /*
     * setpnlServive1
     * @param pnlServive1 pnlServive1
     */
    @JsonProperty("pnlServive1")
    public void setPnlServive1(pnlServive1Div pnlServive1) {
        this.pnlServive1 = pnlServive1;
    }

    /*
     * getpnlService2
     * @return pnlService2
     */
    @JsonProperty("pnlService2")
    public pnlService2Div getPnlService2() {
        return pnlService2;
    }

    /*
     * setpnlService2
     * @param pnlService2 pnlService2
     */
    @JsonProperty("pnlService2")
    public void setPnlService2(pnlService2Div pnlService2) {
        this.pnlService2 = pnlService2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tbp1Div getTbp1() {
        return this.getPnlServive1().getPnlDaiyon().getTbp1();
    }

    @JsonIgnore
    public void setTbp1(tbp1Div tbp1) {
        this.getPnlServive1().getPnlDaiyon().setTbp1(tbp1);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKensu1() {
        return this.getPnlServive1().getPnlDaiyon().getTbp1().getTxtRiyoshaDaiyonKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKensu2() {
        return this.getPnlServive1().getPnlDaiyon().getTbp1().getTxtRiyoshaDaiyonKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKensu3() {
        return this.getPnlServive1().getPnlDaiyon().getTbp1().getTxtRiyoshaDaiyonKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKyufugaku1() {
        return this.getPnlServive1().getPnlDaiyon().getTbp1().getTxtRiyoshaDaiyonKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKyufugaku2() {
        return this.getPnlServive1().getPnlDaiyon().getTbp1().getTxtRiyoshaDaiyonKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKyufugaku3() {
        return this.getPnlServive1().getPnlDaiyon().getTbp1().getTxtRiyoshaDaiyonKyufugaku3();
    }

    @JsonIgnore
    public tbp2Div getTbp2() {
        return this.getPnlServive1().getPnlDaisan().getTbp2();
    }

    @JsonIgnore
    public void setTbp2(tbp2Div tbp2) {
        this.getPnlServive1().getPnlDaisan().setTbp2(tbp2);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKensu1() {
        return this.getPnlServive1().getPnlDaisan().getTbp2().getTxtRiyoshaDaisanKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKensu2() {
        return this.getPnlServive1().getPnlDaisan().getTbp2().getTxtRiyoshaDaisanKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKensu3() {
        return this.getPnlServive1().getPnlDaisan().getTbp2().getTxtRiyoshaDaisanKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKyufugaku1() {
        return this.getPnlServive1().getPnlDaisan().getTbp2().getTxtRiyoshaDaisanKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKyufugaku2() {
        return this.getPnlServive1().getPnlDaisan().getTbp2().getTxtRiyoshaDaisanKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKyufugaku3() {
        return this.getPnlServive1().getPnlDaisan().getTbp2().getTxtRiyoshaDaisanKyufugaku3();
    }

    @JsonIgnore
    public tbp3Div getTbp3() {
        return this.getPnlServive1().getPnlDaini().getTbp3();
    }

    @JsonIgnore
    public void setTbp3(tbp3Div tbp3) {
        this.getPnlServive1().getPnlDaini().setTbp3(tbp3);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDainiKensu1() {
        return this.getPnlServive1().getPnlDaini().getTbp3().getTxtRiyoshaDainiKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDainiKensu2() {
        return this.getPnlServive1().getPnlDaini().getTbp3().getTxtRiyoshaDainiKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDainiKensu3() {
        return this.getPnlServive1().getPnlDaini().getTbp3().getTxtRiyoshaDainiKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDainiKyufugaku1() {
        return this.getPnlServive1().getPnlDaini().getTbp3().getTxtRiyoshaDainiKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDainiKyufugaku2() {
        return this.getPnlServive1().getPnlDaini().getTbp3().getTxtRiyoshaDainiKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDainiKyufugaku3() {
        return this.getPnlServive1().getPnlDaini().getTbp3().getTxtRiyoshaDainiKyufugaku3();
    }

    @JsonIgnore
    public tbp4Div getTbp4() {
        return this.getPnlServive1().getPnlDaiitu().getTbp4();
    }

    @JsonIgnore
    public void setTbp4(tbp4Div tbp4) {
        this.getPnlServive1().getPnlDaiitu().setTbp4(tbp4);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKensu1() {
        return this.getPnlServive1().getPnlDaiitu().getTbp4().getTxtRiyoshaDaiichiKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKensu2() {
        return this.getPnlServive1().getPnlDaiitu().getTbp4().getTxtRiyoshaDaiichiKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKensu3() {
        return this.getPnlServive1().getPnlDaiitu().getTbp4().getTxtRiyoshaDaiichiKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKyufugaku1() {
        return this.getPnlServive1().getPnlDaiitu().getTbp4().getTxtRiyoshaDaiichiKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKyufugaku2() {
        return this.getPnlServive1().getPnlDaiitu().getTbp4().getTxtRiyoshaDaiichiKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKyufugaku3() {
        return this.getPnlServive1().getPnlDaiitu().getTbp4().getTxtRiyoshaDaiichiKyufugaku3();
    }

    @JsonIgnore
    public tbp5Div getTbp5() {
        return this.getPnlServive1().getPnlGokei().getTbp5();
    }

    @JsonIgnore
    public void setTbp5(tbp5Div tbp5) {
        this.getPnlServive1().getPnlGokei().setTbp5(tbp5);
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKensu1() {
        return this.getPnlServive1().getPnlGokei().getTbp5().getTxtGokeiKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKensu2() {
        return this.getPnlServive1().getPnlGokei().getTbp5().getTxtGokeiKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKensu3() {
        return this.getPnlServive1().getPnlGokei().getTbp5().getTxtGokeiKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyufugaku1() {
        return this.getPnlServive1().getPnlGokei().getTbp5().getTxtGokeiKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyufugaku2() {
        return this.getPnlServive1().getPnlGokei().getTbp5().getTxtGokeiKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyufugaku3() {
        return this.getPnlServive1().getPnlGokei().getTbp5().getTxtGokeiKyufugaku3();
    }

    @JsonIgnore
    public tbp6Div getTbp6() {
        return this.getPnlServive1().getPnlSaikeiDaisan().getTbp6();
    }

    @JsonIgnore
    public void setTbp6(tbp6Div tbp6) {
        this.getPnlServive1().getPnlSaikeiDaisan().setTbp6(tbp6);
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKensu1() {
        return this.getPnlServive1().getPnlSaikeiDaisan().getTbp6().getTxtSaikeiRiyoshaDaisanKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKensu2() {
        return this.getPnlServive1().getPnlSaikeiDaisan().getTbp6().getTxtSaikeiRiyoshaDaisanKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKensu3() {
        return this.getPnlServive1().getPnlSaikeiDaisan().getTbp6().getTxtSaikeiRiyoshaDaisanKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKyufugaku1() {
        return this.getPnlServive1().getPnlSaikeiDaisan().getTbp6().getTxtSaikeiRiyoshaDaisanKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKyufugaku2() {
        return this.getPnlServive1().getPnlSaikeiDaisan().getTbp6().getTxtSaikeiRiyoshaDaisanKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKyufugaku3() {
        return this.getPnlServive1().getPnlSaikeiDaisan().getTbp6().getTxtSaikeiRiyoshaDaisanKyufugaku3();
    }

    @JsonIgnore
    public tbp7Div getTbp7() {
        return this.getPnlServive1().getPnlSaikeiDaini().getTbp7();
    }

    @JsonIgnore
    public void setTbp7(tbp7Div tbp7) {
        this.getPnlServive1().getPnlSaikeiDaini().setTbp7(tbp7);
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKensu1() {
        return this.getPnlServive1().getPnlSaikeiDaini().getTbp7().getTxtSaikeiRiyoshaDainiKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKensu2() {
        return this.getPnlServive1().getPnlSaikeiDaini().getTbp7().getTxtSaikeiRiyoshaDainiKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKensu3() {
        return this.getPnlServive1().getPnlSaikeiDaini().getTbp7().getTxtSaikeiRiyoshaDainiKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKyufugaku1() {
        return this.getPnlServive1().getPnlSaikeiDaini().getTbp7().getTxtSaikeiRiyoshaDainiKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKyufugaku2() {
        return this.getPnlServive1().getPnlSaikeiDaini().getTbp7().getTxtSaikeiRiyoshaDainiKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKyufugaku3() {
        return this.getPnlServive1().getPnlSaikeiDaini().getTbp7().getTxtSaikeiRiyoshaDainiKyufugaku3();
    }

    @JsonIgnore
    public tbpADiv getTbpA() {
        return this.getPnlService2().getPnlA().getTbpA();
    }

    @JsonIgnore
    public void setTbpA(tbpADiv tbpA) {
        this.getPnlService2().getPnlA().setTbpA(tbpA);
    }

    @JsonIgnore
    public TextBoxNum getTxtGenekiKensu() {
        return this.getPnlService2().getPnlA().getTbpA().getTxtGenekiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGenekiKyufugaku() {
        return this.getPnlService2().getPnlA().getTbpA().getTxtGenekiKyufugaku();
    }

    @JsonIgnore
    public tbpIDiv getTbpI() {
        return this.getPnlService2().getPnlI().getTbpI();
    }

    @JsonIgnore
    public void setTbpI(tbpIDiv tbpI) {
        this.getPnlService2().getPnlI().setTbpI(tbpI);
    }

    @JsonIgnore
    public TextBoxNum getTxtIppanKensu() {
        return this.getPnlService2().getPnlI().getTbpI().getTxtIppanKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtIppanKyufugaku() {
        return this.getPnlService2().getPnlI().getTbpI().getTxtIppanKyufugaku();
    }

    @JsonIgnore
    public tbpUDiv getTbpU() {
        return this.getPnlService2().getPnlU().getTbpU();
    }

    @JsonIgnore
    public void setTbpU(tbpUDiv tbpU) {
        this.getPnlService2().getPnlU().setTbpU(tbpU);
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIIKensu() {
        return this.getPnlService2().getPnlU().getTbpU().getTxtTeishotokushaIIKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIIKyufugaku() {
        return this.getPnlService2().getPnlU().getTbpU().getTxtTeishotokushaIIKyufugaku();
    }

    @JsonIgnore
    public tbpEDiv getTbpE() {
        return this.getPnlService2().getPnlE().getTbpE();
    }

    @JsonIgnore
    public void setTbpE(tbpEDiv tbpE) {
        this.getPnlService2().getPnlE().setTbpE(tbpE);
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIKensu() {
        return this.getPnlService2().getPnlE().getTbpE().getTxtTeishotokushaIKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIKyufugaku() {
        return this.getPnlService2().getPnlE().getTbpE().getTxtTeishotokushaIKyufugaku();
    }

    @JsonIgnore
    public tbpODiv getTbpO() {
        return this.getPnlService2().getPnlO().getTbpO();
    }

    @JsonIgnore
    public void setTbpO(tbpODiv tbpO) {
        this.getPnlService2().getPnlO().setTbpO(tbpO);
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKensu() {
        return this.getPnlService2().getPnlO().getTbpO().getTxtGokeiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyufugaku() {
        return this.getPnlService2().getPnlO().getTbpO().getTxtGokeiKyufugaku();
    }

    // </editor-fold>
}
