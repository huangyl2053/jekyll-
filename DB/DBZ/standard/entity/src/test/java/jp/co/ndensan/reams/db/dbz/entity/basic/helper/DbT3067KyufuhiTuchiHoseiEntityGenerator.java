/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3067KyufuhiTuchiHoseiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費通知補正エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3067KyufuhiTuchiHoseiEntityGenerator {

    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo(new RString("2"));
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final Decimal DEFAULT_サービス費用合計額 = new Decimal(1);
    public static final Decimal DEFAULT_利用者負担額 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3067KyufuhiTuchiHoseiEntityGenerator() {
    }

    public static DbT3067KyufuhiTuchiHoseiEntity createDbT3067KyufuhiTuchiHoseiEntity() {
        DbT3067KyufuhiTuchiHoseiEntity entity = new DbT3067KyufuhiTuchiHoseiEntity();
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setServiceHiyoTotal(DEFAULT_サービス費用合計額);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        return entity;
    }
}
