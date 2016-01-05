/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import jp.co.ndensan.reams.db.dbz.persistence.db.relate.KyotakuKeikakuDac;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3007KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuDacTest {

    private static KyotakuKeikakuDac sut;
    private static DbT3005KyotakuKeikakuTodokedeDac 居宅給付計画届出Dac;
    private static DbT3006KyotakuKeikakuJigyoshaSakuseiDac 居宅給付計画事業者作成Dac;
    private static DbT3007KyotakuKeikakuJikoSakuseiDac 居宅給付計画自己作成Dac;

    private static final HihokenshaNo 計画_被保険者番号1 = new HihokenshaNo("123451");
    private static final HihokenshaNo 計画_被保険者番号2 = new HihokenshaNo("123451");
    private static final HihokenshaNo 計画_被保険者番号3 = new HihokenshaNo("023450");
    private static final HokenshaNo 計画_証記載保険者番号1 = new HokenshaNo("123456");
    private static final HokenshaNo 計画_証記載保険者番号2 = new HokenshaNo("123457");
    private static final ShikibetsuCode 計画_識別コード1 = new ShikibetsuCode("123456789012345");
    private static final ShikibetsuCode 計画_識別コード2 = new ShikibetsuCode("123456789012346");
    private static final FlexibleYearMonth 計画_対象年月1 = new FlexibleYearMonth(new RString("201406"));
    private static final FlexibleYearMonth 計画_対象年月2 = new FlexibleYearMonth(new RString("201407"));
    private static final YMDHMS 計画_処理日時1 = new YMDHMS(new RString("20140101102030"));
    private static final YMDHMS 計画_処理日時2 = new YMDHMS(new RString("20140101102040"));
    private static final Decimal 計画_履歴番号1 = new Decimal(1);
    private static final Decimal 計画_履歴番号2 = new Decimal(2);

    private static final HihokenshaNo 事業者_被保険者番号1 = new HihokenshaNo("123451");
    private static final RString 事業者_被保険者番号2 = new RString("023450");
    private static final RString 事業者_証記載保険者番号1 = new RString("123456");
    private static final RString 事業者_証記載保険者番号2 = new RString("023450");
    private static final ShikibetsuCode 事業者_識別コード1 = new ShikibetsuCode("123456789012345");
    private static final ShikibetsuCode 事業者_識別コード2 = new ShikibetsuCode("023456789012340");
    private static final FlexibleYearMonth 事業者_対象年月1 = new FlexibleYearMonth(new RString("201406"));
    private static final FlexibleYearMonth 事業者_対象年月2 = new FlexibleYearMonth(new RString("201401"));
    private static final YMDHMS 事業者_処理日時1 = new YMDHMS(new RString("20140101102030"));
    private static final YMDHMS 事業者_処理日時2 = new YMDHMS(new RString("20141201102030"));
    private static final FlexibleDate 事業者_適用開始年月 = new FlexibleDate(new RString("20140601"));
    private static final Decimal 事業者_履歴番号1 = new Decimal(1);

    private static final HihokenshaNo 自己_被保険者番号1 = new HihokenshaNo("123451");
    private static final HihokenshaNo 自己_被保険者番号2 = new HihokenshaNo("023450");
    private static final HokenshaNo 自己_証記載保険者番号1 = new HokenshaNo("123457");
    private static final HokenshaNo 自己_証記載保険者番号2 = new HokenshaNo("023450");
    private static final ShikibetsuCode 自己_識別コード1 = new ShikibetsuCode("123456789012346");
    private static final ShikibetsuCode 自己_識別コード2 = new ShikibetsuCode("023456789012340");
    private static final FlexibleYearMonth 自己_対象年月1 = new FlexibleYearMonth(new RString("201407"));
    private static final FlexibleYearMonth 自己_対象年月2 = new FlexibleYearMonth(new RString("201401"));
    private static final YMDHMS 自己_処理日時1 = new YMDHMS(new RString("20140101102040"));
    private static final YMDHMS 自己_処理日時2 = new YMDHMS(new RString("20141201102030"));
    private static final FlexibleDate 自己_適用開始年月 = new FlexibleDate(new RString("20140701"));
    private static final Decimal 自己_履歴番号1 = new Decimal(1);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KyotakuKeikakuDac.class);
        居宅給付計画届出Dac = InstanceProvider.create(DbT3005KyotakuKeikakuTodokedeDac.class);
        居宅給付計画事業者作成Dac = InstanceProvider.create(DbT3006KyotakuKeikakuJigyoshaSakuseiDac.class);
        居宅給付計画自己作成Dac = InstanceProvider.create(DbT3007KyotakuKeikakuJikoSakuseiDac.class);
    }

    public static class select居宅計画履歴一覧By被保険者番号Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT3005(計画_被保険者番号1, 計画_対象年月1, 計画_履歴番号1);
            TestSupport.insertDbT3005(計画_被保険者番号2, 計画_対象年月2, 計画_履歴番号2);

            TestSupport.insertDbT3006(事業者_被保険者番号1, 事業者_対象年月1, 事業者_履歴番号1);

            TestSupport.insertDbT3007(自己_被保険者番号1, 自己_対象年月1, 自己_履歴番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select居宅計画履歴一覧By被保険者番号(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            IItemList<DbT3005KyotakuKeikakuTodokedeEntity> modelList = sut.select居宅計画履歴一覧By被保険者番号(計画_被保険者番号1);
            assertThat(modelList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getHihokenshaNo(), is(自己_被保険者番号1));
            assertThat(modelList.toList().get(1).getHihokenshaNo(), is(自己_被保険者番号2));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.select居宅計画履歴一覧By被保険者番号(計画_被保険者番号3).isEmpty(), is(true));
        }
    }

    private static class TestSupport {

        public static void insertDbT3005(
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth 対象年月,
                Decimal 履歴番号) {
            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setTaishoYM(対象年月);
            entity.setRirekiNo(履歴番号);
            居宅給付計画届出Dac.save(entity);
        }

        public static void insertDbT3006(
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth 対象年月,
                Decimal 履歴番号) {
            DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
            entity.setHihokenshano(被保険者番号);
            entity.setTaishoYM(対象年月);
            entity.setRirekiNo(履歴番号);
            居宅給付計画事業者作成Dac.save(entity);
        }

        public static void insertDbT3007(
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth 対象年月,
                Decimal 履歴番号) {
            DbT3007KyotakuKeikakuJikoSakuseiEntity entity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setTaishoYM(対象年月);
            entity.setRirekiNo(履歴番号);
            居宅給付計画自己作成Dac.save(entity);
        }
    }

}
