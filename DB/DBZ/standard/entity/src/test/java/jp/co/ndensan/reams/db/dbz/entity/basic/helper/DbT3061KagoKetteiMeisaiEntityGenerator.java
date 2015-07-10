/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 過誤決定明細エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3061KagoKetteiMeisaiEntityGenerator {

    public static final FlexibleYearMonth DEFAULT_取扱年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_保険者区分 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_事業所名 = new RString("1");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final RString DEFAULT_公費受給者番号 = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final RString DEFAULT_サービス種類名 = new RString("1");
    public static final Code DEFAULT_過誤申立事由コード = new Code("3");
    public static final RString DEFAULT_過誤申立事由 = new RString("1");
    public static final Decimal DEFAULT_単位数_特定入所者介護費等 = new Decimal(1);
    public static final Decimal DEFAULT_保険者負担額 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3061KagoKetteiMeisaiEntityGenerator() {
    }

    public static DbT3061KagoKetteiMeisaiEntity createDbT3061KagoKetteiMeisaiEntity() {
        DbT3061KagoKetteiMeisaiEntity entity = new DbT3061KagoKetteiMeisaiEntity();
        entity.setToriatsukaiYM(DEFAULT_取扱年月);
        entity.setHokenshaKubun(DEFAULT_保険者区分);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setJigyoshoName(DEFAULT_事業所名);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setKohiJukyushaNo(DEFAULT_公費受給者番号);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceShuruiName(DEFAULT_サービス種類名);
        entity.setKagomoushitateJiyuCode(DEFAULT_過誤申立事由コード);
        entity.setKagomoushitateJiyu(DEFAULT_過誤申立事由);
        entity.setTanisu(DEFAULT_単位数_特定入所者介護費等);
        entity.setHokenshaFutangaku(DEFAULT_保険者負担額);
        return entity;
    }
}
