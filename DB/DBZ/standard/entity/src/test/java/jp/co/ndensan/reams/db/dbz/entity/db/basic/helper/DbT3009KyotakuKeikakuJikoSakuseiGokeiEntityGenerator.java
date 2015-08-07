/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
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
 * 居宅給付計画自己作成合計エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYear("1990");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_居宅サービス区分 = new RString("Data");
    public static final JigyoshaNo DEFAULT_サービス提供事業者番号 = new JigyoshaNo();
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode();
    public static final Decimal DEFAULT_給付計画単位数 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator() {
    }

    public static DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity() {
        DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = new DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKyotakuServiceKubun(DEFAULT_居宅サービス区分);
        entity.setServiceTeikyoJigyoshaNo(DEFAULT_サービス提供事業者番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setKyufuKeikakuTaniSu(DEFAULT_給付計画単位数);
        return entity;
    }
}
