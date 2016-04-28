package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShakaiFukushiHojinKeigen;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShakaiFukushiHojinKeigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShakaiFukushiHojinKeigenDiv extends Panel implements IShakaiFukushiHojinKeigenDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
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
     * getdgShakaiFukushiHojinKeigenList
     * @return dgShakaiFukushiHojinKeigenList
     */
    @JsonProperty("dgShakaiFukushiHojinKeigenList")
    public DataGrid<dgShakaiFukushiHojinKeigenList_Row> getDgShakaiFukushiHojinKeigenList() {
        return dgShakaiFukushiHojinKeigenList;
    }

    /*
     * setdgShakaiFukushiHojinKeigenList
     * @param dgShakaiFukushiHojinKeigenList dgShakaiFukushiHojinKeigenList
     */
    @JsonProperty("dgShakaiFukushiHojinKeigenList")
    public void setDgShakaiFukushiHojinKeigenList(DataGrid<dgShakaiFukushiHojinKeigenList_Row> dgShakaiFukushiHojinKeigenList) {
        this.dgShakaiFukushiHojinKeigenList = dgShakaiFukushiHojinKeigenList;
    }

    /*
     * getShakaiFukushiHojinKeigenDetail
     * @return ShakaiFukushiHojinKeigenDetail
     */
    @JsonProperty("ShakaiFukushiHojinKeigenDetail")
    public ShakaiFukushiHojinKeigenDetailDiv getShakaiFukushiHojinKeigenDetail() {
        return ShakaiFukushiHojinKeigenDetail;
    }

    /*
     * setShakaiFukushiHojinKeigenDetail
     * @param ShakaiFukushiHojinKeigenDetail ShakaiFukushiHojinKeigenDetail
     */
    @JsonProperty("ShakaiFukushiHojinKeigenDetail")
    public void setShakaiFukushiHojinKeigenDetail(ShakaiFukushiHojinKeigenDetailDiv ShakaiFukushiHojinKeigenDetail) {
        this.ShakaiFukushiHojinKeigenDetail = ShakaiFukushiHojinKeigenDetail;
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
