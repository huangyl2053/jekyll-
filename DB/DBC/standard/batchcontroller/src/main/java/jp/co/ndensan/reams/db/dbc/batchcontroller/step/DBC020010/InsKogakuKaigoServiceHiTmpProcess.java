/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.TyukannKogakuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 高額更新処理_高額介護サービス費一時の作成
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class InsKogakuKaigoServiceHiTmpProcess extends BatchProcessBase<TyukannKogakuRelateEntity> {

    private static final RString MYBATISPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select高額判定結果全件一時");

    private static final RString TABLE_高額介護サービス費支給申請全件一時 = new RString("TempKogakuShikyuShinseiZen");
    private static final RString TABLE_高額介護サービス費支給判定結果全件一時 = new RString("TempKogakuShikyuHanteiKekkaZen");
    private static final RString TABLE_高額介護サービス費支給審査決定全件一時 = new RString("TempKogakuShikyuShinsaKetteiZen");
    private static final RString TABLE_高額介護サービス費給付対象者合計全件一時 = new RString("TempKogakuKyufuTaishoshaGokeiZen");
    private static final RString TABLE_高額介護サービス費給付対象者明細全件一時 = new RString("TempKogakuKyufuTaishoshaMeisaiZen");
    private static final RString TABLE_高額介護サービス費給付対象者明細全件更新一時 = new RString("TempKogakuKyufuTaishoshaMeisaiZenUpdate");
    private static final RString TABLE_給付実績中間高額一時9 = new RString("TempKyufujissekiTyukann9");
    private static final RString DELIMITER = new RString("～");
    private static final RString 区分コード_0 = new RString("0");
    private static final RString 区分コード_1 = new RString("1");
    private static final RString 区分コード_2 = new RString("2");
    private static final RString 区分コード_3 = new RString("3");
    private static final RString 区分コード_4 = new RString("4");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 申請全件一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 判定結果全件一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 審査決定全件一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 合計全件一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 明細全件一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間高額一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 明細全件更新一時Writer;
    private KyufuJissekiKihonKogakuProcessParameter parameter;
    private RString keyBreak;
    private RString 国保連共同処理受託区分_高額;
    private List<TyukannKogakuRelateEntity> 結果全件List;

    @Override

    protected void initialize() {
        国保連共同処理受託区分_高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        結果全件List = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATISPATH);
    }

    @Override
    protected void createWriter() {
        申請全件一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給申請全件一時, DbT3056KogakuShikyuShinseiEntity.class);
        判定結果全件一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給判定結果全件一時, DbT3057KogakuShikyuHanteiKekkaEntity.class);
        審査決定全件一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給審査決定全件一時, DbT3058KogakuShikyuShinsaKetteiEntity.class);
        合計全件一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者合計全件一時, DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
        明細全件一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者明細全件一時, DbT3054KogakuKyufuTaishoshaMeisaiEntity.class);
        中間高額一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間高額一時9, TempKyufujissekiTyukannEntity.class);
        明細全件更新一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者明細全件更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
    }

    @Override
    protected void process(TyukannKogakuRelateEntity entity) {
        RString 被保険者番号 = getColumnValue(entity.get給付実績中間高額Entity().getHiHokenshaNo());
        RString サービス提供年月 = entity.get給付実績中間高額Entity().getServiceTeikyoYM() != null
                ? entity.get給付実績中間高額Entity().getServiceTeikyoYM().toDateString() : RString.EMPTY;
        RString データ区分 = entity.get給付実績中間高額Entity().getDataKubun();
        RString サービス種類コード = getColumnValue(entity.get給付実績中間高額Entity().getServiceSyuruiCode());
        RString nowKeyBreak = 被保険者番号.concat(DELIMITER).concat(サービス提供年月).concat(DELIMITER)
                .concat(データ区分).concat(DELIMITER).concat(サービス種類コード);
        if (keyBreak == null || nowKeyBreak.equals(keyBreak)) {
            結果全件List.add(entity);
            keyBreak = nowKeyBreak;
            return;
        }
        boolean マッチFlag = false;
        boolean 受取年月Flag = false;
        boolean 作成区分Flag_1 = false;
        boolean 作成区分Flag_0 = false;
        boolean 決定年月日Flag = false;
        boolean flag = false;
        Decimal 高額支給額合計 = Decimal.ZERO;
        for (TyukannKogakuRelateEntity 結果Entity : 結果全件List) {
            マッチFlag = getマッチFlag(マッチFlag, 結果Entity);
            受取年月Flag = get受取年月Flag(受取年月Flag, 結果Entity);
            作成区分Flag_1 = get作成区分Flag_1(作成区分Flag_1, 結果Entity);
            作成区分Flag_0 = get作成区分Flag_0(作成区分Flag_0, 結果Entity);
            決定年月日Flag = get決定年月日Flag(決定年月日Flag, 結果Entity);
            flag = getFlag(flag, 結果Entity);
            高額支給額合計 = get高額支給額合計(結果Entity, 高額支給額合計, flag);
        }
        TyukannKogakuRelateEntity 結果Entity = 結果全件List.get(0);
        TempKyufujissekiTyukannEntity 給付実績中間高額Entity = 結果全件List.get(0).get給付実績中間高額Entity();
        if (!マッチFlag) {
            insert高額全件一時(給付実績中間高額Entity);
        } else if (受取年月Flag) {
            if (区分コード_3.equals(給付実績中間高額Entity.getKyufuSakuseiKubunCode())) {
                給付実績中間高額Entity.setSikyugaku(Decimal.ZERO);
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_2);
            } else {
                給付実績中間高額Entity.setSikyugaku(給付実績中間高額Entity.getSikyugaku());
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_2);
            }
            中間高額一時Writer.insert(給付実績中間高額Entity);
        } else {
            if (区分コード_3.equals(給付実績中間高額Entity.getKyufuSakuseiKubunCode())) {
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_4);
                給付実績中間高額Entity.setSikyugaku(Decimal.ZERO);
                中間高額一時Writer.insert(給付実績中間高額Entity);
            } else {
                update高額全件一時_作成区分コードが3以外(高額支給額合計, 給付実績中間高額Entity, 結果Entity, 作成区分Flag_0);
            }
        }
        結果全件List.clear();
        keyBreak = nowKeyBreak;
    }

    @Override
    protected void afterExecute() {
        boolean マッチFlag = false;
        boolean 受取年月Flag = false;
        boolean 作成区分Flag_1 = false;
        boolean 作成区分Flag_0 = false;
        boolean 決定年月日Flag = false;
        boolean flag = false;
        Decimal 高額支給額合計 = Decimal.ZERO;
        for (TyukannKogakuRelateEntity 結果Entity : 結果全件List) {
            マッチFlag = getマッチFlag(マッチFlag, 結果Entity);
            受取年月Flag = get受取年月Flag(受取年月Flag, 結果Entity);
            作成区分Flag_1 = get作成区分Flag_1(作成区分Flag_1, 結果Entity);
            作成区分Flag_0 = get作成区分Flag_0(作成区分Flag_0, 結果Entity);
            決定年月日Flag = get決定年月日Flag(決定年月日Flag, 結果Entity);
            flag = getFlag(flag, 結果Entity);
            高額支給額合計 = get高額支給額合計(結果Entity, 高額支給額合計, flag);
        }
        TyukannKogakuRelateEntity 結果Entity = 結果全件List.get(0);
        TempKyufujissekiTyukannEntity 給付実績中間高額Entity = 結果全件List.get(0).get給付実績中間高額Entity();
        if (!マッチFlag) {
            insert高額全件一時(給付実績中間高額Entity);
        } else if (受取年月Flag) {
            if (区分コード_3.equals(給付実績中間高額Entity.getKyufuSakuseiKubunCode())) {
                給付実績中間高額Entity.setSikyugaku(Decimal.ZERO);
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_2);
            } else {
                給付実績中間高額Entity.setSikyugaku(給付実績中間高額Entity.getSikyugaku());
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_2);
            }
            中間高額一時Writer.insert(給付実績中間高額Entity);
        } else {
            if (区分コード_3.equals(給付実績中間高額Entity.getKyufuSakuseiKubunCode())) {
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_4);
                給付実績中間高額Entity.setSikyugaku(Decimal.ZERO);
                中間高額一時Writer.insert(給付実績中間高額Entity);
            } else {
                update高額全件一時_作成区分コードが3以外(高額支給額合計, 給付実績中間高額Entity, 結果Entity, 作成区分Flag_0);
            }
        }
    }

    private void insert高額全件一時(TempKyufujissekiTyukannEntity 給付実績中間高額Entity) {
        if (!区分コード_3.equals(給付実績中間高額Entity.getKyufuSakuseiKubunCode())
                && Decimal.ZERO.compareTo(給付実績中間高額Entity.getSikyugaku()) == -1) {
            if (区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                給付実績中間高額Entity.setKogakuHanteiKekka(RString.EMPTY);
                中間高額一時Writer.insert(給付実績中間高額Entity);
            }
            if (区分コード_1.equals(国保連共同処理受託区分_高額)
                    && 区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                申請全件一時Writer.insert(get申請全件一時(給付実績中間高額Entity));
                判定結果全件一時Writer.insert(get判定結果全件一時(給付実績中間高額Entity));
                審査決定全件一時Writer.insert(get審査決定全件一時(給付実績中間高額Entity));
                合計全件一時Writer.insert(get合計全件一時(給付実績中間高額Entity));
            } else if (区分コード_1.equals(国保連共同処理受託区分_高額)
                    && 区分コード_2.equals(給付実績中間高額Entity.getDataKubun())) {
                明細全件更新一時Writer.insert(get明細全件更新一時(給付実績中間高額Entity));
            }
        }
    }

    private void update高額全件一時_作成区分コードが3以外(Decimal 高額支給額合計,
            TempKyufujissekiTyukannEntity 給付実績中間高額Entity, TyukannKogakuRelateEntity 結果Entity, boolean 作成区分Flag_0) {
        if (高額支給額合計.compareTo(給付実績中間高額Entity.getSikyugaku()) == 0
                || 高額支給額合計.compareTo(給付実績中間高額Entity.getSikyugaku()) == 1) {
            if (Decimal.ZERO.equals(給付実績中間高額Entity.getSikyugaku())) {
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_4);
                給付実績中間高額Entity.setSikyugaku(Decimal.ZERO);
                中間高額一時Writer.insert(給付実績中間高額Entity);
            } else if (Decimal.ZERO.compareTo(給付実績中間高額Entity.getSikyugaku()) == -1) {
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_3);
                給付実績中間高額Entity.setSikyugaku(給付実績中間高額Entity.getSikyugaku().multiply(高額支給額合計));
                中間高額一時Writer.insert(給付実績中間高額Entity);
            }
        } else {
            if (作成区分Flag_0) {
                if (区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                    給付実績中間高額Entity.setSikyugaku(給付実績中間高額Entity.getSikyugaku().multiply(高額支給額合計));
                    中間高額一時Writer.insert(給付実績中間高額Entity);
                }
                if (区分コード_1.equals(国保連共同処理受託区分_高額)
                        && 区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                    //TOTO
                    合計全件一時Writer.update(get合計全件一時(給付実績中間高額Entity));
                    明細全件更新一時Writer.insert(get明細全件更新一時(給付実績中間高額Entity));
                }
            } else {
                if (区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                    中間高額一時Writer.insert(給付実績中間高額Entity);
                }
                if (区分コード_1.equals(国保連共同処理受託区分_高額)
                        && 区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                    申請全件一時Writer.insert(get申請全件一時_3(給付実績中間高額Entity, 結果Entity));
                    判定結果全件一時Writer.insert(get判定結果全件一時_3(給付実績中間高額Entity, 結果Entity));
                    審査決定全件一時Writer.insert(get審査決定全件一時_3(給付実績中間高額Entity, 結果Entity));
                    合計全件一時Writer.insert(get合計全件一時_3(給付実績中間高額Entity, 結果Entity));
                    明細全件更新一時Writer.insert(get明細全件更新一時(給付実績中間高額Entity));
                }
            }
        }
    }

    private DbT3056KogakuShikyuShinseiEntity get申請全件一時(TempKyufujissekiTyukannEntity 給付実績中間高額Entity) {
        DbT3056KogakuShikyuShinseiEntity 申請全件一時Entity = new DbT3056KogakuShikyuShinseiEntity();
        申請全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        申請全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        申請全件一時Entity.setShoKisaiHokenshaNo(給付実績中間高額Entity.getShokisaiHokenshaNo());
        申請全件一時Entity.setRirekiNo(Decimal.ONE);
        return 申請全件一時Entity;
    }

    private DbT3056KogakuShikyuShinseiEntity get申請全件一時_3(TempKyufujissekiTyukannEntity 給付実績中間高額Entity,
            TyukannKogakuRelateEntity 結果Entity) {
        DbT3056KogakuShikyuShinseiEntity 申請全件一時Entity = new DbT3056KogakuShikyuShinseiEntity();
        申請全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        申請全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        申請全件一時Entity.setShoKisaiHokenshaNo(給付実績中間高額Entity.getShokisaiHokenshaNo());
        申請全件一時Entity.setRirekiNo(結果Entity.get高額申請全件Entity().getRirekiNo().add(Decimal.ONE));
        return 申請全件一時Entity;
    }

    private DbT3057KogakuShikyuHanteiKekkaEntity get判定結果全件一時(TempKyufujissekiTyukannEntity 給付実績中間高額Entity) {
        DbT3057KogakuShikyuHanteiKekkaEntity 判定結果全件一時Entity = new DbT3057KogakuShikyuHanteiKekkaEntity();
        判定結果全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        判定結果全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        判定結果全件一時Entity.setShoKisaiHokenshaNo(給付実績中間高額Entity.getShokisaiHokenshaNo());
        判定結果全件一時Entity.setRirekiNo(1);
        return 判定結果全件一時Entity;
    }

    private DbT3057KogakuShikyuHanteiKekkaEntity get判定結果全件一時_3(TempKyufujissekiTyukannEntity 給付実績中間高額Entity,
            TyukannKogakuRelateEntity 結果Entity) {
        DbT3057KogakuShikyuHanteiKekkaEntity 判定結果全件一時Entity = new DbT3057KogakuShikyuHanteiKekkaEntity();
        判定結果全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        判定結果全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        判定結果全件一時Entity.setShoKisaiHokenshaNo(給付実績中間高額Entity.getShokisaiHokenshaNo());
        判定結果全件一時Entity.setRirekiNo(結果Entity.get高額判定結果全件Entity().getRirekiNo() + 1);
        return 判定結果全件一時Entity;
    }

    private DbT3058KogakuShikyuShinsaKetteiEntity get審査決定全件一時(TempKyufujissekiTyukannEntity 給付実績中間高額Entity) {
        DbT3058KogakuShikyuShinsaKetteiEntity 審査決定全件一時Entity = new DbT3058KogakuShikyuShinsaKetteiEntity();
        審査決定全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        審査決定全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        審査決定全件一時Entity.setShoKisaiHokenshaNo(給付実績中間高額Entity.getShokisaiHokenshaNo());
        審査決定全件一時Entity.setRirekiNo(1);
        return 審査決定全件一時Entity;
    }

    private DbT3058KogakuShikyuShinsaKetteiEntity get審査決定全件一時_3(TempKyufujissekiTyukannEntity 給付実績中間高額Entity,
            TyukannKogakuRelateEntity 結果Entity) {
        DbT3058KogakuShikyuShinsaKetteiEntity 審査決定全件一時Entity = new DbT3058KogakuShikyuShinsaKetteiEntity();
        審査決定全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        審査決定全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        審査決定全件一時Entity.setShoKisaiHokenshaNo(給付実績中間高額Entity.getShokisaiHokenshaNo());
        //TODO
        審査決定全件一時Entity.setRirekiNo(結果Entity.get高額審査決定全件Entity().getRirekiNo() + 1);
        return 審査決定全件一時Entity;
    }

    private DbT3055KogakuKyufuTaishoshaGokeiEntity get合計全件一時(TempKyufujissekiTyukannEntity 給付実績中間高額Entity) {
        DbT3055KogakuKyufuTaishoshaGokeiEntity 合計全件一時Entity = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
        合計全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        合計全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        合計全件一時Entity.setRirekiNo(Decimal.ONE);
        合計全件一時Entity.setServiceHiyoGokeiGakuGokei(給付実績中間高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setRiyoshaFutanGakuGokei(給付実績中間高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setSanteiKijunGaku(給付実績中間高額Entity.getSanteiKijungaku());
        合計全件一時Entity.setShiharaiSumiKingakuGokei(Decimal.ZERO);
        合計全件一時Entity.setKogakuShikyuGaku(給付実績中間高額Entity.getSikyugaku());
        合計全件一時Entity.setTaishoshaHanteiShinsaYM(parameter.get処理年月日().getYearMonth());
        合計全件一時Entity.setTashoshaUketoriYM(FlexibleYearMonth.EMPTY);
        //TODO
        合計全件一時Entity.setSetaiShuyakuNo(RString.EMPTY);
        //合計全件一時Entity.setKyokaisoTaishoshaFlag(給付実績中間高額Entity.getKogakuServicehiJogengakuGengakuGaitoFlag());
        //TODO
        合計全件一時Entity.setHojinKeigenTaishoFlag(true);
        合計全件一時Entity.setKogakuTaishoGaiFlag(false);
        合計全件一時Entity.setJidoShokanTaishoFlag(false);
        return 合計全件一時Entity;
    }

    private DbT3055KogakuKyufuTaishoshaGokeiEntity get合計全件一時_3(TempKyufujissekiTyukannEntity 給付実績中間高額Entity,
            TyukannKogakuRelateEntity 結果Entity) {
        DbT3055KogakuKyufuTaishoshaGokeiEntity 合計全件一時Entity = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
        合計全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        合計全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        合計全件一時Entity.setRirekiNo(結果Entity.get高額合計全件Entity().getRirekiNo().add(Decimal.ONE));
        合計全件一時Entity.setServiceHiyoGokeiGakuGokei(給付実績中間高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setRiyoshaFutanGakuGokei(給付実績中間高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setSanteiKijunGaku(給付実績中間高額Entity.getSanteiKijungaku());
        //TODO 支払済金額合計
        合計全件一時Entity.setShiharaiSumiKingakuGokei(Decimal.ZERO);
        //TODO 高額支給額
        合計全件一時Entity.setKogakuShikyuGaku(給付実績中間高額Entity.getSikyugaku());
        合計全件一時Entity.setTaishoshaHanteiShinsaYM(parameter.get処理年月日().getYearMonth());
        合計全件一時Entity.setTashoshaUketoriYM(FlexibleYearMonth.EMPTY);
        //TODO 世帯集約番号
        合計全件一時Entity.setSetaiShuyakuNo(RString.EMPTY);
        //合計全件一時Entity.setKyokaisoTaishoshaFlag(給付実績中間高額Entity.getKogakuServicehiJogengakuGengakuGaitoFlag());
        //TODO 社会福祉法人軽減対象フラグ
        合計全件一時Entity.setHojinKeigenTaishoFlag(true);
        合計全件一時Entity.setKogakuTaishoGaiFlag(false);
        合計全件一時Entity.setJidoShokanTaishoFlag(false);
        return 合計全件一時Entity;
    }

    private TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity get明細全件更新一時(TempKyufujissekiTyukannEntity 給付実績中間高額Entity) {
        TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity 明細全件更新一時Entity = new TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity();
        明細全件更新一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        明細全件更新一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        明細全件更新一時Entity.setJigyoshaNo(給付実績中間高額Entity.getJigyoshoNo());
        明細全件更新一時Entity.setServiceShuruiCode(給付実績中間高額Entity.getServiceSyuruiCode());
        明細全件更新一時Entity.setRirekiNo(1);
        明細全件更新一時Entity.setServiceHiyoGokeiGaku(給付実績中間高額Entity.getServiceHiyougakuGokei());
        明細全件更新一時Entity.setRiyoshaFutanGaku(給付実績中間高額Entity.getHokenRiyoshaFutangaku());
        明細全件更新一時Entity.setKogakuKyufuKonkyo(給付実績中間高額Entity.getBeikoKojinshotokuKubun());
        return 明細全件更新一時Entity;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private boolean getマッチFlag(boolean マッチFlag, TyukannKogakuRelateEntity 結果Entity) {
        if (結果Entity.get高額判定結果全件Entity() != null) {
            マッチFlag = true;
        }
        return マッチFlag;
    }

    private boolean get受取年月Flag(boolean 受取年月Flag, TyukannKogakuRelateEntity 結果Entity) {
        if (結果Entity.get高額合計全件Entity() != null
                && 結果Entity.get高額合計全件Entity().getTashoshaUketoriYM() != null) {
            受取年月Flag = true;
        }
        return 受取年月Flag;
    }

    private boolean get作成区分Flag_1(boolean 作成区分Flag_1, TyukannKogakuRelateEntity 結果Entity) {
        if (結果Entity.get高額判定結果全件Entity() != null
                && 区分コード_1.equals(結果Entity.get給付実績中間高額Entity().getDokujiSakuseiKubun())) {
            作成区分Flag_1 = true;
        }
        return 作成区分Flag_1;
    }

    private boolean get作成区分Flag_0(boolean 作成区分Flag_0, TyukannKogakuRelateEntity 結果Entity) {
        if (結果Entity.get高額判定結果全件Entity() != null
                && 区分コード_0.equals(結果Entity.get給付実績中間高額Entity().getDokujiSakuseiKubun())) {
            作成区分Flag_0 = true;
        }
        return 作成区分Flag_0;
    }

    private boolean get決定年月日Flag(boolean 決定年月日Flag, TyukannKogakuRelateEntity 結果Entity) {
        if (結果Entity.get高額判定結果全件Entity() != null
                && 区分コード_0.equals(結果Entity.get給付実績中間高額Entity().getDokujiSakuseiKubun())
                && 結果Entity.get高額判定結果全件Entity().getKetteiYMD() != null) {
            決定年月日Flag = true;
        }
        return 決定年月日Flag;
    }

    private boolean getFlag(boolean flag, TyukannKogakuRelateEntity 結果Entity) {
        if (結果Entity.get高額判定結果全件Entity() != null
                && 結果Entity.get高額判定結果全件Entity().getKetteiYMD() != null) {
            flag = true;
        }
        return flag;
    }

    private Decimal get高額支給額合計(TyukannKogakuRelateEntity 結果Entity, Decimal 高額支給額合計, boolean flag) {
        if (!flag && Decimal.ZERO.compareTo(結果Entity.get高額合計全件Entity().getKogakuShikyuGaku()) == 1) {
            高額支給額合計 = 高額支給額合計.add(結果Entity.get高額判定結果全件Entity().getShikyuKingaku());
        } else {
            高額支給額合計 = 高額支給額合計.add(結果Entity.get高額合計全件Entity().getKogakuShikyuGaku());
        }
        return 高額支給額合計;
    }

}
