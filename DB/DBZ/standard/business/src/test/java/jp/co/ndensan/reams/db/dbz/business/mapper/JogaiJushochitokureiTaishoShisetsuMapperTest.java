/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.mapper;

import jp.co.ndensan.reams.db.dbz.business.mapper.JogaiJushochitokureiTaishoShisetsuMapper;
import jp.co.ndensan.reams.db.dbz.business.JogaiJushochitokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.JogaiTokureiShisetsuEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 ** 介護除外・住所地特例対象施設クラスのbusinessクラスとentityクラスのマッピングを行うテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JogaiJushochitokureiTaishoShisetsuMapperTest {

    public static class to除外_住所地特例対象施設 extends DbzTestBase {

        private final ShisetsuCode 施設コード = new ShisetsuCode(new RString("1234567890"));
        private final RString 施設略称 = new RString("ひまわり");

        private final DbT1005KaigoJogai_TokureiTaishoShisetsuEntity entity
                = JogaiTokureiShisetsuEntityMock.create除外_特例施設Entity(施設コード, 施設略称);
        private JogaiJushochitokureiTaishoShisetsu sut;

        @Before
        public void setUp() {
            sut = JogaiJushochitokureiTaishoShisetsuMapper.to除外_住所地特例対象施設(entity);
        }

        @Test
        public void 除外_住所地特例対象施設entityに_nullを設定した時_nullを返す() {
            sut = JogaiJushochitokureiTaishoShisetsuMapper.to除外_住所地特例対象施設(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void get施設種類のコードが_Entityの施設種類と同一になる() {
            assertThat(sut.get施設種類().getCode(), is(entity.getNyushoShisetsuShurui()));
        }

        @Test
        public void get施設コードの値が_Entityの施設コードと同一になる() {
            assertThat(sut.get施設コード().value(), is(entity.getNyushoShisetsuCode()));
        }

        @Test
        public void get処理日時が_Entityの処理日時と同一になる() {
            assertThat(sut.get処理日時(), is(entity.getShoriTimestamp()));
        }

        @Test
        public void get有効期間の開始日が_Entityの有効開始日と同一になる() {
            assertThat(sut.get有効期間().getFrom(), is(entity.getYukoKaishiYMD()));
        }

        @Test
        public void get有効期間の終了日が_Entityの有効終了日と同一になる() {
            assertThat(sut.get有効期間().getTo(), is(entity.getYukoShuryoYMD()));
        }

        @Test
        public void get識別コードが_Entityの識別コードと同一になる() {
            assertThat(sut.get識別コード(), is(entity.getShikibetsuCode()));
        }

        @Test
        public void get施設略称が_Entityの施設略称と同一になる() {
            assertThat(sut.get施設略称(), is(entity.getShisetsuRyakusho()));
        }

        @Test
        public void get施設略称カナが_Entityの施設略称カナと同一になる() {
            assertThat(sut.get施設略称カナ(), is(entity.getShisetsuKanaRyakusho()));
        }

        @Test
        public void get施設住所カナが_Entityの施設住所カナと同一になる() {
            assertThat(sut.get施設住所カナ(), is(entity.getShisetsuKanaJusho()));
        }

        @Test
        public void get異動事由コードが_Entityの異動事由コードと同一になる() {
            assertThat(sut.get異動事由コード(), is(entity.getIdoJiyuCode()));
        }

        @Test
        public void get異動年月日が_Entityの異動年月日と同一になる() {
            assertThat(sut.get異動年月日(), is(entity.getIdoYMD()));
        }

        @Test
        public void get法人種別コードが_Entityの法人種別コードと同一になる() {
            assertThat(sut.get法人種別コード(), is(entity.getHojinShubetsuCode()));
        }

        @Test
        public void get施設開始年月日が_Entityの施設開始年月日と同一になる() {
            assertThat(sut.get施設開始年月日(), is(entity.getShisetsuKaishiYMD()));
        }

        @Test
        public void get施設休止年月日が_Entityの施設休止年月日と同一になる() {
            assertThat(sut.get施設休止年月日(), is(entity.getShisetsuKyushiYMD()));
        }

        @Test
        public void get施設廃止年月日が_Entityの施設廃止年月日と同一になる() {
            assertThat(sut.get施設廃止年月日(), is(entity.getShisetsuHaishiYMD()));
        }

        @Test
        public void get施設再開年月日が_Entityの施設再開年月日と同一になる() {
            assertThat(sut.get施設再開年月日(), is(entity.getShisetsuSaikaiYMD()));
        }
    }
}
