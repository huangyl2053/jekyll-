package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KaigoShikaku のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KaigoShikakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKanyuKikanYMD")
    private TextBoxDateRange txtKanyuKikanYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKanyuKikanYMD
     * @return txtKanyuKikanYMD
     */
    @JsonProperty("txtKanyuKikanYMD")
    public TextBoxDateRange getTxtKanyuKikanYMD() {
        return txtKanyuKikanYMD;
    }

    /*
     * settxtKanyuKikanYMD
     * @param txtKanyuKikanYMD txtKanyuKikanYMD
     */
    @JsonProperty("txtKanyuKikanYMD")
    public void setTxtKanyuKikanYMD(TextBoxDateRange txtKanyuKikanYMD) {
        this.txtKanyuKikanYMD = txtKanyuKikanYMD;
    }

    // </editor-fold>
}
