package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KetteiKohiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KetteiKohiShukeiDiv;
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
    @JsonProperty("lblKetteiKohiSakuseiYMD")
    private Label lblKetteiKohiSakuseiYMD;
    @JsonProperty("txtKetteiKohiSakuseiYMD")
    private TextBoxFlexibleDate txtKetteiKohiSakuseiYMD;
    @JsonProperty("KetteiKohiShukei")
    private KetteiKohiShukeiDiv KetteiKohiShukei;
    @JsonProperty("KetteiKohiDetail")
    private KetteiKohiDetailDiv KetteiKohiDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKetteiKohiSakuseiYMD")
    public Label getLblKetteiKohiSakuseiYMD() {
        return lblKetteiKohiSakuseiYMD;
    }

    @JsonProperty("lblKetteiKohiSakuseiYMD")
    public void setLblKetteiKohiSakuseiYMD(Label lblKetteiKohiSakuseiYMD) {
        this.lblKetteiKohiSakuseiYMD=lblKetteiKohiSakuseiYMD;
    }

    @JsonProperty("txtKetteiKohiSakuseiYMD")
    public TextBoxFlexibleDate getTxtKetteiKohiSakuseiYMD() {
        return txtKetteiKohiSakuseiYMD;
    }

    @JsonProperty("txtKetteiKohiSakuseiYMD")
    public void setTxtKetteiKohiSakuseiYMD(TextBoxFlexibleDate txtKetteiKohiSakuseiYMD) {
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

    @JsonProperty("KetteiKohiDetail")
    public KetteiKohiDetailDiv getKetteiKohiDetail() {
        return KetteiKohiDetail;
    }

    @JsonProperty("KetteiKohiDetail")
    public void setKetteiKohiDetail(KetteiKohiDetailDiv KetteiKohiDetail) {
        this.KetteiKohiDetail=KetteiKohiDetail;
    }

}
