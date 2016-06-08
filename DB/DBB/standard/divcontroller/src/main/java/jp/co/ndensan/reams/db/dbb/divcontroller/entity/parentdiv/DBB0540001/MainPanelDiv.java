package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MainPanel のクラスファイル
 *
 * @reamsid_L DBB-1760-010 sunhui
 */
public class MainPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaInfo")
    private AtenaInfoDiv AtenaInfo;
    @JsonProperty("ChoshuInfo")
    private ChoshuInfoDiv ChoshuInfo;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtenaInfo
     * @return AtenaInfo
     */
    @JsonProperty("AtenaInfo")
    public AtenaInfoDiv getAtenaInfo() {
        return AtenaInfo;
    }

    /*
     * setAtenaInfo
     * @param AtenaInfo AtenaInfo
     */
    @JsonProperty("AtenaInfo")
    public void setAtenaInfo(AtenaInfoDiv AtenaInfo) {
        this.AtenaInfo = AtenaInfo;
    }

    /*
     * getChoshuInfo
     * @return ChoshuInfo
     */
    @JsonProperty("ChoshuInfo")
    public ChoshuInfoDiv getChoshuInfo() {
        return ChoshuInfo;
    }

    /*
     * setChoshuInfo
     * @param ChoshuInfo ChoshuInfo
     */
    @JsonProperty("ChoshuInfo")
    public void setChoshuInfo(ChoshuInfoDiv ChoshuInfo) {
        this.ChoshuInfo = ChoshuInfo;
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
