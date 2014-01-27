/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.standard.business.helper;

import jp.co.ndensan.reams.db.dba.standard.definition.valueobject.HihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * 被保険者区分のMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaKubunMock {

    private HihokenshaKubunMock() {
    }

    public static HihokenshaKubun getSpiedInstance() {
        HihokenshaKubun 被保険者区分 = new HihokenshaKubun(new RString("コード"), new RString("名称"));
        return spy(被保険者区分);
    }
}
