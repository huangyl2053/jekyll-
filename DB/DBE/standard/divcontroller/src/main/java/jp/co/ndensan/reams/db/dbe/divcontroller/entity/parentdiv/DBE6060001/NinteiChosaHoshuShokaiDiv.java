package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6060001;
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
 * NinteiChosaHoshuShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaHoshuShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaIraibi")
    private ChosaIraibiDiv ChosaIraibi;
    @JsonProperty("NinteiChosaHoshu")
    private NinteiChosaHoshuDiv NinteiChosaHoshu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosaIraibi
     * @return ChosaIraibi
     */
    @JsonProperty("ChosaIraibi")
    public ChosaIraibiDiv getChosaIraibi() {
        return ChosaIraibi;
    }

    /*
     * setChosaIraibi
     * @param ChosaIraibi ChosaIraibi
     */
    @JsonProperty("ChosaIraibi")
    public void setChosaIraibi(ChosaIraibiDiv ChosaIraibi) {
        this.ChosaIraibi = ChosaIraibi;
    }

    /*
     * getNinteiChosaHoshu
     * @return NinteiChosaHoshu
     */
    @JsonProperty("NinteiChosaHoshu")
    public NinteiChosaHoshuDiv getNinteiChosaHoshu() {
        return NinteiChosaHoshu;
    }

    /*
     * setNinteiChosaHoshu
     * @param NinteiChosaHoshu NinteiChosaHoshu
     */
    @JsonProperty("NinteiChosaHoshu")
    public void setNinteiChosaHoshu(NinteiChosaHoshuDiv NinteiChosaHoshu) {
        this.NinteiChosaHoshu = NinteiChosaHoshu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtChosaIraibi() {
        return this.getChosaIraibi().getTxtChosaIraibi();
    }

    @JsonIgnore
    public void  setTxtChosaIraibi(TextBoxDateRange txtChosaIraibi) {
        this.getChosaIraibi().setTxtChosaIraibi(txtChosaIraibi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getChosaIraibi().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getChosaIraibi().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getChosaIraibi().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getChosaIraibi().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public Button getBtnKensakuClear() {
        return this.getChosaIraibi().getBtnKensakuClear();
    }

    @JsonIgnore
    public void  setBtnKensakuClear(Button btnKensakuClear) {
        this.getChosaIraibi().setBtnKensakuClear(btnKensakuClear);
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosaHoshu_Row> getDgNinteiChosaHoshu() {
        return this.getNinteiChosaHoshu().getDgNinteiChosaHoshu();
    }

    @JsonIgnore
    public void  setDgNinteiChosaHoshu(DataGrid<dgNinteiChosaHoshu_Row> dgNinteiChosaHoshu) {
        this.getNinteiChosaHoshu().setDgNinteiChosaHoshu(dgNinteiChosaHoshu);
    }

    @JsonIgnore
    public TextBoxNum getTxtZaitakuShokai() {
        return this.getNinteiChosaHoshu().getTxtZaitakuShokai();
    }

    @JsonIgnore
    public void  setTxtZaitakuShokai(TextBoxNum txtZaitakuShokai) {
        this.getNinteiChosaHoshu().setTxtZaitakuShokai(txtZaitakuShokai);
    }

    @JsonIgnore
    public TextBoxNum getTxtZaitakuSaichosa() {
        return this.getNinteiChosaHoshu().getTxtZaitakuSaichosa();
    }

    @JsonIgnore
    public void  setTxtZaitakuSaichosa(TextBoxNum txtZaitakuSaichosa) {
        this.getNinteiChosaHoshu().setTxtZaitakuSaichosa(txtZaitakuSaichosa);
    }

    @JsonIgnore
    public TextBoxNum getTxtShisetsuShokai() {
        return this.getNinteiChosaHoshu().getTxtShisetsuShokai();
    }

    @JsonIgnore
    public void  setTxtShisetsuShokai(TextBoxNum txtShisetsuShokai) {
        this.getNinteiChosaHoshu().setTxtShisetsuShokai(txtShisetsuShokai);
    }

    @JsonIgnore
    public TextBoxNum getTxtShisetsuSaichosa() {
        return this.getNinteiChosaHoshu().getTxtShisetsuSaichosa();
    }

    @JsonIgnore
    public void  setTxtShisetsuSaichosa(TextBoxNum txtShisetsuSaichosa) {
        this.getNinteiChosaHoshu().setTxtShisetsuSaichosa(txtShisetsuSaichosa);
    }

    @JsonIgnore
    public TextBoxNum getTxtItakuryoGokei() {
        return this.getNinteiChosaHoshu().getTxtItakuryoGokei();
    }

    @JsonIgnore
    public void  setTxtItakuryoGokei(TextBoxNum txtItakuryoGokei) {
        this.getNinteiChosaHoshu().setTxtItakuryoGokei(txtItakuryoGokei);
    }

    // </editor-fold>
}
