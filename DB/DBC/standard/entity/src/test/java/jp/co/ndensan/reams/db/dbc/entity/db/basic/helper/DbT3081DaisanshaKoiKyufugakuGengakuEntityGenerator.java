/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3081DaisanshaKoiKyufugakuGengakuEntity;
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
 * 介護第三者行為給付額減額エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_減額対象金額 = new Decimal(0);
    public static final FlexibleDate DEFAULT_給付額減額期間開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_給付額減額期間終了年月日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator() {
    }

    public static DbT3081DaisanshaKoiKyufugakuGengakuEntity createDbT3081DaisanshaKoiKyufugakuGengakuEntity() {
        DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = new DbT3081DaisanshaKoiKyufugakuGengakuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTodokedeKanriNo(DEFAULT_第三者行為届出管理番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setGengakuTaishoKingaku(DEFAULT_減額対象金額);
        entity.setGengakuKaishiYMD(DEFAULT_給付額減額期間開始年月日);
        entity.setGengakuShuryoYMD(DEFAULT_給付額減額期間終了年月日);
        return entity;
    }
}
