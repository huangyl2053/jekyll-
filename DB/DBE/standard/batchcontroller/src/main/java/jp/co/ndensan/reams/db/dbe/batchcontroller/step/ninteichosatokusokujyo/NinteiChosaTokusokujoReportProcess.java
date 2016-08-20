/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosatokusokujyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokujyo.NinteiChosaTokusokujoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo.NinteiChosaTokusokujoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.AtenaKikan;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosatokusokujyo.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosatokusokujyo.INinteichosaTokusokujyoRelateMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査督促状の作成クラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public class NinteiChosaTokusokujoReportProcess extends BatchProcessBase<DbT5101NinteiShinseiJohoEntity> {

    /**
     * OutputParameter用キー outShinseishoKanriNoList
     */
    public static final RString OUT_SHINSEISHO_KANRINO_LIST;
    private NinteiChosaTokusokujoProcessParameter paramter;
    private static final ReportId REPORT_DBE223001 = ReportIdDBE.DBE223001_NinteiChosaTokusokujo.getReportId();
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokujoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokujoReportSource> reportSourceWriter;
    INinteichosaTokusokujyoRelateMapper mapper;

    private final int パターン番号_1 = 1;
    RString 文書番号;
    NinshoshaSource ninshoshaSource;
    Map<Integer, RString> 通知文;
    AtenaKikan atenaKikan;
    RString customerBarCode;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosatokusokujyo."
                    + "INinteichosaTokusokujyoRelateMapper.select要介護認定調査督促状ByKey");

    static {
        OUT_SHINSEISHO_KANRINO_LIST = new RString("outShinseishoKanriNoList");
    }
    private OutputParameter<List<RString>> outShinseishoKanriNoList;
    private List<RString> shinseishoKanriNoList;

    @Override
    protected void initialize() {
        shinseishoKanriNoList = new ArrayList<>();
        outShinseishoKanriNoList = new OutputParameter<>();
        super.initialize();
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(INinteichosaTokusokujyoRelateMapper.class);
        getKyotsuData();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toNinteiChosaTokusokujoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE223001.value(), SubGyomuCode.DBE認定支援).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(DbT5101NinteiShinseiJohoEntity entity) {
        NinteiChosaTokusokujoReport report = new NinteiChosaTokusokujoReport(entity, ninshoshaSource, atenaKikan, 文書番号, 通知文, customerBarCode);
        report.writeBy(reportSourceWriter);

        shinseishoKanriNoList.add(entity.getShinseishoKanriNo().getColumnValue());
    }

    @Override
    protected void afterExecute() {
        outShinseishoKanriNoList.setValue(shinseishoKanriNoList);
    }

    private void getKyotsuData() {
        文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, REPORT_DBE223001, paramter.getTemp_基準日());
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, REPORT_DBE223001, paramter.getTemp_基準日(),
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_DBE223001, KamokuCode.EMPTY, パターン番号_1);

        DbT7051KoseiShichosonMasterEntity shichoson = mapper.select市町村コード(paramter.getTemp_保険者コード());
        RString temp_市町村コード = RString.EMPTY;
        if (shichoson != null) {
            temp_市町村コード = shichoson.getShichosonCode().getColumnValue();
        }
        atenaKikan = mapper.select宛名機関(paramter.toNinteiChosaTokusokujoMybatisParameter(new LasdecCode(temp_市町村コード)));
        if (atenaKikan == null) {
            atenaKikan = new AtenaKikan();
        }

        RString 宛名郵便番号 = RString.EMPTY;
        if (atenaKikan.get宛名郵便番号() != null) {
            宛名郵便番号 = atenaKikan.get宛名郵便番号().getColumnValue();
        }
        RString 住所 = RString.EMPTY;
        if (atenaKikan.get宛名住所() != null) {
            住所 = atenaKikan.get宛名住所();
        }
        customerBarCode = ReportUtil.getCustomerBarCode(宛名郵便番号, 住所);
    }
}
