/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.kaigojigyosha;

import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigojigyosha.KaigoJigyoshaMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;

/**
 * 介護事業者のマッパーインタフェースです。
 */
public interface IKaigoJigyoshaMapper {

    /**
     * 介護事業者情報をキー検索で１件取得します。
     *
     * @param 介護事業者検索条件 介護事業者検索条件
     * @return KaigoJigyoshaEntity
     */
    KaigoJigyoshaEntity getKaigoJigyoshaEntity(KaigoJigyoshaMapperParameter 介護事業者検索条件);
}
