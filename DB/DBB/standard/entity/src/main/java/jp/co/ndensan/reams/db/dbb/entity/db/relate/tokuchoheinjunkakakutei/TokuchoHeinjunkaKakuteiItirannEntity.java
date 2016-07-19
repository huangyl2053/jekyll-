/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunkakakutei;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * 特徴平準化確定一覧entity
 *
 * @reamsid_L DBB-0830-050 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeinjunkaKakuteiItirannEntity {

    private FukaTempEntity fukeEntity;
    private DbV2001ChoshuHohoEntity 徴収方法Newest;
    private UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報_介護継承;
    private UaFt200FindShikibetsuTaishoEntity 宛名;

}
