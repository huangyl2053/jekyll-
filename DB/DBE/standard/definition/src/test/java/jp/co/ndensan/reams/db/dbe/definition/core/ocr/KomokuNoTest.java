/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * {@link KomokuNo}のテストです。
 */
public class KomokuNoTest {

    public KomokuNoTest() {
    }

    @Test
    public void _1011_は_調査項目番号_101_イメージの連番_00_になる() {
        KomokuNo sut = new KomokuNo(new RString("1011"));

        System.out.println("chosaKomokuNo:" + sut.getChosaKomokuNo());
        System.out.println("remban:" + sut.getImageRemban());
        assertThat(sut.getChosaKomokuNo(), is(new RString("101")));
        assertThat(sut.getImageRemban(), is(new RString("00")));
    }

    @Test
    public void _$____$_は_調査項目番号_連番とも_RString$EMPTYになる() {
        KomokuNo sut = new KomokuNo(new RString("    "));

        assertThat(sut.getChosaKomokuNo(), is(RString.EMPTY));
        assertThat(sut.getImageRemban(), is(RString.EMPTY));
    }

    @Test
    public void _$____$_は_KomokuNo$EMPTYと同一として扱われ_isEmpty_は_true_を返す() {
        KomokuNo sut = new KomokuNo(new RString("    "));

        assertThat(sut, is(KomokuNo.EMPTY));
        assertThat(sut.isEmpty(), is(true));
    }
}
