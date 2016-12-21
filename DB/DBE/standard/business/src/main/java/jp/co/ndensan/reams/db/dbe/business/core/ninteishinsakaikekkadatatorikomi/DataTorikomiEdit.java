/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinsakaikekkadatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsaIinRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）ProcessnoのEditクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
public class DataTorikomiEdit {

    /**
     * DbT5503ShinsakaiWariateIinJohoEntityのinsertメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     */
    public DbT5503ShinsakaiWariateIinJohoEntity insertDbT5503Entity(TempShinsaIinRelateEntity entity) {
        DbT5503ShinsakaiWariateIinJohoEntity dbt5503Entity = new DbT5503ShinsakaiWariateIinJohoEntity();
        return editDbT5503Entity(entity, dbt5503Entity);
    }

    /**
     * DbT5503ShinsakaiWariateIinJohoEntityのupdateメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @param dbt5503Entity DbT5503ShinsakaiWariateIinJohoEntity
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     */
    public DbT5503ShinsakaiWariateIinJohoEntity updateDbT5503Entity(TempShinsaIinRelateEntity entity,
                                                                    DbT5503ShinsakaiWariateIinJohoEntity dbt5503Entity) {
        return editDbT5503Entity(entity, dbt5503Entity);
    }

    private DbT5503ShinsakaiWariateIinJohoEntity editDbT5503Entity(TempShinsaIinRelateEntity entity,
                                                                   DbT5503ShinsakaiWariateIinJohoEntity dbt5503Entity) {
        dbt5503Entity.setShinsakaiKaisaiNo(entity.get介護認定審査会開催番号() == null
                                           ? RString.EMPTY : entity.get介護認定審査会開催番号());
        dbt5503Entity.setShinsakaiIinCode(entity.get介護認定審査会委員コード() == null
                                          ? RString.EMPTY : entity.get介護認定審査会委員コード());
        dbt5503Entity.setShinsakaiKaisaiYMD(entity.get介護認定審査会開催年月日() == null
                                            ? FlexibleDate.EMPTY : new FlexibleDate(entity.get介護認定審査会開催年月日()));
        dbt5503Entity.setKaigoninteiShinsakaiGichoKubunCode(entity.get介護認定審査会委員長区分コード() == null
                                                            ? Code.EMPTY : new Code(entity.get介護認定審査会委員長区分コード()));
        dbt5503Entity.setShussekiFlag(entity.get委員出席() == null ? false : Boolean.valueOf(entity.get委員出席().toString()));
        dbt5503Entity.setExistChikokuFlag(entity.get委員遅刻有無() == null ? false : Boolean.valueOf(entity.get委員遅刻有無().toString()));
        dbt5503Entity.setShussekiTime(entity.get委員出席時間() == null ? RString.EMPTY : entity.get委員出席時間());
        dbt5503Entity.setExistSotaiFlag(entity.get委員早退有無() == null ? false : Boolean.valueOf(entity.get委員早退有無().toString()));
        dbt5503Entity.setTaisekiTime(entity.get委員退席時間() == null ? RString.EMPTY : entity.get委員退席時間());
        return dbt5503Entity;
    }

    /**
     * DbT5503ShinsakaiWariateIinJohoEntityのinsertメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     */
    public DbT5510IchiGojiHanteiKekkaJohoEntity insertDbT5510Entity(TempShinsakaiKekkaEntity entity) {
        DbT5510IchiGojiHanteiKekkaJohoEntity dbt5510Entity = new DbT5510IchiGojiHanteiKekkaJohoEntity();
        return editDbT5510Entity(entity, dbt5510Entity);
    }

    /**
     * DbT5503ShinsakaiWariateIinJohoEntityのupdateメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @param dbt5510Entity DbT5510IchiGojiHanteiKekkaJohoEntity
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     */
    public DbT5510IchiGojiHanteiKekkaJohoEntity updateDbT5510Entity(TempShinsakaiKekkaEntity entity,
                                                                    DbT5510IchiGojiHanteiKekkaJohoEntity dbt5510Entity) {
        return editDbT5510Entity(entity, dbt5510Entity);
    }

