/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3092KyufuhiKashitsukeKinChoshuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金徴収エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final RString DEFAULT_貸付管理番号 = new RString("123");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_貸付金返還徴収方法 = new RString("1");
    public static final FlexibleDate DEFAULT_貸付金返還徴収年月日 = new FlexibleDate("20140402");
    public static final Decimal DEFAULT_貸付金返還徴収金額 = new Decimal(10000);
    public static final RString DEFAULT_過不足判定結果区分 = new RString("3");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator() {
    }

    public static DbT3092KyufuhiKashitsukeKinChoshuEntity createDbT3092KyufuhiKashitsukeKinChoshuEntity() {
        DbT3092KyufuhiKashitsukeKinChoshuEntity entity = new DbT3092KyufuhiKashitsukeKinChoshuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKashitsukeKanriNo(DEFAULT_貸付管理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setHenkanChoshuHoho(DEFAULT_貸付金返還徴収方法);
        entity.setHenkanChoshuYMD(DEFAULT_貸付金返還徴収年月日);
        entity.setHenkanChoshuKingaku(DEFAULT_貸付金返還徴収金額);
        entity.setKabusokuHanteiKekkaKubun(DEFAULT_過不足判定結果区分);
        return entity;
    }
}
