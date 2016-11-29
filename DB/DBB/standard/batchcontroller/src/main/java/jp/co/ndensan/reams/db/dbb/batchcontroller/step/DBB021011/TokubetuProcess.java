/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.createtsukibetsusuiihyo.ReportDateHensyu;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.KoumokuGoukey;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tsukibetsusuiihyo.TsukibetsuSuiihyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 月別推移表作成帳票用Processクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class TokubetuProcess extends BatchProcessBase<KoumokuGoukey> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper"
            + ".relate.createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper.get特別徴収帳票データの取得");
    private static final ReportId 帳票ID = ReportIdDBB.DBB300002.getReportId();
    private static final RString 不明 = new RString("不明");
    private List<KoumokuGoukey> koumokuGoukeyList;
    private List<RString> 表記List;
    private CreateTsukibetsuSuiihyoProcessParameter processPrm;
    private CreateTsukibetsuSuiihyoMyBatisParameter mybatisPrm;
    @BatchWriter
    private BatchReportWriter<TsukibetsuSuiihyoReportSource> batchReportWriter;
    private ReportSourceWriter<TsukibetsuSuiihyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
        HokenryoDankaiSettings hokenryoDankaiSettings = new HokenryoDankaiSettings();
        HokenryoDankaiList hokenryoDankaiList = hokenryoDankaiSettings.get保険料段階ListIn(processPrm.getChoteiNendo());
        表記List = hokenryoDankaiList.to表記List();
        koumokuGoukeyList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(KoumokuGoukey item) {
        koumokuGoukeyList.add(item);
    }

    @Override
    protected void afterExecute() {
        KoumokuGoukey newKoumokuGoukey = null;
        List<KoumokuGoukey> newKoumokuGoukeyList = new ArrayList<>();
        for (int i = 0; i < koumokuGoukeyList.size(); i++) {
            KoumokuGoukey koumokuGoukey = koumokuGoukeyList.get(i);
            if (RString.isNullOrEmpty(koumokuGoukey.getHokenryoDankai())
                    || 不明.equals(koumokuGoukey.getHokenryoDankai())) {
                if (null == newKoumokuGoukey) {
                    newKoumokuGoukey = koumokuGoukeyList.get(i);
                } else {
                    newKoumokuGoukey = 不明_合計(newKoumokuGoukey, koumokuGoukey);
                }
            } else {
                newKoumokuGoukeyList.add(koumokuGoukey);
            }
        }
        if (null != newKoumokuGoukey) {
            newKoumokuGoukey.setHokenryoDankai(不明);
            newKoumokuGoukeyList.add(newKoumokuGoukey);
        }
        TsukibetsuSuiihyoReport report = new TsukibetsuSuiihyoReport(getTsukibetsuSuiihyoEntity(newKoumokuGoukeyList));
        report.writeBy(reportSourceWriter);
    }

    private KoumokuGoukey 不明_合計(KoumokuGoukey newKoumokuGoukey, KoumokuGoukey koumokuGoukey) {
        newKoumokuGoukey.setYoGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getYoGetuNinsuuGoukeyi(), koumokuGoukey.getYoGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setGoGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getGoGetuNinsuuGoukeyi(), koumokuGoukey.getGoGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setRokuGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getRokuGetuNinsuuGoukeyi(), koumokuGoukey.getRokuGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setNanaGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getNanaGetuNinsuuGoukeyi(), koumokuGoukey.getNanaGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setHatiGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getHatiGetuNinsuuGoukeyi(), koumokuGoukey.getHatiGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setKyuGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getKyuGetuNinsuuGoukeyi(), koumokuGoukey.getKyuGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setJyuGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getJyuGetuNinsuuGoukeyi(), koumokuGoukey.getJyuGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setJyuitiGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getJyuitiGetuNinsuuGoukeyi(), koumokuGoukey.getJyuitiGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setJyuniGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getJyuniGetuNinsuuGoukeyi(), koumokuGoukey.getJyuniGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setItiGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getItiGetuNinsuuGoukeyi(), koumokuGoukey.getItiGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setNiGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getNiGetuNinsuuGoukeyi(), koumokuGoukey.getNiGetuNinsuuGoukeyi()));
        newKoumokuGoukey.setSanGetuNinsuuGoukeyi(
                getDecimal(newKoumokuGoukey.getSanGetuNinsuuGoukeyi(), koumokuGoukey.getSanGetuNinsuuGoukeyi()));
        newKoumokuGoukey.set現年随時の人数合計(
                getDecimal(newKoumokuGoukey.get現年随時の人数合計(), koumokuGoukey.get現年随時の人数合計()));
        newKoumokuGoukey.set過年度の人数合計(
                getDecimal(newKoumokuGoukey.get過年度の人数合計(), koumokuGoukey.get過年度の人数合計()));
        newKoumokuGoukey.set歳出還付の人数合計(
                getDecimal(newKoumokuGoukey.get歳出還付の人数合計(), koumokuGoukey.get歳出還付の人数合計()));
        newKoumokuGoukey.set該当段階の人数合計(
                getDecimal(newKoumokuGoukey.get該当段階の人数合計(), koumokuGoukey.get該当段階の人数合計()));
        newKoumokuGoukey.set総人数合計(
                getDecimal(newKoumokuGoukey.get総人数合計(), koumokuGoukey.get総人数合計()));
        newKoumokuGoukey.setYoGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getYoGetuKinkakuGoukeyi(), koumokuGoukey.getYoGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setGoGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getGoGetuKinkakuGoukeyi(), koumokuGoukey.getGoGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setRokuGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getRokuGetuKinkakuGoukeyi(), koumokuGoukey.getRokuGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setNanaGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getNanaGetuKinkakuGoukeyi(), koumokuGoukey.getNanaGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setHatiGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getHatiGetuKinkakuGoukeyi(), koumokuGoukey.getHatiGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setKyuGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getKyuGetuKinkakuGoukeyi(), koumokuGoukey.getKyuGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setJyuGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getJyuGetuKinkakuGoukeyi(), koumokuGoukey.getJyuGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setJyuitiGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getJyuitiGetuKinkakuGoukeyi(), koumokuGoukey.getJyuitiGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setJyuniGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getJyuniGetuKinkakuGoukeyi(), koumokuGoukey.getJyuniGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setItiGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getItiGetuKinkakuGoukeyi(), koumokuGoukey.getItiGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setNiGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getNiGetuKinkakuGoukeyi(), koumokuGoukey.getNiGetuKinkakuGoukeyi()));
        newKoumokuGoukey.setSanGetuKinkakuGoukeyi(
                getDecimal(newKoumokuGoukey.getSanGetuKinkakuGoukeyi(), koumokuGoukey.getSanGetuKinkakuGoukeyi()));
        newKoumokuGoukey.set現年随時の金額合計(
                getDecimal(newKoumokuGoukey.get現年随時の金額合計(), koumokuGoukey.get現年随時の金額合計()));
        newKoumokuGoukey.set過年度の金額合計(
                getDecimal(newKoumokuGoukey.get過年度の金額合計(), koumokuGoukey.get過年度の金額合計()));
        newKoumokuGoukey.set歳出還付の金額合計(
                getDecimal(newKoumokuGoukey.get歳出還付の金額合計(), koumokuGoukey.get歳出還付の金額合計()));
        newKoumokuGoukey.set該当段階の金額合計(
                getDecimal(newKoumokuGoukey.get該当段階の金額合計(), koumokuGoukey.get該当段階の金額合計()));
        newKoumokuGoukey.set総金額合計(
                getDecimal(newKoumokuGoukey.get総金額合計(), koumokuGoukey.get総金額合計()));
        return newKoumokuGoukey;
    }

    private Decimal getDecimal(Decimal decimal1, Decimal decimal2) {
        if (null == decimal1) {
            decimal1 = Decimal.ZERO;
        }
        if (null == decimal2) {
            decimal2 = Decimal.ZERO;
        }
        return decimal1.add(decimal2);
    }

    private TsukibetsuSuiihyoEntity getTsukibetsuSuiihyoEntity(List<KoumokuGoukey> list) {
        ReportDateHensyu reportDateHensyu = new ReportDateHensyu();
        return reportDateHensyu.getTsukibetsuSuiihyoEntity(list,
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).getEra(),
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString().substring(2),
                new RString("特別徴収"),
                AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().getColumnValue(), 表記List);
    }
}
