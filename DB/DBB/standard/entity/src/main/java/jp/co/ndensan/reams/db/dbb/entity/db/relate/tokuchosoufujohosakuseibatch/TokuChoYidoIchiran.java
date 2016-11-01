/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の特別徴収異動情報一覧表の発行の発行のクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TokuChoYidoIchiran {

    private UeT0511NenkinTokuchoKaifuJohoEntity 特徴異動追加情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;
    private CaFt703FindNokumiEntity 納組;
}
