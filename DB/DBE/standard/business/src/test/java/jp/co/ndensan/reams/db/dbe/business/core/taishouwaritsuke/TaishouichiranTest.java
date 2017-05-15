/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.taishouwaritsuke.TaishouIchiranEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * {@link Taishouichiran}のテストです。
 */
public class TaishouichiranTest {

    public TaishouichiranTest() {
    }

    @Test
    public void test_get前回厚労省IF識別コード() {
        TaishouIchiranEntity entity = new TaishouIchiranEntity();
        entity.set前回厚労省IF識別コード(new Code("02A"));
        Taishouichiran sut = new Taishouichiran(entity);
        assertThat(sut.get前回厚労省IF識別コード(), is(new Code("02A")));
    }

}
