/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshojissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshojissekiichiran.IkenshoJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IkenshoJissekiIchiranRelateEntity;

/**
 * 主治医意見書作成実績集計表のデータ取得のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 *
 */
public interface IIkenshoJissekiIchiranMapper {

    /**
     * 主治医意見書作成実績集計表の取得します。
     *
     * @param mapperParameter 主治医意見書作成実績集計表のMyBatis用パラメータ
     * @return List<IkenshoJissekiIchiranRelateEntity>
     */
    List<IkenshoJissekiIchiranRelateEntity> get主治医意見書作成実績集計表(IkenshoJissekiIchiranMybitisParamter mapperParameter);

}
