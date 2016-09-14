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
import jp.co.ndensan.reams.db.dbd.business.core.dbd5720011.JyukyushaDaichoIdoCheckListOutputResult;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200037.JukyushaIdoCheckListProperty.DBD200037_JukyushaIdoCheckListEnum;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200037.JukyushaIdoCheckListReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5720001.JyukyushaDaichoIdoCheckListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.JyukyushaDaichoIdoCheckListEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.LowerEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.UpperEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200037.JukyushaIdoCheckListReportSource;
import jp.co.ndensan.reams.db.dbd.service.report.dbd5720001.OutputJokenhyoFactory;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.RLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

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
    private IOutputOrder order = null;
    private RString 出力順 = RString.EMPTY;
    private static final int NUM5 = 5;
    private static final RString 申請書管理番号 = new RString("申請書管理番号");
    private static final RString 帳票出力順の取得 = new RString("帳票出力順の取得");
    private static final int NO_0 = 0;
    private static final int NO_5 = 5;

    @BatchWriter
    private BatchReportWriter<JukyushaIdoCheckListReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaIdoCheckListReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (parameter.get出力順ID() != null) {
            order = finder.get出力順(SubGyomuCode.DBD介護受給, REPORT_DBD200037, parameter.get出力順ID());
            出力順 = get出力順(order);
        } else {
            RLogger.info("uvwxyz");
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(帳票出力順の取得.toString()).toString());
        }
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        YMDHMS 行挿入日時開始 = new YMDHMS(parameter.get今回抽出開始年月日(), parameter.get今回抽出開始時分秒());
        YMDHMS 行挿入日時終了 = new YMDHMS(parameter.get今回抽出終了年月日(), parameter.get今回抽出終了時分秒());
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJyukyushaDaichoIdoCheckListMybatisParameter(
                shikibetsuTaishoPSMSearchKey, 行挿入日時開始.getRDateTime(), 行挿入日時終了.getRDateTime(), 出力順));
    }

    @Override
    protected void createWriter() {
        List<RString> pageBreakKeys = new ArrayList<>();
        set改頁Key(order, pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD200037.value()).addBreak(
                new BreakerCatalog<JukyushaIdoCheckListReportSource>().simplePageBreaker(pageBreakKeys)).create();
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
        JukyushaIdoCheckListReport report = new JukyushaIdoCheckListReport(upperEntity, lowerEntity, order);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        OutputJokenhyoFactory outputJokenhyo = new OutputJokenhyoFactory();
        outputJokenhyo.outputJokenhyoFactory(reportSourceWriter, parameter);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                new ExpandedInformation(new Code("0001"), 申請書管理番号, 申請書管理番号));
        AccessLogger.log(AccessLogType.照会, personalData);
    }

    private RString get出力順(IOutputOrder order) {
        if (null == order) {
            RLogger.info("abcdefg");
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(帳票出力順の取得.toString()).toString());
        } else {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.
                    create(DBD200037_JukyushaIdoCheckListEnum.class, order), NUM5);
        }
        return 出力順;
    }

    private void set改頁Key(IOutputOrder outputOrder, List<RString> pageBreakKeys) {
        pageBreakKeys.addAll(PAGE_BREAK_KEYS);
        if (outputOrder != null) {
            List<ISetSortItem> list = outputOrder.get設定項目リスト();
            if (list == null) {
                list = new ArrayList<>();
            }
            for (int index = 0; index < NO_5; index++) {
                setList(index, pageBreakKeys, list);
            }
        }
    }

    private void setList(int index, List<RString> pageBreakKeys, List<ISetSortItem> list) {

        if (list.size() > index && list.get(index).is改頁項目()) {
            if (!list.get(index).get項目名().isEmpty()) {
                pageBreakKeys.add(list.get(index).get項目名());
            }
        }

    }

}
