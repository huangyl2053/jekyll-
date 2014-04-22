package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KetteiHokenshaDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KetteiHokenshaShukeiDiv;
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
    @JsonProperty("lblKetteiHokenshaSakuseiYMD")
    private Label lblKetteiHokenshaSakuseiYMD;
    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    private TextBoxFlexibleDate txtKetteiHokenshaSakuseiYMD;
    @JsonProperty("KetteiHokenshaShukei")
    private KetteiHokenshaShukeiDiv KetteiHokenshaShukei;
    @JsonProperty("KetteiHokenshaDetail")
    private KetteiHokenshaDetailDiv KetteiHokenshaDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKetteiHokenshaSakuseiYMD")
    public Label getLblKetteiHokenshaSakuseiYMD() {
        return lblKetteiHokenshaSakuseiYMD;
    }

    @JsonProperty("lblKetteiHokenshaSakuseiYMD")
    public void setLblKetteiHokenshaSakuseiYMD(Label lblKetteiHokenshaSakuseiYMD) {
        this.lblKetteiHokenshaSakuseiYMD=lblKetteiHokenshaSakuseiYMD;
    }

    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    public TextBoxFlexibleDate getTxtKetteiHokenshaSakuseiYMD() {
        return txtKetteiHokenshaSakuseiYMD;
    }

    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    public void setTxtKetteiHokenshaSakuseiYMD(TextBoxFlexibleDate txtKetteiHokenshaSakuseiYMD) {
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

    @JsonProperty("KetteiHokenshaDetail")
    public KetteiHokenshaDetailDiv getKetteiHokenshaDetail() {
        return KetteiHokenshaDetail;
    }

    @JsonProperty("KetteiHokenshaDetail")
    public void setKetteiHokenshaDetail(KetteiHokenshaDetailDiv KetteiHokenshaDetail) {
        this.KetteiHokenshaDetail=KetteiHokenshaDetail;
    }

}
