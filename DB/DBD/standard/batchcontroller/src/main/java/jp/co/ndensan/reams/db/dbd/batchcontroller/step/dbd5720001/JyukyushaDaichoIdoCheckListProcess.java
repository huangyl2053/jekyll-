/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5720001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.dbd5720011.JyukyushaDaichoIdoCheckListOutputResult;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200037.JukyushaIdoCheckListItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200037.JukyushaIdoCheckListProperty.DBD200037_JukyushaIdoCheckListEnum;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200037.JukyushaIdoCheckListReport;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5720001.JyukyushaDaichoIdoCheckListMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5720001.JyukyushaDaichoIdoCheckListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.JyukyushaDaichoIdoCheckListEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.LowerEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.UpperEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200037.JukyushaIdoCheckListReportSource;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * バッチ設計_受給者台帳異動チェックリストのprocess処理クラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public class JyukyushaDaichoIdoCheckListProcess extends BatchKeyBreakBase<JyukyushaDaichoIdoCheckListEntity> {

    private static final ReportId REPORT_DBD200037 = ReportIdDBD.DBD200037.getReportId();
    private JyukyushaDaichoIdoCheckListProcessParameter parameter;
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(JukyushaIdoCheckListReportSource.ReportSourceFields.hokenshaNo.name())));
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushaidochecklist."
            + "IJukyushaIdoCheckListMapper.get帳票出力対象データ");
    private static final int INT0 = 0;
    private static final int INT1 = 1;
    private static final int INT2 = 2;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private RString 出力順1 = RString.EMPTY;
    private RString 出力順2 = RString.EMPTY;
    private RString 出力順3 = RString.EMPTY;
    private RString 出力順4 = RString.EMPTY;
    private RString 出力順5 = RString.EMPTY;
    private RString 改頁1 = RString.EMPTY;
    private RString 改頁2 = RString.EMPTY;
    private RString 改頁3 = RString.EMPTY;
    private RString 改頁4 = RString.EMPTY;
    private RString 改頁5 = RString.EMPTY;

    @BatchWriter
    private BatchReportWriter<JukyushaIdoCheckListReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaIdoCheckListReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        get出力順項目();
    }

    @Override
    protected IBatchReader createReader() {
        JyukyushaDaichoIdoCheckListMybatisParameter mybatisPrm = toJyukyushaDaichoIdoCheckListMybatisParameter();
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisPrm);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD200037.value()).addBreak(
                new BreakerCatalog<JukyushaIdoCheckListReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(JyukyushaDaichoIdoCheckListEntity current) {

    }

    @Override
    protected void usualProcess(JyukyushaDaichoIdoCheckListEntity entity) {
        JyukyushaDaichoIdoCheckListOutputResult business = new JyukyushaDaichoIdoCheckListOutputResult();
        UpperEntity upperEntity = business.getUpperEntity(entity);
        LowerEntity lowerEntity = business.getLowerEntity(entity);
        JukyushaIdoCheckListReport report = new JukyushaIdoCheckListReport(setItem(), upperEntity, lowerEntity);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), new RString("申請書管理番号")));
        AccessLogger.log(AccessLogType.照会, personalData);
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(SubGyomuCode.DBD介護受給, REPORT_DBD200037, parameter.get出力順ID());
        RString 出力順 = RString.EMPTY;
        if (null == order) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(new RString("帳票出力順の取得").toString()).toString());
        } else {
            出力順 = MyBatisOrderByClauseCreator.create(DBD200037_JukyushaIdoCheckListEnum.class, order);
        }
        return 出力順;
    }

    private JukyushaIdoCheckListItem setItem() {
        return new JukyushaIdoCheckListItem(
                出力順1,
                出力順2,
                出力順3,
                出力順4,
                出力順5,
                改頁1,
                改頁2,
                改頁3,
                改頁4,
                改頁5);
    }

    private void get出力順項目() {
        Map<Integer, RString> 改頁Map = ReportUtil.get改頁項目(SubGyomuCode.DBD介護受給,
                parameter.get出力順ID(),
                REPORT_DBD200037);
        Map<Integer, ISetSortItem> 出力順Map = ReportUtil.get出力順項目(SubGyomuCode.DBD介護受給,
                parameter.get出力順ID(),
                REPORT_DBD200037);
        if (出力順Map.get(INT0) != null) {
            出力順1 = 出力順Map.get(INT0).get項目名();
        }
        if (出力順Map.get(INT1) != null) {
            出力順2 = 出力順Map.get(INT1).get項目名();
        }
        if (出力順Map.get(INT2) != null) {
            出力順3 = 出力順Map.get(INT2).get項目名();
        }
        if (出力順Map.get(INT3) != null) {
            出力順4 = 出力順Map.get(INT3).get項目名();
        }
        if (出力順Map.get(INT4) != null) {
            出力順5 = 出力順Map.get(INT4).get項目名();
        }
        get改頁(改頁Map);

    }

    private void get改頁(Map<Integer, RString> 改頁Map) {
        if (改頁Map.get(INT0) != null) {
            改頁1 = 改頁Map.get(INT0);
        }
        if (改頁Map.get(INT1) != null) {
            改頁2 = 改頁Map.get(INT1);
        }
        if (改頁Map.get(INT2) != null) {
            改頁3 = 改頁Map.get(INT2);
        }
        if (改頁Map.get(INT3) != null) {
            改頁4 = 改頁Map.get(INT3);
        }
        if (改頁Map.get(INT4) != null) {
            改頁5 = 改頁Map.get(INT4);
        }

    }

    private RDateTime get行挿入日時1() {
        YMDHMS 行挿入日時開始 = new YMDHMS(parameter.get今回抽出開始年月日(), parameter.get今回抽出開始時分秒());
        return 行挿入日時開始.getRDateTime();
    }

    private RDateTime get行挿入日時2() {
        YMDHMS 行挿入日時終了 = new YMDHMS(parameter.get今回抽出終了年月日(), parameter.get今回抽出終了時分秒());
        return 行挿入日時終了.getRDateTime();
    }

    private JyukyushaDaichoIdoCheckListMybatisParameter toJyukyushaDaichoIdoCheckListMybatisParameter() {
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        return new JyukyushaDaichoIdoCheckListMybatisParameter(parameter.get今回抽出開始年月日(),
                get行挿入日時1(), parameter.get今回抽出終了年月日(), get行挿入日時2(),
                parameter.get出力対象(), get出力順(), shikibetsuTaishoPSMSearchKey);
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString ページ数 = new RString(reportSourceWriter.pageCount().value());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                REPORT_DBD200037.getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD200037.getReportName(),
                ページ数,
                new RString("無し"),
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();

    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();

        if (parameter.get今回抽出開始年月日() != null) {
            出力条件.add(add出力条件(new RString("今回抽出開始年月日"), parameter.get今回抽出開始年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出開始時分秒() != null) {
            出力条件.add(add出力条件(new RString("今回抽出開始時分秒"), parameter.get今回抽出開始時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
        if (parameter.get今回抽出終了年月日() != null) {
            出力条件.add(add出力条件(new RString("今回抽出終了年月日"), parameter.get今回抽出終了年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出終了時分秒() != null) {
            出力条件.add(add出力条件(new RString("今回抽出終了時分秒"), parameter.get今回抽出終了時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
        if (parameter.get出力対象() != null) {
            出力条件.add(add出力条件(new RString("出力対象"), parameter.get出力対象()));
        }

        return 出力条件;
    }

    private RString add出力条件(RString バッチパラメータ名, RString 値) {
        RString 条件 = new RStringBuilder(new RString("[")).append(バッチパラメータ名).
                append(new RString("]")).append(値).toRString();
        return 条件;
    }

}
