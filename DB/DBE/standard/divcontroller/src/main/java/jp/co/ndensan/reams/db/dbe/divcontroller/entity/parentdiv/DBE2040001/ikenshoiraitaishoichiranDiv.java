package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001;
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
 * ikenshoiraitaishoichiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ikenshoiraitaishoichiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShoriJyotai")
    private RadioButton radShoriJyotai;
    @JsonProperty("txtTotalCount")
    private TextBoxNum txtTotalCount;
    @JsonProperty("txtCompleteCount")
    private TextBoxNum txtCompleteCount;
    @JsonProperty("txtNoUpdate")
    private TextBoxNum txtNoUpdate;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;
    @JsonProperty("txtSaidaiHyojiKensu")
    private TextBoxNum txtSaidaiHyojiKensu;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShoriJyotai
     * @return radShoriJyotai
     */
    @JsonProperty("radShoriJyotai")
    public RadioButton getRadShoriJyotai() {
        return radShoriJyotai;
    }

    /*
     * setradShoriJyotai
     * @param radShoriJyotai radShoriJyotai
     */
    @JsonProperty("radShoriJyotai")
    public void setRadShoriJyotai(RadioButton radShoriJyotai) {
        this.radShoriJyotai = radShoriJyotai;
    }

    /*
     * gettxtTotalCount
     * @return txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public TextBoxNum getTxtTotalCount() {
        return txtTotalCount;
    }

    /*
     * settxtTotalCount
     * @param txtTotalCount txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public void setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.txtTotalCount = txtTotalCount;
    }

    /*
     * gettxtCompleteCount
     * @return txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public TextBoxNum getTxtCompleteCount() {
        return txtCompleteCount;
    }

    /*
     * settxtCompleteCount
     * @param txtCompleteCount txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public void setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.txtCompleteCount = txtCompleteCount;
    }

    /*
     * gettxtNoUpdate
     * @return txtNoUpdate
     */
    @JsonProperty("txtNoUpdate")
    public TextBoxNum getTxtNoUpdate() {
        return txtNoUpdate;
    }

    /*
     * settxtNoUpdate
     * @param txtNoUpdate txtNoUpdate
     */
    @JsonProperty("txtNoUpdate")
    public void setTxtNoUpdate(TextBoxNum txtNoUpdate) {
        this.txtNoUpdate = txtNoUpdate;
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
     * gettxtSaidaiHyojiKensu
     * @return txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return txtSaidaiHyojiKensu;
    }

    /*
     * settxtSaidaiHyojiKensu
     * @param txtSaidaiHyojiKensu txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public void setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.txtSaidaiHyojiKensu = txtSaidaiHyojiKensu;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
