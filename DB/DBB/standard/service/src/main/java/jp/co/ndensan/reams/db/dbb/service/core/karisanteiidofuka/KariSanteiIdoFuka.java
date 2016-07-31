/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.karisanteiidofuka.KariSanteiIdoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.karisanteiidofuka.TyouhyouResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.KarisanteiIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2014TsuchishoUchiwakeJokenDac;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ36001_仮算定異動賦課
 *
 * @reamsid_L DBB-0890-020 yangchenbing
 */
public class KariSanteiIdoFuka {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;

    private static final RString 特別徴収開始通知書_仮算定_帳票分類ＩＤ = new RString("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final RString 仮算定額変更通知書_帳票分類ＩＤ = new RString("DBB100010_KarisanteiHenkoTsuchishoDaihyo");
    private static final RString 保険料納入通知書_本算定_帳票分類ＩＤ = new RString("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名_追加候補者用通知書タイプ = new RString("追加候補者用通知書タイプ");
    private static final RString 項目名_追加候補者用連帳区分 = new RString("追加候補者用連帳区分");
    private static final RString 項目名_通知書タイプ = new RString("通知書タイプ");
    private static final RString 標準版B5横タイプ = new RString("001");
    private static final RString 標準版B5横オーバレイタイプ = new RString("002");
    private static final RString 標準版A4縦タイプ = new RString("002");
    private static final RString 標準版A4縦オーバレイタイプ = new RString("003");
    private static final RString 標準シーラタイプ = new RString("101");
    private static final RString 連帳 = new RString("1");
    private static final RString カット紙 = new RString("0");
    private static final RString 納入通知書 = new RString("納入通知書の帳票ID");
    private static final RString 定値_0 = new RString("0");
    private static final RString 表示しない = new RString("0");
    private static final RString 通常出力 = new RString("0");
    private static final RString 定値_1 = new RString("1");
    private static final RString 表示する = new RString("1");
    private static final RString 期毎出力 = new RString("1");
    private static final RString 定値_2 = new RString("2");
    private static final RString 定値_すべて選択 = new RString("すべて選択");
    private static final RString 定値_現金納付者 = new RString("現金納付者");
    private static final RString 定値_口座振替者 = new RString("口座振替者");
    private static final RString 定値_する = new RString("する");
    private static final RString 定値_しない = new RString("しない");
    private static final RString 定値_通常の仮算定異動賦課に含めて計算する = new RString("通常の仮算定異動賦課に含めて計算する");
    private static final RString 特徴同定未完了 = new RString("0");
    private static final RString 計算未完了 = new RString("1");
    private static final RString 計算完了 = new RString("2");
    private static final RString 括弧_左 = new RString("（");
    private static final RString 定値_期 = new RString("期");
    private static final RString 定値_前期 = new RString("前期");
    private static final int 定値_1期 = 1;
    private static final int 定値_2期 = 2;
    private static final int 定値_3期 = 3;
    private static final int 定値_4期 = 4;
    private static final int 定値_5期 = 5;
    private static final int 定値_6期 = 6;
    private static final int 定値_7期 = 7;
    private static final int 定値_8期 = 8;
    private static final int 定値_9期 = 9;
    private static final int 定値_10期 = 10;
    private static final int 定値_11期 = 11;
    private static final int 定値_12期 = 12;
    private static final int 定値_13期 = 13;
    private static final int 定値_14期 = 14;
    private static final int 設定値_番号1 = 1;
    private static final int 設定値_番号2 = 2;
    private static final int 設定値_番号0 = 0;
    private static final int 設定値_番号4 = 4;
    private static final int 設定値_番号5 = 5;
    private static final int 設定値_番号6 = 6;
    private static final int 設定値_番号9 = 9;
    private static final RString 定値_期毎 = new RString("期毎タイプ");
    private static final RString 定値_銀振型5期 = new RString("銀振型5期タイプ");
    private static final RString 定値_銀振型4期 = new RString("銀振型4期タイプ");
    private static final RString 定値_ブック = new RString("ブックタイプ");
    private static final RString 定値_コンビニ収納 = new RString("コンビニ収納タイプ");
    private static final RString 定値_その他 = new RString("その他（カスタマイズ）");
    private static final RString 期毎納入通知書タイプ = new RString("期毎納入通知書タイプ");
    private static final RString 銀振納入通知書タイプ = new RString("銀振納入通知書タイプ");
    private static final RString その他納入通知書タイプ = new RString("その他納入通知書タイプ");
    private static final RString コンビニ期毎出力 = new RString("コンビニ期毎出力");
    private static final RString ブック口座振替依頼表示 = new RString("ブック口座振替依頼表示");
    private static final RString 標準版 = new RString("001");
    private static final RString コンビニマルチ収納タイプ = new RString("301");
    private static final RString コンビニ角公タイプ = new RString("302");

    /**
     * コンストラクタです。
     */
    public KariSanteiIdoFuka() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 処理日付管理Dac 処理日付管理Dac
     * @param 通知書打ち分け条件Dac 通知書打ち分け条件Dac
     * @param 帳票制御汎用Dac 帳票制御汎用Dac
     */
    KariSanteiIdoFuka(DbT7022ShoriDateKanriDac 処理日付管理Dac,
            DbT2014TsuchishoUchiwakeJokenDac 通知書打ち分け条件Dac,
            DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * 処理状況取得します。
     *
     * @param 遷移元区分 遷移元区分
     * @param 調定年度 調定年度
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> getShoriDateKanriList(RString 遷移元区分, FlexibleYear 調定年度) {
        List<DbT7022ShoriDateKanriEntity> entityList = new ArrayList<>();
        DbT7022ShoriDateKanriEntity dbt;
        if (定値_0.equals(遷移元区分)) {
            entityList = 処理日付管理Dac.select処理状況_異動賦課(調定年度);
        } else if (定値_1.equals(遷移元区分)) {
            dbt = 処理日付管理Dac.select処理状況_異動通知書作成(調定年度);
            if (dbt != null) {
                entityList.add(dbt);
            }
        }
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShoriDateKanri> kanriList = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            kanriList.add(new ShoriDateKanri(entity));
        }
        return kanriList;
    }

    /**
     * 抽出開始日時取得します。
     *
     * @param 調定年度 調定年度
     * @return YMDHMS
     */
    public YMDHMS getTyusyutuKaishibi(FlexibleYear 調定年度) {
        DbT7022ShoriDateKanriEntity 処理日付管理entity;
        処理日付管理entity = 処理日付管理Dac.select抽出開始日時(調定年度);
        if (処理日付管理entity == null || 処理日付管理entity.getKijunTimestamp() == null || 処理日付管理entity.getKijunTimestamp().isEmpty()) {
            return null;
        } else {
            return 処理日付管理entity.getKijunTimestamp();
        }
    }

    /**
     * 帳票制御汎用キー取得します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo getChohyoHanyoKey(SubGyomuCode サブ業務コード, ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity 帳票制御汎用entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(サブ業務コード, 帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(帳票制御汎用entity);
    }

    /**
     * 帳票ID取得します。
     *
     * @param 調定年度 調定年度
     * @param 帳票分類ID 帳票分類ID
     * @param 算定期 算定期
     * @param 出力順ID 出力順ID
     * @return TyouhyouEntity
     * @throws ApplicationException Exception
     */
    public TyouhyouResult getChohyoID(FlexibleYear 調定年度, ReportId 帳票分類ID, RString 算定期, RString 出力順ID)
            throws ApplicationException {
        if (帳票分類ID == null || 帳票分類ID.isEmpty()) {
            return null;
        }
        if (特別徴収開始通知書_仮算定_帳票分類ＩＤ.equals(帳票分類ID.value())) {
            TyouhyouEntity 特徴開始通知書 = get特徴開始通知書_帳票ID(帳票分類ID, 出力順ID);
            if (特徴開始通知書 != null) {
                return new TyouhyouResult(特徴開始通知書);
            }
        } else if (仮算定額変更通知書_帳票分類ＩＤ.equals(帳票分類ID.value())) {
            TyouhyouEntity 決定変更通知書 = get仮算定額変更通知書_帳票ID(調定年度, 帳票分類ID, 出力順ID);
            if (決定変更通知書 != null) {
                return new TyouhyouResult(決定変更通知書);
            }
        } else if (保険料納入通知書_本算定_帳票分類ＩＤ.equals(帳票分類ID.value())) {
            TyouhyouEntity 納入通知書entity = get納入通知書_帳票ID(調定年度, 算定期, 帳票分類ID, 出力順ID);
            if (保険料納入通知書_本算定_帳票分類ＩＤ.equals(帳票分類ID.value())
                    && 納入通知書entity == null) {
                throw new ApplicationException(UrErrorMessages.存在しない
                        .getMessage().replace(納入通知書.toString()).evaluate());
            } else if (納入通知書entity != null) {
                return new TyouhyouResult(納入通知書entity);
            }
        }
        return null;
    }

    /**
     * 特徴開始通知書(本算定）が選択される場合の帳票IDを取得します。
     *
     * @param 出力順ID 出力順ID
     * @param 帳票分類ID 帳票分類ID
     * @return TyouhyouEntity
     */
    private TyouhyouEntity get特徴開始通知書_帳票ID(ReportId 帳票分類ID, RString 出力順ID) {
        ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                管理年度, 項目名_追加候補者用通知書タイプ);
        ChohyoSeigyoHanyo 連帳区分 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                管理年度, 項目名_追加候補者用連帳区分);
        if (帳票タイプ == null || 連帳区分 == null) {
            return null;
        }
        ReportId 帳票ID = null;
        if (標準版B5横タイプ.equals(帳票タイプ.get設定値())) {
            if (連帳.equals(連帳区分.get設定値())) {
                帳票ID = ReportIdDBB.DBB100004.getReportId();
            } else if (カット紙.equals(連帳区分.get設定値())) {
                帳票ID = ReportIdDBB.DBB100003.getReportId();
            }
        } else if (標準版B5横オーバレイタイプ.equals(帳票タイプ.get設定値())) {
            if (連帳.equals(連帳区分.get設定値()) || カット紙.equals(連帳区分.get設定値())) {
                帳票ID = ReportIdDBB.DBB100009.getReportId();
            }
        } else if (標準版A4縦オーバレイタイプ.equals(帳票タイプ.get設定値())) {
            if (連帳.equals(連帳区分.get設定値()) || カット紙.equals(連帳区分.get設定値())) {
                帳票ID = ReportIdDBB.DBB100008.getReportId();
            }
        } else if (標準シーラタイプ.equals(帳票タイプ.get設定値())) {
            if (連帳.equals(連帳区分.get設定値())) {
                帳票ID = ReportIdDBB.DBB100006.getReportId();
            } else if (カット紙.equals(連帳区分.get設定値())) {
                帳票ID = ReportIdDBB.DBB100005.getReportId();
            }
        }
        if (帳票ID == null) {
            return null;
        } else {
            return new TyouhyouEntity(帳票分類ID, 帳票ID, 出力順ID);
        }
    }

