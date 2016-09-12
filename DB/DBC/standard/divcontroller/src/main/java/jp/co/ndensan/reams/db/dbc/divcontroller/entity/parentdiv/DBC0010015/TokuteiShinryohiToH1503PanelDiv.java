package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuteiShinryohiToH1503Panel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiShinryohiToH1503PanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTitle2")
    private Label lblTitle2;
    @JsonProperty("dgTokuteiShinryohiToH1503")
    private DataGrid<dgTokuteiShinryohiToH1503_Row> dgTokuteiShinryohiToH1503;

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
     * getdgTokuteiShinryohiToH1503
     * @return dgTokuteiShinryohiToH1503
     */
    @JsonProperty("dgTokuteiShinryohiToH1503")
    public DataGrid<dgTokuteiShinryohiToH1503_Row> getDgTokuteiShinryohiToH1503() {
        return dgTokuteiShinryohiToH1503;
    }

    /*
     * setdgTokuteiShinryohiToH1503
     * @param dgTokuteiShinryohiToH1503 dgTokuteiShinryohiToH1503
     */
    @JsonProperty("dgTokuteiShinryohiToH1503")
    public void setDgTokuteiShinryohiToH1503(DataGrid<dgTokuteiShinryohiToH1503_Row> dgTokuteiShinryohiToH1503) {
        this.dgTokuteiShinryohiToH1503 = dgTokuteiShinryohiToH1503;
    }

    // </editor-fold>
}
