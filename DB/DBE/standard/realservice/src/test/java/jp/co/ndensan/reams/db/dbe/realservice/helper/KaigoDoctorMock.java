/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.business.IShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.Shujii;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikan;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business._Doctor;
import jp.co.ndensan.reams.ur.urz.business._Doctors;
import jp.co.ndensan.reams.ur.urz.business._IryoKikan;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Name;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.mockito.Mockito.spy;

/**
 * KaigoDoctorを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class KaigoDoctorMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KaigoDoctorMock() {
    }

    /**
     * KaigoDoctorを生成して返します。
     *
     * @return KaigoDoctor
     */
    public static KaigoDoctor getSpiedInstance() {
        return spy(new KaigoDoctor(createDoctor(), createShujii(), createKaigoIryoKikan()));
    }

    private static IDoctor createDoctor() {
        return new _Doctor(
                new RString("医師識別番号"),
                new AtenaMeisho(new RString("医師氏名")),
                new _IryoKikanCode(new RString("1234567890")),
                new Code(new RString("所属診療科")),
                new Code(new RString("医師区分")));
    }

    private static IShujii createShujii() {
        return new Shujii(
                new ShichosonCode(new RString("市町村コード")),
                new KaigoIryoKikanCode(new RString("介護医療機関コード")),
                new KaigoDoctorCode(new RString("介護医師コード")),
                new _IryoKikanCode(new RString("1234567890")),
                new RString("医師識別番号"),
                IshiJokyo.有効,
                new YubinNo(new RString("1234567")),
                new AtenaJusho(new RString("住所")),
                new TelNo("電話番号"),
                new RString("FAX番号"));
    }

    private static KaigoIryoKikan createKaigoIryoKikan() {
        return new KaigoIryoKikan(createIryoKikan(), createShujiiIryoKikan());
    }

    private static IIryoKikan createIryoKikan() {
        return new _IryoKikan(
                new _IryoKikanCode(new RString("1234567890")),
                new ShikibetsuCode(new RString("123456")),
                new _Name(new RString("医療機関名称"), RString.EMPTY),
                new _Name(new RString("医療機関略称"), RString.EMPTY),
                new RString("所在地郵便番号"),
                new RString("所在地住所"),
                new RString("所在地カナ住所"),
                new Range(RDate.MIN, RDate.MAX),
                new _Doctors(new ArrayList<IDoctor>()),
                new ArrayList<IKoza>(),
                RDate.MIN,
                new RString("休止区分"),
                new RString("異動事由"),
                new RString("会員区分"),
                true);
    }

    private static IShujiiIryoKikan createShujiiIryoKikan() {
        return new ShujiiIryoKikan(
                new ShichosonCode(new RString("市町村コード")),
                new KaigoIryoKikanCode(new RString("1234567890")),
                new _IryoKikanCode(new RString("1234567890")),
                IryoKikanJokyo.有効,
                new IryoKikanKubun(new RString("医療機関の区分"), RString.EMPTY, RString.EMPTY));
    }
}
