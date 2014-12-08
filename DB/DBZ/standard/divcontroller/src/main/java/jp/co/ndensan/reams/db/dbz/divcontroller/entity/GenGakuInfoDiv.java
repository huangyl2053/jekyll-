package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IGenGakuInfoDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ChoshuKenKeimetsuKikan1Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ChoshuKenKeimetsuKikan2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ChoshuKenKeimetsuKikan3Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ChoshuKenKeimetsuKikan4Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.GenGakuKeisanDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.GenGakuKikan2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.GnegakuKikanDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KakesanDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KasanDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ModoruDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NofuZumiKikanDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainoGengakuShosaiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainoNendoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorKannoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorKanoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorMitoraiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorTaishoGaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainocolorToraiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgGenGaku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgTainoShosaiInfo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblCommentDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GenGakuInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class GenGakuInfoDiv extends Panel implements IGenGakuInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TainoNendo")
    private TainoNendoDiv TainoNendo;
    @JsonProperty("TainoGengakuShosaiInfo")
    private TainoGengakuShosaiInfoDiv TainoGengakuShosaiInfo;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TainoNendo")
    public TainoNendoDiv getTainoNendo() {
        return TainoNendo;
    }

    @JsonProperty("TainoNendo")
    public void setTainoNendo(TainoNendoDiv TainoNendo) {
        this.TainoNendo=TainoNendo;
    }

    @JsonProperty("TainoGengakuShosaiInfo")
    public TainoGengakuShosaiInfoDiv getTainoGengakuShosaiInfo() {
        return TainoGengakuShosaiInfo;
    }

    @JsonProperty("TainoGengakuShosaiInfo")
    public void setTainoGengakuShosaiInfo(TainoGengakuShosaiInfoDiv TainoGengakuShosaiInfo) {
        this.TainoGengakuShosaiInfo=TainoGengakuShosaiInfo;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn=btnReturn;
    }

    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei=btnKakutei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtHanteiKijunYMD() {
        return this.getTainoNendo().getTxtHanteiKijunYMD();
    }

    @JsonIgnore
    public void  setTxtHanteiKijunYMD(TextBoxDate txtHanteiKijunYMD) {
        this.getTainoNendo().setTxtHanteiKijunYMD(txtHanteiKijunYMD);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getTainoNendo().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getTainoNendo().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public DataGrid<dgGenGaku_Row> getDgGenGaku() {
        return this.getTainoNendo().getDgGenGaku();
    }

    @JsonIgnore
    public void  setDgGenGaku(DataGrid<dgGenGaku_Row> dgGenGaku) {
        this.getTainoNendo().setDgGenGaku(dgGenGaku);
    }

    @JsonIgnore
    public GenGakuKeisanDiv getGenGakuKeisan() {
        return this.getTainoNendo().getGenGakuKeisan();
    }

    @JsonIgnore
    public void  setGenGakuKeisan(GenGakuKeisanDiv GenGakuKeisan) {
        this.getTainoNendo().setGenGakuKeisan(GenGakuKeisan);
    }

    @JsonIgnore
    public ChoshuKenKeimetsuKikan1Div getChoshuKenKeimetsuKikan1() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan1();
    }

    @JsonIgnore
    public void  setChoshuKenKeimetsuKikan1(ChoshuKenKeimetsuKikan1Div ChoshuKenKeimetsuKikan1) {
        this.getTainoNendo().getGenGakuKeisan().setChoshuKenKeimetsuKikan1(ChoshuKenKeimetsuKikan1);
    }

    @JsonIgnore
    public Label getLblChoShushometsu1() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getLblChoShushometsu1();
    }

    @JsonIgnore
    public void  setLblChoShushometsu1(Label lblChoShushometsu1) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan1().setLblChoShushometsu1(lblChoShushometsu1);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoShushometsu1() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getTxtChoShushometsu1();
    }

    @JsonIgnore
    public void  setTxtChoShushometsu1(TextBoxNum txtChoShushometsu1) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan1().setTxtChoShushometsu1(txtChoShushometsu1);
    }

    @JsonIgnore
    public KakesanDiv getKakesan() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getKakesan();
    }

    @JsonIgnore
    public void  setKakesan(KakesanDiv Kakesan) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan1().setKakesan(Kakesan);
    }

    @JsonIgnore
    public Label getLblKakesan() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getKakesan().getLblKakesan();
    }

    @JsonIgnore
    public void  setLblKakesan(Label lblKakesan) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getKakesan().setLblKakesan(lblKakesan);
    }

    @JsonIgnore
    public ChoshuKenKeimetsuKikan2Div getChoshuKenKeimetsuKikan2() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2();
    }

    @JsonIgnore
    public void  setChoshuKenKeimetsuKikan2(ChoshuKenKeimetsuKikan2Div ChoshuKenKeimetsuKikan2) {
        this.getTainoNendo().getGenGakuKeisan().setChoshuKenKeimetsuKikan2(ChoshuKenKeimetsuKikan2);
    }

    @JsonIgnore
    public ChoshuKenKeimetsuKikan3Div getChoshuKenKeimetsuKikan3() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3();
    }

    @JsonIgnore
    public void  setChoshuKenKeimetsuKikan3(ChoshuKenKeimetsuKikan3Div ChoshuKenKeimetsuKikan3) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().setChoshuKenKeimetsuKikan3(ChoshuKenKeimetsuKikan3);
    }

    @JsonIgnore
    public Label getLblChoShushometsu2() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().getLblChoShushometsu2();
    }

    @JsonIgnore
    public void  setLblChoShushometsu2(Label lblChoShushometsu2) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().setLblChoShushometsu2(lblChoShushometsu2);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoShushometsu2() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().getTxtChoShushometsu2();
    }

    @JsonIgnore
    public void  setTxtChoShushometsu2(TextBoxNum txtChoShushometsu2) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().setTxtChoShushometsu2(txtChoShushometsu2);
    }

    @JsonIgnore
    public Label getLblLine() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().getLblLine();
    }

    @JsonIgnore
    public void  setLblLine(Label lblLine) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().setLblLine(lblLine);
    }

    @JsonIgnore
    public ChoshuKenKeimetsuKikan4Div getChoshuKenKeimetsuKikan4() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4();
    }

    @JsonIgnore
    public void  setChoshuKenKeimetsuKikan4(ChoshuKenKeimetsuKikan4Div ChoshuKenKeimetsuKikan4) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().setChoshuKenKeimetsuKikan4(ChoshuKenKeimetsuKikan4);
    }

    @JsonIgnore
    public Label getLblChoShushometsu3() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4().getLblChoShushometsu3();
    }

    @JsonIgnore
    public void  setLblChoShushometsu3(Label lblChoShushometsu3) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4().setLblChoShushometsu3(lblChoShushometsu3);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoShushometsu3() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4().getTxtChoShushometsu3();
    }

    @JsonIgnore
    public void  setTxtChoShushometsu3(TextBoxNum txtChoShushometsu3) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4().setTxtChoShushometsu3(txtChoShushometsu3);
    }

    @JsonIgnore
    public KasanDiv getKasan() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getKasan();
    }

    @JsonIgnore
    public void  setKasan(KasanDiv Kasan) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().setKasan(Kasan);
    }

    @JsonIgnore
    public Label getLblKasan() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getKasan().getLblKasan();
    }

    @JsonIgnore
    public void  setLblKasan(Label lblKasan) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getKasan().setLblKasan(lblKasan);
    }

    @JsonIgnore
    public NofuZumiKikanDiv getNofuZumiKikan() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan();
    }

    @JsonIgnore
    public void  setNofuZumiKikan(NofuZumiKikanDiv NofuZumiKikan) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().setNofuZumiKikan(NofuZumiKikan);
    }

    @JsonIgnore
    public Label getLblNofuZumiKikan() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan().getLblNofuZumiKikan();
    }

    @JsonIgnore
    public void  setLblNofuZumiKikan(Label lblNofuZumiKikan) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan().setLblNofuZumiKikan(lblNofuZumiKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtNofuZumiKikan() {
        return this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan().getTxtNofuZumiKikan();
    }

    @JsonIgnore
    public void  setTxtNofuZumiKikan(TextBoxNum txtNofuZumiKikan) {
        this.getTainoNendo().getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan().setTxtNofuZumiKikan(txtNofuZumiKikan);
    }

    @JsonIgnore
    public GnegakuKikanDiv getGnegakuKikan() {
        return this.getTainoNendo().getGenGakuKeisan().getGnegakuKikan();
    }

    @JsonIgnore
    public void  setGnegakuKikan(GnegakuKikanDiv GnegakuKikan) {
        this.getTainoNendo().getGenGakuKeisan().setGnegakuKikan(GnegakuKikan);
    }

    @JsonIgnore
    public Label getLblKeisanShiki() {
        return this.getTainoNendo().getGenGakuKeisan().getGnegakuKikan().getLblKeisanShiki();
    }

    @JsonIgnore
    public void  setLblKeisanShiki(Label lblKeisanShiki) {
        this.getTainoNendo().getGenGakuKeisan().getGnegakuKikan().setLblKeisanShiki(lblKeisanShiki);
    }

    @JsonIgnore
    public GenGakuKikan2Div getGenGakuKikan2() {
        return this.getTainoNendo().getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2();
    }

    @JsonIgnore
    public void  setGenGakuKikan2(GenGakuKikan2Div GenGakuKikan2) {
        this.getTainoNendo().getGenGakuKeisan().getGnegakuKikan().setGenGakuKikan2(GenGakuKikan2);
    }

    @JsonIgnore
    public Label getLblGenGakuKikan() {
        return this.getTainoNendo().getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2().getLblGenGakuKikan();
    }

    @JsonIgnore
    public void  setLblGenGakuKikan(Label lblGenGakuKikan) {
        this.getTainoNendo().getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2().setLblGenGakuKikan(lblGenGakuKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtGenGakuKikan() {
        return this.getTainoNendo().getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2().getTxtGenGakuKikan();
    }

    @JsonIgnore
    public void  setTxtGenGakuKikan(TextBoxNum txtGenGakuKikan) {
        this.getTainoNendo().getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2().setTxtGenGakuKikan(txtGenGakuKikan);
    }

    @JsonIgnore
    public CheckBoxList getChkHyojiKirikae() {
        return this.getTainoGengakuShosaiInfo().getChkHyojiKirikae();
    }

    @JsonIgnore
    public void  setChkHyojiKirikae(CheckBoxList chkHyojiKirikae) {
        this.getTainoGengakuShosaiInfo().setChkHyojiKirikae(chkHyojiKirikae);
    }

    @JsonIgnore
    public TextBoxDate getTxtNendo() {
        return this.getTainoGengakuShosaiInfo().getTxtNendo();
    }

    @JsonIgnore
    public void  setTxtNendo(TextBoxDate txtNendo) {
        this.getTainoGengakuShosaiInfo().setTxtNendo(txtNendo);
    }

    @JsonIgnore
    public DataGrid<dgTainoShosaiInfo_Row> getDgTainoShosaiInfo() {
        return this.getTainoGengakuShosaiInfo().getDgTainoShosaiInfo();
    }

    @JsonIgnore
    public void  setDgTainoShosaiInfo(DataGrid<dgTainoShosaiInfo_Row> dgTainoShosaiInfo) {
        this.getTainoGengakuShosaiInfo().setDgTainoShosaiInfo(dgTainoShosaiInfo);
    }

    @JsonIgnore
    public tblCommentDiv getTblComment() {
        return this.getTainoGengakuShosaiInfo().getTblComment();
    }

    @JsonIgnore
    public void  setTblComment(tblCommentDiv tblComment) {
        this.getTainoGengakuShosaiInfo().setTblComment(tblComment);
    }

    @JsonIgnore
    public TainocolorKannoDiv getTainocolorKanno() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorKanno();
    }

    @JsonIgnore
    public Label getLblColorWhite() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorKanno().getLblColorWhite();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiKanno() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getLblTainoSetsumeiKanno();
    }

    @JsonIgnore
    public TainocolorMitoraiDiv getTainocolorMitorai() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorMitorai();
    }

    @JsonIgnore
    public Label getLblDummyYellow() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorMitorai().getLblDummyYellow();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiMiTorai() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getLblTainoSetsumeiMiTorai();
    }

    @JsonIgnore
    public TainocolorToraiDiv getTainocolorTorai() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorTorai();
    }

    @JsonIgnore
    public Label getLblDummyRed() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorTorai().getLblDummyRed();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiTorai() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getLblTainoSetsumeiTorai();
    }

    @JsonIgnore
    public TainocolorTaishoGaiDiv getTainocolorTaishoGai() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorTaishoGai();
    }

    @JsonIgnore
    public Label getLblLightSalmon() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorTaishoGai().getLblLightSalmon();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiTaishoGai() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getLblTainoSetsumeiTaishoGai();
    }

    @JsonIgnore
    public TainocolorKanoDiv getTainocolorKano() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorKano();
    }

    @JsonIgnore
    public Label getLblDummyGreen() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getTainocolorKano().getLblDummyGreen();
    }

    @JsonIgnore
    public Label getLblTainoSetsumeiKano() {
        return this.getTainoGengakuShosaiInfo().getTblComment().getLblTainoSetsumeiKano();
    }

    @JsonIgnore
    public ModoruDiv getModoru() {
        return this.getTainoGengakuShosaiInfo().getModoru();
    }

    @JsonIgnore
    public void  setModoru(ModoruDiv Modoru) {
        this.getTainoGengakuShosaiInfo().setModoru(Modoru);
    }

    @JsonIgnore
    public Button getBtnModoru() {
        return this.getTainoGengakuShosaiInfo().getModoru().getBtnModoru();
    }

    @JsonIgnore
    public void  setBtnModoru(Button btnModoru) {
        this.getTainoGengakuShosaiInfo().getModoru().setBtnModoru(btnModoru);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
