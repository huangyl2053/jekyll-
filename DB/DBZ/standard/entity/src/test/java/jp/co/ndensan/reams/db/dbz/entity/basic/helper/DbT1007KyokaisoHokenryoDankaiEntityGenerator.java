/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 境界層保険料段階エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT1007KyokaisoHokenryoDankaiEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth(new RString("201406"));
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_保険料納付減額後保険料段階 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1007KyokaisoHokenryoDankaiEntityGenerator() {
    }

    public static DbT1007KyokaisoHokenryoDankaiEntity createDbT1007KyokaisoHokenryoDankaiEntity() {
        DbT1007KyokaisoHokenryoDankaiEntity entity = new DbT1007KyokaisoHokenryoDankaiEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimeStamp(DEFAULT_処理日時);
        entity.setTekiyoKaishiYM(DEFAULT_適用開始年月);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setGengakuGoHokenryoDankai(DEFAULT_保険料納付減額後保険料段階);
        return entity;
    }
}
