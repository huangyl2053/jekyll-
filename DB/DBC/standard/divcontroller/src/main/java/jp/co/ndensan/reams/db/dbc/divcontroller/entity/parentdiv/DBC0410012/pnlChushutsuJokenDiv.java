package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-63">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChushutsuJoken")
    private Label lblChushutsuJoken;
    @JsonProperty("txtShoriJoken")
    private TextBoxDate txtShoriJoken;
    @JsonProperty("txtSaishoriKubun")
    private TextBox txtSaishoriKubun;
    @JsonProperty("txtKokanShikibetsuNo")
    private TextBox txtKokanShikibetsuNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChushutsuJoken
     * @return lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public Label getLblChushutsuJoken() {
        return lblChushutsuJoken;
    }

    /*
     * setlblChushutsuJoken
     * @param lblChushutsuJoken lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public void setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.lblChushutsuJoken = lblChushutsuJoken;
    }

    /*
     * gettxtShoriJoken
     * @return txtShoriJoken
     */
    @JsonProperty("txtShoriJoken")
    public TextBoxDate getTxtShoriJoken() {
        return txtShoriJoken;
    }

    /*
     * settxtShoriJoken
     * @param txtShoriJoken txtShoriJoken
     */
    @JsonProperty("txtShoriJoken")
    public void setTxtShoriJoken(TextBoxDate txtShoriJoken) {
        this.txtShoriJoken = txtShoriJoken;
    }

    /*
     * gettxtSaishoriKubun
     * @return txtSaishoriKubun
     */
    @JsonProperty("txtSaishoriKubun")
    public TextBox getTxtSaishoriKubun() {
        return txtSaishoriKubun;
    }

    /*
     * settxtSaishoriKubun
     * @param txtSaishoriKubun txtSaishoriKubun
     */
    @JsonProperty("txtSaishoriKubun")
    public void setTxtSaishoriKubun(TextBox txtSaishoriKubun) {
        this.txtSaishoriKubun = txtSaishoriKubun;
    }

    /*
     * gettxtKokanShikibetsuNo
     * @return txtKokanShikibetsuNo
     */
    @JsonProperty("txtKokanShikibetsuNo")
    public TextBox getTxtKokanShikibetsuNo() {
        return txtKokanShikibetsuNo;
    }

    /*
     * settxtKokanShikibetsuNo
     * @param txtKokanShikibetsuNo txtKokanShikibetsuNo
     */
    @JsonProperty("txtKokanShikibetsuNo")
    public void setTxtKokanShikibetsuNo(TextBox txtKokanShikibetsuNo) {
        this.txtKokanShikibetsuNo = txtKokanShikibetsuNo;
    }

    // </editor-fold>
}
