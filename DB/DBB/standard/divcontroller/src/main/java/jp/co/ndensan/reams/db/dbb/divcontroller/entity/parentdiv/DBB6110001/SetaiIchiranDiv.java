package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SetaiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class SetaiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSetaiIchiran")
    private DataGrid<dgSetaiIchiran_Row> dgSetaiIchiran;
    @JsonProperty("btnRentaiNofuGimushaKensaku")
    private ButtonDialog btnRentaiNofuGimushaKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSetaiIchiran
     * @return dgSetaiIchiran
     */
    @JsonProperty("dgSetaiIchiran")
    public DataGrid<dgSetaiIchiran_Row> getDgSetaiIchiran() {
        return dgSetaiIchiran;
    }

    /*
     * setdgSetaiIchiran
     * @param dgSetaiIchiran dgSetaiIchiran
     */
    @JsonProperty("dgSetaiIchiran")
    public void setDgSetaiIchiran(DataGrid<dgSetaiIchiran_Row> dgSetaiIchiran) {
        this.dgSetaiIchiran = dgSetaiIchiran;
    }

    /*
     * getbtnRentaiNofuGimushaKensaku
     * @return btnRentaiNofuGimushaKensaku
     */
    @JsonProperty("btnRentaiNofuGimushaKensaku")
    public ButtonDialog getBtnRentaiNofuGimushaKensaku() {
        return btnRentaiNofuGimushaKensaku;
    }

    /*
     * setbtnRentaiNofuGimushaKensaku
     * @param btnRentaiNofuGimushaKensaku btnRentaiNofuGimushaKensaku
     */
    @JsonProperty("btnRentaiNofuGimushaKensaku")
    public void setBtnRentaiNofuGimushaKensaku(ButtonDialog btnRentaiNofuGimushaKensaku) {
        this.btnRentaiNofuGimushaKensaku = btnRentaiNofuGimushaKensaku;
    }

    // </editor-fold>
}
