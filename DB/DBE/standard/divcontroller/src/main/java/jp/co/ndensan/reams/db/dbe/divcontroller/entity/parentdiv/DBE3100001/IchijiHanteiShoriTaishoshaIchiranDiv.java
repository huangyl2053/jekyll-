package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHanteiShoriTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiShoriTaishoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radStatus")
    private RadioButton radStatus;
    @JsonProperty("txtSum")
    private TextBoxNum txtSum;
    @JsonProperty("txtKanryoKano")
    private TextBoxNum txtKanryoKano;
    @JsonProperty("txtMishori")
    private TextBoxNum txtMishori;
    @JsonProperty("dgHanteiTaishosha")
    private DataGrid<dgHanteiTaishosha_Row> dgHanteiTaishosha;
    @JsonProperty("txtMaxCount")
    private TextBoxNum txtMaxCount;
    @JsonProperty("chosairaiSelect")
    private chosairaiSelectDiv chosairaiSelect;
    @JsonProperty("btnIchijiHanteiValidate")
    private Button btnIchijiHanteiValidate;
    @JsonProperty("btnHanteishoriAto")
    private Button btnHanteishoriAto;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradStatus
     * @return radStatus
     */
    @JsonProperty("radStatus")
    public RadioButton getRadStatus() {
        return radStatus;
    }

    /*
     * setradStatus
     * @param radStatus radStatus
     */
    @JsonProperty("radStatus")
    public void setRadStatus(RadioButton radStatus) {
        this.radStatus = radStatus;
    }

    /*
     * gettxtSum
     * @return txtSum
     */
    @JsonProperty("txtSum")
    public TextBoxNum getTxtSum() {
        return txtSum;
    }

    /*
     * settxtSum
     * @param txtSum txtSum
     */
    @JsonProperty("txtSum")
    public void setTxtSum(TextBoxNum txtSum) {
        this.txtSum = txtSum;
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
     * getdgHanteiTaishosha
     * @return dgHanteiTaishosha
     */
    @JsonProperty("dgHanteiTaishosha")
    public DataGrid<dgHanteiTaishosha_Row> getDgHanteiTaishosha() {
        return dgHanteiTaishosha;
    }

    /*
     * setdgHanteiTaishosha
     * @param dgHanteiTaishosha dgHanteiTaishosha
     */
    @JsonProperty("dgHanteiTaishosha")
    public void setDgHanteiTaishosha(DataGrid<dgHanteiTaishosha_Row> dgHanteiTaishosha) {
        this.dgHanteiTaishosha = dgHanteiTaishosha;
    }

    /*
     * gettxtMaxCount
     * @return txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public TextBoxNum getTxtMaxCount() {
        return txtMaxCount;
    }

    /*
     * settxtMaxCount
     * @param txtMaxCount txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public void setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.txtMaxCount = txtMaxCount;
    }

    /*
     * getchosairaiSelect
     * @return chosairaiSelect
     */
    @JsonProperty("chosairaiSelect")
    public chosairaiSelectDiv getChosairaiSelect() {
        return chosairaiSelect;
    }

    /*
     * setchosairaiSelect
     * @param chosairaiSelect chosairaiSelect
     */
    @JsonProperty("chosairaiSelect")
    public void setChosairaiSelect(chosairaiSelectDiv chosairaiSelect) {
        this.chosairaiSelect = chosairaiSelect;
    }

    /*
     * getbtnIchijiHanteiValidate
     * @return btnIchijiHanteiValidate
     */
    @JsonProperty("btnIchijiHanteiValidate")
    public Button getBtnIchijiHanteiValidate() {
        return btnIchijiHanteiValidate;
    }

    /*
     * setbtnIchijiHanteiValidate
     * @param btnIchijiHanteiValidate btnIchijiHanteiValidate
     */
    @JsonProperty("btnIchijiHanteiValidate")
    public void setBtnIchijiHanteiValidate(Button btnIchijiHanteiValidate) {
        this.btnIchijiHanteiValidate = btnIchijiHanteiValidate;
    }

    /*
     * getbtnHanteishoriAto
     * @return btnHanteishoriAto
     */
    @JsonProperty("btnHanteishoriAto")
    public Button getBtnHanteishoriAto() {
        return btnHanteishoriAto;
    }

    /*
     * setbtnHanteishoriAto
     * @param btnHanteishoriAto btnHanteishoriAto
     */
    @JsonProperty("btnHanteishoriAto")
    public void setBtnHanteishoriAto(Button btnHanteishoriAto) {
        this.btnHanteishoriAto = btnHanteishoriAto;
    }

    // </editor-fold>
}
