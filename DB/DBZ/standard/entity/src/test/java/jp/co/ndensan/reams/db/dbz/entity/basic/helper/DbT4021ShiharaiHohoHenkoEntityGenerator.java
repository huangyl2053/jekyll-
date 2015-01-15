/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.BemmeiRiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.BemmeiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.KanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.ShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.ShuryoShinseiRiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.ShuryoShinseiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.TorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支払方法変更エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8187 久保田 英男
 */
public final class DbT4021ShiharaiHohoHenkoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("123456");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("012345");
    public static final KanriKubun DEFAULT_管理区分 = KanriKubun.ニ号差止;
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS("20140101102030");
    public static final TorokuKubun DEFAULT_登録区分 = TorokuKubun.二号予告登録者;
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("20150102");
    public static final ShuryoKubun DEFAULT_終了区分 = ShuryoKubun.差止措置終了依頼書受理;
    public static final FlexibleDate DEFAULT_予告登録年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_差止依頼書受理年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_予告通知書発行年月日 = new FlexibleDate("20140102");
    public static final boolean DEFAULT_予告通知書再発行フラグ = true;
    public static final FlexibleDate DEFAULT_弁明書提出期限 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_弁明書受付年月日 = new FlexibleDate("20140102");
    public static final BemmeiRiyu DEFAULT_弁明理由コード = BemmeiRiyu.公費負担医療の受給;
    public static final FlexibleDate DEFAULT_弁明審査決定年月日 = new FlexibleDate("20140102");
    public static final BemmeiShinsaKekkaKubun DEFAULT_弁明審査結果区分 = BemmeiShinsaKekkaKubun.申請受理;
    public static final FlexibleDate DEFAULT_償還払化決定年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_償還払化通知書発行年月日 = new FlexibleDate("20140102");
    public static final boolean DEFAULT_償還払化通知書再発行フラグ = true;
    public static final FlexibleDate DEFAULT_被保険者証提出期限 = new FlexibleDate("20140102");
    public static final boolean DEFAULT_差止対象フラグ = true;
    public static final FlexibleDate DEFAULT_差止対象決定年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_差止対象解除年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_減額決定年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_減額通知書発行年月日 = new FlexibleDate("20140102");
    public static final boolean DEFAULT_減額通知書再発行フラグ = true;
    public static final HokenKyufuRitsu DEFAULT_給付率 = new HokenKyufuRitsu(new Decimal("1"));
    public static final FlexibleDate DEFAULT_終了申請書受付年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_終了申請年月日 = new FlexibleDate("20140102");
    public static final ShuryoShinseiRiyu DEFAULT_終了申請理由コード = ShuryoShinseiRiyu.公費負担医療の受給;
    public static final FlexibleDate DEFAULT_終了申請審査決定年月日 = new FlexibleDate("20140102");
    public static final ShuryoShinseiShinsaKekkaKubun DEFAULT_終了申請審査結果区分 = ShuryoShinseiShinsaKekkaKubun.申請受理;
    public static final boolean DEFAULT_無効区分 = true;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT4021ShiharaiHohoHenkoEntityGenerator() {
    }

    public static DbT4021ShiharaiHohoHenkoEntity createDbT4021ShiharaiHohoHenkoEntity() {
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKanriKubun(DEFAULT_管理区分.code());
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTorokuKubun(DEFAULT_登録区分.code());
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setShuryoKubun(DEFAULT_終了区分.code());
        entity.setYokoku_TorokuYMD(DEFAULT_予告登録年月日);
        entity.setSashitome_IraiJuriYMD(DEFAULT_差止依頼書受理年月日);
        entity.setYokoku_TsuchiHakkoYMD(DEFAULT_予告通知書発行年月日);
        entity.setYokoku_TsuchiSaiHakkoFlag(DEFAULT_予告通知書再発行フラグ);
        entity.setBemmei_TeishutsuYMD(DEFAULT_弁明書提出期限);
        entity.setBemmei_UketsukeYMD(DEFAULT_弁明書受付年月日);
        entity.setBemmei_RiyuCode(DEFAULT_弁明理由コード.code());
        entity.setBemmei_ShinsaKetteiYMD(DEFAULT_弁明審査決定年月日);
        entity.setBemmei_ShinsaKekkaKubun(DEFAULT_弁明審査結果区分.code());
        entity.setShokan_KetteiYMD(DEFAULT_償還払化決定年月日);
        entity.setShokan_TsuchiHakkoYMD(DEFAULT_償還払化通知書発行年月日);
        entity.setShokan_TsuchiSaiHakkoFlag(DEFAULT_償還払化通知書再発行フラグ);
        entity.setHihokenshaShoTeishutsuYMD(DEFAULT_被保険者証提出期限);
        entity.setSashitome_Flag(DEFAULT_差止対象フラグ);
        entity.setSashitome_KetteiYMD(DEFAULT_差止対象決定年月日);
        entity.setSashitome_KaijoYMD(DEFAULT_差止対象解除年月日);
        entity.setGemmen_KetteiYMD(DEFAULT_減額決定年月日);
        entity.setGemmen_TsuchiHakkoYMD(DEFAULT_減額通知書発行年月日);
        entity.setGemmen_TsuchiSaiHakkoFlag(DEFAULT_減額通知書再発行フラグ);
        entity.setKyufuRitsu(DEFAULT_給付率);
        entity.setShuryoShinsei_UketsukeYMD(DEFAULT_終了申請書受付年月日);
        entity.setShuryoShinsei_YMD(DEFAULT_終了申請年月日);
        entity.setShuryoShinsei_RiyuCode(DEFAULT_終了申請理由コード.code());
        entity.setShuryoShinsei_ShinsaKetteiYMD(DEFAULT_終了申請審査決定年月日);
        entity.setShuryoShinsei_ShinsaKekkaKubun(DEFAULT_終了申請審査結果区分.code());
        entity.setMukoKubun(DEFAULT_無効区分);
        return entity;
    }
}
