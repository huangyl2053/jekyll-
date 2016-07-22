/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050041;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.InsuranceInformation;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenShoriDateKanri;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.Shichoson;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.DBU0050041StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.YoshikiYonnosanDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.tblYoshikiyonnosanDiv;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.JigyoHokokuNenpoShoriName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険特別会計経理状況登録_様式４の３ハンドラクラスです。
 *
 * @reamsid_L DBU-1130-040 liangbc
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler {

    private static final int INT3 = 3;
    private static final int INT31 = 31;
    private static final int INT4 = 4;
    private static final int INT6 = 6;
    private static final RString UPDATE = new RString("modify");
    private static final RString DELETE = new RString("delete");
    private static final RString ADD = new RString("add");
    private static final RString BUTTON_追加 = new RString("btnAddUpdate");
    private final YoshikiYonnosanDiv div;
    private static final RString 内部処理モード_修正新規 = new RString("修正新規");
    private static final RString 内部処理モード_修正 = new RString("修正");
    private static final RString 内部処理モード_削除 = new RString("削除");
    private static final RString 内部処理モード_追加 = new RString("追加");
    private static final RString 画面表示_修正 = new RString("修正");
    private static final RString 画面表示_削除 = new RString("削除");
    private static final RString 画面表示_追加 = new RString("追加");
    private static final RString 前年度以前データ = new RString("前年度以前データ");
    private static final RString 今年度データ = new RString("今年度データ");
    private static final RString 実質的な収支についてデータ = new RString("実質的な収支についてデータ");
    private static final Decimal DECIMAL_0 = new Decimal("0");
    private static final RString DOUBLE_ZEOR = new RString("00");
    private final RString 状態1 = new RString("状態1");
    private final RString 状態1_確定 = new RString("状態1_確定");
    private final RString 状態2 = new RString("状態2");
    private final RString 状態3 = new RString("状態3");
    private final Code 集計番号_0301 = new Code("0301");
    private final Code 集計番号_0302 = new Code("0302");
    private final Code 集計番号_0303 = new Code("0303");
    private final Code 集計単位_1 = new Code("1");
    private final RString 介護給付費負担金1 = new RString("1_1");
    private final RString 介護給付費負担金2 = new RString("1_2");
    private final RString 調整交付金1 = new RString("2_1");
    private final RString 調整交付金2 = new RString("2_2");
    private final RString 地域支援事業交付金1 = new RString("3_1");
    private final RString 地域支援事業交付金2 = new RString("3_2");
    private final RString 介護給付費交付金1 = new RString("4_1");
    private final RString 介護給付費交付金2 = new RString("4_2");
    private final RString 地域支援事業支援交付金1 = new RString("5_1");
    private final RString 地域支援事業支援交付金2 = new RString("5_2");
    private final RString 都道府県負担金1 = new RString("6_1");
    private final RString 都道府県負担金2 = new RString("6_2");
    private final RString 地域支援事業交付金_都道府県支出金1 = new RString("7_1");
    private final RString 地域支援事業交付金_都道府県支出金2 = new RString("7_2");
    private final RString 一般会計繰入金1 = new RString("8_1");
    private final RString 一般会計繰入金2 = new RString("8_2");
    private final RString 合計1 = new RString("9_1");
    private final RString 合計2 = new RString("9_2");
    private final RString 歳入合計 = new RString("1_1");
    private final RString 歳出合計 = new RString("2_1");
    private final RString 歳入歳出差引残額 = new RString("3_1");
    private final RString 精算後残額 = new RString("4_1");
    private final TextBoxNum 前年度_介護給付費負担金1;
    private final TextBoxNum 前年度_介護給付費負担金2;
    private final TextBoxNum 前年度_調整交付金1;
    private final TextBoxNum 前年度_調整交付金2;
    private final TextBoxNum 前年度_地域支援事業交付金1;
    private final TextBoxNum 前年度_地域支援事業交付金2;
    private final TextBoxNum 前年度_介護給付費交付金1;
    private final TextBoxNum 前年度_介護給付費交付金2;
    private final TextBoxNum 前年度_地域支援事業支援交付金1;
    private final TextBoxNum 前年度_地域支援事業支援交付金2;
    private final TextBoxNum 前年度_都道府県負担金1;
    private final TextBoxNum 前年度_都道府県負担金2;
    private final TextBoxNum 前年度_地域支援事業交付金_都道府県支出金1;
    private final TextBoxNum 前年度_地域支援事業交付金_都道府県支出金2;
    private final TextBoxNum 前年度_一般会計繰入金1;
    private final TextBoxNum 前年度_一般会計繰入金2;
    private final TextBoxNum 前年度_合計1;
    private final TextBoxNum 前年度_合計2;
    private final TextBoxNum 今年度_介護給付費負担金1;
    private final TextBoxNum 今年度_介護給付費負担金2;
    private final TextBoxNum 今年度_調整交付金1;
    private final TextBoxNum 今年度_調整交付金2;
    private final TextBoxNum 今年度_地域支援事業交付金1;
    private final TextBoxNum 今年度_地域支援事業交付金2;
    private final TextBoxNum 今年度_介護給付費交付金1;
    private final TextBoxNum 今年度_介護給付費交付金2;
    private final TextBoxNum 今年度_地域支援事業支援交付金1;
    private final TextBoxNum 今年度_地域支援事業支援交付金2;
    private final TextBoxNum 今年度_都道府県負担金1;
    private final TextBoxNum 今年度_都道府県負担金2;
    private final TextBoxNum 今年度_地域支援事業交付金_都道府県支出金1;
    private final TextBoxNum 今年度_地域支援事業交付金_都道府県支出金2;
    private final TextBoxNum 今年度_一般会計繰入金1;
    private final TextBoxNum 今年度_一般会計繰入金2;
    private final TextBoxNum 今年度_合計1;
    private final TextBoxNum 今年度_合計2;
    private final TextBoxNum 実質_歳入合計;
    private final TextBoxNum 実質_歳出合計;
    private final TextBoxNum 実質_歳入歳出差引残額;
    private final TextBoxNum 実質_精算後残額;

    /**
     * コンストラクタです。
     *
     * @param div 介護保険特別会計経理状況登録_様式４の３情報Div
     */
    public KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler(YoshikiYonnosanDiv div) {
        this.div = div;
        tblYoshikiyonnosanDiv tblYoshikiyonnosanDiv = div.getYoshikiYonnosanMeisai().getTblYoshikiyonnosan();
        前年度_介護給付費負担金1 = tblYoshikiyonnosanDiv.getTxtsainkakyufuhifukin();
        前年度_介護給付費負担金2 = tblYoshikiyonnosanDiv.getTxtsaitkakyufuhifukin();
        前年度_調整交付金1 = tblYoshikiyonnosanDiv.getTxtsainchoseikofukin();
        前年度_調整交付金2 = tblYoshikiyonnosanDiv.getTxtsaitchoseikofukin();
        前年度_地域支援事業交付金1 = tblYoshikiyonnosanDiv.getTxtsainchiikishienkin();
        前年度_地域支援事業交付金2 = tblYoshikiyonnosanDiv.getTxtsaitchiikishienkin();
        前年度_介護給付費交付金1 = tblYoshikiyonnosanDiv.getTxtsainkaigokyufuhikokin();
        前年度_介護給付費交付金2 = tblYoshikiyonnosanDiv.getTxtsaitkaigokyufuhikokin();
        前年度_地域支援事業支援交付金1 = tblYoshikiyonnosanDiv.getTxtsainchiikishienkofukin();
        前年度_地域支援事業支援交付金2 = tblYoshikiyonnosanDiv.getTxtsaitchiikishienkofukin();
        前年度_都道府県負担金1 = tblYoshikiyonnosanDiv.getTxtsaintodofukenfutankin();
        前年度_都道府県負担金2 = tblYoshikiyonnosanDiv.getTxtsaittodofukenfutankin();
        前年度_地域支援事業交付金_都道府県支出金1 = tblYoshikiyonnosanDiv.getTxtsainchiikishienjkin();
        前年度_地域支援事業交付金_都道府県支出金2 = tblYoshikiyonnosanDiv.getTxtsaitchiikishienjkin();
        前年度_一般会計繰入金1 = tblYoshikiyonnosanDiv.getTxtsainippankaiekikin();
        前年度_一般会計繰入金2 = tblYoshikiyonnosanDiv.getTxtsaitippankaiekikin();
        前年度_合計1 = tblYoshikiyonnosanDiv.getTxtshiyohigokei();
        前年度_合計2 = tblYoshikiyonnosanDiv.getTxtsaishutsugokei();
        今年度_介護給付費負担金1 = tblYoshikiyonnosanDiv.getTxtsainkkakyufuhifukin();
        今年度_介護給付費負担金2 = tblYoshikiyonnosanDiv.getTxtsaitkkakyufuhifukin();
        今年度_調整交付金1 = tblYoshikiyonnosanDiv.getTxtsainkchoseikofukin();
        今年度_調整交付金2 = tblYoshikiyonnosanDiv.getTxtsaitkchoseikofukin();
        今年度_地域支援事業交付金1 = tblYoshikiyonnosanDiv.getTxtsainkchiikishienkin();
        今年度_地域支援事業交付金2 = tblYoshikiyonnosanDiv.getTxtsaitkchiikishienkin();
        今年度_介護給付費交付金1 = tblYoshikiyonnosanDiv.getTxtsainkkaigokyufuhikokin();
        今年度_介護給付費交付金2 = tblYoshikiyonnosanDiv.getTxtsaitkkaigokyufuhikokin();
        今年度_地域支援事業支援交付金1 = tblYoshikiyonnosanDiv.getTxtsainkchiikishienkofukin();
        今年度_地域支援事業支援交付金2 = tblYoshikiyonnosanDiv.getTxtsaitkchiikishienkofukin();
        今年度_都道府県負担金1 = tblYoshikiyonnosanDiv.getTxtsainktodofukenfutankin();
        今年度_都道府県負担金2 = tblYoshikiyonnosanDiv.getTxtsaitktodofukenfutankin();
        今年度_地域支援事業交付金_都道府県支出金1 = tblYoshikiyonnosanDiv.getTxtsainkchiikishienjkin();
        今年度_地域支援事業交付金_都道府県支出金2 = tblYoshikiyonnosanDiv.getTxtsaitkchiikishienjkin();
        今年度_一般会計繰入金1 = tblYoshikiyonnosanDiv.getTxtsainkippankaiekikin();
        今年度_一般会計繰入金2 = tblYoshikiyonnosanDiv.getTxtsaitkippankaiekikin();
        今年度_合計1 = tblYoshikiyonnosanDiv.getTxtkoshiyohigokei();
        今年度_合計2 = tblYoshikiyonnosanDiv.getTxtkosaishutsugokei();
        実質_歳入合計 = tblYoshikiyonnosanDiv.getTxtshitsusainyugokei();
        実質_歳出合計 = tblYoshikiyonnosanDiv.getTxtshitsusaishutsugokei();
        実質_歳入歳出差引残額 = tblYoshikiyonnosanDiv.getTxtshitsusainyusaishutsusa();
        実質_精算後残額 = tblYoshikiyonnosanDiv.getTxtshitsuseisangozangaku();
    }

    /**
     * 画面初期化処理です。
     *
     * @param insuranceInfEntity 引き継ぎデータ
     */
    public void onload(InsuranceInformation insuranceInfEntity) {
        if (DELETE.equals(insuranceInfEntity.get処理フラグ())
                || UPDATE.equals(insuranceInfEntity.get処理フラグ())) {
            onload処理フラグが一覧修正Or一覧削除(insuranceInfEntity);
        } else if (ADD.equals(insuranceInfEntity.get処理フラグ())) {
            onload処理フラグが一覧追加();
        }
    }

    private void onload処理フラグが一覧追加() {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<Shichoson> 市町村Lst = 介護保険特別会計経理状況登録Manager.getShichosonCodeNameList();
        if (市町村Lst.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
        }
        List<KeyValueDataSource> dataSource = getDataSourceFrom市町村Lst(市町村Lst);
        RDate date = RDate.getNowDate();
        FlexibleDate 報告年度;
        FlexibleDate 集計年度;
        if (date.getMonthValue() < INT6) {
            報告年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
        } else {
            報告年度 = new FlexibleDate(date.getYear().getYearValue(), date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
        }
        div.getYoshikiYonnosanMeisai().getTxtHokokuYM().setValue(new RDate(報告年度.getYearValue()));
        div.getYoshikiYonnosanMeisai().getTxtShukeiYM().setValue(new RDate(集計年度.getYearValue()));
        div.getYoshikiYonnosanMeisai().getDdlShicyoson().setDataSource(dataSource);
        div.getYoshikiYonnosanMeisai().getDdlShicyoson().setSelectedIndex(1);
        div.setShoriMode(内部処理モード_追加);
        div.setGamenMode(画面表示_追加);
        div.getYoshikiYonnosanMeisai().getTxtHokokuYM().setReadOnly(false);
        div.getYoshikiYonnosanMeisai().getTxtShukeiYM().setReadOnly(true);
        div.getYoshikiYonnosanMeisai().getTxtHihokenshaNo().setDisplayNone(true);
        div.getYoshikiYonnosanMeisai().getTxtHihokenshaName().setDisplayNone(true);
        div.getYoshikiYonnosanMeisai().getDdlShicyoson().setDisabled(false);
        div.getYoshikiYonnosanMeisai().getBtnKakutei().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_追加, true);
        set詳細データエリア入力可否(状態1);
    }

    private void onload処理フラグが一覧修正Or一覧削除(InsuranceInformation insuranceInfEntity) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        FlexibleYear 報告年 = new FlexibleYear(insuranceInfEntity.get報告年().toString());
        RString 集計対象年 = new RString(insuranceInfEntity.get集計対象年().toString());
        RString 統計対象区分 = insuranceInfEntity.get統計対象区分();
        LasdecCode 市町村コード = insuranceInfEntity.get市町村コード();
        List<KaigoHokenJigyoHokokuNenpo> 前年度以前データs = 介護保険特別会計経理状況登録Manager
                .getJigyoHokokuNenpoDetal(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号_0301.getColumnValue());
        List<KaigoHokenJigyoHokokuNenpo> 今年度データs = 介護保険特別会計経理状況登録Manager
                .getJigyoHokokuNenpoDetal(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号_0302.getColumnValue());
        List<KaigoHokenJigyoHokokuNenpo> 実質的な収支についてデータs = 介護保険特別会計経理状況登録Manager
                .getJigyoHokokuNenpoDetal(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号_0303.getColumnValue());
        KaigoHokenJigyoHokokuNenpo data前年度以前データ = null;
        KaigoHokenJigyoHokokuNenpo data今年度データ = null;
        KaigoHokenJigyoHokokuNenpo data実質的な収支についてデータ = null;
        if (!前年度以前データs.isEmpty()) {
            data前年度以前データ = 前年度以前データs.get(0);
        }
        if (!今年度データs.isEmpty()) {
            data今年度データ = 今年度データs.get(0);
        }
        if (!実質的な収支についてデータs.isEmpty()) {
            data実質的な収支についてデータ = 実質的な収支についてデータs.get(0);
        }
        if (data前年度以前データ != null) {
            set前年度以前データ(data前年度以前データ);
        }
        if (data今年度データ != null) {
            set今年度データ(data今年度データ);
        }
        if (data実質的な収支についてデータ != null) {
            set実質的な収支についてデータ(data実質的な収支についてデータ);
        }
        div.getYoshikiYonnosanMeisai().getTxtHokokuYM().setValue(new RDate(insuranceInfEntity.get報告年().getYearValue()));
        div.getYoshikiYonnosanMeisai().getTxtShukeiYM().setValue(new RDate(insuranceInfEntity.get集計対象年().getYearValue()));
        div.getYoshikiYonnosanMeisai().getTxtHihokenshaNo().setValue(insuranceInfEntity.get保険者コード().getColumnValue());
        div.getYoshikiYonnosanMeisai().getTxtHihokenshaName().setValue(insuranceInfEntity.get市町村名称());
        div.getYoshikiYonnosanMeisai().getDdlShicyoson().setDisplayNone(true);
        div.getYoshikiYonnosanMeisai().getBtnKakutei().setDisplayNone(true);
        div.getYoshikiYonnosanMeisai().getTxtHokokuYM().setReadOnly(true);
        div.getYoshikiYonnosanMeisai().getTxtShukeiYM().setReadOnly(true);
        div.getYoshikiYonnosanMeisai().getTxtHihokenshaNo().setReadOnly(true);
        div.getYoshikiYonnosanMeisai().getTxtHihokenshaName().setReadOnly(true);
        if ((null == data前年度以前データ || data前年度以前データ.get詳細データエリア().isEmpty())
                && (null == data今年度データ || data今年度データ.get詳細データエリア().isEmpty())
                && (null == data実質的な収支についてデータ || data実質的な収支についてデータ.get詳細データエリア().isEmpty())
                && !DELETE.equals(insuranceInfEntity.get処理フラグ())) {
            div.setShoriMode(内部処理モード_修正新規);
        } else {
            boolean 処理 = UPDATE.equals(insuranceInfEntity.get処理フラグ());
            div.setShoriMode(処理 ? 内部処理モード_修正 : 内部処理モード_削除);
            set詳細データエリア入力可否(処理 ? 状態2 : 状態3);
            div.setGamenMode(処理 ? 画面表示_修正 : 画面表示_削除);
        }
        if (DBU0050041StateName.削除状態.getName().equals(ResponseHolder.getState())) {
            btnDisabled(insuranceInfEntity);
        }
    }

    /**
     * BtnYoshikiyonとBtnYoskiyonosanはDisabledになります。
     *
     */
    private void btnDisabled(InsuranceInformation insuranceInf) {
        if (new RString("入力未").equals(insuranceInf.get様式４入力状況())) {
            div.getYoshikiButtonArea().getBtnYoshikiyon().setDisabled(true);
        }
        div.getYoshikiButtonArea().getBtnYoshikiyonnoni().setDisabled(true);
        if (new RString("入力未").equals(insuranceInf.get様式４の２入力状況())) {
            div.getYoshikiButtonArea().getBtnYoskiyonosan().setDisabled(true);
        }
    }

    /**
     * 修正データの取得処理です。
     *
     * @param insuranceInfEntity 引き継ぎデータ
     * @return 修正データ
     */
    public List<KaigoHokenJigyoHokokuNenpo> get修正データ(InsuranceInformation insuranceInfEntity) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        FlexibleYear 報告年 = new FlexibleYear(insuranceInfEntity.get報告年().toString());
        RString 集計対象年 = new RString(insuranceInfEntity.get集計対象年().toString());
        RString 統計対象区分 = insuranceInfEntity.get統計対象区分();
        LasdecCode 市町村コード = insuranceInfEntity.get市町村コード();
        KaigoHokenJigyoHokokuNenpo 更新前前年度以前データ = 介護保険特別会計経理状況登録Manager
                .getJigyoHokokuNenpoDetal(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号_0301.getColumnValue()).get(0);
        KaigoHokenJigyoHokokuNenpo 更新前今年度データ = 介護保険特別会計経理状況登録Manager
                .getJigyoHokokuNenpoDetal(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号_0302.getColumnValue()).get(0);
        KaigoHokenJigyoHokokuNenpo 更新前実質的な収支についてデータ = 介護保険特別会計経理状況登録Manager
                .getJigyoHokokuNenpoDetal(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号_0303.getColumnValue()).get(0);
        KaigoHokenJigyoHokokuNenpo 画面入力前年度以前データ = get各部分画面入力データ(前年度以前データ, insuranceInfEntity);
        KaigoHokenJigyoHokokuNenpo 画面入力今年度データ = get各部分画面入力データ(今年度データ, insuranceInfEntity);
        KaigoHokenJigyoHokokuNenpo 画面入力実質的な収支についてデータ = get各部分画面入力データ(実質的な収支についてデータ, insuranceInfEntity);
        KaigoHokenJigyoHokokuNenpo 修正前年度以前データ = get各部分修正データ(更新前前年度以前データ, 画面入力前年度以前データ);
        KaigoHokenJigyoHokokuNenpo 修正今年度データ = get各部分修正データ(更新前今年度データ, 画面入力今年度データ);
        KaigoHokenJigyoHokokuNenpo 修正実質的な収支についてデータ
                = get各部分修正データ(更新前実質的な収支についてデータ, 画面入力実質的な収支についてデータ);
        List<KaigoHokenJigyoHokokuNenpo> 修正データ = new ArrayList<>();
        修正データ.add(修正前年度以前データ);
        修正データ.add(修正今年度データ);
        修正データ.add(修正実質的な収支についてデータ);
        return 修正データ;
    }

    /**
     * 各部分修正データを取得処理です。
     *
     * @param 更新前のデータ 更新前のデータ
     * @param 画面入力データ 画面入力データ
     * @return 各部分修正データ
     */
    private KaigoHokenJigyoHokokuNenpo get各部分修正データ(
            KaigoHokenJigyoHokokuNenpo 更新前のデータ, KaigoHokenJigyoHokokuNenpo 画面入力データ) {
        Map<RString, Decimal> 更新前のデータMap = 更新前のデータ.get詳細データエリア();
        Map<RString, Decimal> 画面入力データMap = 画面入力データ.get詳細データエリア();
        Map<RString, Decimal> 修正データMap = new HashMap<>();
        for (Map.Entry<RString, Decimal> 更新前のデータMapEntry : 更新前のデータMap.entrySet()) {
            if (!更新前のデータMapEntry.getValue().equals(画面入力データMap.get(更新前のデータMapEntry.getKey()))) {
                修正データMap.put(更新前のデータMapEntry.getKey(), 画面入力データMap.get(更新前のデータMapEntry.getKey()));
            }
        }
        KaigoHokenJigyoHokokuNenpo 修正データ = new KaigoHokenJigyoHokokuNenpo(画面入力データ.get報告年(), 画面入力データ.get報告月(),
                画面入力データ.get集計対象年(), 画面入力データ.get集計対象月(), 画面入力データ.get統計対象区分(), 画面入力データ.get市町村コード(),
                画面入力データ.get表番号(), 画面入力データ.get集計番号(), 画面入力データ.get集計単位(), 画面入力データ.get集計項目名称(),
                画面入力データ.get縦項目コード(), 画面入力データ.get横項目コード(), 修正データMap);
        return 修正データ;
    }

    /**
     * 各部分画面入力データを取得処理です。
     *
     * @param データ区分 データ区分
     * @param insuranceInfEntity 引き継ぎデータ
     * @return 画面入力データ
     */
    public KaigoHokenJigyoHokokuNenpo get各部分画面入力データ(RString データ区分, InsuranceInformation insuranceInfEntity) {
        Code 集計番号 = Code.EMPTY;
        Map<RString, Decimal> 詳細データエリア = new HashMap<>();
        if (前年度以前データ.equals(データ区分)) {
            集計番号 = 集計番号_0301;
            詳細データエリア = get前年度以前データ();
        } else if (今年度データ.equals(データ区分)) {
            集計番号 = 集計番号_0302;
            詳細データエリア = get今年度データ();
        } else if (実質的な収支についてデータ.equals(データ区分)) {
            集計番号 = 集計番号_0303;
            詳細データエリア = get実質的な収支についてデータ();
        }
        KaigoHokenJigyoHokokuNenpo 画面入力データ = new KaigoHokenJigyoHokokuNenpo(
                div.getYoshikiYonnosanMeisai().getTxtHokokuYM().getValue().toFlexibleDate().getYear(), DOUBLE_ZEOR,
                div.getYoshikiYonnosanMeisai().getTxtShukeiYM().getValue().toFlexibleDate().getYear(), DOUBLE_ZEOR,
                insuranceInfEntity.get統計対象区分(), insuranceInfEntity.get市町村コード(), new Code("09"), 集計番号, 集計単位_1, null, null, null, 詳細データエリア);
        return 画面入力データ;
    }

    /**
     * 前年度以前データを設定処理です。
     *
     * @param 前年度以前データ 前年度以前データ
     */
    private void set前年度以前データ(KaigoHokenJigyoHokokuNenpo 前年度以前データ) {
        Map<RString, Decimal> 前年度以前データMap = 前年度以前データ.get詳細データエリア();
        前年度_介護給付費負担金1.setValue(前年度以前データMap.get(介護給付費負担金1));
        前年度_介護給付費負担金2.setValue(前年度以前データMap.get(介護給付費負担金2));
        前年度_調整交付金1.setValue(前年度以前データMap.get(調整交付金1));
        前年度_調整交付金2.setValue(前年度以前データMap.get(調整交付金2));
        前年度_地域支援事業交付金1.setValue(前年度以前データMap.get(地域支援事業交付金1));
        前年度_地域支援事業交付金2.setValue(前年度以前データMap.get(地域支援事業交付金2));
        前年度_介護給付費交付金1.setValue(前年度以前データMap.get(介護給付費交付金1));
        前年度_介護給付費交付金2.setValue(前年度以前データMap.get(介護給付費交付金2));
        前年度_地域支援事業支援交付金1.setValue(前年度以前データMap.get(地域支援事業支援交付金1));
        前年度_地域支援事業支援交付金2.setValue(前年度以前データMap.get(地域支援事業支援交付金2));
        前年度_都道府県負担金1.setValue(前年度以前データMap.get(都道府県負担金1));
        前年度_都道府県負担金2.setValue(前年度以前データMap.get(都道府県負担金2));
        前年度_地域支援事業交付金_都道府県支出金1.setValue(前年度以前データMap.get(地域支援事業交付金_都道府県支出金1));
        前年度_地域支援事業交付金_都道府県支出金2.setValue(前年度以前データMap.get(地域支援事業交付金_都道府県支出金2));
        前年度_一般会計繰入金1.setValue(前年度以前データMap.get(一般会計繰入金1));
        前年度_一般会計繰入金2.setValue(前年度以前データMap.get(一般会計繰入金2));
        前年度_合計1.setValue(前年度以前データMap.get(合計1));
        前年度_合計2.setValue(前年度以前データMap.get(合計2));

    }

    /**
     * 今年度データを設定処理です。
     *
     * @param 今年度データ 今年度データ
     */
    private void set今年度データ(KaigoHokenJigyoHokokuNenpo 今年度データ) {
        Map<RString, Decimal> 今年度データMap = 今年度データ.get詳細データエリア();
        今年度_介護給付費負担金1.setValue(今年度データMap.get(介護給付費負担金1));
        今年度_介護給付費負担金2.setValue(今年度データMap.get(介護給付費負担金2));
        今年度_調整交付金1.setValue(今年度データMap.get(調整交付金1));
        今年度_調整交付金2.setValue(今年度データMap.get(調整交付金2));
        今年度_地域支援事業交付金1.setValue(今年度データMap.get(地域支援事業交付金1));
        今年度_地域支援事業交付金2.setValue(今年度データMap.get(地域支援事業交付金2));
        今年度_介護給付費交付金1.setValue(今年度データMap.get(介護給付費交付金1));
        今年度_介護給付費交付金2.setValue(今年度データMap.get(介護給付費交付金2));
        今年度_地域支援事業支援交付金1.setValue(今年度データMap.get(地域支援事業支援交付金1));
        今年度_地域支援事業支援交付金2.setValue(今年度データMap.get(地域支援事業支援交付金2));
        今年度_都道府県負担金1.setValue(今年度データMap.get(都道府県負担金1));
        今年度_都道府県負担金2.setValue(今年度データMap.get(都道府県負担金2));
        今年度_地域支援事業交付金_都道府県支出金1.setValue(今年度データMap.get(地域支援事業交付金_都道府県支出金1));
        今年度_地域支援事業交付金_都道府県支出金2.setValue(今年度データMap.get(地域支援事業交付金_都道府県支出金2));
        今年度_一般会計繰入金1.setValue(今年度データMap.get(一般会計繰入金1));
        今年度_一般会計繰入金2.setValue(今年度データMap.get(一般会計繰入金2));
        今年度_合計1.setValue(今年度データMap.get(合計1));
        今年度_合計2.setValue(今年度データMap.get(合計2));
    }

    /**
     * 実質的な収支についてデータを設定処理です。
     *
     * @param 実質的な収支についてデータ 実質的な収支についてデータ
     */
    private void set実質的な収支についてデータ(KaigoHokenJigyoHokokuNenpo 実質的な収支についてデータ) {
        Map<RString, Decimal> 実質的な収支についてデータMap = 実質的な収支についてデータ.get詳細データエリア();
        実質_歳入合計.setValue(実質的な収支についてデータMap.get(歳入合計));
        実質_歳出合計.setValue(実質的な収支についてデータMap.get(歳出合計));
        実質_歳入歳出差引残額.setValue(実質的な収支についてデータMap.get(歳入歳出差引残額));
        実質_精算後残額.setValue(実質的な収支についてデータMap.get(精算後残額));
    }

    /**
     * 詳細データエリア入力可否を設定すること処理です。
     *
     * @param 状態 状態
     */
    private void set詳細データエリア入力可否(RString 状態) {
        if (状態2.equals(状態) || 状態3.equals(状態) || 状態1.equals(状態) || 状態1_確定.equals(状態)) {
            Boolean readOnly = 状態3.equals(状態) || 状態1.equals(状態);
            前年度_介護給付費負担金1.setReadOnly(readOnly);
            前年度_介護給付費負担金2.setReadOnly(readOnly);
            前年度_調整交付金1.setReadOnly(readOnly);
            前年度_調整交付金2.setReadOnly(readOnly);
            前年度_地域支援事業交付金1.setReadOnly(readOnly);
            前年度_地域支援事業交付金2.setReadOnly(readOnly);
            前年度_介護給付費交付金1.setReadOnly(readOnly);
            前年度_介護給付費交付金2.setReadOnly(readOnly);
            前年度_地域支援事業支援交付金1.setReadOnly(readOnly);
            前年度_地域支援事業支援交付金2.setReadOnly(readOnly);
            前年度_都道府県負担金1.setReadOnly(readOnly);
            前年度_都道府県負担金2.setReadOnly(readOnly);
            前年度_地域支援事業交付金_都道府県支出金1.setReadOnly(readOnly);
            前年度_地域支援事業交付金_都道府県支出金2.setReadOnly(readOnly);
            前年度_一般会計繰入金1.setReadOnly(readOnly);
            前年度_一般会計繰入金2.setReadOnly(readOnly);
            前年度_合計1.setReadOnly(readOnly);
            前年度_合計2.setReadOnly(readOnly);
            今年度_介護給付費負担金1.setReadOnly(readOnly);
            今年度_介護給付費負担金2.setReadOnly(readOnly);
            今年度_調整交付金1.setReadOnly(readOnly);
            今年度_調整交付金2.setReadOnly(readOnly);
            今年度_地域支援事業交付金1.setReadOnly(readOnly);
            今年度_地域支援事業交付金2.setReadOnly(readOnly);
            今年度_介護給付費交付金1.setReadOnly(readOnly);
            今年度_介護給付費交付金2.setReadOnly(readOnly);
            今年度_地域支援事業支援交付金1.setReadOnly(readOnly);
            今年度_地域支援事業支援交付金2.setReadOnly(readOnly);
            今年度_都道府県負担金1.setReadOnly(readOnly);
            今年度_都道府県負担金2.setReadOnly(readOnly);
            今年度_地域支援事業交付金_都道府県支出金1.setReadOnly(readOnly);
            今年度_地域支援事業交付金_都道府県支出金2.setReadOnly(readOnly);
            今年度_一般会計繰入金1.setReadOnly(readOnly);
            今年度_一般会計繰入金2.setReadOnly(readOnly);
            今年度_合計1.setReadOnly(readOnly);
            今年度_合計2.setReadOnly(readOnly);
            実質_歳入合計.setReadOnly(readOnly);
            実質_歳出合計.setReadOnly(readOnly);
            実質_歳入歳出差引残額.setReadOnly(readOnly);
            実質_精算後残額.setReadOnly(readOnly);
        }
    }

    /**
     * 画面から前年度以前データ取得処理です。
     */
    private Map<RString, Decimal> get前年度以前データ() {
        Map<RString, Decimal> 前年度以前データMap = new HashMap<>();
        前年度以前データMap.put(介護給付費負担金1, 前年度_介護給付費負担金1.getValue() == null ? DECIMAL_0 : 前年度_介護給付費負担金1.getValue());
        前年度以前データMap.put(介護給付費負担金2, 前年度_介護給付費負担金2.getValue() == null ? DECIMAL_0 : 前年度_介護給付費負担金2.getValue());
        前年度以前データMap.put(調整交付金1, 前年度_調整交付金1.getValue() == null ? DECIMAL_0 : 前年度_調整交付金1.getValue());
        前年度以前データMap.put(調整交付金2, 前年度_調整交付金2.getValue() == null ? DECIMAL_0 : 前年度_調整交付金2.getValue());
        前年度以前データMap.put(地域支援事業交付金1, 前年度_地域支援事業交付金1.getValue() == null ? DECIMAL_0 : 前年度_地域支援事業交付金1.getValue());
        前年度以前データMap.put(地域支援事業交付金2, 前年度_地域支援事業交付金2.getValue() == null ? DECIMAL_0 : 前年度_地域支援事業交付金2.getValue());
        前年度以前データMap.put(介護給付費交付金1, 前年度_介護給付費交付金1.getValue() == null ? DECIMAL_0 : 前年度_介護給付費交付金1.getValue());
        前年度以前データMap.put(介護給付費交付金2, 前年度_介護給付費交付金2.getValue() == null ? DECIMAL_0 : 前年度_介護給付費交付金2.getValue());
        前年度以前データMap.put(地域支援事業支援交付金1, 前年度_地域支援事業支援交付金1
                .getValue() == null ? DECIMAL_0 : 前年度_地域支援事業支援交付金1.getValue());
        前年度以前データMap.put(地域支援事業支援交付金2, 前年度_地域支援事業支援交付金2
                .getValue() == null ? DECIMAL_0 : 前年度_地域支援事業支援交付金2.getValue());
        前年度以前データMap.put(都道府県負担金1, 前年度_都道府県負担金1.getValue() == null ? DECIMAL_0 : 前年度_都道府県負担金1.getValue());
        前年度以前データMap.put(都道府県負担金2, 前年度_都道府県負担金2.getValue() == null ? DECIMAL_0 : 前年度_都道府県負担金2.getValue());
        前年度以前データMap.put(地域支援事業交付金_都道府県支出金1, 前年度_地域支援事業交付金_都道府県支出金1.getValue()
                == null ? DECIMAL_0 : 前年度_地域支援事業交付金_都道府県支出金1.getValue());
        前年度以前データMap.put(地域支援事業交付金_都道府県支出金2, 前年度_地域支援事業交付金_都道府県支出金2.getValue()
                == null ? DECIMAL_0 : 前年度_地域支援事業交付金_都道府県支出金2.getValue());
        前年度以前データMap.put(一般会計繰入金1, 前年度_一般会計繰入金1.getValue() == null ? DECIMAL_0 : 前年度_一般会計繰入金1.getValue());
        前年度以前データMap.put(一般会計繰入金2, 前年度_一般会計繰入金2.getValue() == null ? DECIMAL_0 : 前年度_一般会計繰入金2.getValue());
        前年度以前データMap.put(合計1, 前年度_合計1.getValue() == null ? DECIMAL_0 : 前年度_合計1.getValue());
        前年度以前データMap.put(合計2, 前年度_合計2.getValue() == null ? DECIMAL_0 : 前年度_合計2.getValue());
        return 前年度以前データMap;
    }

    /**
     * 画面から今年度データ取得処理です。
     */
    private Map<RString, Decimal> get今年度データ() {
        Map<RString, Decimal> 今年度データMap = new HashMap<>();
        今年度データMap.put(介護給付費負担金1, 今年度_介護給付費負担金1.getValue() == null ? DECIMAL_0 : 今年度_介護給付費負担金1.getValue());
        今年度データMap.put(介護給付費負担金2, 今年度_介護給付費負担金2.getValue() == null ? DECIMAL_0 : 今年度_介護給付費負担金2.getValue());
        今年度データMap.put(調整交付金1, 今年度_調整交付金1.getValue() == null ? DECIMAL_0 : 今年度_調整交付金1.getValue());
        今年度データMap.put(調整交付金2, 今年度_調整交付金2.getValue() == null ? DECIMAL_0 : 今年度_調整交付金2.getValue());
        今年度データMap.put(地域支援事業交付金1, 今年度_地域支援事業交付金1.getValue() == null ? DECIMAL_0 : 今年度_地域支援事業交付金1.getValue());
        今年度データMap.put(地域支援事業交付金2, 今年度_地域支援事業交付金2.getValue() == null ? DECIMAL_0 : 今年度_地域支援事業交付金2.getValue());
        今年度データMap.put(介護給付費交付金1, 今年度_介護給付費交付金1.getValue() == null ? DECIMAL_0 : 今年度_介護給付費交付金1.getValue());
        今年度データMap.put(介護給付費交付金2, 今年度_介護給付費交付金2.getValue() == null ? DECIMAL_0 : 今年度_介護給付費交付金2.getValue());
        今年度データMap.put(地域支援事業支援交付金1, 今年度_地域支援事業支援交付金1
                .getValue() == null ? DECIMAL_0 : 今年度_地域支援事業支援交付金1.getValue());
        今年度データMap.put(地域支援事業支援交付金2, 今年度_地域支援事業支援交付金2
                .getValue() == null ? DECIMAL_0 : 今年度_地域支援事業支援交付金2.getValue());
        今年度データMap.put(都道府県負担金1, 今年度_都道府県負担金1.getValue() == null ? DECIMAL_0 : 今年度_都道府県負担金1.getValue());
        今年度データMap.put(都道府県負担金2, 今年度_都道府県負担金2.getValue() == null ? DECIMAL_0 : 今年度_都道府県負担金2.getValue());
        今年度データMap.put(地域支援事業交付金_都道府県支出金1, 今年度_地域支援事業交付金_都道府県支出金1.getValue()
                == null ? DECIMAL_0 : 今年度_地域支援事業交付金_都道府県支出金1.getValue());
        今年度データMap.put(地域支援事業交付金_都道府県支出金2, 今年度_地域支援事業交付金_都道府県支出金2.getValue()
                == null ? DECIMAL_0 : 今年度_地域支援事業交付金_都道府県支出金2.getValue());
        今年度データMap.put(一般会計繰入金1, 今年度_一般会計繰入金1.getValue() == null ? DECIMAL_0 : 今年度_一般会計繰入金1.getValue());
        今年度データMap.put(一般会計繰入金2, 今年度_一般会計繰入金2.getValue() == null ? DECIMAL_0 : 今年度_一般会計繰入金2.getValue());
        今年度データMap.put(合計1, 今年度_合計1.getValue() == null ? DECIMAL_0 : 今年度_合計1.getValue());
        今年度データMap.put(合計2, 今年度_合計2.getValue() == null ? DECIMAL_0 : 今年度_合計2.getValue());
        return 今年度データMap;
    }

    /**
     * 画面から今質的な収支についてデータ取得処理です。
     */
    private Map<RString, Decimal> get実質的な収支についてデータ() {
        Map<RString, Decimal> 実質的な収支についてデータMap = new HashMap<>();
        実質的な収支についてデータMap.put(歳入合計, 実質_歳入合計.getValue() == null ? DECIMAL_0 : 実質_歳入合計.getValue());
        実質的な収支についてデータMap.put(歳出合計, 実質_歳出合計.getValue() == null ? DECIMAL_0 : 実質_歳出合計.getValue());
        実質的な収支についてデータMap.put(歳入歳出差引残額, 実質_歳入歳出差引残額.getValue() == null ? DECIMAL_0 : 実質_歳入歳出差引残額.getValue());
        実質的な収支についてデータMap.put(精算後残額, 実質_精算後残額.getValue() == null ? DECIMAL_0 : 実質_精算後残額.getValue());
        return 実質的な収支についてデータMap;
    }

    /**
     * 画面詳細エリア入力有無の判定処理です。
     *
     * @param 前年度以前データ 前年度以前データ
     * @param 今年度データ 今年度データ
     * @param 実質的な収支についてデータ 実質的な収支についてデータ
     * @return 画面詳細エリア入力有無
     */
    public Boolean is画面詳細エリア入力有(KaigoHokenJigyoHokokuNenpo 前年度以前データ,
            KaigoHokenJigyoHokokuNenpo 今年度データ, KaigoHokenJigyoHokokuNenpo 実質的な収支についてデータ) {
        return is部分画面詳細エリア入力有(前年度以前データ)
                || is部分画面詳細エリア入力有(今年度データ)
                || is部分画面詳細エリア入力有(実質的な収支についてデータ);
    }

    /**
     * 部分画面詳細エリア入力有無の判定処理です。
     *
     * @param 部分画面詳細エリア 部分画面詳細エリア
     * @return 部分画面詳細エリア入力有無
     */
    public Boolean is部分画面詳細エリア入力有(KaigoHokenJigyoHokokuNenpo 部分画面詳細エリア) {
        if (null == 部分画面詳細エリア) {
            return false;
        }
        Map<RString, Decimal> 部分画面詳細エリアMap = 部分画面詳細エリア.get詳細データエリア();
        if (部分画面詳細エリアMap.isEmpty()) {
            return false;
        }
        for (Map.Entry<RString, Decimal> 部分画面詳細エリアMapEntry : 部分画面詳細エリアMap.entrySet()) {
            if (!DECIMAL_0.equals(部分画面詳細エリアMapEntry.getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 修正データ有無の判定処理です。
     *
     * @param 修正データLst 修正データLst
     * @return 修正データ有無
     */
    public Boolean is修正データ有(List<KaigoHokenJigyoHokokuNenpo> 修正データLst) {
        if (null == 修正データLst || 修正データLst.isEmpty()) {
            return false;
        }
        for (KaigoHokenJigyoHokokuNenpo 修正データ : 修正データLst) {
            if (!修正データ.get詳細データエリア().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 「報告年度」フォーカスロスト処理です。
     */
    public void lostFocus() {
        TextBoxDate 報告年度Box = div.getYoshikiYonnosanMeisai().getTxtHokokuYM();
        TextBoxDate 集計年度Box = div.getYoshikiYonnosanMeisai().getTxtShukeiYM();
        RDate 報告年度 = 報告年度Box.getValue();
        RString 報告年度String = 報告年度Box.getText();
        if (RDate.canConvert(報告年度String)) {
            int 報告年度Year = Integer.parseInt(報告年度String.substring(0, INT4).toString());
            if (!(null == 報告年度)) {
                set集計年度(報告年度Year, 集計年度Box);
            }
        }
    }

    private void set集計年度(int 報告年度Year, TextBoxDate 集計年度Box) {
        RDate 集計年度;
        RDate date = RDate.getNowDate();
        if (報告年度Year == date.getYearValue()) {
            集計年度 = date.getMonthValue() >= INT6 ? new RDate(date.getYearValue() - 1, date.getMonthValue(), date.getDayValue())
                    : new RDate(date.getYearValue() - 2, date.getMonthValue(), date.getDayValue());
        } else {
            集計年度 = new RDate(報告年度Year - 1, date.getMonthValue(), date.getDayValue());
        }
        集計年度Box.setValue(集計年度);
    }

    /**
     * 「報告年度を確定する」ボタンを押下すること処理です。
     *
     * @param insuranceInfEntity insuranceInfEntity
     */
    public void onClick_btnConfirm(InsuranceInformation insuranceInfEntity) {
        LasdecCode 市町村コード = get市町村コード(div.getYoshikiYonnosanMeisai().getDdlShicyoson().getSelectedKey());
        TokeiTaishoKubun 保険者区分 = get保険者区分(div.getYoshikiYonnosanMeisai().getDdlShicyoson().getSelectedKey());
        TextBoxDate 報告年度Box = div.getYoshikiYonnosanMeisai().getTxtHokokuYM();
        RDate 報告年度 = 報告年度Box.getValue();
        if (null == 報告年度) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage());
        } else {
            報告年度の確定処理(報告年度, 市町村コード, 保険者区分, 報告年度Box, insuranceInfEntity);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_追加, true);
        }
    }

    private void 報告年度の確定処理(RDate 報告年度, LasdecCode 市町村コード, TokeiTaishoKubun 保険者区分, TextBoxDate 報告年度Box,
            InsuranceInformation insuranceInfEntity) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        FlexibleYear 報告年 = new FlexibleYear(insuranceInfEntity.get報告年().toString());
        RString 集計対象年 = new RString(insuranceInfEntity.get集計対象年().toString());
        RString 統計対象区分 = insuranceInfEntity.get統計対象区分();
        List<KaigoHokenJigyoHokokuNenpo> 前年度以前データs = 介護保険特別会計経理状況登録Manager
                .getJigyoHokokuNenpoDetal(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号_0301.getColumnValue());
        List<KaigoHokenJigyoHokokuNenpo> 今年度データs = 介護保険特別会計経理状況登録Manager
                .getJigyoHokokuNenpoDetal(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号_0302.getColumnValue());
        List<KaigoHokenJigyoHokokuNenpo> 実質的な収支についてデータs = 介護保険特別会計経理状況登録Manager
                .getJigyoHokokuNenpoDetal(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号_0303.getColumnValue());
        if (前年度以前データs.isEmpty() && 今年度データs.isEmpty() && 実質的な収支についてデータs.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.該当報告年度の集計データは既に存在.getMessage());
        } else {
            報告年度Box.setReadOnly(true);
            div.getYoshikiYonnosanMeisai().getDdlShicyoson().setDisabled(true);
            div.getYoshikiYonnosanMeisai().getBtnKakutei().setDisabled(true);
            set詳細データエリア入力可否(状態1_確定);
        }
    }

    /**
     * 「保存する」ボタンを押下すること処理です。
     *
     * @param insuranceInfEntity 遷移先渡す項目
     */
    @Transaction
    public void onClick_btnSave(InsuranceInformation insuranceInfEntity) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        KaigoHokenShoriDateKanri 処理日付管理マスタ = get処理日付管理マスタ(insuranceInfEntity);
        if (内部処理モード_追加.equals(div.getShoriMode())) {
            介護保険特別会計経理状況登録Manager.insertShoriDateKanri(処理日付管理マスタ);
            div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("登録").evaluate()), RString.EMPTY, RString.EMPTY, true);
        } else if (内部処理モード_修正.equals(div.getShoriMode()) || 内部処理モード_削除.equals(div.getShoriMode())) {
            介護保険特別会計経理状況登録Manager.updateShoriDateKanri(処理日付管理マスタ);
        }
        if (内部処理モード_削除.equals(div.getShoriMode())) {
            List<Code> 集計番号list = new ArrayList<>();
            集計番号list.add(集計番号_0301);
            集計番号list.add(集計番号_0302);
            集計番号list.add(集計番号_0303);
            介護保険特別会計経理状況登録Manager.deleteJigyoHokokuNenpoData(
                    new FlexibleYear(insuranceInfEntity.get報告年().toString()),
                    new FlexibleYear(insuranceInfEntity.get集計対象年().toString()),
                    insuranceInfEntity.get統計対象区分(),
                    insuranceInfEntity.get市町村コード(),
                    insuranceInfEntity.get表番号(), 集計番号list);
            div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("削除").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
        if (内部処理モード_修正新規.equals(div.getShoriMode()) || 内部処理モード_追加.equals(div.getShoriMode())) {
            List<KaigoHokenJigyoHokokuNenpo> 前年度以前データLst = new ArrayList<>();
            List<KaigoHokenJigyoHokokuNenpo> 今年度データLst = new ArrayList<>();
            List<KaigoHokenJigyoHokokuNenpo> 実質的な収支についてデータLst = new ArrayList<>();
            KaigoHokenJigyoHokokuNenpo 画面入力前年度以前データ = get各部分画面入力データ(前年度以前データ, insuranceInfEntity);
            KaigoHokenJigyoHokokuNenpo 画面入力今年度データ = get各部分画面入力データ(今年度データ, insuranceInfEntity);
            KaigoHokenJigyoHokokuNenpo 画面入力実質的な収支についてデータ = get各部分画面入力データ(実質的な収支についてデータ, insuranceInfEntity);
            前年度以前データLst.add(画面入力前年度以前データ);
            今年度データLst.add(画面入力今年度データ);
            実質的な収支についてデータLst.add(画面入力実質的な収支についてデータ);
            介護保険特別会計経理状況登録Manager.insertJigyoHokokuNenpoData(前年度以前データLst);
            介護保険特別会計経理状況登録Manager.insertJigyoHokokuNenpoData(今年度データLst);
            介護保険特別会計経理状況登録Manager.insertJigyoHokokuNenpoData(実質的な収支についてデータLst);
            div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("更新").evaluate()), RString.EMPTY, RString.EMPTY, true);
        } else if (内部処理モード_修正.equals(div.getShoriMode())) {
            List<KaigoHokenJigyoHokokuNenpo> 修正データLst = get修正データ(insuranceInfEntity);
            介護保険特別会計経理状況登録Manager.updateJigyoHokokuNenpoData(修正データLst);
            div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("更新").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
    }

    private KaigoHokenShoriDateKanri get処理日付管理マスタ(InsuranceInformation insuranceInfEntity) {
        FlexibleYear 集計年度
                = new FlexibleYear(new RDate(div.getYoshikiYonnosanMeisai().getTxtShukeiYM().getText().toString()).getYear().toString());
        LasdecCode 市町村コード;
        if (!div.getYoshikiYonnosanMeisai().getDdlShicyoson().isDisplayNone()) {
            市町村コード = new LasdecCode(div.getYoshikiYonnosanMeisai().getDdlShicyoson().getSelectedKey());
        } else {
            市町村コード = insuranceInfEntity.get市町村コード();
        }
        KaigoHokenShoriDateKanri 処理日付管理マスタ = new KaigoHokenShoriDateKanri(SubGyomuCode.DBU介護統計報告, 市町村コード,
                JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成特別会計経理状況, DOUBLE_ZEOR, 集計年度, DOUBLE_ZEOR,
                FlexibleDate.EMPTY, RDate.getNowDateTime(), new FlexibleDate(集計年度.getYearValue(), INT4, 1),
                new FlexibleDate(集計年度.getYearValue() + 1, INT3, INT31), null, null);
        return 処理日付管理マスタ;
    }

    /**
     * 市町村のDataSource取得処理です。
     *
     * @param 市町村Lst 市町村Lst
     * @return DataSource
     */
    private List<KeyValueDataSource> getDataSourceFrom市町村Lst(List<Shichoson> 市町村Lst) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (Shichoson shichoson : 市町村Lst) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource(create市町村Key(shichoson), shichoson.get市町村名称());
            dataSource.add(keyValueDataSource);
        }
        return dataSource;
    }

    private RString create市町村Key(Shichoson shichoson) {
        return new RStringBuilder().append(shichoson.get市町村コード().getColumnValue()).append("_")
                .append(shichoson.get保険者コード().getColumnValue()).append("_").append(shichoson.get保険者区分().getコード()).toRString();
    }

    /**
     * 市町村コード取得処理です。
     *
     * @param 市町村Key 市町村Key
     * @return 市町村コード
     */
    public LasdecCode get市町村コード(RString 市町村Key) {
        if (市町村Key.split("_").size() < 1) {
            return LasdecCode.EMPTY;
        } else {
            System.out.println(市町村Key.split("_").get(0).toString());
            return new LasdecCode(市町村Key.split("_").get(0));
        }
    }

    private TokeiTaishoKubun get保険者区分(RString 市町村Key) {
        if (市町村Key.split("_").size() < INT3) {
            return TokeiTaishoKubun.空;
        } else {
            return TokeiTaishoKubun.toValue(市町村Key.split("_").get(2));
        }
    }

}
