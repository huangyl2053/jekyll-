/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い給付種類支給限度額エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator {

    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth(new RString("201406"));
    public static final int DEFAULT_履歴番号 = 1;
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth(new RString("201406"));
    public static final Decimal DEFAULT_支給限度単位数 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator() {
    }

    public static DbT7112ShokanShuruiShikyuGendoGakuEntity createDbT7112ShokanShuruiShikyuGendoGakuEntity() {
        DbT7112ShokanShuruiShikyuGendoGakuEntity entity = new DbT7112ShokanShuruiShikyuGendoGakuEntity();
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setTekiyoKaishiYM(DEFAULT_適用開始年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setShikyuGendoTaniSu(DEFAULT_支給限度単位数);
        return entity;
    }
}
