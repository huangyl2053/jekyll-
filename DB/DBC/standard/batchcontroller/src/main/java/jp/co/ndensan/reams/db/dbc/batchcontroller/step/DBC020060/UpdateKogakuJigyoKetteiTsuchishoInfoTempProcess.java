/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020060;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.SelectShoriDateKanriMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuServiceUpdateTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
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
    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private static final RString 処理枝番 = new RString("0000");
    private static final FlexibleYear 年度_固定 = new FlexibleYear("0000");
    private static final RString 読点 = new RString("、");
    private static final RString FIRST_DAY = new RString("01");

    private KogakuKaigoServiceProcessParameter parameter;
    private IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper mapper;
    private RString サービス種類名称;
    private KogakuServiceUpdateTempEntity beforeEntity;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 一時tableWriter;
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> permanentTableWriter;

    @Override
    protected void initialize() {

        サービス種類名称 = RString.EMPTY;
        mapper = getMapper(IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.class);
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
            SelectShoriDateKanriMybatisParameter mybatisParameter
                    = new SelectShoriDateKanriMybatisParameter(SubGyomuCode.DBC介護給付, 市町村コード,
                            ShoriName.事業高額サービス等支給不支給決定通知書一括作成.get名称(), 処理枝番, 年度_固定);
            int 年度内連番 = mapper.select最大年度内連番(mybatisParameter);
            permanentTableWriter.insert(get処理日付管理マスタ(年度内連番));
        }
    }

    private DbT7022ShoriDateKanriEntity get処理日付管理マスタ(int 年度内連番) {

        DbT7022ShoriDateKanriEntity tempEntity = new DbT7022ShoriDateKanriEntity();
        tempEntity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        tempEntity.setShichosonCode(市町村コード);
        tempEntity.setShoriName(ShoriName.事業高額サービス等支給不支給決定通知書一括作成.get名称());
        tempEntity.setShoriEdaban(処理枝番);
        tempEntity.setNendo(年度_固定);
        tempEntity.setNendoNaiRenban(new RString(年度内連番 + 1).padZeroToLeft(2));
        if (抽出モード_受付日.equals(parameter.get抽出モード()) || 抽出モード_決定日.equals(parameter.get抽出モード())) {
            if (parameter.get抽出条件日付From() != null) {
                tempEntity.setTaishoKaishiYMD(new FlexibleDate(parameter.get抽出条件日付From().toDateString()));
            }
            if (parameter.get抽出条件日付To() != null) {
                tempEntity.setTaishoShuryoYMD(new FlexibleDate(parameter.get抽出条件日付To().toDateString()));
            }
        } else if (抽出モード_決定者受付年月.equals(parameter.get抽出モード())) {
            RString 月初日 = parameter.get決定者受付年月().toDateString().concat(FIRST_DAY);
            RString 月末日 = parameter.get決定者受付年月().toDateString()
                    .concat(new RString(parameter.get決定者受付年月().getLastDay()));
            tempEntity.setTaishoKaishiYMD(new FlexibleDate(月初日));
            tempEntity.setTaishoShuryoYMD(new FlexibleDate(月末日));
        }
        return tempEntity;
    }
}
