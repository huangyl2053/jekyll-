package jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengakuDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.dgHomonkaigoRiyoshaFutangakuGengakuList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HomonkaigoRiyoshaFutangakuGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonkaigoRiyoshaFutangakuGengakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    private TextBox txtHiddenHihokenshaNo;
    @JsonProperty("dgHomonkaigoRiyoshaFutangakuGengakuList")
    private DataGrid<dgHomonkaigoRiyoshaFutangakuGengakuList_Row> dgHomonkaigoRiyoshaFutangakuGengakuList;
    @JsonProperty("HomonkaigoRiyoshaFutangakuGengakuDetail")
    private HomonkaigoRiyoshaFutangakuGengakuDetailDiv HomonkaigoRiyoshaFutangakuGengakuDetail;
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

    @JsonProperty("dgHomonkaigoRiyoshaFutangakuGengakuList")
    public DataGrid<dgHomonkaigoRiyoshaFutangakuGengakuList_Row> getDgHomonkaigoRiyoshaFutangakuGengakuList() {
        return dgHomonkaigoRiyoshaFutangakuGengakuList;
    }

    @JsonProperty("dgHomonkaigoRiyoshaFutangakuGengakuList")
    public void setDgHomonkaigoRiyoshaFutangakuGengakuList(DataGrid<dgHomonkaigoRiyoshaFutangakuGengakuList_Row> dgHomonkaigoRiyoshaFutangakuGengakuList) {
        this.dgHomonkaigoRiyoshaFutangakuGengakuList=dgHomonkaigoRiyoshaFutangakuGengakuList;
    }

    @JsonProperty("HomonkaigoRiyoshaFutangakuGengakuDetail")
    public HomonkaigoRiyoshaFutangakuGengakuDetailDiv getHomonkaigoRiyoshaFutangakuGengakuDetail() {
        return HomonkaigoRiyoshaFutangakuGengakuDetail;
    }

    @JsonProperty("HomonkaigoRiyoshaFutangakuGengakuDetail")
    public void setHomonkaigoRiyoshaFutangakuGengakuDetail(HomonkaigoRiyoshaFutangakuGengakuDetailDiv HomonkaigoRiyoshaFutangakuGengakuDetail) {
        this.HomonkaigoRiyoshaFutangakuGengakuDetail=HomonkaigoRiyoshaFutangakuGengakuDetail;
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
