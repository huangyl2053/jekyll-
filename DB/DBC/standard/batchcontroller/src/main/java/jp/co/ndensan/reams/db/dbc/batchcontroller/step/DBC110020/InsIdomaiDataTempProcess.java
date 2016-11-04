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
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private static final RString STR_02 = new RString("02");
    private static final RString STR_2 = new RString("2");
    private static final RString STR_03 = new RString("03");
    private static final RString STR_3 = new RString("3");
    private static final RString STR_4 = new RString("4");
    private static final RString STR_06 = new RString("06");
    private static final RString STR_12 = new RString("12");
    private static final RString STR_13 = new RString("13");
    private static final RString STR_21 = new RString("21");
    private static final RString STR_22 = new RString("22");
    private static final RString STR_23 = new RString("23");
    private static final RString STR_24 = new RString("24");
    private static final RString STR_25 = new RString("25");
    private static final RString STR_99 = new RString("99");
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
    private static final Code コート_5 = new Code("5");
    private static final Code コート_6 = new Code("6");
    private static final Code コート_12 = new Code("12");
    private static final Code コート_13 = new Code("13");
    private static final Code コート_14 = new Code("14");
    private static final Code コート_23 = new Code("23");
    private static final Code コート_32 = new Code("32");
    private static final int 履歴番号 = 0000;
    private static final RString 資格取得事由 = new RString("11");
    private static final RString 星 = new RString("*");
    private JukyushaIdoRenrakuhyoOutProcessParameter processParameter;
    private List<IdouTblEntity> 異動一時List;
    private Map<FlexibleDate, IdoTblTmpEntity> 異動一時Map;
    private List<HihokenshaNo> エラー異動No;
    private HihokenshaNo 被保険者番号;
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
        if (エラーあり.equals(entity.getエラーフラグ()) && !エラー異動No.contains(entity.get被保険者番号())) {
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
        被保険者番号 = entity.get被保険者番号();
        FlexibleYearMonth 処理年月 = new FlexibleYearMonth(processParameter.get処理年月().toDateString());
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = get受給者台帳();
        List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List = get総合事業対象者();
        List<KyotakuEntity> 居宅計画List = get居宅計画();
        総合事業対象者適用開始年月日設定(総合事業対象者List, 居宅計画List);
        受給者台帳処理(受給者台帳List, 処理年月, 総合事業対象者List);
        List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List = get二次予防();
        二次予防処理(二次予防List, 処理年月);
        総合事業対象者処理(受給者台帳List, 総合事業対象者List, 処理年月);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = get被保険者台帳();
        被保険者台帳(被保険者台帳List, 処理年月);
        居宅計画処理(居宅計画List, 処理年月);
        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = get支払方法(支払方法変更);
        支払方法変更処理(支払方法変更List, 処理年月);
        List<DbT4021ShiharaiHohoHenkoEntity> 給付額減額List = get支払方法(給付額減額);
        給付額減額処理(給付額減額List, 処理年月);
        List<HyojunFutanEntity> 標準負担List = get標準負担();
        標準負担処理(標準負担List, 処理年月);
        List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List = get利用者負担();
        利用者負担処理(利用者負担List, 処理年月);
        List<TokuteiNyusyoshaInfoEntity> 特定入所者List = get特定入所者();
        特定入所者処理(特定入所者List, 処理年月);
        List<ShafukugemmenEntity> 社福減免List = get社福減免();
        社福減免処理(社福減免List, 処理年月);
        List<JushochitokureiInfoEntity> 住所地特例List = get住所地特例();
        住所地特例(住所地特例List, 処理年月);
        PSMInfoEntity 宛名情報 = get宛名();
//        List<DbT7124KokiKoreishaInfoEntity> 後期高齢者情報List = get後期高齢者情報();
//        List<DbT7123KokuhoShikakuInfoEntity> 国保資格情報List = get国保資格();
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List = get二割負担();
        負担割合処理(二割負担List, 処理年月);
        List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List = get生活保護受給者();
        生活保護受給者まとめる(生活保護受給者List);
        生活保護受給者(生活保護受給者List, 処理年月);
        List<IdoTblTmpEntity> allData = new ArrayList<>();
        for (IdoTblTmpEntity 異動一時 : 異動一時Map.values()) {
            allData.add(異動一時);
        }
        引き継ぎ処理(allData);
        for (int i = allData.size() - 1; i > -1; i--) {
            IdoTblTmpEntity 異動一時entity = allData.get(i);
            不要データ削除(異動一時entity, i, allData);
        }
        再編集(allData, 宛名情報, 処理年月);
        異動一時List.clear();
        異動一時Map.clear();
    }

    private void 受給者台帳処理(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            FlexibleYearMonth 処理年月, List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List) {
        boolean 無効データFlag = false;
        異動一時2By受給者台帳パターン1Check(受給者台帳List, 処理年月);
        異動一時2By受給者台帳パターン2Check(受給者台帳List, 処理年月);
        異動一時2By受給者台帳パターン3Check(受給者台帳List, 処理年月, 無効データFlag);
        異動一時2By受給者台帳パターン4Check(受給者台帳List, 処理年月, 無効データFlag);
        異動一時2By受給者台帳パターン5Check(受給者台帳List, 処理年月, 無効データFlag);
        異動一時2By総合事業対象者パターン5Check(受給者台帳List, 総合事業対象者List, 処理年月, 無効データFlag);
    }

    private void 二次予防処理(List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List, FlexibleYearMonth 処理年月) {
        異動一時2By二次予防パターン1Check(二次予防List, 処理年月);
        異動一時2By二次予防パターン2Check(二次予防List, 処理年月);
    }

    private void 総合事業対象者処理(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List, FlexibleYearMonth 処理年月) {
        異動一時2By総合事業対象者パターン1Check(総合事業対象者List, 処理年月);
        異動一時2By総合事業対象者パターン2Check(総合事業対象者List, 処理年月);
        異動一時2By総合事業対象者パターン3Check(総合事業対象者List, 処理年月);
        異動一時2By総合事業対象者パターン4Check(総合事業対象者List, 処理年月);
    }

    private void 居宅計画処理(List<KyotakuEntity> 居宅計画List, FlexibleYearMonth 処理年月) {
        異動一時2By居宅計画パターン1Check(居宅計画List, 処理年月);
        異動一時2By居宅計画パターン2Check(居宅計画List, 処理年月);
    }

    private void 支払方法変更処理(List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List, FlexibleYearMonth 処理年月) {
        異動一時2By支払方法パターン1Check(支払方法変更List, 処理年月);
        異動一時2By支払方法パターン2Check(支払方法変更List, 処理年月);
        異動一時2By支払方法パターン3Check(支払方法変更List, 処理年月);
    }

    private void 給付額減額処理(List<DbT4021ShiharaiHohoHenkoEntity> 給付額減額List, FlexibleYearMonth 処理年月) {
        異動一時2By給付額減額パターン1Check(給付額減額List, 処理年月);
    }

    private void 標準負担処理(List<HyojunFutanEntity> 標準負担List, FlexibleYearMonth 処理年月) {
        異動一時2By標準負担パターン1Check(標準負担List, 処理年月);
    }

    private void 利用者負担処理(List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List, FlexibleYearMonth 処理年月) {
        異動一時2By利用者負担パターン1Check(利用者負担List, 処理年月);
        異動一時2By利用者負担パターン2Check(利用者負担List, 処理年月);
    }

    private void 特定入所者処理(List<TokuteiNyusyoshaInfoEntity> 特定入所者List, FlexibleYearMonth 処理年月) {
        異動一時2By特定入所者パターン1Check(特定入所者List, 処理年月);
        異動一時2By特定入所者パターン2Check(特定入所者List, 処理年月);
    }

    private void 社福減免処理(List<ShafukugemmenEntity> 社福減免List, FlexibleYearMonth 処理年月) {
        異動一時2By社福減免パターン1Check(社福減免List, 処理年月);
    }

    private void 住所地特例(List<JushochitokureiInfoEntity> 住所地特例List, FlexibleYearMonth 処理年月) {
        異動一時2By住所地特例パターン1Check(住所地特例List, 処理年月);
        異動一時2By住所地特例パターン2Check(住所地特例List, 処理年月);
    }

    private void 負担割合処理(List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List, FlexibleYearMonth 処理年月) {
        異動一時2By負担割合パターン1Check(二割負担List, 処理年月);
        異動一時2By負担割合パターン2Check(二割負担List, 処理年月);
    }

    private void 被保険者台帳(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, FlexibleYearMonth 処理年月) {
        異動一時2By被保険者台帳パターン1Check(被保険者台帳List, 処理年月);
        異動一時2By被保険者台帳パターン2Check(被保険者台帳List, 処理年月);
        異動一時2By被保険者台帳パターン3Check(被保険者台帳List, 処理年月);
    }

    private void 生活保護受給者(List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List, FlexibleYearMonth 処理年月) {
        異動一時2By生活保護受給者パターン1Check(生活保護受給者List, 処理年月);
        異動一時2By生活保護受給者パターン2Check(生活保護受給者List, 処理年月);
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
            if (コート_4.equals(受給者台帳.getJukyuShinseiJiyu())
                    || コート_5.equals(受給者台帳.getJukyuShinseiJiyu())) {
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

    private void 異動一時2By総合事業対象者パターン5Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            FlexibleYearMonth 処理年月, boolean 無効データFlag) {
        if (無効データFlag) {
            return;
        }
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (無効データFlag) {
                break;
            }
            if (!コート_0.equals(受給者台帳.getYukoMukoKubun())) {
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
        insertEntity.set被保険者番号(被保険者番号);
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
//        insertEntity.set認定有効期間終了年月日(受給者台帳.getNinteiYukoKikanShuryoYMD());
        Decimal 訪問通所サービス支給限度基準額 = 受給者台帳.getShikyuGendoTanisu();
        if (訪問通所サービス支給限度基準額 != null) {
            insertEntity.set訪問通所サービス支給限度基準額(訪問通所サービス支給限度基準額.intValue());
        }
        insertEntity.set訪問通所サービス上限管理適用期間開始年月日(受給者台帳.getShikyuGendoKaishiYMD());
        FlexibleDate 支給限度有効開始年月日 = 受給者台帳.getShikyuGendoShuryoYMD();
        if (支給限度有効開始年月日 != null) {
            insertEntity.set訪問通所サービス上限管理適用期間終了年月日(new RString(支給限度有効開始年月日.toString()));
        }
        insertEntity.set短期入所サービス支給限度基準額(受給者台帳.getTankiSikyuGendoNissu());
        insertEntity.set短期入所サービス上限管理適用期間開始年月日(受給者台帳.getTankiShikyuGendoKaishiYMD());
        insertEntity.set短期入所サービス上限管理適用期間終了年月日(受給者台帳.getTankiShikyuGendoShuryoYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By受給者台帳パターン2(IdoTblTmpEntity insertEntity,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set変更申請中区分コード(STR_2);
        insertEntity.set申請年月日(受給者台帳.getJukyuShinseiYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By受給者台帳パターン3(IdoTblTmpEntity insertEntity,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
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
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set二次予防事業区分コード(STR_2);
        insertEntity.set二次予防事業有効期間開始年月日(二次予防.getTekiyoKaishiYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By二次予防パターン2(IdoTblTmpEntity insertEntity,
            DbT3100NijiYoboJigyoTaishoshaEntity 二次予防, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set二次予防事業区分コード(STR_2);
        insertEntity.set二次予防事業有効期間開始年月日(二次予防.getTekiyoKaishiYMD());
        insertEntity.set二次予防事業有効期間終了年月日(二次予防.getTekiyoShuryoYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By総合事業対象者パターン1Check(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            FlexibleYearMonth 処理年月) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            if (isBeforeYearMonth(総合事業対象者.getTekiyoKaishiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(総合事業対象者.getTekiyoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By総合事業対象者パターン1(insertEntity, 総合事業対象者, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By総合事業対象者パターン2Check(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            FlexibleYearMonth 処理年月) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者.getTekiyoShuryoYMD())) {
                continue;
            }
            if (isBeforeYearMonth(総合事業対象者.getTekiyoShuryoYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(総合事業対象者.getTekiyoShuryoYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By総合事業対象者パターン2(insertEntity, 総合事業対象者, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By総合事業対象者パターン3Check(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            FlexibleYearMonth 処理年月) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            if (!is月末(総合事業対象者.getTekiyoShuryoYMD())) {
                continue;
            }
            FlexibleDate 適用終了日の翌月 = 総合事業対象者.getTekiyoShuryoYMD().plusMonth(ORDER_1);
            if (isBeforeYearMonth(適用終了日の翌月, 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(総合事業対象者.getTekiyoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By総合事業対象者パターン1(insertEntity, 総合事業対象者, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
                //TODO
            }
        }
    }

    private void 異動一時2By総合事業対象者パターン4Check(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            FlexibleYearMonth 処理年月) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            if (is月末(総合事業対象者.getTekiyoShuryoYMD())) {
                continue;
            }
            if (isBeforeYearMonth(総合事業対象者.getTekiyoShuryoYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(総合事業対象者.getTekiyoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By総合事業対象者パターン1(insertEntity, 総合事業対象者, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
                //TODO
            }
        }
    }

    private void set異動一時2By総合事業対象者パターン1(IdoTblTmpEntity insertEntity,
            DbT3105SogoJigyoTaishoshaEntity 総合事業対象者, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set変更申請中区分コード(STR_3);
        insertEntity.setみなし要介護状態区分コード(STR_1);
        insertEntity.set要介護状態区分コード(STR_06);
        insertEntity.set認定有効期間開始年月日(総合事業対象者.getTekiyoKaishiYMD());
        //TODO
        insertEntity.set訪問通所サービス支給限度基準額(1);
        insertEntity.set訪問通所サービス上限管理適用期間開始年月日(異動年月日);
        insertEntity.set短期入所サービス支給限度基準額(0);
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By総合事業対象者パターン2(IdoTblTmpEntity insertEntity,
            DbT3105SogoJigyoTaishoshaEntity 総合事業対象者, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set変更申請中区分コード(STR_3);
        insertEntity.setみなし要介護状態区分コード(STR_1);
        insertEntity.set要介護状態区分コード(STR_06);
        insertEntity.set認定有効期間開始年月日(総合事業対象者.getTekiyoKaishiYMD());
        insertEntity.set認定有効期間終了年月日(new RString(総合事業対象者.getTekiyoShuryoYMD().toString()));
        //TODO
        insertEntity.set訪問通所サービス支給限度基準額(1);
        insertEntity.set訪問通所サービス上限管理適用期間開始年月日(異動年月日);
        insertEntity.set短期入所サービス支給限度基準額(0);
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By居宅計画パターン1Check(List<KyotakuEntity> 居宅計画List, FlexibleYearMonth 処理年月) {
        for (KyotakuEntity 居宅計画 : 居宅計画List) {
            if (isBeforeYearMonth(居宅計画.get適用開始日(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(居宅計画.get適用開始日());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By居宅計画パターン1(insertEntity, 居宅計画, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By居宅計画パターン2Check(List<KyotakuEntity> 居宅計画List, FlexibleYearMonth 処理年月) {
        for (KyotakuEntity 居宅計画 : 居宅計画List) {
            if (isDateEmpty(居宅計画.get適用終了日())) {
                continue;
            }
            if (isBeforeYearMonth(居宅計画.get適用終了日(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(居宅計画.get適用終了日());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By居宅計画パターン2(insertEntity, 居宅計画, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By居宅計画パターン1(IdoTblTmpEntity insertEntity,
            KyotakuEntity 居宅計画, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        if (STR_1.equals(居宅計画.get居宅サービス計画作成区分コード()) || STR_2.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_1);
        } else if (STR_3.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_2);
        } else if (STR_4.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_3);
        }
        //TODO  insertEntity.set居宅介護支援事業所番号();
        insertEntity.set居宅サービス計画適用開始年月日(new RString(居宅計画.get適用開始日().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By居宅計画パターン2(IdoTblTmpEntity insertEntity,
            KyotakuEntity 居宅計画, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        if (STR_1.equals(居宅計画.get居宅サービス計画作成区分コード()) || STR_2.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_1);
        } else if (STR_3.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_2);
        } else if (STR_4.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_3);
        }
        //TODO  insertEntity.set居宅介護支援事業所番号();
        insertEntity.set居宅サービス計画適用開始年月日(new RString(居宅計画.get適用開始日().toString()));
        insertEntity.set居宅サービス計画適用終了年月日(new RString(居宅計画.get適用終了日().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By支払方法パターン1Check(List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List,
            FlexibleYearMonth 処理年月) {
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法 : 支払方法変更List) {
            if (isBeforeYearMonth(支払方法.getTekiyoKaishiYMD(), 処理年月) && isDateEmpty(支払方法.getTekiyoShuryoYMD())) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(支払方法.getTekiyoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By支払方法パターン1(insertEntity, 支払方法, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By支払方法パターン2Check(List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List,
            FlexibleYearMonth 処理年月) {
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法 : 支払方法変更List) {
            if (isBeforeYearMonth(支払方法.getTekiyoKaishiYMD(), 処理年月) && !isDateEmpty(支払方法.getTekiyoShuryoYMD())
                    && 支払方法.getTekiyoKaishiYMD() == 支払方法.getTekiyoShuryoYMD()) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(支払方法.getTekiyoShuryoYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By支払方法パターン2(insertEntity, 支払方法, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By支払方法パターン3Check(List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List,
            FlexibleYearMonth 処理年月) {
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法 : 支払方法変更List) {
            if (isBeforeYearMonth(支払方法.getTekiyoKaishiYMD(), 処理年月) && !isDateEmpty(支払方法.getTekiyoShuryoYMD())
                    && 支払方法.getTekiyoKaishiYMD() != 支払方法.getTekiyoShuryoYMD()
                    && isBeforeYearMonth(支払方法.getTekiyoShuryoYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity1;
                IdoTblTmpEntity insertEntity2;
                FlexibleDate 異動年月日1 = get月初(支払方法.getTekiyoKaishiYMD());
                FlexibleDate 異動年月日2 = get月初(支払方法.getTekiyoShuryoYMD());
                if (異動一時Map.containsKey(異動年月日1)) {
                    insertEntity1 = 異動一時Map.get(異動年月日1);
                } else {
                    insertEntity1 = new IdoTblTmpEntity();
                }
                set異動一時2By支払方法パターン1(insertEntity1, 支払方法, 異動年月日1);
                異動一時Map.put(異動年月日1, insertEntity1);
                if (異動一時Map.containsKey(異動年月日2)) {
                    insertEntity2 = 異動一時Map.get(異動年月日2);
                } else {
                    insertEntity2 = new IdoTblTmpEntity();
                }
                set異動一時2By支払方法パターン2(insertEntity2, 支払方法, 異動年月日2);
                異動一時Map.put(異動年月日2, insertEntity2);
            }
        }
    }

    private void set異動一時2By支払方法パターン1(IdoTblTmpEntity insertEntity,
            DbT4021ShiharaiHohoHenkoEntity 支払方法, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        FlexibleDate 適用開始年月日 = 支払方法.getTekiyoKaishiYMD();
        if (適用開始年月日 != null && !適用開始年月日.isEmpty()) {
            insertEntity.set償還払化開始年月日(new RString(適用開始年月日.toString()));
        }
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By支払方法パターン2(IdoTblTmpEntity insertEntity,
            DbT4021ShiharaiHohoHenkoEntity 支払方法, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        FlexibleDate 適用開始年月日 = 支払方法.getTekiyoKaishiYMD();
        if (適用開始年月日 != null && !適用開始年月日.isEmpty()) {
            insertEntity.set償還払化開始年月日(new RString(適用開始年月日.toString()));
        }
        FlexibleDate 適用終了年月日 = 支払方法.getTekiyoShuryoYMD();
        if (適用終了年月日 != null && !適用終了年月日.isEmpty()) {
            insertEntity.set償還払化終了年月日(new RString(適用終了年月日.toString()));
        }
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By給付額減額パターン1Check(List<DbT4021ShiharaiHohoHenkoEntity> 給付額減額List,
            FlexibleYearMonth 処理年月) {
        for (DbT4021ShiharaiHohoHenkoEntity 給付額 : 給付額減額List) {
            if (isBeforeYearMonth(給付額.getTekiyoKaishiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(給付額.getTekiyoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By給付額減額パターン1(insertEntity, 給付額, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By給付額減額パターン1(IdoTblTmpEntity insertEntity,
            DbT4021ShiharaiHohoHenkoEntity 給付額, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set給付率引下げ開始年月日(new RString(異動年月日.toString()));
        FlexibleDate 終了年月日 = get月初(給付額.getTekiyoShuryoYMD());
        insertEntity.set給付率引下げ終了年月日(new RString(終了年月日.toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By標準負担パターン1Check(List<HyojunFutanEntity> 標準負担List, FlexibleYearMonth 処理年月) {
        for (HyojunFutanEntity 標準負担 : 標準負担List) {
            if (isBeforeYearMonth(標準負担.get適用開始日(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(標準負担.get適用開始日());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By標準負担パターン1(insertEntity, 標準負担, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By標準負担パターン1(IdoTblTmpEntity insertEntity,
            HyojunFutanEntity 標準負担, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set減免申請中区分コード(STR_3);
        //TODO   insertEntity.set標準負担区分コード();
        insertEntity.set負担額(標準負担.get負担額());
        insertEntity.set負担限度額適用開始年月日(new RString(異動年月日.toString()));
        FlexibleDate 終了年月日 = get月初(標準負担.get適用終了日());
        insertEntity.set負担額適用終了年月日(new RString(終了年月日.toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By利用者負担パターン1Check(List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List,
            FlexibleYearMonth 処理年月) {
        for (DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担 : 利用者負担List) {
            if (isBeforeYearMonth(利用者負担.getTekiyoKaishiYMD(), 処理年月) && 履歴番号 != 利用者負担.getRirekiNo()) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(利用者負担.getTekiyoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By利用者負担パターン1(insertEntity, 利用者負担, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By利用者負担パターン2Check(List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List, FlexibleYearMonth 処理年月) {
        for (DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担 : 利用者負担List) {
            if (isBeforeYearMonth(利用者負担.getShinseiYMD(), 処理年月) && 履歴番号 == 利用者負担.getRirekiNo()) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(利用者負担.getShinseiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By利用者負担パターン2(insertEntity, 利用者負担, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By利用者負担パターン1(IdoTblTmpEntity insertEntity,
            DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set減免申請中区分コード(STR_3);
        // TODO   insertEntity.set利用者負担区分コード();
        HokenKyufuRitsu 給付率 = 利用者負担.getKyufuritsu();
        if (給付率 != null) {
            insertEntity.set給付率(new Decimal(給付率.toString()));
        }
        FlexibleDate 適用開始年月日 = 利用者負担.getTekiyoKaishiYMD();
        if (適用開始年月日 != null && !適用開始年月日.isEmpty()) {
            insertEntity.set適用開始年月日(new RString(適用開始年月日.toString()));
        }
        FlexibleDate 適用終了年月日 = 利用者負担.getTekiyoShuryoYMD();
        if (適用終了年月日 != null && !適用終了年月日.isEmpty()) {
            insertEntity.set適用終了年月日(new RString(適用終了年月日.toString()));
        }
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By利用者負担パターン2(IdoTblTmpEntity insertEntity,
            DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set減免申請中区分コード(STR_2);
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By特定入所者パターン1Check(List<TokuteiNyusyoshaInfoEntity> 特定入所者List, FlexibleYearMonth 処理年月) {
        for (TokuteiNyusyoshaInfoEntity 特定入所者 : 特定入所者List) {
            if (isBeforeYearMonth(特定入所者.get適用開始日(), 処理年月) && 履歴番号 != 特定入所者.get履歴番号()) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(特定入所者.get適用開始日());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By特定入所者パターン1(insertEntity, 特定入所者, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By特定入所者パターン2Check(List<TokuteiNyusyoshaInfoEntity> 特定入所者List, FlexibleYearMonth 処理年月) {
        for (TokuteiNyusyoshaInfoEntity 特定入所者 : 特定入所者List) {
            if (isBeforeYearMonth(特定入所者.get申請日(), 処理年月) && 履歴番号 == 特定入所者.get履歴番号()) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(特定入所者.get申請日());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By特定入所者パターン2(insertEntity, 特定入所者, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By特定入所者パターン1(IdoTblTmpEntity insertEntity,
            TokuteiNyusyoshaInfoEntity 特定入所者, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set特定入所者認定申請中区分コード(STR_3);
        Decimal 食費負担限度額 = 特定入所者.get食費負担限度額();
        if (食費負担限度額 != null) {
            insertEntity.set食費負担限度額(new RString(食費負担限度額.toString()));
        }
        Decimal 個室負担限度額 = 特定入所者.getユニット型個室();
        if (個室負担限度額 != null) {
            insertEntity.set居住費ユニット型個室負担限度額(new RString(個室負担限度額.toString()));
        }
        Decimal 準個室負担限度額 = 特定入所者.getユニット型準個室();
        if (準個室負担限度額 != null) {
            insertEntity.set居住費ユニット型準個室負担限度額(new RString(準個室負担限度額.toString()));
        }
        Decimal 居住費従来型個室 = 特定入所者.get従来型個室_特養等();
        if (居住費従来型個室 != null) {
            insertEntity.set居住費従来型個室特養等負担限度額(new RString(居住費従来型個室.toString()));
        }
        Decimal 居住費従来型個室老健療養 = 特定入所者.get従来型個室_老健_療養等();
        if (居住費従来型個室老健療養 != null) {
            insertEntity.set居住費従来型個室老健療養等負担限度額(new RString(居住費従来型個室老健療養.toString()));
        }
        Decimal 居住費多床室 = 特定入所者.get多床室();
        if (居住費多床室 != null) {
            insertEntity.set居住費多床室負担限度額(new RString(居住費多床室.toString()));
        }
        FlexibleDate 適用開始年月日 = 特定入所者.get適用開始日();
        if (適用開始年月日 != null && !適用開始年月日.isEmpty()) {
            insertEntity.set負担限度額適用開始年月日(new RString(適用開始年月日.toString()));
        }
        FlexibleDate 終了年月日 = 特定入所者.get適用終了日();
        if (終了年月日 != null && !終了年月日.isEmpty()) {
            insertEntity.set適用終了年月日(new RString(終了年月日.toString()));
        }
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By特定入所者パターン2(IdoTblTmpEntity insertEntity,
            TokuteiNyusyoshaInfoEntity 特定入所者, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        //  TODO  insertEntity.set特定入所者認定申請中区分コード();
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By社福減免パターン1Check(List<ShafukugemmenEntity> 社福減免List,
            FlexibleYearMonth 処理年月) {
        for (ShafukugemmenEntity 社福減免 : 社福減免List) {
            if (isBeforeYearMonth(社福減免.get適用開始日(), 処理年月) && 履歴番号 != 社福減免.get履歴番号()) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(社福減免.get適用開始日());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By社福減免パターン1(insertEntity, 社福減免, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By社福減免パターン1(IdoTblTmpEntity insertEntity,
            ShafukugemmenEntity 社福減免, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set軽減率(社福減免.get軽減率());
        insertEntity.set軽減率適用開始年月日(new RString(異動年月日.toString()));
        FlexibleDate 適用終了年月日 = get月初(社福減免.get適用終了日());
        insertEntity.set軽減率適用終了年月日(new RString(適用終了年月日.toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By住所地特例パターン1Check(List<JushochitokureiInfoEntity> 住所地特例List,
            FlexibleYearMonth 処理年月) {
        for (JushochitokureiInfoEntity 住所地特例 : 住所地特例List) {
            if (isBeforeYearMonth(住所地特例.get住所地特例適用開始日(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(住所地特例.get住所地特例適用開始日());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By住所地特例パターン1(insertEntity, 住所地特例, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By住所地特例パターン2Check(List<JushochitokureiInfoEntity> 住所地特例List,
            FlexibleYearMonth 処理年月) {
        for (JushochitokureiInfoEntity 住所地特例 : 住所地特例List) {
            if (isBeforeYearMonth(住所地特例.get住所地特例適用終了日(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(住所地特例.get住所地特例適用終了日());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By住所地特例パターン2(insertEntity, 住所地特例, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By住所地特例パターン1(IdoTblTmpEntity insertEntity,
            JushochitokureiInfoEntity 住所地特例, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set住所地特例対象者区分コード(STR_1);
        insertEntity.set施設所在保険者番号(new RString(住所地特例.get被保険者番号().toString()));
        insertEntity.set住所地特例適用開始日(new RString(住所地特例.get住所地特例適用開始日().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By住所地特例パターン2(IdoTblTmpEntity insertEntity,
            JushochitokureiInfoEntity 住所地特例, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set住所地特例対象者区分コード(STR_1);
        insertEntity.set施設所在保険者番号(new RString(住所地特例.get被保険者番号().toString()));
        insertEntity.set住所地特例適用開始日(new RString(住所地特例.get住所地特例適用開始日().toString()));
        insertEntity.set住所地特例適用終了日(new RString(住所地特例.get住所地特例適用終了日().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By負担割合パターン1Check(List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List,
            FlexibleYearMonth 処理年月) {
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity 負担割合 : 二割負担List) {
            if (isBeforeYearMonth(負担割合.getYukoKaishiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(負担割合.getYukoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By負担割合パターン1(insertEntity, 負担割合, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By負担割合パターン2Check(List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List,
            FlexibleYearMonth 処理年月) {
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity 負担割合 : 二割負担List) {
            if (isBeforeYearMonth(負担割合.getYukoShuryoYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(負担割合.getYukoShuryoYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By負担割合パターン2(insertEntity, 負担割合, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By負担割合パターン1(IdoTblTmpEntity insertEntity,
            DbT3114RiyoshaFutanWariaiMeisaiEntity 負担割合, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set利用者負担割合有効開始日(new RString(異動年月日.toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By負担割合パターン2(IdoTblTmpEntity insertEntity,
            DbT3114RiyoshaFutanWariaiMeisaiEntity 負担割合, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        FlexibleDate 適用開始年月日 = get月初(負担割合.getYukoKaishiYMD());
        insertEntity.set利用者負担割合有効開始日(new RString(適用開始年月日.toString()));
        insertEntity.set利用者負担割合有効終了日(new RString(異動年月日.toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By被保険者台帳パターン1Check(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (isBeforeYearMonth(被保険者台帳.getShikakuShutokuYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(被保険者台帳.getShikakuShutokuYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By被保険者台帳パターン1(insertEntity, 被保険者台帳, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By被保険者台帳パターン2Check(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (!isDateEmpty(被保険者台帳.getShikakuSoshitsuYMD()) && isBeforeYearMonth(被保険者台帳.getShikakuSoshitsuYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(被保険者台帳.getShikakuSoshitsuYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By被保険者台帳パターン2(insertEntity, 被保険者台帳, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By被保険者台帳パターン3Check(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (資格取得事由.equals(被保険者台帳.getShikakuShutokuJiyuCode()) && isBeforeYearMonth(被保険者台帳.getIdoYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(被保険者台帳.getIdoYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By被保険者台帳パターン3(insertEntity, 被保険者台帳, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By被保険者台帳パターン1(IdoTblTmpEntity insertEntity,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        //TODO
        //        insertEntity.set証記載保険者番号();
        insertEntity.set資格取得年月日(被保険者台帳.getShikakuShutokuYMD());
        insertEntity.set市町村コード(new RString(被保険者台帳.getShichosonCode().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By被保険者台帳パターン2(IdoTblTmpEntity insertEntity,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        //        insertEntity.set証記載保険者番号();
        insertEntity.set資格取得年月日(被保険者台帳.getShikakuShutokuYMD());
        insertEntity.set資格喪失年月日(被保険者台帳.getShikakuSoshitsuYMD());
        insertEntity.set市町村コード(new RString(被保険者台帳.getShichosonCode().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By被保険者台帳パターン3(IdoTblTmpEntity insertEntity,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        //        insertEntity.set証記載保険者番号();
        insertEntity.set資格取得年月日(被保険者台帳.getShikakuShutokuYMD());
        insertEntity.set市町村コード(new RString(被保険者台帳.getShichosonCode().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By生活保護受給者パターン1Check(List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List,
            FlexibleYearMonth 処理年月) {
        for (UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者 : 生活保護受給者List) {
            if (isBeforeYearMonth(生活保護受給者.getJukyuKaishiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(生活保護受給者.getJukyuKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By生活保護受給者パターン1(insertEntity, 生活保護受給者, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By生活保護受給者パターン2Check(List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List,
            FlexibleYearMonth 処理年月) {
        for (UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者 : 生活保護受給者List) {
            if (!isDateEmpty(生活保護受給者.getJukyuHaishiYMD()) && isBeforeYearMonth(生活保護受給者.getJukyuHaishiYMD().plusMonth(ORDER_1), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(生活保護受給者.getJukyuHaishiYMD().plusMonth(ORDER_1));
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By生活保護受給者パターン2(insertEntity, 生活保護受給者, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By生活保護受給者パターン1(IdoTblTmpEntity insertEntity,
            UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set公費負担上限額減額有フラグ(true);
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By生活保護受給者パターン2(IdoTblTmpEntity insertEntity,
            UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set公費負担上限額減額有フラグ(false);
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

    private List<UrT0508SeikatsuHogoJukyushaEntity> get生活保護受給者() {
        List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者 = get生活保護受給者entity(異動一時.get生活保護受給者());
            if (生活保護受給者 == null) {
                continue;
            }
            生活保護受給者List.add(生活保護受給者);
        }
        return 生活保護受給者List;
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
        entity.setShichosonCode(new LasdecCode(被保険者台帳Info.get(ORDER_3)));
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

    private UrT0508SeikatsuHogoJukyushaEntity get生活保護受給者entity(RString 生活保護受給者) {
        if (RString.isNullOrEmpty(生活保護受給者)) {
            return null;
        }
        UrT0508SeikatsuHogoJukyushaEntity entity = new UrT0508SeikatsuHogoJukyushaEntity();
        List<RString> 生活保護受給者Info = 生活保護受給者.split(SPLIT.toString());
        entity.setJukyuKaishiYMD(new FlexibleDate(生活保護受給者Info.get(ORDER_0)));
        entity.setJukyuHaishiYMD(new FlexibleDate(生活保護受給者Info.get(ORDER_1)));
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

    private boolean isBeforeOreqDate(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date1) || isDateEmpty(date2)) {
            return false;
        }
        return date1.isBeforeOrEquals(date2);
    }

    private boolean isBeforeYearMonth(FlexibleDate date1, FlexibleYearMonth date2) {
        if (date1 == null || date1.isEmpty()) {
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

    private void 不要データ削除(IdoTblTmpEntity 異動一時entity, int i, List<IdoTblTmpEntity> allData) {
        if (isDateEmpty(異動一時entity.get資格取得年月日())) {
            allData.remove(i);
            return;
        }
        if (RString.isNullOrEmpty(異動一時entity.get要介護状態区分コード())
                && isDateEmpty(異動一時entity.get認定有効期間開始年月日())
                && RString.isNullOrEmpty(異動一時entity.get認定有効期間終了年月日())
                && isDateEmpty(異動一時entity.get二次予防事業有効期間開始年月日())
                && isDateEmpty(異動一時entity.get二次予防事業有効期間終了年月日())) {
            allData.remove(i);
            return;
        }
        if (!isDateEmpty(異動一時entity.get認定有効期間開始年月日())
                && !RString.isNullOrEmpty(異動一時entity.get認定有効期間終了年月日())
                && !RString.isNullOrEmpty(異動一時entity.get居宅サービス計画適用開始年月日())
                && (isBeforeDate(new FlexibleDate(異動一時entity.get居宅サービス計画適用開始年月日()),
                        異動一時entity.get認定有効期間開始年月日())
                || isBeforeDate(new FlexibleDate(異動一時entity.get認定有効期間終了年月日()),
                        new FlexibleDate(異動一時entity.get居宅サービス計画適用開始年月日())))) {
            allData.remove(i);
            return;
        }
        if (!isDateEmpty(異動一時entity.get認定有効期間開始年月日())
                && !isDateEmpty(異動一時entity.get資格取得年月日())
                && isBeforeDate(異動一時entity.get認定有効期間開始年月日(), 異動一時entity.get資格取得年月日())) {
            allData.remove(i);
            return;
        }
        if (!isDateEmpty(異動一時entity.get二次予防事業有効期間開始年月日())
                && !isDateEmpty(異動一時entity.get資格取得年月日())
                && isBeforeDate(異動一時entity.get二次予防事業有効期間開始年月日(), 異動一時entity.get資格取得年月日())) {
            allData.remove(i);
            return;
        }
    }

    private void 総合事業対象者適用開始年月日設定(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            List<KyotakuEntity> 居宅計画List) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            for (KyotakuEntity 居宅計画 : 居宅計画List) {
                if (!isYMdif(総合事業対象者.getTekiyoKaishiYMD(), 居宅計画.get届出年月日())
                        && !isYMdif(総合事業対象者.getTekiyoKaishiYMD(), 居宅計画.get適用開始日())
                        && STR_4.equals(居宅計画.get居宅サービス計画作成区分コード())) {
                    総合事業対象者.setTekiyoKaishiYMD(居宅計画.get届出年月日());
                }
            }
        }
    }

    private boolean isYMdif(FlexibleDate date1, FlexibleDate date2) {
        if ((date1 == null || date1.isEmpty()) && (date2 == null || date2.isEmpty())) {
            return false;
        }
        if ((date1 == null || date1.isEmpty())) {
            return true;
        }
        if ((date2 == null || date2.isEmpty())) {
            return true;
        }
        if (date1.getYearMonth().compareTo(date2.getYearMonth()) != ORDER_0) {
            return true;
        }
        return false;
    }

    private boolean is月末(FlexibleDate date) {
        if ((date == null || date.isEmpty())) {
            return false;
        }
        int 月末 = date.getYearMonth().getLastDay();
        if (月末 == date.getDayValue()) {
            return true;
        }
        return false;
    }

    private List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者まとめる(List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List) {
        if (生活保護受給者List.isEmpty() || 生活保護受給者List.size() == 1) {
            return 生活保護受給者List;
        }
        sort生活保護受給者List(生活保護受給者List);
        List<UrT0508SeikatsuHogoJukyushaEntity> まとめるList = new ArrayList<>();
        FlexibleDate tempStartDate = null;
        FlexibleDate tempEndDate = null;
        for (int i = 0; i < 生活保護受給者List.size(); i++) {
            UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者 = 生活保護受給者List.get(i);
            if (i == 0) {
                tempStartDate = 生活保護受給者.getJukyuKaishiYMD();
                tempEndDate = 生活保護受給者.getJukyuHaishiYMD();
                continue;
            }
            if (i == 生活保護受給者List.size() - 1) {
                生活保護受給者.setJukyuKaishiYMD(tempStartDate);
                生活保護受給者.setJukyuHaishiYMD(tempEndDate);
                まとめるList.add(生活保護受給者);
                break;
            }
            if (isBeforeDate(生活保護受給者.getJukyuKaishiYMD(), tempEndDate)) {
                tempEndDate = 生活保護受給者.getJukyuHaishiYMD();
                if (isDateEmpty(tempEndDate)) {
                    UrT0508SeikatsuHogoJukyushaEntity tempEntity = 生活保護受給者List.get(i - 1);
                    tempEntity.setJukyuKaishiYMD(tempStartDate);
                    tempEntity.setJukyuHaishiYMD(tempEndDate);
                    まとめるList.add(tempEntity);
                    break;
                }
            } else {
                UrT0508SeikatsuHogoJukyushaEntity tempEntity = 生活保護受給者List.get(i - 1);
                tempEntity.setJukyuKaishiYMD(tempStartDate);
                tempEntity.setJukyuHaishiYMD(tempEndDate);
                まとめるList.add(tempEntity);
                tempStartDate = 生活保護受給者.getJukyuKaishiYMD();
                tempEndDate = 生活保護受給者.getJukyuHaishiYMD();
                if (isDateEmpty(tempEndDate)) {
                    まとめるList.add(生活保護受給者);
                    break;
                }
            }

        }
        return まとめるList;
    }

    private void sort生活保護受給者List(List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List) {
        Collections.sort(生活保護受給者List, new Comparator<UrT0508SeikatsuHogoJukyushaEntity>() {
            @Override
            public int compare(UrT0508SeikatsuHogoJukyushaEntity o1, UrT0508SeikatsuHogoJukyushaEntity o2) {
                int 開始日 = getDateCompara(o1.getJukyuKaishiYMD(), o2.getJukyuKaishiYMD());
                if (開始日 == ORDER_0) {
                    return getDateCompara(o1.getJukyuHaishiYMD(), o2.getJukyuHaishiYMD());
                }
                return 開始日;
            }
        });
    }

    private int getDateCompara(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date1) && isDateEmpty(date2)) {
            return 0;
        }
        if (isDateEmpty(date1) && !isDateEmpty(date2)) {
            return -1;
        }
        if (!isDateEmpty(date1) && isDateEmpty(date2)) {
            return 1;
        }
        return date1.compareTo(date2);
    }

    private void 引き継ぎ処理(List<IdoTblTmpEntity> allData) {
        sort異動一時2データ(allData);
        IdoTblTmpEntity 前履歴データ = null;
        for (IdoTblTmpEntity entity : allData) {
            if (前履歴データ == null) {
                前履歴データ = entity;
                continue;
            }
            if (entity.get証記載保険者番号() == null) {
                entity.set証記載保険者番号(前履歴データ.get証記載保険者番号());
            } else {
                前履歴データ.set証記載保険者番号(entity.get証記載保険者番号());
            }

            if (entity.get資格取得年月日() == null) {
                entity.set資格取得年月日(前履歴データ.get資格取得年月日());
            } else {
                前履歴データ.set資格取得年月日(entity.get資格取得年月日());
            }

            if (entity.get申請種別コード() == null) {
                entity.set申請種別コード(前履歴データ.get申請種別コード());
            } else {
                前履歴データ.set申請種別コード(entity.get申請種別コード());
            }
            if (entity.get変更申請中区分コード() == null) {
                entity.set変更申請中区分コード(前履歴データ.get変更申請中区分コード());
            } else {
                前履歴データ.set変更申請中区分コード(entity.get変更申請中区分コード());
            }
            if (entity.get申請年月日() == null) {
                entity.set申請年月日(前履歴データ.get申請年月日());
            } else {
                前履歴データ.set申請年月日(entity.get申請年月日());
            }
            if (entity.getみなし要介護状態区分コード() == null) {
                entity.setみなし要介護状態区分コード(前履歴データ.getみなし要介護状態区分コード());
            } else {
                前履歴データ.setみなし要介護状態区分コード(entity.getみなし要介護状態区分コード());
            }
            if (entity.get要介護状態区分コード() == null) {
                entity.set要介護状態区分コード(前履歴データ.get要介護状態区分コード());
            } else {
                前履歴データ.set要介護状態区分コード(entity.get要介護状態区分コード());
            }
            if (entity.get認定有効期間開始年月日() == null) {
                entity.set認定有効期間開始年月日(前履歴データ.get認定有効期間開始年月日());
            } else {
                前履歴データ.set認定有効期間開始年月日(entity.get認定有効期間開始年月日());
            }
            if (entity.get認定有効期間終了年月日() == null) {
                entity.set認定有効期間終了年月日(前履歴データ.get認定有効期間終了年月日());
            } else {
                前履歴データ.set認定有効期間終了年月日(entity.get認定有効期間終了年月日());
            }
            if (entity.get居宅サービス計画作成区分コード() == null) {
                entity.set居宅サービス計画作成区分コード(前履歴データ.get居宅サービス計画作成区分コード());
            } else {
                前履歴データ.set居宅サービス計画作成区分コード(entity.get居宅サービス計画作成区分コード());
            }
            if (entity.get居宅介護支援事業所番号() == null) {
                entity.set居宅介護支援事業所番号(前履歴データ.get居宅介護支援事業所番号());
            } else {
                前履歴データ.set居宅介護支援事業所番号(entity.get居宅介護支援事業所番号());
            }
            if (entity.get居宅サービス計画適用開始年月日() == null) {
                entity.set居宅サービス計画適用開始年月日(前履歴データ.get居宅サービス計画適用開始年月日());
            } else {
                前履歴データ.set居宅サービス計画適用開始年月日(entity.get居宅サービス計画適用開始年月日());
            }
            if (entity.get居宅サービス計画適用終了年月日() == null) {
                entity.set居宅サービス計画適用終了年月日(前履歴データ.get居宅サービス計画適用終了年月日());
            } else {
                前履歴データ.set居宅サービス計画適用終了年月日(entity.get居宅サービス計画適用終了年月日());
            }
            if (entity.get要介護状態区分コード() == null) {
                entity.set訪問通所サービス支給限度基準額(前履歴データ.get訪問通所サービス支給限度基準額());
                entity.set訪問通所サービス上限管理適用期間開始年月日(前履歴データ.get訪問通所サービス上限管理適用期間開始年月日());
                entity.set訪問通所サービス上限管理適用期間終了年月日(前履歴データ.get訪問通所サービス上限管理適用期間終了年月日());
                entity.set短期入所サービス支給限度基準額(前履歴データ.get短期入所サービス支給限度基準額());
                entity.set短期入所サービス上限管理適用期間開始年月日(前履歴データ.get短期入所サービス上限管理適用期間開始年月日());
                entity.set短期入所サービス上限管理適用期間終了年月日(前履歴データ.get短期入所サービス上限管理適用期間終了年月日());
            } else {
                前履歴データ.set訪問通所サービス支給限度基準額(entity.get訪問通所サービス支給限度基準額());
                前履歴データ.set訪問通所サービス上限管理適用期間開始年月日(entity.get訪問通所サービス上限管理適用期間開始年月日());
                前履歴データ.set訪問通所サービス上限管理適用期間終了年月日(entity.get訪問通所サービス上限管理適用期間終了年月日());
                前履歴データ.set短期入所サービス支給限度基準額(entity.get短期入所サービス支給限度基準額());
                前履歴データ.set短期入所サービス上限管理適用期間開始年月日(entity.get短期入所サービス上限管理適用期間開始年月日());
                前履歴データ.set短期入所サービス上限管理適用期間終了年月日(entity.get短期入所サービス上限管理適用期間終了年月日());
            }
            if (!entity.is公費負担上限額減額有フラグ()) {
                entity.set公費負担上限額減額有フラグ(前履歴データ.is公費負担上限額減額有フラグ());
            } else {
                前履歴データ.set公費負担上限額減額有フラグ(entity.is公費負担上限額減額有フラグ());
            }
            if (entity.get償還払化開始年月日() == null) {
                entity.set償還払化開始年月日(前履歴データ.get償還払化開始年月日());
            } else {
                前履歴データ.set償還払化開始年月日(entity.get償還払化開始年月日());
            }
            引き継ぎデータ処理(entity, 前履歴データ);
        }
    }

    private void 引き継ぎデータ処理(IdoTblTmpEntity entity, IdoTblTmpEntity 前履歴データ) {
        if (entity.get償還払化終了年月日() == null) {
            entity.set償還払化終了年月日(前履歴データ.get償還払化終了年月日());
        } else {
            前履歴データ.set償還払化終了年月日(entity.get償還払化終了年月日());
        }
        if (entity.get給付率引下げ開始年月日() == null) {
            entity.set給付率引下げ開始年月日(前履歴データ.get給付率引下げ開始年月日());
        } else {
            前履歴データ.set給付率引下げ開始年月日(entity.get給付率引下げ開始年月日());
        }
        if (entity.get給付率引下げ終了年月日() == null) {
            entity.set給付率引下げ終了年月日(前履歴データ.get給付率引下げ終了年月日());
        } else {
            前履歴データ.set給付率引下げ終了年月日(entity.get給付率引下げ終了年月日());
        }
        if (entity.get減免申請中区分コード() == null) {
            entity.set減免申請中区分コード(前履歴データ.get減免申請中区分コード());
        } else {
            前履歴データ.set減免申請中区分コード(entity.get減免申請中区分コード());
        }
        if (entity.get利用者負担区分コード() == null) {
            entity.set利用者負担区分コード(前履歴データ.get利用者負担区分コード());
            entity.set給付率(前履歴データ.get給付率());
            entity.set適用開始年月日(前履歴データ.get適用開始年月日());
            entity.set適用終了年月日(前履歴データ.get適用終了年月日());
        } else {
            前履歴データ.set利用者負担区分コード(entity.get利用者負担区分コード());
            前履歴データ.set給付率(entity.get給付率());
            前履歴データ.set適用開始年月日(entity.get適用開始年月日());
            前履歴データ.set適用終了年月日(entity.get適用終了年月日());
        }
        if (entity.get標準負担区分コード() == null) {
            entity.set標準負担区分コード(前履歴データ.get標準負担区分コード());
            entity.set負担額(前履歴データ.get負担額());
            entity.set負担額適用開始年月日(前履歴データ.get負担額適用開始年月日());
            entity.set負担額適用終了年月日(前履歴データ.get負担額適用終了年月日());
        } else {
            前履歴データ.set標準負担区分コード(entity.get標準負担区分コード());
            前履歴データ.set負担額(entity.get負担額());
            前履歴データ.set負担額適用開始年月日(entity.get負担額適用開始年月日());
            前履歴データ.set負担額適用終了年月日(entity.get負担額適用終了年月日());
        }
        if (entity.get特定入所者認定申請中区分コード() == null) {
            entity.set特定入所者認定申請中区分コード(前履歴データ.get特定入所者認定申請中区分コード());
        } else {
            前履歴データ.set特定入所者認定申請中区分コード(entity.get特定入所者認定申請中区分コード());
        }

        if (entity.get負担限度額適用開始年月日() == null) {
            entity.set特定入所者介護サービス区分コード(前履歴データ.get特定入所者介護サービス区分コード());
            entity.set課税層の特例減額措置対象フラグ(前履歴データ.get課税層の特例減額措置対象フラグ());
            entity.set食費負担限度額(前履歴データ.get食費負担限度額());
            entity.set居住費ユニット型個室負担限度額(前履歴データ.get居住費ユニット型個室負担限度額());
            entity.set居住費ユニット型準個室負担限度額(前履歴データ.get居住費ユニット型準個室負担限度額());
            entity.set居住費従来型個室特養等負担限度額(前履歴データ.get居住費従来型個室特養等負担限度額());
            entity.set居住費従来型個室老健療養等負担限度額(前履歴データ.get居住費従来型個室老健療養等負担限度額());
            entity.set居住費多床室負担限度額(前履歴データ.get居住費多床室負担限度額());
            entity.set負担限度額適用開始年月日(前履歴データ.get負担限度額適用開始年月日());
            entity.set負担限度額適用終了年月日(前履歴データ.get負担限度額適用終了年月日());
        } else {
            前履歴データ.set特定入所者介護サービス区分コード(entity.get特定入所者介護サービス区分コード());
            前履歴データ.set課税層の特例減額措置対象フラグ(entity.get課税層の特例減額措置対象フラグ());
            前履歴データ.set食費負担限度額(entity.get食費負担限度額());
            前履歴データ.set居住費ユニット型個室負担限度額(entity.get居住費ユニット型個室負担限度額());
            前履歴データ.set居住費ユニット型準個室負担限度額(entity.get居住費ユニット型準個室負担限度額());
            前履歴データ.set居住費ユニット型準個室負担限度額(entity.get居住費ユニット型準個室負担限度額());
            前履歴データ.set居住費従来型個室特養等負担限度額(entity.get居住費従来型個室特養等負担限度額());
            前履歴データ.set居住費従来型個室老健療養等負担限度額(entity.get居住費従来型個室老健療養等負担限度額());
            前履歴データ.set居住費多床室負担限度額(entity.get居住費多床室負担限度額());
            前履歴データ.set負担限度額適用開始年月日(entity.get負担限度額適用開始年月日());
            前履歴データ.set負担限度額適用終了年月日(entity.get負担限度額適用終了年月日());
        }
        if (entity.get軽減率() == null) {
            entity.set軽減率(前履歴データ.get軽減率());
        } else {
            前履歴データ.set軽減率(entity.get軽減率());
        }
        if (entity.get軽減率適用開始年月日() == null) {
            entity.set軽減率適用開始年月日(前履歴データ.get軽減率適用開始年月日());
        } else {
            前履歴データ.set軽減率適用開始年月日(entity.get軽減率適用開始年月日());
        }
        if (entity.get軽減率適用終了年月日() == null) {
            entity.set軽減率適用終了年月日(前履歴データ.get軽減率適用終了年月日());
        } else {
            前履歴データ.set軽減率適用終了年月日(entity.get軽減率適用終了年月日());
        }

        if (entity.get二次予防事業有効期間開始年月日() == null) {
            entity.set二次予防事業区分コード(前履歴データ.get二次予防事業区分コード());
            entity.set二次予防事業有効期間開始年月日(前履歴データ.get二次予防事業有効期間開始年月日());
            entity.set二次予防事業有効期間終了年月日(前履歴データ.get二次予防事業有効期間終了年月日());
        } else {
            前履歴データ.set二次予防事業区分コード(entity.get二次予防事業区分コード());
            前履歴データ.set二次予防事業有効期間開始年月日(entity.get二次予防事業有効期間開始年月日());
            前履歴データ.set二次予防事業有効期間終了年月日(entity.get二次予防事業有効期間終了年月日());
        }

        if (entity.get二次予防事業有効期間開始年月日() == null) {
            entity.set住所地特例対象者区分コード(前履歴データ.get住所地特例対象者区分コード());
            entity.set施設所在保険者番号(前履歴データ.get施設所在保険者番号());
            entity.set住所地特例適用開始日(前履歴データ.get住所地特例適用開始日());
            entity.set住所地特例適用終了日(前履歴データ.get住所地特例適用終了日());
        } else {
            前履歴データ.set住所地特例対象者区分コード(entity.get住所地特例対象者区分コード());
            前履歴データ.set施設所在保険者番号(entity.get施設所在保険者番号());
            前履歴データ.set住所地特例適用開始日(entity.get住所地特例適用開始日());
            前履歴データ.set住所地特例適用終了日(entity.get住所地特例適用終了日());
        }

        if (entity.get利用者負担割合有効開始日() == null) {
            entity.set利用者負担割合有効開始日(前履歴データ.get利用者負担割合有効開始日());
            entity.set利用者負担割合有効終了日(前履歴データ.get利用者負担割合有効終了日());
        } else {
            前履歴データ.set利用者負担割合有効開始日(entity.get利用者負担割合有効開始日());
            前履歴データ.set利用者負担割合有効終了日(entity.get利用者負担割合有効終了日());
        }
    }

    private void sort異動一時2データ(List<IdoTblTmpEntity> allData) {
        Collections.sort(allData, new Comparator<IdoTblTmpEntity>() {
            @Override
            public int compare(IdoTblTmpEntity o1, IdoTblTmpEntity o2) {
                if (isBeforeDate(o1.get異動年月日(), o2.get異動年月日())) {
                    return -1;
                }
                if (isBeforeDate(o2.get異動年月日(), o1.get異動年月日())) {
                    return 1;
                }
                return 0;
            }
        });
    }

    private void 再編集(List<IdoTblTmpEntity> allData, PSMInfoEntity 宛名情報, FlexibleYearMonth 処理年月) {
        IdoTblTmpEntity 最古の異動日の異動 = allData.get(ORDER_0);
        if (STR_3.equals(最古の異動日の異動.get異動区分コード())
                && is年月同じ(最古の異動日の異動.get認定有効期間開始年月日(), 最古の異動日の異動.get資格喪失年月日())) {
            IdoTblTmpEntity cloneEntity = 最古の異動日の異動.clone();
            最古の異動日の異動.set異動区分コード(STR_1);
            最古の異動日の異動.set受給者異動事由(STR_01);
            最古の異動日の異動.set資格喪失年月日(null);
            FlexibleDate 次異動日 = 次異動日取得(allData, cloneEntity);
            cloneEntity.set異動年月日(次異動日);
            allData.add(cloneEntity);
        }
        再編集更新(allData);
        int 履歴通番 = 1;
        RString 計画終了日Flag = DbBusinessConfig.get(ConfigNameDBC.国保連受給異動_計画終了日_星, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        for (int i = 0; i < allData.size(); i++) {
            IdoTblTmpEntity entity = allData.get(i);
            entity.set履歴番号(履歴通番);
            履歴通番++;
            if (!isDateEmpty(entity.get資格喪失年月日())) {
                entity.set異動区分コード(STR_3);
                entity.set受給者異動事由(STR_02);
            } else if (i == 0) {
                entity.set異動区分コード(STR_1);
                entity.set受給者異動事由(STR_01);
            } else if (前履歴資格喪失年月日Check(entity, allData.get(i - 1))) {
                entity.set異動区分コード(STR_1);
                entity.set受給者異動事由(STR_01);
            } else if (前履歴証記載保険者番号Check(entity, allData.get(i - 1))) {
                entity.set異動区分コード(STR_1);
                entity.set受給者異動事由(STR_03);
            } else {
                entity.set異動区分コード(STR_2);
                entity.set受給者異動事由(STR_99);
            }
            entity.set被保険者氏名カナ(宛名情報.getカナ名称().getColumnValue());
            entity.set生年月日(宛名情報.get生年月日());
            entity.set性別コード(宛名情報.get性別());
            if (RString.isNullOrEmpty(entity.get要介護状態区分コード())) {
                entity.set要介護状態区分コード(STR_01);
            }
            if (!RString.isNullOrEmpty(entity.get償還払化開始年月日())
                    && !RString.isNullOrEmpty(entity.get償還払化終了年月日())
                    && (isBeforeDate(new FlexibleDate(entity.get償還払化開始年月日()), entity.get異動年月日())
                    || isBeforeDate(new FlexibleDate(entity.get償還払化開始年月日()), entity.get資格取得年月日()))) {
                entity.set償還払化開始年月日(星);
                entity.set償還払化終了年月日(星);
            }
            if (要介護状態区分判断(entity, 計画終了日Flag)) {
                entity.set居宅サービス計画作成区分コード(星);
                entity.set居宅介護支援事業所番号(星);
                entity.set居宅サービス計画適用開始年月日(星);
                entity.set居宅サービス計画適用終了年月日(星);
            } else if (STR_2.equals(entity.get居宅サービス計画作成区分コード())
                    && !STR_1.equals(entity.get異動区分コード())) {
                entity.set居宅介護支援事業所番号(星);
            } else if (STR_1.equals(計画終了日Flag)
                    && !STR_1.equals(entity.get異動区分コード())) {
                entity.set居宅サービス計画適用終了年月日(星);
            }
            if (!entity.is公費負担上限額減額有フラグ()) {
                entity.set公費負担上限額減額有フラグ(true);
            }
            再編集一部(entity);
            entity.set小多機能居宅介護利用開始月利用有フラグ(true);
//            entity.set後期高齢者医療保険者番号(entity.get);
            entity.set後期高齢者医療被保険者番号(entity.get被保険者番号().getColumnValue());
            entity.set国民健康保険被保険者証番号(entity.get被保険者番号().getColumnValue());
            entity.set送付年月(処理年月);
        }

    }

    private void 再編集更新(List<IdoTblTmpEntity> allData) {
        List<FlexibleYearMonth> 同じ年月List = new ArrayList<>();
        Map<FlexibleYearMonth, List<IdoTblTmpEntity>> 同じ年月Map = new HashMap<>();
        for (IdoTblTmpEntity entity : allData) {
//            if (!isDateEmpty(entity.get資格喪失年月日())
//                    && !isBeforeOreqDate(entity.get認定有効期間開始年月日(), entity.get資格喪失年月日())) {
//                return;
//            }
            FlexibleYearMonth 同じ年月 = entity.get認定有効期間開始年月日().getYearMonth();
            List<IdoTblTmpEntity> updateList = 同じ年月Map.get(同じ年月);
            if (updateList == null) {
                updateList = new ArrayList<>();
                同じ年月Map.put(同じ年月, updateList);
            }
            updateList.add(entity);
            同じ年月List.add(同じ年月);
        }

        for (FlexibleYearMonth 年月 : 同じ年月List) {
            List<IdoTblTmpEntity> updateList = 同じ年月Map.get(年月);
            if (updateList.size() != 2) {
                continue;
            }
            二件編集(updateList);

        }
    }

    private void 二件編集(List<IdoTblTmpEntity> updateList) {
        for (IdoTblTmpEntity entity : updateList) {
            if (!isDateEmpty(entity.get資格喪失年月日())
                    && !isBeforeOreqDate(entity.get認定有効期間開始年月日(), entity.get資格喪失年月日())) {
                return;
            }
        }
        IdoTblTmpEntity 最古の異動日 = updateList.get(ORDER_0);
        最古の異動日.set異動区分コード(STR_1);
        最古の異動日.set受給者異動事由(STR_01);
        FlexibleDate 最古資格喪失年月日 = 最古の異動日.get資格喪失年月日();
        最古の異動日.set資格喪失年月日(null);
        IdoTblTmpEntity 最大の異動日 = updateList.get(ORDER_1);
        最大の異動日.set異動区分コード(STR_3);
        最大の異動日.set受給者異動事由(STR_02);
        FlexibleDate 最大の喪失年月日 = 最大の異動日.get資格喪失年月日();
        if (isBeforeDate(最古資格喪失年月日, 最大の喪失年月日)) {
            最大の異動日.set資格喪失年月日(最大の喪失年月日);
        } else {
            最大の異動日.set資格喪失年月日(最古資格喪失年月日);
        }

    }

    private void 再編集一部(IdoTblTmpEntity entity) {
        if (isBeforeDate(new FlexibleDate(entity.get給付率引下げ開始年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get給付率引下げ開始年月日()), entity.get資格取得年月日())) {
            entity.set給付率引下げ開始年月日(星);
            entity.set給付率引下げ終了年月日(星);
        }
        if (STR_3.equals(entity.get減免申請中区分コード())
                && (RString.isNullOrEmpty(entity.get適用開始年月日())
                || 星.equals(entity.get適用開始年月日())
                || RString.isNullOrEmpty(entity.get負担額適用開始年月日())
                || 星.equals(entity.get負担額適用開始年月日()))) {
            entity.set減免申請中区分コード(STR_1);
        }
        if (!RString.isNullOrEmpty(entity.get適用終了年月日())
                && (isBeforeDate(new FlexibleDate(entity.get適用終了年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get適用終了年月日()), entity.get資格取得年月日()))) {
            entity.set利用者負担区分コード(星);
            //TODO
//                entity.set給付率(星);
            entity.set適用開始年月日(星);
            entity.set適用終了年月日(星);
        }
        再編集一部1(entity);
    }

    private void 再編集一部1(IdoTblTmpEntity entity) {
        if (!RString.isNullOrEmpty(entity.get負担額適用終了年月日())
                && (isBeforeDate(new FlexibleDate(entity.get負担額適用終了年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get負担額適用終了年月日()), entity.get資格取得年月日()))) {
            entity.set標準負担区分コード(星);
            //TODO
//                entity.set負担額(星);
            entity.set負担額適用開始年月日(星);
            entity.set負担額適用終了年月日(星);
        }

        if (STR_3.equals(entity.get特定入所者認定申請中区分コード())
                && (RString.isNullOrEmpty(entity.get負担限度額適用開始年月日())
                || 星.equals(entity.get負担限度額適用開始年月日()))) {
            entity.set特定入所者認定申請中区分コード(STR_1);
        }

        if (!RString.isNullOrEmpty(entity.get負担限度額適用終了年月日())
                && (isBeforeDate(new FlexibleDate(entity.get負担限度額適用終了年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get負担限度額適用終了年月日()), entity.get資格取得年月日()))) {
            entity.set特定入所者介護サービス区分コード(星);
            entity.set課税層の特例減額措置対象フラグ(星);
            entity.set食費負担限度額(星);
            entity.set居住費ユニット型個室負担限度額(星);
            entity.set居住費ユニット型準個室負担限度額(星);
            entity.set居住費従来型個室特養等負担限度額(星);
            entity.set居住費従来型個室老健療養等負担限度額(星);
            entity.set居住費多床室負担限度額(星);
            entity.set負担限度額適用開始年月日(星);
            entity.set負担限度額適用終了年月日(星);
        }

        if (!RString.isNullOrEmpty(entity.get軽減率適用終了年月日())
                && (isBeforeDate(new FlexibleDate(entity.get軽減率適用終了年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get軽減率適用終了年月日()), entity.get資格取得年月日()))) {
            entity.set軽減率(星);
            entity.set軽減率適用開始年月日(星);
            entity.set軽減率適用終了年月日(星);
        }
    }

    private boolean 要介護状態区分判断(IdoTblTmpEntity entity, RString 計画終了日Flag) {
        if ((STR_12.equals(entity.get要介護状態区分コード()) || STR_13.equals(entity.get要介護状態区分コード()))
                && STR_1.equals(entity.get居宅サービス計画作成区分コード())) {
            return true;
        }
        if ((STR_21.equals(entity.get要介護状態区分コード())
                || STR_22.equals(entity.get要介護状態区分コード())
                || STR_23.equals(entity.get要介護状態区分コード())
                || STR_24.equals(entity.get要介護状態区分コード())
                || STR_25.equals(entity.get要介護状態区分コード()))
                && STR_3.equals(entity.get居宅サービス計画作成区分コード())) {
            return true;
        }
        return false;
    }

    private boolean 前履歴資格喪失年月日Check(IdoTblTmpEntity entity, IdoTblTmpEntity 前履歴) {
        if (!isDateEmpty(前履歴.get資格喪失年月日())) {
            return true;
        }
        return false;
    }

    private boolean 前履歴証記載保険者番号Check(IdoTblTmpEntity entity, IdoTblTmpEntity 前履歴) {
        if (entity.get証記載保険者番号() != null
                && 前履歴.get証記載保険者番号() != null
                && !entity.get証記載保険者番号().equals(前履歴.get証記載保険者番号())) {
            return true;
        }
        return false;
    }

    private FlexibleDate 次異動日取得(List<IdoTblTmpEntity> allData, IdoTblTmpEntity cloneEntity) {
        FlexibleDate 次異動日 = cloneEntity.get異動年月日();
        for (IdoTblTmpEntity idoTblTmpEntity : allData) {
            if (次異動日.equals(idoTblTmpEntity.get異動年月日())) {
                次異動日 = 次異動日.plusDay(ORDER_1);
                continue;
            }
            return 次異動日;
        }
        return 次異動日;
    }

    private boolean is年月同じ(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date1) || isDateEmpty(date2)) {
            return false;
        }
        return date1.getYearMonth().equals(date2.getYearMonth());
    }

}
