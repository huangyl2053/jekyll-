/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;

/**
 * 認定調査委託先情報のマッパーインタフェースです。
 */
public interface IKoseiShichosonMasterMapper {

    /**
     * 認定調査委託先情報をキー検索で１件取得します。
     *
     * @param 認定調査委託先情報検索条件 認定調査委託先情報検索条件
     * @return KoseiShichosonMasterEntity
     */
    NinteichosaItakusakiJohoRelateEntity getChosaItakusakiChosainRelateEntity(KoseiShichosonMasterMapperParameter 認定調査委託先情報検索条件);

}
