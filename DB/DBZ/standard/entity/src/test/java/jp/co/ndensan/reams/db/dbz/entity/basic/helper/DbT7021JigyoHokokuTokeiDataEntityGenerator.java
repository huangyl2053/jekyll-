/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告統計データエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7021JigyoHokokuTokeiDataEntityGenerator {

    public static final FlexibleYear DEFAULT_報告年 = new FlexibleYear("2014");
    public static final RString DEFAULT_報告月 = new RString("1");
    public static final FlexibleYear DEFAULT_集計対象年 = new FlexibleYear("2014");
    public static final RString DEFAULT_集計対象月 = new RString("3");
    public static final RString DEFAULT_統計対象区分 = new RString("1");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final Code DEFAULT_表番号 = new Code("1003");
    public static final Code DEFAULT_集計番号 = new Code("3001");
    public static final Code DEFAULT_集計単位 = new Code("3");
    public static final Decimal DEFAULT_縦番号 = new Decimal(1000);
    public static final Decimal DEFAULT_横番号 = new Decimal(1000);
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final Decimal DEFAULT_集計結果値 = new Decimal(10000);
    public static final Code DEFAULT_縦項目コード = new Code("13456");
    public static final Code DEFAULT_横項目コード = new Code("46621");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7021JigyoHokokuTokeiDataEntityGenerator() {
    }

    public static DbT7021JigyoHokokuTokeiDataEntity createDbT7021JigyoHokokuTokeiDataEntity() {
        DbT7021JigyoHokokuTokeiDataEntity entity = new DbT7021JigyoHokokuTokeiDataEntity();
        entity.setHokokuYSeireki(DEFAULT_報告年);
        entity.setHokokuM(DEFAULT_報告月);
        entity.setShukeiTaishoYSeireki(DEFAULT_集計対象年);
        entity.setShukeiTaishoM(DEFAULT_集計対象月);
        entity.setToukeiTaishoKubun(DEFAULT_統計対象区分);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setHyoNo(DEFAULT_表番号);
        entity.setShukeiNo(DEFAULT_集計番号);
        entity.setShukeiTani(DEFAULT_集計単位);
        entity.setTateNo(DEFAULT_縦番号);
        entity.setYokoNo(DEFAULT_横番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShukeiKekkaAtai(DEFAULT_集計結果値);
        entity.setTateKomokuCode(DEFAULT_縦項目コード);
        entity.setYokoKomokuCode(DEFAULT_横項目コード);
        return entity;
    }
}
