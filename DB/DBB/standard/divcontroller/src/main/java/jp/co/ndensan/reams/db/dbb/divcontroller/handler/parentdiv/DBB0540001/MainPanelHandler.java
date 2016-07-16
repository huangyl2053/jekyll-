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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

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
    private static final int 整数_1 = 1;
    private static final int 整数_2 = 2;
    private static final int 整数_3 = 3;
    private static final int 整数_4 = 4;
    private static final int 整数_5 = 5;
    private static final int 整数_6 = 6;
    private static final int 整数_7 = 7;
    private static final int 整数_8 = 8;
    private static final int 整数_9 = 9;
    private static final int 整数_10 = 10;
    private static final int 整数_11 = 11;
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
    private static final RString コード種別 = new RString("0046");
    private static final RString 特 = new RString("特");
    private static final RString 普 = new RString("普");

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
     * @param key KaigoFukaKihonSearchKey
     */
    public void setヘッダエリア(ShikibetsuCode 識別コード, KaigoFukaKihonSearchKey key) {
        div.getAtenaInfo().getKiagoAtenaInfo().initialize(識別コード);
        div.getAtenaInfo().getKaigoFukaKihon().load(key);
        this.set共通エリア();

    }

    /**
     * 世帯所得情報一覧エリアの設定
     *
     * @param 賦課年度 FlexibleYear
     * @param 被保険者番号 HihokenshaNo
     * @param serviceResult ChoshuHohoResult
     */
    public void set世帯所得情報一覧エリア(FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号, ChoshuHohoResult serviceResult) {
        RDate fukaNendo = new RDate(賦課年度.wareki().firstYear(FirstYear.ICHI_NEN).toDateString().toString());
        div.getChoshuInfo().getTxtFukaNendo().setValue(fukaNendo);
        if (null != serviceResult.getHoho().get本徴収_年金コード()) {
            RString nenkinCode = createNenkinCode(serviceResult.getHoho().get本徴収_年金コード());
            RString nenkinCodeMeisho = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    new CodeShubetsu(コード種別),
                    new Code(nenkinCode), FlexibleDate.getNowDate());
            div.getChoshuInfo().getTxtHokensha().setValue(nenkinCodeMeisho);
        } else if (null != serviceResult.getHoho().get仮徴収_年金コード()) {
            RString nenkinCode = createNenkinCode(serviceResult.getHoho().get仮徴収_年金コード());
            RString nenkinCodeMeisho = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    new CodeShubetsu(コード種別),
                    new Code(nenkinCode), FlexibleDate.getNowDate());
            div.getChoshuInfo().getTxtHokensha().setValue(nenkinCodeMeisho);
        } else {
            div.getChoshuInfo().getTxtHokensha().setValue(null);
        }

        div.getChoshuInfo().getDdlFucho().setSelectedKey(選択);

        List<choshuHouhou_Row> rows = new ArrayList<>();
        choshuHouhou_Row row現在 = new choshuHouhou_Row();
        choshuHouhou_Row row変更後 = new choshuHouhou_Row();
        row現在.getTxtHenkouMaeAto().setValue(現在の行);
        if (serviceResult.getChoshuHoho3gat() != null && !serviceResult.getChoshuHoho3gat().isEmpty()) {
            row現在.setTxtZen3Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getChoshuHoho3gat()).get名称()));
        } else {
            row現在.setTxtZen3Gatsu(get徴収方法の名称(ChoshuHoho.toValue(コード_0).get名称()));
        }
        row現在.setTxt4Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法4月()).get名称()));
        row現在.setTxt5Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法5月()).get名称()));
        row現在.setTxt6Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法6月()).get名称()));
        row現在.setTxt7Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法7月()).get名称()));
        row現在.setTxt8Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法8月()).get名称()));
        row現在.setTxt9Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法9月()).get名称()));
        row現在.setTxt10Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法10月()).get名称()));
        row現在.setTxt11Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法11月()).get名称()));
        row現在.setTxt12Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法12月()).get名称()));
        row現在.setTxt1Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法1月()).get名称()));
        row現在.setTxt2Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法2月()).get名称()));
        row現在.setTxt3Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法3月()).get名称()));
        row現在.setTxtYoku4Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法翌4月()).get名称()));
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
        if (serviceResult.getChoshuHoho3gat() != null && !serviceResult.getChoshuHoho3gat().isEmpty()) {
            row変更後.setTxtZen3Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getChoshuHoho3gat()).get名称()));
        } else {
            row変更後.setTxtZen3Gatsu(get徴収方法の名称(ChoshuHoho.toValue(コード_0).get名称()));
        }
        row変更後.setTxt4Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法4月()).get名称()));
        row変更後.setTxt5Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法5月()).get名称()));
        row変更後.setTxt6Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法6月()).get名称()));
        row変更後.setTxt7Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法7月()).get名称()));
        row変更後.setTxt8Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法8月()).get名称()));
        row変更後.setTxt9Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法9月()).get名称()));
        row変更後.setTxt10Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法10月()).get名称()));
        row変更後.setTxt11Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法11月()).get名称()));
        row変更後.setTxt12Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法12月()).get名称()));
        row変更後.setTxt1Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法1月()).get名称()));
        row変更後.setTxt2Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法2月()).get名称()));
        row変更後.setTxt3Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法3月()).get名称()));
        row変更後.setTxtYoku4Gatsu(get徴収方法の名称(ChoshuHoho.toValue(serviceResult.getHoho().get徴収方法翌4月()).get名称()));
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
            if (保存活性()) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
            }
        }
    }

    private boolean 保存活性() {
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt4Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt4Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt5Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt5Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt6Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt6Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt7Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt8Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt9Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt10Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt10Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt11Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt11Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt12Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt12Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt1Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu())) {
            return true;
        }
        if (!div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt2Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu())) {
            return true;
        }
        return !div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt3Gatsu().
                equals(div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu());

    }

    /**
     * ＤＢ登録を行う
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @param 徴収方法データ ChoshuHoho
     * @param 停止日時 YMDHMS
     * @param 停止事由コード RString
     */
    public void saveボタンを押下(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号,
            jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho 徴収方法データ,
            YMDHMS 停止日時, RString 停止事由コード) {
        dataSaveEdit(賦課年度, 被保険者番号, 徴収方法データ, 停止日時, 停止事由コード);
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
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxtZen3Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxtZen3Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt4Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt4Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt5Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt5Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt6Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt6Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt7Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt7Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt8Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt8Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt9Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt9Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt10Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt10Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt11Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt11Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt12Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt12Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt1Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt1Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt2Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt2Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt3Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt3Gatsu());
        div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxtYoku4Gatsu(
                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxtYoku4Gatsu());
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
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt4Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt5Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt6Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt7Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt8Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt9Gatsu(
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
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt5Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt6Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt7Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt8Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt9Gatsu(
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
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt6Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt7Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt8Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt9Gatsu(
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
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt7Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt8Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt9Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_7.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_8.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_9.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_8.equals(gatsu)) {
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt8Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt9Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_8.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_9.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_9.equals(gatsu)) {
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt9Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_9.toString(), DataGridCellBgColor.bgColorLightRed);
        } else {
            set背景色も普通徴収の色に変更10To03(gatsu);
        }
    }

    private void set背景色も普通徴収の色に変更10To03(RString gatsu) {
        if (月_10.equals(gatsu)) {
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt10Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt11Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt12Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt1Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt2Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt3Gatsu(
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
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt11Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt12Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt1Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt2Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt3Gatsu(
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
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt12Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt1Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt2Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt3Gatsu(
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
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt1Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt2Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt3Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_1.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_2.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_3.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_2.equals(gatsu)) {
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt2Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt3Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_2.toString(), DataGridCellBgColor.bgColorLightRed);
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_3.toString(), DataGridCellBgColor.bgColorLightRed);
        } else if (月_3.equals(gatsu)) {
            edit空白を選択した場合();
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setTxt3Gatsu(
                    get徴収方法の名称(ChoshuHoho.toValue(コード_3).get名称()));
            div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).setCellBgColor(
                    名_3.toString(), DataGridCellBgColor.bgColorLightRed);
        }
    }

    private void edit現在の月の徴収方法はなしの場合() {
        choshuHouhou_Row row現在 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0);
        choshuHouhou_Row row変更後 = div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1);
        RString getなし名称 = get徴収方法の名称(ChoshuHoho.toValue(コード_0).get名称());
        if (getなし名称.equals(row現在.getTxtZen3Gatsu())) {
            row変更後.setTxtZen3Gatsu(getなし名称);
            row変更後.setCellBgColor(前の名_3.toString(), row現在.getCellBgColor(前の名_3.toString()));
        }
        if (getなし名称.equals(row現在.getTxt4Gatsu())) {
            row変更後.setTxt4Gatsu(getなし名称);
            row変更後.setCellBgColor(名_4.toString(), row現在.getCellBgColor(名_4.toString()));
        }
        if (getなし名称.equals(row現在.getTxt5Gatsu())) {
            row変更後.setTxt5Gatsu(getなし名称);
            row変更後.setCellBgColor(名_5.toString(), row現在.getCellBgColor(名_5.toString()));
        }
        if (getなし名称.equals(row現在.getTxt6Gatsu())) {
            row変更後.setTxt6Gatsu(getなし名称);
            row変更後.setCellBgColor(名_6.toString(), row現在.getCellBgColor(名_6.toString()));
        }
        if (getなし名称.equals(row現在.getTxt7Gatsu())) {
            row変更後.setTxt7Gatsu(getなし名称);
            row変更後.setCellBgColor(名_7.toString(), row現在.getCellBgColor(名_7.toString()));
        }
        if (getなし名称.equals(row現在.getTxt8Gatsu())) {
            row変更後.setTxt8Gatsu(getなし名称);
            row変更後.setCellBgColor(名_8.toString(), row現在.getCellBgColor(名_8.toString()));
        }
        if (getなし名称.equals(row現在.getTxt9Gatsu())) {
            row変更後.setTxt9Gatsu(getなし名称);
            row変更後.setCellBgColor(名_9.toString(), row現在.getCellBgColor(名_9.toString()));
        }
        if (getなし名称.equals(row現在.getTxt10Gatsu())) {
            row変更後.setTxt10Gatsu(getなし名称);
            row変更後.setCellBgColor(名_10.toString(), row現在.getCellBgColor(名_10.toString()));
        }
        continueEdit(getなし名称, row現在, row変更後);
    }

    private void continueEdit(RString getなし名称,
            choshuHouhou_Row row現在, choshuHouhou_Row row変更後) {
        if (getなし名称.equals(row現在.getTxt11Gatsu())) {
            row変更後.setTxt11Gatsu(getなし名称);
            row変更後.setCellBgColor(名_11.toString(), row現在.getCellBgColor(名_11.toString()));
        }
        if (getなし名称.equals(row現在.getTxt12Gatsu())) {
            row変更後.setTxt12Gatsu(getなし名称);
            row変更後.setCellBgColor(名_12.toString(), row現在.getCellBgColor(名_12.toString()));
        }
        if (getなし名称.equals(row現在.getTxt1Gatsu())) {
            row変更後.setTxt1Gatsu(getなし名称);
            row変更後.setCellBgColor(名_1.toString(), row現在.getCellBgColor(名_1.toString()));
        }
        if (getなし名称.equals(row現在.getTxt2Gatsu())) {
            row変更後.setTxt2Gatsu(getなし名称);
            row変更後.setCellBgColor(名_2.toString(), row現在.getCellBgColor(名_2.toString()));
        }
        if (getなし名称.equals(row現在.getTxt3Gatsu())) {
            row変更後.setTxt3Gatsu(getなし名称);
            row変更後.setCellBgColor(名_3.toString(), row現在.getCellBgColor(名_3.toString()));
        }
        if (getなし名称.equals(row現在.getTxtYoku4Gatsu())) {
            row変更後.setTxtYoku4Gatsu(getなし名称);
            row変更後.setCellBgColor(翌の名_4.toString(), row現在.getCellBgColor(翌の名_4.toString()));
        }
    }

    private void dataSaveEdit(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号,
            jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho 徴収方法データ,
            YMDHMS 停止日時, RString 停止事由コード) {
        int 現在の月;
        final int three = 3;
        YMDHMS 特別徴収停止日時 = null;
        RString 特別徴収停止事由コード = null;
        RDate システム日付 = RDate.getNowDate();
        jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho 徴収方法_変更後
                = new jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho(
                        賦課年度, 被保険者番号, 徴収方法データ.get履歴番号() + 1);
        RStringBuilder builder = new RStringBuilder(賦課年度.plusYear(1).toString());
        RString 賦課年度日付 = builder.append(RSTR_0331).toRString();
        RDate 賦課日付 = new RDate(賦課年度日付.toString());
        if (賦課日付.isBefore(システム日付)) {
            現在の月 = three;
        } else {
            現在の月 = システム日付.getMonthValue();
        }
        List<Integer> 現在月list = new ArrayList<>();
        現在月list.add(0, 現在の月_4);
        現在月list.add(整数_1, 現在の月_5);
        現在月list.add(整数_2, 現在の月_6);
        現在月list.add(整数_3, 現在の月_7);
        現在月list.add(整数_4, 現在の月_8);
        現在月list.add(整数_5, 現在の月_9);
        現在月list.add(整数_6, 現在の月_10);
        現在月list.add(整数_7, 現在の月_11);
        現在月list.add(整数_8, 現在の月_12);
        現在月list.add(整数_9, 現在の月_1);
        現在月list.add(整数_10, 現在の月_2);
        現在月list.add(整数_11, 現在の月_3);
        int j = 0;
        for (int i = 0; i <= 整数_11; i++) {
            if (現在の月 == 現在月list.get(i)) {
                j = i;
                break;
            }
        }
        List<RString> 現在徴収方法list = new ArrayList<>();
        現在徴収方法list.add(0, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt4Gatsu());
        現在徴収方法list.add(整数_1, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt5Gatsu());
        現在徴収方法list.add(整数_2, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt6Gatsu());
        現在徴収方法list.add(整数_3, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt7Gatsu());
        現在徴収方法list.add(整数_4, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt8Gatsu());
        現在徴収方法list.add(整数_5, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt9Gatsu());
        現在徴収方法list.add(整数_6, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt10Gatsu());
        現在徴収方法list.add(整数_7, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt11Gatsu());
        現在徴収方法list.add(整数_8, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt12Gatsu());
        現在徴収方法list.add(整数_9, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt1Gatsu());
        現在徴収方法list.add(整数_10, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt2Gatsu());
        現在徴収方法list.add(整数_11, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(0).getTxt3Gatsu());
        List<RString> 変更後list = new ArrayList<>();
        変更後list.add(0, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt4Gatsu());
        変更後list.add(整数_1, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt5Gatsu());
        変更後list.add(整数_2, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt6Gatsu());
        変更後list.add(整数_3, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu());
        変更後list.add(整数_4, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu());
        変更後list.add(整数_5, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu());
        変更後list.add(整数_6, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt10Gatsu());
        変更後list.add(整数_7, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt11Gatsu());
        変更後list.add(整数_8, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt12Gatsu());
        変更後list.add(整数_9, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu());
        変更後list.add(整数_10, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu());
        変更後list.add(整数_11, div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu());
        for (; j <= 整数_11; j++) {
            if (現在徴収方法list.get(j).equals(特) && (変更後list.get(j).equals(普)
                    || 変更後list.get(j).equals(RString.EMPTY))) {
                特別徴収停止日時 = YMDHMS.now();
                特別徴収停止事由コード = ChoteiJiyuCode.徴収方法修正.getコード();
                break;
            } else {
                特別徴収停止日時 = 停止日時;
                特別徴収停止事由コード = 停止事由コード;
            }

        }
        徴収方法_変更後 = 徴収方法_変更後.createBuilderForEdit().
                set徴収方法4月(get徴収方法のコード(徴収方法データ.get徴収方法4月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt4Gatsu())).
                set徴収方法5月(get徴収方法のコード(徴収方法データ.get徴収方法5月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt5Gatsu())).
                set徴収方法6月(get徴収方法のコード(徴収方法データ.get徴収方法6月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt6Gatsu())).
                set徴収方法7月(get徴収方法のコード(徴収方法データ.get徴収方法7月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt7Gatsu())).
                set徴収方法8月(get徴収方法のコード(徴収方法データ.get徴収方法8月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt8Gatsu())).
                set徴収方法9月(get徴収方法のコード(徴収方法データ.get徴収方法9月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt9Gatsu())).
                set徴収方法10月(get徴収方法のコード(徴収方法データ.get徴収方法10月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt10Gatsu())).
                set徴収方法11月(get徴収方法のコード(徴収方法データ.get徴収方法11月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt11Gatsu())).
                set徴収方法12月(get徴収方法のコード(徴収方法データ.get徴収方法12月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt12Gatsu())).
                set徴収方法1月(get徴収方法のコード(徴収方法データ.get徴収方法1月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt1Gatsu())).
                set徴収方法2月(get徴収方法のコード(徴収方法データ.get徴収方法2月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt2Gatsu())).
                set徴収方法3月(get徴収方法のコード(徴収方法データ.get徴収方法3月(),
                                div.getChoshuInfo().getChoshuHouhou().getDataSource().get(1).getTxt3Gatsu())).
                set徴収方法翌4月(徴収方法データ.get徴収方法翌4月()).
                set徴収方法翌5月(徴収方法データ.get徴収方法翌5月()).
                set徴収方法翌6月(徴収方法データ.get徴収方法翌6月()).
                set徴収方法翌7月(徴収方法データ.get徴収方法翌7月()).
                set徴収方法翌8月(徴収方法データ.get徴収方法翌8月()).
                set徴収方法翌9月(徴収方法データ.get徴収方法翌9月()).
                set仮徴収_基礎年金番号(徴収方法データ.get仮徴収_基礎年金番号()).
                set仮徴収_年金コード(徴収方法データ.get仮徴収_年金コード()).
                set仮徴収_捕捉月(徴収方法データ.get仮徴収_捕捉月()).
                set本徴収_基礎年金番号(徴収方法データ.get本徴収_基礎年金番号()).
                set本徴収_年金コード(徴収方法データ.get本徴収_年金コード()).
                set本徴収_捕捉月(徴収方法データ.get本徴収_捕捉月()).
                set翌年度仮徴収_基礎年金番号(徴収方法データ.get翌年度仮徴収_基礎年金番号()).
                set翌年度仮徴収_年金コード(徴収方法データ.get翌年度仮徴収_年金コード()).
                set翌年度仮徴収_捕捉月(徴収方法データ.get翌年度仮徴収_捕捉月()).
                set依頼情報送付済みフラグ(徴収方法データ.is依頼情報送付済みフラグ()).
                set追加依頼情報送付済みフラグ(徴収方法データ.is追加依頼情報送付済みフラグ()).
                set特別徴収停止日時(特別徴収停止日時).
                set特別徴収停止事由コード(特別徴収停止事由コード).build().added();
        ChoshuHohoManager manager = new ChoshuHohoManager();
        manager.save介護徴収方法(徴収方法_変更後);
    }

    private RString get徴収方法のコード(RString 徴収方法, RString 徴収方法_変更後) {
        if (!ChoshuHoho.普通徴収.getコード().equals(徴収方法) && 名称_3.equals(徴収方法_変更後)) {
            return コード_3;
        }
        return 徴収方法;
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
}
