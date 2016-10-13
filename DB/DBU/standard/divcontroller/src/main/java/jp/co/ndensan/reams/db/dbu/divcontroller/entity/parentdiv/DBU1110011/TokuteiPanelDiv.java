package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU1110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuteiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblSetumei1")
    private Label lblSetumei1;
    @JsonProperty("lblSetumei2")
    private Label lblSetumei2;
    @JsonProperty("lblSetumei3")
    private Label lblSetumei3;
    @JsonProperty("grdTokuteiJoho")
    private DataGrid<grdTokuteiJoho_Row> grdTokuteiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblSetumei1
     * @return lblSetumei1
     */
    @JsonProperty("lblSetumei1")
    public Label getLblSetumei1() {
        return lblSetumei1;
    }

    /*
     * setlblSetumei1
     * @param lblSetumei1 lblSetumei1
     */
    @JsonProperty("lblSetumei1")
    public void setLblSetumei1(Label lblSetumei1) {
        this.lblSetumei1 = lblSetumei1;
    }

    /*
     * getlblSetumei2
     * @return lblSetumei2
     */
    @JsonProperty("lblSetumei2")
    public Label getLblSetumei2() {
        return lblSetumei2;
    }

    /*
     * setlblSetumei2
     * @param lblSetumei2 lblSetumei2
     */
    @JsonProperty("lblSetumei2")
    public void setLblSetumei2(Label lblSetumei2) {
        this.lblSetumei2 = lblSetumei2;
    }

    /*
     * getlblSetumei3
     * @return lblSetumei3
     */
    @JsonProperty("lblSetumei3")
    public Label getLblSetumei3() {
        return lblSetumei3;
    }

    /*
     * setlblSetumei3
     * @param lblSetumei3 lblSetumei3
     */
    @JsonProperty("lblSetumei3")
    public void setLblSetumei3(Label lblSetumei3) {
        this.lblSetumei3 = lblSetumei3;
    }

    /*
     * getgrdTokuteiJoho
     * @return grdTokuteiJoho
     */
    @JsonProperty("grdTokuteiJoho")
    public DataGrid<grdTokuteiJoho_Row> getGrdTokuteiJoho() {
        return grdTokuteiJoho;
    }

    /*
     * setgrdTokuteiJoho
     * @param grdTokuteiJoho grdTokuteiJoho
     */
    @JsonProperty("grdTokuteiJoho")
    public void setGrdTokuteiJoho(DataGrid<grdTokuteiJoho_Row> grdTokuteiJoho) {
        this.grdTokuteiJoho = grdTokuteiJoho;
    }

    // </editor-fold>
}
