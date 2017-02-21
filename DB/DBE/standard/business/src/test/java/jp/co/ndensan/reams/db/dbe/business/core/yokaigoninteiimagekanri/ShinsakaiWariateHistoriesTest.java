/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri;

import java.util.ArrayList;
import java.util.Arrays;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.DeletableImages;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5502ShinsakaiWariateJohoEntityGenerator.createDbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * {@link ShinsakaiWariateHistories}のテストです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiWariateHistoriesTest {

    public ShinsakaiWariateHistoriesTest() {
    }

    public static class constructor {

        @Test
        public void 引数のEntitiesが空でも_インスタンスが生成される() {
            ShinsakaiWariateHistories sut = new ShinsakaiWariateHistories(new ArrayList<DbT5502ShinsakaiWariateJohoEntity>());
            assertThat(sut.had審査会資料Published(), is(false));
            assertThat(sut.findDeletableImages(), is(DeletableImages.全て));
        }

        @Test
        public void 審査会開催日がnullのEntityは_生成時に除外される() {
            DbT5502ShinsakaiWariateJohoEntity entity = createDbT5502ShinsakaiWariateJohoEntity();
            entity.setShinsakaiKaisaiYMD(null);
            ShinsakaiWariateHistories sut = new ShinsakaiWariateHistories(Arrays.asList(entity));
            assertThat(sut.isEmpty(), is(true));
            assertThat(sut.had審査会資料Published(), is(false));
            assertThat(sut.findDeletableImages(), is(DeletableImages.全て));
        }
    }

    public static class only {

        private DbT5502ShinsakaiWariateJohoEntity entity;
        private ShinsakaiWariateHistories sut;

        @Before
        public void setUp() {
            entity = createDbT5502ShinsakaiWariateJohoEntity();
            sut = new ShinsakaiWariateHistories(Arrays.<DbT5502ShinsakaiWariateJohoEntity>asList(entity));
        }

        @Test
        public void 審査会資料作成日がnullの場合_結果は_false_になる() {
            entity.setShinsakaiShiryoSakuseiYMD(null);
            assertThat(sut.had審査会資料Published(), is(false));
        }

        @Test
        public void 審査会資料作成日がEMPYTの場合_結果は_false_になる() {
            entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.EMPTY);
            assertThat(sut.had審査会資料Published(), is(false));
        }

        @Test
        public void 審査会資料作成日が実在する日付の場合_結果は_false_になる() {
            entity.setShinsakaiShiryoSakuseiYMD(new FlexibleDate("20170101"));
            assertThat(sut.had審査会資料Published(), is(true));
        }

        @Test
        public void 判定結果コードがnullの場合_結果は_全て_になる() {
            entity.setHanteiKekkaCode(null);
            assertThat(sut.findDeletableImages(), is(DeletableImages.全て));
        }

        @Test
        public void 判定結果コードがnull以外の場合_結果は_無し_になる() {
            entity.setHanteiKekkaCode(HanteiKekkaCode.認定.getCode());
            assertThat(sut.findDeletableImages(), is(DeletableImages.無し));
        }
    }

    @RunWith(Theories.class)
    public static class two {

        @DataPoints
        public static Fixture[] pARAMS = {
            // 前回の判定結果が「再審査」「未審査」で、今回が未判定(null)であれば、結果は「全て」
            new Fixture(HanteiKekkaCode.再審査, null, DeletableImages.全て),
            new Fixture(HanteiKekkaCode.未審査, null, DeletableImages.全て),
            // 前回の判定結果が「再調査」で、今回が未判定(null)であれば、やりなおす対象以外のイメージは削除不可
            new Fixture(HanteiKekkaCode.再調査_意見書のみ, null, DeletableImages.意見書のみ),
            new Fixture(HanteiKekkaCode.再調査_調査のみ, null, DeletableImages.調査票のみ),
            new Fixture(HanteiKekkaCode.再調査_調査_意見書, null, DeletableImages.無し),
            // 前回に判定結果に関わらず、最新の割付情報に判定結果があれば、結果は「無し」
            new Fixture(HanteiKekkaCode.再審査, HanteiKekkaCode.認定, DeletableImages.無し),
            new Fixture(HanteiKekkaCode.未審査, HanteiKekkaCode.未審査, DeletableImages.無し),
            new Fixture(HanteiKekkaCode.再調査_意見書のみ, HanteiKekkaCode.再調査_意見書のみ, DeletableImages.無し),
            new Fixture(HanteiKekkaCode.再調査_調査のみ, HanteiKekkaCode.再調査_調査のみ, DeletableImages.無し),
            new Fixture(HanteiKekkaCode.再調査_調査_意見書, HanteiKekkaCode.再調査_調査_意見書, DeletableImages.無し)
        };

        private DbT5502ShinsakaiWariateJohoEntity newest;
        private DbT5502ShinsakaiWariateJohoEntity onceBefore;
        private ShinsakaiWariateHistories sut;

        @Before
        public void setUp() {
            newest = createDbT5502ShinsakaiWariateJohoEntity();
            newest.setShinsakaiKaisaiYMD(new FlexibleDate("20160101"));
            onceBefore = createDbT5502ShinsakaiWariateJohoEntity();
            onceBefore.setShinsakaiKaisaiYMD(new FlexibleDate("20150101"));
            DbT5502ShinsakaiWariateJohoEntity oldest = createDbT5502ShinsakaiWariateJohoEntity();
            oldest.setShinsakaiKaisaiYMD(new FlexibleDate("20140101"));
            sut = new ShinsakaiWariateHistories(Arrays.<DbT5502ShinsakaiWariateJohoEntity>asList(onceBefore, newest, oldest));
        }

        @Test
        public void 最新の割当情報が持つ審査会資料作成日がnullの場合_結果は_false_になる() {
            newest.setShinsakaiShiryoSakuseiYMD(null);
            assertThat(sut.had審査会資料Published(), is(false));
        }

        @Test
        public void 最新の割当情報が持つ審査会資料作成日がEMPYTの場合_結果は_false_になる() {
            newest.setShinsakaiShiryoSakuseiYMD(FlexibleDate.EMPTY);
            assertThat(sut.had審査会資料Published(), is(false));
        }

        @Test
        public void 最新の割当情報が持つ審査会資料作成日が実在する日付の場合_結果は_false_になる() {
            newest.setShinsakaiShiryoSakuseiYMD(new FlexibleDate("20170101"));
            assertThat(sut.had審査会資料Published(), is(true));
        }

        @Theory
        public void 前回の判定結果コードにより削除可能な画像が決定される(Fixture param) {
            onceBefore.setHanteiKekkaCode(param.beforeHanteiKekka);
            newest.setHanteiKekkaCode(param.newestHanteiKekka);
            assertThat(sut.findDeletableImages(), is(param.result));
        }

        public static class Fixture {

            final Code beforeHanteiKekka;
            final Code newestHanteiKekka;
            final DeletableImages result;

            Fixture(HanteiKekkaCode before, HanteiKekkaCode newest, DeletableImages result) {
                this.beforeHanteiKekka = before.getCode();
                this.newestHanteiKekka = newest == null ? null : newest.getCode();
                this.result = result;
            }

        }
    }
}
