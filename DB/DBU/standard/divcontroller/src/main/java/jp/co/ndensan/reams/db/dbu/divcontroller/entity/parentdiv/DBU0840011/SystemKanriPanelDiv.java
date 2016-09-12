package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SystemKanriPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SystemKanriPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SystemKanri")
    private SystemKanriDiv SystemKanri;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("hdnTxtDonyuKeitaiCode")
    private RString hdnTxtDonyuKeitaiCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSystemKanri
     * @return SystemKanri
     */
    @JsonProperty("SystemKanri")
    public SystemKanriDiv getSystemKanri() {
        return SystemKanri;
    }

    /*
     * setSystemKanri
     * @param SystemKanri SystemKanri
     */
    @JsonProperty("SystemKanri")
    public void setSystemKanri(SystemKanriDiv SystemKanri) {
        this.SystemKanri = SystemKanri;
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
     * gethdnTxtDonyuKeitaiCode
     * @return hdnTxtDonyuKeitaiCode
     */
    @JsonProperty("hdnTxtDonyuKeitaiCode")
    public RString getHdnTxtDonyuKeitaiCode() {
        return hdnTxtDonyuKeitaiCode;
    }

    /*
     * sethdnTxtDonyuKeitaiCode
     * @param hdnTxtDonyuKeitaiCode hdnTxtDonyuKeitaiCode
     */
    @JsonProperty("hdnTxtDonyuKeitaiCode")
    public void setHdnTxtDonyuKeitaiCode(RString hdnTxtDonyuKeitaiCode) {
        this.hdnTxtDonyuKeitaiCode = hdnTxtDonyuKeitaiCode;
    }

    // </editor-fold>
}
