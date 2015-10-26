/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5912ShujiiJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final RString DEFAULT_主治医医療機関コード = new RString("1");
    public static final RString DEFAULT_主治医コード = new RString("1");
    public static final RString DEFAULT_主治医氏名 = new RString("1");
    public static final AtenaKanaMeisho DEFAULT_主治医カナ = new AtenaKanaMeisho("あ");
    public static final Code DEFAULT_性別 = new Code("1");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("3801234");
    public static final RString DEFAULT_住所 = new RString("あ");
    public static final TelNo DEFAULT_電話番号 = new TelNo("1234567890");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("1234567890");
    public static final RString DEFAULT_診療科名称 = new RString("1");
    public static final boolean DEFAULT_指定医フラグ = false;
    public static final boolean DEFAULT_状況フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5912ShujiiJohoEntityGenerator() {
    }

    public static DbT5912ShujiiJohoEntity createDbT5912ShujiiJohoEntity() {
        DbT5912ShujiiJohoEntity entity = new DbT5912ShujiiJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShujiiIryokikanCode(DEFAULT_主治医医療機関コード);
        entity.setShujiiCode(DEFAULT_主治医コード);
        entity.setShujiiName(DEFAULT_主治医氏名);
        entity.setShujiiKana(DEFAULT_主治医カナ);
        entity.setSeibetsu(DEFAULT_性別);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setShinryokaName(DEFAULT_診療科名称);
        entity.setShiteiiFlag(DEFAULT_指定医フラグ);
        entity.setJokyoFlag(DEFAULT_状況フラグ);
        return entity;
    }
}
