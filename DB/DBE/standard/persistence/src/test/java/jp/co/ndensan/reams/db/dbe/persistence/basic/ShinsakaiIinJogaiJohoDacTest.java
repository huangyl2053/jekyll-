/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会委員除外情報の保存、削除を行うDacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiIinJogaiJohoDacTest {

    private static ShinsakaiIinJogaiJohoDac sut;

    private static ShoKisaiHokenshaNo 証記載保険者番号_123456;
    private static HihokenshaNo 被保険者番号_0123456789;
    private static int 管理番号_1;
    private static ShinsakaiIinCode 審査会委員コード_12345678;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(ShinsakaiIinJogaiJohoDac.class);

        証記載保険者番号_123456 = new ShoKisaiHokenshaNo(new RString("123456"));
        被保険者番号_0123456789 = new HihokenshaNo(new RString("0123456789"));
        管理番号_1 = 1;
        審査会委員コード_12345678 = new ShinsakaiIinCode(new RString("12345678"));
    }

    public static class insertOrUpdateのテスト extends DbeTestDacBase {

        @Test
        public void データが存在しない場合_insertが実行される() {
            int result = sut.insertOrUpdate(ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(
                    証記載保険者番号_123456, 被保険者番号_0123456789, 管理番号_1, 審査会委員コード_12345678));
            assertThat(result, is(1));
        }

        @Test
        public void 同じキー情報を持つデータをinsertOrUpdateした場合_updateが実行される() {
            sut.insert(ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(
                    証記載保険者番号_123456, 被保険者番号_0123456789, 管理番号_1, 審査会委員コード_12345678));
            int result = sut.insertOrUpdate(ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(
                    証記載保険者番号_123456, 被保険者番号_0123456789, 管理番号_1, new ShinsakaiIinCode(new RString("09090909"))));
            assertThat(result, is(1));
        }

    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void insertに成功し_1が返る() {
            int result = sut.insert(ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(
                    証記載保険者番号_123456, 被保険者番号_0123456789, 管理番号_1, 審査会委員コード_12345678));
            assertThat(result, is(1));
        }

    }

    public static class updateのテスト extends DbeTestDacBase {

        @Test
        public void updateに成功し_1が返る() {
            sut.insert(ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(
                    証記載保険者番号_123456, 被保険者番号_0123456789, 管理番号_1, 審査会委員コード_12345678));
            int result = sut.update(ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(
                    証記載保険者番号_123456, 被保険者番号_0123456789, 管理番号_1, new ShinsakaiIinCode(new RString("09090909"))));
            assertThat(result, is(1));
        }

    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Test
        public void deleteに成功し_1が返る() {
            sut.insert(ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(
                    証記載保険者番号_123456, 被保険者番号_0123456789, 管理番号_1, 審査会委員コード_12345678));
            int result = sut.delete(ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(
                    証記載保険者番号_123456, 被保険者番号_0123456789, 管理番号_1, 審査会委員コード_12345678));
            assertThat(result, is(1));
        }

    }

}
