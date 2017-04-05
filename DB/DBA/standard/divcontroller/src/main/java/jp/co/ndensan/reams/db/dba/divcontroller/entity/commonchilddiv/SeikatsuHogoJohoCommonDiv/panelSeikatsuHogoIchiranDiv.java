package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoCommonDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelSeikatsuHogoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelSeikatsuHogoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-16_09-04-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgRirekiIchiran")
    private DataGrid<dgRirekiIchiran_Row> dgRirekiIchiran;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgRirekiIchiran
     * @return dgRirekiIchiran
     */
    @JsonProperty("dgRirekiIchiran")
    public DataGrid<dgRirekiIchiran_Row> getDgRirekiIchiran() {
        return dgRirekiIchiran;
    }

    /*
     * setdgRirekiIchiran
     * @param dgRirekiIchiran dgRirekiIchiran
     */
    @JsonProperty("dgRirekiIchiran")
    public void setDgRirekiIchiran(DataGrid<dgRirekiIchiran_Row> dgRirekiIchiran) {
        this.dgRirekiIchiran = dgRirekiIchiran;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
}
