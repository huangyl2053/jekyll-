/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * ケアマネージャDACクラスのテストクラスです
 *
 * @author LDNS 梁百川
 */
public class DbT7064CareManegerDacTest extends DbxTestDacBase {

    DbT7064CareManegerDac sut = InstanceProvider.create(DbT7064CareManegerDac.class);

    @Test
    public void LDNS_データがありません場合_selectByNumberは_nullを返す() {
        assertThat(sut.selectByNumber(new RString("1")), is(nullValue()));
    }

    @Test
    public void LDNS_データがありません場合_selectByJigyoshaCodeは_サイズが0のリストを返す() {
        assertThat(sut.selectByJigyoshaCode(new KaigoJigyoshaNo("1234567890")).size(), is(0));
    }

}
