package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ISogoShokaiSaishinsaMoushitateInfoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SogoShokaiSaishinsaJiyuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SogoShokaiSaishinsaKekkaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiSaishinsaMoushitateInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiSaishinsaMoushitateInfoDiv extends Panel implements ISogoShokaiSaishinsaMoushitateInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSaishinsaTaishoYM")
    private TextBoxDate txtSaishinsaTaishoYM;
    @JsonProperty("txtSaishinsaMoshitateYMD")
    private TextBoxDate txtSaishinsaMoshitateYMD;
    @JsonProperty("txtSaishinsaTeikyoYM")
    private TextBoxDate txtSaishinsaTeikyoYM;
    @JsonProperty("txtSaishinsaJigyoshaCode")
    private TextBoxCode txtSaishinsaJigyoshaCode;
    @JsonProperty("txtSaishinsaJigyoshaName")
    private TextBox txtSaishinsaJigyoshaName;
    @JsonProperty("txtSaishinsaServiceShuruiCode")
    private TextBoxCode txtSaishinsaServiceShuruiCode;
    @JsonProperty("txtSaishinsaServiceCode")
    private TextBoxCode txtSaishinsaServiceCode;
    @JsonProperty("txtSaishinsaServiceName")
    private TextBox txtSaishinsaServiceName;
    @JsonProperty("txtSaishinsaMoshitateTanisu")
    private TextBoxNum txtSaishinsaMoshitateTanisu;
    @JsonProperty("SogoShokaiSaishinsaJiyu")
    private SogoShokaiSaishinsaJiyuDiv SogoShokaiSaishinsaJiyu;
    @JsonProperty("SogoShokaiSaishinsaKekka")
    private SogoShokaiSaishinsaKekkaDiv SogoShokaiSaishinsaKekka;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSaishinsaTaishoYM")
    public TextBoxDate getTxtSaishinsaTaishoYM() {
        return txtSaishinsaTaishoYM;
    }

    @JsonProperty("txtSaishinsaTaishoYM")
    public void setTxtSaishinsaTaishoYM(TextBoxDate txtSaishinsaTaishoYM) {
        this.txtSaishinsaTaishoYM=txtSaishinsaTaishoYM;
    }

    @JsonProperty("txtSaishinsaMoshitateYMD")
    public TextBoxDate getTxtSaishinsaMoshitateYMD() {
        return txtSaishinsaMoshitateYMD;
    }

    @JsonProperty("txtSaishinsaMoshitateYMD")
    public void setTxtSaishinsaMoshitateYMD(TextBoxDate txtSaishinsaMoshitateYMD) {
        this.txtSaishinsaMoshitateYMD=txtSaishinsaMoshitateYMD;
    }

    @JsonProperty("txtSaishinsaTeikyoYM")
    public TextBoxDate getTxtSaishinsaTeikyoYM() {
        return txtSaishinsaTeikyoYM;
    }

    @JsonProperty("txtSaishinsaTeikyoYM")
    public void setTxtSaishinsaTeikyoYM(TextBoxDate txtSaishinsaTeikyoYM) {
        this.txtSaishinsaTeikyoYM=txtSaishinsaTeikyoYM;
    }

    @JsonProperty("txtSaishinsaJigyoshaCode")
    public TextBoxCode getTxtSaishinsaJigyoshaCode() {
        return txtSaishinsaJigyoshaCode;
    }

    @JsonProperty("txtSaishinsaJigyoshaCode")
    public void setTxtSaishinsaJigyoshaCode(TextBoxCode txtSaishinsaJigyoshaCode) {
        this.txtSaishinsaJigyoshaCode=txtSaishinsaJigyoshaCode;
    }

    @JsonProperty("txtSaishinsaJigyoshaName")
    public TextBox getTxtSaishinsaJigyoshaName() {
        return txtSaishinsaJigyoshaName;
    }

    @JsonProperty("txtSaishinsaJigyoshaName")
    public void setTxtSaishinsaJigyoshaName(TextBox txtSaishinsaJigyoshaName) {
        this.txtSaishinsaJigyoshaName=txtSaishinsaJigyoshaName;
    }

    @JsonProperty("txtSaishinsaServiceShuruiCode")
    public TextBoxCode getTxtSaishinsaServiceShuruiCode() {
        return txtSaishinsaServiceShuruiCode;
    }

    @JsonProperty("txtSaishinsaServiceShuruiCode")
    public void setTxtSaishinsaServiceShuruiCode(TextBoxCode txtSaishinsaServiceShuruiCode) {
        this.txtSaishinsaServiceShuruiCode=txtSaishinsaServiceShuruiCode;
    }

    @JsonProperty("txtSaishinsaServiceCode")
    public TextBoxCode getTxtSaishinsaServiceCode() {
        return txtSaishinsaServiceCode;
    }

    @JsonProperty("txtSaishinsaServiceCode")
    public void setTxtSaishinsaServiceCode(TextBoxCode txtSaishinsaServiceCode) {
        this.txtSaishinsaServiceCode=txtSaishinsaServiceCode;
    }

    @JsonProperty("txtSaishinsaServiceName")
    public TextBox getTxtSaishinsaServiceName() {
        return txtSaishinsaServiceName;
    }

    @JsonProperty("txtSaishinsaServiceName")
    public void setTxtSaishinsaServiceName(TextBox txtSaishinsaServiceName) {
        this.txtSaishinsaServiceName=txtSaishinsaServiceName;
    }

    @JsonProperty("txtSaishinsaMoshitateTanisu")
    public TextBoxNum getTxtSaishinsaMoshitateTanisu() {
        return txtSaishinsaMoshitateTanisu;
    }

    @JsonProperty("txtSaishinsaMoshitateTanisu")
    public void setTxtSaishinsaMoshitateTanisu(TextBoxNum txtSaishinsaMoshitateTanisu) {
        this.txtSaishinsaMoshitateTanisu=txtSaishinsaMoshitateTanisu;
    }

    @JsonProperty("SogoShokaiSaishinsaJiyu")
    public SogoShokaiSaishinsaJiyuDiv getSogoShokaiSaishinsaJiyu() {
        return SogoShokaiSaishinsaJiyu;
    }

    @JsonProperty("SogoShokaiSaishinsaJiyu")
    public void setSogoShokaiSaishinsaJiyu(SogoShokaiSaishinsaJiyuDiv SogoShokaiSaishinsaJiyu) {
        this.SogoShokaiSaishinsaJiyu=SogoShokaiSaishinsaJiyu;
    }

    @JsonProperty("SogoShokaiSaishinsaKekka")
    public SogoShokaiSaishinsaKekkaDiv getSogoShokaiSaishinsaKekka() {
        return SogoShokaiSaishinsaKekka;
    }

    @JsonProperty("SogoShokaiSaishinsaKekka")
    public void setSogoShokaiSaishinsaKekka(SogoShokaiSaishinsaKekkaDiv SogoShokaiSaishinsaKekka) {
        this.SogoShokaiSaishinsaKekka=SogoShokaiSaishinsaKekka;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
