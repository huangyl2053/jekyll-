package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NijiyoboJohoTaishoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class NijiyoboJohoTaishoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgNijiyoboJohoTaishoIchiran")
    private DataGrid<dgNijiyoboJohoTaishoIchiran_Row> dgNijiyoboJohoTaishoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgNijiyoboJohoTaishoIchiran
     * @return dgNijiyoboJohoTaishoIchiran
     */
    @JsonProperty("dgNijiyoboJohoTaishoIchiran")
    public DataGrid<dgNijiyoboJohoTaishoIchiran_Row> getDgNijiyoboJohoTaishoIchiran() {
        return dgNijiyoboJohoTaishoIchiran;
    }

    /*
     * setdgNijiyoboJohoTaishoIchiran
     * @param dgNijiyoboJohoTaishoIchiran dgNijiyoboJohoTaishoIchiran
     */
    @JsonProperty("dgNijiyoboJohoTaishoIchiran")
    public void setDgNijiyoboJohoTaishoIchiran(DataGrid<dgNijiyoboJohoTaishoIchiran_Row> dgNijiyoboJohoTaishoIchiran) {
        this.dgNijiyoboJohoTaishoIchiran = dgNijiyoboJohoTaishoIchiran;
    }

    // </editor-fold>
}
