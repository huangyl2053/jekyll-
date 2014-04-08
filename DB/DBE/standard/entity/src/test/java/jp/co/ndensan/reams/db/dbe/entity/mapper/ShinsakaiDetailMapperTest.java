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
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
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

    private static ShinsakaiKaisaiNo 開催番号_1 = new ShinsakaiKaisaiNo(1);
    private static ShinsakaiKaisaiDate 開催年月日_19990101 = new ShinsakaiKaisaiDate(new FlexibleDate("19990101"));
    private static GogitaiNo 合議体番号_22 = new GogitaiNo(22);
    private static ShinsakaiKaishiTime 開始時間_0830 = new ShinsakaiKaishiTime(new TimeString("0830"));
    private static TimeString 終了時間_1730 = new TimeString("1730");
    private static ShinsakaiKaisaiBashoCode 開催場所番号_A001 = new ShinsakaiKaisaiBashoCode(new RString("A001"));
    private static int 審査会予定定員_6 = 6;
    private static int 審査会最大定員_7 = 7;
    private static int 審査会自動割当定員_8 = 8;
    private static int 審査会委員定員_9 = 9;
    private static GogitaiSeishinkaIshiSonzaiKubun 精神科医存在区分_存在 = GogitaiSeishinkaIshiSonzaiKubun.存在;
    private static GogitaiDummyKubun 合議体ダミー区分_正規 = GogitaiDummyKubun.正規;
    private static ShinsakaiKyukaiKubun 休会区分_開催 = ShinsakaiKyukaiKubun.開催;
    private static FlexibleDate 審査会資料作成年月日_20090101 = new FlexibleDate("20090101");
    private static int 審査会割当済み人数_5 = 5;

    public static class to審査会情報のテスト extends DbeTestBase {

        private ShinsakaiDetail result;
        private DbT5101ShinsakaiJohoEntity 審査会情報Entity;
        private ShinsakaiKaisaiBasho 開催場所;
        private GogitaiDetail 合議体情報;

        @Before
        public void setUp() {
            審査会情報Entity = ShinsakaiTestEntityCreator.create審査会情報Entity(開催番号_1, 開催年月日_19990101,
                    合議体番号_22, 開始時間_0830, 終了時間_1730, 開催場所番号_A001, 審査会予定定員_6, 審査会最大定員_7,
                    審査会自動割当定員_8, 審査会委員定員_9, 精神科医存在区分_存在, 合議体ダミー区分_正規, 休会区分_開催,
                    審査会資料作成年月日_20090101, 審査会割当済み人数_5);
            開催場所 = ShinsakaiTestBusinessCreator.create審査会開催場所(開催場所番号_A001.value().toString());
            合議体情報 = ShinsakaiTestBusinessCreator.create合議体情報(合議体番号_22.value());
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
            assertThat(result.get審査会開催番号().value(), is(開催番号_1.value()));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会開催年月日は_19990101になる() {
            assertThat(result.get審査会開催年月日().value(), is(開催年月日_19990101.value()));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会開始時間は_0830になる() {
            assertThat(result.get審査会開始時間(), is(開始時間_0830));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会終了時間は_1720になる() {
            assertThat(result.get審査会終了時間(), is(終了時間_1730));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_合議体情報の合議体番号は_22になる() {
            assertThat(result.get合議体情報().get合議体番号().value(), is(合議体番号_22.value()));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_開催場所の開催場所コードは_A001になる() {
            assertThat(result.get開催場所().get開催場所コード(), is(開催場所番号_A001));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会予定定員は_6になる() {
            assertThat(result.get審査会予定定員(), is(審査会予定定員_6));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会最大定員は_7になる() {
            assertThat(result.get審査会最大定員(), is(審査会最大定員_7));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会自動割当定員は_8になる() {
            assertThat(result.get審査会自動割当定員(), is(審査会自動割当定員_8));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会委員定員は_9になる() {
            assertThat(result.get審査会委員定員(), is(審査会委員定員_9));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_精神科医師存在区分は_存在になる() {
            assertThat(result.get精神科医師存在区分(), is(精神科医存在区分_存在));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_ダミー区分は_正規になる() {
            assertThat(result.getダミー区分(), is(合議体ダミー区分_正規));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会資料作成年月日は_20090101になる() {
            assertThat(result.get審査会資料作成年月日(), is(審査会資料作成年月日_20090101));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_休会区分は_開催になる() {
            assertThat(result.get休会区分(), is(休会区分_開催));
        }

        @Test
        public void to審査会情報で返された審査会情報が持つ_審査会割当済み人数は_5になる() {
            assertThat(result.get審査会割当済み人数(), is(審査会割当済み人数_5));
        }
    }

    public static class to審査会情報Entityのテスト extends DbeTestBase {

        private ShinsakaiDetail 審査会情報;
        private DbT5101ShinsakaiJohoEntity result;

        @Before
        public void setUp() {
            審査会情報 = new ShinsakaiDetail(開催番号_1, 開催年月日_19990101, 開始時間_0830, 終了時間_1730,
                    ShinsakaiTestBusinessCreator.create合議体情報(合議体番号_22.value()),
                    ShinsakaiTestBusinessCreator.create審査会開催場所(開催場所番号_A001.value().toString()),
                    審査会予定定員_6, 審査会最大定員_7, 審査会自動割当定員_8, 審査会委員定員_9,
                    精神科医存在区分_存在, 合議体ダミー区分_正規, 審査会資料作成年月日_20090101, 休会区分_開催, 審査会割当済み人数_5);
            result = ShinsakaiDetailMapper.to審査会情報Entity(審査会情報);
        }

        @Test
        public void 審査会情報にnullが渡されたとき_nullが返る() {
            assertThat(ShinsakaiDetailMapper.to審査会情報Entity(null), is(nullValue()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_審査会開催番号は_1になる() {
            assertThat(result.getShinsakaiKaisaiNo(), is(開催番号_1.value()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_審査会開始年月日は_19990101になる() {
            assertThat(result.getShinsakaiKaisaiYMD(), is(開催年月日_19990101.value()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_審査会開始時間は_0830になる() {
            assertThat(result.getShinsakaiKaishiTime(), is(開始時間_0830.toRString()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_審査会終了時間は_1730になる() {
            assertThat(result.getShinsakaiShuryoTime(), is(終了時間_1730.value()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_開催場所の開催場所コードは_1になる() {
            assertThat(result.getShinsakaiKaisaiBashoCode(), is(開催場所番号_A001.value()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_合議体情報の合議体番号は_1になる() {
            assertThat(result.getGogitaiNo(), is(合議体番号_22.value()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_予定定員は_6になる() {
            assertThat(result.getShinsakaiYoteiTeiin(), is(審査会予定定員_6));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_最大定員は_7になる() {
            assertThat(result.getShinsakaiSaidaiTeiin(), is(審査会最大定員_7));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_割当定員は_8になる() {
            assertThat(result.getShinsakaiJidoWariateTeiin(), is(審査会自動割当定員_8));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_委員定員は_9になる() {
            assertThat(result.getShinsakaiIinTeiin(), is(審査会委員定員_9));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_精神科医師存在フラグは_存在を表すtrueになる() {
            assertThat(result.getGogitaiSeishinkaiSonzaiFlag(), is(精神科医存在区分_存在.is存在()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_ダミーフラグは_正規を表すfalseになる() {
            assertThat(result.getGogitaiDummyFlag(), is(合議体ダミー区分_正規.isダミー()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_資料作成年月日は_20090101になる() {
            assertThat(result.getShinsakaiShiryoSakuseiYMD(), is(審査会資料作成年月日_20090101));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_休会フラグは_開催を表すfalseになる() {
            assertThat(result.getShinsakaiKyukaiFlag(), is(休会区分_開催.is休会()));
        }

        @Test
        public void 戻り値の審査会情報Entityが持つ_割当済み人数は_5になる() {
            assertThat(result.getShinsakaiWariateZumiNinzu(), is(審査会割当済み人数_5));
        }
    }
}
