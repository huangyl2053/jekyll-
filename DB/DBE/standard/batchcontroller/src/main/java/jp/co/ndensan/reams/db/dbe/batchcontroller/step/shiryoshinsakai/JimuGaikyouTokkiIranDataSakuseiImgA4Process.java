/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuGaikyouTokkiBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkiichiran.GaikyoTokkiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuGaikyoTokkiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ImjJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkiichiran.GaikyoTokkiIchiranReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用概況特記一覧表情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuGaikyouTokkiIranDataSakuseiImgA4Process extends BatchProcessBase<ImjJohoEntity> {

    private static final RString SELECT_JIMUGAIKYO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper.getJimuImjJoho");
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IJimuShiryoShinsakaiIinMapper mapper;
    private JimuGaikyoTokkiMyBatisParameter myBatisParameter;
    private List<ImjJohoEntity> 概況特記イメージ情報;
    private JimuGaikyouTokkiBusiness business;
    private int no;
    @BatchWriter
    private BatchReportWriter<GaikyoTokkiIchiranReportSource> batchWriteA4;
    private ReportSourceWriter<GaikyoTokkiIchiranReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        mapper = getMapper(IJimuShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuGaikyoTokkiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setImageKubun(TokkijikoTextImageKubun.テキスト.getコード());
        myBatisParameter.setGenponKubun(TokkijikoTextImageKubun.イメージ.getコード());
        概況特記イメージ情報 = mapper.getJimuImjJoho(myBatisParameter);
        no = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUGAIKYO, myBatisParameter);
    }

    @Override
    protected void process(ImjJohoEntity entity) {
        entity.setJimukyoku(true);
        RString 共有ファイル名 = entity.getDbt5101_shoKisaiHokenshaNo().concat(entity.getDbt5101_hihokenshaNo());
        RString path = get共有ファイル引き出し先パス(entity.getDbt5115_imageSharedFileId(), 共有ファイル名);
        business = new JimuGaikyouTokkiBusiness(null, null, 概況特記イメージ情報, paramter, no, entity, path);
        GaikyoTokkiIchiranReport report = new GaikyoTokkiIchiranReport(business);
        report.writeBy(reportSourceWriterA4);
        no = no + 1;
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517007.getReportId().getColumnValue()).create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void afterExecute() {
    }

    private RString get共有ファイル引き出し先パス(RDateTime sharedFileId, RString sharedFileName) {
        if (sharedFileId == null || RString.isNullOrEmpty(sharedFileName)) {
            return RString.EMPTY;
        }
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        try {
            return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(batchWriteA4.getImageFolderPath())).getCanonicalPath());
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }
}
