/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hiroshimadomain;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hiroshimadomain.HiroshimaDomainMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hiroshimadomain.HiroshimaDomainRelateEntity;

/**
 * 広域内転居結果一覧表のマッパーインタフェースです。
 *
 *
 */
public interface IHiroshimaDomainMapper {

    /**
     * 広域内転居結果一覧表の転入転出異動情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link HiroshimaDomainRelateEntity}
     */
    List<HiroshimaDomainRelateEntity> get転入転出異動情報(HiroshimaDomainMybatisParameter 検索条件);
}
