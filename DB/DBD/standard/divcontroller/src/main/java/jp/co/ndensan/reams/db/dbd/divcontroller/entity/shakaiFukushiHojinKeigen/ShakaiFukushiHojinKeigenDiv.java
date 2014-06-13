package jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigenDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen.dgShakaiFukushiHojinKeigenList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShakaiFukushiHojinKeigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShakaiFukushiHojinKeigenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    private TextBox txtHiddenHihokenshaNo;
    @JsonProperty("dgShakaiFukushiHojinKeigenList")
    private DataGrid<dgShakaiFukushiHojinKeigenList_Row> dgShakaiFukushiHojinKeigenList;
    @JsonProperty("ShakaiFukushiHojinKeigenDetail")
    private ShakaiFukushiHojinKeigenDetailDiv ShakaiFukushiHojinKeigenDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    public TextBox getTxtHiddenHihokenshaNo() {
        return txtHiddenHihokenshaNo;
    }

    @JsonProperty("txtHiddenHihokenshaNo")
    public void setTxtHiddenHihokenshaNo(TextBox txtHiddenHihokenshaNo) {
        this.txtHiddenHihokenshaNo=txtHiddenHihokenshaNo;
    }

    @JsonProperty("dgShakaiFukushiHojinKeigenList")
    public DataGrid<dgShakaiFukushiHojinKeigenList_Row> getDgShakaiFukushiHojinKeigenList() {
        return dgShakaiFukushiHojinKeigenList;
    }

    @JsonProperty("dgShakaiFukushiHojinKeigenList")
    public void setDgShakaiFukushiHojinKeigenList(DataGrid<dgShakaiFukushiHojinKeigenList_Row> dgShakaiFukushiHojinKeigenList) {
        this.dgShakaiFukushiHojinKeigenList=dgShakaiFukushiHojinKeigenList;
    }

    @JsonProperty("ShakaiFukushiHojinKeigenDetail")
    public ShakaiFukushiHojinKeigenDetailDiv getShakaiFukushiHojinKeigenDetail() {
        return ShakaiFukushiHojinKeigenDetail;
    }

    @JsonProperty("ShakaiFukushiHojinKeigenDetail")
    public void setShakaiFukushiHojinKeigenDetail(ShakaiFukushiHojinKeigenDetailDiv ShakaiFukushiHojinKeigenDetail) {
        this.ShakaiFukushiHojinKeigenDetail=ShakaiFukushiHojinKeigenDetail;
    }

}
