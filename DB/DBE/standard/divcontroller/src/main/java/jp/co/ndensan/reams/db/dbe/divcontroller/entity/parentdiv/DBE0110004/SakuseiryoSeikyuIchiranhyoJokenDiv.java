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
 * SakuseiryoSeikyuIchiranhyoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class SakuseiryoSeikyuIchiranhyoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkSakuseiryoSeikyuIchiranhyo")
    private CheckBoxList chkSakuseiryoSeikyuIchiranhyo;
    @JsonProperty("radSeikyuIchiranJoken")
    private RadioButton radSeikyuIchiranJoken;
    @JsonProperty("txtSeikyuIchiranShoriYMD")
    private TextBoxDateRange txtSeikyuIchiranShoriYMD;
    @JsonProperty("txtJuryoYMD")
    private TextBoxDateRange txtJuryoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkSakuseiryoSeikyuIchiranhyo
     * @return chkSakuseiryoSeikyuIchiranhyo
     */
    @JsonProperty("chkSakuseiryoSeikyuIchiranhyo")
    public CheckBoxList getChkSakuseiryoSeikyuIchiranhyo() {
        return chkSakuseiryoSeikyuIchiranhyo;
    }

    /*
     * setchkSakuseiryoSeikyuIchiranhyo
     * @param chkSakuseiryoSeikyuIchiranhyo chkSakuseiryoSeikyuIchiranhyo
     */
    @JsonProperty("chkSakuseiryoSeikyuIchiranhyo")
    public void setChkSakuseiryoSeikyuIchiranhyo(CheckBoxList chkSakuseiryoSeikyuIchiranhyo) {
        this.chkSakuseiryoSeikyuIchiranhyo = chkSakuseiryoSeikyuIchiranhyo;
    }

    /*
     * getradSeikyuIchiranJoken
     * @return radSeikyuIchiranJoken
     */
    @JsonProperty("radSeikyuIchiranJoken")
    public RadioButton getRadSeikyuIchiranJoken() {
        return radSeikyuIchiranJoken;
    }

    /*
     * setradSeikyuIchiranJoken
     * @param radSeikyuIchiranJoken radSeikyuIchiranJoken
     */
    @JsonProperty("radSeikyuIchiranJoken")
    public void setRadSeikyuIchiranJoken(RadioButton radSeikyuIchiranJoken) {
        this.radSeikyuIchiranJoken = radSeikyuIchiranJoken;
    }

    /*
     * gettxtSeikyuIchiranShoriYMD
     * @return txtSeikyuIchiranShoriYMD
     */
    @JsonProperty("txtSeikyuIchiranShoriYMD")
    public TextBoxDateRange getTxtSeikyuIchiranShoriYMD() {
        return txtSeikyuIchiranShoriYMD;
    }

    /*
     * settxtSeikyuIchiranShoriYMD
     * @param txtSeikyuIchiranShoriYMD txtSeikyuIchiranShoriYMD
     */
    @JsonProperty("txtSeikyuIchiranShoriYMD")
    public void setTxtSeikyuIchiranShoriYMD(TextBoxDateRange txtSeikyuIchiranShoriYMD) {
        this.txtSeikyuIchiranShoriYMD = txtSeikyuIchiranShoriYMD;
    }

    /*
     * gettxtJuryoYMD
     * @return txtJuryoYMD
     */
    @JsonProperty("txtJuryoYMD")
    public TextBoxDateRange getTxtJuryoYMD() {
        return txtJuryoYMD;
    }

    /*
     * settxtJuryoYMD
     * @param txtJuryoYMD txtJuryoYMD
     */
    @JsonProperty("txtJuryoYMD")
    public void setTxtJuryoYMD(TextBoxDateRange txtJuryoYMD) {
        this.txtJuryoYMD = txtJuryoYMD;
    }

    // </editor-fold>
}
