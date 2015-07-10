/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅サービス区分支給限度額エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7109KubunShikyuGendoGakuEntityGenerator {

    public static final RString DEFAULT_要介護状態区分 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth(new RString("201406"));
    public static final Decimal DEFAULT_支給限度単位数 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7109KubunShikyuGendoGakuEntityGenerator() {
    }

    public static DbT7109KubunShikyuGendoGakuEntity createDbT7109KubunShikyuGendoGakuEntity() {
        DbT7109KubunShikyuGendoGakuEntity entity = new DbT7109KubunShikyuGendoGakuEntity();
        entity.setYoKaigoJotaiKubun(DEFAULT_要介護状態区分);
        entity.setTekiyoKaishiYM(DEFAULT_適用開始年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setShikyuGendoTaniSu(DEFAULT_支給限度単位数);
        return entity;
    }
}
