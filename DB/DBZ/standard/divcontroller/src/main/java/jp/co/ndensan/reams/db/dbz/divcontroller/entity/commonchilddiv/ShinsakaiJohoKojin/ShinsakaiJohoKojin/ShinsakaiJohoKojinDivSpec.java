/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.service.core.shinsakaijohokojin.ShinsakaiJohoKojinFinder;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 共有子Div「ShinsakaiJohoKojin」のハンドラクラスです。
 *
 * @reamsid_L DBE-3000-070 liangbc
 */
public enum ShinsakaiJohoKojinDivSpec implements IPredicate<ShinsakaiJohoKojinDiv> {

    審査会未割当チェック {

                @Override
                public boolean apply(ShinsakaiJohoKojinDiv div) {
                    return ShinsakaiJohoKojinFinder.createInstance().審査会未割当チェック(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo())) != 0;
                }

            };
}
