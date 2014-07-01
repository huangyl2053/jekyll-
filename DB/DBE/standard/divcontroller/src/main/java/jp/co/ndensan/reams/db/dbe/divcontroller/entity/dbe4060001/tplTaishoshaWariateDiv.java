package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.TaishoshaNarabikaeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgMiwariateTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgWariatezumiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.taishoshaWariateBtnDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplTaishoshaWariate のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplTaishoshaWariateDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblWariatezumiTaishoshaIchiran")
    private Label lblWariatezumiTaishoshaIchiran;
    @JsonProperty("btnNarabikae")
    private Button btnNarabikae;
    @JsonProperty("TaishoshaNarabikae")
    private TaishoshaNarabikaeDiv TaishoshaNarabikae;
    @JsonProperty("dgWariatezumiTaishoshaIchiran")
    private DataGrid<dgWariatezumiTaishoshaIchiran_Row> dgWariatezumiTaishoshaIchiran;
    @JsonProperty("taishoshaWariateBtn")
    private taishoshaWariateBtnDiv taishoshaWariateBtn;
    @JsonProperty("lblMiwariateTaishoshaIchiran")
    private Label lblMiwariateTaishoshaIchiran;
    @JsonProperty("dgMiwariateTaishoshaIchiran")
    private DataGrid<dgMiwariateTaishoshaIchiran_Row> dgMiwariateTaishoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblWariatezumiTaishoshaIchiran")
    public Label getLblWariatezumiTaishoshaIchiran() {
        return lblWariatezumiTaishoshaIchiran;
    }

    @JsonProperty("lblWariatezumiTaishoshaIchiran")
    public void setLblWariatezumiTaishoshaIchiran(Label lblWariatezumiTaishoshaIchiran) {
        this.lblWariatezumiTaishoshaIchiran=lblWariatezumiTaishoshaIchiran;
    }

    @JsonProperty("btnNarabikae")
    public Button getBtnNarabikae() {
        return btnNarabikae;
    }

    @JsonProperty("btnNarabikae")
    public void setBtnNarabikae(Button btnNarabikae) {
        this.btnNarabikae=btnNarabikae;
    }

    @JsonProperty("TaishoshaNarabikae")
    public TaishoshaNarabikaeDiv getTaishoshaNarabikae() {
        return TaishoshaNarabikae;
    }

    @JsonProperty("TaishoshaNarabikae")
    public void setTaishoshaNarabikae(TaishoshaNarabikaeDiv TaishoshaNarabikae) {
        this.TaishoshaNarabikae=TaishoshaNarabikae;
    }

    @JsonProperty("dgWariatezumiTaishoshaIchiran")
    public DataGrid<dgWariatezumiTaishoshaIchiran_Row> getDgWariatezumiTaishoshaIchiran() {
        return dgWariatezumiTaishoshaIchiran;
    }

    @JsonProperty("dgWariatezumiTaishoshaIchiran")
    public void setDgWariatezumiTaishoshaIchiran(DataGrid<dgWariatezumiTaishoshaIchiran_Row> dgWariatezumiTaishoshaIchiran) {
        this.dgWariatezumiTaishoshaIchiran=dgWariatezumiTaishoshaIchiran;
    }

    @JsonProperty("taishoshaWariateBtn")
    public taishoshaWariateBtnDiv getTaishoshaWariateBtn() {
        return taishoshaWariateBtn;
    }

    @JsonProperty("taishoshaWariateBtn")
    public void setTaishoshaWariateBtn(taishoshaWariateBtnDiv taishoshaWariateBtn) {
        this.taishoshaWariateBtn=taishoshaWariateBtn;
    }

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

}
