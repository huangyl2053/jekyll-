/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5830001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5830001.NenreiKaikyubetsuYokaigodoJokyoDiv;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 年齢階級別要介護度状況（統計表）画面のチェックロジックです。
 *
 * @reamsid_L DBD-1790-010 donghj
 */
public enum NenreiKaikyubetsuYokaigodoJokyoSpec implements IPredicate<NenreiKaikyubetsuYokaigodoJokyoDiv> {

    /**
     * 行政区コード大小関係チェック
     */
    行政区コード大小関係チェック {
                @Override
                public boolean apply(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
                    GyoseikuCode 開始行政区コード = div.getCcdGyoseikuStart().get行政区コード();
                    GyoseikuCode 終了行政区コード = div.getCcsGyoseikuEnd().get行政区コード();
                    return 開始行政区コード.compareTo(終了行政区コード) <= 0;
                }
            },
    /**
     * 組合コード大小関係チェック
     */
    組合コード大小関係チェック {
                @Override
                public boolean apply(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
                    ChikuCode 開始組合コード = div.getCcdChiku2Start().get地区2コード();
                    ChikuCode 終了組合コード = div.getCcdChiku2End().get地区2コード();
                    return 開始組合コード.compareTo(終了組合コード) <= 0;
                }
            },
    /**
     * 住所コード大小関係チェック
     */
    住所コード大小関係チェック {
                @Override
                public boolean apply(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
                    ChoikiCode 開始住所コード = div.getCcdChoikiStart().get町域コード();
                    ChoikiCode 終了住所コード = div.getCcdChoikiEnd().get町域コード();
                    return 開始住所コード.compareTo(終了住所コード) <= 0;
                }
            };

}
