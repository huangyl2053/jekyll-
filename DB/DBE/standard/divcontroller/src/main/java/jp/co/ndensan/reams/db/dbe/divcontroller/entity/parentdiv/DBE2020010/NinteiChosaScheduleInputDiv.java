package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaScheduleInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaScheduleInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("WariateJokyo")
    private WariateJokyoDiv WariateJokyo;
    @JsonProperty("ButtonArea")
    private ButtonAreaDiv ButtonArea;
    @JsonProperty("TaishoshaShosai")
    private TaishoshaShosaiDiv TaishoshaShosai;
    @JsonProperty("KaigoKanryoMessage")
    private KaigoKanryoMessageDiv KaigoKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getWariateJokyo
     * @return WariateJokyo
     */
    @JsonProperty("WariateJokyo")
    public WariateJokyoDiv getWariateJokyo() {
        return WariateJokyo;
    }

    /*
     * setWariateJokyo
     * @param WariateJokyo WariateJokyo
     */
    @JsonProperty("WariateJokyo")
    public void setWariateJokyo(WariateJokyoDiv WariateJokyo) {
        this.WariateJokyo = WariateJokyo;
    }

    /*
     * getButtonArea
     * @return ButtonArea
     */
    @JsonProperty("ButtonArea")
    public ButtonAreaDiv getButtonArea() {
        return ButtonArea;
    }

    /*
     * setButtonArea
     * @param ButtonArea ButtonArea
     */
    @JsonProperty("ButtonArea")
    public void setButtonArea(ButtonAreaDiv ButtonArea) {
        this.ButtonArea = ButtonArea;
    }

    /*
     * getTaishoshaShosai
     * @return TaishoshaShosai
     */
    @JsonProperty("TaishoshaShosai")
    public TaishoshaShosaiDiv getTaishoshaShosai() {
        return TaishoshaShosai;
    }

    /*
     * setTaishoshaShosai
     * @param TaishoshaShosai TaishoshaShosai
     */
    @JsonProperty("TaishoshaShosai")
    public void setTaishoshaShosai(TaishoshaShosaiDiv TaishoshaShosai) {
        this.TaishoshaShosai = TaishoshaShosai;
    }

    /*
     * getKaigoKanryoMessage
     * @return KaigoKanryoMessage
     */
    @JsonProperty("KaigoKanryoMessage")
    public KaigoKanryoMessageDiv getKaigoKanryoMessage() {
        return KaigoKanryoMessage;
    }

    /*
     * setKaigoKanryoMessage
     * @param KaigoKanryoMessage KaigoKanryoMessage
     */
    @JsonProperty("KaigoKanryoMessage")
    public void setKaigoKanryoMessage(KaigoKanryoMessageDiv KaigoKanryoMessage) {
        this.KaigoKanryoMessage = KaigoKanryoMessage;
    }

    // </editor-fold>
}
