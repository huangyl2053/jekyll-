/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給住宅改修事前申請エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("20140402");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_事業者名称 = new RString("1");
    public static final RString DEFAULT_事業者名称カナ = new RString("1");
    public static final YubinNo DEFAULT_事業者郵便番号 = new YubinNo(new RString("123-1234"));
    public static final RString DEFAULT_事業者住所 = new RString("1");
    public static final RString DEFAULT_事業者電話番号 = new RString("1");
    public static final RString DEFAULT_事業者ＦＡＸ番号 = new RString("1");
    public static final RString DEFAULT_理由書作成者 = new RString("1");
    public static final RString DEFAULT_理由書作成者カナ = new RString("1");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final FlexibleDate DEFAULT_契約決定年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_承認区分 = new RString("1");
    public static final RString DEFAULT_不承認の理由 = new RString("1");
    public static final int DEFAULT_給付額等_費用額合計 = 1;
    public static final int DEFAULT_給付額等_保険対象費用額 = 1;
    public static final int DEFAULT_給付額等_利用者自己負担額 = 1;
    public static final int DEFAULT_給付額等_保険給付費額 = 1;
    public static final FlexibleDate DEFAULT_施工完了予定年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_申請取消事由コード = new RString("1");
    public static final RString DEFAULT_備考 = new RString("1");

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
        entity.setShoriTimestamp(DEFAULT_処理日時);
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
        entity.setKyufugakuHiyogakuTotal(DEFAULT_給付額等_費用額合計);
        entity.setKyufugakuHokenTaishoHiyogaku(DEFAULT_給付額等_保険対象費用額);
        entity.setKyufugakuRiyoshaJikofutangaku(DEFAULT_給付額等_利用者自己負担額);
        entity.setKyufugakuHokenkyufuhigaku(DEFAULT_給付額等_保険給付費額);
        entity.setSekoKanryoYoteiYMD(DEFAULT_施工完了予定年月日);
        entity.setShinseiTorikeshiJiyuCode(DEFAULT_申請取消事由コード);
        entity.setBiko(DEFAULT_備考);
        return entity;
    }
}
