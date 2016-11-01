/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 特別徴収依頼金額明細一覧表情報クラスです。
 *
 * @reamsid_L DBB-0930-020 xuzhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuIraikingakuMeisaiIchiranDataEntity {

    private DbT2002FukaJohoTempTableEntity 賦課の情報一時テーブル;
    private DbT2001ChoshuHohoEntity 徴収方法Newest;
    private UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名PSMの戻り値;
}
