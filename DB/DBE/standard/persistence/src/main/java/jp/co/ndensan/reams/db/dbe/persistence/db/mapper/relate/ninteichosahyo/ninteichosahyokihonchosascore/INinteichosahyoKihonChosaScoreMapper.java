/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahyo.ninteichosahyokihonchosascore;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreEntity;

/**
 * 認定調査票（基本調査素点）のマッパーインタフェースです。
 */
public interface INinteichosahyoKihonChosaScoreMapper {

    /**
     * 認定調査票（基本調査素点）情報をキー検索で１件取得します。
     *
     * @param 認定調査票_基本調査素点_検索条件 認定調査票_基本調査素点_検索条件
     * @return NinteichosahyoKihonChosaScoreEntity
     */
    NinteichosahyoKihonChosaScoreEntity select認定調査票_基本調査素点ByKey(NinteichosahyoKihonChosaScoreMapperParameter 認定調査票_基本調査素点_検索条件);

    /**
     * 主キー1に合致する認定調査票（基本調査素点）のリストを取得します。
     *
     * @param 認定調査票_基本調査素点_検索条件 認定調査票_基本調査素点_検索条件
     * @return NinteichosahyoKihonChosaScoreEntityの{@code list}
     */
    List<NinteichosahyoKihonChosaScoreEntity> select認定調査票_基本調査素点リストBy主キー1(NinteichosahyoKihonChosaScoreMapperParameter 認定調査票_基本調査素点_検索条件);
}
