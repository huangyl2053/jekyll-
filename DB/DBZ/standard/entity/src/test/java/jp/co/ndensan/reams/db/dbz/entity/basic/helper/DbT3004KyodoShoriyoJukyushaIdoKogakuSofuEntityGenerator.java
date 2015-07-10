/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者異動高額送付エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator {

    public static final FlexibleDate DEFAULT_異動年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_異動区分コード = new RString("1");
    public static final RString DEFAULT_受給者異動事由 = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final HihokenshaNo DEFAULT_世帯集約番号 = new HihokenshaNo(new RString("2"));
    public static final RString DEFAULT_世帯所得区分コード = new RString("1");
    public static final RString DEFAULT_所得区分コード = new RString("1");
    public static final boolean DEFAULT_老齢福祉年金受給有フラグ = false;
    public static final boolean DEFAULT_利用者負担第２段階有フラグ = false;
    public static final boolean DEFAULT_支給申請書出力有フラグ = false;
    public static final boolean DEFAULT_訂正連絡票フラグ = false;
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator() {
    }

    public static DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity createDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity() {
        DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity entity = new DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
        entity.setIdoYMD(DEFAULT_異動年月日);
        entity.setIdoKubunCode(DEFAULT_異動区分コード);
        entity.setJukyushaIdoJiyu(DEFAULT_受給者異動事由);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setSetaiShuyakuNo(DEFAULT_世帯集約番号);
        entity.setSetaiShotokuKubunCode(DEFAULT_世帯所得区分コード);
        entity.setShotokuKubunCode(DEFAULT_所得区分コード);
        entity.setRoureiFukushiNenkinJukyuAriFlag(DEFAULT_老齢福祉年金受給有フラグ);
        entity.setRiyoshaFutan2DankaiAriFlag(DEFAULT_利用者負担第２段階有フラグ);
        entity.setShikyuShinseishoOutputAriFlag(DEFAULT_支給申請書出力有フラグ);
        entity.setTeiseiRenrakuhyoFlag(DEFAULT_訂正連絡票フラグ);
        entity.setSofuYM(DEFAULT_送付年月);
        return entity;
    }
}
