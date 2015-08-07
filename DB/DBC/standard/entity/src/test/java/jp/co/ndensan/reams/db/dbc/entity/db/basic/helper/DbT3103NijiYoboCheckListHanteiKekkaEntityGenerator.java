/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
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
 * 二次予防チェックリスト判定結果エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_点数・生活機能全般 = new Decimal(0);
    public static final Decimal DEFAULT_点数・運動器機能 = new Decimal(0);
    public static final Decimal DEFAULT_点数・栄養 = new Decimal(0);
    public static final Decimal DEFAULT_点数・口腔 = new Decimal(0);
    public static final Decimal DEFAULT_点数・閉じこもり = new Decimal(0);
    public static final Decimal DEFAULT_点数・認知能力 = new Decimal(0);
    public static final Decimal DEFAULT_点数・うつ = new Decimal(0);
    public static final Decimal DEFAULT_支援必要性・生活機能全般 = new Decimal(0);
    public static final Decimal DEFAULT_支援必要性・運動器機能 = new Decimal(0);
    public static final Decimal DEFAULT_支援必要性・栄養 = new Decimal(0);
    public static final Decimal DEFAULT_支援必要性・口腔 = new Decimal(0);
    public static final Decimal DEFAULT_支援必要性・閉じこもり = new Decimal(0);
    public static final Decimal DEFAULT_支援必要性・認知能力 = new Decimal(0);
    public static final Decimal DEFAULT_支援必要性・うつ = new Decimal(0);
    public static final RString DEFAULT_二次予防・主観的健康感 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator() {
    }

    public static DbT3103NijiYoboCheckListHanteiKekkaEntity createDbT3103NijiYoboCheckListHanteiKekkaEntity() {
        DbT3103NijiYoboCheckListHanteiKekkaEntity entity = new DbT3103NijiYoboCheckListHanteiKekkaEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTensu_SeikatsuKinoZenpan(DEFAULT_点数・生活機能全般);
        entity.setTensu_UndokiKino(DEFAULT_点数・運動器機能);
        entity.setTensu_Eiyo(DEFAULT_点数・栄養);
        entity.setTensu_Koku(DEFAULT_点数・口腔);
        entity.setTensu_Tojikomori(DEFAULT_点数・閉じこもり);
        entity.setTensu_NinchiNoryoku(DEFAULT_点数・認知能力);
        entity.setTensu_Utsu(DEFAULT_点数・うつ);
        entity.setShien_SeikatsuKinoZenpan(DEFAULT_支援必要性・生活機能全般);
        entity.setShien_UndokiKino(DEFAULT_支援必要性・運動器機能);
        entity.setShien_Eiyo(DEFAULT_支援必要性・栄養);
        entity.setShien_Koku(DEFAULT_支援必要性・口腔);
        entity.setShien_Tojikomori(DEFAULT_支援必要性・閉じこもり);
        entity.setShien_NinchiNoryoku(DEFAULT_支援必要性・認知能力);
        entity.setShien_Utsu(DEFAULT_支援必要性・うつ);
        entity.setNijiYobo_ShukantekiKenkouKan(DEFAULT_二次予防・主観的健康感);
        return entity;
    }
}
