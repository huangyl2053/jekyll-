/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 利用者負担割合明細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator {

    public static final FlexibleYear DEFAULT_年度 = new FlexibleYear("1990");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_枝番号 = new Decimal(0);
    public static final RString DEFAULT_資格区分 = new RString("Data");
    public static final RString DEFAULT_負担割合区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_有効開始日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_有効終了日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_本人合計所得金額 = new Decimal(0);
    public static final Decimal DEFAULT_世帯１号被保険者数 = new Decimal(0);
    public static final Decimal DEFAULT_年金収入合計 = new Decimal(0);
    public static final Decimal DEFAULT_その他の合計所得金額合計 = new Decimal(0);
    public static final RString DEFAULT_更正理由 = new RString("Data");
    public static final SetaiCode DEFAULT_世帯コード = new SetaiCode("012340123400001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator() {
    }

    public static DbT3114RiyoshaFutanWariaiMeisaiEntity createDbT3114RiyoshaFutanWariaiMeisaiEntity() {
        DbT3114RiyoshaFutanWariaiMeisaiEntity entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
        entity.setNendo(DEFAULT_年度);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setEdaNo(DEFAULT_枝番号);
        entity.setShikakuKubun(DEFAULT_資格区分);
        entity.setFutanWariaiKubun(DEFAULT_負担割合区分);
        entity.setYukoKaishiYMD(DEFAULT_有効開始日);
        entity.setYukoShuryoYMD(DEFAULT_有効終了日);
        entity.setHonninGoukeiShotokuGaku(DEFAULT_本人合計所得金額);
        entity.setSetaiIchigouHihoknehsaSu(DEFAULT_世帯１号被保険者数);
        entity.setNenkinShunyuGoukei(DEFAULT_年金収入合計);
        entity.setSonotanoGoukeiShotokuKingakuGoukei(DEFAULT_その他の合計所得金額合計);
        entity.setKoseiRiyu(DEFAULT_更正理由);
        entity.setSetaiCd(DEFAULT_世帯コード);
        return entity;
    }
}
