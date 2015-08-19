/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還受領委任契約者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3078ShokanJuryoininKeiyakushaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("1");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final int DEFAULT_履歴番号 = 1;
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_事業者契約番号 = new RString("Data");
    public static final RString DEFAULT_契約サービス種類 = new RString("Data");
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_承認結果区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_受領委任払適用開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_受領委任払適用終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_契約番号 = new RString("Data");
    public static final RString DEFAULT_不承認理由 = new RString("Data");
    public static final Decimal DEFAULT_費用額合計 = new Decimal(0);
    public static final Decimal DEFAULT_保険対象費用額 = new Decimal(0);
    public static final Decimal DEFAULT_利用者自己負担額 = new Decimal(0);
    public static final Decimal DEFAULT_保険給付費額 = new Decimal(0);
    public static final FlexibleDate DEFAULT_承認結果通知書作成日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_承認結果通知書再発行区分 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3078ShokanJuryoininKeiyakushaEntityGenerator() {
    }

    public static DbT3078ShokanJuryoininKeiyakushaEntity createDbT3078ShokanJuryoininKeiyakushaEntity() {
        DbT3078ShokanJuryoininKeiyakushaEntity entity = new DbT3078ShokanJuryoininKeiyakushaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setJigyoshaKeiyakuNo(DEFAULT_事業者契約番号);
        entity.setKeiyakuServiceShurui(DEFAULT_契約サービス種類);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setShoninKekkaKubun(DEFAULT_承認結果区分);
        entity.setJuryoininKaishiYMD(DEFAULT_受領委任払適用開始年月日);
        entity.setJuryoininShuryoYMD(DEFAULT_受領委任払適用終了年月日);
        entity.setKeiyakuNo(DEFAULT_契約番号);
        entity.setFuShoninRiyu(DEFAULT_不承認理由);
        entity.setHiyoGakuGokei(DEFAULT_費用額合計);
        entity.setHokenTaishoHiyoGaku(DEFAULT_保険対象費用額);
        entity.setRiyoshaJikoFutanGaku(DEFAULT_利用者自己負担額);
        entity.setHokenKyufuhiGaku(DEFAULT_保険給付費額);
        entity.setShoninKekkaTsuchiSakuseiYMD(DEFAULT_承認結果通知書作成日);
        entity.setShoninKekkaTsuchiSaiHakkoKubun(DEFAULT_承認結果通知書再発行区分);
        return entity;
    }
}
