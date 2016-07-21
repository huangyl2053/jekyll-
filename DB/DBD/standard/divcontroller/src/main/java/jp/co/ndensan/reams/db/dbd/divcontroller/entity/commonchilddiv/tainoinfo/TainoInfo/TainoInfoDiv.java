package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.tainoinfo.TainoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResult;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TokuchoFuchoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TainoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.service.core.taino.TainoJokyoFinder;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYear;

/**
 * TainoInfo のクラスファイル
 *
 * @author 自動生成
 */
public class TainoInfoDiv extends Panel implements ITainoInfoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHanteiKijunYMD")
    private TextBoxDate txtHanteiKijunYMD;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("btnDispGengakuJoho")
    private ButtonDialog btnDispGengakuJoho;
    @JsonProperty("txtSaikoNokigen")
    private TextBoxDate txtSaikoNokigen;
    @JsonProperty("txtKeikaNen")
    private TextBox txtKeikaNen;
    @JsonProperty("txtKeikaTsuki")
    private TextBox txtKeikaTsuki;
    @JsonProperty("linTaino1")
    private HorizontalLine linTaino1;
    @JsonProperty("txtFukaNendo")
    private TextBoxFlexibleYear txtFukaNendo;
    @JsonProperty("txtFukaNendo2")
    private TextBoxFlexibleYear txtFukaNendo2;
    @JsonProperty("txtFukaNendo1")
    private TextBoxFlexibleYear txtFukaNendo1;
    @JsonProperty("dgTainoJokyo3")
    private DataGrid<dgTainoJokyo3_Row> dgTainoJokyo3;
    @JsonProperty("dgTainoJokyo2")
    private DataGrid<dgTainoJokyo2_Row> dgTainoJokyo2;
    @JsonProperty("dgTainoJokyo1")
    private DataGrid<dgTainoJokyo1_Row> dgTainoJokyo1;
    @JsonProperty("txtSonotaHokenryo")
    private TextBoxNum txtSonotaHokenryo;
    @JsonProperty("txtSonotatainoGaku")
    private TextBoxNum txtSonotatainoGaku;
    @JsonProperty("TainoSetsumei")
    private TainoSetsumeiDiv TainoSetsumei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("kanriKubun")
    private RString kanriKubun;
    @JsonProperty("tainoHanteiKubun")
    private RString tainoHanteiKubun;
    @JsonProperty("rirekiNo")
    private RString rirekiNo;
    @JsonProperty("tainoHanteiKekka")
    private RString tainoHanteiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHanteiKijunYMD
     * @return txtHanteiKijunYMD
     */
    @JsonProperty("txtHanteiKijunYMD")
    public TextBoxDate getTxtHanteiKijunYMD() {
        return txtHanteiKijunYMD;
    }

    /*
     * settxtHanteiKijunYMD
     * @param txtHanteiKijunYMD txtHanteiKijunYMD
     */
    @JsonProperty("txtHanteiKijunYMD")
    public void setTxtHanteiKijunYMD(TextBoxDate txtHanteiKijunYMD) {
        this.txtHanteiKijunYMD = txtHanteiKijunYMD;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * getbtnDispGengakuJoho
     * @return btnDispGengakuJoho
     */
    @JsonProperty("btnDispGengakuJoho")
    public ButtonDialog getBtnDispGengakuJoho() {
        return btnDispGengakuJoho;
    }

    /*
     * setbtnDispGengakuJoho
     * @param btnDispGengakuJoho btnDispGengakuJoho
     */
    @JsonProperty("btnDispGengakuJoho")
    public void setBtnDispGengakuJoho(ButtonDialog btnDispGengakuJoho) {
        this.btnDispGengakuJoho = btnDispGengakuJoho;
    }

    /*
     * gettxtSaikoNokigen
     * @return txtSaikoNokigen
     */
    @JsonProperty("txtSaikoNokigen")
    public TextBoxDate getTxtSaikoNokigen() {
        return txtSaikoNokigen;
    }

    /*
     * settxtSaikoNokigen
     * @param txtSaikoNokigen txtSaikoNokigen
     */
    @JsonProperty("txtSaikoNokigen")
    public void setTxtSaikoNokigen(TextBoxDate txtSaikoNokigen) {
        this.txtSaikoNokigen = txtSaikoNokigen;
    }

    /*
     * gettxtKeikaNen
     * @return txtKeikaNen
     */
    @JsonProperty("txtKeikaNen")
    public TextBox getTxtKeikaNen() {
        return txtKeikaNen;
    }

    /*
     * settxtKeikaNen
     * @param txtKeikaNen txtKeikaNen
     */
    @JsonProperty("txtKeikaNen")
    public void setTxtKeikaNen(TextBox txtKeikaNen) {
        this.txtKeikaNen = txtKeikaNen;
    }

    /*
     * gettxtKeikaTsuki
     * @return txtKeikaTsuki
     */
    @JsonProperty("txtKeikaTsuki")
    public TextBox getTxtKeikaTsuki() {
        return txtKeikaTsuki;
    }

    /*
     * settxtKeikaTsuki
     * @param txtKeikaTsuki txtKeikaTsuki
     */
    @JsonProperty("txtKeikaTsuki")
    public void setTxtKeikaTsuki(TextBox txtKeikaTsuki) {
        this.txtKeikaTsuki = txtKeikaTsuki;
    }

    /*
     * getlinTaino1
     * @return linTaino1
     */
    @JsonProperty("linTaino1")
    public HorizontalLine getLinTaino1() {
        return linTaino1;
    }

    /*
     * setlinTaino1
     * @param linTaino1 linTaino1
     */
    @JsonProperty("linTaino1")
    public void setLinTaino1(HorizontalLine linTaino1) {
        this.linTaino1 = linTaino1;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBoxFlexibleYear getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBoxFlexibleYear txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * gettxtFukaNendo2
     * @return txtFukaNendo2
     */
    @JsonProperty("txtFukaNendo2")
    public TextBoxFlexibleYear getTxtFukaNendo2() {
        return txtFukaNendo2;
    }

    /*
     * settxtFukaNendo2
     * @param txtFukaNendo2 txtFukaNendo2
     */
    @JsonProperty("txtFukaNendo2")
    public void setTxtFukaNendo2(TextBoxFlexibleYear txtFukaNendo2) {
        this.txtFukaNendo2 = txtFukaNendo2;
    }

    /*
     * gettxtFukaNendo1
     * @return txtFukaNendo1
     */
    @JsonProperty("txtFukaNendo1")
    public TextBoxFlexibleYear getTxtFukaNendo1() {
        return txtFukaNendo1;
    }

    /*
     * settxtFukaNendo1
     * @param txtFukaNendo1 txtFukaNendo1
     */
    @JsonProperty("txtFukaNendo1")
    public void setTxtFukaNendo1(TextBoxFlexibleYear txtFukaNendo1) {
        this.txtFukaNendo1 = txtFukaNendo1;
    }

    /*
     * getdgTainoJokyo3
     * @return dgTainoJokyo3
     */
    @JsonProperty("dgTainoJokyo3")
    public DataGrid<dgTainoJokyo3_Row> getDgTainoJokyo3() {
        return dgTainoJokyo3;
    }

    /*
     * setdgTainoJokyo3
     * @param dgTainoJokyo3 dgTainoJokyo3
     */
    @JsonProperty("dgTainoJokyo3")
    public void setDgTainoJokyo3(DataGrid<dgTainoJokyo3_Row> dgTainoJokyo3) {
        this.dgTainoJokyo3 = dgTainoJokyo3;
    }

    /*
     * getdgTainoJokyo2
     * @return dgTainoJokyo2
     */
    @JsonProperty("dgTainoJokyo2")
    public DataGrid<dgTainoJokyo2_Row> getDgTainoJokyo2() {
        return dgTainoJokyo2;
    }

    /*
     * setdgTainoJokyo2
     * @param dgTainoJokyo2 dgTainoJokyo2
     */
    @JsonProperty("dgTainoJokyo2")
    public void setDgTainoJokyo2(DataGrid<dgTainoJokyo2_Row> dgTainoJokyo2) {
        this.dgTainoJokyo2 = dgTainoJokyo2;
    }

    /*
     * getdgTainoJokyo1
     * @return dgTainoJokyo1
     */
    @JsonProperty("dgTainoJokyo1")
    public DataGrid<dgTainoJokyo1_Row> getDgTainoJokyo1() {
        return dgTainoJokyo1;
    }

    /*
     * setdgTainoJokyo1
     * @param dgTainoJokyo1 dgTainoJokyo1
     */
    @JsonProperty("dgTainoJokyo1")
    public void setDgTainoJokyo1(DataGrid<dgTainoJokyo1_Row> dgTainoJokyo1) {
        this.dgTainoJokyo1 = dgTainoJokyo1;
    }

    /*
     * gettxtSonotaHokenryo
     * @return txtSonotaHokenryo
     */
    @JsonProperty("txtSonotaHokenryo")
    public TextBoxNum getTxtSonotaHokenryo() {
        return txtSonotaHokenryo;
    }

    /*
     * settxtSonotaHokenryo
     * @param txtSonotaHokenryo txtSonotaHokenryo
     */
    @JsonProperty("txtSonotaHokenryo")
    public void setTxtSonotaHokenryo(TextBoxNum txtSonotaHokenryo) {
        this.txtSonotaHokenryo = txtSonotaHokenryo;
    }

    /*
     * gettxtSonotatainoGaku
     * @return txtSonotatainoGaku
     */
    @JsonProperty("txtSonotatainoGaku")
    public TextBoxNum getTxtSonotatainoGaku() {
        return txtSonotatainoGaku;
    }

    /*
     * settxtSonotatainoGaku
     * @param txtSonotatainoGaku txtSonotatainoGaku
     */
    @JsonProperty("txtSonotatainoGaku")
    public void setTxtSonotatainoGaku(TextBoxNum txtSonotatainoGaku) {
        this.txtSonotatainoGaku = txtSonotatainoGaku;
    }

    /*
     * getTainoSetsumei
     * @return TainoSetsumei
     */
    @JsonProperty("TainoSetsumei")
    public TainoSetsumeiDiv getTainoSetsumei() {
        return TainoSetsumei;
    }

    /*
     * setTainoSetsumei
     * @param TainoSetsumei TainoSetsumei
     */
    @JsonProperty("TainoSetsumei")
    public void setTainoSetsumei(TainoSetsumeiDiv TainoSetsumei) {
        this.TainoSetsumei = TainoSetsumei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
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
     * getkanriKubun
     * @return kanriKubun
     */
    @JsonProperty("kanriKubun")
    public RString getKanriKubun() {
        return kanriKubun;
    }

    /*
     * setkanriKubun
     * @param kanriKubun kanriKubun
     */
    @JsonProperty("kanriKubun")
    public void setKanriKubun(RString kanriKubun) {
        this.kanriKubun = kanriKubun;
    }

    /*
     * gettainoHanteiKubun
     * @return tainoHanteiKubun
     */
    @JsonProperty("tainoHanteiKubun")
    public RString getTainoHanteiKubun() {
        return tainoHanteiKubun;
    }

    /*
     * settainoHanteiKubun
     * @param tainoHanteiKubun tainoHanteiKubun
     */
    @JsonProperty("tainoHanteiKubun")
    public void setTainoHanteiKubun(RString tainoHanteiKubun) {
        this.tainoHanteiKubun = tainoHanteiKubun;
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
     * gettainoHanteiKekka
     * @return tainoHanteiKekka
     */
    @JsonProperty("tainoHanteiKekka")
    public RString getTainoHanteiKekka() {
        return tainoHanteiKekka;
    }

    /*
     * settainoHanteiKekka
     * @param tainoHanteiKekka tainoHanteiKekka
     */
    @JsonProperty("tainoHanteiKekka")
    public void setTainoHanteiKekka(RString tainoHanteiKekka) {
        this.tainoHanteiKekka = tainoHanteiKekka;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TainocolorKannoDiv getTainocolorKanno() {
        return this.getTainoSetsumei().getTainocolorKanno();
    }

    @JsonIgnore
    public Label getLblDummyWhite() {
        return this.getTainoSetsumei().getTainocolorKanno().getLblDummyWhite();
    }

    @JsonIgnore
    public TainocolorMinoDiv getTainocolorMino() {
        return this.getTainoSetsumei().getTainocolorMino();
    }

    @JsonIgnore
    public Label getLblDummyRed() {
        return this.getTainoSetsumei().getTainocolorMino().getLblDummyRed();
    }

    @JsonIgnore
    public Label getLblMassage1() {
        return this.getTainoSetsumei().getLblMassage1();
    }

    @JsonIgnore
    public Label getLblMassage2() {
        return this.getTainoSetsumei().getLblMassage2();
    }

    @JsonIgnore
    public TainocolorMitoraiDiv getTainocolorMitorai() {
        return this.getTainoSetsumei().getTainocolorMitorai();
    }

    @JsonIgnore
    public Label getLblDummyYellow() {
        return this.getTainoSetsumei().getTainocolorMitorai().getLblDummyYellow();
    }

    @JsonIgnore
    public TainocolorKanoDiv getTainocolorKano() {
        return this.getTainoSetsumei().getTainocolorKano();
    }

    @JsonIgnore
    public Label getLblDummyGreen() {
        return this.getTainoSetsumei().getTainocolorKano().getLblDummyGreen();
    }

    @JsonIgnore
    public Label getLblMassage3() {
        return this.getTainoSetsumei().getLblMassage3();
    }

    @JsonIgnore
    public Label getLblMassage4() {
        return this.getTainoSetsumei().getLblMassage4();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private static final RString 過年度分 = new RString("過年度分");

    @Override
    public TainoHanteiResult initialize() {
        if (is管理区分と滞納判定区分と履歴番号ある()) {
            TainoHanteiResult 滞納判定結果 = TainoJokyoFinder.createInstance().find支払方法変更滞納(
                    new HihokenshaNo(hihokenshaNo), ShiharaiHenkoKanriKubun.toValue(kanriKubun), Integer.parseInt(rirekiNo.toString()),
                    TainoHanteiKubun.toValue(tainoHanteiKubun));
            FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
            if (!滞納判定結果.get滞納情報().isEmpty()) {
                賦課年度 = 滞納判定結果.get滞納情報().get(0).get賦課年度();
            }
            FlexibleYear 三年前の賦課年度 = FlexibleYear.EMPTY;
            if (!賦課年度.isEmpty()) {
                三年前の賦課年度 = 賦課年度.minusYear(3);
            }
            KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト();
            Decimal 保険料額 = Decimal.ZERO;
            Decimal 滞納額 = Decimal.ZERO;
            for (TainoKiSummary summary : 滞納判定結果.get滞納情報()) {
                if (summary.get賦課年度() != null
                        && summary.get賦課年度().isBeforeOrEquals(三年前の賦課年度)
                        && summary.get滞納額().compareTo(Decimal.ZERO) > 0) {
                    保険料額 = 保険料額.add(summary.get調定額());
                    滞納額 = 滞納額.add(summary.get滞納額());
                }
            }
            init照会モード(滞納判定結果, 賦課年度, 期月リスト, 保険料額, 滞納額);
            return 滞納判定結果;
        } else {
            init滞納判定モードの状態1();
            return new TainoHanteiResult();
        }

    }

    public TainoHanteiResult kensaku() {
        FlexibleYear 賦課年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        FlexibleYear 三年前の賦課年度 = 賦課年度.minusYear(3);
        TainoHanteiResult 滞納判定結果 = TainoJokyoFinder.createInstance().research滞納情報(
                new HihokenshaNo(hihokenshaNo), new FlexibleDate(txtHanteiKijunYMD.getValue().toString()));
        if (滞納判定結果.get滞納情報().isEmpty()) {
            return 滞納判定結果;
        }
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト();
        Decimal 保険料額 = Decimal.ZERO;
        Decimal 滞納額 = Decimal.ZERO;
        for (TainoKiSummary summary : 滞納判定結果.get滞納情報()) {
            if (summary.get賦課年度() != null
                    && summary.get賦課年度().isBeforeOrEquals(三年前の賦課年度)
                    && summary.get滞納額().compareTo(Decimal.ZERO) > 0) {
                保険料額 = 保険料額.add(summary.get調定額());
                滞納額 = 滞納額.add(summary.get滞納額());
            }
        }
        init滞納判定モードの状態2(滞納判定結果, 賦課年度, 期月リスト, 保険料額, 滞納額);
        return 滞納判定結果;
    }

    private void init照会モード(TainoHanteiResult 滞納判定結果, FlexibleYear 賦課年度, KitsukiList 期月リスト, Decimal 保険料額, Decimal 滞納額) {
        txtHanteiKijunYMD.setDisabled(true);
        btnKensaku.setDisabled(true);
        btnKakutei.setDisplayNone(true);
        if (滞納判定結果.get滞納判定基準日() != null) {
            txtHanteiKijunYMD.setValue(new RDate(滞納判定結果.get滞納判定基準日().toString()));
        }
        init滞納情報エリア(滞納判定結果, 賦課年度, 期月リスト, 保険料額, 滞納額);
    }

    private void init滞納判定モードの状態1() {
        btnKakutei.setDisplayNone(false);
        txtHanteiKijunYMD.setValue(RDate.getNowDate());
    }

    private void init滞納判定モードの状態2(TainoHanteiResult 滞納判定結果, FlexibleYear 賦課年度, KitsukiList 期月リスト, Decimal 保険料額,
            Decimal 滞納額) {
        txtHanteiKijunYMD.setDisabled(false);
        btnKensaku.setDisabled(false);
        btnKakutei.setDisplayNone(false);
        init滞納情報エリア(滞納判定結果, 賦課年度, 期月リスト, 保険料額, 滞納額);
    }

    private void init滞納情報エリア(TainoHanteiResult 滞納判定結果, FlexibleYear 賦課年度, KitsukiList 期月リスト, Decimal 保険料額, Decimal 滞納額) {
        if (滞納判定結果.get最古滞納納期限() != null && !滞納判定結果.get最古滞納納期限().isEmpty()) {
            txtSaikoNokigen.setValue(new RDate(滞納判定結果.get最古滞納納期限().toString()));
        }
        if (滞納判定結果.get滞納期間() != null) {
            txtKeikaNen.setValue(new RString(滞納判定結果.get滞納期間().getYear()));
            txtKeikaTsuki.setValue(new RString(滞納判定結果.get滞納期間().getMonth()));
        }
        txtFukaNendo.setDomain(賦課年度);
        txtFukaNendo2.setDomain(賦課年度.minusYear(1));
        txtFukaNendo1.setDomain(賦課年度.minusYear(2));
        List<TainoKiSummary> 本年度滞納情報List = new ArrayList<>();
        List<TainoKiSummary> 一年度前滞納情報List = new ArrayList<>();
        List<TainoKiSummary> 二年度前滞納情報List = new ArrayList<>();
        create滞納情報List(本年度滞納情報List, 一年度前滞納情報List, 二年度前滞納情報List, 滞納判定結果.get滞納情報(), 賦課年度);
        init本年度滞納情報エリア(本年度滞納情報List, 期月リスト);
        init一年度前滞納情報エリア(一年度前滞納情報List, 期月リスト);
        init二年度前滞納情報エリア(二年度前滞納情報List, 期月リスト);
        if (!Decimal.ZERO.equals(保険料額)) {
            txtSonotaHokenryo.setValue(保険料額);
        }
        if (!Decimal.ZERO.equals(滞納額)) {
            txtSonotatainoGaku.setValue(滞納額);
        }
    }

    private void create滞納情報List(List<TainoKiSummary> 本年度滞納情報List, List<TainoKiSummary> 一年度前滞納情報List,
            List<TainoKiSummary> 二年度前滞納情報List, List<TainoKiSummary> 滞納情報List, FlexibleYear 賦課年度) {
        for (TainoKiSummary tainoKiSummary : 滞納情報List) {
            if (TokuchoFuchoKubun.普通徴収.equals(tainoKiSummary.get徴収方法())) {
                if (tainoKiSummary.get賦課年度().equals(賦課年度)) {
                    本年度滞納情報List.add(tainoKiSummary);
                } else if (tainoKiSummary.get賦課年度().equals(賦課年度.minusYear(1))) {
                    一年度前滞納情報List.add(tainoKiSummary);
                } else if (tainoKiSummary.get賦課年度().equals(賦課年度.minusYear(2))) {
                    二年度前滞納情報List.add(tainoKiSummary);
                }
            }
        }
    }

    private void init本年度滞納情報エリア(List<TainoKiSummary> 本年度滞納情報List, KitsukiList 期月リスト) {
        List<dgTainoJokyo3_Row> dataSource = new ArrayList<>();
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            dataSource.add(create本年度滞納情報List(kitsuki, 本年度滞納情報List));
        }
        if (is過年度のレコードがある(本年度滞納情報List)) {
            dataSource.add(create本年度過年度分の行(本年度滞納情報List));
        }
        dgTainoJokyo3.setDataSource(dataSource);
    }

    private void init一年度前滞納情報エリア(List<TainoKiSummary> 一年度前滞納情報List, KitsukiList 期月リスト) {
        List<dgTainoJokyo2_Row> dataSource = new ArrayList<>();
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            dataSource.add(create一年度前滞納情報List(kitsuki, 一年度前滞納情報List));
        }
        if (is過年度のレコードがある(一年度前滞納情報List)) {
            dataSource.add(create一年度前過年度分の行(一年度前滞納情報List));
        }
        dgTainoJokyo2.setDataSource(dataSource);
    }

    private void init二年度前滞納情報エリア(List<TainoKiSummary> 二年度前滞納情報List, KitsukiList 期月リスト) {
        List<dgTainoJokyo1_Row> dataSource = new ArrayList<>();
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            dataSource.add(create二年度前滞納情報List(kitsuki, 二年度前滞納情報List));
        }
        if (is過年度のレコードがある(二年度前滞納情報List)) {
            dataSource.add(create二年度前過年度分の行(二年度前滞納情報List));
        }
        dgTainoJokyo1.setDataSource(dataSource);
    }

    private dgTainoJokyo3_Row create本年度滞納情報List(Kitsuki 期月, List<TainoKiSummary> 滞納情報List) {
        dgTainoJokyo3_Row row = new dgTainoJokyo3_Row();
        TextBoxNum 保険料 = new TextBoxNum();
        TextBoxDate 納期限 = new TextBoxDate();
        TextBoxNum 滞納 = new TextBoxNum();
        TextBoxFlexibleDate 時効起算日 = new TextBoxFlexibleDate();
        row.setKi(期月.get期().concat("期"));
        row.setTsuki(期月.get月().get名称());
        for (TainoKiSummary summary : 滞納情報List) {
            if (期月.get期().equals(summary.get期()) && !summary.is過年度()) {
                保険料.setValue(summary.get調定額());
                納期限.setValue(summary.get納期限());
                滞納.setValue(summary.get滞納額());
                時効起算日.setValue(summary.get時効起算日());
                row.setTxtHokenryo(保険料);
                row.setTxtNokigen(納期限);
                row.setTxtTaino(滞納);
                row.setTxtJikoKisanYMD(時効起算日);
                row.setJikoKisanbiKubun(summary.get時効起算日区分().get名称());
                row.setCellBgColor(getBgColor(summary));
                break;
            }
        }
        return row;
    }

    private dgTainoJokyo3_Row create本年度過年度分の行(List<TainoKiSummary> 滞納情報List) {
        dgTainoJokyo3_Row row = new dgTainoJokyo3_Row();
        TextBoxNum 保険料 = new TextBoxNum();
        TextBoxDate 納期限 = new TextBoxDate();
        TextBoxNum 滞納 = new TextBoxNum();
        TextBoxFlexibleDate 時効起算日 = new TextBoxFlexibleDate();
        Decimal 保険料合計 = Decimal.ZERO;
        Decimal 滞納合計 = Decimal.ZERO;
        FlexibleYear 調定年度 = FlexibleYear.MAX;
        for (TainoKiSummary summary : 滞納情報List) {
            boolean isFirst = true;
            if (summary.is過年度()) {
                if (isFirst) {
                    row.setCellBgColor(getBgColor(summary));
                    isFirst = false;
                }
                保険料合計 = 保険料合計.add(summary.get調定額());
                滞納合計 = 滞納合計.add(summary.get滞納額());
                if (summary.get調定年度().isBefore(調定年度)) {
                    調定年度 = summary.get調定年度();
                    納期限.setValue(summary.get納期限());
                    時効起算日.setValue(summary.get時効起算日());
                    row.setJikoKisanbiKubun(summary.get時効起算日区分().get名称());
                }
            }
        }
        保険料.setValue(保険料合計);
        滞納.setValue(滞納合計);
        row.setKi(過年度分);
        row.setTsuki(RString.EMPTY);
        row.setTxtHokenryo(保険料);
        row.setTxtNokigen(納期限);
        row.setTxtTaino(滞納);
        row.setTxtJikoKisanYMD(時効起算日);
        return row;
    }

    private dgTainoJokyo2_Row create一年度前滞納情報List(Kitsuki 期月, List<TainoKiSummary> 滞納情報List) {
        dgTainoJokyo2_Row row = new dgTainoJokyo2_Row();
        TextBoxNum 保険料 = new TextBoxNum();
        TextBoxDate 納期限 = new TextBoxDate();
        TextBoxNum 滞納 = new TextBoxNum();
        TextBoxFlexibleDate 時効起算日 = new TextBoxFlexibleDate();
        row.setKi(期月.get期().concat("期"));
        row.setTsuki(期月.get月().get名称());
        for (TainoKiSummary summary : 滞納情報List) {
            if (期月.get期().equals(summary.get期()) && !summary.is過年度()) {
                保険料.setValue(summary.get調定額());
                納期限.setValue(summary.get納期限());
                滞納.setValue(summary.get滞納額());
                時効起算日.setValue(summary.get時効起算日());
                row.setTxtHokenryo(保険料);
                row.setTxtNokigen(納期限);
                row.setTxtTaino(滞納);
                row.setTxtJikoKisanYMD(時効起算日);
                row.setJikoKisanbiKubun(summary.get時効起算日区分().get名称());
                row.setCellBgColor(getBgColor(summary));
                break;
            }
        }

        return row;
    }

    private dgTainoJokyo2_Row create一年度前過年度分の行(List<TainoKiSummary> 滞納情報List) {
        dgTainoJokyo2_Row row = new dgTainoJokyo2_Row();
        TextBoxNum 保険料 = new TextBoxNum();
        TextBoxDate 納期限 = new TextBoxDate();
        TextBoxNum 滞納 = new TextBoxNum();
        TextBoxFlexibleDate 時効起算日 = new TextBoxFlexibleDate();
        Decimal 保険料合計 = Decimal.ZERO;
        Decimal 滞納合計 = Decimal.ZERO;
        FlexibleYear 調定年度 = FlexibleYear.MAX;
        for (TainoKiSummary summary : 滞納情報List) {
            boolean isFirst = true;
            if (summary.is過年度()) {
                if (isFirst) {
                    row.setCellBgColor(getBgColor(summary));
                    isFirst = false;
                }
                保険料合計 = 保険料合計.add(summary.get調定額());
                滞納合計 = 滞納合計.add(summary.get滞納額());
                if (summary.get調定年度().isBefore(調定年度)) {
                    調定年度 = summary.get調定年度();
                    納期限.setValue(summary.get納期限());
                    時効起算日.setValue(summary.get時効起算日());
                    row.setJikoKisanbiKubun(summary.get時効起算日区分().get名称());
                }
            }
        }
        保険料.setValue(保険料合計);
        滞納.setValue(滞納合計);
        row.setKi(過年度分);
        row.setTsuki(RString.EMPTY);
        row.setTxtHokenryo(保険料);
        row.setTxtNokigen(納期限);
        row.setTxtTaino(滞納);
        row.setTxtJikoKisanYMD(時効起算日);
        return row;
    }

    private dgTainoJokyo1_Row create二年度前滞納情報List(Kitsuki 期月, List<TainoKiSummary> 滞納情報List) {
        dgTainoJokyo1_Row row = new dgTainoJokyo1_Row();
        TextBoxNum 保険料 = new TextBoxNum();
        TextBoxDate 納期限 = new TextBoxDate();
        TextBoxNum 滞納 = new TextBoxNum();
        TextBoxFlexibleDate 時効起算日 = new TextBoxFlexibleDate();
        row.setKi(期月.get期().concat("期"));
        row.setTsuki(期月.get月().get名称());
        for (TainoKiSummary summary : 滞納情報List) {
            if (期月.get期().equals(summary.get期()) && !summary.is過年度()) {
                保険料.setValue(summary.get調定額());
                納期限.setValue(summary.get納期限());
                滞納.setValue(summary.get滞納額());
                時効起算日.setValue(summary.get時効起算日());
                row.setTxtHokenryo(保険料);
                row.setTxtNokigen(納期限);
                row.setTxtTaino(滞納);
                row.setTxtJikoKisanYMD(時効起算日);
                row.setJikoKisanbiKubun(summary.get時効起算日区分().get名称());
                row.setCellBgColor(getBgColor(summary));
                break;
            }
        }
        return row;
    }

    private dgTainoJokyo1_Row create二年度前過年度分の行(List<TainoKiSummary> 滞納情報List) {
        dgTainoJokyo1_Row row = new dgTainoJokyo1_Row();
        TextBoxNum 保険料 = new TextBoxNum();
        TextBoxDate 納期限 = new TextBoxDate();
        TextBoxNum 滞納 = new TextBoxNum();
        TextBoxFlexibleDate 時効起算日 = new TextBoxFlexibleDate();
        Decimal 保険料合計 = Decimal.ZERO;
        Decimal 滞納合計 = Decimal.ZERO;
        FlexibleYear 調定年度 = FlexibleYear.MAX;
        for (TainoKiSummary summary : 滞納情報List) {
            boolean isFirst = true;
            if (summary.is過年度()) {
                if (isFirst) {
                    row.setCellBgColor(getBgColor(summary));
                    isFirst = false;
                }
                保険料合計 = 保険料合計.add(summary.get調定額());
                滞納合計 = 滞納合計.add(summary.get滞納額());
                if (summary.get調定年度().isBefore(調定年度)) {
                    調定年度 = summary.get調定年度();
                    納期限.setValue(summary.get納期限());
                    時効起算日.setValue(summary.get時効起算日());
                    row.setJikoKisanbiKubun(summary.get時効起算日区分().get名称());
                }
            }
        }
        保険料.setValue(保険料合計);
        滞納.setValue(滞納合計);
        row.setKi(過年度分);
        row.setTsuki(RString.EMPTY);
        row.setTxtHokenryo(保険料);
        row.setTxtNokigen(納期限);
        row.setTxtTaino(滞納);
        row.setTxtJikoKisanYMD(時効起算日);
        return row;
    }

    private Map<String, DataGridCellBgColor> getBgColor(TainoKiSummary summary) {
        DataGridCellBgColor bgColor = DataGridCellBgColor.bgColorNormal;
        if (MinoKannoKubun.未納あり.equals(summary.get未納完納区分())) {
            if (JikoKubun.時効未到来.equals(summary.get時効区分())) {
                bgColor = DataGridCellBgColor.bgColorYellow;
            } else if (JikoKubun.時効到来.equals(summary.get時効区分())) {
                bgColor = DataGridCellBgColor.bgColorRed;
            }
        } else if (MinoKannoKubun.過納.equals(summary.get未納完納区分())) {
            bgColor = DataGridCellBgColor.bgColorGreen;
        }
        Map<String, DataGridCellBgColor> colorMap = new HashMap<>();
        Class clazz = dgTainoJokyo3_Row.class;
        for (Field field : clazz.getDeclaredFields()) {
            colorMap.put(field.getName(), bgColor);
        }
        return colorMap;
    }

    private boolean is過年度のレコードがある(List<TainoKiSummary> 滞納情報) {
        for (TainoKiSummary tainoKiSummary : 滞納情報) {
            if (tainoKiSummary.is過年度()) {
                return true;
            }
        }
        return false;
    }

    private boolean is管理区分と滞納判定区分と履歴番号ある() {
        return (kanriKubun != null && !kanriKubun.isEmpty())
                && (tainoHanteiKubun != null && !tainoHanteiKubun.isEmpty())
                && (rirekiNo != null && !rirekiNo.isEmpty());
    }
}
