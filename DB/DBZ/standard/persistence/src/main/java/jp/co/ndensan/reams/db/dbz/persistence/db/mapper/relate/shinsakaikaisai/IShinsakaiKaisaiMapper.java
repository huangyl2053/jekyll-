/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinsakaikaisai;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakaikaisai.ShinsakaiKaisaiParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaikaisai.ShinsakaiKaisaiRelateEntity;

/**
 *
 * 介護認定審査会共有一覧のインタフェイスです。
 */
public interface IShinsakaiKaisaiMapper {

    /**
     * 審査会一覧情報検索する。
     *
     * @param parameter 介護認定審査会共有一覧のパラメータクラス
     * @return List<ShinsakaiKaisaiRelateEntity>
     */
    List<ShinsakaiKaisaiRelateEntity> get審査会一覧(ShinsakaiKaisaiParameter parameter);

}
