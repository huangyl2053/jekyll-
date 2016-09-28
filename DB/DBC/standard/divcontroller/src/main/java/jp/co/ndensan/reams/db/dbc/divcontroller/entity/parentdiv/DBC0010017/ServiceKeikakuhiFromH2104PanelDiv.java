package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceKeikakuhiFromH2104Panel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceKeikakuhiFromH2104PanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTitle1")
    private Label lblTitle1;
    @JsonProperty("dgServiceKeikakuhiFromH2104")
    private DataGrid<dgServiceKeikakuhiFromH2104_Row> dgServiceKeikakuhiFromH2104;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTitle1
     * @return lblTitle1
     */
    @JsonProperty("lblTitle1")
    public Label getLblTitle1() {
        return lblTitle1;
    }

    /*
     * setlblTitle1
     * @param lblTitle1 lblTitle1
     */
    @JsonProperty("lblTitle1")
    public void setLblTitle1(Label lblTitle1) {
        this.lblTitle1 = lblTitle1;
    }

    /*
     * getdgServiceKeikakuhiFromH2104
     * @return dgServiceKeikakuhiFromH2104
     */
    @JsonProperty("dgServiceKeikakuhiFromH2104")
    public DataGrid<dgServiceKeikakuhiFromH2104_Row> getDgServiceKeikakuhiFromH2104() {
        return dgServiceKeikakuhiFromH2104;
    }

    /*
     * setdgServiceKeikakuhiFromH2104
     * @param dgServiceKeikakuhiFromH2104 dgServiceKeikakuhiFromH2104
     */
    @JsonProperty("dgServiceKeikakuhiFromH2104")
    public void setDgServiceKeikakuhiFromH2104(DataGrid<dgServiceKeikakuhiFromH2104_Row> dgServiceKeikakuhiFromH2104) {
        this.dgServiceKeikakuhiFromH2104 = dgServiceKeikakuhiFromH2104;
    }

    // </editor-fold>
}
