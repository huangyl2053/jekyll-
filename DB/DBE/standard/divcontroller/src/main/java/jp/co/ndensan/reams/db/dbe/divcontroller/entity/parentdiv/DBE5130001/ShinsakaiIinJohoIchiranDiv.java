package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiIinJohoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinJohoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShinsakaiIinAdd")
    private Button btnShinsakaiIinAdd;
    @JsonProperty("dgShinsaInJohoIchiran")
    private DataGrid<dgShinsaInJohoIchiran_Row> dgShinsaInJohoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShinsakaiIinAdd
     * @return btnShinsakaiIinAdd
     */
    @JsonProperty("btnShinsakaiIinAdd")
    public Button getBtnShinsakaiIinAdd() {
        return btnShinsakaiIinAdd;
    }

    /*
     * setbtnShinsakaiIinAdd
     * @param btnShinsakaiIinAdd btnShinsakaiIinAdd
     */
    @JsonProperty("btnShinsakaiIinAdd")
    public void setBtnShinsakaiIinAdd(Button btnShinsakaiIinAdd) {
        this.btnShinsakaiIinAdd = btnShinsakaiIinAdd;
    }

    /*
     * getdgShinsaInJohoIchiran
     * @return dgShinsaInJohoIchiran
     */
    @JsonProperty("dgShinsaInJohoIchiran")
    public DataGrid<dgShinsaInJohoIchiran_Row> getDgShinsaInJohoIchiran() {
        return dgShinsaInJohoIchiran;
    }

    /*
     * setdgShinsaInJohoIchiran
     * @param dgShinsaInJohoIchiran dgShinsaInJohoIchiran
     */
    @JsonProperty("dgShinsaInJohoIchiran")
    public void setDgShinsaInJohoIchiran(DataGrid<dgShinsaInJohoIchiran_Row> dgShinsaInJohoIchiran) {
        this.dgShinsaInJohoIchiran = dgShinsaInJohoIchiran;
    }

    // </editor-fold>
}
