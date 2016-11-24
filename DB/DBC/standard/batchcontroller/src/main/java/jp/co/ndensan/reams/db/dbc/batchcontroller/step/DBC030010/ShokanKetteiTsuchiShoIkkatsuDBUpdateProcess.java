/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.SelectMaxEdabanParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanHanteiKekkaUpdataParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給不支給決定通知書DB更新を処理します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShokanKetteiTsuchiShoIkkatsuDBUpdateProcess extends BatchProcessBase<DbT3036ShokanHanteiKekkaEntity> {

    private static final RString 償還払支給判定結果情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get償還払支給判定結果情報");
    private static final RString 抽出モード_受付日 = new RString("1");
    private static final RString 抽出モード_決定日 = new RString("2");
    private static final RString 更新する = new RString("2");
    private static final RString 初期連番 = new RString("0001");
    private static final RString 初期年度 = new RString("0000");
    private static final RString 発行有無_2 = new RString("２号発行有無");

    @BatchWriter
    BatchPermanentTableWriter<DbT3036ShokanHanteiKekkaEntity> dbT3036Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7072Writer;
    ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        RString 発行有無 = RString.EMPTY;
        ChohyoSeigyoHanyo 帳票制御汎発行有無 = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleYear.MIN, 発行有無_2);
        if (帳票制御汎発行有無 != null) {
            発行有無 = 帳票制御汎発行有無.get設定値();
        }
        ShokanHanteiKekkaUpdataParameter sqlParam = ShokanHanteiKekkaUpdataParameter.createParam(parameter.getChusyuMode(),
                parameter.getInsho(), parameter.getDataFrom(), parameter.getDataTo(), parameter.getKetteishaUketsukeYM(), 発行有無);
        return new BatchDbReader(償還払支給判定結果情報取得SQL, sqlParam);
    }

    @Override
    protected void createWriter() {
        dbT3036Writer = new BatchPermanentTableWriter(DbT3036ShokanHanteiKekkaEntity.class);
        dbT7072Writer = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT3036ShokanHanteiKekkaEntity entity) {
        RDate 決定日 = parameter.getKetteiYMD();
        if (決定日 != null && 更新する.endsWith(parameter.get決定日一括更新区分())) {
            entity.setKetteiYMD(new FlexibleDate(決定日.getYearValue(), 決定日.getMonthValue(), 決定日.getDayValue()));
        }
        entity.setKetteiTsuchishoSakuseiYMD(parameter.getHakkoYMD());
        dbT3036Writer.update(entity);
    }

    @Override
    protected void afterExecute() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        LasdecCode 市町村コード = association.get地方公共団体コード();
        FlexibleYear 年度 = new FlexibleYear(初期年度);
        RString 処理枝番 = 初期連番;
        RString 処理名;
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        entity.setShichosonCode(市町村コード);
        entity.setNendo(年度);

        if (抽出モード_受付日.equals(parameter.getChusyuMode()) || 抽出モード_決定日.equals(parameter.getChusyuMode())) {
            if (抽出モード_受付日.equals(parameter.getChusyuMode())) {
                処理名 = ShoriName.償還払い支給不支給決定通知書一括作成_受付日.get名称();
            } else {
                処理名 = ShoriName.償還払い支給不支給決定通知書一括作成_決定日.get名称();
            }
            entity.setTaishoKaishiYMD(parameter.getDataFrom());
            entity.setTaishoShuryoYMD(parameter.getDataTo());
        } else {
            処理名 = ShoriName.償還払い支給不支給決定通知書一括作成_決定者受付年月.get名称();
            FlexibleYearMonth 決定者受付年月 = parameter.getKetteishaUketsukeYM();
            if (決定者受付年月 != null) {
                entity.setTaishoKaishiYMD(new FlexibleDate(決定者受付年月.getYearValue(), 決定者受付年月.getMonthValue(), 1));
                entity.setTaishoShuryoYMD(
                        new FlexibleDate(決定者受付年月.getYearValue(), 決定者受付年月.getMonthValue(), 決定者受付年月.getLastDay()));
            }
        }
        IShokanKetteiTsuchiShoIkkatsuSakuseiMapper mapper = getMapper(IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.class);
        DbT7022ShoriDateKanriEntity dbt7022Entity = mapper.get最大枝番(new SelectMaxEdabanParameter(SubGyomuCode.DBC介護給付,
                市町村コード, 処理名, 処理枝番, 年度));
        if (dbt7022Entity == null) {
            entity.setNendoNaiRenban(初期連番);
            entity.setShoriEdaban(初期連番);
            entity.setShoriName(処理名);
            dbT7072Writer.insert(entity);
        } else {
            dbt7022Entity.setTaishoKaishiYMD(entity.getTaishoKaishiYMD());
            dbt7022Entity.setTaishoShuryoYMD(entity.getTaishoShuryoYMD());
            dbT7072Writer.update(dbt7022Entity);
        }
    }
}
