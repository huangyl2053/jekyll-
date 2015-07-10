package jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShujiiIkensho")
    private DataGrid<dgShujiiIkensho_Row> dgShujiiIkensho;
    @JsonProperty("chkInsatsuIkensho")
    private CheckBoxList chkInsatsuIkensho;
    @JsonProperty("chkIkenshoSakuseiryoSeikyusho")
    private CheckBoxList chkIkenshoSakuseiryoSeikyusho;
    @JsonProperty("chkIkenshoSakuseiIchiran")
    private CheckBoxList chkIkenshoSakuseiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShujiiIkensho")
    public DataGrid<dgShujiiIkensho_Row> getDgShujiiIkensho() {
        return dgShujiiIkensho;
    }

    @JsonProperty("dgShujiiIkensho")
    public void setDgShujiiIkensho(DataGrid<dgShujiiIkensho_Row> dgShujiiIkensho) {
        this.dgShujiiIkensho=dgShujiiIkensho;
    }

    @JsonProperty("chkInsatsuIkensho")
    public CheckBoxList getChkInsatsuIkensho() {
        return chkInsatsuIkensho;
    }

    @JsonProperty("chkInsatsuIkensho")
    public void setChkInsatsuIkensho(CheckBoxList chkInsatsuIkensho) {
        this.chkInsatsuIkensho=chkInsatsuIkensho;
    }

    @JsonProperty("chkIkenshoSakuseiryoSeikyusho")
    public CheckBoxList getChkIkenshoSakuseiryoSeikyusho() {
        return chkIkenshoSakuseiryoSeikyusho;
    }

    @JsonProperty("chkIkenshoSakuseiryoSeikyusho")
    public void setChkIkenshoSakuseiryoSeikyusho(CheckBoxList chkIkenshoSakuseiryoSeikyusho) {
        this.chkIkenshoSakuseiryoSeikyusho=chkIkenshoSakuseiryoSeikyusho;
    }

    @JsonProperty("chkIkenshoSakuseiIchiran")
    public CheckBoxList getChkIkenshoSakuseiIchiran() {
        return chkIkenshoSakuseiIchiran;
    }

    @JsonProperty("chkIkenshoSakuseiIchiran")
    public void setChkIkenshoSakuseiIchiran(CheckBoxList chkIkenshoSakuseiIchiran) {
        this.chkIkenshoSakuseiIchiran=chkIkenshoSakuseiIchiran;
    }

    // </editor-fold>
}
