/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 市町村単独助成金給付申請エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3098TandokuJoseikinKyufuShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_申請者区分 = new RString("Data");
    public static final JigyoshaNo DEFAULT_申請代行事業者番号 = new JigyoshaNo();
    public static final RString DEFAULT_事業者区分 = new RString("Data");
    public static final YubinNo DEFAULT_申請者郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_申請者住所 = new RString("Data");
    public static final TelNo DEFAULT_申請者電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_申請理由 = new RString("Data");
    public static final RString DEFAULT_市町村単独助成種類 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3098TandokuJoseikinKyufuShinseiEntityGenerator() {
    }

    public static DbT3098TandokuJoseikinKyufuShinseiEntity createDbT3098TandokuJoseikinKyufuShinseiEntity() {
        DbT3098TandokuJoseikinKyufuShinseiEntity entity = new DbT3098TandokuJoseikinKyufuShinseiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
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
