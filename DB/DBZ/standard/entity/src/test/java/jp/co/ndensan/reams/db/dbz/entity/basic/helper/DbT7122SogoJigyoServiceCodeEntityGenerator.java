/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7122SogoJigyoServiceCodeEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護予防・日常生活支援総合事業サービスコードエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7122SogoJigyoServiceCodeEntityGenerator {

    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_サービス名称 = new RString("1");
    public static final Decimal DEFAULT_単位数 = new Decimal(1);
    public static final RString DEFAULT_限度額対象外フラグ = new RString("1");
    public static final RString DEFAULT_単位数識別コード = new RString("1");
    public static final RString DEFAULT_外部サービス利用型区分 = new RString("1");
    public static final RString DEFAULT_特別地域加算フラグ = new RString("1");
    public static final RString DEFAULT_利用者負担定率_定額区分 = new RString("1");
    public static final Decimal DEFAULT_利用者負担額 = new Decimal(1);
    public static final HokenKyufuRitsu DEFAULT_給付率 = new HokenKyufuRitsu(new Decimal("2"));
    public static final RString DEFAULT_二次予防事業対象者実施区分 = new RString("1");
    public static final RString DEFAULT_要支援１受給者実施区分 = new RString("1");
    public static final RString DEFAULT_要支援２受給者実施区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7122SogoJigyoServiceCodeEntityGenerator() {
    }

    public static DbT7122SogoJigyoServiceCodeEntity createDbT7122SogoJigyoServiceCodeEntity() {
        DbT7122SogoJigyoServiceCodeEntity entity = new DbT7122SogoJigyoServiceCodeEntity();
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setTekiyoKaishiYM(DEFAULT_適用開始年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setServiceMeisho(DEFAULT_サービス名称);
        entity.setTaniSu(DEFAULT_単位数);
        entity.setGendoGakuTaishogaiFlag(DEFAULT_限度額対象外フラグ);
        entity.setTaniSuShikibetsuCode(DEFAULT_単位数識別コード);
        entity.setGaibuServiceRiyoKubun(DEFAULT_外部サービス利用型区分);
        entity.setTokubetsuChiikiKasanFlag(DEFAULT_特別地域加算フラグ);
        entity.setTeiRitsu_TeiGakuKubun(DEFAULT_利用者負担定率_定額区分);
        entity.setRiyoshaFutanGaku(DEFAULT_利用者負担額);
        entity.setKyufuRitsu(DEFAULT_給付率);
        entity.setNijiYoboTaishosha_JissiKubun(DEFAULT_二次予防事業対象者実施区分);
        entity.setYoShien1_JisshiKubun(DEFAULT_要支援１受給者実施区分);
        entity.setYoShien2_JisshiKubun(DEFAULT_要支援２受給者実施区分);
        return entity;
    }
}
