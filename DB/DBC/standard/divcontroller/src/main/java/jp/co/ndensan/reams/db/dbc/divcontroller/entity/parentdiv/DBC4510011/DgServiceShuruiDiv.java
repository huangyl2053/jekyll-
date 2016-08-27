package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DgServiceShurui のクラスファイル 
 * 
 * @author 自動生成
 */
public class DgServiceShuruiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTsuika")
    private Button btnTsuika;
    @JsonProperty("dgServiceShurui")
    private DataGrid<dgServiceShurui_Row> dgServiceShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTsuika
     * @return btnTsuika
     */
    @JsonProperty("btnTsuika")
    public Button getBtnTsuika() {
        return btnTsuika;
    }

    /*
     * setbtnTsuika
     * @param btnTsuika btnTsuika
     */
    @JsonProperty("btnTsuika")
    public void setBtnTsuika(Button btnTsuika) {
        this.btnTsuika = btnTsuika;
    }

    /*
     * getdgServiceShurui
     * @return dgServiceShurui
     */
    @JsonProperty("dgServiceShurui")
    public DataGrid<dgServiceShurui_Row> getDgServiceShurui() {
        return dgServiceShurui;
    }

    /*
     * setdgServiceShurui
     * @param dgServiceShurui dgServiceShurui
     */
    @JsonProperty("dgServiceShurui")
    public void setDgServiceShurui(DataGrid<dgServiceShurui_Row> dgServiceShurui) {
        this.dgServiceShurui = dgServiceShurui;
    }

    // </editor-fold>
}
