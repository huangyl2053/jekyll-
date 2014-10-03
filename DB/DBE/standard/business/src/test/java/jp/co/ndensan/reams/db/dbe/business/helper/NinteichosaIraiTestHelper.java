/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.MobileDataShutsuryoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaTokusokuHoho;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.chosahyoTouShutsuryokuYMD;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.chousainCode;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.iraishoShutsuryokuYMD;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.mobileDataShutsuryokuFlag;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichosaIraiKaisu;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichosaIraiRirekiNo;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichosaIraiYMD;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichosaItakusakiCode;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichosaKigenYMD;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichosaTokusokuHoho;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichosaTokusokuKaisu;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichosaTokusokuMemo;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichosaTokusokuYMD;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.ninteichousaIraiKubunCode;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.shinseishoKanriNo;

/**
 * モデルパッケージ作成時にエラーになったため仮作成。対応するときに考える。
 *
 * @author N3317 塚田 萌
 */
public class NinteichosaIraiTestHelper {

    /**
     * テスト用認定調査依頼情報を返します。
     *
     * @return 認定調査依頼情報
     */
    public static NinteichosaIrai create認定調査依頼情報() {

        return new NinteichosaIrai(shinseishoKanriNo, ninteichosaIraiRirekiNo,
                ninteichosaItakusakiCode, chousainCode,
                NinteichosaIraiKubun.toValue(ninteichousaIraiKubunCode), ninteichosaIraiKaisu,
                ninteichosaIraiYMD.toRDate(), ninteichosaKigenYMD.toRDate(),
                iraishoShutsuryokuYMD.toRDate(), chosahyoTouShutsuryokuYMD.toRDate(),
                MobileDataShutsuryoku.toValue(mobileDataShutsuryokuFlag), ninteichosaTokusokuYMD.toRDate(),
                NinteichosaTokusokuHoho.toValue(ninteichosaTokusokuHoho),
                ninteichosaTokusokuKaisu, ninteichosaTokusokuMemo);
    }

}
