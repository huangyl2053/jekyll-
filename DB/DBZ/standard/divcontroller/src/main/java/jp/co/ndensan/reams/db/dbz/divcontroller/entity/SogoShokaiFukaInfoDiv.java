package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ISogoShokaiFukaInfoDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SogoShokaiFukaTokubetsuChoshuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblFukaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblFutsuChoshuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblTokubetsuChoshuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiFukaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiFukaInfoDiv extends Panel implements ISogoShokaiFukaInfoDiv {
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

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblFukaKijun() {
        return this.getTblFuka().getLblFukaKijun();
    }

    @JsonIgnore
    public Label getLblFukaKijunYMD() {
        return this.getTblFuka().getLblFukaKijunYMD();
    }

    @JsonIgnore
    public TextBoxDate getTxtFukaKijunYMD() {
        return this.getTblFuka().getTxtFukaKijunYMD();
    }

    @JsonIgnore
    public Label getLblZennendo() {
        return this.getTblFuka().getLblZennendo();
    }

    @JsonIgnore
    public Label getLblShotokuDankai() {
        return this.getTblFuka().getLblShotokuDankai();
    }

    @JsonIgnore
    public TextBox getTxtShotokuDankai() {
        return this.getTblFuka().getTxtShotokuDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoRitsu() {
        return this.getTblFuka().getLblHokenryoRitsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsu() {
        return this.getTblFuka().getTxtHokenryoRitsu();
    }

    @JsonIgnore
    public Label getLblNenHokenryo() {
        return this.getTblFuka().getLblNenHokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtNenHokenryo() {
        return this.getTblFuka().getTxtNenHokenryo();
    }

    @JsonIgnore
    public Label getLblTokubetsuSaishugaku() {
        return this.getTblFuka().getLblTokubetsuSaishugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetsuSaishugaku() {
        return this.getTblFuka().getTxtTokubetsuSaishugaku();
    }

    @JsonIgnore
    public Label getLblFutsuSaishugaku() {
        return this.getTblFuka().getLblFutsuSaishugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsuSaishugaku() {
        return this.getTblFuka().getTxtFutsuSaishugaku();
    }

    @JsonIgnore
    public Label getLblGenmen() {
        return this.getTblFuka().getLblGenmen();
    }

    @JsonIgnore
    public Label getLblGenmengaku() {
        return this.getTblFuka().getLblGenmengaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGenmengaku() {
        return this.getTblFuka().getTxtGenmengaku();
    }

    @JsonIgnore
    public Label getLblEtc() {
        return this.getTblFuka().getLblEtc();
    }

    @JsonIgnore
    public Label getLblZanteiGokei() {
        return this.getTblFuka().getLblZanteiGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiGokei() {
        return this.getTblFuka().getTxtZanteiGokei();
    }

    @JsonIgnore
    public Label getLblSudeniNofugaku() {
        return this.getTblFuka().getLblSudeniNofugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtSudeniNofugaku() {
        return this.getTblFuka().getTxtSudeniNofugaku();
    }

    @JsonIgnore
    public Label getLblKongoNofugaku() {
        return this.getTblFuka().getLblKongoNofugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKongoNofugaku() {
        return this.getTblFuka().getTxtKongoNofugaku();
    }

    @JsonIgnore
    public Label getLblNofuzumigaku() {
        return this.getTblFuka().getLblNofuzumigaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtNofuzumigaku() {
        return this.getTblFuka().getTxtNofuzumigaku();
    }

    @JsonIgnore
    public Label getLblFutsu() {
        return this.getTblFutsuChoshu().getLblFutsu();
    }

    @JsonIgnore
    public Label getLblFutsu1() {
        return this.getTblFutsuChoshu().getLblFutsu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu1() {
        return this.getTblFutsuChoshu().getTxtFutsu1();
    }

    @JsonIgnore
    public Label getLblFutsu2() {
        return this.getTblFutsuChoshu().getLblFutsu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu2() {
        return this.getTblFutsuChoshu().getTxtFutsu2();
    }

    @JsonIgnore
    public Label getLblFutsu3() {
        return this.getTblFutsuChoshu().getLblFutsu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu3() {
        return this.getTblFutsuChoshu().getTxtFutsu3();
    }

    @JsonIgnore
    public Label getLblFutsu4() {
        return this.getTblFutsuChoshu().getLblFutsu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu4() {
        return this.getTblFutsuChoshu().getTxtFutsu4();
    }

    @JsonIgnore
    public Label getLblFutsu5() {
        return this.getTblFutsuChoshu().getLblFutsu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu5() {
        return this.getTblFutsuChoshu().getTxtFutsu5();
    }

    @JsonIgnore
    public Label getLblFutsu6() {
        return this.getTblFutsuChoshu().getLblFutsu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu6() {
        return this.getTblFutsuChoshu().getTxtFutsu6();
    }

    @JsonIgnore
    public Label getLblFutsu7() {
        return this.getTblFutsuChoshu().getLblFutsu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu7() {
        return this.getTblFutsuChoshu().getTxtFutsu7();
    }

    @JsonIgnore
    public Label getLblFutsu8() {
        return this.getTblFutsuChoshu().getLblFutsu8();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu8() {
        return this.getTblFutsuChoshu().getTxtFutsu8();
    }

    @JsonIgnore
    public Label getLblFutsu9() {
        return this.getTblFutsuChoshu().getLblFutsu9();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu9() {
        return this.getTblFutsuChoshu().getTxtFutsu9();
    }

    @JsonIgnore
    public Label getLblFutsu10() {
        return this.getTblFutsuChoshu().getLblFutsu10();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu10() {
        return this.getTblFutsuChoshu().getTxtFutsu10();
    }

    @JsonIgnore
    public Label getLblFutsu11() {
        return this.getTblFutsuChoshu().getLblFutsu11();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu11() {
        return this.getTblFutsuChoshu().getTxtFutsu11();
    }

    @JsonIgnore
    public Label getLblFutsu12() {
        return this.getTblFutsuChoshu().getLblFutsu12();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu12() {
        return this.getTblFutsuChoshu().getTxtFutsu12();
    }

    @JsonIgnore
    public Label getLblFutsu13() {
        return this.getTblFutsuChoshu().getLblFutsu13();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu13() {
        return this.getTblFutsuChoshu().getTxtFutsu13();
    }

    @JsonIgnore
    public Label getLblFutsu14() {
        return this.getTblFutsuChoshu().getLblFutsu14();
    }

    @JsonIgnore
    public TextBoxNum getTxtFutsu14() {
        return this.getTblFutsuChoshu().getTxtFutsu14();
    }

    @JsonIgnore
    public Label getLblTokubetsu() {
        return this.getTblTokubetsuChoshu().getLblTokubetsu();
    }

    @JsonIgnore
    public Label getLblTokubetsu1() {
        return this.getTblTokubetsuChoshu().getLblTokubetsu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetsu1() {
        return this.getTblTokubetsuChoshu().getTxtTokubetsu1();
    }

    @JsonIgnore
    public Label getLblTokubetsu2() {
        return this.getTblTokubetsuChoshu().getLblTokubetsu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetsu2() {
        return this.getTblTokubetsuChoshu().getTxtTokubetsu2();
    }

    @JsonIgnore
    public Label getLblTokubetsu3() {
        return this.getTblTokubetsuChoshu().getLblTokubetsu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetsu3() {
        return this.getTblTokubetsuChoshu().getTxtTokubetsu3();
    }

    @JsonIgnore
    public Label getLblTokubetsu4() {
        return this.getTblTokubetsuChoshu().getLblTokubetsu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetsu4() {
        return this.getTblTokubetsuChoshu().getTxtTokubetsu4();
    }

    @JsonIgnore
    public Label getLblTokubetsu5() {
        return this.getTblTokubetsuChoshu().getLblTokubetsu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetsu5() {
        return this.getTblTokubetsuChoshu().getTxtTokubetsu5();
    }

    @JsonIgnore
    public Label getLblTokubetsu6() {
        return this.getTblTokubetsuChoshu().getLblTokubetsu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetsu6() {
        return this.getTblTokubetsuChoshu().getTxtTokubetsu6();
    }

    //--------------- この行より下にコードを追加してください -------------------

}
