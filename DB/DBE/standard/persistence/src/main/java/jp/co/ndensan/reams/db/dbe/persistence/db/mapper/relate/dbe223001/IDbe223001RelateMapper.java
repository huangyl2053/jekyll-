/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe223001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe223001.NinteiChosaTokusokujoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe223001.NinteiChosaTokusokujoRelateEntity;

/**
 * 認定調査督促状発行のマッパーインタフェースです。
 */
public interface IDbe223001RelateMapper {
 
    /**
     * 要介護認定調査督促状パラメータを取得します。
     *
     * @param parameter 検索条件
     * @return NinteiChosaTokusokujoRelateEntity 検索結果の{@link NinteiChosaTokusokujoRelateEntity}
     */
    List<NinteiChosaTokusokujoRelateEntity> select要介護認定調査督促状ByKey(NinteiChosaTokusokujoMybatisParameter parameter);
    
    /**
     * 認定調査督促対象者一覧表パラメータを取得します。
     *
     * @param parameter 検索条件
     * @return NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity 検索結果の{@link NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity}
     */
    List<NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity> 
        select認定調査督促対象者一覧表ByKey(NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter parameter);
    
}
