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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa4.SonotashiryoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa4.SonotashiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用その他資料情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 wangxiaodong
 */
public class IinSonotaJohoDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiSiryoKyotsuEntity> {

    private static final RString SELECT_TSONOTAJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiSiryoKyotsu");
    private static final List<RString> PAGE_BREAK_KEYS_A4 = Collections.unmodifiableList(Arrays.asList(
            new RString(SonotashiryoA4ReportSource.ReportSourceFields.hokenshaNo.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private JimuSonotashiryoBusiness その他資料;
    private int shinsakaiOrder;
    private int 存在ファイルindex;
    private static final int INDEX_5 = 5;
    private static final RString ファイル名_G0001 = new RString("G0001.png");
    private static final RString SEPARATOR = new RString("/");

    @BatchWriter
    private BatchReportWriter<SonotashiryoA4ReportSource> batchWriteA4;
    private ReportSourceWriter<SonotashiryoA4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        shinsakaiOrder = -1;
        存在ファイルindex = 0;
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubunList(shoriJotaiKubunList);
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_TSONOTAJOHO, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517016.getReportId().value())
                .addBreak(new BreakerCatalog<SonotashiryoA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A4))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiSiryoKyotsuEntity entity) {
        hasBreak(getBefore(), entity);
    }

    @Override
    protected void usualProcess(ShinsakaiSiryoKyotsuEntity entity) {
        RString 共有ファイル名 = entity.getShoKisaiHokenshaNo().concat(entity.getHihokenshaNo());
        RString path = getFilePath(entity.getImageSharedFileId(), 共有ファイル名);
        entity.setHihokenshaName(AtenaMeisho.EMPTY);
        entity.setShoKisaiHokenshaNo(RString.EMPTY);
        entity.setHihokenshaNo(RString.EMPTY);
        entity.setJimukyoku(false);
        if (shinsakaiOrder != entity.getShinsakaiOrder()) {
            存在ファイルindex = 0;
        }
        List<RString> イメージファイルリスト;
        if (!entity.isJimukyoku()) {
            イメージファイルリスト = getその他資料(entity.getImageSharedFileId(), getその他資料マスキング後イメージファイル名(), path);
        } else {
            イメージファイルリスト = getその他資料(entity.getImageSharedFileId(), getその他資料原本イメージファイル名(), path);
        }
        その他資料 = new JimuSonotashiryoBusiness(entity, イメージファイルリスト, 存在ファイルindex);
        その他資料.set事務局概況特記イメージ(共有ファイルを引き出す(path));
        SonotashiryoA4Report reportA4 = new SonotashiryoA4Report(その他資料);
        reportA4.writeBy(reportSourceWriterA4);
        存在ファイルindex = その他資料.get存在ファイルIndex();
        shinsakaiOrder = entity.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
    }

    private boolean hasBreak(ShinsakaiSiryoKyotsuEntity before, ShinsakaiSiryoKyotsuEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    /**
     * その他資料を取得します。
     *
     * @param sharedFileId 共有ファイルID
     * @param ファイル名List イメージファイルリスト
     * @param ファイルパス ファイルパス
     * @return その他資料
     */
    public List<RString> getその他資料(RDateTime sharedFileId, List<RString> ファイル名List, RString ファイルパス) {
        List<RString> ファイルPathList = new ArrayList<>();
        if (sharedFileId == null) {
            return ファイルPathList;
        }
        int index = 0;
        for (int i = 0; i < ファイル名List.size(); i++) {
            RString ファイル名 = ファイル名List.get(i);
            if (!RString.isNullOrEmpty(ファイルパス) && index < INDEX_5) {
                RString fileFullPath = getFilePath(ファイルパス, ファイル名);
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

    private RString 共有ファイルを引き出す(RString path) {
        RString fileFullPath = getFilePath(path, ファイル名_G0001);
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
            return DBEImageUtil.copySharedFilesBatch(sharedFileId, sharedFileName, batchWriteA4.getImageFolderPath());
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }
}
