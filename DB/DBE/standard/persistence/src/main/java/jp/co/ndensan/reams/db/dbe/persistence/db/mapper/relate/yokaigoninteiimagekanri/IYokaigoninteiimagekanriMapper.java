/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteiimagekanri;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteiimagekanri.ImagekanriJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ管理情報のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1670-010 wangxiaodong
 */
public interface IYokaigoninteiimagekanriMapper {

    /**
     * イメージ管理情報を取得します。
     *
     * @param shinseishoKanriNo RString
     * @return イメージ管理情報のentity
     */
    ImagekanriJohoEntity getImageJoho(RString shinseishoKanriNo);
}
