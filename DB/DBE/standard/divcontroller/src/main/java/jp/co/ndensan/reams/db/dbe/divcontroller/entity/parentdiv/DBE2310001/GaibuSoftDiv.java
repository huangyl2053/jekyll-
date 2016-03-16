package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GaibuSoft のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaibuSoftDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblGaibuSoft")
    private Label lblGaibuSoft;
    @JsonProperty("chkGaibuSoft")
    private CheckBoxList chkGaibuSoft;
    @JsonProperty("txtGaibuSoftName")
    private TextBox txtGaibuSoftName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblGaibuSoft
     * @return lblGaibuSoft
     */
    @JsonProperty("lblGaibuSoft")
    public Label getLblGaibuSoft() {
        return lblGaibuSoft;
    }

    /*
     * setlblGaibuSoft
     * @param lblGaibuSoft lblGaibuSoft
     */
    @JsonProperty("lblGaibuSoft")
    public void setLblGaibuSoft(Label lblGaibuSoft) {
        this.lblGaibuSoft = lblGaibuSoft;
    }

    /*
     * getchkGaibuSoft
     * @return chkGaibuSoft
     */
    @JsonProperty("chkGaibuSoft")
    public CheckBoxList getChkGaibuSoft() {
        return chkGaibuSoft;
    }

    /*
     * setchkGaibuSoft
     * @param chkGaibuSoft chkGaibuSoft
     */
    @JsonProperty("chkGaibuSoft")
    public void setChkGaibuSoft(CheckBoxList chkGaibuSoft) {
        this.chkGaibuSoft = chkGaibuSoft;
    }

    /*
     * gettxtGaibuSoftName
     * @return txtGaibuSoftName
     */
    @JsonProperty("txtGaibuSoftName")
    public TextBox getTxtGaibuSoftName() {
        return txtGaibuSoftName;
    }

    /*
     * settxtGaibuSoftName
     * @param txtGaibuSoftName txtGaibuSoftName
     */
    @JsonProperty("txtGaibuSoftName")
    public void setTxtGaibuSoftName(TextBox txtGaibuSoftName) {
        this.txtGaibuSoftName = txtGaibuSoftName;
    }

    // </editor-fold>
}
