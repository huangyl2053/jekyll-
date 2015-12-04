/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaisha.tekiyojogaisha;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaEntity;

/**
 * 適用除外者のマッパーインタフェースです。
 */
public interface ITekiyoJogaishaMapper {

    /**
     * 適用除外者情報をキー検索で１件取得します。
     *
     * @param 適用除外者検索条件 適用除外者検索条件
     * @return TekiyoJogaishaEntity
     */
    TekiyoJogaishaEntity select適用除外者ByKey(TekiyoJogaishaMapperParameter 適用除外者検索条件);
}
