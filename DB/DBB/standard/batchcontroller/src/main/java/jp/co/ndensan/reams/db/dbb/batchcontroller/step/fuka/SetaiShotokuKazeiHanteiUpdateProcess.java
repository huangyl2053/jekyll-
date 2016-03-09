/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.fuka.SetaiShotokuKazeiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2005SetaiHaakuTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.SetaiShotokuKazeiHantei;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 世帯員把握（バッチ）クラスです。
 */
public class SetaiShotokuKazeiHanteiUpdateProcess extends BatchProcessBase<DbT2005SetaiHaakuTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(""
            + "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper.selectNotNull");
    private SetaiShotokuKazeiHanteiProcessParameter processParameter;
    private ISetaiShotokuKazeiHanteiMapper mapper;

    @Override
    protected void initialize() {

        mapper = getMapper(ISetaiShotokuKazeiHanteiMapper.class);
        List<DbT2005SetaiHaakuTempEntity> list = mapper.selectNotNull();
        if (list == null || list.isEmpty()) {
            DbT2005SetaiHaakuTempEntity entity = new DbT2005SetaiHaakuTempEntity();
            FlexibleYear 所得年度 = new FlexibleYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                    SubGyomuCode.DBB介護賦課));
            entity.setShotokuNendo(所得年度);
            mapper.update世帯員把握入力Temp(entity);
        }

    }

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT2005SetaiHaakuTempEntity entity) {

    }

    @Override
    protected void afterExecute() {
        SetaiShotokuKazeiHantei sut = SetaiShotokuKazeiHantei.createInstance();
        sut.getSetaiinHaaku(processParameter.get管理識別区分());
        sut.getJuminShotokuJoho();
    }
}
