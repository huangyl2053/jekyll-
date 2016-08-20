/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe090001;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.johoteikyoshiryo.JohoTeikyoShiryoChange;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.ShujiiIraiAtenaJoho;
import jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo.JohoTeikyoShiryo;
import jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo.JohoTeikyoShiryoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe090001.YouKaiGoNinTeiKekTesuChiMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe090001.YouKaiGoNinTeiKekTesuChiProcessParemeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.johoteikyoshiryo.JohoTeikyoShiryoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.youkaigoninteikekktesuchi.IYouKaiGoNinTeiKekTesuChiMapper;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 調査員一覧情報の取得バッチクラスです。
 *
 * @reamsid_L DBE-0220-030 wangkun
 */
public class YouKaiGoNinTeiKekTesuChiProcess extends BatchProcessBase<YouKaiGoNinTeiKekTesuChiRelateEntity> {

    /**
     * OutputParameter用キー outDataList
     */
    public static final RString OUT_DATA_LIST;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.youkaigoninteikekktesuchi"
                    + ".IYouKaiGoNinTeiKekTesuChiMapper.getCyouHyouSyuTsuRyoKu");
    private static final int 通知文1 = 1;
    private static final int 主治医コードSTART = 10;
    private static final int 主治医コードEND = 18;

    private YouKaiGoNinTeiKekTesuChiProcessParemeter paramter;
    private static final ReportId REPORT_ID = ReportIdDBE.DBE090001.getReportId();
    private IYouKaiGoNinTeiKekTesuChiMapper mapper;
    private YouKaiGoNinTeiKekTesuChiMybitisParamter mybatisPrm;
    private OutputParameter<JohoTeikyoShiryo> outDataList;

    static {
        OUT_DATA_LIST = new RString("outDataList");
    }

    @BatchWriter
    private BatchReportWriter<JohoTeikyoShiryoReportSource> batchWrite;
    private ReportSourceWriter<JohoTeikyoShiryoReportSource> retortWrite;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5301ShujiiIkenshoIraiJohoEntity> dbT5301Temp;

    @Override
    protected void initialize() {
        outDataList = new OutputParameter<>();
        mybatisPrm = paramter.toMybitisParameter();
        mapper = getMapper(IYouKaiGoNinTeiKekTesuChiMapper.class);
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toMybitisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        retortWrite = new ReportSourceWriter<>(batchWrite);
        dbT5301Temp = new BatchPermanentTableWriter<>(DbT5301ShujiiIkenshoIraiJohoEntity.class);
    }

    @Override
    protected void process(YouKaiGoNinTeiKekTesuChiRelateEntity t) {
        eidtItem(t);
        DbT5301ShujiiIkenshoIraiJohoEntity entity = mapper.
                get主治医意見書作成依頼情報ByKey(t.getShinseishoKanriNo(), Integer.parseInt(t.getIkenshoIraiRirekiNo().toString()));
        entity.setNinteiJohoTeikyoYMD(new FlexibleDate(mybatisPrm.get認定状況提供日()));
        dbT5301Temp.update(entity);
        JohoTeikyoShiryo headItem = eidtItem(t);
        JohoTeikyoShiryoReport report = new JohoTeikyoShiryoReport(headItem);
        report.writeBy(retortWrite);
        outDataList.setValue(headItem);
    }

    @Override
    protected void afterExecute() {
    }

    private JohoTeikyoShiryo eidtItem(YouKaiGoNinTeiKekTesuChiRelateEntity entity) {
        NinshoshaSource 認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, REPORT_ID, FlexibleDate.getNowDate(),
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, retortWrite);
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_ID, KamokuCode.EMPTY, 通知文1);
        RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE090001.getReportId(), FlexibleDate.getNowDate());
        ShujiiIraiAtenaJoho 宛先情報 = get宛先();
        return JohoTeikyoShiryoChange.createBusiness(entity, 認証者情報, 通知文, 文書番号, 宛先情報, new RString(retortWrite.pageCount().value()));
    }

    private ShujiiIraiAtenaJoho get宛先() {
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        ShujiiIraiAtenaJohoParameter parameter = new ShujiiIraiAtenaJohoParameter();
        parameter.setShichosonCode(paramter.getShichosonCode());
        parameter.setShujiiCode(paramter.getShuJiiJyouHou().substring(主治医コードSTART, 主治医コードEND));
        parameter.setShujiiIryokikanCode(paramter.getShuJiiJyouHou().substring(0, 主治医コードSTART));
        return manager.get宛先情報(parameter);
    }
}
