/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3044ShokanShokujiHiyoSagakuShikyuEntity;
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
 * 償還払請求食事費用差額支給エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo();
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final int DEFAULT_差額金額 = 1;
    public static final RString DEFAULT_支給区分コード = new RString("Data");
    public static final int DEFAULT_点数／金額 = 1;
    public static final int DEFAULT_支給金額 = 1;
    public static final RString DEFAULT_支給・不支給理由 = new RString("Data");

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
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setSagakuKingaku(DEFAULT_差額金額);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setTensuKingaku(DEFAULT_点数／金額);
        entity.setShikyuKingaku(DEFAULT_支給金額);
        entity.setShikyuFushikyuRiyu(DEFAULT_支給・不支給理由);
        return entity;
    }
}
