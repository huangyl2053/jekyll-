package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * Todokedesha のクラスファイル
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public class TodokedeshaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTodokedeshaShimei")
    private TextBoxAtenaMeisho txtTodokedeshaShimei;
    @JsonProperty("txtTodokedeshaKankeiKubun")
    private TextBox txtTodokedeshaKankeiKubun;
    @JsonProperty("txtTodokedeshaShimeiKana")
    private TextBoxAtenaKanaMeisho txtTodokedeshaShimeiKana;
    @JsonProperty("txtTodokedeshaTelNo")
    private TextBoxTelNo txtTodokedeshaTelNo;
    @JsonProperty("txtTodokedeshaYubinNo")
    private TextBoxYubinNo txtTodokedeshaYubinNo;
    @JsonProperty("txtTodokedeshaJusho")
    private TextBox txtTodokedeshaJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTodokedeshaShimei
     * @return txtTodokedeshaShimei
     */
    @JsonProperty("txtTodokedeshaShimei")
    public TextBoxAtenaMeisho getTxtTodokedeshaShimei() {
        return txtTodokedeshaShimei;
    }

    /*
     * settxtTodokedeshaShimei
     * @param txtTodokedeshaShimei txtTodokedeshaShimei
     */
    @JsonProperty("txtTodokedeshaShimei")
    public void setTxtTodokedeshaShimei(TextBoxAtenaMeisho txtTodokedeshaShimei) {
        this.txtTodokedeshaShimei = txtTodokedeshaShimei;
    }

    /*
     * gettxtTodokedeshaKankeiKubun
     * @return txtTodokedeshaKankeiKubun
     */
    @JsonProperty("txtTodokedeshaKankeiKubun")
    public TextBox getTxtTodokedeshaKankeiKubun() {
        return txtTodokedeshaKankeiKubun;
    }

    /*
     * settxtTodokedeshaKankeiKubun
     * @param txtTodokedeshaKankeiKubun txtTodokedeshaKankeiKubun
     */
    @JsonProperty("txtTodokedeshaKankeiKubun")
    public void setTxtTodokedeshaKankeiKubun(TextBox txtTodokedeshaKankeiKubun) {
        this.txtTodokedeshaKankeiKubun = txtTodokedeshaKankeiKubun;
    }

    /*
     * gettxtTodokedeshaShimeiKana
     * @return txtTodokedeshaShimeiKana
     */
    @JsonProperty("txtTodokedeshaShimeiKana")
    public TextBoxAtenaKanaMeisho getTxtTodokedeshaShimeiKana() {
        return txtTodokedeshaShimeiKana;
    }

    /*
     * settxtTodokedeshaShimeiKana
     * @param txtTodokedeshaShimeiKana txtTodokedeshaShimeiKana
     */
    @JsonProperty("txtTodokedeshaShimeiKana")
    public void setTxtTodokedeshaShimeiKana(TextBoxAtenaKanaMeisho txtTodokedeshaShimeiKana) {
        this.txtTodokedeshaShimeiKana = txtTodokedeshaShimeiKana;
    }

    /*
     * gettxtTodokedeshaTelNo
     * @return txtTodokedeshaTelNo
     */
    @JsonProperty("txtTodokedeshaTelNo")
    public TextBoxTelNo getTxtTodokedeshaTelNo() {
        return txtTodokedeshaTelNo;
    }

    /*
     * settxtTodokedeshaTelNo
     * @param txtTodokedeshaTelNo txtTodokedeshaTelNo
     */
    @JsonProperty("txtTodokedeshaTelNo")
    public void setTxtTodokedeshaTelNo(TextBoxTelNo txtTodokedeshaTelNo) {
        this.txtTodokedeshaTelNo = txtTodokedeshaTelNo;
    }

    /*
     * gettxtTodokedeshaYubinNo
     * @return txtTodokedeshaYubinNo
     */
    @JsonProperty("txtTodokedeshaYubinNo")
    public TextBoxYubinNo getTxtTodokedeshaYubinNo() {
        return txtTodokedeshaYubinNo;
    }

    /*
     * settxtTodokedeshaYubinNo
     * @param txtTodokedeshaYubinNo txtTodokedeshaYubinNo
     */
    @JsonProperty("txtTodokedeshaYubinNo")
    public void setTxtTodokedeshaYubinNo(TextBoxYubinNo txtTodokedeshaYubinNo) {
        this.txtTodokedeshaYubinNo = txtTodokedeshaYubinNo;
    }

    /*
     * gettxtTodokedeshaJusho
     * @return txtTodokedeshaJusho
     */
    @JsonProperty("txtTodokedeshaJusho")
    public TextBox getTxtTodokedeshaJusho() {
        return txtTodokedeshaJusho;
    }

    /*
     * settxtTodokedeshaJusho
     * @param txtTodokedeshaJusho txtTodokedeshaJusho
     */
    @JsonProperty("txtTodokedeshaJusho")
    public void setTxtTodokedeshaJusho(TextBox txtTodokedeshaJusho) {
        this.txtTodokedeshaJusho = txtTodokedeshaJusho;
    }

    // </editor-fold>
}
