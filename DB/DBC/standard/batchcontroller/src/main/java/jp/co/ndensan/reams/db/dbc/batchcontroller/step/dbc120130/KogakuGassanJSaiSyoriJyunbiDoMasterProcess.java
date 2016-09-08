/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120130;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.DbT3070KogakuGassanJikoFutanGakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.DbWT37H1KogakuGassanaJikofutangakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110.KogakuGassanJikofutangakuMasterTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額証明書情報取込ののマスタ登録です。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public class KogakuGassanJSaiSyoriJyunbiDoMasterProcess extends BatchProcessBase<KogakuGassanJikofutangakuMasterTorokuEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassanjikofutangaku.IKogakuGassanJSaiSyoriJyunbiMapper.select高額合算自己負担額一時と明細データ");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 高額合算自己負担額一時_TABLE_NAME = new RString("DbWT37H1KogakuGassanaJikofutangaku");

    @BatchWriter
    BatchPermanentTableWriter 高額合算自己負担額TBLWriter;
    @BatchWriter
    IBatchTableWriter 処理結果リスト一時tbWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算自己負担額一時tableWriter;

    private KogakuGassanJikofutangakuDoMasterTorokuProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額TBLWriter = new BatchPermanentTableWriter(DbT3070KogakuGassanJikoFutanGakuEntity.class);
        処理結果リスト一時tbWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME, DbWT0002KokuhorenTorikomiErrorEntity.class);
        高額合算自己負担額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額一時_TABLE_NAME, DbWT37H1KogakuGassanaJikofutangakuTempEntity.class);

    }

    @Override
    protected void process(KogakuGassanJikofutangakuMasterTorokuEntity entity) {
        DbWT37H1KogakuGassanaJikofutangakuCsvEntity 高額合算自己負担額一時entity = entity.get高額合算自己負担額一時entity();
        DbT3070KogakuGassanJikoFutanGakuCsvEntity 高額合算自己負担額entity = entity.get高額合算自己負担額entity();
        if (高額合算自己負担額一時entity != null && 高額合算自己負担額entity != null) {
            高額合算自己負担額TBLマスタ更新(高額合算自己負担額一時entity);
            高額合算自己負担額一時TBLマスタ更新(高額合算自己負担額entity, 高額合算自己負担額一時entity);
        } else {
            処理結果リスト一時に登録(高額合算自己負担額一時entity);
        }
    }

    private void 高額合算自己負担額TBLマスタ更新(DbWT37H1KogakuGassanaJikofutangakuCsvEntity tempEntity) {
        DbT3070KogakuGassanJikoFutanGakuEntity updateEntity = new DbT3070KogakuGassanJikoFutanGakuEntity();
        updateEntity.setJikoFutanSeiriNo(tempEntity.get自己負担額証明書整理番号());
        updateEntity.setShomeisho_UketoriYM(parameter.get処理年月());
        高額合算自己負担額TBLWriter.update(updateEntity);
    }

    private void 高額合算自己負担額一時TBLマスタ更新(
            DbT3070KogakuGassanJikoFutanGakuCsvEntity dbt3070Entity,
            DbWT37H1KogakuGassanaJikofutangakuCsvEntity dbwt37H1Entity) {
        DbWT37H1KogakuGassanaJikofutangakuTempEntity entity = new DbWT37H1KogakuGassanaJikofutangakuTempEntity();
        entity.setRirekiNo(dbt3070Entity.get履歴番号());
        entity.setJikoFutangakuSaiFlag(true);
        if (dbwt37H1Entity.get合計_自己負担額()
                == (dbt3070Entity.get補正済_合計_自己負担額().subtract(dbt3070Entity.get補正済_合計_70未満高額支給額()))) {
            entity.setJikoFutangakuSaiFlag(true);
        } else {
            entity.setJikoFutangakuSaiFlag(false);
        }
        高額合算自己負担額一時tableWriter.update(entity);
    }

    private void 処理結果リスト一時に登録(DbWT37H1KogakuGassanaJikofutangakuCsvEntity tempEntity) {
        DbWT0002KokuhorenTorikomiErrorEntity 処理結果リスト一時entity = new DbWT0002KokuhorenTorikomiErrorEntity();
        処理結果リスト一時entity.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.更新対象データなし.getコード());
        処理結果リスト一時entity.setShoHokanehshaNo(tempEntity.get保険者番号());
        処理結果リスト一時entity.setHihokenshaNo(tempEntity.get被保険者番号());
        処理結果リスト一時entity.setKey1(new RString(tempEntity.get対象年度().toString()));
        処理結果リスト一時entity.setKey2(tempEntity.get支給申請書整理番号());
        処理結果リスト一時entity.setKey3(tempEntity.get自己負担額証明書整理番号());
        処理結果リスト一時entity.setKey4(RString.EMPTY);
        処理結果リスト一時entity.setKey5(RString.EMPTY);
        処理結果リスト一時entity.setHihokenshaKanaShimei(new RString(tempEntity.get被保険者氏名カナ().toString()));
        処理結果リスト一時entity.setHihokenshaShimei(new RString(tempEntity.get被保険者氏名().toString()));
        処理結果リスト一時entity.setBiko(RString.EMPTY);
        処理結果リスト一時tbWriter.insert(処理結果リスト一時entity);
    }

}
