package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.RiyoshaFutangakuGemmen.RiyoshaFutangakuGemmen;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Panel1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Panel1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkYochokin")
    private CheckBoxList chkYochokin;
    @JsonProperty("TextBoxNum1")
    private TextBoxNum TextBoxNum1;
    @JsonProperty("txtYukaShoken")
    private TextBoxNum txtYukaShoken;
    @JsonProperty("txtSonota")
    private TextBoxNum txtSonota;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkYochokin
     * @return chkYochokin
     */
    @JsonProperty("chkYochokin")
    public CheckBoxList getChkYochokin() {
        return chkYochokin;
    }

    /*
     * setchkYochokin
     * @param chkYochokin chkYochokin
     */
    @JsonProperty("chkYochokin")
    public void setChkYochokin(CheckBoxList chkYochokin) {
        this.chkYochokin = chkYochokin;
    }

    /*
     * getTextBoxNum1
     * @return TextBoxNum1
     */
    @JsonProperty("TextBoxNum1")
    public TextBoxNum getTextBoxNum1() {
        return TextBoxNum1;
    }

    /*
     * setTextBoxNum1
     * @param TextBoxNum1 TextBoxNum1
     */
    @JsonProperty("TextBoxNum1")
    public void setTextBoxNum1(TextBoxNum TextBoxNum1) {
        this.TextBoxNum1 = TextBoxNum1;
    }

    /*
     * gettxtYukaShoken
     * @return txtYukaShoken
     */
    @JsonProperty("txtYukaShoken")
    public TextBoxNum getTxtYukaShoken() {
        return txtYukaShoken;
    }

    /*
     * settxtYukaShoken
     * @param txtYukaShoken txtYukaShoken
     */
    @JsonProperty("txtYukaShoken")
    public void setTxtYukaShoken(TextBoxNum txtYukaShoken) {
        this.txtYukaShoken = txtYukaShoken;
    }

    /*
     * gettxtSonota
     * @return txtSonota
     */
    @JsonProperty("txtSonota")
    public TextBoxNum getTxtSonota() {
        return txtSonota;
    }

    /*
     * settxtSonota
     * @param txtSonota txtSonota
     */
    @JsonProperty("txtSonota")
    public void setTxtSonota(TextBoxNum txtSonota) {
        this.txtSonota = txtSonota;
    }

    // </editor-fold>
}
