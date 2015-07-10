/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績住宅改修費エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3027KyufujissekiJutakuKaishuhiEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo(new RString("2"));
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo(new RString("2"));
    public static final RString DEFAULT_レコード種別コード = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_通し番号 = new RString("1");
    public static final RString DEFAULT_明細番号 = new RString("1");
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode(new RString("2"));
    public static final FlexibleDate DEFAULT_住宅改修着工年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_住宅改修事業者名 = new RString("1");
    public static final RString DEFAULT_住宅改修住宅住所 = new RString("1");
    public static final int DEFAULT_改修金額 = 1;
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3027KyufujissekiJutakuKaishuhiEntityGenerator() {
    }

    public static DbT3027KyufujissekiJutakuKaishuhiEntity createDbT3027KyufujissekiJutakuKaishuhiEntity() {
        DbT3027KyufujissekiJutakuKaishuhiEntity entity = new DbT3027KyufujissekiJutakuKaishuhiEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setMeisaiNo(DEFAULT_明細番号);
        entity.setServiceCode(DEFAULT_サービスコード);
        entity.setJutakuKaishuchakkoYMD(DEFAULT_住宅改修着工年月日);
        entity.setJutakuKaishuJigyoshaName(DEFAULT_住宅改修事業者名);
        entity.setJuutakukaishuJyutakuAdress(DEFAULT_住宅改修住宅住所);
        entity.setKaishuKingaku(DEFAULT_改修金額);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
