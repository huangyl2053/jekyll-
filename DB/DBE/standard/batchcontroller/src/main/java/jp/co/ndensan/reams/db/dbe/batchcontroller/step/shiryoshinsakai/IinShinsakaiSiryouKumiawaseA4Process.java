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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IchijihanteikekkahyoItemSettei;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiText1A4Business;
import jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa4.IinShinsakaishiryoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.ShinsakaiSiryouKumiawaseA3ProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinshinsakaishiryoa4.IinShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 委員審査会資料組み合わせ一覧A4版のバッチ処理です。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class IinShinsakaiSiryouKumiawaseA4Process extends SimpleBatchProcessBase {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(IinShinsakaishiryoA4ReportSource.ReportSourceFields.two_tokkiText.name()),
            new RString(IinShinsakaishiryoA4ReportSource.ReportSourceFields.two_tokkiImg.name()),
            new RString(IinShinsakaishiryoA4ReportSource.ReportSourceFields.three_tokkiText.name()),
            new RString(IinShinsakaishiryoA4ReportSource.ReportSourceFields.three_tokkiImg.name())));
    private static final RString 印字する = new RString("1");
    private static final RString 両面 = new RString("1");
    private static final int INT_4 = 4;
    private ShinsakaiSiryouKumiawaseA3ProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;
    private IinShinsakaiIinJohoMyBatisParameter 対象者一覧MyBatisParameter;
    private IinTokkiJikouItiziHanteiMyBatisParameter 一次判定MyBatisParameter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private List<ShinsakaiTaiyosyaJohoEntity> shinsakaiTaiyosyaJohoList;
    private List<JimuShinsakaishiryoBusiness> jimuShinsakaishiryoList;
    private List<ItiziHanteiEntity> itiziHanteiList;
    private List<ShinsakaiSiryoKyotsuEntity> shinsakaiSiryoKyotsuList;
    private int no;
    private int count;
    private int shinsakaiOrder;
    private int 存在ファイルindex;
    @BatchWriter
    private BatchReportWriter<IinShinsakaishiryoA4ReportSource> batchReportWriter;
    private ReportSourceWriter<IinShinsakaishiryoA4ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        shinsakaiOrder = -1;
        存在ファイルindex = 0;
        shinsakaiIinJohoList = new ArrayList<>();
        shinsakaiTaiyosyaJohoList = new ArrayList<>();
        jimuShinsakaishiryoList = new ArrayList<>();
        itiziHanteiList = new ArrayList<>();
        shinsakaiSiryoKyotsuList = new ArrayList<>();
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        対象者一覧MyBatisParameter = paramter.toIinShinsakaiIinJohoMyBatisParameter();
        一次判定MyBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        一次判定MyBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        itiziHanteiList = mapper.getItiziHantei(一次判定MyBatisParameter);
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        一次判定MyBatisParameter.setShoriJotaiKubunList(shoriJotaiKubunList);
        一次判定MyBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        shinsakaiSiryoKyotsuList = mapper.getShinsakaiSiryoKyotsu(一次判定MyBatisParameter);
        get審査対象者一覧表情報();
    }

    @Override
    protected void process() {
        RString reportId;
        RDate 日期 = RDate.getNowDate();
        if (両面.equals(paramter.getPrintHou())
                && 印字する.equals(DbBusinessConfig.get(ConfigNameDBE.特記と意見書の見開き印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            reportId = ReportIdDBE.DBE517906.getReportId().value();
        } else {
            reportId = ReportIdDBE.DBE517905.getReportId().value();
        }
        batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId)
                .addBreak(new BreakerCatalog<IinShinsakaishiryoA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .addBreak(new BreakerCatalog<IinShinsakaishiryoA4ReportSource>().new SimpleLayoutBreaker(
                    IinShinsakaishiryoA4ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<IinShinsakaishiryoA4ReportSource> occuredBreak(
                            ReportLineRecord<IinShinsakaishiryoA4ReportSource> currentRecord,
                            ReportLineRecord<IinShinsakaishiryoA4ReportSource> nextRecord,
                            ReportDynamicChart dynamicChart) {
                                int layout = currentRecord.getSource().layout.index();
                                currentRecord.setFormGroupIndex(layout);
                                if (nextRecord != null && nextRecord.getSource() != null) {
                                    layout = nextRecord.getSource().layout.index();
                                    nextRecord.setFormGroupIndex(layout);
                                }
                                return currentRecord;
                            }
                }).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        List<ShinseishoKanriNo> 申請書管理番号List = new ArrayList<>();
        for (ItiziHanteiEntity entity : itiziHanteiList) {
            if (!申請書管理番号List.contains(entity.getShinseishoKanriNo())) {
                申請書管理番号List.add(entity.getShinseishoKanriNo());
            }
        }
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiSiryoKyotsuList) {
            if (!申請書管理番号List.contains(entity.getShinseishoKanriNo())) {
                申請書管理番号List.add(entity.getShinseishoKanriNo());
            }
        }
        for (ShinseishoKanriNo shinseishoKanriNo : 申請書管理番号List) {
            IinShinsakaishiryoA4Report report = new IinShinsakaishiryoA4Report(jimuShinsakaishiryoList,
                    get一次判定結果票(shinseishoKanriNo),
                    get特記事項情報(shinseishoKanriNo),
                    get主治医意見書情報(shinseishoKanriNo),
                    getその他資料情報(shinseishoKanriNo),
                    reportId);
            report.writeBy(reportSourceWriter);
        }
        batchReportWriter.close();
    }

    private void get審査対象者一覧表情報() {
        no = 0;
        対象者一覧MyBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        対象者一覧MyBatisParameter.setHaishiFlag_False(IsHaishi.有効.is廃止());
        対象者一覧MyBatisParameter.setHaishiFlag_True(IsHaishi.廃止.is廃止());
        対象者一覧MyBatisParameter.setSisutemuYMD(FlexibleDate.getNowDate());
        shinsakaiIinJohoList = mapper.getShinsakaiIinJoho(対象者一覧MyBatisParameter);
        count = mapper.getShinsakaiTaiyosyaJohoCount(対象者一覧MyBatisParameter);
        shinsakaiTaiyosyaJohoList = mapper.getShinsakaiTaiyosyaJoho(対象者一覧MyBatisParameter);
        for (ShinsakaiTaiyosyaJohoEntity entity : shinsakaiTaiyosyaJohoList) {
            entity.setShoKisaiHokenshaNo(RString.EMPTY);
            entity.setHihokenshaNo(RString.EMPTY);
            entity.setHihokenshaName(AtenaMeisho.EMPTY);
            entity.setJimukyoku(false);
            jimuShinsakaishiryoList.add(new JimuShinsakaishiryoBusiness(
                    paramter.toIinShinsakaiIinJohoProcessParameter(), entity, shinsakaiIinJohoList, no, count));
            no = no + 1;
        }
    }

    private IchijihanteikekkahyoA4Entity get一次判定結果票(ShinseishoKanriNo shinseishoKanriNo) {
        for (ItiziHanteiEntity entity : itiziHanteiList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                IinTokkiJikouItiziHanteiMyBatisParameter parameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
                parameter.setShinseishoKanri(entity.getShinseishoKanriNo());
                parameter.setNinteichosaRirekiNo(entity.getNinteichosaIraiRirekiNo());
                List<DbT5207NinteichosahyoServiceJokyoEntity> サービス利用状況 = getサービス利用状況(entity, parameter);
                DbT5208NinteichosahyoServiceJokyoFlagEntity サービスの状況フラグ = mapper.getServiceJokyoFlag(parameter);
                DbT5210NinteichosahyoShisetsuRiyoEntity 現在の状況 = mapper.getGenzaiJokyo(parameter);
                List<DbT5205NinteichosahyoTokkijikoEntity> 特記事項情報 = mapper.getTokkijiko(parameter);
                List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報 = mapper.getChosahyoChosaItem(parameter);
                parameter.setIkenshoIraiRirekiNo(entity.getIkenshoIraiRirekiNo());
                List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目情報 = mapper.getIkenshoIkenItem(parameter);
                parameter.setShinseishoKanriZ(entity.getZShinseishoKanriNo());
                List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目情報 = mapper.getZenkaiChosahyoChosaItem(parameter);
                return new IchijihanteikekkahyoItemSettei().set項目(entity, 特記事項情報, 調査票調査項目情報, 前回調査項目情報, 主治医意見書項目情報,
                        new ArrayList(), サービス利用状況, サービス利用状況, サービスの状況フラグ, 現在の状況, new RString(paramter.getGogitaiNo()));
            }
        }
        return null;
    }

    private TokkiText1A4Business get特記事項情報(ShinseishoKanriNo shinseishoKanriNo) {
        for (ShinsakaiSiryoKyotsuEntity kyotsuEntity : shinsakaiSiryoKyotsuList) {
            if (shinseishoKanriNo.equals(kyotsuEntity.getShinseishoKanriNo())) {
                kyotsuEntity.setJimukyoku(false);
                kyotsuEntity.setShoKisaiHokenshaNo(RString.EMPTY);
                kyotsuEntity.setHihokenshaNo(RString.EMPTY);
                kyotsuEntity.setHihokenshaName(AtenaMeisho.EMPTY);

                List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List = get特記情報(kyotsuEntity);
                return new TokkiText1A4Business(kyotsuEntity, 特記情報List);
            }
        }
        return null;
    }

    private JimuShinsakaiWariateJohoBusiness get主治医意見書情報(ShinseishoKanriNo shinseishoKanriNo) {
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiSiryoKyotsuList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                entity.setHihokenshaNo(RString.EMPTY);
                entity.setHihokenshaName(AtenaMeisho.EMPTY);
                entity.setShoKisaiHokenshaNo(RString.EMPTY);
                entity.setJimukyoku(false);
                return new JimuShinsakaiWariateJohoBusiness(entity);
            }
        }
        return null;
    }

    private JimuSonotashiryoBusiness getその他資料情報(ShinseishoKanriNo shinseishoKanriNo) {
        JimuSonotashiryoBusiness business = null;
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiSiryoKyotsuList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                entity.setHihokenshaNo(RString.EMPTY);
                entity.setHihokenshaName(AtenaMeisho.EMPTY);
                entity.setShoKisaiHokenshaNo(RString.EMPTY);
                entity.setJimukyoku(false);
                if (shinsakaiOrder != entity.getShinsakaiOrder()) {
                    存在ファイルindex = 0;
                }
                business = new JimuSonotashiryoBusiness(entity, 存在ファイルindex);
                存在ファイルindex = business.get存在ファイルIndex();
                shinsakaiOrder = entity.getShinsakaiOrder();
            }
        }
        return business;
    }

    private List<DbT5207NinteichosahyoServiceJokyoEntity> getサービス利用状況(ItiziHanteiEntity entity,
            IinTokkiJikouItiziHanteiMyBatisParameter parameter) {
        List<DbT5207NinteichosahyoServiceJokyoEntity> サービス利用状況 = new ArrayList<>();
        if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
            サービス利用状況 = mapper.getYoboService(parameter);
        } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
            サービス利用状況 = mapper.getKaigoService(parameter);
        }
        return サービス利用状況;
    }

    private List<DbT5205NinteichosahyoTokkijikoEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        一次判定MyBatisParameter.setGenponMaskKubun(GenponMaskKubun.マスク.getコード());
        一次判定MyBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        一次判定MyBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.getTokkiIranJoho(一次判定MyBatisParameter);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory(ReportIdDBE.DBE517011.getReportId().value(), get帳票名());
        outputJokenhyoFactory(ReportIdDBE.DBE517141.getReportId().value(), new RString("概況調査の特記"));
        outputJokenhyoFactory(ReportIdDBE.DBE517131.getReportId().value(), new RString("特記事項（1枚目）"));
        outputJokenhyoFactory(ReportIdDBE.DBE517038.getReportId().value(), new RString("一次判定結果票"));
        outputJokenhyoFactory(ReportIdDBE.DBE517134.getReportId().value(), new RString("特記事項（2枚目以降）"));
        outputJokenhyoFactory(ReportIdDBE.DBE517151.getReportId().value(), new RString("主治医意見書（表）"));
        outputJokenhyoFactory(ReportIdDBE.DBE517152.getReportId().value(), new RString("主治医意見書（裏）"));
        outputJokenhyoFactory(ReportIdDBE.DBE517016.getReportId().value(), new RString("その他資料"));
    }

    private RString get帳票名() {
        RString 介護認定審査会開催番号 = paramter.getShinsakaiKaisaiNo();
        RStringBuilder 帳票名 = new RStringBuilder();
        帳票名.append(介護認定審査会開催番号.substring(介護認定審査会開催番号.length() - INT_4));
        帳票名.append(new RString("　審査会"));
        return 帳票名.toRString();
    }

    private void outputJokenhyoFactory(RString id, RString 帳票名) {
        RString 総ページ数 = new RString(batchReportWriter.getPageCount());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem jokenhyoItem = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                総ページ数,
                RString.EMPTY,
                RString.EMPTY,
                出力条件());
        OutputJokenhyoFactory.createInstance(jokenhyoItem).print();
    }

    private List<RString> 出力条件() {
        List<RString> list = new ArrayList<>();
        RStringBuilder builder1 = new RStringBuilder();
        builder1.append("【合議体番号】")
                .append(" ")
                .append(paramter.getGogitaiNo());
        RStringBuilder builder2 = new RStringBuilder();
        builder2.append("【介護認定審査会開催予定年月日】")
                .append(" ")
                .append(paramter.getShinsakaiKaisaiYoteiYMD().wareki().toDateString());
        RStringBuilder builder3 = new RStringBuilder();
        builder3.append("【介護認定審査会開催番号】")
                .append(" ")
                .append(paramter.getShinsakaiKaisaiNo());
        list.add(builder1.toRString());
        list.add(builder2.toRString());
        list.add(builder3.toRString());
        return list;
    }
}
