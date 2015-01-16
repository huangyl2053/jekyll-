/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 市町村単独助成金給付決定エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3097TandokuJoseikinKyufuKetteiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_有効期限 = new FlexibleDate("20150402");
    public static final RString DEFAULT_利用者負担_決定区分 = new RString("1");
    public static final RString DEFAULT_利用者負担_不承認理由 = new RString("3");
    public static final RString DEFAULT_公費受給者番号 = new RString("16123");
    public static final RString DEFAULT_公費負担者番号 = new RString("12123");
    public static final HokenKyufuRitsu DEFAULT_給付率 = new HokenKyufuRitsu(new Decimal("1"));
    public static final RString DEFAULT_受給者番号 = new RString("5123");
    public static final RString DEFAULT_経過措置 = new RString("1");
    public static final RString DEFAULT_国軽減 = new RString("1");
    public static final RString DEFAULT_社会福祉法人軽減 = new RString("1");
    public static final RString DEFAULT_特別地域加算 = new RString("1");
    public static final RString DEFAULT_保留区分_滞納 = new RString("2");
    public static final RString DEFAULT_保留区分_認定申請中 = new RString("1");
    public static final RString DEFAULT_保留区分_認定有効期限切れ = new RString("3");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3097TandokuJoseikinKyufuKetteiEntityGenerator() {
    }

    public static DbT3097TandokuJoseikinKyufuKetteiEntity createDbT3097TandokuJoseikinKyufuKetteiEntity() {
        DbT3097TandokuJoseikinKyufuKetteiEntity entity = new DbT3097TandokuJoseikinKyufuKetteiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setYukoKigenYMD(DEFAULT_有効期限);
        entity.setRiyoshaFutan_KetteiKubun(DEFAULT_利用者負担_決定区分);
        entity.setRiyoshaFutan_FuShoninRiyu(DEFAULT_利用者負担_不承認理由);
        entity.setKohi_JukyushaNo(DEFAULT_公費受給者番号);
        entity.setKohi_FutanshaNo(DEFAULT_公費負担者番号);
        entity.setKyufuRitsu(DEFAULT_給付率);
        entity.setJukyushaNo(DEFAULT_受給者番号);
        entity.setKeikaSochiKubun(DEFAULT_経過措置);
        entity.setKuniKeigenKubun(DEFAULT_国軽減);
        entity.setShakaiFukushiHojinKeigenKubun(DEFAULT_社会福祉法人軽減);
        entity.setTokubetsuChiikiKasanKubun(DEFAULT_特別地域加算);
        entity.setTaino_HoryuKubun(DEFAULT_保留区分_滞納);
        entity.setNinteiShinseichu_HoryuKubun(DEFAULT_保留区分_認定申請中);
        entity.setNinteiKigenGire_HoryuKubun(DEFAULT_保留区分_認定有効期限切れ);
        return entity;
    }
}
