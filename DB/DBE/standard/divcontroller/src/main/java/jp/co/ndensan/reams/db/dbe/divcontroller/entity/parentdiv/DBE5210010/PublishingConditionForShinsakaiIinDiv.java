package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PublishingConditionForShinsakaiIin のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublishingConditionForShinsakaiIinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCopyNumForShinsakaiIin1")
    private TextBoxNum txtCopyNumForShinsakaiIin1;
    @JsonProperty("chkPrintChohyoIin")
    private CheckBoxList chkPrintChohyoIin;
    @JsonProperty("spSpace")
    private Space spSpace;
    @JsonProperty("chkPrintChohyoShinsakaiIin")
    private CheckBoxList chkPrintChohyoShinsakaiIin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtCopyNumForShinsakaiIin1
     * @return txtCopyNumForShinsakaiIin1
     */
    @JsonProperty("txtCopyNumForShinsakaiIin1")
    public TextBoxNum getTxtCopyNumForShinsakaiIin1() {
        return txtCopyNumForShinsakaiIin1;
    }

    /*
     * settxtCopyNumForShinsakaiIin1
     * @param txtCopyNumForShinsakaiIin1 txtCopyNumForShinsakaiIin1
     */
    @JsonProperty("txtCopyNumForShinsakaiIin1")
    public void setTxtCopyNumForShinsakaiIin1(TextBoxNum txtCopyNumForShinsakaiIin1) {
        this.txtCopyNumForShinsakaiIin1 = txtCopyNumForShinsakaiIin1;
    }

    /*
     * getchkPrintChohyoIin
     * @return chkPrintChohyoIin
     */
    @JsonProperty("chkPrintChohyoIin")
    public CheckBoxList getChkPrintChohyoIin() {
        return chkPrintChohyoIin;
    }

    /*
     * setchkPrintChohyoIin
     * @param chkPrintChohyoIin chkPrintChohyoIin
     */
    @JsonProperty("chkPrintChohyoIin")
    public void setChkPrintChohyoIin(CheckBoxList chkPrintChohyoIin) {
        this.chkPrintChohyoIin = chkPrintChohyoIin;
    }

    /*
     * getspSpace
     * @return spSpace
     */
    @JsonProperty("spSpace")
    public Space getSpSpace() {
        return spSpace;
    }

    /*
     * setspSpace
     * @param spSpace spSpace
     */
    @JsonProperty("spSpace")
    public void setSpSpace(Space spSpace) {
        this.spSpace = spSpace;
    }

    /*
     * getchkPrintChohyoShinsakaiIin
     * @return chkPrintChohyoShinsakaiIin
     */
    @JsonProperty("chkPrintChohyoShinsakaiIin")
    public CheckBoxList getChkPrintChohyoShinsakaiIin() {
        return chkPrintChohyoShinsakaiIin;
    }

    /*
     * setchkPrintChohyoShinsakaiIin
     * @param chkPrintChohyoShinsakaiIin chkPrintChohyoShinsakaiIin
     */
    @JsonProperty("chkPrintChohyoShinsakaiIin")
    public void setChkPrintChohyoShinsakaiIin(CheckBoxList chkPrintChohyoShinsakaiIin) {
        this.chkPrintChohyoShinsakaiIin = chkPrintChohyoShinsakaiIin;
    }

    // </editor-fold>
}
