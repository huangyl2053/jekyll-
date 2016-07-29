/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteifuka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.TsuchishoUchiwakeJoken;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.BatchTyouhyouResult;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.HonsanteifukaParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.TyouhyouParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteifuka.BatchTyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2014TsuchishoUchiwakeJokenDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteifuka.IHonsanteifukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定賦課計算のビジネスクラスです。
 *
 * @reamsid_L DBB-0780-030 xicongwang
 */
public class Honsanteifuka {

    private final MapperProvider mapperProvider;
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT2014TsuchishoUchiwakeJokenDac 通知書打ち分け条件Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private static final RString 区分_ゼロ = new RString("0");
    private static final RString 区分_イチ = new RString("1");
    private static final RString 区分_二 = new RString("2");
    private static final RString キー = new RString("uchiwakeJoken");
    private static final RString 通知書タイプ設定値 = new RString("001");
    private static final RString コンビニマルチ収納タイプ = new RString("301");
    private static final RString コンビニ角公タイプ = new RString("302");
    private static final RString 定値_期毎 = new RString("期毎納入通知書タイプ");
    private static final RString 定値_銀振型5期 = new RString("銀振納入通知書タイプ");
    private static final RString 定値_銀振型4期 = new RString("銀振納入通知書タイプ");
    private static final RString 定値_ブック = new RString("ブックタイプ");
    private static final RString 定値_ブックタイプ = new RString("ブック口座振替依頼表示");
    private static final RString 定値_コンビニ収納 = new RString("コンビニ収納タイプ");
    private static final RString 定値_コンビニ収納タイプ = new RString("コンビニ期毎出力");
    private static final RString 定値_その他タイプ = new RString("その他納入通知書タイプ");
    private static final RString 定値_その他 = new RString("その他（カスタマイズ）");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名_通知書タイプ = new RString("通知書タイプ");
    private static final RString 項目名_追加候補者用通知書タイプ = new RString("追加候補者用通知書タイプ");
    private static final RString 項目名_追加候補者用連帳区分 = new RString("追加候補者用連帳区分");
    private static final RString 標準版B5横_連帳 = new RString("0011");
    private static final RString 標準版B5横_カット紙 = new RString("0010");
    private static final RString 標準B5_連帳 = new RString("0021");
    private static final RString 標準B5_カット紙 = new RString("0020");
    private static final RString 標準版A4縦_連帳 = new RString("0031");
    private static final RString 標準版A4縦_カット紙 = new RString("0030");
    private static final RString 標準シーラ_連帳 = new RString("1011");
    private static final RString 標準シーラ_カット紙 = new RString("1010");
    private static final RString 通知書タイプ_B5横 = new RString("001");
    private static final RString 通知書タイプ_A4縦 = new RString("002");
    private static final ReportId 特徴開始通知書_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final int 設定値_番号1 = 1;
    private static final int 設定値_番号2 = 2;
    private static final int 設定値_番号0 = 0;
    private static final int 設定値_番号4 = 4;
    private static final int 設定値_番号5 = 5;
    private static final int 設定値_番号6 = 6;
    private static final int 設定値_番号9 = 9;
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
    private static final RString 特徴出力対象_本算定 = new RString("本算定分");
    private static final RString 納入出力方法_別々出力 = new RString("別々出力");
    private static final RString 納入出力方法_全件出力 = new RString("全件出力");
    private static final RString 納入対象者_すべて = new RString("すべて選択");
    private static final RString 納入対象者_現金 = new RString("現金納付者");
    private static final RString 納入対象者_口座 = new RString("口座振替者");
    private static final RString 区分_する = new RString("する");
    private static final RString 区分_しない = new RString("しない");

    /**
     * コンストラクタです。
     */
    public Honsanteifuka() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.通知書打ち分け条件Dac = InstanceProvider.create(DbT2014TsuchishoUchiwakeJokenDac.class);
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
    Honsanteifuka(MapperProvider mapperProvider,
            DbT7022ShoriDateKanriDac 処理日付管理Dac,
            DbT2014TsuchishoUchiwakeJokenDac 通知書打ち分け条件Dac,
            DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.mapperProvider = mapperProvider;
        this.処理日付管理Dac = 処理日付管理Dac;
        this.通知書打ち分け条件Dac = 通知書打ち分け条件Dac;
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link Honsanteifuka}のインスタンスを返します。
     *
     * @return Honsanteifuka
     */
    public static Honsanteifuka createInstance() {
        return InstanceProvider.create(Honsanteifuka.class);
    }

