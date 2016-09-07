/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修理由書作成手数料請求集計エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator {

    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_集計開始年月 = new FlexibleYearMonth("199001");
    public static final int DEFAULT_履歴番号 = 0;
    public static final FlexibleYearMonth DEFAULT_集計終了年月 = new FlexibleYearMonth("199001");
    public static final JigyoshaNo DEFAULT_介護住宅改修理由書作成事業者番号 = new JigyoshaNo("1");
    public static final Decimal DEFAULT_介護住宅改修理由書作成件数 = new Decimal(0);
    public static final Decimal DEFAULT_介護住宅改修理由書作成単価 = new Decimal(0);
    public static final Decimal DEFAULT_介護住宅改修理由書作成請求金額 = new Decimal(0);
    public static final FlexibleDate DEFAULT_介護住宅改修理由書作成申請年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_介護住宅改修理由書作成受付年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_介護支払方法区分 = new RString("Data");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator() {
    }

    public static DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity() {
        DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = new DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShukeiKaishiYM(DEFAULT_集計開始年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShukeiShuryoYM(DEFAULT_集計終了年月);
        entity.setRiyushoSakuseiJigyoshaNo(DEFAULT_介護住宅改修理由書作成事業者番号);
        entity.setRiyushoSakuseiKensu(DEFAULT_介護住宅改修理由書作成件数);
        entity.setRiyushoSakuseiTanka(DEFAULT_介護住宅改修理由書作成単価);
        entity.setRiyushoSakuseiSeikyuKingaku(DEFAULT_介護住宅改修理由書作成請求金額);
//        entity.setRiyushoSakuseiShinseiYMD(DEFAULT_介護住宅改修理由書作成申請年月日);
//        entity.setRiyushoSakuseiUketsukeYMD(DEFAULT_介護住宅改修理由書作成受付年月日);
        entity.setShiharaiHohoKubun(DEFAULT_介護支払方法区分);
        entity.setShikibetsuNo(DEFAULT_識別コード);
        return entity;
    }
}
