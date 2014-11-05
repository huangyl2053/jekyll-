/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosainBangoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼情報のテストヘルパーです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaIraiTestHelper {

    public static ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(new RString("0001"));
    public static NinteichosaIraiRirekiNo ninteichosaIraiRirekiNo = new NinteichosaIraiRirekiNo(1);
    public static KaigoJigyoshaNo ninteichosaItakusakiCode = new KaigoJigyoshaNo(new RString("2001"));
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

    /**
     * 項目の一部を任意に設定できる、認定調査依頼情報をcreateできるメソッドです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 認定調査依頼情報Entity
     */
    public static DbT5006NinteichosaIraiJohoEntity create認定調査依頼情報Entity(ShinseishoKanriNo 申請書管理番号,
            NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        DbT5006NinteichosaIraiJohoEntity entity = create認定調査依頼情報Entity();
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setNinteichosaIraiRirekiNo(認定調査依頼履歴番号);
        return entity;
    }

    /**
     * 項目の一部を任意に設定できる、認定調査依頼情報をcreateできるメソッドです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 督促年月日 督促年月日
     * @return 認定調査依頼情報Entity
     */
    public static DbT5006NinteichosaIraiJohoEntity create認定調査依頼情報Entity(ShinseishoKanriNo 申請書管理番号,
            NinteichosaIraiRirekiNo 認定調査依頼履歴番号, RDate 督促年月日) {
        DbT5006NinteichosaIraiJohoEntity entity = create認定調査依頼情報Entity();
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setNinteichosaIraiRirekiNo(認定調査依頼履歴番号);
        entity.setNinteichosaTokusokuYMD(督促年月日.toFlexibleDate());
        return entity;
    }

    public static DbT5006NinteichosaIraiJohoEntity create認定調査依頼情報Entity(ShinseishoKanriNo 申請書管理番号,
            NinteichosaIraiRirekiNo 認定調査依頼履歴番号, KaigoJigyoshaNo get認定調査委託先コード, NinteichosainBangoCode get調査員番号コード) {
        DbT5006NinteichosaIraiJohoEntity entity = create認定調査依頼情報Entity();
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setNinteichosaIraiRirekiNo(認定調査依頼履歴番号);
        entity.setNinteichosaItakusakiCode(get認定調査委託先コード);
        entity.setChousainCode(get調査員番号コード);
        return entity;
    }
}
