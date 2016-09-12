package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * HosokuMKoikiPanel のクラスファイル
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public class HosokuMKoikiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHosokuM2")
    private TextBox txtHosokuM2;
    @JsonProperty("txtHosokuM3")
    private TextBox txtHosokuM3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHosokuM2
     * @return txtHosokuM2
     */
    @JsonProperty("txtHosokuM2")
    public TextBox getTxtHosokuM2() {
        return txtHosokuM2;
    }

    /*
     * settxtHosokuM2
     * @param txtHosokuM2 txtHosokuM2
     */
    @JsonProperty("txtHosokuM2")
    public void setTxtHosokuM2(TextBox txtHosokuM2) {
        this.txtHosokuM2 = txtHosokuM2;
    }

    /*
     * gettxtHosokuM3
     * @return txtHosokuM3
     */
    @JsonProperty("txtHosokuM3")
    public TextBox getTxtHosokuM3() {
        return txtHosokuM3;
    }

    /*
     * settxtHosokuM3
     * @param txtHosokuM3 txtHosokuM3
     */
    @JsonProperty("txtHosokuM3")
    public void setTxtHosokuM3(TextBox txtHosokuM3) {
        this.txtHosokuM3 = txtHosokuM3;
    }

    // </editor-fold>
}
