package jp.co.ndensan.reams.db.dbd.divcontroller.entity.hyojunFutangakuGemmen;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.hyojunFutangakuGemmen.HyojunFutangakuGemmenDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.hyojunFutangakuGemmen.dgHyojunFutangakuGengakuList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HyojunFutangakuGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HyojunFutangakuGengakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    private TextBox txtHiddenHihokenshaNo;
    @JsonProperty("dgHyojunFutangakuGengakuList")
    private DataGrid<dgHyojunFutangakuGengakuList_Row> dgHyojunFutangakuGengakuList;
    @JsonProperty("HyojunFutangakuGemmenDetail")
    private HyojunFutangakuGemmenDetailDiv HyojunFutangakuGemmenDetail;

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

    @JsonProperty("dgHyojunFutangakuGengakuList")
    public DataGrid<dgHyojunFutangakuGengakuList_Row> getDgHyojunFutangakuGengakuList() {
        return dgHyojunFutangakuGengakuList;
    }

    @JsonProperty("dgHyojunFutangakuGengakuList")
    public void setDgHyojunFutangakuGengakuList(DataGrid<dgHyojunFutangakuGengakuList_Row> dgHyojunFutangakuGengakuList) {
        this.dgHyojunFutangakuGengakuList=dgHyojunFutangakuGengakuList;
    }

    @JsonProperty("HyojunFutangakuGemmenDetail")
    public HyojunFutangakuGemmenDetailDiv getHyojunFutangakuGemmenDetail() {
        return HyojunFutangakuGemmenDetail;
    }

    @JsonProperty("HyojunFutangakuGemmenDetail")
    public void setHyojunFutangakuGemmenDetail(HyojunFutangakuGemmenDetailDiv HyojunFutangakuGemmenDetail) {
        this.HyojunFutangakuGemmenDetail=HyojunFutangakuGemmenDetail;
    }

}
