/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 二次予防事業対象者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3100NijiYoboJigyoTaishoshaEntityGenerator {

    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("02"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("20140402");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3100NijiYoboJigyoTaishoshaEntityGenerator() {
    }

    public static DbT3100NijiYoboJigyoTaishoshaEntity createDbT3100NijiYoboJigyoTaishoshaEntity() {
        DbT3100NijiYoboJigyoTaishoshaEntity entity = new DbT3100NijiYoboJigyoTaishoshaEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        return entity;
    }
}
