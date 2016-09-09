/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6000011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.business.core.hihokenshashikakuteisei.SukejuruRirekiJohoListEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.config.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.ScheduleSettingDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.dgDataSofu_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.dgDataTorikomi_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbc.service.core.hihokenshashikakuteisei.HihokenshaShikakuTeisei;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ScheduleSettingHandler_国保連連携スケジュール設定のHandlerクラスです。
 *
 * @reamsid_L DBC-2930-010 liuxiaoyu
 */
public class ScheduleSettingHandler {

    private final ScheduleSettingDiv div;
    private final HihokenshaShikakuTeisei hihokenshaShikakuTeisei;
    private final KokuhorenInterfaceKanriManager manger;
    private static final RString メニューID_DBCMNH1001 = new RString("DBCMNH1001");
    private static final RString 保存しないで戻る = new RString("btnComplete");
    private static final RString 再処理前 = new RString("再処理前");
    private static final RString 送付取込区分_送付 = new RString("1");
    private static final RString 送付取込区分_取込 = new RString("2");
    private static final RString 再処理不可 = new RString("1");
    private static final RString 国保連送付 = new RString("国保連送付");
    private static final RString 国保連取込 = new RString("国保連取込");
    private static final RString 処理名称 = new RString("処理名称");
    private static final RString アンダーライン = new RString("_");
    private static final RString KEY空白 = new RString("blank");

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public ScheduleSettingHandler(ScheduleSettingDiv div) {
        this.div = div;
        this.hihokenshaShikakuTeisei = InstanceProvider.create(HihokenshaShikakuTeisei.class);
        this.manger = InstanceProvider.create(KokuhorenInterfaceKanriManager.class);
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     *
     * @return IdoReanrakuhyoEraTeiseiHandler
     */
    public static ScheduleSettingHandler of(ScheduleSettingDiv div) {
        return new ScheduleSettingHandler(div);
    }

    /**
     * 画面初期化
     *
     * @param menuID RString
     *
     * @return SukejuruRirekiJohoListEntity
     */
    public SukejuruRirekiJohoListEntity onLoad(RString menuID) {
        if (メニューID_DBCMNH1001.equals(menuID)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存しないで戻る, true);
        }
        //TODO QA1148
        SukejuruRirekiJohoListEntity 履歴情報初期 = hihokenshaShikakuTeisei.getSukejuruRirekiShokiJoho();
        スケジュール履歴情報処理(履歴情報初期);
        return 履歴情報初期;

    }

    /**
     * 「表示」ボタンを押下する。
     *
     * @param 処理年月 FlexibleYearMonth
     */
    public void 画面表示(FlexibleYearMonth 処理年月) {
        SukejuruRirekiJohoListEntity 履歴情報 = hihokenshaShikakuTeisei.getSukejuruRirekiJoho(処理年月);
        スケジュール履歴情報処理(履歴情報);
    }

