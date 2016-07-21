/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.fuka.SetaiShotokuKazeiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiHaakuEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.SetaiShotokuKazeiHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 世帯員把握（バッチ）クラスです。
 *
 * @reamsid_L DBB-0640-010 chenaoqi
 */
public class SetaiShotokuKazeiHanteiUpdateProcess extends SimpleBatchProcessBase {

    private SetaiShotokuKazeiHanteiProcessParameter processParameter;
    private ISetaiShotokuKazeiHanteiMapper mapper;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(ISetaiShotokuKazeiHanteiMapper.class);
        mapper.createTmpSetaiShotoku();
        List<SetaiHaakuEntity> list = mapper.selectNotNull();
        if (list == null || list.isEmpty()) {
            SetaiHaakuEntity entity = new SetaiHaakuEntity();
            FlexibleYear 所得年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
            entity.setShotokuNendo(所得年度);
            mapper.update世帯員把握入力Temp(entity);
        }
    }

    @Override
    protected void process() {
        SetaiShotokuKazeiHantei sut = SetaiShotokuKazeiHantei.createInstance();
        sut.getSetaiinHaaku(processParameter.get管理識別区分());
        sut.getJuminShotokuJoho();
    }
}
