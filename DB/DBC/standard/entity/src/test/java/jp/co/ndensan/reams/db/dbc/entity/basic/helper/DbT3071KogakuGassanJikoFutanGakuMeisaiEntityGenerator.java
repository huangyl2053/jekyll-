/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算自己負担額明細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYear DEFAULT_対象年度 = new FlexibleYear("1990");
    public static final HokenshaNo DEFAULT_保険者番号 = new HokenshaNo("1");
    public static final RString DEFAULT_支給申請書整理番号 = new RString("Data");
    public static final RString DEFAULT_対象月 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_自己負担額 = new Decimal(0);
    public static final Decimal DEFAULT_70_74自己負担額_内数 = new Decimal(0);
    public static final Decimal DEFAULT_70未満高額支給額 = new Decimal(0);
    public static final Decimal DEFAULT_70_74高額支給額 = new Decimal(0);
    public static final RString DEFAULT_摘要 = new RString("Data");
    public static final Decimal DEFAULT_補正済_自己負担額 = new Decimal(0);
    public static final Decimal DEFAULT_補正済_70_74自己負担額_内数 = new Decimal(0);
    public static final Decimal DEFAULT_補正済_70未満高額支給額 = new Decimal(0);
    public static final Decimal DEFAULT_補正済_70_74高額支給額 = new Decimal(0);
    public static final RString DEFAULT_補正済_摘要 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator() {
    }

    public static DbT3071KogakuGassanJikoFutanGakuMeisaiEntity createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity() {
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity = new DbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoNendo(DEFAULT_対象年度);
        entity.setHokenshaNo(DEFAULT_保険者番号);
        entity.setShikyuShinseishoSeiriNo(DEFAULT_支給申請書整理番号);
        entity.setTaishoM(DEFAULT_対象月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setJikoFutanGaku(DEFAULT_自己負担額);
        entity.setUchisu_70_74JikoFutanGaku(DEFAULT_70_74自己負担額_内数);
        entity.setUnder_70KogakuShikyuGaku(DEFAULT_70未満高額支給額);
        entity.setOver_70_74KogakuShikyuGaku(DEFAULT_70_74高額支給額);
        entity.setTekiyo(DEFAULT_摘要);
        entity.setSumi_JikoFutanGaku(DEFAULT_補正済_自己負担額);
        entity.setSumi_70_74JikoFutanGaku(DEFAULT_補正済_70_74自己負担額_内数);
        entity.setSumi_under_70KogakuShikyuGaku(DEFAULT_補正済_70未満高額支給額);
        entity.setSumi_70_74KogakuShikyuGaku(DEFAULT_補正済_70_74高額支給額);
        entity.setSumi_Tekiyo(DEFAULT_補正済_摘要);
        return entity;
    }
}
