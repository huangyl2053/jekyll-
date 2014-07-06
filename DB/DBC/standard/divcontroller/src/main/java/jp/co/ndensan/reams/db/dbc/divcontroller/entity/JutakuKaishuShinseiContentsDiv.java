package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.JutakuKaishuShinseiDetailInputDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiReasonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethod.PaymentMethodDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfo.ShinseishaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuShinseiContents のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinseiContentsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("txtSeiriNo")
    private TextBoxCode txtSeiriNo;
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("btnShowJizenShinsei")
    private ButtonDialog btnShowJizenShinsei;
    @JsonProperty("txtJutakuOwner")
    private TextBox txtJutakuOwner;
    @JsonProperty("txtRelationWithHihokensha")
    private TextBox txtRelationWithHihokensha;
    @JsonProperty("JutakuKaishuShinseiDetailInput")
    private JutakuKaishuShinseiDetailInputDiv JutakuKaishuShinseiDetailInput;
    @JsonProperty("JutakuKaishuShinseisha")
    private ShinseishaInfoDiv JutakuKaishuShinseisha;
    @JsonProperty("JutakuKaishuShinseiReason")
    private JutakuKaishuShinseiReasonDiv JutakuKaishuShinseiReason;
    @JsonProperty("JutakuKaishuShinseiKozaInfo")
    private PaymentMethodDiv JutakuKaishuShinseiKozaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM=txtTeikyoYM;
    }

    @JsonProperty("txtSeiriNo")
    public TextBoxCode getTxtSeiriNo() {
        return txtSeiriNo;
    }

    @JsonProperty("txtSeiriNo")
    public void setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.txtSeiriNo=txtSeiriNo;
    }

    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("btnShowJizenShinsei")
    public ButtonDialog getBtnShowJizenShinsei() {
        return btnShowJizenShinsei;
    }

    @JsonProperty("btnShowJizenShinsei")
    public void setBtnShowJizenShinsei(ButtonDialog btnShowJizenShinsei) {
        this.btnShowJizenShinsei=btnShowJizenShinsei;
    }

    @JsonProperty("txtJutakuOwner")
    public TextBox getTxtJutakuOwner() {
        return txtJutakuOwner;
    }

    @JsonProperty("txtJutakuOwner")
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.txtJutakuOwner=txtJutakuOwner;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public TextBox getTxtRelationWithHihokensha() {
        return txtRelationWithHihokensha;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.txtRelationWithHihokensha=txtRelationWithHihokensha;
    }

    @JsonProperty("JutakuKaishuShinseiDetailInput")
    public JutakuKaishuShinseiDetailInputDiv getJutakuKaishuShinseiDetailInput() {
        return JutakuKaishuShinseiDetailInput;
    }

    @JsonProperty("JutakuKaishuShinseiDetailInput")
    public void setJutakuKaishuShinseiDetailInput(JutakuKaishuShinseiDetailInputDiv JutakuKaishuShinseiDetailInput) {
        this.JutakuKaishuShinseiDetailInput=JutakuKaishuShinseiDetailInput;
    }

    @JsonProperty("JutakuKaishuShinseisha")
    public ShinseishaInfoDiv getJutakuKaishuShinseisha() {
        return JutakuKaishuShinseisha;
    }

    @JsonProperty("JutakuKaishuShinseisha")
    public void setJutakuKaishuShinseisha(ShinseishaInfoDiv JutakuKaishuShinseisha) {
        this.JutakuKaishuShinseisha=JutakuKaishuShinseisha;
    }

    @JsonProperty("JutakuKaishuShinseiReason")
    public JutakuKaishuShinseiReasonDiv getJutakuKaishuShinseiReason() {
        return JutakuKaishuShinseiReason;
    }

    @JsonProperty("JutakuKaishuShinseiReason")
    public void setJutakuKaishuShinseiReason(JutakuKaishuShinseiReasonDiv JutakuKaishuShinseiReason) {
        this.JutakuKaishuShinseiReason=JutakuKaishuShinseiReason;
    }

    @JsonProperty("JutakuKaishuShinseiKozaInfo")
    public PaymentMethodDiv getJutakuKaishuShinseiKozaInfo() {
        return JutakuKaishuShinseiKozaInfo;
    }

    @JsonProperty("JutakuKaishuShinseiKozaInfo")
    public void setJutakuKaishuShinseiKozaInfo(PaymentMethodDiv JutakuKaishuShinseiKozaInfo) {
        this.JutakuKaishuShinseiKozaInfo=JutakuKaishuShinseiKozaInfo;
    }

}
