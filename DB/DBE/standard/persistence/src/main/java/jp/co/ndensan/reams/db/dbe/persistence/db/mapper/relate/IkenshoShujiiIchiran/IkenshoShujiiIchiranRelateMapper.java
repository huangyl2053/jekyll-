/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.IkenshoShujiiIchiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshoshujiiichiran.IkenshoShujiiIchiranMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.basic.IkenshoShujiiIchiran.IkenshoShujiiIchiranRelateEntity;

/**
 * 主治医医療機関・主治医一覧表のマッパーインタフェースです。
 */
public interface IkenshoShujiiIchiranRelateMapper {
 
    /**
     * 主治医医療機関・主治医一覧表を取得します。
     *
     * @param 主治医一覧表検索条件 主治医一覧表検索条件
     * @return IkenshoShujiiIchiranRelateEntity 検索結果の{@link IkenshoShujiiIchiranRelateEntity}
     */
    List<IkenshoShujiiIchiranRelateEntity> getIkenshoShujiiIchiranRelateEntity(IkenshoShujiiIchiranMybatisParameter 主治医一覧表検索条件);
}
