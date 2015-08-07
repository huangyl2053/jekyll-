/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給住宅改修事前申請エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo();
    public static final RString DEFAULT_事業者名称 = new RString("Data");
    public static final RString DEFAULT_事業者名称カナ = new RString("Data");
    public static final YubinNo DEFAULT_事業者郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_事業者住所 = new RString("Data");
    public static final RString DEFAULT_事業者電話番号 = new RString("Data");
    public static final RString DEFAULT_事業者ＦＡＸ番号 = new RString("Data");
    public static final RString DEFAULT_理由書作成者 = new RString("Data");
    public static final RString DEFAULT_理由書作成者カナ = new RString("Data");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode();
    public static final FlexibleDate DEFAULT_契約決定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_承認区分 = new RString("Data");
    public static final RString DEFAULT_不承認の理由 = new RString("Data");
    public static final int DEFAULT_給付額等・費用額合計 = 1;
    public static final int DEFAULT_給付額等・保険対象費用額 = 1;
    public static final int DEFAULT_給付額等・利用者自己負担額 = 1;
    public static final int DEFAULT_給付額等・保険給付費額 = 1;
    public static final FlexibleDate DEFAULT_施工完了予定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_申請取消事由コード = new RString("Data");
    public static final RString DEFAULT_備考 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator() {
    }

    public static DbT3035ShokanJutakuKaishuJizenShinseiEntity createDbT3035ShokanJutakuKaishuJizenShinseiEntity() {
        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setJigyoshaNameKanji(DEFAULT_事業者名称);
        entity.setJigyoshaNameKana(DEFAULT_事業者名称カナ);
        entity.setJigyoshaYubunNo(DEFAULT_事業者郵便番号);
        entity.setJigyoshaAddress(DEFAULT_事業者住所);
        entity.setJigyoshaTelNo(DEFAULT_事業者電話番号);
        entity.setJigyoshaFaxNo(DEFAULT_事業者ＦＡＸ番号);
        entity.setRiyushoSakuseishaKanji(DEFAULT_理由書作成者);
        entity.setRiyushoSakuseishaKana(DEFAULT_理由書作成者カナ);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setKeiyakuKetteiYMD(DEFAULT_契約決定年月日);
        entity.setShoninKubun(DEFAULT_承認区分);
        entity.setFushoninRiyu(DEFAULT_不承認の理由);
        entity.setKyufugakuHiyogakuTotal(DEFAULT_給付額等・費用額合計);
        entity.setKyufugakuHokenTaishoHiyogaku(DEFAULT_給付額等・保険対象費用額);
        entity.setKyufugakuRiyoshaJikofutangaku(DEFAULT_給付額等・利用者自己負担額);
        entity.setKyufugakuHokenkyufuhigaku(DEFAULT_給付額等・保険給付費額);
        entity.setSekoKanryoYoteiYMD(DEFAULT_施工完了予定年月日);
        entity.setShinseiTorikeshiJiyuCode(DEFAULT_申請取消事由コード);
        entity.setBiko(DEFAULT_備考);
        return entity;
    }
}
