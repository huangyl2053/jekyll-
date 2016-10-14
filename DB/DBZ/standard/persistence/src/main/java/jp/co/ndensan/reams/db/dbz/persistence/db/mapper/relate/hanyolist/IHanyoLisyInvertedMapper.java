/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.hanyolist;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.hanyolist.HanyoLisyInvertedParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hanyolist.HanyoLisyInvertedEntity;

/**
 * ビジネス設計_DBZMNnnnnn_汎用リストのマッパーインタフェースです。
 *
 * @reamsid_L DBZ-4570-010 jinge
 */
public interface IHanyoLisyInvertedMapper {

    /**
     * select汎用リスト一時テーブル
     *
     * @param parameter HanyoListTempTableNameParameter
     * @return HanyoListTempEntity
     */
    List<HanyoLisyInvertedEntity> select汎用リスト項目変換テーブル(HanyoLisyInvertedParameter parameter);
}
