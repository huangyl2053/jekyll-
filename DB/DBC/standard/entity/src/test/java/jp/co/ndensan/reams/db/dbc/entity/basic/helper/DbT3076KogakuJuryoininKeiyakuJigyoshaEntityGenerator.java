/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額受領委任契約事業者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_承認結果区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_受領委任払適用開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_受領委任払適用終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_契約番号 = new RString("Data");
    public static final RString DEFAULT_不承認理由 = new RString("Data");
    public static final Decimal DEFAULT_利用者負担上限額 = new Decimal(0);
    public static final FlexibleDate DEFAULT_承認結果通知書作成日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_承認結果通知書再発行区分 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator() {
    }

    public static DbT3076KogakuJuryoininKeiyakuJigyoshaEntity createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity() {
        DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = new DbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setShoninKekkaKubun(DEFAULT_承認結果区分);
        entity.setJuryoininKaishiYMD(DEFAULT_受領委任払適用開始年月日);
        entity.setJuryoininShuryoYMD(DEFAULT_受領委任払適用終了年月日);
        entity.setKeiyakuNo(DEFAULT_契約番号);
        entity.setFuShoninRiyu(DEFAULT_不承認理由);
        entity.setRiyoshaFutanJogenGaku(DEFAULT_利用者負担上限額);
        entity.setShoninKekkaTsuchiSakuseiYMD(DEFAULT_承認結果通知書作成日);
        entity.setShoninKekkaTsuchiSaiHakkoKubun(DEFAULT_承認結果通知書再発行区分);
        return entity;
    }
}
