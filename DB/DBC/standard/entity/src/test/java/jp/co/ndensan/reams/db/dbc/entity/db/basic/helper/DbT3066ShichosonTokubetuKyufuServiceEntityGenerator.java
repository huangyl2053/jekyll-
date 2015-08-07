/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
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
 * 市町村特別給付サービス内容エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3066ShichosonTokubetuKyufuServiceEntityGenerator {

    public static final RString DEFAULT_市町村特別給付用サービスコード = new RString("Data");
    public static final FlexibleDate DEFAULT_市町村特別給付用サービス有効期間開始年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_市町村特別給付用サービス名（正式名称） = new RString("Data");
    public static final RString DEFAULT_市町村特別給付用サービス名（略称） = new RString("Data");
    public static final FlexibleDate DEFAULT_市町村特別給付用サービス有効期間終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_市町村特別給付用サービス区分 = new RString("Data");
    public static final Decimal DEFAULT_市町村特別給付用単位・日数 = new Decimal(0);
    public static final Decimal DEFAULT_市町村特別給付用支給限度基準額 = new Decimal(0);
    public static final boolean DEFAULT_市町村特別給付用給付率引下有フラグ = false;
    public static final FlexibleDate DEFAULT_登録年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_変更年月日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3066ShichosonTokubetuKyufuServiceEntityGenerator() {
    }

    public static DbT3066ShichosonTokubetuKyufuServiceEntity createDbT3066ShichosonTokubetuKyufuServiceEntity() {
        DbT3066ShichosonTokubetuKyufuServiceEntity entity = new DbT3066ShichosonTokubetuKyufuServiceEntity();
        entity.setServiceCode(DEFAULT_市町村特別給付用サービスコード);
        entity.setServiceYukoKikanKaishiYMD(DEFAULT_市町村特別給付用サービス有効期間開始年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setServiceSeishikiName(DEFAULT_市町村特別給付用サービス名（正式名称）);
        entity.setServiceRyakushoName(DEFAULT_市町村特別給付用サービス名（略称）);
        entity.setServiceYukoKikanShuryoYMD(DEFAULT_市町村特別給付用サービス有効期間終了年月日);
        entity.setServiceKubun(DEFAULT_市町村特別給付用サービス区分);
        entity.setTanisuNissu(DEFAULT_市町村特別給付用単位・日数);
        entity.setShikyuGendoKijungaku(DEFAULT_市町村特別給付用支給限度基準額);
        entity.setKyufuritsuHikisageAriFlag(DEFAULT_市町村特別給付用給付率引下有フラグ);
        entity.setTorokuYMD(DEFAULT_登録年月日);
        entity.setHenkoYMD(DEFAULT_変更年月日);
        return entity;
    }
}
