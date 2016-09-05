package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuTsuchiSakusei2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuTsuchiSakusei2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTuuchiJoho")
    private Button btnTuuchiJoho;
    @JsonProperty("grdTuuchiJoho")
    private DataGrid<grdTuuchiJoho_Row> grdTuuchiJoho;
    @JsonProperty("lblTyuibun1")
    private Label lblTyuibun1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTuuchiJoho
     * @return btnTuuchiJoho
     */
    @JsonProperty("btnTuuchiJoho")
    public Button getBtnTuuchiJoho() {
        return btnTuuchiJoho;
    }

    /*
     * setbtnTuuchiJoho
     * @param btnTuuchiJoho btnTuuchiJoho
     */
    @JsonProperty("btnTuuchiJoho")
    public void setBtnTuuchiJoho(Button btnTuuchiJoho) {
        this.btnTuuchiJoho = btnTuuchiJoho;
    }

    /*
     * getgrdTuuchiJoho
     * @return grdTuuchiJoho
     */
    @JsonProperty("grdTuuchiJoho")
    public DataGrid<grdTuuchiJoho_Row> getGrdTuuchiJoho() {
        return grdTuuchiJoho;
    }

    /*
     * setgrdTuuchiJoho
     * @param grdTuuchiJoho grdTuuchiJoho
     */
    @JsonProperty("grdTuuchiJoho")
    public void setGrdTuuchiJoho(DataGrid<grdTuuchiJoho_Row> grdTuuchiJoho) {
        this.grdTuuchiJoho = grdTuuchiJoho;
    }

    /*
     * getlblTyuibun1
     * @return lblTyuibun1
     */
    @JsonProperty("lblTyuibun1")
    public Label getLblTyuibun1() {
        return lblTyuibun1;
    }

    /*
     * setlblTyuibun1
     * @param lblTyuibun1 lblTyuibun1
     */
    @JsonProperty("lblTyuibun1")
    public void setLblTyuibun1(Label lblTyuibun1) {
        this.lblTyuibun1 = lblTyuibun1;
    }

    // </editor-fold>
}
