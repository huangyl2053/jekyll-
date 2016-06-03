package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TekiyoJogaiTotal のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJogaiTotalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("ShikakuKihonJoho")
    private ShikakuKihonJohoDiv ShikakuKihonJoho;
    @JsonProperty("TekiyoJogaiJohoIchiran")
    private TekiyoJogaiJohoIchiranDiv TekiyoJogaiJohoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getShikakuKihonJoho
     * @return ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public ShikakuKihonJohoDiv getShikakuKihonJoho() {
        return ShikakuKihonJoho;
    }

    /*
     * setShikakuKihonJoho
     * @param ShikakuKihonJoho ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public void setShikakuKihonJoho(ShikakuKihonJohoDiv ShikakuKihonJoho) {
        this.ShikakuKihonJoho = ShikakuKihonJoho;
    }

    /*
     * getTekiyoJogaiJohoIchiran
     * @return TekiyoJogaiJohoIchiran
     */
    @JsonProperty("TekiyoJogaiJohoIchiran")
    public TekiyoJogaiJohoIchiranDiv getTekiyoJogaiJohoIchiran() {
        return TekiyoJogaiJohoIchiran;
    }

    /*
     * setTekiyoJogaiJohoIchiran
     * @param TekiyoJogaiJohoIchiran TekiyoJogaiJohoIchiran
     */
    @JsonProperty("TekiyoJogaiJohoIchiran")
    public void setTekiyoJogaiJohoIchiran(TekiyoJogaiJohoIchiranDiv TekiyoJogaiJohoIchiran) {
        this.TekiyoJogaiJohoIchiran = TekiyoJogaiJohoIchiran;
    }

    // </editor-fold>
}
