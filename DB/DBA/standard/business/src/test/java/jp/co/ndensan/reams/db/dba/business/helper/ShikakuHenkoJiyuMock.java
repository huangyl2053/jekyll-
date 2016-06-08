/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.helper;

import jp.co.ndensan.reams.db.dba.definition.core.valueobject.shikakuhenkojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * 資格変更事由のMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public class ShikakuHenkoJiyuMock {

    private ShikakuHenkoJiyuMock() {
    }

    public static ShikakuHenkoJiyu getSpiedInstance() {
        ShikakuHenkoJiyu 資格変更事由 = new ShikakuHenkoJiyu(new RString("コード"), new RString("名称"));
        return spy(資格変更事由);
    }
}
