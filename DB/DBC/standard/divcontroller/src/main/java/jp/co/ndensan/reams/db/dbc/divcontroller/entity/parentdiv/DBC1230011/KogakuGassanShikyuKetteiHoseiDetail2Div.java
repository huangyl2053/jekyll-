package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * KogakuGassanShikyuKetteiHoseiDetail2 のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiDetail2Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKyufuShurui")
    private TextBoxMultiLine txtKyufuShurui;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKyufuShurui
     * @return txtKyufuShurui
     */
    @JsonProperty("txtKyufuShurui")
    public TextBoxMultiLine getTxtKyufuShurui() {
        return txtKyufuShurui;
    }

    /*
     * settxtKyufuShurui
     * @param txtKyufuShurui txtKyufuShurui
     */
    @JsonProperty("txtKyufuShurui")
    public void setTxtKyufuShurui(TextBoxMultiLine txtKyufuShurui) {
        this.txtKyufuShurui = txtKyufuShurui;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBoxMultiLine getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.txtBiko = txtBiko;
    }

    // </editor-fold>
}
