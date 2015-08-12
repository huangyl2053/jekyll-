/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5201NinteichosaIraiJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_認定調査依頼履歴番号 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("01");
    public static final JigyoshaNo DEFAULT_認定調査委託先コード = new JigyoshaNo("111111");
    public static final RString DEFAULT_認定調査員コード = new RString("名称");
    public static final Code DEFAULT_認定調査依頼区分コード = new Code("01");
    public static final int DEFAULT_認定調査回数 = 1;
    public static final FlexibleDate DEFAULT_認定調査依頼年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定調査期限年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_依頼書出力年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_調査票等出力年月日 = new FlexibleDate("20141030");
    public static final boolean DEFAULT_モバイルデータ出力済フラグ = false;
    public static final boolean DEFAULT_事前調査フラグ = false;
    public static final FlexibleDate DEFAULT_認定調査督促年月日 = new FlexibleDate("20141030");
    public static final RString DEFAULT_認定調査督促方法 = new RString("名称");
    public static final int DEFAULT_認定調査督促回数 = 1;
    public static final RString DEFAULT_認定調査督促メモ = new RString("名称");
    public static final boolean DEFAULT_論理削除フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5201NinteichosaIraiJohoEntityGenerator() {
    }

    public static DbT5201NinteichosaIraiJohoEntity createDbT5201NinteichosaIraiJohoEntity() {
        DbT5201NinteichosaIraiJohoEntity entity = new DbT5201NinteichosaIraiJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaIraiRirekiNo(DEFAULT_認定調査依頼履歴番号);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setNinteichosaItakusakiCode(DEFAULT_認定調査委託先コード);
        entity.setNinteiChosainCode(DEFAULT_認定調査員コード);
        entity.setNinteichosaIraiKubunCode(DEFAULT_認定調査依頼区分コード);
        entity.setNinteichosaIraiKaisu(DEFAULT_認定調査回数);
        entity.setNinteichosaIraiYMD(DEFAULT_認定調査依頼年月日);
        entity.setNinteichosaKigenYMD(DEFAULT_認定調査期限年月日);
        entity.setIraishoShutsuryokuYMD(DEFAULT_依頼書出力年月日);
        entity.setChosahyoTouShutsuryokuYMD(DEFAULT_調査票等出力年月日);
        entity.setMobileDataShutsuryokuZumiFlag(DEFAULT_モバイルデータ出力済フラグ);
        entity.setJizenChosaFlag(DEFAULT_事前調査フラグ);
        entity.setNinteichosaTokusokuYMD(DEFAULT_認定調査督促年月日);
        entity.setNinteichosaTokusokuHoho(DEFAULT_認定調査督促方法);
        entity.setNinteichosaTokusokuKaisu(DEFAULT_認定調査督促回数);
        entity.setNinteichosaTokusokuMemo(DEFAULT_認定調査督促メモ);
        entity.setLogicalDeletedFlag(DEFAULT_論理削除フラグ);
        return entity;
    }
}
