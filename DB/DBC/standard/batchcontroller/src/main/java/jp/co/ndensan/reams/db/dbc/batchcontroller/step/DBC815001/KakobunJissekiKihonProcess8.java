/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonBusiness;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.KyufuJissekiTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.ShiKaKuiDoDeTaEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoshaChushutsuSokyubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN41003_高額介護対象者抽出（遡及分）のProcessです。
 *
 * @reamsid_L DBC-5750-030 wanghui
 */
public class KakobunJissekiKihonProcess8 extends BatchProcessBase<ShiKaKuiDoDeTaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kogakukaigotaishoshachushutsusokyubun.IKogakuKaigoTaishoshaChushutsuSokyubunMapper.get給付実績基本TBLデータ");
    private static final RString 宛名データ抽出 = new RString("Tempkeisantaisyo");
    private KogakuKaigoTaishoshaChushutsuSokyubun sokyubun;
    private KogakuKaigoTaishoProcessParameter parameter;
    private KakobunJissekiKihonBusiness business;
    private LasdecCode 団体コード;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempTable;

    @Override
    protected void initialize() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        団体コード = association.get地方公共団体コード();
        business = new KakobunJissekiKihonBusiness();
        sokyubun = KogakuKaigoTaishoshaChushutsuSokyubun.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, business.setparameter(parameter, 団体コード.value(), RString.EMPTY));
    }

    @Override
    protected void createWriter() {
        tempTable = new BatchEntityCreatedTempTableWriter(宛名データ抽出,
                KakobunJissekiKihonTempTableEntity.class);
    }

    @Override
    protected void process(ShiKaKuiDoDeTaEntity entity) {
        business.setShiKalist(entity);
    }

    @Override
    protected void afterExecute() {
        List<ShiKaKuiDoDeTaEntity> datelist = sokyubun.getKyufuJisseki(business.getShiKalist());
        for (ShiKaKuiDoDeTaEntity entity : datelist) {
            KyufuJissekiTempTableEntity temoTableEntity = new KyufuJissekiTempTableEntity();
            temoTableEntity.set交換情報識別番号(entity.get交換情報識別番号());
            temoTableEntity.set入力識別番号(entity.get入力識別番号());
            temoTableEntity.setレコード種別コード(entity.getレコード種別コード());
            temoTableEntity.set給付実績情報作成区分コード(entity.get給付実績情報作成区分コード());
            temoTableEntity.set証記載保険者番号(entity.get証記載保険者番号());
            temoTableEntity.set被保険者番号(entity.get被保険者番号());
            temoTableEntity.setサービス提供年月(entity.getサービス提供年月());
            temoTableEntity.set給付実績区分コード(entity.get給付実績区分コード());
            temoTableEntity.set事業所番号(entity.get事業所番号());
            temoTableEntity.set通し番号(entity.get通し番号());
            temoTableEntity.set公費１負担者番号(entity.get公費１負担者番号());
            temoTableEntity.set公費１受給者番号(entity.get公費１受給者番号());
            temoTableEntity.set公費１受給者番号(entity.get公費１受給者番号());
            temoTableEntity.set公費２受給者番号(entity.get公費２受給者番号());
            temoTableEntity.set公費３負担者番号(entity.get公費３負担者番号());
            temoTableEntity.set公費３受給者番号(entity.get公費３受給者番号());
            temoTableEntity.set生年月日(entity.get生年月日());
            temoTableEntity.set性別コード(entity.get性別コード());
            temoTableEntity.set要介護状態区分コード(entity.get要介護状態区分コード());
            temoTableEntity.set旧措置入所者特例コード(entity.get旧措置入所者特例コード());
            temoTableEntity.set認定有効期間開始年月日(entity.get認定有効期間開始年月日());
            temoTableEntity.set認定有功期間終了年月日(entity.get認定有功期間終了年月日());
            temoTableEntity.set老人保健市町村番号(entity.get老人保健市町村番号());
            temoTableEntity.set老人保健受給者番号(entity.get老人保健受給者番号());
            temoTableEntity.set保険者番号後期(entity.get保険者番号後期());
            temoTableEntity.set被保険者番号後期(entity.get被保険者番号後期());
            temoTableEntity.set保険者番号国保(entity.get保険者番号国保());
            temoTableEntity.set被保険者証番号国保(entity.get被保険者証番号国保());
            temoTableEntity.set個人番号国保(entity.get個人番号国保());
            temoTableEntity.set居宅サービス計画作成区分コード(entity.get居宅サービス計画作成区分コード());
            temoTableEntity.set事業所番号居宅介護支援事業所等(entity.get事業所番号居宅介護支援事業所等());
            temoTableEntity.set開始年月日(entity.get開始年月日());
            temoTableEntity.set中止年月日(entity.get中止年月日());
            temoTableEntity.set中止理由入所院前の状況コード(entity.get中止理由入所院前の状況コード());
            temoTableEntity.set入所院年月日(entity.get入所院年月日());
            temoTableEntity.set退所院年月日(entity.get退所院年月日());
            temoTableEntity.set入所院実日数(entity.get入所院実日数());
            temoTableEntity.set外泊日数(entity.get外泊日数());
            temoTableEntity.set退所院後の状態コード(entity.get退所院後の状態コード());
            temoTableEntity.set保険給付率(entity.get保険給付率());
            temoTableEntity.set公費１給付率(entity.get公費１給付率());
            temoTableEntity.set公費２給付率(entity.get公費２給付率());
            temoTableEntity.set公費３給付率(entity.get公費３給付率());
            temoTableEntity.set前保険サービス単位数(entity.get前保険サービス単位数());
            temoTableEntity.set前保険請求額(entity.get前保険請求額());
            temoTableEntity.set前保険利用者負担額(entity.get前保険利用者負担額());
            temoTableEntity.set前保険緊急時施設療養費請求額(entity.get前保険緊急時施設療養費請求額());
            temoTableEntity.set前保険特定診療費請求額(entity.get前保険特定診療費請求額());
            temoTableEntity.set前保険特定入所者介護サービス費等請求額(entity.get前保険特定入所者介護サービス費等請求額());
            temoTableEntity.set前公費１サービス単位数(entity.get前公費１サービス単位数());
            temoTableEntity.set前公費１請求額(entity.get前公費１請求額());
            temoTableEntity.set前公費１本人負担額(entity.get前公費１本人負担額());
            temoTableEntity.set前公費１緊急時施設療養費請求額(entity.get前公費１緊急時施設療養費請求額());
            temoTableEntity.set前公費１特定診療費請求額(entity.get前公費１特定診療費請求額());
            temoTableEntity.set前公費１特定入所者介護サービス費等請求額(entity.get前公費１特定入所者介護サービス費等請求額());
            temoTableEntity.set前公費２サービス単位数(entity.get前公費２サービス単位数());
            temoTableEntity.set前公費２請求額(entity.get前公費２請求額());
            temoTableEntity.set前公費２本人負担額(entity.get前公費２本人負担額());
            temoTableEntity.set前公費２緊急時施設療養費請求額(entity.get前公費２緊急時施設療養費請求額());
            temoTableEntity.set前公費２特定診療費請求額(entity.get前公費２特定診療費請求額());
            temoTableEntity.set前公費２特定入所者介護サービス費等請求額(entity.get前公費２特定入所者介護サービス費等請求額());
            temoTableEntity.set前公費３サービス単位数(entity.get前公費３サービス単位数());
            temoTableEntity.set前公費３請求額(entity.get前公費３請求額());
            temoTableEntity.set前公費３本人負担額(entity.get前公費３本人負担額());
            temoTableEntity.set前公費３緊急時施設療養費請求額(entity.get前公費３緊急時施設療養費請求額());
            temoTableEntity.set前公費３特定診療費請求額(entity.get前公費３特定診療費請求額());
            temoTableEntity.set前公費３特定入所者介護サービス費等請求額(entity.get前公費３特定入所者介護サービス費等請求額());
            temoTableEntity.set後保険サービス単位数(entity.get後保険サービス単位数());
            temoTableEntity.set後保険請求額(entity.get後保険請求額());
            temoTableEntity.set後保険利用者負担額(entity.get後保険利用者負担額());
            temoTableEntity.set後緊急時施設療養費請求額(entity.get後緊急時施設療養費請求額());
            temoTableEntity.set後保険特定診療費請求額(entity.get後保険特定診療費請求額());
            temoTableEntity.set後保険特定入所者介護サービス費等請求額(entity.get後保険特定入所者介護サービス費等請求額());
            temoTableEntity.set後公費１サービス単位数(entity.get後公費１サービス単位数());
            temoTableEntity.set後公費１請求額(entity.get後公費１請求額());
            temoTableEntity.set後公費１本人負担額(entity.get後公費１本人負担額());
            temoTableEntity.set後公費１緊急時施設療養費請求額(entity.get後公費１緊急時施設療養費請求額());
            temoTableEntity.set後公費１特定診療費請求額(entity.get後公費１特定診療費請求額());
            temoTableEntity.set後公費１特定入所者介護サービス費等請求額(entity.get後公費１特定入所者介護サービス費等請求額());
            temoTableEntity.set後公費２サービス単位数(entity.get後公費２サービス単位数());
            temoTableEntity.set後公費２請求額(entity.get後公費２請求額());
            temoTableEntity.set後公費２利用者負担額(entity.get後公費２利用者負担額());
            temoTableEntity.set後公費２緊急時施設療養費請求額(entity.get後公費２緊急時施設療養費請求額());
            temoTableEntity.set後公費２特定診療費請求額(entity.get後公費２特定診療費請求額());
            temoTableEntity.set後公費２特定入所者介護サービス費等請求額(entity.get後公費２特定入所者介護サービス費等請求額());
            temoTableEntity.set後公費３サービス単位数(entity.get後公費３サービス単位数());
            temoTableEntity.set後公費３請求額(entity.get後公費３請求額());
            temoTableEntity.set後公費３利用者負担額(entity.get後公費３利用者負担額());
            temoTableEntity.set後公費３緊急時施設療養費請求額(entity.get後公費３緊急時施設療養費請求額());
            temoTableEntity.set後公費３特定診療費請求額(entity.get後公費３特定診療費請求額());
            temoTableEntity.set後公費３特定入所者介護サービス費等請求額(entity.get後公費３特定入所者介護サービス費等請求額());
            temoTableEntity.set警告区分コード(entity.get警告区分コード());
            temoTableEntity.set審査年月(entity.get審査年月());
            temoTableEntity.set整理番号(entity.get整理番号());
            temoTableEntity.set送付年月(entity.get送付年月());
            temoTableEntity.set取込年月(entity.get取込年月());
            temoTableEntity.set独自作成区分(entity.get独自作成区分());
            temoTableEntity.set保険者保有給付実績情報削除済フラグ(entity.is保険者保有給付実績情報削除済フラグ());
            tempTable.insert(temoTableEntity);
        }
    }
}
