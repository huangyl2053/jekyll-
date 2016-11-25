/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuchokarisanteifuka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fuchokarisanteifuka.BatchFuchoKariSanteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.fuchokarisanteifuka.FuchoKariSanteiFukaEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003.BatchFuchoKariSanteiEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003.DBB014003_FuchoKarisanteiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ34001_普徴仮算定賦課のクラスです
 *
 * @reamsid_L DBB-0710-020 gongliang
 */
public class FuchoKariSanteiFuka {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;

    private static final RString 遷移元区分_0 = new RString("0");
    private static final RString 遷移元区分_1 = new RString("1");
    private static final RString 別々出力_0 = new RString("0");
    private static final RString 別々出力 = new RString("別々出力");
    private static final RString 全件出力_1 = new RString("1");
    private static final RString 全件出力 = new RString("全件出力");
    private static final RString 出力期表示方法_1 = new RString("1");
    private static final RString 出力期表示方法_分 = new RString("分");
    private static final RString 出力期表示方法_2 = new RString("2");
    private static final RString 出力期表示方法_ = new RString("~");
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
    private static final int 設定値_番号0 = 0;
    private static final int 設定値_番号2 = 2;
    private static final int 設定値_番号4 = 4;
    private static final int 設定値_番号5 = 5;
    private static final int 設定値_番号6 = 6;
    private static final int 設定値_番号9 = 9;
    private static final RString 区分_ゼロ = new RString("0");
    private static final RString 区分_イチ = new RString("1");
    private static final RString 口座振替依頼_ゼロ = new RString("0");
    private static final RString 口座振替依頼_イチ = new RString("1");
    private static final RString 通知書タイプ設定値 = new RString("001");
    private static final RString 期毎タイプ = new RString("期毎納入通知書タイプ");
    private static final RString 定値_銀振型 = new RString("銀振納入通知書タイプ");
    private static final RString ブック口座振替依頼表示 = new RString("ブック口座振替依頼表示");
    private static final RString その他納入通知書タイプ = new RString("その他納入通知書タイプ");
    private static final RString コンビニ期毎出力 = new RString("コンビニ期毎出力");
    private static final RString コンビニマルチ収納タイプ = new RString("301");
    private static final RString コンビニ角公タイプ = new RString("302");
    private static final RString 調定月日 = new RString("0401");
    private static final ReportId 保険料納入通知書_仮算定_帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");

    /**
     * コンストラクタです。
     */
    public FuchoKariSanteiFuka() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac 処理日付管理Dac
     * @param 帳票制御汎用Dac 帳票制御汎用Dac
     */
    FuchoKariSanteiFuka(DbT7022ShoriDateKanriDac 処理日付管理Dac, DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * 初期化メソッドです。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link FuchoKariSanteiFuka}のインスタンス
     */
    public static FuchoKariSanteiFuka createInstance() {
        return InstanceProvider.create(FuchoKariSanteiFuka.class);
    }

