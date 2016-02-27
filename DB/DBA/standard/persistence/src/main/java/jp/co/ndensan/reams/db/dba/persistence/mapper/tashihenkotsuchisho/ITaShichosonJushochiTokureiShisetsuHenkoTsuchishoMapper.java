/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.tashihenkotsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tashihenkotsuchisho.TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tashihenkotsuchisho.TatokuKanrenChohyoRenrakuhyoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.TatokuKanrenChohyoShijiDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;

/**
 * 介護除外住所地特例対象施設情報取得Mapperクラスです。
 *
 */
public interface ITaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper {

    /**
     * 介護除外住所地特例対象施設情報取得(他住特施設変更通知書データ作成)
     *
     * @param inEntity inEntity
     * @return DbT1005KaigoJogaiTokureiTaishoShisetsuEntity
     */
    List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> getTaShichosonJushochiTokureiShisetsuHenkoTsuchisho(
            TatokuKanrenChohyoShijiDataEntity inEntity);

    /**
     * 宛名取得(他住特施設変更通知書データ作成)
     *
     * @param params params
     * @return 宛名データEntity
     */
    TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity selectTaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatis(
            TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter params);

    /**
     * 介護除外住所地特例対象施設情報取得(他住特施設退所通知書データ作成)
     *
     * @param inEntity inEntity
     * @return 介護除外住所地特例対象施設リスト
     */
    TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity setTatokuKanrenChohyoRenrakuhyo(
            TatokuKanrenChohyoShijiDataEntity inEntity);

    /**
     * 宛名取得(他住特施設退所通知書データ作成)
     *
     * @param params params
     * @return 宛名データEntity
     */
    TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity selectTatokuKanrenChohyoRenrakuhyoMybatis(
            TatokuKanrenChohyoRenrakuhyoMybatisParameter params);
}
