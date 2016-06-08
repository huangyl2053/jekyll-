/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 二次予防事業対象者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3100NijiYoboJigyoTaishoshaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final int DEFAULT_履歴番号 = 1;
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_調査実施日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3100NijiYoboJigyoTaishoshaEntityGenerator() {
    }

    public static DbT3100NijiYoboJigyoTaishoshaEntity createDbT3100NijiYoboJigyoTaishoshaEntity() {
        DbT3100NijiYoboJigyoTaishoshaEntity entity = new DbT3100NijiYoboJigyoTaishoshaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setChosaJisshiYMD(DEFAULT_調査実施日);
        return entity;
    }
}
