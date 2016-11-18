/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 集計データ登録①のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1513ShukeiDataInsert1Process extends BatchProcessBase<DbWT1513RiyoJokyoTokeihyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select集計データ登録1");

    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;

    DbWT1513RiyoJokyoTokeihyoEntity tempEntity;
    RString 被保険者番号;
    RString サービス提供年月;
    RiyoJokyoTokeihyoMeisaiListSakuseiService service;

    @Override
    protected void initialize() {
        tempEntity = null;
        被保険者番号 = RString.EMPTY;
        サービス提供年月 = RString.EMPTY;
        service = RiyoJokyoTokeihyoMeisaiListSakuseiService.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        利用状況統計表一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_利用状況統計表一時,
                DbWT1513RiyoJokyoTokeihyoEntity.class);
    }

    @Override
    protected void process(DbWT1513RiyoJokyoTokeihyoEntity entity) {
        if (被保険者番号.equals(entity.getHihokenshaNo()) && サービス提供年月.equals(entity.getServiceTeikyoYM())) {
            tempEntity = service.create集計データ登録1(tempEntity, entity);
        } else {
            if (tempEntity != null) {
                利用状況統計表一時TBL.insert(tempEntity);
            }
            tempEntity = entity.clone();
            tempEntity.setKyotakuServiceSakuseiKubunCode(RString.EMPTY);
            tempEntity.setKyotakuServiceShuruiCode(RString.EMPTY);
            tempEntity.setKyotakuServiceJigyoshoNo(RString.EMPTY);
            tempEntity.setServiceKubun(RString.EMPTY);
            tempEntity = service.create集計データ登録1(tempEntity, entity);
        }
        被保険者番号 = entity.getHihokenshaNo();
        サービス提供年月 = entity.getServiceTeikyoYM();
    }

    @Override
    protected void afterExecute() {
        if (tempEntity != null) {
            利用状況統計表一時TBL.insert(tempEntity);
        }
    }
}
