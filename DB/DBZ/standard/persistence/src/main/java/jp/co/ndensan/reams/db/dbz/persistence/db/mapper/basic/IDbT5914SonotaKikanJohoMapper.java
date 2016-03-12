/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.param.sonotakikanguide.SoNoTaKikanGuideParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;

/**
 * {@link jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5914SonotaKikanJohoEntity}のマッパーIFです。
 *
 */
public interface IDbT5914SonotaKikanJohoMapper {

    /**
     * {@link DbT5914SonotaKikanJohoEntity}を取得します。
     *
     * @return {@link DbT5914SonotaKikanJohoEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT5914SonotaKikanJohoEntity getEntity();
     
    /**
     * {@link List<DbT5914SonotaKikanJohoEntity>}を取得します。
     * @param parameter その他機関情報の取得するクラスです。
     * @return {@link List<DbT5914SonotaKikanJohoEntity>}
     */
    List<DbT5914SonotaKikanJohoEntity> getSoNoTaKiKanJohoList(SoNoTaKikanGuideParameter parameter);
}
