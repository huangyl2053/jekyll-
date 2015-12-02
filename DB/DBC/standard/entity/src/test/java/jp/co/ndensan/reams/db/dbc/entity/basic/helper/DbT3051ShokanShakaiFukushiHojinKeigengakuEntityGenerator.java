/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求社会福祉法人軽減額エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final RString DEFAULT_順次番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_軽減率 = new Decimal(0);
    public static final ShinseishoKanriNo DEFAULT_サービス種類コード = new ShinseishoKanriNo("1");
    public static final int DEFAULT_受領すべき利用者負担の総額 = 1;
    public static final int DEFAULT_軽減額 = 1;
    public static final int DEFAULT_軽減後利用者負担額 = 1;
    public static final RString DEFAULT_備考 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator() {
    }

    public static DbT3051ShokanShakaiFukushiHojinKeigengakuEntity createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity() {
        DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setKeigenritsu(DEFAULT_軽減率);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setRiyoshaFutangakuTotal(DEFAULT_受領すべき利用者負担の総額);
        entity.setKeigengaku(DEFAULT_軽減額);
        entity.setKeigengoRiyoshaFutangaku(DEFAULT_軽減後利用者負担額);
        entity.setBiko(DEFAULT_備考);
        return entity;
    }
}
