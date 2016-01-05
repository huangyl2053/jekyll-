/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3044ShokanShokujiHiyoSagakuShikyuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求食事費用差額支給エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final RString DEFAULT_明細番号 = new RString("Data");
    public static final RString DEFAULT_連番 = new RString("Data");
    public static final int DEFAULT_差額金額 = 1;
    public static final RString DEFAULT_支給区分コード = new RString("Data");
    public static final int DEFAULT_点数_金額 = 1;
    public static final int DEFAULT_支給金額 = 1;
    public static final RString DEFAULT_支給_不支給理由 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator() {
    }

    public static DbT3044ShokanShokujiHiyoSagakuShikyuEntity createDbT3044ShokanShokujiHiyoSagakuShikyuEntity() {
        DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = new DbT3044ShokanShokujiHiyoSagakuShikyuEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNp(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setMeisaiNo(DEFAULT_明細番号);
        entity.setRenban(DEFAULT_連番);
        entity.setSagakuKingaku(DEFAULT_差額金額);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setTensuKingaku(DEFAULT_点数_金額);
        entity.setShikyuKingaku(DEFAULT_支給金額);
        entity.setShikyuFushikyuRiyu(DEFAULT_支給_不支給理由);
        return entity;
    }
}
