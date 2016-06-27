/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tashitaishotsuchisho;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tashitaishotsuchisho.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter;
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
}
