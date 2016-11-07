/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.SelectMaxEdabanParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanHanteiKekkaUpdataParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
    private static final RString 初期連番 = new RString("0001");
    private static final int MAXLENGTH = 4;
    private static final RString ZERO = new RString("0");

    @BatchWriter
    BatchPermanentTableWriter<DbT3036ShokanHanteiKekkaEntity> dbT3036Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7072Writer;
    ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        ShokanHanteiKekkaUpdataParameter sqlParam = ShokanHanteiKekkaUpdataParameter.createParam(parameter.getChusyuMode(),
                parameter.getInsho(), parameter.getDataFrom(), parameter.getDataTo(), parameter.getKetteishaUketsukeYM());
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
        if (決定日 != null) {
            entity.setKetteiYMD(new FlexibleDate(決定日.getYearValue(), 決定日.getMonthValue(), 決定日.getDayValue()));
        }
        entity.setKetteiTsuchishoSakuseiYMD(parameter.getHakkoYMD());
        dbT3036Writer.update(entity);
    }

    @Override
    protected void afterExecute() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        LasdecCode 市町村コード = association.get地方公共団体コード();
        RString 処理名;
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        entity.setShichosonCode(市町村コード);
        entity.setNendo(new FlexibleYear(RDate.getNowDate().getNendo().toDateString()));

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
                市町村コード, 処理名, new FlexibleYear(RDate.getNowDate().getNendo().toDateString())));
        if (dbt7022Entity == null) {
            entity.setNendoNaiRenban(初期連番);
            entity.setShoriEdaban(初期連番);
        } else {
            entity.setShoriEdaban(new RString(Integer.parseInt(dbt7022Entity.getShoriEdaban().toString()) + 1).padLeft(ZERO, MAXLENGTH));
            entity.setNendoNaiRenban(new RString(Integer.parseInt(dbt7022Entity.getNendoNaiRenban().toString()) + 1).padLeft(ZERO, MAXLENGTH));
        }
        entity.setShoriName(処理名);
        dbT7072Writer.insert(entity);
    }
}
