/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKogakuHanteiEraaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKogakuShinseishaJokenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKokuhorenIfEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufuHihokenAtenaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額介護サービス費給付対象者登録のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
public class KogakuKaigoKyufuhiTaishoshaTorokuProcess extends BatchProcessBase<KyufujissekiKihonEntity> {

//    private KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter parameter;
    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchotaishoshadotei.ITokuchoTaishoshaDoteiMapper.get介護の３つのテーブルの全件");

    private static final RString TABLE_高額介護サービス費支給申請全件一時 = new RString("TempKogakuShikyuShinseiZen");
    private static final RString TABLE_高額介護サービス費支給判定結果全件一時 = new RString("TempKogakuShikyuHanteiKekkaZen");
    private static final RString TABLE_高額介護サービス費支給審査決定全件一時 = new RString("TempKogakuShikyuShinsaKetteiZen");
    private static final RString TABLE_高額介護サービス費給付対象者合計全件一時 = new RString("TempKogakuKyufuTaishoshaGokeiZen");
    private static final RString TABLE_高額介護サービス費給付対象者明細全件一時 = new RString("TempKogakuKyufuTaishoshaMeisaiZen");
    private static final RString TABLE_事業高額介護サービス費支給申請全件一時 = new RString("TempJigyoKogakuShikyuShinseiZen");
    private static final RString TABLE_事業高額介護サービス費支給判定結果全件一時 = new RString("TempJigyoKogakuShikyuHanteiKekkaZen");
    private static final RString TABLE_事業高額介護サービス費支給審査決定全件一時 = new RString("TempJigyoKogakuShikyuShinsaKetteiZen");
    private static final RString TABLE_事業高額介護サービス費給付対象者合計全件一時 = new RString("TempJigyoKogakuKyufuTaishoshaGokeiZen");
    private static final RString TABLE_事業高額介護サービス費給付対象者明細全件一時 = new RString("TempJigyoKogakuKyufuTaishoshaMeisaiZen");
    private static final RString TABLE_給付実績基本情報高額一時1 = new RString("TempKyufujissekiKihon1");
    private static final RString TABLE_給付実績基本情報高額一時2 = new RString("TempKyufujissekiKihon2");
    private static final RString TABLE_給付実績基本情報事業高額一時1 = new RString("TempKyufujissekiKihonJigyo1");
    private static final RString TABLE_給付実績基本情報事業高額一時2 = new RString("TempKyufujissekiKihonJigyo2");
    private static final RString TABLE_被保険者台帳情報一時1 = new RString("TempHihokenshaDaicho1");
    private static final RString TABLE_被保険者台帳情報一時2 = new RString("TempHihokenshaDaicho2");
    private static final RString TABLE_合併内住特者新旧番号変換一時 = new RString("TempGappeiNaiJutokushaShinKyuNoHenkan");
    private static final RString TABLE_支払方法変更管理一時 = new RString("TempShiharaiHohoHenko");
    private static final RString TABLE_境界層管理一時 = new RString("TempyokaisoGaitosha");
    private static final RString TABLE_給付実績集計一時 = new RString("TempKyufujissekiShukei");
    private static final RString TABLE_給付実績社会福祉法人軽減額一時 = new RString("TempKyufuJissekiShakaiFukushiHojinKeigengaku");
    private static final RString TABLE_基準収入額適用管理一時 = new RString("TempKijunShunyugakuTekiyoKanri");
    private static final RString TABLE_高額介護サービス費支給申請一時 = new RString("TempKogakuShikyuShinsei");
    private static final RString TABLE_高額介護サービス費支給判定結果一時 = new RString("TempKogakuShikyuHanteiKekka");
    private static final RString TABLE_高額介護サービス費支給審査決定一時 = new RString("TempKogakuShikyuShinsaKettei");
    private static final RString TABLE_高額介護サービス費給付対象者合計一時 = new RString("TempKogakuKyufuTaishoshaGokei");
    private static final RString TABLE_高額介護サービス費給付対象者明細一時 = new RString("TempKogakuKyufuTaishoshaMeisai");
    private static final RString TABLE_事業高額介護サービス費支給申請一時 = new RString("TempJigyoKogakuShikyuShinsei");
    private static final RString TABLE_事業高額介護サービス費支給判定結果一時 = new RString("TempJigyoKogakuShikyuHanteiKekka");
    private static final RString TABLE_事業高額介護サービス費支給審査決定一時 = new RString("JigyoTempKogakuShikyuShinsaKettei");
    private static final RString TABLE_事業高額介護サービス費給付対象者合計一時 = new RString("TempJigyoKogakuKyufuTaishoshaGokei");
    private static final RString TABLE_事業高額介護サービス費給付対象者明細一時 = new RString("TempJigyoKogakuKyufuTaishoshaMeisai");
    private static final RString TABLE_給付実績基本情報高額一時３ = new RString("TempKyufujissekiKihon3");
    private static final RString TABLE_給付実績基本情報事業高額一時3 = new RString("TempKyufujissekiKihonJigyo3");
    private static final RString TABLE_世帯員把握入力高額一時 = new RString("TempSetaiinHaakuNyuryoku");
    private static final RString TABLE_給付実績基本情報高額一時4 = new RString("TempKyufujissekiKihon4");
    private static final RString TABLE_給付実績基本情報事業高額一時4 = new RString("TempKyufujissekiKihonJigyo4");
    private static final RString TABLE_被保険者台帳情報一時3 = new RString("TempHihokenshaDaicho3");
    private static final RString TABLE_世帯員所得判定明細高額一時 = new RString("TempSetaiinShotokuHantei");
    private static final RString TABLE_世帯員所得判定明細事業高額一時 = new RString("TempSetaiinShotokuHanteiJigyo");
    private static final RString TABLE_給付実績中間高額一時 = new RString("TempKyufujissekiTyukann");
    private static final RString TABLE_給付実績中間事業高額一時 = new RString("TempKyufujissekiTyukannJigyo");
    private static final RString TABLE_高額介護サービス費支給申請一時1 = new RString("TempKogakuShikyuShinsei1");
    private static final RString TABLE_高額介護サービス費支給判定結果一時1 = new RString("TempKogakuShikyuHanteiKekka1");
    private static final RString TABLE_高額介護サービス費支給審査決定一時1 = new RString("TempKogakuShikyuShinsaKettei1");
    private static final RString TABLE_高額判定エラー一時 = new RString("TempKogakuHanteiEraa");
    private static final RString TABLE_事業高額判定エラー一時 = new RString("TempJigyoKogakuHanteiEraa");
    private static final RString TABLE_給付被保宛名情報高額一時 = new RString("TempKyufuHihokenAtena");
    private static final RString TABLE_給付被保宛名情報事業高額一時 = new RString("TempKyufuHihokenAtenaJigyo");
    private static final RString TABLE_処理結果確認リスト高額一時 = new RString("TempShorikekkaKakuninRisuto");
    private static final RString TABLE_処理結果確認リスト事業高額一時 = new RString("TempShorikekkaKakuninRisutoJigyo");
    private static final RString TABLE_世帯員所得判定明細高額一時1 = new RString("TempSetaiinShotokuHantei1");
    private static final RString TABLE_世帯員所得判定明細事業高額一時1 = new RString("TempSetaiinShotokuHanteiJigyo1");
    private static final RString TABLE_高額申請者条件高額一時 = new RString("TempKogakuShinseishaJoken");
    private static final RString TABLE_国保連IF高額一時 = new RString("TempKokuhorenIf");
    private static final RString TABLE_申請者条件事業高額一時 = new RString("TempShinseishaJokenJigyo");
    private static final RString TABLE_国保連IF事業高額一時 = new RString("TempKokuhorenIfJigyo");
    private static final RString TABLE_高額介護サービス費給付対象者明細全件更新一時 = new RString("TempKogakuKyufuTaishoshaMeisaiZenUpdate");
    private static final RString TABLE_高額介護サービス費給付対象者明細更新一時 = new RString("TempKogakuKyufuTaishoshaMeisaiUpdate");
    private static final RString TABLE_事業高額介護サービス費給付対象者明細更新一時 = new RString("TempJigyoKogakuKyufuTaishoshaMeisaiUpdate");
    private static final RString TABLE_事業高額介護サービス費給付対象者明細全件更新一時 = new RString("TempJigyoKogakuKyufuTaishoshaMeisaiZenUpdate");

    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShikyuShinseiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShikyuHanteiKekkaZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShikyuShinsaKetteiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuKyufuTaishoshaGokeiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuKyufuTaishoshaMeisaiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuShikyuShinseiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuShikyuHanteiKekkaZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuShikyuShinsaKetteiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuKyufuTaishoshaGokeiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuKyufuTaishoshaMeisaiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiKihon1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiKihon2Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiKihonJigyo1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiKihonJigyo2Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter HihokenshaDaicho1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter HihokenshaDaicho2Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter GappeiNaiJutokushaShinKyuNoHenkanWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter ShiharaiHohoHenkoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter yokaisoGaitoshaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiShukeiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufuJissekiShakaiFukushiHojinKeigengakuWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KijunShunyugakuTekiyoKanriWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShikyuShinseiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShikyuHanteiKekkaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShikyuShinsaKetteiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuKyufuTaishoshaGokeiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuKyufuTaishoshaMeisaiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuShikyuShinseiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuShikyuHanteiKekkaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoTempKogakuShikyuShinsaKetteiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuKyufuTaishoshaGokeiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuKyufuTaishoshaMeisaiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiKihon3Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiKihonJigyo3Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter SetaiinHaakuNyuryokuWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiKihon4Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiKihonJigyo4Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter HihokenshaDaicho3Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter SetaiinShotokuHanteiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter SetaiinShotokuHanteiJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiTyukannWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufujissekiTyukannJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShikyuShinsei1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShikyuHanteiKekka1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShikyuShinsaKettei1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuHanteiEraaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuHanteiEraaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufuHihokenAtenaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KyufuHihokenAtenaJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter ShorikekkaKakuninRisutoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter ShorikekkaKakuninRisutoJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter SetaiinShotokuHantei1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter SetaiinShotokuHanteiJigyo1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuShinseishaJokenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KokuhorenIfWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter ShinseishaJokenJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KokuhorenIfJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuKyufuTaishoshaMeisaiZenUpdateWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter KogakuKyufuTaishoshaMeisaiUpdateWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuKyufuTaishoshaMeisaiUpdateWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter JigyoKogakuKyufuTaishoshaMeisaiZenUpdateWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
//        manager = TokuchoTaishoshaDoteiIkatsu.createInstance();
    }

    @Override
    protected void createWriter() {
        createTempTable();
    }

    @Override
    protected void process(KyufujissekiKihonEntity emtity) {

    }

    @Override
    protected void afterExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    private void createTempTable() {
        KogakuShikyuShinseiZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費支給申請全件一時, DbT3056KogakuShikyuShinseiEntity.class);
        KogakuShikyuHanteiKekkaZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費支給判定結果全件一時, DbT3057KogakuShikyuHanteiKekkaEntity.class);
        KogakuShikyuShinsaKetteiZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費支給審査決定全件一時, DbT3058KogakuShikyuShinsaKetteiEntity.class);
        KogakuKyufuTaishoshaGokeiZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費給付対象者合計全件一時, DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
        KogakuKyufuTaishoshaMeisaiZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費給付対象者明細全件一時, DbT3054KogakuKyufuTaishoshaMeisaiEntity.class);
        JigyoKogakuShikyuShinseiZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費支給申請全件一時, DbT3110JigyoKogakuShikyuShinseiEntity.class);
        JigyoKogakuShikyuHanteiKekkaZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費支給判定結果全件一時, DbT3111JigyoKogakuShikyuHanteiKekkaEntity.class);
        JigyoKogakuShikyuShinsaKetteiZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費支給審査決定全件一時, DbT3112KogakuShikyuShinsaKetteiEntity.class);
        JigyoKogakuKyufuTaishoshaGokeiZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費給付対象者合計全件一時, DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity.class);
        JigyoKogakuKyufuTaishoshaMeisaiZenWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費給付対象者明細全件一時, DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity.class);
        KyufujissekiKihon1Writer = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本情報高額一時1, DbT3017KyufujissekiKihonEntity.class);
        KyufujissekiKihon2Writer = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本情報高額一時2, DbT3017KyufujissekiKihonEntity.class);
        KyufujissekiKihonJigyo1Writer = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本情報事業高額一時1, DbT3017KyufujissekiKihonEntity.class);
        KyufujissekiKihonJigyo2Writer = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本情報事業高額一時2, DbT3017KyufujissekiKihonEntity.class);
        HihokenshaDaicho1Writer = new BatchEntityCreatedTempTableWriter(TABLE_被保険者台帳情報一時1, DbT1001HihokenshaDaichoEntity.class);
        HihokenshaDaicho2Writer = new BatchEntityCreatedTempTableWriter(TABLE_被保険者台帳情報一時2, DbT1001HihokenshaDaichoEntity.class);
        GappeiNaiJutokushaShinKyuNoHenkanWriter = new BatchEntityCreatedTempTableWriter(TABLE_合併内住特者新旧番号変換一時, DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class);
        ShiharaiHohoHenkoWriter = new BatchEntityCreatedTempTableWriter(TABLE_支払方法変更管理一時, DbT4021ShiharaiHohoHenkoEntity.class);
        yokaisoGaitoshaWriter = new BatchEntityCreatedTempTableWriter(TABLE_境界層管理一時, DbT1006KyokaisoGaitoshaEntity.class);
        KyufujissekiShukeiWriter = new BatchEntityCreatedTempTableWriter(TABLE_給付実績集計一時, DbT3033KyufujissekiShukeiEntity.class);
        KyufuJissekiShakaiFukushiHojinKeigengakuWriter = new BatchEntityCreatedTempTableWriter(TABLE_給付実績社会福祉法人軽減額一時, DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity.class);
        KijunShunyugakuTekiyoKanriWriter = new BatchEntityCreatedTempTableWriter(TABLE_基準収入額適用管理一時, DbT3116KijunShunyugakuTekiyoKanriEntity.class);
        KogakuShikyuShinseiWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費支給申請一時, DbT3056KogakuShikyuShinseiEntity.class);
        KogakuShikyuHanteiKekkaWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費支給判定結果一時, DbT3057KogakuShikyuHanteiKekkaEntity.class);
        KogakuShikyuShinsaKetteiWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費支給審査決定一時, DbT3058KogakuShikyuShinsaKetteiEntity.class);
        KogakuKyufuTaishoshaGokeiWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費給付対象者合計一時, DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
        KogakuKyufuTaishoshaMeisaiWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費給付対象者明細一時, DbT3054KogakuKyufuTaishoshaMeisaiEntity.class);
        JigyoKogakuShikyuShinseiWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費支給申請一時, DbT3110JigyoKogakuShikyuShinseiEntity.class);
        JigyoKogakuShikyuHanteiKekkaWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費支給判定結果一時, DbT3111JigyoKogakuShikyuHanteiKekkaEntity.class);
        JigyoTempKogakuShikyuShinsaKetteiWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費支給審査決定一時, DbT3112KogakuShikyuShinsaKetteiEntity.class);
        JigyoKogakuKyufuTaishoshaGokeiWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費給付対象者合計一時, DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity.class);
        JigyoKogakuKyufuTaishoshaMeisaiWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費給付対象者明細一時, DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity.class);
        KyufujissekiKihon3Writer = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本情報高額一時３, DbT3017KyufujissekiKihonEntity.class);
        KyufujissekiKihonJigyo3Writer = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本情報事業高額一時3, DbT3017KyufujissekiKihonEntity.class);
        SetaiinHaakuNyuryokuWriter = new BatchEntityCreatedTempTableWriter(TABLE_世帯員把握入力高額一時, TempSetaiinHaakuNyuryokuEntity.class);
        KyufujissekiKihon4Writer = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本情報高額一時4, DbT3017KyufujissekiKihonEntity.class);
        KyufujissekiKihonJigyo4Writer = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本情報事業高額一時4, DbT3017KyufujissekiKihonEntity.class);
        HihokenshaDaicho3Writer = new BatchEntityCreatedTempTableWriter(TABLE_被保険者台帳情報一時3, DbT1001HihokenshaDaichoEntity.class);
        SetaiinShotokuHanteiWriter = new BatchEntityCreatedTempTableWriter(TABLE_世帯員所得判定明細高額一時, TempSetaiinShotokuHanteiEntity.class);
        SetaiinShotokuHanteiJigyoWriter = new BatchEntityCreatedTempTableWriter(TABLE_世帯員所得判定明細事業高額一時, TempSetaiinShotokuHanteiEntity.class);
        KyufujissekiTyukannWriter = new BatchEntityCreatedTempTableWriter(TABLE_給付実績中間高額一時, TempKyufujissekiTyukannEntity.class);
        KyufujissekiTyukannJigyoWriter = new BatchEntityCreatedTempTableWriter(TABLE_給付実績中間事業高額一時, TempKyufujissekiTyukannEntity.class);
        KogakuShikyuShinsei1Writer = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費支給申請一時1, DbT3056KogakuShikyuShinseiEntity.class);
        KogakuShikyuHanteiKekka1Writer = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費支給判定結果一時1, DbT3057KogakuShikyuHanteiKekkaEntity.class);
        KogakuShikyuShinsaKettei1Writer = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費支給審査決定一時1, DbT3058KogakuShikyuShinsaKetteiEntity.class);
        KogakuHanteiEraaWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額判定エラー一時, TempKogakuHanteiEraaEntity.class);
        JigyoKogakuHanteiEraaWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額判定エラー一時, TempKogakuHanteiEraaEntity.class);
        KyufuHihokenAtenaWriter = new BatchEntityCreatedTempTableWriter(TABLE_給付被保宛名情報高額一時, TempKyufuHihokenAtenaEntity.class);
        KyufuHihokenAtenaJigyoWriter = new BatchEntityCreatedTempTableWriter(TABLE_給付被保宛名情報事業高額一時, TempKyufuHihokenAtenaEntity.class);
        ShorikekkaKakuninRisutoWriter = new BatchEntityCreatedTempTableWriter(TABLE_処理結果確認リスト高額一時, DbT3056KogakuShikyuShinseiEntity.class);
        ShorikekkaKakuninRisutoJigyoWriter = new BatchEntityCreatedTempTableWriter(TABLE_処理結果確認リスト事業高額一時, DbT3056KogakuShikyuShinseiEntity.class);
        SetaiinShotokuHantei1Writer = new BatchEntityCreatedTempTableWriter(TABLE_世帯員所得判定明細高額一時1, TempSetaiinShotokuHanteiEntity.class);
        SetaiinShotokuHanteiJigyo1Writer = new BatchEntityCreatedTempTableWriter(TABLE_世帯員所得判定明細事業高額一時1, TempSetaiinShotokuHanteiEntity.class);
        KogakuShinseishaJokenWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額申請者条件高額一時, TempKogakuShinseishaJokenEntity.class);
        KokuhorenIfWriter = new BatchEntityCreatedTempTableWriter(TABLE_国保連IF高額一時, TempKokuhorenIfEntity.class);
        ShinseishaJokenJigyoWriter = new BatchEntityCreatedTempTableWriter(TABLE_申請者条件事業高額一時, TempKogakuShinseishaJokenEntity.class);
        KokuhorenIfJigyoWriter = new BatchEntityCreatedTempTableWriter(TABLE_国保連IF事業高額一時, TempKokuhorenIfEntity.class);
        KogakuKyufuTaishoshaMeisaiZenUpdateWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費給付対象者明細全件更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
        KogakuKyufuTaishoshaMeisaiUpdateWriter = new BatchEntityCreatedTempTableWriter(TABLE_高額介護サービス費給付対象者明細更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
        JigyoKogakuKyufuTaishoshaMeisaiUpdateWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費給付対象者明細更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
        JigyoKogakuKyufuTaishoshaMeisaiZenUpdateWriter = new BatchEntityCreatedTempTableWriter(TABLE_事業高額介護サービス費給付対象者明細全件更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
    }

}
