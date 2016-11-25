/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020060;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.SelectMaxEdabanParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuServiceUpdateTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額総合事業サービス費支給（不支給）決定通知書作成の一時テーブルのデータに設定
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class UpdateKogakuJigyoKetteiTsuchishoInfoTempProcess extends BatchProcessBase<KogakuServiceUpdateTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.select事業高額のサービス種類名称情報");

    private static final RString 高額サービス決定通知書情報一時_TABLE_NAME = new RString("KetteiTsuchishoInfoTempEntity");
    private static final RString フラグ_FALSE = new RString("false");
    private static final RString 抽出モード_受付日 = new RString("1");
    private static final RString 抽出モード_決定日 = new RString("2");
    private static final RString 抽出モード_決定者受付年月 = new RString("3");
    private static final RString 読点 = new RString("、");
    private static final RString 初期連番 = new RString("0000");
    private static final RString 初期年度 = new RString("0000");


    private KogakuKaigoServiceProcessParameter parameter;
    private RString サービス種類名称;
    private KogakuServiceUpdateTempEntity beforeEntity;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 一時tableWriter;
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> permanentTableWriter;

    @Override
    protected void initialize() {

        サービス種類名称 = RString.EMPTY;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {

        permanentTableWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
        一時tableWriter = new BatchEntityCreatedTempTableWriter(高額サービス決定通知書情報一時_TABLE_NAME,
                KetteiTsuchishoInfoTempEntity.class);
    }

    @Override
    protected void process(KogakuServiceUpdateTempEntity entity) {

        if (beforeEntity == null) {
            サービス種類名称 = entity.get介護サービス種類Entity() == null ? RString.EMPTY
                    : entity.get介護サービス種類Entity().getServiceShuruiMeisho();
        } else if (beforeEntity.getHihokenshaNo().equals(entity.getHihokenshaNo())
                && beforeEntity.getServiceTeikyoYM().equals(entity.getServiceTeikyoYM())) {
            サービス種類名称 = entity.get介護サービス種類Entity() == null ? サービス種類名称
                    : サービス種類名称.concat(読点).concat(entity.get介護サービス種類Entity().getServiceShuruiMeisho());
        } else {
            KetteiTsuchishoInfoTempEntity 一時Entit = beforeEntity.get一時Entity();
            一時Entit.setServiceShuruiName(サービス種類名称);
            一時tableWriter.update(一時Entit);
            サービス種類名称 = entity.get介護サービス種類Entity() == null ? RString.EMPTY
                    : entity.get介護サービス種類Entity().getServiceShuruiMeisho();
        }
        beforeEntity = entity;
    }

    @Override
    protected void afterExecute() {

        if (beforeEntity != null) {
            KetteiTsuchishoInfoTempEntity 一時Entit = beforeEntity.get一時Entity();
            一時Entit.setServiceShuruiName(サービス種類名称);
            一時tableWriter.update(一時Entit);
        }
        if (フラグ_FALSE.equals(parameter.getテスト出力フラグ())) {
            do処理日付管理マスタ登録更新();
        }
    }

    private void do処理日付管理マスタ登録更新() {
        LasdecCode 市町村コード = new LasdecCode(new RString("000000"));
        FlexibleYear 年度 = new FlexibleYear(初期年度);
        RString 処理枝番 = 初期連番;
        RString 処理名 = RString.EMPTY;
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        entity.setShichosonCode(市町村コード);
        entity.setNendo(年度);

        if (抽出モード_受付日.equals(parameter.get抽出モード()) || 抽出モード_決定日.equals(parameter.get抽出モード())) {
            if (抽出モード_受付日.equals(parameter.get抽出モード())) {
                処理名 = ShoriName.事業高額サービス等支給不支給決定通知書一括作成_受付日.get名称();
            } else {
                処理名 = ShoriName.事業高額サービス等支給不支給決定通知書一括作成_決定日.get名称();
            }
            if (parameter.get抽出条件日付From() != null) {
                entity.setTaishoKaishiYMD(new FlexibleDate(parameter.get抽出条件日付From().toDateString()));
            }
            if (parameter.get抽出条件日付To() != null) {
                entity.setTaishoShuryoYMD(new FlexibleDate(parameter.get抽出条件日付To().toDateString()));
            }
        } else {
            処理名 = ShoriName.事業高額サービス等支給不支給決定通知書一括作成_決定者受付年月.get名称();
            FlexibleYearMonth 決定者受付年月 = parameter.get決定者受付年月();
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
            permanentTableWriter.insert(entity);
        } else {
            dbt7022Entity.setTaishoKaishiYMD(entity.getTaishoKaishiYMD());
            dbt7022Entity.setTaishoShuryoYMD(entity.getTaishoShuryoYMD());
            permanentTableWriter.update(dbt7022Entity);
        }
    }
}
