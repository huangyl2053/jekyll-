package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.YoguKonyuhiShikyuShinseiSeikyuDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.dgYoguSeikyuDetail_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.tblYoguSeikyuSummaryDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiFukushiYoguKonyuhiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiFukushiYoguKonyuhiInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("txtSeiriNo")
    private TextBoxCode txtSeiriNo;
    @JsonProperty("txtKyufuritsu")
    private TextBoxNum txtKyufuritsu;
    @JsonProperty("dgYoguSeikyuDetail")
    private DataGrid<dgYoguSeikyuDetail_Row> dgYoguSeikyuDetail;
    @JsonProperty("YoguKonyuhiShikyuShinseiSeikyuDetail")
    private YoguKonyuhiShikyuShinseiSeikyuDetailDiv YoguKonyuhiShikyuShinseiSeikyuDetail;
    @JsonProperty("tblYoguSeikyuSummary")
    private tblYoguSeikyuSummaryDiv tblYoguSeikyuSummary;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM=txtTeikyoYM;
    }

    @JsonProperty("txtSeiriNo")
    public TextBoxCode getTxtSeiriNo() {
        return txtSeiriNo;
    }

    @JsonProperty("txtSeiriNo")
    public void setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.txtSeiriNo=txtSeiriNo;
    }

    @JsonProperty("txtKyufuritsu")
    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.txtKyufuritsu=txtKyufuritsu;
    }

    @JsonProperty("dgYoguSeikyuDetail")
    public DataGrid<dgYoguSeikyuDetail_Row> getDgYoguSeikyuDetail() {
        return dgYoguSeikyuDetail;
    }

    @JsonProperty("dgYoguSeikyuDetail")
    public void setDgYoguSeikyuDetail(DataGrid<dgYoguSeikyuDetail_Row> dgYoguSeikyuDetail) {
        this.dgYoguSeikyuDetail=dgYoguSeikyuDetail;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiSeikyuDetail")
    public YoguKonyuhiShikyuShinseiSeikyuDetailDiv getYoguKonyuhiShikyuShinseiSeikyuDetail() {
        return YoguKonyuhiShikyuShinseiSeikyuDetail;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiSeikyuDetail")
    public void setYoguKonyuhiShikyuShinseiSeikyuDetail(YoguKonyuhiShikyuShinseiSeikyuDetailDiv YoguKonyuhiShikyuShinseiSeikyuDetail) {
        this.YoguKonyuhiShikyuShinseiSeikyuDetail=YoguKonyuhiShikyuShinseiSeikyuDetail;
    }

    @JsonProperty("tblYoguSeikyuSummary")
    public tblYoguSeikyuSummaryDiv getTblYoguSeikyuSummary() {
        return tblYoguSeikyuSummary;
    }

    @JsonProperty("tblYoguSeikyuSummary")
    public void setTblYoguSeikyuSummary(tblYoguSeikyuSummaryDiv tblYoguSeikyuSummary) {
        this.tblYoguSeikyuSummary=tblYoguSeikyuSummary;
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
