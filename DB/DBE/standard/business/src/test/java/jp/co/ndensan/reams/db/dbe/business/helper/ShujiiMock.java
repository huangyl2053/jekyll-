/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.IShujii;

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
//        return spy(new Shujii(
//                new LasdecCode(new RString("000001")),
//                new KaigoIryoKikanCode(new RString("介護医療機関コード")),
//                new KaigoDoctorCode(new RString("介護医師コード")),
//                new IryoKikanCode(new RString("1234567890")),
//                new RString("医師識別番号"),
//                IshiJokyo.有効,
//                new YubinNo(new RString("1234567")),
//                new AtenaJusho(new RString("住所")),
//                new TelNo("電話番号"),
//                new RString("FAX番号")));
        return null;
    }
}
