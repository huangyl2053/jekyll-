package jp.co.ndensan.reams.db.dbx.divcontroller.entity.parentdiv;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.parentdiv.IKaigoJigyoshaNoInputGuideDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoJigyoshaNoInputGuide のクラスファイル 
 * 
 * @author 自動生成
 * @jpName
 * @bizDomain 介護
 * @category DAメニュー
 * @subCategory 介護事業者登録
 * @mainClass
 * @reference
 */
public class KaigoJigyoshaNoInputGuideDiv extends Panel implements IKaigoJigyoshaNoInputGuideDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlPrefecturesCode")
    private DropDownList ddlPrefecturesCode;
    @JsonProperty("ddlJigyoshaKubun")
    private DropDownList ddlJigyoshaKubun;
    @JsonProperty("ddlGunshiCode")
    private DropDownList ddlGunshiCode;
    @JsonProperty("txtTsuban")
    private TextBox txtTsuban;
    @JsonProperty("txtCheckDigit")
    private TextBox txtCheckDigit;
    @JsonProperty("btnCalcCheckDigit")
    private Button btnCalcCheckDigit;
    @JsonProperty("btnCreateJigyoshaNo")
    private Button btnCreateJigyoshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlPrefecturesCode")
    public DropDownList getDdlPrefecturesCode() {
        return ddlPrefecturesCode;
    }

    @JsonProperty("ddlPrefecturesCode")
    public void setDdlPrefecturesCode(DropDownList ddlPrefecturesCode) {
        this.ddlPrefecturesCode=ddlPrefecturesCode;
    }

    @JsonProperty("ddlJigyoshaKubun")
    public DropDownList getDdlJigyoshaKubun() {
        return ddlJigyoshaKubun;
    }

    @JsonProperty("ddlJigyoshaKubun")
    public void setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.ddlJigyoshaKubun=ddlJigyoshaKubun;
    }

    @JsonProperty("ddlGunshiCode")
    public DropDownList getDdlGunshiCode() {
        return ddlGunshiCode;
    }

    @JsonProperty("ddlGunshiCode")
    public void setDdlGunshiCode(DropDownList ddlGunshiCode) {
        this.ddlGunshiCode=ddlGunshiCode;
    }

    @JsonProperty("txtTsuban")
    public TextBox getTxtTsuban() {
        return txtTsuban;
    }

    @JsonProperty("txtTsuban")
    public void setTxtTsuban(TextBox txtTsuban) {
        this.txtTsuban=txtTsuban;
    }

    @JsonProperty("txtCheckDigit")
    public TextBox getTxtCheckDigit() {
        return txtCheckDigit;
    }

    @JsonProperty("txtCheckDigit")
    public void setTxtCheckDigit(TextBox txtCheckDigit) {
        this.txtCheckDigit=txtCheckDigit;
    }

    @JsonProperty("btnCalcCheckDigit")
    public Button getBtnCalcCheckDigit() {
        return btnCalcCheckDigit;
    }

    @JsonProperty("btnCalcCheckDigit")
    public void setBtnCalcCheckDigit(Button btnCalcCheckDigit) {
        this.btnCalcCheckDigit=btnCalcCheckDigit;
    }

    @JsonProperty("btnCreateJigyoshaNo")
    public Button getBtnCreateJigyoshaNo() {
        return btnCreateJigyoshaNo;
    }

    @JsonProperty("btnCreateJigyoshaNo")
    public void setBtnCreateJigyoshaNo(Button btnCreateJigyoshaNo) {
        this.btnCreateJigyoshaNo=btnCreateJigyoshaNo;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
