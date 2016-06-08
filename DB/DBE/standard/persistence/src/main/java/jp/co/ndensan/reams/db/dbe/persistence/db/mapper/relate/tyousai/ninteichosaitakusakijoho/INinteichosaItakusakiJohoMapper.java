/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.tyousai.ninteichosaitakusakijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;

/**
 * 認定調査委託先情報のマッパーインタフェースです。
 */
public interface INinteichosaItakusakiJohoMapper {

    /**
     * 認定調査委託先情報情報をキー検索で１件取得します。
     *
     * @param 認定調査委託先情報検索条件 認定調査委託先情報検索条件
     * @return NinteichosaItakusakiJohoEntity
     */
    NinteichosaItakusakiJohoRelateEntity select認定調査委託先情報ByKey(NinteichosaItakusakiJohoMapperParameter 認定調査委託先情報検索条件);

    /**
     * 主キー1に合致する認定調査委託先情報のリストを取得します。
     *
     * @param 認定調査委託先情報検索条件 認定調査委託先情報検索条件
     * @return NinteichosaItakusakiJohoEntityの{@code list}
     */
    List<NinteichosaItakusakiJohoRelateEntity> select認定調査委託先情報リストBy主キー1(NinteichosaItakusakiJohoMapperParameter 認定調査委託先情報検索条件);
}
