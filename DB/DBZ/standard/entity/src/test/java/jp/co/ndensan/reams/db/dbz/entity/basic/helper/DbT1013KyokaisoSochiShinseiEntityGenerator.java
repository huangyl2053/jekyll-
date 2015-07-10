/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 境界層措置申請エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT1013KyokaisoSochiShinseiEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_申請_廃止区分 = new RString("1");
    public static final FlexibleDate DEFAULT_申請_廃止年月日 = new FlexibleDate("20140402");
    public static final Decimal DEFAULT_保護不要根拠減額金額 = new Decimal(1);
    public static final FlexibleDate DEFAULT_境界層証明書交付年月日 = new FlexibleDate("20140402");
    public static final Decimal DEFAULT_給付額減額取消_減額自己負担月額 = new Decimal(1);
    public static final Decimal DEFAULT_居住費軽減_減額自己負担月額 = new Decimal(1);
    public static final RString DEFAULT_居住費軽減_負担限度額段階コード = new RString("1");
    public static final Decimal DEFAULT_食費軽減_減額自己負担月額 = new Decimal(1);
    public static final RString DEFAULT_食費軽減_負担限度額段階コード = new RString("1");
    public static final Decimal DEFAULT_利用者負担世帯合算額_減額自己負担月額 = new Decimal(1);
    public static final Decimal DEFAULT_保険料減額_減額自己負担月額 = new Decimal(1);
    public static final Decimal DEFAULT_減額自己負担月額合計額 = new Decimal(1);
    public static final FlexibleDate DEFAULT_境界層措置決定年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_措置該当_非該当区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1013KyokaisoSochiShinseiEntityGenerator() {
    }

    public static DbT1013KyokaisoSochiShinseiEntity createDbT1013KyokaisoSochiShinseiEntity() {
        DbT1013KyokaisoSochiShinseiEntity entity = new DbT1013KyokaisoSochiShinseiEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setShoriTimeStamp(DEFAULT_処理日時);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setShinsei_HaishiKubun(DEFAULT_申請_廃止区分);
        entity.setShinsei_HaishiYMD(DEFAULT_申請_廃止年月日);
        entity.setHogoHuyoKonkyoGengakuKingaku(DEFAULT_保護不要根拠減額金額);
        entity.setKyokaisoShomeishoKofuYMD(DEFAULT_境界層証明書交付年月日);
        entity.setKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku(DEFAULT_給付額減額取消_減額自己負担月額);
        entity.setKyojuhiKeigen_GengakuJikofutanGetsugaku(DEFAULT_居住費軽減_減額自己負担月額);
        entity.setKyojuhiKeigen_FutangendogakuDankaiCode(DEFAULT_居住費軽減_負担限度額段階コード);
        entity.setShokuhiKeigen_GengakuJikofutanGetsugaku(DEFAULT_食費軽減_減額自己負担月額);
        entity.setShokuhiKeigen_FutangendogakuDankaiCode(DEFAULT_食費軽減_負担限度額段階コード);
        entity.setRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku(DEFAULT_利用者負担世帯合算額_減額自己負担月額);
        entity.setHokenryoGengaku_GengakuJikofutanGetsugaku(DEFAULT_保険料減額_減額自己負担月額);
        entity.setGengakuJikofutanGetsugakuGokeigaku(DEFAULT_減額自己負担月額合計額);
        entity.setKyukaisoSochiKetteiYMD(DEFAULT_境界層措置決定年月日);
        entity.setSochiGaito_HigaitoKubun(DEFAULT_措置該当_非該当区分);
        return entity;
    }
}
