package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NonyuTsuchishoTotal のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class NonyuTsuchishoTotalDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KonkaiShoriNaiyo")
    private KonkaiShoriNaiyoDiv KonkaiShoriNaiyo;
    @JsonProperty("NotsuInfo")
    private NotsuInfoDiv NotsuInfo;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKonkaiShoriNaiyo
     * @return KonkaiShoriNaiyo
     */
    @JsonProperty("KonkaiShoriNaiyo")
    public KonkaiShoriNaiyoDiv getKonkaiShoriNaiyo() {
        return KonkaiShoriNaiyo;
    }

    /*
     * setKonkaiShoriNaiyo
     * @param KonkaiShoriNaiyo KonkaiShoriNaiyo
     */
    @JsonProperty("KonkaiShoriNaiyo")
    public void setKonkaiShoriNaiyo(KonkaiShoriNaiyoDiv KonkaiShoriNaiyo) {
        this.KonkaiShoriNaiyo = KonkaiShoriNaiyo;
    }

    /*
     * getNotsuInfo
     * @return NotsuInfo
     */
    @JsonProperty("NotsuInfo")
    public NotsuInfoDiv getNotsuInfo() {
        return NotsuInfo;
    }

    /*
     * setNotsuInfo
     * @param NotsuInfo NotsuInfo
     */
    @JsonProperty("NotsuInfo")
    public void setNotsuInfo(NotsuInfoDiv NotsuInfo) {
        this.NotsuInfo = NotsuInfo;
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
