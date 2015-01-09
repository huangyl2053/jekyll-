/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.DbT1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 * {@link HihokenshaDaichoFinder}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoFinderBaseTest {

    private static HihokenshaDaichoFinderBase<HihokenshaDaichoModel> sut;
    private static final int 情報なし_0件 = 0;
    private static final int 情報あり_1件 = 1;
    private static final int 情報あり_2件 = 2;

    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private static final HihokenshaNo 被保険者番号 = new HihokenshaNo("1234567890");
    private static final YMDHMS 処理日時 = new YMDHMS("20140328000000");
    private static final LasdecCode notFound市町村コード = new LasdecCode("987654");

    private static HihokenshaDaichoDac createDacMock(int kensu) {
        HihokenshaDaichoDac 被保険者台帳dac = Mockito.mock(HihokenshaDaichoDac.class);
        ItemList<DbT1001HihokenshaDaichoEntity> entityList = ItemList.of(new ArrayList<DbT1001HihokenshaDaichoEntity>());
        DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityMock.createWithKey(市町村コード, 被保険者番号, 処理日時);
        entityList.added(entity);
        if (kensu == 情報あり_2件) {
            entity.setSaikofuKubun(new RString("2"));
            entityList.added(entity);
        }
//        when(被保険者台帳dac.selectByKey(市町村コード)).thenReturn(entityList);
        when(被保険者台帳dac.selectByKey(市町村コード, 被保険者番号)).thenReturn(entityList);
//        when(被保険者台帳dac.selectByKey(市町村コード, 被保険者番号, 処理日時)).thenReturn(entity);
        return 被保険者台帳dac;
    }

    public static class find被保険者台帳 extends DbaTestBase {
        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
    }

    public static class find被保険者台帳List_市町村コード_被保険者番号を引数で受け取る場合 extends DbaTestBase {

        //TODO #52997
        @Test
        public void 該当の連絡先情報がない時_get連絡先情報リストは_空のリストを返す() {

            sut = new HihokenshaDaichoFinderBase<>(createDacMock(情報なし_0件));
            IItemList<HihokenshaDaichoModel> result = sut.find被保険者台帳List(notFound市町村コード, 被保険者番号);
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 該当の連絡先情報が１件存在する時_get連絡先情報リストは_１件のデータを返す() {

            sut = new HihokenshaDaichoFinderBase<>(createDacMock(情報あり_1件));

            IItemList<HihokenshaDaichoModel> result = sut.find被保険者台帳List(市町村コード, 被保険者番号);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 該当の連絡先情報が２件存在する時_get連絡先情報リストは_２件のデータを返す() {

            sut = new HihokenshaDaichoFinderBase(createDacMock(情報あり_2件));
            IItemList<HihokenshaDaichoModel> result = sut.find被保険者台帳List(市町村コード, 被保険者番号);
            assertThat(result.size(), is(2));
        }
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
        //
        //例：
        //1, 3件のListを返すMockDacを用意。
        //2, MockDacをテスト用コンストラクタに渡して、HihokenshaDaichoFinderのインスタンスを生成。
        //3, get被保険者台帳Listを実行して、3件のListが返るかを確認する。
    }

    public static class find被保険者台帳List_市町村コード_識別コードを引数で受け取る場合 extends DbaTestBase {
        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
    }

    public static class find被保険者台帳List__市町村コード_被保険者番号_資格取得日を引数で受け取る場合 extends DbaTestBase {
        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
    }

}
