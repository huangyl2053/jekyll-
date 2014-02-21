/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiChosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * DbT5001NinteiShinseiJohoEntityを生成するためのMockクラスです
 *
 * @author N8187 久保田 英男
 */
public class DbT5001NinteiShinseiJohoEntityMock {

    private DbT5001NinteiShinseiJohoEntityMock() {
    }

    public static DbT5001NinteiShinseiJohoEntity getSpiedInstance() {
        final RString 試験用文字列 = new RString("0001");
        return spy(new DbT5001NinteiShinseiJohoEntity(
                new ShinseishoKanriNo(試験用文字列),
                new ShichosonCode(試験用文字列),
                試験用文字列,
                new KaigoHihokenshaNo(試験用文字列),
                試験用文字列,
                new NinteiShinseiDate(new FlexibleDate(new RString("20140101"))),
                試験用文字列,
                試験用文字列,
                試験用文字列,
                試験用文字列,
                試験用文字列,
                試験用文字列,
                試験用文字列,
                1,
                true,
                new NinteiChosaIraiRirekiNo(試験用文字列),
                Integer.parseInt(試験用文字列.toString()),
                試験用文字列,
                true,
                true,
                試験用文字列,
                試験用文字列,
                試験用文字列,
                new FlexibleDate(new RString("20140101")),
                true));
    }
}