    /**
     * 処理状況取得メソッドです。
     *
     * @param 遷移元区分 遷移元区分
     * @param 調定年度 調定年度
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> getShoriDateKanriList(RString 遷移元区分, FlexibleYear 調定年度) {
        List<DbT7022ShoriDateKanriEntity> entityList = new ArrayList<>();
        if (区分_ゼロ.equals(遷移元区分)) {
            entityList = 処理日付管理Dac.select処理状況_賦課(調定年度);
        } else if (区分_イチ.equals(遷移元区分)) {
            entityList = 処理日付管理Dac.select処理状況_通知書作成(調定年度);
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
     * 打分け方法情報の取得処理１メソッドです。
     *
     * @return List<TsuchishoUchiwakeJoken>
     */
    public List<TsuchishoUchiwakeJoken> getutiwakehouhoujyoho1() {
        IHonsanteifukaMapper mapper = mapperProvider.create(IHonsanteifukaMapper.class);
        List<DbT2014TsuchishoUchiwakeJokenEntity> entityList = mapper.get通知書打ち分け条件();
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        List<TsuchishoUchiwakeJoken> jokenList = new ArrayList<>();
        for (DbT2014TsuchishoUchiwakeJokenEntity entity : entityList) {
            jokenList.add(new TsuchishoUchiwakeJoken(entity));
        }
        return jokenList;
    }

