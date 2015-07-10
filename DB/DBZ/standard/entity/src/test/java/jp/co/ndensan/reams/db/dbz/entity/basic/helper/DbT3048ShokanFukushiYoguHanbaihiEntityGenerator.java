/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求福祉用具販売費エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3048ShokanFukushiYoguHanbaihiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_様式番号 = new RString("1");
    public static final RString DEFAULT_順次番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode(new RString("2"));
    public static final FlexibleDate DEFAULT_福祉用具販売年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_福祉用具商品名 = new RString("1");
    public static final RString DEFAULT_福祉用具種目コード = new RString("1");
    public static final RString DEFAULT_福祉用具製造事業者名 = new RString("1");
    public static final RString DEFAULT_福祉用具販売事業者名 = new RString("1");
    public static final int DEFAULT_購入金額 = 1;
    public static final RString DEFAULT_品目コード = new RString("1");
    public static final RString DEFAULT_審査方法区分コード = new RString("1");
    public static final int DEFAULT_差額金額 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3048ShokanFukushiYoguHanbaihiEntityGenerator() {
    }

    public static DbT3048ShokanFukushiYoguHanbaihiEntity createDbT3048ShokanFukushiYoguHanbaihiEntity() {
        DbT3048ShokanFukushiYoguHanbaihiEntity entity = new DbT3048ShokanFukushiYoguHanbaihiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setJunjiNo(DEFAULT_順次番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setServiceCode(DEFAULT_サービスコード);
        entity.setFukushiYoguHanbaiYMD(DEFAULT_福祉用具販売年月日);
        entity.setFukushiYoguShohinName(DEFAULT_福祉用具商品名);
        entity.setFukushiYoguShumokuCode(DEFAULT_福祉用具種目コード);
        entity.setFukushiYoguSeizoJigyoshaName(DEFAULT_福祉用具製造事業者名);
        entity.setFukushiYoguHanbaiJigyoshaName(DEFAULT_福祉用具販売事業者名);
        entity.setKounyuKingaku(DEFAULT_購入金額);
        entity.setHinmokuCode(DEFAULT_品目コード);
        entity.setShinsaHohoKubunCode(DEFAULT_審査方法区分コード);
        entity.setSagakuKingaku(DEFAULT_差額金額);
        return entity;
    }
}
