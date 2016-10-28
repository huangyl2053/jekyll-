/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110020.JukyushaIdoRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.HyojunFutanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdoTblTmpEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.JushochitokureiInfoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.KyotakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.PSMInfoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.ShafukugemmenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.TokuteiNyusyoshaInfoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 異動一時１テーブルの作成を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class InsIdomaiDataTempProcess extends BatchProcessBase<IdouTblEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select異動一時");
    private static final RString 異動一時2_TABLE_NAME = new RString("IdouTemp2");
    private static final RString 支払方法変更 = new RString("支払方法変更");
    private static final RString 給付額減額 = new RString("給付額減額");
    private static final RString SPLIT = new RString(",");
    private static final RString STR_01 = new RString("01");
    private static final RString STR_1 = new RString("1");
    private static final RString STR_2 = new RString("2");
    private static final RString STR_3 = new RString("3");
    private static final RString エラーあり = new RString("1");
    private static final RString エラーなし = new RString("0");
    private static final int ORDER_0 = 0;
    private static final int ORDER_1 = 1;
    private static final int ORDER_2 = 2;
    private static final int ORDER_3 = 3;
    private static final int ORDER_4 = 4;
    private static final int ORDER_5 = 5;
    private static final int ORDER_6 = 6;
    private static final int ORDER_7 = 7;
    private static final int ORDER_8 = 8;
    private static final int ORDER_9 = 9;
    private static final int ORDER_10 = 10;
    private static final int ORDER_11 = 11;
    private static final int ORDER_12 = 12;
    private static final int ORDER_13 = 13;
    private static final int ORDER_14 = 14;
    private static final Code コート_0 = new Code("0");
    private static final Code コート_1 = new Code("1");
    private static final Code コート_01 = new Code("01");
    private static final Code コート_2 = new Code("2");
    private static final Code コート_3 = new Code("3");
    private static final Code コート_4 = new Code("4");
    private static final Code コート_6 = new Code("6");
    private static final Code コート_12 = new Code("12");
    private static final Code コート_13 = new Code("13");
    private static final Code コート_14 = new Code("14");
    private static final Code コート_23 = new Code("23");
    private static final Code コート_32 = new Code("32");
    private JukyushaIdoRenrakuhyoOutProcessParameter processParameter;
    private List<IdouTblEntity> 異動一時List;
    private Map<FlexibleDate, IdoTblTmpEntity> 異動一時Map;
    private List<HihokenshaNo> エラー異動No;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時2tableWriter;

    @Override
    protected void initialize() {
        異動一時List = new ArrayList<>();
        エラー異動No = new ArrayList<>();
        異動一時Map = new HashMap<>();
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        異動一時2tableWriter
                = new BatchEntityCreatedTempTableWriter(異動一時2_TABLE_NAME, IdoTblTmpEntity.class);
    }

    @Override
    protected void process(IdouTblEntity entity) {
        if (エラーあり.equals(entity.getエラーフラグ()) || !エラー異動No.contains(entity.get被保険者番号())) {
            エラー異動No.add(entity.get被保険者番号());
            IdoTblTmpEntity errorEntity = new IdoTblTmpEntity();
            errorEntity.set被保険者番号(entity.get被保険者番号());
            errorEntity.setエラーフラグ(エラーあり);
            異動一時2tableWriter.insert(errorEntity);
            return;
        }
        異動一時List.add(entity);
        if (entity.get連番() != entity.get被保険者番号Max連番()) {
            return;
        }
        FlexibleYearMonth 処理年月 = new FlexibleYearMonth(processParameter.get処理年月().toDateString());
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = get受給者台帳();
        受給者台帳処理(受給者台帳List, 処理年月);
        List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List = get二次予防();
        二次予防処理(二次予防List, 処理年月);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = get被保険者台帳();
        List<KyotakuEntity> 居宅計画List = get居宅計画();
        List<HyojunFutanEntity> 標準負担List = get標準負担();
        List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List = get利用者負担();
        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = get支払方法(支払方法変更);
        List<DbT4021ShiharaiHohoHenkoEntity> 給付額減額List = get支払方法(給付額減額);
        List<TokuteiNyusyoshaInfoEntity> 特定入所者List = get特定入所者();
        List<ShafukugemmenEntity> 社福減免List = get社福減免();
        List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List = get総合事業対象者();
        List<JushochitokureiInfoEntity> 住所地特例List = get住所地特例();
        PSMInfoEntity 宛名情報 = get宛名();
        List<DbT7124KokiKoreishaInfoEntity> 後期高齢者情報List = get後期高齢者情報();
        List<DbT7123KokuhoShikakuInfoEntity> 国保資格情報List = get国保資格();
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List = get二割負担();
        異動一時List.clear();
        異動一時Map.clear();
    }

    private void 受給者台帳処理(List<DbT4001JukyushaDaichoEntity> 受給者台帳List, FlexibleYearMonth 処理年月) {
        boolean 無効データFlag = false;
        異動一時2By受給者台帳パターン1Check(受給者台帳List, 処理年月);
        異動一時2By受給者台帳パターン2Check(受給者台帳List, 処理年月);
        異動一時2By受給者台帳パターン3Check(受給者台帳List, 処理年月, 無効データFlag);
        異動一時2By受給者台帳パターン4Check(受給者台帳List, 処理年月, 無効データFlag);
        異動一時2By受給者台帳パターン5Check(受給者台帳List, 処理年月, 無効データFlag);
    }

    private void 二次予防処理(List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List, FlexibleYearMonth 処理年月) {
        異動一時2By二次予防パターン1Check(二次予防List, 処理年月);
        異動一時2By二次予防パターン2Check(二次予防List, 処理年月);
    }

    private void 異動一時2By受給者台帳パターン1Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (コート_1.equals(受給者台帳.getYukoMukoKubun()) && isDateEmpty(受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                continue;
            }
            if (コート_1.equals(受給者台帳.getYukoMukoKubun())
                    && isBeforeYearMonth(受給者台帳.getNinteiYukoKikanKaishiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
                FlexibleDate 異動年月日 = get月初(受給者台帳.getNinteiYukoKikanKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    異動年月日 = 異動年月日.plusDay(ORDER_1);
                }
                set異動一時2By受給者台帳パターン1(insertEntity, 受給者台帳, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By受給者台帳パターン2Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List, FlexibleYearMonth 処理年月) {
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (コート_0.equals(受給者台帳.getYukoMukoKubun())
                    && コート_4.equals(受給者台帳.getJukyuShinseiJiyu())
                    && isBeforeYearMonth(受給者台帳.getJukyuShinseiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(受給者台帳.getNinteiYukoKikanKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By受給者台帳パターン2(insertEntity, 受給者台帳, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By受給者台帳パターン3Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            FlexibleYearMonth 処理年月, boolean 無効データFlag) {
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (無効データFlag) {
                break;
            }
            if (!コート_2.equals(受給者台帳.getYukoMukoKubun())) {
                continue;
            }
            if (!isBeforeYearMonth(受給者台帳.getNinteiYMD(), 処理年月)) {
                continue;
            }
            if (!コート_32.equals(受給者台帳.getDataKubun())) {
                continue;
            }
            if (前後履歴の有効Check(受給者台帳List, 受給者台帳)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = 受給者台帳.getNinteiYMD();
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By受給者台帳パターン3(insertEntity, 受給者台帳, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By受給者台帳パターン4Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            FlexibleYearMonth 処理年月, boolean 無効データFlag) {
        if (無効データFlag) {
            return;
        }
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (コート_32.equals(受給者台帳.getDataKubun())
                    && コート_01.equals(受給者台帳.getYokaigoJotaiKubunCode())) {
                return;
            }
        }
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (無効データFlag) {
                break;
            }
            if (!コート_2.equals(受給者台帳.getYukoMukoKubun())) {
                continue;
            }
            if (!isBeforeYearMonth(受給者台帳.getNinteiYMD(), 処理年月)) {
                continue;
            }
            if (!コート_01.equals(受給者台帳.getYokaigoJotaiKubunCode())) {
                continue;
            }
            if (前後履歴の有効Check(受給者台帳List, 受給者台帳)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = 受給者台帳.getNinteiYMD();
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By受給者台帳パターン3(insertEntity, 受給者台帳, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By受給者台帳パターン5Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            FlexibleYearMonth 処理年月, boolean 無効データFlag) {
        if (無効データFlag) {
            return;
        }
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (無効データFlag) {
                break;
            }
            if (!コート_2.equals(受給者台帳.getYukoMukoKubun())) {
                continue;
            }
            if (!isBeforeYearMonth(受給者台帳.getSoshitsuYMD(), 処理年月)) {
                continue;
            }
            if (!コート_14.equals(受給者台帳.getDataKubun())) {
                continue;
            }
            if (前後履歴の有効Check(受給者台帳List, 受給者台帳)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = 受給者台帳.getSoshitsuYMD();
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By受給者台帳パターン3(insertEntity, 受給者台帳, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private boolean 前後履歴の有効Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List, DbT4001JukyushaDaichoEntity 受給者台帳) {
        DbT4001JukyushaDaichoEntity 前履歴 = get前履歴の有効データ(受給者台帳List, 受給者台帳);
        if (!コート_12.equals(前履歴.getYokaigoJotaiKubunCode()) && !コート_13.equals(前履歴.getYokaigoJotaiKubunCode())) {
            return false;
        }
        if (isBeforeDate(前履歴.getNinteiYukoKikanKaishiYMD(), 受給者台帳.getNinteiYMD())
                && isBeforeDate(受給者台帳.getNinteiYMD(), 前履歴.getNinteiYukoKikanShuryoYMD())) {
            return true;
        }
        DbT4001JukyushaDaichoEntity 後履歴 = get後履歴の有効データ(受給者台帳List, 受給者台帳);
        if (isBeforeDate(後履歴.getNinteiYukoKikanKaishiYMD(), 受給者台帳.getNinteiYMD())
                && isBeforeDate(受給者台帳.getNinteiYMD(), 後履歴.getNinteiYukoKikanShuryoYMD())) {
            return true;
        }
        return false;
    }

    private void set異動一時2By受給者台帳パターン1(IdoTblTmpEntity insertEntity,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(受給者台帳.getHihokenshaNo());
        insertEntity.set異動年月日(異動年月日);
        if (コート_1.equals(受給者台帳.getJukyuShinseiJiyu())
                || コート_3.equals(受給者台帳.getJukyuShinseiJiyu())
                || コート_6.equals(受給者台帳.getJukyuShinseiJiyu())) {
            insertEntity.set申請種別コード(STR_1);
        } else if (コート_2.equals(受給者台帳.getJukyuShinseiJiyu())) {
            insertEntity.set申請種別コード(STR_2);
        } else if (コート_4.equals(受給者台帳.getJukyuShinseiJiyu())) {
            insertEntity.set申請種別コード(STR_3);
        }
        if (コート_4.equals(受給者台帳.getJukyuShinseiJiyu())) {
            insertEntity.set変更申請中区分コード(STR_3);
        } else {
            insertEntity.set変更申請中区分コード(STR_1);
        }
        if (受給者台帳.getKyuSochishaFlag()) {
            insertEntity.setみなし要介護状態区分コード(STR_2);
        } else if (コート_23.equals(受給者台帳.getDataKubun())) {
            insertEntity.setみなし要介護状態区分コード(STR_3);
        } else {
            insertEntity.setみなし要介護状態区分コード(STR_1);
        }
        Code 要介護状態区分コード = 受給者台帳.getYokaigoJotaiKubunCode();
        if (要介護状態区分コード != null) {
            insertEntity.set要介護状態区分コード(要介護状態区分コード.getColumnValue());
        }
        insertEntity.set認定有効期間開始年月日(受給者台帳.getNinteiYukoKikanKaishiYMD());
        //TODO
        insertEntity.set認定有効期間終了年月日(受給者台帳.getNinteiYukoKikanShuryoYMD());
        Decimal 訪問通所サービス支給限度基準額 = 受給者台帳.getShikyuGendoTanisu();
        if (訪問通所サービス支給限度基準額 != null) {
            insertEntity.set訪問通所サービス支給限度基準額(訪問通所サービス支給限度基準額.intValue());
        }
        insertEntity.set訪問通所サービス上限管理適用期間開始年月日(受給者台帳.getShikyuGendoKaishiYMD());
        FlexibleDate 支給限度有効開始年月日 = 受給者台帳.getShikyuGendoShuryoYMD();
        if (支給限度有効開始年月日 != null) {
            insertEntity.set訪問通所サービス上限管理適用期間終了年月日(new RString(支給限度有効開始年月日.toString()));
        }
        insertEntity.set短期入所サービス支給限度基準額(new RString(受給者台帳.getTankiSikyuGendoNissu()));
        insertEntity.set短期入所サービス上限管理適用期間開始年月日(受給者台帳.getTankiShikyuGendoKaishiYMD());
        insertEntity.set短期入所サービス上限管理適用期間終了年月日(受給者台帳.getTankiShikyuGendoShuryoYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By受給者台帳パターン2(IdoTblTmpEntity insertEntity,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(受給者台帳.getHihokenshaNo());
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set変更申請中区分コード(STR_2);
        insertEntity.set申請年月日(受給者台帳.getJukyuShinseiYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By受給者台帳パターン3(IdoTblTmpEntity insertEntity,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(受給者台帳.getHihokenshaNo());
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set変更申請中区分コード(STR_3);
        insertEntity.set要介護状態区分コード(STR_01);
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By二次予防パターン1Check(List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List,
            FlexibleYearMonth 処理年月) {
        for (DbT3100NijiYoboJigyoTaishoshaEntity 二次予防 : 二次予防List) {
            if (isBeforeYearMonth(二次予防.getTekiyoKaishiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(二次予防.getTekiyoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By二次予防パターン1(insertEntity, 二次予防, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By二次予防パターン2Check(List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List,
            FlexibleYearMonth 処理年月) {
        for (DbT3100NijiYoboJigyoTaishoshaEntity 二次予防 : 二次予防List) {
            if (isDateEmpty(二次予防.getTekiyoShuryoYMD())) {
                continue;
            }
            if (isBeforeYearMonth(二次予防.getTekiyoShuryoYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(二次予防.getTekiyoShuryoYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By二次予防パターン2(insertEntity, 二次予防, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By二次予防パターン1(IdoTblTmpEntity insertEntity,
            DbT3100NijiYoboJigyoTaishoshaEntity 二次予防, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(二次予防.getHihokenshaNo());
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set二次予防事業区分コード(STR_2);
        insertEntity.set二次予防事業有効期間開始年月日(二次予防.getTekiyoKaishiYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By二次予防パターン2(IdoTblTmpEntity insertEntity,
            DbT3100NijiYoboJigyoTaishoshaEntity 二次予防, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(二次予防.getHihokenshaNo());
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set二次予防事業区分コード(STR_2);
        insertEntity.set二次予防事業有効期間開始年月日(二次予防.getTekiyoKaishiYMD());
        insertEntity.set二次予防事業有効期間終了年月日(二次予防.getTekiyoShuryoYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    private List<DbT4001JukyushaDaichoEntity> get受給者台帳() {
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT4001JukyushaDaichoEntity 受給者台帳 = get受給者台帳Entity(異動一時.get受給者台帳());
            if (受給者台帳 == null) {
                continue;
            }
            受給者台帳List.add(受給者台帳);
        }
        return 受給者台帳List;
    }

    private List<DbT1001HihokenshaDaichoEntity> get被保険者台帳() {
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT1001HihokenshaDaichoEntity 被保険者台帳 = get被保険者台帳Entity(異動一時.get被保険者台帳管理());
            if (被保険者台帳 == null) {
                continue;
            }
            被保険者台帳List.add(被保険者台帳);
        }
        return 被保険者台帳List;
    }

    private List<KyotakuEntity> get居宅計画() {
        List<KyotakuEntity> 居宅計画List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            KyotakuEntity 居宅計画 = get居宅計画entity(異動一時.get居宅計画());
            if (居宅計画 == null) {
                continue;
            }
            居宅計画List.add(居宅計画);
        }
        return 居宅計画List;
    }

    private List<HyojunFutanEntity> get標準負担() {
        List<HyojunFutanEntity> 標準負担List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            HyojunFutanEntity 標準負担 = get標準負担entity(異動一時.get標準負担());
            if (標準負担 == null) {
                continue;
            }
            標準負担List.add(標準負担);
        }
        return 標準負担List;
    }

    private List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> get利用者負担() {
        List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担 = get利用者負担entity(異動一時.get利用者負担額減額());
            if (利用者負担 == null) {
                continue;
            }
            利用者負担List.add(利用者負担);
        }
        return 利用者負担List;
    }

    private List<DbT4021ShiharaiHohoHenkoEntity> get支払方法(RString flag) {
        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT4021ShiharaiHohoHenkoEntity 支払方法 = null;
            if (支払方法変更.equals(flag)) {
                支払方法 = get支払方法変更entity(異動一時.get支払方法変更_支払方法());
            } else if (給付額減額.equals(flag)) {
                支払方法 = get支払方法変更entity(異動一時.get支払方法変更_給付費減額());
            }
            if (支払方法 == null) {
                continue;
            }
            支払方法List.add(支払方法);
        }
        return 支払方法List;
    }

    private List<TokuteiNyusyoshaInfoEntity> get特定入所者() {
        List<TokuteiNyusyoshaInfoEntity> 特定入所者List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            TokuteiNyusyoshaInfoEntity 特定入所者 = get特定入所者entity(異動一時.get特定入所者());
            if (特定入所者 == null) {
                continue;
            }
            特定入所者List.add(特定入所者);
        }
        return 特定入所者List;
    }

    private List<ShafukugemmenEntity> get社福減免() {
        List<ShafukugemmenEntity> 社福減免List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            ShafukugemmenEntity 社福減免 = get社福減免entity(異動一時.get社福減免());
            if (社福減免 == null) {
                continue;
            }
            社福減免List.add(社福減免);
        }
        return 社福減免List;
    }

    private List<DbT3105SogoJigyoTaishoshaEntity> get総合事業対象者() {
        List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 = get総合事業対象者entity(異動一時.get総合事業対象者());
            if (総合事業対象者 == null) {
                continue;
            }
            総合事業対象者List.add(総合事業対象者);
        }
        return 総合事業対象者List;
    }

    private PSMInfoEntity get宛名() {
        PSMInfoEntity entity = new PSMInfoEntity();
        RString 宛名Info = 異動一時List.get(ORDER_0).get宛名();
        if (RString.isNullOrEmpty(宛名Info)) {
            return entity;
        }
        List<RString> 宛名InfoList = 宛名Info.split(SPLIT.toString());
        entity.setカナ名称(new AtenaKanaMeisho(宛名InfoList.get(ORDER_0)));
        entity.set名称(new AtenaMeisho(宛名InfoList.get(ORDER_1)));
        entity.set生年月日(new FlexibleDate(宛名InfoList.get(ORDER_2)));
        entity.set性別(宛名InfoList.get(ORDER_3));
        return entity;
    }

    private List<JushochitokureiInfoEntity> get住所地特例() {
        List<JushochitokureiInfoEntity> 住所地特例List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            JushochitokureiInfoEntity 住所地特例 = get住所地特例entity(異動一時.get住所地特例());
            if (住所地特例 == null) {
                continue;
            }
            住所地特例List.add(住所地特例);
        }
        return 住所地特例List;
    }

    private List<DbT7124KokiKoreishaInfoEntity> get後期高齢者情報() {
        List<DbT7124KokiKoreishaInfoEntity> 後期高齢者List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT7124KokiKoreishaInfoEntity 後期高齢者 = get後期高齢者entity(異動一時.get後期高齢者情報());
            if (後期高齢者 == null) {
                continue;
            }
            後期高齢者List.add(後期高齢者);
        }
        return 後期高齢者List;
    }

    private List<DbT7123KokuhoShikakuInfoEntity> get国保資格() {
        List<DbT7123KokuhoShikakuInfoEntity> 国保資格List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT7123KokuhoShikakuInfoEntity 国保資格 = get国保資格entity(異動一時.get国保資格情報());
            if (国保資格 == null) {
                continue;
            }
            国保資格List.add(国保資格);
        }
        return 国保資格List;
    }

    private List<DbT3100NijiYoboJigyoTaishoshaEntity> get二次予防() {
        List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT3100NijiYoboJigyoTaishoshaEntity 二次予防 = get二次予防entity(異動一時.get二次予防事業対象者());
            if (二次予防 == null) {
                continue;
            }
            二次予防List.add(二次予防);
        }
        return 二次予防List;
    }

    private List<DbT3114RiyoshaFutanWariaiMeisaiEntity> get二割負担() {
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT3114RiyoshaFutanWariaiMeisaiEntity 二割負担 = get二割負担entity(異動一時.get利用者負担割合明細());
            if (二割負担 == null) {
                continue;
            }
            二割負担List.add(二割負担);
        }
        return 二割負担List;
    }

    private DbT4001JukyushaDaichoEntity get受給者台帳Entity(RString 受給者台帳) {
        if (RString.isNullOrEmpty(受給者台帳)) {
            return null;
        }
        DbT4001JukyushaDaichoEntity entity = new DbT4001JukyushaDaichoEntity();
        List<RString> 受給者台帳Info = 受給者台帳.split(SPLIT.toString());
        entity.setHihokenshaNo(new HihokenshaNo(受給者台帳Info.get(ORDER_0)));
        entity.setYokaigoJotaiKubunCode(new Code(受給者台帳Info.get(ORDER_1)));
        entity.setJukyuShinseiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_2)));
        entity.setNinteiYukoKikanKaishiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_3)));
        entity.setNinteiYukoKikanShuryoYMD(new FlexibleDate(受給者台帳Info.get(ORDER_4)));
        entity.setMinashiCode(new Code(受給者台帳Info.get(ORDER_5)));
        if (!RString.isNullOrEmpty(受給者台帳Info.get(ORDER_6))) {
            entity.setShikyuGendoTanisu(new Decimal(受給者台帳Info.get(ORDER_6).toString()));
        }
        entity.setShikyuGendoKaishiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_7)));
        entity.setShikyuGendoShuryoYMD(new FlexibleDate(受給者台帳Info.get(ORDER_8)));
        if (!RString.isNullOrEmpty(受給者台帳Info.get(ORDER_9))) {
            entity.setTankiSikyuGendoNissu(Integer.parseInt(受給者台帳Info.get(ORDER_9).toString()));
        }
        entity.setTankiShikyuGendoKaishiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_10)));
        entity.setTankiShikyuGendoShuryoYMD(new FlexibleDate(受給者台帳Info.get(ORDER_11)));
        entity.setYukoMukoKubun(new Code(受給者台帳Info.get(ORDER_12)));
        entity.setJukyuShinseiJiyu(new Code(受給者台帳Info.get(ORDER_13)));
        entity.setJukyuShinseiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_14)));
        return entity;
    }

    private DbT1001HihokenshaDaichoEntity get被保険者台帳Entity(RString 被保険者台帳) {
        if (RString.isNullOrEmpty(被保険者台帳)) {
            return null;
        }
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        List<RString> 被保険者台帳Info = 被保険者台帳.split(SPLIT.toString());
        entity.setShikakuShutokuYMD(new FlexibleDate(被保険者台帳Info.get(ORDER_0)));
        entity.setShikakuSoshitsuYMD(new FlexibleDate(被保険者台帳Info.get(ORDER_1)));
        entity.setJushochiTokureiFlag(被保険者台帳Info.get(ORDER_2));
        return entity;
    }

    private KyotakuEntity get居宅計画entity(RString 居宅サービス計画) {
        if (RString.isNullOrEmpty(居宅サービス計画)) {
            return null;
        }
        KyotakuEntity entity = new KyotakuEntity();
        List<RString> 居宅計画Info = 居宅サービス計画.split(SPLIT.toString());
        entity.set適用開始日(new FlexibleDate(居宅計画Info.get(ORDER_0)));
        entity.set計画事業者番号(new JigyoshaNo(居宅計画Info.get(ORDER_1)));
        entity.set居宅サービス計画作成区分コード(居宅計画Info.get(ORDER_2));
        entity.setサービス種類コード(居宅計画Info.get(ORDER_3));
        entity.set有効終了日(new FlexibleDate(居宅計画Info.get(ORDER_4)));
        return entity;
    }

    private HyojunFutanEntity get標準負担entity(RString 標準負担) {
        if (RString.isNullOrEmpty(標準負担)) {
            return null;
        }
        HyojunFutanEntity entity = new HyojunFutanEntity();
        List<RString> 居宅計画Info = 標準負担.split(SPLIT.toString());
        entity.set適用開始日(new FlexibleDate(居宅計画Info.get(ORDER_0)));
        entity.set適用終了日(new FlexibleDate(居宅計画Info.get(ORDER_1)));
        entity.set申請日(new FlexibleDate(居宅計画Info.get(ORDER_2)));
        entity.set決定年月日(new FlexibleDate(居宅計画Info.get(ORDER_3)));
        return entity;
    }

    private DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity get利用者負担entity(RString 利用者負担) {
        if (RString.isNullOrEmpty(利用者負担)) {
            return null;
        }
        DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity entity = new DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity();
        List<RString> 利用者負担Info = 利用者負担.split(SPLIT.toString());
        entity.setTekiyoKaishiYMD(new FlexibleDate(利用者負担Info.get(ORDER_0)));
        entity.setTekiyoShuryoYMD(new FlexibleDate(利用者負担Info.get(ORDER_1)));
        return entity;
    }

    private DbT4021ShiharaiHohoHenkoEntity get支払方法変更entity(RString 支払方法変更) {
        if (RString.isNullOrEmpty(支払方法変更)) {
            return null;
        }
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        List<RString> 支払方法変更Info = 支払方法変更.split(SPLIT.toString());
        entity.setTekiyoKaishiYMD(new FlexibleDate(支払方法変更Info.get(ORDER_0)));
        entity.setTekiyoShuryoYMD(new FlexibleDate(支払方法変更Info.get(ORDER_1)));
        return entity;
    }

    private TokuteiNyusyoshaInfoEntity get特定入所者entity(RString 特定入所者) {
        if (RString.isNullOrEmpty(特定入所者)) {
            return null;
        }
        TokuteiNyusyoshaInfoEntity entity = new TokuteiNyusyoshaInfoEntity();
        List<RString> 特定入所者Info = 特定入所者.split(SPLIT.toString());
        entity.set減免_減額種類(特定入所者Info.get(ORDER_0));
        entity.set適用開始日(new FlexibleDate(特定入所者Info.get(ORDER_1)));
        entity.set適用終了日(new FlexibleDate(特定入所者Info.get(ORDER_2)));
        entity.set食費負担限度額(new Decimal(特定入所者Info.get(ORDER_3).toString()));
        entity.setユニット型個室(new Decimal(特定入所者Info.get(ORDER_4).toString()));
        entity.setユニット型準個室(new Decimal(特定入所者Info.get(ORDER_5).toString()));
        entity.set従来型個室_特養等(new Decimal(特定入所者Info.get(ORDER_6).toString()));
        entity.set従来型個室_老健_療養等(new Decimal(特定入所者Info.get(ORDER_7).toString()));
        entity.set多床室(new Decimal(特定入所者Info.get(ORDER_8).toString()));
        entity.set旧措置者区分(特定入所者Info.get(ORDER_9));
        entity.set決定区分(特定入所者Info.get(ORDER_10));
        entity.set申請日(new FlexibleDate(特定入所者Info.get(ORDER_11)));
        return entity;
    }

    private ShafukugemmenEntity get社福減免entity(RString 社福減免) {
        if (RString.isNullOrEmpty(社福減免)) {
            return null;
        }
        ShafukugemmenEntity entity = new ShafukugemmenEntity();
        List<RString> 社福減免Info = 社福減免.split(SPLIT.toString());
        entity.set適用開始日(new FlexibleDate(社福減免Info.get(ORDER_0)));
        entity.set適用終了日(new FlexibleDate(社福減免Info.get(ORDER_1)));
        return entity;
    }

    private DbT3105SogoJigyoTaishoshaEntity get総合事業対象者entity(RString 総合事業対象者) {
        if (RString.isNullOrEmpty(総合事業対象者)) {
            return null;
        }
        DbT3105SogoJigyoTaishoshaEntity entity = new DbT3105SogoJigyoTaishoshaEntity();
        List<RString> 総合事業対象者Info = 総合事業対象者.split(SPLIT.toString());
        entity.setTekiyoKaishiYMD(new FlexibleDate(総合事業対象者Info.get(ORDER_0)));
        return entity;
    }

    private JushochitokureiInfoEntity get住所地特例entity(RString 住所地特例) {
        if (RString.isNullOrEmpty(住所地特例)) {
            return null;
        }
        JushochitokureiInfoEntity entity = new JushochitokureiInfoEntity();
        List<RString> 住所地特例Info = 住所地特例.split(SPLIT.toString());
        entity.set住所地特例適用開始日(new FlexibleDate(住所地特例Info.get(ORDER_0)));
        entity.set住所地特例適用終了日(new FlexibleDate(住所地特例Info.get(ORDER_1)));
        return entity;
    }

    private DbT7124KokiKoreishaInfoEntity get後期高齢者entity(RString 後期高齢者) {
        if (RString.isNullOrEmpty(後期高齢者)) {
            return null;
        }
        DbT7124KokiKoreishaInfoEntity entity = new DbT7124KokiKoreishaInfoEntity();
        List<RString> 後期高齢者Info = 後期高齢者.split(SPLIT.toString());
        entity.setKokiHokenshaNoCity(後期高齢者Info.get(ORDER_0));
        entity.setKokikoreiHihokenshaNo(後期高齢者Info.get(ORDER_1));
        return entity;
    }

    private DbT7123KokuhoShikakuInfoEntity get国保資格entity(RString 国保資格) {
        if (RString.isNullOrEmpty(国保資格)) {
            return null;
        }
        DbT7123KokuhoShikakuInfoEntity entity = new DbT7123KokuhoShikakuInfoEntity();
        List<RString> 国保資格Info = 国保資格.split(SPLIT.toString());
        entity.setKokuhoHokenshaNo(国保資格Info.get(ORDER_0));
        entity.setKokuhoKojinNo(国保資格Info.get(ORDER_1));
        return entity;
    }

    private DbT3100NijiYoboJigyoTaishoshaEntity get二次予防entity(RString 二次予防) {
        if (RString.isNullOrEmpty(二次予防)) {
            return null;
        }
        DbT3100NijiYoboJigyoTaishoshaEntity entity = new DbT3100NijiYoboJigyoTaishoshaEntity();
        List<RString> 二次予防Info = 二次予防.split(SPLIT.toString());
        entity.setTekiyoKaishiYMD(new FlexibleDate(二次予防Info.get(ORDER_0)));
        entity.setTekiyoShuryoYMD(new FlexibleDate(二次予防Info.get(ORDER_1)));
        return entity;
    }

    private DbT3114RiyoshaFutanWariaiMeisaiEntity get二割負担entity(RString 二割負担) {
        if (RString.isNullOrEmpty(二割負担)) {
            return null;
        }
        DbT3114RiyoshaFutanWariaiMeisaiEntity entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
        List<RString> 二割負担Info = 二割負担.split(SPLIT.toString());
        entity.setYukoKaishiYMD(new FlexibleDate(二割負担Info.get(ORDER_0)));
        entity.setYukoShuryoYMD(new FlexibleDate(二割負担Info.get(ORDER_1)));
        entity.setHihokenshaNo(new HihokenshaNo(二割負担Info.get(ORDER_2)));
        return entity;
    }

    private boolean isDateEmpty(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isBeforeDate(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date1) || isDateEmpty(date2)) {
            return false;
        }
        return date1.isBefore(date2);
    }

    private boolean isBeforeYearMonth(FlexibleDate date1, FlexibleYearMonth date2) {
        if (date1 == null) {
            return false;
        }
        FlexibleYearMonth yearMonth1 = date1.getYearMonth();
        if (isYearMonthEmpty(yearMonth1) || isYearMonthEmpty(date2)) {
            return false;
        }
        return yearMonth1.isBefore(date2);
    }

    private boolean isYearMonthEmpty(FlexibleYearMonth date) {
        if (date == null || date.isEmpty()) {
            return true;
        }
        return false;
    }

    private FlexibleDate get月初(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        return new FlexibleDate(date.getYearMonth().toDateString().concat(STR_01));
    }

    private DbT4001JukyushaDaichoEntity get前履歴の有効データ(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            DbT4001JukyushaDaichoEntity 受給者台帳) {
        List<DbT4001JukyushaDaichoEntity> 小さいList = new ArrayList<>();
        for (DbT4001JukyushaDaichoEntity 受給者台帳Entity : 受給者台帳List) {
            if (!コート_1.equals(受給者台帳.getYukoMukoKubun())) {
                continue;
            }
            if (受給者台帳Entity.getRirekiNo().compareTo(受給者台帳.getRirekiNo()) < 0) {
                小さいList.add(受給者台帳Entity);
            }
        }
        sort受給者台帳List(小さいList);
        return 小さいList.get(ORDER_0);
    }

    private DbT4001JukyushaDaichoEntity get後履歴の有効データ(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            DbT4001JukyushaDaichoEntity 受給者台帳) {
        List<DbT4001JukyushaDaichoEntity> 大きいList = new ArrayList<>();
        for (DbT4001JukyushaDaichoEntity 受給者台帳Entity : 受給者台帳List) {
            if (!コート_1.equals(受給者台帳.getYukoMukoKubun())) {
                continue;
            }
            if (受給者台帳.getRirekiNo().compareTo(受給者台帳Entity.getRirekiNo()) < 0) {
                大きいList.add(受給者台帳Entity);
            }
        }
        sort受給者台帳List(大きいList);
        return 大きいList.get(大きいList.size() - ORDER_1);
    }

    private static void sort受給者台帳List(List<DbT4001JukyushaDaichoEntity> 受給者台帳List) {
        Collections.sort(受給者台帳List, new Comparator<DbT4001JukyushaDaichoEntity>() {
            @Override
            public int compare(DbT4001JukyushaDaichoEntity o1, DbT4001JukyushaDaichoEntity o2) {
                return o1.getRirekiNo().compareTo(o2.getRirekiNo());
            }
        });
    }
}
