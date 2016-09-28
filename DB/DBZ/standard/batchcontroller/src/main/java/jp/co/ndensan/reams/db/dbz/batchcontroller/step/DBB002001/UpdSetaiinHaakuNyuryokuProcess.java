/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHakuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * update世帯員把握入力です。
 *
 * @reamsid_L DBB-0640-010 chenaoqi
 */
public class UpdSetaiinHaakuNyuryokuProcess extends SimpleBatchProcessBase {

    private ISetaiShotokuKazeiHanteiMapper mapper;
    private FlexibleYear 所得年度;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(ISetaiShotokuKazeiHanteiMapper.class);
        所得年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));

    }

    @Override
    protected void process() {
        List<SetaiHakuEntity> list = mapper.selectNotNull();
        if (list == null || list.isEmpty()) {
            SetaiHakuEntity entity = new SetaiHakuEntity();
            entity.setShotokuNendo(所得年度);
            mapper.update世帯員把握入力Temp(entity);
        }
    }
}
