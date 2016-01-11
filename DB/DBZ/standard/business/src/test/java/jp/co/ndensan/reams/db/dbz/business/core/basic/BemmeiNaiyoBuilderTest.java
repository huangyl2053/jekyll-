/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7002BemmeiNaiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link BemmeiNaiyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class BemmeiNaiyoBuilderTest extends DbzTestBase {

    private static DbT7002BemmeiNaiyoEntity BemmeiNaiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShoKisaiHokenshaNo 主キー名1;
    private static ShikibetsuCode 主キー名2;
    private HihokenshaNo 主キー名3;
    private FlexibleDate 主キー名4;
    private FlexibleDate 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static BemmeiNaiyoBuilder sut;
        private static BemmeiNaiyo business;

        @Before
        public void setUp() {
            BemmeiNaiyoEntity = new DbT7002BemmeiNaiyoEntity();
            BemmeiNaiyoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeiNaiyoEntity.setShikibetsuCode(主キー名2);

            business = new BemmeiNaiyo(BemmeiNaiyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の原処分被保険者番号は_設定した値と同じ原処分被保険者番号を返す() {
            business = sut.set原処分被保険者番号(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_原処分被保険者番号).build();
            assertThat(business.get原処分被保険者番号(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_原処分被保険者番号));
        }

        @Test
        public void 戻り値の審査請求届出日は_設定した値と同じ審査請求届出日を返す() {
            business = sut.set審査請求届出日(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_審査請求届出日).build();
            assertThat(business.get審査請求届出日(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_審査請求届出日));
        }

        @Test
        public void 戻り値の弁明書作成日は_設定した値と同じ弁明書作成日を返す() {
            business = sut.set弁明書作成日(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明書作成日).build();
            assertThat(business.get弁明書作成日(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明書作成日));
        }

        @Test
        public void 戻り値の審査請求に係る処分内容は_設定した値と同じ審査請求に係る処分内容を返す() {
            business = sut.set審査請求に係る処分内容(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_審査請求に係る処分内容).build();
            assertThat(business.get審査請求に係る処分内容(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_審査請求に係る処分内容));
        }

        @Test
        public void 戻り値の弁明内容は_設定した値と同じ弁明内容を返す() {
            business = sut.set弁明内容(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明内容).build();
            assertThat(business.get弁明内容(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明内容));
        }

        @Test
        public void 戻り値の弁明書作成日提出日は_設定した値と同じ弁明書作成日提出日を返す() {
            business = sut.set弁明書作成日提出日(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明書作成日提出日).build();
            assertThat(business.get弁明書作成日提出日(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明書作成日提出日));
        }

    }
}
