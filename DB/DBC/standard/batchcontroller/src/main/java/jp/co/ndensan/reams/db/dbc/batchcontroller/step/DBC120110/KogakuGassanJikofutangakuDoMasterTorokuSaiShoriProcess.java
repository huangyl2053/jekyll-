/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.KogakuGassanJikoFutanGakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 37J_高額合算自己負担額確認情報取込のマスタ登録(再処理準備)。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
public class KogakuGassanJikofutangakuDoMasterTorokuSaiShoriProcess
        extends BatchProcessBase<KogakuGassanJikoFutanGakuCsvEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc120110.IKogakuGassanJikofutangakuMapper.select再処理準備高額合算自己負担額と明細データ");
    private final RString zero = new RString("0");

    private KogakuGassanJikofutangakuDoMasterTorokuProcessParameter parameter;
    private KogakuGassanJikofutangakuDoMasterTorokuParameter dbParameter;
    @BatchWriter
    BatchPermanentTableWriter 高額合算自己負担額TBLWriter;
    @BatchWriter
    BatchPermanentTableWriter 高額合算自己負担額明細TBLWriter;

    @Override
    protected void initialize() {
        dbParameter = new KogakuGassanJikofutangakuDoMasterTorokuParameter();
        if (parameter.get処理区分() != null) {
            dbParameter.set処理区分(parameter.get処理区分().trim());
        }
        dbParameter.set処理年月(parameter.get処理年月());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, dbParameter);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額TBLWriter = new BatchPermanentTableWriter(DbT3070KogakuGassanJikoFutanGakuEntity.class);
        高額合算自己負担額明細TBLWriter = new BatchPermanentTableWriter(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity.class);
    }

    @Override
    protected void process(KogakuGassanJikoFutanGakuCsvEntity entity) {
        if ((null == entity.getリアル補正実施年月日() || entity.getリアル補正実施年月日().isEmpty())
                && (null == entity.getバッチ補正実施年月日() || entity.getバッチ補正実施年月日().isEmpty())) {
            this.do明細データ削除(entity);
            this.doデータ削除(entity);
        } else {
            this.do明細データ更新(entity);
            this.doデータ更新(entity);
        }

    }

    private void do明細データ削除(KogakuGassanJikoFutanGakuCsvEntity 明細entity) {
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity deleteEntity = new DbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
        deleteEntity.setHihokenshaNo(明細entity.get被保険者番号());
        deleteEntity.setTaishoNendo(明細entity.get対象年度());
        deleteEntity.setHokenshaNo(明細entity.get保険者番号());
        deleteEntity.setShikyuShinseishoSeiriNo(明細entity.get支給申請書整理番号());
        deleteEntity.setRirekiNo(明細entity.get履歴番号());
        deleteEntity.setTaishoM(明細entity.get対象月());
        deleteEntity.setJikoFutanGaku(明細entity.get自己負担額());
        deleteEntity.setUchisu_70_74JikoFutanGaku(明細entity.get自己負担額_内数70_74());
        deleteEntity.setUnder_70KogakuShikyuGaku(明細entity.get未満70高額支給額());
        deleteEntity.setOver_70_74KogakuShikyuGaku(明細entity.get高額支給額70_74());
        deleteEntity.setTekiyo(明細entity.get摘要());
        deleteEntity.setSumi_JikoFutanGaku(明細entity.get補正済_自己負担額());
        deleteEntity.setSumi_70_74JikoFutanGaku(明細entity.get補正済_70_74自己負担額_内数_());
        deleteEntity.setSumi_under_70KogakuShikyuGaku(明細entity.get補正済_70未満高額支給額());
        deleteEntity.setSumi_70_74KogakuShikyuGaku(明細entity.get補正済_70_74高額支給額());
        deleteEntity.setSumi_Tekiyo(明細entity.get補正済_摘要());
        高額合算自己負担額明細TBLWriter.delete(deleteEntity);
    }

    private void doデータ削除(KogakuGassanJikoFutanGakuCsvEntity entity) {
        DbT3070KogakuGassanJikoFutanGakuEntity deleteEntity = new DbT3070KogakuGassanJikoFutanGakuEntity();
        deleteEntity.setHihokenshaNo(entity.get被保険者番号());
        deleteEntity.setTaishoNendo(entity.get対象年度());
        deleteEntity.setHokenshaNo(entity.get保険者番号());
        deleteEntity.setShikyuShinseishoSeiriNo(entity.get支給申請書整理番号());
        deleteEntity.setRirekiNo(entity.get履歴番号());
        deleteEntity.setHokenSeidoCode(entity.get保険制度コード());
        deleteEntity.setHokenshaMei(entity.get保険者名());
        deleteEntity.setKokuho_HihokenshaShoKigo(entity.get国保被保険者証記号());
        deleteEntity.setHihokenshaShimeiKana(entity.get被保険者氏名カナ());
        deleteEntity.setHihokenshaShimei(entity.get被保険者氏名());
        deleteEntity.setUmareYMD(entity.get生年月日());
        deleteEntity.setSeibetsuCode(entity.get性別());
        deleteEntity.setShotokuKubun(entity.get所得区分());
        deleteEntity.setOver70_ShotokuKubun(entity.get超過70歳者に係る所得区分());
        deleteEntity.setJikoFutanSeiriNo(entity.get自己負担額証明書整理番号());
        deleteEntity.setKoki_HokenshaNo(entity.get後期保険者番号());
        deleteEntity.setKoki_HihokenshaNo(entity.get後期被保険者番号());
        deleteEntity.setKokuho_HokenshaNo(entity.get国保保険者番号());
        deleteEntity.setKokuho_HihokenshaShoNo(entity.get国保被保険者証番号());
        deleteEntity.setKokuho_KojinNo(entity.get国保個人番号());
        deleteEntity.setIdoKubun(entity.get異動区分());
        deleteEntity.setHoseiZumiSofuKubun(entity.get補正済自己負担額送付区分());
        deleteEntity.setTaishoKeisanKaishiYMD(entity.get対象計算期間開始年月日());
        deleteEntity.setTaishoKeisanShuryoYMD(entity.get対象計算期間終了年月日());
        deleteEntity.setHihokenshaKaishiYMD(entity.get被保険者期間開始年月日());
        deleteEntity.setHihokenshaShuryoYMD(entity.get被保険者期間終了年月日());
        deleteEntity.setShinseiYMD(entity.get申請年月日());
        deleteEntity.setGokei_JikoFutanGaku(entity.get合計_自己負担額());
        deleteEntity.setGokei_70_74JikoFutanGaku(entity.get合計_70_74自己負担額_内訳());
        deleteEntity.setGokei_Under70KogakuShikyuGaku(entity.get合計_70未満高額支給額());
        deleteEntity.setGokei_70_74KogakuShikyuGaku(entity.get合計_70_74高額支給額());
        deleteEntity.setSumi_Gokei_JikoFutanGaku(entity.get補正済_合計_自己負担額());
        deleteEntity.setSumi_Gokei_70_74JikoFutanGaku(entity.get補正済_合計_70_74自己負担額_内訳());
        deleteEntity.setSumi_Gokei_Under70KogakuShikyuGaku(entity.get補正済_合計_70未満高額支給額());
        deleteEntity.setSumi_Gokei_70_74KogakuShikyuGaku(entity.get補正済_合計_70_74高額支給額());
        deleteEntity.setAtesakiShimei(entity.get宛先氏名());
        deleteEntity.setAtesakiYubinNo(entity.get宛先郵便番号());
        deleteEntity.setAtesakiJusho(entity.get宛先住所());
        deleteEntity.setMadoguchi_TaishoshaHanteiCode(entity.get窓口払対象者判定コード());
        deleteEntity.setShiharaiBasho(entity.get支払場所());
        deleteEntity.setShikaraiKaishiYMD(entity.get支払期間開始年月日());
        deleteEntity.setShiharaiShuryoYMD(entity.get支払期間終了年月日());
        deleteEntity.setHeichoNaiyo(entity.get閉庁内容());
        deleteEntity.setShiharaiKaishiTime(entity.get支払期間開始時間());
        deleteEntity.setShiharaiShuryoTime(entity.get支払期間終了時間());
        deleteEntity.setBiko(entity.get備考());
        deleteEntity.setDataSakuseiKubun(entity.getデータ作成区分());
        deleteEntity.setKakunin_UketoriYM(entity.get自己負担額確認情報受取年月());
        deleteEntity.setHoseiZumi_SofuYM(entity.get補正済自己負担額情報送付年月());
        deleteEntity.setShomeisho_UketoriYM(entity.get自己負担額証明書情報受取年月());
        deleteEntity.setSaisoFlag(entity.get再送フラグ());
        deleteEntity.setSofuTaishoGaiFlag(entity.get送付対象外フラグ());
        deleteEntity.setJikoFutanKeisanYMD(entity.get自己負担額計算年月日());
        deleteEntity.setShomeiShoSakuseiYMD(entity.get自己負担額証明書作成年月日());
        deleteEntity.setKoki_KokuhoShoriKubun(entity.get後期_国保処理区分());
        deleteEntity.setJikoFutangakuShomeishoRealHakkoFlag(entity.get自己負担額証明書リアル発行フラグ());
        deleteEntity.setBatchHoseiJissiYMD(entity.getバッチ補正実施年月日());
        deleteEntity.setRealHoseiJissiYMD(entity.getリアル補正実施年月日());
        this.高額合算自己負担額TBLWriter.delete(deleteEntity);
    }

    private void do明細データ更新(KogakuGassanJikoFutanGakuCsvEntity 明細entity) {
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity updateEntity = new DbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
        updateEntity.setHihokenshaNo(明細entity.get被保険者番号());
        updateEntity.setTaishoNendo(明細entity.get対象年度());
        updateEntity.setHokenshaNo(明細entity.get保険者番号());
        updateEntity.setShikyuShinseishoSeiriNo(明細entity.get支給申請書整理番号());
        updateEntity.setRirekiNo(明細entity.get履歴番号());
        updateEntity.setTaishoM(明細entity.get対象月());
        updateEntity.setJikoFutanGaku(Decimal.ZERO);
        updateEntity.setUchisu_70_74JikoFutanGaku(Decimal.ZERO);
        updateEntity.setUnder_70KogakuShikyuGaku(Decimal.ZERO);
        updateEntity.setOver_70_74KogakuShikyuGaku(Decimal.ZERO);
        updateEntity.setTekiyo(zero);
        updateEntity.setSumi_JikoFutanGaku(明細entity.get補正済_自己負担額());
        updateEntity.setSumi_70_74JikoFutanGaku(明細entity.get補正済_70_74自己負担額_内数_());
        updateEntity.setSumi_under_70KogakuShikyuGaku(明細entity.get補正済_70未満高額支給額());
        updateEntity.setSumi_70_74KogakuShikyuGaku(明細entity.get補正済_70_74高額支給額());
        updateEntity.setSumi_Tekiyo(明細entity.get補正済_摘要());
        高額合算自己負担額明細TBLWriter.update(updateEntity);
    }

    private void doデータ更新(KogakuGassanJikoFutanGakuCsvEntity entity) {
        DbT3070KogakuGassanJikoFutanGakuEntity uodateEntity = new DbT3070KogakuGassanJikoFutanGakuEntity();
        uodateEntity.setHihokenshaNo(entity.get被保険者番号());
        uodateEntity.setTaishoNendo(entity.get対象年度());
        uodateEntity.setHokenshaNo(entity.get保険者番号());
        uodateEntity.setShikyuShinseishoSeiriNo(entity.get支給申請書整理番号());
        uodateEntity.setRirekiNo(entity.get履歴番号());
        uodateEntity.setHokenSeidoCode(entity.get保険制度コード());
        uodateEntity.setHokenshaMei(entity.get保険者名());
        uodateEntity.setKokuho_HihokenshaShoKigo(entity.get国保被保険者証記号());
        uodateEntity.setHihokenshaShimeiKana(entity.get被保険者氏名カナ());
        uodateEntity.setHihokenshaShimei(entity.get被保険者氏名());
        uodateEntity.setUmareYMD(entity.get生年月日());
        uodateEntity.setSeibetsuCode(entity.get性別());
        uodateEntity.setShotokuKubun(entity.get所得区分());
        uodateEntity.setOver70_ShotokuKubun(entity.get超過70歳者に係る所得区分());
        uodateEntity.setJikoFutanSeiriNo(entity.get自己負担額証明書整理番号());
        uodateEntity.setKoki_HokenshaNo(entity.get後期保険者番号());
        uodateEntity.setKoki_HihokenshaNo(entity.get後期被保険者番号());
        uodateEntity.setKokuho_HokenshaNo(entity.get国保保険者番号());
        uodateEntity.setKokuho_HihokenshaShoNo(entity.get国保被保険者証番号());
        uodateEntity.setKokuho_KojinNo(entity.get国保個人番号());
        uodateEntity.setIdoKubun(entity.get異動区分());
        uodateEntity.setHoseiZumiSofuKubun(entity.get補正済自己負担額送付区分());
        uodateEntity.setTaishoKeisanKaishiYMD(entity.get対象計算期間開始年月日());
        uodateEntity.setTaishoKeisanShuryoYMD(entity.get対象計算期間終了年月日());
        uodateEntity.setHihokenshaKaishiYMD(entity.get被保険者期間開始年月日());
        uodateEntity.setHihokenshaShuryoYMD(entity.get被保険者期間終了年月日());
        uodateEntity.setShinseiYMD(entity.get申請年月日());
        uodateEntity.setGokei_JikoFutanGaku(Decimal.ZERO);
        uodateEntity.setGokei_70_74JikoFutanGaku(Decimal.ZERO);
        uodateEntity.setGokei_Under70KogakuShikyuGaku(Decimal.ZERO);
        uodateEntity.setGokei_70_74KogakuShikyuGaku(Decimal.ZERO);
        uodateEntity.setSumi_Gokei_JikoFutanGaku(entity.get補正済_合計_自己負担額());
        uodateEntity.setSumi_Gokei_70_74JikoFutanGaku(entity.get補正済_合計_70_74自己負担額_内訳());
        uodateEntity.setSumi_Gokei_Under70KogakuShikyuGaku(entity.get補正済_合計_70未満高額支給額());
        uodateEntity.setSumi_Gokei_70_74KogakuShikyuGaku(entity.get補正済_合計_70_74高額支給額());
        uodateEntity.setAtesakiShimei(entity.get宛先氏名());
        uodateEntity.setAtesakiYubinNo(entity.get宛先郵便番号());
        uodateEntity.setAtesakiJusho(entity.get宛先住所());
        uodateEntity.setMadoguchi_TaishoshaHanteiCode(entity.get窓口払対象者判定コード());
        uodateEntity.setShiharaiBasho(entity.get支払場所());
        uodateEntity.setShikaraiKaishiYMD(entity.get支払期間開始年月日());
        uodateEntity.setShiharaiShuryoYMD(entity.get支払期間終了年月日());
        uodateEntity.setHeichoNaiyo(entity.get閉庁内容());
        uodateEntity.setShiharaiKaishiTime(entity.get支払期間開始時間());
        uodateEntity.setShiharaiShuryoTime(entity.get支払期間終了時間());
        uodateEntity.setBiko(entity.get備考());
        uodateEntity.setDataSakuseiKubun(entity.getデータ作成区分());
        uodateEntity.setKakunin_UketoriYM(FlexibleYearMonth.EMPTY);
        uodateEntity.setHoseiZumi_SofuYM(entity.get補正済自己負担額情報送付年月());
        uodateEntity.setShomeisho_UketoriYM(entity.get自己負担額証明書情報受取年月());
        uodateEntity.setSaisoFlag(entity.get再送フラグ());
        uodateEntity.setSofuTaishoGaiFlag(entity.get送付対象外フラグ());
        uodateEntity.setJikoFutanKeisanYMD(entity.get自己負担額計算年月日());
        uodateEntity.setShomeiShoSakuseiYMD(entity.get自己負担額証明書作成年月日());
        uodateEntity.setKoki_KokuhoShoriKubun(entity.get後期_国保処理区分());
        uodateEntity.setJikoFutangakuShomeishoRealHakkoFlag(entity.get自己負担額証明書リアル発行フラグ());
        uodateEntity.setBatchHoseiJissiYMD(entity.getバッチ補正実施年月日());
        uodateEntity.setRealHoseiJissiYMD(entity.getリアル補正実施年月日());
        this.高額合算自己負担額TBLWriter.update(uodateEntity);
    }
}