    private DbT5510IchiGojiHanteiKekkaJohoEntity editDbT5510Entity(TempShinsakaiKekkaEntity entity,
                                                                   DbT5510IchiGojiHanteiKekkaJohoEntity dbt5510Entity) {
        dbt5510Entity.setShinseishoKanriNo(entity.get申請書管理番号() == null
                                           ? ShinseishoKanriNo.EMPTY : new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbt5510Entity.setIchiGojiHanteiYMD(entity.get要介護認定一点五次判定年月日() == null
                                           ? FlexibleDate.EMPTY : new FlexibleDate(entity.get要介護認定一点五次判定年月日()));
        dbt5510Entity.setIchiGojiHanteiKekkaCode(entity.get要介護認定一点五次判定結果コード() == null
                                                 ? Code.EMPTY : new Code(entity.get要介護認定一点五次判定結果コード()));
        dbt5510Entity.setIchiGojiHanteiKekkaNinchishoKasanCode(entity.get要介護認定一点五次判定結果コード_認知症加算() == null
                                                               ? Code.EMPTY : new Code(entity.get要介護認定一点五次判定結果コード_認知症加算()));
        dbt5510Entity.setKijunJikan(entity.get一点五次要介護認定等基準時間() == null
                                    ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間().toString()));
        dbt5510Entity.setKijunJikanShokuji(entity.get一点五次要介護認定等基準時間_食事() == null
                                           ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_食事().toString()));
        dbt5510Entity.setKijunJikanHaisetsu(entity.get一点五次要介護認定等基準時間_排泄() == null
                                            ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_排泄().toString()));
        dbt5510Entity.setKijunJikanIdo(entity.get一点五次要介護認定等基準時間_移動() == null
                                       ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_移動().toString()));
        dbt5510Entity.setKijunJikanSeiketsuHoji(entity.get一点五次要介護認定等基準時間_清潔保持() == null
                                                ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_清潔保持().toString()));
        dbt5510Entity.setKijunJikanKansetsuCare(entity.get一点五次要介護認定等基準時間_間接ケア() == null
                                                ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_間接ケア().toString()));
        dbt5510Entity.setKijunJikanBPSDKanren(entity.get一点五次要介護認定等基準時間_BPSD関連() == null
                                              ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_BPSD関連().toString()));
        dbt5510Entity.setKijunJikanKinoKunren(entity.get一点五次要介護認定等基準時間_機能訓練() == null
                                              ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_機能訓練().toString()));
        dbt5510Entity.setKijunJikanIryoKanren(entity.get一点五次要介護認定等基準時間_医療関連() == null
                                              ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_医療関連().toString()));
        dbt5510Entity.setKijunJikanNinchishoKasan(entity.get一点五次要介護認定等基準時間_認知症加算() == null
                                                  ? 0 : (int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_認知症加算().toString()));
        dbt5510Entity.setChukanHyokaKomoku1gun(entity.get一点五次中間評価項目得点第1群() == null
                                               ? 0 : (int) Double.parseDouble(entity.get一点五次中間評価項目得点第1群().toString()));
        dbt5510Entity.setChukanHyokaKomoku2gun(entity.get一点五次中間評価項目得点第2群() == null
                                               ? 0 : (int) Double.parseDouble(entity.get一点五次中間評価項目得点第2群().toString()));
        dbt5510Entity.setChukanHyokaKomoku3gun(entity.get一点五次中間評価項目得点第3群() == null
                                               ? 0 : (int) Double.parseDouble(entity.get一点五次中間評価項目得点第3群().toString()));
        dbt5510Entity.setChukanHyokaKomoku4gun(entity.get一点五次中間評価項目得点第4群() == null
                                               ? 0 : (int) Double.parseDouble(entity.get一点五次中間評価項目得点第4群().toString()));
        dbt5510Entity.setChukanHyokaKomoku5gun(entity.get一点五次中間評価項目得点第5群() == null
                                               ? 0 : (int) Double.parseDouble(entity.get一点五次中間評価項目得点第5群().toString()));
        dbt5510Entity.setIchiGojiHnateiKeikokuCode(entity.get一点五次要介護認定一点五次判定警告コード() == null
                                                   ? Code.EMPTY : new Code(entity.get一点五次要介護認定一点五次判定警告コード()));
        dbt5510Entity.setJotaiAnteiseiCode(entity.get一点五次要介護認定状態の安定性コード() == null
                                           ? Code.EMPTY : new Code(entity.get一点五次要介護認定状態の安定性コード()));
        dbt5510Entity.setNinchishoJiritsudoIIijoNoGaizensei(entity.get一点五次認知症自立度Ⅱ以上の蓋然性() == null
                                                            ? Decimal.ZERO : new Decimal(entity.get一点五次認知症自立度Ⅱ以上の蓋然性().toString()));
        dbt5510Entity.setSuiteiKyufuKubunCode(entity.get一点五次認知機能及び状態安定性から推定される給付区分コード() == null
                                              ? Code.EMPTY : new Code(entity.get一点五次認知機能及び状態安定性から推定される給付区分コード()));
        return dbt5510Entity;
    }

    /**
     * DbT5105NinteiKanryoJohoEntityのinsertメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @param 審査会資料作成年月日 審査会資料作成年月日
     * @param nowDate システム日付
     * @return DbT5102NinteiKekkaJohoEntity
     */
    public DbT5102NinteiKekkaJohoEntity insertDbT5102Entity(TempShinsakaiKekkaEntity entity, FlexibleDate 審査会資料作成年月日,
                                                            FlexibleDate nowDate) {
        DbT5102NinteiKekkaJohoEntity dbt5102Entity = new DbT5102NinteiKekkaJohoEntity();
        return editDbT5102Entity(entity, dbt5102Entity, 審査会資料作成年月日, nowDate);
    }

    /**
     * DbT5105NinteiKanryoJohoEntityの設定メッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @param dbt5102Entity DbT5102NinteiKekkaJohoEntity
     * @param 審査会資料作成年月日 審査会資料作成年月日
     * @param nowDate システム日付
     * @return DbT5102NinteiKekkaJohoEntity
     */
    public DbT5102NinteiKekkaJohoEntity updateDbT5102Entity(TempShinsakaiKekkaEntity entity, DbT5102NinteiKekkaJohoEntity dbt5102Entity,
                                                            FlexibleDate 審査会資料作成年月日, FlexibleDate nowDate) {
        return editDbT5102Entity(entity, dbt5102Entity, 審査会資料作成年月日, nowDate);
    }

    private DbT5102NinteiKekkaJohoEntity editDbT5102Entity(TempShinsakaiKekkaEntity entity, DbT5102NinteiKekkaJohoEntity dbt5102Entity,
                                                           FlexibleDate 審査会資料作成年月日, FlexibleDate nowDate) {
        dbt5102Entity.setShinseishoKanriNo(entity.get申請書管理番号() == null
                                           ? ShinseishoKanriNo.EMPTY : new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbt5102Entity.setNijiHanteiYMD(entity.get今回_二次判定日() == null
                                       ? FlexibleDate.EMPTY : new FlexibleDate(entity.get今回_二次判定日()));
        dbt5102Entity.setNijiHanteiYokaigoJotaiKubunCode(Code.EMPTY);//要介護状態区分？
        dbt5102Entity.setNijiHanteiNinteiYukoKikan(entity.get今回_認定期間() == null ? 0 : entity.get今回_認定期間().toInt());
        dbt5102Entity.setNijiHanteiNinteiYukoKaishiYMD(entity.get今回_認定有効開始年月日() == null
                                                       ? FlexibleDate.EMPTY : new FlexibleDate(entity.get今回_認定有効開始年月日()));
        dbt5102Entity.setNijiHanteiNinteiYukoShuryoYMD(entity.get今回_認定有効終了年月日() == null
                                                       ? FlexibleDate.EMPTY : new FlexibleDate(entity.get今回_認定有効終了年月日()));
        dbt5102Entity.setShinsakaiShiryoSakuseiYMD(審査会資料作成年月日);
        dbt5102Entity.setShinsakaiKaisaiNo(entity.get今回_審査会開催番号() == null ? RString.EMPTY : entity.get今回_審査会開催番号());
        dbt5102Entity.setShinsakaiIken(entity.get今回_審査会意見() == null ? RString.EMPTY : entity.get今回_審査会意見());
        dbt5102Entity.setIchijiHanteiKekkaHenkoRiyu(RString.EMPTY);//変更理由？
        dbt5102Entity.setYokaigoJotaizoReiCode(entity.get今回_状態像() == null ? Code.EMPTY : new Code(entity.get今回_状態像()));
        dbt5102Entity.setShinsakaiMemo(entity.get今回_審査会メモ() == null ? RString.EMPTY : entity.get今回_審査会メモ());
        dbt5102Entity.setNinteishinsakaiIkenShurui(RString.EMPTY);//意見種類？
        dbt5102Entity.setNijiHanteiKekkaInputHoho(new Code("2"));
        dbt5102Entity.setNijiHanteiKekkaInputYMD(nowDate);
        return dbt5102Entity;
    }

    /**
     * DbT5511ShinsakaiKaisaiKekkaJohoEntityのinsertメッソドです。
     *
     * @param entity TempShinsakaiJohoEntity
     * @return DbT5511ShinsakaiKaisaiKekkaJohoEntity
     */
    public DbT5511ShinsakaiKaisaiKekkaJohoEntity insertDbT5511Entity(TempShinsakaiJohoEntity entity) {
        DbT5511ShinsakaiKaisaiKekkaJohoEntity dbt5511Entity = new DbT5511ShinsakaiKaisaiKekkaJohoEntity();
        return editDbT5511Entity(entity, dbt5511Entity);
    }

    /**
     * DbT5511ShinsakaiKaisaiKekkaJohoEntityのupdateメッソドです。
     *
     * @param entity TempShinsakaiJohoEntity
     * @param dbt5511Entity DbT5511ShinsakaiKaisaiKekkaJohoEntity
     * @return DbT5511ShinsakaiKaisaiKekkaJohoEntity
     */
    public DbT5511ShinsakaiKaisaiKekkaJohoEntity updateDbT5511Entity(TempShinsakaiJohoEntity entity,
                                                                     DbT5511ShinsakaiKaisaiKekkaJohoEntity dbt5511Entity) {
        return editDbT5511Entity(entity, dbt5511Entity);
    }

    private DbT5511ShinsakaiKaisaiKekkaJohoEntity editDbT5511Entity(TempShinsakaiJohoEntity entity,
                                                                    DbT5511ShinsakaiKaisaiKekkaJohoEntity dbt5511Entity) {
        dbt5511Entity.setShinsakaiKaisaiNo(entity.get介護認定審査会開催番号());
        dbt5511Entity.setGogitaiNo(entity.get合議体番号() == null ? 0 : (int) Double.parseDouble(entity.get合議体番号().toString()));
        dbt5511Entity.setShinsakaiKaisaiYMD(entity.get介護認定審査会開催年月日() == null
                                            ? FlexibleDate.EMPTY : new FlexibleDate(entity.get介護認定審査会開催年月日()));
        dbt5511Entity.setShinsakaiKaishiTime(entity.get介護認定審査会開始時刻());
        dbt5511Entity.setShinsakaiShuryoTime(entity.get介護認定審査会終了時刻());
        return dbt5511Entity;
    }
}
