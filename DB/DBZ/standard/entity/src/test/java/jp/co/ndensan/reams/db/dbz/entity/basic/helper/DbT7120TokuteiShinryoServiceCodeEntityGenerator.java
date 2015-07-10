/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特定診療サービスコードエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7120TokuteiShinryoServiceCodeEntityGenerator {

    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleYearMonth DEFAULT_適用終了年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_サービス名称 = new RString("1");
    public static final Decimal DEFAULT_単位数 = new Decimal(1);
    public static final RString DEFAULT_単位数識別 = new RString("1");
    public static final RString DEFAULT_算定単位 = new RString("1");
    public static final RString DEFAULT_合成識別区分 = new RString("1");
    public static final RString DEFAULT_特定診療区分コード = new RString("1");
    public static final RString DEFAULT_特定診療項目コード = new RString("1");
    public static final RString DEFAULT_算定制約期間 = new RString("1");
    public static final Decimal DEFAULT_算定制約回数 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7120TokuteiShinryoServiceCodeEntityGenerator() {
    }

    public static DbT7120TokuteiShinryoServiceCodeEntity createDbT7120TokuteiShinryoServiceCodeEntity() {
        DbT7120TokuteiShinryoServiceCodeEntity entity = new DbT7120TokuteiShinryoServiceCodeEntity();
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setTekiyoKaishiYM(DEFAULT_適用開始年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTekiyoShuryoYM(DEFAULT_適用終了年月);
        entity.setServiceMeisho(DEFAULT_サービス名称);
        entity.setTaniSu(DEFAULT_単位数);
        entity.setTaniSuShikibetsu(DEFAULT_単位数識別);
        entity.setSanteiTani(DEFAULT_算定単位);
        entity.setGoseiShikibetsuKubun(DEFAULT_合成識別区分);
        entity.setTokuteiShinryoKubunCode(DEFAULT_特定診療区分コード);
        entity.setTokuteiShinryoKomokuCode(DEFAULT_特定診療項目コード);
        entity.setSanteiSeiyakuKikan(DEFAULT_算定制約期間);
        entity.setSanteiSeiyakuKaisu(DEFAULT_算定制約回数);
        return entity;
    }
}
