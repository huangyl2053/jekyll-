/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.taishouwaritsuke.KohoshaIchiranEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * {@link  KohoshaIchiran}のテストです。
 */
public class KohoshaIchiranTest {

    public KohoshaIchiranTest() {
    }

    @Test
    public void test_get前回厚労省IF識別コード() {
        KohoshaIchiranEntity entity = new KohoshaIchiranEntity();
        entity.set前回厚労省IF識別コード(new Code("02A"));
        KohoshaIchiran sut = new KohoshaIchiran(entity);
        assertThat(sut.get前回厚労省IF識別コード(), is(new Code("02A")));
    }

}
