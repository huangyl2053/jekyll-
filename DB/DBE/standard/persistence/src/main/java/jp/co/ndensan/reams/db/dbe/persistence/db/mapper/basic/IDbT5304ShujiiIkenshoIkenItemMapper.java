/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author n3509
 */
public interface IDbT5304ShujiiIkenshoIkenItemMapper {

    /**
     * selectBy申請書管理番号の処理です。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param iraiRirekiNo 依頼履歴番号
     * @return List<DbT5304ShujiiIkenshoIkenItemEntity>
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> select主治医意見書(@Param("申請書管理番号") ShinseishoKanriNo shinseishoKanriNo, @Param("依頼履歴番号") int iraiRirekiNo);

}
