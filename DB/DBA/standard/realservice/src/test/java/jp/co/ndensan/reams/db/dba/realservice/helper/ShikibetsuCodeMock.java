/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice.helper;

import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * 識別コードのMockクラスです。
 *
 * @author N3327 三浦 凌
 */
//TODO n3327 三浦凌 識別コードがドメインクラスとして公開されたら修正する。
public class ShikibetsuCodeMock {

    private ShikibetsuCodeMock() {
    }

    public static IShikibetsuCode getSpiedInstance() {
        IShikibetsuCode 識別コード = new _ShikibetsuCode(new RString("識別コード"));
        return spy(識別コード);
    }

    public static IShikibetsuCode createInstance(RString code) {
        return new _ShikibetsuCode(code);
    }
}