    /**
     * 打分け方法情報の取得処理２メソッドです。
     *
     * @param 打分け方法 打分け方法
     * @return List<TsuchishoUchiwakeJoken>
     */
    public List<TsuchishoUchiwakeJoken> getutiwakehouhoujyoho2(RString 打分け方法) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー.toString(), 打分け方法);
        IHonsanteifukaMapper mapper = mapperProvider.create(IHonsanteifukaMapper.class);
        List<DbT2014TsuchishoUchiwakeJokenEntity> entityList = mapper.get打分け方法情報一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        List<TsuchishoUchiwakeJoken> jokenList = new ArrayList<>();
        for (DbT2014TsuchishoUchiwakeJokenEntity entity : entityList) {
            jokenList.add(new TsuchishoUchiwakeJoken(entity));
        }
        return jokenList;
    }

    /**
     * 打分け方法情報の登録処理１メソッドです。
     *
     * @param joken joken
     */
    public void regutiwakehouhoujyoho1(TsuchishoUchiwakeJoken joken) {
        if (joken != null) {
            DbT2014TsuchishoUchiwakeJokenEntity entity = joken.toEntity();
            entity.setState(EntityDataState.Added);
            通知書打ち分け条件Dac.save(entity);
        }
    }

    /**
     * 打分け方法情報の登録処理２メソッドです。
     *
     * @param joken joken
     * @param 変更区分 変更区分
     */
    public void regutiwakehouhoujyoho2(TsuchishoUchiwakeJoken joken, RString 変更区分) {
        if (joken != null) {
            DbT2014TsuchishoUchiwakeJokenEntity entity = joken.toEntity();
            entity.setState(EntityDataState.Added);
            通知書打ち分け条件Dac.save(entity);
        }
    }

    /**
     * 帳票制御汎用キー取得メソッドです。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo getChohyoHanyoKey(SubGyomuCode サブ業務コード, ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(サブ業務コード, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

    /**
     * 帳票ID取得メソッドです。
     *
     * @param 調定年度 調定年度
     * @param 算定期 算定期
     * @param parameterList parameterList
     * @return List<BatchTyouhyouResult>
     * @throws ApplicationException Exception
     */
    public List<BatchTyouhyouResult> getChohyoID(FlexibleYear 調定年度, RString 算定期, List<TyouhyouParameter> parameterList)
            throws ApplicationException {
        if (parameterList == null || parameterList.isEmpty()) {
            return null;
        }
        List<BatchTyouhyouResult> resultList = new ArrayList<>();
        for (TyouhyouParameter parameter : parameterList) {
            if (特徴開始通知書_帳票分類ID.equals(parameter.get帳票分類ID())) {
                BatchTyouhyouResult 特徴開始通知書_帳票ID = get特徴開始通知書_帳票ID(parameter);
                resultList.add(特徴開始通知書_帳票ID);
            } else if (決定変更通知書_帳票分類ID.equals(parameter.get帳票分類ID())) {
                BatchTyouhyouResult 決定通知書_帳票ID = get決定通知書_帳票ID(調定年度, parameter);
                resultList.add(決定通知書_帳票ID);
                BatchTyouhyouResult 変更通知書_帳票ID = get変更通知書_帳票ID(調定年度, parameter);
                resultList.add(変更通知書_帳票ID);
            } else if (納入通知書_帳票分類ID.equals(parameter.get帳票分類ID())) {
                BatchTyouhyouEntity 納入通知書 = get納入通知書_帳票ID(調定年度, 算定期, parameter);
                if (納入通知書 == null) {
                    throw new ApplicationException(DbbErrorMessages.帳票ID取得不可のため処理不可.getMessage());
                }
                resultList.add(new BatchTyouhyouResult(納入通知書));
            } else {
                resultList.add(new BatchTyouhyouResult(new BatchTyouhyouEntity(parameter.get帳票分類ID(), null, parameter.get出力順ID())));
            }
        }
        return resultList;
    }

    /**
     * 特徴開始通知書(本算定）が選択される場合の帳票IDを取得メソッドです。
     *
     * @param parameter parameter
     * @return BatchTyouhyouResult
     */
    private BatchTyouhyouResult get特徴開始通知書_帳票ID(TyouhyouParameter parameter) {
        ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, parameter.get帳票分類ID(),
                管理年度, 項目名_追加候補者用通知書タイプ);
        ChohyoSeigyoHanyo 連帳区分 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, parameter.get帳票分類ID(),
                管理年度, 項目名_追加候補者用連帳区分);
        ReportId 帳票ID = null;
        if (帳票タイプ != null && 連帳区分 != null) {
            RStringBuilder builder = new RStringBuilder();
            RString 帳票タイプ_連帳区分 = builder.append(帳票タイプ.get設定値()).append(連帳区分.get設定値()).toRString();
            if (標準版B5横_連帳.equals(帳票タイプ_連帳区分)) {
                帳票ID = ReportIdDBB.DBB100033.getReportId();
            } else if (標準版B5横_カット紙.equals(帳票タイプ_連帳区分)) {
                帳票ID = ReportIdDBB.DBB100032.getReportId();
            } else if (標準B5_連帳.equals(帳票タイプ_連帳区分)) {
                帳票ID = ReportIdDBB.DBB100037.getReportId();
            } else if (標準B5_カット紙.equals(帳票タイプ_連帳区分)) {
                帳票ID = ReportIdDBB.DBB100036.getReportId();
            } else if (標準版A4縦_連帳.equals(帳票タイプ_連帳区分) || 標準版A4縦_カット紙.equals(帳票タイプ_連帳区分)) {
                帳票ID = ReportIdDBB.DBB100038.getReportId();
            } else if (標準シーラ_連帳.equals(帳票タイプ_連帳区分)) {
                帳票ID = ReportIdDBB.DBB100035.getReportId();
            } else if (標準シーラ_カット紙.equals(帳票タイプ_連帳区分)) {
                帳票ID = ReportIdDBB.DBB100034.getReportId();
            }
        }
        return new BatchTyouhyouResult(new BatchTyouhyouEntity(parameter.get帳票分類ID(), 帳票ID, parameter.get出力順ID()));
    }

    /**
     * 決定通知書の帳票IDを取得メソッドです。
     *
     * @param 調定年度 調定年度
     * @param parameter parameter
     * @return BatchTyouhyouResult
     */
    private BatchTyouhyouResult get決定通知書_帳票ID(FlexibleYear 調定年度, TyouhyouParameter parameter) {
        ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, parameter.get帳票分類ID(),
                調定年度, 項目名_通知書タイプ);
        ReportId 帳票ID = null;
        if (帳票タイプ != null) {
            if (通知書タイプ_B5横.equals(帳票タイプ.get設定値())) {
                帳票ID = ReportIdDBB.DBB100039.getReportId();
            } else if (通知書タイプ_A4縦.equals(帳票タイプ.get設定値())) {
                帳票ID = ReportIdDBB.DBB100040.getReportId();
            }
        }
        return new BatchTyouhyouResult(new BatchTyouhyouEntity(parameter.get帳票分類ID(), 帳票ID, parameter.get出力順ID()));
    }

    /**
     * 変更通知書の帳票IDを取得メソッドです。
     *
     * @param 調定年度 調定年度
     * @param parameter parameter
     * @return BatchTyouhyouResult
     */
    private BatchTyouhyouResult get変更通知書_帳票ID(FlexibleYear 調定年度, TyouhyouParameter parameter) {
        ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, parameter.get帳票分類ID(),
                調定年度, 項目名_通知書タイプ);
        ReportId 帳票ID = null;
        if (帳票タイプ != null) {
            if (通知書タイプ_B5横.equals(帳票タイプ.get設定値())) {
                帳票ID = ReportIdDBB.DBB100042.getReportId();
            } else if (通知書タイプ_A4縦.equals(帳票タイプ.get設定値())) {
                帳票ID = ReportIdDBB.DBB100043.getReportId();
            }
        }
        return new BatchTyouhyouResult(new BatchTyouhyouEntity(parameter.get帳票分類ID(), 帳票ID, parameter.get出力順ID()));
    }

    /**
     * 納入通知書の帳票IDを取得メソッドです。
     *
     * @param 調定年度 調定年度
     * @param 出力期 出力期
     * @param parameter parameter
     * @return BatchTyouhyouEntity
     */
    private BatchTyouhyouEntity get納入通知書_帳票ID(FlexibleYear 調定年度, RString 出力期, TyouhyouParameter parameter) {

        RString 項目名 = set項目名(出力期);
        RString 納通連帳区分 = get普徴期情報_納通連帳区分(出力期);
        if (定値_ブック.equals(項目名)) {
            項目名 = 定値_その他タイプ;
        } else if (定値_コンビニ収納.equals(項目名)) {
            項目名 = 定値_コンビニ収納タイプ;
        }
        ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, parameter.get帳票分類ID(),
                調定年度, 項目名);
        if (帳票タイプ == null) {
            return null;
        }
        ReportId 帳票ID = get通知書帳票ID(調定年度, 項目名, 納通連帳区分, 帳票タイプ);
        if (帳票ID == null) {
            return null;
        }
        return new BatchTyouhyouEntity(parameter.get帳票分類ID(), 帳票ID, parameter.get出力順ID());
    }

    private RString set項目名(RString 出力期) {

        RString 設定値 = 区分_ゼロ;
        RDate 運用日 = RDate.getNowDate();
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
        return get項目名(設定値);
    }

    private RString get項目名(RString 設定値) {
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

    private ReportId get通知書帳票ID(FlexibleYear 調定年度, RString 項目名,
            RString 納通連帳区分, ChohyoSeigyoHanyo 帳票タイプ) {
        ReportId 帳票ID = get通知書帳票ID(項目名, 納通連帳区分, 帳票タイプ);
        if (帳票ID != null) {
            return 帳票ID;
        }
        if (定値_その他タイプ.equals(項目名) && 通知書タイプ設定値.equals(帳票タイプ.get設定値())) {
            return getブックタイプ_帳票ID(調定年度, 定値_ブックタイプ, 納通連帳区分, 帳票タイプ);
        } else if (定値_コンビニ収納タイプ.equals(項目名) && 区分_ゼロ.equals(帳票タイプ.get設定値())) {
            return getその他納入通知書_帳票ID(調定年度, 定値_その他タイプ, 納通連帳区分, 帳票タイプ);
        } else if (定値_コンビニ収納タイプ.equals(項目名) && 区分_イチ.equals(帳票タイプ.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100063.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100064.getReportId();
            }
        }
        return null;
    }

    private ReportId get通知書帳票ID(RString 項目名, RString 納通連帳区分, ChohyoSeigyoHanyo 帳票タイプ) {
        if (定値_期毎.equals(項目名) && 通知書タイプ設定値.equals(帳票タイプ.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100045.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100046.getReportId();
            }
        } else if (定値_銀振型5期.equals(項目名) && 通知書タイプ設定値.equals(帳票タイプ.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100053.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100054.getReportId();
            }
        } else if (定値_銀振型4期.equals(項目名) && 通知書タイプ設定値.equals(帳票タイプ.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100051.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100052.getReportId();
            }
        }
        return null;
    }

    private RString get普徴期情報_納通連帳区分(RString 出力期) {

        RDate 運用日 = RDate.getNowDate();
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

    private ReportId getブックタイプ_帳票ID(FlexibleYear 調定年度, RString 項目名,
            RString 納通連帳区分, ChohyoSeigyoHanyo 帳票タイプ) {
        ChohyoSeigyoHanyo 帳票制御汎用 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票タイプ.get帳票分類ID(),
                調定年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        if (区分_ゼロ.equals(帳票制御汎用.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100056.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100058.getReportId();
            }
        } else if (区分_イチ.equals(帳票制御汎用.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100055.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100057.getReportId();
            }
        }
        return null;
    }

    private ReportId getその他納入通知書_帳票ID(FlexibleYear 調定年度, RString 項目名,
            RString 納通連帳区分, ChohyoSeigyoHanyo 帳票タイプ) {
        ChohyoSeigyoHanyo 帳票制御汎用 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票タイプ.get帳票分類ID(),
                調定年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        if (コンビニマルチ収納タイプ.equals(帳票制御汎用.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100061.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100062.getReportId();
            }
        } else if (コンビニ角公タイプ.equals(帳票制御汎用.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100059.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100060.getReportId();
            }
        }
        return null;
    }

    /**
     * バッチ用パラメータ作成メソッドです。
     *
     * @param parameter parameter
     * @return BatchresultParameter
     */
    public HonsanteifukaBatchParameter createhonsanteifukaBatchParameter(HonsanteifukaParameter parameter) {
        List<BatchTyouhyouResult> resultList
                = getChohyoID(parameter.get調定年度(), parameter.get算定期(), parameter.get出力帳票一覧List());
        List<HonsanteifukaBatchTyouhyou> honsanteifukaBatchTyouhyouList = new ArrayList<>();
        if (resultList == null || resultList.isEmpty()) {
            return null;
        }
        for (BatchTyouhyouResult result : resultList) {
            HonsanteifukaBatchTyouhyou honsanteifukaBatchTyouhyou = new HonsanteifukaBatchTyouhyou();
            if (result != null) {
                honsanteifukaBatchTyouhyou.set帳票分類ID(result.getEntity().get帳票分類ID());
                honsanteifukaBatchTyouhyou.set帳票ID(result.getEntity().get帳票ID());
                honsanteifukaBatchTyouhyou.set出力順ID(result.getEntity().get出力順ID());
                honsanteifukaBatchTyouhyouList.add(honsanteifukaBatchTyouhyou);
            }
        }
        HonsanteifukaBatchParameter result = new HonsanteifukaBatchParameter();
        result.set調定年度(parameter.get調定年度());
        result.set賦課年度(parameter.get賦課年度());
        result.set資格基準日(parameter.get資格基準日());
        result.set出力帳票一覧(honsanteifukaBatchTyouhyouList);
        if (特徴出力対象_本算定.equals(parameter.get特徴_出力対象())) {
            result.set特徴_出力対象(区分_イチ);
        }
        result.set特徴_発行日(parameter.get特徴_発行日());
        result.set決定変更_文書番号(parameter.get文書番号());
        result.set決定変更_発行日(parameter.get決定変更_発行日());
        if (納入出力方法_別々出力.equals(parameter.get納入_出力方法())) {
            result.set納入_出力方法(区分_ゼロ);
        } else if (納入出力方法_全件出力.equals(parameter.get納入_出力方法())) {
            result.set納入_出力方法(区分_イチ);
        }
        result.set納入_出力期(parameter.get出力期());
        if (parameter.get納入_対象者() != null && !parameter.get納入_対象者().isEmpty()) {
            for (RString 納入_対象者 : parameter.get納入_対象者()) {
                if (納入対象者_すべて.equals(納入_対象者)) {
                    result.set納入_対象者(区分_二);
                    break;
                } else if (納入対象者_現金.equals(納入_対象者)) {
                    result.set納入_対象者(区分_ゼロ);
                } else if (納入対象者_口座.equals(納入_対象者)) {
                    result.set納入_対象者(区分_イチ);
                }
            }
        }
        result.set納入_発行日(parameter.get納入_発行日());
        if (区分_する.equals(parameter.get納入_生活保護対象者をまとめて先頭に出力())) {
            result.set納入_生活保護対象者をまとめて先頭に出力(区分_ゼロ);
        } else if (区分_しない.equals(parameter.get納入_生活保護対象者をまとめて先頭に出力())) {
            result.set納入_生活保護対象者をまとめて先頭に出力(区分_イチ);
        }
        if (区分_する.equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(区分_ゼロ);
        } else if (区分_しない.equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(区分_イチ);
        }
        result.set打分け条件情報(parameter.get打分け条件情報());
        result.set処理日時(RDate.getNowDateTime());
        result.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        return result;
    }
}
