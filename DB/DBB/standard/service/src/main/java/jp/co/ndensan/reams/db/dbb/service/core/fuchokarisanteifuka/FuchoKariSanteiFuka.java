/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuchokarisanteifuka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fuchokarisanteifuka.BatchFuchoKariSanteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.fuchokarisanteifuka.FuchoKariSanteiEntity;
import jp.co.ndensan.reams.db.dbb.business.core.fuchokarisanteifuka.FuchoKariSanteiFukaEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuchokarisantei.FuchoKarisanteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuchokarisanteitsuchishohakko.BatchFuchoKariSanteiEntity;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
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
    private static final RString 現金納付者_0 = new RString("0");
    private static final RString 現金納付者 = new RString("現金納付者");
    private static final RString 口座振替者_1 = new RString("1");
    private static final RString 口座振替者 = new RString("口座振替者");
    private static final RString すべて選択_2 = new RString("2");
    private static final RString すべて選択 = new RString("（すべて選択）");
    private static final int 算定期_0 = 0;
    private static final int 算定期_1 = 1;
    private static final int 算定期_2 = 2;
    private static final int 算定期_4 = 4;
    private static final int 算定期_5 = 5;
    private static final int 算定期_6 = 6;
    private static final int 算定期_9 = 9;
    private static final RString なし = new RString("なし");
    private static final RString 期毎タイプ = new RString("期毎タイプ");
    private static final RString 銀振型5期タイプ = new RString("銀振型5期タイプ");
    private static final RString 銀振型4期タイプ = new RString("銀振型4期タイプ");
    private static final RString ブックタイプ = new RString("ブックタイプ");
    private static final RString コンビニ収納タイプ = new RString("コンビニ収納タイプ");
    private static final RString その他_カスタマイズ = new RString("その他（カスタマイズ）");
    private static final RString 期毎納入通知書タイプ = new RString("期毎納入通知書タイプ");
    private static final RString 銀振納入通知書タイプ = new RString("銀振納入通知書タイプ");
    private static final RString ブック口座振替依頼表示 = new RString("ブック口座振替依頼表示");
    private static final RString コンビニ期毎タイプ = new RString("コンビニ期毎タイプ");
    private static final RString その他納入通知書タイプ = new RString("その他納入通知書タイプ");
    private static final int CASE_10010 = 10010;
    private static final int CASE_10011 = 10011;
    private static final int CASE_40010 = 40010;
    private static final int CASE_40011 = 40011;
    private static final int CASE_50010 = 50010;
    private static final int CASE_50011 = 50011;
    private static final int CASE_00 = 00;
    private static final int CASE_01 = 01;
    private static final int CASE_10 = 10;
    private static final int CASE_11 = 11;
    private static final int CASE_600 = 600;
    private static final int CASE_601 = 601;
    private static final int CASE_3010 = 3010;
    private static final int CASE_3011 = 3011;
    private static final int CASE_3020 = 3020;
    private static final int CASE_3021 = 3021;
    private static final int CASE_610 = 610;
    private static final int CASE_611 = 611;
    private static final ReportId DBB100014 = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final RString 納入通知書の帳票ID = new RString("納入通知書の帳票ID");

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
        if (遷移元区分_0.equals(遷移元区分)) {
            RString 処理名 = ShoriName.特徴仮算定賦課.get名称();
            entityList = 処理日付管理Dac.select処理状況_普徴仮算定賦課(調定年度, 処理名, サブ業務コード);
        } else if (遷移元区分_1.equals(遷移元区分)) {
            RString 処理名 = ShoriName.普徴仮算定賦課.get名称();
            entityList = 処理日付管理Dac.select処理状況_普徴仮算定賦課(調定年度, 処理名, サブ業務コード);
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
    public FuchoKarisanteiBatchParameter createFuchoKariSanteiParameter(FuchoKariSanteiFukaEntity entity) {
        List<BatchFuchoKariSanteiResult> 出力帳票一覧List = get出力帳票一覧(entity.get出力帳票一覧List(),
                entity.get調定年度(), entity.get算定期());
        FuchoKarisanteiBatchParameter resultParameter = new FuchoKarisanteiBatchParameter();
        resultParameter.set調定年度(entity.get調定年度());
        resultParameter.set賦課年度(entity.get賦課年度());
        resultParameter.set出力帳票一覧List(出力帳票一覧List);
        resultParameter.set発行日(entity.get発行日());
        if (別々出力.equals(entity.get出力方法())) {
            resultParameter.set出力方法(別々出力_0);
        } else if (全件出力.equals(entity.get出力方法())) {
            resultParameter.set出力方法(全件出力_1);
        }
        if (entity.get出力期表示方法().endsWith(出力期表示方法_分)) {
            resultParameter.set出力期表示方法(出力期表示方法_1);
        } else if (entity.get出力期表示方法().endsWith(出力期表示方法_)) {
            resultParameter.set出力期表示方法(出力期表示方法_2);
        }
        resultParameter.set出力期(entity.get出力期());
        if (すべて選択.equals(entity.get対象者())) {
            resultParameter.set対象者フラグ(すべて選択_2);
        } else if (現金納付者.equals(entity.get対象者())) {
            resultParameter.set対象者フラグ(現金納付者_0);
        } else if (口座振替者.equals(entity.get対象者())) {
            resultParameter.set対象者フラグ(口座振替者_1);
        }
        resultParameter.set生活保護者をまとめて先頭に出力フラグ(entity.get生活保護者をまとめて先頭に出力フラグ());
        resultParameter.setページごとに山分けフラグ(entity.getページごとに山分けフラグ());
        return resultParameter;
    }

    /**
     * 出力帳票一覧作成する。
     *
     * @param 出力帳票List FuchoKariSanteiEntity
     * @throws ApplicationException
     * @return バッチ出力帳票リスト
     */
    private List<BatchFuchoKariSanteiResult> get出力帳票一覧(List<FuchoKariSanteiEntity> 出力帳票List,
            FlexibleYear 調定年度, RString 算定期) throws ApplicationException {
        List<BatchFuchoKariSanteiResult> resultList = new ArrayList<>();
        if (出力帳票List == null || 出力帳票List.isEmpty()) {
            return resultList;
        }
        for (FuchoKariSanteiEntity 出力帳票entity : 出力帳票List) {
            ReportId 帳票分類ID = 出力帳票entity.get帳票分類ID();
            ReportId 帳票ID = 帳票分類ID;
            if (DBB100014.equals(帳票分類ID)) {
                // TODO DBBコンフィグから、納付書の型と連帳区分を取得する。
//                BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型４, RDate.MAX, SubGyomuCode.DBB介護賦課, LasdecCode.EMPTY)
//                RString 設定値 = get設定値(算定期);
                RString 納入通知書の型 = get納入通知書の型(算定期);
                RString 普徴期情報_納通連帳区分 = new RString("0");
                RString 項目名 = get項目名(納入通知書の型);
                ReportId 通知書の帳票ID = get通知書の帳票ID(
                        帳票分類ID, 調定年度, 項目名, 算定期, 普徴期情報_納通連帳区分);

                if (通知書の帳票ID == null || 通知書の帳票ID.isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.存在しない
                            .getMessage().replace(納入通知書の帳票ID.toString()).evaluate());
                }
                帳票ID = 通知書の帳票ID;
            }
            BatchFuchoKariSanteiEntity バッチ出力帳票一覧Entity = new BatchFuchoKariSanteiEntity(
                    帳票分類ID,
                    帳票ID,
                    出力帳票entity.get改頁出力順ID()
            );
            resultList.add(new BatchFuchoKariSanteiResult(バッチ出力帳票一覧Entity));
        }
        return resultList;
    }

