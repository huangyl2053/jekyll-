package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KakuninJikoMsg のクラスファイル
 *
 * @reamsid_L DBC-0980-290 wangkanglei
 */
public class KakuninJikoMsgDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKakuninJohoMsg")
    private Label lblKakuninJohoMsg;
    @JsonProperty("lblAruBaiMsg")
    private Label lblAruBaiMsg;
    @JsonProperty("lblNaiBaiMsg")
    private Label lblNaiBaiMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKakuninJohoMsg
     * @return lblKakuninJohoMsg
     */
    @JsonProperty("lblKakuninJohoMsg")
    public Label getLblKakuninJohoMsg() {
        return lblKakuninJohoMsg;
    }

    /*
     * setlblKakuninJohoMsg
     * @param lblKakuninJohoMsg lblKakuninJohoMsg
     */
    @JsonProperty("lblKakuninJohoMsg")
    public void setLblKakuninJohoMsg(Label lblKakuninJohoMsg) {
        this.lblKakuninJohoMsg = lblKakuninJohoMsg;
    }

    /*
     * getlblAruBaiMsg
     * @return lblAruBaiMsg
     */
    @JsonProperty("lblAruBaiMsg")
    public Label getLblAruBaiMsg() {
        return lblAruBaiMsg;
    }

    /*
     * setlblAruBaiMsg
     * @param lblAruBaiMsg lblAruBaiMsg
     */
    @JsonProperty("lblAruBaiMsg")
    public void setLblAruBaiMsg(Label lblAruBaiMsg) {
        this.lblAruBaiMsg = lblAruBaiMsg;
    }

    /*
     * getlblNaiBaiMsg
     * @return lblNaiBaiMsg
     */
    @JsonProperty("lblNaiBaiMsg")
    public Label getLblNaiBaiMsg() {
        return lblNaiBaiMsg;
    }

    /*
     * setlblNaiBaiMsg
     * @param lblNaiBaiMsg lblNaiBaiMsg
     */
    @JsonProperty("lblNaiBaiMsg")
    public void setLblNaiBaiMsg(Label lblNaiBaiMsg) {
        this.lblNaiBaiMsg = lblNaiBaiMsg;
    }

    // </editor-fold>
}
