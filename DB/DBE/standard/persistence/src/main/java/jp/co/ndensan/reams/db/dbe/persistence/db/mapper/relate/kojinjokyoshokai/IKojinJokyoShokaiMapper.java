/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kojinjokyoshokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kojinjokyoshokai.KojinJokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinjokyoshokai.KojinJokyoShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5150RenrakusakiJohoEntity;

/**
 * 要介護認定個人状況照会のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0200-010 suguangjun
 */
public interface IKojinJokyoShokaiMapper {

    /**
     * 要介護認定個人状況照会を取得します。
     *
     * @param parameter 要介護認定個人状況照会用パラメータ
     * @return KojinJokyoShokaiRelateEntity 検索結果の{@link KojinJokyoShokaiRelateEntity}
     */
    KojinJokyoShokaiRelateEntity selectKojinJokyoShokai(KojinJokyoShokaiParameter parameter);

    /**
     * 要介護認定個人進捗状況票を取得します。
     *
     * @param parameter 要介護認定個人状況照会用パラメータ
     * @return KojinJokyoShokaiRelateEntity 検索結果の{@link KojinJokyoShokaiRelateEntity}
     */
    KojinJokyoShokaiRelateEntity selectKojinShinchokuJokyohyo(KojinJokyoShokaiParameter parameter);

    /**
     * 連絡先を取得します。
     *
     * @param parameter 要介護認定個人状況照会用パラメータ
     * @return KojinJokyoShokaiRelateEntity 検索結果の{@link KojinJokyoShokaiRelateEntity}
     */
    List<DbT5150RenrakusakiJohoEntity> selectRenrakusakiJoho(KojinJokyoShokaiParameter parameter);
}
