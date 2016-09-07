/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservice.IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額介護サービス費支給判定結果の更新処理のクラスです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public class UpdateKogakuShikyuHanteiKekkaProcess extends BatchProcessBase<DbT3057KogakuShikyuHanteiKekkaEntity> {

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額サービス決定通知書情報一時tableWriter;
    BatchPermanentTableWriter permanentTableWriter;

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservice.IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper.select支給判定結果");
    private IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper mapper;

    private KogakuKaigoServiceProcessParameter parameter;

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper.class);
    }

    @Override
    protected void createWriter() {
        permanentTableWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toパラメータ());
    }

    @Override
    protected void beforeExecute() {
        DbT7022ShoriDateKanriEntity entity = mapper.select処理日付管理マスタMAX();
        entity.getNendoNaiRenban();
        permanentTableWriter.insert(entity);

    }

    @Override
    protected void process(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        if (parameter.get決定日() != null) {
            entity.setKetteiYMD(new FlexibleDate(parameter.get決定日().toDateString()));
            高額サービス決定通知書情報一時tableWriter.insert(entity);
        }
    }

    @Override
    protected void afterExecute() {

    }
}
