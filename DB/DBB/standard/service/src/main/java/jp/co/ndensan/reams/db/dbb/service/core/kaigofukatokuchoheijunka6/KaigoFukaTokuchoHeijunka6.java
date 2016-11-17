/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.kaigofukatokuchoheijunka6.ShorijyokyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchoheijunka6tsuchishoikatsuhako.HeijunkaKeisanPageJoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012001.DBB012001_TokuchoHeinjunka6GatsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012003.DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6.ShorijyokyoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特徴平準化（特徴6月分）のビジネスクラスです。
 *
 * @reamsid_L DBB-0820-020 xuyue
 */
public class KaigoFukaTokuchoHeijunka6 {

    private static final RString 帳票分類ＩＤ_DBB100012 = new RString("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    private static final RString 帳票分類ＩＤ_DBB100010 = new RString("DBB100010_KarisanteiHenkoTsuchishoDaihyo");
    private static final RString 項目名 = new RString("通知書タイプ");
    private static final RString 標準版B5横タイプ = new RString("001");
    private static final RString 標準版A4縦タイプ = new RString("002");
    private static final ReportId 通知書帳票ID_００１ = ReportIdDBB.DBB100012.getReportId();
    private static final ReportId 通知書帳票ID_００２ = ReportIdDBB.DBB100013.getReportId();
    private static final RString 遷移元区分_0 = new RString("0");
    private static final RString 遷移元区分_1 = new RString("1");

    /**
     * コンストラクタです。
     */
    KaigoFukaTokuchoHeijunka6() {
    }

    /**
     * 特徴平準化（特徴6月分）のビジネスを生成します。
     *
     * @return 特徴平準化（特徴6月分）のビジネス
     */
    public static KaigoFukaTokuchoHeijunka6 createInstance() {
        return InstanceProvider.create(KaigoFukaTokuchoHeijunka6.class);
    }

    /**
     * 特徴平準化（特徴6月分）バッチパラメータの取得
     *
     * @param pageData 画面情報
     * @return batchParameterクラス
     */
    public DBB012001_TokuchoHeinjunka6GatsuParameter getBatchiPara(HeijunkaKeisanPageJoho pageData) {
        DBB012001_TokuchoHeinjunka6GatsuParameter batchParameter = new DBB012001_TokuchoHeinjunka6GatsuParameter();
        batchParameter.set調定年度(pageData.get調定年度());
        batchParameter.set賦課年度(pageData.get賦課年度());
        batchParameter.set増額平準化方法(pageData.get増額平準化方法());
        batchParameter.set減額平準化方法(pageData.get減額平準化方法());
        batchParameter.set帳票グループ(pageData.get帳票グループ());

        for (OutputChohyoIchiran shuturyokuChohuo : pageData.get出力帳票一覧List()) {
            if (帳票分類ＩＤ_DBB100012.equals(shuturyokuChohuo.get帳票分類ID())) {
                DbT7067ChohyoSeigyoHanyoEntity dbT7067ChohyoSeigyoHanyoEntity
                        = get帳票制御汎用キー(SubGyomuCode.DBB介護賦課, new ReportId(帳票分類ＩＤ_DBB100010), pageData.get調定年度(), 項目名);
                RString komokuValue = RString.EMPTY;
                if (dbT7067ChohyoSeigyoHanyoEntity != null) {
                    komokuValue = dbT7067ChohyoSeigyoHanyoEntity.getKomokuValue();
                }
                if (標準版B5横タイプ.equals(komokuValue)) {
                    shuturyokuChohuo.set帳票ID(通知書帳票ID_００１.getColumnValue());
                } else if (標準版A4縦タイプ.equals(komokuValue)) {
                    shuturyokuChohuo.set帳票ID(通知書帳票ID_００２.getColumnValue());
                }
            } else {
                shuturyokuChohuo.set帳票ID(shuturyokuChohuo.get帳票分類ID());
            }
        }

        batchParameter.set出力帳票entity(pageData.get出力帳票一覧List());
        batchParameter.set出力対象指示フラグ(pageData.get出力対象指示フラグ());
        batchParameter.set発行日(pageData.get発行日());
        batchParameter.set文書番号(pageData.get文書番号());
        batchParameter.set一括発行フラグ(pageData.is一括発行フラグ());
        return batchParameter;
    }

    /**
     * 特徴平準化（特徴6月分）通知書一括発行バッチパラメータの取得
     *
     * @param pageData 画面情報
     * @return batchParameterクラス
     */
    public DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter getIkatsuBatchiPara(HeijunkaKeisanPageJoho pageData) {
        DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter batchParameter = new DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter();
        batchParameter.set調定年度(pageData.get調定年度());
        batchParameter.set賦課年度(pageData.get賦課年度());
        batchParameter.set帳票グループ(pageData.get帳票グループ());

        for (OutputChohyoIchiran shuturyokuChohuo : pageData.get出力帳票一覧List()) {
            if (帳票分類ＩＤ_DBB100012.equals(shuturyokuChohuo.get帳票分類ID())) {
                DbT7067ChohyoSeigyoHanyoEntity dbT7067ChohyoSeigyoHanyoEntity
                        = get帳票制御汎用キー(SubGyomuCode.DBB介護賦課, new ReportId(帳票分類ＩＤ_DBB100010), pageData.get調定年度(), 項目名);
                RString komokuValue = RString.EMPTY;
                if (dbT7067ChohyoSeigyoHanyoEntity != null) {
                    komokuValue = dbT7067ChohyoSeigyoHanyoEntity.getKomokuValue();
                }
                if (標準版B5横タイプ.equals(komokuValue)) {
                    shuturyokuChohuo.set帳票ID(通知書帳票ID_００１.getColumnValue());
                } else if (標準版A4縦タイプ.equals(komokuValue)) {
                    shuturyokuChohuo.set帳票ID(通知書帳票ID_００２.getColumnValue());
                }
            } else {
                shuturyokuChohuo.set帳票ID(shuturyokuChohuo.get帳票分類ID());
            }
        }

        batchParameter.set出力帳票一覧List(pageData.get出力帳票一覧List());
        batchParameter.set出力対象(pageData.get出力対象指示フラグ());
        batchParameter.set発行日(pageData.get発行日());
        batchParameter.set文書番号(pageData.get文書番号());
        batchParameter.set一括発行フラグ(pageData.is一括発行フラグ());
        return batchParameter;
    }

    /**
     * 処理状況取得
     *
     * @param 遷移元区分 遷移元区分
     * @param 調定年度 調定年度
     * @return 処理状況リスト<処理日付管理entity>
     */
    public List<ShorijyokyoJoho> getShoriJohkyoList(RString 遷移元区分, FlexibleYear 調定年度) {

        ShorijyokyoEntity shoriEntity = new ShorijyokyoEntity();
        List<ShorijyokyoJoho> shoriList = new ArrayList<>();
        DbT7022ShoriDateKanriDac bT7022ShoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);

        List<RString> 処理名 = new ArrayList<>();

        if (遷移元区分_0.equals(遷移元区分)) {
            FuchoKiUtil fuchoKiUtil = new FuchoKiUtil(調定年度);
            KitsukiList 期月リスト = fuchoKiUtil.get期月リスト().filtered仮算定期間();
            int count = 期月リスト.toList().size();
            if (count >= 1) {
                処理名.add(ShoriName.特徴仮算定賦課.get名称());
                処理名.add(ShoriName.普徴仮算定賦課.get名称());
            } else {
                処理名.add(ShoriName.特徴仮算定賦課.get名称());
            }
            List<DbT7022ShoriDateKanriEntity> entityList = bT7022ShoriDateKanriDac.select処理状況(調定年度, 処理名, SubGyomuCode.DBB介護賦課);
            for (DbT7022ShoriDateKanriEntity entity : entityList) {
                shoriEntity.set処理名(entity.getShoriName());
                shoriEntity.set基準年月日(entity.getKijunYMD());
                shoriEntity.set基準日時(entity.getKijunTimestamp());
                shoriList.add(new ShorijyokyoJoho(shoriEntity));
            }
        } else if (遷移元区分_1.equals(遷移元区分)) {
            処理名.add(ShoriName.特徴平準化計算_6月分.get名称());
            List<DbT7022ShoriDateKanriEntity> entityList = bT7022ShoriDateKanriDac.select処理状況(調定年度, 処理名, SubGyomuCode.DBB介護賦課);
            for (DbT7022ShoriDateKanriEntity entity : entityList) {
                shoriEntity.set処理名(entity.getShoriName());
                shoriEntity.set基準年月日(entity.getKijunYMD());
                shoriEntity.set基準日時(entity.getKijunTimestamp());
                shoriList.add(new ShorijyokyoJoho(shoriEntity));
            }
        }
        return shoriList;
    }

    /**
     * 帳票制御汎用キー取得
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @param 調定年度 調定年度
     * @param 項目名 項目名
     * @return 帳票制御汎用Entity
     */
    private DbT7067ChohyoSeigyoHanyoEntity get帳票制御汎用キー(SubGyomuCode サブ業務コード, ReportId 帳票分類ID,
            FlexibleYear 調定年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoDac dbT7067ChohyoSeigyoHanyoDac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        DbT7067ChohyoSeigyoHanyoEntity entity = dbT7067ChohyoSeigyoHanyoDac.selectByKey(サブ業務コード, 帳票分類ID, 調定年度, 項目名);
        return entity;
    }
}
