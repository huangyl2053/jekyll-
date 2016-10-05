package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KokiShikaku のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KokiShikakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokiHokenshaNo")
    private TextBox txtKokiHokenshaNo;
    @JsonProperty("txtKokiKoikiRengoMeisho")
    private TextBox txtKokiKoikiRengoMeisho;
    @JsonProperty("txtKokiHihokenshaNo")
    private TextBox txtKokiHihokenshaNo;
    @JsonProperty("txtKokiKanyuKikanYMD")
    private TextBoxDateRange txtKokiKanyuKikanYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKokiHokenshaNo
     * @return txtKokiHokenshaNo
     */
    @JsonProperty("txtKokiHokenshaNo")
    public TextBox getTxtKokiHokenshaNo() {
        return txtKokiHokenshaNo;
    }

    /*
     * settxtKokiHokenshaNo
     * @param txtKokiHokenshaNo txtKokiHokenshaNo
     */
    @JsonProperty("txtKokiHokenshaNo")
    public void setTxtKokiHokenshaNo(TextBox txtKokiHokenshaNo) {
        this.txtKokiHokenshaNo = txtKokiHokenshaNo;
    }

    /*
     * gettxtKokiKoikiRengoMeisho
     * @return txtKokiKoikiRengoMeisho
     */
    @JsonProperty("txtKokiKoikiRengoMeisho")
    public TextBox getTxtKokiKoikiRengoMeisho() {
        return txtKokiKoikiRengoMeisho;
    }

    /*
     * settxtKokiKoikiRengoMeisho
     * @param txtKokiKoikiRengoMeisho txtKokiKoikiRengoMeisho
     */
    @JsonProperty("txtKokiKoikiRengoMeisho")
    public void setTxtKokiKoikiRengoMeisho(TextBox txtKokiKoikiRengoMeisho) {
        this.txtKokiKoikiRengoMeisho = txtKokiKoikiRengoMeisho;
    }

    /*
     * gettxtKokiHihokenshaNo
     * @return txtKokiHihokenshaNo
     */
    @JsonProperty("txtKokiHihokenshaNo")
    public TextBox getTxtKokiHihokenshaNo() {
        return txtKokiHihokenshaNo;
    }

    /*
     * settxtKokiHihokenshaNo
     * @param txtKokiHihokenshaNo txtKokiHihokenshaNo
     */
    @JsonProperty("txtKokiHihokenshaNo")
    public void setTxtKokiHihokenshaNo(TextBox txtKokiHihokenshaNo) {
        this.txtKokiHihokenshaNo = txtKokiHihokenshaNo;
    }

    /*
     * gettxtKokiKanyuKikanYMD
     * @return txtKokiKanyuKikanYMD
     */
    @JsonProperty("txtKokiKanyuKikanYMD")
    public TextBoxDateRange getTxtKokiKanyuKikanYMD() {
        return txtKokiKanyuKikanYMD;
    }

    /*
     * settxtKokiKanyuKikanYMD
     * @param txtKokiKanyuKikanYMD txtKokiKanyuKikanYMD
     */
    @JsonProperty("txtKokiKanyuKikanYMD")
    public void setTxtKokiKanyuKikanYMD(TextBoxDateRange txtKokiKanyuKikanYMD) {
        this.txtKokiKanyuKikanYMD = txtKokiKanyuKikanYMD;
    }

    // </editor-fold>
}
