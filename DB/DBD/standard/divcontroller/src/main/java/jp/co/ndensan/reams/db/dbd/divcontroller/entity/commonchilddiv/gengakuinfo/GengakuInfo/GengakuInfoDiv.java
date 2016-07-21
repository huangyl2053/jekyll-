package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.taino.KyufugakuGengakuInfo;
import jp.co.ndensan.reams.db.dbd.business.core.taino.KyufugakuGengakuMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResult;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResultKohen;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TaishoHanteiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * GengakuInfo のクラスファイル
 *
 * @author 自動生成
 */
public class GengakuInfoDiv extends Panel implements IGengakuInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("kanriKuben")
    private RString kanriKuben;
    @JsonProperty("rirekiNo")
    private RString rirekiNo;
    @JsonProperty("tainohanteiKuben")
    private RString tainohanteiKuben;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTainoNendo
     * @return TainoNendo
     */
    @JsonProperty("TainoNendo")
    public TainoNendoDiv getTainoNendo() {
        return TainoNendo;
    }

    /*
     * setTainoNendo
     * @param TainoNendo TainoNendo
     */
    @JsonProperty("TainoNendo")
    public void setTainoNendo(TainoNendoDiv TainoNendo) {
        this.TainoNendo = TainoNendo;
    }

    /*
     * getTainoGengakuShosaiInfo
     * @return TainoGengakuShosaiInfo
     */
    @JsonProperty("TainoGengakuShosaiInfo")
    public TainoGengakuShosaiInfoDiv getTainoGengakuShosaiInfo() {
        return TainoGengakuShosaiInfo;
    }

    /*
     * setTainoGengakuShosaiInfo
     * @param TainoGengakuShosaiInfo TainoGengakuShosaiInfo
     */
    @JsonProperty("TainoGengakuShosaiInfo")
    public void setTainoGengakuShosaiInfo(TainoGengakuShosaiInfoDiv TainoGengakuShosaiInfo) {
        this.TainoGengakuShosaiInfo = TainoGengakuShosaiInfo;
    }

    /*
     * getbtnReturn
     * @return btnReturn
     */
    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    /*
     * setbtnReturn
     * @param btnReturn btnReturn
     */
    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getkanriKuben
     * @return kanriKuben
     */
    @JsonProperty("kanriKuben")
    public RString getKanriKuben() {
        return kanriKuben;
    }

    /*
     * setkanriKuben
     * @param kanriKuben kanriKuben
     */
    @JsonProperty("kanriKuben")
    public void setKanriKuben(RString kanriKuben) {
        this.kanriKuben = kanriKuben;
    }

    /*
     * getrirekiNo
     * @return rirekiNo
     */
    @JsonProperty("rirekiNo")
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /*
     * setrirekiNo
     * @param rirekiNo rirekiNo
     */
    @JsonProperty("rirekiNo")
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /*
     * gettainohanteiKuben
     * @return tainohanteiKuben
     */
    @JsonProperty("tainohanteiKuben")
    public RString getTainohanteiKuben() {
        return tainohanteiKuben;
    }

    /*
     * settainohanteiKuben
     * @param tainohanteiKuben tainohanteiKuben
     */
    @JsonProperty("tainohanteiKuben")
    public void setTainohanteiKuben(RString tainohanteiKuben) {
        this.tainohanteiKuben = tainohanteiKuben;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private static final int 十年 = 10;
    private static final RString 賦課年度ColumnName = new RString("txtFukaNendo");
    private static final RString 普特ColumnName = new RString("txtChoshuHoHo");
    private static final RString 通知書番号ColumnName = new RString("txttsuchishoNo");

    public void init状態２(TainoHanteiResult 滞納判定結果) {
        init状態２収納情報ヘッダエリア();
        init状態２収納情報エリア(滞納判定結果.get給付額減額());
        init状態２フッターエリア();
        getTainoGengakuShosaiInfo().setIsOpen(false);
    }

    public void init状態３(TainoHanteiResultKohen 滞納判定結果) {
        getTainoNendo().setIsOpen(false);
        getTainoGengakuShosaiInfo().setIsOpen(true);
        init状態３滞納状態詳細ヘッダエリア(getDgGenGaku().getActiveRow());
        init状態３滞納状態詳細エリア(滞納判定結果.get滞納情報(), 滞納判定結果.get滞納判定基準日());

    }

    public void init照会モード(TainoHanteiResult 滞納判定結果) {
        if (滞納判定結果.get滞納判定基準日() != null && !滞納判定結果.get滞納判定基準日().isEmpty()) {
            getTxtHanteiKijunYMD().setValue(new RDate(滞納判定結果.get滞納判定基準日().toString()));
        }
        getBtnKensaku().setDisabled(true);
        init状態２収納情報エリア(滞納判定結果.get給付額減額());
        init状態２フッターエリア();
        getTainoGengakuShosaiInfo().setIsOpen(false);
    }

    public void init状態１() {
        getTainoGengakuShosaiInfo().setIsOpen(false);
    }

    public boolean is管理区分と滞納判定区分と履歴番号ある() {
        return (kanriKuben != null && !kanriKuben.isEmpty())
                && (tainohanteiKuben != null && !tainohanteiKuben.isEmpty())
                && (rirekiNo != null && !rirekiNo.isEmpty());
    }

    public void setIs賦課年度_普特_通知書番号Visible(boolean isVisible) {
        getDgTainoShosaiInfo().getGridSetting().getColumn(賦課年度ColumnName).setVisible(isVisible);
        getDgTainoShosaiInfo().getGridSetting().getColumn(普特ColumnName).setVisible(isVisible);
        getDgTainoShosaiInfo().getGridSetting().getColumn(通知書番号ColumnName).setVisible(isVisible);
    }

    private void init状態２収納情報ヘッダエリア() {
        getBtnKensaku().setDisabled(false);
    }

    private void init状態２収納情報エリア(KyufugakuGengakuInfo 給付額減額) {
        List<dgGenGaku_Row> dataSource = new ArrayList<>();
        for (Map.Entry<FlexibleYear, KyufugakuGengakuMeisai> entry : 給付額減額.get給付額減額明細マップ().entrySet()) {
            dgGenGaku_Row row = new dgGenGaku_Row();
            FlexibleYear 調定年度 = entry.getKey();
            KyufugakuGengakuMeisai 給付額減額明細 = entry.getValue();
            if (調定年度 != null && !調定年度.isEmpty()) {
                row.getTxtChoteiNendo().setValue(new RDate(調定年度.toString()));
            }
            row.getTxtChoteiGaku().setValue(給付額減額明細.get調定額());
            row.getTxtShunyuGaku().setValue(給付額減額明細.get収入額());
            row.getTxtJikoMinoGaku().setValue(給付額減額明細.get時効到来未納額());
            dataSource.add(row);
        }
        getDgGenGaku().setDataSource(dataSource);
        getTxtChoShushometsu1().setValue(給付額減額.get徴収権消滅期間());
        getTxtChoShushometsu2().setValue(給付額減額.get徴収権消滅期間());
        getTxtChoShushometsu3().setValue(給付額減額.get徴収権消滅期間());
        getTxtNofuZumiKikan().setValue(給付額減額.get納付済期間());
        getTxtGenGakuKikan().setValue(new Decimal(給付額減額.get給付額減額期間()));
    }

    private void init状態２フッターエリア() {
        getBtnReturn().setDisplayNone(false);
        getBtnReturn().setDisabled(false);
    }

    private void init状態３滞納状態詳細ヘッダエリア(dgGenGaku_Row row) {
        getTxtNendo().setValue(row.getTxtChoteiNendo().getValue());
        getChkHyojiKirikae().setSelectedItems(Collections.EMPTY_LIST);
        setIs賦課年度_普特_通知書番号Visible(false);
    }

    private void init状態３滞納状態詳細エリア(List<TainoKiSummary> 滞納情報, FlexibleDate 滞納判定基準日) {
        List<dgTainoShosaiInfo_Row> dataSource = new ArrayList<>();
        FlexibleYear 調定年度 = new FlexibleYear(String.valueOf(getDgGenGaku().getActiveRow().getTxtChoteiNendo().getValue().getYearValue()));
        List<TainoKiSummary> 滞納情報Array = new ArrayList<>();
        滞納情報Array.addAll(滞納情報);
        Collections.sort(滞納情報Array, new Comparator<TainoKiSummary>() {
            @Override
            public int compare(TainoKiSummary o1, TainoKiSummary o2) {
                return o2.get賦課年度().compareTo(o1.get賦課年度());
            }
        });
        for (TainoKiSummary summary : 滞納情報Array) {
            if (調定年度.equals(summary.get調定年度())) {
                dgTainoShosaiInfo_Row row = new dgTainoShosaiInfo_Row();
                if (summary.get賦課年度() != null && summary.get賦課年度().isValid()) {
                    row.getTxtFukaNendo().setValue(new RDate(summary.get賦課年度().toString()));
                }
                if (summary.get徴収方法() != null) {
                    row.getTxtChoshuHoHo().setValue(summary.get徴収方法().get略称());
                }
                if (summary.get通知書番号() != null) {
                    row.getTxttsuchishoNo().setValue(summary.get通知書番号().value());
                }
                row.getTxtKi().setValue(summary.get期());
                row.getTxtChoteiGaku().setValue(summary.get調定額());
                row.getTxtNokiGen().setValue(summary.get納期限());
                row.getTxtShunyuGaku().setValue(summary.get収入額());
                row.getTxtMinoGaku().setValue(summary.get滞納額());
                row.getTxtKokai().setValue(TaishoHanteiKubun.今回対象.equals(summary.get対象管理区分()) ? new RString("○") : RString.EMPTY);
                if (summary.get時効起算日() != null) {
                    row.getTxtJikoKisanYMD().setValue(new RDate(summary.get時効起算日().toString()));
                }
                row.getTxtJikoKisanKbn().setValue(summary.get時効起算日区分().get名称());
                row.setCellBgColor(getBgColor(summary, 滞納判定基準日));
                dataSource.add(row);
            }
        }
        getDgTainoShosaiInfo().setDataSource(dataSource);
    }

    private Map<String, DataGridCellBgColor> getBgColor(TainoKiSummary summary, FlexibleDate 滞納判定基準日) {
        DataGridCellBgColor bgColor = DataGridCellBgColor.bgColorNormal;
        if (滞納判定基準日 != null && summary.get納期限() != null && summary.get納期限().isBefore(new RDate(滞納判定基準日.toString()).minusYear(十年))) {
            bgColor = DataGridCellBgColor.bgColorLightRed;
        } else {
            bgColor = getcolor(summary);
        }
        Map<String, DataGridCellBgColor> colorMap = new HashMap<>();
        Class clazz = dgTainoShosaiInfo_Row.class;
        for (Field field : clazz.getDeclaredFields()) {
            colorMap.put(field.getName(), bgColor);
        }
        return colorMap;
    }

    private DataGridCellBgColor getcolor(TainoKiSummary summary) {
        if (MinoKannoKubun.未納あり.equals(summary.get未納完納区分())) {
            if (JikoKubun.時効未到来.equals(summary.get時効区分())) {
                return DataGridCellBgColor.bgColorYellow;
            } else if (JikoKubun.時効到来.equals(summary.get時効区分())) {
                return DataGridCellBgColor.bgColorRed;
            }
        } else if (MinoKannoKubun.過納.equals(summary.get未納完納区分())) {
            return DataGridCellBgColor.bgColorGreen;
        }
        return DataGridCellBgColor.bgColorNormal;
    }
}
