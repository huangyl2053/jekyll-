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
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendo.HonsanteiIdoKanendoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendo.HonsanteiIdoKanendoResult;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ45001_本算定異動（過年度）
 *
 * @reamsid_L DBB-0920-020 quxiaodong
 */
public class HonsanteiIdoKanendo {

    private static final RString 定数調定年度 = new RString("調定年度");
    private final RString 通知書タイプ = new RString("通知書タイプ");
    private final RString zeroRS = new RString("0");
    private final RString oneRS = new RString("1");
    private final RString twoRS = new RString("2");
    private final RString zOneRS = new RString("001");
    private final RString twlZRS = new RString("301");
    private final RString twlTRS = new RString("302");
    private final RString 納入通知書の帳票ID = new RString("納入通知書の帳票ID");
    private final RString 期毎納入通知書タイプ = new RString("期毎納入通知書タイプ");
    private final RString 銀振納入通知書タイプ = new RString("銀振納入通知書タイプ");
    private final RString その他納入通知書タイプ = new RString("その他納入通知書タイプ");
    private final RString コンビニ期毎タイプ = new RString("コンビニ期毎タイプ");
    private final RString ブック口座振替依頼表示 = new RString("ブック口座振替依頼表示");
    private final RString コンビニ期毎出力 = new RString("コンビニ期毎出力");
    private final RString 口座用 = new RString("口座用");
    private final RString 現金用 = new RString("現金用");
    private final RString する = new RString("する");
    private final RString しない = new RString("しない");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;

