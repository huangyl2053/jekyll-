/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1006KyokaisoGaitoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link KyokaisoGaitosha}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyokaisoGaitoshaTest extends DbzTestBase {

    private static DbT1006KyokaisoGaitoshaEntity KyokaisoGaitoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyokaisoGaitosha sut;

        @Before
        public void setUp() {
            KyokaisoGaitoshaEntity = new DbT1006KyokaisoGaitoshaEntity();
            KyokaisoGaitoshaEntity.setHihokenshaNo(被保険者番号);
            KyokaisoGaitoshaEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyokaisoGaitosha(null, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyokaisoGaitosha(被保険者番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT1006KyokaisoGaitoshaEntityにセットされている() {
            sut = new KyokaisoGaitosha(被保険者番号, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するKyokaisoGaitoshaIdentifierにセットされている() {
            sut = new KyokaisoGaitosha(被保険者番号, 履歴番号);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyokaisoGaitosha sut;

        @Before
        public void setUp() {
            KyokaisoGaitoshaEntity = new DbT1006KyokaisoGaitoshaEntity();
            KyokaisoGaitoshaEntity.setHihokenshaNo(被保険者番号);
            KyokaisoGaitoshaEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyokaisoGaitosha(null);
        }

        @Test
        public void 指定したDbT1006KyokaisoGaitoshaEntityのキー情報を識別子が持つ() {

            sut = new KyokaisoGaitosha(KyokaisoGaitoshaEntity);

            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyokaisoGaitosha sut;

        @Before
        public void setUp() {
            KyokaisoGaitoshaEntity = new DbT1006KyokaisoGaitoshaEntity();
            KyokaisoGaitoshaEntity.setHihokenshaNo(被保険者番号);
            KyokaisoGaitoshaEntity.setRirekiNo(履歴番号);

            sut = new KyokaisoGaitosha(KyokaisoGaitoshaEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyokaisoGaitoshaEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyokaisoGaitoshaEntity.getRirekiNo()));
        }

        @Test
        public void get適用開始年月日は_entityが持つ適用開始年月日を返す() {
            assertThat(sut.get適用開始年月日(), is(KyokaisoGaitoshaEntity.getTekiyoKaishiYMD()));
        }

        @Test
        public void get適用終了年月日は_entityが持つ適用終了年月日を返す() {
            assertThat(sut.get適用終了年月日(), is(KyokaisoGaitoshaEntity.getTekiyoShuryoYMD()));
        }

        @Test
        public void get境界層措置決定年月日は_entityが持つ境界層措置決定年月日を返す() {
            assertThat(sut.get境界層措置決定年月日(), is(KyokaisoGaitoshaEntity.getKyokaisoSochiKetteiYMD()));
        }

        @Test
        public void get給付額減額記載解除フラグは_entityが持つ給付額減額記載解除フラグを返す() {
            assertThat(sut.get給付額減額記載解除フラグ(), is(KyokaisoGaitoshaEntity.getKyuufugakuGengakuKisaiKiajoFlag()));
        }

        @Test
        public void get標準負担額額該当フラグは_entityが持つ標準負担額額該当フラグを返す() {
            assertThat(sut.get標準負担額額該当フラグ(), is(KyokaisoGaitoshaEntity.getHyojunFutanGengakuGaitoFlag()));
        }

        @Test
        public void get標準負担軽減後負担額は_entityが持つ標準負担軽減後負担額を返す() {
            assertThat(sut.get標準負担軽減後負担額(), is(KyokaisoGaitoshaEntity.getHyojunFutanKeigengoFutangaku()));
        }

        @Test
        public void get居住費等負担額減額該当フラグは_entityが持つ居住費等負担額減額該当フラグを返す() {
            assertThat(sut.get居住費等負担額減額該当フラグ(), is(KyokaisoGaitoshaEntity.getKyojuhinadoFutangakugengakuGaitoFlag()));
        }

        @Test
        public void get居住費軽減後居室種類コードは_entityが持つ居住費軽減後居室種類コードを返す() {
            assertThat(sut.get居住費軽減後居室種類コード(), is(KyokaisoGaitoshaEntity.getKyojuhiKeigengoKyoshitsuShuruiCode()));
        }

        @Test
        public void get居住費軽減後負担額は_entityが持つ居住費軽減後負担額を返す() {
            assertThat(sut.get居住費軽減後負担額(), is(KyokaisoGaitoshaEntity.getKyojuhiKeigengoHutangaku()));
        }

        @Test
        public void get食費負担額減額該当フラグは_entityが持つ食費負担額減額該当フラグを返す() {
            assertThat(sut.get食費負担額減額該当フラグ(), is(KyokaisoGaitoshaEntity.getShokuhiKeigengoHutangakuGaitoFlag()));
        }

        @Test
        public void get食費軽減後負担額は_entityが持つ食費軽減後負担額を返す() {
            assertThat(sut.get食費軽減後負担額(), is(KyokaisoGaitoshaEntity.getShokuhiKeigengoHutangaku()));
        }

        @Test
        public void get高額ｻｰﾋﾞｽ費上限額減額該当フラグは_entityが持つ高額ｻｰﾋﾞｽ費上限額減額該当フラグを返す() {
            assertThat(sut.get高額ｻｰﾋﾞｽ費上限額減額該当フラグ(), is(KyokaisoGaitoshaEntity.getKogakuServicehiJogengakuGengakuGaitoFlag()));
        }

        @Test
        public void get高額ｻｰﾋﾞｽ費減額後上限額は_entityが持つ高額ｻｰﾋﾞｽ費減額後上限額を返す() {
            assertThat(sut.get高額ｻｰﾋﾞｽ費減額後上限額(), is(KyokaisoGaitoshaEntity.getKogakuServicehiJogengakuGengakugoJogengaku()));
        }

        @Test
        public void get保険料納付減額フラグは_entityが持つ保険料納付減額フラグを返す() {
            assertThat(sut.get保険料納付減額フラグ(), is(KyokaisoGaitoshaEntity.getHokenryoNofuGengakuFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyokaisoGaitosha sut;

        @Before
        public void setUp() {
            KyokaisoGaitoshaEntity = new DbT1006KyokaisoGaitoshaEntity();
            KyokaisoGaitoshaEntity.setHihokenshaNo(被保険者番号);
            KyokaisoGaitoshaEntity.setRirekiNo(履歴番号);

            sut = new KyokaisoGaitosha(KyokaisoGaitoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyokaisoGaitoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyokaisoGaitosha sut;

        @Before
        public void setUp() {
            KyokaisoGaitoshaEntity = new DbT1006KyokaisoGaitoshaEntity();
            KyokaisoGaitoshaEntity.setHihokenshaNo(被保険者番号);
            KyokaisoGaitoshaEntity.setRirekiNo(履歴番号);

            sut = new KyokaisoGaitosha(KyokaisoGaitoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyokaisoGaitosha sut;
        private static KyokaisoGaitosha result;

        @Before
        public void setUp() {
            KyokaisoGaitoshaEntity = new DbT1006KyokaisoGaitoshaEntity();
            KyokaisoGaitoshaEntity.setHihokenshaNo(被保険者番号);
            KyokaisoGaitoshaEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void KyokaisoGaitoshaが保持するDbT1006KyokaisoGaitoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyokaisoGaitoshaが保持するDbT1006KyokaisoGaitoshaEntityのEntityDataStateがDeletedに指定されたKyokaisoGaitoshaが返る() {
            sut = TestSupport.setStateKyokaisoGaitosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyokaisoGaitoshaが保持するDbT1006KyokaisoGaitoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyokaisoGaitoshaが保持するDbT1006KyokaisoGaitoshaEntityのEntityDataStateがDeletedに指定されたKyokaisoGaitoshaが返る() {
            sut = TestSupport.setStateKyokaisoGaitosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyokaisoGaitoshaが保持するDbT1006KyokaisoGaitoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyokaisoGaitoshaが保持するDbT1006KyokaisoGaitoshaEntityのEntityDataStateがDeletedに指定されたKyokaisoGaitoshaが返る() {
            sut = TestSupport.setStateKyokaisoGaitosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyokaisoGaitoshaが保持するDbT1006KyokaisoGaitoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyokaisoGaitosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyokaisoGaitosha setStateKyokaisoGaitosha(EntityDataState parentState) {
            KyokaisoGaitoshaEntity.setState(parentState);
            return new KyokaisoGaitosha(KyokaisoGaitoshaEntity);
        }
    }
}
