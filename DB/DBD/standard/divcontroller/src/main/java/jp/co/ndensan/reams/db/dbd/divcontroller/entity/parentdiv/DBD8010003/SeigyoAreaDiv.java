package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeigyoArea のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeigyoAreaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlYear")
    private DropDownList ddlYear;
    @JsonProperty("btnSearch")
    private ButtonDialog btnSearch;
    @JsonProperty("btnCreate")
    private Button btnCreate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlYear
     * @return ddlYear
     */
    @JsonProperty("ddlYear")
    public DropDownList getDdlYear() {
        return ddlYear;
    }

    /*
     * setddlYear
     * @param ddlYear ddlYear
     */
    @JsonProperty("ddlYear")
    public void setDdlYear(DropDownList ddlYear) {
        this.ddlYear = ddlYear;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public ButtonDialog getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(ButtonDialog btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * getbtnCreate
     * @return btnCreate
     */
    @JsonProperty("btnCreate")
    public Button getBtnCreate() {
        return btnCreate;
    }

    /*
     * setbtnCreate
     * @param btnCreate btnCreate
     */
    @JsonProperty("btnCreate")
    public void setBtnCreate(Button btnCreate) {
        this.btnCreate = btnCreate;
    }

    // </editor-fold>
}
