/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7121ChiikiMitchakuServiceCodeEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 地域密着型介護サービスコードエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7121ChiikiMitchakuServiceCodeEntityGenerator {

    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_サービス名称 = new RString("1");
    public static final Decimal DEFAULT_単位数 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7121ChiikiMitchakuServiceCodeEntityGenerator() {
    }

    public static DbT7121ChiikiMitchakuServiceCodeEntity createDbT7121ChiikiMitchakuServiceCodeEntity() {
        DbT7121ChiikiMitchakuServiceCodeEntity entity = new DbT7121ChiikiMitchakuServiceCodeEntity();
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setTekiyoKaishiYM(DEFAULT_適用開始年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setServiceMeisho(DEFAULT_サービス名称);
        entity.setTaniSu(DEFAULT_単位数);
        return entity;
    }
}
