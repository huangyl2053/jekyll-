package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020001.dgIdoTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IdoTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class IdoTaishoshaIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtLastKeisanYMD")
    private TextBox txtLastKeisanYMD;
    @JsonProperty("ddlTsuchishoMeisho")
    private DropDownList ddlTsuchishoMeisho;
    @JsonProperty("ddlSakuseiYMD")
    private DropDownList ddlSakuseiYMD;
    @JsonProperty("dgIdoTaishoshaIchiran")
    private DataGrid<dgIdoTaishoshaIchiran_Row> dgIdoTaishoshaIchiran;
    @JsonProperty("btnHozonIdoTaishoshaIchiran")
    private Button btnHozonIdoTaishoshaIchiran;
    @JsonProperty("btnHakkoIdoTaishoshaIchiran")
    private Button btnHakkoIdoTaishoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtLastKeisanYMD")
    public TextBox getTxtLastKeisanYMD() {
        return txtLastKeisanYMD;
    }

    @JsonProperty("txtLastKeisanYMD")
    public void setTxtLastKeisanYMD(TextBox txtLastKeisanYMD) {
        this.txtLastKeisanYMD=txtLastKeisanYMD;
    }

    @JsonProperty("ddlTsuchishoMeisho")
    public DropDownList getDdlTsuchishoMeisho() {
        return ddlTsuchishoMeisho;
    }

    @JsonProperty("ddlTsuchishoMeisho")
    public void setDdlTsuchishoMeisho(DropDownList ddlTsuchishoMeisho) {
        this.ddlTsuchishoMeisho=ddlTsuchishoMeisho;
    }

    @JsonProperty("ddlSakuseiYMD")
    public DropDownList getDdlSakuseiYMD() {
        return ddlSakuseiYMD;
    }

    @JsonProperty("ddlSakuseiYMD")
    public void setDdlSakuseiYMD(DropDownList ddlSakuseiYMD) {
        this.ddlSakuseiYMD=ddlSakuseiYMD;
    }

    @JsonProperty("dgIdoTaishoshaIchiran")
    public DataGrid<dgIdoTaishoshaIchiran_Row> getDgIdoTaishoshaIchiran() {
        return dgIdoTaishoshaIchiran;
    }

    @JsonProperty("dgIdoTaishoshaIchiran")
    public void setDgIdoTaishoshaIchiran(DataGrid<dgIdoTaishoshaIchiran_Row> dgIdoTaishoshaIchiran) {
        this.dgIdoTaishoshaIchiran=dgIdoTaishoshaIchiran;
    }

    @JsonProperty("btnHozonIdoTaishoshaIchiran")
    public Button getBtnHozonIdoTaishoshaIchiran() {
        return btnHozonIdoTaishoshaIchiran;
    }

    @JsonProperty("btnHozonIdoTaishoshaIchiran")
    public void setBtnHozonIdoTaishoshaIchiran(Button btnHozonIdoTaishoshaIchiran) {
        this.btnHozonIdoTaishoshaIchiran=btnHozonIdoTaishoshaIchiran;
    }

    @JsonProperty("btnHakkoIdoTaishoshaIchiran")
    public Button getBtnHakkoIdoTaishoshaIchiran() {
        return btnHakkoIdoTaishoshaIchiran;
    }

    @JsonProperty("btnHakkoIdoTaishoshaIchiran")
    public void setBtnHakkoIdoTaishoshaIchiran(Button btnHakkoIdoTaishoshaIchiran) {
        this.btnHakkoIdoTaishoshaIchiran=btnHakkoIdoTaishoshaIchiran;
    }

}
