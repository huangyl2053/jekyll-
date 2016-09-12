/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tashihenkotsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tajushochitokureisyakanri.ShisetsuJyohoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.ShisetsuJyohoRelateEntity;

/**
 * 介護除外住所地特例対象施設情報取得Mapperクラスです。
 *
 * @reamsid_L DBA-0380-040 duanzhanli
 */
public interface IShisetsuJyohoMapper {

    /**
     * 介護除外住所地特例対象施設情報の取得処理です。
     *
     * @param prm ShisetsuJyohoParameter
     * @return ShisetsuJyohoRelateEntity
     */
    List<ShisetsuJyohoRelateEntity> selct他市町村住所地特例(ShisetsuJyohoParameter prm);

    /**
     * 事業者名称の取得処理です。
     *
     * @param prm ShisetsuJyohoParameter
     * @return ShisetsuJyohoRelateEntity
     */
    ShisetsuJyohoRelateEntity get事業者名称_介護保険施設(ShisetsuJyohoParameter prm);

    /**
     * 事業者名称の取得処理です。
     *
     * @param prm ShisetsuJyohoParameter
     * @return ShisetsuJyohoRelateEntity
     */
    ShisetsuJyohoRelateEntity get事業者名称_住所地特例対象施設(ShisetsuJyohoParameter prm);

}