    /**
     * 「保存する」ボタンを押下する。
     *
     * @param スケジュール履歴情報 SukejuruRirekiJohoListEntity
     *
     */
    public void 保存処理(SukejuruRirekiJohoListEntity スケジュール履歴情報) {
        if (div.getTxtShoriNengetsu().getValue() == null) {
            return;
        }
        List<KokuhorenInterfaceKanri> 送付List = スケジュール履歴情報.getスケジュール履歴情報_送付List();
        List<KokuhorenInterfaceKanri> 取込List = スケジュール履歴情報.getスケジュール履歴情報_取込List();
        List<dgDataSofu_Row> sList = div.getDgDataSofu().getDataSource();
        List<dgDataTorikomi_Row> tList = div.getDgDataTorikomi().getDataSource();
        List<RString> 送付の交換情報識別番号List = new ArrayList<>();
        List<RString> 取込の交換情報識別番号List = new ArrayList<>();
        Map<RString, KokuhorenInterfaceKanri> 送付Map = new HashMap<>();
        Map<RString, KokuhorenInterfaceKanri> 取込Map = new HashMap<>();
        FlexibleYearMonth 処理年月 = new FlexibleYearMonth(div.getTxtShoriNengetsu().getValue().getYearMonth().toDateString());
        RString 交換情報識別番号;
        KokuhorenInterfaceKanri 国保連インターフェース管理;
        RString 画面_処理状況;
        RString 再処理設定不可区分;
        ShoriJotaiKubun 処理状態区分;

        for (KokuhorenInterfaceKanri kokuhorenInterfaceKanri : 送付List) {
            交換情報識別番号 = kokuhorenInterfaceKanri.get交換情報識別番号();
            送付の交換情報識別番号List.add(交換情報識別番号);
            送付Map.put(交換情報識別番号, kokuhorenInterfaceKanri);
        }
        for (KokuhorenInterfaceKanri kokuhorenInterfaceKanri : 取込List) {
            交換情報識別番号 = kokuhorenInterfaceKanri.get交換情報識別番号();
            取込の交換情報識別番号List.add(交換情報識別番号);
            取込Map.put(交換情報識別番号, kokuhorenInterfaceKanri);
        }

        for (dgDataSofu_Row sofuRow : sList) {
            画面_処理状況 = sofuRow.getTxtSofuShoriJokyo().getSelectedValue();
            if (RString.EMPTY.equals(画面_処理状況)) {
                continue;
            }
            交換情報識別番号 = sofuRow.getTxtKokanJohoSikibetsuBango();
            処理状態区分 = ShoriJotaiKubun.valueOf(画面_処理状況.toString());
            if (送付の交換情報識別番号List.contains(交換情報識別番号)) {
                国保連インターフェース管理 = 送付Map.get(交換情報識別番号);
                国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit()
                        .set処理状態区分(処理状態区分.getコード())
                        .set再処理可能区分(再処理前.equals(画面_処理状況))
                        .build();
                国保連インターフェース管理 = 国保連インターフェース管理.modified();
                manger.save(国保連インターフェース管理);
            } else {
                再処理設定不可区分 = DbBusinessConfig.get(
                        ConfigKeysKokuhorenSofu.toValue(交換情報識別番号),
                        RDate.getNowDate(),
                        SubGyomuCode.DBC介護給付);
                国保連インターフェース管理 = new KokuhorenInterfaceKanri(処理年月, 交換情報識別番号);
                国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit()
                        .set処理年月(処理年月)
                        .set交換情報識別番号(交換情報識別番号)
                        .set送付取込区分(送付取込区分_送付)
                        .set処理状態区分(処理状態区分.getコード())
                        .set再処理可能区分(再処理前.equals(画面_処理状況))
                        .set再処理設定不可区分(再処理不可.equals(再処理設定不可区分))
                        .build();
                国保連インターフェース管理 = 国保連インターフェース管理.added();
                manger.save(国保連インターフェース管理);
            }
        }
        for (dgDataTorikomi_Row torikomiRow : tList) {
            交換情報識別番号 = torikomiRow.getTxtKokanJohoSikibetsuBango();
            画面_処理状況 = torikomiRow.getTxtTorikomiShoriJokyo().getSelectedValue();
            if (RString.EMPTY.equals(画面_処理状況)) {
                continue;
            }
            処理状態区分 = ShoriJotaiKubun.valueOf(画面_処理状況.toString());
            if (取込の交換情報識別番号List.contains(交換情報識別番号)) {
                国保連インターフェース管理 = 取込Map.get(交換情報識別番号);
                国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit()
                        .set処理状態区分(処理状態区分.getコード())
                        .set再処理可能区分(再処理前.equals(画面_処理状況))
                        .build();
                国保連インターフェース管理 = 国保連インターフェース管理.modified();
                manger.save(国保連インターフェース管理);
            } else {
                再処理設定不可区分 = DbBusinessConfig.get(
                        ConfigKeysKokuhorenTorikomi.toValue(交換情報識別番号),
                        RDate.getNowDate(),
                        SubGyomuCode.DBC介護給付);
                国保連インターフェース管理 = new KokuhorenInterfaceKanri(処理年月, 交換情報識別番号);
                国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit()
                        .set処理年月(処理年月)
                        .set交換情報識別番号(交換情報識別番号)
                        .set送付取込区分(送付取込区分_取込)
                        .set処理状態区分(処理状態区分.getコード())
                        .set再処理可能区分(再処理前.equals(画面_処理状況))
                        .set再処理設定不可区分(再処理不可.equals(再処理設定不可区分))
                        .build();
                国保連インターフェース管理 = 国保連インターフェース管理.added();
                manger.save(国保連インターフェース管理);
            }
        }
    }

