/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosahyojissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosahyojissekiichiran.ChosahyoJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.ChosahyoJissekiIchiranRelateEntity;

/**
 * 帳票出力用認定調査実績集計表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1691-020 dangjingjing
 */
public interface IChosahyoJissekiIchiranMapper {

    /**
     * 帳票出力用認定調査実績集計表の取得します。
     *
     * @param mapperParameter 帳票出力用認定調査実績集計表のMyBatis用パラメータ
     * @return List<ChosahyoJissekiIchiranEntity>
     */
    List<ChosahyoJissekiIchiranRelateEntity> get帳票出力用認定調査実績集計表(ChosahyoJissekiIchiranMybitisParamter mapperParameter);

}
