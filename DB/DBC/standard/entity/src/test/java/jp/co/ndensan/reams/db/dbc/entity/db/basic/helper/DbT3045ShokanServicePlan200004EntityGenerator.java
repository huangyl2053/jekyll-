/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3045ShokanServicePlan200004Entity;
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
 * 償還払請求サービス計画200004エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3045ShokanServicePlan200004EntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo();
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_指定／基準該当事業者区分コード = new RString("Data");
    public static final FlexibleDate DEFAULT_居宅サービス計画作成依頼届出年月日 = new FlexibleDate("19900101");
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode();
    public static final int DEFAULT_単位数 = 1;
    public static final Decimal DEFAULT_単位数単価 = new Decimal(0);
    public static final int DEFAULT_請求金額 = 1;
    public static final RString DEFAULT_審査方法区分コード = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_支給区分コード = new RString("Data");
    public static final int DEFAULT_点数／金額 = 1;
    public static final int DEFAULT_支給金額 = 1;
    public static final int DEFAULT_増減点 = 1;
    public static final int DEFAULT_差額金額 = 1;
    public static final RString DEFAULT_増減理由等 = new RString("Data");
    public static final RString DEFAULT_不支給理由等 = new RString("Data");
    public static final RString DEFAULT_購入・改修履歴等 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3045ShokanServicePlan200004EntityGenerator() {
    }

    public static DbT3045ShokanServicePlan200004Entity createDbT3045ShokanServicePlan200004Entity() {
        DbT3045ShokanServicePlan200004Entity entity = new DbT3045ShokanServicePlan200004Entity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNp(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShiteiKijunGaitoJigyoshaKubunCode(DEFAULT_指定／基準該当事業者区分コード);
        entity.setKyotakuServiceSakuseiIraiYMD(DEFAULT_居宅サービス計画作成依頼届出年月日);
        entity.setServiceCode(DEFAULT_サービスコード);
        entity.setTanisu(DEFAULT_単位数);
        entity.setTanisuTanka(DEFAULT_単位数単価);
        entity.setSeikyuKingaku(DEFAULT_請求金額);
        entity.setShinsaHohoKubunCode(DEFAULT_審査方法区分コード);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setTensuKingaku(DEFAULT_点数／金額);
        entity.setShikyuKingaku(DEFAULT_支給金額);
        entity.setZougenTen(DEFAULT_増減点);
        entity.setSagakuKingaku(DEFAULT_差額金額);
        entity.setZougenRiyu(DEFAULT_増減理由等);
        entity.setFushikyuRiyu(DEFAULT_不支給理由等);
        entity.setKounyuKaishuRireki(DEFAULT_購入・改修履歴等);
        return entity;
    }
}
