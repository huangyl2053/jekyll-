/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe090001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 調査員一覧情報の取得バッチクラスです。
 */
public class YouKaiGoNinTeiKekTesuChiProcess extends BatchProcessBase<YouKaiGoNinTeiKekTesuChiRelateEntity> {

    /**
     * OutputParameter用キー outDataList
     */
    public static final RString OUT_DATA_LIST;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.youkaigoninteikekktesuchi"
                    + ".IYouKaiGoNinTeiKekTesuChiMapper.getCyouHyouSyuTsuRyoKu");
    private static final int 通知文1 = 1;
    private static final int 通知文2 = 2;
    private static final int 通知文3 = 3;
    private static final int 通知文4 = 4;
    private static final int 通知文5 = 5;
    private static final int 通知文6 = 6;
    private static final int 通知文7 = 7;
    private static final int 通知文8 = 8;
    private static final int 通知文9 = 9;
    private static final int 通知文10 = 10;

    private YouKaiGoNinTeiKekTesuChiProcessParemeter paramter;
    private static final ReportId REPORT_ID = new ReportId(ItakusakiChosainIchiranReportId.REPORTID_DBE090001.getCode());
    private JohoTeikyoShiryoItem headItem;
    private IYouKaiGoNinTeiKekTesuChiMapper mapper;
    private YouKaiGoNinTeiKekTesuChiMybitisParamter mybatisPrm;
    private List<JohoTeikyoShiryoItem> itemList;
    private OutputParameter<List<JohoTeikyoShiryoItem>> outDataList;

    static {
        OUT_DATA_LIST = new RString("outDataList");
    }

    @BatchWriter
    private BatchReportWriter<JohoTeikyoShiryoReportSource> batchWrite;
    private ReportSourceWriter<JohoTeikyoShiryoReportSource> retortWrite;

    @Override
    protected void initialize() {
        itemList = new ArrayList();
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
    }

    @Override
    protected void process(YouKaiGoNinTeiKekTesuChiRelateEntity t) {
        eidtItem(t);
        DbT5301ShujiiIkenshoIraiJohoEntity entity = new DbT5301ShujiiIkenshoIraiJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(t.getShinseishoKanriNo()));
        entity.setIkenshoIraiRirekiNo(Integer.valueOf(t.getIkenshoIraiRirekiNo().toString()));
        entity.setNinteiJohoTeikyoYMD(new FlexibleDate(mybatisPrm.get認定状況提供日()));
        mapper.updateShuJiIkenSyoSaKuSeiIraiJyouHou(entity);
    }

    @Override
    protected void afterExecute() {
        JohoTeikyoShiryoReport report = JohoTeikyoShiryoReport.createFrom(itemList);
        report.writeBy(retortWrite);
        outDataList.setValue(itemList);
    }

    private void eidtItem(YouKaiGoNinTeiKekTesuChiRelateEntity entity) {
        RString 認証者氏名 = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, REPORT_ID, FlexibleDate.getNowDate(), retortWrite).ninshoshaYakushokuMei;
        RString 帳票名 = BusinessConfig.get(ItakusakiChosainIchiranReportId.REPORTID_DBE090001, SubGyomuCode.DBE認定支援);
        RString 認定結果 = YokaigoJotaiKubun09.toValue(entity.getNijiHanteiYokaigoJotaiKubunCod()).get名称();
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_ID, KamokuCode.EMPTY, 通知文1);
        headItem = new JohoTeikyoShiryoItem(RDate.getNowDate(),
                entity.getShichosonMeisho(),
                認証者氏名,
                帳票名,
                通知文.get(通知文1),
                entity.getHihokenshaName(),
                entity.getJusho(),
                new RDate(entity.getNijiHanteiYMD().toString()),
                認定結果,
                new RDate(entity.getNijiHanteiNinteiYukoKaishiYMD().toString()),
                new RDate(entity.getNijiHanteiNinteiYukoShuryoYMD().toString()),
                entity.getShinsakaiIken(),
                通知文.get(通知文2),
                通知文.get(通知文3),
                通知文.get(通知文4),
                通知文.get(通知文5),
                通知文.get(通知文6),
                通知文.get(通知文7),
                通知文.get(通知文8),
                通知文.get(通知文9),
                通知文.get(通知文10));
        itemList.add(headItem);
    }
}