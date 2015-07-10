/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求社会福祉法人軽減額エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_様式番号 = new RString("1");
    public static final RString DEFAULT_順次番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final Decimal DEFAULT_軽減率 = new Decimal(1);
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final int DEFAULT_受領すべき利用者負担の総額 = 1;
    public static final int DEFAULT_軽減額 = 1;
    public static final int DEFAULT_軽減後利用者負担額 = 1;
    public static final RString DEFAULT_備考 = new RString("1");

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
        entity.setJunjiNo(DEFAULT_順次番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKeigenritsu(DEFAULT_軽減率);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setRiyoshaFutangakuTotal(DEFAULT_受領すべき利用者負担の総額);
        entity.setKeigengaku(DEFAULT_軽減額);
        entity.setKeigengoRiyoshaFutangaku(DEFAULT_軽減後利用者負担額);
        entity.setBiko(DEFAULT_備考);
        return entity;
    }
}
