/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe090001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo.JohoTeikyoShiryoItem;
import jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo.JohoTeikyoShiryoReport;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran.ItakusakiChosainIchiranReportId;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe090001.YouKaiGoNinTeiKekTesuChiMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe090001.YouKaiGoNinTeiKekTesuChiProcessParemeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.johoteikyoshiryo.JohoTeikyoShiryoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.youkaigoninteikekktesuchi.IYouKaiGoNinTeiKekTesuChiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
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
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 調査員一覧情報の取得バッチクラスです。
 */
public class YouKaiGoNinTeiKekTesuChiProcess extends BatchProcessBase<YouKaiGoNinTeiKekTesuChiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.youkaigoninteikekktesuchi"
                    + ".IYouKaiGoNinTeiKekTesuChiMapper.getCyouHyouSyuTsuRyoKu");

    private YouKaiGoNinTeiKekTesuChiProcessParemeter paramter;
    private static final ReportId REPORT_ID = new ReportId(ItakusakiChosainIchiranReportId.REPORTID_DBE090001.getCode());
    private JohoTeikyoShiryoItem headItem;
    private IYouKaiGoNinTeiKekTesuChiMapper mapper;
    private YouKaiGoNinTeiKekTesuChiMybitisParamter mybatisPrm;

    @BatchWriter
    private BatchReportWriter<JohoTeikyoShiryoReportSource> batchWrite;
    private ReportSourceWriter<JohoTeikyoShiryoReportSource> retortWrite;

    @Override
    protected void initialize() {
        mybatisPrm = paramter.toMybitisParameter();
        mapper = getMapper(IYouKaiGoNinTeiKekTesuChiMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toMybitisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        retortWrite = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IYouKaiGoNinTeiKekTesuChiMapper.class);
        List<YouKaiGoNinTeiKekTesuChiRelateEntity> list = mapper.getCyouHyouSyuTsuRyoKu(mybatisPrm);
        System.out.println(list.size());
    }

    @Override
    protected void process(YouKaiGoNinTeiKekTesuChiRelateEntity t) {
        eidtItem(t);
        DbT5301ShujiiIkenshoIraiJohoEntity entity = new DbT5301ShujiiIkenshoIraiJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(t.getShinseishoKanriNo()));
        entity.setIkenshoIraiRirekiNo(new Integer(t.getIkenshoIraiRirekiNo().toString()));
        entity.setNinteiJohoTeikyoYMD(new FlexibleDate(mybatisPrm.get認定状況提供日()));
        mapper.updateShuJiIkenSyoSaKuSeiIraiJyouHou(entity);
    }

    @Override
    protected void afterExecute() {
        JohoTeikyoShiryoReport report = JohoTeikyoShiryoReport.createFrom(headItem);
        report.writeBy(retortWrite);
    }

    private void eidtItem(YouKaiGoNinTeiKekTesuChiRelateEntity entity) {

        // 課題番号34を待ち
//        ReportAssembler<ChosaIraiIchiranhyoReportSource> assembler = createAssembler(property, reportManager)
//        INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
//        INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
//        RDate.getNowDate(), assembler.getImageFolderPath());
        RString 認証者氏名 = new RString("認証者氏名");
        RString 帳票名 = BusinessConfig.get(ItakusakiChosainIchiranReportId.REPORTID_DBE090001, SubGyomuCode.DBE認定支援);
        RString 認定結果 = YokaigoJotaiKubun09.toValue(entity.getNijiHanteiYokaigoJotaiKubunCode()).get名称();

        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        List<TsuchishoTeikeibunEntity> tempList = manager.get通知書定型文パターン(REPORT_ID, SubGyomuCode.DBE認定支援).get通知書定型文List();
        headItem = new JohoTeikyoShiryoItem(RDate.getNowDate(), entity.getShichosonMeisho() // QA 539
                , 認証者氏名, 帳票名, get通知文(tempList, 1)
                , entity.getHihokenshaName()
                , entity.getJusho()
                , new RDate(entity.getNijiHanteiYMD().toString())
                , 認定結果, new RDate(entity.getNijiHanteiNinteiYukoKaishiYMD().toString())
                , new RDate(entity.getNijiHanteiNinteiYukoShuryoYMD().toString())
                , entity.getShinsakaiIken(), get通知文(tempList, 2)
                , get通知文(tempList, 3)
                , get通知文(tempList, 4)
                , get通知文(tempList, 5)
                , get通知文(tempList, 6)
                , get通知文(tempList, 7)
                , get通知文(tempList, 8)
                , get通知文(tempList, 9)
                , get通知文(tempList, 10));
    }

    private RString get通知文(List<TsuchishoTeikeibunEntity> tempList, int index) {
        RString 通知文 = RString.EMPTY;
        for (TsuchishoTeikeibunEntity entity : tempList) {
            if (index == entity.getTsuchishoTeikeibunEntity().getSentenceNo()) {
                通知文 = entity.getTsuchishoTeikeibunEntity().getSentence();
                break;
            }
        }
        return 通知文;
    }
}
