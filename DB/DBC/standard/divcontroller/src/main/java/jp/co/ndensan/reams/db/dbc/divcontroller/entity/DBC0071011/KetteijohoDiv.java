package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011.KetteiHokenshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011.KetteiKohiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Ketteijoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteijohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtToriatsukaiYM")
    private TextBoxDate txtToriatsukaiYM;
    @JsonProperty("lblShichosonName")
    private Label lblShichosonName;
    @JsonProperty("ddlShichosonName")
    private DropDownList ddlShichosonName;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("KetteiHokensha")
    private KetteiHokenshaDiv KetteiHokensha;
    @JsonProperty("KetteiKohi")
    private KetteiKohiDiv KetteiKohi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtToriatsukaiYM")
    public TextBoxDate getTxtToriatsukaiYM() {
        return txtToriatsukaiYM;
    }

    @JsonProperty("txtToriatsukaiYM")
    public void setTxtToriatsukaiYM(TextBoxDate txtToriatsukaiYM) {
        this.txtToriatsukaiYM=txtToriatsukaiYM;
    }

    @JsonProperty("lblShichosonName")
    public Label getLblShichosonName() {
        return lblShichosonName;
    }

    @JsonProperty("lblShichosonName")
    public void setLblShichosonName(Label lblShichosonName) {
        this.lblShichosonName=lblShichosonName;
    }

    @JsonProperty("ddlShichosonName")
    public DropDownList getDdlShichosonName() {
        return ddlShichosonName;
    }

    @JsonProperty("ddlShichosonName")
    public void setDdlShichosonName(DropDownList ddlShichosonName) {
        this.ddlShichosonName=ddlShichosonName;
    }

    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch=btnSearch;
    }

    @JsonProperty("KetteiHokensha")
    public KetteiHokenshaDiv getKetteiHokensha() {
        return KetteiHokensha;
    }

    @JsonProperty("KetteiHokensha")
    public void setKetteiHokensha(KetteiHokenshaDiv KetteiHokensha) {
        this.KetteiHokensha=KetteiHokensha;
    }

    @JsonProperty("KetteiKohi")
    public KetteiKohiDiv getKetteiKohi() {
        return KetteiKohi;
    }

    @JsonProperty("KetteiKohi")
    public void setKetteiKohi(KetteiKohiDiv KetteiKohi) {
        this.KetteiKohi=KetteiKohi;
    }

}
