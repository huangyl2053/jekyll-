/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahyo.ninteichosairaijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJohoEntity;

/**
 * 認定調査依頼情報のマッパーインタフェースです。
 */
public interface INinteichosaIraiJohoMapper {

    /**
     * 認定調査依頼情報情報をキー検索で１件取得します。
     *
     * @param 認定調査依頼情報検索条件 認定調査依頼情報検索条件
     * @return NinteichosaIraiJohoEntity
     */
    NinteichosaIraiJohoEntity select認定調査依頼情報ByKey(NinteichosaIraiJohoMapperParameter 認定調査依頼情報検索条件);

    /**
     * 主キー1に合致する認定調査依頼情報のリストを取得します。
     *
     * @param 認定調査依頼情報検索条件 認定調査依頼情報検索条件
     * @return NinteichosaIraiJohoEntityの{@code list}
     */
    List<NinteichosaIraiJohoEntity> select認定調査依頼情報リストBy主キー1(NinteichosaIraiJohoMapperParameter 認定調査依頼情報検索条件);
}
