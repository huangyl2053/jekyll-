/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity;
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
 * 上乗せサービス種類支給限度額エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator {

    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final RString DEFAULT_要介護状態区分 = RString;
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth(new RString("201406"));
    public static final int DEFAULT_履歴番号 = 1;
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth(new RString("201406"));
    public static final Decimal DEFAULT_支給限度単位数 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator() {
    }

    public static DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity() {
        DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = new DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setYoKaigoJotaiKubun(DEFAULT_要介護状態区分);
        entity.setTekiyoKaishiYM(DEFAULT_適用開始年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setShikyuGendoTaniSu(DEFAULT_支給限度単位数);
        return entity;
    }
}
