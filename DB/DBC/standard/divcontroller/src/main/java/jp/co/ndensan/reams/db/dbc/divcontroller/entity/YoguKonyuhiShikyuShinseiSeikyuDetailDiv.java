package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSeikyuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblSummaryDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YoguKonyuhiShikyuShinseiSeikyuDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiSeikyuDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSeikyuDetail")
    private DataGrid<dgSeikyuDetail_Row> dgSeikyuDetail;
    @JsonProperty("tblSummary")
    private tblSummaryDiv tblSummary;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSeikyuDetail")
    public DataGrid<dgSeikyuDetail_Row> getDgSeikyuDetail() {
        return dgSeikyuDetail;
    }

    @JsonProperty("dgSeikyuDetail")
    public void setDgSeikyuDetail(DataGrid<dgSeikyuDetail_Row> dgSeikyuDetail) {
        this.dgSeikyuDetail=dgSeikyuDetail;
    }

    @JsonProperty("tblSummary")
    public tblSummaryDiv getTblSummary() {
        return tblSummary;
    }

    @JsonProperty("tblSummary")
    public void setTblSummary(tblSummaryDiv tblSummary) {
        this.tblSummary=tblSummary;
    }

}
