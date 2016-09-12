/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufukanrihyoshokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoshokai.KyufuKanrihyoShokaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoshokai.KyufuKanrihyoShokaiEntity;

/**
 * 給付管理票照会（画面）のMapperです。
 *
 * @reamsid_L DBC-2960-060 chenxiangyu
 */
public interface IKyufuKanrihyoShokaiMapper {

    /**
     * 給付管理票一覧を取得します。
     *
     * @param parameter 給付管理票一覧のパラメータ
     * @return List<KyufuKanrihyoShokaiEntity>
     */
    List<KyufuKanrihyoShokaiEntity> select給付管理票一覧(KyufuKanrihyoShokaiMapperParameter parameter);

    /**
     * 給付管理明細一覧を取得します。
     *
     * @param parameter 給付管理明細一覧のパラメータ
     * @return List<KyufuKanrihyoShokaiEntity>
     */
    List<KyufuKanrihyoShokaiEntity> select給付管理明細一覧(KyufuKanrihyoShokaiMapperParameter parameter);
}
