/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoResult;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.JigyoHokokuNenpoResult;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataDeleteParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoSearchParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.basic.DbT7021JigyoHokokuTokeiDataDac;
import jp.co.ndensan.reams.db.dbu.persistence.jigyohokokugeppohoseihako.IJigyoHokokuGeppoHoseiHakoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author sunhui
 */
public class JigyoHokokuGeppoHoseiHakoTest extends DbuTestBase {

    private DbT7021JigyoHokokuTokeiDataDac dac;
    private JigyoHokokuGeppoHoseiHako hoseiHako;
    MapperProvider provider;
    IJigyoHokokuGeppoHoseiHakoMapper mapper;
    JigyoHokokuGeppoDetalSearchParameter jigyoHokokuGeppoDetalParameter;
    JigyoHokokuGeppoSearchParameter jigyoHokokuGeppoParameter;
    List<JigyoHokokuNenpoResult> jigyoHokokuNenpoResult;

    @Before
    public void setUp() {
        dac = mock(DbT7021JigyoHokokuTokeiDataDac.class);
        hoseiHako = new JigyoHokokuGeppoHoseiHako();
        provider = mock(MapperProvider.class);
        mapper = mock(IJigyoHokokuGeppoHoseiHakoMapper.class);
        hoseiHako = new JigyoHokokuGeppoHoseiHako(provider);
    }

    @Test
    public void select市町村のリスト_null() {
        SearchResult<ShichosonCodeNameResult> list = hoseiHako.getShichosonCodeNameList();
    }

    @Test
    public void getJigyoHokokuGeppoList() {
        jigyoHokokuGeppoParameter = JigyoHokokuGeppoSearchParameter.createParameterForJigyoHokokuGeppo(FlexibleYear.MAX, RString.EMPTY, FlexibleYear.MAX, RString.EMPTY, LasdecCode.EMPTY);
        List<JigyoHokokuGeppoHoseiHakoEntity> entityList = new ArrayList<>();
        when(provider.create(IJigyoHokokuGeppoHoseiHakoMapper.class)).thenReturn(mapper);
        when(mapper.select事業報告集計一覧データ(jigyoHokokuGeppoParameter)).thenReturn(entityList);
        List<JigyoHokokuGeppoHoseiHakoResult> entiotyList = hoseiHako.getJigyoHokokuGeppoList(jigyoHokokuGeppoParameter);
        assertThat(entiotyList.size(), is(1));
    }

    @Test
    public void getJigyoHokokuGeppoDetal() {
        jigyoHokokuGeppoDetalParameter = JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(FlexibleYear.MAX, RString.EMPTY, FlexibleYear.MAX, RString.EMPTY, RString.EMPTY, LasdecCode.EMPTY, Code.EMPTY, Code.EMPTY);
        List<JigyoHokokuTokeiData> list = hoseiHako.getJigyoHokokuGeppoDetal(jigyoHokokuGeppoDetalParameter);
        assertThat(list.size(), is(1));
    }

    @Test
    public void updateJigyoHokokuGeppoData() {

        List<JigyoHokokuGeppoHoseiHakoResult> list = new ArrayList<>();
        int i = hoseiHako.updateJigyoHokokuGeppoData(list);
        assertThat(i, is(1));

    }

    @Test
    public void deleteJigyoHokokuGeppoData() {
        List<JigyoHokokuGeppoDataDeleteParameter> parameter = new ArrayList<>();
        int i = hoseiHako.deleteJigyoHokokuGeppoData(parameter);
        assertThat(i, is(1));
    }
}
