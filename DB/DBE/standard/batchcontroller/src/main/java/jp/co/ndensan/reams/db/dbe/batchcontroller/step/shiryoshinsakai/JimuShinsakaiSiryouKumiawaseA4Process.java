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
import jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa4.JimuShinsakaishiryoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa4.JimuShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 事務局審査会資料組み合わせ一覧A4版のバッチ処理です。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class JimuShinsakaiSiryouKumiawaseA4Process extends SimpleBatchProcessBase {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(JimuShinsakaishiryoA4ReportSource.ReportSourceFields.tokkiText.name()),
            new RString(JimuShinsakaishiryoA4ReportSource.ReportSourceFields.tokkiImg.name())));
    private static final RString 印字する = new RString("1");
    private static final RString 両面 = new RString("1");
    private static final int INT_4 = 4;
    private IinShinsakaiIinJohoProcessParameter paramter;
    private IJimuShiryoShinsakaiIinMapper mapper;
    private JimuShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private List<ShinsakaiTaiyosyaJohoEntity> shinsakaiTaiyosyaJohoList;
    private List<JimuShinsakaishiryoBusiness> jimuShinsakaishiryoList;
    private List<ItiziHanteiEntity> itiziHanteiEntityList;
    private List<ShinsakaiSiryoKyotsuEntity> shinsakaiSiryoKyotsuEntityList;
    private int no;
    private int count;
    private int shinsakaiOrder;
    private int 存在ファイルindex;
    private static final int INDEX_5 = 5;
    private static final boolean あり = true;
    private static final boolean 無し = false;
    private static final RString ファイル名_G0001 = new RString("G0001.png");
    private boolean is審査会対象一覧印刷済み;
    private static final RString SEPARATOR = new RString("/");

    @BatchWriter
    private BatchReportWriter<JimuShinsakaishiryoA4ReportSource> batchReportWriter;
    private ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter;

    static {
        System.setProperty("java.awt.headless", "true");
    }

    @Override
    protected void beforeExecute() {

        shinsakaiOrder = -1;
        存在ファイルindex = 0;
        shinsakaiIinJohoList = new ArrayList<>();
        shinsakaiTaiyosyaJohoList = new ArrayList<>();
        jimuShinsakaishiryoList = new ArrayList<>();
        itiziHanteiEntityList = new ArrayList<>();
        shinsakaiSiryoKyotsuEntityList = new ArrayList<>();
        mapper = getMapper(IJimuShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        shinsakaiSiryoKyotsuEntityList = mapper.get共通情報(myBatisParameter);
        itiziHanteiEntityList = mapper.get事務局一次判定結果(myBatisParameter);
        get審査対象者一覧表情報();
        is審査会対象一覧印刷済み = false;
    }

    @Override
    protected void process() {
        RString reportId;
        RDate 日期 = RDate.getNowDate();
        if (両面.equals(paramter.getPrintHou())
                && 印字する.equals(DbBusinessConfig.get(ConfigNameDBE.特記と意見書の見開き印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            reportId = ReportIdDBE.DBE517904.getReportId().value();
        } else {
            reportId = ReportIdDBE.DBE517901.getReportId().value();
        }
        batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId)
                .addBreak(new BreakerCatalog<JimuShinsakaishiryoA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .addBreak(new BreakerCatalog<JimuShinsakaishiryoA4ReportSource>().
        new SimpleLayoutBreaker(JimuShinsakaishiryoA4ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<JimuShinsakaishiryoA4ReportSource> occuredBreak(
                            ReportLineRecord<JimuShinsakaishiryoA4ReportSource> currentRecord,
                            ReportLineRecord<JimuShinsakaishiryoA4ReportSource> nextRecord,
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
        for (ItiziHanteiEntity entity : itiziHanteiEntityList) {
            if (!申請書管理番号List.contains(entity.getShinseishoKanriNo())) {
                申請書管理番号List.add(entity.getShinseishoKanriNo());
            }
        }
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiSiryoKyotsuEntityList) {
            if (!申請書管理番号List.contains(entity.getShinseishoKanriNo())) {
                申請書管理番号List.add(entity.getShinseishoKanriNo());
            }
        }
        for (ShinseishoKanriNo shinseishoKanriNo : 申請書管理番号List) {
            JimuShinsakaishiryoA4Report report = new JimuShinsakaishiryoA4Report(jimuShinsakaishiryoList,
                    get一次判定結果票情報(shinseishoKanriNo),
                    get特記事項情報(shinseishoKanriNo),
                    get主治医意見書情報(shinseishoKanriNo),
                    getその他資料情報(shinseishoKanriNo),
                    reportId, is審査会対象一覧印刷済み);
            report.writeBy(reportSourceWriter);
            is審査会対象一覧印刷済み = true;
        }
        batchReportWriter.close();
    }

    private void get審査対象者一覧表情報() {
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setHaishiFlag_False(IsHaishi.有効.is廃止());
        myBatisParameter.setHaishiFlag_True(IsHaishi.廃止.is廃止());
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setSisutemuYMD(FlexibleDate.getNowDate());
        shinsakaiIinJohoList = mapper.get事務局委員氏名(myBatisParameter);
        count = mapper.get事務局情報件数(myBatisParameter);
        shinsakaiTaiyosyaJohoList = mapper.get事務局情報(myBatisParameter);
        jimuShinsakaishiryoList = new ArrayList<>();
        for (ShinsakaiTaiyosyaJohoEntity entity : shinsakaiTaiyosyaJohoList) {
            entity.setJimukyoku(true);
            jimuShinsakaishiryoList.add(new JimuShinsakaishiryoBusiness(paramter, entity, shinsakaiIinJohoList, no, count));
        }
    }

    private IchijihanteikekkahyoA4Entity get一次判定結果票情報(ShinseishoKanriNo shinseishoKanriNo) {
        for (ItiziHanteiEntity entity : itiziHanteiEntityList) {
            ShinseishoKanriNo 申請書管理番号 = entity.getShinseishoKanriNo();
            if (shinseishoKanriNo.equals(申請書管理番号)) {
                ShinseishoKanriNo 前申請書管理番号 = entity.getZShinseishoKanriNo();
                int 認定調査依頼履歴番号 = entity.getNinteichosaIraiRirekiNo();
                int 主治医意見履歴番号 = entity.getIkenshoIraiRirekiNo();
                myBatisParameter.setShinseishoKanriNo(申請書管理番号);
                myBatisParameter.setNinteichosaRirekiNo(認定調査依頼履歴番号);
                myBatisParameter.setShinseishoKanriNoZ(前申請書管理番号);
                myBatisParameter.setIkenshoIraiRirekiNo(主治医意見履歴番号);
                List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付サービス利用状況 = new ArrayList<>();
                List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付サービス利用状況 = new ArrayList<>();
                DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
                if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
                    予防給付サービス利用状況 = mapper.get予防給付(myBatisParameter);
                } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
                    介護給付サービス利用状況 = mapper.get介護給付(myBatisParameter);
                } else {
                    サービス状況フラグ = mapper.get状況フラグ(myBatisParameter);
                }
                List<DbT5205NinteichosahyoTokkijikoEntity> 特記事項 = mapper.get特記事項(myBatisParameter);
                List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書 = mapper.get主治医意見書(myBatisParameter);
                List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目 = mapper.get調査票項目(myBatisParameter);
                List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目 = mapper.get前回調査票項目(myBatisParameter);
                DbT5210NinteichosahyoShisetsuRiyoEntity 現在状況 = mapper.get現在状況(myBatisParameter);
                List<DbT5304ShujiiIkenshoIkenItemEntity> 前回主治医意見書 = mapper.get前回主治医意見書(myBatisParameter);
                return new IchijihanteikekkahyoItemSettei().set項目(entity, 特記事項,
                        調査票調査項目, 前回調査票調査項目, 主治医意見書,
                        前回主治医意見書, 予防給付サービス利用状況, 介護給付サービス利用状況, サービス状況フラグ, 現在状況,
                        new RString(myBatisParameter.getGogitaiNo()), batchReportWriter.getImageFolderPath());
            }
        }
        return null;
    }

    private TokkiText1A4Business get特記事項情報(ShinseishoKanriNo shinseishoKanriNo) {
        for (ShinsakaiSiryoKyotsuEntity kyotsuEntity : shinsakaiSiryoKyotsuEntityList) {
            if (shinseishoKanriNo.equals(kyotsuEntity.getShinseishoKanriNo())) {
                kyotsuEntity.setJimukyoku(true);
                List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List = get特記情報(kyotsuEntity);
                return new TokkiText1A4Business(kyotsuEntity, 特記情報List);
            }
        }
        return null;
    }

    private JimuShinsakaiWariateJohoBusiness get主治医意見書情報(ShinseishoKanriNo shinseishoKanriNo) {
        for (ShinsakaiSiryoKyotsuEntity kyotsuEntity : shinsakaiSiryoKyotsuEntityList) {
            if (shinseishoKanriNo.equals(kyotsuEntity.getShinseishoKanriNo())) {
                kyotsuEntity.setJimukyoku(true);
                return new JimuShinsakaiWariateJohoBusiness(kyotsuEntity);
            }
        }
        return null;
    }

    private JimuSonotashiryoBusiness getその他資料情報(ShinseishoKanriNo shinseishoKanriNo) {
        JimuSonotashiryoBusiness business = null;
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiSiryoKyotsuEntityList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                entity.setJimukyoku(true);
                if (shinsakaiOrder != entity.getShinsakaiOrder()) {
                    存在ファイルindex = 0;
                }
                List<RString> イメージファイルリスト;
                if (!entity.isJimukyoku()) {
                    イメージファイルリスト = getその他資料(entity.getImageSharedFileId(), getその他資料マスキング後イメージファイル名());
                } else {
                    イメージファイルリスト = getその他資料(entity.getImageSharedFileId(), getその他資料原本イメージファイル名());
                }
                RString 共有ファイル名 = entity.getShoKisaiHokenshaNo().concat(entity.getHihokenshaNo());
                RString path = getFilePath(entity.getImageSharedFileId(), 共有ファイル名);
                business = new JimuSonotashiryoBusiness(entity, イメージファイルリスト, 存在ファイルindex);
                business.set事務局概況特記イメージ(共有ファイルを引き出す(path, ファイル名_G0001));
                存在ファイルindex = business.get存在ファイルIndex();
                shinsakaiOrder = entity.getShinsakaiOrder();
            }
        }
        return business;
    }

    private List<DbT5205NinteichosahyoTokkijikoEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        myBatisParameter.setGenponMaskKubun(GenponMaskKubun.原本.getコード());
        myBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        myBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.get事務局特記情報(myBatisParameter);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory(ReportIdDBE.DBE517011.getReportId().value(), get帳票名());
        outputJokenhyoFactory(ReportIdDBE.DBE517141.getReportId().value(), new RString("概況調査の特記"));
        outputJokenhyoFactory(ReportIdDBE.DBE517131.getReportId().value(), new RString("特記事項（1枚目）"));
        outputJokenhyoFactory(ReportIdDBE.DBE517181.getReportId().value(), new RString("一次判定結果票"));
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

    /**
     * その他資料を取得します。
     *
     * @param sharedFileId 共有ファイルID
     * @param ファイル名List イメージファイルリスト
     * @return その他資料
     */
    public List<RString> getその他資料(RDateTime sharedFileId, List<RString> ファイル名List) {
        List<RString> ファイルPathList = new ArrayList<>();
        if (sharedFileId == null) {
            return ファイルPathList;
        }
        boolean is存在;
        int index = 0;
        for (int i = 0; i < ファイル名List.size(); i++) {
            RString ファイル名 = ファイル名List.get(i);
            ReadOnlySharedFileEntryDescriptor descriptor
                    = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(ファイル名), sharedFileId);
            try {
                SharedFile.copyToLocal(descriptor, new FilesystemPath(batchReportWriter.getImageFolderPath()));
                is存在 = あり;
            } catch (Exception e) {
                is存在 = 無し;
            }
            if (is存在 && index < INDEX_5) {
                ファイルPathList.add(ファイル名);
                index = i + 1;
            }
            if (INDEX_5 <= index) {
                return ファイルPathList;
            }
        }
        return ファイルPathList;
    }

    private List<RString> getその他資料マスキング後イメージファイル名() {
        List<RString> ファイル名 = new ArrayList<>();
        ファイル名.add(new RString("F1401A01.png"));
        ファイル名.add(new RString("F1401A02.png"));
        ファイル名.add(new RString("F1401A03.png"));
        ファイル名.add(new RString("F1401A04.png"));
        ファイル名.add(new RString("F1401A05.png"));
        ファイル名.add(new RString("F1401A06.png"));
        ファイル名.add(new RString("F1401B01.png"));
        ファイル名.add(new RString("F1401B02.png"));
        ファイル名.add(new RString("F1401B03.png"));
        ファイル名.add(new RString("F1401B04.png"));
        ファイル名.add(new RString("F1401B05.png"));
        ファイル名.add(new RString("F1401B06.png"));
        ファイル名.add(new RString("F1401C01.png"));
        ファイル名.add(new RString("F1401C02.png"));
        ファイル名.add(new RString("F1401C03.png"));
        ファイル名.add(new RString("F1401C04.png"));
        ファイル名.add(new RString("F1401C05.png"));
        ファイル名.add(new RString("F1401C06.png"));
        ファイル名.add(new RString("F1401D01.png"));
        ファイル名.add(new RString("F1401D02.png"));
        ファイル名.add(new RString("F1401D03.png"));
        ファイル名.add(new RString("F1401D04.png"));
        ファイル名.add(new RString("F1401D05.png"));
        ファイル名.add(new RString("F1401D06.png"));
        ファイル名.add(new RString("F1401E01.png"));
        ファイル名.add(new RString("F1401E02.png"));
        ファイル名.add(new RString("F1401E03.png"));
        ファイル名.add(new RString("F1401E04.png"));
        ファイル名.add(new RString("F1401E05.png"));
        ファイル名.add(new RString("F1401E06.png"));
        ファイル名.add(new RString("F1401F01.png"));
        ファイル名.add(new RString("F1401F02.png"));
        ファイル名.add(new RString("F1401F03.png"));
        ファイル名.add(new RString("F1401F04.png"));
        ファイル名.add(new RString("F1401F05.png"));
        ファイル名.add(new RString("F1401F06.png"));
        return ファイル名;
    }

    private List<RString> getその他資料原本イメージファイル名() {
        List<RString> ファイル名 = new ArrayList<>();
        ファイル名.add(new RString("F1401A01_BAK.png"));
        ファイル名.add(new RString("F1401A02_BAK.png"));
        ファイル名.add(new RString("F1401A03_BAK.png"));
        ファイル名.add(new RString("F1401A04_BAK.png"));
        ファイル名.add(new RString("F1401A05_BAK.png"));
        ファイル名.add(new RString("F1401A06_BAK.png"));
        ファイル名.add(new RString("F1401B01_BAK.png"));
        ファイル名.add(new RString("F1401B02_BAK.png"));
        ファイル名.add(new RString("F1401B03_BAK.png"));
        ファイル名.add(new RString("F1401B04_BAK.png"));
        ファイル名.add(new RString("F1401B05_BAK.png"));
        ファイル名.add(new RString("F1401B06_BAK.png"));
        ファイル名.add(new RString("F1401C01_BAK.png"));
        ファイル名.add(new RString("F1401C02_BAK.png"));
        ファイル名.add(new RString("F1401C03_BAK.png"));
        ファイル名.add(new RString("F1401C04_BAK.png"));
        ファイル名.add(new RString("F1401C05_BAK.png"));
        ファイル名.add(new RString("F1401C06_BAK.png"));
        ファイル名.add(new RString("F1401D01_BAK.png"));
        ファイル名.add(new RString("F1401D02_BAK.png"));
        ファイル名.add(new RString("F1401D03_BAK.png"));
        ファイル名.add(new RString("F1401D04_BAK.png"));
        ファイル名.add(new RString("F1401D05_BAK.png"));
        ファイル名.add(new RString("F1401D06_BAK.png"));
        ファイル名.add(new RString("F1401E01_BAK.png"));
        ファイル名.add(new RString("F1401E02_BAK.png"));
        ファイル名.add(new RString("F1401E03_BAK.png"));
        ファイル名.add(new RString("F1401E04_BAK.png"));
        ファイル名.add(new RString("F1401E05_BAK.png"));
        ファイル名.add(new RString("F1401E06_BAK.png"));
        ファイル名.add(new RString("F1401F01_BAK.png"));
        ファイル名.add(new RString("F1401F02_BAK.png"));
        ファイル名.add(new RString("F1401F03_BAK.png"));
        ファイル名.add(new RString("F1401F04_BAK.png"));
        ファイル名.add(new RString("F1401F05_BAK.png"));
        ファイル名.add(new RString("F1401F06_BAK.png"));
        return ファイル名;
    }

    private RString 共有ファイルを引き出す(RString path, RString fileName) {
        if (!RString.isNullOrEmpty(getFilePath(path, fileName))) {
            return getFilePath(path, fileName);
        }
        return RString.EMPTY;
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名);
        }
        return RString.EMPTY;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(batchReportWriter.getImageFolderPath()));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return sharedFileName;
    }

}
