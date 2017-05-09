package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoPrint のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoPrintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-15_14-55-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkIkenshoIraisho")
    private CheckBoxList chkIkenshoIraisho;
    @JsonProperty("chkIkensho")
    private CheckBoxList chkIkensho;
    @JsonProperty("chkIkenshoSeikyusho")
    private CheckBoxList chkIkenshoSeikyusho;
    @JsonProperty("chkShindanMeireisho")
    private CheckBoxList chkShindanMeireisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkIkenshoIraisho
     * @return chkIkenshoIraisho
     */
    @JsonProperty("chkIkenshoIraisho")
    public CheckBoxList getChkIkenshoIraisho() {
        return chkIkenshoIraisho;
    }

    /*
     * setchkIkenshoIraisho
     * @param chkIkenshoIraisho chkIkenshoIraisho
     */
    @JsonProperty("chkIkenshoIraisho")
    public void setChkIkenshoIraisho(CheckBoxList chkIkenshoIraisho) {
        this.chkIkenshoIraisho = chkIkenshoIraisho;
    }

    /*
     * getchkIkensho
     * @return chkIkensho
     */
    @JsonProperty("chkIkensho")
    public CheckBoxList getChkIkensho() {
        return chkIkensho;
    }

    /*
     * setchkIkensho
     * @param chkIkensho chkIkensho
     */
    @JsonProperty("chkIkensho")
    public void setChkIkensho(CheckBoxList chkIkensho) {
        this.chkIkensho = chkIkensho;
    }

    /*
     * getchkIkenshoSeikyusho
     * @return chkIkenshoSeikyusho
     */
    @JsonProperty("chkIkenshoSeikyusho")
    public CheckBoxList getChkIkenshoSeikyusho() {
        return chkIkenshoSeikyusho;
    }

    /*
     * setchkIkenshoSeikyusho
     * @param chkIkenshoSeikyusho chkIkenshoSeikyusho
     */
    @JsonProperty("chkIkenshoSeikyusho")
    public void setChkIkenshoSeikyusho(CheckBoxList chkIkenshoSeikyusho) {
        this.chkIkenshoSeikyusho = chkIkenshoSeikyusho;
    }

    /*
     * getchkShindanMeireisho
     * @return chkShindanMeireisho
     */
    @JsonProperty("chkShindanMeireisho")
    public CheckBoxList getChkShindanMeireisho() {
        return chkShindanMeireisho;
    }

    /*
     * setchkShindanMeireisho
     * @param chkShindanMeireisho chkShindanMeireisho
     */
    @JsonProperty("chkShindanMeireisho")
    public void setChkShindanMeireisho(CheckBoxList chkShindanMeireisho) {
        this.chkShindanMeireisho = chkShindanMeireisho;
    }

    // </editor-fold>
}
