package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
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
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;
    @JsonProperty("radJotaiKubun")
    private RadioButton radJotaiKubun;
    @JsonProperty("txtGokei")
    private TextBoxNum txtGokei;
    @JsonProperty("txtKanryoKano")
    private TextBoxNum txtKanryoKano;
    @JsonProperty("txtMishori")
    private TextBoxNum txtMishori;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;
    @JsonProperty("btnchosakekkaoutput")
    private ButtonDownLoad btnchosakekkaoutput;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

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
     * getbtnchosakekkaoutput
     * @return btnchosakekkaoutput
     */
    @JsonProperty("btnchosakekkaoutput")
    public ButtonDownLoad getBtnchosakekkaoutput() {
        return btnchosakekkaoutput;
    }

    /*
     * setbtnchosakekkaoutput
     * @param btnchosakekkaoutput btnchosakekkaoutput
     */
    @JsonProperty("btnchosakekkaoutput")
    public void setBtnchosakekkaoutput(ButtonDownLoad btnchosakekkaoutput) {
        this.btnchosakekkaoutput = btnchosakekkaoutput;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    // </editor-fold>
}
