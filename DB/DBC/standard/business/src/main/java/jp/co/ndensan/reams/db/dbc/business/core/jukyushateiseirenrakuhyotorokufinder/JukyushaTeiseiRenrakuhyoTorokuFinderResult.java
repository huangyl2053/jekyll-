/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jukyushateiseirenrakuhyotorokufinder;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCZB00001_受給者異動情報変更箇所判定
 *
 * @reamsid_L DBC-2101-050 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaTeiseiRenrakuhyoTorokuFinderResult {

    private JukyushaIdoRenrakuhyo 受給者異動送付entity;
    private RString 氏名_性別_生年月日を印字する;
    private FlexibleDate 作成年月日;
    private Boolean 公費負担上限額減額有フラグ;
    private Boolean 小多機能居宅介護利用開始月利用有フラグ;
}
