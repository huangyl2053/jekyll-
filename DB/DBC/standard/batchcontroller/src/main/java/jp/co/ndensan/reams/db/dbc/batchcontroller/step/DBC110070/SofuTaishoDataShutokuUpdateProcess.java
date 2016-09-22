/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給額計算結果明細データの存在確認のProcessクラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class SofuTaishoDataShutokuUpdateProcess extends BatchProcessBase<DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110070."
            + "IKogakugassanKeisankekkaRenrakuhyoOutMapper.get高額合算支給額計算結果明細データがない");

    private static final RString 高額合算支給額計算結果一時 = new RString("DbWT3811KogakuGassanShikyuGakuKeisanKekka");
    private static final RString 処理結果リスト一時 = new RString("DbWT1002KokuhorenSakuseiError");

    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT3811TableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT1002TableWriter;

    private List<DbWT1002KokuhorenSakuseiErrorTempEntity> 処理結果リスト;

    @Override
    protected void initialize() {
        処理結果リスト = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        dbWT3811TableWriter = new BatchEntityCreatedTempTableWriter(高額合算支給額計算結果一時,
                DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity.class);
        dbWT1002TableWriter = new BatchEntityCreatedTempTableWriter(処理結果リスト一時,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity entity) {
        entity.setSofuJogaiFlag(true);
        dbWT3811TableWriter.update(entity);
        DbWT1002KokuhorenSakuseiErrorTempEntity 処理結果リスト一時Entity = get処理結果リスト一時Entity(entity);
        if (is処理結果リスト一時出力対象(処理結果リスト一時Entity)) {
            dbWT1002TableWriter.insert(処理結果リスト一時Entity);
        }
    }

    @Override
    protected void afterExecute() {

    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity get処理結果リスト一時Entity(
            DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity entity) {
        DbWT1002KokuhorenSakuseiErrorTempEntity 一時Enttiy = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        一時Enttiy.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.明細情報取得エラー.getコード());
        一時Enttiy.setShoHokanehshaNo(new ShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo().getColumnValue()));
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

    private boolean is処理結果リスト一時出力対象(DbWT1002KokuhorenSakuseiErrorTempEntity 処理結果リスト一時Entity) {
        if (処理結果リスト.isEmpty()) {
            処理結果リスト.add(処理結果リスト一時Entity);
            return true;
        }
        for (DbWT1002KokuhorenSakuseiErrorTempEntity 処理結果一時 : 処理結果リスト) {
            if (KokuhorenJoho_SakuseiErrorKubun.明細情報取得エラー.getコード().equals(処理結果一時.getErrorKubun())
                    && 処理結果一時.getShoHokanehshaNo().equals(処理結果リスト一時Entity.getShoHokanehshaNo())
                    && 処理結果一時.getHihokenshaNo().equals(処理結果リスト一時Entity.getHihokenshaNo())
                    && 処理結果一時.getKey1().equals(処理結果リスト一時Entity.getKey1())
                    && 処理結果一時.getKey2().equals(処理結果リスト一時Entity.getKey2())
                    && 処理結果一時.getKey3().equals(処理結果リスト一時Entity.getKey3())
                    && 処理結果一時.getKey4().equals(処理結果リスト一時Entity.getKey4())
                    && 処理結果一時.getKey5().equals(処理結果リスト一時Entity.getKey5())) {
                return false;
            }
        }
        処理結果リスト.add(処理結果リスト一時Entity);
        return true;
    }
}
