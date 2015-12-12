/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求福祉用具販売費エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3048ShokanFukushiYoguHanbaihiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final RString DEFAULT_順次番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode("1");
    public static final FlexibleDate DEFAULT_福祉用具販売年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_福祉用具商品名 = new RString("Data");
    public static final RString DEFAULT_福祉用具種目コード = new RString("Data");
    public static final RString DEFAULT_福祉用具製造事業者名 = new RString("Data");
    public static final RString DEFAULT_福祉用具販売事業者名 = new RString("Data");
    public static final int DEFAULT_購入金額 = 1;
    public static final RString DEFAULT_品目コード = new RString("Data");
    public static final RString DEFAULT_審査方法区分コード = new RString("Data");
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
        entity.setRirekiNo(DEFAULT_履歴番号);
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
