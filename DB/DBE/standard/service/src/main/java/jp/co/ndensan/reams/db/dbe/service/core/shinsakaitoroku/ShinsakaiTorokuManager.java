/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku;

import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5510IchiGojiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会登録のManagerです。
 *
 * @reamsid_L DBE-0340-010 linghuhang
 */
public class ShinsakaiTorokuManager {

    private final DbT5105NinteiKanryoJohoDac dbt5105Dac;
    private final DbT5102NinteiKekkaJohoDac dbt5102Dac;
    private final DbT5510IchiGojiHanteiKekkaJohoDac dbt5510Dac;
    private final DbT5502ShinsakaiWariateJohoDac dbt5502Dac;

    ShinsakaiTorokuManager() {
        this.dbt5105Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
        this.dbt5102Dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
        this.dbt5510Dac = InstanceProvider.create(DbT5510IchiGojiHanteiKekkaJohoDac.class);
        this.dbt5502Dac = InstanceProvider.create(DbT5502ShinsakaiWariateJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbt5105Dac DbT5105NinteiKanryoJohoDac
     */
    ShinsakaiTorokuManager(
            DbT5105NinteiKanryoJohoDac dbt5105Dac,
            DbT5102NinteiKekkaJohoDac dbt5102Dac,
            DbT5510IchiGojiHanteiKekkaJohoDac dbt5510Dac,
            DbT5502ShinsakaiWariateJohoDac dbt5502Dac) {
        this.dbt5105Dac = dbt5105Dac;
        this.dbt5102Dac = dbt5102Dac;
        this.dbt5510Dac = dbt5510Dac;
        this.dbt5502Dac = dbt5502Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiTorokuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiTorokuManager}のインスタンス
     */
    public static ShinsakaiTorokuManager createInstance() {
        return InstanceProvider.create(ShinsakaiTorokuManager.class);
    }

    /**
     * 要介護認定完了情報の更新処理する。
     *
     * @param entity DbT5105NinteiKanryoJohoEntity
     */
    @Transaction
    public void 要介護認定完了更新(DbT5105NinteiKanryoJohoEntity entity) {
        dbt5105Dac.save(entity);
    }

    /**
     * CSVファイルのデータをDBへ更新する。
     *
     * @param 要介護認定結果情報 NinteiKekkaJoho
     * @param 要介護認定1_5次判定結果情報 IchiGojiHanteiKekkaJoho
     */
    @Transaction
    public void saveCsvDataInput(NinteiKekkaJoho 要介護認定結果情報, IchiGojiHanteiKekkaJoho 要介護認定1_5次判定結果情報) {
        dbt5102Dac.save(要介護認定結果情報.toEntity());
        saveIchiGojiHanteiKekkaJoho(要介護認定1_5次判定結果情報);
    }

    /**
     * 審査会資料作成年月日を取得します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 申請書管理番号 申請書管理番号
     * @return FlexibleDate 審査会資料作成年月日
     */
    @Transaction
    public FlexibleDate get審査会資料作成年月日(RString 審査会開催番号, ShinseishoKanriNo 申請書管理番号) {
        DbT5502ShinsakaiWariateJohoEntity entity = dbt5502Dac.selectByKey(審査会開催番号, 申請書管理番号);
        if (entity != null) {
            return entity.getShinsakaiShiryoSakuseiYMD();
        }
        return FlexibleDate.EMPTY;
    }

    private void saveIchiGojiHanteiKekkaJoho(IchiGojiHanteiKekkaJoho 要介護認定1_5次判定結果情報) {
        DbT5510IchiGojiHanteiKekkaJohoEntity entity = dbt5510Dac.selectByKey(要介護認定1_5次判定結果情報.get申請書管理番号());
        if (entity == null) {
            dbt5510Dac.save(要介護認定1_5次判定結果情報.toEntity());
        } else {
            entity.setIchiGojiHanteiYMD(要介護認定1_5次判定結果情報.get要介護認定1_5次判定年月日());
            entity.setIchiGojiHanteiKekkaCode(要介護認定1_5次判定結果情報.get要介護認定1_5次判定結果コード());
            entity.setIchiGojiHanteiKekkaNinchishoKasanCode(要介護認定1_5次判定結果情報.get要介護認定1_5次判定結果コード_認知症加算_());
            entity.setKijunJikan(要介護認定1_5次判定結果情報.get要介護認定等基準時間());
            entity.setKijunJikanShokuji(要介護認定1_5次判定結果情報.get要介護認定等基準時間_食事_());
            entity.setKijunJikanHaisetsu(要介護認定1_5次判定結果情報.get要介護認定等基準時間_排泄_());
            entity.setKijunJikanIdo(要介護認定1_5次判定結果情報.get要介護認定等基準時間_移動_());
            entity.setKijunJikanSeiketsuHoji(要介護認定1_5次判定結果情報.get要介護認定等基準時間_清潔保持_());
            entity.setKijunJikanKansetsuCare(要介護認定1_5次判定結果情報.get要介護認定等基準時間_間接ケア_());
            entity.setKijunJikanBPSDKanren(要介護認定1_5次判定結果情報.get要介護認定等基準時間_BPSD関連_());
            entity.setKijunJikanKinoKunren(要介護認定1_5次判定結果情報.get要介護認定等基準時間_機能訓練_());
            entity.setKijunJikanIryoKanren(要介護認定1_5次判定結果情報.get要介護認定等基準時間_医療関連_());
            entity.setKijunJikanNinchishoKasan(要介護認定1_5次判定結果情報.get要介護認定等基準時間_認知症加算_());
            entity.setChukanHyokaKomoku1gun(要介護認定1_5次判定結果情報.get中間評価項目得点第1群());
            entity.setChukanHyokaKomoku2gun(要介護認定1_5次判定結果情報.get中間評価項目得点第2群());
            entity.setChukanHyokaKomoku3gun(要介護認定1_5次判定結果情報.get中間評価項目得点第3群());
            entity.setChukanHyokaKomoku4gun(要介護認定1_5次判定結果情報.get中間評価項目得点第4群());
            entity.setChukanHyokaKomoku5gun(要介護認定1_5次判定結果情報.get中間評価項目得点第5群());
            entity.setIchiGojiHnateiKeikokuCode(要介護認定1_5次判定結果情報.get要介護認定1_5次判定警告コード());
            entity.setJotaiAnteiseiCode(要介護認定1_5次判定結果情報.get要介護認定状態の安定性コード());
            entity.setNinchishoJiritsudoIIijoNoGaizensei(要介護認定1_5次判定結果情報.get認知症自立度Ⅱ以上の蓋然性());
            entity.setSuiteiKyufuKubunCode(要介護認定1_5次判定結果情報.get認知機能及び状態安定性から推定される給付区分コード());
            entity.setState(EntityDataState.Modified);
            dbt5510Dac.save(entity);
        }
    }
}
