/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidogennendotsuchisyoikatsuhako;

import java.io.Serializable;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * 特徴仮算定一時テーブルから情報を取得するEntityクラスです。
 *
 * @reamsid_L DBB-0880-040 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TmpIdoGennendoKarisanteiEntity implements Serializable {

    private FukaJohoRelateEntity 賦課の情報_更正後;
    private DbT2001ChoshuHohoEntity 徴収方法;
    private FukaJohoRelateEntity 今年度賦課情報;
    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者_追加含む_情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;
    private CaFt703FindNokumiEntity 納組;
}
