/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅給付計画事業者作成エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator {

    public static final RString DEFAULT_被保険者番号 = new RString("1");
    public static final RString DEFAULT_証記載保険者番号 = new RString("1");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_計画事業者番号 = new RString("1");
    public static final RString DEFAULT_委託先事業者番号 = new RString("1");
    public static final FlexibleDate DEFAULT_事業者変更年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_事業者変更事由 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator() {
    }

    public static DbT3006KyotakuKeikakuJigyoshaSakuseiEntity createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity() {
        DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity = new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
        entity.setHihokenshano(DEFAULT_被保険者番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setKeikakuJigyoshaNo(DEFAULT_計画事業者番号);
        entity.setItakusakiJigyoshaNo(DEFAULT_委託先事業者番号);
        entity.setJigyoshaHenkoYMD(DEFAULT_事業者変更年月日);
        entity.setJigyoshaHenkoJiyu(DEFAULT_事業者変更事由);
        return entity;
    }
}
