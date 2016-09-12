/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiParameterDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 月別推移表のHandlerクラスです。
 *
 * @reamsid_L DBB-0760-010 zhangguopeng
 */
public class TsukibetsuSuiihyoSakuseiParameterHandler {

    private final TsukibetsuSuiihyoSakuseiParameterDiv div;
    private static final RString 年齢 = new RString("nenrei");
    private static final RString 生年月日 = new RString("umareYMD");
    private static final int 調定基準日_S = 0;
    private static final int 調定基準日_E = 8;

    /**
     * コンストラクタです。
     *
     * @param div 月別推移表のクラスファイル
     */
    public TsukibetsuSuiihyoSakuseiParameterHandler(TsukibetsuSuiihyoSakuseiParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onload() {
        set調定年度();
        setヘッダエリア();
        set抽出条件エリア();
        // TODO 子DIVを実装しない
//        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
//        if (市町村セキュリティ情報 != null) {
//            DonyuKeitaiCode 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
//            if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getCode())) {
//                // 状態１　初期化状態（広域保険者）
//                // 市町村==全市町村
//            } else if (DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード.getCode())
//                    || DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード.getCode())) {
//                // 状態２　初期化状態（単一保険者）
////            div.getCcdChikuShichosonSelect().
//                // 選択対象==全て
//            }
//        }
    }

    /**
     * 条件を復元するボタンを押下する場合、バッチパラメータの設定値を画面に表示する。
     */
    public void onClick_btnKogakuParamRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnParameterRestore().getRestoreBatchParameterMap();
        FlexibleYear 調定年度 = restoreBatchParameterMap.getParameterValue(FlexibleYear.class, new RString("choteiNendo"));
        if (調定年度 != null && !調定年度.isEmpty()) {
            div.getDdlChoteiNendo().setSelectedValue(new RString(調定年度.toString()));
        }
        RString 調定基準日 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("choteiKijunNichiji"));
        if (!RString.isNullOrEmpty(調定基準日)) {
            div.getTxtChoteiKijunYMD().setValue(new RDate(調定基準日.substringEmptyOnError(調定基準日_S, 調定基準日_E).toString()));
        }
        RString 各月資格基準日 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kakutukiShikakuKijunNichi"));
        if (!RString.isNullOrEmpty(各月資格基準日)) {
            div.getDdShikakuKijunD().setSelectedKey(各月資格基準日);
        }
        boolean is年齢 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("ageFlg"));
        if (is年齢) {
            div.getRadNenrei().setSelectedKey(年齢);
        }
        boolean is生年月日 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("seinengappiYMD_Flg"));
        if (is生年月日) {
            div.getRadUmareYMD().setSelectedKey(生年月日);
        }
        RString 年齢開始 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("ageStart"));
        if (!RString.isNullOrEmpty(年齢開始)) {
            div.getTxtNenreiSt().setValue(new Decimal(年齢開始.toString()));
        }
        RString 年齢終了 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("ageEnd"));
        if (!RString.isNullOrEmpty(年齢終了)) {
            div.getTxtNenreiEd().setValue(new Decimal(年齢終了.toString()));
        }
        FlexibleDate 年齢基準日 = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("ageKijunNi"));
        if (年齢基準日 != null && !年齢基準日.isEmpty()) {
            div.getTxtNenreiKijunYMD().setValue(new RDate(年齢基準日.toString()));
        }
        RString 生年月日開始 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("seinengappiYMDStart"));
        if (!RString.isNullOrEmpty(生年月日開始)) {
            div.getTxtUmareSt().setValue(new RDate(生年月日開始.toString()));
        }
        RString 生年月日終了 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("seinengappiYMDEnd"));
        if (!RString.isNullOrEmpty(生年月日終了)) {
            div.getTxtUmareEd().setValue(new RDate(生年月日終了.toString()));
        }
        // TODO 介護地区・市町村選択DIVを実装無し、この項目設定無し、
    }

    /**
     * バッチパラメータを作成します。
     *
     * @return CreateTsukibetsuSuiihyoBatchParameter 月別推移表作成_バッチ用のパラメータ
     */
    public CreateTsukibetsuSuiihyoBatchParameter batchParameter() {

        FlexibleYear 調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedValue());
        RStringBuilder 調定基準日 = new RStringBuilder();
        調定基準日.append(div.getTxtChoteiKijunYMD().getValue());
        調定基準日.append(new RString("23:59:59"));
        boolean is年齢 = false;
        boolean is生年月日 = false;
        if (年齢.equals(div.getRadNenrei().getSelectedKey())) {
            is年齢 = true;
        }
        if (生年月日.equals(div.getRadUmareYMD().getSelectedKey())) {
            is生年月日 = true;
        }
        // TODO 介護地区・市町村選択共有子Divを呼び出す
        return new CreateTsukibetsuSuiihyoBatchParameter(調定年度, 調定基準日.toRString(), div.getDdShikakuKijunD().getSelectedKey(), is年齢, nullToEmpty(div.getTxtNenreiSt().getValue()),
                nullToEmpty(div.getTxtNenreiEd().getValue()), nullToEmpty(div.getTxtNenreiKijunYMD().getValue()), is生年月日,
                nullToEmpt(div.getTxtUmareSt().getValue()), nullToEmpt(div.getTxtUmareEd().getValue()),
                RString.EMPTY, null, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    private RString nullToEmpty(Decimal 年齢) {
        if (年齢 != null) {
            return new RString(年齢.toString());
        }
        return RString.EMPTY;
    }

    private FlexibleDate nullToEmpty(RDate 日期) {
        if (日期 != null) {
            return new FlexibleDate(日期.toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private RString nullToEmpt(RDate 日期) {
        if (日期 != null) {
            return 日期.toDateString();
        }
        return RString.EMPTY;
    }

    private void setヘッダエリア() {
        RDate 適用基準日 = RDate.getNowDate();
        div.getDdlChoteiNendo().setSelectedValue((DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, 適用基準日, SubGyomuCode.DBB介護賦課)));
        div.getTxtChoteiKijunYMD().setValue(RDate.getNowDate());
    }

    private void set抽出条件エリア() {
        set各月資格基準日();
        div.getRadNenrei().setSelectedKey(年齢);
        div.getTxtUmareSt().setDisabled(true);
        div.getTxtUmareEd().setDisabled(true);

    }

    private void set調定年度() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        RDate 適用基準日 = RDate.getNowDate();
        RString 日付関連_調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 日付関連_当初年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_当初年度, 適用基準日, SubGyomuCode.DBB介護賦課);
        int 調定年度 = Integer.parseInt(日付関連_調定年度.toString());
        int 当初年度 = Integer.parseInt(日付関連_当初年度.toString());
        for (int i = 当初年度; i <= 調定年度; i++) {
            KeyValueDataSource 調定年度Key = new KeyValueDataSource();
            調定年度Key.setKey(new RString(i));
            調定年度Key.setValue(new RString(i));
            dataSourceList.add(調定年度Key);
        }
        Collections.sort(dataSourceList, new DateComparator());
        div.getDdlChoteiNendo().setDataSource(dataSourceList);
    }

    private void set各月資格基準日() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (int i = 1; i <= RDate.getNowDate().getLastDay(); i++) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(i));
            dataSource.setValue(new RString(i));
            dataSourceList.add(dataSource);
        }
        div.getDdShikakuKijunD().setDataSource(dataSourceList);
        div.getDdShikakuKijunD().setSelectedKey(new RString(RDate.getNowDate().getDayValue()));
    }

    private static class DateComparator implements Comparator<KeyValueDataSource>, Serializable {

        @Override
        public int compare(KeyValueDataSource o1, KeyValueDataSource o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    }
}
