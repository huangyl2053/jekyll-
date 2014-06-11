package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.Kiwarigaku.KiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblKikanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.txtChoteiJiyuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblFukaKonkyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblFukaKonkyoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cellFukaShokai1")
    private cellFukaShokai1AttblFukaKonkyo cellFukaShokai1;
    @JsonProperty("cellFukaShokai2")
    private cellFukaShokai2AttblFukaKonkyo cellFukaShokai2;
    @JsonProperty("cellFukaShokai3")
    private cellFukaShokai3AttblFukaKonkyo cellFukaShokai3;
    @JsonProperty("cellFukaShokai4")
    private cellFukaShokai4AttblFukaKonkyo cellFukaShokai4;
    @JsonProperty("cellFukaShokai5")
    private cellFukaShokai5AttblFukaKonkyo cellFukaShokai5;
    @JsonProperty("cellFukaShokai6")
    private cellFukaShokai6AttblFukaKonkyo cellFukaShokai6;
    @JsonProperty("cellFukaShokai7")
    private cellFukaShokai7AttblFukaKonkyo cellFukaShokai7;
    @JsonProperty("cellFukaShokai8")
    private cellFukaShokai8AttblFukaKonkyo cellFukaShokai8;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxDate getTxtFukaKijunYMD() {
        return this.cellFukaShokai1.getTxtFukaKijunYMD();
    }

    @JsonIgnore
    public CheckBoxList getChkJuToku() {
        return this.cellFukaShokai1.getChkJuToku();
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMD() {
        return this.cellFukaShokai2.getTxtShikakuShutokuYMD();
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMD() {
        return this.cellFukaShokai2.getTxtShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public TextBoxDate getTxtSeihoKaishiYMD() {
        return this.cellFukaShokai2.getTxtSeihoKaishiYMD();
    }

    @JsonIgnore
    public TextBoxDate getTxtSeihoShuryoYMD() {
        return this.cellFukaShokai2.getTxtSeihoShuryoYMD();
    }

    @JsonIgnore
    public TextBoxDate getTxtRonenKaishiYMD() {
        return this.cellFukaShokai2.getTxtRonenKaishiYMD();
    }

    @JsonIgnore
    public TextBoxDate getTxtRonenShuryoYMD() {
        return this.cellFukaShokai2.getTxtRonenShuryoYMD();
    }

    @JsonIgnore
    public TextBox getTxtHonninKazei() {
        return this.cellFukaShokai3.getTxtHonninKazei();
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazei() {
        return this.cellFukaShokai3.getTxtSetaiKazei();
    }

    @JsonIgnore
    public TextBoxNum getTxtShotokuSum() {
        return this.cellFukaShokai3.getTxtShotokuSum();
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkinShunyu() {
        return this.cellFukaShokai3.getTxtNenkinShunyu();
    }

    @JsonIgnore
    public Label getLblZennendo() {
        return this.cellFukaShokai3.getLblZennendo();
    }

    @JsonIgnore
    public TextBox getTxtHokenryoDankai() {
        return this.cellFukaShokai3.getTxtHokenryoDankai();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoritsu() {
        return this.cellFukaShokai3.getTxtHokenryoritsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtNengakuHokenryo() {
        return this.cellFukaShokai3.getTxtNengakuHokenryo();
    }

    @JsonIgnore
    public TextBoxCode getTxtKisoNenkinNo() {
        return this.cellFukaShokai4.getTxtKisoNenkinNo();
    }

    @JsonIgnore
    public TextBoxCode getTxtNenkinCode() {
        return this.cellFukaShokai4.getTxtNenkinCode();
    }

    @JsonIgnore
    public TextBox getTxtTokuchoGimusha() {
        return this.cellFukaShokai4.getTxtTokuchoGimusha();
    }

    @JsonIgnore
    public TextBox getTxtTokuChoTaishoNenkin() {
        return this.cellFukaShokai4.getTxtTokuChoTaishoNenkin();
    }

    @JsonIgnore
    public tblKikanDiv getTblKikan() {
        return this.cellFukaShokai5.getTblKikan();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeisanjoNenkanHokenryo() {
        return this.cellFukaShokai6.getTxtKeisanjoNenkanHokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmen() {
        return this.cellFukaShokai6.getTxtGemmen();
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkanHokenryo() {
        return this.cellFukaShokai6.getTxtNenkanHokenryo();
    }

    @JsonIgnore
    public KiwarigakuDiv getFukaShokaiKiwarigaku() {
        return this.cellFukaShokai7.getFukaShokaiKiwarigaku();
    }

    @JsonIgnore
    public txtChoteiJiyuDiv getTxtChoteiJiyu() {
        return this.cellFukaShokai8.getTxtChoteiJiyu();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("cellFukaShokai1")
    private cellFukaShokai1AttblFukaKonkyo getCellFukaShokai1() {
        return cellFukaShokai1;
    }

    @JsonProperty("cellFukaShokai1")
    private void setCellFukaShokai1(cellFukaShokai1AttblFukaKonkyo cellFukaShokai1) {
        this.cellFukaShokai1=cellFukaShokai1;
    }

    @JsonProperty("cellFukaShokai2")
    private cellFukaShokai2AttblFukaKonkyo getCellFukaShokai2() {
        return cellFukaShokai2;
    }

    @JsonProperty("cellFukaShokai2")
    private void setCellFukaShokai2(cellFukaShokai2AttblFukaKonkyo cellFukaShokai2) {
        this.cellFukaShokai2=cellFukaShokai2;
    }

    @JsonProperty("cellFukaShokai3")
    private cellFukaShokai3AttblFukaKonkyo getCellFukaShokai3() {
        return cellFukaShokai3;
    }

    @JsonProperty("cellFukaShokai3")
    private void setCellFukaShokai3(cellFukaShokai3AttblFukaKonkyo cellFukaShokai3) {
        this.cellFukaShokai3=cellFukaShokai3;
    }

    @JsonProperty("cellFukaShokai4")
    private cellFukaShokai4AttblFukaKonkyo getCellFukaShokai4() {
        return cellFukaShokai4;
    }

    @JsonProperty("cellFukaShokai4")
    private void setCellFukaShokai4(cellFukaShokai4AttblFukaKonkyo cellFukaShokai4) {
        this.cellFukaShokai4=cellFukaShokai4;
    }

    @JsonProperty("cellFukaShokai5")
    private cellFukaShokai5AttblFukaKonkyo getCellFukaShokai5() {
        return cellFukaShokai5;
    }

    @JsonProperty("cellFukaShokai5")
    private void setCellFukaShokai5(cellFukaShokai5AttblFukaKonkyo cellFukaShokai5) {
        this.cellFukaShokai5=cellFukaShokai5;
    }

    @JsonProperty("cellFukaShokai6")
    private cellFukaShokai6AttblFukaKonkyo getCellFukaShokai6() {
        return cellFukaShokai6;
    }

    @JsonProperty("cellFukaShokai6")
    private void setCellFukaShokai6(cellFukaShokai6AttblFukaKonkyo cellFukaShokai6) {
        this.cellFukaShokai6=cellFukaShokai6;
    }

    @JsonProperty("cellFukaShokai7")
    private cellFukaShokai7AttblFukaKonkyo getCellFukaShokai7() {
        return cellFukaShokai7;
    }

    @JsonProperty("cellFukaShokai7")
    private void setCellFukaShokai7(cellFukaShokai7AttblFukaKonkyo cellFukaShokai7) {
        this.cellFukaShokai7=cellFukaShokai7;
    }

    @JsonProperty("cellFukaShokai8")
    private cellFukaShokai8AttblFukaKonkyo getCellFukaShokai8() {
        return cellFukaShokai8;
    }

    @JsonProperty("cellFukaShokai8")
    private void setCellFukaShokai8(cellFukaShokai8AttblFukaKonkyo cellFukaShokai8) {
        this.cellFukaShokai8=cellFukaShokai8;
    }

}
/**
 * cellFukaShokai1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokai1AttblFukaKonkyo extends TableCell {
    @JsonProperty("txtFukaKijunYMD")
    private TextBoxDate txtFukaKijunYMD;
    @JsonProperty("chkJuToku")
    private CheckBoxList chkJuToku;

    @JsonProperty("txtFukaKijunYMD")
    public TextBoxDate getTxtFukaKijunYMD() {
        return txtFukaKijunYMD;
    }

    @JsonProperty("txtFukaKijunYMD")
    public void setTxtFukaKijunYMD(TextBoxDate txtFukaKijunYMD) {
        this.txtFukaKijunYMD=txtFukaKijunYMD;
    }

    @JsonProperty("chkJuToku")
    public CheckBoxList getChkJuToku() {
        return chkJuToku;
    }

    @JsonProperty("chkJuToku")
    public void setChkJuToku(CheckBoxList chkJuToku) {
        this.chkJuToku=chkJuToku;
    }

}
/**
 * cellFukaShokai2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokai2AttblFukaKonkyo extends TableCell {
    @JsonProperty("txtShikakuShutokuYMD")
    private TextBoxDate txtShikakuShutokuYMD;
    @JsonProperty("txtShikakuSoshitsuYMD")
    private TextBoxDate txtShikakuSoshitsuYMD;
    @JsonProperty("txtSeihoKaishiYMD")
    private TextBoxDate txtSeihoKaishiYMD;
    @JsonProperty("txtSeihoShuryoYMD")
    private TextBoxDate txtSeihoShuryoYMD;
    @JsonProperty("txtRonenKaishiYMD")
    private TextBoxDate txtRonenKaishiYMD;
    @JsonProperty("txtRonenShuryoYMD")
    private TextBoxDate txtRonenShuryoYMD;

    @JsonProperty("txtShikakuShutokuYMD")
    public TextBoxDate getTxtShikakuShutokuYMD() {
        return txtShikakuShutokuYMD;
    }

    @JsonProperty("txtShikakuShutokuYMD")
    public void setTxtShikakuShutokuYMD(TextBoxDate txtShikakuShutokuYMD) {
        this.txtShikakuShutokuYMD=txtShikakuShutokuYMD;
    }

    @JsonProperty("txtShikakuSoshitsuYMD")
    public TextBoxDate getTxtShikakuSoshitsuYMD() {
        return txtShikakuSoshitsuYMD;
    }

    @JsonProperty("txtShikakuSoshitsuYMD")
    public void setTxtShikakuSoshitsuYMD(TextBoxDate txtShikakuSoshitsuYMD) {
        this.txtShikakuSoshitsuYMD=txtShikakuSoshitsuYMD;
    }

    @JsonProperty("txtSeihoKaishiYMD")
    public TextBoxDate getTxtSeihoKaishiYMD() {
        return txtSeihoKaishiYMD;
    }

    @JsonProperty("txtSeihoKaishiYMD")
    public void setTxtSeihoKaishiYMD(TextBoxDate txtSeihoKaishiYMD) {
        this.txtSeihoKaishiYMD=txtSeihoKaishiYMD;
    }

    @JsonProperty("txtSeihoShuryoYMD")
    public TextBoxDate getTxtSeihoShuryoYMD() {
        return txtSeihoShuryoYMD;
    }

    @JsonProperty("txtSeihoShuryoYMD")
    public void setTxtSeihoShuryoYMD(TextBoxDate txtSeihoShuryoYMD) {
        this.txtSeihoShuryoYMD=txtSeihoShuryoYMD;
    }

    @JsonProperty("txtRonenKaishiYMD")
    public TextBoxDate getTxtRonenKaishiYMD() {
        return txtRonenKaishiYMD;
    }

    @JsonProperty("txtRonenKaishiYMD")
    public void setTxtRonenKaishiYMD(TextBoxDate txtRonenKaishiYMD) {
        this.txtRonenKaishiYMD=txtRonenKaishiYMD;
    }

    @JsonProperty("txtRonenShuryoYMD")
    public TextBoxDate getTxtRonenShuryoYMD() {
        return txtRonenShuryoYMD;
    }

    @JsonProperty("txtRonenShuryoYMD")
    public void setTxtRonenShuryoYMD(TextBoxDate txtRonenShuryoYMD) {
        this.txtRonenShuryoYMD=txtRonenShuryoYMD;
    }

}
/**
 * cellFukaShokai3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokai3AttblFukaKonkyo extends TableCell {
    @JsonProperty("txtHonninKazei")
    private TextBox txtHonninKazei;
    @JsonProperty("txtSetaiKazei")
    private TextBox txtSetaiKazei;
    @JsonProperty("txtShotokuSum")
    private TextBoxNum txtShotokuSum;
    @JsonProperty("txtNenkinShunyu")
    private TextBoxNum txtNenkinShunyu;
    @JsonProperty("lblZennendo")
    private Label lblZennendo;
    @JsonProperty("txtHokenryoDankai")
    private TextBox txtHokenryoDankai;
    @JsonProperty("txtHokenryoritsu")
    private TextBoxNum txtHokenryoritsu;
    @JsonProperty("txtNengakuHokenryo")
    private TextBoxNum txtNengakuHokenryo;

    @JsonProperty("txtHonninKazei")
    public TextBox getTxtHonninKazei() {
        return txtHonninKazei;
    }

    @JsonProperty("txtHonninKazei")
    public void setTxtHonninKazei(TextBox txtHonninKazei) {
        this.txtHonninKazei=txtHonninKazei;
    }

    @JsonProperty("txtSetaiKazei")
    public TextBox getTxtSetaiKazei() {
        return txtSetaiKazei;
    }

    @JsonProperty("txtSetaiKazei")
    public void setTxtSetaiKazei(TextBox txtSetaiKazei) {
        this.txtSetaiKazei=txtSetaiKazei;
    }

    @JsonProperty("txtShotokuSum")
    public TextBoxNum getTxtShotokuSum() {
        return txtShotokuSum;
    }

    @JsonProperty("txtShotokuSum")
    public void setTxtShotokuSum(TextBoxNum txtShotokuSum) {
        this.txtShotokuSum=txtShotokuSum;
    }

    @JsonProperty("txtNenkinShunyu")
    public TextBoxNum getTxtNenkinShunyu() {
        return txtNenkinShunyu;
    }

    @JsonProperty("txtNenkinShunyu")
    public void setTxtNenkinShunyu(TextBoxNum txtNenkinShunyu) {
        this.txtNenkinShunyu=txtNenkinShunyu;
    }

    @JsonProperty("lblZennendo")
    public Label getLblZennendo() {
        return lblZennendo;
    }

    @JsonProperty("lblZennendo")
    public void setLblZennendo(Label lblZennendo) {
        this.lblZennendo=lblZennendo;
    }

    @JsonProperty("txtHokenryoDankai")
    public TextBox getTxtHokenryoDankai() {
        return txtHokenryoDankai;
    }

    @JsonProperty("txtHokenryoDankai")
    public void setTxtHokenryoDankai(TextBox txtHokenryoDankai) {
        this.txtHokenryoDankai=txtHokenryoDankai;
    }

    @JsonProperty("txtHokenryoritsu")
    public TextBoxNum getTxtHokenryoritsu() {
        return txtHokenryoritsu;
    }

    @JsonProperty("txtHokenryoritsu")
    public void setTxtHokenryoritsu(TextBoxNum txtHokenryoritsu) {
        this.txtHokenryoritsu=txtHokenryoritsu;
    }

    @JsonProperty("txtNengakuHokenryo")
    public TextBoxNum getTxtNengakuHokenryo() {
        return txtNengakuHokenryo;
    }

    @JsonProperty("txtNengakuHokenryo")
    public void setTxtNengakuHokenryo(TextBoxNum txtNengakuHokenryo) {
        this.txtNengakuHokenryo=txtNengakuHokenryo;
    }

}
/**
 * cellFukaShokai4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokai4AttblFukaKonkyo extends TableCell {
    @JsonProperty("txtKisoNenkinNo")
    private TextBoxCode txtKisoNenkinNo;
    @JsonProperty("txtNenkinCode")
    private TextBoxCode txtNenkinCode;
    @JsonProperty("txtTokuchoGimusha")
    private TextBox txtTokuchoGimusha;
    @JsonProperty("txtTokuChoTaishoNenkin")
    private TextBox txtTokuChoTaishoNenkin;

    @JsonProperty("txtKisoNenkinNo")
    public TextBoxCode getTxtKisoNenkinNo() {
        return txtKisoNenkinNo;
    }

    @JsonProperty("txtKisoNenkinNo")
    public void setTxtKisoNenkinNo(TextBoxCode txtKisoNenkinNo) {
        this.txtKisoNenkinNo=txtKisoNenkinNo;
    }

    @JsonProperty("txtNenkinCode")
    public TextBoxCode getTxtNenkinCode() {
        return txtNenkinCode;
    }

    @JsonProperty("txtNenkinCode")
    public void setTxtNenkinCode(TextBoxCode txtNenkinCode) {
        this.txtNenkinCode=txtNenkinCode;
    }

    @JsonProperty("txtTokuchoGimusha")
    public TextBox getTxtTokuchoGimusha() {
        return txtTokuchoGimusha;
    }

    @JsonProperty("txtTokuchoGimusha")
    public void setTxtTokuchoGimusha(TextBox txtTokuchoGimusha) {
        this.txtTokuchoGimusha=txtTokuchoGimusha;
    }

    @JsonProperty("txtTokuChoTaishoNenkin")
    public TextBox getTxtTokuChoTaishoNenkin() {
        return txtTokuChoTaishoNenkin;
    }

    @JsonProperty("txtTokuChoTaishoNenkin")
    public void setTxtTokuChoTaishoNenkin(TextBox txtTokuChoTaishoNenkin) {
        this.txtTokuChoTaishoNenkin=txtTokuChoTaishoNenkin;
    }

}
/**
 * cellFukaShokai5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokai5AttblFukaKonkyo extends TableCell {
    @JsonProperty("tblKikan")
    private tblKikanDiv tblKikan;

    @JsonProperty("tblKikan")
    public tblKikanDiv getTblKikan() {
        return tblKikan;
    }

    @JsonProperty("tblKikan")
    public void setTblKikan(tblKikanDiv tblKikan) {
        this.tblKikan=tblKikan;
    }

}
/**
 * cellFukaShokai6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokai6AttblFukaKonkyo extends TableCell {
    @JsonProperty("txtKeisanjoNenkanHokenryo")
    private TextBoxNum txtKeisanjoNenkanHokenryo;
    @JsonProperty("txtGemmen")
    private TextBoxNum txtGemmen;
    @JsonProperty("txtNenkanHokenryo")
    private TextBoxNum txtNenkanHokenryo;

    @JsonProperty("txtKeisanjoNenkanHokenryo")
    public TextBoxNum getTxtKeisanjoNenkanHokenryo() {
        return txtKeisanjoNenkanHokenryo;
    }

    @JsonProperty("txtKeisanjoNenkanHokenryo")
    public void setTxtKeisanjoNenkanHokenryo(TextBoxNum txtKeisanjoNenkanHokenryo) {
        this.txtKeisanjoNenkanHokenryo=txtKeisanjoNenkanHokenryo;
    }

    @JsonProperty("txtGemmen")
    public TextBoxNum getTxtGemmen() {
        return txtGemmen;
    }

    @JsonProperty("txtGemmen")
    public void setTxtGemmen(TextBoxNum txtGemmen) {
        this.txtGemmen=txtGemmen;
    }

    @JsonProperty("txtNenkanHokenryo")
    public TextBoxNum getTxtNenkanHokenryo() {
        return txtNenkanHokenryo;
    }

    @JsonProperty("txtNenkanHokenryo")
    public void setTxtNenkanHokenryo(TextBoxNum txtNenkanHokenryo) {
        this.txtNenkanHokenryo=txtNenkanHokenryo;
    }

}
/**
 * cellFukaShokai7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokai7AttblFukaKonkyo extends TableCell {
    @JsonProperty("FukaShokaiKiwarigaku")
    private KiwarigakuDiv FukaShokaiKiwarigaku;

    @JsonProperty("FukaShokaiKiwarigaku")
    public KiwarigakuDiv getFukaShokaiKiwarigaku() {
        return FukaShokaiKiwarigaku;
    }

    @JsonProperty("FukaShokaiKiwarigaku")
    public void setFukaShokaiKiwarigaku(KiwarigakuDiv FukaShokaiKiwarigaku) {
        this.FukaShokaiKiwarigaku=FukaShokaiKiwarigaku;
    }

}
/**
 * cellFukaShokai8 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokai8AttblFukaKonkyo extends TableCell {
    @JsonProperty("txtChoteiJiyu")
    private txtChoteiJiyuDiv txtChoteiJiyu;

    @JsonProperty("txtChoteiJiyu")
    public txtChoteiJiyuDiv getTxtChoteiJiyu() {
        return txtChoteiJiyu;
    }

    @JsonProperty("txtChoteiJiyu")
    public void setTxtChoteiJiyu(txtChoteiJiyuDiv txtChoteiJiyu) {
        this.txtChoteiJiyu=txtChoteiJiyu;
    }

}