    /**
     * コンストラクタです。
     */
    public HonsanteiIdoKanendo() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
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
     * 抽出開始日時取得
     *
     * @param 調定年度 FlexibleYear
     * @return ShoriDateKanri
     */
    public ShoriDateKanri getShuchutsuKaishiJikan(FlexibleYear 調定年度) {
        SubGyomuCode サブ業務コード = SubGyomuCode.DBB介護賦課;
        RString 処理名 = ShoriName.過年度賦課.get名称();
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
        DbT7022ShoriDateKanriEntity shentity = 処理日付管理Dac.
                select処理状況_本算定異動_過年度(調定年度);
        entityList.add(shentity);
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            kanriList.add(new ShoriDateKanri(entity));
        }
        if (kanriList.isEmpty()) {
            return new ArrayList<>();
        }
        return kanriList;
    }

    /**
     * 帳票ID取得
     *
     * @param 調定年度 調定年度
     * @param 算定期 算定期
     * @param chohyoPara HonsanteiIdoParameter
     * @return List<HonsanteiIdoKanendoResult>
     */
    public List<HonsanteiIdoKanendoResult> getChohyoID(FlexibleYear 調定年度,
            RString 算定期, List<HonsanteiIdoParameter> chohyoPara) {
        List<HonsanteiIdoKanendoResult> resultList = new ArrayList<>();
        if (chohyoPara == null || chohyoPara.isEmpty()) {
            return null;
        }
        for (HonsanteiIdoParameter choParameter : chohyoPara) {
            if (決定変更通知書_帳票分類ID.equals(choParameter.get帳票分類ID())) {
                HonsanteiIdoKanendoResult result1 = get決定通知書(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID(), 調定年度);
                if (result1 != null) {
                    resultList.add(result1);
                }
                HonsanteiIdoKanendoResult result2 = get変更通知書(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID(), 調定年度);
                if (result2 != null) {
                    resultList.add(result2);
                }
            }
            if (納入通知書_帳票分類ID.equals(choParameter.get帳票分類ID())) {
                HonsanteiIdoKanendoResult result = get納入通知書(choParameter.get帳票分類ID(), 調定年度,
                        算定期, choParameter.get出力順ID());
                if (result == null) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage().
                            replace(納入通知書の帳票ID.toString()).evaluate());
                } else {
                    resultList.add(result);
                }
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
    public HonsanteiIdoKanendoBatchParameter createBatchParam(HonsanteiIdoDivParameter parameter) {
        HonsanteiIdoKanendoBatchParameter result = new HonsanteiIdoKanendoBatchParameter();
        result.set調定年度(parameter.get調定年度());
        result.set処理対象(parameter.get処理対象());
        result.set抽出開始日時(parameter.get抽出開始日時());
        result.set抽出終了日時(parameter.get抽出終了日時());
        List<HonsanteiIdoKanendoResult> choResult = getChohyoID(parameter.get調定年度(),
                parameter.get算定期(), parameter.get出力帳票一覧());
        result.set出力帳票一覧(choResult);
        if (parameter.get決定_チェックボックス() != null && !parameter.get決定_チェックボックス().isEmpty()) {
            result.set決定_チェックボックス(oneRS);
        } else {
            result.set決定_チェックボックス(zeroRS);
        }
        result.set決定_対象賦課年度(parameter.get決定_対象賦課年度());
        result.set決定_発行日(parameter.get決定_発行日());
        result.set決定_文書番号(parameter.get決定_文書番号());
        if (parameter.get変更_チェックボックス() != null && !parameter.get変更_チェックボックス().isEmpty()) {
            result.set変更_チェックボックス(oneRS);
        } else {
            result.set変更_チェックボックス(zeroRS);
        }
        result.set変更_対象賦課年度(parameter.get変更_対象賦課年度());
        result.set変更_発行日(parameter.get変更_発行日());
        result.set変更_文書番号(parameter.get変更_文書番号());
        if (zeroRS.equals(parameter.get変更_対象者())) {
            result.set変更_対象者(zeroRS);
        } else if (oneRS.equals(parameter.get変更_対象者())) {
            result.set変更_対象者(oneRS);
        } else {
            result.set変更_対象者(twoRS);
        }
        result.set納入_対象賦課年度(parameter.get納入_対象賦課年度());
        result.set納入_発行日(parameter.get納入_発行日());
        result.set納入_出力期(parameter.get納入_出力期());
        if (zeroRS.equals(parameter.get変更_対象者())) {
            result.set納入_対象者(zeroRS);
        } else if (oneRS.equals(parameter.get変更_対象者())) {
            result.set納入_対象者(oneRS);
        } else {
            result.set納入_対象者(twoRS);
        }
        if (口座用.equals(parameter.get納入_口座振替様式())) {
            result.set納入_口座振替様式(oneRS);
        } else if (現金用.equals(parameter.get納入_口座振替様式())) {
            result.set納入_口座振替様式(twoRS);
        }
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
        return result;
    }

    private HonsanteiIdoKanendoResult get決定通知書(ReportId 帳票分類ID, RString 出力順ID, FlexibleYear 調定年度) {
        ChohyoSeigyoHanyo 帳票タイプを = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, 通知書タイプ);
        switch (帳票タイプを.get設定値().toString()) {
            case "001":
                return new HonsanteiIdoKanendoResult(帳票分類ID,
                        ReportIdDBB.DBB100039.getReportId().value(), 出力順ID);
            case "002":
                return new HonsanteiIdoKanendoResult(帳票分類ID,
                        ReportIdDBB.DBB100040.getReportId().value(), 出力順ID);
            default:
                return null;
        }
    }

    private HonsanteiIdoKanendoResult get変更通知書(ReportId 帳票分類ID, RString 出力順ID, FlexibleYear 調定年度) {
        ChohyoSeigyoHanyo 帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, 通知書タイプ);
        switch (帳票タイプを.get設定値().toString()) {
            case "001":
                return new HonsanteiIdoKanendoResult(帳票分類ID,
                        ReportIdDBB.DBB100042.getReportId().value(), 出力順ID);
            case "002":
                return new HonsanteiIdoKanendoResult(帳票分類ID,
                        ReportIdDBB.DBB100043.getReportId().value(), 出力順ID);
            default:
                return null;
        }
    }

    private RString get納付書の型(RString 算定期) {
        RString 設定値;
        switch (算定期.toString()) {
            case "1":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型1,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",1");
            case "2":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型2,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",2");
            case "3":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型3,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",3");
            case "4":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型4,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",4");
            case "5":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型5,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",5");
            case "6":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型6,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",6");
            case "7":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型7,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",7");
            case "8":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型8,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",8");
            case "9":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型9,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",9");
            case "10":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型10,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",10");
            case "11":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型11,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",11");
            case "12":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型12,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",12");
            case "13":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型13,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",13");
            case "14":
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型14,
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                return new RString(設定値.toString() + ",14");
            default:
                設定値 = RString.EMPTY;
                return 設定値;
        }
    }

    private HonsanteiIdoKanendoResult get期毎タイプ(ChohyoSeigyoHanyo 帳票タイプを, ReportId 帳票分類ID,
            RString 出力順ID, RString 型N) {
        if (zOneRS.equals(帳票タイプを.get設定値())) {
            return new HonsanteiIdoKanendoResult(帳票分類ID, ReportIdDBB.DBB100066.getReportId().value(), 出力順ID);
        }
        return null;
    }

    private HonsanteiIdoKanendoResult get銀振型5期タイプ(ChohyoSeigyoHanyo 帳票タイプを,
            ReportId 帳票分類ID, RString 出力順ID, RString 型N) {
        if (zOneRS.equals(帳票タイプを.get設定値())) {
            return new HonsanteiIdoKanendoResult(帳票分類ID, ReportIdDBB.DBB100070.getReportId().value(), 出力順ID);
        }
        return null;
    }

    private HonsanteiIdoKanendoResult get銀振型４期タイプ(ChohyoSeigyoHanyo 帳票タイプを, ReportId 帳票分類ID,
            RString 出力順ID, RString 型N) {
        if (zOneRS.equals(帳票タイプを.get設定値())) {
            return new HonsanteiIdoKanendoResult(帳票分類ID, ReportIdDBB.DBB100069.getReportId().value(), 出力順ID);
        }
        return null;
    }

    private HonsanteiIdoKanendoResult getブックタイプ(ChohyoSeigyoHanyo 帳票タイプを, ChohyoSeigyoHanyo 帳票_口座振替依頼,
            ReportId 帳票分類ID,
            RString 出力順ID, RString 型N) {
        if (zOneRS.equals(帳票タイプを.get設定値())) {
            if (zeroRS.equals(帳票_口座振替依頼.get設定値())) {
                return new HonsanteiIdoKanendoResult(帳票分類ID, ReportIdDBB.DBB100071.getReportId().value(), 出力順ID);
            } else if (oneRS.equals(帳票_口座振替依頼.get設定値())) {
                return new HonsanteiIdoKanendoResult(帳票分類ID, ReportIdDBB.DBB100072.getReportId().value(), 出力順ID);
            }
        }
        return null;
    }

    private HonsanteiIdoKanendoResult getコンビニ収納タイプ(
            ChohyoSeigyoHanyo 帳票タイプを,
            ChohyoSeigyoHanyo 帳票_コンビニ期毎出力,
            ReportId 帳票分類ID,
            RString 出力順ID, RString 型N) {
        if (twlZRS.equals(帳票タイプを.get設定値()) && zeroRS.equals(帳票_コンビニ期毎出力.get設定値())) {
            return new HonsanteiIdoKanendoResult(帳票分類ID, ReportIdDBB.DBB100075.getReportId().value(), 出力順ID);
        } else if (twlTRS.equals(帳票タイプを.get設定値()) && zeroRS.equals(帳票_コンビニ期毎出力.get設定値())) {
            return new HonsanteiIdoKanendoResult(帳票分類ID, ReportIdDBB.DBB100073.getReportId().value(), 出力順ID);
        } else if (oneRS.equals(帳票_コンビニ期毎出力.get設定値())) {
            return new HonsanteiIdoKanendoResult(帳票分類ID, ReportIdDBB.DBB100063.getReportId().value(), 出力順ID);
        }
        return null;
    }

    private HonsanteiIdoKanendoResult get納入通知書(
            ReportId 帳票分類ID, FlexibleYear 調定年度, RString 算定期, RString 出力順ID) {
        RString 項目名;
        RString アイテムとして;
        ChohyoSeigyoHanyo 帳票タイプを;
        RString 設定値 = new RString(get納付書の型(算定期).toString().split(",")[0]);
        RString 型N = new RString(get納付書の型(算定期).toString().split(",")[1]);
        switch (設定値.toString()) {
            case "1":
                項目名 = 期毎納入通知書タイプ;
                帳票タイプを = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                return get期毎タイプ(帳票タイプを, 帳票分類ID, 出力順ID, 型N);
            case "2":
                項目名 = 銀振納入通知書タイプ;
                帳票タイプを = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                return get銀振型5期タイプ(帳票タイプを, 帳票分類ID, 出力順ID, 型N);
            case "4":
                項目名 = 銀振納入通知書タイプ;
                帳票タイプを = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                return get銀振型４期タイプ(帳票タイプを, 帳票分類ID, 出力順ID, 型N);
            case "5":
                項目名 = その他納入通知書タイプ;
                アイテムとして = ブック口座振替依頼表示;
                帳票タイプを = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                ChohyoSeigyoHanyo 帳票_口座振替依頼 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        調定年度, アイテムとして);
                return getブックタイプ(帳票タイプを, 帳票_口座振替依頼, 帳票分類ID, 出力順ID, 型N);
            case "6":
                項目名 = コンビニ期毎タイプ;
                アイテムとして = コンビニ期毎出力;
                帳票タイプを = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
                ChohyoSeigyoHanyo 帳票_コンビニ期毎出力 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        調定年度, アイテムとして);
                return getコンビニ収納タイプ(帳票タイプを, 帳票_コンビニ期毎出力, 帳票分類ID, 出力順ID, 型N);
            default:
                return null;
        }
    }

}
