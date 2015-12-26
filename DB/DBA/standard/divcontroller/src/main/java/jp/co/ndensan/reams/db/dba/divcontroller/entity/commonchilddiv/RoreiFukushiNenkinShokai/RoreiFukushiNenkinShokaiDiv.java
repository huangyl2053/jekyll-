package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RoreiFukushiNenkinShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class RoreiFukushiNenkinShokaiDiv extends Panel implements IRoreiFukushiNenkinShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelRireki")
    private panelRirekiDiv panelRireki;
    @JsonProperty("panelInput")
    private panelInputDiv panelInput;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("model")
    private RString model;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelRireki
     * @return panelRireki
     */
    @JsonProperty("panelRireki")
    public panelRirekiDiv getPanelRireki() {
        return panelRireki;
    }

    /*
     * setpanelRireki
     * @param panelRireki panelRireki
     */
    @JsonProperty("panelRireki")
    public void setPanelRireki(panelRirekiDiv panelRireki) {
        this.panelRireki = panelRireki;
    }

    /*
     * getpanelInput
     * @return panelInput
     */
    @JsonProperty("panelInput")
    public panelInputDiv getPanelInput() {
        return panelInput;
    }

    /*
     * setpanelInput
     * @param panelInput panelInput
     */
    @JsonProperty("panelInput")
    public void setPanelInput(panelInputDiv panelInput) {
        this.panelInput = panelInput;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * getmodel
     * @return model
     */
    @JsonProperty("model")
    public RString getModel() {
        return model;
    }

    /*
     * setmodel
     * @param model model
     */
    @JsonProperty("model")
    public void setModel(RString model) {
        this.model = model;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getPanelRireki().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getPanelRireki().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<datagridRireki_Row> getDatagridRireki() {
        return this.getPanelRireki().getDatagridRireki();
    }

    @JsonIgnore
    public void  setDatagridRireki(DataGrid<datagridRireki_Row> datagridRireki) {
        this.getPanelRireki().setDatagridRireki(datagridRireki);
    }

    @JsonIgnore
    public TextBoxDate getTxtStartDate() {
        return this.getPanelInput().getTxtStartDate();
    }

    @JsonIgnore
    public void  setTxtStartDate(TextBoxDate txtStartDate) {
        this.getPanelInput().setTxtStartDate(txtStartDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtEndDate() {
        return this.getPanelInput().getTxtEndDate();
    }

    @JsonIgnore
    public void  setTxtEndDate(TextBoxDate txtEndDate) {
        this.getPanelInput().setTxtEndDate(txtEndDate);
    }

    @JsonIgnore
    public Button getBtnSave() {
        return this.getPanelInput().getBtnSave();
    }

    @JsonIgnore
    public void  setBtnSave(Button btnSave) {
        this.getPanelInput().setBtnSave(btnSave);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelInput().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelInput().setBtnCancel(btnCancel);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
