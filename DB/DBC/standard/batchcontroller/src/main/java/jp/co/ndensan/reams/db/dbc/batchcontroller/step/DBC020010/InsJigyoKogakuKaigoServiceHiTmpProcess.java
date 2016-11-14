/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.TyukannJigyoKogakuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
 * 高額更新処理_事業高額介護サービス費一時の作成
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class InsJigyoKogakuKaigoServiceHiTmpProcess extends BatchProcessBase<TyukannJigyoKogakuRelateEntity> {

    private static final RString MYBATISPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select事業高額判定結果全件一時");

    private static final RString TABLE_事業高額介護サービス費支給申請全件一時 = new RString("TempJigyoKogakuShikyuShinseiZen");
    private static final RString TABLE_事業高額介護サービス費支給判定結果全件一時 = new RString("TempJigyoKogakuShikyuHanteiKekkaZen");
    private static final RString TABLE_事業高額介護サービス費支給審査決定全件一時 = new RString("TempJigyoKogakuShikyuShinsaKetteiZen");
    private static final RString TABLE_事業高額介護サービス費給付対象者合計全件一時 = new RString("TempJigyoKogakuKyufuTaishoshaGokeiZen");
    private static final RString TABLE_事業高額介護サービス費給付対象者明細全件更新一時 = new RString("TempJigyoKogakuKyufuTaishoshaMeisaiZenUpdate");
    private static final RString TABLE_給付実績中間事業高額一時9 = new RString("TempKyufujissekiTyukannJigyo9");
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
    BatchEntityCreatedTempTableWriter 中間高額一時Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 明細全件更新一時Writer;
    private KyufuJissekiKihonKogakuProcessParameter parameter;
    private RString keyBreak;
    private RString 国保連共同処理受託区分_高額;
    private RString beforeマッチキー;
    private List<TyukannJigyoKogakuRelateEntity> 結果全件List;

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
                TABLE_事業高額介護サービス費支給申請全件一時, DbT3110JigyoKogakuShikyuShinseiEntity.class);
        判定結果全件一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費支給判定結果全件一時, DbT3111JigyoKogakuShikyuHanteiKekkaEntity.class);
        審査決定全件一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費支給審査決定全件一時, DbT3112KogakuShikyuShinsaKetteiEntity.class);
        合計全件一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費給付対象者合計全件一時, DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity.class);
        中間高額一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間事業高額一時9, TempKyufujissekiTyukannJigyoEntity.class);
        明細全件更新一時Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_事業高額介護サービス費給付対象者明細全件更新一時, TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity.class);
    }

    @Override
    protected void process(TyukannJigyoKogakuRelateEntity entity) {
        RString 被保険者番号 = getColumnValue(entity.get給付実績中間事業高額Entity().getHiHokenshaNo());
        RString サービス提供年月 = entity.get給付実績中間事業高額Entity().getServiceTeikyoYM() != null
                ? entity.get給付実績中間事業高額Entity().getServiceTeikyoYM().toDateString() : RString.EMPTY;
        RString データ区分 = entity.get給付実績中間事業高額Entity().getDataKubun();
        RString サービス種類コード = getColumnValue(entity.get給付実績中間事業高額Entity().getServiceSyuruiCode());
        RString nowKeyBreak = 被保険者番号.concat(DELIMITER).concat(サービス提供年月).concat(DELIMITER)
                .concat(データ区分).concat(DELIMITER).concat(サービス種類コード);
        RString マッチキー = 被保険者番号.concat(DELIMITER).concat(サービス提供年月);
        if (keyBreak == null) {
            keyBreak = nowKeyBreak;
        }
        if (beforeマッチキー == null) {
            beforeマッチキー = マッチキー;
        }
        if (nowKeyBreak.equals(keyBreak)) {
            return;
        }
        if (beforeマッチキー.equals(マッチキー)) {
            結果全件List.add(entity);
            return;
        }
        do事業高額更新処理();
        結果全件List.clear();
        keyBreak = nowKeyBreak;
        beforeマッチキー = マッチキー;
        結果全件List.add(entity);
    }

    @Override
    protected void afterExecute() {
        if (結果全件List == null || 結果全件List.isEmpty()) {
            return;
        }
        do事業高額更新処理();
    }

    private void do事業高額更新処理() {
        boolean isマッチ = false;
        boolean is出力をしない = false;
        boolean is対象者受取年月が設定1件以上 = false;
        boolean is作成区分0存在 = false;
        boolean is支給区分コード2存在 = false;
        Decimal 高額支給額合計 = Decimal.ZERO;
        Decimal 差額区分_高額支給額合計 = Decimal.ZERO;
        for (TyukannJigyoKogakuRelateEntity 結果Entity : 結果全件List) {
            isマッチ = getマッチFlag(isマッチ, 結果Entity);
            is出力をしない = get給付実績中間事業高額一時出力Flag(is出力をしない, 結果Entity);
            is対象者受取年月が設定1件以上 = get受取年月Flag(is対象者受取年月が設定1件以上, 結果Entity);
            is作成区分0存在 = get作成区分Flag_0(is作成区分0存在, 結果Entity);
            is支給区分コード2存在 = get支給区分コード2存在(is支給区分コード2存在, 結果Entity);
            高額支給額合計 = get高額支給額合計(結果Entity, 高額支給額合計);
            差額区分_高額支給額合計 = get差額区分_高額支給額合計(結果Entity, 高額支給額合計);
        }
        TyukannJigyoKogakuRelateEntity 結果Entity = 結果全件List.get(0);
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity = 結果Entity.get給付実績中間事業高額Entity();
        if (!Decimal.ZERO.equals(差額区分_高額支給額合計)
                || is支給区分コード2存在) {
            給付実績中間事業高額Entity.setSagakuKubun(差額区分コード);
        } else {
            給付実績中間事業高額Entity.setSagakuKubun(RString.EMPTY);
        }
        if (!isマッチ) {
            if (!is出力をしない) {
                insert高額全件一時(給付実績中間事業高額Entity);
            }
        } else if (is対象者受取年月が設定1件以上) {
            if (区分コード_3.equals(給付実績中間事業高額Entity.getKyufuSakuseiKubunCode())) {
                給付実績中間事業高額Entity.setSikyugaku(Decimal.ZERO);
                給付実績中間事業高額Entity.setKoogakuKetteiKubun(区分コード_2);
            } else {
                給付実績中間事業高額Entity.setKoogakuKetteiKubun(区分コード_2);
            }
            中間高額一時Writer.insert(給付実績中間事業高額Entity);
        } else {
            if (区分コード_3.equals(給付実績中間事業高額Entity.getKyufuSakuseiKubunCode())) {
                給付実績中間事業高額Entity.setKoogakuKetteiKubun(区分コード_4);
                給付実績中間事業高額Entity.setSikyugaku(Decimal.ZERO);
                中間高額一時Writer.insert(給付実績中間事業高額Entity);
            } else {
                update高額全件一時_作成区分コードが3以外(高額支給額合計,
                        給付実績中間事業高額Entity,
                        結果Entity,
                        is作成区分0存在);
            }
        }
    }

    private void update高額全件一時_作成区分コードが3以外(Decimal 高額支給額合計,
            TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity, TyukannJigyoKogakuRelateEntity 結果Entity, boolean 作成区分Flag_0) {
        if (高額支給額合計.compareTo(給付実績中間事業高額Entity.getSikyugaku()) == 0
                || 高額支給額合計.compareTo(給付実績中間事業高額Entity.getSikyugaku()) == 1) {
            if (Decimal.ZERO.equals(給付実績中間事業高額Entity.getSikyugaku())) {
                給付実績中間事業高額Entity.setKoogakuKetteiKubun(区分コード_4);
                給付実績中間事業高額Entity.setSikyugaku(Decimal.ZERO);
                中間高額一時Writer.insert(給付実績中間事業高額Entity);
            } else if (Decimal.ZERO.compareTo(給付実績中間事業高額Entity.getSikyugaku()) == -1) {
                給付実績中間事業高額Entity.setKoogakuKetteiKubun(区分コード_3);
                給付実績中間事業高額Entity.setSikyugaku(給付実績中間事業高額Entity.getSikyugaku().multiply(高額支給額合計));
                中間高額一時Writer.insert(給付実績中間事業高額Entity);
            }
        } else {
            if (作成区分Flag_0) {
                if (区分コード_1.equals(給付実績中間事業高額Entity.getDataKubun())) {
                    給付実績中間事業高額Entity.setSikyugaku(給付実績中間事業高額Entity.getSikyugaku().multiply(高額支給額合計));
                    中間高額一時Writer.insert(給付実績中間事業高額Entity);
                }
                if (区分コード_1.equals(国保連共同処理受託区分_高額)
                        && 区分コード_1.equals(給付実績中間事業高額Entity.getDataKubun())) {
                    合計全件一時Writer.update(update合計全件一時(給付実績中間事業高額Entity, 結果Entity, 高額支給額合計));
                    明細全件更新一時Writer.insert(get明細全件更新一時(給付実績中間事業高額Entity));
                }
            } else {
                if (区分コード_1.equals(給付実績中間事業高額Entity.getDataKubun())) {
                    中間高額一時Writer.insert(給付実績中間事業高額Entity);
                }
                if (区分コード_1.equals(国保連共同処理受託区分_高額)
                        && 区分コード_1.equals(給付実績中間事業高額Entity.getDataKubun())) {
                    申請全件一時Writer.insert(get申請全件一時_3(給付実績中間事業高額Entity, 結果Entity));
                    判定結果全件一時Writer.insert(get判定結果全件一時_3(給付実績中間事業高額Entity, 結果Entity));
                    審査決定全件一時Writer.insert(get審査決定全件一時_3(給付実績中間事業高額Entity, 結果Entity));
                    合計全件一時Writer.insert(get合計全件一時_3(給付実績中間事業高額Entity, 結果Entity, 高額支給額合計));
                    明細全件更新一時Writer.insert(get明細全件更新一時(給付実績中間事業高額Entity));
                }
            }
        }
    }

    private void insert高額全件一時(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity) {
        if (!区分コード_3.equals(給付実績中間事業高額Entity.getKyufuSakuseiKubunCode())
                && Decimal.ZERO.compareTo(給付実績中間事業高額Entity.getSikyugaku()) == -1) {
            if (区分コード_1.equals(給付実績中間事業高額Entity.getDataKubun())) {
                給付実績中間事業高額Entity.setKogakuHanteiKekka(RString.EMPTY);
                中間高額一時Writer.insert(給付実績中間事業高額Entity);
            }
            if (区分コード_1.equals(国保連共同処理受託区分_高額)
                    && 区分コード_1.equals(給付実績中間事業高額Entity.getDataKubun())) {
                申請全件一時Writer.insert(get申請全件一時(給付実績中間事業高額Entity));
                判定結果全件一時Writer.insert(get判定結果全件一時(給付実績中間事業高額Entity));
                審査決定全件一時Writer.insert(get審査決定全件一時(給付実績中間事業高額Entity));
                合計全件一時Writer.insert(get合計全件一時(給付実績中間事業高額Entity));
            } else if (区分コード_1.equals(国保連共同処理受託区分_高額)
                    && 区分コード_2.equals(給付実績中間事業高額Entity.getDataKubun())) {
                明細全件更新一時Writer.insert(get明細全件更新一時(給付実績中間事業高額Entity));
            }
        }
    }

    private DbT3110JigyoKogakuShikyuShinseiEntity get申請全件一時(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity) {
        DbT3110JigyoKogakuShikyuShinseiEntity 申請全件一時Entity = new DbT3110JigyoKogakuShikyuShinseiEntity();
        申請全件一時Entity.setHihokenshaNo(給付実績中間事業高額Entity.getHiHokenshaNo());
        申請全件一時Entity.setServiceTeikyoYM(給付実績中間事業高額Entity.getServiceTeikyoYM());
        申請全件一時Entity.setShoKisaiHokenshaNo(給付実績中間事業高額Entity.getShokisaiHokenshaNo());
        申請全件一時Entity.setRirekiNo(Decimal.ONE);
        return 申請全件一時Entity;
    }

    private DbT3110JigyoKogakuShikyuShinseiEntity get申請全件一時_3(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity,
            TyukannJigyoKogakuRelateEntity 結果Entity) {
        DbT3110JigyoKogakuShikyuShinseiEntity 申請全件一時Entity = new DbT3110JigyoKogakuShikyuShinseiEntity();
        申請全件一時Entity.setHihokenshaNo(給付実績中間事業高額Entity.getHiHokenshaNo());
        申請全件一時Entity.setServiceTeikyoYM(給付実績中間事業高額Entity.getServiceTeikyoYM());
        申請全件一時Entity.setShoKisaiHokenshaNo(給付実績中間事業高額Entity.getShokisaiHokenshaNo());
        申請全件一時Entity.setRirekiNo(結果Entity.get事業高額申請全件Entity().getRirekiNo().add(Decimal.ONE));
        return 申請全件一時Entity;
    }

    private DbT3111JigyoKogakuShikyuHanteiKekkaEntity get判定結果全件一時(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity) {
        DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果全件一時Entity = new DbT3111JigyoKogakuShikyuHanteiKekkaEntity();
        判定結果全件一時Entity.setHihokenshaNo(給付実績中間事業高額Entity.getHiHokenshaNo());
        判定結果全件一時Entity.setServiceTeikyoYM(給付実績中間事業高額Entity.getServiceTeikyoYM());
        判定結果全件一時Entity.setShoKisaiHokenshaNo(給付実績中間事業高額Entity.getShokisaiHokenshaNo());
        判定結果全件一時Entity.setRirekiNo(Decimal.ONE);
        return 判定結果全件一時Entity;
    }

    private DbT3111JigyoKogakuShikyuHanteiKekkaEntity get判定結果全件一時_3(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity,
            TyukannJigyoKogakuRelateEntity 結果Entity) {
        DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果全件一時Entity = new DbT3111JigyoKogakuShikyuHanteiKekkaEntity();
        判定結果全件一時Entity.setHihokenshaNo(給付実績中間事業高額Entity.getHiHokenshaNo());
        判定結果全件一時Entity.setServiceTeikyoYM(給付実績中間事業高額Entity.getServiceTeikyoYM());
        判定結果全件一時Entity.setShoKisaiHokenshaNo(給付実績中間事業高額Entity.getShokisaiHokenshaNo());
        判定結果全件一時Entity.setRirekiNo(結果Entity.get事業高額判定結果全件Entity().getRirekiNo().add(Decimal.ONE));
        return 判定結果全件一時Entity;
    }

    private DbT3112KogakuShikyuShinsaKetteiEntity get審査決定全件一時(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity) {
        DbT3112KogakuShikyuShinsaKetteiEntity 審査決定全件一時Entity = new DbT3112KogakuShikyuShinsaKetteiEntity();
        審査決定全件一時Entity.setHihokenshaNo(給付実績中間事業高額Entity.getHiHokenshaNo());
        審査決定全件一時Entity.setServiceTeikyoYM(給付実績中間事業高額Entity.getServiceTeikyoYM());
        審査決定全件一時Entity.setShoKisaiHokenshaNo(給付実績中間事業高額Entity.getShokisaiHokenshaNo());
        審査決定全件一時Entity.setRirekiNo(1);
        return 審査決定全件一時Entity;
    }

    private DbT3112KogakuShikyuShinsaKetteiEntity get審査決定全件一時_3(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity,
            TyukannJigyoKogakuRelateEntity 結果Entity) {
        DbT3112KogakuShikyuShinsaKetteiEntity 審査決定全件一時Entity = new DbT3112KogakuShikyuShinsaKetteiEntity();
        審査決定全件一時Entity.setHihokenshaNo(給付実績中間事業高額Entity.getHiHokenshaNo());
        審査決定全件一時Entity.setServiceTeikyoYM(給付実績中間事業高額Entity.getServiceTeikyoYM());
        審査決定全件一時Entity.setShoKisaiHokenshaNo(給付実績中間事業高額Entity.getShokisaiHokenshaNo());
        審査決定全件一時Entity.setRirekiNo(結果Entity.get事業審査決定全件Entity().getRirekiNo() + 1);
        return 審査決定全件一時Entity;
    }

    private DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity get合計全件一時(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity) {
        DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity 合計全件一時Entity = new DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
        合計全件一時Entity.setHihokenshaNo(給付実績中間事業高額Entity.getHiHokenshaNo());
        合計全件一時Entity.setServiceTeikyoYM(給付実績中間事業高額Entity.getServiceTeikyoYM());
        合計全件一時Entity.setRirekiNo(Decimal.ONE);
        合計全件一時Entity.setServiceHiyoGokeiGakuGokei(給付実績中間事業高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setRiyoshaFutanGakuGokei(給付実績中間事業高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setSanteiKijunGaku(給付実績中間事業高額Entity.getSanteiKijungaku());
        合計全件一時Entity.setShiharaiSumiKingakuGokei(Decimal.ZERO);
        合計全件一時Entity.setJigyoKogakuShikyuGaku(給付実績中間事業高額Entity.getSikyugaku());
        合計全件一時Entity.setTaishoshaHanteiShinsaYM(parameter.get処理年月日().getYearMonth());
        合計全件一時Entity.setTashoshaUketoriYM(FlexibleYearMonth.EMPTY);
        合計全件一時Entity.setSetaiShuyakuNo(getColumnValue(給付実績中間事業高額Entity.getShotokuHantei_setaiinShikibetsuCode()));
        if (区分コード_1.equals(給付実績中間事業高額Entity.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(true);
        } else {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(false);
        }
        合計全件一時Entity.setHojinKeigenTaishoFlag(給付実績中間事業高額Entity.isHokenshaHoyuKyufujissekiJohoSakujoFlag());
        合計全件一時Entity.setKogakuTaishoGaiFlag(false);
        合計全件一時Entity.setJidoShokanTaishoFlag(false);
        return 合計全件一時Entity;
    }

    private DbT3055KogakuKyufuTaishoshaGokeiEntity update合計全件一時(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity,
            TyukannJigyoKogakuRelateEntity 結果Entity, Decimal 高額支給額合計) {
        DbT3055KogakuKyufuTaishoshaGokeiEntity 合計全件一時Entity = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
        合計全件一時Entity.setHihokenshaNo(結果Entity.get事業高額合計全件Entity().getHihokenshaNo());
        合計全件一時Entity.setServiceTeikyoYM(結果Entity.get事業高額合計全件Entity().getServiceTeikyoYM());
        合計全件一時Entity.setRirekiNo(結果Entity.get事業高額合計全件Entity().getRirekiNo());
        合計全件一時Entity.setServiceHiyoGokeiGakuGokei(給付実績中間事業高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setRiyoshaFutanGakuGokei(給付実績中間事業高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setSanteiKijunGaku(給付実績中間事業高額Entity.getSanteiKijungaku());
        合計全件一時Entity.setShiharaiSumiKingakuGokei(高額支給額合計);
        合計全件一時Entity.setKogakuShikyuGaku(高額支給額合計);
        合計全件一時Entity.setTaishoshaHanteiShinsaYM(parameter.get処理年月日().getYearMonth());
        合計全件一時Entity.setSetaiShuyakuNo(getColumnValue(給付実績中間事業高額Entity.getShotokuHantei_setaiinShikibetsuCode()));
        if (区分コード_1.equals(給付実績中間事業高額Entity.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(true);
        } else {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(false);
        }
        return 合計全件一時Entity;
    }

    private DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity get合計全件一時_3(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity,
            TyukannJigyoKogakuRelateEntity 結果Entity, Decimal 高額支給額合計) {
        DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity 合計全件一時Entity = new DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
        合計全件一時Entity.setHihokenshaNo(給付実績中間事業高額Entity.getHiHokenshaNo());
        合計全件一時Entity.setServiceTeikyoYM(給付実績中間事業高額Entity.getServiceTeikyoYM());
        合計全件一時Entity.setRirekiNo(結果Entity.get事業高額合計全件Entity().getRirekiNo().add(Decimal.ONE));
        合計全件一時Entity.setServiceHiyoGokeiGakuGokei(給付実績中間事業高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setRiyoshaFutanGakuGokei(給付実績中間事業高額Entity.getHokenRiyoshaFutangaku());
        合計全件一時Entity.setSanteiKijunGaku(給付実績中間事業高額Entity.getSanteiKijungaku());
        合計全件一時Entity.setShiharaiSumiKingakuGokei(高額支給額合計);
        合計全件一時Entity.setJigyoKogakuShikyuGaku(高額支給額合計);
        合計全件一時Entity.setTashoshaUketoriYM(FlexibleYearMonth.EMPTY);
        合計全件一時Entity.setTaishoshaHanteiShinsaYM(parameter.get処理年月日().getYearMonth());
        合計全件一時Entity.setSetaiShuyakuNo(getColumnValue(給付実績中間事業高額Entity.getShotokuHantei_setaiinShikibetsuCode()));
        if (区分コード_1.equals(給付実績中間事業高額Entity.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(true);
        } else {
            合計全件一時Entity.setKyokaisoTaishoshaFlag(false);
        }
        合計全件一時Entity.setHojinKeigenTaishoFlag(給付実績中間事業高額Entity.isHokenshaHoyuKyufujissekiJohoSakujoFlag());
        合計全件一時Entity.setKogakuTaishoGaiFlag(false);
        合計全件一時Entity.setJidoShokanTaishoFlag(false);
        return 合計全件一時Entity;
    }

    private TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity get明細全件更新一時(TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity) {
        TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity 明細全件更新一時Entity = new TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity();
        明細全件更新一時Entity.setHihokenshaNo(給付実績中間事業高額Entity.getHiHokenshaNo());
        明細全件更新一時Entity.setServiceTeikyoYM(給付実績中間事業高額Entity.getServiceTeikyoYM());
        明細全件更新一時Entity.setJigyoshaNo(給付実績中間事業高額Entity.getJigyoshoNo());
        明細全件更新一時Entity.setServiceShuruiCode(給付実績中間事業高額Entity.getServiceSyuruiCode());
        明細全件更新一時Entity.setRirekiNo(1);
        明細全件更新一時Entity.setServiceHiyoGokeiGaku(給付実績中間事業高額Entity.getServiceHiyougakuGokei());
        明細全件更新一時Entity.setRiyoshaFutanGaku(給付実績中間事業高額Entity.getHokenRiyoshaFutangaku());
        明細全件更新一時Entity.setKogakuKyufuKonkyo(給付実績中間事業高額Entity.getBeikoKojinshotokuKubun());
        return 明細全件更新一時Entity;
    }

    private boolean get給付実績中間事業高額一時出力Flag(boolean is出力をしない, TyukannJigyoKogakuRelateEntity 結果Entity) {
        if (区分コード_3.equals(結果Entity.get給付実績中間事業高額Entity().getKyufuSakuseiKubunCode())
                || Decimal.ZERO.compareTo(結果Entity.get給付実績中間事業高額Entity().getSikyugaku()) == 0) {
            is出力をしない = true;
        }
        return is出力をしない;
    }

    private boolean get支給区分コード2存在(boolean is支給区分コード2存在, TyukannJigyoKogakuRelateEntity 結果Entity) {
        if (結果Entity.get事業審査決定全件Entity() != null
                && 区分コード_2.equals(結果Entity.get事業審査決定全件Entity().getShikyuKubunCode())) {
            is支給区分コード2存在 = true;
        }
        return is支給区分コード2存在;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private boolean getマッチFlag(boolean マッチFlag, TyukannJigyoKogakuRelateEntity 結果Entity) {
        if (結果Entity.get事業高額判定結果全件Entity() != null) {
            マッチFlag = true;
        }
        return マッチFlag;
    }

    private boolean get受取年月Flag(boolean 受取年月Flag, TyukannJigyoKogakuRelateEntity 結果Entity) {
        if (結果Entity.get事業高額合計全件Entity() != null
                && 結果Entity.get事業高額合計全件Entity().getTashoshaUketoriYM() != null) {
            受取年月Flag = true;
        }
        return 受取年月Flag;
    }

    private boolean get作成区分Flag_0(boolean 作成区分Flag_0, TyukannJigyoKogakuRelateEntity 結果Entity) {
        if (結果Entity.get事業高額判定結果全件Entity() != null
                && 区分コード_0.equals(結果Entity.get給付実績中間事業高額Entity().getDokujiSakuseiKubun())) {
            作成区分Flag_0 = true;
        }
        return 作成区分Flag_0;
    }

    private Decimal get高額支給額合計(TyukannJigyoKogakuRelateEntity 結果Entity, Decimal 高額支給額合計) {
        if (結果Entity.get事業高額合計全件Entity() == null || 結果Entity.get事業高額判定結果全件Entity() == null) {
            return 高額支給額合計;
        }
        Decimal kogakuShikyuGaku = 結果Entity.get事業高額合計全件Entity().getJigyoKogakuShikyuGaku() == null
                ? Decimal.ZERO : 結果Entity.get事業高額合計全件Entity().getJigyoKogakuShikyuGaku();
        if ((結果Entity.get事業高額判定結果全件Entity().getKetteiYMD() == null
                || 結果Entity.get事業高額判定結果全件Entity().getKetteiYMD().isEmpty())
                && Decimal.ZERO.compareTo(kogakuShikyuGaku) == 1) {
            高額支給額合計 = 高額支給額合計.add(結果Entity.get事業高額判定結果全件Entity().getShiharaiKingaku());
        } else {
            高額支給額合計 = 高額支給額合計.add(結果Entity.get事業高額合計全件Entity().getJigyoKogakuShikyuGaku() == null
                    ? Decimal.ZERO : 結果Entity.get事業高額合計全件Entity().getJigyoKogakuShikyuGaku());
        }
        return 高額支給額合計;
    }

    private Decimal get差額区分_高額支給額合計(TyukannJigyoKogakuRelateEntity 結果Entity, Decimal 高額支給額合計) {
        if (結果Entity.get事業高額合計全件Entity() == null || 結果Entity.get事業高額判定結果全件Entity() == null) {
            return 高額支給額合計;
        }
        Decimal kogakuShikyuGaku = 結果Entity.get事業高額合計全件Entity().getJigyoKogakuShikyuGaku() == null
                ? Decimal.ZERO : 結果Entity.get事業高額合計全件Entity().getJigyoKogakuShikyuGaku();
        高額支給額合計 = 高額支給額合計.add(kogakuShikyuGaku).
                add(結果Entity.get事業高額合計全件Entity().getJigyoKogakuShikyuGaku() == null
                        ? Decimal.ZERO : 結果Entity.get事業高額合計全件Entity().getJigyoKogakuShikyuGaku());
        return 高額支給額合計;
    }

}
