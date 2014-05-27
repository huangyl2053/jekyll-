package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShinseiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShinseiInfoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiShinseiYMD")
    private TextBoxDate txtShinseiShinseiYMD;
    @JsonProperty("txtShinseiUketsukeYMD")
    private TextBoxDate txtShinseiUketsukeYMD;
    @JsonProperty("radShinseiShinseiKubun")
    private RadioButton radShinseiShinseiKubun;
    @JsonProperty("txtShinseiShokisaiNo")
    private TextBoxCode txtShinseiShokisaiNo;
    @JsonProperty("chkShinseiSaiso")
    private CheckBoxList chkShinseiSaiso;
    @JsonProperty("txtShinseiName")
    private TextBoxKana txtShinseiName;
    @JsonProperty("txtShinseiKana")
    private TextBoxKana txtShinseiKana;
    @JsonProperty("txtShinseiTelNo")
    private TextBox txtShinseiTelNo;
    @JsonProperty("txtShinseiRiyu")
    private TextBox txtShinseiRiyu;
    @JsonProperty("txtShinseiShiharaiGokei")
    private TextBoxNum txtShinseiShiharaiGokei;
    @JsonProperty("txtShinseiHokenGokei")
    private TextBoxNum txtShinseiHokenGokei;
    @JsonProperty("txtShinseiJikoGokei")
    private TextBoxNum txtShinseiJikoGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiShinseiYMD")
    public TextBoxDate getTxtShinseiShinseiYMD() {
        return txtShinseiShinseiYMD;
    }

    @JsonProperty("txtShinseiShinseiYMD")
    public void setTxtShinseiShinseiYMD(TextBoxDate txtShinseiShinseiYMD) {
        this.txtShinseiShinseiYMD=txtShinseiShinseiYMD;
    }

    @JsonProperty("txtShinseiUketsukeYMD")
    public TextBoxDate getTxtShinseiUketsukeYMD() {
        return txtShinseiUketsukeYMD;
    }

    @JsonProperty("txtShinseiUketsukeYMD")
    public void setTxtShinseiUketsukeYMD(TextBoxDate txtShinseiUketsukeYMD) {
        this.txtShinseiUketsukeYMD=txtShinseiUketsukeYMD;
    }

    @JsonProperty("radShinseiShinseiKubun")
    public RadioButton getRadShinseiShinseiKubun() {
        return radShinseiShinseiKubun;
    }

    @JsonProperty("radShinseiShinseiKubun")
    public void setRadShinseiShinseiKubun(RadioButton radShinseiShinseiKubun) {
        this.radShinseiShinseiKubun=radShinseiShinseiKubun;
    }

    @JsonProperty("txtShinseiShokisaiNo")
    public TextBoxCode getTxtShinseiShokisaiNo() {
        return txtShinseiShokisaiNo;
    }

    @JsonProperty("txtShinseiShokisaiNo")
    public void setTxtShinseiShokisaiNo(TextBoxCode txtShinseiShokisaiNo) {
        this.txtShinseiShokisaiNo=txtShinseiShokisaiNo;
    }

    @JsonProperty("chkShinseiSaiso")
    public CheckBoxList getChkShinseiSaiso() {
        return chkShinseiSaiso;
    }

    @JsonProperty("chkShinseiSaiso")
    public void setChkShinseiSaiso(CheckBoxList chkShinseiSaiso) {
        this.chkShinseiSaiso=chkShinseiSaiso;
    }

    @JsonProperty("txtShinseiName")
    public TextBoxKana getTxtShinseiName() {
        return txtShinseiName;
    }

    @JsonProperty("txtShinseiName")
    public void setTxtShinseiName(TextBoxKana txtShinseiName) {
        this.txtShinseiName=txtShinseiName;
    }

    @JsonProperty("txtShinseiKana")
    public TextBoxKana getTxtShinseiKana() {
        return txtShinseiKana;
    }

    @JsonProperty("txtShinseiKana")
    public void setTxtShinseiKana(TextBoxKana txtShinseiKana) {
        this.txtShinseiKana=txtShinseiKana;
    }

    @JsonProperty("txtShinseiTelNo")
    public TextBox getTxtShinseiTelNo() {
        return txtShinseiTelNo;
    }

    @JsonProperty("txtShinseiTelNo")
    public void setTxtShinseiTelNo(TextBox txtShinseiTelNo) {
        this.txtShinseiTelNo=txtShinseiTelNo;
    }

    @JsonProperty("txtShinseiRiyu")
    public TextBox getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBox txtShinseiRiyu) {
        this.txtShinseiRiyu=txtShinseiRiyu;
    }

    @JsonProperty("txtShinseiShiharaiGokei")
    public TextBoxNum getTxtShinseiShiharaiGokei() {
        return txtShinseiShiharaiGokei;
    }

    @JsonProperty("txtShinseiShiharaiGokei")
    public void setTxtShinseiShiharaiGokei(TextBoxNum txtShinseiShiharaiGokei) {
        this.txtShinseiShiharaiGokei=txtShinseiShiharaiGokei;
    }

    @JsonProperty("txtShinseiHokenGokei")
    public TextBoxNum getTxtShinseiHokenGokei() {
        return txtShinseiHokenGokei;
    }

    @JsonProperty("txtShinseiHokenGokei")
    public void setTxtShinseiHokenGokei(TextBoxNum txtShinseiHokenGokei) {
        this.txtShinseiHokenGokei=txtShinseiHokenGokei;
    }

    @JsonProperty("txtShinseiJikoGokei")
    public TextBoxNum getTxtShinseiJikoGokei() {
        return txtShinseiJikoGokei;
    }

    @JsonProperty("txtShinseiJikoGokei")
    public void setTxtShinseiJikoGokei(TextBoxNum txtShinseiJikoGokei) {
        this.txtShinseiJikoGokei=txtShinseiJikoGokei;
    }

}
