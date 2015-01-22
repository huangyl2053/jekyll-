/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求サービス計画200904エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3047ShokanServicePlan200904EntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_様式番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_指定基準該当事業者区分コード = new RString("1");
    public static final RString DEFAULT_明細行番号 = new RString("1");
    public static final FlexibleDate DEFAULT_居宅サービス計画作成依頼届出年月日 = new FlexibleDate("20140402");
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode(new RString("2"));
    public static final int DEFAULT_単位数 = 1;
    public static final int DEFAULT_回数 = 1;
    public static final int DEFAULT_サービス単位数 = 1;
    public static final Decimal DEFAULT_単位数単価 = new Decimal(1);
    public static final int DEFAULT_サービス単位数合計 = 1;
    public static final int DEFAULT_請求金額 = 1;
    public static final RString DEFAULT_担当介護支援専門員番号 = new RString("1");
    public static final RString DEFAULT_摘要 = new RString("1");
    public static final RString DEFAULT_審査方法区分コード = new RString("1");
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_支給区分コード = new RString("1");
    public static final int DEFAULT_点数金額 = 1;
    public static final int DEFAULT_支給金額 = 1;
    public static final int DEFAULT_増減点 = 1;
    public static final int DEFAULT_差額金額 = 1;
    public static final RString DEFAULT_増減理由等 = new RString("1");
    public static final RString DEFAULT_不支給理由等 = new RString("1");
    public static final RString DEFAULT_購入_改修履歴等 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3047ShokanServicePlan200904EntityGenerator() {
    }

    public static DbT3047ShokanServicePlan200904Entity createDbT3047ShokanServicePlan200904Entity() {
        DbT3047ShokanServicePlan200904Entity entity = new DbT3047ShokanServicePlan200904Entity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNp(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShiteiKijunGaitoJigyoshaKubunCode(DEFAULT_指定基準該当事業者区分コード);
        entity.setMeisaiLineNo(DEFAULT_明細行番号);
        entity.setKyotakuServiceSakuseiIraiYMD(DEFAULT_居宅サービス計画作成依頼届出年月日);
        entity.setServiceCode(DEFAULT_サービスコード);
        entity.setTanisu(DEFAULT_単位数);
        entity.setKaisu(DEFAULT_回数);
        entity.setServiceTanisu(DEFAULT_サービス単位数);
        entity.setTanisuTanka(DEFAULT_単位数単価);
        entity.setServiceTanisuTotal(DEFAULT_サービス単位数合計);
        entity.setSeikyuKingaku(DEFAULT_請求金額);
        entity.setTantokangoshienSemmoninNo(DEFAULT_担当介護支援専門員番号);
        entity.setTekiyo(DEFAULT_摘要);
        entity.setShinsaHohoKubunCode(DEFAULT_審査方法区分コード);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setTensuKingaku(DEFAULT_点数金額);
        entity.setShikyuKingaku(DEFAULT_支給金額);
        entity.setZougenTen(DEFAULT_増減点);
        entity.setSagakuKingaku(DEFAULT_差額金額);
        entity.setZougenRiyu(DEFAULT_増減理由等);
        entity.setFushikyuRiyu(DEFAULT_不支給理由等);
        entity.setKounyuKaishuRireki(DEFAULT_購入_改修履歴等);
        return entity;
    }
}
