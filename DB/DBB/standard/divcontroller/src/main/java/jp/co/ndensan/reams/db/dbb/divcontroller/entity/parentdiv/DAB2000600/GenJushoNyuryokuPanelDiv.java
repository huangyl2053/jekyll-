package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DAB2000600;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GenJushoNyuryokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class GenJushoNyuryokuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radMaeJusho")
    private RadioButton radMaeJusho;
    @JsonProperty("btnZenkokuJushoTenshutsusaki")
    private Button btnZenkokuJushoTenshutsusaki;
    @JsonProperty("txtZenJusho")
    private TextBox txtZenJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradMaeJusho
     * @return radMaeJusho
     */
    @JsonProperty("radMaeJusho")
    public RadioButton getRadMaeJusho() {
        return radMaeJusho;
    }

    /*
     * setradMaeJusho
     * @param radMaeJusho radMaeJusho
     */
    @JsonProperty("radMaeJusho")
    public void setRadMaeJusho(RadioButton radMaeJusho) {
        this.radMaeJusho = radMaeJusho;
    }

    /*
     * getbtnZenkokuJushoTenshutsusaki
     * @return btnZenkokuJushoTenshutsusaki
     */
    @JsonProperty("btnZenkokuJushoTenshutsusaki")
    public Button getBtnZenkokuJushoTenshutsusaki() {
        return btnZenkokuJushoTenshutsusaki;
    }

    /*
     * setbtnZenkokuJushoTenshutsusaki
     * @param btnZenkokuJushoTenshutsusaki btnZenkokuJushoTenshutsusaki
     */
    @JsonProperty("btnZenkokuJushoTenshutsusaki")
    public void setBtnZenkokuJushoTenshutsusaki(Button btnZenkokuJushoTenshutsusaki) {
        this.btnZenkokuJushoTenshutsusaki = btnZenkokuJushoTenshutsusaki;
    }

    /*
     * gettxtZenJusho
     * @return txtZenJusho
     */
    @JsonProperty("txtZenJusho")
    public TextBox getTxtZenJusho() {
        return txtZenJusho;
    }

    /*
     * settxtZenJusho
     * @param txtZenJusho txtZenJusho
     */
    @JsonProperty("txtZenJusho")
    public void setTxtZenJusho(TextBox txtZenJusho) {
        this.txtZenJusho = txtZenJusho;
    }

    // </editor-fold>
}
