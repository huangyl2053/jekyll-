package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ninteichosakekkainput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ninteichosakekkainputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJotaiKubun")
    private RadioButton radJotaiKubun;
    @JsonProperty("txtMishori")
    private TextBoxNum txtMishori;
    @JsonProperty("txtKanryoKano")
    private TextBoxNum txtKanryoKano;
    @JsonProperty("txtGokei")
    private TextBoxNum txtGokei;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJotaiKubun
     * @return radJotaiKubun
     */
    @JsonProperty("radJotaiKubun")
    public RadioButton getRadJotaiKubun() {
        return radJotaiKubun;
    }

    /*
     * setradJotaiKubun
     * @param radJotaiKubun radJotaiKubun
     */
    @JsonProperty("radJotaiKubun")
    public void setRadJotaiKubun(RadioButton radJotaiKubun) {
        this.radJotaiKubun = radJotaiKubun;
    }

    /*
     * gettxtMishori
     * @return txtMishori
     */
    @JsonProperty("txtMishori")
    public TextBoxNum getTxtMishori() {
        return txtMishori;
    }

    /*
     * settxtMishori
     * @param txtMishori txtMishori
     */
    @JsonProperty("txtMishori")
    public void setTxtMishori(TextBoxNum txtMishori) {
        this.txtMishori = txtMishori;
    }

    /*
     * gettxtKanryoKano
     * @return txtKanryoKano
     */
    @JsonProperty("txtKanryoKano")
    public TextBoxNum getTxtKanryoKano() {
        return txtKanryoKano;
    }

    /*
     * settxtKanryoKano
     * @param txtKanryoKano txtKanryoKano
     */
    @JsonProperty("txtKanryoKano")
    public void setTxtKanryoKano(TextBoxNum txtKanryoKano) {
        this.txtKanryoKano = txtKanryoKano;
    }

    /*
     * gettxtGokei
     * @return txtGokei
     */
    @JsonProperty("txtGokei")
    public TextBoxNum getTxtGokei() {
        return txtGokei;
    }

    /*
     * settxtGokei
     * @param txtGokei txtGokei
     */
    @JsonProperty("txtGokei")
    public void setTxtGokei(TextBoxNum txtGokei) {
        this.txtGokei = txtGokei;
    }

    /*
     * getdgNinteiTaskList
     * @return dgNinteiTaskList
     */
    @JsonProperty("dgNinteiTaskList")
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return dgNinteiTaskList;
    }

    /*
     * setdgNinteiTaskList
     * @param dgNinteiTaskList dgNinteiTaskList
     */
    @JsonProperty("dgNinteiTaskList")
    public void setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.dgNinteiTaskList = dgNinteiTaskList;
    }

    // </editor-fold>
}
