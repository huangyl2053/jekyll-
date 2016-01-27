/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.JutakuKaishuJyusyoChofukuHannteiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHannteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujyusyo.IJutakuKaishuIJyusyoChofukuHannteiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ycb
 */
public class IJutakuKaishuJyusyoChofukuHannteiMapperTest extends DbcTestDacBase {

    private static IJutakuKaishuIJyusyoChofukuHannteiMapper sut;

    @Before
    public void setup() {
        sqlSession.getConfiguration().addMapper(IJutakuKaishuIJyusyoChofukuHannteiMapper.class);
        sut = sqlSession.getMapper(IJutakuKaishuIJyusyoChofukuHannteiMapper.class);
    }

    @Test
    public void select略称_データなし() {
        JutakuKaishuJyusyoChofukuHannteiMapperParameter parameter = JutakuKaishuJyusyoChofukuHannteiMapperParameter.createSelectByKeyParam(
                new HihokenshaNo("0"), new FlexibleYearMonth("201605"));
        List<JutakuKaishuJyusyoChofukuHannteiEntity> result = sut.selectKaishuJyusyoChofukuToroku(parameter);
        assertThat(result.isEmpty(), is(true));

    }

    @Test
    public void select略称_データあり() {
        JutakuKaishuJyusyoChofukuHannteiMapperParameter parameter = JutakuKaishuJyusyoChofukuHannteiMapperParameter.createSelectByKeyParam(
                new HihokenshaNo("04"), new FlexibleYearMonth("201605"));
        List<JutakuKaishuJyusyoChofukuHannteiEntity> list = sut.selectKaishuJyusyoChofukuToroku(parameter);
        assertThat(new RString("4tr"), is(list.get(0).getJutakuKaishuJutakuAddress()));
        assertThat(true, is(list.get(0).isJutakuJushoHenko()));
    }

}
