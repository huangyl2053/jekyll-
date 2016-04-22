package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ccdSetaiKazei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ccdSetaiKazeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    private TextBox txtSetaiKazeiJokyo;
    @JsonProperty("btnShowSetaiJoho")
    private ButtonDialog btnShowSetaiJoho;
    @JsonProperty("btnShowGemmenJoho")
    private ButtonDialog btnShowGemmenJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSetaiKazeiJokyo
     * @return txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public TextBox getTxtSetaiKazeiJokyo() {
        return txtSetaiKazeiJokyo;
    }

    /*
     * settxtSetaiKazeiJokyo
     * @param txtSetaiKazeiJokyo txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public void setTxtSetaiKazeiJokyo(TextBox txtSetaiKazeiJokyo) {
        this.txtSetaiKazeiJokyo = txtSetaiKazeiJokyo;
    }

    /*
     * getbtnShowSetaiJoho
     * @return btnShowSetaiJoho
     */
    @JsonProperty("btnShowSetaiJoho")
    public ButtonDialog getBtnShowSetaiJoho() {
        return btnShowSetaiJoho;
    }

    /*
     * setbtnShowSetaiJoho
     * @param btnShowSetaiJoho btnShowSetaiJoho
     */
    @JsonProperty("btnShowSetaiJoho")
    public void setBtnShowSetaiJoho(ButtonDialog btnShowSetaiJoho) {
        this.btnShowSetaiJoho = btnShowSetaiJoho;
    }

    /*
     * getbtnShowGemmenJoho
     * @return btnShowGemmenJoho
     */
    @JsonProperty("btnShowGemmenJoho")
    public ButtonDialog getBtnShowGemmenJoho() {
        return btnShowGemmenJoho;
    }

    /*
     * setbtnShowGemmenJoho
     * @param btnShowGemmenJoho btnShowGemmenJoho
     */
    @JsonProperty("btnShowGemmenJoho")
    public void setBtnShowGemmenJoho(ButtonDialog btnShowGemmenJoho) {
        this.btnShowGemmenJoho = btnShowGemmenJoho;
    }

    // </editor-fold>
}
