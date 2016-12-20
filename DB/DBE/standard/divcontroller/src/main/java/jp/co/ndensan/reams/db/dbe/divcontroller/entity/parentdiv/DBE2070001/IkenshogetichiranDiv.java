package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ikenshogetichiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshogetichiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJyotaiKubun")
    private RadioButton radJyotaiKubun;
    @JsonProperty("txtMisyori")
    private TextBoxNum txtMisyori;
    @JsonProperty("txtKanryouKano")
    private TextBoxNum txtKanryouKano;
    @JsonProperty("txtGokei")
    private TextBoxNum txtGokei;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;
    @JsonProperty("btnikenshogetoutput")
    private ButtonDownLoad btnikenshogetoutput;
    @JsonProperty("txtMaxNumber")
    private TextBoxNum txtMaxNumber;

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
     * gettxtMisyori
     * @return txtMisyori
     */
    @JsonProperty("txtMisyori")
    public TextBoxNum getTxtMisyori() {
        return txtMisyori;
    }

    /*
     * settxtMisyori
     * @param txtMisyori txtMisyori
     */
    @JsonProperty("txtMisyori")
    public void setTxtMisyori(TextBoxNum txtMisyori) {
        this.txtMisyori = txtMisyori;
    }

    /*
     * gettxtKanryouKano
     * @return txtKanryouKano
     */
    @JsonProperty("txtKanryouKano")
    public TextBoxNum getTxtKanryouKano() {
        return txtKanryouKano;
    }

    /*
     * settxtKanryouKano
     * @param txtKanryouKano txtKanryouKano
     */
    @JsonProperty("txtKanryouKano")
    public void setTxtKanryouKano(TextBoxNum txtKanryouKano) {
        this.txtKanryouKano = txtKanryouKano;
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

    /*
     * getbtnikenshogetoutput
     * @return btnikenshogetoutput
     */
    @JsonProperty("btnikenshogetoutput")
    public ButtonDownLoad getBtnikenshogetoutput() {
        return btnikenshogetoutput;
    }

    /*
     * setbtnikenshogetoutput
     * @param btnikenshogetoutput btnikenshogetoutput
     */
    @JsonProperty("btnikenshogetoutput")
    public void setBtnikenshogetoutput(ButtonDownLoad btnikenshogetoutput) {
        this.btnikenshogetoutput = btnikenshogetoutput;
    }

    /*
     * gettxtMaxNumber
     * @return txtMaxNumber
     */
    @JsonProperty("txtMaxNumber")
    public TextBoxNum getTxtMaxNumber() {
        return txtMaxNumber;
    }

    /*
     * settxtMaxNumber
     * @param txtMaxNumber txtMaxNumber
     */
    @JsonProperty("txtMaxNumber")
    public void setTxtMaxNumber(TextBoxNum txtMaxNumber) {
        this.txtMaxNumber = txtMaxNumber;
    }

    // </editor-fold>
}
