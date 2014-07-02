package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011.KetteiHokenshaShukeiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KetteiHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiHokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    private TextBoxDate txtKetteiHokenshaSakuseiYMD;
    @JsonProperty("KetteiHokenshaShukei")
    private KetteiHokenshaShukeiDiv KetteiHokenshaShukei;
    @JsonProperty("lblHokenshaHosoku")
    private Label lblHokenshaHosoku;
    @JsonProperty("dgKetteiHokenshaDetail")
    private DataGrid<dgKetteiHokenshaDetail_Row> dgKetteiHokenshaDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    public TextBoxDate getTxtKetteiHokenshaSakuseiYMD() {
        return txtKetteiHokenshaSakuseiYMD;
    }

    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    public void setTxtKetteiHokenshaSakuseiYMD(TextBoxDate txtKetteiHokenshaSakuseiYMD) {
        this.txtKetteiHokenshaSakuseiYMD=txtKetteiHokenshaSakuseiYMD;
    }

    @JsonProperty("KetteiHokenshaShukei")
    public KetteiHokenshaShukeiDiv getKetteiHokenshaShukei() {
        return KetteiHokenshaShukei;
    }

    @JsonProperty("KetteiHokenshaShukei")
    public void setKetteiHokenshaShukei(KetteiHokenshaShukeiDiv KetteiHokenshaShukei) {
        this.KetteiHokenshaShukei=KetteiHokenshaShukei;
    }

    @JsonProperty("lblHokenshaHosoku")
    public Label getLblHokenshaHosoku() {
        return lblHokenshaHosoku;
    }

    @JsonProperty("lblHokenshaHosoku")
    public void setLblHokenshaHosoku(Label lblHokenshaHosoku) {
        this.lblHokenshaHosoku=lblHokenshaHosoku;
    }

    @JsonProperty("dgKetteiHokenshaDetail")
    public DataGrid<dgKetteiHokenshaDetail_Row> getDgKetteiHokenshaDetail() {
        return dgKetteiHokenshaDetail;
    }

    @JsonProperty("dgKetteiHokenshaDetail")
    public void setDgKetteiHokenshaDetail(DataGrid<dgKetteiHokenshaDetail_Row> dgKetteiHokenshaDetail) {
        this.dgKetteiHokenshaDetail=dgKetteiHokenshaDetail;
    }

}
