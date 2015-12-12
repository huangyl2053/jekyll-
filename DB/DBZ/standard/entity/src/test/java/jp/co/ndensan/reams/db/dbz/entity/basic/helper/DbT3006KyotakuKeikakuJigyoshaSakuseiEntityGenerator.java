/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅給付計画事業者作成エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth("199001");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_作成区分コード = new RString("Data");
    public static final JigyoshaNo DEFAULT_計画事業者番号 = new JigyoshaNo("1");
    public static final JigyoshaNo DEFAULT_委託先事業者番号 = new JigyoshaNo("1");
    public static final FlexibleDate DEFAULT_事業者変更年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_事業者変更事由 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator() {
    }

    public static DbT3006KyotakuKeikakuJigyoshaSakuseiEntity createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity() {
        DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity = new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
        entity.setHihokenshano(DEFAULT_被保険者番号);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setSakuseiKubunCode(DEFAULT_作成区分コード);
        entity.setKeikakuJigyoshaNo(DEFAULT_計画事業者番号);
        entity.setItakusakiJigyoshaNo(DEFAULT_委託先事業者番号);
        entity.setJigyoshaHenkoYMD(DEFAULT_事業者変更年月日);
        entity.setJigyoshaHenkoJiyu(DEFAULT_事業者変更事由);
        return entity;
    }
}
