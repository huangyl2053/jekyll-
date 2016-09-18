/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32004;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200008.KyufuGengakuHaakuIchiranReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbdbt32004.KyufuGakuGengakuTainoShaProcessProperty;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenko.kyufugengakukanrilist.TaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32004.KyufuGakuGengakuTainoShaProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt32004.KyufuGakuGengakuTainoShaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.GengakuTaishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.KyufuGengakuHaakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.ShunoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.ShunoKibetsuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 給付額減額滞納者把握情報取得_process処理クラスです。
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
public class KyufuGakuGengakuTainoShaProcess extends BatchProcessBase<KyufuGakuGengakuTainoShaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugakugengakukanririsutosakusei"
            + ".IKyufuGakuGengakuKanriRisutoSakuseiMapper.get給付額減額滞納者把握情報取得");
    private KyufuGakuGengakuTainoShaProcessParameter processParameter;
    private IOutputOrder outputOrder;
    private Association association;
    private RString reamsLoginID;
    private RString 出力順;

    @BatchWriter
    private BatchReportWriter<KyufuGengakuHaakuIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<KyufuGengakuHaakuIchiranReportSource> reportSourceWriter;

    private static final RString 基準日 = new RString("【基準日】");
    private static final RString 対象区分 = new RString("【対象】");
    private static final RString 通知書未発行者 = new RString("　　　　 ・通知書未発行者");
    private static final RString 減額適用中者 = new RString("　　　　 ・減額適用中者（");
    private static final RString 時点で減額適用中の被保険者 = new RString("時点で減額適用中の被保険者）");
    private static final RString 減額終了日抽出 = new RString("　　　　 ・減額終了日抽出　開始：");
    private static final RString 終了 = new RString("　～　終了：");
    private static final RString 保険料完納者出力 = new RString("【保険料完納者も出力】  ");
    private static final RString 帳票作成日時 = new RString("【作成日時】 ");
    private static final RString TRUE = new RString("true");
    private static final RString FALSE = new RString("false");
    private Map<RString, Decimal> 調定額年度Map;
    private Map<RString, Decimal> 収入額Map;
    private Map<RString, Decimal> 未納額Map;
    private Map<RString, Decimal> 徴収権消滅期間Map;
    private Map<RString, Decimal> 納付済み期間Map;
    private Decimal 給付額減額期間;

    @Override
    protected void initialize() {

        association = AssociationFinderFactory.createInstance().getAssociation();
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        調定額年度Map = new HashMap<>();
        収入額Map = new HashMap<>();
        未納額Map = new HashMap<>();

        徴収権消滅期間Map = new HashMap<>();
        納付済み期間Map = new HashMap<>();

    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(processParameter.get帳票ID().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    private RString get出力順() {
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBD介護受給, processParameter.get帳票ID(), reamsLoginID, processParameter.get改頁出力順ID());
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator
                    .create(KyufuGakuGengakuTainoShaProcessProperty.DBD200009_KyufuGengakuKanriIchiran.class, outputOrder);
        }
        return 出力順;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, processParameter.toTaishoShaKanriJohoMybatisParameter(get出力順()));
    }

    @Override
    protected void process(KyufuGakuGengakuTainoShaEntity t) {
        List<ShunoTainoJokyoTempTableEntity> 収納滞納状況一時List = t.get収納滞納状況一時Entity();

        Decimal 調定額_合計;
        Decimal 収入額_合計;
        Decimal 未納額_合計;
        Decimal 調定額_当該;
        Decimal 収入額_当該;
        Decimal 未納額_当該;

        for (ShunoTainoJokyoTempTableEntity entity : 収納滞納状況一時List) {
            RString 賦課年度 = entity.getFukaNendo().toDateString();

            調定額_当該 = entity.getChoteigaku();
            調定額_合計 = 調定額年度Map.get(賦課年度);
            if (調定額_合計 != null) {
                調定額_合計 = 調定額_合計.add(調定額_当該);
                調定額年度Map.put(賦課年度, 調定額_合計);
            } else {
                調定額年度Map.put(賦課年度, 調定額_当該);
            }

            収入額_当該 = entity.getShunyugaku();
            収入額_合計 = 収入額Map.get(賦課年度);
            if (収入額_合計 != null) {
                収入額_合計 = 収入額_合計.add(収入額_当該);
                収入額Map.put(賦課年度, 収入額_合計);
            } else {
                収入額Map.put(賦課年度, 収入額_当該);
            }

            未納額_当該 = entity.getMinogaku();
            未納額_合計 = 未納額Map.get(賦課年度);
            if (未納額_合計 != null) {
                未納額_合計 = 未納額_合計.add(未納額_当該);
                収入額Map.put(賦課年度, 未納額_合計);
            } else {
                収入額Map.put(賦課年度, 未納額_当該);
            }
        }

        Decimal 徴収権消滅期間の合計 = Decimal.ZERO;
        Decimal 納付済み期間の合計 = Decimal.ZERO;

        Decimal 収入額_年度;
        Decimal 未納額_年度;
        for (RString key : 調定額年度Map.keySet()) {
            収入額_年度 = 収入額Map.get(key);
            未納額_年度 = 未納額Map.get(key);
            徴収権消滅期間Map.put(key, 収入額_年度.divide(調定額年度Map.get(key)));
            納付済み期間Map.put(key, 未納額_年度.divide(調定額年度Map.get(key)));

            徴収権消滅期間の合計 = 徴収権消滅期間の合計.add(収入額_年度).divide(調定額年度Map.get(key));
            納付済み期間の合計 = 納付済み期間の合計.add(未納額_年度).divide(調定額年度Map.get(key));

        }
        給付額減額期間 = Decimal.ZERO;
        給付額減額期間 = 徴収権消滅期間の合計.multiply(徴収権消滅期間の合計
                .divide(徴収権消滅期間の合計.add(納付済み期間の合計)))
                .multiply(1).divide(2).multiply(12);

        /**
         * HokenshaNo.EMPTY, RString.EMPTY:QA TODO
         */
        KyufuGengakuHaakuIchiranReport report = new KyufuGengakuHaakuIchiranReport(processParameter.get帳票作成日時(),
                null, null, 帳票印字用データを取得(t), outputOrder);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    public KyufuGengakuHaakuIchiranEntity 帳票印字用データを取得(KyufuGakuGengakuTainoShaEntity entity) {
        KyufuGengakuHaakuIchiranEntity t = new KyufuGengakuHaakuIchiranEntity();
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
        t.get被保険者情報Entity().set被保険者番号(entity.get対象者情報一時Entity().getHihokenshaNo().getColumnValue());
        t.get被保険者情報Entity().set識別コード(kojin.get識別コード().getColumnValue());
        t.get被保険者情報Entity().set被保険者氏名カナ(kojin.get名称().getKana().getColumnValue());
        t.get被保険者情報Entity().set被保険者氏名(kojin.get名称().getName().getColumnValue());
        t.get被保険者情報Entity().set世帯番号(kojin.get世帯コード().getColumnValue());
        t.get被保険者情報Entity().set行政区ｺｰﾄﾞ(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
        t.get被保険者情報Entity().set行政区(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
        t.get被保険者情報Entity().set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
        t.get被保険者情報Entity().set住所(kojin.get住所().get住所());
        t.get被保険者情報Entity().set郵便番号(kojin.get住所().get郵便番号().getColumnValue());

        t.get被保険者情報Entity().set資格取得日(entity.get収納滞納状況一時Entity().get(0).getShikakuShutokuYMD());
        t.get被保険者情報Entity().set資格喪失日(entity.get収納滞納状況一時Entity().get(0).getShikakuSoshitsuYMD());
        t.get被保険者情報Entity().set喪失事由(entity.get収納滞納状況一時Entity().get(0).getShikakuSoshitsuJiyuCode());
        t.get被保険者情報Entity().set資格区分(entity.get収納滞納状況一時Entity().get(0).get資格区分());
        t.get被保険者情報Entity().set住特フラグ(entity.get収納滞納状況一時Entity().get(0).getKoikinaiJushochiTokureiFlag());
        t.get被保険者情報Entity().set生保フラグ(entity.get収納滞納状況一時Entity().get(0).isSeihoFlag());
        t.get被保険者情報Entity().set厚労省IF識別コード(entity.get収納滞納状況一時Entity().get(0).getKoroshoIfShikibetsuCode().getColumnValue());
        t.get被保険者情報Entity().set要介護状態区分コード(entity.get収納滞納状況一時Entity().get(0).getYokaigoJotaiKubunCode().getColumnValue());
        t.get被保険者情報Entity().set認定有効期間開始年月日(entity.get収納滞納状況一時Entity().get(0).getNinteiYukoKikanKaishiYMD());
        t.get被保険者情報Entity().set認定有効期間終了年月日(entity.get収納滞納状況一時Entity().get(0).getNinteiYukoKikanShuryoYMD());
        t.get被保険者情報Entity().set認定日(entity.get収納滞納状況一時Entity().get(0).getNinteiYMD());
        t.get被保険者情報Entity().set申請中フラグ(entity.get収納滞納状況一時Entity().get(0).isShiseityuFlag());
        t.get被保険者情報Entity().set申請日(entity.get収納滞納状況一時Entity().get(0).getJukyuShinseiYMD());
//        t.get被保険者情報Entity().set徴収権消滅期間();
//        t.get被保険者情報Entity().set納付済み期間();
        t.get被保険者情報Entity().set給付額減額期間(new RString(給付額減額期間.toString()));

        List<ShunoJohoEntity> 収納情報List = new ArrayList<>();
        for (ShunoTainoJokyoTempTableEntity data : entity.get収納滞納状況一時Entity()) {
            ShunoJohoEntity resultData = new ShunoJohoEntity();
            resultData.set調定年度(data.getChoteiNendo());
            resultData.set賦課年度(data.getFukaNendo());
            List<ShunoKibetsuEntity> 期別情報List = new ArrayList<>();
            for (ShunoTainoJokyoTempTableEntity table : entity.get収納滞納状況一時Entity()) {
                ShunoKibetsuEntity resulttable = new ShunoKibetsuEntity();
                resulttable.set期別(table.getKibetsu());
                resulttable.set保険料金(table.getChoteigaku());
//QA                resulttable.set納期限(FlexibleDate.MAX);
                resulttable.set滞納額(table.getMinogaku());
                resulttable.set滞納区分(table.getTainoKubun());
                resulttable.set時効起算日(table.getJikoKisanYMD());
                resulttable.set時効起算事由(table.getJikoKisanJiyu());
                期別情報List.add(resulttable);
            }
            resultData.set期別情報(期別情報List);
            resultData.set特徴普徴区分(data.getTokucho_FuchoKubun());
            if (data.getFukaNendo() == null) {
                resultData.set収納情報なし(new RString("true"));
            }
            収納情報List.add(resultData);
        }
        t.set収納情報リスト(収納情報List);

        List<GengakuTaishoJohoEntity> 減額対象情報List = new ArrayList<>();
        for (DbT4025ShiharaiHohoHenkoGengakuEntity data : entity.get支払方法変更減額Entity()) {
            GengakuTaishoJohoEntity resultData = new GengakuTaishoJohoEntity();
            resultData.set徴収権消滅期間(new RString(data.getChoshukenShometsuKikan().toString()));
            resultData.set納付済み期間(new RString(data.getNofusumiKikan().toString()));
            resultData.set給付額減額期間(new RString(data.getNofusumiGengakuKikan().toString()));
            減額対象情報List.add(resultData);
        }
        t.set減額対象情報リスト(減額対象情報List);
        return t;
    }

    private void バッチ出力条件リストの出力() {
        RString 帳票ID = new RString("DBD200008_KyufuGengakuHaakuIchiran");
        RString 導入団体コード = association.getLasdecCode_().getColumnValue();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = ReportIdDBD.DBD200008.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("");

        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(基準日.concat(processParameter.get基準日().toString()));
        出力条件.add(対象区分.concat(processParameter.get対象区分().get名称()));
        if (TaishoKubun.全登録者以外.getコード().equals(processParameter.get対象区分().getコード())) {
            if (processParameter.is通知書未発行者抽出() == true) {
                出力条件.add(通知書未発行者);
            }
            if (processParameter.is減額適用中者抽出() == true) {
                出力条件.add(減額適用中者.concat(processParameter.get減額適用中者抽出基準日().toString())
                        .concat(時点で減額適用中の被保険者));
            }
            if (processParameter.is減額終了日抽出() == true) {
                出力条件.add(減額終了日抽出.concat(processParameter.get減額終了日範囲From().toString())
                        .concat(終了)
                        .concat(processParameter.get減額終了日範囲To().toString()));
            }
        }
        if (processParameter.is保険料完納者出力() == true) {
            出力条件.add(保険料完納者出力.concat(TRUE));
        } else {
            出力条件.add(保険料完納者出力.concat(FALSE));
        }
        出力条件.add(帳票作成日時.concat(processParameter.get帳票作成日時().toString()));
        出力条件.add(出力順);

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID,
                導入団体コード,
                市町村名,
                ジョブ番号,
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
