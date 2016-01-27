/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.eigyokeitai.EigyoKeitai;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.JutakuKaishuJyusyoChofukuHannteiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHannteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujyusyo.IJutakuKaishuIJyusyoChofukuHannteiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHanntei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author ycb
 */
public class JutakuKaishuJyusyoChofukuHannteiTest extends DbcTestBase {

    //  private static JutakuKaishuJyusyoChofukuHanntei sut;
    private static MapperProvider provider;
    private static IJutakuKaishuIJyusyoChofukuHannteiMapper mapper;

    @Before
    public void setup() {
        //   sut = new JutakuKaishuJyusyoChofukuHanntei();
        provider = mock(MapperProvider.class);
        mapper = mock(IJutakuKaishuIJyusyoChofukuHannteiMapper.class);
    }

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        when(mapper.selectKaishuJyusyoChofukuToroku(any(JutakuKaishuJyusyoChofukuHannteiMapperParameter.class))).thenReturn(null);
        when(provider.create(any(Class.class))).thenReturn(mapper);
        HihokenshaNo 被保険者番号 = null;
        FlexibleYearMonth サービス提供年月 = null;
        RString 改修住宅住所 = null;
        JutakuKaishuJyusyoChofukuHanntei test = new JutakuKaishuJyusyoChofukuHanntei(provider);
        boolean 略称 = test.checkKaishuJyusyoChofukuToroku(被保険者番号, サービス提供年月, 改修住宅住所);
        EigyoKeitai.toValue(null);
    }

    @Test
    public void checkKaishuJyusyoChofukuTorokuデータが取得されない場合_falseで返却する() {
        when(mapper.selectKaishuJyusyoChofukuToroku(any(JutakuKaishuJyusyoChofukuHannteiMapperParameter.class))).thenReturn(null);
        when(provider.create(any(Class.class))).thenReturn(mapper);
        HihokenshaNo 被保険者番号 = new HihokenshaNo("002");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("194303");
        RString 改修住宅住所 = new RString("fd");
        JutakuKaishuJyusyoChofukuHanntei test = new JutakuKaishuJyusyoChofukuHanntei(provider);
        boolean 略称 = test.checkKaishuJyusyoChofukuToroku(被保険者番号, サービス提供年月, 改修住宅住所);
        assertThat(略称, is(false));
    }

    @Test
    public void checkKaishuJyusyoChofukuTorokuデータが取得されない場合_trueで返却する() {
        JutakuKaishuJyusyoChofukuHannteiEntity entity = new JutakuKaishuJyusyoChofukuHannteiEntity();
        entity.setJutakuJushoHenko(false);
        entity.setJutakuKaishuJutakuAddress(new RString("4tr"));
        List<JutakuKaishuJyusyoChofukuHannteiEntity> entityList = Arrays.asList(entity);
        when(mapper.selectKaishuJyusyoChofukuToroku(any(JutakuKaishuJyusyoChofukuHannteiMapperParameter.class))).thenReturn(entityList);
        when(provider.create(any(Class.class))).thenReturn(mapper);
        HihokenshaNo 被保険者番号 = new HihokenshaNo("04");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("201605");
        RString 改修住宅住所 = new RString("4tr");
        JutakuKaishuJyusyoChofukuHanntei test = new JutakuKaishuJyusyoChofukuHanntei(provider);
        boolean 略称 = test.checkKaishuJyusyoChofukuToroku(被保険者番号, サービス提供年月, 改修住宅住所);
        assertThat(略称, is(true));
    }

}
