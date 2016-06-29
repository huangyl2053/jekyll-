/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.iinYobihanteiKinyuhyo.IinYobihanteiKinyuhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.iinYobihanteiKinyuhyo.IinYobihanteiKinyuhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.HanteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.iinYobihanteiKinyuhyoReportSource.IinYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 委員用予備判定記入表情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinHanteiDataSakuseiA4Process extends BatchKeyBreakBase<HanteiJohoEntity> {

    private static final RString SELECT_HANTEIJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getHanteiJoho");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(IinYobihanteiKinyuhyoReportSource.ReportSourceFields.shinsakaiKaisaiNo.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private IinYobihanteiKinyuhyoItem item;
    private int データ件数;
    private static final int 満ページ件数 = 10;
    @BatchWriter
    private BatchReportWriter<IinYobihanteiKinyuhyoReportSource> batchWrite;
    private ReportSourceWriter<IinYobihanteiKinyuhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        データ件数 = 0;
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setIsShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setIsShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HANTEIJOHO, myBatisParameter);
    }

    @Override
    protected void usualProcess(HanteiJohoEntity entity) {
        set項目(entity);
        IinYobihanteiKinyuhyoReport report = IinYobihanteiKinyuhyoReport.createFrom(item);
        データ件数 = データ件数 + 1;
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517022.getReportId().value())
                .addBreak(new BreakerCatalog<IinYobihanteiKinyuhyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    @Override
    protected void keyBreakProcess(HanteiJohoEntity t) {
        if (データ件数 % 満ページ件数 == 0) {
            IinYobihanteiKinyuhyoReport report = IinYobihanteiKinyuhyoReport.createFrom(item);
            report.writeBy(reportSourceWriter);
        }
    }

    private void set項目(HanteiJohoEntity entity) {
        item = new IinYobihanteiKinyuhyoItem(作成年月日(),
                paramter.getShinsakaiKaisaiNo(),
                new RString(entity.getShinsakaiOrder()),
                entity.getShinseijiKubunCode() == null || entity.getShinseijiKubunCode().isEmpty() ? RString.EMPTY
                : NinteiShinseiShinseijiKubunCode.toValue(
                        entity.getShinseijiKubunCode().getColumnValue()).get名称(),
                HihokenshaKubunCode.toValue(entity.getHihokenshaKubunCode()).get名称(),
                entity.getSeibetsu() == null || entity.getSeibetsu().isEmpty() ? RString.EMPTY
                : Seibetsu.toValue(entity.getSeibetsu().getColumnValue()).get名称(),
                new RString(entity.getAge()),
                entity.getYokaigoJotaiKubunCode() == null || entity.getYokaigoJotaiKubunCode().isEmpty() ? RString.EMPTY
                : YokaigoJotaiKubun09.toValue(entity.getYokaigoJotaiKubunCode().getColumnValue()).get名称(),
                new RString(entity.getHanteiNinteiYukoKikan()),
                entity.getIchijiHanteiKekkaCode() == null || entity.getIchijiHanteiKekkaCode().isEmpty() ? RString.EMPTY
                : IchijiHanteiKekkaCode09.toValue(entity.getIchijiHanteiKekkaCode().getColumnValue()).get名称(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                entity.getNigoTokuteiShippeiCode() == null || entity.getNigoTokuteiShippeiCode().isEmpty() ? RString.EMPTY
                : entity.getNigoTokuteiShippeiCode().getColumnValue(),
                entity.getNigoTokuteiShippeiCode() == null || entity.getNigoTokuteiShippeiCode().isEmpty() ? RString.EMPTY
                : TokuteiShippei.toValue(entity.getNigoTokuteiShippeiCode().getColumnValue()).get名称(),
                RString.EMPTY, RString.EMPTY);
    }

    private RString 作成年月日() {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString())
                .append(" ")
                .append(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).toString())
                .append(" ")
                .append("作成")
                .toRString();
    }

    private void outputJokenhyoFactory() {
        RString id = ReportIdDBE.DBE517022.getReportId().getColumnValue();
        RString idName = ReportIdDBE.DBE517022.getReportName();
        RString 総ページ数 = new RString(batchWrite.getPageCount());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem jokenhyoItem = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                idName,
                総ページ数,
                RString.EMPTY,
                RString.EMPTY,
                出力条件());
        OutputJokenhyoFactory.createInstance(jokenhyoItem).print();
    }

    private List<RString> 出力条件() {
        List<RString> list = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append("【介護認定審査会開催番号】")
                .append(" ")
                .append(paramter.getShinsakaiKaisaiNo());
        list.add(builder.toRString());
        return list;
    }
}
