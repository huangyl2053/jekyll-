/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3081DaisanshaKoiKyufugakuGengakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護第三者行為給付額減額エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("123");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final Decimal DEFAULT_減額対象金額 = new Decimal(10000);
    public static final FlexibleDate DEFAULT_給付額減額期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_給付額減額期間終了年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator() {
    }

    public static DbT3081DaisanshaKoiKyufugakuGengakuEntity createDbT3081DaisanshaKoiKyufugakuGengakuEntity() {
        DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = new DbT3081DaisanshaKoiKyufugakuGengakuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTodokedeKanriNo(DEFAULT_第三者行為届出管理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setGengakuTaishoKingaku(DEFAULT_減額対象金額);
        entity.setGengakuKaishiYMD(DEFAULT_給付額減額期間開始年月日);
        entity.setGengakuShuryoYMD(DEFAULT_給付額減額期間終了年月日);
        return entity;
    }
}
