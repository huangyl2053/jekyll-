/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他機関情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5914SonotaKikanJohoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("000001");
    public static final RString DEFAULT_その他機関コード = new RString("名称");
    public static final RString DEFAULT_機関名称 = new RString("名称");
    public static final RString DEFAULT_機関名称カナ = new RString("名称");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1234567");
    public static final RString DEFAULT_住所 = new RString("名称");
    public static final RString DEFAULT_住所カナ = new RString("名称");
    public static final TelNo DEFAULT_電話番号 = new TelNo("0123456789");
    public static final RString DEFAULT_調査委託区分 = new RString("名称");
    public static final int DEFAULT_割付定員 = 1;
    public static final ChikuCode DEFAULT_割付地区 = new ChikuCode("123456789");
    public static final RString DEFAULT_機関の区分 = new RString("名称");
    public static final boolean DEFAULT_廃止フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5914SonotaKikanJohoEntityGenerator() {
    }

    public static DbT5914SonotaKikanJohoEntity createDbT5914SonotaKikanJohoEntity() {
        DbT5914SonotaKikanJohoEntity entity = new DbT5914SonotaKikanJohoEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setSonotaKikanCode(DEFAULT_その他機関コード);
        entity.setKikanMeisho(DEFAULT_機関名称);
        entity.setKikanMeishoKana(DEFAULT_機関名称カナ);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setJushoKana(DEFAULT_住所カナ);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setChosaItakuKubun(DEFAULT_調査委託区分);
        entity.setWaritsukeTeiin(DEFAULT_割付定員);
        entity.setWaritsukeChiku(DEFAULT_割付地区);
        entity.setKikanKubun(DEFAULT_機関の区分);
        entity.setHaishiFlag(DEFAULT_廃止フラグ);
        return entity;
    }
}
