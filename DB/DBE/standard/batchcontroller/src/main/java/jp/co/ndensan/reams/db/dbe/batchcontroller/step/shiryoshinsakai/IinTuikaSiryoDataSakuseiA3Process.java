/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia3.TsuikashiryokagamiA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTuutishoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTuikaSiryoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.IinTuikaSiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tsuikashiryokagami.TsuikashiryokagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia3.TsuikashiryokagamiA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 介護認定追加資料鑑情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinTuikaSiryoDataSakuseiA3Process extends BatchKeyBreakBase<IinTuikaSiryoEntity> {

    private static final RString SELECT_IINTUIKASIRYO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getIinTuikaSiryo");
    private static final List<RString> PAGE_BREAK_KEYS_A3 = Collections.unmodifiableList(Arrays.asList(
            new RString(TsuikashiryokagamiA3ReportSource.ReportSourceFields.shinsakaiNo.name())));
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_0 = 0;
    private static final int 満ページ件数 = 10;
    private static final RString 警告_有 = new RString("有");
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
        tsuikashiryokagami.set申請日(entity.getNinteiShinseiYMD() == null || entity.getNinteiShinseiYMD().isEmpty() ? RString.EMPTY
                : entity.getNinteiShinseiYMD().wareki().toDateString());
        tsuikashiryokagami.set申請区分(entity.getShinseijiKubunCode() == null || entity.getShinseijiKubunCode().isEmpty() ? RString.EMPTY
                : NinteiShinseiShinseijiKubunCode.toValue(entity.getShinseijiKubunCode().value()).get名称());
        tsuikashiryokagami.set前回一次(entity.getZenIchijiHanteiKekkaCode() == null || entity.getZenIchijiHanteiKekkaCode().isEmpty()
                ? RString.EMPTY : IchijiHanteiKekkaCode09.toValue(entity.getZenIchijiHanteiKekkaCode().value()).get名称());
        tsuikashiryokagami.set前回二次(entity.getJotaiKubunCode() == null || entity.getJotaiKubunCode().isEmpty() ? RString.EMPTY
                : YokaigoJotaiKubun09.toValue(entity.getJotaiKubunCode().value()).get略称());
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
        tsuikashiryokagami.set警告(警告有無(entity.getIchijiHnateiKeikokuCode()));
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
        RString 審査会開催年月日 = get審査会開催年月日(fromatパターン9(mapper.getShinsakaiKaisaiKekkaJoho(myBatisParameter).getShinsakaiKaisaiYMD()),
                日時転換(mapper.getShinsakaiKaisaiKekkaJoho(myBatisParameter).getShinsakaiKaishiTime()));
        tsuikashiryokagami.set審査会開催年月日(審査会開催年月日);
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

    private RString 日時転換(RString 日時) {
        if (!RString.isNullOrEmpty(日時)) {
            日時 = 日時.padZeroToLeft(INDEX_4);
            return RTime.of(Integer.parseInt(日時.substring(INDEX_0, INDEX_2).toString()),
                    Integer.parseInt(日時.substring(INDEX_2).toString())).toFormattedTimeString(DisplayTimeFormat.HH時mm分);
        }
        return RString.EMPTY;
    }

    private RString get審査会開催年月日(RString 開催年月日, RString 日時) {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(開催年月日)
                .append(" ")
                .append(日時)
                .toRString();
    }

    private RString 警告有無(RString 警告コード) {
        if (!RString.isNullOrEmpty(警告コード) && 警告コード.contains(new RString("1"))) {
            return 警告_有;
        }
        return RString.EMPTY;
    }
}
