/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.CreateRiyojokyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
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
 * 給付事業者名更新のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1513kyotakuServiceJigyoshoNameUpdateProcess extends BatchProcessBase<DbWT1513RiyoJokyoTokeihyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select事業者名称");

    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    private static final RString TABLE_処理結果確認リスト一時 = new RString("DbWT1514ShoriKekkaKakuninList");
    private static final RString 事業者番号_ALL0 = new RString("0000000000");
    private static final RString TRUE_1 = new RString("1");
    private static final RString 居宅介護支援事業者 = new RString("居宅介護支援事業者");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果確認リスト一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;

    @Override
    protected IBatchReader createReader() {
        CreateRiyojokyoMybatisParameter parameter = new CreateRiyojokyoMybatisParameter();
        parameter.set事業者名(false);
        parameter.set給付事業者名(true);
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter);
    }

    @Override
    protected void createWriter() {
        利用状況統計表一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_利用状況統計表一時,
                DbWT1513RiyoJokyoTokeihyoEntity.class);
        処理結果確認リスト一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_処理結果確認リスト一時,
                DbWT1514ShoriKekkaKakuninListEntity.class);
    }

    @Override
    protected void process(DbWT1513RiyoJokyoTokeihyoEntity entity) {
        if ((!RString.isNullOrEmpty(entity.getKyotakuServiceJigyoshoNo())
                && !事業者番号_ALL0.equals(entity.getKyotakuServiceJigyoshoNo()))
                && RString.isNullOrEmpty(entity.getKyotakuServiceJigyoshoName()) && TRUE_1.equals(entity.getMeisaiOutFlag())) {
            DbWT1514ShoriKekkaKakuninListEntity 処理結果確認リスト一時entity = new DbWT1514ShoriKekkaKakuninListEntity();
            処理結果確認リスト一時entity.setErrorKubun(Tokeihyo_ErrorKubun.事業者名称取得.getコード());
            処理結果確認リスト一時entity.setShoKisaiHokenshaNo(new HokenshaNo(entity.getShoKisaiHokenshaNo()));
            処理結果確認リスト一時entity.setHihokenshaNo(new HihokenshaNo(entity.getHihokenshaNo()));
            処理結果確認リスト一時entity.setKey1(entity.getServiceTeikyoYM());
            処理結果確認リスト一時entity.setKey2(entity.getKyotakuServiceJigyoshoNo());
            処理結果確認リスト一時entity.setKey3(RString.EMPTY);
            処理結果確認リスト一時entity.setKey4(RString.EMPTY);
            処理結果確認リスト一時entity.setKey5(entity.getKyotakuServiceShuruiCode());
            処理結果確認リスト一時entity.setHihokenshaShimei(entity.getShimei());
            処理結果確認リスト一時entity.setBiko(居宅介護支援事業者);
            処理結果確認リスト一時TBL.insert(entity);
        } else {
            利用状況統計表一時TBL.update(entity);
        }
    }
}
