/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * サービス種類支給限度額エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator {

    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final RString DEFAULT_要介護状態区分 = new RString("01");
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth(new RString("201406"));
    public static final Decimal DEFAULT_支給限度単位数 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator() {
    }

    public static DbT7111ServiceShuruiShikyuGendoGakuEntity createDbT7111ServiceShuruiShikyuGendoGakuEntity() {
        DbT7111ServiceShuruiShikyuGendoGakuEntity entity = new DbT7111ServiceShuruiShikyuGendoGakuEntity();
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setYoKaigoJotaiKubun(DEFAULT_要介護状態区分);
        entity.setTekiyoKaishuYM(DEFAULT_適用開始年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTekiyoShuryuYM(DEFAULT_適用終了年月);
        entity.setShikyuGendoTaniSu(DEFAULT_支給限度単位数);
        return entity;
    }
}
