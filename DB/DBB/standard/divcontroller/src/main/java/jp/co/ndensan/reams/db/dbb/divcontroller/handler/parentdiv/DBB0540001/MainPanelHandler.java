/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0540001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.choshuhoho.ChoshuHohoResult;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.MainPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.choshuHouhou_Row;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.ChosyuHohoHenko;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.CodeShubetsus;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;

/**
 * 徴収方法変更_のハンドラクラスです。
 *
 * @reamsid_L DBB-1760-010 sunhui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class MainPanelHandler {

    private final MainPanelDiv div;
    private static final RString 再検索する = new RString("btnResearch");
    private static final RString 検索結果一覧へ = new RString("btnSearchResult");
    private static final RString 保存する = new RString("btnUpdate");
    private static final int 現在の月_1 = 1;
    private static final int 現在の月_2 = 2;
    private static final int 現在の月_3 = 3;
    private static final int 現在の月_4 = 4;
    private static final int 現在の月_5 = 5;
    private static final int 現在の月_6 = 6;
    private static final int 現在の月_7 = 7;
    private static final int 現在の月_8 = 8;
    private static final int 現在の月_9 = 9;
    private static final int 現在の月_10 = 10;
    private static final int 現在の月_11 = 11;
    private static final int 現在の月_12 = 12;
    private static final RString 名_0 = new RString("txtHenkouMaeAto");
    private static final RString 名_1 = new RString("txt1Gatsu");
    private static final RString 名_2 = new RString("txt2Gatsu");
    private static final RString 名_3 = new RString("txt3Gatsu");
    private static final RString 名_4 = new RString("txt4Gatsu");
    private static final RString 名_5 = new RString("txt5Gatsu");
    private static final RString 名_6 = new RString("txt6Gatsu");
    private static final RString 名_7 = new RString("txt7Gatsu");
    private static final RString 名_8 = new RString("txt8Gatsu");
    private static final RString 名_9 = new RString("txt9Gatsu");
    private static final RString 名_10 = new RString("txt10Gatsu");
    private static final RString 名_11 = new RString("txt11Gatsu");
    private static final RString 名_12 = new RString("txt12Gatsu");
    private static final RString 月_1 = new RString("01月");
    private static final RString 月_2 = new RString("02月");
    private static final RString 月_3 = new RString("03月");
    private static final RString 月_4 = new RString("04月");
    private static final RString 月_5 = new RString("05月");
    private static final RString 月_6 = new RString("06月");
    private static final RString 月_7 = new RString("07月");
    private static final RString 月_8 = new RString("08月");
    private static final RString 月_9 = new RString("09月");
    private static final RString 月_10 = new RString("10月");
    private static final RString 月_11 = new RString("11月");
    private static final RString 月_12 = new RString("12月");
    private static final RString 前の名_3 = new RString("txtZen3Gatsu");
    private static final RString 翌の名_4 = new RString("txtYoku4Gatsu");
    private static final RString 選択 = new RString("kuhaku");
    private static final RString 現在の行 = new RString("現在");
    private static final RString 変更後の行 = new RString("変更後");
    private static final RString コード_0 = new RString("0");
    private static final RString コード_1 = new RString("1");
    private static final RString コード_2 = new RString("2");
    private static final RString コード_3 = new RString("3");
    private static final RString RSTR_0331 = new RString("0331");
    private static final RString 名称_0 = new RString("なし");
    private static final RString 名称_1 = new RString("特");
    private static final RString 名称_2 = new RString("特");
    private static final RString 名称_3 = new RString("普");

    /**
     * MainPanelHandler
     *
     * @param div MainPanelDiv
     */
    public MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     * 初期状態のヘッダエリア
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void setヘッダエリア(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        div.getAtenaInfo().getKiagoAtenaInfo().onLoad(識別コード);
        // TODO QA:470 (79877)
//        div.getAtenaInfo().getKaigoFukaKihon().load(被保険者番号);
        this.set共通エリア();

    }

    /**
     * 世帯所得情報一覧エリアの設定
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     */
    public void set世帯所得情報一覧エリア(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {

        ChoshuHohoResult serviceResult = ChosyuHohoHenko.createInstance()
                .getChosyuHoho(賦課年度, 被保険者番号);

        RDate fukaNendo = new RDate(賦課年度.wareki().firstYear(FirstYear.ICHI_NEN).toDateString().toString());
        div.getChoshuInfo().getTxtFukaNendo().setValue(fukaNendo);
        if (null != serviceResult.getHoho().get本徴収_年金コード()) {
            RString nenkinCode = createNenkinCode(serviceResult.getHoho().get本徴収_年金コード());
            RString nenkinCodeMeisho = CodeMasterNoOption.getCodeMeisho(CodeShubetsus.年金コード, new Code(nenkinCode));
            div.getChoshuInfo().getTxtHokensha().setValue(nenkinCodeMeisho);
        } else if (null != serviceResult.getHoho().get仮徴収_年金コード()) {
            RString nenkinCode = createNenkinCode(serviceResult.getHoho().get仮徴収_年金コード());
            RString nenkinCodeMeisho = CodeMasterNoOption.getCodeMeisho(CodeShubetsus.年金コード, new Code(nenkinCode));
            div.getChoshuInfo().getTxtHokensha().setValue(nenkinCodeMeisho);
        } else {
            div.getChoshuInfo().getTxtHokensha().setValue(null);
        }

        div.getChoshuInfo().getDdlFucho().setSelectedKey(選択);

        List<choshuHouhou_Row> rows = new ArrayList<>();
        choshuHouhou_Row row現在 = new choshuHouhou_Row();
        choshuHouhou_Row row変更後 = new choshuHouhou_Row();
        row現在.getTxtHenkouMaeAto().setValue(現在の行);
        row現在.getTxtZen3Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getChoshuHoho3gat()).get名称()));
        row現在.getTxt4Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法4月()).get名称()));
        row現在.getTxt5Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法5月()).get名称()));
        row現在.getTxt6Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法6月()).get名称()));
        row現在.getTxt7Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法7月()).get名称()));
        row現在.getTxt8Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法8月()).get名称()));
        row現在.getTxt9Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法9月()).get名称()));
        row現在.getTxt10Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法10月()).get名称()));
        row現在.getTxt11Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法11月()).get名称()));
        row現在.getTxt12Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法12月()).get名称()));
        row現在.getTxt1Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法1月()).get名称()));
        row現在.getTxt2Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法2月()).get名称()));
        row現在.getTxt3Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法3月()).get名称()));
        row現在.getTxtYoku4Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法翌4月()).get名称()));
        row現在.setCellBgColor(前の名_3.toString(), setBgColor(serviceResult.getChoshuHoho3gat()));
        row現在.setCellBgColor(名_4.toString(), setBgColor(serviceResult.getHoho().get徴収方法4月()));
        row現在.setCellBgColor(名_5.toString(), setBgColor(serviceResult.getHoho().get徴収方法5月()));
        row現在.setCellBgColor(名_6.toString(), setBgColor(serviceResult.getHoho().get徴収方法6月()));
        row現在.setCellBgColor(名_7.toString(), setBgColor(serviceResult.getHoho().get徴収方法7月()));
        row現在.setCellBgColor(名_8.toString(), setBgColor(serviceResult.getHoho().get徴収方法8月()));
        row現在.setCellBgColor(名_9.toString(), setBgColor(serviceResult.getHoho().get徴収方法9月()));
        row現在.setCellBgColor(名_10.toString(), setBgColor(serviceResult.getHoho().get徴収方法10月()));
        row現在.setCellBgColor(名_11.toString(), setBgColor(serviceResult.getHoho().get徴収方法11月()));
        row現在.setCellBgColor(名_12.toString(), setBgColor(serviceResult.getHoho().get徴収方法12月()));
        row現在.setCellBgColor(名_1.toString(), setBgColor(serviceResult.getHoho().get徴収方法1月()));
        row現在.setCellBgColor(名_2.toString(), setBgColor(serviceResult.getHoho().get徴収方法2月()));
        row現在.setCellBgColor(名_3.toString(), setBgColor(serviceResult.getHoho().get徴収方法3月()));
        row現在.setCellBgColor(翌の名_4.toString(), setBgColor(serviceResult.getHoho().get徴収方法翌4月()));
        rows.add(row現在);
        row変更後.getTxtHenkouMaeAto().setValue(変更後の行);
        row変更後.getTxtZen3Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getChoshuHoho3gat()).get名称()));
        row変更後.getTxt4Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法4月()).get名称()));
        row変更後.getTxt5Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法5月()).get名称()));
        row変更後.getTxt6Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法6月()).get名称()));
        row変更後.getTxt7Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法7月()).get名称()));
        row変更後.getTxt8Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法8月()).get名称()));
        row変更後.getTxt9Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法9月()).get名称()));
        row変更後.getTxt10Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法10月()).get名称()));
        row変更後.getTxt11Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法11月()).get名称()));
        row変更後.getTxt12Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法12月()).get名称()));
        row変更後.getTxt1Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法1月()).get名称()));
        row変更後.getTxt2Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法2月()).get名称()));
        row変更後.getTxt3Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法3月()).get名称()));
        row変更後.getTxtYoku4Gatsu().setValue(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法翌4月()).get名称()));
        row変更後.setCellBgColor(前の名_3.toString(), setBgColor(serviceResult.getChoshuHoho3gat()));
        row変更後.setCellBgColor(名_4.toString(), setBgColor(serviceResult.getHoho().get徴収方法4月()));
        row変更後.setCellBgColor(名_5.toString(), setBgColor(serviceResult.getHoho().get徴収方法5月()));
        row変更後.setCellBgColor(名_6.toString(), setBgColor(serviceResult.getHoho().get徴収方法6月()));
        row変更後.setCellBgColor(名_7.toString(), setBgColor(serviceResult.getHoho().get徴収方法7月()));
        row変更後.setCellBgColor(名_8.toString(), setBgColor(serviceResult.getHoho().get徴収方法8月()));
        row変更後.setCellBgColor(名_9.toString(), setBgColor(serviceResult.getHoho().get徴収方法9月()));
        row変更後.setCellBgColor(名_10.toString(), setBgColor(serviceResult.getHoho().get徴収方法10月()));
        row変更後.setCellBgColor(名_11.toString(), setBgColor(serviceResult.getHoho().get徴収方法11月()));
        row変更後.setCellBgColor(名_12.toString(), setBgColor(serviceResult.getHoho().get徴収方法12月()));
        row変更後.setCellBgColor(名_1.toString(), setBgColor(serviceResult.getHoho().get徴収方法1月()));
        row変更後.setCellBgColor(名_2.toString(), setBgColor(serviceResult.getHoho().get徴収方法2月()));
        row変更後.setCellBgColor(名_3.toString(), setBgColor(serviceResult.getHoho().get徴収方法3月()));
        row変更後.setCellBgColor(翌の名_4.toString(), setBgColor(serviceResult.getHoho().get徴収方法翌4月()));
        rows.add(row変更後);
        div.getChoshuInfo().getChoshuHouhou().setDataSource(rows);
    }

    /**
     * 普通徴収に切り替える月DDLの変更
     */
    public void change普通徴収に切り替える月DDL() {

        RString kuhaku = 選択;
        if (kuhaku.equals(div.getChoshuInfo().getDdlFucho().getSelectedKey())) {
            edit空白を選択した場合();
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
        } else {
            edit空白以外を選択した場合();
            edit現在の月の徴収方法はなしの場合();
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);
        }
    }

    /**
     * ＤＢ登録を行う
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     */
    public void saveボタンを押下(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {

        dataSaveEdit(賦課年度, 被保険者番号);
    }

    private DataGridCellBgColor setBgColor(RString コード) {

        DataGridCellBgColor bgColor = DataGridCellBgColor.bgColorLightGreen;
        if (コード.equals(コード_0)) {
            bgColor = DataGridCellBgColor.bgColorLightYellow;
        } else if (コード.equals(コード_3)) {
            bgColor = DataGridCellBgColor.bgColorLightRed;
        } else if (コード.equals(コード_2)) {
            bgColor = DataGridCellBgColor.bgColorLightGreen;
        } else if (コード.equals(コード_1)) {
            bgColor = DataGridCellBgColor.bgColorLightGreen;
        }
        return bgColor;
    }

    private RString createNenkinCode(RString 年金コード) {
        final int numberOfDigit = 3;
        RString 年金コード上3桁 = (年金コード != null && 年金コード.length() >= numberOfDigit)
                ? 年金コード.substring(0, numberOfDigit) : RString.EMPTY;
        return 年金コード上3桁;
    }

    private void set共通エリア() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(再検索する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧へ, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
    }

    private void edit空白を選択した場合() {

        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxtZen3Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxtZen3Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt4Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt4Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt5Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt5Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt6Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt6Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt7Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt8Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt9Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt10Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt10Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt11Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt11Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt12Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt12Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt1Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt2Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt3Gatsu().getValue());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxtYoku4Gatsu().setValue(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxtYoku4Gatsu().getValue());

        choshuHouhou_Row row現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0);
        choshuHouhou_Row row変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1);
        row変更後.setCellBgColor(名_0.toString(), row現在.getCellBgColor(名_0.toString()));
        row変更後.setCellBgColor(前の名_3.toString(), row現在.getCellBgColor(前の名_3.toString()));
        row変更後.setCellBgColor(名_4.toString(), row現在.getCellBgColor(名_4.toString()));
        row変更後.setCellBgColor(名_5.toString(), row現在.getCellBgColor(名_5.toString()));
        row変更後.setCellBgColor(名_6.toString(), row現在.getCellBgColor(名_6.toString()));
        row変更後.setCellBgColor(名_7.toString(), row現在.getCellBgColor(名_7.toString()));
        row変更後.setCellBgColor(名_8.toString(), row現在.getCellBgColor(名_8.toString()));
        row変更後.setCellBgColor(名_9.toString(), row現在.getCellBgColor(名_9.toString()));
        row変更後.setCellBgColor(名_10.toString(), row現在.getCellBgColor(名_10.toString()));
        row変更後.setCellBgColor(名_11.toString(), row現在.getCellBgColor(名_11.toString()));
        row変更後.setCellBgColor(名_12.toString(), row現在.getCellBgColor(名_12.toString()));
        row変更後.setCellBgColor(名_1.toString(), row現在.getCellBgColor(名_1.toString()));
        row変更後.setCellBgColor(名_2.toString(), row現在.getCellBgColor(名_2.toString()));
        row変更後.setCellBgColor(名_3.toString(), row現在.getCellBgColor(名_3.toString()));
        row変更後.setCellBgColor(翌の名_4.toString(), row現在.getCellBgColor(翌の名_4.toString()));

    }

    private void edit空白以外を選択した場合() {

        RString gatsu = div.getChoshuInfo().getDdlFucho().getSelectedValue();
        set背景色も普通徴収の色に変更04To09(gatsu);
    }

    private void set背景色も普通徴収の色に変更04To09(RString gatsu) {

        if (月_4.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt4Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt5Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt6Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_4.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_5.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_6.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_7.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_8.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_9.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_5.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt5Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt6Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_5.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_6.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_7.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_8.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_9.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_6.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt6Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_6.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_7.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_8.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_9.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_7.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_7.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_8.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_9.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_8.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_8.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_9.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_9.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_9.toString(), DataGridCellBgColor.bgColorLightRed);
        } else {
            set背景色も普通徴収の色に変更10To03(gatsu);
        }
    }

    private void set背景色も普通徴収の色に変更10To03(RString gatsu) {
        if (月_10.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt10Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt11Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt12Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_10.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_11.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_12.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_1.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_2.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_3.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_11.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt11Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt12Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_11.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_12.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_1.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_2.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_3.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_12.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt12Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_12.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_1.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_2.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_3.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_1.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_1.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_2.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_3.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_2.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_2.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_3.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_3.equals(gatsu)) {
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu().setValue(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_3.toString(), DataGridCellBgColor.bgColorLightRed);
        }
    }

    private void edit現在の月の徴収方法はなしの場合() {

        choshuHouhou_Row row現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0);
        choshuHouhou_Row row変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1);
        RString getなし名称 = get徴収方法の名称(ChoshuHoho.toValue(コード_0).get名称());
        if (getなし名称.equals(row現在.getTxtZen3Gatsu().getValue())) {
            row変更後.getTxtZen3Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(前の名_3.toString(), row現在.getCellBgColor(前の名_3.toString()));
        }
        if (getなし名称.equals(row現在.getTxt4Gatsu().getValue())) {
            row変更後.getTxt4Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_4.toString(), row現在.getCellBgColor(名_4.toString()));
        }
        if (getなし名称.equals(row現在.getTxt5Gatsu().getValue())) {
            row変更後.getTxt5Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_5.toString(), row現在.getCellBgColor(名_5.toString()));
        }
        if (getなし名称.equals(row現在.getTxt6Gatsu().getValue())) {
            row変更後.getTxt6Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_6.toString(), row現在.getCellBgColor(名_6.toString()));
        }
        if (getなし名称.equals(row現在.getTxt7Gatsu().getValue())) {
            row変更後.getTxt7Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_7.toString(), row現在.getCellBgColor(名_7.toString()));
        }
        if (getなし名称.equals(row現在.getTxt8Gatsu().getValue())) {
            row変更後.getTxt8Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_8.toString(), row現在.getCellBgColor(名_8.toString()));
        }
        if (getなし名称.equals(row現在.getTxt9Gatsu().getValue())) {
            row変更後.getTxt9Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_9.toString(), row現在.getCellBgColor(名_9.toString()));
        }
        if (getなし名称.equals(row現在.getTxt10Gatsu().getValue())) {
            row変更後.getTxt10Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_10.toString(), row現在.getCellBgColor(名_10.toString()));
        }
        continueEdit(getなし名称, row現在, row変更後);
    }

    private void continueEdit(RString getなし名称, choshuHouhou_Row row現在, choshuHouhou_Row row変更後) {

        if (getなし名称.equals(row現在.getTxt11Gatsu().getValue())) {
            row変更後.getTxt11Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_11.toString(), row現在.getCellBgColor(名_11.toString()));
        }
        if (getなし名称.equals(row現在.getTxt12Gatsu().getValue())) {
            row変更後.getTxt12Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_12.toString(), row現在.getCellBgColor(名_12.toString()));
        }
        if (getなし名称.equals(row現在.getTxt1Gatsu().getValue())) {
            row変更後.getTxt1Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_1.toString(), row現在.getCellBgColor(名_1.toString()));
        }
        if (getなし名称.equals(row現在.getTxt2Gatsu().getValue())) {
            row変更後.getTxt2Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_2.toString(), row現在.getCellBgColor(名_2.toString()));
        }
        if (getなし名称.equals(row現在.getTxt3Gatsu().getValue())) {
            row変更後.getTxt3Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(名_3.toString(), row現在.getCellBgColor(名_3.toString()));
        }
        if (getなし名称.equals(row現在.getTxtYoku4Gatsu().getValue())) {
            row変更後.getTxtYoku4Gatsu().setValue(getなし名称);
            row変更後.setCellBgColor(翌の名_4.toString(), row現在.getCellBgColor(翌の名_4.toString()));
        }
    }

    private void dataSaveEdit(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {

        int 現在の月;
        final int three = 3;
        YMDHMS 特別徴収停止日時 = null;
        RString 特別徴収停止事由コード = null;
        RDate システム日付 = RDate.getNowDate();
        ChoshuHohoManager manager = new ChoshuHohoManager();
        jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho choshuHoho
                = manager.get介護徴収方法(賦課年度, 被保険者番号);

        RString 賦課年度日付 = new RString(賦課年度.plusYear(1).toString() + RSTR_0331.toString());
        RDate 賦課日付 = new RDate(賦課年度日付.toString());
        if (賦課日付.isBefore(システム日付)) {
            現在の月 = three;
        } else {
            現在の月 = システム日付.getMonthValue();
        }

        boolean flag = is四月To八月の徴収方法を比較(現在の月);
        boolean flg = is四月To八月の徴収方法は変更無しの場合(現在の月, choshuHoho);
        if (!flag) {
            特別徴収停止日時 = YMDHMS.now();
            特別徴収停止事由コード = ChoteiJiyuCode.徴収方法修正.getコード();
        }
        if (!flg) {
            特別徴収停止日時 = choshuHoho.get特別徴収停止日時();
            特別徴収停止事由コード = choshuHoho.get特別徴収停止事由コード();
        }

        jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho 介護徴収方法 = choshuHoho.createBuilderForEdit()
                .set賦課年度(賦課年度).set被保険者番号(被保険者番号).set履歴番号(choshuHoho.get履歴番号() + 1)
                .set徴収方法4月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt4Gatsu().getValue()))
                .set徴収方法5月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt5Gatsu().getValue()))
                .set徴収方法6月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt6Gatsu().getValue()))
                .set徴収方法7月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt7Gatsu().getValue()))
                .set徴収方法8月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt8Gatsu().getValue()))
                .set徴収方法9月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt9Gatsu().getValue()))
                .set徴収方法10月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt10Gatsu().getValue()))
                .set徴収方法11月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt11Gatsu().getValue()))
                .set徴収方法12月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt12Gatsu().getValue()))
                .set徴収方法1月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt1Gatsu().getValue()))
                .set徴収方法2月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt2Gatsu().getValue()))
                .set徴収方法3月(get徴収方法のコード(div.getChoshuInfo().getChoshuHouhou()
                                .getDataSource().get(1).getTxt3Gatsu().getValue()))
                .set特別徴収停止日時(特別徴収停止日時)
                .set特別徴収停止事由コード(特別徴収停止事由コード).build();

        manager.save介護徴収方法(介護徴収方法);
    }

    private RString get徴収方法のコード(RString 徴収方法の名称) {

        RString 徴収方法のコード = null;
        if (ChoshuHoho.資格なし.get名称().equals(徴収方法の名称)) {
            徴収方法のコード = コード_0;
        } else if (ChoshuHoho.特別徴収_厚生労働省.get名称().equals(徴収方法の名称)) {
            徴収方法のコード = コード_1;
        } else if (ChoshuHoho.特別徴収_地共済.get名称().equals(徴収方法の名称)) {
            徴収方法のコード = コード_2;
        } else if (ChoshuHoho.普通徴収.get名称().equals(徴収方法の名称)) {
            徴収方法のコード = コード_3;
        }
        return 徴収方法のコード;
    }

    private RString get徴収方法の名称(RString 徴収方法の名称) {

        RString 名称 = null;
        if (ChoshuHoho.資格なし.get名称().equals(徴収方法の名称)) {
            名称 = 名称_0;
        } else if (ChoshuHoho.特別徴収_厚生労働省.get名称().equals(徴収方法の名称)) {
            名称 = 名称_1;
        } else if (ChoshuHoho.特別徴収_地共済.get名称().equals(徴収方法の名称)) {
            名称 = 名称_2;
        } else if (ChoshuHoho.普通徴収.get名称().equals(徴収方法の名称)) {
            名称 = 名称_3;
        }
        return 名称;
    }

    private boolean is四月To八月の徴収方法を比較(int 現在の月) {

        RString 現在;
        RString 変更後;
        boolean flg = false;
        if (現在の月 == 現在の月_4) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt4Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt4Gatsu().getValue();
            flg = judge(現在, 変更後);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt5Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt5Gatsu().getValue();
            flg = judge(現在, 変更後);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt6Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt6Gatsu().getValue();
            flg = judge(現在, 変更後);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt7Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu().getValue();
            flg = judge(現在, 変更後);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6
                || 現在の月 == 現在の月_7 || 現在の月 == 現在の月_8) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt8Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu().getValue();
            flg = judge(現在, 変更後);
        }

        flg = is九月To十月の徴収方法を比較(現在の月, flg);
        return flg;
    }

    private boolean is九月To十月の徴収方法を比較(int 現在の月, boolean flg) {

        RString 現在;
        RString 変更後;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt9Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu().getValue();
            flg = judge(現在, 変更後);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt10Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt10Gatsu().getValue();
            flg = judge(現在, 変更後);
        }

        flg = is十一月To十二月の徴収方法を比較(現在の月, flg);
        return flg;
    }

    private boolean is十一月To十二月の徴収方法を比較(int 現在の月, boolean flg) {

        RString 現在;
        RString 変更後;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt11Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt11Gatsu().getValue();
            flg = judge(現在, 変更後);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11
                || 現在の月 == 現在の月_12) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt12Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt12Gatsu().getValue();
            flg = judge(現在, 変更後);
        }

        flg = is一月の徴収方法を比較(現在の月, flg);
        return flg;
    }

    private boolean is一月の徴収方法を比較(int 現在の月, boolean flg) {

        RString 現在;
        RString 変更後;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11
                || 現在の月 == 現在の月_12 || 現在の月 == 現在の月_1) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt1Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu().getValue();
            flg = judge(現在, 変更後);
        }

        flg = is二月の徴収方法を比較(現在の月, flg);
        return flg;
    }

    private boolean is二月の徴収方法を比較(int 現在の月, boolean flg) {

        RString 現在;
        RString 変更後;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11
                || 現在の月 == 現在の月_12 || 現在の月 == 現在の月_1 || 現在の月 == 現在の月_2) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt2Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu().getValue();
            flg = judge(現在, 変更後);
        }

        flg = is三月の徴収方法を比較(現在の月, flg);
        return flg;
    }

    private boolean is三月の徴収方法を比較(int 現在の月, boolean flg) {

        RString 現在;
        RString 変更後;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11
                || 現在の月 == 現在の月_12 || 現在の月 == 現在の月_1 || 現在の月 == 現在の月_2 || 現在の月 == 現在の月_3) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt3Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu().getValue();
            flg = judge(現在, 変更後);
        }

        return flg;
    }

    private boolean judge(RString 現在, RString 変更後) {

        boolean flag = false;
        if (!((ChoshuHoho.toValue(コード_1).get名称().equals(現在)
                || ChoshuHoho.toValue(コード_2).get名称().equals(現在))
                && (ChoshuHoho.toValue(コード_0).get名称().equals(変更後)
                || ChoshuHoho.toValue(コード_3).get名称().equals(変更後)))) {
            return true;
        }
        return flag;
    }

    private boolean is四月To八月の徴収方法は変更無しの場合(int 現在の月,
            jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho choshuHoho) {

        RString 現在;
        RString 変更後;
        RString 基本;
        boolean flg = false;
        if (現在の月 == 現在の月_4) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt4Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt4Gatsu().getValue();
            基本 = choshuHoho.get徴収方法4月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt5Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt5Gatsu().getValue();
            基本 = choshuHoho.get徴収方法5月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt6Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt6Gatsu().getValue();
            基本 = choshuHoho.get徴収方法6月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt7Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu().getValue();
            基本 = choshuHoho.get徴収方法7月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt8Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu().getValue();
            基本 = choshuHoho.get徴収方法8月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }

        flg = is九月To十月の徴収方法は変更無しの場合(現在の月, choshuHoho, flg);
        return flg;
    }

    private boolean is九月To十月の徴収方法は変更無しの場合(int 現在の月,
            jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho choshuHoho, boolean flg) {

        RString 現在;
        RString 変更後;
        RString 基本;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt9Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu().getValue();
            基本 = choshuHoho.get徴収方法9月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt10Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt10Gatsu().getValue();
            基本 = choshuHoho.get徴収方法10月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }

        flg = is十一月To十二月の徴収方法は変更無しの場合(現在の月, choshuHoho, flg);
        return flg;
    }

    private boolean is十一月To十二月の徴収方法は変更無しの場合(int 現在の月,
            jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho choshuHoho, boolean flg) {

        RString 現在;
        RString 変更後;
        RString 基本;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt11Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt11Gatsu().getValue();
            基本 = choshuHoho.get徴収方法11月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11
                || 現在の月 == 現在の月_12) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt12Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt12Gatsu().getValue();
            基本 = choshuHoho.get徴収方法12月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }

        flg = is一月の徴収方法は変更無しの場合(現在の月, choshuHoho, flg);
        return flg;
    }

    private boolean is一月の徴収方法は変更無しの場合(int 現在の月,
            jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho choshuHoho, boolean flg) {

        RString 現在;
        RString 変更後;
        RString 基本;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11
                || 現在の月 == 現在の月_12 || 現在の月 == 現在の月_1) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt1Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu().getValue();
            基本 = choshuHoho.get徴収方法1月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }

        flg = is二月の徴収方法は変更無しの場合(現在の月, choshuHoho, flg);
        return flg;
    }

    private boolean is二月の徴収方法は変更無しの場合(int 現在の月,
            jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho choshuHoho, boolean flg) {

        RString 現在;
        RString 変更後;
        RString 基本;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11
                || 現在の月 == 現在の月_12 || 現在の月 == 現在の月_1 || 現在の月 == 現在の月_2) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt2Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu().getValue();
            基本 = choshuHoho.get徴収方法2月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }

        flg = is三月の徴収方法は変更無しの場合(現在の月, choshuHoho, flg);
        return flg;
    }

    private boolean is三月の徴収方法は変更無しの場合(int 現在の月,
            jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho choshuHoho, boolean flg) {

        RString 現在;
        RString 変更後;
        RString 基本;
        if (現在の月 == 現在の月_4 || 現在の月 == 現在の月_5 || 現在の月 == 現在の月_6 || 現在の月 == 現在の月_7
                || 現在の月 == 現在の月_8 || 現在の月 == 現在の月_9 || 現在の月 == 現在の月_10 || 現在の月 == 現在の月_11
                || 現在の月 == 現在の月_12 || 現在の月 == 現在の月_1 || 現在の月 == 現在の月_2 || 現在の月 == 現在の月_3) {
            現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt3Gatsu().getValue();
            変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu().getValue();
            基本 = choshuHoho.get徴収方法3月();
            flg = is変更無しの場合(現在, 変更後, 基本);
        }

        return flg;
    }

    private boolean is変更無しの場合(RString 現在, RString 変更後, RString 基本) {

        boolean flag = false;
        if (!現在.equals(ChoshuHoho.toValue(基本).get名称()) || !変更後.equals(ChoshuHoho.toValue(基本).get名称())) {
            flag = true;
        }
        return flag;
    }
}
