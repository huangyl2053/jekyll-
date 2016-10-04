package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlTsuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlTsuchishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkOutPutSelect")
    private CheckBoxList chkOutPutSelect;
    @JsonProperty("txtKikan")
    private TextBoxDateRange txtKikan;
    @JsonProperty("txtHakobi")
    private TextBoxFlexibleDate txtHakobi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkOutPutSelect
     * @return chkOutPutSelect
     */
    @JsonProperty("chkOutPutSelect")
    public CheckBoxList getChkOutPutSelect() {
        return chkOutPutSelect;
    }

    /*
     * setchkOutPutSelect
     * @param chkOutPutSelect chkOutPutSelect
     */
    @JsonProperty("chkOutPutSelect")
    public void setChkOutPutSelect(CheckBoxList chkOutPutSelect) {
        this.chkOutPutSelect = chkOutPutSelect;
    }

    /*
     * gettxtKikan
     * @return txtKikan
     */
    @JsonProperty("txtKikan")
    public TextBoxDateRange getTxtKikan() {
        return txtKikan;
    }

    /*
     * settxtKikan
     * @param txtKikan txtKikan
     */
    @JsonProperty("txtKikan")
    public void setTxtKikan(TextBoxDateRange txtKikan) {
        this.txtKikan = txtKikan;
    }

    /*
     * gettxtHakobi
     * @return txtHakobi
     */
    @JsonProperty("txtHakobi")
    public TextBoxFlexibleDate getTxtHakobi() {
        return txtHakobi;
    }

    /*
     * settxtHakobi
     * @param txtHakobi txtHakobi
     */
    @JsonProperty("txtHakobi")
    public void setTxtHakobi(TextBoxFlexibleDate txtHakobi) {
        this.txtHakobi = txtHakobi;
    }

    // </editor-fold>
}
