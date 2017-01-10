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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiJiko;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.report.tokkijiko.TokkiJikoReport;
import jp.co.ndensan.reams.db.dbe.business.report.tokkijiko.TokkiJikoReportLayoutBreaker;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkijiko.TokkiJikoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用特記事項の取得バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinTokkiJikouDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiSiryoKyotsuEntity> {

    private static final RString SELECT_SHINSAKAISIRYOKYOTSU = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiSiryoKyotsu");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(TokkiJikoReportSource.ReportSourceFields.tokkiText.name()),
            new RString(TokkiJikoReportSource.ReportSourceFields.tokkiImg.name()),
            new RString(TokkiJikoReportSource.ReportSourceFields.tokkiText1.name()),
            new RString(TokkiJikoReportSource.ReportSourceFields.tokkiImg1.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private IShiryoShinsakaiIinMapper mapper;

    @BatchWriter
    private BatchReportWriter<TokkiJikoReportSource> batchWriter;
    private ReportSourceWriter<TokkiJikoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setShoriJotaiKubunList(shoriJotaiKubunList);
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHINSAKAISIRYOKYOTSU, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517131.getReportId().value())
                .addBreak(new BreakerCatalog<TokkiJikoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .addBreak(new TokkiJikoReportLayoutBreaker()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiSiryoKyotsuEntity current) {
    }

    @Override
    protected void usualProcess(ShinsakaiSiryoKyotsuEntity kyotsuEntity) {
        kyotsuEntity.setJimukyoku(false);
        kyotsuEntity.setShoKisaiHokenshaNo(RString.EMPTY);
        kyotsuEntity.setHihokenshaNo(RString.EMPTY);
        kyotsuEntity.setHihokenshaName(AtenaMeisho.EMPTY);

        RString 共有ファイル名 = kyotsuEntity.getShoKisaiHokenshaNo().concat(kyotsuEntity.getHihokenshaNo());
        RString imageFilePath = copySharedFile(kyotsuEntity.getImageSharedFileId(), 共有ファイル名);

        List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List = get特記情報(kyotsuEntity);
        TokkiJiko tokkiJiko = new TokkiJiko(kyotsuEntity, 特記情報List, imageFilePath);
        TokkiJikoReport report = new TokkiJikoReport(tokkiJiko);
        report.writeBy(reportSourceWriter);
    }

    private RString copySharedFile(RDateTime sharedFileId, RString sharedFileName) {
        if (sharedFileId == null || RString.isNullOrEmpty(sharedFileName)) {
            return RString.EMPTY;
        }
        try {
            return DBEImageUtil.copySharedFilesBatch(sharedFileId, sharedFileName, batchWriter.getImageFolderPath());
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }

    @Override
    protected void afterExecute() {
    }

    private List<DbT5205NinteichosahyoTokkijikoEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        myBatisParameter.setGenponMaskKubun(GenponMaskKubun.マスク.getコード());
        myBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        myBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.getTokkiIranJoho(myBatisParameter);
    }

}
