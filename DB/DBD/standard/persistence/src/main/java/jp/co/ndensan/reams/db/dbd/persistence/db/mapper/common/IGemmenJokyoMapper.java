/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.common;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.definition.common.GemmenJokyoParameter;
import jp.co.ndensan.reams.db.dbd.entity.common.NursingCareInformationCodeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;

/**
 *
 * 減免照会（画面） Mapper
 */
public interface IGemmenJokyoMapper {

    /**
     * get要介護認定情報
     *
     * @param parameter パラメータク
     * @return List<NursingCareInformationCodeEntity>
     */
    List<NursingCareInformationCodeEntity> get要介護認定情報(GemmenJokyoParameter parameter);

    /**
     * get申請中情報
     *
     * @param parameter パラメータク
     * @return DbT4001JukyushaDaichoEntity
     */
    DbT4001JukyushaDaichoEntity get申請中情報(GemmenJokyoParameter parameter);

    /**
     * get老齢年金情報
     *
     * @param parameter パラメータク
     * @return DbT7006RoreiFukushiNenkinJukyushaEntity
     */
    DbT7006RoreiFukushiNenkinJukyushaEntity get老齢年金情報(GemmenJokyoParameter parameter);

    /**
     * get支払方法変更情報
     *
     * @param parameter パラメータク
     * @return List<DbT4021ShiharaiHohoHenkoEntity>
     */
    List<DbT4021ShiharaiHohoHenkoEntity> get支払方法変更情報(GemmenJokyoParameter parameter);

    /**
     * get支払方法変更情報
     *
     * @param parameter パラメータク
     * @return List<DbV1001HihokenshaDaichoEntity>
     */
    List<DbV1001HihokenshaDaichoEntity> get識別コード(GemmenJokyoParameter parameter);

    /**
     * get利用者負担割合明細
     *
     * @param parameter パラメータク
     * @return List<DbT3114RiyoshaFutanWariaiMeisaiEntity>
     */
    List<DbT3114RiyoshaFutanWariaiMeisaiEntity> get利用者負担割合明細(GemmenJokyoParameter parameter);

}
