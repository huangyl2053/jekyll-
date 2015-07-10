/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修理由書作成手数料請求集計エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator {

    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("02"));
    public static final FlexibleYearMonth DEFAULT_集計開始年月 = new FlexibleYearMonth(new RString("201402"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleYearMonth DEFAULT_集計終了年月 = new FlexibleYearMonth(new RString("201602"));
    public static final JigyoshaNo DEFAULT_介護住宅改修理由書作成事業者番号 = new JigyoshaNo(new RString("02"));
    public static final Decimal DEFAULT_介護住宅改修理由書作成件数 = new Decimal(10);
    public static final Decimal DEFAULT_介護住宅改修理由書作成単価 = new Decimal(1000);
    public static final Decimal DEFAULT_介護住宅改修理由書作成請求金額 = new Decimal(10000);
    public static final FlexibleDate DEFAULT_介護住宅改修理由書作成申請年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_介護住宅改修理由書作成受付年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_介護支払方法区分 = new RString("3");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator() {
    }

    public static DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity() {
        DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = new DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShukeiKaishiYM(DEFAULT_集計開始年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShukeiShuryoYM(DEFAULT_集計終了年月);
        entity.setRiyushoSakuseiJigyoshaNo(DEFAULT_介護住宅改修理由書作成事業者番号);
        entity.setRiyushoSakuseiKensu(DEFAULT_介護住宅改修理由書作成件数);
        entity.setRiyushoSakuseiTanka(DEFAULT_介護住宅改修理由書作成単価);
        entity.setRiyushoSakuseiSeikyuKingaku(DEFAULT_介護住宅改修理由書作成請求金額);
        entity.setRiyushoSakuseiShinseiYMD(DEFAULT_介護住宅改修理由書作成申請年月日);
        entity.setRiyushoSakuseiUketsukeYMD(DEFAULT_介護住宅改修理由書作成受付年月日);
        entity.setShiharaiHohoKubun(DEFAULT_介護支払方法区分);
        entity.setShikibetsuNo(DEFAULT_識別コード);
        return entity;
    }
}
