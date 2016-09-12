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
 * IraiMishorishaIchiranhyoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class IraiMishorishaIchiranhyoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkIraiMishorishaIchiranhyo")
    private CheckBoxList chkIraiMishorishaIchiranhyo;
    @JsonProperty("radJoken3")
    private RadioButton radJoken3;
    @JsonProperty("txtShinsaYMD3")
    private TextBoxDateRange txtShinsaYMD3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkIraiMishorishaIchiranhyo
     * @return chkIraiMishorishaIchiranhyo
     */
    @JsonProperty("chkIraiMishorishaIchiranhyo")
    public CheckBoxList getChkIraiMishorishaIchiranhyo() {
        return chkIraiMishorishaIchiranhyo;
    }

    /*
     * setchkIraiMishorishaIchiranhyo
     * @param chkIraiMishorishaIchiranhyo chkIraiMishorishaIchiranhyo
     */
    @JsonProperty("chkIraiMishorishaIchiranhyo")
    public void setChkIraiMishorishaIchiranhyo(CheckBoxList chkIraiMishorishaIchiranhyo) {
        this.chkIraiMishorishaIchiranhyo = chkIraiMishorishaIchiranhyo;
    }

    /*
     * getradJoken3
     * @return radJoken3
     */
    @JsonProperty("radJoken3")
    public RadioButton getRadJoken3() {
        return radJoken3;
    }

    /*
     * setradJoken3
     * @param radJoken3 radJoken3
     */
    @JsonProperty("radJoken3")
    public void setRadJoken3(RadioButton radJoken3) {
        this.radJoken3 = radJoken3;
    }

    /*
     * gettxtShinsaYMD3
     * @return txtShinsaYMD3
     */
    @JsonProperty("txtShinsaYMD3")
    public TextBoxDateRange getTxtShinsaYMD3() {
        return txtShinsaYMD3;
    }

    /*
     * settxtShinsaYMD3
     * @param txtShinsaYMD3 txtShinsaYMD3
     */
    @JsonProperty("txtShinsaYMD3")
    public void setTxtShinsaYMD3(TextBoxDateRange txtShinsaYMD3) {
        this.txtShinsaYMD3 = txtShinsaYMD3;
    }

    // </editor-fold>
}
