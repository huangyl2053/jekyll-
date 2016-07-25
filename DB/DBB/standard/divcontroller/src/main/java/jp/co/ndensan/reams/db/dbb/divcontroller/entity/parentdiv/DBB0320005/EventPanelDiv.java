package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * EventPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class EventPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnForHikaku")
    private Button btnForHikaku;
    @JsonProperty("btnHaveNoRireki")
    private Button btnHaveNoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnForHikaku
     * @return btnForHikaku
     */
    @JsonProperty("btnForHikaku")
    public Button getBtnForHikaku() {
        return btnForHikaku;
    }

    /*
     * setbtnForHikaku
     * @param btnForHikaku btnForHikaku
     */
    @JsonProperty("btnForHikaku")
    public void setBtnForHikaku(Button btnForHikaku) {
        this.btnForHikaku = btnForHikaku;
    }

    /*
     * getbtnHaveNoRireki
     * @return btnHaveNoRireki
     */
    @JsonProperty("btnHaveNoRireki")
    public Button getBtnHaveNoRireki() {
        return btnHaveNoRireki;
    }

    /*
     * setbtnHaveNoRireki
     * @param btnHaveNoRireki btnHaveNoRireki
     */
    @JsonProperty("btnHaveNoRireki")
    public void setBtnHaveNoRireki(Button btnHaveNoRireki) {
        this.btnHaveNoRireki = btnHaveNoRireki;
    }

    // </editor-fold>
}
