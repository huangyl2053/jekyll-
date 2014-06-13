package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.SogoShokaiFukaTokubetsuChoshuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiFukaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiFukaInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukaChoteiNendo")
    private TextBoxDate txtFukaChoteiNendo;
    @JsonProperty("txtFukaChoteiJiyu")
    private TextBox txtFukaChoteiJiyu;
    @JsonProperty("txtFukaKoseiTsuki")
    private TextBoxNum txtFukaKoseiTsuki;
    @JsonProperty("txtFukaFukaNendo")
    private TextBoxDate txtFukaFukaNendo;
    @JsonProperty("txtFukaKazeiKubunHonnin")
    private TextBox txtFukaKazeiKubunHonnin;
    @JsonProperty("txtFukaKazeiKubunSetai")
    private TextBox txtFukaKazeiKubunSetai;
    @JsonProperty("tblFuka")
    private tblFukaDiv tblFuka;
    @JsonProperty("tblFutsuChoshu")
    private tblFutsuChoshuDiv tblFutsuChoshu;
    @JsonProperty("tblTokubetsuChoshu")
    private tblTokubetsuChoshuDiv tblTokubetsuChoshu;
    @JsonProperty("SogoShokaiFukaTokubetsuChoshu")
    private SogoShokaiFukaTokubetsuChoshuDiv SogoShokaiFukaTokubetsuChoshu;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtFukaChoteiNendo")
    public TextBoxDate getTxtFukaChoteiNendo() {
        return txtFukaChoteiNendo;
    }

    @JsonProperty("txtFukaChoteiNendo")
    public void setTxtFukaChoteiNendo(TextBoxDate txtFukaChoteiNendo) {
        this.txtFukaChoteiNendo=txtFukaChoteiNendo;
    }

    @JsonProperty("txtFukaChoteiJiyu")
    public TextBox getTxtFukaChoteiJiyu() {
        return txtFukaChoteiJiyu;
    }

    @JsonProperty("txtFukaChoteiJiyu")
    public void setTxtFukaChoteiJiyu(TextBox txtFukaChoteiJiyu) {
        this.txtFukaChoteiJiyu=txtFukaChoteiJiyu;
    }

    @JsonProperty("txtFukaKoseiTsuki")
    public TextBoxNum getTxtFukaKoseiTsuki() {
        return txtFukaKoseiTsuki;
    }

    @JsonProperty("txtFukaKoseiTsuki")
    public void setTxtFukaKoseiTsuki(TextBoxNum txtFukaKoseiTsuki) {
        this.txtFukaKoseiTsuki=txtFukaKoseiTsuki;
    }

    @JsonProperty("txtFukaFukaNendo")
    public TextBoxDate getTxtFukaFukaNendo() {
        return txtFukaFukaNendo;
    }

    @JsonProperty("txtFukaFukaNendo")
    public void setTxtFukaFukaNendo(TextBoxDate txtFukaFukaNendo) {
        this.txtFukaFukaNendo=txtFukaFukaNendo;
    }

    @JsonProperty("txtFukaKazeiKubunHonnin")
    public TextBox getTxtFukaKazeiKubunHonnin() {
        return txtFukaKazeiKubunHonnin;
    }

    @JsonProperty("txtFukaKazeiKubunHonnin")
    public void setTxtFukaKazeiKubunHonnin(TextBox txtFukaKazeiKubunHonnin) {
        this.txtFukaKazeiKubunHonnin=txtFukaKazeiKubunHonnin;
    }

    @JsonProperty("txtFukaKazeiKubunSetai")
    public TextBox getTxtFukaKazeiKubunSetai() {
        return txtFukaKazeiKubunSetai;
    }

    @JsonProperty("txtFukaKazeiKubunSetai")
    public void setTxtFukaKazeiKubunSetai(TextBox txtFukaKazeiKubunSetai) {
        this.txtFukaKazeiKubunSetai=txtFukaKazeiKubunSetai;
    }

    @JsonProperty("tblFuka")
    public tblFukaDiv getTblFuka() {
        return tblFuka;
    }

    @JsonProperty("tblFuka")
    public void setTblFuka(tblFukaDiv tblFuka) {
        this.tblFuka=tblFuka;
    }

    @JsonProperty("tblFutsuChoshu")
    public tblFutsuChoshuDiv getTblFutsuChoshu() {
        return tblFutsuChoshu;
    }

    @JsonProperty("tblFutsuChoshu")
    public void setTblFutsuChoshu(tblFutsuChoshuDiv tblFutsuChoshu) {
        this.tblFutsuChoshu=tblFutsuChoshu;
    }

    @JsonProperty("tblTokubetsuChoshu")
    public tblTokubetsuChoshuDiv getTblTokubetsuChoshu() {
        return tblTokubetsuChoshu;
    }

    @JsonProperty("tblTokubetsuChoshu")
    public void setTblTokubetsuChoshu(tblTokubetsuChoshuDiv tblTokubetsuChoshu) {
        this.tblTokubetsuChoshu=tblTokubetsuChoshu;
    }

    @JsonProperty("SogoShokaiFukaTokubetsuChoshu")
    public SogoShokaiFukaTokubetsuChoshuDiv getSogoShokaiFukaTokubetsuChoshu() {
        return SogoShokaiFukaTokubetsuChoshu;
    }

    @JsonProperty("SogoShokaiFukaTokubetsuChoshu")
    public void setSogoShokaiFukaTokubetsuChoshu(SogoShokaiFukaTokubetsuChoshuDiv SogoShokaiFukaTokubetsuChoshu) {
        this.SogoShokaiFukaTokubetsuChoshu=SogoShokaiFukaTokubetsuChoshu;
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
