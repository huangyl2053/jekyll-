package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * printShiji のクラスファイル
 *
 * @reamsid_L DBC-5110-010 xupeng
 */
public class printShijiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiYmd")
    private TextBoxDate txtSakuseiYmd;
    @JsonProperty("txtJikoSakuseiKeikakuYm")
    private TextBoxDate txtJikoSakuseiKeikakuYm;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSakuseiYmd
     * @return txtSakuseiYmd
     */
    @JsonProperty("txtSakuseiYmd")
    public TextBoxDate getTxtSakuseiYmd() {
        return txtSakuseiYmd;
    }

    /*
     * settxtSakuseiYmd
     * @param txtSakuseiYmd txtSakuseiYmd
     */
    @JsonProperty("txtSakuseiYmd")
    public void setTxtSakuseiYmd(TextBoxDate txtSakuseiYmd) {
        this.txtSakuseiYmd = txtSakuseiYmd;
    }

    /*
     * gettxtJikoSakuseiKeikakuYm
     * @return txtJikoSakuseiKeikakuYm
     */
    @JsonProperty("txtJikoSakuseiKeikakuYm")
    public TextBoxDate getTxtJikoSakuseiKeikakuYm() {
        return txtJikoSakuseiKeikakuYm;
    }

    /*
     * settxtJikoSakuseiKeikakuYm
     * @param txtJikoSakuseiKeikakuYm txtJikoSakuseiKeikakuYm
     */
    @JsonProperty("txtJikoSakuseiKeikakuYm")
    public void setTxtJikoSakuseiKeikakuYm(TextBoxDate txtJikoSakuseiKeikakuYm) {
        this.txtJikoSakuseiKeikakuYm = txtJikoSakuseiKeikakuYm;
    }

    // </editor-fold>
}
