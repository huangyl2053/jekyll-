/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.taShichosonJushochiTokureiShisetsuTaishoTsuchisho;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.TaShichosonJushochiTokureiShisetsuTaishoTsuchisho.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.TatokuKanrenChohyoShijiDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity;

/**
 *
 * 住特施設退所通知書のMapperクラスです。
 */
public interface TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper {

    /**
     * 介護除外住所地特例対象施設情報の取得処理です。
     *
     * @param inEntity
     * @return 介護除外住所地特例対象施設情報
     */
    TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity getTaShichosonJushochiTokureiShisetsuTaishoTsuchisho(
            TatokuKanrenChohyoShijiDataEntity inEntity
    );

    /**
     * 共通「宛名取得」情報の取得処理です。
     *
     * @param params
     * @return 共通「宛名取得」情報
     */
    public TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity selectTaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatis(TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter params);
}
