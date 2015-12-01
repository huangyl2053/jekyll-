/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
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
 */
public final class DbT7062KaigoJigyoshaDaihyoshaEntityGenerator {

    public static final KaigoJigyoshaNo DEFAULT_事業者番号 = new KaigoJigyoshaNo("0123400001");
    public static final FlexibleDate DEFAULT_有効開始日 = new FlexibleDate("20141216");
    public static final AtenaMeisho DEFAULT_代表者名 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_代表者名カナ = new AtenaKanaMeisho("");
    public static final YubinNo DEFAULT_代表者郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_代表者住所 = new AtenaJusho("");
    public static final RString DEFAULT_代表者住所カナ = new RString("Data");
    public static final RString DEFAULT_代表者役職名 = new RString("Data");
    public static final AtenaMeisho DEFAULT_開設者名称 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_開設者名称カナ = new AtenaKanaMeisho("");
    public static final YubinNo DEFAULT_開設者郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_開設者住所 = new AtenaJusho("");
    public static final RString DEFAULT_開設者住所カナ = new RString("Data");
    public static final TelNo DEFAULT_開設者電話番号 = new TelNo("08011112222");
    public static final TelNo DEFAULT_開設者ＦＡＸ番号 = new TelNo("08011112222");

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
        entity.setKaisetsushaShimei(DEFAULT_開設者名称);
        entity.setKaisetsushaKanaShimei(DEFAULT_開設者名称カナ);
        entity.setKaisetsushaYubinNo(DEFAULT_開設者郵便番号);
        entity.setKaisetsushaJusho(DEFAULT_開設者住所);
        entity.setKaisetsushaKanaJusho(DEFAULT_開設者住所カナ);
        entity.setKaisetsushaTelNo(DEFAULT_開設者電話番号);
        entity.setKaisetsushaFaxNo(DEFAULT_開設者ＦＡＸ番号);
        return entity;
    }
}
