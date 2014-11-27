package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.IShunoJohoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShunoJohoFuchoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShunoJohoTokuchoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShunoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShunoJohoDiv extends Panel implements IShunoJohoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBox txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("txtTsuchiNo")
    private TextBoxCode txtTsuchiNo;
    @JsonProperty("ddlChoteiNendo")
    private DropDownList ddlChoteiNendo;
    @JsonProperty("ddlFukaNendo")
    private DropDownList ddlFukaNendo;
    @JsonProperty("btnNendoChange")
    private Button btnNendoChange;
    @JsonProperty("ShunoJohoTokucho")
    private ShunoJohoTokuchoDiv ShunoJohoTokucho;
    @JsonProperty("ShunoJohoFucho")
    private ShunoJohoFuchoDiv ShunoJohoFucho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo=txtChoteiNendo;
    }

    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("txtTsuchiNo")
    public TextBoxCode getTxtTsuchiNo() {
        return txtTsuchiNo;
    }

    @JsonProperty("txtTsuchiNo")
    public void setTxtTsuchiNo(TextBoxCode txtTsuchiNo) {
        this.txtTsuchiNo=txtTsuchiNo;
    }

    @JsonProperty("ddlChoteiNendo")
    public DropDownList getDdlChoteiNendo() {
        return ddlChoteiNendo;
    }

    @JsonProperty("ddlChoteiNendo")
    public void setDdlChoteiNendo(DropDownList ddlChoteiNendo) {
        this.ddlChoteiNendo=ddlChoteiNendo;
    }

    @JsonProperty("ddlFukaNendo")
    public DropDownList getDdlFukaNendo() {
        return ddlFukaNendo;
    }

    @JsonProperty("ddlFukaNendo")
    public void setDdlFukaNendo(DropDownList ddlFukaNendo) {
        this.ddlFukaNendo=ddlFukaNendo;
    }

    @JsonProperty("btnNendoChange")
    public Button getBtnNendoChange() {
        return btnNendoChange;
    }

    @JsonProperty("btnNendoChange")
    public void setBtnNendoChange(Button btnNendoChange) {
        this.btnNendoChange=btnNendoChange;
    }

    @JsonProperty("ShunoJohoTokucho")
    public ShunoJohoTokuchoDiv getShunoJohoTokucho() {
        return ShunoJohoTokucho;
    }

    @JsonProperty("ShunoJohoTokucho")
    public void setShunoJohoTokucho(ShunoJohoTokuchoDiv ShunoJohoTokucho) {
        this.ShunoJohoTokucho=ShunoJohoTokucho;
    }

    @JsonProperty("ShunoJohoFucho")
    public ShunoJohoFuchoDiv getShunoJohoFucho() {
        return ShunoJohoFucho;
    }

    @JsonProperty("ShunoJohoFucho")
    public void setShunoJohoFucho(ShunoJohoFuchoDiv ShunoJohoFucho) {
        this.ShunoJohoFucho=ShunoJohoFucho;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
