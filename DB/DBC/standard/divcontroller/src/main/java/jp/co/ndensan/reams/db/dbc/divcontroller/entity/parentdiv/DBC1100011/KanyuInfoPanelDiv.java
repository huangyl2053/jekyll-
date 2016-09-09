package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KanyuInfoPanel のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KanyuInfoPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKanyuInfoHokensyaMei")
    private TextBox txtKanyuInfoHokensyaMei;
    @JsonProperty("txtKanyuInfoKanyuKikanYMD")
    private TextBoxDateRange txtKanyuInfoKanyuKikanYMD;
    @JsonProperty("txtJikoFutangakuShomeishoSeiriBango")
    private TextBox txtJikoFutangakuShomeishoSeiriBango;
    @JsonProperty("btnKanyuRirekKakutei")
    private Button btnKanyuRirekKakutei;
    @JsonProperty("btnKanyuRirekiModoru")
    private Button btnKanyuRirekiModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKanyuInfoHokensyaMei
     * @return txtKanyuInfoHokensyaMei
     */
    @JsonProperty("txtKanyuInfoHokensyaMei")
    public TextBox getTxtKanyuInfoHokensyaMei() {
        return txtKanyuInfoHokensyaMei;
    }

    /*
     * settxtKanyuInfoHokensyaMei
     * @param txtKanyuInfoHokensyaMei txtKanyuInfoHokensyaMei
     */
    @JsonProperty("txtKanyuInfoHokensyaMei")
    public void setTxtKanyuInfoHokensyaMei(TextBox txtKanyuInfoHokensyaMei) {
        this.txtKanyuInfoHokensyaMei = txtKanyuInfoHokensyaMei;
    }

    /*
     * gettxtKanyuInfoKanyuKikanYMD
     * @return txtKanyuInfoKanyuKikanYMD
     */
    @JsonProperty("txtKanyuInfoKanyuKikanYMD")
    public TextBoxDateRange getTxtKanyuInfoKanyuKikanYMD() {
        return txtKanyuInfoKanyuKikanYMD;
    }

    /*
     * settxtKanyuInfoKanyuKikanYMD
     * @param txtKanyuInfoKanyuKikanYMD txtKanyuInfoKanyuKikanYMD
     */
    @JsonProperty("txtKanyuInfoKanyuKikanYMD")
    public void setTxtKanyuInfoKanyuKikanYMD(TextBoxDateRange txtKanyuInfoKanyuKikanYMD) {
        this.txtKanyuInfoKanyuKikanYMD = txtKanyuInfoKanyuKikanYMD;
    }

    /*
     * gettxtJikoFutangakuShomeishoSeiriBango
     * @return txtJikoFutangakuShomeishoSeiriBango
     */
    @JsonProperty("txtJikoFutangakuShomeishoSeiriBango")
    public TextBox getTxtJikoFutangakuShomeishoSeiriBango() {
        return txtJikoFutangakuShomeishoSeiriBango;
    }

    /*
     * settxtJikoFutangakuShomeishoSeiriBango
     * @param txtJikoFutangakuShomeishoSeiriBango txtJikoFutangakuShomeishoSeiriBango
     */
    @JsonProperty("txtJikoFutangakuShomeishoSeiriBango")
    public void setTxtJikoFutangakuShomeishoSeiriBango(TextBox txtJikoFutangakuShomeishoSeiriBango) {
        this.txtJikoFutangakuShomeishoSeiriBango = txtJikoFutangakuShomeishoSeiriBango;
    }

    /*
     * getbtnKanyuRirekKakutei
     * @return btnKanyuRirekKakutei
     */
    @JsonProperty("btnKanyuRirekKakutei")
    public Button getBtnKanyuRirekKakutei() {
        return btnKanyuRirekKakutei;
    }

    /*
     * setbtnKanyuRirekKakutei
     * @param btnKanyuRirekKakutei btnKanyuRirekKakutei
     */
    @JsonProperty("btnKanyuRirekKakutei")
    public void setBtnKanyuRirekKakutei(Button btnKanyuRirekKakutei) {
        this.btnKanyuRirekKakutei = btnKanyuRirekKakutei;
    }

    /*
     * getbtnKanyuRirekiModoru
     * @return btnKanyuRirekiModoru
     */
    @JsonProperty("btnKanyuRirekiModoru")
    public Button getBtnKanyuRirekiModoru() {
        return btnKanyuRirekiModoru;
    }

    /*
     * setbtnKanyuRirekiModoru
     * @param btnKanyuRirekiModoru btnKanyuRirekiModoru
     */
    @JsonProperty("btnKanyuRirekiModoru")
    public void setBtnKanyuRirekiModoru(Button btnKanyuRirekiModoru) {
        this.btnKanyuRirekiModoru = btnKanyuRirekiModoru;
    }

    // </editor-fold>
}
