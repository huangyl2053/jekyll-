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
 * KanyuRirekiInput のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KanyuRirekiInputDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKanyuRirekiHokenshaMei")
    private TextBox txtKanyuRirekiHokenshaMei;
    @JsonProperty("txtKanyuRirekiKanyuKikanYMD")
    private TextBoxDateRange txtKanyuRirekiKanyuKikanYMD;
    @JsonProperty("txtJikoFutangakuShomeishoSeiriBango")
    private TextBox txtJikoFutangakuShomeishoSeiriBango;
    @JsonProperty("btnKakuteiKanyuRireki")
    private Button btnKakuteiKanyuRireki;
    @JsonProperty("btnBackKanyuRirekiIchiran")
    private Button btnBackKanyuRirekiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKanyuRirekiHokenshaMei
     * @return txtKanyuRirekiHokenshaMei
     */
    @JsonProperty("txtKanyuRirekiHokenshaMei")
    public TextBox getTxtKanyuRirekiHokenshaMei() {
        return txtKanyuRirekiHokenshaMei;
    }

    /*
     * settxtKanyuRirekiHokenshaMei
     * @param txtKanyuRirekiHokenshaMei txtKanyuRirekiHokenshaMei
     */
    @JsonProperty("txtKanyuRirekiHokenshaMei")
    public void setTxtKanyuRirekiHokenshaMei(TextBox txtKanyuRirekiHokenshaMei) {
        this.txtKanyuRirekiHokenshaMei = txtKanyuRirekiHokenshaMei;
    }

    /*
     * gettxtKanyuRirekiKanyuKikanYMD
     * @return txtKanyuRirekiKanyuKikanYMD
     */
    @JsonProperty("txtKanyuRirekiKanyuKikanYMD")
    public TextBoxDateRange getTxtKanyuRirekiKanyuKikanYMD() {
        return txtKanyuRirekiKanyuKikanYMD;
    }

    /*
     * settxtKanyuRirekiKanyuKikanYMD
     * @param txtKanyuRirekiKanyuKikanYMD txtKanyuRirekiKanyuKikanYMD
     */
    @JsonProperty("txtKanyuRirekiKanyuKikanYMD")
    public void setTxtKanyuRirekiKanyuKikanYMD(TextBoxDateRange txtKanyuRirekiKanyuKikanYMD) {
        this.txtKanyuRirekiKanyuKikanYMD = txtKanyuRirekiKanyuKikanYMD;
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
     * getbtnKakuteiKanyuRireki
     * @return btnKakuteiKanyuRireki
     */
    @JsonProperty("btnKakuteiKanyuRireki")
    public Button getBtnKakuteiKanyuRireki() {
        return btnKakuteiKanyuRireki;
    }

    /*
     * setbtnKakuteiKanyuRireki
     * @param btnKakuteiKanyuRireki btnKakuteiKanyuRireki
     */
    @JsonProperty("btnKakuteiKanyuRireki")
    public void setBtnKakuteiKanyuRireki(Button btnKakuteiKanyuRireki) {
        this.btnKakuteiKanyuRireki = btnKakuteiKanyuRireki;
    }

    /*
     * getbtnBackKanyuRirekiIchiran
     * @return btnBackKanyuRirekiIchiran
     */
    @JsonProperty("btnBackKanyuRirekiIchiran")
    public Button getBtnBackKanyuRirekiIchiran() {
        return btnBackKanyuRirekiIchiran;
    }

    /*
     * setbtnBackKanyuRirekiIchiran
     * @param btnBackKanyuRirekiIchiran btnBackKanyuRirekiIchiran
     */
    @JsonProperty("btnBackKanyuRirekiIchiran")
    public void setBtnBackKanyuRirekiIchiran(Button btnBackKanyuRirekiIchiran) {
        this.btnBackKanyuRirekiIchiran = btnBackKanyuRirekiIchiran;
    }

    // </editor-fold>
}
