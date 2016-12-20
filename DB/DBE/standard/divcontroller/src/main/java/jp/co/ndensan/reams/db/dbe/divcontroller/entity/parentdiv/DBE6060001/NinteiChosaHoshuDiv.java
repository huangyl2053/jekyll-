package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6060001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaHoshu のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaHoshuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgNinteiChosaHoshu")
    private DataGrid<dgNinteiChosaHoshu_Row> dgNinteiChosaHoshu;
    @JsonProperty("txtZaitakuShokai")
    private TextBoxNum txtZaitakuShokai;
    @JsonProperty("txtZaitakuSaichosa")
    private TextBoxNum txtZaitakuSaichosa;
    @JsonProperty("txtShisetsuShokai")
    private TextBoxNum txtShisetsuShokai;
    @JsonProperty("txtShisetsuSaichosa")
    private TextBoxNum txtShisetsuSaichosa;
    @JsonProperty("txtItakuryoGokei")
    private TextBoxNum txtItakuryoGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgNinteiChosaHoshu
     * @return dgNinteiChosaHoshu
     */
    @JsonProperty("dgNinteiChosaHoshu")
    public DataGrid<dgNinteiChosaHoshu_Row> getDgNinteiChosaHoshu() {
        return dgNinteiChosaHoshu;
    }

    /*
     * setdgNinteiChosaHoshu
     * @param dgNinteiChosaHoshu dgNinteiChosaHoshu
     */
    @JsonProperty("dgNinteiChosaHoshu")
    public void setDgNinteiChosaHoshu(DataGrid<dgNinteiChosaHoshu_Row> dgNinteiChosaHoshu) {
        this.dgNinteiChosaHoshu = dgNinteiChosaHoshu;
    }

    /*
     * gettxtZaitakuShokai
     * @return txtZaitakuShokai
     */
    @JsonProperty("txtZaitakuShokai")
    public TextBoxNum getTxtZaitakuShokai() {
        return txtZaitakuShokai;
    }

    /*
     * settxtZaitakuShokai
     * @param txtZaitakuShokai txtZaitakuShokai
     */
    @JsonProperty("txtZaitakuShokai")
    public void setTxtZaitakuShokai(TextBoxNum txtZaitakuShokai) {
        this.txtZaitakuShokai = txtZaitakuShokai;
    }

    /*
     * gettxtZaitakuSaichosa
     * @return txtZaitakuSaichosa
     */
    @JsonProperty("txtZaitakuSaichosa")
    public TextBoxNum getTxtZaitakuSaichosa() {
        return txtZaitakuSaichosa;
    }

    /*
     * settxtZaitakuSaichosa
     * @param txtZaitakuSaichosa txtZaitakuSaichosa
     */
    @JsonProperty("txtZaitakuSaichosa")
    public void setTxtZaitakuSaichosa(TextBoxNum txtZaitakuSaichosa) {
        this.txtZaitakuSaichosa = txtZaitakuSaichosa;
    }

    /*
     * gettxtShisetsuShokai
     * @return txtShisetsuShokai
     */
    @JsonProperty("txtShisetsuShokai")
    public TextBoxNum getTxtShisetsuShokai() {
        return txtShisetsuShokai;
    }

    /*
     * settxtShisetsuShokai
     * @param txtShisetsuShokai txtShisetsuShokai
     */
    @JsonProperty("txtShisetsuShokai")
    public void setTxtShisetsuShokai(TextBoxNum txtShisetsuShokai) {
        this.txtShisetsuShokai = txtShisetsuShokai;
    }

    /*
     * gettxtShisetsuSaichosa
     * @return txtShisetsuSaichosa
     */
    @JsonProperty("txtShisetsuSaichosa")
    public TextBoxNum getTxtShisetsuSaichosa() {
        return txtShisetsuSaichosa;
    }

    /*
     * settxtShisetsuSaichosa
     * @param txtShisetsuSaichosa txtShisetsuSaichosa
     */
    @JsonProperty("txtShisetsuSaichosa")
    public void setTxtShisetsuSaichosa(TextBoxNum txtShisetsuSaichosa) {
        this.txtShisetsuSaichosa = txtShisetsuSaichosa;
    }

    /*
     * gettxtItakuryoGokei
     * @return txtItakuryoGokei
     */
    @JsonProperty("txtItakuryoGokei")
    public TextBoxNum getTxtItakuryoGokei() {
        return txtItakuryoGokei;
    }

    /*
     * settxtItakuryoGokei
     * @param txtItakuryoGokei txtItakuryoGokei
     */
    @JsonProperty("txtItakuryoGokei")
    public void setTxtItakuryoGokei(TextBoxNum txtItakuryoGokei) {
        this.txtItakuryoGokei = txtItakuryoGokei;
    }

    // </editor-fold>
}
