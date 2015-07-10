/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3044ShokanShokujiHiyoSagakuShikyuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求食事費用差額支給エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_様式番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final int DEFAULT_差額金額 = 1;
    public static final RString DEFAULT_支給区分コード = new RString("1");
    public static final int DEFAULT_点数金額 = 1;
    public static final int DEFAULT_支給金額 = 1;
    public static final RString DEFAULT_支給_不支給理由 = new RString("1");

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
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setSagakuKingaku(DEFAULT_差額金額);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setTensuKingaku(DEFAULT_点数金額
        );
        entity.setShikyuKingaku(DEFAULT_支給金額);
        entity.setShikyuFushikyuRiyu(DEFAULT_支給_不支給理由);
        return entity;
    }
}
