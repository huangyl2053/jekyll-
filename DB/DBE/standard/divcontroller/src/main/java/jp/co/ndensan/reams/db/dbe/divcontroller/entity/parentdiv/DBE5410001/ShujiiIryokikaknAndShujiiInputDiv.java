package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIryokikaknAndShujiiInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIryokikaknAndShujiiInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShujiiIryoKikanCode")
    private TextBoxCode txtShujiiIryoKikanCode;
    @JsonProperty("txtShujiiIryoKikanName")
    private TextBox txtShujiiIryoKikanName;
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("txtShujiiName")
    private TextBox txtShujiiName;
    @JsonProperty("chkShiteii")
    private CheckBoxList chkShiteii;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShujiiIryoKikanCode
     * @return txtShujiiIryoKikanCode
     */
    @JsonProperty("txtShujiiIryoKikanCode")
    public TextBoxCode getTxtShujiiIryoKikanCode() {
        return txtShujiiIryoKikanCode;
    }

    /*
     * settxtShujiiIryoKikanCode
     * @param txtShujiiIryoKikanCode txtShujiiIryoKikanCode
     */
    @JsonProperty("txtShujiiIryoKikanCode")
    public void setTxtShujiiIryoKikanCode(TextBoxCode txtShujiiIryoKikanCode) {
        this.txtShujiiIryoKikanCode = txtShujiiIryoKikanCode;
    }

    /*
     * gettxtShujiiIryoKikanName
     * @return txtShujiiIryoKikanName
     */
    @JsonProperty("txtShujiiIryoKikanName")
    public TextBox getTxtShujiiIryoKikanName() {
        return txtShujiiIryoKikanName;
    }

    /*
     * settxtShujiiIryoKikanName
     * @param txtShujiiIryoKikanName txtShujiiIryoKikanName
     */
    @JsonProperty("txtShujiiIryoKikanName")
    public void setTxtShujiiIryoKikanName(TextBox txtShujiiIryoKikanName) {
        this.txtShujiiIryoKikanName = txtShujiiIryoKikanName;
    }

    /*
     * gettxtShujiiCode
     * @return txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    public TextBoxCode getTxtShujiiCode() {
        return txtShujiiCode;
    }

    /*
     * settxtShujiiCode
     * @param txtShujiiCode txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.txtShujiiCode = txtShujiiCode;
    }

    /*
     * gettxtShujiiName
     * @return txtShujiiName
     */
    @JsonProperty("txtShujiiName")
    public TextBox getTxtShujiiName() {
        return txtShujiiName;
    }

    /*
     * settxtShujiiName
     * @param txtShujiiName txtShujiiName
     */
    @JsonProperty("txtShujiiName")
    public void setTxtShujiiName(TextBox txtShujiiName) {
        this.txtShujiiName = txtShujiiName;
    }

    /*
     * getchkShiteii
     * @return chkShiteii
     */
    @JsonProperty("chkShiteii")
    public CheckBoxList getChkShiteii() {
        return chkShiteii;
    }

    /*
     * setchkShiteii
     * @param chkShiteii chkShiteii
     */
    @JsonProperty("chkShiteii")
    public void setChkShiteii(CheckBoxList chkShiteii) {
        this.chkShiteii = chkShiteii;
    }

    // </editor-fold>
}
