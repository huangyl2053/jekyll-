package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SinsaSeikyusyoJohoPane1 のクラスファイル
 *
 * @reamsid_L DBU-1080-070 lizhuoxuan
 */
public class SinsaSeikyusyoJohoPane1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTuika")
    private Button btnTuika;
    @JsonProperty("grdSinsaSeikyusyoJoho")
    private DataGrid<grdSinsaSeikyusyoJoho_Row> grdSinsaSeikyusyoJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTuika
     * @return btnTuika
     */
    @JsonProperty("btnTuika")
    public Button getBtnTuika() {
        return btnTuika;
    }

    /*
     * setbtnTuika
     * @param btnTuika btnTuika
     */
    @JsonProperty("btnTuika")
    public void setBtnTuika(Button btnTuika) {
        this.btnTuika = btnTuika;
    }

    /*
     * getgrdSinsaSeikyusyoJoho
     * @return grdSinsaSeikyusyoJoho
     */
    @JsonProperty("grdSinsaSeikyusyoJoho")
    public DataGrid<grdSinsaSeikyusyoJoho_Row> getGrdSinsaSeikyusyoJoho() {
        return grdSinsaSeikyusyoJoho;
    }

    /*
     * setgrdSinsaSeikyusyoJoho
     * @param grdSinsaSeikyusyoJoho grdSinsaSeikyusyoJoho
     */
    @JsonProperty("grdSinsaSeikyusyoJoho")
    public void setGrdSinsaSeikyusyoJoho(DataGrid<grdSinsaSeikyusyoJoho_Row> grdSinsaSeikyusyoJoho) {
        this.grdSinsaSeikyusyoJoho = grdSinsaSeikyusyoJoho;
    }

    // </editor-fold>
}
