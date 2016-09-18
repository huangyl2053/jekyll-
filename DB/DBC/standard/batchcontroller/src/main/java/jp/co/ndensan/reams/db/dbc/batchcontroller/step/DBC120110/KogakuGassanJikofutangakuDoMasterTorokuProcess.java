/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.DbT3070KogakuGassanJikoFutanGakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.DbWT37H1KogakuGassanaJikofutangakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110.KogakuGassanJikofutangakuMasterTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 37J_高額合算自己負担額確認情報取込のマスタ登録(マスタ更新)。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
public class KogakuGassanJikofutangakuDoMasterTorokuProcess
        extends BatchProcessBase<KogakuGassanJikofutangakuMasterTorokuEntity> {

    private KogakuGassanJikofutangakuDoMasterTorokuProcessParameter parameter;

    private static final RString 高額合算自己負担額一時_TABLE_NAME = new RString("DbWT37H1KogakuGassanaJikofutangaku");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc120110.IKogakuGassanJikofutangakuMapper.select高額合算自己負担額と一時データ");

    @BatchWriter
    BatchPermanentTableWriter 高額合算自己負担額TBLWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算自己負担額一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額TBLWriter = new BatchPermanentTableWriter(DbT3070KogakuGassanJikoFutanGakuEntity.class);
        高額合算自己負担額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額一時_TABLE_NAME,
                        DbWT37H1KogakuGassanaJikofutangakuTempEntity.class);
    }

    @Override
    protected void process(KogakuGassanJikofutangakuMasterTorokuEntity entity) {
        DbWT37H1KogakuGassanaJikofutangakuCsvEntity 高額合算自己負担額一時entity = entity.get高額合算自己負担額一時entity();
        DbT3070KogakuGassanJikoFutanGakuCsvEntity 高額合算自己負担額entity = entity.get高額合算自己負担額entity();
        if (高額合算自己負担額entity != null) {
            if (!SaiShoriKubun.再処理.equals(parameter.get再処理区分())) {
                this.マッチング1(高額合算自己負担額一時entity, 高額合算自己負担額entity);
            } else {
                this.マッチング2(高額合算自己負担額一時entity, 高額合算自己負担額entity);
            }
        } else {
            this.マッチング3(高額合算自己負担額一時entity);
        }
    }

    private void マッチング1(DbWT37H1KogakuGassanaJikofutangakuCsvEntity 高額合算自己負担額一時entity,
            DbT3070KogakuGassanJikoFutanGakuCsvEntity 高額合算自己負担額entity) {
        this.マスタ追加(高額合算自己負担額一時entity,
                高額合算自己負担額entity.get履歴番号() + 1);
        this.履歴番号登録(高額合算自己負担額一時entity,
                高額合算自己負担額entity.get履歴番号() + 1,
                高額合算自己負担額一時entity.get更新フラグ());
    }

    private void マッチング2(DbWT37H1KogakuGassanaJikofutangakuCsvEntity 高額合算自己負担額一時entity,
            DbT3070KogakuGassanJikoFutanGakuCsvEntity 高額合算自己負担額entity) {
        if (高額合算自己負担額entity.get自己負担額確認情報受取年月().isEmpty()) {
            this.マスタ更新(高額合算自己負担額一時entity,
                    高額合算自己負担額entity);
            this.履歴番号登録(高額合算自己負担額一時entity,
                    高額合算自己負担額entity.get履歴番号(),
                    true);
        } else {
            this.マスタ追加(高額合算自己負担額一時entity,
                    高額合算自己負担額entity.get履歴番号() + 1);
            this.履歴番号登録(高額合算自己負担額一時entity,
                    高額合算自己負担額entity.get履歴番号() + 1,
                    高額合算自己負担額一時entity.get更新フラグ());
        }
    }

    private void マッチング3(DbWT37H1KogakuGassanaJikofutangakuCsvEntity 高額合算自己負担額一時entity) {
        this.マスタ追加(高額合算自己負担額一時entity, 高額合算自己負担額一時entity.get履歴番号());
    }

    private void マスタ追加(DbWT37H1KogakuGassanaJikofutangakuCsvEntity entity, int 履歴番号) {
        DbT3070KogakuGassanJikoFutanGakuEntity insertEntity = new DbT3070KogakuGassanJikoFutanGakuEntity();
        insertEntity.setHihokenshaNo(entity.get被保険者番号());
        insertEntity.setTaishoNendo(entity.get対象年度());
        insertEntity.setHokenshaNo(new HokenshaNo(getColumnValue(entity.get保険者番号())));
        insertEntity.setShikyuShinseishoSeiriNo(entity.get支給申請書整理番号());
        insertEntity.setRirekiNo(履歴番号);
        insertEntity.setHokenSeidoCode(entity.get保険制度コード());
        insertEntity.setHokenshaMei(entity.get保険者名());
        insertEntity.setKokuho_HihokenshaShoKigo(entity.get国保被保険者証記号());
        insertEntity.setHihokenshaShimeiKana(entity.get被保険者氏名カナ());
        insertEntity.setHihokenshaShimei(entity.get被保険者氏名());
        insertEntity.setUmareYMD(entity.get生年月日());
        insertEntity.setSeibetsuCode(entity.get性別());
        insertEntity.setShotokuKubun(entity.get所得区分());
        insertEntity.setOver70_ShotokuKubun(entity.get超過70歳者に係る所得区分());
        insertEntity.setJikoFutanSeiriNo(entity.get自己負担額証明書整理番号());
        insertEntity.setKoki_HokenshaNo(entity.get後期保険者番号());
        insertEntity.setKoki_HihokenshaNo(entity.get後期被保険者番号());
        insertEntity.setKokuho_HokenshaNo(entity.get国保保険者番号());
        insertEntity.setKokuho_HihokenshaShoNo(entity.get国保被保険者証番号());
        insertEntity.setKokuho_KojinNo(entity.get国保個人番号());
        insertEntity.setIdoKubun(entity.get異動区分());
        insertEntity.setHoseiZumiSofuKubun(entity.get補正済自己負担額送付区分());
        insertEntity.setTaishoKeisanKaishiYMD(entity.get対象計算期間開始年月日());
        insertEntity.setTaishoKeisanShuryoYMD(entity.get対象計算期間終了年月日());
        insertEntity.setHihokenshaKaishiYMD(entity.get被保険者期間開始年月日());
        insertEntity.setHihokenshaShuryoYMD(entity.get被保険者期間終了年月日());
        insertEntity.setShinseiYMD(entity.get申請年月日());
        insertEntity.setGokei_JikoFutanGaku(entity.get合計_自己負担額());
        insertEntity.setGokei_70_74JikoFutanGaku(entity.get合計_70_74自己負担額_内訳());
        insertEntity.setGokei_Under70KogakuShikyuGaku(entity.get合計_70未満高額支給額());
        insertEntity.setGokei_70_74KogakuShikyuGaku(entity.get合計_70_74高額支給額());
        insertEntity.setSumi_Gokei_JikoFutanGaku(entity.get補正済_合計_自己負担額());
        insertEntity.setSumi_Gokei_70_74JikoFutanGaku(entity.get補正済_合計_70_74自己負担額_内訳());
        insertEntity.setSumi_Gokei_Under70KogakuShikyuGaku(entity.get補正済_合計_70未満高額支給額());
        insertEntity.setSumi_Gokei_70_74KogakuShikyuGaku(entity.get補正済_合計_70_74高額支給額());
        insertEntity.setAtesakiShimei(entity.get宛先氏名());
        insertEntity.setAtesakiYubinNo(entity.get宛先郵便番号());
        insertEntity.setAtesakiJusho(entity.get宛先住所());
        insertEntity.setMadoguchi_TaishoshaHanteiCode(entity.get窓口払対象者判定コード());
        insertEntity.setShiharaiBasho(entity.get支払場所());
        insertEntity.setShikaraiKaishiYMD(entity.get支払期間開始年月日());
        insertEntity.setShiharaiShuryoYMD(entity.get支払期間終了年月日());
        insertEntity.setHeichoNaiyo(entity.get閉庁内容());
        insertEntity.setShiharaiKaishiTime(entity.get支払期間開始時間());
        insertEntity.setShiharaiShuryoTime(entity.get支払期間終了時間());
        insertEntity.setBiko(entity.get備考());
        insertEntity.setDataSakuseiKubun(entity.getデータ作成区分());
        insertEntity.setKakunin_UketoriYM(parameter.get処理年月());
        insertEntity.setHoseiZumi_SofuYM(entity.get補正済自己負担額情報送付年月());
        insertEntity.setShomeisho_UketoriYM(entity.get自己負担額証明書情報受取年月());
        insertEntity.setSaisoFlag(entity.get再送フラグ());
        insertEntity.setSofuTaishoGaiFlag(entity.get送付対象外フラグ());
        insertEntity.setJikoFutanKeisanYMD(entity.get自己負担額計算年月日());
        insertEntity.setShomeiShoSakuseiYMD(entity.get自己負担額証明書作成年月日());
        insertEntity.setKoki_KokuhoShoriKubun(entity.get後期_国保処理区分());
        insertEntity.setJikoFutangakuShomeishoRealHakkoFlag(entity.get自己負担額証明書リアル発行フラグ());
        insertEntity.setBatchHoseiJissiYMD(entity.getバッチ補正実施年月日());
        insertEntity.setRealHoseiJissiYMD(entity.getリアル補正実施年月日());
        高額合算自己負担額TBLWriter.insert(insertEntity);
    }

    private void 履歴番号登録(DbWT37H1KogakuGassanaJikofutangakuCsvEntity entity, int 履歴番号, boolean 更新フラグ) {
        DbWT37H1KogakuGassanaJikofutangakuTempEntity insertEntity = new DbWT37H1KogakuGassanaJikofutangakuTempEntity();
        insertEntity.setRenban(entity.get連番());
        insertEntity.setHokenshaNoIn(entity.get被保険者番号());
        insertEntity.setTaishoNendo(entity.get対象年度());
        insertEntity.setShoKisaiHokenshaNo(entity.get保険者番号());
        insertEntity.setShikyuShinseishoSeiriNo(entity.get支給申請書整理番号());
        insertEntity.setRirekiNo(履歴番号);
        insertEntity.setHokenSeidoCode(entity.get保険制度コード());
        insertEntity.setHokenshaMei(entity.get保険者名());
        insertEntity.setKokuho_HihokenshaShoKigo(entity.get国保被保険者証記号());
        insertEntity.setHihokenshaShimeiKana(entity.get被保険者氏名カナ());
        insertEntity.setHihokenshaShimei(entity.get被保険者氏名());
        insertEntity.setUmareYMD(entity.get生年月日());
        insertEntity.setSeibetsuCode(entity.get性別());
        insertEntity.setShotokuKubun(entity.get所得区分());
        insertEntity.setOver70_ShotokuKubun(entity.get超過70歳者に係る所得区分());
        insertEntity.setJikoFutanSeiriNo(entity.get自己負担額証明書整理番号());
        insertEntity.setKoki_HokenshaNo(entity.get後期保険者番号());
        insertEntity.setKoki_HihokenshaNo(entity.get後期被保険者番号());
        insertEntity.setKokuho_HokenshaNo(entity.get国保保険者番号());
        insertEntity.setKokuho_HihokenshaShoNo(entity.get国保被保険者証番号());
        insertEntity.setKokuho_KojinNo(entity.get国保個人番号());
        insertEntity.setIdoKubun(entity.get異動区分());
        insertEntity.setHoseiZumiSofuKubun(entity.get補正済自己負担額送付区分());
        insertEntity.setTaishoKeisanKaishiYMD(entity.get対象計算期間開始年月日());
        insertEntity.setTaishoKeisanShuryoYMD(entity.get対象計算期間終了年月日());
        insertEntity.setHihokenshaKaishiYMD(entity.get被保険者期間開始年月日());
        insertEntity.setHihokenshaShuryoYMD(entity.get被保険者期間終了年月日());
        insertEntity.setShinseiYMD(entity.get申請年月日());
        insertEntity.setGokei_JikoFutanGaku(entity.get合計_自己負担額());
        insertEntity.setGokei_70_74JikoFutanGaku(entity.get合計_70_74自己負担額_内訳());
        insertEntity.setGokei_Under70KogakuShikyuGaku(entity.get合計_70未満高額支給額());
        insertEntity.setGokei_70_74KogakuShikyuGaku(entity.get合計_70_74高額支給額());
        insertEntity.setSumi_Gokei_JikoFutanGaku(entity.get補正済_合計_自己負担額());
        insertEntity.setSumi_Gokei_70_74JikoFutanGaku(entity.get補正済_合計_70_74自己負担額_内訳());
        insertEntity.setSumi_Gokei_Under70KogakuShikyuGaku(entity.get補正済_合計_70未満高額支給額());
        insertEntity.setSumi_Gokei_70_74KogakuShikyuGaku(entity.get補正済_合計_70_74高額支給額());
        insertEntity.setAtesakiShimei(entity.get宛先氏名());
        insertEntity.setAtesakiYubinNo(entity.get宛先郵便番号());
        insertEntity.setAtesakiJusho(entity.get宛先住所());
        insertEntity.setMadoguchi_TaishoshaHanteiCode(entity.get窓口払対象者判定コード());
        insertEntity.setShiharaiBasho(entity.get支払場所());
        insertEntity.setShikaraiKaishiYMD(entity.get支払期間開始年月日());
        insertEntity.setShiharaiShuryoYMD(entity.get支払期間終了年月日());
        insertEntity.setHeichoNaiyo(entity.get閉庁内容());
        insertEntity.setShiharaiKaishiTime(entity.get支払期間開始時間());
        insertEntity.setShiharaiShuryoTime(entity.get支払期間終了時間());
        insertEntity.setBiko(entity.get備考());
        insertEntity.setDataSakuseiKubun(entity.getデータ作成区分());
        insertEntity.setKakunin_UketoriYM(entity.get自己負担額確認情報受取年月());
        insertEntity.setHoseiZumi_SofuYM(entity.get補正済自己負担額情報送付年月());
        insertEntity.setShomeisho_UketoriYM(entity.get自己負担額証明書情報受取年月());
        insertEntity.setSaisoFlag(entity.get再送フラグ());
        insertEntity.setSofuTaishoGaiFlag(entity.get送付対象外フラグ());
        insertEntity.setJikoFutanKeisanYMD(entity.get自己負担額計算年月日());
        insertEntity.setShomeiShoSakuseiYMD(entity.get自己負担額証明書作成年月日());
        insertEntity.setKoki_KokuhoShoriKubun(entity.get後期_国保処理区分());
        insertEntity.setJikoFutangakuShomeishoRealHakkoFlag(entity.get自己負担額証明書リアル発行フラグ());
        insertEntity.setBatchHoseiJissiYMD(entity.getバッチ補正実施年月日());
        insertEntity.setRealHoseiJissiYMD(entity.getリアル補正実施年月日());
        insertEntity.setKoshinFlag(更新フラグ);
        insertEntity.setJikoFutangakuSaiFlag(entity.get自己負担額差異フラグ());
        高額合算自己負担額一時tableWriter.update(insertEntity);
    }

    private void マスタ更新(DbWT37H1KogakuGassanaJikofutangakuCsvEntity 高額合算自己負担額一時entity,
            DbT3070KogakuGassanJikoFutanGakuCsvEntity 高額合算自己負担額entity) {
        DbT3070KogakuGassanJikoFutanGakuEntity updateEntity = new DbT3070KogakuGassanJikoFutanGakuEntity();
        updateEntity.setHihokenshaNo(高額合算自己負担額entity.get被保険者番号());
        updateEntity.setTaishoNendo(高額合算自己負担額entity.get対象年度());
        updateEntity.setHokenshaNo(new HokenshaNo(getColumnValue(高額合算自己負担額entity.get保険者番号())));
        updateEntity.setShikyuShinseishoSeiriNo(高額合算自己負担額entity.get支給申請書整理番号());
        updateEntity.setRirekiNo(高額合算自己負担額entity.get履歴番号());
        updateEntity.setHokenSeidoCode(高額合算自己負担額entity.get保険制度コード());
        updateEntity.setHokenshaMei(高額合算自己負担額entity.get保険者名());
        updateEntity.setKokuho_HihokenshaShoKigo(高額合算自己負担額entity.get国保被保険者証記号());
        updateEntity.setHihokenshaShimeiKana(高額合算自己負担額entity.get被保険者氏名カナ());
        updateEntity.setHihokenshaShimei(高額合算自己負担額entity.get被保険者氏名());
        updateEntity.setUmareYMD(高額合算自己負担額entity.get生年月日());
        updateEntity.setSeibetsuCode(高額合算自己負担額entity.get性別());
        updateEntity.setShotokuKubun(高額合算自己負担額entity.get所得区分());
        updateEntity.setOver70_ShotokuKubun(高額合算自己負担額entity.get超過70歳者に係る所得区分());
        updateEntity.setJikoFutanSeiriNo(高額合算自己負担額entity.get自己負担額証明書整理番号());
        updateEntity.setKoki_HokenshaNo(高額合算自己負担額entity.get後期保険者番号());
        updateEntity.setKoki_HihokenshaNo(高額合算自己負担額entity.get後期被保険者番号());
        updateEntity.setKokuho_HokenshaNo(高額合算自己負担額entity.get国保保険者番号());
        updateEntity.setKokuho_HihokenshaShoNo(高額合算自己負担額entity.get国保被保険者証番号());
        updateEntity.setKokuho_KojinNo(高額合算自己負担額entity.get国保個人番号());
        updateEntity.setIdoKubun(高額合算自己負担額entity.get異動区分());
        updateEntity.setHoseiZumiSofuKubun(高額合算自己負担額entity.get補正済自己負担額送付区分());
        updateEntity.setTaishoKeisanKaishiYMD(高額合算自己負担額entity.get対象計算期間開始年月日());
        updateEntity.setTaishoKeisanShuryoYMD(高額合算自己負担額entity.get対象計算期間終了年月日());
        updateEntity.setHihokenshaKaishiYMD(高額合算自己負担額entity.get被保険者期間開始年月日());
        updateEntity.setHihokenshaShuryoYMD(高額合算自己負担額entity.get被保険者期間終了年月日());
        updateEntity.setShinseiYMD(高額合算自己負担額entity.get申請年月日());
        updateEntity.setGokei_JikoFutanGaku(高額合算自己負担額一時entity.get合計_自己負担額());
        updateEntity.setGokei_70_74JikoFutanGaku(高額合算自己負担額一時entity.get合計_70_74自己負担額_内訳());
        updateEntity.setGokei_Under70KogakuShikyuGaku(高額合算自己負担額一時entity.get合計_70未満高額支給額());
        updateEntity.setGokei_70_74KogakuShikyuGaku(高額合算自己負担額一時entity.get合計_70_74高額支給額());
        updateEntity.setSumi_Gokei_JikoFutanGaku(高額合算自己負担額entity.get補正済_合計_自己負担額());
        updateEntity.setSumi_Gokei_70_74JikoFutanGaku(高額合算自己負担額entity.get補正済_合計_70_74自己負担額_内訳());
        updateEntity.setSumi_Gokei_Under70KogakuShikyuGaku(高額合算自己負担額entity.get補正済_合計_70未満高額支給額());
        updateEntity.setSumi_Gokei_70_74KogakuShikyuGaku(高額合算自己負担額entity.get補正済_合計_70_74高額支給額());
        updateEntity.setAtesakiShimei(高額合算自己負担額entity.get宛先氏名());
        updateEntity.setAtesakiYubinNo(高額合算自己負担額entity.get宛先郵便番号());
        updateEntity.setAtesakiJusho(高額合算自己負担額entity.get宛先住所());
        updateEntity.setMadoguchi_TaishoshaHanteiCode(高額合算自己負担額entity.get窓口払対象者判定コード());
        updateEntity.setShiharaiBasho(高額合算自己負担額entity.get支払場所());
        updateEntity.setShikaraiKaishiYMD(高額合算自己負担額entity.get支払期間開始年月日());
        updateEntity.setShiharaiShuryoYMD(高額合算自己負担額entity.get支払期間終了年月日());
        updateEntity.setHeichoNaiyo(高額合算自己負担額entity.get閉庁内容());
        updateEntity.setShiharaiKaishiTime(高額合算自己負担額entity.get支払期間開始時間());
        updateEntity.setShiharaiShuryoTime(高額合算自己負担額entity.get支払期間終了時間());
        updateEntity.setBiko(高額合算自己負担額entity.get備考());
        updateEntity.setDataSakuseiKubun(高額合算自己負担額entity.getデータ作成区分());
        updateEntity.setKakunin_UketoriYM(parameter.get処理年月());
        updateEntity.setHoseiZumi_SofuYM(高額合算自己負担額entity.get補正済自己負担額情報送付年月());
        updateEntity.setShomeisho_UketoriYM(高額合算自己負担額entity.get自己負担額証明書情報受取年月());
        updateEntity.setSaisoFlag(高額合算自己負担額entity.get再送フラグ());
        updateEntity.setSofuTaishoGaiFlag(高額合算自己負担額entity.get送付対象外フラグ());
        updateEntity.setJikoFutanKeisanYMD(高額合算自己負担額entity.get自己負担額計算年月日());
        updateEntity.setShomeiShoSakuseiYMD(高額合算自己負担額entity.get自己負担額証明書作成年月日());
        updateEntity.setKoki_KokuhoShoriKubun(高額合算自己負担額entity.get後期_国保処理区分());
        updateEntity.setJikoFutangakuShomeishoRealHakkoFlag(高額合算自己負担額entity.get自己負担額証明書リアル発行フラグ());
        updateEntity.setBatchHoseiJissiYMD(高額合算自己負担額entity.getバッチ補正実施年月日());
        updateEntity.setRealHoseiJissiYMD(高額合算自己負担額entity.getリアル補正実施年月日());
        高額合算自己負担額TBLWriter.update(updateEntity);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
