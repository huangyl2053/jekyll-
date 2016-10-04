package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KokuhoShikaku のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KokuhoShikakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokuhoHokenshaNo")
    private TextBox txtKokuhoHokenshaNo;
    @JsonProperty("txtKokuhoHokenshaMeisho")
    private TextBox txtKokuhoHokenshaMeisho;
    @JsonProperty("txtKokuhoHikonenshaShoKigo")
    private TextBox txtKokuhoHikonenshaShoKigo;
    @JsonProperty("txtKokuhoHikonenshaShoNo")
    private TextBox txtKokuhoHikonenshaShoNo;
    @JsonProperty("txtKokuhoSetaiNo")
    private TextBox txtKokuhoSetaiNo;
    @JsonProperty("txtKokuhoZokugara")
    private DropDownList txtKokuhoZokugara;
    @JsonProperty("txtKokuhoKanyuKikanYMD")
    private TextBoxDateRange txtKokuhoKanyuKikanYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKokuhoHokenshaNo
     * @return txtKokuhoHokenshaNo
     */
    @JsonProperty("txtKokuhoHokenshaNo")
    public TextBox getTxtKokuhoHokenshaNo() {
        return txtKokuhoHokenshaNo;
    }

    /*
     * settxtKokuhoHokenshaNo
     * @param txtKokuhoHokenshaNo txtKokuhoHokenshaNo
     */
    @JsonProperty("txtKokuhoHokenshaNo")
    public void setTxtKokuhoHokenshaNo(TextBox txtKokuhoHokenshaNo) {
        this.txtKokuhoHokenshaNo = txtKokuhoHokenshaNo;
    }

    /*
     * gettxtKokuhoHokenshaMeisho
     * @return txtKokuhoHokenshaMeisho
     */
    @JsonProperty("txtKokuhoHokenshaMeisho")
    public TextBox getTxtKokuhoHokenshaMeisho() {
        return txtKokuhoHokenshaMeisho;
    }

    /*
     * settxtKokuhoHokenshaMeisho
     * @param txtKokuhoHokenshaMeisho txtKokuhoHokenshaMeisho
     */
    @JsonProperty("txtKokuhoHokenshaMeisho")
    public void setTxtKokuhoHokenshaMeisho(TextBox txtKokuhoHokenshaMeisho) {
        this.txtKokuhoHokenshaMeisho = txtKokuhoHokenshaMeisho;
    }

    /*
     * gettxtKokuhoHikonenshaShoKigo
     * @return txtKokuhoHikonenshaShoKigo
     */
    @JsonProperty("txtKokuhoHikonenshaShoKigo")
    public TextBox getTxtKokuhoHikonenshaShoKigo() {
        return txtKokuhoHikonenshaShoKigo;
    }

    /*
     * settxtKokuhoHikonenshaShoKigo
     * @param txtKokuhoHikonenshaShoKigo txtKokuhoHikonenshaShoKigo
     */
    @JsonProperty("txtKokuhoHikonenshaShoKigo")
    public void setTxtKokuhoHikonenshaShoKigo(TextBox txtKokuhoHikonenshaShoKigo) {
        this.txtKokuhoHikonenshaShoKigo = txtKokuhoHikonenshaShoKigo;
    }

    /*
     * gettxtKokuhoHikonenshaShoNo
     * @return txtKokuhoHikonenshaShoNo
     */
    @JsonProperty("txtKokuhoHikonenshaShoNo")
    public TextBox getTxtKokuhoHikonenshaShoNo() {
        return txtKokuhoHikonenshaShoNo;
    }

    /*
     * settxtKokuhoHikonenshaShoNo
     * @param txtKokuhoHikonenshaShoNo txtKokuhoHikonenshaShoNo
     */
    @JsonProperty("txtKokuhoHikonenshaShoNo")
    public void setTxtKokuhoHikonenshaShoNo(TextBox txtKokuhoHikonenshaShoNo) {
        this.txtKokuhoHikonenshaShoNo = txtKokuhoHikonenshaShoNo;
    }

    /*
     * gettxtKokuhoSetaiNo
     * @return txtKokuhoSetaiNo
     */
    @JsonProperty("txtKokuhoSetaiNo")
    public TextBox getTxtKokuhoSetaiNo() {
        return txtKokuhoSetaiNo;
    }

    /*
     * settxtKokuhoSetaiNo
     * @param txtKokuhoSetaiNo txtKokuhoSetaiNo
     */
    @JsonProperty("txtKokuhoSetaiNo")
    public void setTxtKokuhoSetaiNo(TextBox txtKokuhoSetaiNo) {
        this.txtKokuhoSetaiNo = txtKokuhoSetaiNo;
    }

    /*
     * gettxtKokuhoZokugara
     * @return txtKokuhoZokugara
     */
    @JsonProperty("txtKokuhoZokugara")
    public DropDownList getTxtKokuhoZokugara() {
        return txtKokuhoZokugara;
    }

    /*
     * settxtKokuhoZokugara
     * @param txtKokuhoZokugara txtKokuhoZokugara
     */
    @JsonProperty("txtKokuhoZokugara")
    public void setTxtKokuhoZokugara(DropDownList txtKokuhoZokugara) {
        this.txtKokuhoZokugara = txtKokuhoZokugara;
    }

    /*
     * gettxtKokuhoKanyuKikanYMD
     * @return txtKokuhoKanyuKikanYMD
     */
    @JsonProperty("txtKokuhoKanyuKikanYMD")
    public TextBoxDateRange getTxtKokuhoKanyuKikanYMD() {
        return txtKokuhoKanyuKikanYMD;
    }

    /*
     * settxtKokuhoKanyuKikanYMD
     * @param txtKokuhoKanyuKikanYMD txtKokuhoKanyuKikanYMD
     */
    @JsonProperty("txtKokuhoKanyuKikanYMD")
    public void setTxtKokuhoKanyuKikanYMD(TextBoxDateRange txtKokuhoKanyuKikanYMD) {
        this.txtKokuhoKanyuKikanYMD = txtKokuhoKanyuKikanYMD;
    }

    // </editor-fold>
}
