package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
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
    @JsonProperty("Label1")
    private Label Label1;
    @JsonProperty("txtKyufuShurui")
    private TextBoxMultiLine txtKyufuShurui;
    @JsonProperty("Label2")
    private Label Label2;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getLabel1
     * @return Label1
     */
    @JsonProperty("Label1")
    public Label getLabel1() {
        return Label1;
    }

    /*
     * setLabel1
     * @param Label1 Label1
     */
    @JsonProperty("Label1")
    public void setLabel1(Label Label1) {
        this.Label1 = Label1;
    }

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
     * getLabel2
     * @return Label2
     */
    @JsonProperty("Label2")
    public Label getLabel2() {
        return Label2;
    }

    /*
     * setLabel2
     * @param Label2 Label2
     */
    @JsonProperty("Label2")
    public void setLabel2(Label Label2) {
        this.Label2 = Label2;
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
