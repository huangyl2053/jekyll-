/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 日常生活予防給付計画自己作成合計エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_居宅サービス区分 = new RString("1");
    public static final JigyoshaNo DEFAULT_サービス提供事業者番号 = new JigyoshaNo(new RString("2"));
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final Decimal DEFAULT_給付計画単位数 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator() {
    }

    public static DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity createDbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity() {
        DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity entity = new DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setKyotakuServiceKubun(DEFAULT_居宅サービス区分);
        entity.setServiceTeikyoJigyoshaNo(DEFAULT_サービス提供事業者番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setKeikakuTaniSu(DEFAULT_給付計画単位数);
        return entity;
    }
}
