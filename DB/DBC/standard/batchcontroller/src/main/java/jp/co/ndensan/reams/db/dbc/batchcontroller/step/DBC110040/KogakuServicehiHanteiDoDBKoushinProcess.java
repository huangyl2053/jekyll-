/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110040;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout.KogakuServicehiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.DbWT3411KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiKanrenDataKoushinEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額サービス費給付判定結果情報作成・DB更新を実行する。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
public class KogakuServicehiHanteiDoDBKoushinProcess extends BatchProcessBase<KogakuServicehiHanteiKanrenDataKoushinEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakuservicehihanteikekkaout.IKogakuServicehiHanteikekkaOutJohoMapper.selectDB更新データ関連リスト");
    KogakuServicehiHanteiProcessParameter parameter;
    @BatchWriter
    private BatchPermanentTableWriter 支給判定結果tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        支給判定結果tableWriter
                = new BatchPermanentTableWriter(DbT3057KogakuShikyuHanteiKekkaEntity.class);
    }

    @Override
    protected void process(KogakuServicehiHanteiKanrenDataKoushinEntity entity) {
        DbWT3411KogakuShikyuShinseiEntity 高額介護 = entity.get高額介護();
        DbT3057KogakuShikyuHanteiKekkaEntity 支給判定結果 = entity.get支給判定結果();
        if (null != 高額介護 && !高額介護.isSofuJogaiFlag()) {
            支給判定結果.setHanteiKekkaSofuYM(parameter.get処理年月());
            支給判定結果.setSaiSofuFlag(false);
            支給判定結果.setState(EntityDataState.Modified);
            支給判定結果tableWriter.update(支給判定結果);
        } else if (null != 高額介護 && 高額介護.isSofuJogaiFlag()) {
            支給判定結果.setHanteiKekkaSofuYM(FlexibleYearMonth.EMPTY);
            支給判定結果.setSaiSofuFlag(false);
            支給判定結果.setState(EntityDataState.Modified);
            支給判定結果tableWriter.update(支給判定結果);
        }
    }
}
