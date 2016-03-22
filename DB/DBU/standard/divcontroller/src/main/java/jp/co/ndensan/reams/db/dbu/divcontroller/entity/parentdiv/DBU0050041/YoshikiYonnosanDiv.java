package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiYonnosan のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiYonnosanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("YoshikiButtonArea")
    private YoshikiButtonAreaDiv YoshikiButtonArea;
    @JsonProperty("YoshikiYonnosanMeisai")
    private YoshikiYonnosanMeisaiDiv YoshikiYonnosanMeisai;

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
     * getYoshikiButtonArea
     * @return YoshikiButtonArea
     */
    @JsonProperty("YoshikiButtonArea")
    public YoshikiButtonAreaDiv getYoshikiButtonArea() {
        return YoshikiButtonArea;
    }

    /*
     * setYoshikiButtonArea
     * @param YoshikiButtonArea YoshikiButtonArea
     */
    @JsonProperty("YoshikiButtonArea")
    public void setYoshikiButtonArea(YoshikiButtonAreaDiv YoshikiButtonArea) {
        this.YoshikiButtonArea = YoshikiButtonArea;
    }

    /*
     * getYoshikiYonnosanMeisai
     * @return YoshikiYonnosanMeisai
     */
    @JsonProperty("YoshikiYonnosanMeisai")
    public YoshikiYonnosanMeisaiDiv getYoshikiYonnosanMeisai() {
        return YoshikiYonnosanMeisai;
    }

    /*
     * setYoshikiYonnosanMeisai
     * @param YoshikiYonnosanMeisai YoshikiYonnosanMeisai
     */
    @JsonProperty("YoshikiYonnosanMeisai")
    public void setYoshikiYonnosanMeisai(YoshikiYonnosanMeisaiDiv YoshikiYonnosanMeisai) {
        this.YoshikiYonnosanMeisai = YoshikiYonnosanMeisai;
    }

    // </editor-fold>
}
