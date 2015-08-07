/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukeiEntity;
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
 * 再審査決定集計エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3063SaishinsaKetteiShukeiEntityGenerator {

    public static final FlexibleYearMonth DEFAULT_取扱年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_保険者区分 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final int DEFAULT_介護給付費・請求・件数 = 1;
    public static final Decimal DEFAULT_介護給付費・請求・単位数 = new Decimal(0);
    public static final Decimal DEFAULT_介護給付費・請求・保険者負担額 = new Decimal(0);
    public static final int DEFAULT_介護給付費・決定・件数 = 1;
    public static final Decimal DEFAULT_介護給付費・決定・単位数 = new Decimal(0);
    public static final Decimal DEFAULT_介護給付費・決定・保険者負担額 = new Decimal(0);
    public static final int DEFAULT_介護給付費・調整・件数 = 1;
    public static final Decimal DEFAULT_介護給付費・調整・単位数 = new Decimal(0);
    public static final Decimal DEFAULT_介護給付費・調整・保険者負担額 = new Decimal(0);
    public static final int DEFAULT_高額介護サービス費・請求・件数 = 1;
    public static final Decimal DEFAULT_高額介護サービス費・請求・単位数 = new Decimal(0);
    public static final Decimal DEFAULT_高額介護サービス費・請求・保険者負担額 = new Decimal(0);
    public static final int DEFAULT_高額介護サービス費・決定・件数 = 1;
    public static final Decimal DEFAULT_高額介護サービス費・決定・単位数 = new Decimal(0);
    public static final Decimal DEFAULT_高額介護サービス費・決定・保険者負担額 = new Decimal(0);
    public static final int DEFAULT_高額介護サービス費・調整・件数 = 1;
    public static final Decimal DEFAULT_高額介護サービス費・調整・単位数 = new Decimal(0);
    public static final Decimal DEFAULT_高額介護サービス費・調整・保険者負担額 = new Decimal(0);
    public static final RString DEFAULT_公費負担者番号 = new RString("Data");
    public static final FlexibleDate DEFAULT_作成年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_審査委員会名 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYear("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3063SaishinsaKetteiShukeiEntityGenerator() {
    }

    public static DbT3063SaishinsaKetteiShukeiEntity createDbT3063SaishinsaKetteiShukeiEntity() {
        DbT3063SaishinsaKetteiShukeiEntity entity = new DbT3063SaishinsaKetteiShukeiEntity();
        entity.setToriatsukaiYM(DEFAULT_取扱年月);
        entity.setHokenshaKubun(DEFAULT_保険者区分);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKaigoKyufuhiSeikyuKensu(DEFAULT_介護給付費・請求・件数);
        entity.setKaigoKyufuhiSeikyuTanisu(DEFAULT_介護給付費・請求・単位数);
        entity.setKaigoKyufuhiSeikyuFutangaku(DEFAULT_介護給付費・請求・保険者負担額);
        entity.setKaigoKyufuhiKetteiKensu(DEFAULT_介護給付費・決定・件数);
        entity.setKaigoKyufuhiKetteiTanisu(DEFAULT_介護給付費・決定・単位数);
        entity.setKaigoKyufuhiKetteiFutangaku(DEFAULT_介護給付費・決定・保険者負担額);
        entity.setKaigoKyufuhiChoseiKensu(DEFAULT_介護給付費・調整・件数);
        entity.setKaigoKyufuhiChoseiTanisu(DEFAULT_介護給付費・調整・単位数);
        entity.setKaigoKyufuhiChoseiFutangaku(DEFAULT_介護給付費・調整・保険者負担額);
        entity.setKogakuKaigoServicehiSeikyuKensu(DEFAULT_高額介護サービス費・請求・件数);
        entity.setKogakuKaigoServicehiSeikyuTanisu(DEFAULT_高額介護サービス費・請求・単位数);
        entity.setKogakuKaigoServicehiSeikyuFutangaku(DEFAULT_高額介護サービス費・請求・保険者負担額);
        entity.setKogakuKaigoServicehiKetteiKensu(DEFAULT_高額介護サービス費・決定・件数);
        entity.setKogakuKaigoServicehiKetteiTanisu(DEFAULT_高額介護サービス費・決定・単位数);
        entity.setKogakuKaigoServicehiKetteiFutangaku(DEFAULT_高額介護サービス費・決定・保険者負担額);
        entity.setKogakuKaigoServicehiChoseiKensu(DEFAULT_高額介護サービス費・調整・件数);
        entity.setKogakuKaigoServicehiChoseiTanisu(DEFAULT_高額介護サービス費・調整・単位数);
        entity.setKogakuKaigoServicehiChoseiFutangaku(DEFAULT_高額介護サービス費・調整・保険者負担額);
        entity.setKohiFutanshaNo(DEFAULT_公費負担者番号);
        entity.setSakuseiYMD(DEFAULT_作成年月日);
        entity.setSinsaiinkaiName(DEFAULT_審査委員会名);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
