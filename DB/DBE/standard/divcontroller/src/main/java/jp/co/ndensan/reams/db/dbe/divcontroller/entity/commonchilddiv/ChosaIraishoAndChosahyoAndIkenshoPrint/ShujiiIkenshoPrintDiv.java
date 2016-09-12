package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkInsatsuIkensho")
    private CheckBoxList chkInsatsuIkensho;
    @JsonProperty("chkIkenshoSakuseiIchiran")
    private CheckBoxList chkIkenshoSakuseiIchiran;
    @JsonProperty("chkIkenshoSakuseiryoSeikyusho")
    private CheckBoxList chkIkenshoSakuseiryoSeikyusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkInsatsuIkensho
     * @return chkInsatsuIkensho
     */
    @JsonProperty("chkInsatsuIkensho")
    public CheckBoxList getChkInsatsuIkensho() {
        return chkInsatsuIkensho;
    }

    /*
     * setchkInsatsuIkensho
     * @param chkInsatsuIkensho chkInsatsuIkensho
     */
    @JsonProperty("chkInsatsuIkensho")
    public void setChkInsatsuIkensho(CheckBoxList chkInsatsuIkensho) {
        this.chkInsatsuIkensho = chkInsatsuIkensho;
    }

    /*
     * getchkIkenshoSakuseiIchiran
     * @return chkIkenshoSakuseiIchiran
     */
    @JsonProperty("chkIkenshoSakuseiIchiran")
    public CheckBoxList getChkIkenshoSakuseiIchiran() {
        return chkIkenshoSakuseiIchiran;
    }

    /*
     * setchkIkenshoSakuseiIchiran
     * @param chkIkenshoSakuseiIchiran chkIkenshoSakuseiIchiran
     */
    @JsonProperty("chkIkenshoSakuseiIchiran")
    public void setChkIkenshoSakuseiIchiran(CheckBoxList chkIkenshoSakuseiIchiran) {
        this.chkIkenshoSakuseiIchiran = chkIkenshoSakuseiIchiran;
    }

    /*
     * getchkIkenshoSakuseiryoSeikyusho
     * @return chkIkenshoSakuseiryoSeikyusho
     */
    @JsonProperty("chkIkenshoSakuseiryoSeikyusho")
    public CheckBoxList getChkIkenshoSakuseiryoSeikyusho() {
        return chkIkenshoSakuseiryoSeikyusho;
    }

    /*
     * setchkIkenshoSakuseiryoSeikyusho
     * @param chkIkenshoSakuseiryoSeikyusho chkIkenshoSakuseiryoSeikyusho
     */
    @JsonProperty("chkIkenshoSakuseiryoSeikyusho")
    public void setChkIkenshoSakuseiryoSeikyusho(CheckBoxList chkIkenshoSakuseiryoSeikyusho) {
        this.chkIkenshoSakuseiryoSeikyusho = chkIkenshoSakuseiryoSeikyusho;
    }

    // </editor-fold>
}
