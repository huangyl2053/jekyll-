/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.MobileDataShutsuryoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosainBangoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItakusakiCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼情報のテストヘルパーです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaIraiJohoTestHelper {

    public static ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(new RString("0001"));
    public static NinteichosaIraiRirekiNo ninteichosaIraiRirekiNo = new NinteichosaIraiRirekiNo(1);
    public static NinteichosaItakusakiCode ninteichosaItakusakiCode = new NinteichosaItakusakiCode(new RString("2001"));
    public static NinteichosainBangoCode chousainCode = new NinteichosainBangoCode(new RString("3001"));
    public static RString ninteichousaIraiKubunCode = new RString("0");
    public static int ninteichosaIraiKaisu = 1;
    public static FlexibleDate ninteichosaIraiYMD = new FlexibleDate("19991212");
    public static FlexibleDate ninteichosaKigenYMD = new FlexibleDate("20001212");
    public static FlexibleDate iraishoShutsuryokuYMD = new FlexibleDate("20011212");
    public static FlexibleDate chosahyoTouShutsuryokuYMD = new FlexibleDate("20021212");
    public static boolean mobileDataShutsuryokuFlag = false;
    public static FlexibleDate ninteichosaTokusokuYMD = new FlexibleDate("20031212");
    public static RString ninteichosaTokusokuHoho = new RString("1");
    public static int ninteichosaTokusokuKaisu = 2;
    public static RString ninteichosaTokusokuMemo = new RString("督促");

    /**
     * テスト用認定調査依頼情報を返します。
     *
     * @return 認定調査依頼情報
     */
    public static NinteichosaIrai create認定調査依頼情報() {

        return new NinteichosaIrai(shinseishoKanriNo, ninteichosaIraiRirekiNo,
                ninteichosaItakusakiCode, chousainCode,
                NinteichosaIraiKubunCode.toValue(ninteichousaIraiKubunCode), ninteichosaIraiKaisu,
                ninteichosaIraiYMD.toRDate(), ninteichosaKigenYMD.toRDate(),
                iraishoShutsuryokuYMD.toRDate(), chosahyoTouShutsuryokuYMD.toRDate(),
                MobileDataShutsuryoku.toValue(mobileDataShutsuryokuFlag), ninteichosaTokusokuYMD.toRDate(),
                NinteichosaTokusokuHoho.toValue(ninteichosaTokusokuHoho),
                ninteichosaTokusokuKaisu, ninteichosaTokusokuMemo);
    }

    /**
     * テスト用エンティティを返します。
     *
     * @return テスト用エンティティ
     */
    public static DbT5006NinteichosaIraiJohoEntity create認定調査依頼情報Entity() {
        DbT5006NinteichosaIraiJohoEntity entity = new DbT5006NinteichosaIraiJohoEntity();
        entity.setShinseishoKanriNo(shinseishoKanriNo);
        entity.setNinteichosaIraiRirekiNo(ninteichosaIraiRirekiNo);
        entity.setNinteichosaItakusakiCode(ninteichosaItakusakiCode);
        entity.setChousainCode(chousainCode);
        entity.setNinteichousaIraiKubunCode(ninteichousaIraiKubunCode);
        entity.setNinteichosaIraiKaisu(ninteichosaIraiKaisu);
        entity.setNinteichosaIraiYMD(ninteichosaIraiYMD);
        entity.setNinteichosaKigenYMD(ninteichosaKigenYMD);
        entity.setIraishoShutsuryokuYMD(iraishoShutsuryokuYMD);
        entity.setChosahyoTouShutsuryokuYMD(chosahyoTouShutsuryokuYMD);
        entity.setMobileDataShutsuryokuFlag(mobileDataShutsuryokuFlag);
        entity.setNinteichosaTokusokuYMD(ninteichosaTokusokuYMD);
        entity.setNinteichosaTokusokuHoho(ninteichosaTokusokuHoho);
        entity.setNinteichosaTokusokuKaisu(ninteichosaTokusokuKaisu);
        entity.setNinteichosaTokusokuMemo(ninteichosaTokusokuMemo);
        return entity;
    }
}
