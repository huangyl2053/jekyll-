/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * KaigoJigyoshaEntityを生成するためのMockクラスです
 *
 * @author N8187 久保田 英男
 */
public final class KaigoJigyoshaEntityMock {

    private KaigoJigyoshaEntityMock() {
    }

    public static KaigoJigyoshaEntity getSpiedInstance() {
        return spy(new KaigoJigyoshaEntity(
                new RString("123456"),
                new RDate("20130101"),
                new RDate("20140101"),
                new RString("1234567"),
                new RString("テスト事業者略称"),
                new RString("テストジギョウシャリャクショウ"),
                new RString("テストジュウショカナ"),
                new RString("異動事由"),
                new RDate("20131231"),
                new RString("社会福祉法人軽減対象区分"),
                new RString("地域差区分"),
                new RString("受領委任区分"),
                new RString("生活保護指定区分"),
                new RString("法人種別"),
                new RDate("20130201"),
                new RDate("20130301"),
                new RDate("20130401"),
                new RDate("20130501")));
    }
}
