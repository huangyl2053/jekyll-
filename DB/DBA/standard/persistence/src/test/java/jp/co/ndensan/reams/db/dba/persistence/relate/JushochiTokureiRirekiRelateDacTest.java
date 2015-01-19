/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.relate;

import jp.co.ndensan.reams.db.dba.model.relate.shikakuido.JushochiTokureiModel;
import jp.co.ndensan.reams.db.dbz.definition.util.Lists;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase.JushochiTokureiRirekiRelateDac}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiRirekiRelateDacTest extends DbaTestDacBase {

    private static JushochiTokureiRirekiRelateDac sut;
    private static JushochiTokureiModel target;
    private static int result;
    private static DbT1001HihokenshaDaichoDac hihoDaichoDac;
    private static DbT1004ShisetsuNyutaishoDac nyutaishoDac;

    private static HihokenshaDaichoModel hihoDaicho1;
    private static HihokenshaDaichoModel hihoDaicho2;
    private static HihokenshaDaichoModel hihoDaicho3;
    private static HihokenshaDaichoModel hihoDaicho4;
    private static HihokenshaDaichoModel hihoDaicho5;

    private static ShisetsuNyutaishoModel nyutaisho1;
    private static ShisetsuNyutaishoModel nyutaisho2;
    private static ShisetsuNyutaishoModel nyutaisho3;
    private static ShisetsuNyutaishoModel nyutaisho4;
    private static ShisetsuNyutaishoModel nyutaisho5;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(JushochiTokureiRirekiRelateDac.class);
        hihoDaichoDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        nyutaishoDac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);

        hihoDaicho1 = createHihoDaichoModel(EntityDataState.Unchanged, ShoriTimestamp.of(new YMDHMS("20141214010000")));
        hihoDaichoDac.insert(hihoDaicho1.getEntity());
        hihoDaicho2 = createHihoDaichoModel(EntityDataState.Unchanged, ShoriTimestamp.of(new YMDHMS("20141214020000")));
        hihoDaichoDac.insert(hihoDaicho2.getEntity());
        hihoDaicho3 = createHihoDaichoModel(EntityDataState.Unchanged, ShoriTimestamp.of(new YMDHMS("20141214030000")));
        hihoDaichoDac.insert(hihoDaicho3.getEntity());
        hihoDaicho4 = createHihoDaichoModel(EntityDataState.Unchanged, ShoriTimestamp.of(new YMDHMS("20141214040000")));
        hihoDaichoDac.insert(hihoDaicho4.getEntity());

        nyutaisho1 = createNyutaishoModel(EntityDataState.Unchanged, ShoriTimestamp.of(new YMDHMS("20141214010000")));
        nyutaishoDac.insert(nyutaisho1.getEntity());
        nyutaisho2 = createNyutaishoModel(EntityDataState.Unchanged, ShoriTimestamp.of(new YMDHMS("20141214020000")));
        nyutaishoDac.insert(nyutaisho2.getEntity());
        nyutaisho3 = createNyutaishoModel(EntityDataState.Unchanged, ShoriTimestamp.of(new YMDHMS("20141214030000")));
        nyutaishoDac.insert(nyutaisho3.getEntity());
        nyutaisho4 = createNyutaishoModel(EntityDataState.Unchanged, ShoriTimestamp.of(new YMDHMS("20141214040000")));
        nyutaishoDac.insert(nyutaisho4.getEntity());

        hihoDaicho3 = changedHihoDaichoModel(hihoDaicho3, new ShikibetsuCode("111112222233303"));
        hihoDaicho4 = deletedHihoDaichoModel(hihoDaicho4);
        hihoDaicho5 = createHihoDaichoModel(EntityDataState.Added, ShoriTimestamp.of(new YMDHMS("20141214050000")));
        nyutaisho3 = changedNyutaishoModel(nyutaisho3, new JigyoshaNo("1111133303"));
        nyutaisho4 = DeletedNyutaishoModel(nyutaisho4);
        nyutaisho5 = createNyutaishoModel(EntityDataState.Added, ShoriTimestamp.of(new YMDHMS("20141214050000")));

        target = new JushochiTokureiModel(
                Lists.newArrayList(hihoDaicho1, hihoDaicho2, hihoDaicho3, hihoDaicho4, hihoDaicho5),
                Lists.newArrayList(nyutaisho1, nyutaisho2, nyutaisho3, nyutaisho4, nyutaisho5));

        result = sut.update(target);
    }

    public static class update {

        @Test
        public void 合計10件のデータを持ち_内4件のデータのStatusがUnchangedであるModelを保存した場合_戻り値が6となる() {
            assertThat(result, is(6));
        }

        @Test
        public void update対象の被保険者台帳Modelについて_更新後のデータがselectで取得できる() {
            DbT1001HihokenshaDaichoEntity resultEntity = hihoDaichoDac.selectByKey(hihoDaicho3.get市町村コード(),
                    hihoDaicho3.get被保険者番号(), hihoDaicho3.get処理日時());
            assertThat(resultEntity.getShikibetsuCode(), is(hihoDaicho3.get識別コード()));
        }

        @Test
        public void delete対象の被保険者台帳Modelについて_selectで取得できない() {
            DbT1001HihokenshaDaichoEntity resultEntity = hihoDaichoDac.selectByKey(hihoDaicho4.get市町村コード(),
                    hihoDaicho4.get被保険者番号(), hihoDaicho4.get処理日時());
            assertThat(resultEntity, is(nullValue()));
        }

        @Test
        public void insert対象の被保険者台帳Modelについて_selectで取得できる() {
            DbT1001HihokenshaDaichoEntity resultEntity = hihoDaichoDac.selectByKey(hihoDaicho5.get市町村コード(),
                    hihoDaicho5.get被保険者番号(), hihoDaicho5.get処理日時());
            assertThat(resultEntity.getShoriTimestamp(), is(hihoDaicho5.get処理日時()));
        }

        @Test
        public void update対象の施設入退所Modelについて_更新後のデータがselectで取得できる() {
            DbT1004ShisetsuNyutaishoEntity resultEntity = nyutaishoDac.selectByKey(nyutaisho3.get市町村コード(),
                    nyutaisho3.get識別コード(), nyutaisho3.get処理日時());
            assertThat(resultEntity.getNyushoShisetsuCode(), is(nyutaisho3.get入所施設コード()));
        }

        @Test
        public void delete対象の施設入退所Modelについて_selectで取得できない() {
            DbT1004ShisetsuNyutaishoEntity resultEntity = nyutaishoDac.selectByKey(nyutaisho4.get市町村コード(),
                    nyutaisho4.get識別コード(), nyutaisho4.get処理日時());
            assertThat(resultEntity, is(nullValue()));
        }

        @Test
        public void insert対象の施設入退所Modelについて_selectで取得できる() {
            DbT1004ShisetsuNyutaishoEntity resultEntity = nyutaishoDac.selectByKey(nyutaisho5.get市町村コード(),
                    nyutaisho5.get識別コード(), nyutaisho5.get処理日時());
            assertThat(resultEntity.getShoriTimestamp(), is(nyutaisho5.get処理日時()));
        }

    }

    private static JushochiTokureiModel createJutokuModel() {

        return new JushochiTokureiModel(null, null);
    }

    private static HihokenshaDaichoModel createHihoDaichoModel(EntityDataState status, ShoriTimestamp timestamp) {
        HihokenshaDaichoModel creatingModel = new HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntityGenerator.
                createDbT1001HihokenshaDaichoEntity());
        creatingModel.getEntity().setState(status);
        creatingModel.set処理日時(timestamp);
        return creatingModel;
    }

    private static ShisetsuNyutaishoModel createNyutaishoModel(EntityDataState status, ShoriTimestamp timestamp) {
        ShisetsuNyutaishoModel creatingModel = new ShisetsuNyutaishoModel(DbT1004ShisetsuNyutaishoEntityGenerator.
                createDbT1004ShisetsuNyutaishoEntity());
        creatingModel.getEntity().setState(status);
        creatingModel.set処理日時(timestamp.getColumnValue());
        return creatingModel;
    }

    private static HihokenshaDaichoModel changedHihoDaichoModel(HihokenshaDaichoModel targetModel, ShikibetsuCode shikibetsuCode) {
        targetModel.getEntity().setState(EntityDataState.Modified);
        targetModel.set識別コード(shikibetsuCode);
        return targetModel;
    }

    private static HihokenshaDaichoModel deletedHihoDaichoModel(HihokenshaDaichoModel targetModel) {
        targetModel.getEntity().setState(EntityDataState.Deleted);
        return targetModel;
    }

    private static ShisetsuNyutaishoModel changedNyutaishoModel(ShisetsuNyutaishoModel targetModel, JigyoshaNo jigyoshaNo) {
        targetModel.getEntity().setState(EntityDataState.Modified);
        targetModel.set入所施設コード(jigyoshaNo.getColumnValue());
        return targetModel;
    }

    private static ShisetsuNyutaishoModel DeletedNyutaishoModel(ShisetsuNyutaishoModel targetModel) {
        targetModel.getEntity().setState(EntityDataState.Deleted);
        return targetModel;
    }

}
