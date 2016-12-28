package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.sonotakikanguide.SonotaKikanGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SelectIchiran のクラスファイル 
 * 
 */
public class SelectIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSonotaKikanIchiran")
    private DataGrid<dgSonotaKikanIchiran_Row> dgSonotaKikanIchiran;
    @JsonProperty("btnback")
    private Button btnback;
    @JsonProperty("btnResearch")
    private Button btnResearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSonotaKikanIchiran
     * @return dgSonotaKikanIchiran
     */
    @JsonProperty("dgSonotaKikanIchiran")
    public DataGrid<dgSonotaKikanIchiran_Row> getDgSonotaKikanIchiran() {
        return dgSonotaKikanIchiran;
    }

    /*
     * setdgSonotaKikanIchiran
     * @param dgSonotaKikanIchiran dgSonotaKikanIchiran
     */
    @JsonProperty("dgSonotaKikanIchiran")
    public void setDgSonotaKikanIchiran(DataGrid<dgSonotaKikanIchiran_Row> dgSonotaKikanIchiran) {
        this.dgSonotaKikanIchiran = dgSonotaKikanIchiran;
    }

    /*
     * getbtnback
     * @return btnback
     */
    @JsonProperty("btnback")
    public Button getBtnback() {
        return btnback;
    }

    /*
     * setbtnback
     * @param btnback btnback
     */
    @JsonProperty("btnback")
    public void setBtnback(Button btnback) {
        this.btnback = btnback;
    }

    /*
     * getbtnResearch
     * @return btnResearch
     */
    @JsonProperty("btnResearch")
    public Button getBtnResearch() {
        return btnResearch;
    }

    /*
     * setbtnResearch
     * @param btnResearch btnResearch
     */
    @JsonProperty("btnResearch")
    public void setBtnResearch(Button btnResearch) {
        this.btnResearch = btnResearch;
    }

    // </editor-fold>
}
