/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者異動連絡票関連共有子DivのSpecです。
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public enum JukyushaIdoRenrakuhyoSpec implements IPredicate<JukyushaIdoRenrakuhyoDiv> {

    /**
     * 異動日の必須チェックです。
     */
    異動日の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    FlexibleDate 異動日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
                    return (異動日 == null || 異動日.toString().isEmpty());
                }
            },
    /**
     * 異動区分の必須チェックです。
     */
    異動区分の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoDiv div) {
                    RString 異動区分 = div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun().getSelectedKey();
                    return RString.isNullOrEmpty(異動区分);
                }
            };
}
