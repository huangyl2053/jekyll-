/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業高額合算支給不支給決定のデータと更新用データを比較して、更新用一時の内容を更新する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class KogakuShikyuFushikyuKetteiUpdateShikyugakuUpdateTempProcess extends BatchProcessBase<ShikyugakuUpdateTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.高額合算支給不支給決定のデータFor更新用データ");

    private static final RString TABLE_NAME = new RString("ShikyugakuUpdateTemp");
    private static final RString 支払方法区分1 = new RString(1);
    private static final RString 支払方法区分2 = new RString(2);
    private static final RString 窓口区分1 = new RString(1);
    private static final RString 窓口区分2 = new RString(2);

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuUpdateTempEntity.class);
    }

    @Override
    protected void process(ShikyugakuUpdateTempRelateEntity entity) {
        ShikyugakuUpdateTempEntity 更新用一時 = entity.get更新用一時();
        更新用一時.setKettei_rirekiNo(更新用一時.getKettei_rirekiNo() == 0
                ? entity.get高額合算支給不支給決定().getRirekiNo() + 1 : 更新用一時.getKettei_rirekiNo());
        更新用一時.setKettei_shiharaiHohoKubun(entity.get高額合算支給不支給決定().getShiharaiHohoKubun());
        更新用一時.setKettei_shiharaiBasho(entity.get高額合算支給不支給決定().getShiharaiBasho());
        更新用一時.setKettei_shiharaikikanKaishiYMD(entity.get高額合算支給不支給決定().getShiharaiKaishiYMD());
        更新用一時.setKettei_shiharaikikanShuryoYMD(entity.get高額合算支給不支給決定().getShiharaiShuryoYMD());
        更新用一時.setKettei_heichoNaiyo(entity.get高額合算支給不支給決定().getHeichoNaiyo());
        更新用一時.setKettei_shiharaikikanKaishiTime(entity.get高額合算支給不支給決定().getShiharaiKaishiTime());
        更新用一時.setKettei_shiharaikikanShuryoTime(entity.get高額合算支給不支給決定().getShiharaiShuryoTime());
        更新用一時.setKettei_kozaID(entity.get高額合算支給不支給決定().getKozaID());
        if (支払方法区分1.equals(entity.get高額合算支給不支給決定().getShiharaiHohoKubun())) {
            更新用一時.setMadoguchiKubun(窓口区分2);
        } else if (支払方法区分2.equals(entity.get高額合算支給不支給決定().getShiharaiHohoKubun())) {
            更新用一時.setMadoguchiKubun(窓口区分1);
        } else {
            更新用一時.setMadoguchiKubun(RString.EMPTY);
        }

        更新用一時.setState(EntityDataState.Modified);
        tempDbWriter.update(更新用一時);
    }
}
