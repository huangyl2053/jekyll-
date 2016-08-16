/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb901002;

import jp.co.ndensan.reams.db.dbb.definition.processprm.nendokirikae.NendoKirikaeProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.config.entity.UzT0001StandardConfigEntity;

/**
 * 業務コンフィグ年度切替processのクラスです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
public class UpdateUzT0001StandardConfigProcess extends BatchProcessBase<UzT0001StandardConfigEntity> {

    private NendoKirikaeProcessParameter processParameter;
    private static final int INT_1 = 1;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nendokirikae."
            + "INendoKirikaeMapper.select業務コンフィグ");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
    }

    @Override
    protected void process(UzT0001StandardConfigEntity entity) {
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.日付関連_調定年度,
                processParameter.get調定年度().plusYear(INT_1).toDateString(), RString.EMPTY, RString.EMPTY, RDate.getNowDate());
    }
}
