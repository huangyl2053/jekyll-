/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.DBB9020001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.FukaKijunTotalDiv;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RankJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.RankJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * システム管理（賦課基準）のhandler処理です。
 *
 * @reamsid_L DBB-1770-010 zhangrui
 */
public class FukaKijunTotalHandler {

    private final FukaKijunTotalDiv parentDiv;
    private static final FlexibleYear 平成12年 = new FlexibleYear("2000");
    private static final FlexibleYear 平成27年 = new FlexibleYear("2015");
    private static final FlexibleYear 平成26年 = new FlexibleYear("2014");
    private static final FlexibleYear 平成25年 = new FlexibleYear("2013");
    private static final FlexibleYear 平成24年 = new FlexibleYear("2012");
    private static final FlexibleYear 平成23年 = new FlexibleYear("2011");
    private static final FlexibleYear 平成21年 = new FlexibleYear("2009");
    private static final FlexibleYear 平成20年 = new FlexibleYear("2008");
    private static final FlexibleYear 平成18年 = new FlexibleYear("2006");
    private static final FlexibleYear 平成17年 = new FlexibleYear("2005");
//    private static final RString ランク_無 = new RString("無");
//    private static final RString ランク_有 = new RString("有");
    private static final RString ランク区分_00 = new RString("00");
    private static final RString 段階インデックス_01 = new RString("01");
    private static final RString 段階インデックス_02 = new RString("02");
    private static final RString 段階インデックス_03 = new RString("03");
//    private static final RString 段階インデックス_04 = new RString("04");
//    private static final RString 段階インデックス_05 = new RString("05");
//    private static final RString 段階インデックス_06 = new RString("06");
//    private static final RString 段階インデックス_07 = new RString("07");

    /**
     * コンストラクタです。
     *
     * @param parentDiv システム管理（賦課基準）の画面Div
     */
    public FukaKijunTotalHandler(FukaKijunTotalDiv parentDiv) {
        this.parentDiv = parentDiv;
    }

    /**
     * 賦課年度の設定
     */
    public void 賦課年度の設定() {
        FlexibleYear 賦課年度 = new FlexibleYear(DbBusinessConfig.get(
                ConfigNameDBB.日付関連_調定年度, RDate.getNowDate()));
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        ShoriDateKanri 新年度管理情報作成 = manager.get抽出調定日時(
                SubGyomuCode.DBB介護賦課, ShoriName.新年度管理情報作成.get名称(), 賦課年度.plusYear(1));
        boolean is新年度管理情報未作成 = null == 新年度管理情報作成
                || null == 新年度管理情報作成.get基準年月日()
                || 新年度管理情報作成.get基準年月日().isEmpty();
        FlexibleYear 年度 = is新年度管理情報未作成 ? 賦課年度 : 賦課年度.plusYear(1);
        FlexibleYear 開始年度 = 平成12年.isBeforeOrEquals(年度) ? 平成12年 : 年度;
        FlexibleYear 終了年度 = 平成12年.isBeforeOrEquals(年度) ? 年度 : 平成12年;
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        while (開始年度.isBeforeOrEquals(終了年度)) {
            KeyValueDataSource dataSource = new KeyValueDataSource(終了年度.seireki().toDateString(),
                    終了年度.wareki().toDateString());
            dataSourceList.add(dataSource);
            終了年度 = 終了年度.minusYear(1);
        }
        parentDiv.getKonkaiShoriNaiyo().getDdlFukaNendo().setDataSource(dataSourceList);
        parentDiv.getKonkaiShoriNaiyo().getDdlFukaNendo().setSelectedKey(賦課年度.seireki().toDateString());
    }

    /**
     * ランクを取得する。
     */
    public void ランクの取得() {
        boolean isランク非表示 = false;
        // TODO ランク管理情報_ランク有無、ランク管理情報_ランク開始年度、ランク管理情報_ランク終了年度
//        RString ランク有無 = DbBusinessConifg.get(ConfigNameDBB.ランク管理情報_ランク有無, RDate.getNowDate());
//        RDate now = RDate.getNowDate();
//        if (ランク_無.equals(ランク有無)) {
//            isランク非表示 = true;
//        } else if (ランク_有.equals(ランク有無)) {
//            FlexibleYear ランク開始年度 = new FlexibleYear(DbBusinessConifg.get(
//                    ConfigNameDBB.ランク管理情報_ランク開始年度, now));
//            FlexibleYear ランク終了年度 = new FlexibleYear(DbBusinessConifg.get(
//                    ConfigNameDBB.ランク管理情報_ランク終了年度, now));
//            isランク非表示 = 賦課年度.isBefore(ランク開始年度) || ランク終了年度.isBefore(賦課年度);
//        }
        ランクDDLのデータ設定(new FlexibleYear(parentDiv.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey()));
        parentDiv.getKonkaiShoriNaiyo().getDdlRank().setDisplayNone(isランク非表示);
    }

