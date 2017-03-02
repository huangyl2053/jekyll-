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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShinsakaiIinAdd")
    private Button btnShinsakaiIinAdd;
    @JsonProperty("btnOutputCsv")
    private ButtonDownLoad btnOutputCsv;
    @JsonProperty("btnKozaMitorokuCSV")
    private ButtonDownLoad btnKozaMitorokuCSV;
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
     * getbtnOutputCsv
     * @return btnOutputCsv
     */
    @JsonProperty("btnOutputCsv")
    public ButtonDownLoad getBtnOutputCsv() {
        return btnOutputCsv;
    }

    /*
     * setbtnOutputCsv
     * @param btnOutputCsv btnOutputCsv
     */
    @JsonProperty("btnOutputCsv")
    public void setBtnOutputCsv(ButtonDownLoad btnOutputCsv) {
        this.btnOutputCsv = btnOutputCsv;
    }

    /*
     * getbtnKozaMitorokuCSV
     * @return btnKozaMitorokuCSV
     */
    @JsonProperty("btnKozaMitorokuCSV")
    public ButtonDownLoad getBtnKozaMitorokuCSV() {
        return btnKozaMitorokuCSV;
    }

    /*
     * setbtnKozaMitorokuCSV
     * @param btnKozaMitorokuCSV btnKozaMitorokuCSV
     */
    @JsonProperty("btnKozaMitorokuCSV")
    public void setBtnKozaMitorokuCSV(ButtonDownLoad btnKozaMitorokuCSV) {
        this.btnKozaMitorokuCSV = btnKozaMitorokuCSV;
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
