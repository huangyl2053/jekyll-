package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TeishiKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class TeishiKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTeishiRirekiAdd")
    private Button btnTeishiRirekiAdd;
    @JsonProperty("dgTeishiRireki")
    private DataGrid<dgTeishiRireki_Row> dgTeishiRireki;
    @JsonProperty("TeishiKikanInput")
    private TeishiKikanInputDiv TeishiKikanInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTeishiRirekiAdd
     * @return btnTeishiRirekiAdd
     */
    @JsonProperty("btnTeishiRirekiAdd")
    public Button getBtnTeishiRirekiAdd() {
        return btnTeishiRirekiAdd;
    }

    /*
     * setbtnTeishiRirekiAdd
     * @param btnTeishiRirekiAdd btnTeishiRirekiAdd
     */
    @JsonProperty("btnTeishiRirekiAdd")
    public void setBtnTeishiRirekiAdd(Button btnTeishiRirekiAdd) {
        this.btnTeishiRirekiAdd = btnTeishiRirekiAdd;
    }

    /*
     * getdgTeishiRireki
     * @return dgTeishiRireki
     */
    @JsonProperty("dgTeishiRireki")
    public DataGrid<dgTeishiRireki_Row> getDgTeishiRireki() {
        return dgTeishiRireki;
    }

    /*
     * setdgTeishiRireki
     * @param dgTeishiRireki dgTeishiRireki
     */
    @JsonProperty("dgTeishiRireki")
    public void setDgTeishiRireki(DataGrid<dgTeishiRireki_Row> dgTeishiRireki) {
        this.dgTeishiRireki = dgTeishiRireki;
    }

    /*
     * getTeishiKikanInput
     * @return TeishiKikanInput
     */
    @JsonProperty("TeishiKikanInput")
    public TeishiKikanInputDiv getTeishiKikanInput() {
        return TeishiKikanInput;
    }

    /*
     * setTeishiKikanInput
     * @param TeishiKikanInput TeishiKikanInput
     */
    @JsonProperty("TeishiKikanInput")
    public void setTeishiKikanInput(TeishiKikanInputDiv TeishiKikanInput) {
        this.TeishiKikanInput = TeishiKikanInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtTeishiKaishiYMD() {
        return this.getTeishiKikanInput().getTxtTeishiKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtTeishiKaishiYMD(TextBoxDate txtTeishiKaishiYMD) {
        this.getTeishiKikanInput().setTxtTeishiKaishiYMD(txtTeishiKaishiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeishiShuryoYMD() {
        return this.getTeishiKikanInput().getTxtTeishiShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtTeishiShuryoYMD(TextBoxDate txtTeishiShuryoYMD) {
        this.getTeishiKikanInput().setTxtTeishiShuryoYMD(txtTeishiShuryoYMD);
    }

    @JsonIgnore
    public TeishiInputSeigyoDiv getTeishiInputSeigyo() {
        return this.getTeishiKikanInput().getTeishiInputSeigyo();
    }

    @JsonIgnore
    public void  setTeishiInputSeigyo(TeishiInputSeigyoDiv TeishiInputSeigyo) {
        this.getTeishiKikanInput().setTeishiInputSeigyo(TeishiInputSeigyo);
    }

    @JsonIgnore
    public Button getBtnTeishiInputKakutei() {
        return this.getTeishiKikanInput().getTeishiInputSeigyo().getBtnTeishiInputKakutei();
    }

    @JsonIgnore
    public void  setBtnTeishiInputKakutei(Button btnTeishiInputKakutei) {
        this.getTeishiKikanInput().getTeishiInputSeigyo().setBtnTeishiInputKakutei(btnTeishiInputKakutei);
    }

    @JsonIgnore
    public Button getBtnTeishiInputTorikeshi() {
        return this.getTeishiKikanInput().getTeishiInputSeigyo().getBtnTeishiInputTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTeishiInputTorikeshi(Button btnTeishiInputTorikeshi) {
        this.getTeishiKikanInput().getTeishiInputSeigyo().setBtnTeishiInputTorikeshi(btnTeishiInputTorikeshi);
    }

    // </editor-fold>
}
