/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3092KyufuhiKashitsukeKinChoshuEntity;
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
 * 給付費貸付金徴収エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final RString DEFAULT_貸付管理番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_貸付金返還徴収方法 = new RString("Data");
    public static final FlexibleDate DEFAULT_貸付金返還徴収年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_貸付金返還徴収金額 = new Decimal(0);
    public static final RString DEFAULT_過不足判定結果区分 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator() {
    }

    public static DbT3092KyufuhiKashitsukeKinChoshuEntity createDbT3092KyufuhiKashitsukeKinChoshuEntity() {
        DbT3092KyufuhiKashitsukeKinChoshuEntity entity = new DbT3092KyufuhiKashitsukeKinChoshuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKashitsukeKanriNo(DEFAULT_貸付管理番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setHenkanChoshuHoho(DEFAULT_貸付金返還徴収方法);
        entity.setHenkanChoshuYMD(DEFAULT_貸付金返還徴収年月日);
        entity.setHenkanChoshuKingaku(DEFAULT_貸付金返還徴収金額);
        entity.setKabusokuHanteiKekkaKubun(DEFAULT_過不足判定結果区分);
        return entity;
    }
}
