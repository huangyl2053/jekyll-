/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 二次予防チェックリスト判定結果エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final int DEFAULT_履歴番号 = 1;
    public static final Decimal DEFAULT_点数_生活機能全般 = new Decimal(0);
    public static final Decimal DEFAULT_点数_運動器機能 = new Decimal(0);
    public static final Decimal DEFAULT_点数_栄養 = new Decimal(0);
    public static final Decimal DEFAULT_点数_口腔 = new Decimal(0);
    public static final Decimal DEFAULT_点数_閉じこもり = new Decimal(0);
    public static final Decimal DEFAULT_点数_認知能力 = new Decimal(0);
    public static final Decimal DEFAULT_点数_うつ = new Decimal(0);
    public static final int DEFAULT_支援必要性_生活機能全般 = 1;
    public static final int DEFAULT_支援必要性_運動器機能 = 1;
    public static final int DEFAULT_支援必要性_栄養 = 1;
    public static final int DEFAULT_支援必要性_口腔 = 1;
    public static final int DEFAULT_支援必要性_閉じこもり = 1;
    public static final int DEFAULT_支援必要性_認知能力 = 1;
    public static final int DEFAULT_支援必要性_うつ = 1;
    public static final RString DEFAULT_二次予防_主観的健康感 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator() {
    }

    public static DbT3103NijiYoboCheckListHanteiKekkaEntity createDbT3103NijiYoboCheckListHanteiKekkaEntity() {
        DbT3103NijiYoboCheckListHanteiKekkaEntity entity = new DbT3103NijiYoboCheckListHanteiKekkaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTensu_SeikatsuKinoZenpan(DEFAULT_点数_生活機能全般);
        entity.setTensu_UndokiKino(DEFAULT_点数_運動器機能);
        entity.setTensu_Eiyo(DEFAULT_点数_栄養);
        entity.setTensu_Koku(DEFAULT_点数_口腔);
        entity.setTensu_Tojikomori(DEFAULT_点数_閉じこもり);
        entity.setTensu_NinchiNoryoku(DEFAULT_点数_認知能力);
        entity.setTensu_Utsu(DEFAULT_点数_うつ);
        entity.setShien_SeikatsuKinoZenpan(DEFAULT_支援必要性_生活機能全般);
        entity.setShien_UndokiKino(DEFAULT_支援必要性_運動器機能);
        entity.setShien_Eiyo(DEFAULT_支援必要性_栄養);
        entity.setShien_Koku(DEFAULT_支援必要性_口腔);
        entity.setShien_Tojikomori(DEFAULT_支援必要性_閉じこもり);
        entity.setShien_NinchiNoryoku(DEFAULT_支援必要性_認知能力);
        entity.setShien_Utsu(DEFAULT_支援必要性_うつ);
        entity.setNijiYobo_ShukantekiKenkouKan(DEFAULT_二次予防_主観的健康感);
        return entity;
    }
}
