package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MiteishutsushaIchiranJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class MiteishutsushaIchiranJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkMiteishutsushaIchiran")
    private CheckBoxList chkMiteishutsushaIchiran;
    @JsonProperty("radJoken1")
    private RadioButton radJoken1;
    @JsonProperty("txtIraiNisu")
    private TextBoxNum txtIraiNisu;
    @JsonProperty("txtShinseiYMD1")
    private TextBoxDateRange txtShinseiYMD1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkMiteishutsushaIchiran
     * @return chkMiteishutsushaIchiran
     */
    @JsonProperty("chkMiteishutsushaIchiran")
    public CheckBoxList getChkMiteishutsushaIchiran() {
        return chkMiteishutsushaIchiran;
    }

    /*
     * setchkMiteishutsushaIchiran
     * @param chkMiteishutsushaIchiran chkMiteishutsushaIchiran
     */
    @JsonProperty("chkMiteishutsushaIchiran")
    public void setChkMiteishutsushaIchiran(CheckBoxList chkMiteishutsushaIchiran) {
        this.chkMiteishutsushaIchiran = chkMiteishutsushaIchiran;
    }

    /*
     * getradJoken1
     * @return radJoken1
     */
    @JsonProperty("radJoken1")
    public RadioButton getRadJoken1() {
        return radJoken1;
    }

    /*
     * setradJoken1
     * @param radJoken1 radJoken1
     */
    @JsonProperty("radJoken1")
    public void setRadJoken1(RadioButton radJoken1) {
        this.radJoken1 = radJoken1;
    }

    /*
     * gettxtIraiNisu
     * @return txtIraiNisu
     */
    @JsonProperty("txtIraiNisu")
    public TextBoxNum getTxtIraiNisu() {
        return txtIraiNisu;
    }

    /*
     * settxtIraiNisu
     * @param txtIraiNisu txtIraiNisu
     */
    @JsonProperty("txtIraiNisu")
    public void setTxtIraiNisu(TextBoxNum txtIraiNisu) {
        this.txtIraiNisu = txtIraiNisu;
    }

    /*
     * gettxtShinseiYMD1
     * @return txtShinseiYMD1
     */
    @JsonProperty("txtShinseiYMD1")
    public TextBoxDateRange getTxtShinseiYMD1() {
        return txtShinseiYMD1;
    }

    /*
     * settxtShinseiYMD1
     * @param txtShinseiYMD1 txtShinseiYMD1
     */
    @JsonProperty("txtShinseiYMD1")
    public void setTxtShinseiYMD1(TextBoxDateRange txtShinseiYMD1) {
        this.txtShinseiYMD1 = txtShinseiYMD1;
    }

    // </editor-fold>
}
