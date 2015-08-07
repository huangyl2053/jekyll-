/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
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
 * 住宅改修理由書作成手数料請求決定エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator {

    public static final JigyoshaNo DEFAULT_介護住宅改修理由書作成事業者番号 = new JigyoshaNo();
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_支給・不支給決定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_支給・不支給区分 = new RString("Data");
    public static final RString DEFAULT_償還不支給理由等 = new RString("Data");
    public static final FlexibleDate DEFAULT_住宅改修理由書作成手数料支払予定日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator() {
    }

    public static DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity() {
        DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = new DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
        entity.setRiyushoSakuseiJigyoshaNo(DEFAULT_介護住宅改修理由書作成事業者番号);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShikyu_FushikyuKetteiYMD(DEFAULT_支給・不支給決定年月日);
        entity.setShikyu_FushikyuKubun(DEFAULT_支給・不支給区分);
        entity.setFushikyuRiyu(DEFAULT_償還不支給理由等);
        entity.setTesuryoShiharaiYoteiYMD(DEFAULT_住宅改修理由書作成手数料支払予定日);
        return entity;
    }
}
