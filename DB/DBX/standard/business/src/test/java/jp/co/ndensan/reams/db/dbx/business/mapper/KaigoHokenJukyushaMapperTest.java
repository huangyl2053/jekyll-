/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoHokenJukyusha;
import jp.co.ndensan.reams.db.dbx.business.core.IKobetsuJikoKaigoJukyu;
import jp.co.ndensan.reams.db.dbx.business.mapper.helper.JutogaiYusenCurrentEntityMock;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinchishoKoreishaNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiYukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShogaiKoreiNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.KaigohokenJukyushaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.KaigohokenJukyushaAndKojinEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護保険受給者の変換クラスのテストクラスです
 *
 * @author LDNS 袁国棟
 */
@Ignore //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にIgnore。期限:2015/7末まで。
@RunWith(Enclosed.class)
public class KaigoHokenJukyushaMapperTest extends DbxTestBase {

    public static class toKaigotoKaigoHokenJukyusha extends DbxTestBase {

        @Test
        public void LDNS_引数にリストのサイズが0の場合_toKaigotoKaigoHokenJukyushaは_nullを返す() {
            List<KaigohokenJukyushaAndKojinEntity> entityList = new ArrayList();
            assertNull(KaigoHokenJukyushaMapper.toKaigotoKaigoHokenJukyusha(entityList));
        }

        @Test
        public void LDNS_引数にリストのサイズが2の場合_toKaigotoKaigoHokenJukyushaは_IKaigoHokenJukyushaのインスタンスを返す() {
            KaigohokenJukyushaAndKojinEntity kaigohokenJukyushaAndKojinEntity = createKaigohokenJukyushaAndKojinEntity();
            List<KaigohokenJukyushaAndKojinEntity> entityList = new ArrayList();
            entityList.add(kaigohokenJukyushaAndKojinEntity);
            entityList.add(kaigohokenJukyushaAndKojinEntity);
            assertThat(KaigoHokenJukyushaMapper.toKaigotoKaigoHokenJukyusha(entityList), instanceOf(IKaigoHokenJukyusha.class));
        }

        @Test
        public void LDNS_引数にKaigohokenJukyushaAndKojinEntityを指定した場合_toKaigotoKaigoHokenJukyushaは_IKaigoHokenJukyushaのインスタンスを返す() {
            assertThat(KaigoHokenJukyushaMapper.toKaigotoKaigoHokenJukyusha(
                    createKaigohokenJukyushaAndKojinEntity()), instanceOf(IKaigoHokenJukyusha.class));
        }
    }

    public static class toKaigotoKaigoHokenJukyushaList extends DbxTestBase {

        @Test
        public void LDNS_引数にリストのサイズが0の場合_toKaigotoKaigoHokenJukyushaListは_サイズが0のリストを返す() {
            List<KaigohokenJukyushaAndKojinEntity> entityList = new ArrayList();
            assertThat(KaigoHokenJukyushaMapper.toKaigotoKaigoHokenJukyushaList(entityList).size(), is(0));
        }

        @Test
        public void LDNS_引数にリストのサイズが2の場合_toKaigotoKaigoHokenJukyushaListは_サイズが2のリストを返す() {
            KaigohokenJukyushaAndKojinEntity kaigohokenJukyushaAndKojinEntity = createKaigohokenJukyushaAndKojinEntity();
            List<KaigohokenJukyushaAndKojinEntity> entityList = new ArrayList();
            entityList.add(kaigohokenJukyushaAndKojinEntity);
            entityList.add(kaigohokenJukyushaAndKojinEntity);
            assertThat(KaigoHokenJukyushaMapper.toKaigotoKaigoHokenJukyushaList(entityList).size(), is(2));
        }
    }

    public static class toKobetsuJikoKaigoJukyu extends DbxTestBase {

        @Test
        public void LDNS_引数に介護受給者と個人の複合エンティティと基準日を指定した場合_toKobetsuJikoKaigoJukyuは_IKobetsuJikoKaigoJukyuのインスタンスを返す() {
            assertThat(KaigoHokenJukyushaMapper.toKobetsuJikoKaigoJukyu(
                    createKaigohokenJukyushaAndKojinEntity(), RDate.MIN), instanceOf(IKobetsuJikoKaigoJukyu.class));
        }
    }

    public static KaigohokenJukyushaAndKojinEntity createKaigohokenJukyushaAndKojinEntity() {
        KaigohokenJukyushaAndKojinEntity entity = new KaigohokenJukyushaAndKojinEntity();
        entity.setKaigohokenJukyushaEntity(createKaigohokenJukyushaEntity());
        entity.setKojinEntity(JutogaiYusenCurrentEntityMock.getSpiedInstance());
        return entity;
    }

    public static KaigohokenJukyushaEntity createKaigohokenJukyushaEntity() {
        KaigohokenJukyushaEntity entity = new KaigohokenJukyushaEntity();
        entity.setC申請番号(new RString("1"));
        entity.setB介護被保険者番号(RString.EMPTY);
        entity.set申請有効区分(NinteiShinseiYukoKubun.申請中);
        entity.set申請年月日(RDate.MIN);
        entity.set申請時申請区分(NinteiShinseiKubunShinsei.新規申請);
        entity.set法令申請区分(NinteiShinseiKubunHorei.新規申請);
        entity.set認定申請理由(RString.EMPTY);
        entity.set地方自治体コード(new RString("123455"));
        entity.set取下げ区分(TorisageKubun.認定申請有効);
        entity.set依頼年月日(RDate.MIN);
        entity.set実施年月日(RDate.MIN);
        entity.set完了年月日(RDate.MIN);
        entity.set認定調査員コード(RString.EMPTY);
        entity.set認定調査員氏名(RString.EMPTY);
        entity.set調査委託先コード(RString.EMPTY);
        entity.set事業者名称(RString.EMPTY);
        entity.set作成依頼年月日(RDate.MIN);
        entity.set受領年月日(RDate.MIN);
        entity.set障害高齢者生活自立度(ShogaiKoreiNichijoSeikatsuJiritsudo.自立);
        entity.set認知症高齢者生活自立度(NinchishoKoreishaNichijoSeikatsuJiritsudo.自立);
        entity.set一時判定_要介護状態区分(new RString("11"));
        entity.set認知症加算_要介護状態区分(new RString("01"));
        entity.set資料作成年月日(RDate.MIN);
        entity.set開催予定年月日(RDate.MIN);
        entity.set合議体番号(1);
        entity.set回答年月日(RDate.MIN);
        entity.set認定年月日(RDate.MIN);
        entity.set要介護状態区分(new RString("12"));
        entity.set有効開始年月日(RDate.MIN);
        entity.set有効終了年月日(RDate.MAX);
        entity.set審査会意見(RString.EMPTY);
        entity.set異動年月日(RDate.MIN);
        entity.set特定疾病(RString.EMPTY);
        entity.set主治医医師識別コード(RString.HALF_SPACE);
        entity.set主治医氏名(RString.FULL_SPACE);
        entity.set医療機関コード(RString.EMPTY);
        entity.set医療機関名称(RString.EMPTY);
        entity.set判定年月日(RDate.MIN);
        entity.set喪失年月日(RDate.MIN);
        return entity;
    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoHokenJukyushaMapperが呼び出される場合_KaigoHokenJukyushaMapperは_インスタンス化成功() throws Exception {
            Constructor<KaigoHokenJukyushaMapper> constructor = KaigoHokenJukyushaMapper.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }
}
