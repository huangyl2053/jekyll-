/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choshuyuyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.ChoshuYuyoMapperParameter;
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

    public ChoshuYuyoEntity select介護賦課徴収猶予ByKey(ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件);

    public List<ChoshuYuyoEntity> select介護賦課徴収猶予リストBy主キー1(ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件);
}
