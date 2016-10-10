/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteitsuchishohakko.TmpIdoFukaJohoEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * 異動賦課情報一時テーブル
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenkenKoseigoJohoTempEntity implements Cloneable, Serializable {

    private UeT0511NenkinTokuchoKaifuJohoEntity 年金特徴回付情報_更正前;
    private TmpIdoFukaJohoEntity 異動賦課情報一時テーブル;
}
