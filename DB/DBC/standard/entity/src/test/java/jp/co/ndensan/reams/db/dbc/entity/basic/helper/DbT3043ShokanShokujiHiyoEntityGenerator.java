/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求食事費用エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3043ShokanShokujiHiyoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final RString DEFAULT_明細番号 = new RString("Data");
    public static final RString DEFAULT_連番 = new RString("0");
    public static final int DEFAULT_基本提供日数 = 0;
    public static final int DEFAULT_基本提供単価 = 0;
    public static final int DEFAULT_基本提供金額 = 1;
    public static final int DEFAULT_特別提供日数 = 0;
    public static final int DEFAULT_特別提供単価 = 0;
    public static final int DEFAULT_特別提供金額 = 1;
    public static final int DEFAULT_食事提供延べ日数 = 0;
    public static final int DEFAULT_食事提供費合計 = 1;
    public static final int DEFAULT_標準負担額_月額 = 1;
    public static final int DEFAULT_食事提供費請求額 = 1;
    public static final int DEFAULT_標準負担額_日額 = 0;
    public static final RString DEFAULT_支給区分コード = new RString("Data");
    public static final int DEFAULT_点数_金額 = 1;
    public static final int DEFAULT_支給金額 = 1;
    public static final int DEFAULT_増減点 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3043ShokanShokujiHiyoEntityGenerator() {
    }

    public static DbT3043ShokanShokujiHiyoEntity createDbT3043ShokanShokujiHiyoEntity() {
        DbT3043ShokanShokujiHiyoEntity entity = new DbT3043ShokanShokujiHiyoEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setMeisaiNo(DEFAULT_明細番号);
        entity.setRenban(DEFAULT_連番);
        entity.setKihonTeikyoNissu(DEFAULT_基本提供日数);
        entity.setKihonTeikyoTanka(DEFAULT_基本提供単価);
        entity.setKihonTeikyoKingaku(DEFAULT_基本提供金額);
        entity.setTokubetsuTeikyoNissu(DEFAULT_特別提供日数);
        entity.setTokubetsuTeikyoTanka(DEFAULT_特別提供単価);
        entity.setTokubetsuTeikyoKingaku(DEFAULT_特別提供金額);
        entity.setShokujiTeikyoTotalNissu(DEFAULT_食事提供延べ日数);
        entity.setShokujiTeikyohiTotal(DEFAULT_食事提供費合計);
        entity.setGetsugakuHyojunFutangaku(DEFAULT_標準負担額_月額);
        entity.setShokujiTeikyohiSeikyugaku(DEFAULT_食事提供費請求額);
        entity.setNichigakuHyojunFutangaku(DEFAULT_標準負担額_日額);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setTensuKingaku(DEFAULT_点数_金額);
        entity.setShikyuKingaku(DEFAULT_支給金額);
        entity.setZougenTen(DEFAULT_増減点);
        return entity;
    }
}
