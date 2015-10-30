/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7002BemmeiNaiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link BemmeiNaiyo}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class BemmeiNaiyoTest extends DbzTestBase {

    private static DbT7002BemmeiNaiyoEntity BemmeiNaiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShoKisaiHokenshaNo 主キー名1;
    private static ShikibetsuCode 主キー名2;
    private static HihokenshaNo 主キー名3;
    private static FlexibleDate 主キー名4;
    private static FlexibleDate 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static BemmeiNaiyo sut;

        @Before
        public void setUp() {
            BemmeiNaiyoEntity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            BemmeiNaiyoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeiNaiyoEntity.setShikibetsuCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new BemmeiNaiyo(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new BemmeiNaiyo(主キー名1, null, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test
        public void 指定したキーが保持するDbT7002BemmeiNaiyoEntityにセットされている() {
            sut = new BemmeiNaiyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.get証記載保険者番号(), is(主キー名1));
            assertThat(sut.get識別コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するBemmeiNaiyoIdentifierにセットされている() {
            sut = new BemmeiNaiyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get識別コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static BemmeiNaiyo sut;

        @Before
        public void setUp() {
            BemmeiNaiyoEntity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            BemmeiNaiyoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeiNaiyoEntity.setShikibetsuCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new BemmeiNaiyo(null);
        }

        @Test
        public void 指定したDbT7002BemmeiNaiyoEntityのキー情報を識別子が持つ() {

            sut = new BemmeiNaiyo(BemmeiNaiyoEntity);

            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get識別コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static BemmeiNaiyo sut;

        @Before
        public void setUp() {
            BemmeiNaiyoEntity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            BemmeiNaiyoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeiNaiyoEntity.setShikibetsuCode(主キー名2);

            sut = new BemmeiNaiyo(BemmeiNaiyoEntity);
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(BemmeiNaiyoEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(BemmeiNaiyoEntity.getShikibetsuCode()));
        }

        @Test
        public void get原処分被保険者番号は_entityが持つ原処分被保険者番号を返す() {
            assertThat(sut.get原処分被保険者番号(), is(BemmeiNaiyoEntity.getGenshobunHihokenshaNo()));
        }

        @Test
        public void get審査請求届出日は_entityが持つ審査請求届出日を返す() {
            assertThat(sut.get審査請求届出日(), is(BemmeiNaiyoEntity.getShinsaseikyuTodokedeYMD()));
        }

        @Test
        public void get弁明書作成日は_entityが持つ弁明書作成日を返す() {
            assertThat(sut.get弁明書作成日(), is(BemmeiNaiyoEntity.getBemmeishoSakuseiYMD()));
        }

        @Test
        public void get審査請求に係る処分内容は_entityが持つ審査請求に係る処分内容を返す() {
            assertThat(sut.get審査請求に係る処分内容(), is(BemmeiNaiyoEntity.getShinsaseikyuKankeiShobunNaiyo()));
        }

        @Test
        public void get弁明内容は_entityが持つ弁明内容を返す() {
            assertThat(sut.get弁明内容(), is(BemmeiNaiyoEntity.getBemmeiNaiyo()));
        }

        @Test
        public void get弁明書作成日提出日は_entityが持つ弁明書作成日提出日を返す() {
            assertThat(sut.get弁明書作成日提出日(), is(BemmeiNaiyoEntity.getBemmeishoSakuseiTeishutsuYMD()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static BemmeiNaiyo sut;

        @Before
        public void setUp() {
            BemmeiNaiyoEntity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            BemmeiNaiyoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeiNaiyoEntity.setShikibetsuCode(主キー名2);

            sut = new BemmeiNaiyo(BemmeiNaiyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(BemmeiNaiyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static BemmeiNaiyo sut;

        @Before
        public void setUp() {
            BemmeiNaiyoEntity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            BemmeiNaiyoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeiNaiyoEntity.setShikibetsuCode(主キー名2);

            sut = new BemmeiNaiyo(BemmeiNaiyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static BemmeiNaiyo sut;
        private static BemmeiNaiyo result;

        @Before
        public void setUp() {
            BemmeiNaiyoEntity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            BemmeiNaiyoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeiNaiyoEntity.setShikibetsuCode(主キー名2);
        }

        @Test
        public void BemmeiNaiyoが保持するDbT7002BemmeiNaiyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりBemmeiNaiyoが保持するDbT7002BemmeiNaiyoEntityのEntityDataStateがDeletedに指定されたBemmeiNaiyoが返る() {
            sut = TestSupport.setStateBemmeiNaiyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void BemmeiNaiyoが保持するDbT7002BemmeiNaiyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりBemmeiNaiyoが保持するDbT7002BemmeiNaiyoEntityのEntityDataStateがDeletedに指定されたBemmeiNaiyoが返る() {
            sut = TestSupport.setStateBemmeiNaiyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void BemmeiNaiyoが保持するDbT7002BemmeiNaiyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりBemmeiNaiyoが保持するDbT7002BemmeiNaiyoEntityのEntityDataStateがDeletedに指定されたBemmeiNaiyoが返る() {
            sut = TestSupport.setStateBemmeiNaiyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void BemmeiNaiyoが保持するDbT7002BemmeiNaiyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateBemmeiNaiyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static BemmeiNaiyo setStateBemmeiNaiyo(EntityDataState parentState) {
            BemmeiNaiyoEntity.setState(parentState);
            return new BemmeiNaiyo(BemmeiNaiyoEntity);
        }
    }
}
