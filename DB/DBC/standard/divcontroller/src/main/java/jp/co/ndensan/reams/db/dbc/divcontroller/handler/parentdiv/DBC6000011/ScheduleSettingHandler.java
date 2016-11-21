/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6000011;

import java.util.ArrayList;
import java.util.Collections;
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
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
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
    private static final RString 再処理前 = new RString("再処理前");
    private static final RString 送付取込区分_送付 = new RString("1");
    private static final RString 送付取込区分_取込 = new RString("2");
    private static final RString ダッシュ = new RString("－");
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int SIZE_ONE = 1;
    private static final RString RSTRING_ZERO = new RString("0");
    private static final RString KEY空白 = new RString("blank");
    private static final RString 受託あり = new RString("2");
    private static final RString 処理なし = new RString("処理なし");
    private static final RString 処理前 = new RString("処理前");

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
     * @return SukejuruRirekiJohoListEntity
     */
    public SukejuruRirekiJohoListEntity onLoad() {
        SukejuruRirekiJohoListEntity 履歴情報初期 = hihokenshaShikakuTeisei.getSukejuruRirekiShokiJoho();
        スケジュール履歴情報処理(履歴情報初期);
        if (履歴情報初期.getスケジュール履歴情報_送付List().isEmpty()) {
            div.getTxtShoriNengetsu().setValue(RDate.getNowDate());
            div.getBtnDisplay().setDisabled(true);
        } else {
            RDate 処理年月 = new RDate(履歴情報初期.getスケジュール履歴情報_送付List().get(0).get処理年月().toString());
            div.getTxtHyojiTaishoNengetsu().setValue(処理年月);
            div.getTxtShoriNengetsu().setValue(処理年月);
        }
        return 履歴情報初期;
        
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
        Map<RString, KokuhorenInterfaceKanri> 送付Map = new HashMap<>();
        Map<RString, KokuhorenInterfaceKanri> 取込Map = new HashMap<>();
        FlexibleYearMonth 処理年月 = new FlexibleYearMonth(div.getTxtShoriNengetsu().getValue().getYearMonth().toDateString());
        RString 交換情報識別番号;
        KokuhorenInterfaceKanri 国保連インターフェース管理;
        RString 画面_処理状況;
        ShoriJotaiKubun 処理状態区分;
        
        for (KokuhorenInterfaceKanri kokuhorenInterfaceKanri : 送付List) {
            交換情報識別番号 = kokuhorenInterfaceKanri.get交換情報識別番号();
            送付Map.put(交換情報識別番号, kokuhorenInterfaceKanri);
        }
        for (KokuhorenInterfaceKanri kokuhorenInterfaceKanri : 取込List) {
            交換情報識別番号 = kokuhorenInterfaceKanri.get交換情報識別番号();
            取込Map.put(交換情報識別番号, kokuhorenInterfaceKanri);
        }
        
        if (送付List.isEmpty()) {
            for (dgDataSofu_Row sofuRow : sList) {
                画面_処理状況 = sofuRow.getTxtSofuShoriJokyo().getSelectedValue();
                if (RString.EMPTY.equals(画面_処理状況)) {
                    continue;
                }
                交換情報識別番号 = sofuRow.getTxtKokanJohoSikibetsuBango();
                処理状態区分 = ShoriJotaiKubun.valueOf(画面_処理状況.toString());
                国保連インターフェース管理 = new KokuhorenInterfaceKanri(処理年月, 交換情報識別番号);
                国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit()
                        .set処理年月(処理年月)
                        .set交換情報識別番号(交換情報識別番号)
                        .set送付取込区分(送付取込区分_送付)
                        .set処理状態区分(処理状態区分.getコード())
                        .set処理実施日時(new YMDHMS(RString.EMPTY))
                        .set抽出開始日時(new YMDHMS(RString.EMPTY))
                        .set抽出終了日時(new YMDHMS(RString.EMPTY))
                        .set再処理可能区分(再処理前.equals(画面_処理状況))
                        .set処理実行回数(Decimal.ZERO)
                        .setファイル名称１(RString.EMPTY)
                        .setファイル名称２(RString.EMPTY)
                        .setファイル名称３(RString.EMPTY)
                        .setファイル名称４(RString.EMPTY)
                        .setファイル名称５(RString.EMPTY)
                        .set再処理設定不可区分(false)
                        .setコントロール上処理年月(new FlexibleYearMonth(RString.EMPTY))
                        .set過誤コントロール上処理年月(new FlexibleYearMonth(RString.EMPTY))
                        .set実績データ上審査年月(new FlexibleYearMonth(RString.EMPTY))
                        .build();
                国保連インターフェース管理 = 国保連インターフェース管理.added();
                manger.save(国保連インターフェース管理);
            }
        } else {
            for (dgDataSofu_Row sofuRow : sList) {
                画面_処理状況 = sofuRow.getTxtSofuShoriJokyo().getSelectedValue();
                if (RString.EMPTY.equals(画面_処理状況)) {
                    continue;
                }
                交換情報識別番号 = sofuRow.getTxtKokanJohoSikibetsuBango();
                処理状態区分 = ShoriJotaiKubun.valueOf(画面_処理状況.toString());
                国保連インターフェース管理 = 送付Map.get(交換情報識別番号);
                国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit()
                        .set処理状態区分(処理状態区分.getコード())
                        .set再処理可能区分(再処理前.equals(画面_処理状況))
                        .build();
                国保連インターフェース管理 = 国保連インターフェース管理.modified();
                manger.save(国保連インターフェース管理);
            }
            
        }
        if (取込List.isEmpty()) {
            for (dgDataTorikomi_Row toriRow : tList) {
                画面_処理状況 = toriRow.getTxtTorikomiShoriJokyo().getSelectedValue();
                if (RString.EMPTY.equals(画面_処理状況)) {
                    continue;
                }
                交換情報識別番号 = toriRow.getTxtKokanJohoSikibetsuBango();
                処理状態区分 = ShoriJotaiKubun.valueOf(画面_処理状況.toString());
                国保連インターフェース管理 = new KokuhorenInterfaceKanri(処理年月, 交換情報識別番号);
                国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit()
                        .set処理年月(処理年月)
                        .set交換情報識別番号(交換情報識別番号)
                        .set送付取込区分(送付取込区分_取込)
                        .set処理状態区分(処理状態区分.getコード())
                        .set処理実施日時(new YMDHMS(RString.EMPTY))
                        .set抽出開始日時(new YMDHMS(RString.EMPTY))
                        .set抽出終了日時(new YMDHMS(RString.EMPTY))
                        .set再処理可能区分(再処理前.equals(画面_処理状況))
                        .set処理実行回数(Decimal.ZERO)
                        .setファイル名称１(RString.EMPTY)
                        .setファイル名称２(RString.EMPTY)
                        .setファイル名称３(RString.EMPTY)
                        .setファイル名称４(RString.EMPTY)
                        .setファイル名称５(RString.EMPTY)
                        .set再処理設定不可区分(false)
                        .setコントロール上処理年月(new FlexibleYearMonth(RString.EMPTY))
                        .set過誤コントロール上処理年月(new FlexibleYearMonth(RString.EMPTY))
                        .set実績データ上審査年月(new FlexibleYearMonth(RString.EMPTY))
                        .build();
                国保連インターフェース管理 = 国保連インターフェース管理.added();
                manger.save(国保連インターフェース管理);
            }
        } else {
            for (dgDataTorikomi_Row toriRow : tList) {
                画面_処理状況 = toriRow.getTxtTorikomiShoriJokyo().getSelectedValue();
                if (RString.EMPTY.equals(画面_処理状況)) {
                    continue;
                }
                交換情報識別番号 = toriRow.getTxtKokanJohoSikibetsuBango();
                処理状態区分 = ShoriJotaiKubun.valueOf(画面_処理状況.toString());
                国保連インターフェース管理 = 取込Map.get(交換情報識別番号);
                国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit()
                        .set処理状態区分(処理状態区分.getコード())
                        .set再処理可能区分(再処理前.equals(画面_処理状況))
                        .build();
                国保連インターフェース管理 = 国保連インターフェース管理.modified();
                manger.save(国保連インターフェース管理);
            }
        }
    }
    
    private void スケジュール履歴情報処理(SukejuruRirekiJohoListEntity 履歴情報) {
        List<KokuhorenInterfaceKanri> 送付List = 履歴情報.getスケジュール履歴情報_送付List();
        List<KokuhorenInterfaceKanri> 取込List = 履歴情報.getスケジュール履歴情報_取込List();
        List<dgDataSofu_Row> sList = スケジュール履歴情報処理_送付(送付List);
        List<dgDataTorikomi_Row> tList = スケジュール履歴情報処理_取込(取込List);
        div.getDgDataSofu().setDataSource(sList);
        div.getDgDataTorikomi().setDataSource(tList);
    }

    /**
     * スケジュール履歴情報処理 送付
     *
     * @param 送付List List<KokuhorenInterfaceKanri>
     *
     * @return List<dgDataSofu_Row>
     */
    // CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 1 LINES
    public List<dgDataSofu_Row> スケジュール履歴情報処理_送付(List<KokuhorenInterfaceKanri> 送付List) {
        List<KeyValueDataSource> 追加状態dataSource = new ArrayList<>();
        追加状態dataSource.add(new KeyValueDataSource(KEY空白, RString.EMPTY));
        追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理なし.getコード(), ShoriJotaiKubun.処理なし.get名称()));
        追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理前.getコード(), ShoriJotaiKubun.処理前.get名称()));
        List<RString> 送付表示順ソートList = new ArrayList<>();
        RString 送付表示順_CODE;
        RString 一覧表示順;
        for (ConfigKeysKokuhorenSofu 交換識別番号 : ConfigKeysKokuhorenSofu.values()) {
            一覧表示順 = 交換識別番号.get一覧表示順();
            if (SIZE_ONE == 一覧表示順.length()) {
                一覧表示順 = RSTRING_ZERO.concat(一覧表示順);
            }
            送付表示順_CODE = 一覧表示順.concat(ダッシュ).concat(交換識別番号.getコード());
            送付表示順ソートList.add(送付表示順_CODE);
        }
        Collections.sort(送付表示順ソートList);
        dgDataSofu_Row sofuRow;
        List<dgDataSofu_Row> sList = new ArrayList<>();
        YMDHMS 送付処理実施日時;
        ConfigKeysKokuhorenSofu 送付交換情報識別番号;
        RString 識別番号;
        RString 国保連共同処理受託区分_償還 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 国保連共同処理受託区分_高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 処理開始年月 = DbBusinessConfig.get(ConfigNameDBC.国保連高額合算運用_後期国保個別処理開始年月,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (送付List.isEmpty()) {
            for (RString 表示順_CODE : 送付表示順ソートList) {
                識別番号 = 表示順_CODE.split(ダッシュ.toString()).get(INDEX_ONE);
                送付交換情報識別番号 = ConfigKeysKokuhorenSofu.toValue(識別番号);
                if (!送付交換情報識別番号.isスケジュール設定有無()) {
                    continue;
                }
                if (ConfigKeysKokuhorenSofu.償還連絡票情報.getコード().equals(識別番号) && 受託あり.equals(国保連共同処理受託区分_償還)) {
                    continue;
                }
                if (ConfigKeysKokuhorenSofu.高額介護サービス費給付判定結果情報.getコード().equals(識別番号)
                        && 受託あり.equals(国保連共同処理受託区分_高額)) {
                    continue;
                }
                if (ConfigKeysKokuhorenSofu.高額合算補正済自己負担額情報.getコード().equals(識別番号)
                        && (RString.EMPTY.equals(処理開始年月) || RDate.getNowDate().isBefore(new RDate(処理開始年月.toString())))) {
                    continue;
                } else if ((ConfigKeysKokuhorenSofu.高額合算補正済自己負担額情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenSofu.高額合算補正済自己負担額情報_後期分.getコード().equals(識別番号))
                        && (!RString.EMPTY.equals(処理開始年月) && !RDate.getNowDate().isBefore(new RDate(処理開始年月.toString())))) {
                    continue;
                }
                sofuRow = new dgDataSofu_Row();
                sofuRow.setTxtSofuShoriMei(送付交換情報識別番号.get名称());
                sofuRow.getTxtSofuShoriJokyo().setDataSource(追加状態dataSource);
                sofuRow.setTxtKokanJohoSikibetsuBango(送付交換情報識別番号.getコード());
                sList.add(sofuRow);
            }
        } else {
            Map<RString, KokuhorenInterfaceKanri> 送付Map = new HashMap<>();
            for (KokuhorenInterfaceKanri entity : 送付List) {
                送付Map.put(entity.get交換情報識別番号(), entity);
            }
            for (RString 表示順_CODE : 送付表示順ソートList) {
                識別番号 = 表示順_CODE.split(ダッシュ.toString()).get(INDEX_ONE);
                if (!送付Map.containsKey(識別番号)) {
                    continue;
                }
                KokuhorenInterfaceKanri entity = 送付Map.get(識別番号);
                送付交換情報識別番号 = ConfigKeysKokuhorenSofu.toValue(識別番号);
                if (!送付交換情報識別番号.isスケジュール設定有無()) {
                    continue;
                }
                if (ConfigKeysKokuhorenSofu.償還連絡票情報.getコード().equals(識別番号)
                        && 受託あり.equals(国保連共同処理受託区分_償還)) {
                    continue;
                }
                if (ConfigKeysKokuhorenSofu.高額介護サービス費給付判定結果情報.getコード().equals(識別番号)
                        && 受託あり.equals(国保連共同処理受託区分_高額)) {
                    continue;
                }
                if (ConfigKeysKokuhorenSofu.高額合算補正済自己負担額情報.getコード().equals(識別番号)
                        && (RString.EMPTY.equals(処理開始年月)
                        || 送付List.get(INDEX_ZERO).get処理年月().isBefore(new FlexibleYearMonth(処理開始年月)))) {
                    continue;
                } else if ((ConfigKeysKokuhorenSofu.高額合算補正済自己負担額情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenSofu.高額合算補正済自己負担額情報_後期分.getコード().equals(識別番号))
                        && (!RString.EMPTY.equals(処理開始年月)
                        && !送付List.get(INDEX_ZERO).get処理年月().isBefore(new FlexibleYearMonth(処理開始年月)))) {
                    continue;
                }
                送付処理実施日時 = entity.get処理実施日時();
                sofuRow = new dgDataSofu_Row();
                sofuRow.setTxtSofuShoriMei(送付交換情報識別番号.get名称());
                sofuRow.getTxtSofuShoriJokyo().setDataSource(get初期状態dataSource(entity.get処理状態区分()));
                sofuRow.getTxtSofuShoriJokyo().setSelectedValue(ShoriJotaiKubun.toValue(entity.get処理状態区分()).get名称());
                sofuRow.getTxtSofuShoribi().setValue(送付処理実施日時 == null || 送付処理実施日時.isEmpty() ? null : 送付処理実施日時.getDate());
                sofuRow.setTxtSofuChushutsuKaishiNitiji(
                        entity.get抽出開始日時() == null || entity.get抽出開始日時().isEmpty()
                        ? RString.EMPTY : entity.get抽出開始日時().getDate().getYearMonth().toDateString());
                sofuRow.setTxtSofuChushutsuShuryoNitiji(
                        entity.get抽出終了日時() == null || entity.get抽出終了日時().isEmpty()
                        ? RString.EMPTY : entity.get抽出終了日時().getDate().getYearMonth().toDateString());
                sofuRow.setTxtKokanJohoSikibetsuBango(送付交換情報識別番号.getコード());
                sList.add(sofuRow);
            }
        }
        return sList;
    }
    
    private List<KeyValueDataSource> get初期状態dataSource(RString 処理状態区分) {
        List<KeyValueDataSource> 追加状態dataSource = new ArrayList<>();
        追加状態dataSource.add(new KeyValueDataSource(KEY空白, RString.EMPTY));
        if (ShoriJotaiKubun.処理前.getコード().equals(処理状態区分)) {
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理前.getコード(), ShoriJotaiKubun.処理前.get名称()));
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理なし.getコード(), ShoriJotaiKubun.処理なし.get名称()));
        } else if (ShoriJotaiKubun.起動.getコード().equals(処理状態区分)) {
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理なし.getコード(), ShoriJotaiKubun.処理なし.get名称()));
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.再処理前.getコード(), ShoriJotaiKubun.再処理前.get名称()));
        } else if (ShoriJotaiKubun.終了.getコード().equals(処理状態区分)) {
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.終了.getコード(), ShoriJotaiKubun.終了.get名称()));
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.再処理前.getコード(), ShoriJotaiKubun.再処理前.get名称()));
        } else if (ShoriJotaiKubun.処理なし.getコード().equals(処理状態区分)) {
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理前.getコード(), ShoriJotaiKubun.処理前.get名称()));
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理なし.getコード(), ShoriJotaiKubun.処理なし.get名称()));
        } else if (ShoriJotaiKubun.再処理前.getコード().equals(処理状態区分)) {
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.終了.getコード(), ShoriJotaiKubun.終了.get名称()));
            追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.再処理前.getコード(), ShoriJotaiKubun.再処理前.get名称()));
        }
        
        return 追加状態dataSource;
    }

    /**
     * スケジュール履歴情報処理 取込
     *
     * @param 取込List List<KokuhorenInterfaceKanri>
     *
     * @return List<dgDataTorikomi_Row>
     */
    // CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 1 LINES
    public List<dgDataTorikomi_Row> スケジュール履歴情報処理_取込(List<KokuhorenInterfaceKanri> 取込List) {
        List<KeyValueDataSource> 追加状態dataSource = new ArrayList<>();
        追加状態dataSource.add(new KeyValueDataSource(KEY空白, RString.EMPTY));
        追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理なし.getコード(), ShoriJotaiKubun.処理なし.get名称()));
        追加状態dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理前.getコード(), ShoriJotaiKubun.処理前.get名称()));
        List<RString> 取込表示順ソートList = new ArrayList<>();
        RString 取込表示順_CODE;
        RString 一覧表示順;
        for (ConfigKeysKokuhorenTorikomi 交換識別番号 : ConfigKeysKokuhorenTorikomi.values()) {
            一覧表示順 = 交換識別番号.get一覧表示順();
            if (SIZE_ONE == 一覧表示順.length()) {
                一覧表示順 = RSTRING_ZERO.concat(一覧表示順);
            }
            取込表示順_CODE = 一覧表示順.concat(ダッシュ).concat(交換識別番号.getコード());
            取込表示順ソートList.add(取込表示順_CODE);
        }
        Collections.sort(取込表示順ソートList);
        dgDataTorikomi_Row toriRow;
        List<dgDataTorikomi_Row> tList = new ArrayList<>();
        RString 識別番号;
        RString 国保連共同処理受託区分_償還 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 国保連共同処理受託区分_高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 処理開始年月 = DbBusinessConfig.get(ConfigNameDBC.国保連高額合算運用_後期国保個別処理開始年月,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        ConfigKeysKokuhorenTorikomi 取込交換情報識別番号;
        YMDHMS 取込処理実施日時;
        if (取込List.isEmpty()) {
            for (RString 表示順_CODE : 取込表示順ソートList) {
                識別番号 = 表示順_CODE.split(ダッシュ.toString()).get(INDEX_ONE);
                取込交換情報識別番号 = ConfigKeysKokuhorenTorikomi.toValue(識別番号);
                if (!取込交換情報識別番号.isスケジュール設定有無()) {
                    continue;
                }
                if ((ConfigKeysKokuhorenTorikomi.償還払支給決定者一覧情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.償還払不支給決定者一覧情報.getコード().equals(識別番号))
                        && 受託あり.equals(国保連共同処理受託区分_償還)) {
                    continue;
                }
                if ((ConfigKeysKokuhorenTorikomi.高額介護サービス費給付対象者一覧表情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額介護サービス費支給不支給決定者一覧表情報.getコード().equals(識別番号))
                        && 受託あり.equals(国保連共同処理受託区分_高額)) {
                    continue;
                }
                if ((ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算支給不支給決定通知書情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算給付実績情報.getコード().equals(識別番号))
                        && (処理開始年月.isEmpty() || RDate.getNowDate().isBefore(new RDate(処理開始年月.toString())))) {
                    continue;
                }
                if ((ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報_後期分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算支給不支給決定通知書情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算支給不支給決定通知書情報_後期分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報_後期分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算給付実績情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算給付実績情報_後期分.getコード().equals(識別番号))
                        && (!処理開始年月.isEmpty() && !RDate.getNowDate().isBefore(new RDate(処理開始年月.toString())))) {
                    continue;
                }
                toriRow = new dgDataTorikomi_Row();
                toriRow.setTxtTorikomiShorimei(取込交換情報識別番号.get名称());
                toriRow.getTxtTorikomiShoriJokyo().setDataSource(追加状態dataSource);
                toriRow.setTxtKokanJohoSikibetsuBango(取込交換情報識別番号.getコード());
                tList.add(toriRow);
            }
        } else {
            Map<RString, KokuhorenInterfaceKanri> 取込Map = new HashMap<>();
            for (KokuhorenInterfaceKanri entity : 取込List) {
                取込Map.put(entity.get交換情報識別番号(), entity);
            }
            for (RString 表示順_CODE : 取込表示順ソートList) {
                識別番号 = 表示順_CODE.split(ダッシュ.toString()).get(INDEX_ONE);
                if (!取込Map.containsKey(識別番号)) {
                    continue;
                }
                KokuhorenInterfaceKanri entity = 取込Map.get(識別番号);
                取込交換情報識別番号 = ConfigKeysKokuhorenTorikomi.toValue(識別番号);
                if (!取込交換情報識別番号.isスケジュール設定有無()) {
                    continue;
                }
                if ((ConfigKeysKokuhorenTorikomi.償還払支給決定者一覧情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.償還払不支給決定者一覧情報.getコード().equals(識別番号))
                        && 受託あり.equals(国保連共同処理受託区分_償還)) {
                    continue;
                }
                if ((ConfigKeysKokuhorenTorikomi.高額介護サービス費給付対象者一覧表情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額介護サービス費支給不支給決定者一覧表情報.getコード().equals(識別番号))
                        && 受託あり.equals(国保連共同処理受託区分_高額)) {
                    continue;
                }
                if ((ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算支給不支給決定通知書情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算給付実績情報.getコード().equals(識別番号))
                        && (処理開始年月.isEmpty() || 取込List.get(INDEX_ZERO).get処理年月().isBefore(new FlexibleYearMonth(処理開始年月)))) {
                    continue;
                }
                if ((ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報_後期分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算支給不支給決定通知書情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算支給不支給決定通知書情報_後期分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報_後期分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算給付実績情報_国保分.getコード().equals(識別番号)
                        || ConfigKeysKokuhorenTorikomi.高額合算給付実績情報_後期分.getコード().equals(識別番号))
                        && (!処理開始年月.isEmpty() && !取込List.get(INDEX_ZERO).get処理年月().isBefore(new FlexibleYearMonth(処理開始年月)))) {
                    continue;
                }
                toriRow = new dgDataTorikomi_Row();
                取込交換情報識別番号 = ConfigKeysKokuhorenTorikomi.toValue(entity.get交換情報識別番号());
                取込処理実施日時 = entity.get処理実施日時();
                toriRow.setTxtTorikomiShorimei(取込交換情報識別番号.get名称());
                toriRow.getTxtTorikomiShoriJokyo().setDataSource(get初期状態dataSource(entity.get処理状態区分()));
                toriRow.getTxtTorikomiShoriJokyo().setSelectedValue(
                        ShoriJotaiKubun.toValue(entity.get処理状態区分()).get名称());
                toriRow.getTxtTorikomiShoribi().setValue(取込処理実施日時 == null || 取込処理実施日時.isEmpty() ? null : 取込処理実施日時.getDate());
                toriRow.setTxtKokanJohoSikibetsuBango(取込交換情報識別番号.getコード());
                tList.add(toriRow);
            }
        }
        return tList;
    }

    /**
     * set取込処理状況
     *
     * @param list List<dgDataTorikomi_Row>
     * @param 取込List List<KokuhorenInterfaceKanri>
     * @return List<dgDataTorikomi_Row>
     */
    public List<dgDataTorikomi_Row> set取込処理状況(List<dgDataTorikomi_Row> list, List<KokuhorenInterfaceKanri> 取込List) {
        Map<RString, KokuhorenInterfaceKanri> 取込Map = new HashMap<>();
        RString 処理状況;
        for (KokuhorenInterfaceKanri entity : 取込List) {
            取込Map.put(entity.get交換情報識別番号(), entity);
        }
        for (dgDataTorikomi_Row rowData : list) {
            if (取込Map.containsKey(rowData.getTxtKokanJohoSikibetsuBango())) {
                処理状況 = 取込Map.get(rowData.getTxtKokanJohoSikibetsuBango()).get処理状態区分();
                if (処理なし.equals(処理状況)) {
                    rowData.getTxtTorikomiShoriJokyo().setSelectedValue(処理なし);
                } else {
                    rowData.getTxtTorikomiShoriJokyo().setSelectedValue(処理前);
                }
            }
        }
        return list;
    }

    /**
     * set送付処理状況
     *
     * @param list List<dgDataSofu_Row>
     * @param 送付List List<KokuhorenInterfaceKanri>
     * @return List<dgDataSofu_Row>
     */
    public List<dgDataSofu_Row> set送付処理状況(List<dgDataSofu_Row> list, List<KokuhorenInterfaceKanri> 送付List) {
        Map<RString, KokuhorenInterfaceKanri> 送付Map = new HashMap<>();
        RString 処理状況;
        for (KokuhorenInterfaceKanri entity : 送付List) {
            送付Map.put(entity.get交換情報識別番号(), entity);
        }
        for (dgDataSofu_Row rowData : list) {
            if (送付Map.containsKey(rowData.getTxtKokanJohoSikibetsuBango())) {
                処理状況 = 送付Map.get(rowData.getTxtKokanJohoSikibetsuBango()).get処理状態区分();
                if (処理なし.equals(処理状況)) {
                    rowData.getTxtSofuShoriJokyo().setSelectedValue(処理なし);
                } else {
                    rowData.getTxtSofuShoriJokyo().setSelectedValue(処理前);
                }
            }
        }
        return list;
    }
}
