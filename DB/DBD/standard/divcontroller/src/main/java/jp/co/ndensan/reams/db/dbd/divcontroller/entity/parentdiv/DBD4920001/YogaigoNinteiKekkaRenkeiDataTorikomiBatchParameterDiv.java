package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001;
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
 * YogaigoNinteiKekkaRenkeiDataTorikomiBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class YogaigoNinteiKekkaRenkeiDataTorikomiBatchParameterDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radDataSelect")
    private RadioButton radDataSelect;
    @JsonProperty("radIfType")
    private RadioButton radIfType;
    @JsonProperty("hdNum")
    private TextBox hdNum;
    @JsonProperty("DataGridFile")
    private DataGrid<DataGridFile_Row> DataGridFile;
    @JsonProperty("HokenshaList")
    private HokenshaListDiv HokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradDataSelect
     * @return radDataSelect
     */
    @JsonProperty("radDataSelect")
    public RadioButton getRadDataSelect() {
        return radDataSelect;
    }

    /*
     * setradDataSelect
     * @param radDataSelect radDataSelect
     */
    @JsonProperty("radDataSelect")
    public void setRadDataSelect(RadioButton radDataSelect) {
        this.radDataSelect = radDataSelect;
    }

    /*
     * getradIfType
     * @return radIfType
     */
    @JsonProperty("radIfType")
    public RadioButton getRadIfType() {
        return radIfType;
    }

    /*
     * setradIfType
     * @param radIfType radIfType
     */
    @JsonProperty("radIfType")
    public void setRadIfType(RadioButton radIfType) {
        this.radIfType = radIfType;
    }

    /*
     * gethdNum
     * @return hdNum
     */
    @JsonProperty("hdNum")
    public TextBox getHdNum() {
        return hdNum;
    }

    /*
     * sethdNum
     * @param hdNum hdNum
     */
    @JsonProperty("hdNum")
    public void setHdNum(TextBox hdNum) {
        this.hdNum = hdNum;
    }

    /*
     * getDataGridFile
     * @return DataGridFile
     */
    @JsonProperty("DataGridFile")
    public DataGrid<DataGridFile_Row> getDataGridFile() {
        return DataGridFile;
    }

    /*
     * setDataGridFile
     * @param DataGridFile DataGridFile
     */
    @JsonProperty("DataGridFile")
    public void setDataGridFile(DataGrid<DataGridFile_Row> DataGridFile) {
        this.DataGridFile = DataGridFile;
    }

    /*
     * getHokenshaList
     * @return HokenshaList
     */
    @JsonProperty("HokenshaList")
    public IHokenshaListDiv getHokenshaList() {
        return HokenshaList;
    }

    // </editor-fold>
}
