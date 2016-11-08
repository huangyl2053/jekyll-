/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 処理結果リストの一意排他登録判定Mapperです。
 *
 * @reamsid_L DBC-9999-022 zhangrui
 */
public final class KokuhorenKyoutsuuShoriKekkaListInsertManager {

    private static final IKokuhorenKyoutsuuMapper MAPPER
            = InstanceProvider.create(MapperProvider.class).create(IKokuhorenKyoutsuuMapper.class);

    private KokuhorenKyoutsuuShoriKekkaListInsertManager() {
    }

    /**
     * 一意排他登録を判定する。
     *
     * @param 処理結果 DbWT0002KokuhorenTorikomiErrorTempEntity
     * @return boolean true:できる　false:できません
     */
    public static boolean do一意排他登録(DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果) {
        if ((MAPPER.count処理結果ByPK(処理結果) == 0)) {
            return MAPPER.insert処理結果リスト一時TBL(処理結果) > 0;
        }
        return false;
    }

}
