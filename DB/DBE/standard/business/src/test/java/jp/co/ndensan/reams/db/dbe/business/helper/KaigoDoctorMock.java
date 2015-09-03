/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.business.IShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.IryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.ux.uxx.business.core.iryokikan.IryoKikan;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * モデルパッケージ作成時にエラーになったため仮作成。対応するときに考える。
 *
 * @author N3317 塚田 萌
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
        //TODO KaigoDoctorコメントアウトされている
//        return spy(new KaigoDoctor(createDoctor(), createShujii(), createKaigoIryoKikan()));
        return null;
    }

//    private static IDoctor createDoctor() {
    //TODO KaigoDoctorコメントアウトされている
//        return new _Doctor(
//                new RString("医師識別番号"),
//                new AtenaMeisho(new RString("医師氏名")),
//                new _IryoKikanCode(new RString("1234567890")),
//                new Code(new RString("所属診療科")),
//                new Code(new RString("医師区分")));
//        return null;
//    }
    private static IShujii createShujii() {
//        return new Shujii(
//                new LasdecCode(new RString("000001")),
//                new KaigoIryoKikanCode(new RString("介護医療機関コード")),
//                new KaigoDoctorCode(new RString("介護医師コード")),
//                new _IryoKikanCode(new RString("1234567890")),
//                new RString("医師識別番号"),
//                IshiJokyo.有効,
//                new YubinNo(new RString("1234567")),
//                new AtenaJusho(new RString("住所")),
//                new TelNo("電話番号"),
//                new RString("FAX番号"));
        return null;
    }

    private static KaigoIryoKikan createKaigoIryoKikan() {
        return new KaigoIryoKikan(createIryoKikan(), createShujiiIryoKikan());
    }

    private static IryoKikan createIryoKikan() {
        return null;
//        return new IryoKikan(KaigoIryoKikanTestHelper.create医療機関Entity(), null);
    }

    private static IShujiiIryoKikan createShujiiIryoKikan() {
        return new ShujiiIryoKikan(
                new LasdecCode(new RString("000001")),
                new KaigoIryoKikanCode(new RString("1234567890")),
                new IryoKikanCode("1234567890"),
                IryoKikanJokyo.有効,
                new IryoKikanKubun(new RString("医療機関の区分"), RString.EMPTY, RString.EMPTY));
    }
}
