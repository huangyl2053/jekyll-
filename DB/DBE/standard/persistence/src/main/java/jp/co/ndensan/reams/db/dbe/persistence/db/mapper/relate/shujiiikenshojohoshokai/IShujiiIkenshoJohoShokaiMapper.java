/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshojohoshokai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshojohoshokai.ShujiiIkenshoJohoShokaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 主治医意見書情報照会マッパーインターフェース
 * 
 * @author n3213
 */
public interface IShujiiIkenshoJohoShokaiMapper {
    
    /**
     * selectBy申請書管理番号の処理です。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param iraiRirekiNo 依頼履歴番号
     * @return List<ShujiiIkenshoIkenItemEntity>
     */
    ShujiiIkenshoJohoShokaiEntity select主治医意見書情報(@Param("申請書管理番号") RString shinseishoKanriNo, @Param("依頼履歴番号") int iraiRirekiNo);
    
}
