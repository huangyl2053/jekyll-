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
 * IraiZumiIchiranhyoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class IraiZumiIchiranhyoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkIraiZumiIchiranhyoJoken")
    private CheckBoxList chkIraiZumiIchiranhyoJoken;
    @JsonProperty("radJoken5")
    private RadioButton radJoken5;
    @JsonProperty("txtShoriYMD5")
    private TextBoxDateRange txtShoriYMD5;
    @JsonProperty("txtShinseiYMD5")
    private TextBoxDateRange txtShinseiYMD5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkIraiZumiIchiranhyoJoken
     * @return chkIraiZumiIchiranhyoJoken
     */
    @JsonProperty("chkIraiZumiIchiranhyoJoken")
    public CheckBoxList getChkIraiZumiIchiranhyoJoken() {
        return chkIraiZumiIchiranhyoJoken;
    }

    /*
     * setchkIraiZumiIchiranhyoJoken
     * @param chkIraiZumiIchiranhyoJoken chkIraiZumiIchiranhyoJoken
     */
    @JsonProperty("chkIraiZumiIchiranhyoJoken")
    public void setChkIraiZumiIchiranhyoJoken(CheckBoxList chkIraiZumiIchiranhyoJoken) {
        this.chkIraiZumiIchiranhyoJoken = chkIraiZumiIchiranhyoJoken;
    }

    /*
     * getradJoken5
     * @return radJoken5
     */
    @JsonProperty("radJoken5")
    public RadioButton getRadJoken5() {
        return radJoken5;
    }

    /*
     * setradJoken5
     * @param radJoken5 radJoken5
     */
    @JsonProperty("radJoken5")
    public void setRadJoken5(RadioButton radJoken5) {
        this.radJoken5 = radJoken5;
    }

    /*
     * gettxtShoriYMD5
     * @return txtShoriYMD5
     */
    @JsonProperty("txtShoriYMD5")
    public TextBoxDateRange getTxtShoriYMD5() {
        return txtShoriYMD5;
    }

    /*
     * settxtShoriYMD5
     * @param txtShoriYMD5 txtShoriYMD5
     */
    @JsonProperty("txtShoriYMD5")
    public void setTxtShoriYMD5(TextBoxDateRange txtShoriYMD5) {
        this.txtShoriYMD5 = txtShoriYMD5;
    }

    /*
     * gettxtShinseiYMD5
     * @return txtShinseiYMD5
     */
    @JsonProperty("txtShinseiYMD5")
    public TextBoxDateRange getTxtShinseiYMD5() {
        return txtShinseiYMD5;
    }

    /*
     * settxtShinseiYMD5
     * @param txtShinseiYMD5 txtShinseiYMD5
     */
    @JsonProperty("txtShinseiYMD5")
    public void setTxtShinseiYMD5(TextBoxDateRange txtShinseiYMD5) {
        this.txtShinseiYMD5 = txtShinseiYMD5;
    }

    // </editor-fold>
}
