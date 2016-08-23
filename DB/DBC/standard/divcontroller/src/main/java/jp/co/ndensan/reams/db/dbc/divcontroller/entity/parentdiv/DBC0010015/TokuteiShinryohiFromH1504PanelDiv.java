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
 * TokuteiShinryohiFromH1504Panel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiShinryohiFromH1504PanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTitle1")
    private Label lblTitle1;
    @JsonProperty("dgTokuteiShinryohiFromH1504")
    private DataGrid<dgTokuteiShinryohiFromH1504_Row> dgTokuteiShinryohiFromH1504;

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
     * getdgTokuteiShinryohiFromH1504
     * @return dgTokuteiShinryohiFromH1504
     */
    @JsonProperty("dgTokuteiShinryohiFromH1504")
    public DataGrid<dgTokuteiShinryohiFromH1504_Row> getDgTokuteiShinryohiFromH1504() {
        return dgTokuteiShinryohiFromH1504;
    }

    /*
     * setdgTokuteiShinryohiFromH1504
     * @param dgTokuteiShinryohiFromH1504 dgTokuteiShinryohiFromH1504
     */
    @JsonProperty("dgTokuteiShinryohiFromH1504")
    public void setDgTokuteiShinryohiFromH1504(DataGrid<dgTokuteiShinryohiFromH1504_Row> dgTokuteiShinryohiFromH1504) {
        this.dgTokuteiShinryohiFromH1504 = dgTokuteiShinryohiFromH1504;
    }

    // </editor-fold>
}
