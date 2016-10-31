/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
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
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static final RString 未納分 = new RString("0");
    private static final RString 完納分 = new RString("1");
    private static final RString 完納出力区分_出力する = new RString("1");
    private static final RString 完納出力区分_出力しない = new RString("0");
    private static final RString 抽出条件_認定者のみ = new RString("2");
    private static final RString 抽出条件_受給者のみ = new RString("3");
    private static final RString 抽出条件_認定者を除く１号被保険者 = new RString("4");
    private static final RString 認定者 = new RString("認定者");
    private static final RString 受給者 = new RString("受給者");
    private static final RString 広域保険者 = new RString("111");
    private static final RString 単一市町村分 = new RString("120");
    private static final RString 市町村分 = new RString("000000");
    private static final RString ONE = new RString("1");
    private static final int INT_0 = 0;

    private ShunoKamokuFinder shunoKamokuManager;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 保険料段階別収納率一時tableWriter;

    @Override
    protected void initialize() {
        shunoKamokuManager = ShunoKamokuFinder.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter(get検索用科目リスト()));
    }

    @Override
    protected void createWriter() {
        保険料段階別収納率一時tableWriter = new BatchEntityCreatedTempTableWriter(保険料段階別収納率一時_TABLE_NAME,
                DankaibetsuShunoritsuTempEntity.class);
    }

    @Override
    protected void process(DankaibetsuShunoritsuDataEntity 収納データ) {
        if (!get徴収方法(収納データ.get収納管理マスタ().getKamokuCode()).equals(収納データ.get介護期別().getChoshuHouhou())
                || 収納データ.get収納管理マスタ().getKibetsu() != 収納データ.get介護期別().getKi()) {
            return;
        }
        RString 完納区分 = 完納分;
        if (parameter.get会計年度().getYearValue()
                == 収納データ.get収入().getKaikeiNendo().getYearValue()
                && parameter.get出力区分().contains(完納出力区分_出力しない)) {
            完納区分 = 未納分;
        } else if (parameter.get出力区分().contains(完納出力区分_出力する)) {
            完納区分 = 完納分;
        } else {
            return;
        }
        DankaibetsuShunoritsuTempEntity entity = get保険料段階別収納率一時(収納データ);
        entity.setKannnouKunbun(完納区分);
        保険料段階別収納率一時tableWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
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

    private RString get徴収方法(KamokuCode kamokuCode) {
        IShunoKamoku 普通徴収科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        IShunoKamoku 特別徴収科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        if (普通徴収科目 != null && kamokuCode.equals(普通徴収科目.getコード())) {
            return ChoshuHohoKibetsu.普通徴収.getコード();
        } else if (特別徴収科目 != null && kamokuCode.equals(特別徴収科目.getコード())) {
            return ChoshuHohoKibetsu.特別徴収.getコード();
        }
        return RString.EMPTY;
    }

    private DankaibetsuShunoritsuTempEntity get保険料段階別収納率一時(DankaibetsuShunoritsuDataEntity 収納データ) {
        LasdecCode 市町村コード = 収納データ.get宛名().getGenLasdecCode();
        UrT0700ShunoKanriEntity 収納管理Entity = 収納データ.get収納管理マスタ();
        DankaibetsuShunoritsuTempEntity entity = new DankaibetsuShunoritsuTempEntity();
        entity.setChoteiNendo(new FlexibleYear(収納管理Entity.getChoteiNendo().toDateString()));
        entity.setFukaNendo(new FlexibleYear(収納管理Entity.getKazeiNendo().toDateString()));
        entity.setKibetsu(収納管理Entity.getKibetsu());
        entity.setTsuchishoNo(new TsuchishoNo(収納管理Entity.getTsuchishoNo().toString()));
        if ((広域保険者.equals(parameter.get広域判定区分())
                || 単一市町村分.equals(parameter.get広域判定区分()))
                && 市町村コード != null
                && 市町村分.equals(市町村コード.getColumnValue())) {
            if ((抽出条件_認定者のみ.equals(parameter.get抽出条件())
                    || 抽出条件_認定者を除く１号被保険者.equals(parameter.get抽出条件()))
                    && 収納データ.get受給者給付COUNT().get受給者台帳COUNT() != INT_0) {
                entity.setTaishouKubun(認定者);
            } else if (抽出条件_受給者のみ.equals(parameter.get抽出条件())
                    && 収納データ.get受給者給付COUNT().get給付実績基本COUNT() != INT_0) {
                entity.setTaishouKubun(受給者);
            }
        }
        entity.setHihokenshaNo(収納データ.get介護賦課().getHihokenshaNo());
        entity.setChoteigaku(収納データ.get調定共通().getChoteigaku());
        entity.setFunougaku(収納データ.get不納欠損() == null ? Decimal.ZERO : 収納データ.get不納欠損().getFunoKessongaku());
        entity.setShunyugaku(収納データ.get収入().getShunyugaku());
        entity.setShunoDataKubun(収納データ.get収入().getShunoDataKubun().getColumnValue());
        entity.setFukaYMD(収納データ.get介護賦課().getFukaYMD());
        entity.setHokenryoDankai(収納データ.get介護賦課().getHokenryoDankai());
        entity.setKamokuCode(収納データ.get収納管理マスタ().getKamokuCode());
        entity.setLasdecCode(市町村コード);
        LasdecCode 賦課市町村コード = 収納データ.get介護賦課().getFukaShichosonCode();
        if (市町村コード != null
                && 広域保険者.equals(parameter.get広域判定区分())
                && !市町村分.equals(市町村コード.getColumnValue())
                && 賦課市町村コード != null
                && (賦課市町村コード.getColumnValue().equals(parameter.get市町村情報())
                || 賦課市町村コード.getColumnValue().equals(parameter.get旧市町村情報()))) {
            if (ONE.equals(収納データ.get被保険者台帳().getKoikinaiJushochiTokureiFlag())) {
                entity.setFukaLasdecCode(収納データ.get被保険者台帳().getKoikinaiTokureiSochimotoShichosonCode());
            } else {
                entity.setFukaLasdecCode(収納データ.get被保険者台帳().getShichosonCode());
            }
        }
        return entity;
    }
}
