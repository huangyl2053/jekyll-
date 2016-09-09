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
 * KokiShikakuJohoPanel のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KokiShikakuJohoPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokiShikaku")
    private TextBox txtKokiShikaku;
    @JsonProperty("txtKokiShikaku2")
    private TextBox txtKokiShikaku2;
    @JsonProperty("txtKokiShikaku3")
    private TextBox txtKokiShikaku3;
    @JsonProperty("txtKokiShikakuKanyuKikan")
    private TextBoxDateRange txtKokiShikakuKanyuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKokiShikaku
     * @return txtKokiShikaku
     */
    @JsonProperty("txtKokiShikaku")
    public TextBox getTxtKokiShikaku() {
        return txtKokiShikaku;
    }

    /*
     * settxtKokiShikaku
     * @param txtKokiShikaku txtKokiShikaku
     */
    @JsonProperty("txtKokiShikaku")
    public void setTxtKokiShikaku(TextBox txtKokiShikaku) {
        this.txtKokiShikaku = txtKokiShikaku;
    }

    /*
     * gettxtKokiShikaku2
     * @return txtKokiShikaku2
     */
    @JsonProperty("txtKokiShikaku2")
    public TextBox getTxtKokiShikaku2() {
        return txtKokiShikaku2;
    }

    /*
     * settxtKokiShikaku2
     * @param txtKokiShikaku2 txtKokiShikaku2
     */
    @JsonProperty("txtKokiShikaku2")
    public void setTxtKokiShikaku2(TextBox txtKokiShikaku2) {
        this.txtKokiShikaku2 = txtKokiShikaku2;
    }

    /*
     * gettxtKokiShikaku3
     * @return txtKokiShikaku3
     */
    @JsonProperty("txtKokiShikaku3")
    public TextBox getTxtKokiShikaku3() {
        return txtKokiShikaku3;
    }

    /*
     * settxtKokiShikaku3
     * @param txtKokiShikaku3 txtKokiShikaku3
     */
    @JsonProperty("txtKokiShikaku3")
    public void setTxtKokiShikaku3(TextBox txtKokiShikaku3) {
        this.txtKokiShikaku3 = txtKokiShikaku3;
    }

    /*
     * gettxtKokiShikakuKanyuKikan
     * @return txtKokiShikakuKanyuKikan
     */
    @JsonProperty("txtKokiShikakuKanyuKikan")
    public TextBoxDateRange getTxtKokiShikakuKanyuKikan() {
        return txtKokiShikakuKanyuKikan;
    }

    /*
     * settxtKokiShikakuKanyuKikan
     * @param txtKokiShikakuKanyuKikan txtKokiShikakuKanyuKikan
     */
    @JsonProperty("txtKokiShikakuKanyuKikan")
    public void setTxtKokiShikakuKanyuKikan(TextBoxDateRange txtKokiShikakuKanyuKikan) {
        this.txtKokiShikakuKanyuKikan = txtKokiShikakuKanyuKikan;
    }

    // </editor-fold>
}
