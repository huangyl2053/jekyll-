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
        for (int i = 0; i < koumokuGoukeyList.size(); i++) {
            KoumokuGoukey koumokuGoukey = koumokuGoukeyList.get(i);
            if (RString.isNullOrEmpty(koumokuGoukey.getHokenryoDankai())
                    || 不明.equals(koumokuGoukey.getHokenryoDankai())) {
                if (null == newKoumokuGoukey) {
                    newKoumokuGoukey = koumokuGoukeyList.get(i);
                } else {
                    newKoumokuGoukey = 不明_合計(newKoumokuGoukey, koumokuGoukey);    
                }
                koumokuGoukeyList.remove(i);
            }
        }
        if (null != newKoumokuGoukey) {
            newKoumokuGoukey.setHokenryoDankai(不明);
            koumokuGoukeyList.add(newKoumokuGoukey);
        }
        TsukibetsuSuiihyoReport report = new TsukibetsuSuiihyoReport(getTsukibetsuSuiihyoEntity(koumokuGoukeyList));
        report.writeBy(reportSourceWriter);
    }
    
    private KoumokuGoukey 不明_合計(KoumokuGoukey newKoumokuGoukey, KoumokuGoukey koumokuGoukey){
        KoumokuGoukey tmp = new KoumokuGoukey();
        newKoumokuGoukey.getYoGetuNinsuuGoukeyi().add(koumokuGoukey.getYoGetuNinsuuGoukeyi());
        newKoumokuGoukey.getGoGetuNinsuuGoukeyi().add(koumokuGoukey.getGoGetuNinsuuGoukeyi());
        newKoumokuGoukey.getRokuGetuNinsuuGoukeyi().add(koumokuGoukey.getRokuGetuNinsuuGoukeyi());
        newKoumokuGoukey.getNanaGetuNinsuuGoukeyi().add(koumokuGoukey.getNanaGetuNinsuuGoukeyi());
        newKoumokuGoukey.getHatiGetuNinsuuGoukeyi().add(koumokuGoukey.getHatiGetuNinsuuGoukeyi());
        newKoumokuGoukey.getKyuGetuNinsuuGoukeyi().add(koumokuGoukey.getKyuGetuNinsuuGoukeyi());
        newKoumokuGoukey.getJyuGetuNinsuuGoukeyi().add(koumokuGoukey.getJyuGetuNinsuuGoukeyi());
        newKoumokuGoukey.getJyuitiGetuNinsuuGoukeyi().add(koumokuGoukey.getJyuitiGetuNinsuuGoukeyi());
        newKoumokuGoukey.getJyuniGetuNinsuuGoukeyi().add(koumokuGoukey.getJyuniGetuNinsuuGoukeyi());
        newKoumokuGoukey.getItiGetuNinsuuGoukeyi().add(koumokuGoukey.getItiGetuNinsuuGoukeyi());
        newKoumokuGoukey.getNiGetuNinsuuGoukeyi().add(koumokuGoukey.getNiGetuNinsuuGoukeyi());
        newKoumokuGoukey.getSanGetuNinsuuGoukeyi().add(koumokuGoukey.getSanGetuNinsuuGoukeyi());
        newKoumokuGoukey.get現年随時の人数合計().add(koumokuGoukey.get現年随時の人数合計());
        newKoumokuGoukey.get過年度の人数合計().add(koumokuGoukey.get過年度の人数合計());
        newKoumokuGoukey.get歳出還付の人数合計().add(koumokuGoukey.get歳出還付の人数合計());
        newKoumokuGoukey.get該当段階の人数合計().add(koumokuGoukey.get該当段階の人数合計());
        newKoumokuGoukey.get総人数合計().add(koumokuGoukey.get総人数合計());
        newKoumokuGoukey.getYoGetuKinkakuGoukeyi().add(koumokuGoukey.getYoGetuKinkakuGoukeyi());
        newKoumokuGoukey.getGoGetuKinkakuGoukeyi().add(koumokuGoukey.getGoGetuKinkakuGoukeyi());
        newKoumokuGoukey.getRokuGetuKinkakuGoukeyi().add(koumokuGoukey.getRokuGetuKinkakuGoukeyi());
        newKoumokuGoukey.getNanaGetuKinkakuGoukeyi().add(koumokuGoukey.getNanaGetuKinkakuGoukeyi());
        newKoumokuGoukey.getHatiGetuKinkakuGoukeyi().add(koumokuGoukey.getHatiGetuKinkakuGoukeyi());
        newKoumokuGoukey.getKyuGetuKinkakuGoukeyi().add(koumokuGoukey.getKyuGetuKinkakuGoukeyi());
        newKoumokuGoukey.getJyuGetuKinkakuGoukeyi().add(koumokuGoukey.getJyuGetuKinkakuGoukeyi());
        newKoumokuGoukey.getJyuitiGetuKinkakuGoukeyi().add(koumokuGoukey.getJyuitiGetuKinkakuGoukeyi());
        newKoumokuGoukey.getJyuniGetuKinkakuGoukeyi().add(koumokuGoukey.getJyuniGetuKinkakuGoukeyi());
        newKoumokuGoukey.getItiGetuKinkakuGoukeyi().add(koumokuGoukey.getItiGetuKinkakuGoukeyi());
        newKoumokuGoukey.getNiGetuKinkakuGoukeyi().add(koumokuGoukey.getNiGetuKinkakuGoukeyi());
        newKoumokuGoukey.getSanGetuKinkakuGoukeyi().add(koumokuGoukey.getSanGetuKinkakuGoukeyi());
        newKoumokuGoukey.get現年随時の金額合計().add(koumokuGoukey.get現年随時の金額合計());
        newKoumokuGoukey.get過年度の金額合計().add(koumokuGoukey.get過年度の金額合計());
        newKoumokuGoukey.get歳出還付の金額合計().add(koumokuGoukey.get歳出還付の金額合計());
        newKoumokuGoukey.get該当段階の金額合計().add(koumokuGoukey.get該当段階の金額合計());
        newKoumokuGoukey.get総金額合計().add(koumokuGoukey.get総金額合計());
        return newKoumokuGoukey;
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
