package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.KaijoButtonAreaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.WariateButtonAreaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgMiwariateTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Miwariatesha のクラスファイル 
 * 
 * @author 自動生成
 */
public class MiwariateshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblMiwariateTaishoshaIchiran")
    private Label lblMiwariateTaishoshaIchiran;
    @JsonProperty("dgMiwariateTaishoshaIchiran")
    private DataGrid<dgMiwariateTaishoshaIchiran_Row> dgMiwariateTaishoshaIchiran;
    @JsonProperty("WariateButtonArea")
    private WariateButtonAreaDiv WariateButtonArea;
    @JsonProperty("KaijoButtonArea")
    private KaijoButtonAreaDiv KaijoButtonArea;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblMiwariateTaishoshaIchiran")
    public Label getLblMiwariateTaishoshaIchiran() {
        return lblMiwariateTaishoshaIchiran;
    }

    @JsonProperty("lblMiwariateTaishoshaIchiran")
    public void setLblMiwariateTaishoshaIchiran(Label lblMiwariateTaishoshaIchiran) {
        this.lblMiwariateTaishoshaIchiran=lblMiwariateTaishoshaIchiran;
    }

    @JsonProperty("dgMiwariateTaishoshaIchiran")
    public DataGrid<dgMiwariateTaishoshaIchiran_Row> getDgMiwariateTaishoshaIchiran() {
        return dgMiwariateTaishoshaIchiran;
    }

    @JsonProperty("dgMiwariateTaishoshaIchiran")
    public void setDgMiwariateTaishoshaIchiran(DataGrid<dgMiwariateTaishoshaIchiran_Row> dgMiwariateTaishoshaIchiran) {
        this.dgMiwariateTaishoshaIchiran=dgMiwariateTaishoshaIchiran;
    }

    @JsonProperty("WariateButtonArea")
    public WariateButtonAreaDiv getWariateButtonArea() {
        return WariateButtonArea;
    }

    @JsonProperty("WariateButtonArea")
    public void setWariateButtonArea(WariateButtonAreaDiv WariateButtonArea) {
        this.WariateButtonArea=WariateButtonArea;
    }

    @JsonProperty("KaijoButtonArea")
    public KaijoButtonAreaDiv getKaijoButtonArea() {
        return KaijoButtonArea;
    }

    @JsonProperty("KaijoButtonArea")
    public void setKaijoButtonArea(KaijoButtonAreaDiv KaijoButtonArea) {
        this.KaijoButtonArea=KaijoButtonArea;
    }

}
