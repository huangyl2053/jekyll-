/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護資格のファクトリークラスのテストクラスです。
 *
 * @author LDNS 梁百川
 */
@RunWith(Enclosed.class)
public class KaigoShikakuFactoryTest extends DbxTestBase {

    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("123");
    private static final HokenShubetsu 保険種別 = HokenShubetsu.国民健康保険;
    private static final RDate 資格取得届出年月日 = new RDate(2014, 10, 20);
    private static final RDate 資格取得年月日 = new RDate(2014, 10, 21);
    private static final ShikakuShutokuJiyu 資格取得事由 = new ShikakuShutokuJiyu(Code.EMPTY, RString.EMPTY, RString.EMPTY);
    private static final RDate 資格喪失届出年月日 = new RDate(2014, 11, 20);
    private static final RDate 資格喪失年月日 = new RDate(2014, 11, 21);
    private static final ShikakuSoshitsuJiyu 資格喪失事由 = new ShikakuSoshitsuJiyu(Code.EMPTY, RString.EMPTY, RString.EMPTY);
    private static final RString 被保険者番号 = new RString("123456");
    private static final RString 介護保険広域構成市町村コード = new RString("111");
    private static final RDate 一号該当日 = new RDate(2014, 11, 25);
    private static final ShikakuHihokenshaKubun 資格被保険者区分 = ShikakuHihokenshaKubun.第１号被保険者;
    private static final JushochiTokureishaKubun 住所地特例者区分 = JushochiTokureishaKubun.住所地特例者;

    public static class createInstanceのテスト extends DbxTestBase {

        @Test
        public void LDNS_createInstanceは_実体が_KaigoShikakuのインスタンスを返す() {
            IKaigoShikaku result = KaigoShikakuFactory.createInstance(識別コード, 保険種別, 資格取得届出年月日, 資格取得年月日, 資格取得事由, 資格喪失届出年月日, 資格喪失年月日, 資格喪失事由, 被保険者番号, 介護保険広域構成市町村コード, 一号該当日, 資格被保険者区分, 住所地特例者区分);
            assertThat(result, instanceOf(_KaigoShikaku.class));
        }

    }

}