    /**
     * 処理状況取得する。
     *
     * @param 調定年度 調定年度
     * @param 遷移元区分 遷移元区分
     * @return 処理日付管理entity 取得できない場合、NULLを返す
     */
    public List<ShoriDateKanri> getShoriDateKanriList(FlexibleYear 調定年度, RString 遷移元区分) {
        List<DbT7022ShoriDateKanriEntity> entityList = new ArrayList<>();
        SubGyomuCode サブ業務コード = SubGyomuCode.DBB介護賦課;
        List<RString> 処理名リスト = new ArrayList<>();
        if (遷移元区分_0.equals(遷移元区分)) {
            処理名リスト.add(ShoriName.特徴仮算定賦課.get名称());
            entityList = 処理日付管理Dac.select処理状況(調定年度, 処理名リスト, サブ業務コード);
        } else if (遷移元区分_1.equals(遷移元区分)) {
            処理名リスト.add(ShoriName.普徴仮算定賦課.get名称());
            entityList = 処理日付管理Dac.select処理状況(調定年度, 処理名リスト, サブ業務コード);
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
     * バッチ用パラメータ作成する。
     *
     * @param entity FuchoKariSanteiFukaEntity
     * @return FuchoKariSanteiFukaParameter
     */
    public DBB014003_FuchoKarisanteiTsuchishoHakkoParameter createFuchoKariSanteiParameter(FuchoKariSanteiFukaEntity entity) {
        List<BatchFuchoKariSanteiEntity> 出力帳票一覧List = getChohyoIchiran(entity.get出力帳票一覧List(),
                entity.get調定年度(), entity.get出力期());
        DBB014003_FuchoKarisanteiTsuchishoHakkoParameter resultParameter = new DBB014003_FuchoKarisanteiTsuchishoHakkoParameter();
        resultParameter.set調定年度(entity.get調定年度());
        resultParameter.set賦課年度(entity.get賦課年度());
        resultParameter.set出力帳票一覧List(出力帳票一覧List);
        resultParameter.set発行日(entity.get発行日());
        if (別々出力.equals(entity.get出力方法())) {
            resultParameter.set出力方法(別々出力_0);
        } else if (全件出力.equals(entity.get出力方法())) {
            resultParameter.set出力方法(全件出力_1);
        }
        RString 出力期表示方法 = entity.get出力期表示方法();
        if (出力期表示方法 != null && !出力期表示方法.isEmpty()) {
            if (出力期表示方法.endsWith(出力期表示方法_分)) {
                resultParameter.set出力期の表示方法(出力期表示方法_1);
            } else if (出力期表示方法.endsWith(出力期表示方法_)) {
                resultParameter.set出力期の表示方法(出力期表示方法_2);
            }
        }
        resultParameter.set出力期(entity.get出力期());
        resultParameter.set対象者(entity.get対象者());
        resultParameter.set生活保護対象者をまとめて先頭に出力(entity.get生活保護者をまとめて先頭に出力フラグ());
        resultParameter.setページごとに山分け(entity.getページごとに山分けフラグ());
        resultParameter.set一括発行起動フラグ(entity.is一括発行起動フラグ());
        return resultParameter;
    }

    /**
     * 出力帳票一覧作成する。
     *
     * @param 出力帳票List BatchFuchoKariSanteiEntity
     * @param 調定年度 FlexibleYear
     * @param 算定期 RString
     * @return バッチ出力帳票リスト List<BatchFuchoKariSanteiEntity>
     * @throws ApplicationException ApplicationException
     */
    public List<BatchFuchoKariSanteiEntity> getChohyoIchiran(List<BatchFuchoKariSanteiResult> 出力帳票List,
            FlexibleYear 調定年度, RString 算定期) throws ApplicationException {
        List<BatchFuchoKariSanteiEntity> resultList = new ArrayList<>();
        if (出力帳票List == null || 出力帳票List.isEmpty()) {
            return resultList;
        }
        for (BatchFuchoKariSanteiResult 出力帳票entity : 出力帳票List) {
            BatchFuchoKariSanteiEntity バッチ出力帳票一覧Entity;
            ReportId 帳票ID = 出力帳票entity.get帳票ID();
            if (!保険料納入通知書_仮算定_帳票分類ID.equals(帳票ID)) {
                バッチ出力帳票一覧Entity = new BatchFuchoKariSanteiEntity(
                        帳票ID,
                        帳票ID,
                        出力帳票entity.get出力順ID()
                );
                resultList.add(バッチ出力帳票一覧Entity);
                continue;
            }

            RDate 調定年月日 = new RDate(調定年度.toString().concat(調定月日.toString()));

            RString 設定値 = get納付書の型の設定値(算定期, 調定年月日);
            RString 項目名 = get項目名(設定値);
            RString 納通連帳区分 = get普徴期情報_納通連帳区分(算定期, 調定年月日);

            ChohyoSeigyoHanyo 帳票タイプ = getChohyoSeigyoKey(SubGyomuCode.DBB介護賦課, 出力帳票entity.get帳票ID(),
                    調定年度, 項目名);
            if (帳票タイプ == null) {
                throw new ApplicationException(DbbErrorMessages.帳票ID取得不可のため処理不可.getMessage());
            }
            ReportId 通知書の帳票ID = get通知書の帳票ID(調定年度, 項目名, 帳票タイプ, 納通連帳区分, 帳票ID);
            if (通知書の帳票ID == null || 通知書の帳票ID.isEmpty()) {
                throw new ApplicationException(DbbErrorMessages.帳票ID取得不可のため処理不可.getMessage());
            }
            バッチ出力帳票一覧Entity = new BatchFuchoKariSanteiEntity(
                    帳票ID,
                    通知書の帳票ID,
                    出力帳票entity.get出力順ID()
            );
            resultList.add(バッチ出力帳票一覧Entity);
        }
        return resultList;
    }

    private RString get普徴期情報_納通連帳区分(RString 出力期, RDate 調定年月日) {

        switch (Integer.parseInt(出力期.toString())) {
            case 定値_1期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分1, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_2期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分2, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_3期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分3, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_4期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分4, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_5期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分5, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_6期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分6, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_7期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分7, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_8期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分8, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_9期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分9, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_10期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分10, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_11期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分11, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_12期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分12, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_13期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分13, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_14期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納通連帳区分14, 調定年月日, SubGyomuCode.DBB介護賦課);
            default:
                return RString.EMPTY;
        }
    }

    private RString get納付書の型の設定値(RString 算定期, RDate 調定年月日) {

        switch (Integer.parseInt(算定期.toString())) {
            case 定値_1期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型1, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_2期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型2, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_3期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型3, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_4期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型4, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_5期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型5, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_6期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型6, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_7期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型7, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_8期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型8, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_9期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型9, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_10期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型10, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_11期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型11, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_12期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型12, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_13期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型13, 調定年月日, SubGyomuCode.DBB介護賦課);
            case 定値_14期:
                return DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型14, 調定年月日, SubGyomuCode.DBB介護賦課);
            default:
                return 区分_ゼロ;
        }
    }

    private RString get項目名(RString 設定値) {
        switch (Integer.parseInt(設定値.toString())) {
            case 設定値_番号0:
                return RString.EMPTY;
            case 設定値_番号1:
                return 期毎タイプ;
            case 設定値_番号2:
                return RString.EMPTY;
            case 設定値_番号4:
                return 定値_銀振型;
            case 設定値_番号5:
                return その他納入通知書タイプ;
            case 設定値_番号6:
                return コンビニ期毎出力;
            case 設定値_番号9:
                return RString.EMPTY;
            default:
                return RString.EMPTY;
        }
    }

    private ReportId get通知書の帳票ID(
            FlexibleYear 調定年度,
            RString 項目名,
            ChohyoSeigyoHanyo 帳票タイプ,
            RString 納通連帳区分,
            ReportId 帳票ID) {
        if (期毎タイプ.equals(項目名) && 通知書タイプ設定値.equals(帳票タイプ.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100014.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100015.getReportId();
            }
        } else if (定値_銀振型.equals(項目名) && 通知書タイプ設定値.equals(帳票タイプ.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100018.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100019.getReportId();
            }
        } else if (その他納入通知書タイプ.equals(項目名) && 通知書タイプ設定値.equals(帳票タイプ.get設定値())) {
            return get口座振替依頼帳票ID(納通連帳区分, 調定年度, 帳票ID);
        } else if (コンビニ期毎出力.equals(項目名) && 区分_イチ.equals(帳票タイプ.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100028.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100029.getReportId();
            }
        } else if (コンビニ期毎出力.equals(項目名) && 区分_ゼロ.equals(帳票タイプ.get設定値())) {
            return get通知書の帳票ID(納通連帳区分, 調定年度, 帳票ID);
        }
        return null;
    }

    private ReportId get口座振替依頼帳票ID(RString 納通連帳区分,
            FlexibleYear 調定年度,
            ReportId 帳票ID) {
        ChohyoSeigyoHanyo 帳票口座振替依頼 = getChohyoSeigyoKey(SubGyomuCode.DBB介護賦課, 帳票ID, 調定年度, ブック口座振替依頼表示);
        if (帳票口座振替依頼 == null) {
            throw new ApplicationException(DbbErrorMessages.帳票ID取得不可のため処理不可.getMessage());
        }
        if (口座振替依頼_ゼロ.equals(帳票口座振替依頼.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100021.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100023.getReportId();
            }
        } else if (口座振替依頼_イチ.equals(帳票口座振替依頼.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100020.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100022.getReportId();
            }
        }
        return null;
    }

    private ReportId get通知書の帳票ID(RString 納通連帳区分,
            FlexibleYear 調定年度,
            ReportId 帳票ID) {
        ChohyoSeigyoHanyo 帳票タイプその他 = getChohyoSeigyoKey(SubGyomuCode.DBB介護賦課, 帳票ID, 調定年度, その他納入通知書タイプ);
        if (帳票タイプその他 == null) {
            throw new ApplicationException(DbbErrorMessages.帳票ID取得不可のため処理不可.getMessage().evaluate());
        }
        if (コンビニマルチ収納タイプ.equals(帳票タイプその他.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100026.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100027.getReportId();
            }
        } else if (コンビニ角公タイプ.equals(帳票タイプその他.get設定値())) {
            if (区分_ゼロ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100024.getReportId();
            } else if (区分_イチ.equals(納通連帳区分)) {
                return ReportIdDBB.DBB100025.getReportId();
            }
        }
        return null;
    }

    /**
     * 帳票制御汎用キー取得する。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo getChohyoSeigyoKey(SubGyomuCode サブ業務コード, ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(サブ業務コード, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

}
