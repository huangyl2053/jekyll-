/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKyukaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaishiTime;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会詳細情報Mapperのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiDetailMapperTest {

    public static class to審査会情報のテスト extends DbeTestBase {

        private ShinsakaiDetail result;
        private DbT5101ShinsakaiJohoEntity 審査会情報Entity;
        private ShinsakaiKaisaiBasho 開催場所;
        private GogitaiDetail 合議体情報;

        @Before
        public void setUp() {
            審査会情報Entity = ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990101", "A001");
            開催場所 = ShinsakaiTestBusinessCreator.create審査会開催場所("A001");
            合議体情報 = ShinsakaiTestBusinessCreator.create合議体情報(22);
            result = ShinsakaiDetailMapper.to審査会情報(審査会情報Entity, 開催場所, 合議体情報);
        }

        @Test
        public void 審査会情報Entityにnullが渡されたとき_nullが返る() {
            result = ShinsakaiDetailMapper.to審査会情報(null, 開催場所, 合議体情報);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 開催場所にnullが渡されたとき_nullが返る() {
            result = ShinsakaiDetailMapper.to審査会情報(審査会情報Entity, null, 合議体情報);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 合議体情報にnullが渡されたとき_nullが返る() {
            result = ShinsakaiDetailMapper.to審査会情報(審査会情報Entity, 開催場所, null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会開催番号は_1になる() {
            assertThat(result.get審査会開催番号().value(), is(1));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会開催年月日は_19990101になる() {
            assertThat(result.get審査会開催年月日().value(), is(new FlexibleDate("19990101")));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会開始時間は_0830になる() {
            assertThat(result.get審査会開始時間(), is(new ShinsakaiKaishiTime(new TimeString("0830"))));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会終了時間は_1720になる() {
            assertThat(result.get審査会終了時間(), is(new TimeString(new RString("1720"))));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_合議体情報の合議体番号は_22になる() {
            assertThat(result.get合議体情報().get合議体番号().value(), is(22));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_開催場所の開催場所コードは_A001になる() {
            assertThat(result.get開催場所().get開催場所コード().value(), is(new RString("A001")));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会予定定員は_6になる() {
            assertThat(result.get審査会予定定員(), is(6));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会最大定員は_7になる() {
            assertThat(result.get審査会最大定員(), is(7));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会自動割当定員は_8になる() {
            assertThat(result.get審査会自動割当定員(), is(8));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会委員定員は_9になる() {
            assertThat(result.get審査会委員定員(), is(9));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_精神科医師存在区分は_存在になる() {
            assertThat(result.get精神科医師存在区分(), is(GogitaiSeishinkaIshiSonzaiKubun.存在));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_ダミー区分は_正規になる() {
            assertThat(result.getダミー区分(), is(GogitaiDummyKubun.正規));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会資料作成年月日は_になる() {
            assertThat(result.get審査会資料作成年月日(), is(new FlexibleDate("20090101")));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_休会区分は_開催になる() {
            assertThat(result.get休会区分(), is(ShinsakaiKyukaiKubun.開催));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会割当済み人数は_になる() {
            assertThat(result.get審査会割当済み人数(), is(5));
        }
    }

    public static class to審査会情報Entityのテスト extends DbeTestBase {

        private ShinsakaiDetail 審査会情報;
        private DbT5101ShinsakaiJohoEntity result;

        @Before
        public void setUp() {
            審査会情報 = ShinsakaiTestBusinessCreator.create審査会情報(1, "19990101");
            result = ShinsakaiDetailMapper.to審査会情報Entity(審査会情報);
        }

        @Test
        public void 審査会情報にnullが渡されたとき_nullが返る() {
            assertThat(ShinsakaiDetailMapper.to審査会情報Entity(null), is(nullValue()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_審査会開催番号は_1になる() {
            assertThat(result.getShinsakaiKaisaiNo(), is(1));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_審査会開始年月日は_19990101になる() {
            assertThat(result.getShinsakaiKaisaiYMD(), is(new FlexibleDate("19990101")));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_審査会開始時間は_0000になる() {
            assertThat(result.getShinsakaiKaishiTime(), is(new RString("0000")));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_審査会終了時間は_2359になる() {
            assertThat(result.getShinsakaiShuryoTime(), is(new RString("2359")));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_開催場所の開催場所コードは_1になる() {
            assertThat(result.getShinsakaiKaisaiBashoCode(), is(new RString("A001")));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_合議体情報の合議体番号は_1になる() {
            assertThat(result.getGogitaiNo(), is(1));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_予定定員は_になる() {
            assertThat(result.getShinsakaiYoteiTeiin(), is(6));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_最大定員は_になる() {
            assertThat(result.getShinsakaiSaidaiTeiin(), is(7));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_割当定員は_になる() {
            assertThat(result.getShinsakaiJidoWariateTeiin(), is(8));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_委員定員は_になる() {
            assertThat(result.getShinsakaiIinTeiin(), is(9));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_精神科医師存在フラグは_trueになる() {
            assertThat(result.getGogitaiSeishinkaiSonzaiFlag(), is(true));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_ダミーフラグは_trueになる() {
            assertThat(result.getGogitaiDummyFlag(), is(true));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_資料作成年月日は_19800101になる() {
            assertThat(result.getShinsakaiShiryoSakuseiYMD(), is(new FlexibleDate("19800101")));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_休会フラグは_trueになる() {
            assertThat(result.getShinsakaiKyukaiFlag(), is(true));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_割当済み人数は_10になる() {
            assertThat(result.getShinsakaiWariateZumiNinzu(), is(10));
        }
    }
}
