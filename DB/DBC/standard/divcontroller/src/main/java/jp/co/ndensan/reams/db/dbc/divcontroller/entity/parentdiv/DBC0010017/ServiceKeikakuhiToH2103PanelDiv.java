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
 * ServiceKeikakuhiToH2103Panel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceKeikakuhiToH2103PanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTitle2")
    private Label lblTitle2;
    @JsonProperty("dgServiceKeikakuhiToH2103")
    private DataGrid<dgServiceKeikakuhiToH2103_Row> dgServiceKeikakuhiToH2103;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTitle2
     * @return lblTitle2
     */
    @JsonProperty("lblTitle2")
    public Label getLblTitle2() {
        return lblTitle2;
    }

    /*
     * setlblTitle2
     * @param lblTitle2 lblTitle2
     */
    @JsonProperty("lblTitle2")
    public void setLblTitle2(Label lblTitle2) {
        this.lblTitle2 = lblTitle2;
    }

    /*
     * getdgServiceKeikakuhiToH2103
     * @return dgServiceKeikakuhiToH2103
     */
    @JsonProperty("dgServiceKeikakuhiToH2103")
    public DataGrid<dgServiceKeikakuhiToH2103_Row> getDgServiceKeikakuhiToH2103() {
        return dgServiceKeikakuhiToH2103;
    }

    /*
     * setdgServiceKeikakuhiToH2103
     * @param dgServiceKeikakuhiToH2103 dgServiceKeikakuhiToH2103
     */
    @JsonProperty("dgServiceKeikakuhiToH2103")
    public void setDgServiceKeikakuhiToH2103(DataGrid<dgServiceKeikakuhiToH2103_Row> dgServiceKeikakuhiToH2103) {
        this.dgServiceKeikakuhiToH2103 = dgServiceKeikakuhiToH2103;
    }

    // </editor-fold>
}
