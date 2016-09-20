/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.chosajisshishajoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.chosaJisshishaJoho.ChosaJisshishaMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査実施者情報の検索します。
 * @reamsid_L DBE-3000-100 dongyabin
 */
public interface IChosaJisshishaJohoMapper {
    
    /**
     * 所属機関のデータソースを取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return List<DbT5910NinteichosaItakusakiJohoEntity>
     */
    List<DbT5910NinteichosaItakusakiJohoEntity> getSyozokuKikan(RString shinseishoKanriNo); 
    
    /**
     * 記入者のデータソースを取得します。
     * @param paramer ChosaJisshishaMapperParameter
     * @return List<DbT5913ChosainJohoEntity>
     */
    List<DbT5913ChosainJohoEntity> getKinyusha(ChosaJisshishaMapperParameter paramer);
    
    /**
     * 記入者の初期値を取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return List<DbT5913ChosainJohoEntity>
     */
    List<DbT5913ChosainJohoEntity> getKinyushaEmpty(RString shinseishoKanriNo);
}
