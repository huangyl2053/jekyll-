/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.FukaEntity;

/**
 * 介護賦課のマッパーインタフェースです。
 */
public interface IFukaMapper {

    /**
     * 介護賦課情報をキー検索で１件取得します。
     *
     * @param 賦課検索条件 賦課検索条件
     * @return FukaEntity
     */
    FukaEntity getFukaEntity(FukaMapperParameter 賦課検索条件);
}
