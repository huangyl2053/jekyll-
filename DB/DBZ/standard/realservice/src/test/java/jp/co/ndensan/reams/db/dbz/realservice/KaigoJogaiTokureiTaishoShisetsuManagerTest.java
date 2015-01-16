/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.KaigoJogaiTokureiTaishoShisetsu.KaigoJogaiTokureiTaishoShisetsuModel;
import jp.co.ndensan.reams.db.dbz.model.relate.KaigoJogaiTokureiTaishoShisetsuRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * KaigoJogaiTokureiTaishoShisetsuManagerのテストです。
 *
 * @author n8223　朴義一
 */
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuManagerTest extends DbzTestBase {

    private static KaigoJogaiTokureiTaishoShisetsuManager sut;

    private static final RString 事業者種別 = new RString("12");
    private static final RString 事業者番号 = new RString("0000000011");
    private static final FlexibleDate 有効開始年月日 = new FlexibleDate("20140101");

    public static class get介護除外住所地特例対象施設一覧 {

        @Test
        public void get介護除外住所地特例対象施設() {

            sut = createManager();
            KaigoJogaiTokureiTaishoShisetsuRelateModel result = sut.get介護除外住所地特例対象施設(事業者種別, 事業者番号, 有効開始年月日);
            assertThat(result.get介護除外住所地特例対象施設モデル().get事業者名称().toString(), is("適用除外施設01"));

        }

        private static KaigoJogaiTokureiTaishoShisetsuManager createManager() {
            return new KaigoJogaiTokureiTaishoShisetsuManager(createDac());

        }

        private static KaigoJogaiTokureiTaishoShisetsuDac createDac() {
            KaigoJogaiTokureiTaishoShisetsuModel shisetsuModel = mock(KaigoJogaiTokureiTaishoShisetsuModel.class);
            when(shisetsuModel.get事業者名称()).thenReturn(new AtenaMeisho("適用除外施設01"));

            KaigoJogaiTokureiTaishoShisetsuRelateModel shisetsuRelateModel = mock(KaigoJogaiTokureiTaishoShisetsuRelateModel.class);

            when(shisetsuRelateModel.get介護除外住所地特例対象施設モデル()).thenReturn(shisetsuModel);

            KaigoJogaiTokureiTaishoShisetsuDac kaigoJogaiTokureiTaishoShisetsuDac = mock(KaigoJogaiTokureiTaishoShisetsuDac.class);
            when(kaigoJogaiTokureiTaishoShisetsuDac.select介護除外住所地特例対象施設ByKey(事業者種別, 事業者番号, 有効開始年月日)).thenReturn(shisetsuRelateModel);
            return kaigoJogaiTokureiTaishoShisetsuDac;
        }

        @Test
        public void get介護除外住所地特例対象施設一覧By主キー1() {

            List<KaigoJogaiTokureiTaishoShisetsuRelateModel> selectList = new ArrayList<>();
            selectList.add(createMock1());
            selectList.add(createMock2());
            selectList.add(createMock3());

            sut = createManagerMock(事業者番号, selectList);
            List<KaigoJogaiTokureiTaishoShisetsuRelateModel> result = sut.get介護除外住所地特例対象施設一覧By主キー1(事業者番号);
            assertThat(result.get(1).get介護除外住所地特例対象施設モデル().get事業者名称().toString(), is("適用除外施設02"));

        }

        private static KaigoJogaiTokureiTaishoShisetsuManager createManagerMock(RString 事業者番号, List<KaigoJogaiTokureiTaishoShisetsuRelateModel> selectList) {
            KaigoJogaiTokureiTaishoShisetsuManager mangaer = mock(KaigoJogaiTokureiTaishoShisetsuManager.class);
            when(mangaer.get介護除外住所地特例対象施設一覧By主キー1(事業者番号)).thenReturn(selectList);
            return mangaer;
        }

        private static KaigoJogaiTokureiTaishoShisetsuRelateModel createMock1() {
            KaigoJogaiTokureiTaishoShisetsuModel shisetsuModel = mock(KaigoJogaiTokureiTaishoShisetsuModel.class);
            when(shisetsuModel.get事業者名称()).thenReturn(new AtenaMeisho("適用除外施設01"));
            KaigoJogaiTokureiTaishoShisetsuRelateModel shisetsuRelateModel = mock(KaigoJogaiTokureiTaishoShisetsuRelateModel.class);
            when(shisetsuRelateModel.get介護除外住所地特例対象施設モデル()).thenReturn(shisetsuModel);

            return shisetsuRelateModel;
        }

        private static KaigoJogaiTokureiTaishoShisetsuRelateModel createMock2() {
            KaigoJogaiTokureiTaishoShisetsuModel shisetsuModel = mock(KaigoJogaiTokureiTaishoShisetsuModel.class);
            when(shisetsuModel.get事業者名称()).thenReturn(new AtenaMeisho("適用除外施設02"));
            KaigoJogaiTokureiTaishoShisetsuRelateModel shisetsuRelateModel = mock(KaigoJogaiTokureiTaishoShisetsuRelateModel.class);
            when(shisetsuRelateModel.get介護除外住所地特例対象施設モデル()).thenReturn(shisetsuModel);

            return shisetsuRelateModel;
        }

        private static KaigoJogaiTokureiTaishoShisetsuRelateModel createMock3() {
            KaigoJogaiTokureiTaishoShisetsuModel shisetsuModel = mock(KaigoJogaiTokureiTaishoShisetsuModel.class);
            when(shisetsuModel.get事業者名称()).thenReturn(new AtenaMeisho("適用除外施設03"));
            KaigoJogaiTokureiTaishoShisetsuRelateModel shisetsuRelateModel = mock(KaigoJogaiTokureiTaishoShisetsuRelateModel.class);
            when(shisetsuRelateModel.get介護除外住所地特例対象施設モデル()).thenReturn(shisetsuModel);

            return shisetsuRelateModel;
        }

        @Test
        public void save介護除外住所地特例対象施設_trueを返す() {

            KaigoJogaiTokureiTaishoShisetsuManager manager = mock(KaigoJogaiTokureiTaishoShisetsuManager.class);
            KaigoJogaiTokureiTaishoShisetsuRelateModel shisetsuRelateModel = mock(KaigoJogaiTokureiTaishoShisetsuRelateModel.class);

            when(manager.save介護除外住所地特例対象施設(shisetsuRelateModel)).thenReturn(1);
        }

        @Test
        public void save介護除外住所地特例対象施設_falseを返す() {

            KaigoJogaiTokureiTaishoShisetsuManager manager = mock(KaigoJogaiTokureiTaishoShisetsuManager.class);
            KaigoJogaiTokureiTaishoShisetsuRelateModel shisetsuRelateModel = mock(KaigoJogaiTokureiTaishoShisetsuRelateModel.class);

            when(manager.save介護除外住所地特例対象施設(shisetsuRelateModel)).thenReturn(0);
        }

    }

}
