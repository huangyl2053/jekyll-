/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahyo.ninteichosahyogaikyochosa;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosaMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosaEntity;

/**
 * 認定調査票（概況調査）のマッパーインタフェースです。
 */
public interface INinteichosahyoGaikyoChosaMapper {

    /**
     * 認定調査票（概況調査）情報をキー検索で１件取得します。
     *
     * @param 認定調査票_概況調査_検索条件 認定調査票_概況調査_検索条件
     * @return NinteichosahyoGaikyoChosaEntity
     */
    NinteichosahyoGaikyoChosaEntity select認定調査票_概況調査ByKey(NinteichosahyoGaikyoChosaMapperParameter 認定調査票_概況調査_検索条件);

    /**
     * 主キー1に合致する認定調査票（概況調査）のリストを取得します。
     *
     * @param 認定調査票_概況調査_検索条件 認定調査票_概況調査_検索条件
     * @return NinteichosahyoGaikyoChosaEntityの{@code list}
     */
    List<NinteichosahyoGaikyoChosaEntity> select認定調査票_概況調査リストBy主キー1(NinteichosahyoGaikyoChosaMapperParameter 認定調査票_概況調査_検索条件);
}
