/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.business.Shujii;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * Shujiiを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShujiiMock() {
    }

    /**
     * Shujiiを生成して返します。
     *
     * @return Shujii
     */
    public static IShujii getSpiedInstance() {
        return spy(new Shujii(
                new ShichosonCode(new RString("市町村コード")),
                new KaigoIryoKikanCode(new RString("介護医療機関コード")),
                new KaigoDoctorCode(new RString("介護医師コード")),
                new _IryoKikanCode(new RString("1234567890")),
                new RString("医師識別番号"),
                IshiJokyo.有効,
                new YubinNo(new RString("1234567")),
                new AtenaJusho(new RString("住所")),
                new TelNo("電話番号"),
                new RString("FAX番号")));
    }
}
