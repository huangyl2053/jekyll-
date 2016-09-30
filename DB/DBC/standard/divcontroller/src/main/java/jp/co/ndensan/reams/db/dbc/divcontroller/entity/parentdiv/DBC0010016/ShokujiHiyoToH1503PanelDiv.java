package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokujiHiyoToH1503Panel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokujiHiyoToH1503PanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTitle2")
    private Label lblTitle2;
    @JsonProperty("lblGokei2")
    private Label lblGokei2;
    @JsonProperty("dgShokujiHiyoToH1503")
    private DataGrid<dgShokujiHiyoToH1503_Row> dgShokujiHiyoToH1503;

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
     * getlblGokei2
     * @return lblGokei2
     */
    @JsonProperty("lblGokei2")
    public Label getLblGokei2() {
        return lblGokei2;
    }

    /*
     * setlblGokei2
     * @param lblGokei2 lblGokei2
     */
    @JsonProperty("lblGokei2")
    public void setLblGokei2(Label lblGokei2) {
        this.lblGokei2 = lblGokei2;
    }

    /*
     * getdgShokujiHiyoToH1503
     * @return dgShokujiHiyoToH1503
     */
    @JsonProperty("dgShokujiHiyoToH1503")
    public DataGrid<dgShokujiHiyoToH1503_Row> getDgShokujiHiyoToH1503() {
        return dgShokujiHiyoToH1503;
    }

    /*
     * setdgShokujiHiyoToH1503
     * @param dgShokujiHiyoToH1503 dgShokujiHiyoToH1503
     */
    @JsonProperty("dgShokujiHiyoToH1503")
    public void setDgShokujiHiyoToH1503(DataGrid<dgShokujiHiyoToH1503_Row> dgShokujiHiyoToH1503) {
        this.dgShokujiHiyoToH1503 = dgShokujiHiyoToH1503;
    }

    // </editor-fold>
}
