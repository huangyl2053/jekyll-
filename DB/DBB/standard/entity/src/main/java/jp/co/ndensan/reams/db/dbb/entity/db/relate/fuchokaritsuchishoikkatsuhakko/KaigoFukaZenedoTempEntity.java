/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteitsuchishohakko.TmpIdoFukaJohoEntity;

/**
 * 異動賦課情報一時テーブル
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoFukaZenedoTempEntity implements Cloneable, Serializable {

    private FukaJohoZenendoTmpEntity 介護賦課前年度;
    private TmpIdoFukaJohoEntity 異動賦課情報一時テーブル;
}
