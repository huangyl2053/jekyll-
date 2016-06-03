/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaishadaichojoho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaishadaichojoho.TekiyoJogaiShisetuJyohoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaishadaichojoho.TekiyoJogaiShisetuJyohoRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 適用除外者台帳のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0412-010 linghuhang
 */
public interface ITekiyoJogaiShisetuJyohoMapper {

    /**
     * 宛名情報PSMで取得します。
     *
     * @param 宛名情報PSM検索条件 宛名情報PSM検索条件
     * @return ShikibetsuTaishoRelateEntity
     */
    UaFt200FindShikibetsuTaishoEntity select宛名情報(TekiyoJogaiShisetuJyohoParameter 宛名情報PSM検索条件);

    /**
     * 適用除外施設情報を識別コード検索でリスト取得します。
     *
     * @param 適用除外施設情報検索条件 適用除外施設情報検索条件
     * @return List<TekiyoJogaiShisetuJyohoRelateEntity>
     */
    List<TekiyoJogaiShisetuJyohoRelateEntity> select適用除外施設情報(TekiyoJogaiShisetuJyohoParameter 適用除外施設情報検索条件);
}
