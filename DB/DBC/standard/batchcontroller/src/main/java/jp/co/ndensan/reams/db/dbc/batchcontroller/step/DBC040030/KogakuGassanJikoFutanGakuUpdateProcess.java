/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040030.KogakugassanJikofutangakuInfoHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakuGassanUpdateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額情報更新プロセスです。
 *
 * @reamsid_L DBC-2320-060 yuanzhenxia
 */
public class KogakuGassanJikoFutanGakuUpdateProcess extends BatchProcessBase<KogakuGassanUpdateEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030."
            + "IKogakugassanJikofutangakuInfoHoseiMapper.select高額合算自己負担額データ");
    private static final RString STRINGTWO = new RString("2");
    private KogakugassanJikofutangakuInfoHoseiProcessParameter processParameter;
    private RString 高額合算自己負担額補正_支払場所;
    @BatchWriter
    BatchPermanentTableWriter<DbT3070KogakuGassanJikoFutanGakuEntity> tableWrite;

    @Override
    protected void initialize() {
        高額合算自己負担額補正_支払場所 = DbBusinessConfig.get(ConfigNameDBC.高額合算自己負担額補正_支払場所, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.tableWrite = new BatchPermanentTableWriter<>(DbT3070KogakuGassanJikoFutanGakuEntity.class);
    }

    @Override
    protected void process(KogakuGassanUpdateEntity entity) {
        DbT3070KogakuGassanJikoFutanGakuEntity 高額合算自己負担額 = entity.get高額合算自己負担額();
        高額合算自己負担額.setSumi_Gokei_JikoFutanGaku(entity.get中間DBEntity().getSumi_Gokei_JikoFutanGaku());
        高額合算自己負担額.setSumi_Gokei_70_74JikoFutanGaku(entity.get中間DBEntity().getSumi_Gokei_70_74JikoFutanGaku());
        高額合算自己負担額.setSumi_Gokei_Under70KogakuShikyuGaku(entity.get中間DBEntity().getSumi_Gokei_Under70KogakuShikyuGaku());
        高額合算自己負担額.setSumi_Gokei_70_74KogakuShikyuGaku(entity.get中間DBEntity().getSumi_Gokei_70_74KogakuShikyuGaku());
        高額合算自己負担額.setShiharaiBasho(edit支払場所(entity));
        高額合算自己負担額.setShikaraiKaishiYMD(edit支払期間開始年月日(entity));
        高額合算自己負担額.setShiharaiShuryoYMD(edit支払期間終了年月日(entity));
        高額合算自己負担額.setShiharaiKaishiTime(edit支払期間開始時間(entity));
        高額合算自己負担額.setShiharaiShuryoTime(edit支払期間終了時間(entity));
        高額合算自己負担額.setBatchHoseiJissiYMD(new FlexibleDate(RDateTime.now().getDate().toDateString()));
        tableWrite.update(高額合算自己負担額);

    }

    private RString edit支払場所(KogakuGassanUpdateEntity entity) {
        if (STRINGTWO.equals(entity.get中間DBEntity().getMadoguchi_TaishoshaHanteiCode())) {
            return 高額合算自己負担額補正_支払場所;
        } else {
            return entity.get中間DBEntity().getShiharaiBasho();
        }
    }

    private FlexibleDate edit支払期間開始年月日(KogakuGassanUpdateEntity entity) {
        if (STRINGTWO.equals(entity.get中間DBEntity().getMadoguchi_TaishoshaHanteiCode())) {
            return new FlexibleDate(processParameter.get開始年月日());
        } else {
            return entity.get中間DBEntity().getShikaraiKaishiYMD() == null ? null
                    : new FlexibleDate(entity.get中間DBEntity().getShikaraiKaishiYMD().toString());
        }
    }

    private FlexibleDate edit支払期間終了年月日(KogakuGassanUpdateEntity entity) {
        if (STRINGTWO.equals(entity.get中間DBEntity().getMadoguchi_TaishoshaHanteiCode())) {
            return new FlexibleDate(processParameter.get終了年月日());
        } else {
            return entity.get中間DBEntity().getShiharaiShuryoYMD() == null ? null
                    : new FlexibleDate(entity.get中間DBEntity().getShiharaiShuryoYMD().toString());
        }
    }

    private RString edit支払期間開始時間(KogakuGassanUpdateEntity entity) {
        if (STRINGTWO.equals(entity.get中間DBEntity().getMadoguchi_TaishoshaHanteiCode())) {
            return processParameter.get開始時間();
        } else {
            return entity.get中間DBEntity().getShiharaiKaishiTime();
        }
    }

    private RString edit支払期間終了時間(KogakuGassanUpdateEntity entity) {
        if (STRINGTWO.equals(entity.get中間DBEntity().getMadoguchi_TaishoshaHanteiCode())) {
            return processParameter.get終了時間();
        } else {
            return entity.get中間DBEntity().getShiharaiShuryoTime();
        }
    }

}
