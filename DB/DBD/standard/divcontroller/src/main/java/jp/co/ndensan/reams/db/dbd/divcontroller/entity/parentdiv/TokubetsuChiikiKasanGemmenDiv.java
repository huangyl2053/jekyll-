package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.ITokubetsuChiikiKasanGemmenDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.TokubetsuChiikiKasanGemmenDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.dgTokubetsuChiikiKasanGemmenList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TokubetsuChiikiKasanGemmen のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuChiikiKasanGemmenDiv extends Panel implements ITokubetsuChiikiKasanGemmenDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    private TextBox txtHiddenHihokenshaNo;
    @JsonProperty("dgTokubetsuChiikiKasanGemmenList")
    private DataGrid<dgTokubetsuChiikiKasanGemmenList_Row> dgTokubetsuChiikiKasanGemmenList;
    @JsonProperty("TokubetsuChiikiKasanGemmenDetail")
    private TokubetsuChiikiKasanGemmenDetailDiv TokubetsuChiikiKasanGemmenDetail;
    @JsonProperty("btnClose")
    private Button btnClose;

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

    @JsonProperty("dgTokubetsuChiikiKasanGemmenList")
    public DataGrid<dgTokubetsuChiikiKasanGemmenList_Row> getDgTokubetsuChiikiKasanGemmenList() {
        return dgTokubetsuChiikiKasanGemmenList;
    }

    @JsonProperty("dgTokubetsuChiikiKasanGemmenList")
    public void setDgTokubetsuChiikiKasanGemmenList(DataGrid<dgTokubetsuChiikiKasanGemmenList_Row> dgTokubetsuChiikiKasanGemmenList) {
        this.dgTokubetsuChiikiKasanGemmenList=dgTokubetsuChiikiKasanGemmenList;
    }

    @JsonProperty("TokubetsuChiikiKasanGemmenDetail")
    public TokubetsuChiikiKasanGemmenDetailDiv getTokubetsuChiikiKasanGemmenDetail() {
        return TokubetsuChiikiKasanGemmenDetail;
    }

    @JsonProperty("TokubetsuChiikiKasanGemmenDetail")
    public void setTokubetsuChiikiKasanGemmenDetail(TokubetsuChiikiKasanGemmenDetailDiv TokubetsuChiikiKasanGemmenDetail) {
        this.TokubetsuChiikiKasanGemmenDetail=TokubetsuChiikiKasanGemmenDetail;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