    /**
     * 賦課年度より、遷移先を設定する
     *
     * @return DBB9020001StateName
     */
    public DBB9020001StateName 遷移先の設定() {
        FlexibleYear 賦課年度 = new FlexibleYear(parentDiv.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        if (平成27年.isBeforeOrEquals(賦課年度)) {
            return DBB9020001StateName.平成27年以降;
        } else if (平成26年.equals(賦課年度)) {
            return DBB9020001StateName.平成26年;
        } else if (平成24年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成25年)) {
            return DBB9020001StateName.平成24年から平25年まで;
        } else if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成23年)) {
            return DBB9020001StateName.平成21年から平成23年まで;
        } else if (平成18年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成20年)) {
            return DBB9020001StateName.平成18年から平成20年;
        } else if (賦課年度.isBeforeOrEquals(平成17年)) {
            return DBB9020001StateName.平成17年以前;
        }
        return DBB9020001StateName.初期状態;
    }

    /**
     * 保険料率の取得と画面表示の設定
     */
    public void 保険料率の取得と画面表示の設定() {
        HokenryoDankaiManager manager = new HokenryoDankaiManager();
        RString ランク区分 = parentDiv.getKonkaiShoriNaiyo().getDdlRank().isDisplayNone()
                ? ランク区分_00 : parentDiv.getKonkaiShoriNaiyo().getDdlRank().getSelectedKey();
        FlexibleYear 賦課年度 = new FlexibleYear(parentDiv.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        List<HokenryoDankai> 保険料段階一覧 = manager.get保険料段階一覧Byランク区分(賦課年度, ランク区分);
        画面項目の保険料率の値の設定(保険料段階一覧);
    }

    private void 画面項目の保険料率の値の設定(List<HokenryoDankai> 保険料段階一覧) {
        DBB9020001StateName state = 遷移先の設定();
        if (DBB9020001StateName.平成17年以前.equals(state)) {
            parentDiv.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai1Dankai().setValue(
                    get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_01));
            parentDiv.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai2Dankai().setValue(
                    get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_02));
            parentDiv.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3Dankai().setValue(
                    get保険料率From保険料段階一覧(保険料段階一覧, 段階インデックス_03));
        }
        // TODO
//        else if (DBB9020001StateName.平成18年から平成20年.equals(state)) {
//
//        } else if (DBB9020001StateName.平成21年から平成23年まで.equals(state)) {
//
//        } else if (DBB9020001StateName.平成24年から平25年まで.equals(state)
//                || DBB9020001StateName.平成26年.equals(state)) {
//
//        } else if (DBB9020001StateName.平成27年以降.equals(state)) {
//
//        }
    }

//    private void 保険料段階Gridの保険料等の設定() {
//
//    }
    private Decimal get保険料率From保険料段階一覧(List<HokenryoDankai> 保険料段階一覧, RString 段階インデックス) {
        if (null == 保険料段階一覧 || null == 段階インデックス) {
            return null;
        }
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            if (段階インデックス.equals(保険料段階.get段階インデックス())) {
                return 保険料段階.get保険料率();
            }
        }
        return null;
    }

    private void ランクDDLのデータ設定(FlexibleYear 賦課年度) {
        RankJohoManager manager = new RankJohoManager();
        List<RankJoho> ランク情報一覧 = manager.getランク情報一覧By賦課年度(賦課年度);
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (RankJoho ランク情報 : ランク情報一覧) {
            KeyValueDataSource dataSource = new KeyValueDataSource(ランク情報.getランク区分(), ランク情報.getランク名称());
            dataSourceList.add(dataSource);
        }
        parentDiv.getKonkaiShoriNaiyo().getDdlRank().setDataSource(dataSourceList);
        parentDiv.getKonkaiShoriNaiyo().getDdlRank().setSelectedIndex(0);
    }

    /**
     * 平成12年 前排他を設定する.
     */
    public void 前排他を設定する() {
        LockingKey key = new LockingKey(UrControlDataFactory.createInstance().getMenuID());
        if (RealInitialLocker.tryGetLock(key)) {
            RealInitialLocker.lock(key);
        } else {
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
    }

    /**
     * 前排他を解除する
     */
    public void 前排他を解除する() {
        LockingKey key = new LockingKey(UrControlDataFactory.createInstance().getMenuID());
        if (RealInitialLocker.tryGetLock(key)) {
            RealInitialLocker.release(key);
        }
    }
}
