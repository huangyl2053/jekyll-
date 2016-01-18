/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.FukaEntity;

/**
 * 介護賦課のマッパーインタフェースです。
 */
public interface IFukaMapper {

    /**
     * 介護賦課情報をキー検索で１件取得します。
     *
     * @param 介護賦課検索条件 介護賦課検索条件
     * @return FukaEntity
     */
    FukaEntity getFukaEntity(FukaMapperParameter 賦課検索条件);

    public FukaEntity select介護賦課ByKey(FukaMapperParameter 介護賦課検索条件);

    public List<FukaEntity> select介護賦課リストBy主キー1(FukaMapperParameter 介護賦課検索条件);
}
