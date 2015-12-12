/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅給付計画自己作成エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth("199001");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_居宅総合事業区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_作成区分コード = new RString("Data");
    public static final FlexibleDate DEFAULT_計画作成年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_計画変更年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_計画変更事由 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator() {
    }

    public static DbT3007KyotakuKeikakuJikoSakuseiEntity createDbT3007KyotakuKeikakuJikoSakuseiEntity() {
        DbT3007KyotakuKeikakuJikoSakuseiEntity entity = new DbT3007KyotakuKeikakuJikoSakuseiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKyotaku_SogoJigyoKubun(DEFAULT_居宅総合事業区分);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setSakuseiKubunCode(DEFAULT_作成区分コード);
        entity.setKeikakuSakuseiYMD(DEFAULT_計画作成年月日);
        entity.setKeikakuHenkoYMD(DEFAULT_計画変更年月日);
        entity.setKeikakuHenkoJiyu(DEFAULT_計画変更事由);
        return entity;
    }
}
