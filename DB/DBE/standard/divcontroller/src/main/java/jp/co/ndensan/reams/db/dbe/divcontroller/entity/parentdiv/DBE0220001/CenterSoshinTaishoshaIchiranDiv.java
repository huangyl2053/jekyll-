package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * CenterSoshinTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class CenterSoshinTaishoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJyotaiKubun")
    private RadioButton radJyotaiKubun;
    @JsonProperty("txtGokei")
    private TextBox txtGokei;
    @JsonProperty("txtKanryouKano")
    private TextBox txtKanryouKano;
    @JsonProperty("txtMisyori")
    private TextBox txtMisyori;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;
    @JsonProperty("txtDispMax")
    private TextBoxNum txtDispMax;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJyotaiKubun
     * @return radJyotaiKubun
     */
    @JsonProperty("radJyotaiKubun")
    public RadioButton getRadJyotaiKubun() {
        return radJyotaiKubun;
    }

    /*
     * setradJyotaiKubun
     * @param radJyotaiKubun radJyotaiKubun
     */
    @JsonProperty("radJyotaiKubun")
    public void setRadJyotaiKubun(RadioButton radJyotaiKubun) {
        this.radJyotaiKubun = radJyotaiKubun;
    }

    /*
     * gettxtGokei
     * @return txtGokei
     */
    @JsonProperty("txtGokei")
    public TextBox getTxtGokei() {
        return txtGokei;
    }

    /*
     * settxtGokei
     * @param txtGokei txtGokei
     */
    @JsonProperty("txtGokei")
    public void setTxtGokei(TextBox txtGokei) {
        this.txtGokei = txtGokei;
    }

    /*
     * gettxtKanryouKano
     * @return txtKanryouKano
     */
    @JsonProperty("txtKanryouKano")
    public TextBox getTxtKanryouKano() {
        return txtKanryouKano;
    }

    /*
     * settxtKanryouKano
     * @param txtKanryouKano txtKanryouKano
     */
    @JsonProperty("txtKanryouKano")
    public void setTxtKanryouKano(TextBox txtKanryouKano) {
        this.txtKanryouKano = txtKanryouKano;
    }

    /*
     * gettxtMisyori
     * @return txtMisyori
     */
    @JsonProperty("txtMisyori")
    public TextBox getTxtMisyori() {
        return txtMisyori;
    }

    /*
     * settxtMisyori
     * @param txtMisyori txtMisyori
     */
    @JsonProperty("txtMisyori")
    public void setTxtMisyori(TextBox txtMisyori) {
        this.txtMisyori = txtMisyori;
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

    /*
     * gettxtDispMax
     * @return txtDispMax
     */
    @JsonProperty("txtDispMax")
    public TextBoxNum getTxtDispMax() {
        return txtDispMax;
    }

    /*
     * settxtDispMax
     * @param txtDispMax txtDispMax
     */
    @JsonProperty("txtDispMax")
    public void setTxtDispMax(TextBoxNum txtDispMax) {
        this.txtDispMax = txtDispMax;
    }

    // </editor-fold>
}
