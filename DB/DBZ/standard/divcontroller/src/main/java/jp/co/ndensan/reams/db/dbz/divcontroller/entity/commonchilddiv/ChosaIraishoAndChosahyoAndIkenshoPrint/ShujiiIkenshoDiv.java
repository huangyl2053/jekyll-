package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;
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
 * ShujiiIkensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-15_14-55-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShujiiIkensho")
    private DataGrid<dgShujiiIkensho_Row> dgShujiiIkensho;
    @JsonProperty("ShujiiIkenshoPrint")
    private ShujiiIkenshoPrintDiv ShujiiIkenshoPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShujiiIkensho
     * @return dgShujiiIkensho
     */
    @JsonProperty("dgShujiiIkensho")
    public DataGrid<dgShujiiIkensho_Row> getDgShujiiIkensho() {
        return dgShujiiIkensho;
    }

    /*
     * setdgShujiiIkensho
     * @param dgShujiiIkensho dgShujiiIkensho
     */
    @JsonProperty("dgShujiiIkensho")
    public void setDgShujiiIkensho(DataGrid<dgShujiiIkensho_Row> dgShujiiIkensho) {
        this.dgShujiiIkensho = dgShujiiIkensho;
    }

    /*
     * getShujiiIkenshoPrint
     * @return ShujiiIkenshoPrint
     */
    @JsonProperty("ShujiiIkenshoPrint")
    public ShujiiIkenshoPrintDiv getShujiiIkenshoPrint() {
        return ShujiiIkenshoPrint;
    }

    /*
     * setShujiiIkenshoPrint
     * @param ShujiiIkenshoPrint ShujiiIkenshoPrint
     */
    @JsonProperty("ShujiiIkenshoPrint")
    public void setShujiiIkenshoPrint(ShujiiIkenshoPrintDiv ShujiiIkenshoPrint) {
        this.ShujiiIkenshoPrint = ShujiiIkenshoPrint;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkIkenshoIraisho() {
        return this.getShujiiIkenshoPrint().getChkIkenshoIraisho();
    }

    @JsonIgnore
    public void  setChkIkenshoIraisho(CheckBoxList chkIkenshoIraisho) {
        this.getShujiiIkenshoPrint().setChkIkenshoIraisho(chkIkenshoIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkensho() {
        return this.getShujiiIkenshoPrint().getChkIkensho();
    }

    @JsonIgnore
    public void  setChkIkensho(CheckBoxList chkIkensho) {
        this.getShujiiIkenshoPrint().setChkIkensho(chkIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSeikyusho() {
        return this.getShujiiIkenshoPrint().getChkIkenshoSeikyusho();
    }

    @JsonIgnore
    public void  setChkIkenshoSeikyusho(CheckBoxList chkIkenshoSeikyusho) {
        this.getShujiiIkenshoPrint().setChkIkenshoSeikyusho(chkIkenshoSeikyusho);
    }

    @JsonIgnore
    public CheckBoxList getChkShindanMeireisho() {
        return this.getShujiiIkenshoPrint().getChkShindanMeireisho();
    }

    @JsonIgnore
    public void  setChkShindanMeireisho(CheckBoxList chkShindanMeireisho) {
        this.getShujiiIkenshoPrint().setChkShindanMeireisho(chkShindanMeireisho);
    }

    // </editor-fold>
}
