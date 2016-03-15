package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005;
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
 * NinteiChosainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnInsert")
    private Button btnInsert;
    @JsonProperty("dgNinteiChosainList")
    private DataGrid<dgNinteiChosainList_Row> dgNinteiChosainList;
    @JsonProperty("shichosonCode")
    private RString shichosonCode;
    @JsonProperty("chosaChikuCode")
    private RString chosaChikuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnInsert
     * @return btnInsert
     */
    @JsonProperty("btnInsert")
    public Button getBtnInsert() {
        return btnInsert;
    }

    /*
     * setbtnInsert
     * @param btnInsert btnInsert
     */
    @JsonProperty("btnInsert")
    public void setBtnInsert(Button btnInsert) {
        this.btnInsert = btnInsert;
    }

    /*
     * getdgNinteiChosainList
     * @return dgNinteiChosainList
     */
    @JsonProperty("dgNinteiChosainList")
    public DataGrid<dgNinteiChosainList_Row> getDgNinteiChosainList() {
        return dgNinteiChosainList;
    }

    /*
     * setdgNinteiChosainList
     * @param dgNinteiChosainList dgNinteiChosainList
     */
    @JsonProperty("dgNinteiChosainList")
    public void setDgNinteiChosainList(DataGrid<dgNinteiChosainList_Row> dgNinteiChosainList) {
        this.dgNinteiChosainList = dgNinteiChosainList;
    }

    /*
     * getshichosonCode
     * @return shichosonCode
     */
    @JsonProperty("shichosonCode")
    public RString getShichosonCode() {
        return shichosonCode;
    }

    /*
     * setshichosonCode
     * @param shichosonCode shichosonCode
     */
    @JsonProperty("shichosonCode")
    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /*
     * getchosaChikuCode
     * @return chosaChikuCode
     */
    @JsonProperty("chosaChikuCode")
    public RString getChosaChikuCode() {
        return chosaChikuCode;
    }

    /*
     * setchosaChikuCode
     * @param chosaChikuCode chosaChikuCode
     */
    @JsonProperty("chosaChikuCode")
    public void setChosaChikuCode(RString chosaChikuCode) {
        this.chosaChikuCode = chosaChikuCode;
    }

    // </editor-fold>
}
