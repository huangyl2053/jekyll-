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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IchijihanteikekkahyoItemSetteiA3;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3.IinShinsakaishiryoA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.ShinsakaiSiryouKumiawaseA3ProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 委員審査会資料組み合わせ一覧A3版のバッチ処理です。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class IinShinsakaiSiryouKumiawaseA3Process extends SimpleBatchProcessBase {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(IinShinsakaishiryoA3ReportSource.ReportSourceFields.tokkiText1.name()),
            new RString(IinShinsakaishiryoA3ReportSource.ReportSourceFields.tokkiImg1.name())));
    private ShinsakaiSiryouKumiawaseA3ProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;
    private IinShinsakaiIinJohoMyBatisParameter 一覧表myBatisParameter;
    private IinTokkiJikouItiziHanteiMyBatisParameter 一次判定myBatisParameter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private List<ShinsakaiTaiyosyaJohoEntity> shinsakaiTaiyosyaJohoList;
    private List<JimuShinsakaishiryoBusiness> jimuShinsakaishiryoList;
    private List<ShinsakaiSiryoKyotsuEntity> 共通情報;
    private List<ItiziHanteiEntity> itiziHanteiEntityList;
    private int データ件数;
    private int no;
    private int count;
    private int shinsakaiOrder;
    private RString path;
    private int 存在ファイルindex;
    private static final int INDEX_5 = 5;
    private static final RString ファイル名_G0001 = new RString("G0001.png");
    private static final RString ファイルID_E0001BAK = new RString("E0001_BAK.png");
    private static final RString ファイルID_E0002BAK = new RString("E0002_BAK.png");
    private static final RString SEPARATOR = new RString("/");
    private boolean is審査会対象一覧印刷済み;
    private List<ShinsakaiTaiyosyaJohoEntity> 委員審査会追加資料A3リスト;

    @BatchWriter
    private BatchReportWriter<IinShinsakaishiryoA3ReportSource> batchReportWriter;
    private ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        shinsakaiOrder = -1;
        存在ファイルindex = 0;
        shinsakaiIinJohoList = new ArrayList<>();
        shinsakaiTaiyosyaJohoList = new ArrayList<>();
        jimuShinsakaishiryoList = new ArrayList<>();
        共通情報 = new ArrayList<>();
        itiziHanteiEntityList = new ArrayList<>();
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        一覧表myBatisParameter = paramter.toIinShinsakaiIinJohoMyBatisParameter();
        一次判定myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        一次判定myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        一次判定myBatisParameter.setShoriJotaiKubunList(shoriJotaiKubunList);
        共通情報 = mapper.getShinsakaiSiryoKyotsu(一次判定myBatisParameter);
        データ件数 = mapper.getTokkiJikouItiziHanteiCount(一次判定myBatisParameter);
        itiziHanteiEntityList = mapper.getTokkiJikouItiziHantei(一次判定myBatisParameter);
        委員審査会追加資料A3リスト = mapper.getShinsakaiTaiyosyaJoho(一覧表myBatisParameter);
        is審査会対象一覧印刷済み = false;
        get審査対象者一覧表情報();
    }

    @Override
    protected void process() {
        RString reportId = ReportIdDBE.DBE517904.getReportId().value();
        batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId)
                .addBreak(new BreakerCatalog<IinShinsakaishiryoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .addBreak(new BreakerCatalog<IinShinsakaishiryoA3ReportSource>().new SimpleLayoutBreaker(
                    IinShinsakaishiryoA3ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<IinShinsakaishiryoA3ReportSource> occuredBreak(
                            ReportLineRecord<IinShinsakaishiryoA3ReportSource> currentRecord,
                            ReportLineRecord<IinShinsakaishiryoA3ReportSource> nextRecord,
                            ReportDynamicChart dynamicChart) {
                                int layout = currentRecord.getSource().layout;
                                currentRecord.setFormGroupIndex(layout);
                                if (nextRecord != null && nextRecord.getSource() != null) {
                                    layout = nextRecord.getSource().layout;
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
        for (ShinsakaiSiryoKyotsuEntity entity : 共通情報) {
            if (!申請書管理番号List.contains(entity.getShinseishoKanriNo())) {
                申請書管理番号List.add(entity.getShinseishoKanriNo());
            }
        }
        for (ShinseishoKanriNo shinseishoKanriNo : 申請書管理番号List) {
            for (ShinsakaiSiryoKyotsuEntity entity : 共通情報) {
                if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                    RString 共有ファイル名 = entity.getShoKisaiHokenshaNo().concat(entity.getHihokenshaNo());
                    path = getFilePath(entity.getImageSharedFileId(), 共有ファイル名);
                    break;
                }
            }
            IinShinsakaishiryoA3Report report = new IinShinsakaishiryoA3Report(jimuShinsakaishiryoList,
                    get特記事項と一次判定結果票情報(shinseishoKanriNo),
                    get主治医意見書情報(shinseishoKanriNo),
                    getその他資料情報(shinseishoKanriNo),
                    get審査会追加資料情報(shinseishoKanriNo),
                    is審査会対象一覧印刷済み,
                    paramter.getSakuseiJoken(),
                    paramter.getPrintHou());
            report.writeBy(reportSourceWriter);
            is審査会対象一覧印刷済み = true;
        }
        batchReportWriter.close();
    }

    private void get審査対象者一覧表情報() {
        一覧表myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        一覧表myBatisParameter.setHaishiFlag_False(IsHaishi.有効.is廃止());
        一覧表myBatisParameter.setHaishiFlag_True(IsHaishi.廃止.is廃止());
        一覧表myBatisParameter.setSisutemuYMD(FlexibleDate.getNowDate());
        shinsakaiIinJohoList = mapper.getShinsakaiIinJoho(一覧表myBatisParameter);
        count = mapper.getShinsakaiTaiyosyaJohoCount(一覧表myBatisParameter);
        shinsakaiTaiyosyaJohoList = mapper.getShinsakaiTaiyosyaJoho(一覧表myBatisParameter);
        no = 0;
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

    private IchijihanteikekkahyoA3Entity get特記事項と一次判定結果票情報(ShinseishoKanriNo shinseishoKanriNo) {
        for (ItiziHanteiEntity entity : itiziHanteiEntityList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                一次判定myBatisParameter.setShinseishoKanri(entity.getShinseishoKanriNo());
                一次判定myBatisParameter.setNinteichosaRirekiNo(entity.getNinteichosaIraiRirekiNo());
                一次判定myBatisParameter.setShinseishoKanriZ(entity.getZShinseishoKanriNo());
                一次判定myBatisParameter.setIkenshoIraiRirekiNo(entity.getIkenshoIraiRirekiNo());
                List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付サービス利用状況 = new ArrayList<>();
                List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付サービス利用状況 = new ArrayList<>();
                DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
                if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
                    予防給付サービス利用状況 = mapper.getYoboService(一次判定myBatisParameter);
                } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
                    介護給付サービス利用状況 = mapper.getKaigoService(一次判定myBatisParameter);
                } else {
                    サービス状況フラグ = mapper.getServiceJokyoFlag(一次判定myBatisParameter);
                }
                List<DbT5205NinteichosahyoTokkijikoEntity> 特記事項 = mapper.getTokkijiko(一次判定myBatisParameter);
                List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書 = mapper.getIkenshoIkenItem(一次判定myBatisParameter);
                List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目 = mapper.getChosahyoChosaItem(一次判定myBatisParameter);
                List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目 = mapper.getZenkaiChosahyoChosaItem(一次判定myBatisParameter);
                List<DbT5304ShujiiIkenshoIkenItemEntity> 前回主治医意見書 = mapper.getZenkaiIkenshoIkenItem(一次判定myBatisParameter);
                List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報 = new ArrayList<>();
                if (get共通情報(共通情報, entity.getShinseishoKanriNo()) != null) {
                    特記情報 = get特記情報(get共通情報(共通情報, entity.getShinseishoKanriNo()));
                }
                return new IchijihanteikekkahyoItemSetteiA3().set項目(entity, 特記事項,
                        調査票調査項目, 前回調査票調査項目, 主治医意見書,
                        前回主治医意見書, 予防給付サービス利用状況, 介護給付サービス利用状況, サービス状況フラグ, データ件数,
                        get共通情報(共通情報, entity.getShinseishoKanriNo()), 主治医意見書, new RString(paramter.getGogitaiNo()),
                        特記情報, batchReportWriter.getImageFolderPath());
            }
        }
        return null;
    }

    private JimuShinsakaiWariateJohoBusiness get主治医意見書情報(ShinseishoKanriNo shinseishoKanriNo) {
        for (ShinsakaiSiryoKyotsuEntity entity : 共通情報) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                entity.setJimukyoku(false);
                JimuShinsakaiWariateJohoBusiness business = new JimuShinsakaiWariateJohoBusiness(entity);
                business.setイメージファイル(共有ファイルを引き出す(path, ファイルID_E0001BAK));
                business.setイメージファイル_BAK(共有ファイルを引き出す(path, ファイルID_E0002BAK));
                return business;
            }
        }
        return null;
    }

    private JimuSonotashiryoBusiness getその他資料情報(ShinseishoKanriNo shinseishoKanriNo) {
        JimuSonotashiryoBusiness その他資料 = null;
        for (ShinsakaiSiryoKyotsuEntity entity : 共通情報) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                entity.setHihokenshaName(AtenaMeisho.EMPTY);
                entity.setJimukyoku(false);
                if (shinsakaiOrder != entity.getShinsakaiOrder()) {
                    存在ファイルindex = 0;
                }
                List<RString> イメージファイルリスト;
                if (!entity.isJimukyoku()) {
                    イメージファイルリスト = getその他資料(entity.getImageSharedFileId(), getその他資料マスキング後イメージファイル名());
                } else {
                    イメージファイルリスト = getその他資料(entity.getImageSharedFileId(), getその他資料原本イメージファイル名());
                }
                その他資料 = new JimuSonotashiryoBusiness(entity, イメージファイルリスト, 存在ファイルindex);
                その他資料.set事務局概況特記イメージ(共有ファイルを引き出す(path, ファイル名_G0001));
                存在ファイルindex = その他資料.get存在ファイルIndex();
                shinsakaiOrder = entity.getShinsakaiOrder();
            }
        }
        return その他資料;
    }

    private JimuTuikaSiryoBusiness get審査会追加資料情報(ShinseishoKanriNo shinseishoKanriNo) {
        JimuTuikaSiryoBusiness 審査会追加資料 = null;
        for (ShinsakaiTaiyosyaJohoEntity entity : 委員審査会追加資料A3リスト) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                審査会追加資料 = new JimuTuikaSiryoBusiness(entity, shinsakaiIinJohoList, paramter.toIinShinsakaiIinJohoProcessParameter(), count,
                        ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517009.getReportId(),
                                KamokuCode.EMPTY, 1, 1, FlexibleDate.getNowDate()));
            }
        }
        return 審査会追加資料;
    }

    private ShinsakaiSiryoKyotsuEntity get共通情報(List<ShinsakaiSiryoKyotsuEntity> 共通情報,
            ShinseishoKanriNo 申請書管理番号) {
        for (ShinsakaiSiryoKyotsuEntity 共通情報Entity : 共通情報) {
            if (申請書管理番号.equals(共通情報Entity.getShinseishoKanriNo())) {
                return 共通情報Entity;
            }
        }
        return null;
    }

    private List<DbT5205NinteichosahyoTokkijikoEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        一次判定myBatisParameter.setGenponMaskKubun(GenponMaskKubun.原本.getコード());
        一次判定myBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        一次判定myBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.getTokkiIranJoho(一次判定myBatisParameter);
    }

    @Override
    protected void afterExecute() {
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
        int index = 0;
        for (int i = 0; i < ファイル名List.size(); i++) {
            RString ファイル名 = ファイル名List.get(i);
            if (!RString.isNullOrEmpty(path) && index < INDEX_5) {
                RString fileFullPath = getFilePath(path, ファイル名);
                if (!RString.isNullOrEmpty(fileFullPath)) {
                    ファイルPathList.add(fileFullPath);
                    index = i + 1;
                }
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
        RString fileFullPath = getFilePath(path, fileName);
        if (!RString.isNullOrEmpty(fileFullPath)) {
            return fileFullPath;
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
        if (sharedFileId == null || RString.isNullOrEmpty(sharedFileName)) {
            return RString.EMPTY;
        }
        try {
            return DBEImageUtil.copySharedFilesBatch(sharedFileId, sharedFileName, batchReportWriter.getImageFolderPath());
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }

}
