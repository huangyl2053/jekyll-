package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiNinteiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiNinteiInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteiShinseiYMD")
    private TextBoxDate txtNinteiShinseiYMD;
    @JsonProperty("txtNinteiShinseiKubun")
    private TextBox txtNinteiShinseiKubun;
    @JsonProperty("txtNinteiYukoKubun")
    private TextBox txtNinteiYukoKubun;
    @JsonProperty("txtNinteiChosaJissiYMD")
    private TextBoxDate txtNinteiChosaJissiYMD;
    @JsonProperty("txtNinteiChosaJuryoYMD")
    private TextBoxDate txtNinteiChosaJuryoYMD;
    @JsonProperty("txtNinteiChosaKanryoYMD")
    private TextBoxDate txtNinteiChosaKanryoYMD;
    @JsonProperty("txtNinteiChosaItakusaki")
    private TextBox txtNinteiChosaItakusaki;
    @JsonProperty("txtNinteiChosain")
    private TextBox txtNinteiChosain;
    @JsonProperty("txtNinteiShujii")
    private TextBox txtNinteiShujii;
    @JsonProperty("txtNinteiShujiiIryoKikan")
    private TextBox txtNinteiShujiiIryoKikan;
    @JsonProperty("txtNinteiIkenshoJuryoYMD")
    private TextBoxDate txtNinteiIkenshoJuryoYMD;
    @JsonProperty("txtNinteiIkenshoKanryoYMD")
    private TextBoxDate txtNinteiIkenshoKanryoYMD;
    @JsonProperty("txtNinteiIchijiHantei")
    private TextBox txtNinteiIchijiHantei;
    @JsonProperty("txtNinteiIchijiHanteiNinchi")
    private TextBox txtNinteiIchijiHanteiNinchi;
    @JsonProperty("txtNinteiIchijiHanteiYMD")
    private TextBoxDate txtNinteiIchijiHanteiYMD;
    @JsonProperty("txtNinteiIchijiKanryoYMD")
    private TextBoxDate txtNinteiIchijiKanryoYMD;
    @JsonProperty("txtNinteiNinteiYMD")
    private TextBoxDate txtNinteiNinteiYMD;
    @JsonProperty("txtNinteiJotaiKubun")
    private TextBox txtNinteiJotaiKubun;
    @JsonProperty("txtNinteiYukoKikan")
    private TextBoxDateRange txtNinteiYukoKikan;
    @JsonProperty("txtNinteiIdoJiyu")
    private TextBox txtNinteiIdoJiyu;
    @JsonProperty("txtNinteiIdoYMD")
    private TextBoxDate txtNinteiIdoYMD;
    @JsonProperty("txtNinteiSoshitsuYMD")
    private TextBoxDate txtNinteiSoshitsuYMD;
    @JsonProperty("txtNinteiTorikeshiRiyu")
    private TextBox txtNinteiTorikeshiRiyu;
    @JsonProperty("txtNinteiTorikeshiYMD")
    private TextBoxDate txtNinteiTorikeshiYMD;
    @JsonProperty("txtNinteiTokuteiShippei")
    private TextBox txtNinteiTokuteiShippei;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNinteiShinseiYMD")
    public TextBoxDate getTxtNinteiShinseiYMD() {
        return txtNinteiShinseiYMD;
    }

    @JsonProperty("txtNinteiShinseiYMD")
    public void setTxtNinteiShinseiYMD(TextBoxDate txtNinteiShinseiYMD) {
        this.txtNinteiShinseiYMD=txtNinteiShinseiYMD;
    }

    @JsonProperty("txtNinteiShinseiKubun")
    public TextBox getTxtNinteiShinseiKubun() {
        return txtNinteiShinseiKubun;
    }

    @JsonProperty("txtNinteiShinseiKubun")
    public void setTxtNinteiShinseiKubun(TextBox txtNinteiShinseiKubun) {
        this.txtNinteiShinseiKubun=txtNinteiShinseiKubun;
    }

    @JsonProperty("txtNinteiYukoKubun")
    public TextBox getTxtNinteiYukoKubun() {
        return txtNinteiYukoKubun;
    }

    @JsonProperty("txtNinteiYukoKubun")
    public void setTxtNinteiYukoKubun(TextBox txtNinteiYukoKubun) {
        this.txtNinteiYukoKubun=txtNinteiYukoKubun;
    }

    @JsonProperty("txtNinteiChosaJissiYMD")
    public TextBoxDate getTxtNinteiChosaJissiYMD() {
        return txtNinteiChosaJissiYMD;
    }

    @JsonProperty("txtNinteiChosaJissiYMD")
    public void setTxtNinteiChosaJissiYMD(TextBoxDate txtNinteiChosaJissiYMD) {
        this.txtNinteiChosaJissiYMD=txtNinteiChosaJissiYMD;
    }

    @JsonProperty("txtNinteiChosaJuryoYMD")
    public TextBoxDate getTxtNinteiChosaJuryoYMD() {
        return txtNinteiChosaJuryoYMD;
    }

    @JsonProperty("txtNinteiChosaJuryoYMD")
    public void setTxtNinteiChosaJuryoYMD(TextBoxDate txtNinteiChosaJuryoYMD) {
        this.txtNinteiChosaJuryoYMD=txtNinteiChosaJuryoYMD;
    }

    @JsonProperty("txtNinteiChosaKanryoYMD")
    public TextBoxDate getTxtNinteiChosaKanryoYMD() {
        return txtNinteiChosaKanryoYMD;
    }

    @JsonProperty("txtNinteiChosaKanryoYMD")
    public void setTxtNinteiChosaKanryoYMD(TextBoxDate txtNinteiChosaKanryoYMD) {
        this.txtNinteiChosaKanryoYMD=txtNinteiChosaKanryoYMD;
    }

    @JsonProperty("txtNinteiChosaItakusaki")
    public TextBox getTxtNinteiChosaItakusaki() {
        return txtNinteiChosaItakusaki;
    }

    @JsonProperty("txtNinteiChosaItakusaki")
    public void setTxtNinteiChosaItakusaki(TextBox txtNinteiChosaItakusaki) {
        this.txtNinteiChosaItakusaki=txtNinteiChosaItakusaki;
    }

    @JsonProperty("txtNinteiChosain")
    public TextBox getTxtNinteiChosain() {
        return txtNinteiChosain;
    }

    @JsonProperty("txtNinteiChosain")
    public void setTxtNinteiChosain(TextBox txtNinteiChosain) {
        this.txtNinteiChosain=txtNinteiChosain;
    }

    @JsonProperty("txtNinteiShujii")
    public TextBox getTxtNinteiShujii() {
        return txtNinteiShujii;
    }

    @JsonProperty("txtNinteiShujii")
    public void setTxtNinteiShujii(TextBox txtNinteiShujii) {
        this.txtNinteiShujii=txtNinteiShujii;
    }

    @JsonProperty("txtNinteiShujiiIryoKikan")
    public TextBox getTxtNinteiShujiiIryoKikan() {
        return txtNinteiShujiiIryoKikan;
    }

    @JsonProperty("txtNinteiShujiiIryoKikan")
    public void setTxtNinteiShujiiIryoKikan(TextBox txtNinteiShujiiIryoKikan) {
        this.txtNinteiShujiiIryoKikan=txtNinteiShujiiIryoKikan;
    }

    @JsonProperty("txtNinteiIkenshoJuryoYMD")
    public TextBoxDate getTxtNinteiIkenshoJuryoYMD() {
        return txtNinteiIkenshoJuryoYMD;
    }

    @JsonProperty("txtNinteiIkenshoJuryoYMD")
    public void setTxtNinteiIkenshoJuryoYMD(TextBoxDate txtNinteiIkenshoJuryoYMD) {
        this.txtNinteiIkenshoJuryoYMD=txtNinteiIkenshoJuryoYMD;
    }

    @JsonProperty("txtNinteiIkenshoKanryoYMD")
    public TextBoxDate getTxtNinteiIkenshoKanryoYMD() {
        return txtNinteiIkenshoKanryoYMD;
    }

    @JsonProperty("txtNinteiIkenshoKanryoYMD")
    public void setTxtNinteiIkenshoKanryoYMD(TextBoxDate txtNinteiIkenshoKanryoYMD) {
        this.txtNinteiIkenshoKanryoYMD=txtNinteiIkenshoKanryoYMD;
    }

    @JsonProperty("txtNinteiIchijiHantei")
    public TextBox getTxtNinteiIchijiHantei() {
        return txtNinteiIchijiHantei;
    }

    @JsonProperty("txtNinteiIchijiHantei")
    public void setTxtNinteiIchijiHantei(TextBox txtNinteiIchijiHantei) {
        this.txtNinteiIchijiHantei=txtNinteiIchijiHantei;
    }

    @JsonProperty("txtNinteiIchijiHanteiNinchi")
    public TextBox getTxtNinteiIchijiHanteiNinchi() {
        return txtNinteiIchijiHanteiNinchi;
    }

    @JsonProperty("txtNinteiIchijiHanteiNinchi")
    public void setTxtNinteiIchijiHanteiNinchi(TextBox txtNinteiIchijiHanteiNinchi) {
        this.txtNinteiIchijiHanteiNinchi=txtNinteiIchijiHanteiNinchi;
    }

    @JsonProperty("txtNinteiIchijiHanteiYMD")
    public TextBoxDate getTxtNinteiIchijiHanteiYMD() {
        return txtNinteiIchijiHanteiYMD;
    }

    @JsonProperty("txtNinteiIchijiHanteiYMD")
    public void setTxtNinteiIchijiHanteiYMD(TextBoxDate txtNinteiIchijiHanteiYMD) {
        this.txtNinteiIchijiHanteiYMD=txtNinteiIchijiHanteiYMD;
    }

    @JsonProperty("txtNinteiIchijiKanryoYMD")
    public TextBoxDate getTxtNinteiIchijiKanryoYMD() {
        return txtNinteiIchijiKanryoYMD;
    }

    @JsonProperty("txtNinteiIchijiKanryoYMD")
    public void setTxtNinteiIchijiKanryoYMD(TextBoxDate txtNinteiIchijiKanryoYMD) {
        this.txtNinteiIchijiKanryoYMD=txtNinteiIchijiKanryoYMD;
    }

    @JsonProperty("txtNinteiNinteiYMD")
    public TextBoxDate getTxtNinteiNinteiYMD() {
        return txtNinteiNinteiYMD;
    }

    @JsonProperty("txtNinteiNinteiYMD")
    public void setTxtNinteiNinteiYMD(TextBoxDate txtNinteiNinteiYMD) {
        this.txtNinteiNinteiYMD=txtNinteiNinteiYMD;
    }

    @JsonProperty("txtNinteiJotaiKubun")
    public TextBox getTxtNinteiJotaiKubun() {
        return txtNinteiJotaiKubun;
    }

    @JsonProperty("txtNinteiJotaiKubun")
    public void setTxtNinteiJotaiKubun(TextBox txtNinteiJotaiKubun) {
        this.txtNinteiJotaiKubun=txtNinteiJotaiKubun;
    }

    @JsonProperty("txtNinteiYukoKikan")
    public TextBoxDateRange getTxtNinteiYukoKikan() {
        return txtNinteiYukoKikan;
    }

    @JsonProperty("txtNinteiYukoKikan")
    public void setTxtNinteiYukoKikan(TextBoxDateRange txtNinteiYukoKikan) {
        this.txtNinteiYukoKikan=txtNinteiYukoKikan;
    }

    @JsonProperty("txtNinteiIdoJiyu")
    public TextBox getTxtNinteiIdoJiyu() {
        return txtNinteiIdoJiyu;
    }

    @JsonProperty("txtNinteiIdoJiyu")
    public void setTxtNinteiIdoJiyu(TextBox txtNinteiIdoJiyu) {
        this.txtNinteiIdoJiyu=txtNinteiIdoJiyu;
    }

    @JsonProperty("txtNinteiIdoYMD")
    public TextBoxDate getTxtNinteiIdoYMD() {
        return txtNinteiIdoYMD;
    }

    @JsonProperty("txtNinteiIdoYMD")
    public void setTxtNinteiIdoYMD(TextBoxDate txtNinteiIdoYMD) {
        this.txtNinteiIdoYMD=txtNinteiIdoYMD;
    }

    @JsonProperty("txtNinteiSoshitsuYMD")
    public TextBoxDate getTxtNinteiSoshitsuYMD() {
        return txtNinteiSoshitsuYMD;
    }

    @JsonProperty("txtNinteiSoshitsuYMD")
    public void setTxtNinteiSoshitsuYMD(TextBoxDate txtNinteiSoshitsuYMD) {
        this.txtNinteiSoshitsuYMD=txtNinteiSoshitsuYMD;
    }

    @JsonProperty("txtNinteiTorikeshiRiyu")
    public TextBox getTxtNinteiTorikeshiRiyu() {
        return txtNinteiTorikeshiRiyu;
    }

    @JsonProperty("txtNinteiTorikeshiRiyu")
    public void setTxtNinteiTorikeshiRiyu(TextBox txtNinteiTorikeshiRiyu) {
        this.txtNinteiTorikeshiRiyu=txtNinteiTorikeshiRiyu;
    }

    @JsonProperty("txtNinteiTorikeshiYMD")
    public TextBoxDate getTxtNinteiTorikeshiYMD() {
        return txtNinteiTorikeshiYMD;
    }

    @JsonProperty("txtNinteiTorikeshiYMD")
    public void setTxtNinteiTorikeshiYMD(TextBoxDate txtNinteiTorikeshiYMD) {
        this.txtNinteiTorikeshiYMD=txtNinteiTorikeshiYMD;
    }

    @JsonProperty("txtNinteiTokuteiShippei")
    public TextBox getTxtNinteiTokuteiShippei() {
        return txtNinteiTokuteiShippei;
    }

    @JsonProperty("txtNinteiTokuteiShippei")
    public void setTxtNinteiTokuteiShippei(TextBox txtNinteiTokuteiShippei) {
        this.txtNinteiTokuteiShippei=txtNinteiTokuteiShippei;
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