//    private RString get設定値(RString 算定期) {
//        return 算定期;
//    }
    private RString get納入通知書の型(RString 算定期) {
        RString 納入通知書の型;
        switch (Integer.valueOf(算定期.toString())) {
            case 算定期_0:
                納入通知書の型 = なし;
                break;
            case 算定期_1:
                納入通知書の型 = 期毎タイプ;
                break;
            case 算定期_2:
                納入通知書の型 = 銀振型5期タイプ;
                break;
            case 算定期_4:
                納入通知書の型 = 銀振型4期タイプ;
                break;
            case 算定期_5:
                納入通知書の型 = ブックタイプ;
                break;
            case 算定期_6:
                納入通知書の型 = コンビニ収納タイプ;
                break;
            case 算定期_9:
                納入通知書の型 = その他_カスタマイズ;
                break;
            default:
                納入通知書の型 = RString.EMPTY;
        }
        return 納入通知書の型;
    }

    private RString get項目名(RString 納入通知書の型) {
        RString 項目名;
        if (期毎タイプ.equals(納入通知書の型)) {
            項目名 = 期毎納入通知書タイプ;
        } else if (銀振型4期タイプ.equals(納入通知書の型)) {
            項目名 = 銀振納入通知書タイプ;
        } else if (ブックタイプ.equals(納入通知書の型)) {
            項目名 = その他納入通知書タイプ;
        } else if (コンビニ収納タイプ.equals(納入通知書の型)) {
            項目名 = コンビニ期毎タイプ;
        } else {
            項目名 = null;
        }
        return 項目名;
    }

    private ReportId get通知書の帳票ID(
            ReportId 帳票分類ID,
            FlexibleYear 調定年度,
            RString 項目名,
            RString 算定期,
            RString 普徴期情報_納通連帳区分) {
        ChohyoSeigyoHanyo 帳票制御汎用キー = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, 項目名);
        ReportId 通知書帳票ID = null;
        if (帳票制御汎用キー != null && 算定期 != null && 普徴期情報_納通連帳区分 != null) {
            RString 帳票制御汎用 = 帳票制御汎用キー.get設定値();
            RString コンフィグと帳票制御汎用 = new RString(
                    算定期.toString() + 帳票制御汎用.toString() + 普徴期情報_納通連帳区分.toString());
            switch (Integer.valueOf(コンフィグと帳票制御汎用.toString())) {
                case CASE_10010:
                    通知書帳票ID = ReportIdDBB.DBB100014.getReportId();
                    break;
                case CASE_10011:
                    通知書帳票ID = ReportIdDBB.DBB100015.getReportId();
                    break;
                case CASE_40010:
                    通知書帳票ID = ReportIdDBB.DBB100018.getReportId();
                    break;
                case CASE_40011:
                    通知書帳票ID = ReportIdDBB.DBB100019.getReportId();
                    break;
                case CASE_50010:
                case CASE_50011:
                    ChohyoSeigyoHanyo 帳票制御汎用キー_ブックタイプ
                            = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, ブック口座振替依頼表示);
                    switch (Integer.valueOf(帳票制御汎用キー_ブックタイプ.get設定値().toString() + 普徴期情報_納通連帳区分.toString())) {
                        case CASE_00:
                            通知書帳票ID = ReportIdDBB.DBB100021.getReportId();
                            break;
                        case CASE_01:
                            通知書帳票ID = ReportIdDBB.DBB100023.getReportId();
                            break;
                        case CASE_10:
                            通知書帳票ID = ReportIdDBB.DBB100020.getReportId();
                            break;
                        case CASE_11:
                            通知書帳票ID = ReportIdDBB.DBB100022.getReportId();
                            break;
                        default:
                            通知書帳票ID = ReportId.EMPTY;
                    }
                    break;
                case CASE_600:
                case CASE_601:
                    ChohyoSeigyoHanyo 帳票制御汎用キー_ブックタイプ_コンビニ収納タイプ
                            = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, 調定年度, その他納入通知書タイプ);
                    int 通知書帳票IDFlag = Integer.valueOf(
                            帳票制御汎用キー_ブックタイプ_コンビニ収納タイプ.toString() + 普徴期情報_納通連帳区分.toString());
                    通知書帳票ID = get通知書の帳票ID_通常出力(通知書帳票IDFlag);
                    break;
                case CASE_610:
                    通知書帳票ID = ReportIdDBB.DBB100028.getReportId();
                    break;
                case CASE_611:
                    通知書帳票ID = ReportIdDBB.DBB100029.getReportId();
                    break;
                default:
                    通知書帳票ID = ReportId.EMPTY;
            }
        }
        return 通知書帳票ID;
    }

    private ReportId get通知書の帳票ID_通常出力(int 通知書帳票IDFlag) {
        ReportId 通知書帳票ID = null;
        switch (通知書帳票IDFlag) {
            case CASE_3010:
                通知書帳票ID = ReportIdDBB.DBB100026.getReportId();
                break;
            case CASE_3011:
                通知書帳票ID = ReportIdDBB.DBB100027.getReportId();
                break;
            case CASE_3020:
                通知書帳票ID = ReportIdDBB.DBB100024.getReportId();
                break;
            case CASE_3021:
                通知書帳票ID = ReportIdDBB.DBB100025.getReportId();
                break;
            default:
                通知書帳票ID = ReportId.EMPTY;
        }
        return 通知書帳票ID;
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
    private ChohyoSeigyoHanyo getChohyoHanyoKey(SubGyomuCode サブ業務コード, ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(サブ業務コード, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

}
