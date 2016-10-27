/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.getpanteitodaisyou.GetPanTeiToDaiSyouEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者の判定と受給者台帳の取得のクラスです。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
public class GetPanTeiToDaiSyouProcess extends BatchProcessBase<GetPanTeiToDaiSyouEntity> {

    private static final RString 受給者の判定と受給者台帳 = new RString("jp.co.ndensan.reams.db.dbc.persistence"
            + ".db.mapper.relate.dbc110050.IShokanRenrakuhyoOutMapper.get受給者の判定と受給者台帳");
    private static final RString TABLE_償還払支給申請一時 = new RString("DbWT2111ShokanShinsei");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 償還払支給申請一時;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(受給者の判定と受給者台帳);
    }

    @Override
    protected void createWriter() {
        償還払支給申請一時 = new BatchEntityCreatedTempTableWriter(TABLE_償還払支給申請一時,
                DbWT2111ShokanShinseiTempEntity.class);
    }

    @Override
    protected void process(GetPanTeiToDaiSyouEntity entity) {
        DbWT2111ShokanShinseiTempEntity updateEntity = entity.get償還払支給申請一時TBL();
        DbT4001JukyushaDaichoEntity 受給者台帳TBL = entity.get受給者台帳TBL();
        updateEntity.setJukyushaDaichoFlag(true);
        updateEntity.setKyuSochishaFlag(受給者台帳TBL.getKyuSochishaFlag());
        Code 要介護認定状態区分コード = 受給者台帳TBL.getYokaigoJotaiKubunCode();
        if (要介護認定状態区分コード != null) {
            updateEntity.setYokaigoJotaiKubunCode(要介護認定状態区分コード.getColumnValue());
        } else {
            updateEntity.setYokaigoJotaiKubunCode(RString.EMPTY);
        }
        updateEntity.setNinteiYukoKikanKaishiYMD(受給者台帳TBL.getNinteiYukoKikanKaishiYMD());
        updateEntity.setNinteiYukoKikanShuryoYMD(受給者台帳TBL.getNinteiYukoKikanShuryoYMD());
        償還払支給申請一時.update(updateEntity);
    }
}
