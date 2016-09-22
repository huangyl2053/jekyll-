/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangaku.DbWT37K1KogakuGassanJikoFutanGakuTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成のバッチ高額合算自己負担額明細データの存在確認Processです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public class KogakugassanMeisaiKakuninProcess extends BatchProcessBase<DbWT37K1KogakuGassanJikoFutanGakuTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassan."
            + "IKogakugassanHoseisumiJikofutangakuOutMapper.get明細データ");

    private static final RString 高額合算自己負担額一時NAME = new RString("DbWT37K1KogakuGassanJikoFutanGaku");
    private static final RString 処理結果リスト一時NAME = new RString("DbWT1002KokuhorenSakuseiError");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算自己負担額一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額一時NAME, DbWT37K1KogakuGassanJikoFutanGakuTempEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時NAME, DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(DbWT37K1KogakuGassanJikoFutanGakuTempEntity entity) {
        DbWT1002KokuhorenSakuseiErrorTempEntity dbWT1002Entity = get処理結果リスト一時Entity(entity);
        entity.setSofuJogaiFlag(true);
        高額合算自己負担額一時tableWriter.update(entity);
        処理結果リスト一時tableWriter.insert(dbWT1002Entity);
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity get処理結果リスト一時Entity(DbWT37K1KogakuGassanJikoFutanGakuTempEntity entity) {
        DbWT1002KokuhorenSakuseiErrorTempEntity 一時Enttiy = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        一時Enttiy.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.明細情報取得エラー.getコード());
        一時Enttiy.setShoHokanehshaNo(new ShoKisaiHokenshaNo(entity.getHokenshaNo().getColumnValue()));
        一時Enttiy.setHihokenshaNo(entity.getHihokenshaNo());
        一時Enttiy.setKey1(entity.getShikyuShinseishoSeiriNo());
        一時Enttiy.setKey2(RString.EMPTY);
        一時Enttiy.setKey3(RString.EMPTY);
        一時Enttiy.setKey4(RString.EMPTY);
        一時Enttiy.setKey5(RString.EMPTY);
        一時Enttiy.setHihokenshaKanaShimei(RString.EMPTY);
        一時Enttiy.setHihokenshaShimei(RString.EMPTY);
        一時Enttiy.setBiko(RString.EMPTY);
        return 一時Enttiy;
    }
}
