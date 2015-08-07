/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
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
 * 過誤申立エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3059KagoMoshitateEntityGenerator {

    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_申立年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_申立者区分コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final RString DEFAULT_申立事由コード = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_国保連送付年月 = new FlexibleYear("1990");
    public static final boolean DEFAULT_国保連再送付有フラグ = false;
    public static final boolean DEFAULT_同月審査有フラグ = false;
    public static final RString DEFAULT_申立書区分コード = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3059KagoMoshitateEntityGenerator() {
    }

    public static DbT3059KagoMoshitateEntity createDbT3059KagoMoshitateEntity() {
        DbT3059KagoMoshitateEntity entity = new DbT3059KagoMoshitateEntity();
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setMoshitateYMD(DEFAULT_申立年月日);
        entity.setMoshitateshaKubunCode(DEFAULT_申立者区分コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setMoshitateJiyuCode(DEFAULT_申立事由コード);
        entity.setKokuhorenSofuYM(DEFAULT_国保連送付年月);
        entity.setKokuhirenSaiSofuAriFlag(DEFAULT_国保連再送付有フラグ);
        entity.setDogetsuShinsaAriFlag(DEFAULT_同月審査有フラグ);
        entity.setMoshitateshoKubunCode(DEFAULT_申立書区分コード);
        return entity;
    }
}
