package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SogoShokaiKagoMoshitateJiyuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SogoShokaiKagoMoshitateKekkaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiKagoMoushitateInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKagoMoushitateInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKagoTaishoYM")
    private TextBoxDate txtKagoTaishoYM;
    @JsonProperty("txtKagoMoshitateYMD")
    private TextBoxDate txtKagoMoshitateYMD;
    @JsonProperty("txtKagoTeikyoYM")
    private TextBoxDate txtKagoTeikyoYM;
    @JsonProperty("txtKagoDogetsuKago")
    private TextBox txtKagoDogetsuKago;
    @JsonProperty("txtKagoJigyoshaCode")
    private TextBoxCode txtKagoJigyoshaCode;
    @JsonProperty("txtKagoJigyoshaName")
    private TextBox txtKagoJigyoshaName;
    @JsonProperty("SogoShokaiKagoMoshitateJiyu")
    private SogoShokaiKagoMoshitateJiyuDiv SogoShokaiKagoMoshitateJiyu;
    @JsonProperty("SogoShokaiKagoMoshitateKekka")
    private SogoShokaiKagoMoshitateKekkaDiv SogoShokaiKagoMoshitateKekka;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKagoTaishoYM")
    public TextBoxDate getTxtKagoTaishoYM() {
        return txtKagoTaishoYM;
    }

    @JsonProperty("txtKagoTaishoYM")
    public void setTxtKagoTaishoYM(TextBoxDate txtKagoTaishoYM) {
        this.txtKagoTaishoYM=txtKagoTaishoYM;
    }

    @JsonProperty("txtKagoMoshitateYMD")
    public TextBoxDate getTxtKagoMoshitateYMD() {
        return txtKagoMoshitateYMD;
    }

    @JsonProperty("txtKagoMoshitateYMD")
    public void setTxtKagoMoshitateYMD(TextBoxDate txtKagoMoshitateYMD) {
        this.txtKagoMoshitateYMD=txtKagoMoshitateYMD;
    }

    @JsonProperty("txtKagoTeikyoYM")
    public TextBoxDate getTxtKagoTeikyoYM() {
        return txtKagoTeikyoYM;
    }

    @JsonProperty("txtKagoTeikyoYM")
    public void setTxtKagoTeikyoYM(TextBoxDate txtKagoTeikyoYM) {
        this.txtKagoTeikyoYM=txtKagoTeikyoYM;
    }

    @JsonProperty("txtKagoDogetsuKago")
    public TextBox getTxtKagoDogetsuKago() {
        return txtKagoDogetsuKago;
    }

    @JsonProperty("txtKagoDogetsuKago")
    public void setTxtKagoDogetsuKago(TextBox txtKagoDogetsuKago) {
        this.txtKagoDogetsuKago=txtKagoDogetsuKago;
    }

    @JsonProperty("txtKagoJigyoshaCode")
    public TextBoxCode getTxtKagoJigyoshaCode() {
        return txtKagoJigyoshaCode;
    }

    @JsonProperty("txtKagoJigyoshaCode")
    public void setTxtKagoJigyoshaCode(TextBoxCode txtKagoJigyoshaCode) {
        this.txtKagoJigyoshaCode=txtKagoJigyoshaCode;
    }

    @JsonProperty("txtKagoJigyoshaName")
    public TextBox getTxtKagoJigyoshaName() {
        return txtKagoJigyoshaName;
    }

    @JsonProperty("txtKagoJigyoshaName")
    public void setTxtKagoJigyoshaName(TextBox txtKagoJigyoshaName) {
        this.txtKagoJigyoshaName=txtKagoJigyoshaName;
    }

    @JsonProperty("SogoShokaiKagoMoshitateJiyu")
    public SogoShokaiKagoMoshitateJiyuDiv getSogoShokaiKagoMoshitateJiyu() {
        return SogoShokaiKagoMoshitateJiyu;
    }

    @JsonProperty("SogoShokaiKagoMoshitateJiyu")
    public void setSogoShokaiKagoMoshitateJiyu(SogoShokaiKagoMoshitateJiyuDiv SogoShokaiKagoMoshitateJiyu) {
        this.SogoShokaiKagoMoshitateJiyu=SogoShokaiKagoMoshitateJiyu;
    }

    @JsonProperty("SogoShokaiKagoMoshitateKekka")
    public SogoShokaiKagoMoshitateKekkaDiv getSogoShokaiKagoMoshitateKekka() {
        return SogoShokaiKagoMoshitateKekka;
    }

    @JsonProperty("SogoShokaiKagoMoshitateKekka")
    public void setSogoShokaiKagoMoshitateKekka(SogoShokaiKagoMoshitateKekkaDiv SogoShokaiKagoMoshitateKekka) {
        this.SogoShokaiKagoMoshitateKekka=SogoShokaiKagoMoshitateKekka;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

}
