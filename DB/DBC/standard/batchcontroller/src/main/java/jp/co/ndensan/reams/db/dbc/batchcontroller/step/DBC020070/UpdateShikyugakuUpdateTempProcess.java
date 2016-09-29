/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020070.JigyobunShikyugakuKeisanProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 更新用データの支払情報を更新する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class UpdateShikyugakuUpdateTempProcess extends BatchProcessBase<ShikyugakuUpdateTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get更新用データの支払情報の更新");

    private static final RString TABLE_NAME = new RString("ShikyugakuUpdateTemp");
    private static final RString 支払方法区分 = new RString(1);
    private static final RString 窓口区分 = new RString(5);

    private JigyobunShikyugakuKeisanProcessParameter parameter;

    private RString 支払場所;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        支払場所 = DbBusinessConfig.get(ConfigNameDBC.事業分高額合算支給額計算_支払方法, RDate.getNowDate());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuUpdateTempEntity.class);
    }

    @Override
    protected void process(ShikyugakuUpdateTempEntity entity) {
        entity.setKettei_shiharaiHohoKubun(支払方法区分);
        entity.setKettei_shiharaiBasho(支払場所);
        entity.setKettei_shiharaikikanKaishiYMD(parameter.get窓口払開始年月日());
        entity.setKettei_shiharaikikanShuryoYMD(parameter.get窓口払終了年月日());
        entity.setKettei_heichoNaiyo(RString.EMPTY);
        entity.setKettei_shiharaikikanKaishiTime(getTime(parameter.get窓口払開始時刻()));
        entity.setKettei_shiharaikikanShuryoTime(getTime(parameter.get窓口払終了時刻()));
        entity.setMadoguchiKubun(窓口区分);

        entity.setState(EntityDataState.Modified);
        tempDbWriter.update(entity);
    }

    private RString getTime(RTime time) {
        return null;
    }
}
