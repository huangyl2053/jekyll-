/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4.ShinsakaishiryoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.publicationshiryoshinsakai.IinShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.publicationshiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.ShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.publicationshiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用審査対象者一覧表情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinShinsakaiIinJohoDataSakuseiA4Process extends BatchProcessBase<ShinseiJohoEntity> {

    private static final RString SELECT_SHINASKAIIINJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.publicationshiryoshinsakai.IShiryoShinsakaiIinMapper.getShinseiJoho");
    private static final int INT_4 = 4;
    private IinShinsakaiIinJohoProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;
    private IinShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private List<PersonalData> personalDataList;
    private int no;
    private int count;
    @BatchWriter
    private BatchReportWriter<ShinsakaishiryoA4ReportSource> batchWriteA4;
    private ReportSourceWriter<ShinsakaishiryoA4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toIinShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setHaishiFlag_False(IsHaishi.廃止されていない.is廃止());
        myBatisParameter.setHaishiFlag_True(IsHaishi.廃止.is廃止());
        myBatisParameter.setSisutemuYMD(new FlexibleDate(RDate.getNowDate().toDateString()));
        shinsakaiIinJohoList = mapper.getShinsakaiIinJoho(myBatisParameter);
        count = mapper.getShinseiJohoCount(myBatisParameter);
        no = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHINASKAIIINJOHO, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517011.getReportId().value()).create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void process(ShinseiJohoEntity entity) {
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), entity.getShinseishoKanriNo().getColumnValue()));
        personalDataList.add(personalData);
        ShinsakaishiryoItem item = setShinsakaishiryoItem(entity, no);
        ShinsakaishiryoA4Report report = new ShinsakaishiryoA4Report(item);
        report.writeBy(reportSourceWriterA4);
        no = no + 1;
    }

    @Override
    protected void afterExecute() {
        AccessLogger.log(AccessLogType.照会, personalDataList);
        outputJokenhyoFactory();
    }

    private ShinsakaishiryoItem setShinsakaishiryoItem(ShinseiJohoEntity entity, int no) {
        ShinsakaishiryoItem item = new ShinsakaishiryoItem();
        item.set審査会番号(paramter.getShinsakaiKaisaiNo());
        item.set審査会開催年月日(get審査会開催年月日());
        item.set合議体番号(paramter.getGogitaiNo());
        item.set審査対象者数(new RString(count));
        item.set審査員一覧(shinsakaiIinJohoList.get(no).getShinsakaiIinShimei().getColumnValue());
        item.setNo(no + 1);
        item.set審査会審査順(new RString(entity.getShinsakaiOrder()));
        item.set保険者(entity.getShoKisaiHokenshaNo());
        item.set被保険者(entity.getHihokenshaNo());
        item.set氏名(entity.getHihokenshaName().getColumnValue());
        item.set性別(Seibetsu.toValue(entity.getSeibetsu().getColumnValue()).get名称());
        item.set年齢(new RString(entity.getAge()));
        DbT5102NinteiKekkaJohoEntity dbT5102Entity = get前回要介護認定結果情報(entity.getShinseishoKanriNo());
        item.set前回二次(get要介護状態区分(dbT5102Entity.getNijiHanteiYokaigoJotaiKubunCode()));
        item.set前回期間(get前回期間(dbT5102Entity.getNijiHanteiNinteiYukoKikan()));
        item.set二時判定認定有効開始年月日(dbT5102Entity.getNijiHanteiNinteiYukoKaishiYMD());
        item.set二時判定認定有効終了年月日(dbT5102Entity.getNijiHanteiNinteiYukoShuryoYMD());
        item.set一次判定(get要介護認定一次判定結果(entity.getIchijiHanteiKekkaCode()));
        item.set二次判定(get要介護状態区分(entity.getJotaiKubunCode()));
        item.set警告(entity.getIchijiHnateiKeikokuCode());
        item.set基準時間(new RString(entity.getKijunJikan()));
        return item;
    }

    private DbT5102NinteiKekkaJohoEntity get前回要介護認定結果情報(ShinseishoKanriNo 申請管理番号) {
        myBatisParameter.setShinseishoKanriNo(申請管理番号);
        DbT5121ShinseiRirekiJohoEntity dbT5121Entity = mapper.get前回の申請管理番号(myBatisParameter);
        myBatisParameter.setShinseishoKanriNo(dbT5121Entity.getZenkaiShinseishoKanriNo());
        return mapper.get前回二次判定(myBatisParameter);
    }

    private RString get前回期間(int 期間) {
        RStringBuilder 前回期間 = new RStringBuilder();
        前回期間.append(期間);
        前回期間.append(new RString("ヵ月"));
        return 前回期間.toRString();
    }

    private RString get要介護状態区分(Code 状態区分コード) {
        if (状態区分コード != null && !状態区分コード.isEmpty()) {
            return YokaigoJotaiKubun09.toValue(状態区分コード.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get要介護認定一次判定結果(Code 判定結果コード) {
        if (判定結果コード != null && !判定結果コード.isEmpty()) {
            return IchijiHanteiKekkaCode09.toValue(判定結果コード.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get審査会開催年月日() {
        RStringBuilder 審査会開催年月日 = new RStringBuilder();
        審査会開催年月日.append(パターン33(paramter.getShinsakaiKaisaiYoteiYMD()));
        審査会開催年月日.append(paramter.getShinsakaiKaishiYoteiTime().substring(0, 2));
        審査会開催年月日.append(new RString("時"));
        審査会開催年月日.append(paramter.getShinsakaiKaishiYoteiTime().substring(2));
        審査会開催年月日.append(new RString("分"));
        return 審査会開催年月日.toRString();
    }

    private RString パターン33(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString id = ReportIdDBE.DBE517011.getReportId().getColumnValue();
        RString ページ数 = new RString(reportSourceWriterA4.pageCount().value());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                get帳票名(),
                ページ数,
                RString.EMPTY,
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(条件(new RString("合議体番号"), paramter.getGogitaiNo()));
        出力条件.add(条件(new RString("介護認定審査会開催予定年月日"), paramter.getShinsakaiKaisaiYoteiYMD().wareki().toDateString()));
        出力条件.add(条件(new RString("介護認定審査会開催番号"), paramter.getShinsakaiKaisaiNo()));
        return 出力条件;
    }

    private RString 条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("【"));
        条件.append(バッチパラメータ名);
        条件.append(new RString("】"));
        条件.append(値);
        return 条件.toRString();
    }

    private RString get帳票名() {
        RString 介護認定審査会開催番号 = paramter.getShinsakaiKaisaiNo();
        RStringBuilder 帳票名 = new RStringBuilder();
        帳票名.append(介護認定審査会開催番号.substring(介護認定審査会開催番号.length() - INT_4));
        帳票名.append(new RString("　審査会"));
        return 帳票名.toRString();
    }
}
