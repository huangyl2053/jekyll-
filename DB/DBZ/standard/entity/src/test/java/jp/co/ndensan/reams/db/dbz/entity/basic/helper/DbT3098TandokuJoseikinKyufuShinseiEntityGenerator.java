/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村単独助成金給付申請エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3098TandokuJoseikinKyufuShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_申請者区分 = new RString("1");
    public static final JigyoshaNo DEFAULT_申請代行事業者番号 = new JigyoshaNo(new RString("02"));
    public static final RString DEFAULT_事業者区分 = new RString("1");
    public static final YubinNo DEFAULT_申請者郵便番号 = new YubinNo(new RString("0250301"));
    public static final RString DEFAULT_申請者住所 = new RString("123");
    public static final TelNo DEFAULT_申請者電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_申請理由 = new RString("1");
    public static final RString DEFAULT_市町村単独助成種類 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3098TandokuJoseikinKyufuShinseiEntityGenerator() {
    }

    public static DbT3098TandokuJoseikinKyufuShinseiEntity createDbT3098TandokuJoseikinKyufuShinseiEntity() {
        DbT3098TandokuJoseikinKyufuShinseiEntity entity = new DbT3098TandokuJoseikinKyufuShinseiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setShinseishaKubun(DEFAULT_申請者区分);
        entity.setDaikoJigyoshaNo(DEFAULT_申請代行事業者番号);
        entity.setJigyoshaKubun(DEFAULT_事業者区分);
        entity.setShinseishaYubinNo(DEFAULT_申請者郵便番号);
        entity.setShinseishaJusho(DEFAULT_申請者住所);
        entity.setShinseishaTelNo(DEFAULT_申請者電話番号);
        entity.setShinseiRiyu(DEFAULT_申請理由);
        entity.setTandokuJoseiShuruiCode(DEFAULT_市町村単独助成種類);
        return entity;
    }
}
