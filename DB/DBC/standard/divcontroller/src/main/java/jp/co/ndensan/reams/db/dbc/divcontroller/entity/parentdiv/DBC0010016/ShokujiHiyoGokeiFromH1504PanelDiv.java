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
 * ShokujiHiyoGokeiFromH1504Panel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokujiHiyoGokeiFromH1504PanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTitle1")
    private Label lblTitle1;
    @JsonProperty("lblGokei1")
    private Label lblGokei1;
    @JsonProperty("dgShokujiHiyoGokeiFromH1504")
    private DataGrid<dgShokujiHiyoGokeiFromH1504_Row> dgShokujiHiyoGokeiFromH1504;
    @JsonProperty("lblMeisai")
    private Label lblMeisai;
    @JsonProperty("dgShokujiHiyoMeisaiFromH1504")
    private DataGrid<dgShokujiHiyoMeisaiFromH1504_Row> dgShokujiHiyoMeisaiFromH1504;

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
     * getlblGokei1
     * @return lblGokei1
     */
    @JsonProperty("lblGokei1")
    public Label getLblGokei1() {
        return lblGokei1;
    }

    /*
     * setlblGokei1
     * @param lblGokei1 lblGokei1
     */
    @JsonProperty("lblGokei1")
    public void setLblGokei1(Label lblGokei1) {
        this.lblGokei1 = lblGokei1;
    }

    /*
     * getdgShokujiHiyoGokeiFromH1504
     * @return dgShokujiHiyoGokeiFromH1504
     */
    @JsonProperty("dgShokujiHiyoGokeiFromH1504")
    public DataGrid<dgShokujiHiyoGokeiFromH1504_Row> getDgShokujiHiyoGokeiFromH1504() {
        return dgShokujiHiyoGokeiFromH1504;
    }

    /*
     * setdgShokujiHiyoGokeiFromH1504
     * @param dgShokujiHiyoGokeiFromH1504 dgShokujiHiyoGokeiFromH1504
     */
    @JsonProperty("dgShokujiHiyoGokeiFromH1504")
    public void setDgShokujiHiyoGokeiFromH1504(DataGrid<dgShokujiHiyoGokeiFromH1504_Row> dgShokujiHiyoGokeiFromH1504) {
        this.dgShokujiHiyoGokeiFromH1504 = dgShokujiHiyoGokeiFromH1504;
    }

    /*
     * getlblMeisai
     * @return lblMeisai
     */
    @JsonProperty("lblMeisai")
    public Label getLblMeisai() {
        return lblMeisai;
    }

    /*
     * setlblMeisai
     * @param lblMeisai lblMeisai
     */
    @JsonProperty("lblMeisai")
    public void setLblMeisai(Label lblMeisai) {
        this.lblMeisai = lblMeisai;
    }

    /*
     * getdgShokujiHiyoMeisaiFromH1504
     * @return dgShokujiHiyoMeisaiFromH1504
     */
    @JsonProperty("dgShokujiHiyoMeisaiFromH1504")
    public DataGrid<dgShokujiHiyoMeisaiFromH1504_Row> getDgShokujiHiyoMeisaiFromH1504() {
        return dgShokujiHiyoMeisaiFromH1504;
    }

    /*
     * setdgShokujiHiyoMeisaiFromH1504
     * @param dgShokujiHiyoMeisaiFromH1504 dgShokujiHiyoMeisaiFromH1504
     */
    @JsonProperty("dgShokujiHiyoMeisaiFromH1504")
    public void setDgShokujiHiyoMeisaiFromH1504(DataGrid<dgShokujiHiyoMeisaiFromH1504_Row> dgShokujiHiyoMeisaiFromH1504) {
        this.dgShokujiHiyoMeisaiFromH1504 = dgShokujiHiyoMeisaiFromH1504;
    }

    // </editor-fold>
}