    /**
     * 仮算定額変更通知書の帳票IDを取得します。
     *
     * @param 出力順ID 出力順ID
     * @param 調定年度 調定年度
     * @param 帳票分類ID 帳票分類ID
     * @return TyouhyouEntity
     */
    private TyouhyouEntity get仮算定額変更通知書_帳票ID(FlexibleYear 調定年度, ReportId 帳票分類ID, RString 出力順ID) {
        ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, 項目名_通知書タイプ);
        if (帳票タイプ == null) {
            return null;
        }
        ReportId 帳票ID = null;
        if (標準版B5横タイプ.equals(帳票タイプ.get設定値())) {
            帳票ID = ReportIdDBB.DBB100010.getReportId();
        } else if (標準版A4縦タイプ.equals(帳票タイプ.get設定値())) {
            帳票ID = ReportIdDBB.DBB100011.getReportId();
        }
        if (帳票ID == null) {
            return null;
        } else {
            return new TyouhyouEntity(帳票分類ID, 帳票ID, 出力順ID);
        }
    }

    /**
     * 納入通知書の帳票IDを取得します。
     *
     * @param 出力順ID 出力順ID
     * @param 調定年度 調定年度
     * @param 算定期 算定期
     * @param 帳票分類ID 帳票分類ID
     * @return TyouhyouEntity
     */
    private TyouhyouEntity get納入通知書_帳票ID(FlexibleYear 調定年度, RString 出力期, ReportId 帳票分類ID, RString 出力順ID) {
        RString 納入通知書の型 = set納入通知書の型(出力期);
        RString 納通連帳区分 = get普徴期情報_納通連帳区分(出力期);
        ReportId 帳票ID = ReportId.EMPTY;
        if (定値_期毎.equals(納入通知書の型)) {
            ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    調定年度, 期毎納入通知書タイプ);
            if (帳票タイプ == null) {
                return null;
            }
            if (標準版.equals(帳票タイプ.get設定値()) && カット紙.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100014.getReportId();
            } else if (標準版.equals(帳票タイプ.get設定値()) && 連帳.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100015.getReportId();
            }
        } else if (定値_銀振型4期.equals(納入通知書の型)) {
            ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    調定年度, 銀振納入通知書タイプ);
            if (帳票タイプ == null) {
                return null;
            }
            if (標準版.equals(帳票タイプ.get設定値()) && カット紙.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100018.getReportId();
            } else if (標準版.equals(帳票タイプ.get設定値()) && 連帳.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100019.getReportId();
            }
        } else if (定値_ブック.equals(納入通知書の型)) {
            帳票ID = getブック帳票ID(調定年度, 帳票分類ID, 納通連帳区分);
        } else if (定値_コンビニ収納.equals(納入通知書の型)) {
            帳票ID = getコンビニ収納帳票ID(調定年度, 帳票分類ID, 納通連帳区分);
        }
        return 帳票ID == null ? null : new TyouhyouEntity(帳票分類ID, 帳票ID, 出力順ID);
    }

    private ReportId getブック帳票ID(FlexibleYear 調定年度, ReportId 帳票分類ID, RString 納通連帳区分) {
        ReportId 帳票ID = null;
        ChohyoSeigyoHanyo 帳票タイプ1 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, ブック口座振替依頼表示);
        ChohyoSeigyoHanyo 帳票タイプ2 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, その他納入通知書タイプ);
        if (帳票タイプ1 == null || 帳票タイプ2 == null) {
            return null;
        }
        if (標準版.equals(帳票タイプ2.get設定値()) && 表示しない.equals(帳票タイプ1.get設定値()) && カット紙.equals(納通連帳区分)) {
            帳票ID = ReportIdDBB.DBB100021.getReportId();
        } else if (標準版.equals(帳票タイプ2.get設定値()) && 表示しない.equals(帳票タイプ1.get設定値()) && 連帳.equals(納通連帳区分)) {
            帳票ID = ReportIdDBB.DBB100023.getReportId();
        } else if (標準版.equals(帳票タイプ2.get設定値()) && 表示する.equals(帳票タイプ1.get設定値()) && カット紙.equals(納通連帳区分)) {
            帳票ID = ReportIdDBB.DBB100020.getReportId();
        } else if (標準版.equals(帳票タイプ2.get設定値()) && 表示する.equals(帳票タイプ1.get設定値()) && 連帳.equals(納通連帳区分)) {
            帳票ID = ReportIdDBB.DBB100022.getReportId();
        }
        return 帳票ID;
    }

    private ReportId getコンビニ収納帳票ID(FlexibleYear 調定年度, ReportId 帳票分類ID, RString 納通連帳区分) {
        ReportId 帳票ID = null;
        ChohyoSeigyoHanyo 帳票タイプ1 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, コンビニ期毎出力);
        if (帳票タイプ1 == null) {
            return null;
        }
        if (期毎出力.equals(帳票タイプ1.get設定値())) {
            if (カット紙.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100028.getReportId();
            } else if (連帳.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100029.getReportId();
            }
        } else if (通常出力.equals(帳票タイプ1.get設定値())) {
            ChohyoSeigyoHanyo 帳票タイプ2 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    調定年度, その他納入通知書タイプ);
            if (帳票タイプ2 == null) {
                return null;
            }
            if (コンビニマルチ収納タイプ.equals(帳票タイプ2.get設定値()) && カット紙.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100026.getReportId();
            } else if (コンビニマルチ収納タイプ.equals(帳票タイプ2.get設定値()) && 連帳.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100027.getReportId();
            } else if (コンビニ角公タイプ.equals(帳票タイプ2.get設定値()) && カット紙.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100024.getReportId();
            } else if (コンビニ角公タイプ.equals(帳票タイプ2.get設定値()) && 連帳.equals(納通連帳区分)) {
                帳票ID = ReportIdDBB.DBB100025.getReportId();
            }
        }
        return 帳票ID;
    }

    private RString set納入通知書の型(RString 出力期) {
        RString 設定値 = 定値_0;
        RDate 運用日 = RDate.getNowDate();
        出力期 = 出力期.split(括弧_左.toString()).get(0).replace(定値_前期, RString.EMPTY).replace(定値_期, RString.EMPTY);
        switch (Integer.parseInt(出力期.toString())) {
            case 定値_1期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_2期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_3期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_4期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_5期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_6期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_7期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_8期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_9期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_10期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_11期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_12期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_13期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_14期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return get納入通知書の型(設定値);
    }

    private RString get納入通知書の型(RString 設定値) {
        switch (Integer.parseInt(設定値.toString())) {
            case 設定値_番号0:
                return RString.EMPTY;
            case 設定値_番号1:
                return 定値_期毎;
            case 設定値_番号2:
                return 定値_銀振型5期;
            case 設定値_番号4:
                return 定値_銀振型4期;
            case 設定値_番号5:
                return 定値_ブック;
            case 設定値_番号6:
                return 定値_コンビニ収納;
            case 設定値_番号9:
                return 定値_その他;
            default:
                return RString.EMPTY;
        }
    }

    private RString get普徴期情報_納通連帳区分(RString 出力期) {
        RDate 運用日 = RDate.getNowDate();
        出力期 = 出力期.split(括弧_左.toString()).get(0).replace(定値_前期, RString.EMPTY).replace(定値_期, RString.EMPTY);
        switch (Integer.parseInt(出力期.toString())) {
            case 定値_1期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分1, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_2期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分2, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_3期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分3, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_4期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分4, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_5期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分5, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_6期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分6, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_7期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分7, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_8期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分8, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_9期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分9, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_10期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分10, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_11期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分11, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_12期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分12, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_13期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分13, 運用日, SubGyomuCode.DBB介護賦課);
            case 定値_14期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分14, 運用日, SubGyomuCode.DBB介護賦課);
            default:
                return null;
        }
    }

    /**
     * バッチ用パラメータ作成します。
     *
     * @param parameter parameter
     * @return KarisanteiIdoFukaParameter
     */
    public KarisanteiIdoFukaParameter createKariSanteiIdoParameter(KariSanteiIdoParameter parameter) {
        KarisanteiIdoFukaParameter result = new KarisanteiIdoFukaParameter();
        result.set調定年度(parameter.get調定年度());
        result.set賦課年度(parameter.get賦課年度());
        result.set処理対象月(parameter.get処理対象());
        result.set普徴仮算定異動方法(parameter.get普徴仮算定異動方法());
        result.set抽出開始日時(parameter.get抽出開始日時());
        result.set抽出終了日時(parameter.get抽出終了日時());
        result.set帳票グループ(parameter.get帳票グループ());
        List<TyouhyouEntity> list = new ArrayList<>();
        for (TyouhyouEntity entity : parameter.get出力帳票一覧List()) {
            TyouhyouResult tyouhyouResult = getChohyoID(new FlexibleYear(parameter.get調定年度()), entity.get帳票分類ID(),
                    parameter.get算定期(), entity.get出力順ID());
            if (tyouhyouResult != null) {
                list.add(tyouhyouResult.getEntity());
            }
        }
        result.set出力帳票一覧List(list);
        result.set特徴_発行日(parameter.get特徴_発行日());
        result.set仮算定額変更_発行日(parameter.get仮算定額変更_発行日());
        result.set文書番号(parameter.get文書番号());
        result.set納入_出力期(parameter.get納入_出力期());
        result.set納入_出力方式(parameter.get納入_出力方式());
        result.set納入_発行日(parameter.get納入_発行日());
        if (定値_すべて選択.equals(parameter.get納入_対象者())) {
            result.set納入_対象者(定値_0);
        } else if (定値_現金納付者.equals(parameter.get納入_対象者())) {
            result.set納入_対象者(定値_1);
        } else if (定値_口座振替者.equals(parameter.get納入_対象者())) {
            result.set納入_対象者(定値_2);
        }
        if (定値_する.equals(parameter.get納入_生活保護対象者())) {
            result.set納入_生活保護対象者(定値_0);
        } else if (定値_しない.equals(parameter.get納入_生活保護対象者())) {
            result.set納入_生活保護対象者(定値_1);
        }
        if (定値_する.equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(定値_0);
        } else if (定値_しない.equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(定値_1);
        }
        result.set特徴仮算定賦課処理日時(parameter.get特徴仮算定賦課処理日時());
        result.set普徴仮算定賦課処理日時(parameter.get普徴仮算定賦課処理日時());
        result.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        if (定値_通常の仮算定異動賦課に含めて計算する.equals(parameter.get仮算定異動賦課メニューからの場合())) {
            result.set特徴捕捉対象者の依頼金額計算区分(定値_0);
        } else {
            result.set特徴捕捉対象者の依頼金額計算区分(定値_1);
        }
        result.setバッチ起動フラグ(parameter.isバッチ起動フラグ());
        return result;
    }

    /**
     * 算定月の特徴対象者同定状況を取得します。
     *
     * @param 調定年度 FlexibleYear
     * @param 算定月 RYearMonth
     * @return 依頼金計算処理区分 RString
     */
    public RString getIraikinKeisanShoriKubun(FlexibleYear 調定年度, RYearMonth 算定月) {
        List<DbT7022ShoriDateKanriEntity> 特徴対象者同定list = 処理日付管理Dac.get特徴対象者同定(調定年度);
        if (特徴対象者同定list.isEmpty()) {
            return 特徴同定未完了;
        }
        List<DbT7022ShoriDateKanriEntity> 依頼金額計算list = 処理日付管理Dac.get依頼金額計算(調定年度);
        YMDHMS 基準日時1 = 特徴対象者同定list.get(0).getKijunTimestamp();
        if (基準日時1 == null || 基準日時1.isEmpty()) {
            return 特徴同定未完了;
        }
        if (依頼金額計算list.isEmpty()) {
            return 計算未完了;
        } else {
            YMDHMS 基準日時2 = 依頼金額計算list.get(0).getKijunTimestamp();
            if (基準日時2 == null || 基準日時2.isEmpty()) {
                return 計算未完了;
            } else {
                return 計算完了;
            }
        }
    }

    /**
     * 基準日時取得のメソッドます。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理名 RString
     * @return 処理日付管理entity
     */
    public ShoriDateKanri get基準日時(FlexibleYear 調定年度, RString 処理名) {
        DbT7022ShoriDateKanriEntity shoriDateKanri = 処理日付管理Dac.selectMax基準日(調定年度, 処理名);
        return new ShoriDateKanri(shoriDateKanri);
    }
}
