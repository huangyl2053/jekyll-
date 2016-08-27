 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteiidogennendo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennen.ChohyoMeter;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennen.SanteiIdoGennen;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennen.Shoriku;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.CreateHonsanteiIdoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定異動（現年度）のビジネスクラスです。
 *
 * @reamsid_L DBB-0880-020 lijunjun
 */
public class HonsanteiIdoGennendo {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private static RString 処理_枝番 = new RString("0001");
    private static FlexibleYear 管理年度 = new FlexibleYear("0000");
    private int countLog = 0;
    private final RString zeroRS = new RString("0");
    private final RString oneRS = new RString("1");
    private final RString twoRS = new RString("2");
    private final RString threeRS = new RString("3");
    private final RString fourRS = new RString("4");
    private final RString zfourRS = new RString("04");
    private final RString tenRS = new RString("10");
    private final RString twlRS = new RString("12");
    private final RString twlZRS = new RString("301");
    private final RString twlTRS = new RString("302");
    private final RString zOneRS = new RString("001");
    private final RString zThrRS = new RString("0003");
    private final RString zFourRS = new RString("0004");
    private final RString zFiveRS = new RString("0005");
    private final RString zSixRS = new RString("0006");
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final int INDEX_13 = 13;
    private static final int INDEX_14 = 14;
    private final RString 追加候補者用通知書タイプ = new RString("追加候補者用通知書タイプ");
    private final RString 追加候補者用連帳区分 = new RString("追加候補者用連帳区分");
    private final RString 通知書タイプ = new RString("通知書タイプ");
    private final RString 期毎納入通知書タイプ = new RString("期毎納入通知書タイプ");
    private final RString 銀振納入通知書タイプ = new RString("銀振納入通知書タイプ");
    private final RString その他納入通知書タイプ = new RString("その他納入通知書タイプ");
    private final RString ブック口座振替依頼表示 = new RString("ブック口座振替依頼表示");
    private final RString コンビニ期毎出力 = new RString("コンビニ期毎出力");
    private final ReportId 特徴開始通知書 = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private final ReportId 特徴開始通知書_仮算定 = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private final ReportId 決定通知書_変更通知書 = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private final ReportId 納入通知書 = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final ReportId 本算定異動_現年度_結果一覧表 = new ReportId("DBB200015_HonsanteiIdouKekkaIchiran");
    private final RString 特徴開始者_12月 = new RString("12月特徴開始者のみ");
    private final RString 特徴開始者_2月 = new RString("2月特徴開始者のみ");
    private final RString 特徴開始者_4月 = new RString("4月特徴開始者のみ");
    private final RString すべて選択 = new RString("（すべて選択）");
    private final RString 現金納付者 = new RString("現金納付者");
    private final RString 口座振替者 = new RString("口座振替者");
    private final RString 口座用 = new RString("口座用");
    private final RString 現金用 = new RString("現金用");
    private final RString 別々出力 = new RString("別々出力");
    private final RString 全件出力 = new RString("全件出力");
    private final RString する = new RString("する");
    private final RString しない = new RString("しない");
    private final RString 空白文字 = new RString("");

