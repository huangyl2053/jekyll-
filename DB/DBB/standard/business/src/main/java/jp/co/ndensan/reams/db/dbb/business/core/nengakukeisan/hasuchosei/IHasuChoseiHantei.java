/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;

/**
 * 端数調整判定
 *
 * @author n3336
 */
interface IHasuChoseiHantei {

    boolean judgeHasuu(NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter);
}
