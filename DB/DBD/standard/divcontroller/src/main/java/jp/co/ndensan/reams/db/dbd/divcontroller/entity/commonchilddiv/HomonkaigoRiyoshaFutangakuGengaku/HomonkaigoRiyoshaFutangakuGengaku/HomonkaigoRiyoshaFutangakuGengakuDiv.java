package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HomonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HomonkaigoRiyoshaFutangakuGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonkaigoRiyoshaFutangakuGengakuDiv extends Panel implements IHomonkaigoRiyoshaFutangakuGengakuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgHomonkaigoRiyoshaFutangakuGengakuList")
    private DataGrid<dgHomonkaigoRiyoshaFutangakuGengakuList_Row> dgHomonkaigoRiyoshaFutangakuGengakuList;
    @JsonProperty("HomonkaigoRiyoshaFutangakuGengakuDetail")
    private HomonkaigoRiyoshaFutangakuGengakuDetailDiv HomonkaigoRiyoshaFutangakuGengakuDetail;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("txtHiddenHihokenshaNo")
    private RString txtHiddenHihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgHomonkaigoRiyoshaFutangakuGengakuList
     * @return dgHomonkaigoRiyoshaFutangakuGengakuList
     */
    @JsonProperty("dgHomonkaigoRiyoshaFutangakuGengakuList")
    public DataGrid<dgHomonkaigoRiyoshaFutangakuGengakuList_Row> getDgHomonkaigoRiyoshaFutangakuGengakuList() {
        return dgHomonkaigoRiyoshaFutangakuGengakuList;
    }

    /*
     * setdgHomonkaigoRiyoshaFutangakuGengakuList
     * @param dgHomonkaigoRiyoshaFutangakuGengakuList dgHomonkaigoRiyoshaFutangakuGengakuList
     */
    @JsonProperty("dgHomonkaigoRiyoshaFutangakuGengakuList")
    public void setDgHomonkaigoRiyoshaFutangakuGengakuList(DataGrid<dgHomonkaigoRiyoshaFutangakuGengakuList_Row> dgHomonkaigoRiyoshaFutangakuGengakuList) {
        this.dgHomonkaigoRiyoshaFutangakuGengakuList = dgHomonkaigoRiyoshaFutangakuGengakuList;
    }

    /*
     * getHomonkaigoRiyoshaFutangakuGengakuDetail
     * @return HomonkaigoRiyoshaFutangakuGengakuDetail
     */
    @JsonProperty("HomonkaigoRiyoshaFutangakuGengakuDetail")
    public HomonkaigoRiyoshaFutangakuGengakuDetailDiv getHomonkaigoRiyoshaFutangakuGengakuDetail() {
        return HomonkaigoRiyoshaFutangakuGengakuDetail;
    }

    /*
     * setHomonkaigoRiyoshaFutangakuGengakuDetail
     * @param HomonkaigoRiyoshaFutangakuGengakuDetail HomonkaigoRiyoshaFutangakuGengakuDetail
     */
    @JsonProperty("HomonkaigoRiyoshaFutangakuGengakuDetail")
    public void setHomonkaigoRiyoshaFutangakuGengakuDetail(HomonkaigoRiyoshaFutangakuGengakuDetailDiv HomonkaigoRiyoshaFutangakuGengakuDetail) {
        this.HomonkaigoRiyoshaFutangakuGengakuDetail = HomonkaigoRiyoshaFutangakuGengakuDetail;
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

    /*
     * gettxtHiddenHihokenshaNo
     * @return txtHiddenHihokenshaNo
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    public RString getTxtHiddenHihokenshaNo() {
        return txtHiddenHihokenshaNo;
    }

    /*
     * settxtHiddenHihokenshaNo
     * @param txtHiddenHihokenshaNo txtHiddenHihokenshaNo
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    public void setTxtHiddenHihokenshaNo(RString txtHiddenHihokenshaNo) {
        this.txtHiddenHihokenshaNo = txtHiddenHihokenshaNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
