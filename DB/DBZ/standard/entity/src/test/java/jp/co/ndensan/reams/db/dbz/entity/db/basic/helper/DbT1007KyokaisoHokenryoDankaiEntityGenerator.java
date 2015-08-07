/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
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
 * 境界層保険料段階エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT1007KyokaisoHokenryoDankaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYear("1990");
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_保険料納付減額後保険料段階 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1007KyokaisoHokenryoDankaiEntityGenerator() {
    }

    public static DbT1007KyokaisoHokenryoDankaiEntity createDbT1007KyokaisoHokenryoDankaiEntity() {
        DbT1007KyokaisoHokenryoDankaiEntity entity = new DbT1007KyokaisoHokenryoDankaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTekiyoKaishiYM(DEFAULT_適用開始年月);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setGengakuGoHokenryoDankai(DEFAULT_保険料納付減額後保険料段階);
        return entity;
    }
}
