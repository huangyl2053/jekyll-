package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091;
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
 * pnlService2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlService2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlA")
    private pnlADiv pnlA;
    @JsonProperty("pnlI")
    private pnlIDiv pnlI;
    @JsonProperty("pnlU")
    private pnlUDiv pnlU;
    @JsonProperty("pnlE")
    private pnlEDiv pnlE;
    @JsonProperty("pnlO")
    private pnlODiv pnlO;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlA
     * @return pnlA
     */
    @JsonProperty("pnlA")
    public pnlADiv getPnlA() {
        return pnlA;
    }

    /*
     * setpnlA
     * @param pnlA pnlA
     */
    @JsonProperty("pnlA")
    public void setPnlA(pnlADiv pnlA) {
        this.pnlA = pnlA;
    }

    /*
     * getpnlI
     * @return pnlI
     */
    @JsonProperty("pnlI")
    public pnlIDiv getPnlI() {
        return pnlI;
    }

    /*
     * setpnlI
     * @param pnlI pnlI
     */
    @JsonProperty("pnlI")
    public void setPnlI(pnlIDiv pnlI) {
        this.pnlI = pnlI;
    }

    /*
     * getpnlU
     * @return pnlU
     */
    @JsonProperty("pnlU")
    public pnlUDiv getPnlU() {
        return pnlU;
    }

    /*
     * setpnlU
     * @param pnlU pnlU
     */
    @JsonProperty("pnlU")
    public void setPnlU(pnlUDiv pnlU) {
        this.pnlU = pnlU;
    }

    /*
     * getpnlE
     * @return pnlE
     */
    @JsonProperty("pnlE")
    public pnlEDiv getPnlE() {
        return pnlE;
    }

    /*
     * setpnlE
     * @param pnlE pnlE
     */
    @JsonProperty("pnlE")
    public void setPnlE(pnlEDiv pnlE) {
        this.pnlE = pnlE;
    }

    /*
     * getpnlO
     * @return pnlO
     */
    @JsonProperty("pnlO")
    public pnlODiv getPnlO() {
        return pnlO;
    }

    /*
     * setpnlO
     * @param pnlO pnlO
     */
    @JsonProperty("pnlO")
    public void setPnlO(pnlODiv pnlO) {
        this.pnlO = pnlO;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tbpADiv getTbpA() {
        return this.getPnlA().getTbpA();
    }

    @JsonIgnore
    public void  setTbpA(tbpADiv tbpA) {
        this.getPnlA().setTbpA(tbpA);
    }

    @JsonIgnore
    public TextBoxNum getTxtGenekiKensu() {
        return this.getPnlA().getTbpA().getTxtGenekiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGenekiKyufugaku() {
        return this.getPnlA().getTbpA().getTxtGenekiKyufugaku();
    }

    @JsonIgnore
    public tbpIDiv getTbpI() {
        return this.getPnlI().getTbpI();
    }

    @JsonIgnore
    public void  setTbpI(tbpIDiv tbpI) {
        this.getPnlI().setTbpI(tbpI);
    }

    @JsonIgnore
    public TextBoxNum getTxtIppanKensu() {
        return this.getPnlI().getTbpI().getTxtIppanKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtIppanKyufugaku() {
        return this.getPnlI().getTbpI().getTxtIppanKyufugaku();
    }

    @JsonIgnore
    public tbpUDiv getTbpU() {
        return this.getPnlU().getTbpU();
    }

    @JsonIgnore
    public void  setTbpU(tbpUDiv tbpU) {
        this.getPnlU().setTbpU(tbpU);
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIIKensu() {
        return this.getPnlU().getTbpU().getTxtTeishotokushaIIKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIIKyufugaku() {
        return this.getPnlU().getTbpU().getTxtTeishotokushaIIKyufugaku();
    }

    @JsonIgnore
    public tbpEDiv getTbpE() {
        return this.getPnlE().getTbpE();
    }

    @JsonIgnore
    public void  setTbpE(tbpEDiv tbpE) {
        this.getPnlE().setTbpE(tbpE);
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIKensu() {
        return this.getPnlE().getTbpE().getTxtTeishotokushaIKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIKyufugaku() {
        return this.getPnlE().getTbpE().getTxtTeishotokushaIKyufugaku();
    }

    @JsonIgnore
    public tbpODiv getTbpO() {
        return this.getPnlO().getTbpO();
    }

    @JsonIgnore
    public void  setTbpO(tbpODiv tbpO) {
        this.getPnlO().setTbpO(tbpO);
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKensu() {
        return this.getPnlO().getTbpO().getTxtGokeiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyufugaku() {
        return this.getPnlO().getTbpO().getTxtGokeiKyufugaku();
    }

    // </editor-fold>
}
