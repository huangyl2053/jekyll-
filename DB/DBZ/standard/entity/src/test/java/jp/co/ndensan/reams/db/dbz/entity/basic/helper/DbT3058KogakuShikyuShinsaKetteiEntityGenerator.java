/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費支給審査決定エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3058KogakuShikyuShinsaKetteiEntityGenerator {

    public static final FlexibleYearMonth DEFAULT_決定者受取年月 = new FlexibleYearMonth(new RString("201406"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_通知書番号 = new RString("1");
    public static final Decimal DEFAULT_利用者負担額 = new Decimal(1);
    public static final RString DEFAULT_支給区分コード = new RString("1");
    public static final FlexibleYearMonth DEFAULT_決定年月 = new FlexibleYearMonth(new RString("201406"));
    public static final Decimal DEFAULT_高額支給額 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3058KogakuShikyuShinsaKetteiEntityGenerator() {
    }

    public static DbT3058KogakuShikyuShinsaKetteiEntity createDbT3058KogakuShikyuShinsaKetteiEntity() {
        DbT3058KogakuShikyuShinsaKetteiEntity entity = new DbT3058KogakuShikyuShinsaKetteiEntity();
        entity.setKetteishaUketoriYM(DEFAULT_決定者受取年月);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setRiyoshaFutanGaku(DEFAULT_利用者負担額);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setKetteiYM(DEFAULT_決定年月);
        entity.setKogakuShikyuGaku(DEFAULT_高額支給額);
        return entity;
    }
}
