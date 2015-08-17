/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者代表者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n3317 塚田萌
 */
public final class DbT7062KaigoJigyoshaDaihyoshaEntityGenerator {

    public static final KaigoJigyoshaNo DEFAULT_事業者番号 = new KaigoJigyoshaNo("1234567890");
    public static final FlexibleDate DEFAULT_有効開始日 = new FlexibleDate("20140401");
    public static final AtenaMeisho DEFAULT_代表者名 = new AtenaMeisho("田中　智");
    public static final AtenaKanaMeisho DEFAULT_代表者名カナ = new AtenaKanaMeisho("タナカ　サトシ");
    public static final YubinNo DEFAULT_代表者郵便番号 = new YubinNo("1820088");
    public static final AtenaJusho DEFAULT_代表者住所 = new AtenaJusho("七瀬中町");
    public static final RString DEFAULT_代表者住所カナ = new RString("ナナセナカマチ");
    public static final RString DEFAULT_代表者役職名 = new RString("課長");
    public static final AtenaMeisho DEFAULT_開設者名 = new AtenaMeisho("田中　智");
    public static final AtenaKanaMeisho DEFAULT_開設者名カナ = new AtenaKanaMeisho("タナカ　サトシ");
    public static final YubinNo DEFAULT_開設者郵便番号 = new YubinNo("1820088");
    public static final AtenaJusho DEFAULT_開設者住所 = new AtenaJusho("七瀬中町");
    public static final RString DEFAULT_開設者住所カナ = new RString("ナナセナカマチ");
    public static final TelNo DEFAULT_開設者電話番号 = new TelNo("0332188955");
    public static final TelNo DEFAULT_開設者FAX番号 = new TelNo("0332188955");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7062KaigoJigyoshaDaihyoshaEntityGenerator() {
    }

    public static DbT7062KaigoJigyoshaDaihyoshaEntity createDbT7062KaigoJigyoshaDaihyoshaEntity() {
        DbT7062KaigoJigyoshaDaihyoshaEntity entity = new DbT7062KaigoJigyoshaDaihyoshaEntity();
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYukoKaishiYMD(DEFAULT_有効開始日);
        entity.setDaihyoshaShimei(DEFAULT_代表者名);
        entity.setDaihyoshaKanaShimei(DEFAULT_代表者名カナ);
        entity.setDaihyoshaYubinNo(DEFAULT_代表者郵便番号);
        entity.setDaihyoshaJusho(DEFAULT_代表者住所);
        entity.setDaihyoshaKanaJusho(DEFAULT_代表者住所カナ);
        entity.setDaihyoshaYakushokuMei(DEFAULT_代表者役職名);
        entity.setKaisetsushaShimei(DEFAULT_開設者名);
        entity.setKaisetsushaKanaShimei(DEFAULT_開設者名カナ);
        entity.setKaisetsushaYubinNo(DEFAULT_開設者郵便番号);
        entity.setKaisetsushaJusho(DEFAULT_開設者住所);
        entity.setKaisetsushaKanaJusho(DEFAULT_開設者住所カナ);
        entity.setKaisetsushaTelNo(DEFAULT_開設者電話番号);
        entity.setKaisetsushaFaxNo(DEFAULT_開設者FAX番号);
        return entity;
    }
}
