/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * {@link jp.co.ndensan.reams.db.dbb.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity}のマッパーIFです。
 *
 * @reamsid_L DBZ-9999-022 yangchenbing
 */
public interface IUeT0511NenkinTokuchoKaifuJohoMapper {

    /**
     * {@link UeT0511NenkinTokuchoKaifuJohoEntity}を取得します。
     *
     * @return {@link UeT0511NenkinTokuchoKaifuJohoEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> selectAllNoDeleted();

}
