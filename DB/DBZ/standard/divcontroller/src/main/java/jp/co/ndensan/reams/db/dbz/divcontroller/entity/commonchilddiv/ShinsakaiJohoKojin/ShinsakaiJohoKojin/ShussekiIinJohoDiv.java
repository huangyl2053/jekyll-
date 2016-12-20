package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShussekiIinJoho のクラスファイル
 *
 * @reamsid_L DBE-3000-070 zhengshukai
 */
public class ShussekiIinJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinsakaiIin")
    private Label lblShinsakaiIin;
    @JsonProperty("lblHoketsuShinsakaiIin")
    private Label lblHoketsuShinsakaiIin;
    @JsonProperty("dgShinsakaiIin")
    private DataGrid<dgShinsakaiIin_Row> dgShinsakaiIin;
    @JsonProperty("dgHoketsuShinsakai")
    private DataGrid<dgHoketsuShinsakai_Row> dgHoketsuShinsakai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShinsakaiIin
     * @return lblShinsakaiIin
     */
    @JsonProperty("lblShinsakaiIin")
    public Label getLblShinsakaiIin() {
        return lblShinsakaiIin;
    }

    /*
     * setlblShinsakaiIin
     * @param lblShinsakaiIin lblShinsakaiIin
     */
    @JsonProperty("lblShinsakaiIin")
    public void setLblShinsakaiIin(Label lblShinsakaiIin) {
        this.lblShinsakaiIin = lblShinsakaiIin;
    }

    /*
     * getlblHoketsuShinsakaiIin
     * @return lblHoketsuShinsakaiIin
     */
    @JsonProperty("lblHoketsuShinsakaiIin")
    public Label getLblHoketsuShinsakaiIin() {
        return lblHoketsuShinsakaiIin;
    }

    /*
     * setlblHoketsuShinsakaiIin
     * @param lblHoketsuShinsakaiIin lblHoketsuShinsakaiIin
     */
    @JsonProperty("lblHoketsuShinsakaiIin")
    public void setLblHoketsuShinsakaiIin(Label lblHoketsuShinsakaiIin) {
        this.lblHoketsuShinsakaiIin = lblHoketsuShinsakaiIin;
    }

    /*
     * getdgShinsakaiIin
     * @return dgShinsakaiIin
     */
    @JsonProperty("dgShinsakaiIin")
    public DataGrid<dgShinsakaiIin_Row> getDgShinsakaiIin() {
        return dgShinsakaiIin;
    }

    /*
     * setdgShinsakaiIin
     * @param dgShinsakaiIin dgShinsakaiIin
     */
    @JsonProperty("dgShinsakaiIin")
    public void setDgShinsakaiIin(DataGrid<dgShinsakaiIin_Row> dgShinsakaiIin) {
        this.dgShinsakaiIin = dgShinsakaiIin;
    }

    /*
     * getdgHoketsuShinsakai
     * @return dgHoketsuShinsakai
     */
    @JsonProperty("dgHoketsuShinsakai")
    public DataGrid<dgHoketsuShinsakai_Row> getDgHoketsuShinsakai() {
        return dgHoketsuShinsakai;
    }

    /*
     * setdgHoketsuShinsakai
     * @param dgHoketsuShinsakai dgHoketsuShinsakai
     */
    @JsonProperty("dgHoketsuShinsakai")
    public void setDgHoketsuShinsakai(DataGrid<dgHoketsuShinsakai_Row> dgHoketsuShinsakai) {
        this.dgHoketsuShinsakai = dgHoketsuShinsakai;
    }

    // </editor-fold>
}
