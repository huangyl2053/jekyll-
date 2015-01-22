package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ISogoShokaiJutakuKaishuhiInfoDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.JutakuKaishuDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgJutakuKaishuDetail_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblSeikyuSummaryDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiJutakuKaishuhiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiJutakuKaishuhiInfoDiv extends Panel implements ISogoShokaiJutakuKaishuhiInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJutakuOwner")
    private TextBox txtJutakuOwner;
    @JsonProperty("txtRelationWithHihokensha")
    private TextBox txtRelationWithHihokensha;
    @JsonProperty("dgJutakuKaishuDetail")
    private DataGrid<dgJutakuKaishuDetail_Row> dgJutakuKaishuDetail;
    @JsonProperty("JutakuKaishuDetail")
    private JutakuKaishuDetailDiv JutakuKaishuDetail;
    @JsonProperty("tblSeikyuSummary")
    private tblSeikyuSummaryDiv tblSeikyuSummary;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJutakuOwner")
    public TextBox getTxtJutakuOwner() {
        return txtJutakuOwner;
    }

    @JsonProperty("txtJutakuOwner")
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.txtJutakuOwner=txtJutakuOwner;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public TextBox getTxtRelationWithHihokensha() {
        return txtRelationWithHihokensha;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.txtRelationWithHihokensha=txtRelationWithHihokensha;
    }

    @JsonProperty("dgJutakuKaishuDetail")
    public DataGrid<dgJutakuKaishuDetail_Row> getDgJutakuKaishuDetail() {
        return dgJutakuKaishuDetail;
    }

    @JsonProperty("dgJutakuKaishuDetail")
    public void setDgJutakuKaishuDetail(DataGrid<dgJutakuKaishuDetail_Row> dgJutakuKaishuDetail) {
        this.dgJutakuKaishuDetail=dgJutakuKaishuDetail;
    }

    @JsonProperty("JutakuKaishuDetail")
    public JutakuKaishuDetailDiv getJutakuKaishuDetail() {
        return JutakuKaishuDetail;
    }

    @JsonProperty("JutakuKaishuDetail")
    public void setJutakuKaishuDetail(JutakuKaishuDetailDiv JutakuKaishuDetail) {
        this.JutakuKaishuDetail=JutakuKaishuDetail;
    }

    @JsonProperty("tblSeikyuSummary")
    public tblSeikyuSummaryDiv getTblSeikyuSummary() {
        return tblSeikyuSummary;
    }

    @JsonProperty("tblSeikyuSummary")
    public void setTblSeikyuSummary(tblSeikyuSummaryDiv tblSeikyuSummary) {
        this.tblSeikyuSummary=tblSeikyuSummary;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblSummary() {
        return this.getTblSeikyuSummary().getLblSummary();
    }

    @JsonIgnore
    public Label getLblHiyoTotal() {
        return this.getTblSeikyuSummary().getLblHiyoTotal();
    }

    @JsonIgnore
    public Label getLblHokenTaishoHiyo() {
        return this.getTblSeikyuSummary().getLblHokenTaishoHiyo();
    }

    @JsonIgnore
    public Label getLblHokenKyufuAmount() {
        return this.getTblSeikyuSummary().getLblHokenKyufuAmount();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutanAmount() {
        return this.getTblSeikyuSummary().getLblRiyoshaFutanAmount();
    }

    @JsonIgnore
    public Label getLblSummaryMae() {
        return this.getTblSeikyuSummary().getLblSummaryMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtPayTotalMae() {
        return this.getTblSeikyuSummary().getTxtPayTotalMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenSeikyuAmountMae() {
        return this.getTblSeikyuSummary().getTxtHokenSeikyuAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountMae() {
        return this.getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtLimitOverAmountMae() {
        return this.getTblSeikyuSummary().getTxtLimitOverAmountMae();
    }

    @JsonIgnore
    public Label getLblSummaryNow() {
        return this.getTblSeikyuSummary().getLblSummaryNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtPayTotalNow() {
        return this.getTblSeikyuSummary().getTxtPayTotalNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenSeikyuAmountNow() {
        return this.getTblSeikyuSummary().getTxtHokenSeikyuAmountNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountNow() {
        return this.getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtLimitOverAmountNow() {
        return this.getTblSeikyuSummary().getTxtLimitOverAmountNow();
    }

    //--------------- この行より下にコードを追加してください -------------------

}
