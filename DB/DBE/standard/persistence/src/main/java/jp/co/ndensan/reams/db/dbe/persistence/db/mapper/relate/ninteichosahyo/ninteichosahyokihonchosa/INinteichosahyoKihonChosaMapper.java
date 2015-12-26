/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahyo.ninteichosahyokihonchosa;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaEntity;

/**
 * 認定調査票（基本調査）のマッパーインタフェースです。
 */
public interface INinteichosahyoKihonChosaMapper {

    /**
     * 認定調査票（基本調査）情報をキー検索で１件取得します。
     *
     * @param 認定調査票_基本調査_検索条件 認定調査票_基本調査_検索条件
     * @return NinteichosahyoKihonChosaEntity
     */
    NinteichosahyoKihonChosaEntity select認定調査票_基本調査ByKey(NinteichosahyoKihonChosaMapperParameter 認定調査票_基本調査_検索条件);

    /**
     * 主キー1に合致する認定調査票（基本調査）のリストを取得します。
     *
     * @param 認定調査票_基本調査_検索条件 認定調査票_基本調査_検索条件
     * @return NinteichosahyoKihonChosaEntityの{@code list}
     */
    List<NinteichosahyoKihonChosaEntity> select認定調査票_基本調査リストBy主キー1(NinteichosahyoKihonChosaMapperParameter 認定調査票_基本調査_検索条件);
}
