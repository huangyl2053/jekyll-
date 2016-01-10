/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 利用者負担割合世帯員エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator {

    public static final FlexibleYear DEFAULT_年度 = new FlexibleYear("1990");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final int DEFAULT_履歴番号 = 0;
    public static final int DEFAULT_枝番号 = 0;
    public static final HihokenshaNo DEFAULT_世帯員被保険者番号 = new HihokenshaNo("1");
    public static final Decimal DEFAULT_世帯員所得履歴番号 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator() {
    }

    public static DbT3115RiyoshaFutanWariaiKonkyoEntity createDbT3115RiyoshaFutanWariaiKonkyoEntity() {
        DbT3115RiyoshaFutanWariaiKonkyoEntity entity = new DbT3115RiyoshaFutanWariaiKonkyoEntity();
        entity.setNendo(DEFAULT_年度);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setEdaNo(DEFAULT_枝番号);
        entity.setSetaiinHihokenshaNo(DEFAULT_世帯員被保険者番号);
        entity.setSetaiinShotokuRirekiNo(DEFAULT_世帯員所得履歴番号);
        return entity;
    }
}
