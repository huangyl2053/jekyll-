package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
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
public class SogoShokaiJutakuKaishuhiInfoDiv extends Panel {
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

}
