/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.idochecklist;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.idochecklist.IdoCheckListGetDataParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.IdoInfoEntity;

/**
 * 異動チェックリストのマッパーインタフェースです。
 */
public interface IIdoCheckListMapper {

    /**
     * 被保険者台帳リストを取得します
     *
     * @param param パラメータ
     * @return IdoInfoEntity
     */
    List<IdoInfoEntity> getHihokenshaDaichouList(IdoCheckListGetDataParameter param);

    /**
     * 異動事由がコード種別：0008のコードと一致した場合、他市町村住所地特例者を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getJushochiTokureiListByCode08(IdoCheckListGetDataParameter param);

    /**
     * 異動事由がコード種別：0011のコードと一致した場合、他市町村住所地特例者を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getJushochiTokureiListByCode11(IdoCheckListGetDataParameter param);

    /**
     * 介護保険施設入退所情報を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getShisetsuNyutaishoList(IdoCheckListGetDataParameter param);

    /**
     * 異動事由がコード種別：0009のコードと一致した場合、適用除外者を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getTekiyoJogaishaDaichouListByCode09(IdoCheckListGetDataParameter param);

    /**
     * 異動事由がコード種別：0012のコードと一致した場合、適用除外者を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getTekiyoJogaishaDaichouListByCode12(IdoCheckListGetDataParameter param);

    /**
     * 異動事由がコード種別：0012のコードと一致した場合、適用除外者を取得します
     *
     * @param param パラメータ
     * @return List<IdoInfoEntity>
     */
    List<IdoInfoEntity> getRoreiFukushiNenkinList(IdoCheckListGetDataParameter param);
}
