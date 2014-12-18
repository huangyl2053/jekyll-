/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5001NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5002NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.relate.NinteiShinseiKekkaModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5001NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5002NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiShinseiKekkaDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteiShinseiKekkaDacTest {

    private static NinteiShinseiKekkaDac sut;
    private static DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private static DbT5001NinteiShinseiJohoDac 要介護認定申請情報Dac;
    private static DbT5002NinteiKekkaJohoDac 要介護認定結果情報Dac;
    private static final ShoKisaiHokenshaNo 受給者_証記載保険者番号1 = new ShoKisaiHokenshaNo("124560");
    private static final ShoKisaiHokenshaNo 受給者_証記載保険者番号2 = new ShoKisaiHokenshaNo("124561");
    private static final HihokenshaNo 受給者_被保険者番号1 = new HihokenshaNo("1234567890");
    private static final HihokenshaNo 受給者_被保険者番号2 = new HihokenshaNo("1234567891");
    private static final ShinseishoKanriNo 受給者_申請書管理番号1 = new ShinseishoKanriNo("2234567890");
    private static final ShinseishoKanriNo 受給者_申請書管理番号2 = new ShinseishoKanriNo("2234567891");
    private static final YMDHMS 受給者_処理日時1 = new YMDHMS("20140101102040");
    private static final YMDHMS 受給者_処理日時2 = new YMDHMS("20140101102030");

    private static final RString 申請_申請書管理番号1 = new RString("2234567890");
    private static final RString 申請_申請書管理番号2 = new RString("2234567891");
    private static final YMDHMS 申請_処理日時1 = new YMDHMS("20140101102040");
    private static final YMDHMS 申請_処理日時2 = new YMDHMS("20140101102030");

    private static final RString 結果_申請書管理番号1 = new RString("2234567890");
    private static final RString 結果_申請書管理番号2 = new RString("2234567891");
    private static final YMDHMS 結果_処理日時1 = new YMDHMS("20140101102040");
    private static final YMDHMS 結果_処理日時2 = new YMDHMS("20140101102030");
    private static final FlexibleDate 結果_要介護認定取消年月日 = FlexibleDate.EMPTY;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(NinteiShinseiKekkaDac.class);
        受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        要介護認定申請情報Dac = InstanceProvider.create(DbT5001NinteiShinseiJohoDac.class);
        要介護認定結果情報Dac = InstanceProvider.create(DbT5002NinteiKekkaJohoDac.class);
    }

    public static class select要介護認定申請結果ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT4001(受給者_証記載保険者番号1, 受給者_被保険者番号1, 受給者_申請書管理番号1, 受給者_処理日時1);
            TestSupport.insertDbT4001(受給者_証記載保険者番号1, 受給者_被保険者番号1, 受給者_申請書管理番号2, 受給者_処理日時2);

            TestSupport.insertDbT5001(申請_申請書管理番号1, 申請_処理日時1);
            TestSupport.insertDbT5001(申請_申請書管理番号2, 申請_処理日時2);

            TestSupport.insertDbT5002(結果_申請書管理番号1, 結果_処理日時1, 結果_要介護認定取消年月日);
            TestSupport.insertDbT5002(結果_申請書管理番号2, 結果_処理日時2, 結果_要介護認定取消年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select要介護認定申請結果履歴By被保険者番号(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            IItemList<NinteiShinseiKekkaModel> modelList = sut.select要介護認定申請結果履歴By被保険者番号(受給者_被保険者番号1);
            assertThat(modelList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).get要介護認定申請情報モデル().get().get申請書管理番号(), is(申請_申請書管理番号1));
            assertThat(modelList.toList().get(0).get要介護認定結果情報モデル().get().get申請書管理番号(), is(結果_申請書管理番号1));
            assertThat(modelList.toList().get(1).get要介護認定申請情報モデル().get().get申請書管理番号(), is(申請_申請書管理番号2));
            assertThat(modelList.toList().get(1).get要介護認定結果情報モデル().get().get申請書管理番号(), is(結果_申請書管理番号2));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.select要介護認定申請結果履歴By被保険者番号(受給者_被保険者番号2).isEmpty(), is(true));
        }
    }

    private static class TestSupport {

        public static void insertDbT4001(
                ShoKisaiHokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                ShinseishoKanriNo 申請書管理番号,
                YMDHMS 処理日時) {
            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setShoriTimeStamp(処理日時);
            受給者台帳Dac.insert(entity);
        }

        public static void insertDbT5001(
                RString 申請書管理番号,
                YMDHMS 処理日時) {
            DbT5001NinteiShinseiJohoEntity entity = DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setShoriTimestamp(処理日時);
            要介護認定申請情報Dac.insert(entity);
        }

        public static void insertDbT5002(
                RString 申請書管理番号,
                YMDHMS 処理日時,
                FlexibleDate 要介護認定取消年月日) {
            DbT5002NinteiKekkaJohoEntity entity = DbT5002NinteiKekkaJohoEntityGenerator.createDbT5002NinteiKekkaJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setShoriTimestamp(処理日時);
            entity.setNinteiTorikeshiYMD(要介護認定取消年月日);
            要介護認定結果情報Dac.insert(entity);
        }
    }
}
