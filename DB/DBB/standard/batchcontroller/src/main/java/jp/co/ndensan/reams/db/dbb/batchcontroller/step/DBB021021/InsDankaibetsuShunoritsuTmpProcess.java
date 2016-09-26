/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ca.cax.business.search.CaFt702FindTotalShunyuFunction;
import jp.co.ndensan.reams.ca.cax.business.search.TotalShunyuSearchKeyBuilder;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.SearchSaishutsuKubun;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.SearchSokuhoKubun;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaV0704SaishinShunyuNiniFutaikinEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.SaikinShunyugakuUchiwakeRelateEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dankaibetsushunoritsu.InsDankaibetsuShunoritsuTmpProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu.DankaibetsuShunoritsuDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu.DankaibetsuShunoritsuTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.shunokanri.UrT0700ShunoKanriEntity;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険料段階別収納率一時テーブル（新規）に登録
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
public class InsDankaibetsuShunoritsuTmpProcess extends BatchProcessBase<DankaibetsuShunoritsuDataEntity> {

    private static final RString MYBATIS_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.dankaibetsushunoritsu."
                    + "IDankaibetsuShunoritsuMapper.get収納宛名データ");
    private static final RString 保険料段階別収納率一時_TABLE_NAME = new RString("DankaibetsuShunoritsuTemp");

    private InsDankaibetsuShunoritsuTmpProcessParameter parameter;
    private CaFt702FindTotalShunyuFunction psmEntity;
