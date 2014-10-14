/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.helper.YokaigoNinteiShinseiMock;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.YokaigoNinteiShinseiDac;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 * YokaigoNinteiShinseiManagerのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class YokaigoNinteiShinseiManagerTest extends DbzTestBase {

    public static class save extends DbzTestBase {

        private YokaigoNinteiShinseiDac dac;
        private YokaigoNinteiShinseiManager sut;

        @Test
        public void saveは_メンバのDacのinsertOrUpdateが成功したとき_trueを返す() {
            dac = createDacAsInsertOrUpdate(Returns.成功);
            sut = new YokaigoNinteiShinseiManager(dac);
            assertThat(sut.save(YokaigoNinteiShinseiMock.getSpiedInstance()), is(true));
        }

        @Test
        public void saveは_メンバのDacのinsertOrUpdateが失敗したとき_trueを返す() {
            dac = createDacAsInsertOrUpdate(Returns.失敗);
            sut = new YokaigoNinteiShinseiManager(dac);
            assertThat(sut.save(YokaigoNinteiShinseiMock.getSpiedInstance()), is(false));
        }
    }

    enum Returns {

        成功(1), 失敗(0);
        private final int value;

        private Returns(int returnValue) {
            this.value = returnValue;
        }

        int returnValue() {
            return value;
        }
    }

    private static YokaigoNinteiShinseiDac createDacAsInsertOrUpdate(Returns type) {
        YokaigoNinteiShinseiDac dac = mock(YokaigoNinteiShinseiDac.class);
        when(dac.insertOrUpdate(any(DbT5001NinteiShinseiJohoEntity.class))).thenReturn(type.returnValue());
        return dac;
    }
}
