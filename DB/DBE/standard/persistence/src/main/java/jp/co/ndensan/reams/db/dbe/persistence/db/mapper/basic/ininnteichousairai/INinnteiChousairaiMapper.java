/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.ininnteichousairai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.ninnteichousairai.NinnteiChousairaiEntity;

/**
 * 認定調査依頼情報のマッパーインタフェースです。
 */
public interface INinnteiChousairaiMapper {

    /**
     * 認定調査委託先情報を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return NinnteiChousairaiEntity 要介護認定結果情報Entityクラスです。
     */
    List<NinnteiChousairaiEntity> selectNinnteiChousaItaku(NinnteiChousairaiParameter parametere);

    /**
     * 認定調査委託先一覧を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return NinnteiChousairaiEntity 要介護認定結果情報Entityクラスです。
     */
    List<NinnteiChousairaiEntity> selectItakuSenn(NinnteiChousairaiParameter parametere);
}
