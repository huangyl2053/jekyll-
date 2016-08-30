/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakujohoEntity {

    private RString 資格区分;
    private RString 明細番号;
    private FlexibleDate 資格取得日;
    private FlexibleDate 取得届出日;
    private ShikakuShutokuJiyu 取得事由;
    private FlexibleDate 資格喪失日;
    private FlexibleDate 喪失届出日;
    private ShikakuSoshitsuJiyu 喪失事由;
    private FlexibleDate 変更年月日;
    private FlexibleDate 変更届出日;
    private ShikakuHenkoJiyu 変更事由;
    private FlexibleDate 適用開始日;
    private FlexibleDate 適用届出日;
    private ShikakuJutokuTekiyoJiyu 適用事由;
    private FlexibleDate 解除開始日;
    private FlexibleDate 解除届出日;
    private ShikakuJutokuKaijoJiyu 解除事由;
}
