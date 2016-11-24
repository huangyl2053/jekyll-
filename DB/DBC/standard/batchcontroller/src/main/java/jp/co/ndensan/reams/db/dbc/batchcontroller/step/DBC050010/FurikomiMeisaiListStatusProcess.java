/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiMeisaiListStatusEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込明細一覧表作成_受給取得状況データ取得処理_Processクラスです．
 *
 * @reamsid_L DBC-2180-030 x_lilh
 */
public class FurikomiMeisaiListStatusProcess extends BatchProcessBase<FurikomiMeisaiListStatusEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IFurikomiMeisaiListStatusMapper.select受給取得状況情報");

    @BatchWriter
    BatchEntityCreatedTempTableWriter furikomiMeisaiJukyuWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        furikomiMeisaiJukyuWriter = new BatchEntityCreatedTempTableWriter(FurikomiDetailTempTableEntity.TABLE_NAME,
                FurikomiDetailTempTableEntity.class);
    }

    @Override
    protected void process(FurikomiMeisaiListStatusEntity t) {
        FurikomiDetailTempTableEntity data = t.get振込明細一時Entity();
        data.setShinseiKubunCode(t.get認定申請区分申請時コード());
        data.setYokaigoJotaiKubunCode(t.get受給者台帳Entity().getYokaigoJotaiKubunCode());
        data.setNinteiYukoKikanKaishiYMD(t.get受給者台帳Entity().getNinteiYukoKikanKaishiYMD());
        data.setNinteiYukoKikanShuryoYMD(t.get受給者台帳Entity().getNinteiYukoKikanShuryoYMD());
        furikomiMeisaiJukyuWriter.update(data);
    }
}
