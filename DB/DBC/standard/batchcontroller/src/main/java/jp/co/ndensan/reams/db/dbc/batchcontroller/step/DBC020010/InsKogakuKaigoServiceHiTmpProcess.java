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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    private static final RString TABLE_高額介護サービス費支給申請全件一時_新規 = new RString("TempKogakuShikyuShinseiZenForInsert");
    private static final RString TABLE_高額介護サービス費支給判定結果全件一時_新規 = new RString("TempKogakuShikyuHanteiKekkaZenForInsert");
    private static final RString TABLE_高額介護サービス費支給審査決定全件一時_新規 = new RString("TempKogakuShikyuShinsaKetteiZenForInsert");
    private static final RString TABLE_高額介護サービス費給付対象者合計全件一時_新規 = new RString("TempKogakuKyufuTaishoshaGokeiZenForInsert");
    private static final RString TABLE_高額介護サービス費給付対象者明細全件更新一時 = new RString("TempKogakuKyufuTaishoshaMeisaiZenUpdate");
    private static final RString TABLE_給付実績中間高額一時9 = new RString("TempKyufujissekiTyukann9");
    private static final RString DELIMITER = new RString("～");
    private static final RString 区分コード_0 = new RString("0");
    private static final RString 区分コード_1 = new RString("1");
    private static final RString 区分コード_2 = new RString("2");
    private static final RString 区分コード_3 = new RString("3");
    private static final RString 区分コード_4 = new RString("4");
    private static final RString 差額区分コード = new RString("※");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 申請全件一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 判定結果全件一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 審査決定全件一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 合計全件一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 申請全件一時_新規Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 判定結果全件一時_新規Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 審査決定全件一時_新規Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 合計全件一時_新規Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間高額一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 明細全件更新一時Writer;
    private KyufuJissekiKihonKogakuProcessParameter parameter;
    private RString keyBreak;
    private RString beforeマッチキー;
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
        申請全件一時_新規Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給申請全件一時_新規, DbT3056KogakuShikyuShinseiEntity.class);
        判定結果全件一時_新規Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給判定結果全件一時_新規, DbT3057KogakuShikyuHanteiKekkaEntity.class);
        審査決定全件一時_新規Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費支給審査決定全件一時_新規, DbT3058KogakuShikyuShinsaKetteiEntity.class);
        合計全件一時_新規Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者合計全件一時_新規, DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
        中間高額一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間高額一時9, TempKyufujissekiTyukannEntity.class);
        明細全件更新一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_高額介護サービス費給付対象者明細全件更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
    }

    @Override
    protected void process(TyukannKogakuRelateEntity entity) {
        if (isデータ不整合(entity)) {
            return;
        }
        RString 被保険者番号 = getColumnValue(entity.get給付実績中間高額Entity().getHiHokenshaNo());
        RString サービス提供年月 = entity.get給付実績中間高額Entity().getServiceTeikyoYM() != null
                ? entity.get給付実績中間高額Entity().getServiceTeikyoYM().toDateString() : RString.EMPTY;
        RString データ区分 = entity.get給付実績中間高額Entity().getDataKubun();
        RString サービス種類コード = getColumnValue(entity.get給付実績中間高額Entity().getServiceSyuruiCode());
        RString nowKeyBreak = 被保険者番号.concat(DELIMITER).concat(サービス提供年月).concat(DELIMITER)
                .concat(データ区分).concat(DELIMITER).concat(サービス種類コード);
        RString マッチキー = 被保険者番号.concat(DELIMITER).concat(サービス提供年月);
        boolean isFirstProcess = false;
        if (keyBreak == null || beforeマッチキー == null) {
            isFirstProcess = true;
            keyBreak = nowKeyBreak;
            beforeマッチキー = マッチキー;
        }
        if (!isFirstProcess && nowKeyBreak.equals(keyBreak)) {
            return;
        }
        if (beforeマッチキー.equals(マッチキー)) {
            結果全件List.add(entity);
            return;
        }
        do高額更新処理();
        結果全件List.clear();
        keyBreak = nowKeyBreak;
        beforeマッチキー = マッチキー;
        結果全件List.add(entity);
    }

    @Override
    protected void afterExecute() {
        do高額更新処理();
    }

    private void do高額更新処理() {
        if (結果全件List == null || 結果全件List.isEmpty()) {
            return;
        }
        boolean isマッチ = false;
        boolean is出力をしない = false;
        boolean is対象者受取年月が設定1件以上 = false;
        boolean is作成区分0存在 = false;
        boolean is支給区分コード2存在 = false;
        Decimal 高額支給額合計 = Decimal.ZERO;
        Decimal 差額区分_高額支給額合計 = Decimal.ZERO;
        Decimal 算定済高額金額 = Decimal.ZERO;
        for (TyukannKogakuRelateEntity 結果Entity : 結果全件List) {
            isマッチ = getマッチFlag(isマッチ, 結果Entity);
            is出力をしない = get給付実績中間高額一時出力Flag(is出力をしない, 結果Entity);
            is対象者受取年月が設定1件以上 = get受取年月Flag(is対象者受取年月が設定1件以上, 結果Entity);
            is作成区分0存在 = get作成区分Flag_0(is作成区分0存在, 結果Entity);
            is支給区分コード2存在 = get支給区分コード2存在(is支給区分コード2存在, 結果Entity);
            高額支給額合計 = get高額支給額合計(結果Entity, 高額支給額合計);
            算定済高額金額 = get算定済高額金額(結果Entity, 算定済高額金額);
            差額区分_高額支給額合計 = get差額区分_高額支給額合計(結果Entity, 高額支給額合計);
        }
        TyukannKogakuRelateEntity 結果Entity = 結果全件List.get(0);
        TempKyufujissekiTyukannEntity 給付実績中間高額Entity = 結果Entity.get給付実績中間高額Entity();
        if (!Decimal.ZERO.equals(差額区分_高額支給額合計)
                || is支給区分コード2存在) {
            給付実績中間高額Entity.setSagakuKubun(差額区分コード);
        } else {
            給付実績中間高額Entity.setSagakuKubun(RString.EMPTY);
        }
        if (!isマッチ) {
            if (!is出力をしない) {
                insert高額全件一時(結果Entity);
            }
        } else if (is対象者受取年月が設定1件以上) {
            if (区分コード_3.equals(給付実績中間高額Entity.getKyufuSakuseiKubunCode())) {
                給付実績中間高額Entity.setSikyugaku(Decimal.ZERO);
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_2);
            } else {
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_2);
            }
            中間高額一時Writer.insert(給付実績中間高額Entity);
        } else {
            if (区分コード_3.equals(給付実績中間高額Entity.getKyufuSakuseiKubunCode())) {
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_4);
                給付実績中間高額Entity.setSikyugaku(Decimal.ZERO);
                中間高額一時Writer.insert(給付実績中間高額Entity);
            } else {
                update高額全件一時_作成区分コードが3以外(高額支給額合計,
                        給付実績中間高額Entity,
                        結果Entity,
                        is作成区分0存在,
                        算定済高額金額);
            }
        }
    }

    private void insert高額全件一時(TyukannKogakuRelateEntity 結果Entity) {
        TempKyufujissekiTyukannEntity 給付実績中間高額Entity = 結果Entity.get給付実績中間高額Entity();
        if (区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
            給付実績中間高額Entity.setKogakuHanteiKekka(RString.EMPTY);
            中間高額一時Writer.insert(給付実績中間高額Entity);
        }
        if (区分コード_1.equals(国保連共同処理受託区分_高額)
                && 区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
            DbT3056KogakuShikyuShinseiEntity 申請全件一時 = get申請全件一時(給付実績中間高額Entity);
            DbT3057KogakuShikyuHanteiKekkaEntity 判定結果全件一時 = get判定結果全件一時(給付実績中間高額Entity);
            DbT3058KogakuShikyuShinsaKetteiEntity 審査決定全件一時 = get審査決定全件一時(給付実績中間高額Entity);
            DbT3055KogakuKyufuTaishoshaGokeiEntity 合計全件一時 = get合計全件一時(給付実績中間高額Entity);
            申請全件一時Writer.insert(申請全件一時);
            申請全件一時_新規Writer.insert(申請全件一時);
            判定結果全件一時Writer.insert(判定結果全件一時);
            判定結果全件一時_新規Writer.insert(判定結果全件一時);
            審査決定全件一時Writer.insert(審査決定全件一時);
            審査決定全件一時_新規Writer.insert(審査決定全件一時);
            合計全件一時Writer.insert(合計全件一時);
            合計全件一時_新規Writer.insert(合計全件一時);
        } else if (区分コード_1.equals(国保連共同処理受託区分_高額)
                && 区分コード_2.equals(給付実績中間高額Entity.getDataKubun())) {
            明細全件更新一時Writer.insert(get明細全件更新一時(給付実績中間高額Entity));
        }
    }

    private boolean get給付実績中間高額一時出力Flag(boolean is出力をしない, TyukannKogakuRelateEntity 結果Entity) {
        if (区分コード_3.equals(結果Entity.get給付実績中間高額Entity().getKyufuSakuseiKubunCode())
                || Decimal.ZERO.compareTo(結果Entity.get給付実績中間高額Entity().getSikyugaku()) == 0) {
            is出力をしない = true;
        }
        return is出力をしない;
    }

    private void update高額全件一時_作成区分コードが3以外(Decimal 高額支給額合計,
            TempKyufujissekiTyukannEntity 給付実績中間高額Entity,
            TyukannKogakuRelateEntity 結果Entity,
            boolean is作成区分0存在,
            Decimal 算定済高額金額) {
        if (給付実績中間高額Entity.getSikyugaku().compareTo(高額支給額合計) <= 0) {
            if (Decimal.ZERO.equals(給付実績中間高額Entity.getSikyugaku())) {
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_4);
                給付実績中間高額Entity.setSikyugaku(Decimal.ZERO);
                中間高額一時Writer.insert(給付実績中間高額Entity);
            } else if (Decimal.ZERO.compareTo(給付実績中間高額Entity.getSikyugaku()) < 0
                    && !Decimal.ZERO.equals(給付実績中間高額Entity.getSikyugaku().multiply(高額支給額合計))) {
                給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_3);
                中間高額一時Writer.insert(給付実績中間高額Entity);
            }
        } else {
            if (is作成区分0存在) {
                if (区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                    給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_3);
                    中間高額一時Writer.insert(給付実績中間高額Entity);
                }
                if (区分コード_1.equals(国保連共同処理受託区分_高額)
                        && 区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                    合計全件一時Writer.update(update合計全件一時(給付実績中間高額Entity, 結果Entity, 算定済高額金額));
                    明細全件更新一時Writer.insert(get明細全件更新一時(給付実績中間高額Entity));
                }
            } else {
                if (区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                    給付実績中間高額Entity.setKoogakuKetteiKubun(区分コード_4);
                    給付実績中間高額Entity.setSikyugaku(Decimal.ZERO);
                    中間高額一時Writer.insert(給付実績中間高額Entity);
                }
                if (区分コード_1.equals(国保連共同処理受託区分_高額)
                        && 区分コード_1.equals(給付実績中間高額Entity.getDataKubun())) {
                    DbT3056KogakuShikyuShinseiEntity 申請全件一時 = get申請全件一時_3(給付実績中間高額Entity, 結果Entity);
                    DbT3057KogakuShikyuHanteiKekkaEntity 判定結果全件一時 = get判定結果全件一時_3(給付実績中間高額Entity, 結果Entity);
                    DbT3058KogakuShikyuShinsaKetteiEntity 審査決定全件一時 = get審査決定全件一時_3(給付実績中間高額Entity, 結果Entity);
                    DbT3055KogakuKyufuTaishoshaGokeiEntity 合計全件一時 = get合計全件一時_3(給付実績中間高額Entity, 結果Entity, 算定済高額金額);
                    TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity 明細全件更新一時 = get明細全件更新一時(給付実績中間高額Entity);
                    明細全件更新一時.setRirekiNo(判定結果全件一時.getRirekiNo());
                    申請全件一時Writer.insert(申請全件一時);
                    申請全件一時_新規Writer.insert(申請全件一時);
                    判定結果全件一時Writer.insert(判定結果全件一時);
                    判定結果全件一時_新規Writer.insert(判定結果全件一時);
                    審査決定全件一時Writer.insert(審査決定全件一時);
                    審査決定全件一時_新規Writer.insert(審査決定全件一時);
                    合計全件一時Writer.insert(合計全件一時);
                    合計全件一時_新規Writer.insert(合計全件一時);
                    明細全件更新一時Writer.insert(明細全件更新一時);
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
        判定結果全件一時Entity.setRirekiEdaNo(0);
        判定結果全件一時Entity.setKetteiYMD(FlexibleDate.EMPTY);
        判定結果全件一時Entity.setHonninShiharaiGaku(Decimal.ZERO);
        判定結果全件一時Entity.setShikyuKubunCode(RString.EMPTY);
        判定結果全件一時Entity.setShikyuKingaku(Decimal.ZERO);
        return 判定結果全件一時Entity;
    }

    private DbT3057KogakuShikyuHanteiKekkaEntity get判定結果全件一時_3(TempKyufujissekiTyukannEntity 給付実績中間高額Entity,
            TyukannKogakuRelateEntity 結果Entity) {
        DbT3057KogakuShikyuHanteiKekkaEntity 判定結果全件一時Entity = new DbT3057KogakuShikyuHanteiKekkaEntity();
        判定結果全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        判定結果全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        判定結果全件一時Entity.setShoKisaiHokenshaNo(給付実績中間高額Entity.getShokisaiHokenshaNo());
        判定結果全件一時Entity.setRirekiNo(結果Entity.get高額判定結果全件Entity().getRirekiNo() + 1);
        判定結果全件一時Entity.setRirekiEdaNo(0);
        判定結果全件一時Entity.setKetteiYMD(FlexibleDate.EMPTY);
        判定結果全件一時Entity.setHonninShiharaiGaku(Decimal.ZERO);
        判定結果全件一時Entity.setShikyuKubunCode(RString.EMPTY);
        判定結果全件一時Entity.setShikyuKingaku(Decimal.ZERO);
        return 判定結果全件一時Entity;
    }

    private DbT3058KogakuShikyuShinsaKetteiEntity get審査決定全件一時(TempKyufujissekiTyukannEntity 給付実績中間高額Entity) {
        DbT3058KogakuShikyuShinsaKetteiEntity 審査決定全件一時Entity = new DbT3058KogakuShikyuShinsaKetteiEntity();
        審査決定全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        審査決定全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        審査決定全件一時Entity.setShoKisaiHokenshaNo(給付実績中間高額Entity.getShokisaiHokenshaNo());
        審査決定全件一時Entity.setRirekiNo(1);
        審査決定全件一時Entity.setKetteishaUketoriYM(FlexibleYearMonth.EMPTY);
        審査決定全件一時Entity.setTsuchishoNo(RString.EMPTY);
        審査決定全件一時Entity.setRiyoshaFutanGaku(Decimal.ZERO);
        審査決定全件一時Entity.setShikyuKubunCode(RString.EMPTY);
        審査決定全件一時Entity.setKetteiYM(FlexibleYearMonth.EMPTY);
        return 審査決定全件一時Entity;
    }

    private DbT3058KogakuShikyuShinsaKetteiEntity get審査決定全件一時_3(TempKyufujissekiTyukannEntity 給付実績中間高額Entity,
            TyukannKogakuRelateEntity 結果Entity) {
        DbT3058KogakuShikyuShinsaKetteiEntity 審査決定全件一時Entity = new DbT3058KogakuShikyuShinsaKetteiEntity();
        審査決定全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        審査決定全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        審査決定全件一時Entity.setShoKisaiHokenshaNo(給付実績中間高額Entity.getShokisaiHokenshaNo());
        審査決定全件一時Entity.setRirekiNo(結果Entity.get高額審査決定全件Entity().getRirekiNo() + 1);
        審査決定全件一時Entity.setKetteishaUketoriYM(FlexibleYearMonth.EMPTY);
        審査決定全件一時Entity.setTsuchishoNo(RString.EMPTY);
        審査決定全件一時Entity.setRiyoshaFutanGaku(Decimal.ZERO);
        審査決定全件一時Entity.setShikyuKubunCode(RString.EMPTY);
        審査決定全件一時Entity.setKetteiYM(FlexibleYearMonth.EMPTY);
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
        合計全件一時Entity.setSetaiShuyakuNo(getColumnValue(給付実績中間高額Entity.getShotokuHantei_setaiinShikibetsuCode()));
        if (区分コード_1.equals(給付実績中間高額Entity.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(true);
        } else {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(false);
        }
        合計全件一時Entity.setHojinKeigenTaishoFlag(給付実績中間高額Entity.isHokenshaHoyuKyufujissekiJohoSakujoFlag());
        合計全件一時Entity.setKogakuTaishoGaiFlag(false);
        合計全件一時Entity.setJidoShokanTaishoFlag(false);
        return 合計全件一時Entity;
    }

    private DbT3055KogakuKyufuTaishoshaGokeiEntity update合計全件一時(TempKyufujissekiTyukannEntity 給付実績中間高額Entity,
            TyukannKogakuRelateEntity 結果Entity, Decimal 算定済高額金額) {
        DbT3055KogakuKyufuTaishoshaGokeiEntity 合計全件一時Entity = 結果Entity.get高額合計全件Entity();
        合計全件一時Entity.setServiceHiyoGokeiGakuGokei(給付実績中間高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setRiyoshaFutanGakuGokei(給付実績中間高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setSanteiKijunGaku(給付実績中間高額Entity.getSanteiKijungaku());
        合計全件一時Entity.setShiharaiSumiKingakuGokei(算定済高額金額);
        合計全件一時Entity.setKogakuShikyuGaku(給付実績中間高額Entity.getSikyugaku().subtract(算定済高額金額));
        合計全件一時Entity.setTaishoshaHanteiShinsaYM(parameter.get処理年月日().getYearMonth());
        合計全件一時Entity.setSetaiShuyakuNo(getColumnValue(給付実績中間高額Entity.getShotokuHantei_setaiinShikibetsuCode()));
        if (区分コード_1.equals(給付実績中間高額Entity.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(true);
        } else {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(false);
        }
        return 合計全件一時Entity;
    }

    private DbT3055KogakuKyufuTaishoshaGokeiEntity get合計全件一時_3(TempKyufujissekiTyukannEntity 給付実績中間高額Entity,
            TyukannKogakuRelateEntity 結果Entity, Decimal 算定済高額金額) {
        DbT3055KogakuKyufuTaishoshaGokeiEntity 合計全件一時Entity = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
        合計全件一時Entity.setHihokenshaNo(給付実績中間高額Entity.getHiHokenshaNo());
        合計全件一時Entity.setServiceTeikyoYM(給付実績中間高額Entity.getServiceTeikyoYM());
        合計全件一時Entity.setRirekiNo(結果Entity.get高額合計全件Entity().getRirekiNo().add(Decimal.ONE));
        合計全件一時Entity.setServiceHiyoGokeiGakuGokei(給付実績中間高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setRiyoshaFutanGakuGokei(給付実績中間高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setSanteiKijunGaku(給付実績中間高額Entity.getSanteiKijungaku());
        合計全件一時Entity.setShiharaiSumiKingakuGokei(算定済高額金額);
        合計全件一時Entity.setKogakuShikyuGaku(給付実績中間高額Entity.getSikyugaku().subtract(算定済高額金額));
        合計全件一時Entity.setTaishoshaHanteiShinsaYM(parameter.get処理年月日().getYearMonth());
        合計全件一時Entity.setTashoshaUketoriYM(FlexibleYearMonth.EMPTY);
        合計全件一時Entity.setSetaiShuyakuNo(getColumnValue(給付実績中間高額Entity.getShotokuHantei_setaiinShikibetsuCode()));
        if (区分コード_1.equals(給付実績中間高額Entity.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(true);
        } else {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(false);
        }
        合計全件一時Entity.setHojinKeigenTaishoFlag(給付実績中間高額Entity.isHokenshaHoyuKyufujissekiJohoSakujoFlag());
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
                && 結果Entity.get高額合計全件Entity().getTashoshaUketoriYM() != null
                && !結果Entity.get高額合計全件Entity().getTashoshaUketoriYM().isEmpty()) {
            受取年月Flag = true;
        }
        return 受取年月Flag;
    }

    private boolean get作成区分Flag_0(boolean 作成区分Flag_0, TyukannKogakuRelateEntity 結果Entity) {
        if (結果Entity.get高額判定結果全件Entity() != null
                && 区分コード_0.equals(結果Entity.get給付実績中間高額Entity().getDokujiSakuseiKubun())) {
            作成区分Flag_0 = true;
        }
        return 作成区分Flag_0;
    }

    private boolean get支給区分コード2存在(boolean is支給区分コード2存在, TyukannKogakuRelateEntity 結果Entity) {
        if (結果Entity.get高額審査決定全件Entity() != null
                && 区分コード_2.equals(結果Entity.get高額審査決定全件Entity().getShikyuKubunCode())) {
            is支給区分コード2存在 = true;
        }
        return is支給区分コード2存在;
    }

    private Decimal get高額支給額合計(TyukannKogakuRelateEntity 結果Entity, Decimal 高額支給額合計) {
        if (結果Entity.get高額合計全件Entity() == null || 結果Entity.get高額判定結果全件Entity() == null) {
            return 高額支給額合計;
        }
        Decimal kogakuShikyuGaku = 結果Entity.get高額合計全件Entity().getKogakuShikyuGaku() == null
                ? Decimal.ZERO : 結果Entity.get高額合計全件Entity().getKogakuShikyuGaku();
        if ((結果Entity.get高額判定結果全件Entity().getKetteiYMD() == null
                || 結果Entity.get高額判定結果全件Entity().getKetteiYMD().isEmpty())
                && Decimal.ZERO.compareTo(kogakuShikyuGaku) == 1) {
            高額支給額合計 = 高額支給額合計.add(結果Entity.get高額判定結果全件Entity().getShikyuKingaku());
        } else {
            高額支給額合計 = 高額支給額合計.add(結果Entity.get高額合計全件Entity().getKogakuShikyuGaku() == null
                    ? Decimal.ZERO : 結果Entity.get高額合計全件Entity().getKogakuShikyuGaku());
        }
        return 高額支給額合計;
    }

    private Decimal get算定済高額金額(TyukannKogakuRelateEntity 結果Entity, Decimal 算定済高額金額) {
        if (結果Entity.get高額審査決定全件Entity() != null) {
            if (結果Entity.get高額判定結果全件Entity() != null) {
                算定済高額金額 = 算定済高額金額.add(結果Entity.get高額判定結果全件Entity().getShikyuKingaku());
            }
        } else if (結果Entity.get高額合計全件Entity() != null) {
            算定済高額金額 = 算定済高額金額.add(結果Entity.get高額合計全件Entity().getKogakuShikyuGaku() == null
                    ? Decimal.ZERO : 結果Entity.get高額合計全件Entity().getKogakuShikyuGaku());
        }
        return 算定済高額金額;
    }

    private Decimal get差額区分_高額支給額合計(TyukannKogakuRelateEntity 結果Entity, Decimal 高額支給額合計) {
        if (結果Entity.get高額合計全件Entity() == null || 結果Entity.get高額判定結果全件Entity() == null) {
            return 高額支給額合計;
        }
        Decimal kogakuShikyuGaku = 結果Entity.get高額合計全件Entity().getKogakuShikyuGaku() == null
                ? Decimal.ZERO : 結果Entity.get高額合計全件Entity().getKogakuShikyuGaku();
        高額支給額合計 = 高額支給額合計.add(kogakuShikyuGaku).
                add(結果Entity.get高額合計全件Entity().getKogakuShikyuGaku() == null
                        ? Decimal.ZERO : 結果Entity.get高額合計全件Entity().getKogakuShikyuGaku());
        return 高額支給額合計;
    }

    private boolean isデータ不整合(TyukannKogakuRelateEntity entity) {
        return null == entity.get高額判定結果全件Entity()
                && (null != entity.get高額合計全件Entity()
                || null != entity.get高額申請全件Entity()
                || null != entity.get高額審査決定全件Entity());
    }
}
