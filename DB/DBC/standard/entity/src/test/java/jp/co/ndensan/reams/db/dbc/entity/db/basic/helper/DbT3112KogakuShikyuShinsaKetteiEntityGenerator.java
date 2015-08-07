/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
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
 * 事業高額介護サービス費支給審査決定エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3112KogakuShikyuShinsaKetteiEntityGenerator {

    public static final FlexibleYearMonth DEFAULT_決定者受取年月 = new FlexibleYear("1990");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_通知書番号 = new RString("Data");
    public static final Decimal DEFAULT_利用者負担額 = new Decimal(0);
    public static final RString DEFAULT_支給区分コード = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_決定年月 = new FlexibleYear("1990");
    public static final Decimal DEFAULT_事業高額支給額 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3112KogakuShikyuShinsaKetteiEntityGenerator() {
    }

    public static DbT3112KogakuShikyuShinsaKetteiEntity createDbT3112KogakuShikyuShinsaKetteiEntity() {
        DbT3112KogakuShikyuShinsaKetteiEntity entity = new DbT3112KogakuShikyuShinsaKetteiEntity();
        entity.setKetteishaUketoriYM(DEFAULT_決定者受取年月);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setRiyoshaFutanGaku(DEFAULT_利用者負担額);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setKetteiYM(DEFAULT_決定年月);
        entity.setJigyoKogakuShikyuGaku(DEFAULT_事業高額支給額);
        return entity;
    }
}
