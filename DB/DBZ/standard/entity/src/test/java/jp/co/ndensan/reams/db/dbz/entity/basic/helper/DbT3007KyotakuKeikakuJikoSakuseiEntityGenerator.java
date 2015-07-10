/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅給付計画自己作成エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_居宅_総合事業区分 = new RString("1");
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_計画作成年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_計画変更年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_計画変更事由 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator() {
    }

    public static DbT3007KyotakuKeikakuJikoSakuseiEntity createDbT3007KyotakuKeikakuJikoSakuseiEntity() {
        DbT3007KyotakuKeikakuJikoSakuseiEntity entity = new DbT3007KyotakuKeikakuJikoSakuseiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKyotaku_SogoJigyoKubun(DEFAULT_居宅_総合事業区分);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setKeikakuSakuseiYMD(DEFAULT_計画作成年月日);
        entity.setKeikakuHenkoYMD(DEFAULT_計画変更年月日);
        entity.setKeikakuHenkoJiyu(DEFAULT_計画変更事由);
        return entity;
    }
}
