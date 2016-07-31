/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko;

import java.io.Serializable;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動賦課情報一時テーブル
 *
 * @reamsid_L DBB-0710-040 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuchoKariTsuchishoIkkatsuHakkoTempEntity implements Cloneable, Serializable {

    private DbT2015KeisangoJohoEntity 計算後情報_更正後;
    private DbT2015KeisangoJohoEntity 計算後情報_更正前;
    private UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報_更正後;
    private UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報_更正前;
    private UaFt200FindShikibetsuTaishoEntity 宛名識別対象;
    private UaFt250FindAtesakiEntity 宛先;
    private UaFt250FindAtesakiEntity 宛先代納;
    private CaFt703FindNokumiEntity 納組;
    private KozaRelateEntity 口座;
    private FukaJohoRelateEntity 賦課情報;
    private RString 代納人氏名;
    private RString 生活保護区分;
}
