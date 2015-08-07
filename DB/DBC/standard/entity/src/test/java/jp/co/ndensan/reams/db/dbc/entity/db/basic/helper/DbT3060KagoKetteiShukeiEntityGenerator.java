/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3060KagoKetteiShukeiEntity;
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
 * 過誤決定集計エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3060KagoKetteiShukeiEntityGenerator {

    public static final FlexibleYearMonth DEFAULT_取扱年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_保険者区分 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final int DEFAULT_介護給付費件数 = 1;
    public static final Decimal DEFAULT_介護給付費単位数 = new Decimal(0);
    public static final Decimal DEFAULT_介護給付費保険者負担額 = new Decimal(0);
    public static final int DEFAULT_高額介護サービス費件数 = 1;
    public static final Decimal DEFAULT_高額介護サービス費単位数 = new Decimal(0);
    public static final Decimal DEFAULT_高額介護サービス費保険者負担額 = new Decimal(0);
    public static final int DEFAULT_特定入所者介護サービス費等件数 = 1;
    public static final Decimal DEFAULT_特定入所者介護サービス費等費用額 = new Decimal(0);
    public static final Decimal DEFAULT_特定入所者介護サービス費等保険者負担額 = new Decimal(0);
    public static final RString DEFAULT_公費負担者番号 = new RString("Data");
    public static final FlexibleDate DEFAULT_作成年月日 = new FlexibleDate("19900101");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYear("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3060KagoKetteiShukeiEntityGenerator() {
    }

    public static DbT3060KagoKetteiShukeiEntity createDbT3060KagoKetteiShukeiEntity() {
        DbT3060KagoKetteiShukeiEntity entity = new DbT3060KagoKetteiShukeiEntity();
        entity.setToriatsukaiYM(DEFAULT_取扱年月);
        entity.setHokenshaKubun(DEFAULT_保険者区分);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKaigoKyufuhiKensu(DEFAULT_介護給付費件数);
        entity.setKaigoKyufuhiTanisu(DEFAULT_介護給付費単位数);
        entity.setKaigoKyufuhiFutangaku(DEFAULT_介護給付費保険者負担額);
        entity.setKogakuServicehiKensu(DEFAULT_高額介護サービス費件数);
        entity.setKogakuServicehiTanisu(DEFAULT_高額介護サービス費単位数);
        entity.setKogakuServicehiFutangaku(DEFAULT_高額介護サービス費保険者負担額);
        entity.setTokuteiNyushoshaServicehiKensu(DEFAULT_特定入所者介護サービス費等件数);
        entity.setTokuteiNyushoshaServicehiTanisu(DEFAULT_特定入所者介護サービス費等費用額);
        entity.setTokuteiNyushoshaServicehiFutangaku(DEFAULT_特定入所者介護サービス費等保険者負担額);
        entity.setKohiFutanshaNo(DEFAULT_公費負担者番号);
        entity.setSakuseiYMD(DEFAULT_作成年月日);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
