/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.standard.business.helper;

import jp.co.ndensan.reams.db.dba.standard.definition.valueobject.SaikofuJiyu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * 再交付事由のMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public class SaikofuJiyuMock {

    private SaikofuJiyuMock() {
    }

    public static SaikofuJiyu getSpiedInstance() {
        SaikofuJiyu 再交付事由 = new SaikofuJiyu(new RString("コード"), new RString("名称"));
        return spy(再交付事由);
    }
}