    private void スケジュール履歴情報処理(SukejuruRirekiJohoListEntity 履歴情報) {
        List<KokuhorenInterfaceKanri> 送付List = 履歴情報.getスケジュール履歴情報_送付List();
        List<KokuhorenInterfaceKanri> 取込List = 履歴情報.getスケジュール履歴情報_取込List();
        List<KeyValueDataSource> 初期状態dataSource = new ArrayList<>();
        List<KeyValueDataSource> 追加状態dataSource = new ArrayList<>();
        KeyValueDataSource keyValue;
        keyValue = new KeyValueDataSource();
        keyValue.setKey(KEY空白);
        keyValue.setValue(RString.EMPTY);
        初期状態dataSource.add(keyValue);
        追加状態dataSource.add(keyValue);
        for (ShoriJotaiKubun 処理状態区分 : ShoriJotaiKubun.values()) {
            keyValue = new KeyValueDataSource();
            keyValue.setKey(処理状態区分.getコード());
            keyValue.setValue(処理状態区分.get名称());
            初期状態dataSource.add(keyValue);
        }
        keyValue = new KeyValueDataSource();
        keyValue.setKey(ShoriJotaiKubun.処理前.getコード());
        keyValue.setValue(ShoriJotaiKubun.処理前.get名称());
        追加状態dataSource.add(keyValue);
        keyValue = new KeyValueDataSource();
        keyValue.setKey(ShoriJotaiKubun.処理なし.getコード());
        keyValue.setValue(ShoriJotaiKubun.処理なし.get名称());
        追加状態dataSource.add(keyValue);
        dgDataSofu_Row sofuRow;
        List<dgDataSofu_Row> sList = new ArrayList<>();
        dgDataTorikomi_Row toriRow;
        List<dgDataTorikomi_Row> tList = new ArrayList<>();
        YMDHMS 送付処理実施日時;
        RString 送付交換情報識別番号;

        for (ConfigKeysKokuhorenSofu 交換識別番号 : ConfigKeysKokuhorenSofu.values()) {
            sofuRow = new dgDataSofu_Row();
            sofuRow.setTxtSofuShoriMei(
                    国保連送付.concat(アンダーライン).concat(交換識別番号.get名称()).concat(アンダーライン).concat(処理名称));
            for (KokuhorenInterfaceKanri kokuhorenInterfaceKanri : 送付List) {
                送付交換情報識別番号 = kokuhorenInterfaceKanri.get交換情報識別番号();
                if (交換識別番号.getコード().equals(送付交換情報識別番号)) {
                    送付処理実施日時 = kokuhorenInterfaceKanri.get処理実施日時();
                    sofuRow.getTxtSofuShoriJokyo().setDataSource(初期状態dataSource);
                    sofuRow.getTxtSofuShoriJokyo().setSelectedValue(
                            ShoriJotaiKubun.toValue(kokuhorenInterfaceKanri.get処理状態区分()).get名称());
                    sofuRow.getTxtSofuShoribi().setValue(送付処理実施日時 == null ? null : 送付処理実施日時.getDate());
                    sofuRow.setTxtSofuChushutsuKaishiNitiji(
                            kokuhorenInterfaceKanri.get抽出開始日時() == null || kokuhorenInterfaceKanri.get抽出開始日時().isEmpty()
                            ? RString.EMPTY : kokuhorenInterfaceKanri.get抽出開始日時().getDate().getYearMonth().toDateString());
                    sofuRow.setTxtSofuChushutsuShuryoNitiji(
                            kokuhorenInterfaceKanri.get抽出終了日時() == null || kokuhorenInterfaceKanri.get抽出終了日時().isEmpty()
                            ? RString.EMPTY : kokuhorenInterfaceKanri.get抽出終了日時().getDate().getYearMonth().toDateString());
                    break;
                }
            }
            if (sofuRow.getTxtSofuShoriJokyo().getDataSource() == null || sofuRow.getTxtSofuShoriJokyo().getDataSource().isEmpty()) {
                sofuRow.getTxtSofuShoriJokyo().setDataSource(追加状態dataSource);
            }
            sofuRow.setTxtKokanJohoSikibetsuBango(交換識別番号.getコード());
            sList.add(sofuRow);
        }

        RString 取込交換情報識別番号;
        YMDHMS 取込処理実施日時;
        for (ConfigKeysKokuhorenTorikomi 交換識別番号 : ConfigKeysKokuhorenTorikomi.values()) {
            toriRow = new dgDataTorikomi_Row();
            toriRow.setTxtTorikomiShorimei(
                    国保連取込.concat(アンダーライン).concat(交換識別番号.get名称()).concat(アンダーライン).concat(処理名称));
            for (KokuhorenInterfaceKanri kokuhorenInterfaceKanri : 取込List) {
                取込交換情報識別番号 = kokuhorenInterfaceKanri.get交換情報識別番号();
                if (交換識別番号.getコード().equals(取込交換情報識別番号)) {
                    取込処理実施日時 = kokuhorenInterfaceKanri.get処理実施日時();
                    toriRow.getTxtTorikomiShoriJokyo().setDataSource(初期状態dataSource);
                    toriRow.getTxtTorikomiShoriJokyo().setSelectedValue(
                            ShoriJotaiKubun.toValue(kokuhorenInterfaceKanri.get処理状態区分()).get名称());
                    toriRow.getTxtTorikomiShoribi().setValue(取込処理実施日時 == null ? null : 取込処理実施日時.getDate());
                    break;
                }
            }
            if (toriRow.getTxtTorikomiShoriJokyo().getDataSource() == null
                    || toriRow.getTxtTorikomiShoriJokyo().getDataSource().isEmpty()) {
                toriRow.getTxtTorikomiShoriJokyo().setDataSource(追加状態dataSource);
            }
            toriRow.setTxtKokanJohoSikibetsuBango(交換識別番号.getコード());
            tList.add(toriRow);
        }
        div.getDgDataSofu().setDataSource(sList);
        div.getDgDataTorikomi().setDataSource(tList);
    }
}
