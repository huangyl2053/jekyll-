/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅給付計画自己作成短期入所利用日数エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final Decimal DEFAULT_前回迄利用日数 = new Decimal(1);
    public static final Decimal DEFAULT_今回計画利用日数 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator() {
    }

    public static DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity() {
        DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = new DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setZenkaiRiyoNissu(DEFAULT_前回迄利用日数);
        entity.setKonkaiKeikakuRiyoNissu(DEFAULT_今回計画利用日数);
        return entity;
    }
}
