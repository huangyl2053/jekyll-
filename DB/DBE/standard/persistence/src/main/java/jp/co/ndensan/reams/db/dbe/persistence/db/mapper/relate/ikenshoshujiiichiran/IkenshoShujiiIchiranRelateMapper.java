/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshoshujiiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshoshujiiichiran.IkenshoShujiiIchiranMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoshujiiichiran.IkenshoShujiiIchiranRelateEntity;

/**
 * 主治医医療機関・主治医一覧表のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0260-030 zuotao
 */
public interface IkenshoShujiiIchiranRelateMapper {

    /**
     * 主治医医療機関・主治医一覧表を取得します。
     *
     * @param parameter 主治医一覧表検索条件
     * @return IkenshoShujiiIchiranRelateEntity 検索結果の{@link IkenshoShujiiIchiranRelateEntity}
     */
    List<IkenshoShujiiIchiranRelateEntity> getIkenshoShujiiIchiranRelateEntity(IkenshoShujiiIchiranMybatisParameter parameter);
}
