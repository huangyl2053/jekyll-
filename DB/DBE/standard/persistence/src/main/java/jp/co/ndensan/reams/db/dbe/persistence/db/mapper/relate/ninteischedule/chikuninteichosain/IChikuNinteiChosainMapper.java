/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteischedule.chikuninteichosain;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteischedule.chikuninteichosain.ChikuNinteiChosainMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikuninteichosain.ChikuNinteiChosainEntity;

/**
 * 地区認定調査員のマッパーインタフェースです。
 */
public interface IChikuNinteiChosainMapper {

    /**
     * 地区認定調査員情報をキー検索で１件取得します。
     *
     * @param 地区認定調査員検索条件 地区認定調査員検索条件
     * @return ChikuNinteiChosainEntity
     */
    ChikuNinteiChosainEntity select地区認定調査員ByKey(ChikuNinteiChosainMapperParameter 地区認定調査員検索条件);

    /**
     * 主キー1に合致する地区認定調査員のリストを取得します。
     *
     * @param 地区認定調査員検索条件 地区認定調査員検索条件
     * @return ChikuNinteiChosainEntityの{@code list}
     */
    List<ChikuNinteiChosainEntity> select地区認定調査員リストBy主キー1(ChikuNinteiChosainMapperParameter 地区認定調査員検索条件);
}
