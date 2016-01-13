/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 *
 * 介護住民票個別事項連携情報作成【広域運用】作成画面divです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJuminhyoKobetsuParameter {

    private RString sakiShichoson;
    private RDate konkaiStSakuseiYMD;
    private RTime konkaiStSakuseiTime;
}
