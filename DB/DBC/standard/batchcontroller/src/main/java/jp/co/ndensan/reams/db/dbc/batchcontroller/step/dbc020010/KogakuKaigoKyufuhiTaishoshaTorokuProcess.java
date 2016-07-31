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
    private static final RString TABLE_世帯員把握入力事業高額一時 = new RString("TempSetaiinHaakuNyuryokuJigyo");
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
    BatchEntityCreatedTempTableWriter kogakuShikyuShinseiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuShikyuHanteiKekkaZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuShikyuShinsaKetteiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuKyufuTaishoshaGokeiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuKyufuTaishoshaMeisaiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuShikyuShinseiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuShikyuHanteiKekkaZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuShikyuShinsaKetteiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuKyufuTaishoshaGokeiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuKyufuTaishoshaMeisaiZenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiKihon1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiKihon2Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiKihonJigyo1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiKihonJigyo2Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter hihokenshaDaicho1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter hihokenshaDaicho2Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter gappeiNaiJutokushaShinKyuNoHenkanWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter shiharaiHohoHenkoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter yokaisoGaitoshaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiShukeiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiShakaiFukushiHojinKeigengakuWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kijunShunyugakuTekiyoKanriWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuShikyuShinseiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuShikyuHanteiKekkaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuShikyuShinsaKetteiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuKyufuTaishoshaGokeiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuKyufuTaishoshaMeisaiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuShikyuShinseiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuShikyuHanteiKekkaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyoTempkogakuShikyuShinsaKetteiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuKyufuTaishoshaGokeiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuKyufuTaishoshaMeisaiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiKihon3Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiKihonJigyo3Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter setaiinHaakuNyuryokuWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter setaiinHaakuNyuryokuJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiKihon4Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiKihonJigyo4Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter hihokenshaDaicho3Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter setaiinShotokuHanteiWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter setaiinShotokuHanteiJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiTyukannWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufujissekiTyukannJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuShikyuShinsei1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuShikyuHanteiKekka1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuShikyuShinsaKettei1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuHanteiEraaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuHanteiEraaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufuHihokenAtenaWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufuHihokenAtenaJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter shorikekkaKakuninRisutoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter shorikekkaKakuninRisutoJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter setaiinShotokuHantei1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter setaiinShotokuHanteiJigyo1Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuShinseishaJokenWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kokuhorenIfWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter shinseishaJokenJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kokuhorenIfJigyoWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuKyufuTaishoshaMeisaiZenUpdateWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter kogakuKyufuTaishoshaMeisaiUpdateWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuKyufuTaishoshaMeisaiUpdateWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyokogakuKyufuTaishoshaMeisaiZenUpdateWriter;

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
        kogakuShikyuShinseiZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給申請全件一時, DbT3056KogakuShikyuShinseiEntity.class);
        kogakuShikyuHanteiKekkaZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給判定結果全件一時, DbT3057KogakuShikyuHanteiKekkaEntity.class);
        kogakuShikyuShinsaKetteiZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給審査決定全件一時, DbT3058KogakuShikyuShinsaKetteiEntity.class);
        kogakuKyufuTaishoshaGokeiZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者合計全件一時, DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
        kogakuKyufuTaishoshaMeisaiZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者明細全件一時, DbT3054KogakuKyufuTaishoshaMeisaiEntity.class);
        jigyokogakuShikyuShinseiZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費支給申請全件一時, DbT3110JigyoKogakuShikyuShinseiEntity.class);
        jigyokogakuShikyuHanteiKekkaZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費支給判定結果全件一時, DbT3111JigyoKogakuShikyuHanteiKekkaEntity.class);
        jigyokogakuShikyuShinsaKetteiZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費支給審査決定全件一時, DbT3112KogakuShikyuShinsaKetteiEntity.class);
        jigyokogakuKyufuTaishoshaGokeiZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費給付対象者合計全件一時, DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity.class);
        jigyokogakuKyufuTaishoshaMeisaiZenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費給付対象者明細全件一時, DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity.class);
        kyufujissekiKihon1Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報高額一時1, DbT3017KyufujissekiKihonEntity.class);
        kyufujissekiKihon2Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報高額一時2, DbT3017KyufujissekiKihonEntity.class);
        kyufujissekiKihonJigyo1Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報事業高額一時1, DbT3017KyufujissekiKihonEntity.class);
        kyufujissekiKihonJigyo2Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報事業高額一時2, DbT3017KyufujissekiKihonEntity.class);
        hihokenshaDaicho1Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_被保険者台帳情報一時1, DbT1001HihokenshaDaichoEntity.class);
        hihokenshaDaicho2Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_被保険者台帳情報一時2, DbT1001HihokenshaDaichoEntity.class);
        gappeiNaiJutokushaShinKyuNoHenkanWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_合併内住特者新旧番号変換一時, DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity.class);
        shiharaiHohoHenkoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_支払方法変更管理一時, DbT4021ShiharaiHohoHenkoEntity.class);
        yokaisoGaitoshaWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_境界層管理一時, DbT1006KyokaisoGaitoshaEntity.class);
        kyufujissekiShukeiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績集計一時, DbT3033KyufujissekiShukeiEntity.class);
        kyufujissekiShakaiFukushiHojinKeigengakuWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績社会福祉法人軽減額一時, DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity.class);
        kijunShunyugakuTekiyoKanriWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_基準収入額適用管理一時, DbT3116KijunShunyugakuTekiyoKanriEntity.class);
        kogakuShikyuShinseiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給申請一時, DbT3056KogakuShikyuShinseiEntity.class);
        kogakuShikyuHanteiKekkaWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給判定結果一時, DbT3057KogakuShikyuHanteiKekkaEntity.class);
        kogakuShikyuShinsaKetteiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給審査決定一時, DbT3058KogakuShikyuShinsaKetteiEntity.class);
        kogakuKyufuTaishoshaGokeiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者合計一時, DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
        kogakuKyufuTaishoshaMeisaiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者明細一時, DbT3054KogakuKyufuTaishoshaMeisaiEntity.class);
        jigyokogakuShikyuShinseiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費支給申請一時, DbT3110JigyoKogakuShikyuShinseiEntity.class);
        jigyokogakuShikyuHanteiKekkaWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費支給判定結果一時, DbT3111JigyoKogakuShikyuHanteiKekkaEntity.class);
        jigyoTempkogakuShikyuShinsaKetteiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費支給審査決定一時, DbT3112KogakuShikyuShinsaKetteiEntity.class);
        jigyokogakuKyufuTaishoshaGokeiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費給付対象者合計一時, DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity.class);
        jigyokogakuKyufuTaishoshaMeisaiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費給付対象者明細一時, DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity.class);
        kyufujissekiKihon3Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報高額一時３, DbT3017KyufujissekiKihonEntity.class);
        kyufujissekiKihonJigyo3Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報事業高額一時3, DbT3017KyufujissekiKihonEntity.class);
        setaiinHaakuNyuryokuWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員把握入力高額一時, TempSetaiinHaakuNyuryokuEntity.class);
        setaiinHaakuNyuryokuJigyoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員把握入力事業高額一時, TempSetaiinHaakuNyuryokuEntity.class);
        kyufujissekiKihon4Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報高額一時4, DbT3017KyufujissekiKihonEntity.class);
        kyufujissekiKihonJigyo4Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報事業高額一時4, DbT3017KyufujissekiKihonEntity.class);
        hihokenshaDaicho3Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_被保険者台帳情報一時3, DbT1001HihokenshaDaichoEntity.class);
        setaiinShotokuHanteiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員所得判定明細高額一時, TempSetaiinShotokuHanteiEntity.class);
        setaiinShotokuHanteiJigyoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員所得判定明細事業高額一時, TempSetaiinShotokuHanteiEntity.class);
        kyufujissekiTyukannWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間高額一時, TempKyufujissekiTyukannEntity.class);
        kyufujissekiTyukannJigyoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間事業高額一時, TempKyufujissekiTyukannEntity.class);
        kogakuShikyuShinsei1Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給申請一時1, DbT3056KogakuShikyuShinseiEntity.class);
        kogakuShikyuHanteiKekka1Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給判定結果一時1, DbT3057KogakuShikyuHanteiKekkaEntity.class);
        kogakuShikyuShinsaKettei1Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給審査決定一時1, DbT3058KogakuShikyuShinsaKetteiEntity.class);
        kogakuHanteiEraaWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額判定エラー一時, TempKogakuHanteiEraaEntity.class);
        jigyokogakuHanteiEraaWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額判定エラー一時, TempKogakuHanteiEraaEntity.class);
        kyufuHihokenAtenaWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_給付被保宛名情報高額一時, TempKyufuHihokenAtenaEntity.class);
        kyufuHihokenAtenaJigyoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_給付被保宛名情報事業高額一時, TempKyufuHihokenAtenaEntity.class);
        shorikekkaKakuninRisutoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_処理結果確認リスト高額一時, DbT3056KogakuShikyuShinseiEntity.class);
        shorikekkaKakuninRisutoJigyoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_処理結果確認リスト事業高額一時, DbT3056KogakuShikyuShinseiEntity.class);
        setaiinShotokuHantei1Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員所得判定明細高額一時1, TempSetaiinShotokuHanteiEntity.class);
        setaiinShotokuHanteiJigyo1Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員所得判定明細事業高額一時1, TempSetaiinShotokuHanteiEntity.class);
        kogakuShinseishaJokenWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額申請者条件高額一時, TempKogakuShinseishaJokenEntity.class);
        kokuhorenIfWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_国保連IF高額一時, TempKokuhorenIfEntity.class);
        shinseishaJokenJigyoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_申請者条件事業高額一時, TempKogakuShinseishaJokenEntity.class);
        kokuhorenIfJigyoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_国保連IF事業高額一時, TempKokuhorenIfEntity.class);
        kogakuKyufuTaishoshaMeisaiZenUpdateWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者明細全件更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
        kogakuKyufuTaishoshaMeisaiUpdateWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者明細更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
        jigyokogakuKyufuTaishoshaMeisaiUpdateWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費給付対象者明細更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
        jigyokogakuKyufuTaishoshaMeisaiZenUpdateWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費給付対象者明細全件更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
    }

}
