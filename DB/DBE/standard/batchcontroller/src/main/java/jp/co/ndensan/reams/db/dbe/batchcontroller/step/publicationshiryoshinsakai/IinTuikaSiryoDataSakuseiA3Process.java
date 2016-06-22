/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia3.TsuikashiryokagamiA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.publicationshiryoshinsakai.IinTuutishoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.publicationshiryoshinsakai.IinTuikaSiryoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.IinTuikaSiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tsuikashiryokagami.TsuikashiryokagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia3.TsuikashiryokagamiA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.publicationshiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKeikoku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定追加資料鑑情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinTuikaSiryoDataSakuseiA3Process extends BatchKeyBreakBase<IinTuikaSiryoEntity> {

    private static final RString SELECT_IINTUIKASIRYO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.publicationshiryoshinsakai.IShiryoShinsakaiIinMapper.getIinTuikaSiryo");
    private static final List<RString> PAGE_BREAK_KEYS_A3 = Collections.unmodifiableList(Arrays.asList(
            new RString(TsuikashiryokagamiA3ReportSource.ReportSourceFields.shinsakaiNo.name())));
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int 満ページ件数 = 10;
    private IinTuikaSiryoProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;
    private IinTuutishoMyBatisParameter myBatisParameter;
    private TsuikashiryokagamiEntity tsuikashiryokagami;
    private int データ件数;
    @BatchWriter
    private BatchReportWriter<TsuikashiryokagamiA3ReportSource> batchWriterA3;
    private ReportSourceWriter<TsuikashiryokagamiA3ReportSource> reportSourceWriterA3;

    @Override
    protected void initialize() {
        tsuikashiryokagami = new TsuikashiryokagamiEntity();
        myBatisParameter = paramter.toIinTuutishoMyBatisParameter();
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        データ件数 = 0;
        setヘッダー();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_IINTUIKASIRYO, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriterA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517009.getReportId().value())
                .addBreak(new BreakerCatalog<TsuikashiryokagamiA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A3))
                .create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriterA3);
    }

    @Override
    protected void keyBreakProcess(IinTuikaSiryoEntity entity) {
        if (データ件数 % 満ページ件数 == 0) {
            TsuikashiryokagamiA3Report report = new TsuikashiryokagamiA3Report(tsuikashiryokagami);
            report.writeBy(reportSourceWriterA3);
        }
    }

    @Override
    protected void usualProcess(IinTuikaSiryoEntity entity) {
        tsuikashiryokagami.set審査会審査順(new RString(entity.getShinsakaiOrder()));
        tsuikashiryokagami.set被保険者番号(entity.getHihokenshaNo());
        tsuikashiryokagami.set被保険者氏名(entity.getHihokenshaName() == null || entity.getHihokenshaName().isEmpty() ? RString.EMPTY
                : entity.getHihokenshaName().value());
        tsuikashiryokagami.set性別(entity.getSeibetsu() == null || entity.getSeibetsu().isEmpty() ? RString.EMPTY
                : Seibetsu.toValue(entity.getSeibetsu().value()).get名称());
        tsuikashiryokagami.set年齢(new RString(entity.getAge()));
        tsuikashiryokagami.set申請日(fromatパターン9(entity.getNinteiShinseiYMD()));
        tsuikashiryokagami.set申請区分(entity.getShinseijiKubunCode() == null || entity.getShinseijiKubunCode().isEmpty() ? RString.EMPTY
                : NinteiShinseiShinseijiKubunCode.toValue(entity.getShinseijiKubunCode().value()).get名称());
        tsuikashiryokagami.set前回一次(entity.getZenIchijiHanteiKekkaCode() == null || entity.getZenIchijiHanteiKekkaCode().isEmpty()
                ? RString.EMPTY : IchijiHanteiKekkaCode09.toValue(entity.getZenIchijiHanteiKekkaCode().value()).get名称());
        tsuikashiryokagami.set前回二次(entity.getJotaiKubunCode() == null || entity.getJotaiKubunCode().isEmpty() ? RString.EMPTY
                : YokaigoJotaiKubun09.toValue(entity.getJotaiKubunCode().value()).get名称());
        tsuikashiryokagami.set前回期間(new RString(entity.getYukoKikan()));
        tsuikashiryokagami.set寝たきり度(entity.getNinchishoCode() == null || entity.getNinchishoCode().isEmpty() ? RString.EMPTY
                : ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.getNinchishoCode().value()).get名称());
        set項目(entity);
        TsuikashiryokagamiA3Report report = new TsuikashiryokagamiA3Report(tsuikashiryokagami);
        report.writeBy(reportSourceWriterA3);
        データ件数++;
    }

    private void set項目(IinTuikaSiryoEntity entity) {
        tsuikashiryokagami.set認知度(entity.getNinchishoCode() == null || entity.getNinchishoCode().isEmpty() ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getNinchishoCode().value()).get名称());
        tsuikashiryokagami.set基準時間(new RString(entity.getKijunJikan()));
        tsuikashiryokagami.set一次判定(entity.getIchijiHanteiKekkaCode() == null || entity.getIchijiHanteiKekkaCode().isEmpty() ? RString.EMPTY
                : IchijiHanteiKekkaCode09.toValue(entity.getIchijiHanteiKekkaCode().value()).get名称());
        tsuikashiryokagami.set警告(entity.getIchijiHnateiKeikokuCode() == null || entity.getIchijiHnateiKeikokuCode().isEmpty() ? RString.EMPTY
                : IchijiHanteiKeikoku.toValue(entity.getIchijiHnateiKeikokuCode()).get名称());
        tsuikashiryokagami.set審査結果(RString.EMPTY);
        tsuikashiryokagami.set期間(RString.EMPTY);
    }

    @Override
    protected void afterExecute() {
    }

    private void setヘッダー() {
        set審査員();
        tsuikashiryokagami.set審査会開催番号(paramter.getShinsakaiKaisaiNo());
        tsuikashiryokagami.set追加審査対象者数(new RString(mapper.getShinsakaiWariateJohoCount(myBatisParameter)));
        tsuikashiryokagami.set合議体番号(new RString(mapper.getShinsakaiKaisaiKekkaJoho(myBatisParameter).getGogitaiNo()));
        tsuikashiryokagami.set審査会開催年月日(fromatパターン9(mapper.getShinsakaiKaisaiKekkaJoho(myBatisParameter).getShinsakaiKaisaiYMD()));
        tsuikashiryokagami.set通知文1(RString.EMPTY);
        tsuikashiryokagami.set通知文2(RString.EMPTY);
        tsuikashiryokagami.set通知文3(RString.EMPTY);
        tsuikashiryokagami.set通知文4(RString.EMPTY);
        tsuikashiryokagami.set通知文5(RString.EMPTY);
    }

    private void set審査員() {
        List<ShinsakaiIinJohoEntity> 審査員 = mapper.getIinShimei(myBatisParameter);
        for (int i = 0; i < 審査員.size(); i++) {
            if (i == 0) {
                tsuikashiryokagami.set審査員1(審査員.get(0) == null ? RString.EMPTY : 審査員.get(0).getShinsakaiIinShimei().value());
            }
            if (i == 1) {
                tsuikashiryokagami.set審査員2(審査員.get(1) == null ? RString.EMPTY : 審査員.get(1).getShinsakaiIinShimei().value());
            }
            if (i == INDEX_2) {
                tsuikashiryokagami.set審査員3(審査員.get(INDEX_2) == null ? RString.EMPTY : 審査員.get(INDEX_2).getShinsakaiIinShimei().value());
            }
            if (i == INDEX_3) {
                tsuikashiryokagami.set審査員4(審査員.get(INDEX_3) == null ? RString.EMPTY : 審査員.get(INDEX_3).getShinsakaiIinShimei().value());
            }
            if (i == INDEX_4) {
                tsuikashiryokagami.set審査員5(審査員.get(INDEX_4) == null ? RString.EMPTY : 審査員.get(INDEX_4).getShinsakaiIinShimei().value());
            }
            if (i == INDEX_5) {
                tsuikashiryokagami.set審査員6(審査員.get(INDEX_5) == null ? RString.EMPTY : 審査員.get(INDEX_5).getShinsakaiIinShimei().value());
            }
            if (i == INDEX_6) {
                tsuikashiryokagami.set審査員7(審査員.get(INDEX_6) == null ? RString.EMPTY : 審査員.get(INDEX_6).getShinsakaiIinShimei().value());
            }
            if (i == INDEX_7) {
                tsuikashiryokagami.set審査員8(審査員.get(INDEX_7) == null ? RString.EMPTY : 審査員.get(INDEX_7).getShinsakaiIinShimei().value());
            }
        }
    }

    private RString fromatパターン9(FlexibleDate date) {
        if (date != null && !date.isEmpty()) {
            return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }
}
