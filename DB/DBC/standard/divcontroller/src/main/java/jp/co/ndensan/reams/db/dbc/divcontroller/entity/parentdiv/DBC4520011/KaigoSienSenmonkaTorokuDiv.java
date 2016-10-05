package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoSienSenmonkaToroku のクラスファイル
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KaigoSienSenmonkaTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("KaigoShienSenmoninIchiran")
    private KaigoShienSenmoninIchiranDiv KaigoShienSenmoninIchiran;
    @JsonProperty("KaigoSienSenmoninToroku")
    private KaigoSienSenmoninTorokuDiv KaigoSienSenmoninToroku;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("operateState")
    private RString operateState;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getKaigoShienSenmoninIchiran
     * @return KaigoShienSenmoninIchiran
     */
    @JsonProperty("KaigoShienSenmoninIchiran")
    public KaigoShienSenmoninIchiranDiv getKaigoShienSenmoninIchiran() {
        return KaigoShienSenmoninIchiran;
    }

    /*
     * setKaigoShienSenmoninIchiran
     * @param KaigoShienSenmoninIchiran KaigoShienSenmoninIchiran
     */
    @JsonProperty("KaigoShienSenmoninIchiran")
    public void setKaigoShienSenmoninIchiran(KaigoShienSenmoninIchiranDiv KaigoShienSenmoninIchiran) {
        this.KaigoShienSenmoninIchiran = KaigoShienSenmoninIchiran;
    }

    /*
     * getKaigoSienSenmoninToroku
     * @return KaigoSienSenmoninToroku
     */
    @JsonProperty("KaigoSienSenmoninToroku")
    public KaigoSienSenmoninTorokuDiv getKaigoSienSenmoninToroku() {
        return KaigoSienSenmoninToroku;
    }

    /*
     * setKaigoSienSenmoninToroku
     * @param KaigoSienSenmoninToroku KaigoSienSenmoninToroku
     */
    @JsonProperty("KaigoSienSenmoninToroku")
    public void setKaigoSienSenmoninToroku(KaigoSienSenmoninTorokuDiv KaigoSienSenmoninToroku) {
        this.KaigoSienSenmoninToroku = KaigoSienSenmoninToroku;
    }

    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public KanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * setKanryoMessage
     * @param KanryoMessage KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public void setKanryoMessage(KanryoMessageDiv KanryoMessage) {
        this.KanryoMessage = KanryoMessage;
    }

    /*
     * getoperateState
     * @return operateState
     */
    @JsonProperty("operateState")
    public RString getOperateState() {
        return operateState;
    }

    /*
     * setoperateState
     * @param operateState operateState
     */
    @JsonProperty("operateState")
    public void setOperateState(RString operateState) {
        this.operateState = operateState;
    }

    // </editor-fold>
}
