/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3048ShokanFukushiYoguHanbaihiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 * 福祉用具購入費同一品目重複判定のTest
 *
 * @author chenaoqi
 */
public class FukushiYoguKounyuhiDouituHinmokuChofukuHanteiTest extends DbcTestBase {

    private FukushiYoguKounyuhiDouituHinmokuChofukuHantei sut;
    private List<DbT3048ShokanFukushiYoguHanbaihiEntity> list;
    private DbT3048ShokanFukushiYoguHanbaihiEntity entity;

    @Before
    public void setUp() {
        sut = new FukushiYoguKounyuhiDouituHinmokuChofukuHantei();
        entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
        list = new ArrayList<>();
        list.add(entity);

    }

    @Test
    public void chkHinmokuCodePerShinsei_listがnullの場合_falseを返す() {
        boolean flag = sut.chkHinmokuCodePerShinsei(new RString("1"), null);
        assertThat(flag, is(false));
    }

    @Test
    public void chkHinmokuCodePerShinsei_品目コードがnullの場合_falseを返す() {
        boolean flag = sut.chkHinmokuCodePerShinsei(null, list);
        assertThat(flag, is(false));
    }

    @Test
    public void chkHinmokuCodePerShinsei_品目コードが重複の場合_trueを返す() {
        RString 品目コード = new RString("1");
        boolean flag = sut.chkHinmokuCodePerShinsei(品目コード, list);
        assertThat(flag, is(true));
    }

    @Test
    public void chkHinmokuCodePerShinsei_品目コードが重複じゃないの場合_falseを返す() {
        RString 品目コード = new RString("Data");
        boolean flag = sut.chkHinmokuCodePerShinsei(品目コード, list);
        assertThat(flag, is(false));
    }

    @Test
    public void chkHinmokuCodePerYear_被保険者番号がnullの場合_falseを返す() {
        FlexibleYearMonth サービス提供年月 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
        RString 整理番号 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
        boolean flag = sut.chkHinmokuCodePerYear(null, サービス提供年月, list, 整理番号);
        assertThat(flag, is(false));
    }

    @Test
    public void chkHinmokuCodePerYear_サービス提供年月がnullの場合_falseを返す() {
        HihokenshaNo 被保険者番号 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
        RString 整理番号 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
        boolean flag = sut.chkHinmokuCodePerYear(被保険者番号, null, list, 整理番号);
        assertThat(flag, is(false));
    }

    @Test
    public void chkHinmokuCodePerYear_listがnullの場合_falseを返す() {
        HihokenshaNo 被保険者番号 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
        FlexibleYearMonth サービス提供年月 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
        RString 整理番号 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
        boolean flag = sut.chkHinmokuCodePerYear(被保険者番号, サービス提供年月, null, 整理番号);
        assertThat(flag, is(false));
    }

    @Test
    public void chkHinmokuCodePerYear_整理番号がnullの場合_falseを返す() {
        HihokenshaNo 被保険者番号 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
        FlexibleYearMonth サービス提供年月 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
        boolean flag = sut.chkHinmokuCodePerYear(被保険者番号, サービス提供年月, list, null);
        assertThat(flag, is(false));
    }

    @Test
    public void chkHinmokuCodePerYear_整理番号がnullじゃないの場合_falseを返す() {
        HihokenshaNo 被保険者番号 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
        FlexibleYearMonth サービス提供年月 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
        RString 整理番号 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
        boolean flag = sut.chkHinmokuCodePerYear(被保険者番号, サービス提供年月, list, 整理番号);
        assertThat(flag, is(false));
    }
}
