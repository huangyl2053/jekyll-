/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * 特別徴収依頼金額明細一覧表のEntityクラスです。
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class FukaJohoPsmChoshuRelateEntity {

    private DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity;
    private DbT2001ChoshuHohoEntity 徴収方法Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名PSM;
    private UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報;
}
