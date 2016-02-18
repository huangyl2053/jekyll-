/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求特定診療費・特別療養費エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final RString DEFAULT_明細番号 = new RString("Data");
    public static final RString DEFAULT_連番 = new RString("0");
    public static final RString DEFAULT_傷病名 = new RString("Data");
    public static final RString DEFAULT_識別番号 = new RString("Data");
    public static final int DEFAULT_単位数 = 0;
    public static final int DEFAULT_回数 = 0;
    public static final int DEFAULT_サービス単位数 = 1;
    public static final int DEFAULT_合計単位数 = 1;
    public static final RString DEFAULT_摘要 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator() {
    }

    public static DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity() {
        DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setMeisaiNo(DEFAULT_明細番号);
        entity.setRenban(DEFAULT_連番);
        entity.setShobyoName(DEFAULT_傷病名);
        entity.setShikibetsuNo(DEFAULT_識別番号);
        entity.setTanisu(DEFAULT_単位数);
        entity.setKaisu(DEFAULT_回数);
        entity.setServiceTanisu(DEFAULT_サービス単位数);
        entity.setTotalTanisu(DEFAULT_合計単位数);
        entity.setTekiyo(DEFAULT_摘要);
        return entity;
    }
}
