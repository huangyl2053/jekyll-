/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kojinjokyoshokai;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.kojinjokyoshokai.KojinJokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinjokyoshokai.KojinJokyoShokaiRelateEntity;


/**
 * 要介護認定個人状況照会のマッパーインタフェースです。
 */
public interface IKojinJokyoShokaiMapper {

    /**
     * 要介護認定個人状況照会を取得します。
     *
     * @param parameter 要介護認定個人状況照会
     * @return KojinJokyoShokaiRelateEntity 検索結果の{@link KojinJokyoShokaiRelateEntity}
     */
    KojinJokyoShokaiRelateEntity selectKojinJokyoShokai(KojinJokyoShokaiParameter parameter);

}
