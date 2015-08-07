/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
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
 * 居宅給付計画事業者作成エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator {

    public static final none DEFAULT_被保険者番号 = new none();
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYear("1990");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_作成区分コード = new RString("Data");
    public static final JigyoshaNo DEFAULT_計画事業者番号 = new JigyoshaNo();
    public static final JigyoshaNo DEFAULT_委託先事業者番号 = new JigyoshaNo();
    public static final FlexibleDate DEFAULT_事業者変更年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_事業者変更事由 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator() {
    }

    public static DbT3006KyotakuKeikakuJigyoshaSakuseiEntity createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity() {
        DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity = new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
        entity.setNone(DEFAULT_被保険者番号);
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
