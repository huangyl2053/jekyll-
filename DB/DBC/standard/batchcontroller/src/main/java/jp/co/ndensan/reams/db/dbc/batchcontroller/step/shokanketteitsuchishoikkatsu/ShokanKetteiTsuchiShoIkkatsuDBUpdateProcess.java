/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.shokanketteitsuchishoikkatsu;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanHanteiKekkaUpdataParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
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
    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private static final RString 定数ゼロ = new RString("0000");

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
        } else {
            entity.setKetteiYMD(null);
        }
        dbT3036Writer.update(entity);
    }

    @Override
    protected void afterExecute() {
        IShokanKetteiTsuchiShoIkkatsuSakuseiMapper mapper = getMapper(IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.class);
        RString 最大年度内連番 = mapper.get最大年度内連番();
        if (RString.isNullOrEmpty(最大年度内連番)) {
            最大年度内連番 = new RString("0");
        }
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        entity.setShichosonCode(市町村コード);
        entity.setShoriEdaban(定数ゼロ);
        entity.setNendo(FlexibleYear.MIN);
        entity.setNendoNaiRenban(new RString(String.valueOf(Integer.parseInt(最大年度内連番.toString()) + 1)));
        if (抽出モード_受付日.equals(parameter.getChusyuMode()) || 抽出モード_決定日.equals(parameter.getChusyuMode())) {
            if (抽出モード_受付日.equals(parameter.getChusyuMode())) {
                entity.setShoriName(ShoriName.償還払い支給不支給決定通知書一括作成_受付日.get名称());
            } else {
                entity.setShoriName(ShoriName.償還払い支給不支給決定通知書一括作成_決定日.get名称());
            }
            entity.setTaishoKaishiYMD(parameter.getDataFrom());
            entity.setTaishoShuryoYMD(parameter.getDataTo());
        } else {
            entity.setShoriName(ShoriName.償還払い支給不支給決定通知書一括作成_決定者受付年月.get名称());
            FlexibleYearMonth 決定者受付年月 = parameter.getKetteishaUketsukeYM();
            if (決定者受付年月 != null) {
                entity.setTaishoKaishiYMD(new FlexibleDate(決定者受付年月.getYearValue(), 決定者受付年月.getMonthValue(), 1));
                entity.setTaishoShuryoYMD(
                        new FlexibleDate(決定者受付年月.getYearValue(), 決定者受付年月.getMonthValue(), 決定者受付年月.getLastDay()));
            }
        }
        dbT7072Writer.insert(entity);
    }
}
