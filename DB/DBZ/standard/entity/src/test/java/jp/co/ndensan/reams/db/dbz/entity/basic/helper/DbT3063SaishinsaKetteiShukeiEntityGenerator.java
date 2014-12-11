/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 再審査決定集計エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3063SaishinsaKetteiShukeiEntityGenerator {

    public static final FlexibleYearMonth DEFAULT_取扱年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_保険者区分 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final int DEFAULT_介護給付費_請求_件数 = 1;
    public static final Decimal DEFAULT_介護給付費_請求_単位数 = new Decimal(1);
    public static final Decimal DEFAULT_介護給付費_請求_保険者負担額 = new Decimal(1);
    public static final int DEFAULT_介護給付費_決定_件数 = 1;
    public static final Decimal DEFAULT_介護給付費_決定_単位数 = new Decimal(1);
    public static final Decimal DEFAULT_介護給付費_決定_保険者負担額 = new Decimal(1);
    public static final int DEFAULT_介護給付費_調整_件数 = 1;
    public static final Decimal DEFAULT_介護給付費_調整_単位数 = new Decimal(1);
    public static final Decimal DEFAULT_介護給付費_調整_保険者負担額 = new Decimal(1);
    public static final int DEFAULT_高額介護サービス費_請求_件数 = 1;
    public static final Decimal DEFAULT_高額介護サービス費_請求_単位数 = new Decimal(1);
    public static final Decimal DEFAULT_高額介護サービス費_請求_保険者負担額 = new Decimal(1);
    public static final int DEFAULT_高額介護サービス費_決定_件数 = 1;
    public static final Decimal DEFAULT_高額介護サービス費_決定_単位数 = new Decimal(1);
    public static final Decimal DEFAULT_高額介護サービス費_決定_保険者負担額 = new Decimal(1);
    public static final int DEFAULT_高額介護サービス費_調整_件数 = 1;
    public static final Decimal DEFAULT_高額介護サービス費_調整_単位数 = new Decimal(1);
    public static final Decimal DEFAULT_高額介護サービス費_調整_保険者負担額 = new Decimal(1);
    public static final RString DEFAULT_公費負担者番号 = new RString("1");
    public static final FlexibleDate DEFAULT_作成年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_審査委員会名 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3063SaishinsaKetteiShukeiEntityGenerator() {
    }

    public static DbT3063SaishinsaKetteiShukeiEntity createDbT3063SaishinsaKetteiShukeiEntity() {
        DbT3063SaishinsaKetteiShukeiEntity entity = new DbT3063SaishinsaKetteiShukeiEntity();
        entity.setToriatsukaiYM(DEFAULT_取扱年月);
        entity.setHokenshaKubun(DEFAULT_保険者区分);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKaigoKyufuhiSeikyuKensu(DEFAULT_介護給付費_請求_件数);
        entity.setKaigoKyufuhiSeikyuTanisu(DEFAULT_介護給付費_請求_単位数);
        entity.setKaigoKyufuhiSeikyuFutangaku(DEFAULT_介護給付費_請求_保険者負担額);
        entity.setKaigoKyufuhiKetteiKensu(DEFAULT_介護給付費_決定_件数);
        entity.setKaigoKyufuhiKetteiTanisu(DEFAULT_介護給付費_決定_単位数);
        entity.setKaigoKyufuhiKetteiFutangaku(DEFAULT_介護給付費_決定_保険者負担額);
        entity.setKaigoKyufuhiChoseiKensu(DEFAULT_介護給付費_調整_件数);
        entity.setKaigoKyufuhiChoseiTanisu(DEFAULT_介護給付費_調整_単位数);
        entity.setKaigoKyufuhiChoseiFutangaku(DEFAULT_介護給付費_調整_保険者負担額);
        entity.setKogakuKaigoServicehiSeikyuKensu(DEFAULT_高額介護サービス費_請求_件数);
        entity.setKogakuKaigoServicehiSeikyuTanisu(DEFAULT_高額介護サービス費_請求_単位数);
        entity.setKogakuKaigoServicehiSeikyuFutangaku(DEFAULT_高額介護サービス費_請求_保険者負担額);
        entity.setKogakuKaigoServicehiKetteiKensu(DEFAULT_高額介護サービス費_決定_件数);
        entity.setKogakuKaigoServicehiKetteiTanisu(DEFAULT_高額介護サービス費_決定_単位数);
        entity.setKogakuKaigoServicehiKetteiFutangaku(DEFAULT_高額介護サービス費_決定_保険者負担額);
        entity.setKogakuKaigoServicehiChoseiKensu(DEFAULT_高額介護サービス費_調整_件数);
        entity.setKogakuKaigoServicehiChoseiTanisu(DEFAULT_高額介護サービス費_調整_単位数);
        entity.setKogakuKaigoServicehiChoseiFutangaku(DEFAULT_高額介護サービス費_調整_保険者負担額);
        entity.setKohiFutanshaNo(DEFAULT_公費負担者番号);
        entity.setSakuseiYMD(DEFAULT_作成年月日);
        entity.setSinsaiinkaiName(DEFAULT_審査委員会名);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
