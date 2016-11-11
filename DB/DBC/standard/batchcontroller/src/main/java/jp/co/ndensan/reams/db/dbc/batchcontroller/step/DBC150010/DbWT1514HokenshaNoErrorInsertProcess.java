/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1514ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者・宛名更新のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1514HokenshaNoErrorInsertProcess extends BatchProcessBase<RString> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select被保険者宛名エラー情報");

    private static final RString TABLE_処理結果確認リスト一時 = new RString("DbWT1514ShoriKekkaKakuninList");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果確認リスト一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        処理結果確認リスト一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_処理結果確認リスト一時,
                DbWT1514ShoriKekkaKakuninListEntity.class);
    }

    @Override
    protected void process(RString 被保険者番号) {
        DbWT1514ShoriKekkaKakuninListEntity entity = new DbWT1514ShoriKekkaKakuninListEntity();
        entity.setErrorKubun(Tokeihyo_ErrorKubun.被保険者宛名情報取得.getコード());
        entity.setHihokenshaNo(new HihokenshaNo(被保険者番号));
        entity.setBiko(RString.EMPTY);
        entity.setHihokenshaShimei(RString.EMPTY);
        entity.setKey1(RString.EMPTY);
        entity.setKey2(RString.EMPTY);
        entity.setKey3(RString.EMPTY);
        entity.setKey4(RString.EMPTY);
        entity.setKey5(RString.EMPTY);
        entity.setShoKisaiHokenshaNo(HokenshaNo.EMPTY);
        処理結果確認リスト一時TBL.insert(entity);
    }
}
