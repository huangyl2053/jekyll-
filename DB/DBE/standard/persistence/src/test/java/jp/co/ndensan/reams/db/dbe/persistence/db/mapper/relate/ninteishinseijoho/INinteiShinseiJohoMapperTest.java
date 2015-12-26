/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinseijoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5129TennyuShiboEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5590ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5101NinteiShinseiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5102NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5105NinteiKanryoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5115ImageEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5116IchijiHanteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5120ShinseitodokedeJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5121ShinseiRirekiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5122TsuchishoHakkoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5123NinteiKeikakuJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5129TennyuShiboEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5150RenrakusakiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5510IchiGojiHanteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5590ShinsakaiIinJogaiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5115ImageDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5120ShinseitodokedeJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5122TsuchishoHakkoJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5123NinteiKeikakuJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5129TennyuShiboDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5150RenrakusakiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5510IchiGojiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5590ShinsakaiIinJogaiJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link INinteiShinseiJohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class INinteiShinseiJohoMapperTest {

    private static INinteiShinseiJohoMapper sut;
    private static DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac;
    private static DbT5102NinteiKekkaJohoDac 要介護認定結果情報Dac;
    private static DbT5116IchijiHanteiKekkaJohoDac 要介護認定一次判定結果情報Dac;
    private static DbT5105NinteiKanryoJohoDac 要介護認定完了情報Dac;
    private static DbT5115ImageDac イメージ情報Dac;
    private static DbT5120ShinseitodokedeJohoDac 申請届出情報Dac;
    private static DbT5121ShinseiRirekiJohoDac 申請履歴情報Dac;
    private static DbT5122TsuchishoHakkoJohoDac 通知書発行情報Dac;
    private static DbT5123NinteiKeikakuJohoDac 要介護認定計画情報Dac;
    private static DbT5129TennyuShiboDac 転入_死亡情報Dac;
    private static DbT5150RenrakusakiJohoDac 介護連絡先情報Dac;
    private static DbT5510IchiGojiHanteiKekkaJohoDac 要介護認定1_5次判定結果情報Dac;
    private static DbT5590ShinsakaiIinJogaiJohoDac 審査会委員除外情報Dac;
    private static MapperProvider mapperProvider;
    private static final ShinseishoKanriNo 申請書管理番号_1 = DEFAULT_申請書管理番号;
    private static final int 連番_1 = 1;
    private static final int 連番_2 = 2;

    @BeforeClass
    public static void setUpClass() {
        要介護認定申請情報Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        要介護認定結果情報Dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
        要介護認定一次判定結果情報Dac = InstanceProvider.create(DbT5116IchijiHanteiKekkaJohoDac.class);
        要介護認定完了情報Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
        イメージ情報Dac = InstanceProvider.create(DbT5115ImageDac.class);
        申請届出情報Dac = InstanceProvider.create(DbT5120ShinseitodokedeJohoDac.class);
        申請履歴情報Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
        通知書発行情報Dac = InstanceProvider.create(DbT5122TsuchishoHakkoJohoDac.class);
        要介護認定計画情報Dac = InstanceProvider.create(DbT5123NinteiKeikakuJohoDac.class);
        転入_死亡情報Dac = InstanceProvider.create(DbT5129TennyuShiboDac.class);
        介護連絡先情報Dac = InstanceProvider.create(DbT5150RenrakusakiJohoDac.class);
        要介護認定1_5次判定結果情報Dac = InstanceProvider.create(DbT5510IchiGojiHanteiKekkaJohoDac.class);
        審査会委員除外情報Dac = InstanceProvider.create(DbT5590ShinsakaiIinJogaiJohoDac.class);
    }

    public static class getNinteiShinseiJohoEntityTest extends DbeTestDacBase {

        @Before
        public void setUp() {
            mapperProvider = InstanceProvider.create(MapperProvider.class);
            sut = mapperProvider.create(INinteiShinseiJohoMapper.class);
            TestSupport.insertDbT5101(申請書管理番号_1);

            TestSupport.insertDbT5102(申請書管理番号_1);

            TestSupport.insertDbT5116(申請書管理番号_1);

            TestSupport.insertDbT5105(申請書管理番号_1);

            TestSupport.insertDbT5115(申請書管理番号_1);

            TestSupport.insertDbT5120(申請書管理番号_1);

            TestSupport.insertDbT5121(申請書管理番号_1);

            TestSupport.insertDbT5122(申請書管理番号_1);

            TestSupport.insertDbT5123(申請書管理番号_1);

            TestSupport.insertDbT5129(申請書管理番号_1);

            TestSupport.insertDbT5150(申請書管理番号_1, 連番_1);
            TestSupport.insertDbT5150(申請書管理番号_1, 連番_2);

            TestSupport.insertDbT5510(申請書管理番号_1);

            TestSupport.insertDbT5590(申請書管理番号_1, 連番_1);
            TestSupport.insertDbT5590(申請書管理番号_1, 連番_2);

        }

        @Test
        public void データが見つかる検索条件を渡すと_要介護認定申請情報Entity返す() {
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createParam(申請書管理番号_1);
            assertThat(sut.getNinteiShinseiJohoEntity(要介護認定申請情報検索条件).get要介護認定申請情報Entity().getShinseishoKanriNo(), is(申請書管理番号_1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createParam(new ShinseishoKanriNo("2"));
            assertThat(sut.getNinteiShinseiJohoEntity(要介護認定申請情報検索条件), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insertDbT5101(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5101NinteiShinseiJohoEntity entity = DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            要介護認定申請情報Dac.save(entity);
        }

        public static void insertDbT5102(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            要介護認定結果情報Dac.save(entity);
        }

        public static void insertDbT5116(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            要介護認定一次判定結果情報Dac.save(entity);
        }

        public static void insertDbT5105(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5105NinteiKanryoJohoEntity entity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            要介護認定完了情報Dac.save(entity);
        }

        public static void insertDbT5115(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            イメージ情報Dac.save(entity);
        }

        public static void insertDbT5120(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5120ShinseitodokedeJohoEntity entity = DbT5120ShinseitodokedeJohoEntityGenerator.createDbT5120ShinseitodokedeJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            申請届出情報Dac.save(entity);
        }

        public static void insertDbT5121(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5121ShinseiRirekiJohoEntity entity = DbT5121ShinseiRirekiJohoEntityGenerator.createDbT5121ShinseiRirekiJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            申請履歴情報Dac.save(entity);
        }

        public static void insertDbT5122(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5122TsuchishoHakkoJohoEntity entity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            通知書発行情報Dac.save(entity);
        }

        public static void insertDbT5123(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5123NinteiKeikakuJohoEntity entity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            要介護認定計画情報Dac.save(entity);
        }

        public static void insertDbT5129(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5129TennyuShiboEntity entity = DbT5129TennyuShiboEntityGenerator.createDbT5129TennyuShiboEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            転入_死亡情報Dac.save(entity);
        }

        public static void insertDbT5150(
                ShinseishoKanriNo 申請書管理番号,
                int 連番) {
            DbT5150RenrakusakiJohoEntity entity = DbT5150RenrakusakiJohoEntityGenerator.createDbT5150RenrakusakiJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setRenban(連番);
            entity.setState(EntityDataState.Added);
            介護連絡先情報Dac.save(entity);
        }

        public static void insertDbT5510(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5510IchiGojiHanteiKekkaJohoEntity entity = DbT5510IchiGojiHanteiKekkaJohoEntityGenerator.createDbT5510IchiGojiHanteiKekkaJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            要介護認定1_5次判定結果情報Dac.save(entity);
        }

        public static void insertDbT5590(
                ShinseishoKanriNo 申請書管理番号,
                int 連番) {
            DbT5590ShinsakaiIinJogaiJohoEntity entity = DbT5590ShinsakaiIinJogaiJohoEntityGenerator.createDbT5590ShinsakaiIinJogaiJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setRenban(連番);
            entity.setState(EntityDataState.Added);
            審査会委員除外情報Dac.save(entity);
        }
    }

}
