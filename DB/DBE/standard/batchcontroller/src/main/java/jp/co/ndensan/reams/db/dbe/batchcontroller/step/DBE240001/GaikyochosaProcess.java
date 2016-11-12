/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.HomonChosaIraishoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IHomonChosaIraishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyotokki.GaikyotokkiA4Report;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyotokki.GaikyotokkiA4ReportSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票「DBE221051_要介護認定調査票（概況特記）」の処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class GaikyochosaProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final ReportId 帳票ID = ReportIdDBZ.DBE221051.getReportId();
    private static final RString CONFIGVALUE = new RString("1");
    private RDate 基準日;
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private HomonChosaIraishoProcessParamter processParamter;

    @BatchWriter
    private BatchReportWriter<GaikyotokkiA4ReportSource> batchReportWriter;
    private ReportSourceWriter<GaikyotokkiA4ReportSource> reportSourceWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5201NinteichosaIraiJohoEntity> dbT5201EntityWriter;

    @Override
    protected void initialize() {
        iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
        基準日 = RDate.getNowDate();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHomonChosaIraishoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        dbT5201EntityWriter = new BatchPermanentTableWriter(DbT5201NinteichosaIraiJohoEntity.class);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        update認定調査依頼情報(entity);
        GaikyotokkiA4Report report = new GaikyotokkiA4Report(new HomonChosaIraishoBusiness(processParamter).setReportEntity(entity));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        OutputJokenhyoFactory.createInstance(
                new HomonChosaIraishoBusiness(processParamter).バッチ出力条件リストの出力(reportSourceWriter,
                        AssociationFinderFactory.createInstance().getAssociation())).print();
    }

    private void update認定調査依頼情報(HomonChosaIraishoRelateEntity entity) {
        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = iHomonChosaIraishoMapper.get認定調査依頼情報(entity);
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, 基準日, SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE.equals(認定調査期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数,
                            基準日, SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 認定調査依頼日 = entity.get認定調査依頼年月日();
                    if (認定調査依頼日 != null && !認定調査依頼日.isEmpty()) {
                        dbT5201Entity.setNinteichosaKigenYMD(認定調査依頼日.plusDay(期限日数));
                    }
                    break;
                case "1":
                    dbT5201Entity.setNinteichosaKigenYMD(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (!RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        dbT5201Entity.setNinteichosaKigenYMD(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        dbT5201Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbT5201Entity.setNinteichosaIraiRirekiNo(entity.get最大依頼履歴番号());
        dbT5201Entity.setLogicalDeletedFlag(false);
        RString hakkobi = processParamter.getHakkobi();
        if (!RString.isNullOrEmpty(hakkobi)) {
            dbT5201Entity.setIraishoShutsuryokuYMD(new FlexibleDate(hakkobi));
        } else {
            dbT5201Entity.setIraishoShutsuryokuYMD(FlexibleDate.EMPTY);
        }
        dbT5201EntityWriter.update(dbT5201Entity);
    }
}
