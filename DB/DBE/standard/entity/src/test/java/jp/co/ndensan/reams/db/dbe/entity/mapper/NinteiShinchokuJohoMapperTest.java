/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgress;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ConsentToEnkitsuchiHakko;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoMock.*;

/**
 * 認定進捗情報を変換するMapperのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteiShinchokuJohoMapperTest extends TestBase {

    public static class toNinteiShinchokuJoho extends TestBase {

        YokaigoninteiProgress sut;

        @Override
        public void setUp() {
            sut = NinteiShinchokuJohoMapper.toNinteiShinchokuJoho(create認定進捗情報Entity());
        }

        @Test(expected = NullPointerException.class)
        public void 引数がnullのとき_NullPointerExceptionが発生する() {
            sut = NinteiShinchokuJohoMapper.toNinteiShinchokuJoho(null);
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_申請書管理番号が_同一になる() {
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_認定申請情報登録年月日が_同一になる() {
            assertThat(sut.get認定申請情報登録年月日(), is(認定申請情報登録年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_認定延期通知発行に対する同意有無が_同一になる() {
            assertThat(sut.has認定延期通知発行に対する同意有無(), is(ConsentToEnkitsuchiHakko.toValue(認定延期通知発行に対する同意有無)));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_認定延期通知発行年月日が_同一になる() {
            assertThat(sut.get認定延期通知発行年月日(), is(認定延期通知発行年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_認定延期通知発行回数が_同一になる() {
            assertThat(sut.get認定延期通知発行回数(), is(認定延期通知発行回数));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_要介護認定延期理由が_同一になる() {
            assertThat(sut.get要介護認定延期理由(), is(要介護認定延期理由));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_要介護認定一次判定情報抽出年月日が_同一になる() {
            assertThat(sut.get要介護認定一次判定情報抽出年月日(), is(要介護認定一次判定情報抽出年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_依頼情報データ送信年月日が_同一になる() {
            assertThat(sut.get依頼情報データ送信年月日(), is(依頼情報データ送信年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_認定調査依頼完了年月日が_同一になる() {
            assertThat(sut.get認定調査依頼完了年月日(), is(認定調査依頼完了年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_認定調査完了年月日が_同一になる() {
            assertThat(sut.get認定調査完了年月日(), is(認定調査完了年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_主治医意見書作成依頼完了年月日が_同一になる() {
            assertThat(sut.get主治医意見書作成依頼完了年月日(), is(主治医意見書作成依頼完了年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_主治医意見書登録完了年月日が_同一になる() {
            assertThat(sut.get主治医意見書登録完了年月日(), is(主治医意見書登録完了年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_要介護認定一次判定完了年月日が_同一になる() {
            assertThat(sut.get要介護認定一次判定完了年月日(), is(要介護認定一次判定完了年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_要介護認定1_5次判定完了年月日が_同一になる() {
            assertThat(sut.get要介護認定1_5次判定完了年月日(), is(要介護認定1_5次判定完了年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_認定審査会割当完了年月日が_同一になる() {
            assertThat(sut.get認定審査会割当完了年月日(), is(認定審査会割当完了年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_認定審査会完了年月日が_同一になる() {
            assertThat(sut.get認定審査会完了年月日(), is(認定審査会完了年月日));
        }

        @Test
        public void 渡されたentityと_Mapping後の認定進捗情報の_センター送信年月日が_同一になる() {
            assertThat(sut.getセンター送信年月日(), is(センター送信年月日));
        }
    }

    public static class toNinteiShinchokuJohoEntity extends TestBase {

        DbT5005NinteiShinchokuJohoEntity sut;

        @Override
        public void setUp() {
            sut = NinteiShinchokuJohoMapper.toNinteiShinchokuJohoEntity(create認定進捗情報());
        }

        @Test(expected = NullPointerException.class)
        public void 引数がnullのとき_NullPointerExceptionが発生する() {
            sut = NinteiShinchokuJohoMapper.toNinteiShinchokuJohoEntity(null);
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_申請書管理番号が_同一になる() {
            assertThat(sut.getShinseishoKanriNo(), is(申請書管理番号));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_認定申請情報登録年月日が_同一になる() {
            assertThat(sut.getNinteiShinseiJohoTorokuYMD(), is(認定申請情報登録年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_認定延期通知発行に対する同意有無が_同一になる() {
            assertThat(sut.isEnkitsuchiDoiUmuKubun(), is(認定延期通知発行に対する同意有無));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_認定延期通知発行年月日が_同一になる() {
            assertThat(sut.getEnkitsuchiHakkoYMD(), is(認定延期通知発行年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_認定延期通知発行回数が_同一になる() {
            assertThat(sut.getEnkitsuchiHakkoKaisu(), is(認定延期通知発行回数));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_要介護認定延期理由が_同一になる() {
            assertThat(sut.getNinteiEnkiRuyu(), is(要介護認定延期理由));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_要介護認定一次判定情報抽出年月日が_同一になる() {
            assertThat(sut.getIchijihanteiChushutsuYMD(), is(要介護認定一次判定情報抽出年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_依頼情報データ送信年月日が_同一になる() {
            assertThat(sut.getIraiJohoSoshinYMD(), is(依頼情報データ送信年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_認定調査依頼完了年月日が_同一になる() {
            assertThat(sut.getNinteichosaIraiKanryoYMD(), is(認定調査依頼完了年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_認定調査完了年月日が_同一になる() {
            assertThat(sut.getNinteichosaKanryoYMD(), is(認定調査完了年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_主治医意見書作成依頼完了年月日が_同一になる() {
            assertThat(sut.getIkenshoSakuseiIraiKanryoYMD(), is(主治医意見書作成依頼完了年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_主治医意見書登録完了年月日が_同一になる() {
            assertThat(sut.getIkenshoTorokuKanryoYMD(), is(主治医意見書登録完了年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_要介護認定一次判定完了年月日が_同一になる() {
            assertThat(sut.getIchijiHanteiKanryoYMD(), is(要介護認定一次判定完了年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_要介護認定1_5次判定完了年月日が_同一になる() {
            assertThat(sut.getIchiGoHanteiKanryoYMD(), is(要介護認定1_5次判定完了年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_認定審査会割当完了年月日が_同一になる() {
            assertThat(sut.getNinteiShinsakaiWariateKanryoYMD(), is(認定審査会割当完了年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_認定審査会完了年月日が_同一になる() {
            assertThat(sut.getNinteiShinsakaiKanryoYMD(), is(認定審査会完了年月日));
        }

        @Test
        public void 渡された認定進捗情報と_Mapping後の認定進捗情報エンティティの_センター送信年月日が_同一になる() {
            assertThat(sut.getCenterSoshinYMD(), is(センター送信年月日));
        }
    }
}
