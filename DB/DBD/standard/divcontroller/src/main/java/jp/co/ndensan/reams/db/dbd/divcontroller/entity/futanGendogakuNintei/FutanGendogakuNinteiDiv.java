package jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.IFutanGendogakuNinteiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.FutanGendogakuNinteiDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.dgFutanGendogakuNinteiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FutanGendogakuNintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanGendogakuNinteiDiv extends Panel implements IFutanGendogakuNinteiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    private TextBox txtHiddenHihokenshaNo;
    @JsonProperty("dgFutanGendogakuNinteiList")
    private DataGrid<dgFutanGendogakuNinteiList_Row> dgFutanGendogakuNinteiList;
    @JsonProperty("FutanGendogakuNinteiDetail")
    private FutanGendogakuNinteiDetailDiv FutanGendogakuNinteiDetail;
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

    @JsonProperty("dgFutanGendogakuNinteiList")
    public DataGrid<dgFutanGendogakuNinteiList_Row> getDgFutanGendogakuNinteiList() {
        return dgFutanGendogakuNinteiList;
    }

    @JsonProperty("dgFutanGendogakuNinteiList")
    public void setDgFutanGendogakuNinteiList(DataGrid<dgFutanGendogakuNinteiList_Row> dgFutanGendogakuNinteiList) {
        this.dgFutanGendogakuNinteiList=dgFutanGendogakuNinteiList;
    }

    @JsonProperty("FutanGendogakuNinteiDetail")
    public FutanGendogakuNinteiDetailDiv getFutanGendogakuNinteiDetail() {
        return FutanGendogakuNinteiDetail;
    }

    @JsonProperty("FutanGendogakuNinteiDetail")
    public void setFutanGendogakuNinteiDetail(FutanGendogakuNinteiDetailDiv FutanGendogakuNinteiDetail) {
        this.FutanGendogakuNinteiDetail=FutanGendogakuNinteiDetail;
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
