package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011.KetteiKohiShukeiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KetteiKohi のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiKohiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiKohiSakuseiYMD")
    private TextBoxDate txtKetteiKohiSakuseiYMD;
    @JsonProperty("KetteiKohiShukei")
    private KetteiKohiShukeiDiv KetteiKohiShukei;
    @JsonProperty("lblKohiHosoku")
    private Label lblKohiHosoku;
    @JsonProperty("dgKetteiKohiDetail")
    private DataGrid<dgKetteiKohiDetail_Row> dgKetteiKohiDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKetteiKohiSakuseiYMD")
    public TextBoxDate getTxtKetteiKohiSakuseiYMD() {
        return txtKetteiKohiSakuseiYMD;
    }

    @JsonProperty("txtKetteiKohiSakuseiYMD")
    public void setTxtKetteiKohiSakuseiYMD(TextBoxDate txtKetteiKohiSakuseiYMD) {
        this.txtKetteiKohiSakuseiYMD=txtKetteiKohiSakuseiYMD;
    }

    @JsonProperty("KetteiKohiShukei")
    public KetteiKohiShukeiDiv getKetteiKohiShukei() {
        return KetteiKohiShukei;
    }

    @JsonProperty("KetteiKohiShukei")
    public void setKetteiKohiShukei(KetteiKohiShukeiDiv KetteiKohiShukei) {
        this.KetteiKohiShukei=KetteiKohiShukei;
    }

    @JsonProperty("lblKohiHosoku")
    public Label getLblKohiHosoku() {
        return lblKohiHosoku;
    }

    @JsonProperty("lblKohiHosoku")
    public void setLblKohiHosoku(Label lblKohiHosoku) {
        this.lblKohiHosoku=lblKohiHosoku;
    }

    @JsonProperty("dgKetteiKohiDetail")
    public DataGrid<dgKetteiKohiDetail_Row> getDgKetteiKohiDetail() {
        return dgKetteiKohiDetail;
    }

    @JsonProperty("dgKetteiKohiDetail")
    public void setDgKetteiKohiDetail(DataGrid<dgKetteiKohiDetail_Row> dgKetteiKohiDetail) {
        this.dgKetteiKohiDetail=dgKetteiKohiDetail;
    }

}
