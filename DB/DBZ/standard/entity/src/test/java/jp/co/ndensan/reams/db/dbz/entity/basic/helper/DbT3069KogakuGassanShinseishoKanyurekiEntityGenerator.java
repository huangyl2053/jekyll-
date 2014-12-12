/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算申請書加入歴エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYear DEFAULT_対象年度 = new FlexibleYear("2014");
    public static final HokenshaNo DEFAULT_保険者番号 = new HokenshaNo(new RString("2"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final RString DEFAULT_加入歴番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_保険者名 = new RString("1");
    public static final FlexibleDate DEFAULT_加入期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_加入期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_自己負担額証明書整理番号 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator() {
    }

    public static DbT3069KogakuGassanShinseishoKanyurekiEntity createDbT3069KogakuGassanShinseishoKanyurekiEntity() {
        DbT3069KogakuGassanShinseishoKanyurekiEntity entity = new DbT3069KogakuGassanShinseishoKanyurekiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoNendo(DEFAULT_対象年度);
        entity.setHokenshaNo(DEFAULT_保険者番号);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setKanyurekiNo(DEFAULT_加入歴番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setHokenshaMei(DEFAULT_保険者名);
        entity.setKanyuKaishiYMD(DEFAULT_加入期間開始年月日);
        entity.setKanyuShuryoYMD(DEFAULT_加入期間終了年月日);
        entity.setJikoFutanShomeisho_SeiriNo(DEFAULT_自己負担額証明書整理番号);
        return entity;
    }
}
