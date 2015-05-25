/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.KaigoKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoKoseiShichosonMaster}のテストクラスです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class KaigoKoseiShichosonMasterTest extends DbzTestBase {

    private static KaigoKoseiShichosonMaster sut;

    public static class getterSetterTest extends DbzTestBase {

        @BeforeClass
        public static void setUp() {
            sut = new KaigoKoseiShichosonMaster(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());
        }

        @Test
        public void 引数に市町村識別IDを設定した場合_市町村識別IDは_市町村識別IDと同じ市町村識別IDを返す() {
            assertThat(sut.get市町村識別ID(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID));
        }

        @Test
        public void 引数に市町村コードを設定した場合_市町村コードは_市町村コードと同じ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 引数に証記載保険者番号を設定した場合_証記載保険者番号は_証記載保険者番号と同じ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 引数に国保連広域内市町村番号を設定した場合_国保連広域内市町村番号は_国保連広域内市町村番号と同じ国保連広域内市町村番号を返す() {
            assertThat(sut.get国保連広域内市町村番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_国保連広域内市町村番号));
        }

        @Test
        public void 引数に市町村名称を設定した場合_市町村名称は_市町村名称と同じ市町村名称を返す() {
            assertThat(sut.get市町村名称(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村名称));
        }

        @Test
        public void 引数に都道府県名称を設定した場合_都道府県名称は_都道府県名称と同じ都道府県名称を返す() {
            assertThat(sut.get都道府県名称(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_都道府県名称));
        }

        @Test
        public void 引数に郡名称を設定した場合_郡名称は_郡名称と同じ郡名称を返す() {
            assertThat(sut.get郡名称(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郡名称));
        }

        @Test
        public void 引数に郵便番号を設定した場合_郵便番号は_郵便番号と同じ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 引数に住所を設定した場合_住所は_住所と同じ住所を返す() {
            assertThat(sut.get住所(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 引数に電話番号を設定した場合_電話番号は_電話番号と同じ電話番号を返す() {
            assertThat(sut.get電話番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 引数に最優先地区コードを設定した場合_最優先地区コードは_最優先地区コードと同じ最優先地区コードを返す() {
            assertThat(sut.get最優先地区コード(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_最優先地区コード));
        }

        @Test
        public void 引数に帳票用都道府県名称を設定した場合_帳票用都道府県名称は_帳票用都道府県名称と同じ帳票用都道府県名称を返す() {
            assertThat(sut.get帳票用都道府県名称表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用都道府県名称表示有無));
        }

        @Test
        public void 引数に帳票用郡名称表示有無を設定した場合_帳票用郡名称表示有無は_帳票用郡名称表示有無と同じ帳票用郡名称表示有無を返す() {
            assertThat(sut.get帳票用郡名称表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用郡名称表示有無));
        }

        @Test
        public void 引数に帳票用市町村名称表示有無を設定した場合_帳票用市町村名称表示有無号は_帳票用市町村名称表示有無と同じ帳票用市町村名称表示有無を返す() {
            assertThat(sut.get帳票用市町村名称表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用市町村名称表示有無));
        }

        @Test
        public void 引数に帳票用住所編集方法を設定した場合_帳票用住所編集方法は_帳票用住所編集方法と同じ帳票用住所編集方法を返す() {
            assertThat(sut.get帳票用住所編集方法(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用住所編集方法));
        }

        @Test
        public void 引数に帳票用方書表示有無を設定した場合_帳票用方書表示有無は_帳票用方書表示有無と同じ帳票用方書表示有無を返す() {
            assertThat(sut.get帳票用方書表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用方書表示有無));
        }

        @Test
        public void 引数に外国人氏名表示方法を設定した場合_外国人氏名表示方法は外国人氏名表示方法と同じ外国人氏名表示方法を返す() {
            assertThat(sut.get外国人氏名表示方法(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_外国人氏名表示方法));
        }

        @Test
        public void 引数に老人保健市町村番号を設定した場合_老人保健市町村番号は老人保健市町村番号と同じ老人保健市町村番号を返す() {
            assertThat(sut.get老人保健市町村番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_老人保健市町村番号));
        }

        @Test
        public void 引数に老人保健受給者番号体系を設定した場合_老人保健受給者番号体系は老人保健受給者番号体系と同じ老人保健受給者番号体系を返す() {
            assertThat(sut.get老人保健受給者番号体系(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_老人保健受給者番号体系));
        }

        @Test
        public void 引数に特徴分配集約を設定した場合_特徴分配集約は特徴分配集約と同じ特徴分配集約を返す() {
            assertThat(sut.get特徴分配集約(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_特徴分配集約));
        }

        @Test
        public void 引数に移行日を設定した場合_移行日は移行日と同じ移行日を返す() {
            assertThat(sut.get移行日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_移行日));
        }

        @Test
        public void 引数に加入日を設定した場合_加入日は加入日と同じ加入日を返す() {
            assertThat(sut.get加入日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_加入日));
        }

        @Test
        public void 引数に離脱日を設定した場合_離脱日は離脱日と同じ離脱日を返す() {
            assertThat(sut.get離脱日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_離脱日));
        }

        @Test
        public void 引数に合併旧市町村区分を設定した場合_合併旧市町村区分は合併旧市町村区分と同じ合併旧市町村区分を返す() {
            assertThat(sut.get合併旧市町村区分(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併旧市町村区分));
        }

        @Test
        public void 引数に合併旧市町村表示有無を設定した場合_合併旧市町村表示有無は合併旧市町村表示有無と同じ合併旧市町村表示有無を返す() {
            assertThat(sut.get合併旧市町村表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併旧市町村表示有無));
        }

        @Test
        public void 引数に合併情報地域番号を設定した場合_合併情報地域番号は合併情報地域番号と同じ合併情報地域番号を返す() {
            assertThat(sut.get合併情報地域番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併情報地域番号));
        }

        @Test
        public void 引数に合運用保険者番号を設定した場合_運用保険者番号は運用保険者番号と同じ運用保険者番号を返す() {
            assertThat(sut.get運用保険者番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用保険者番号));
        }

        @Test
        public void 引数に運用開始日を設定した場合_運用開始日は運用開始日と同じ運用開始日を返す() {
            assertThat(sut.get運用開始日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用開始日));
        }

        @Test
        public void 引数に運用終了日を設定した場合_運用終了日は運用終了日と同じ運用終了日を返す() {
            assertThat(sut.get運用終了日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用終了日));
        }

        @Test
        public void 引数に運用形態区分を設定した場合_運用形態区分は運用形態区分と同じ運用形態区分を返す() {
            assertThat(sut.get運用形態区分(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用形態区分));
        }
    }

    public static class BuilderTest extends DbzTestBase {

        @Test
        public void setShichosonShokibetsuIDで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setShichosonShokibetsuID(new RString("1")).build();
            assertThat(result.get市町村識別ID(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID));
        }

        @Test
        public void setShichosonCodeで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setShichosonCode(new LasdecCode(new RString("012345"))).build();
            assertThat(result.get市町村コード(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void setShoKisaiHokenshaNoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("2"))).build();
            assertThat(result.get証記載保険者番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void setKokuhorenKoikiShichosonNoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setKokuhorenKoikiShichosonNo(new RString("1")).build();
            assertThat(result.get国保連広域内市町村番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_国保連広域内市町村番号));
        }

        @Test
        public void setShichosonMeishoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setShichosonMeisho(new RString("1")).build();
            assertThat(result.get市町村名称(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村名称));
        }

        @Test
        public void setTodofukenMeishoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setTodofukenMeisho(new RString("1")).build();
            assertThat(result.get都道府県名称(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_都道府県名称));
        }

        @Test
        public void setGunMeishoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setGunMeisho(new RString("1")).build();
            assertThat(result.get郡名称(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郡名称));
        }

        @Test
        public void setYubinNoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setYubinNo(new YubinNo(new RString("123-1234"))).build();
            assertThat(result.get郵便番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void setJushoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setJusho(new AtenaJusho("申請書記載住所")).build();
            assertThat(result.get住所(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void setTelNoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setTelNo(new TelNo("012-345-6789")).build();
            assertThat(result.get電話番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void setYusenChikuCodeで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setYusenChikuCode(new RString("1")).build();
            assertThat(result.get最優先地区コード(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_最優先地区コード));
        }

        @Test
        public void setTyohyoTodoufukenHyojiUmuで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setTyohyoTodoufukenHyojiUmu(new RString("1")).build();
            assertThat(result.get帳票用都道府県名称表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用都道府県名称表示有無));
        }

        @Test
        public void setTyohyoGunHyojiUmuで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setTyohyoGunHyojiUmu(new RString("1")).build();
            assertThat(result.get帳票用郡名称表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用市町村名称表示有無));
        }

        @Test
        public void setTyohyoShichosonHyojiUmuで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setTyohyoShichosonHyojiUmu(new RString("1")).build();
            assertThat(result.get帳票用市町村名称表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用市町村名称表示有無));
        }

        @Test
        public void setTyohyoJushoHenshuHouhouで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setTyohyoJushoHenshuHouhou(new RString("1")).build();
            assertThat(result.get帳票用住所編集方法(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用住所編集方法));
        }

        @Test
        public void setTyohyoKatagakiHyojiUmuで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setTyohyoKatagakiHyojiUmu(new RString("1")).build();
            assertThat(result.get帳票用方書表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用方書表示有無));
        }

        @Test
        public void setGaikokujinHyojiHouhouで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setGaikokujinHyojiHouhou(new RString("1")).build();
            assertThat(result.get外国人氏名表示方法(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_外国人氏名表示方法));
        }

        @Test
        public void setRojinhokenShichosonNoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setRojinhokenShichosonNo(new RString("1")).build();
            assertThat(result.get老人保健市町村番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_老人保健市町村番号));
        }

        @Test
        public void setRokenJukyushaNoTaikeiで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setRokenJukyushaNoTaikei(new RString("1")).build();
            assertThat(result.get老人保健受給者番号体系(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_老人保健受給者番号体系));
        }

        @Test
        public void setTokuchoBunpaishuyakuで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setTokuchoBunpaishuyaku(new RString("1")).build();
            assertThat(result.get特徴分配集約(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_特徴分配集約));
        }

        @Test
        public void setIkoYMDで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setIkoYMD(new FlexibleDate("20150522")).build();
            assertThat(result.get移行日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_移行日));
        }

        @Test
        public void setKanyuYMDで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setKanyuYMD(new FlexibleDate("20150522")).build();
            assertThat(result.get加入日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_加入日));
        }

        @Test
        public void setRidatsuYMDで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setRidatsuYMD(new FlexibleDate("20150522")).build();
            assertThat(result.get離脱日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_離脱日));
        }

        @Test
        public void setGappeiKyuShichosonKubunで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setGappeiKyuShichosonKubun(new RString("1")).build();
            assertThat(result.get合併旧市町村区分(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併旧市町村区分));
        }

        @Test
        public void setGappeiKyuShichosonHyojiUmuで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setGappeiKyuShichosonHyojiUmu(new RString("1")).build();
            assertThat(result.get合併旧市町村表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併旧市町村表示有無));
        }

        @Test
        public void setGappeiChiikiNoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setGappeiChiikiNo(new RString("1")).build();
            assertThat(result.get合併情報地域番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併情報地域番号));
        }

        @Test
        public void setUnyoHokenshaNoで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setUnyoHokenshaNo(new ShoKisaiHokenshaNo("2")).build();
            assertThat(result.get運用保険者番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用保険者番号));
        }

        @Test
        public void setUnyoKaishiYMDで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setUnyoKaishiYMD(new FlexibleDate("20150522")).build();
            assertThat(result.get運用開始日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用開始日));
        }

        @Test
        public void setUnyoShuryoYMDで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setUnyoShuryoYMD(new FlexibleDate("20150522")).build();
            assertThat(result.get運用終了日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用終了日));
        }

        @Test
        public void setUnyoKeitaiKubunで設定した値を_生成されたKaigoKoseiShichosonMasterも保持する() {
            KaigoKoseiShichosonMaster result = KaigoKoseiShichosonMaster.newBuilder().setUnyoKeitaiKubun(new RString("1")).build();
            assertThat(result.get運用形態区分(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用形態区分));
        }
    }

    public static class SerializationProxyTest {

        private KaigoKoseiShichosonMaster sut;

        @Before
        public void setUp() {
            sut = KaigoKoseiShichosonMaster.newBuilder().build(); //builderを用いて、インスタンスを生成してください。
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            sut.createBuilderForEdit().setGunMeisho(new RString("1"));
            String b64 = _Base64Serializer.serialize(sut.serialize());
            KaigoKoseiShichosonMaster desirialized = _Base64Serializer.deSerialize(b64, KaigoKoseiShichosonMaster.class);
            assertThat(desirialized.get郡名称(), is(sut.get郡名称())); // デシリアライズが成功していることを確認できるコードを書いてください。
        }
    }
}
