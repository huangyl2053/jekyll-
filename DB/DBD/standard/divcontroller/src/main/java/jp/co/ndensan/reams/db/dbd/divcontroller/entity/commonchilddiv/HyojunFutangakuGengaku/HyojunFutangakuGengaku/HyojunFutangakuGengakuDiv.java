package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HyojunFutangakuGengaku.HyojunFutangakuGengaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HyojunFutangakuGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HyojunFutangakuGengakuDiv extends Panel implements IHyojunFutangakuGengakuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
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
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHiddenHihokenshaNo
     * @return txtHiddenHihokenshaNo
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    public TextBox getTxtHiddenHihokenshaNo() {
        return txtHiddenHihokenshaNo;
    }

    /*
     * settxtHiddenHihokenshaNo
     * @param txtHiddenHihokenshaNo txtHiddenHihokenshaNo
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    public void setTxtHiddenHihokenshaNo(TextBox txtHiddenHihokenshaNo) {
        this.txtHiddenHihokenshaNo = txtHiddenHihokenshaNo;
    }

    /*
     * getdgHyojunFutangakuGengakuList
     * @return dgHyojunFutangakuGengakuList
     */
    @JsonProperty("dgHyojunFutangakuGengakuList")
    public DataGrid<dgHyojunFutangakuGengakuList_Row> getDgHyojunFutangakuGengakuList() {
        return dgHyojunFutangakuGengakuList;
    }

    /*
     * setdgHyojunFutangakuGengakuList
     * @param dgHyojunFutangakuGengakuList dgHyojunFutangakuGengakuList
     */
    @JsonProperty("dgHyojunFutangakuGengakuList")
    public void setDgHyojunFutangakuGengakuList(DataGrid<dgHyojunFutangakuGengakuList_Row> dgHyojunFutangakuGengakuList) {
        this.dgHyojunFutangakuGengakuList = dgHyojunFutangakuGengakuList;
    }

    /*
     * getHyojunFutangakuGemmenDetail
     * @return HyojunFutangakuGemmenDetail
     */
    @JsonProperty("HyojunFutangakuGemmenDetail")
    public HyojunFutangakuGemmenDetailDiv getHyojunFutangakuGemmenDetail() {
        return HyojunFutangakuGemmenDetail;
    }

    /*
     * setHyojunFutangakuGemmenDetail
     * @param HyojunFutangakuGemmenDetail HyojunFutangakuGemmenDetail
     */
    @JsonProperty("HyojunFutangakuGemmenDetail")
    public void setHyojunFutangakuGemmenDetail(HyojunFutangakuGemmenDetailDiv HyojunFutangakuGemmenDetail) {
        this.HyojunFutangakuGemmenDetail = HyojunFutangakuGemmenDetail;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
