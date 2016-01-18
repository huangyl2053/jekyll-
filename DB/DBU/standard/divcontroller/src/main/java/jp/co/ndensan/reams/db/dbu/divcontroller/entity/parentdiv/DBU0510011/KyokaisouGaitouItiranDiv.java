package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyokaisouGaitouItiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyokaisouGaitouItiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTuika")
    private Button btnTuika;
    @JsonProperty("dgKyokaisouGaitouItran")
    private DataGrid<dgKyokaisouGaitouItran_Row> dgKyokaisouGaitouItran;
    @JsonProperty("IranState")
    private RString IranState;

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
     * getdgKyokaisouGaitouItran
     * @return dgKyokaisouGaitouItran
     */
    @JsonProperty("dgKyokaisouGaitouItran")
    public DataGrid<dgKyokaisouGaitouItran_Row> getDgKyokaisouGaitouItran() {
        return dgKyokaisouGaitouItran;
    }

    /*
     * setdgKyokaisouGaitouItran
     * @param dgKyokaisouGaitouItran dgKyokaisouGaitouItran
     */
    @JsonProperty("dgKyokaisouGaitouItran")
    public void setDgKyokaisouGaitouItran(DataGrid<dgKyokaisouGaitouItran_Row> dgKyokaisouGaitouItran) {
        this.dgKyokaisouGaitouItran = dgKyokaisouGaitouItran;
    }

    /*
     * getIranState
     * @return IranState
     */
    @JsonProperty("IranState")
    public RString getIranState() {
        return IranState;
    }

    /*
     * setIranState
     * @param IranState IranState
     */
    @JsonProperty("IranState")
    public void setIranState(RString IranState) {
        this.IranState = IranState;
    }

    // </editor-fold>
}
