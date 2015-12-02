/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoEntity;

/**
 * 介護賦課徴収猶予のマッパーインタフェースです。
 */
public interface IChoshuYuyoMapper {

    /**
     * 介護賦課徴収猶予情報をキー検索で１件取得します。
     *
     * @param 介護賦課徴収猶予検索条件 介護賦課徴収猶予検索条件
     * @return ChoshuYuyoEntity
     */
    ChoshuYuyoEntity getChoshuyuyoEntity(ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件);
}