//    private static final RString 未納分 = new RString("未納分");
    private static final RString 完納分 = new RString("完納分");
    private static final RString 認定者のみ = new RString("認定者のみ");
    private static final RString 認定者を除く１号被保険者 = new RString("認定者を除く１号被保険者");
    private static final RString 受給者のみ = new RString("受給者のみ");
    private static final RString 認定者 = new RString("認定者");
    private static final RString 受給者 = new RString("受給者");
    private static final RString 広域保険者 = new RString("広域保険者");
    private static final RString 単一市町村分 = new RString("単一市町村分");
    private static final RString 市町村分 = new RString("000000");
    private static final RString ONE = new RString("1");
    private static final int INT_0 = 0;
    private List<SaikinShunyugakuUchiwakeRelateEntity> 最新収入額内訳RelateEntityリスト;
    private List<CaV0704SaishinShunyuNiniFutaikinEntity> 最新収入任意附帯金Entityリスト;
    private DankaibetsuShunoritsuDataEntity beforeEntity;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 保険料段階別収納率一時tableWriter;

    @Override
    protected void initialize() {
        TotalShunyuSearchKeyBuilder searchKey = new TotalShunyuSearchKeyBuilder(SearchSokuhoKubun.全て,
                SearchSaishutsuKubun.全て);
        searchKey.set科目リスト(get検索用科目リスト());
        searchKey.set調定年度From(new RYear(parameter.get開始調定年度().getYearValue()));
        searchKey.set調定年度To(new RYear(parameter.get終了調定年度().getYearValue()));
        searchKey.set課税年度From(new RYear(parameter.get開始賦課年度().getYearValue()));
        searchKey.set課税年度To(new RYear(parameter.get終了賦課年度().getYearValue()));
        searchKey.set速報区分(SearchSokuhoKubun.全て);
        searchKey.set歳出区分(SearchSaishutsuKubun.全て);
        psmEntity = new CaFt702FindTotalShunyuFunction(searchKey);
        最新収入額内訳RelateEntityリスト = new ArrayList<>();
        最新収入任意附帯金Entityリスト = new ArrayList<>();
        beforeEntity = null;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter(new RString(psmEntity.toString())));
    }

    @Override
    protected void createWriter() {
        保険料段階別収納率一時tableWriter = new BatchEntityCreatedTempTableWriter(保険料段階別収納率一時_TABLE_NAME,
                DankaibetsuShunoritsuTempEntity.class);
    }

    @Override
    protected void process(DankaibetsuShunoritsuDataEntity 収納データ) {
        if (beforeEntity == null) {
            beforeEntity = 収納データ;
        }
//        RString 完納区分 = 完納分;
        // TODO 収納情報の調定年月日、収納情報．会計年度 QA#102469 確認中
//        if (parameter.get会計年度().getYearValue()
//                == 収納データ.get収入情報取得PSM().get収納キーRelateEntity().get収納管理Entity().getKazeiNendo().getYearValue()
//                && parameter.get完納出力区分().contains(完納出力区分_出力しない)) {
//            完納区分 = 未納分;
//        } else if (収納データ.get収入情報取得PSM().get収納キーRelateEntity().get収納管理Entity().getKazeiNendo().getYearValue()
//                < parameter.get会計年度().getYearValue()
//                && parameter.get完納出力区分().contains(完納出力区分_出力する)) {
//            完納区分 = 完納分;
//        } else {
//            return;
//        }
        if (収納データ.get収入情報取得PSM().get収納キーRelateEntity().get収納管理Entity().getShunoId().compareTo(
                beforeEntity.get収入情報取得PSM().get収納キーRelateEntity().get収納管理Entity().getShunoId()) == 0) {
            最新収入額内訳RelateEntityリスト.add(収納データ.get収入情報取得PSM().get最新収入額内訳RelateEntity());
            最新収入任意附帯金Entityリスト.add(収納データ.get収入情報取得PSM().get最新収入任意附帯金Entity());
        } else {
            DankaibetsuShunoritsuTempEntity entity = get保険料段階別収納率一時(収納データ);
            entity.setKannnouKunbun(完納分);
            保険料段階別収納率一時tableWriter.insert(entity);
            最新収入額内訳RelateEntityリスト = new ArrayList<>();
            最新収入任意附帯金Entityリスト = new ArrayList<>();
            最新収入額内訳RelateEntityリスト.add(収納データ.get収入情報取得PSM().get最新収入額内訳RelateEntity());
            最新収入任意附帯金Entityリスト.add(収納データ.get収入情報取得PSM().get最新収入任意附帯金Entity());
        }
        beforeEntity = 収納データ;
    }

    @Override
    protected void afterExecute() {
        if (beforeEntity != null) {
            DankaibetsuShunoritsuTempEntity entity = get保険料段階別収納率一時(beforeEntity);
            保険料段階別収納率一時tableWriter.insert(entity);
        }
    }

    private List<RString> get検索用科目リスト() {
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 収納科目_国保特徴 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        IShunoKamoku 収納科目_国保普徴 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        List<RString> kamokuList = new ArrayList<>();
        kamokuList.add(収納科目_国保特徴.get表示用コードwithハイフン());
        kamokuList.add(収納科目_国保普徴.get表示用コードwithハイフン());
        return kamokuList;
    }

    private DankaibetsuShunoritsuTempEntity get保険料段階別収納率一時(DankaibetsuShunoritsuDataEntity 収納データ) {
        LasdecCode 市町村コード = 収納データ.get宛名().getGenLasdecCode();
        UrT0700ShunoKanriEntity 収納管理Entity
                = 収納データ.get収入情報取得PSM().get収納キーRelateEntity().get収納管理Entity();
        DankaibetsuShunoritsuTempEntity entity = new DankaibetsuShunoritsuTempEntity();
        entity.setChoteiNendo(new FlexibleYear(収納管理Entity.getChoteiNendo().toDateString()));
        entity.setFukaNendo(new FlexibleYear(収納管理Entity.getKazeiNendo().toDateString()));
        entity.setKibetsu(収納管理Entity.getKibetsu());
        entity.setTsuchishoNo(new TsuchishoNo(収納管理Entity.getTsuchishoNo().get通知書番号()));
        if ((広域保険者.equals(parameter.get広域判定区分())
                || 単一市町村分.equals(parameter.get広域判定区分()))
                && 市町村コード != null
                && 市町村分.equals(市町村コード.code市町村RString())) {
            if ((認定者のみ.equals(parameter.get抽出条件())
                    || 認定者を除く１号被保険者.equals(parameter.get抽出条件()))
                    && 収納データ.get受給者給付COUNT().get受給者台帳COUNT() != INT_0) {
                entity.setTaishouKubun(認定者);
            } else if (受給者のみ.equals(parameter.get抽出条件())
                    && 収納データ.get受給者給付COUNT().get給付実績基本COUNT() != INT_0) {
                entity.setTaishouKubun(受給者);
            }
        }
        entity.setHihokenshaNo(収納データ.get介護賦課().getHihokenshaNo());
        // QA#99921確認中　被保険者番号、調定額、不納欠損額、収納データ区分、
        entity.setChoteigaku(Decimal.ONE);
        entity.setFunougaku(Decimal.ONE);
        entity.setShunyugaku(収納データ.get収入情報取得PSM().get最新収入Entity().getShunyugaku());
//        entity.set収納データ区分(収納データ.get収入情報取得PSM().get収納キーRelateEntity().
//        get収納科目枝番Entity().getShunoKamokuId());
        entity.setFukaYMD(収納データ.get介護賦課().getFukaYMD());
        entity.setHokenryoDankai(収納データ.get介護賦課().getHokenryoDankai());
        entity.setKamokuCode(収納データ.get収入情報取得PSM().get収納キーRelateEntity().
                get収納科目Entity().getKamokuCode().getColumnValue());
        entity.setLasdecCode(市町村コード);
        LasdecCode 賦課市町村コード = 収納データ.get介護賦課().getFukaShichosonCode();
        if (市町村コード != null
                && 広域保険者.equals(parameter.get広域判定区分())
                && !市町村分.equals(市町村コード.code市町村RString())
                && 賦課市町村コード != null
                && (賦課市町村コード.code市町村RString().equals(parameter.get市町村情報())
                || 賦課市町村コード.code市町村RString().equals(parameter.get旧市町村情報()))) {
            if (ONE.equals(収納データ.get被保険者台帳().getKoikinaiJushochiTokureiFlag())) {
                entity.setFukaLasdecCode(収納データ.get被保険者台帳().getKoikinaiTokureiSochimotoShichosonCode());
            } else {
                entity.setFukaLasdecCode(収納データ.get被保険者台帳().getShichosonCode());
            }
        }
        return entity;
    }
}
