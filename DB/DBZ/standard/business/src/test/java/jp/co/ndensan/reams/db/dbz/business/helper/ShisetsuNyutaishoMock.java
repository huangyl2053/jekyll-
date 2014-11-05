/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.helper;

import jp.co.ndensan.reams.db.dbz.business.NyushoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.ur.urz.business.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.mockito.Mockito.*;

/**
 * 施設入退所の共通Mockです。
 *
 * @author N3317 塚田 萌
 */
public class ShisetsuNyutaishoMock {

    public static ShisetsuNyutaisho create施設入退所() {
        return new ShisetsuNyutaisho(
                new LasdecCode(new RString("123456")),
                new ShikibetsuCode(new RString("1234567890")),
                RDateTime.of(2014, 1, 10, 11, 12),
                DaichoType.他市町村住所地特例者,
                create期間(),
                create入所施設(),
                new FlexibleDate("20110703"),
                new FlexibleDate("20130331"));
    }

    private static Range<FlexibleDate> create期間() {
        FlexibleDate 開始年月日 = new FlexibleDate("20110703");
        FlexibleDate 終了年月日 = new FlexibleDate("20130331");
        return new Range(開始年月日, 終了年月日);
    }

    public static NyushoShisetsu create入所施設() {
        return new NyushoShisetsu(
                ShisetsuType.介護保険施設,
                new ShisetsuCode(new RString("1234567890")),
                new RString("ひまわり"),
                new RString("ヒマワリ"),
                new RString("中野市"));
    }

    public static IHojin createHojinMock() {
        IJusho jushoMock = mock(IJusho.class);
        when(jushoMock.get住所()).thenReturn(new RString("施設住所"));

        IHojin hojinMock = mock(IHojin.class);
        when(hojinMock.get住所()).thenReturn(jushoMock);

        IName name = mock(IName.class);
        when(name.getName()).thenReturn(new AtenaMeisho("介護太郎"));
        when(name.getKana()).thenReturn(new AtenaKanaMeisho("ｶｲｺﾞ ﾀﾛｳ"));
        when(hojinMock.get氏名()).thenReturn(name);

        return hojinMock;
    }
}
