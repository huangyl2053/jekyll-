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
import jp.co.ndensan.reams.db.dbc.service.core.interfacekanrikousin.UpDoInterfaceKanriKousinManager;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 異動日毎データ抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class InsIdomaiDataTempProcess extends BatchProcessBase<IdouTblEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select異動一時");
    private static final RString 異動一時2_TABLE_NAME = new RString("IdouTemp2");
    private static final RString 支払方法変更 = new RString("支払方法変更");
    private static final RString 給付額減額 = new RString("給付額減額");
    private static final RString STR_01 = new RString("01");
    private static final RString STR_1 = new RString("1");
    private static final RString STR_02 = new RString("02");
    private static final RString STR_2 = new RString("2");
    private static final RString STR_03 = new RString("03");
    private static final RString STR_3 = new RString("3");
    private static final RString STR_4 = new RString("4");
    private static final RString STR_99 = new RString("99");
    private static final RString エラーあり = new RString("1");
    private static final RString エラーなし = new RString("0");
    private static final int ORDER_0 = 0;
    private static final int ORDER_1 = 1;
    private static final Code コート_0 = new Code("0");
    private static final Code コート_1 = new Code("1");
    private static final Code コート_01 = new Code("01");
    private static final Code コート_2 = new Code("2");
    private static final Code コート_4 = new Code("4");
    private static final Code コート_5 = new Code("5");
    private static final Code コート_12 = new Code("12");
    private static final Code コート_13 = new Code("13");
    private static final Code コート_14 = new Code("14");
    private static final Code コート_21 = new Code("21");
    private static final Code コート_22 = new Code("22");
    private static final Code コート_23 = new Code("23");
    private static final Code コート_24 = new Code("24");
    private static final Code コート_25 = new Code("25");
    private static final Code コート_32 = new Code("32");
    private static final int 履歴番号 = 0;
    private static final RString 資格取得事由_11 = new RString("11");
    private static final RString 資格取得事由_13 = new RString("13");
    private static final RString 資格取得事由_17 = new RString("17");
    private static final FlexibleDate MIN_DATE = new FlexibleDate(new RString("20150401"));
    private static final RString 星 = new RString("*");
    private JukyushaIdoRenrakuhyoOutProcessParameter processParameter;
    private List<IdouTblEntity> 異動一時List;
    private Map<FlexibleDate, IdoTblTmpEntity> 異動一時Map;
    private List<HihokenshaNo> エラー異動No;
    private HihokenshaNo 被保険者番号;
    private List<DbT7109KubunShikyuGendoGakuEntity> 居宅サービス区分支給限度額List;
    private ShichosonSecurityJoho 市町村;
    private Map<LasdecCode, ShoKisaiHokenshaNo> 証記載保険者番号Map;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時2tableWriter;

    @Override
    protected void initialize() {
        異動一時List = new ArrayList<>();
        エラー異動No = new ArrayList<>();
        異動一時Map = new HashMap<>();
        証記載保険者番号Map = new HashMap<>();
        居宅サービス区分支給限度額List = UpDoInterfaceKanriKousinManager.createInstance().get居宅サービス区分支給限度額();
        市町村 = ShichosonSecurityJohoFinder.createInstance().
                getShichosonSecurityJoho(GyomuBunrui.介護事務);
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
        if (エラー異動No.contains(entity.get被保険者番号())) {
            return;
        }
        if (エラーあり.equals(entity.getエラーフラグ())) {
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
        System.out.println(entity.get被保険者番号().getColumnValue());
        PSMInfoEntity 宛名情報 = JukyushaIdoRenrakuhyoOutCommonProcess.get宛名(異動一時List);
        if (宛名情報 == null) {
            異動一時List.clear();
            異動一時Map.clear();
            return;
        }
        被保険者番号 = entity.get被保険者番号();
//        if (!被保険者番号.equals(new HihokenshaNo("2016111601"))) {
//            異動一時List.clear();
//            異動一時Map.clear();
//            return;
//        }
        FlexibleYearMonth 処理年月 = new FlexibleYearMonth(processParameter.get処理年月().toDateString());
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = JukyushaIdoRenrakuhyoOutCommonProcess.get受給者台帳(異動一時List);
        List<KyotakuEntity> 居宅計画List = JukyushaIdoRenrakuhyoOutCommonProcess.get居宅計画(異動一時List);
        List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List
                = JukyushaIdoRenrakuhyoOutCommonProcess.get総合事業対象者(異動一時List);
        総合事業対象者適用開始年月日設定(総合事業対象者List, 居宅計画List);
        受給者台帳処理(受給者台帳List, 処理年月, 総合事業対象者List);
        List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List = JukyushaIdoRenrakuhyoOutCommonProcess.get二次予防(異動一時List);
        二次予防処理(二次予防List, 処理年月);
        総合事業対象者処理(受給者台帳List, 総合事業対象者List, 処理年月);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = JukyushaIdoRenrakuhyoOutCommonProcess.get被保険者台帳(異動一時List);
        被保険者台帳(被保険者台帳List, 処理年月);
        居宅計画処理(居宅計画List, 処理年月);
        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = JukyushaIdoRenrakuhyoOutCommonProcess.get支払方法(異動一時List, 支払方法変更);
        支払方法変更処理(支払方法変更List, 処理年月);
        List<DbT4021ShiharaiHohoHenkoEntity> 給付額減額List = JukyushaIdoRenrakuhyoOutCommonProcess.get支払方法(異動一時List, 給付額減額);
        給付額減額処理(給付額減額List, 処理年月);
        List<HyojunFutanEntity> 標準負担List = JukyushaIdoRenrakuhyoOutCommonProcess.get標準負担(異動一時List);
        標準負担処理(標準負担List, 処理年月);
        List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List = JukyushaIdoRenrakuhyoOutCommonProcess.get利用者負担(異動一時List);
        利用者負担処理(利用者負担List, 処理年月);
        List<TokuteiNyusyoshaInfoEntity> 特定入所者List = JukyushaIdoRenrakuhyoOutCommonProcess.get特定入所者(異動一時List);
        特定入所者処理(特定入所者List, 処理年月);
        List<ShafukugemmenEntity> 社福減免List = JukyushaIdoRenrakuhyoOutCommonProcess.get社福減免(異動一時List);
        社福減免処理(社福減免List, 処理年月);
        List<JushochitokureiInfoEntity> 住所地特例List = JukyushaIdoRenrakuhyoOutCommonProcess.get住所地特例(異動一時List, 被保険者台帳List);
        住所地特例(住所地特例List, 処理年月);
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List = JukyushaIdoRenrakuhyoOutCommonProcess.get二割負担(異動一時List);
        負担割合処理(二割負担List, 処理年月);
        List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List = JukyushaIdoRenrakuhyoOutCommonProcess.get生活保護受給者(異動一時List);
        生活保護受給者まとめる(生活保護受給者List);
        生活保護受給者(生活保護受給者List, 処理年月);
        DbT7124KokiKoreishaInfoEntity 後期高齢者 = JukyushaIdoRenrakuhyoOutCommonProcess.get後期高齢者(異動一時List);
        DbT7123KokuhoShikakuInfoEntity 国保資格 = JukyushaIdoRenrakuhyoOutCommonProcess.get国保資格(異動一時List);
        List<IdoTblTmpEntity> allData = new ArrayList<>();
        for (IdoTblTmpEntity 異動一時 : 異動一時Map.values()) {
            allData.add(異動一時);
        }
        引き継ぎ処理(allData);
        for (int i = allData.size() - 1; i > -1; i--) {
            IdoTblTmpEntity 異動一時entity = allData.get(i);
            不要データ削除(異動一時entity, i, allData);
        }
        if (!allData.isEmpty()) {
            再編集(allData, 宛名情報, 処理年月, 後期高齢者, 国保資格);
        }
        int 番号 = 1;
        for (IdoTblTmpEntity idoTblTmpEntity : allData) {
            idoTblTmpEntity.set履歴番号(番号);
            ++番号;
            異動一時2tableWriter.insert(idoTblTmpEntity);
        }
        異動一時List.clear();
        異動一時Map.clear();
    }

    private void 受給者台帳処理(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            FlexibleYearMonth 処理年月, List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List) {
        boolean 無効データFlag = false;
        異動一時2By受給者台帳パターン1Check(受給者台帳List, 総合事業対象者List, 処理年月);
        異動一時2By受給者台帳パターン2Check(受給者台帳List, 処理年月);
        異動一時2By受給者台帳パターン3Check(受給者台帳List, 処理年月, 無効データFlag);
        異動一時2By受給者台帳パターン4Check(受給者台帳List, 処理年月, 無効データFlag);
        異動一時2By受給者台帳パターン5Check(受給者台帳List, 処理年月, 無効データFlag);
        異動一時2By総合事業対象者パターン5Check(受給者台帳List, 総合事業対象者List, 無効データFlag);
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
        異動一時2By総合事業対象者パターン5Check(受給者台帳List, 処理年月);
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

    private void 利用者負担処理(List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List, FlexibleYearMonth 処理年月) {
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
        異動一時2By被保険者台帳パターン4Check(被保険者台帳List, 処理年月);
        異動一時2By被保険者台帳パターン5Check(被保険者台帳List, 処理年月);
    }

    private void 生活保護受給者(List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List, FlexibleYearMonth 処理年月) {
        異動一時2By生活保護受給者パターン1Check(生活保護受給者List, 処理年月);
        異動一時2By生活保護受給者パターン2Check(生活保護受給者List, 処理年月);
    }

    private void 異動一時2By受給者台帳パターン1Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            FlexibleYearMonth 処理年月) {
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (コート_1.equals(受給者台帳.getYukoMukoKubun()) && isDateEmpty(受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                continue;
            }
            if (!コート_1.equals(受給者台帳.getYukoMukoKubun())
                    || !isBeforeYearMonth(受給者台帳.getNinteiYukoKikanKaishiYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(受給者台帳.getNinteiYukoKikanKaishiYMD());
            if (isDateEmpty(異動年月日)) {
                continue;
            }
            if (異動一時Map.containsKey(異動年月日)) {
                RString 要介護状態区分コード = 異動一時Map.get(異動年月日).get要介護状態区分コード();
                if (RString.isNullOrEmpty(要介護状態区分コード)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            DbT4001JukyushaDaichoEntity 後履歴の有効データ = get後履歴の有効データ(受給者台帳List, 受給者台帳);
            JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By受給者台帳パターン1(
                    insertEntity, 受給者台帳, 異動年月日, 後履歴の有効データ, 被保険者番号, 居宅サービス区分支給限度額List);
            異動年月日 = 総合事業対象者パターン更新Check(総合事業対象者List, 受給者台帳, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private FlexibleDate get翌日異動日(FlexibleDate 異動年月日) {
        FlexibleDate 翌日異動日 = 異動年月日.plusDay(ORDER_1);
        for (int i = ORDER_0; i < 異動一時Map.size(); i++) {
            if (異動一時Map.containsKey(翌日異動日)) {
                翌日異動日 = 異動年月日.plusDay(ORDER_1);
                continue;
            }
            return 翌日異動日;
        }
        return 異動年月日.plusDay(異動一時Map.size());
    }

    private void 異動一時2By受給者台帳パターン2Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List, FlexibleYearMonth 処理年月) {
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (コート_0.equals(受給者台帳.getYukoMukoKubun())
                    && コート_4.equals(受給者台帳.getJukyuShinseiJiyu())
                    && isBeforeYearMonth(受給者台帳.getJukyuShinseiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(受給者台帳.getJukyuShinseiYMD());
                if (isDateEmpty(異動年月日)) {
                    continue;
                }
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By受給者台帳パターン2(
                        insertEntity, 受給者台帳, 異動年月日, 被保険者番号);
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
            if (isDateEmpty(受給者台帳.getNinteiYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(受給者台帳.getNinteiYMD(), 処理年月)) {
                continue;
            }
            if (!コート_32.equals(受給者台帳.getDataKubun())) {
                continue;
            }
            if (前後履歴の有効Check(受給者台帳List, 受給者台帳, 受給者台帳.getNinteiYMD())) {
                IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
                FlexibleDate 異動年月日 = 受給者台帳.getNinteiYMD();
                if (異動一時Map.containsKey(異動年月日)) {
                    異動年月日 = get翌日異動日(異動年月日);
                }
                JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By受給者台帳パターン3(insertEntity, 異動年月日, 被保険者番号);
                異動一時Map.put(異動年月日, insertEntity);
                無効データFlag = true;
                break;
            }
        }
    }

    private void 異動一時2By受給者台帳パターン4Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
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
            if (isDateEmpty(受給者台帳.getNinteiYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(受給者台帳.getNinteiYMD(), 処理年月)) {
                continue;
            }
            if (!コート_01.equals(受給者台帳.getYokaigoJotaiKubunCode())) {
                continue;
            }
            if (前後履歴の有効Check(受給者台帳List, 受給者台帳, 受給者台帳.getNinteiYMD())) {
                IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
                FlexibleDate 異動年月日 = 受給者台帳.getNinteiYMD();
                if (異動一時Map.containsKey(異動年月日)) {
                    異動年月日 = get翌日異動日(異動年月日);
                }
                JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By受給者台帳パターン3(
                        insertEntity, 異動年月日, 被保険者番号);
                異動一時Map.put(異動年月日, insertEntity);
                無効データFlag = true;
                break;
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
            if (isDateEmpty(受給者台帳.getSoshitsuYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(受給者台帳.getSoshitsuYMD(), 処理年月)) {
                continue;
            }
            if (!コート_14.equals(受給者台帳.getDataKubun())) {
                continue;
            }
            if (前後履歴の有効Check(受給者台帳List, 受給者台帳, 受給者台帳.getSoshitsuYMD())) {
                IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
                FlexibleDate 異動年月日 = 受給者台帳.getSoshitsuYMD();
                if (異動一時Map.containsKey(異動年月日)) {
                    異動年月日 = get翌日異動日(異動年月日);
                }
                JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By受給者台帳パターン3(
                        insertEntity, 異動年月日, 被保険者番号);
                異動一時Map.put(異動年月日, insertEntity);
                無効データFlag = true;
                break;
            }
        }
    }

    private void 異動一時2By総合事業対象者パターン5Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            boolean 無効データFlag) {
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
            if (isDateEmpty(受給者台帳.getSoshitsuYMD())) {
                continue;
            }
            if (コート_4.equals(受給者台帳.getJukyuShinseiJiyu())
                    || コート_5.equals(受給者台帳.getJukyuShinseiJiyu())) {
                continue;
            }
            for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
                if (isDateEmpty(総合事業対象者.getTekiyoShuryoYMD())
                        && isBeforeOreqDate(総合事業対象者.getTekiyoKaishiYMD(), 受給者台帳.getJukyuShinseiYMD())) {
                    IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
                    FlexibleDate 異動年月日 = 受給者台帳.getSoshitsuYMD();
                    if (異動一時Map.containsKey(異動年月日)) {
                        異動年月日 = get翌日異動日(異動年月日);
                    }
                    JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By受給者台帳パターン3(
                            insertEntity, 異動年月日, 被保険者番号);
                    異動一時Map.put(異動年月日, insertEntity);
                    無効データFlag = true;
                    break;
                }
                if (!isDateEmpty(総合事業対象者.getTekiyoShuryoYMD())
                        && isBeforeOreqDate(総合事業対象者.getTekiyoKaishiYMD(), 受給者台帳.getJukyuShinseiYMD())
                        && isBeforeOreqDate(受給者台帳.getJukyuShinseiYMD(), 総合事業対象者.getTekiyoShuryoYMD())) {
                    IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
                    FlexibleDate 異動年月日 = 受給者台帳.getSoshitsuYMD();
                    if (異動一時Map.containsKey(異動年月日)) {
                        異動年月日 = get翌日異動日(異動年月日);
                    }
                    JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By受給者台帳パターン3(
                            insertEntity, 異動年月日, 被保険者番号);
                    異動一時Map.put(異動年月日, insertEntity);
                    無効データFlag = true;
                    break;
                }
            }
        }
    }

    private boolean 前後履歴の有効Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate checkDate) {
        DbT4001JukyushaDaichoEntity 前履歴 = get前履歴の有効データ(受給者台帳List, 受給者台帳);
        if (前履歴 != null) {
            if (!コート_12.equals(前履歴.getYokaigoJotaiKubunCode()) && !コート_13.equals(前履歴.getYokaigoJotaiKubunCode())) {
                return false;
            }
            if (isBeforeDate(前履歴.getNinteiYukoKikanKaishiYMD(), checkDate)
                    && isBeforeDate(checkDate, 前履歴.getNinteiYukoKikanShuryoYMD())) {
                return true;
            }
        }
        DbT4001JukyushaDaichoEntity 後履歴 = get後履歴の有効データ(受給者台帳List, 受給者台帳);
        if (後履歴 != null && isBeforeDate(後履歴.getNinteiYukoKikanKaishiYMD(), checkDate)
                && isBeforeDate(checkDate, 後履歴.getNinteiYukoKikanShuryoYMD())) {
            return true;
        }
        return false;
    }

    private void 異動一時2By二次予防パターン1Check(List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List,
            FlexibleYearMonth 処理年月) {
        for (DbT3100NijiYoboJigyoTaishoshaEntity 二次予防 : 二次予防List) {
            if (isDateEmpty(二次予防.getTekiyoKaishiYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(二次予防.getTekiyoKaishiYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(二次予防.getTekiyoKaishiYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (isDateEmpty(異動一時Map.get(異動年月日).get二次予防事業有効期間開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By二次予防パターン1(insertEntity, 二次予防, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By二次予防パターン2Check(List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List,
            FlexibleYearMonth 処理年月) {
        for (DbT3100NijiYoboJigyoTaishoshaEntity 二次予防 : 二次予防List) {
            if (isDateEmpty(二次予防.getTekiyoShuryoYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(二次予防.getTekiyoShuryoYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(二次予防.getTekiyoShuryoYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (isDateEmpty(異動一時Map.get(異動年月日).get二次予防事業有効期間開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By二次予防パターン2(insertEntity, 二次予防, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
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
            if (isDateEmpty(総合事業対象者.getTekiyoKaishiYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(総合事業対象者.getTekiyoKaishiYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(総合事業対象者.getTekiyoKaishiYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get要介護状態区分コード())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By総合事業対象者パターン1(
                    insertEntity, 総合事業対象者, 異動年月日, 被保険者番号, 居宅サービス区分支給限度額List);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By総合事業対象者パターン2Check(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            FlexibleYearMonth 処理年月) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者.getTekiyoShuryoYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(総合事業対象者.getTekiyoShuryoYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(総合事業対象者.getTekiyoShuryoYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get要介護状態区分コード())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By総合事業対象者パターン2(
                    insertEntity, 総合事業対象者, 異動年月日, 被保険者番号, 居宅サービス区分支給限度額List);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By総合事業対象者パターン3Check(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            FlexibleYearMonth 処理年月) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者.getTekiyoKaishiYMD())) {
                continue;
            }
            if (!is月末(総合事業対象者.getTekiyoShuryoYMD())) {
                continue;
            }
            FlexibleDate 適用終了日 = 総合事業対象者.getTekiyoShuryoYMD();
            if (isDateEmpty(適用終了日)) {
                continue;
            }
            FlexibleDate 適用終了日の翌月 = 適用終了日.plusMonth(ORDER_1);
            if (isBeforeYearMonth(適用終了日の翌月, 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(総合事業対象者.getTekiyoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By総合事業対象者パターン1(
                        insertEntity, 総合事業対象者, 異動年月日, 被保険者番号, 居宅サービス区分支給限度額List);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By総合事業対象者パターン4Check(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            FlexibleYearMonth 処理年月) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者.getTekiyoKaishiYMD())) {
                continue;
            }
            if (!is月末(総合事業対象者.getTekiyoShuryoYMD())) {
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
                JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By総合事業対象者パターン1(
                        insertEntity, 総合事業対象者, 異動年月日, 被保険者番号, 居宅サービス区分支給限度額List);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private FlexibleDate 総合事業対象者パターン更新Check(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate 異動年月日) {
        if (!(コート_21.equals(受給者台帳.getYokaigoJotaiKubunCode())
                || コート_22.equals(受給者台帳.getYokaigoJotaiKubunCode())
                || コート_23.equals(受給者台帳.getYokaigoJotaiKubunCode())
                || コート_24.equals(受給者台帳.getYokaigoJotaiKubunCode())
                || コート_25.equals(受給者台帳.getYokaigoJotaiKubunCode()))) {
            return 異動年月日;
        }
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            if (!isBeforeOreqDate(総合事業対象者.getTekiyoKaishiYMD(), 受給者台帳.getNinteiYMD())) {
                continue;
            }
            if (!(!isDateEmpty(総合事業対象者.getTekiyoShuryoYMD())
                    && isBeforeOreqDate(総合事業対象者.getTekiyoShuryoYMD(), 受給者台帳.getNinteiYukoKikanShuryoYMD()))) {
                continue;
            }
            FlexibleDate 適用終了年月日 = 総合事業対象者.getTekiyoShuryoYMD();
            if (isDateEmpty(適用終了年月日)) {
                continue;
            }
            if ((isBeforeOreqDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 総合事業対象者.getTekiyoKaishiYMD())
                    && isBeforeOreqDate(総合事業対象者.getTekiyoKaishiYMD(), 受給者台帳.getNinteiYukoKikanShuryoYMD()))
                    || (isBeforeOreqDate(総合事業対象者.getTekiyoKaishiYMD(), 受給者台帳.getNinteiYukoKikanKaishiYMD())
                    && isBeforeOreqDate(受給者台帳.getNinteiYukoKikanShuryoYMD(), 適用終了年月日))) {
                if (is月末(総合事業対象者.getTekiyoShuryoYMD())) {
                    異動年月日 = get月初(適用終了年月日.plusMonth(ORDER_1));
                } else {
                    異動年月日 = get月初(適用終了年月日).plusDay(ORDER_1);
                }
                return 異動年月日;
            }
        }
        return 異動年月日;
    }

    private void 異動一時2By総合事業対象者パターン5Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (isDateEmpty(受給者台帳.getJukyuShinseiYMD())) {
                continue;
            }
            if (!コート_0.equals(受給者台帳.getYukoMukoKubun())) {
                continue;
            }
            if (コート_4.equals(受給者台帳.getJukyuShinseiJiyu())) {
                continue;
            }
            if (isBeforeYearMonth(受給者台帳.getJukyuShinseiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(受給者台帳.getJukyuShinseiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By総合事業対象者パターン5(
                        insertEntity, 受給者台帳, 異動年月日, 被保険者番号);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By居宅計画パターン1Check(List<KyotakuEntity> 居宅計画List, FlexibleYearMonth 処理年月) {
        for (KyotakuEntity 居宅計画 : 居宅計画List) {
            if (isDateEmpty(居宅計画.get適用開始日())) {
                continue;
            }
            if (!isBeforeYearMonth(居宅計画.get適用開始日(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(居宅計画.get適用開始日());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get居宅サービス計画作成区分コード())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By居宅計画パターン1(insertEntity, 居宅計画, 異動年月日, 被保険者番号);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By居宅計画パターン2Check(List<KyotakuEntity> 居宅計画List, FlexibleYearMonth 処理年月) {
        for (KyotakuEntity 居宅計画 : 居宅計画List) {
            if (isDateEmpty(居宅計画.get適用終了日())) {
                continue;
            }
            if (!isBeforeYearMonth(居宅計画.get適用終了日(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(居宅計画.get適用終了日());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get居宅サービス計画作成区分コード())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By居宅計画パターン2(insertEntity, 居宅計画, 異動年月日, 被保険者番号);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By支払方法パターン1Check(List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List,
            FlexibleYearMonth 処理年月) {
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法 : 支払方法変更List) {
            if (isDateEmpty(支払方法.getTekiyoKaishiYMD())) {
                continue;
            }
            if (!(isBeforeYearMonth(支払方法.getTekiyoKaishiYMD(), 処理年月) && isDateEmpty(支払方法.getTekiyoShuryoYMD()))) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(支払方法.getTekiyoKaishiYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get償還払化開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By支払方法パターン1(insertEntity, 支払方法, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By支払方法パターン2Check(List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List,
            FlexibleYearMonth 処理年月) {
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法 : 支払方法変更List) {
            if (isDateEmpty(支払方法.getTekiyoShuryoYMD())) {
                continue;
            }
            if (!(isBeforeYearMonth(支払方法.getTekiyoKaishiYMD(), 処理年月) && !isDateEmpty(支払方法.getTekiyoShuryoYMD())
                    && 支払方法.getTekiyoKaishiYMD() == 支払方法.getTekiyoShuryoYMD())) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(支払方法.getTekiyoShuryoYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get償還払化開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By支払方法パターン2(insertEntity, 支払方法, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By支払方法パターン3Check(List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List,
            FlexibleYearMonth 処理年月) {
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法 : 支払方法変更List) {
            if (isDateEmpty(支払方法.getTekiyoKaishiYMD())) {
                continue;
            }
            if (isDateEmpty(支払方法.getTekiyoShuryoYMD())) {
                continue;
            }
            if (!(isBeforeYearMonth(支払方法.getTekiyoKaishiYMD(), 処理年月) && !isDateEmpty(支払方法.getTekiyoShuryoYMD())
                    && 支払方法.getTekiyoKaishiYMD() != 支払方法.getTekiyoShuryoYMD()
                    && isBeforeYearMonth(支払方法.getTekiyoShuryoYMD(), 処理年月))) {
                continue;
            }
            IdoTblTmpEntity insertEntity1 = new IdoTblTmpEntity();
            IdoTblTmpEntity insertEntity2 = new IdoTblTmpEntity();
            FlexibleDate 異動年月日1 = get月初(支払方法.getTekiyoKaishiYMD());
            FlexibleDate 異動年月日2 = get月初(支払方法.getTekiyoShuryoYMD());
            if (異動一時Map.containsKey(異動年月日1)) {
                if (isDateEmpty(支払方法.getTekiyoKaishiYMD())) {
                    insertEntity1 = 異動一時Map.get(異動年月日1);
                } else {
                    異動年月日1 = get翌日異動日(異動年月日1);
                }
            }
            set異動一時2By支払方法パターン1(insertEntity1, 支払方法, 異動年月日1);
            異動一時Map.put(異動年月日1, insertEntity1);
            if (異動一時Map.containsKey(異動年月日2)) {
                if (isDateEmpty(支払方法.getTekiyoKaishiYMD())) {
                    insertEntity2 = 異動一時Map.get(異動年月日2);
                } else {
                    異動年月日2 = get翌日異動日(異動年月日2);
                }
            }
            set異動一時2By支払方法パターン2(insertEntity2, 支払方法, 異動年月日2);
            異動一時Map.put(異動年月日2, insertEntity2);
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
            if (isDateEmpty(給付額.getTekiyoKaishiYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(給付額.getTekiyoKaishiYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(給付額.getTekiyoKaishiYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get給付率引下げ開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By給付額減額パターン1(insertEntity, 給付額, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
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
            if (isDateEmpty(標準負担.get適用開始日())) {
                continue;
            }
            if (!isBeforeYearMonth(標準負担.get適用開始日(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(標準負担.get適用開始日());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get負担額適用開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By標準負担パターン1(insertEntity, 標準負担, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void set異動一時2By標準負担パターン1(IdoTblTmpEntity insertEntity,
            HyojunFutanEntity 標準負担, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        if (!STR_2.equals(insertEntity.get減免申請中区分コード())) {
            insertEntity.set減免申請中区分コード(STR_3);
        }
        insertEntity.set標準負担区分コード(STR_1);
        insertEntity.set負担額(標準負担.get負担額());
        insertEntity.set負担限度額適用開始年月日(new RString(異動年月日.toString()));
        FlexibleDate 終了年月日 = get月初(標準負担.get適用終了日());
        insertEntity.set負担額適用終了年月日(new RString(終了年月日.toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By利用者負担パターン1Check(List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List,
            FlexibleYearMonth 処理年月) {
        for (DbT4014RiyoshaFutangakuGengakuEntity 利用者負担 : 利用者負担List) {
            if (isDateEmpty(利用者負担.getTekiyoKaishiYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(利用者負担.getTekiyoKaishiYMD(), 処理年月) && 履歴番号 != 利用者負担.getRirekiNo()) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(利用者負担.getTekiyoKaishiYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get適用開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By利用者負担パターン1(insertEntity, 利用者負担, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By利用者負担パターン2Check(List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List,
            FlexibleYearMonth 処理年月) {
        for (DbT4014RiyoshaFutangakuGengakuEntity 利用者負担 : 利用者負担List) {
            if (isDateEmpty(利用者負担.getShinseiYMD())) {
                continue;
            }
            if (!(isBeforeYearMonth(利用者負担.getShinseiYMD(), 処理年月) && 履歴番号 == 利用者負担.getRirekiNo())) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(利用者負担.getShinseiYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get適用開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By利用者負担パターン2(insertEntity, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void set異動一時2By利用者負担パターン1(IdoTblTmpEntity insertEntity,
            DbT4014RiyoshaFutangakuGengakuEntity 利用者負担, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        if (!STR_2.equals(insertEntity.get減免申請中区分コード())) {
            insertEntity.set減免申請中区分コード(STR_3);
        }
        insertEntity.set利用者負担区分コード(STR_1);
        HokenKyufuRitsu 給付率 = 利用者負担.getKyuhuritsu();
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
            FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set減免申請中区分コード(STR_2);
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By特定入所者パターン1Check(List<TokuteiNyusyoshaInfoEntity> 特定入所者List, FlexibleYearMonth 処理年月) {
        for (TokuteiNyusyoshaInfoEntity 特定入所者 : 特定入所者List) {
            if (isDateEmpty(特定入所者.get適用開始日())) {
                continue;
            }
            if (!isBeforeYearMonth(特定入所者.get適用開始日(), 処理年月) && 履歴番号 != 特定入所者.get履歴番号()) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(特定入所者.get適用開始日());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get負担限度額適用開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By特定入所者パターン1(
                    insertEntity, 特定入所者, 異動年月日, 被保険者番号);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By特定入所者パターン2Check(List<TokuteiNyusyoshaInfoEntity> 特定入所者List, FlexibleYearMonth 処理年月) {
        for (TokuteiNyusyoshaInfoEntity 特定入所者 : 特定入所者List) {
            if (isDateEmpty(特定入所者.get申請日())) {
                continue;
            }
            if (!(isBeforeYearMonth(特定入所者.get申請日(), 処理年月) && 履歴番号 == 特定入所者.get履歴番号())) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(特定入所者.get申請日());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get負担限度額適用開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            JukyushaIdoRenrakuhyoOutCommonProcess.set異動一時2By特定入所者パターン2(insertEntity, 異動年月日,
                    被保険者番号);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By社福減免パターン1Check(List<ShafukugemmenEntity> 社福減免List,
            FlexibleYearMonth 処理年月) {
        for (ShafukugemmenEntity 社福減免 : 社福減免List) {
            if (isDateEmpty(社福減免.get適用開始日())) {
                continue;
            }
            if (!(isBeforeYearMonth(社福減免.get適用開始日(), 処理年月) && 履歴番号 != 社福減免.get履歴番号())) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(社福減免.get適用開始日());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get軽減率適用開始年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By社福減免パターン1(insertEntity, 社福減免, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void set異動一時2By社福減免パターン1(IdoTblTmpEntity insertEntity,
            ShafukugemmenEntity 社福減免, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set軽減率(社福減免.get軽減率());
        insertEntity.set軽減率適用開始年月日(new RString(社福減免.get適用開始日().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By住所地特例パターン1Check(List<JushochitokureiInfoEntity> 住所地特例List,
            FlexibleYearMonth 処理年月) {
        for (JushochitokureiInfoEntity 住所地特例 : 住所地特例List) {
            if (isDateEmpty(住所地特例.get住所地特例適用開始日())) {
                continue;
            }
            if (!isBeforeYearMonth(住所地特例.get住所地特例適用開始日(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(住所地特例.get住所地特例適用開始日());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get住所地特例適用開始日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By住所地特例パターン1(insertEntity, 住所地特例, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By住所地特例パターン2Check(List<JushochitokureiInfoEntity> 住所地特例List,
            FlexibleYearMonth 処理年月) {
        for (JushochitokureiInfoEntity 住所地特例 : 住所地特例List) {
            if (isDateEmpty(住所地特例.get住所地特例適用終了日())) {
                continue;
            }
            if (!isBeforeYearMonth(住所地特例.get住所地特例適用終了日(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(住所地特例.get住所地特例適用終了日());
            if (異動一時Map.containsKey(異動年月日)) {
                if (RString.isNullOrEmpty(異動一時Map.get(異動年月日).get住所地特例適用開始日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By住所地特例パターン2(insertEntity, 住所地特例, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
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
            if (isDateEmpty(負担割合.getYukoKaishiYMD())) {
                continue;
            }
            if (isBeforeYearMonth(負担割合.getYukoKaishiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
                FlexibleDate 異動年月日 = get月初(負担割合.getYukoKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    異動年月日 = get翌日異動日(異動年月日);
                }
                set異動一時2By負担割合パターン1(insertEntity, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By負担割合パターン2Check(List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List,
            FlexibleYearMonth 処理年月) {
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity 負担割合 : 二割負担List) {
            if (isDateEmpty(負担割合.getYukoShuryoYMD())) {
                continue;
            }
            if (isBeforeYearMonth(負担割合.getYukoShuryoYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
                FlexibleDate 異動年月日 = get月初(負担割合.getYukoShuryoYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    異動年月日 = get翌日異動日(異動年月日);
                }
                set異動一時2By負担割合パターン2(insertEntity, 負担割合, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By負担割合パターン1(IdoTblTmpEntity insertEntity,
            FlexibleDate 異動年月日) {
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
        if (適用開始年月日 != null) {
            insertEntity.set利用者負担割合有効開始日(new RString(適用開始年月日.toString()));
        }
        insertEntity.set利用者負担割合有効終了日(new RString(異動年月日.toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By被保険者台帳パターン1Check(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (isDateEmpty(被保険者台帳.getShikakuShutokuYMD())) {
                continue;
            }
            if (!isBeforeYearMonth(被保険者台帳.getShikakuShutokuYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(被保険者台帳.getShikakuShutokuYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (isDateEmpty(異動一時Map.get(異動年月日).get資格取得年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By被保険者台帳パターン1(insertEntity, 被保険者台帳, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By被保険者台帳パターン2Check(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (isDateEmpty(被保険者台帳.getShikakuSoshitsuYMD()) || !isBeforeYearMonth(被保険者台帳.getShikakuSoshitsuYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(被保険者台帳.getShikakuSoshitsuYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (isDateEmpty(異動一時Map.get(異動年月日).get資格取得年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By被保険者台帳パターン2(insertEntity, 被保険者台帳, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By被保険者台帳パターン3Check(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (isDateEmpty(被保険者台帳.getIdoYMD())) {
                continue;
            }
            if (!資格取得事由_11.equals(被保険者台帳.getShikakuShutokuJiyuCode()) || !isBeforeYearMonth(被保険者台帳.getIdoYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(被保険者台帳.getIdoYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (isDateEmpty(異動一時Map.get(異動年月日).get資格取得年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By被保険者台帳パターン3(insertEntity, 被保険者台帳, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By被保険者台帳パターン4Check(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (isDateEmpty(被保険者台帳.getIdoYMD())) {
                continue;
            }
            if (!資格取得事由_13.equals(被保険者台帳.getShikakuShutokuJiyuCode()) || !isBeforeYearMonth(被保険者台帳.getIdoYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(被保険者台帳.getIdoYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (isDateEmpty(異動一時Map.get(異動年月日).get資格取得年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By被保険者台帳パターン3(insertEntity, 被保険者台帳, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void 異動一時2By被保険者台帳パターン5Check(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            FlexibleYearMonth 処理年月) {
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (isDateEmpty(被保険者台帳.getIdoYMD())) {
                continue;
            }
            if (!資格取得事由_17.equals(被保険者台帳.getShikakuShutokuJiyuCode()) || !isBeforeYearMonth(被保険者台帳.getIdoYMD(), 処理年月)) {
                continue;
            }
            IdoTblTmpEntity insertEntity = new IdoTblTmpEntity();
            FlexibleDate 異動年月日 = get月初(被保険者台帳.getIdoYMD());
            if (異動一時Map.containsKey(異動年月日)) {
                if (isDateEmpty(異動一時Map.get(異動年月日).get資格取得年月日())) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    異動年月日 = get翌日異動日(異動年月日);
                }
            }
            set異動一時2By被保険者台帳パターン3(insertEntity, 被保険者台帳, 異動年月日);
            異動一時Map.put(異動年月日, insertEntity);
        }
    }

    private void set異動一時2By被保険者台帳パターン1(IdoTblTmpEntity insertEntity,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        ShoKisaiHokenshaNo 証記載保険者番号;
        LasdecCode 広住特措置元市町村コード = 被保険者台帳.getKoikinaiTokureiSochimotoShichosonCode();
        if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
            証記載保険者番号 = get証記載保険者番号(広住特措置元市町村コード);
        } else {
            証記載保険者番号 = get証記載保険者番号(被保険者台帳.getShichosonCode());
        }
        insertEntity.set証記載保険者番号(証記載保険者番号);
        insertEntity.set資格取得年月日(被保険者台帳.getShikakuShutokuYMD());
        insertEntity.set市町村コード(new RString(被保険者台帳.getShichosonCode().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By被保険者台帳パターン2(IdoTblTmpEntity insertEntity,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        ShoKisaiHokenshaNo 証記載保険者番号;
        LasdecCode 広住特措置元市町村コード = 被保険者台帳.getKoikinaiTokureiSochimotoShichosonCode();
        if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
            証記載保険者番号 = get証記載保険者番号(広住特措置元市町村コード);
        } else {
            証記載保険者番号 = get証記載保険者番号(被保険者台帳.getShichosonCode());
        }
        insertEntity.set証記載保険者番号(証記載保険者番号);
        insertEntity.set資格取得年月日(被保険者台帳.getShikakuShutokuYMD());
        insertEntity.set資格喪失年月日(被保険者台帳.getShikakuSoshitsuYMD());
        insertEntity.set市町村コード(new RString(被保険者台帳.getShichosonCode().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By被保険者台帳パターン3(IdoTblTmpEntity insertEntity,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        ShoKisaiHokenshaNo 証記載保険者番号;
        LasdecCode 広住特措置元市町村コード = 被保険者台帳.getKoikinaiTokureiSochimotoShichosonCode();
        if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
            証記載保険者番号 = get証記載保険者番号(広住特措置元市町村コード);
        } else {
            証記載保険者番号 = get証記載保険者番号(被保険者台帳.getShichosonCode());
        }
        insertEntity.set証記載保険者番号(証記載保険者番号);
        insertEntity.set資格取得年月日(被保険者台帳.getShikakuShutokuYMD());
        insertEntity.set市町村コード(new RString(被保険者台帳.getShichosonCode().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void 異動一時2By生活保護受給者パターン1Check(List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List,
            FlexibleYearMonth 処理年月) {
        for (UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者 : 生活保護受給者List) {
            if (isDateEmpty(生活保護受給者.getJukyuKaishiYMD())) {
                continue;
            }
            if (isBeforeYearMonth(生活保護受給者.getJukyuKaishiYMD(), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(生活保護受給者.getJukyuKaishiYMD());
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By生活保護受給者パターン1(insertEntity, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void 異動一時2By生活保護受給者パターン2Check(List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List,
            FlexibleYearMonth 処理年月) {
        for (UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者 : 生活保護受給者List) {
            if (isDateEmpty(生活保護受給者.getJukyuHaishiYMD())) {
                continue;
            }
            if (!isDateEmpty(生活保護受給者.getJukyuHaishiYMD()) && isBeforeYearMonth(生活保護受給者.getJukyuHaishiYMD().plusMonth(ORDER_1), 処理年月)) {
                IdoTblTmpEntity insertEntity;
                FlexibleDate 異動年月日 = get月初(生活保護受給者.getJukyuHaishiYMD().plusMonth(ORDER_1));
                if (異動一時Map.containsKey(異動年月日)) {
                    insertEntity = 異動一時Map.get(異動年月日);
                } else {
                    insertEntity = new IdoTblTmpEntity();
                }
                set異動一時2By生活保護受給者パターン2(insertEntity, 異動年月日);
                異動一時Map.put(異動年月日, insertEntity);
            }
        }
    }

    private void set異動一時2By生活保護受給者パターン1(IdoTblTmpEntity insertEntity,
            FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set公費負担上限額減額有フラグ(true);
        insertEntity.setエラーフラグ(エラーなし);
    }

    private void set異動一時2By生活保護受給者パターン2(IdoTblTmpEntity insertEntity,
            FlexibleDate 異動年月日) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set公費負担上限額減額有フラグ(false);
        insertEntity.setエラーフラグ(エラーなし);
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
        if (小さいList.isEmpty()) {
            return null;
        }
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
        if (大きいList.isEmpty()) {
            return null;
        }
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
                && !星.equals(異動一時entity.get認定有効期間終了年月日())
                && !RString.isNullOrEmpty(異動一時entity.get居宅サービス計画適用開始年月日())
                && !星.equals(異動一時entity.get居宅サービス計画適用開始年月日())
                && (isBeforeDate(new FlexibleDate(異動一時entity.get居宅サービス計画適用開始年月日()),
                        異動一時entity.get認定有効期間開始年月日())
                || isBeforeDate(new FlexibleDate(異動一時entity.get認定有効期間終了年月日()),
                        new FlexibleDate(異動一時entity.get居宅サービス計画適用開始年月日())))) {
            allData.remove(i);
            return;
        }
        if (isBeforeDate(異動一時entity.get認定有効期間開始年月日(), 異動一時entity.get資格取得年月日())) {
            allData.remove(i);
            return;
        }
        if (isBeforeDate(異動一時entity.get二次予防事業有効期間開始年月日(), 異動一時entity.get資格取得年月日())) {
            allData.remove(i);
        }
    }

    private void 総合事業対象者適用開始年月日設定(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            List<KyotakuEntity> 居宅計画List) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            for (KyotakuEntity 居宅計画 : 居宅計画List) {
                if (!isYMdif(総合事業対象者.getTekiyoKaishiYMD(), 居宅計画.get届出年月日())
                        && !isYMdif(総合事業対象者.getTekiyoKaishiYMD(), 居宅計画.get適用開始日())
                        && STR_4.equals(居宅計画.get居宅サービス計画作成区分コード())) {
                    if (isBeforeDate(居宅計画.get届出年月日(), MIN_DATE)) {
                        総合事業対象者.setTekiyoKaishiYMD(MIN_DATE);
                    } else {
                        総合事業対象者.setTekiyoKaishiYMD(居宅計画.get届出年月日());
                    }
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
        if (date == null || date.isEmpty()) {
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
            System.out.println(entity.get異動年月日().toString());
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
            JukyushaIdoRenrakuhyoOutCommonProcess.引き継ぎデータ処理(entity, 前履歴データ);
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

    private void 再編集(List<IdoTblTmpEntity> allData, PSMInfoEntity 宛名情報, FlexibleYearMonth 処理年月,
            DbT7124KokiKoreishaInfoEntity 後期高齢者, DbT7123KokuhoShikakuInfoEntity 国保資格) {
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
        for (int i = 0; i < allData.size(); i++) {
            IdoTblTmpEntity entity = allData.get(i);
            if (!isDateEmpty(entity.get資格喪失年月日())) {
                entity.set異動区分コード(STR_3);
                entity.set受給者異動事由(STR_02);
            } else if (i == 0) {
                entity.set異動区分コード(STR_1);
                entity.set受給者異動事由(STR_01);
            } else if (前履歴資格喪失年月日Check(allData.get(i - 1))) {
                entity.set異動区分コード(STR_1);
                entity.set受給者異動事由(STR_01);
            } else if (前履歴証記載保険者番号Check(entity, allData.get(i - 1))) {
                entity.set異動区分コード(STR_2);
                entity.set受給者異動事由(STR_03);
            } else {
                entity.set異動区分コード(STR_2);
                entity.set受給者異動事由(STR_99);
            }
            if (宛名情報 != null) {
                entity.set被保険者氏名カナ(宛名情報.getカナ名称() == null
                        ? RString.EMPTY : 宛名情報.getカナ名称().getColumnValue());
                entity.set生年月日(宛名情報.get生年月日());
                entity.set性別コード(宛名情報.get性別());
            }
            if (市町村 != null && DonyuKeitaiCode.事務広域.equals(市町村.get導入形態コード())) {
                entity.set広域連合_政令市_保険者番号(市町村.get市町村情報().get運用保険者番号());
            }
            if (RString.isNullOrEmpty(entity.get要介護状態区分コード())) {
                entity.set要介護状態区分コード(STR_01);
            }
            if (!entity.is公費負担上限額減額有フラグ()) {
                entity.set公費負担上限額減額有フラグ(true);
            }
            JukyushaIdoRenrakuhyoOutCommonProcess.再編集一部(entity);
            entity.set小多機能居宅介護利用開始月利用有フラグ(true);
            RString 後期高齢者資格喪失日 = 後期高齢者.getShikakuSoshitsuYMD();
            FlexibleYearMonth 異動年月 = entity.get異動年月日().getYearMonth();
            if (RString.isNullOrEmpty(後期高齢者資格喪失日)
                    || !new FlexibleDate(後期高齢者資格喪失日).getYearMonth().isBefore(異動年月)) {
                entity.set後期高齢者医療保険者番号(後期高齢者.getKokiHokenshaNoCity());
                entity.set後期高齢者医療被保険者番号(後期高齢者.getKokikoreiHihokenshaNo());
            }
            RString 国保資格資格喪失日 = 国保資格.getShikakuSoshitsuYMD();
            if (RString.isNullOrEmpty(国保資格資格喪失日)
                    || !new FlexibleDate(国保資格資格喪失日).getYearMonth().isBefore(異動年月)) {
                entity.set国民健康保険保険者番号(国保資格.getKokuhoHokenshaNo());
                entity.set国民健康保険被保険者証番号(国保資格.getKokuhoHokenshoNo());
                entity.set国民健康保険個人番号(国保資格.getKokuhoKojinNo());
            }
            entity.set送付年月(処理年月);
            if (宛名情報.get名称() != null) {
                entity.set被保険者氏名(宛名情報.get名称().getColumnValue());
            }
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
            if (isDateEmpty(entity.get認定有効期間開始年月日())) {
                continue;
            }
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

    private boolean 前履歴資格喪失年月日Check(IdoTblTmpEntity 前履歴) {
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

    private ShoKisaiHokenshaNo get証記載保険者番号(LasdecCode 市町村コード) {
        if (証記載保険者番号Map.containsKey(市町村コード)) {
            return 証記載保険者番号Map.get(市町村コード);
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = ShoKisaiHokenshaNo.EMPTY;
        List<ShichosonCodeYoriShichoson> list = KoikiShichosonJohoFinder.createInstance().
                shichosonCodeYoriShichosonJoho(市町村コード).records();
        if (list != null && !list.isEmpty()) {
            証記載保険者番号 = list.get(ORDER_0).get証記載保険者番号();
        }
        証記載保険者番号Map.put(市町村コード, 証記載保険者番号);
        return 証記載保険者番号;
    }
}
