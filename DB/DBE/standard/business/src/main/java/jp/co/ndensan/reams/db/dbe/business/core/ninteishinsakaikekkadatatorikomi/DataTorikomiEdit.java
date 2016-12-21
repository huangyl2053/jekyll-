/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinsakaikekkadatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi.TmpNijiHanteikekkaTourokuyoDataItijiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi.TmpNinteiShinsakaiWariateIinJohoItijiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
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
    public DbT5503ShinsakaiWariateIinJohoEntity insertDbT5503Entity(TempShinsakaiIinJohoEntity entity) {
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
    public DbT5503ShinsakaiWariateIinJohoEntity updateDbT5503Entity(TempShinsakaiIinJohoEntity entity,
                                                                    DbT5503ShinsakaiWariateIinJohoEntity dbt5503Entity) {
        return editDbT5503Entity(entity, dbt5503Entity);
    }

    private DbT5503ShinsakaiWariateIinJohoEntity editDbT5503Entity(TempShinsakaiIinJohoEntity entity,
                                                                   DbT5503ShinsakaiWariateIinJohoEntity dbt5503Entity) {
        dbt5503Entity.setShinsakaiKaisaiNo(entity.get介護認定審査会開催番号());
        dbt5503Entity.setShinsakaiIinCode(entity.get介護認定審査会委員コード());
        dbt5503Entity.setShinsakaiKaisaiYMD(FlexibleDate.EMPTY);//審査会情報とJOINして取得する必要有
        dbt5503Entity.setKaigoninteiShinsakaiGichoKubunCode(new Code(entity.get介護認定審査会委員長区分コード()));
        dbt5503Entity.setShussekiFlag(Boolean.valueOf(entity.get委員出席().toString()));
        dbt5503Entity.setExistChikokuFlag(Boolean.valueOf(entity.get委員遅刻有無().toString()));
        dbt5503Entity.setShussekiTime(entity.get委員出席時間());
        dbt5503Entity.setExistSotaiFlag(Boolean.valueOf(entity.get委員早退有無().toString()));
        dbt5503Entity.setTaisekiTime(entity.get委員退席時間());
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
        dbt5510Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbt5510Entity.setIchiGojiHanteiYMD(new FlexibleDate(entity.get要介護認定一点五次判定年月日()));
        dbt5510Entity.setIchiGojiHanteiKekkaCode(new Code(entity.get要介護認定一点五次判定結果コード()));
        dbt5510Entity.setIchiGojiHanteiKekkaNinchishoKasanCode(new Code(entity.get要介護認定一点五次判定結果コード_認知症加算()));
        dbt5510Entity.setKijunJikan((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間().toString()));
        dbt5510Entity.setKijunJikanShokuji((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_食事().toString()));
        dbt5510Entity.setKijunJikanHaisetsu((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_排泄().toString()));
        dbt5510Entity.setKijunJikanIdo((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_移動().toString()));
        dbt5510Entity.setKijunJikanSeiketsuHoji((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_清潔保持().toString()));
        dbt5510Entity.setKijunJikanKansetsuCare((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_間接ケア().toString()));
        dbt5510Entity.setKijunJikanBPSDKanren((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_BPSD関連().toString()));
        dbt5510Entity.setKijunJikanKinoKunren((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_機能訓練().toString()));
        dbt5510Entity.setKijunJikanIryoKanren((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_医療関連().toString()));
        dbt5510Entity.setKijunJikanNinchishoKasan((int) Double.parseDouble(entity.get一点五次要介護認定等基準時間_認知症加算().toString()));
        dbt5510Entity.setChukanHyokaKomoku1gun(Integer.parseInt(entity.get一点五次中間評価項目得点第1群().toString()));
        dbt5510Entity.setChukanHyokaKomoku2gun(Integer.parseInt(entity.get一点五次中間評価項目得点第2群().toString()));
        dbt5510Entity.setChukanHyokaKomoku3gun(Integer.parseInt(entity.get一点五次中間評価項目得点第3群().toString()));
        dbt5510Entity.setChukanHyokaKomoku4gun(Integer.parseInt(entity.get一点五次中間評価項目得点第4群().toString()));
        dbt5510Entity.setChukanHyokaKomoku5gun(Integer.parseInt(entity.get一点五次中間評価項目得点第5群().toString()));
        dbt5510Entity.setIchiGojiHnateiKeikokuCode(new Code(entity.get一点五次要介護認定一点五次判定警告コード()));
        dbt5510Entity.setJotaiAnteiseiCode(new Code(entity.get一点五次要介護認定状態の安定性コード()));
        dbt5510Entity.setNinchishoJiritsudoIIijoNoGaizensei(new Decimal(entity.get一点五次認知症自立度Ⅱ以上の蓋然性().toString()));
        dbt5510Entity.setSuiteiKyufuKubunCode(new Code(entity.get一点五次認知機能及び状態安定性から推定される給付区分コード()));
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
        dbt5102Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbt5102Entity.setNijiHanteiYMD(new FlexibleDate(entity.get今回_二次判定日()));
        dbt5102Entity.setNijiHanteiYokaigoJotaiKubunCode(Code.EMPTY);
        dbt5102Entity.setNijiHanteiNinteiYukoKikan(entity.get今回_認定期間().toInt());
        dbt5102Entity.setNijiHanteiNinteiYukoKaishiYMD(new FlexibleDate(entity.get今回_認定有効開始年月日()));
        dbt5102Entity.setNijiHanteiNinteiYukoShuryoYMD(new FlexibleDate(entity.get今回_認定有効終了年月日()));
        dbt5102Entity.setShinsakaiShiryoSakuseiYMD(審査会資料作成年月日);
        dbt5102Entity.setShinsakaiKaisaiNo(entity.get今回_審査会開催番号());
        dbt5102Entity.setShinsakaiIken(entity.get今回_審査会意見());
        dbt5102Entity.setIchijiHanteiKekkaHenkoRiyu(RString.EMPTY);
        dbt5102Entity.setYokaigoJotaizoReiCode(new Code(entity.get今回_状態像()));
        dbt5102Entity.setShinsakaiMemo(entity.get今回_審査会メモ());
        dbt5102Entity.setNinteishinsakaiIkenShurui(RString.EMPTY);
        dbt5102Entity.setNijiHanteiKekkaInputHoho(new Code("2"));
        dbt5102Entity.setNijiHanteiKekkaInputYMD(nowDate);
        return dbt5102Entity;
    }

}
