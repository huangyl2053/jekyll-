package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiIchiBesshi のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiIchiBesshiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YoshikiIchiBesshiHeader")
    private YoshikiIchiBesshiHeaderDiv YoshikiIchiBesshiHeader;
    @JsonProperty("YoshikiIchiBesshiIchi")
    private YoshikiIchiBesshiIchiDiv YoshikiIchiBesshiIchi;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYoshikiIchiBesshiHeader
     * @return YoshikiIchiBesshiHeader
     */
    @JsonProperty("YoshikiIchiBesshiHeader")
    public YoshikiIchiBesshiHeaderDiv getYoshikiIchiBesshiHeader() {
        return YoshikiIchiBesshiHeader;
    }

    /*
     * setYoshikiIchiBesshiHeader
     * @param YoshikiIchiBesshiHeader YoshikiIchiBesshiHeader
     */
    @JsonProperty("YoshikiIchiBesshiHeader")
    public void setYoshikiIchiBesshiHeader(YoshikiIchiBesshiHeaderDiv YoshikiIchiBesshiHeader) {
        this.YoshikiIchiBesshiHeader = YoshikiIchiBesshiHeader;
    }

    /*
     * getYoshikiIchiBesshiIchi
     * @return YoshikiIchiBesshiIchi
     */
    @JsonProperty("YoshikiIchiBesshiIchi")
    public YoshikiIchiBesshiIchiDiv getYoshikiIchiBesshiIchi() {
        return YoshikiIchiBesshiIchi;
    }

    /*
     * setYoshikiIchiBesshiIchi
     * @param YoshikiIchiBesshiIchi YoshikiIchiBesshiIchi
     */
    @JsonProperty("YoshikiIchiBesshiIchi")
    public void setYoshikiIchiBesshiIchi(YoshikiIchiBesshiIchiDiv YoshikiIchiBesshiIchi) {
        this.YoshikiIchiBesshiIchi = YoshikiIchiBesshiIchi;
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

    // </editor-fold>
}
