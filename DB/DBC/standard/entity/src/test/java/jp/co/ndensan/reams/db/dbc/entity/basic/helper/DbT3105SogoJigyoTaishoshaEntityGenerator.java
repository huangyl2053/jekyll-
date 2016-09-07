/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 総合事業対象者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3105SogoJigyoTaishoshaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final int DEFAULT_履歴番号 = 1;
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_チェックリスト実施日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3105SogoJigyoTaishoshaEntityGenerator() {
    }

    public static DbT3105SogoJigyoTaishoshaEntity createDbT3105SogoJigyoTaishoshaEntity() {
        DbT3105SogoJigyoTaishoshaEntity entity = new DbT3105SogoJigyoTaishoshaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setChecklistJisshiYMD(DEFAULT_チェックリスト実施日);
        return entity;
    }
}
