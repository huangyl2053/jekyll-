/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tashitaishotsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tajushochitokureisyakanri.ShisetsuJyohoParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tashitaishotsuchisho.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.ShisetsuJyohoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.TatokuKanrenChohyoShijiDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashitaishotsuchisho.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity;

/**
 *
 * 住特施設退所通知書のMapperクラスです。
 *
 * @reamsid_L DBA-0380-010 huangh
 */
public interface ITaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper {

    /**
     * 介護除外住所地特例対象施設情報の取得処理です。
     *
     * @param inEntity inEntity
     * @return 介護除外住所地特例対象施設情報
     */
    TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity getTaShichosonJushochiTokureiShisetsuTaishoTsuchisho(
            TatokuKanrenChohyoShijiDataEntity inEntity);

    /**
     * 共通「宛名取得」情報の取得処理です。
     *
     * @param params params
     * @return 共通「宛名取得」情報
     */
    TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity selectTaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatis(
            TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter params);

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
