package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIraiShokai.NinteiChosaIraiShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;

/**
 * NinteiChosaIraiShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaIraiShokaiDiv extends Panel implements INinteiChosaIraiShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgNinteiChosaIrai")
    private DataGrid<dgNinteiChosaIrai_Row> dgNinteiChosaIrai;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("hdnHihokenshaNo")
    private RString hdnHihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgNinteiChosaIrai
     * @return dgNinteiChosaIrai
     */
    @JsonProperty("dgNinteiChosaIrai")
    public DataGrid<dgNinteiChosaIrai_Row> getDgNinteiChosaIrai() {
        return dgNinteiChosaIrai;
    }

    /*
     * setdgNinteiChosaIrai
     * @param dgNinteiChosaIrai dgNinteiChosaIrai
     */
    @JsonProperty("dgNinteiChosaIrai")
    public void setDgNinteiChosaIrai(DataGrid<dgNinteiChosaIrai_Row> dgNinteiChosaIrai) {
        this.dgNinteiChosaIrai = dgNinteiChosaIrai;
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
     * gethdnHihokenshaNo
     * @return hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public RString getHdnHihokenshaNo() {
        return hdnHihokenshaNo;
    }

    /*
     * sethdnHihokenshaNo
     * @param hdnHihokenshaNo hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public void setHdnHihokenshaNo(RString hdnHihokenshaNo) {
        this.hdnHihokenshaNo = hdnHihokenshaNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