    /**
     * コンストラクタです
     */
    public HonsanteiIdoGennendo() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac 処理日付管理Dac
     */
    HonsanteiIdoGennendo(DbT7022ShoriDateKanriDac 処理日付管理Dac,
            DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * にて生成した{@link HonsanteiIdoGennendo}のインスタンスを返します。
     *
     * @return HonsanteiIdoGennendo
     */
    public static HonsanteiIdoGennendo createInstance() {
        return InstanceProvider.create(HonsanteiIdoGennendo.class);
    }

    /**
     * 処理状況取得
     *
     * @param 算定月 算定月
     * @param 調定年度 調定年度
     * @param 遷移元区分 遷移元区分
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> getShoriDateKanriList(RString 算定月, FlexibleYear 調定年度,
            RString 遷移元区分) {
        List<DbT7022ShoriDateKanriEntity> entityList = new ArrayList<>();
        RString 特徴開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (zeroRS.equals(遷移元区分)) {
            if (tenRS.equals(算定月) && !zfourRS.equals(特徴開始月)) {
                entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                        ShoriName.特徴対象者同定.get名称(),
                        処理_枝番, 調定年度, zThrRS);
            } else if (twlRS.equals(算定月)) {
                entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                        ShoriName.特徴対象者同定.get名称(),
                        処理_枝番, 調定年度, zFourRS);
            } else if (twoRS.equals(算定月)) {
                entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                        ShoriName.特徴対象者同定.get名称(),
                        処理_枝番, 調定年度, zFiveRS);
            }
        } else if (oneRS.equals(遷移元区分)) {
            DbT7022ShoriDateKanriEntity entity
                    = 処理日付管理Dac.selectByFourKeys(SubGyomuCode.DBB介護賦課,
                            ShoriName.異動賦課.get名称(), 処理_枝番, 調定年度);
            if (entity != null) {
                entityList.add(entity);
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
     * 抽出開始日時取得
     *
     * @param 調定年度 調定年度
     * @return ShoriDateKanri
     */
    public ShoriDateKanri getChushutsuKaishiNichiji(FlexibleYear 調定年度) {
        DbT7022ShoriDateKanriEntity kanriEntity = 処理日付管理Dac.selectByFourKeys(SubGyomuCode.DBB介護賦課,
                ShoriName.異動賦課.get名称(), 処理_枝番, 調定年度);
        if (kanriEntity == null) {
            List<DbT7022ShoriDateKanriEntity> kanriEntityList = 処理日付管理Dac
                    .selectBySomeKeys(SubGyomuCode.DBB介護賦課, ShoriName.本算定賦課.get名称(), 処理_枝番, 調定年度, 処理_枝番);
            if (kanriEntityList != null) {
                return new ShoriDateKanri(kanriEntityList.get(0));
            }
        }
        return new ShoriDateKanri(kanriEntity);
    }

    /**
     * 処理区分設定 パラメータ
     *
     * @param list list
     * @param 年度内連番 年度内連番
     * @return int
     */
    public int getCountFlag(List<DbT7022ShoriDateKanriEntity> list, RString 年度内連番) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (年度内連番.equals(list.get(i).getNendoNaiRenban())
                    && list.get(i).getKijunTimestamp() != null && !list.get(i).getKijunTimestamp().isEmpty()) {
                count = 1;
                break;
            }
        }
        if (count == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 処理区分設定 パラメータ
     *
     * @param entity entity
     * @param countLog countLog
     */
    public void setEntity(Shoriku entity, int countLog) {
        if (countLog == 1) {
            entity.set計算処理区分(oneRS);
        } else {
            entity.set計算処理区分(zeroRS);
        }
    }

    /**
     * 処理区分設定
     *
     * @param 算定月 算定月
     * @param 調定年度 調定年度
     * @return Shoriku
     */
    public Shoriku setShorikubun(RString 算定月, FlexibleYear 調定年度) {
        List<DbT7022ShoriDateKanriEntity> entityFir;
        List<DbT7022ShoriDateKanriEntity> entitySec;
        Shoriku entity = new Shoriku();
        entityFir = 処理日付管理Dac.selectShorikubun(SubGyomuCode.DBB介護賦課,
                ShoriName.特徴対象者同定.get名称(), 調定年度);
        if (entityFir == null || entityFir.isEmpty()) {
            return null;
        }
        entitySec = 処理日付管理Dac.selectShorikubun(SubGyomuCode.DBB介護賦課,
                ShoriName.依頼金額計算.get名称(), 調定年度);

        if (entitySec == null || entitySec.isEmpty()) {
            return null;
        }

        if (tenRS.equals(算定月)) {
            countLog = this.getCountFlag(entityFir, zThrRS);
            if (countLog == 0) {
                entity.set特徴同定区分(zeroRS);
                entity.set計算処理区分(zeroRS);
                return entity;
            } else {
                entity.set特徴同定区分(oneRS);
                countLog = this.getCountFlag(entitySec, zFourRS);
                this.setEntity(entity, countLog);
                return entity;
            }
        }

        if (twlRS.equals(算定月)) {
            countLog = this.getCountFlag(entityFir, zFourRS);
            if (countLog == 0) {
                entity.set特徴同定区分(zeroRS);
                entity.set計算処理区分(zeroRS);
                return entity;
            } else {
                entity.set特徴同定区分(oneRS);
                countLog = this.getCountFlag(entitySec, zFiveRS);
                this.setEntity(entity, countLog);
                return entity;
            }
        }

        if (twoRS.equals(算定月)) {
            countLog = this.getCountFlag(entityFir, zFiveRS);
            if (countLog == 0) {
                entity.set特徴同定区分(zeroRS);
                entity.set計算処理区分(zeroRS);
                return entity;
            } else {
                entity.set特徴同定区分(oneRS);
                countLog = this.getCountFlag(entitySec, zSixRS);
                this.setEntity(entity, countLog);
                return entity;
            }
        }
        return null;
    }

    /**
     * 帳票制御汎用キー取得
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo getChohyoHanyoKey(SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID, FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.selectByKey(サブ業務コード, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        } else {
            return new ChohyoSeigyoHanyo(entity);
        }
    }

    /**
     * 特徴開始通知書(本算定）が選択される場合の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 出力順ID 出力順ID
     * @return ChohyoResult
     */
    public ChohyoResult get特徴開始通知書_本算定(ReportId 帳票分類ID, RString 出力順ID) {
        ChohyoSeigyoHanyo 帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                管理年度, 追加候補者用通知書タイプ);
        ChohyoSeigyoHanyo 連帳区分を = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                管理年度, 追加候補者用連帳区分);
        switch (帳票タイプを.get設定値().toString() + 連帳区分を.get設定値().toString()) {
            case "0011":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100033.getReportId().value(), 出力順ID);
            case "0010":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100032.getReportId().value(), 出力順ID);
            case "0021":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100037.getReportId().value(), 出力順ID);
            case "0020":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100036.getReportId().value(), 出力順ID);
            case "0031":
            case "0030":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100038.getReportId().value(), 出力順ID);
            case "1011":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100035.getReportId().value(), 出力順ID);
            case "1010":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100034.getReportId().value(), 出力順ID);
            default:
                return null;
        }
    }

    /**
     * 特徴開始通知書(仮算定）の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 出力順ID 出力順ID
     * @return ChohyoResult
     */
    public ChohyoResult get特徴開始通知書_仮算定(ReportId 帳票分類ID, RString 出力順ID) {
        ChohyoSeigyoHanyo 帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                管理年度, 追加候補者用通知書タイプ);
        ChohyoSeigyoHanyo 連帳区分を = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                管理年度, 追加候補者用連帳区分);
        switch (帳票タイプを.get設定値().toString() + 連帳区分を.get設定値().toString()) {
            case "0011":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100004.getReportId().value(), 出力順ID);
            case "0010":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100003.getReportId().value(), 出力順ID);
            case "0021":
            case "0020":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100009.getReportId().value(), 出力順ID);
            case "0031":
            case "0030":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100008.getReportId().value(), 出力順ID);
            case "1011":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100006.getReportId().value(), 出力順ID);
            case "1010":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100005.getReportId().value(), 出力順ID);
            default:
                return null;
        }
    }

    /**
     * 決定通知書の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 出力順ID 出力順ID
     * @param 調定年度 調定年度
     * @return ChohyoResult
     */
    public ChohyoResult get決定通知書(ReportId 帳票分類ID, RString 出力順ID, FlexibleYear 調定年度) {
        ChohyoSeigyoHanyo 帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, 通知書タイプ);
        switch (帳票タイプを.get設定値().toString()) {
            case "001":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100039.getReportId().value(), 出力順ID);
            case "002":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100040.getReportId().value(), 出力順ID);
            default:
                return null;
        }
    }

    /**
     * 変更通知書の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 出力順ID 出力順ID
     * @param 調定年度 調定年度
     * @return ChohyoResult
     */
    public ChohyoResult get変更通知書(ReportId 帳票分類ID, RString 出力順ID, FlexibleYear 調定年度) {
        ChohyoSeigyoHanyo 帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, 通知書タイプ);
        switch (帳票タイプを.get設定値().toString()) {
            case "001":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100042.getReportId().value(), 出力順ID);
            case "002":
                return new ChohyoResult(帳票分類ID,
                        ReportIdDBB.DBB100043.getReportId().value(), 出力順ID);
            default:
                return null;
        }
    }

    /**
     * 普徴期情報_納付書の型N
     *
     * @param 算定期 String
     * @return RString
     */
    public RString get納付書の型(RString 算定期) {
        RString 設定値;
        int case_算定期 = Integer.valueOf(算定期.toString());
        switch (case_算定期) {
            case INDEX_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",1");
            case INDEX_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",2");
            case INDEX_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",3");
            case INDEX_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",4");
            case INDEX_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",5");
            case INDEX_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",6");
            case INDEX_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",7");
            case INDEX_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",8");
            case INDEX_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",9");
            case INDEX_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",10");
            case INDEX_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",11");
            case INDEX_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",12");
            case INDEX_13:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",13");
            case INDEX_14:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",14");
            default:
                設定値 = 空白文字;
                return 設定値;
        }
    }

    /**
     * 普徴期情報_納通連帳区分N
     *
     * @param 納通連帳区分 String
     * @return RString
     */
    public RString get納通連帳区分(RString 納通連帳区分) {
        RString 設定値;
        int case_納通連帳区分 = Integer.valueOf(納通連帳区分.toString());
        switch (case_納通連帳区分) {
            case INDEX_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_13:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            case INDEX_14:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return 設定値;
            default:
                設定値 = 空白文字;
                return 設定値;
        }
    }

    /**
     * 期毎タイプ
     *
     * @param 帳票タイプを ChohyoSeigyoHanyo
     * @param 帳票分類ID ReportId
     * @param 出力順ID RString
     * @param 型N RString
     * @return ChohyoResult
     */
    public ChohyoResult get期毎タイプ(ChohyoSeigyoHanyo 帳票タイプを, ReportId 帳票分類ID, RString 出力順ID, RString 型N) {
        RString 設定値 = this.get納通連帳区分(型N);
        if (zOneRS.equals(帳票タイプを.get設定値()) && zeroRS.equals(設定値)) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100045.getReportId().value(), 出力順ID);
        } else if (zOneRS.equals(帳票タイプを.get設定値()) && oneRS.equals(設定値)) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100046.getReportId().value(), 出力順ID);
        }
        return null;
    }

    /**
     * 銀振型5期タイプ
     *
     * @param 帳票タイプを ChohyoSeigyoHanyo
     * @param 帳票分類ID ReportId
     * @param 出力順ID RString
     * @param 型N RString
     * @return ChohyoResult
     */
    public ChohyoResult get銀振型5期タイプ(ChohyoSeigyoHanyo 帳票タイプを, ReportId 帳票分類ID, RString 出力順ID, RString 型N) {
        RString 設定値 = this.get納通連帳区分(型N);
        if (zOneRS.equals(帳票タイプを.get設定値()) && zeroRS.equals(設定値)) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100001.getReportId().value(), 出力順ID);
        } else if (zOneRS.equals(帳票タイプを.get設定値()) && oneRS.equals(設定値)) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100054.getReportId().value(), 出力順ID);
        }
        return null;
    }

    /**
     * 銀振型４期タイプ
     *
     * @param 帳票タイプを ChohyoSeigyoHanyo
     * @param 帳票分類ID ReportId
     * @param 出力順ID RString
     * @param 型N RString
     * @return ChohyoResult
     */
    public ChohyoResult get銀振型４期タイプ(ChohyoSeigyoHanyo 帳票タイプを, ReportId 帳票分類ID, RString 出力順ID, RString 型N) {
        RString 設定値 = this.get納通連帳区分(型N);
        if (zOneRS.equals(帳票タイプを.get設定値()) && zeroRS.equals(設定値)) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100051.getReportId().value(), 出力順ID);
        } else if (zOneRS.equals(帳票タイプを.get設定値()) && oneRS.equals(設定値)) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100052.getReportId().value(), 出力順ID);
        }
        return null;
    }

    /**
     * ブックタイプ
     *
     * @param 帳票タイプを ChohyoSeigyoHanyo
     * @param 帳票_口座振替依頼 ChohyoSeigyoHanyo
     * @param 帳票分類ID ReportId
     * @param 出力順ID RString
     * @param 型N RString
     * @return ChohyoResult
     */
    public ChohyoResult getブックタイプ(ChohyoSeigyoHanyo 帳票タイプを, ChohyoSeigyoHanyo 帳票_口座振替依頼, ReportId 帳票分類ID,
            RString 出力順ID, RString 型N) {
        RString 設定値 = this.get納通連帳区分(型N);
        if (zOneRS.equals(帳票タイプを.get設定値())) {
            if (zeroRS.equals(帳票_口座振替依頼.get設定値()) && zeroRS.equals(設定値)) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100056.getReportId().value(), 出力順ID);
            } else if (zeroRS.equals(帳票_口座振替依頼.get設定値()) && oneRS.equals(設定値)) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100058.getReportId().value(), 出力順ID);
            } else if (oneRS.equals(帳票_口座振替依頼.get設定値()) && zeroRS.equals(設定値)) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100055.getReportId().value(), 出力順ID);
            } else if (oneRS.equals(帳票_口座振替依頼.get設定値()) && oneRS.equals(設定値)) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100057.getReportId().value(), 出力順ID);
            }
        }
        return null;
    }

    /**
     * コンビニ収納タイプ
     *
     * @param 帳票タイプを ChohyoSeigyoHanyo
     * @param 帳票_コンビニ期毎出力 ChohyoSeigyoHanyo
     * @param 帳票分類ID ReportId
     * @param 出力順ID RString
     * @param 型N RString
     * @return ChohyoResult
     */
    public ChohyoResult getコンビニ期毎出力(ChohyoSeigyoHanyo 帳票タイプを, ChohyoSeigyoHanyo 帳票_コンビニ期毎出力, ReportId 帳票分類ID,
            RString 出力順ID, RString 型N) {
        RString 設定値 = this.get納通連帳区分(型N);
        if (twlZRS.equals(帳票タイプを.get設定値())) {
            if (zeroRS.equals(帳票_コンビニ期毎出力.get設定値()) && zeroRS.equals(設定値)) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100061.getReportId().value(), 出力順ID);
            } else if (zeroRS.equals(帳票_コンビニ期毎出力.get設定値()) && oneRS.equals(設定値)) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100062.getReportId().value(), 出力順ID);
            }
        } else if (twlTRS.equals(帳票タイプを.get設定値())) {
            if (zeroRS.equals(帳票_コンビニ期毎出力.get設定値()) && zeroRS.equals(設定値)) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100059.getReportId().value(), 出力順ID);
            } else if (zeroRS.equals(帳票_コンビニ期毎出力.get設定値()) && oneRS.equals(設定値)) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100060.getReportId().value(), 出力順ID);
            }
        } else if (oneRS.equals(帳票_コンビニ期毎出力.get設定値()) && zeroRS.equals(設定値)) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100063.getReportId().value(), 出力順ID);
        } else if (oneRS.equals(帳票_コンビニ期毎出力.get設定値()) && oneRS.equals(設定値)) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100064.getReportId().value(), 出力順ID);
        }
        return null;
    }

    /**
     * 納入通知書の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 調定年度 調定年度
     * @param 算定期 算定期
     * @param 出力順ID RString
     * @return ChohyoResult
     */
    public ChohyoResult get納入通知書(ReportId 帳票分類ID, FlexibleYear 調定年度, RString 算定期, RString 出力順ID) {
        RString 項目名;
        RString アイテムとして;
        ChohyoSeigyoHanyo 帳票タイプを;
        RString 設定値 = new RString(this.get納付書の型(算定期).toString().split(",")[0]);
        RString 型N = new RString(this.get納付書の型(算定期).toString().split(",")[1]);
        int case_設定値 = Integer.valueOf(設定値.toString());
        switch (case_設定値) {
            case INDEX_1:
                項目名 = 期毎納入通知書タイプ;
                帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                return this.get期毎タイプ(帳票タイプを, 帳票分類ID, 出力順ID, 型N);
            case INDEX_2:
                項目名 = 銀振納入通知書タイプ;
                帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                return this.get銀振型5期タイプ(帳票タイプを, 帳票分類ID, 出力順ID, 型N);
            case INDEX_4:
                項目名 = 銀振納入通知書タイプ;
                帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                return this.get銀振型４期タイプ(帳票タイプを, 帳票分類ID, 出力順ID, 型N);
            case INDEX_5:
                項目名 = その他納入通知書タイプ;
                アイテムとして = ブック口座振替依頼表示;
                帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                ChohyoSeigyoHanyo 帳票_口座振替依頼 = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, アイテムとして);
                return this.getブックタイプ(帳票タイプを, 帳票_口座振替依頼, 帳票分類ID, 出力順ID, 型N);
            case INDEX_6:
                項目名 = その他納入通知書タイプ;
                アイテムとして = コンビニ期毎出力;
                帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                ChohyoSeigyoHanyo 帳票_コンビニ期毎出力 = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, アイテムとして);
                return this.getコンビニ期毎出力(帳票タイプを, 帳票_コンビニ期毎出力, 帳票分類ID, 出力順ID, 型N);
            default:
                return null;
        }
    }

    /**
     * 帳票ID取得
     *
     * @param 調定年度 調定年度
     * @param 算定期 算定期
     * @param chohyoPara chohyoPara
     * @return List<ChohyoResult>
     */
    public List<ChohyoResult> getChohyoID(FlexibleYear 調定年度,
            RString 算定期, List<ChohyoMeter> chohyoPara) {
        List<ChohyoResult> resultList = new ArrayList<>();
        ChohyoResult result;
        if (chohyoPara == null || chohyoPara.isEmpty()) {
            return null;
        }
        for (ChohyoMeter choParameter : chohyoPara) {
            if (特徴開始通知書.equals(choParameter.get帳票分類ID())) {
                result = this.get特徴開始通知書_本算定(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID());
                if (result != null) {
                    resultList.add(result);
                }
            }
            if (特徴開始通知書_仮算定.equals(choParameter.get帳票分類ID())) {
                result = get特徴開始通知書_仮算定(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID());
                if (result != null) {
                    resultList.add(result);
                }
            }
            if (決定通知書_変更通知書.equals(choParameter.get帳票分類ID())) {
                result = get決定通知書(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID(), 調定年度);
                if (result != null) {
                    resultList.add(result);
                }
            }
            if (決定通知書_変更通知書.equals(choParameter.get帳票分類ID())) {
                result = get変更通知書(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID(), 調定年度);
                if (result != null) {
                    resultList.add(result);
                }
            }
            if (納入通知書.equals(choParameter.get帳票分類ID())) {
                result = get納入通知書(choParameter.get帳票分類ID(), 調定年度, 算定期, choParameter.get出力順ID());
                if (result == null) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage().
                            replace("納入通知書の帳票ID").evaluate());
                } else {
                    resultList.add(result);
                }
            }
            if (本算定異動_現年度_結果一覧表.equals(choParameter.get帳票分類ID())) {
                result = new ChohyoResult();
                result.set帳票分類ID(choParameter.get帳票分類ID());
                result.set出力順ID(choParameter.get出力順ID());
                resultList.add(result);
            }
        }
        return resultList;
    }

    /**
     * バッチパラメータ作成 batchParameterクラス
     *
     * @param parameter parameter
     * @return BatchParamResult
     */
    public CreateHonsanteiIdoBatchParameter createBatchParam(SanteiIdoGennen parameter) {
        CreateHonsanteiIdoBatchParameter result = new CreateHonsanteiIdoBatchParameter();
        result.setChoteiNendo(parameter.get調定年度());
        result.set賦課年度(parameter.get賦課年度());
        result.set処理対象(parameter.get処理対象());
        result.set抽出開始日時(parameter.get抽出開始日時());
        result.set抽出終了日時(parameter.get抽出終了日時());
        result.set特徴捕捉分(parameter.get特徴捕捉分());
        result.set依頼金額計算(parameter.get依頼金額計算());
        List<ChohyoResult> choResult = this.getChohyoID(parameter.get調定年度(),
                parameter.get算定期(), parameter.get出力帳票一覧List());
        result.set出力帳票List(choResult);
        if (特徴開始者_12月.equals(parameter.get特徴_出力対象())) {
            result.set特徴_出力対象(twoRS);
        } else if (特徴開始者_2月.equals(parameter.get特徴_出力対象())) {
            result.set特徴_出力対象(threeRS);
        } else if (特徴開始者_4月.equals(parameter.get特徴_出力対象())) {
            result.set特徴_出力対象(fourRS);
        }
        result.set特徴_発行日(parameter.get特徴_発行日());
        result.set決定_チェックボックス(parameter.get決定_チェックボックス());
        result.set決定_文書番号(parameter.get決定_文書番号());
        result.set決定_発行日(parameter.get決定_発行日());
        result.set変更_チェックボックス(parameter.get変更_チェックボックス());
        if (すべて選択.equals(parameter.get変更_対象者())) {
            result.set変更_対象者(twoRS);
        } else if (現金納付者.equals(parameter.get変更_対象者())) {
            result.set変更_対象者(zeroRS);
        } else if (口座振替者.equals(parameter.get変更_対象者())) {
            result.set変更_対象者(oneRS);
        }
        result.set変更_文書番号(parameter.get変更_文書番号());
        result.set変更_発行日(parameter.get変更_発行日());

        if (すべて選択.equals(parameter.get納入_対象者())) {
            result.set納入_対象者(twoRS);
        } else if (現金納付者.equals(parameter.get納入_対象者())) {
            result.set納入_対象者(zeroRS);
        } else if (口座振替者.equals(parameter.get納入_対象者())) {
            result.set納入_対象者(oneRS);
        }

        if (口座用.equals(parameter.get納入_口座振替者())) {
            result.set納入_口座振替者(oneRS);
        } else if (現金用.equals(parameter.get納入_口座振替者())) {
            result.set納入_口座振替者(twoRS);
        }
        result.set納入_発行日(parameter.get納入_発行日());
        if (別々出力.equals(parameter.get納入_出力方法())) {
            result.set納入_出力方法(zeroRS);
        } else if (全件出力.equals(parameter.get納入_出力方法())) {
            result.set納入_出力方法(oneRS);
        }
        result.set納入_出力期(parameter.get納入_出力期());

        if (する.equals(parameter.get納入_生活保護対象者())) {
            result.set納入_生活保護対象者(zeroRS);
        } else if (しない.equals(parameter.get納入_生活保護対象者())) {
            result.set納入_生活保護対象者(oneRS);
        }

        if (する.equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(zeroRS);
        } else if (しない.equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(oneRS);
        }
        result.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        result.set随時フラグ(parameter.is随時フラグ());
        result.set画面移動フラグ(parameter.is画面移動フラグ());
        return result;
    }

    /**
     * 基準日時取得のメソッドます。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理名 RString
     * @return 処理日付管理entity
     */
    public ShoriDateKanri getMax基準日時(FlexibleYear 調定年度, RString 処理名) {
        DbT7022ShoriDateKanriEntity shoriDateKanri = 処理日付管理Dac.selectMax基準日(調定年度, 処理名);
        return new ShoriDateKanri(shoriDateKanri);
    }

    /**
     * 帳票制御汎用キー取得
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo get帳票制御汎用(ReportId 帳票分類ID, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.get帳票制御汎用(帳票分類ID, 項目名);
        if (entity == null) {
            return null;
        } else {
            return new ChohyoSeigyoHanyo(entity);
        }
    }
}
