/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshohoshushokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshohoshushokai.IkenshoHoshuShokaiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenshoHoshuShokaiRelateEntity;

/**
 * 意見書作成報酬照会のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public interface IIkenshoHoshuShokaiRelateMapper {

    /**
     * 合計額リストの作成です。
     *
     * @param ikenshoParam IkenshoHoshuShokaiMapperParameter
     * @return List&lt;IkenshoHoshuShokaiRelateEntity&gt;
     */
    List<IkenshoHoshuShokaiRelateEntity> select合計額リスト(IkenshoHoshuShokaiMapperParameter ikenshoParam);

    /**
     * レコード数を取得します。
     *
     * @param ikenshoParam IkenshoHoshuShokaiMapperParameter
     * @return 検索条件に満たすレコード数
     */
    int getCount(IkenshoHoshuShokaiMapperParameter ikenshoParam);
}
