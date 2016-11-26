/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteiidokanendo.HonsanteiIdoDivParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteiidokanendo.HonsanteiIdoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB051001.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB055001.DBB055001_KanendoIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB055003.DBB055003_KanendoIdoTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendo.HonsanteiIdoKanendoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendo.IHonsanteiIdoKanendoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ45001_本算定異動（過年度）
 *
 * @reamsid_L DBB-0920-020 quxiaodong
 */
public class HonsanteiIdoKanendo {

    private static final RString 定数調定年度 = new RString("調定年度");
    private static final RString 定数処理名 = new RString("処理名");
    private final RString 通知書タイプ = new RString("通知書タイプ");
    private final RString zeroRS = new RString("0");
    private final RString oneRS = new RString("1");
    private final RString twoRS = new RString("2");
    private final RString threeRS = new RString("3");
    private final RString zOneRS = new RString("001");
    private final RString twlZRS = new RString("301");
    private final RString twlTRS = new RString("302");
    private final RString zOneOneRS = new RString("0001");
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
    private static final int 定値_14期 = 14;
    private static final int 定値_15期 = 15;
    private final RString 納入通知書の帳票ID = new RString("納入通知書の帳票ID");
    private final RString 期毎納入通知書タイプ = new RString("期毎納入通知書タイプ");
    private final RString 銀振納入通知書タイプ = new RString("銀振納入通知書タイプ");
    private final RString その他納入通知書タイプ = new RString("その他納入通知書タイプ");
    private final RString ブック口座振替依頼表示 = new RString("ブック口座振替依頼表示");
    private final RString コンビニ期毎出力 = new RString("コンビニ期毎出力");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public HonsanteiIdoKanendo() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HonsanteiIdoKanendo}のインスタンス
     */
    public static HonsanteiIdoKanendo createInstance() {
        return InstanceProvider.create(HonsanteiIdoKanendo.class);
    }

    /**
     * 最大基準日時取得
     *
     * @param 処理名 RString
     * @param 調定年度 FlexibleYear
     * @return ShoriDateKanri
     */
    public ShoriDateKanri get最大基準日時(RString 処理名, FlexibleYear 調定年度) {
        SubGyomuCode サブ業務コード = SubGyomuCode.DBB介護賦課;
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(定数処理名.toString()));
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(定数調定年度.toString()));
        DbT7022ShoriDateKanriEntity entity = 処理日付管理Dac.select最大基準日時(サブ業務コード, 処理名, zOneOneRS, 調定年度);
        return new ShoriDateKanri(entity);
    }

    /**
     *
     * @return RDateTime
     */
    public RDateTime get処理日時() {
        IHonsanteiIdoKanendoMapper mapper = mapperProvider.create(IHonsanteiIdoKanendoMapper.class);
        HonsanteiIdoKanendoEntity entity = mapper.select確定日時();
        if (entity != null) {
            return entity.get確定日時();
        }
        return null;
    }

    /**
     * 抽出開始日時取得
     *
     * @param 調定年度 FlexibleYear
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 RString
     * @return ShoriDateKanri
     */
    public ShoriDateKanri getShuchutsuKaishiJikan(FlexibleYear 調定年度, SubGyomuCode サブ業務コード, RString 処理名) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(定数調定年度.toString()));
        DbT7022ShoriDateKanriEntity entity = 処理日付管理Dac.
                select抽出開始日時_本算定異動_過年度(調定年度, 処理名, サブ業務コード);
        return new ShoriDateKanri(entity);
    }

    /**
     * 処理状況取得
     *
     * @param 調定年度 FlexibleYear
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> getShoriJokyo(FlexibleYear 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(定数調定年度.toString()));
        List<DbT7022ShoriDateKanriEntity> entityList = new ArrayList<>();
        List<ShoriDateKanri> kanriList = new ArrayList<>();
        DbT7022ShoriDateKanriEntity shentity = 処理日付管理Dac.selectByFourKeys(
                SubGyomuCode.DBB介護賦課, ShoriName.過年度賦課.get名称(), new RString("0001"), 調定年度);
        if (shentity == null) {
            return new ArrayList<>();
        }
        entityList.add(shentity);
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            kanriList.add(new ShoriDateKanri(entity));
        }
        return kanriList;
    }

    /**
     * 帳票ID取得
     *
     * @param 調定年度 FlexibleYear
     * @param 算定期 RString
     * @param chohyoPara List<HonsanteiIdoParameter>
     * @param 決定_変更通知書区分 RString
     * @return List<HonsanteiIdoKanendoResult>
     */
    public List<ChohyoResult> getChohyoID(FlexibleYear 調定年度,
            RString 算定期, List<HonsanteiIdoParameter> chohyoPara, RString 決定_変更通知書区分) {
        List<ChohyoResult> resultList = new ArrayList<>();
        if (chohyoPara == null || chohyoPara.isEmpty()) {
            return null;
        }
        for (HonsanteiIdoParameter choParameter : chohyoPara) {
            if (決定変更通知書_帳票分類ID.equals(choParameter.get帳票分類ID())) {
                if (oneRS.equals(決定_変更通知書区分) || threeRS.equals(決定_変更通知書区分)) {
                    ChohyoResult result1 = get決定通知書(choParameter.get帳票分類ID(),
                            choParameter.get出力順ID(), 調定年度);
                    resultList.add(result1);
                }
                if (twoRS.equals(決定_変更通知書区分) || threeRS.equals(決定_変更通知書区分)) {
                    ChohyoResult result2 = get変更通知書(choParameter.get帳票分類ID(),
                            choParameter.get出力順ID(), 調定年度);
                    resultList.add(result2);
                }
            }
            if (納入通知書_帳票分類ID.equals(choParameter.get帳票分類ID())) {
                ChohyoResult result = get納入通知書(choParameter.get帳票分類ID(), 調定年度,
                        算定期, choParameter.get出力順ID());
                if (result == null) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage().
                            replace(納入通知書の帳票ID.toString()).evaluate());
                } else {
                    resultList.add(result);
                }
            }
            if (ReportIdDBB.DBB200027.getReportId().equals(choParameter.get帳票分類ID())) {
                ChohyoResult result = new ChohyoResult();
                result.set帳票ID(ReportIdDBB.DBB200027.getReportId().value());
                result.set帳票分類ID(choParameter.get帳票分類ID());
                result.set出力順ID(choParameter.get出力順ID());
                resultList.add(result);
            }
        }
        return resultList;
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
     * バッチパラメータ作成 batchParameterクラス
     *
     * @param parameter parameter
     * @return BatchParamResult
     */
    public DBB055003_KanendoIdoTsuchishoHakkoParameter createBatchParam(HonsanteiIdoDivParameter parameter) {
        DBB055003_KanendoIdoTsuchishoHakkoParameter result = new DBB055003_KanendoIdoTsuchishoHakkoParameter();
        result.set調定年度(parameter.get調定年度());
        RString 決定_変更通知書区分 = RString.EMPTY;
        if (parameter.get決定_チェックボックス().equals(oneRS)) {
            決定_変更通知書区分 = oneRS;
        }
        if (parameter.get変更_チェックボックス().equals(oneRS)) {
            決定_変更通知書区分 = twoRS;
        }
        if (parameter.get決定_チェックボックス().equals(oneRS)
                && parameter.get変更_チェックボックス().equals(oneRS)) {
            決定_変更通知書区分 = threeRS;
        }
        List<ChohyoResult> 出力帳票 = getChohyoID(parameter.get調定年度(),
                parameter.get算定期(), parameter.get出力帳票一覧(), 決定_変更通知書区分);
        result.set出力帳票List(出力帳票);
        result.set決定_チェックボックス(parameter.get決定_チェックボックス());
        result.set決定_対象賦課年度(parameter.get決定_対象賦課年度());
        result.set決定_発行日(parameter.get決定_発行日());
        result.set決定_文書番号(parameter.get決定_文書番号());
        result.set変更_チェックボックス(parameter.get変更_チェックボックス());
        result.set変更_対象賦課年度(parameter.get変更_対象賦課年度());
        result.set変更_発行日(parameter.get変更_発行日());
        result.set変更_文書番号(parameter.get変更_文書番号());
        result.set変更_対象者(parameter.get変更_対象者());
        result.set納入_対象賦課年度(parameter.get納入_対象賦課年度());
        result.set納入_発行日(parameter.get納入_発行日());
        result.set納入_出力期(parameter.get納入_出力期());
        result.set納入_対象者(parameter.get納入_対象者());
        result.set納入_口座振替様式(parameter.get納入_口座振替様式());
        result.set納入_先頭出力(parameter.get納入_生活保護対象者());
        result.set納入_ページ山分け(parameter.get納入_ページごとに山分け());
        result.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        return result;
    }

    /**
     * 本算定異動（過年度）バッチパラメータ作成 batchParameterクラス
     *
     * @param parameter parameter
     * @return BatchParamResult
     */
    public DBB055001_KanendoIdoFukaParameter createIdoBatchParam(HonsanteiIdoDivParameter parameter) {
        DBB055001_KanendoIdoFukaParameter result = new DBB055001_KanendoIdoFukaParameter();
        result.set調定年度(parameter.get調定年度());
        RString 決定_変更通知書区分 = RString.EMPTY;
        if (parameter.get決定_チェックボックス().equals(oneRS)) {
            決定_変更通知書区分 = oneRS;
        }
        if (parameter.get変更_チェックボックス().equals(oneRS)) {
            決定_変更通知書区分 = twoRS;
        }
        if (parameter.get決定_チェックボックス().equals(oneRS)
                && parameter.get変更_チェックボックス().equals(oneRS)) {
            決定_変更通知書区分 = threeRS;
        }
        List<ChohyoResult> 出力帳票 = getChohyoID(parameter.get調定年度(),
                parameter.get算定期(), parameter.get出力帳票一覧(), 決定_変更通知書区分);
        result.set出力帳票List(出力帳票);
        result.set処理対象(parameter.get処理対象());
        if (parameter.get抽出開始日時() != null) {
            result.set抽出開始日時(parameter.get抽出開始日時().getRDateTime());
        }
        if (parameter.get抽出終了日時() != null) {
            result.set抽出終了日時(parameter.get抽出終了日時().getRDateTime());
        }
        result.set決定_チェックボックス(parameter.get決定_チェックボックス());
        result.set決定_対象賦課年度(parameter.get決定_対象賦課年度());
        result.set決定_発行日(parameter.get決定_発行日());
        result.set決定_文書番号(parameter.get決定_文書番号());
        result.set変更_チェックボックス(parameter.get変更_チェックボックス());
        result.set変更_対象賦課年度(parameter.get変更_対象賦課年度());
        result.set変更_発行日(parameter.get変更_発行日());
        result.set変更_文書番号(parameter.get変更_文書番号());
        result.set変更_対象者(parameter.get変更_対象者());
        result.set納入_対象賦課年度(parameter.get納入_対象賦課年度());
        result.set納入_発行日(parameter.get納入_発行日());
        result.set納入_出力期(parameter.get納入_出力期());
        result.set納入_対象者(parameter.get納入_対象者());
        result.set納入_口座振替様式(parameter.get納入_口座振替様式());
        result.set納入_先頭出力(parameter.get納入_生活保護対象者());
        result.set納入_ページ山分け(parameter.get納入_ページごとに山分け());
        result.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        return result;
    }

    private ChohyoResult get決定通知書(ReportId 帳票分類ID, RString 出力順ID, FlexibleYear 調定年度) {
        ChohyoSeigyoHanyo 帳票タイプを = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
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

    private ChohyoResult get変更通知書(ReportId 帳票分類ID, RString 出力順ID, FlexibleYear 調定年度) {
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

    private RString get納付書の型(int 月) {
        RDate 調定年月日 = RDate.getNowDate();

        switch (月) {
            case 定値_1期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型10, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_2期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型11, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_3期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型12, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_4期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型1, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_5期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型2, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_6期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型3, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_7期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型4, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_8期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型5, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_9期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型6, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_10期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型7, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_11期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型8, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_12期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型9, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_14期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型13, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_15期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型14, 調定年月日, SubGyomuCode.DBB介護賦課);
            default:
                return zeroRS;
        }
    }

    private ChohyoResult get期毎タイプ(ChohyoSeigyoHanyo 帳票タイプを, ReportId 帳票分類ID,
            RString 出力順ID) {
        if (zOneRS.equals(帳票タイプを.get設定値())) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100066.getReportId().value(), 出力順ID);
        }
        return null;
    }

    private ChohyoResult get銀振型5期タイプ(ChohyoSeigyoHanyo 帳票タイプを,
            ReportId 帳票分類ID, RString 出力順ID) {
        if (zOneRS.equals(帳票タイプを.get設定値())) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100070.getReportId().value(), 出力順ID);
        }
        return null;
    }

    private ChohyoResult get銀振型４期タイプ(ChohyoSeigyoHanyo 帳票タイプを, ReportId 帳票分類ID,
            RString 出力順ID) {
        if (zOneRS.equals(帳票タイプを.get設定値())) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100069.getReportId().value(), 出力順ID);
        }
        return null;
    }

    private ChohyoResult getブックタイプ(ChohyoSeigyoHanyo 帳票タイプを, ChohyoSeigyoHanyo 帳票_口座振替依頼,
            ReportId 帳票分類ID,
            RString 出力順ID) {
        if (zOneRS.equals(帳票タイプを.get設定値())) {
            if (zeroRS.equals(帳票_口座振替依頼.get設定値())) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100072.getReportId().value(), 出力順ID);
            } else if (oneRS.equals(帳票_口座振替依頼.get設定値())) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100071.getReportId().value(), 出力順ID);
            }
        }
        return null;
    }

    private ChohyoResult getコンビニ収納タイプ(
            ChohyoSeigyoHanyo 帳票タイプを,
            ChohyoSeigyoHanyo 帳票_コンビニ期毎出力,
            ReportId 帳票分類ID,
            RString 出力順ID) {
        if (zeroRS.equals(帳票_コンビニ期毎出力.get設定値())) {
            if (twlZRS.equals(帳票タイプを.get設定値())) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100075.getReportId().value(), 出力順ID);
            } else if (twlTRS.equals(帳票タイプを.get設定値())) {
                return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100073.getReportId().value(), 出力順ID);
            }
        } else if (oneRS.equals(帳票_コンビニ期毎出力.get設定値())) {
            return new ChohyoResult(帳票分類ID, ReportIdDBB.DBB100076.getReportId().value(), 出力順ID);
        }
        return null;
    }

    private ChohyoResult get納入通知書(
            ReportId 帳票分類ID, FlexibleYear 調定年度, RString 算定期, RString 出力順ID) {
        RString 項目名;
        RString アイテムとして;
        ChohyoSeigyoHanyo 帳票タイプ;
        int 月 = new FuchoKiUtil().get期月リスト().get期の最初月(Integer.parseInt(算定期.toString())).get月AsInt();
        RString 設定値 = get納付書の型(月);
        switch (Integer.parseInt(設定値.toString())) {
            case 定値_1期:
                項目名 = 期毎納入通知書タイプ;
                帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                return get期毎タイプ(帳票タイプ, 帳票分類ID, 出力順ID);
            case 定値_2期:
                項目名 = 銀振納入通知書タイプ;
                帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                return get銀振型5期タイプ(帳票タイプ, 帳票分類ID, 出力順ID);
            case 定値_4期:
                項目名 = 銀振納入通知書タイプ;
                帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                return get銀振型４期タイプ(帳票タイプ, 帳票分類ID, 出力順ID);
            case 定値_5期:
                項目名 = その他納入通知書タイプ;
                アイテムとして = ブック口座振替依頼表示;
                帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                ChohyoSeigyoHanyo 帳票_口座振替依頼 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        調定年度, アイテムとして);
                return getブックタイプ(帳票タイプ, 帳票_口座振替依頼, 帳票分類ID, 出力順ID);
            case 定値_6期:
                項目名 = その他納入通知書タイプ;
                アイテムとして = コンビニ期毎出力;
                帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                ChohyoSeigyoHanyo 帳票_コンビニ期毎出力 = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課,
                        帳票分類ID, 調定年度, アイテムとして);
                return getコンビニ収納タイプ(帳票タイプ, 帳票_コンビニ期毎出力, 帳票分類ID, 出力順ID);
            default:
                return null;
        }
    }

}
