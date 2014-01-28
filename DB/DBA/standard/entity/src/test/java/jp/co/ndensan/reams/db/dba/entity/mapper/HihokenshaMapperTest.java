/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.mapper;

import jp.co.ndensan.reams.db.dba.entity.mapper.HihokenshaMapper;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dba.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dba.entity.basic.helper.ShikibetsuCodeMock;
import jp.co.ndensan.reams.db.dba.entity.basic.helper.DbT1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.business.HokenShubetsu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * 被保険者Mapperのテストクラスです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaMapperTest extends TestBase {

    public static class ToHihokensha extends TestBase {

        private DbT1001HihokenshaDaichoEntity entity;

        @Override
        protected void setUp() {
            entity = DbT1001HihokenshaDaichoEntityMock.getSpiedInstance();
        }

        @Test
        public void あるEntityから作成した被保険者のget市町村コードは_当該Entityに設定した市町村コードと同じ値を返す() {
            ShichosonCode 市町村コード = new ShichosonCode(new RString("10010"));
            entity.setShichosonCd(市町村コード.getValue());
            assertThat(HihokenshaMapper.toHihokensha(entity).get市町村コード(), is(市町村コード));
        }

        @Test
        public void あるEntityから作成した被保険者のget広域内住所地特例措置元_市町村コードは_当該Entityに設定した広域内住所地特例措置元市町村コードと同じ値を返す() {
            ShichosonCode 住特措置元市町村コード = new ShichosonCode(new RString("10010"));
            entity.setKoikinaiTokureiSochimotoShichosonCd(住特措置元市町村コード.getValue());
            assertThat(HihokenshaMapper.toHihokensha(entity).get広域内住所地特例措置元_市町村コード(), is(住特措置元市町村コード));
        }

        @Test
        public void あるEntityから作成した被保険者のget再交付事由は_当該Entityに設定した再交付事由と同じ値を返す() {
            RString 再交付事由コード = new RString("再交付事由");
            entity.setSaikofuJiyuCode(再交付事由コード);
            assertThat(HihokenshaMapper.toHihokensha(entity).get再交付事由().getCode(), is(再交付事由コード));
        }

        @Test
        public void あるEntityから作成した被保険者のhas被保険者証の再交付は_当該Entityに設定した再交付有無と同じ値を返す() {
            boolean 再交付有無 = true;
            entity.setSaikofuKubun(再交付有無);
            assertThat(HihokenshaMapper.toHihokensha(entity).has被保険者証の再交付(), is(再交付有無));
        }

        @Test
        public void あるEntityから作成した被保険者のis広域内住所地特例は_当該Entityに設定した広域内住所地特例フラグと同じ値を返す() {
            boolean 広域内住所地特例フラグ = true;
            entity.setKoikinaiJushochitokureiFlag(広域内住所地特例フラグ);
            assertThat(HihokenshaMapper.toHihokensha(entity).is広域内住所地特者(), is(広域内住所地特例フラグ));
        }

        @Test
        public void あるEntityから作成した被保険者のis住所地特例は_当該Entityに設定した住所地特例フラグと同じ値を返す() {
            boolean 住所地特例フラグ = true;
            entity.setJushochitokureiFlag(住所地特例フラグ);
            assertThat(HihokenshaMapper.toHihokensha(entity).is住所地特例者(), is(住所地特例フラグ));
        }

        @Test
        public void あるEntityから作成した被保険者のget住所地特例解除年月日は_当該Entityに設定した住所地特例解除年月日と同じ値を返す() {
            RDate 住所地特例解除年月日 = new RDate("2001-1-1");
            entity.setJushochitokureiKaijoDate(住所地特例解除年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get住所地特例解除年月日(), is(住所地特例解除年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget住所地特例解除届出年月日は_当該Entityに設定した住所地特例解除届出年月日と同じ値を返す() {
            RDate 住所地特例解除届出年月日 = new RDate("2001-1-1");
            entity.setJushochitokureiKaijoTodokedeDate(住所地特例解除届出年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get住所地特例解除届出年月日(), is(住所地特例解除届出年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget住所地特例解除事由は_当該Entityに設定した住所地特例解除事由と同じ値を返す() {
            RString 住所地特例解除事由コード = new RString("住所地特例解除事由");
            entity.setJushochitokureiKaijoJiyuCode(住所地特例解除事由コード);
            assertThat(HihokenshaMapper.toHihokensha(entity).get住所地特例解除事由().getCode(), is(住所地特例解除事由コード));
        }

        @Test
        public void あるEntityから作成した被保険者のget住所地特例適用年月日は_当該Entityに設定した住所地特例適用年月日と同じ値を返す() {
            RDate 住所地特例適用年月日 = new RDate("2001-1-1");
            entity.setJushochitokureiTekiyoDate(住所地特例適用年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get住所地特例適用年月日(), is(住所地特例適用年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget住所地特例適用届出年月日は_当該Entityに設定した住所地特例適用届出年月日と同じ値を返す() {
            RDate 住所地特例適用届出年月日 = new RDate("2001-1-1");
            entity.setJushochitokureiTekiyoTodokedeDate(住所地特例適用届出年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get住所地特例適用届出年月日(), is(住所地特例適用届出年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget住所地特例適用事由は_当該Entityに設定した住所地特例適用事由と同じ値を返す() {
            RString 住所地特例適用事由コード = new RString("住所地特例適用事由");
            entity.setJushochitokureiTekiyoJiyuCode(住所地特例適用事由コード);
            assertThat(HihokenshaMapper.toHihokensha(entity).get住所地特例適用事由().getCode(), is(住所地特例適用事由コード));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格変更年月日は_当該Entityに設定した資格変更年月日と同じ値を返す() {
            RDate 資格変更年月日 = new RDate("2001-1-1");
            entity.setShikakuHenkoDate(資格変更年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格変更年月日(), is(資格変更年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格変更あ届出年月日は_当該Entityに設定した資格変更届出年月日と同じ値を返す() {
            RDate 資格変更届出年月日 = new RDate("2001-1-1");
            entity.setShikakuHenkoTodokedeDate(資格変更届出年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格変更届出年月日(), is(資格変更届出年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格変更事由は_当該Entityに設定した資格変更事由と同じ値を返す() {
            RString 資格変更事由コード = new RString("資格変更事由");
            entity.setShikakuHenkoJiyuCode(資格変更事由コード);
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格変更事由().getCode(), is(資格変更事由コード));
        }

        @Test
        public void あるEntityから作成した被保険者のget被保険者区分は_当該Entityに設定した被保険者区分と同じ値を返す() {
            RString 被保険者区分コード = new RString("被保険者区分");
            entity.setHihokenshaKubunCode(被保険者区分コード);
            assertThat(HihokenshaMapper.toHihokensha(entity).get被保険者区分().getCode(), is(被保険者区分コード));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格異動区分は_当該Entityに設定した資格異動区分と同じ値を返す() {
            ShikakuIdoKubun 資格異動区分 = ShikakuIdoKubun.資格取得;
            entity.setShikakuIdouKubunCode(資格異動区分.getCode());
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格異動区分(), is(資格異動区分));
        }

        @Test
        public void あるEntityから作成した被保険者のget被保険者番号は_当該Entityに設定した被保険者番号と同じ値を返す() {
            KaigoHihokenshaNumber 被保険者番号 = new KaigoHihokenshaNumber(new RString("0000000001"));
            entity.setHihokenshaNo(被保険者番号.getValue());
            assertThat(HihokenshaMapper.toHihokensha(entity).get被保険者番号(), is(被保険者番号.getValue()));
        }

        @Test
        public void あるEntityから作成した被保険者のget介護保険広域構成市町村コードは_当該Entityに設定した市町村コードと同じ値を返す() {
            ShichosonCode 市町村コード = new ShichosonCode(new RString("10010"));
            entity.setShichosonCd(市町村コード.getValue());
            assertThat(HihokenshaMapper.toHihokensha(entity).get介護保険広域構成市町村コード(), is(市町村コード.getValue()));
        }

        @Test
        public void あるEntityから作成した被保険者のget一号該当日は_当該Entityに設定した一号被保険者年齢到達年月日と同じ値を返す() {
            RDate 一号被保険者年齢到達年月日 = new RDate("2001-1-1");
            entity.setIchigoHihokenshaNenreiTotatsuDate(一号被保険者年齢到達年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get一号該当日(), is(一号被保険者年齢到達年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget識別コードは_当該Entityに設定したと同じ値を返す() {
            IShikibetsuCode 識別コード = ShikibetsuCodeMock.createInstance(new RString("識別コード"));
            entity.setShikibetsuCode(識別コード);
            assertThat(HihokenshaMapper.toHihokensha(entity).get識別コード(), is(識別コード));
        }

        @Test
        public void あるEntityから作成した被保険者のget保険種別は_介護保険を返す() {
            assertThat(HihokenshaMapper.toHihokensha(entity).get保険種別(), is(HokenShubetsu.介護保険));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格取得届出年月日は_当該Entityに設定した資格取得届出年月日と同じ値を返す() {
            RDate 資格取得届出年月日 = new RDate("2001-1-1");
            entity.setShikakuShutokuTodokedeDate(資格取得届出年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格取得届出年月日(), is(資格取得届出年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格取得年月日は_当該Entityに設定した資格取得年月日と同じ値を返す() {
            RDate 資格取得年月日 = new RDate("2001-1-1");
            entity.setShikakuShutokuDate(資格取得年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格取得年月日(), is(資格取得年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格取得事由は_当該Entityに設定した資格取得事由コードと同じ値を返す() {
            RString 資格取得事由コード = new RString("資格取得事由");
            entity.setShikakuShutokuJiyuCode(資格取得事由コード);
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格取得事由().getCode(), is(資格取得事由コード));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格喪失届出年月日は_当該Entityに資格喪失届出年月日設定したと同じ値を返す() {
            RDate 資格喪失届出年月日 = new RDate("2001-1-1");
            entity.setShikakuSoshitsuTodokedeDate(資格喪失届出年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格喪失届出年月日(), is(資格喪失届出年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格喪失年月日は_当該Entityに設定した資格喪失年月日と同じ値を返す() {
            RDate 資格喪失年月日 = new RDate("2001-1-1");
            entity.setShikakuSoshitsuDate(資格喪失年月日);
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格喪失年月日(), is(資格喪失年月日));
        }

        @Test
        public void あるEntityから作成した被保険者のget資格喪失事由は_当該Entityに設定した資格喪失事由コードと同じ値を返す() {
            RString 資格喪失事由コード = new RString("資格喪失事由");
            entity.setShikakuSoshitsuJiyuCode(資格喪失事由コード);
            assertThat(HihokenshaMapper.toHihokensha(entity).get資格喪失事由().getCode(), is(資格喪失事由コード));
        }
    }

    public static class ToHihokenshaList extends TestBase {

        private List<DbT1001HihokenshaDaichoEntity> entities;

        @Override
        protected void setUp() {
            entities = new ArrayList<>();
        }

        @Test
        public void 引数にするリストのサイズと_変換後の被保険者リストのサイズは一致する() {
            entities.add(DbT1001HihokenshaDaichoEntityMock.getSpiedInstance());
            entities.add(DbT1001HihokenshaDaichoEntityMock.getSpiedInstance());
            assertThat(HihokenshaMapper.toHihokenshaList(entities).size(), is(entities.size()));
        }
    }
}
