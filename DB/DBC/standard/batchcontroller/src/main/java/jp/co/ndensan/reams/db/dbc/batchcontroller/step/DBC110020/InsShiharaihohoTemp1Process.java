/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.HyojunFutanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdoTblTmpEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.JushochitokureiInfoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.KyotakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.PSMInfoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.ShafukugemmenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.SoufuErrorTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.TokuteiNyusyoshaInfoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 異動一時１テーブルの作成を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class InsShiharaihohoTemp1Process extends BatchProcessBase<IdouTblEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select異動一時");
    private static final RString 異動一時1_TABLE_NAME = new RString("IdoTblTmp");
    private static final RString 送付エラー一時_TABLE_NAME = new RString("SoufuError");
    private static final RString SPLIT = new RString(",");
    private static final RString 支払方法変更 = new RString("支払方法変更");
    private static final RString 給付額減額 = new RString("給付額減額");
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
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");
    private static final RString コード_1 = new RString("1");
    private static final RString コード_2 = new RString("2");
    private static final RString コード_4 = new RString("4");
    private static final RString コード_11 = new RString("11");
    private static final RString コード_12 = new RString("12");
    private static final RString コード_13 = new RString("13");
    private static final RString コード_21 = new RString("21");
    private static final RString コード_22 = new RString("22");
    private static final RString コード_23 = new RString("23");
    private static final RString コード_24 = new RString("24");
    private static final RString コード_25 = new RString("25");
    private static final RString コード_43 = new RString("43");
    private static final RString コード_46 = new RString("46");
    private static final RString 区分_4 = new RString("4");
    private static final RString MAX_DATE = new RString("99999999");
    private static final RString エラーコード_25 = new RString("25");
    private static final RString エラー内容_25 = new RString("資格登録されていません。");
    private static final RString エラーコード_26 = new RString("26");
    private static final RString エラー内容_26 = new RString("資格・受給整合性エラー");
    private static final RString エラーコード_29 = new RString("29");
    private static final RString エラー内容_29 = new RString("要介護度変更申請日エラー");
    private static final RString エラーコード_22 = new RString("22");
    private static final RString エラー内容_22 = new RString("計画作成指定事業者が存在しない");
    private static final RString エラーコード_40 = new RString("40");
    private static final RString エラー内容_40 = new RString("居宅サービス計画事業者が終了");
    private static final RString エラーコード_31 = new RString("31");
    private static final RString エラー内容_31 = new RString("居宅サービス計画開始日不整合");
    private static final RString エラーコード_45 = new RString("45");
    private static final RString エラー内容_45 = new RString("要支援１・２者：介護事業所届出");
    private static final RString エラーコード_44 = new RString("44");
    private static final RString エラー内容_44 = new RString("要介護者：予防事業所届出");
    private static final RString エラーコード_28 = new RString("28");
    private static final RString エラー内容_28 = new RString("標準負担減額期間不整合エラー");
    private static final RString エラーコード_30 = new RString("30");
    private static final RString エラー内容_30 = new RString("標準負担減額申請日エラー");
    private static final RString エラーコード_27 = new RString("27");
    private static final RString エラー内容_27 = new RString("利用者負担減額期間不整合エラー");
    private static final RString エラーコード_33 = new RString("33");
    private static final RString エラー内容_33 = new RString("利用者負担減免申請日エラー");
    private static final RString エラーコード_32 = new RString("32");
    private static final RString エラー内容_32 = new RString("支払方法変更適用開始日不整合エラー");
    private static final RString エラーコード_34 = new RString("34");
    private static final RString エラー内容_34 = new RString("給付額減額適用開始日不整合エラー");
    private static final RString エラーコード_42 = new RString("42");
    private static final RString エラー内容_42 = new RString("特定入所者減免期間不整合エラー");
    private static final RString エラーコード_43 = new RString("43");
    private static final RString エラー内容_43 = new RString("特定入所者減免申請日エラー");
    private static final RString エラーコード_41 = new RString("41");
    private static final RString エラー内容_41 = new RString("社会福祉法人軽減期間不整合");
    private static final RString エラーコード_48 = new RString("48");
    private static final RString エラー内容_48 = new RString("資格・総合事業対象者整合性エラー");
    private static final RString エラーコード_49 = new RString("49");
    private static final RString エラー内容_49 = new RString("総合事業受給の終了日を事業対象者に登録してください");
    private static final RString エラーコード_50 = new RString("50");
    private static final RString エラー内容_50 = new RString("住所地特例者の施設情報に誤りがあります");
    private static final RString エラーコード_51 = new RString("51");
    private static final RString エラー内容_51 = new RString("事業対象者：居宅計画サービス届出日エラー");
    private static final RString エラーあり = new RString("1");
    private static final RString エラーなし = new RString("0");

    private List<IdouTblEntity> 異動一時List;
    private int 履歴番号 = 1;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時1tableWriter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 送付エラー一時tableWriter;

    @Override
    protected void initialize() {
        異動一時List = new ArrayList<>();
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        異動一時1tableWriter
                = new BatchEntityCreatedTempTableWriter(異動一時1_TABLE_NAME, IdoTblTmpEntity.class);
        送付エラー一時tableWriter
                = new BatchEntityCreatedTempTableWriter(送付エラー一時_TABLE_NAME, SoufuErrorTblEntity.class);
    }

    @Override
    protected void process(IdouTblEntity entity) {
        異動一時List.add(entity);
        if (entity.get連番() != entity.get被保険者番号Max連番()) {
            return;
        }
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = get受給者台帳();
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
        List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List = get二次予防();
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List = get二割負担();
        異動一時List.clear();
        if (被保険者台帳List.isEmpty() && !受給者台帳List.isEmpty()) {
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                送付エラー新規1(受給者台帳, 宛名情報);
            }
        } else {
            資格_受給整合性Check(受給者台帳List, 被保険者台帳List, 宛名情報);
            要介護度変更申請日Check(受給者台帳List, 被保険者台帳List, 宛名情報);
            計画作成指定事業者Check(受給者台帳List, 被保険者台帳List, 居宅計画List, 宛名情報);
            居宅サービス計画事業者Check(受給者台帳List, 被保険者台帳List, 居宅計画List, 宛名情報);
            居宅サービス計画開始日不整合Check(受給者台帳List, 被保険者台帳List, 居宅計画List, 宛名情報);
            介護事業所届出Check(受給者台帳List, 被保険者台帳List, 居宅計画List, 宛名情報);
            予防事業所届出Check(受給者台帳List, 被保険者台帳List, 居宅計画List, 宛名情報);
            標準負担減額期間不整合Check(受給者台帳List, 被保険者台帳List, 標準負担List, 宛名情報);
            標準負担減額申請日Check(受給者台帳List, 被保険者台帳List, 標準負担List, 宛名情報);
            利用者負担減額期間不整合Check(受給者台帳List, 被保険者台帳List, 利用者負担List, 宛名情報);
            利用者負担減免申請日Check(受給者台帳List, 被保険者台帳List, 利用者負担List, 宛名情報);
            支払方法変更適用開始日不整合Check(受給者台帳List, 被保険者台帳List, 支払方法変更List, 宛名情報);
            給付額減額適用開始日不整合Check(受給者台帳List, 被保険者台帳List, 給付額減額List, 宛名情報);
            特定入所者減免期間不整合Check(受給者台帳List, 被保険者台帳List, 特定入所者List, 宛名情報);
            特定入所者減免申請日Check(受給者台帳List, 被保険者台帳List, 特定入所者List, 宛名情報);
            社会福祉法人軽減期間不整合Check(受給者台帳List, 被保険者台帳List, 社福減免List, 宛名情報);
            資格_総合事業対象者整合性Check(受給者台帳List, 被保険者台帳List, 総合事業対象者List, 宛名情報);
            総合事業受給の終了日Check(受給者台帳List, 被保険者台帳List, 総合事業対象者List, 宛名情報);
            住所地特例者の施設情報Check(受給者台帳List, 被保険者台帳List, 住所地特例List, 宛名情報);
            居宅計画サービス届出日Check(受給者台帳List, 被保険者台帳List, 総合事業対象者List, 居宅計画List, 宛名情報);
        }
        IdoTblTmpEntity idoTblTmpEntity = new IdoTblTmpEntity();
        set宛名情報(idoTblTmpEntity, 宛名情報);
        set受給者台帳(idoTblTmpEntity, 受給者台帳List);
        set被保険者台帳(idoTblTmpEntity, 被保険者台帳List);
        set居宅計画(idoTblTmpEntity, 居宅計画List);
        set支払方法変更(idoTblTmpEntity, 支払方法変更List);
        set利用者負担(idoTblTmpEntity, 利用者負担List);
        set標準負担(idoTblTmpEntity, 標準負担List);
        set特定入所者(idoTblTmpEntity, 特定入所者List);
        set社福減免(idoTblTmpEntity, 社福減免List);
        set後期高齢者情報(idoTblTmpEntity, 後期高齢者情報List);
        set国保資格情報(idoTblTmpEntity, 国保資格情報List);
        set二次予防(idoTblTmpEntity, 二次予防List);
        set住所地特例(idoTblTmpEntity, 住所地特例List);
        set二割負担(idoTblTmpEntity, 二割負担List);
        idoTblTmpEntity.set異動年月日(RString.EMPTY);
        idoTblTmpEntity.set履歴番号(new RString(履歴番号));
        ++履歴番号;
        idoTblTmpEntity.set異動区分コード(RString.EMPTY);
        idoTblTmpEntity.set受給者異動事由(RString.EMPTY);
        idoTblTmpEntity.set証記載保険者番号(RString.EMPTY);
        idoTblTmpEntity.set老人保健市町村番号(RString.EMPTY);
        idoTblTmpEntity.set老人保健受給者番号(RString.EMPTY);
        idoTblTmpEntity.set公費負担者番号(RString.EMPTY);
        idoTblTmpEntity.set広域連合_政令市_保険者番号(RString.EMPTY);
        idoTblTmpEntity.set申請種別コード(RString.EMPTY);
        idoTblTmpEntity.set変更申請中区分コード(RString.EMPTY);
        idoTblTmpEntity.set公費負担上限額減額有フラグ(RString.EMPTY);
        idoTblTmpEntity.set減免申請中区分コード(RString.EMPTY);
        idoTblTmpEntity.set利用者負担区分コード(RString.EMPTY);
        idoTblTmpEntity.set標準負担区分コード(RString.EMPTY);
        idoTblTmpEntity.set特定入所者認定申請中区分コード(RString.EMPTY);
        idoTblTmpEntity.set特定入所者介護サービス区分コード(RString.EMPTY);
        idoTblTmpEntity.set課税層の特例減額措置対象フラグ(RString.EMPTY);
        idoTblTmpEntity.set小多機能居宅介護利用開始月利用有フラグ(RString.EMPTY);
        idoTblTmpEntity.set二次予防事業区分コード(RString.EMPTY);
        idoTblTmpEntity.set訂正連絡票フラグ(RString.EMPTY);
        //TODO
        idoTblTmpEntity.set送付年月(RString.EMPTY);
        idoTblTmpEntity.set居宅費_新１_負担限度額(RString.EMPTY);
        idoTblTmpEntity.set居宅費_新２_負担限度額(RString.EMPTY);
        idoTblTmpEntity.set居宅費_新３_負担限度額(RString.EMPTY);
        idoTblTmpEntity.set訂正区分コード(RString.EMPTY);
        idoTblTmpEntity.set訂正年月日(RString.EMPTY);
        idoTblTmpEntity.set論理削除フラグ(RString.EMPTY);
        //TODO
        idoTblTmpEntity.setエラーフラグ(エラーあり);
        異動一時1tableWriter.insert(idoTblTmpEntity);
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

    private void 資格_受給整合性Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty()) {
            return;
        }
        boolean has有効区分 = false;
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
            if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
                continue;
            }
            has有効区分 = true;
            break;
        }
        if (!has有効区分) {
            return;
        }
        boolean hasError = true;
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                FlexibleDate 認定開始日 = 受給者台帳.getNinteiYukoKikanKaishiYMD();
                if (isDateEmpty(認定開始日)) {
                    return;
                }
                FlexibleDate 資格取得日 = 被保険者台帳.getShikakuShutokuYMD();
                if (資格取得日 != null && 資格取得日.isBeforeOrEquals(認定開始日)) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規2(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 宛名情報);
        }
    }

    private void 要介護度変更申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty()) {
            return;
        }
        boolean hasError = true;
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            Code 受給申請事由 = 受給者台帳.getJukyuShinseiJiyu();
            RString 申請状況区分 = 受給者台帳.getShinseiJokyoKubun();
            Code 有効無効区分 = 受給者台帳.getYukoMukoKubun();
            if (!(受給申請事由 != null && 区分_4.equals(受給申請事由.getColumnValue()) && 区分_0.equals(申請状況区分)
                    && 有効無効区分 != null && 区分_1.equals(有効無効区分.getColumnValue()))) {
                continue;
            }
            if (isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 受給者台帳.getJukyuShinseiYMD())
                    && isBeforeDate(受給者台帳.getJukyuShinseiYMD(), 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                hasError = false;
            }
            if (!hasError) {
                break;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 受給者台帳.getJukyuShinseiYMD())
                        && isBeforeDate(受給者台帳.getJukyuShinseiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                }
                if (!hasError) {
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規3(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 宛名情報);
        }
    }

    private void 計画作成指定事業者Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        boolean hasError = true;
        for (KyotakuEntity 居宅計画 : 居宅計画List) {
            if (!RString.isNullOrEmpty(居宅計画.getサービス種類コード())) {
                hasError = false;
            }
        }
        if (hasError) {
            送付エラー新規4(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 居宅計画List.get(ORDER_0), 宛名情報);
        }
    }

    private void 居宅サービス計画事業者Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        boolean hasError = false;
        for (KyotakuEntity 居宅計画 : 居宅計画List) {
            if (!コード_43.equals(居宅計画.getサービス種類コード()) && !コード_46.equals(居宅計画.getサービス種類コード())) {
                continue;
            }
            if (isDateEmpty(居宅計画.get有効終了日())) {
                continue;
            }
            if (居宅計画.get有効終了日().isBefore(居宅計画.get適用開始日())) {
                hasError = true;
            }

        }
        if (hasError) {
            送付エラー新規5(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 居宅計画List.get(ORDER_0), 宛名情報);
        }
    }

    private void 居宅サービス計画開始日不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        boolean hasError = true;
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            for (KyotakuEntity 居宅計画entity : 居宅計画List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 居宅計画entity.get適用開始日())
                        && isBeforeDate(居宅計画entity.get適用開始日(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        送付エラー新規6(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 居宅計画List.get(ORDER_0), 宛名情報);
    }

    private void 介護事業所届出Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        boolean hasError = false;
        for (KyotakuEntity 居宅計画entity : 居宅計画List) {
            if (!コード_1.equals(居宅計画entity.get居宅サービス計画作成区分コード())
                    && !コード_2.equals(居宅計画entity.get居宅サービス計画作成区分コード())) {
                continue;
            }
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                if (!(isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 居宅計画entity.get適用開始日())
                        && isBeforeDate(居宅計画entity.get適用開始日(), 受給者台帳.getNinteiYukoKikanShuryoYMD()))) {
                    continue;
                }
                Code 要介護認定状態区分コード = 受給者台帳.getYokaigoJotaiKubunCode();
                if (要介護認定状態区分コード != null && (コード_11.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_12.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_13.equals(要介護認定状態区分コード.getColumnValue()))) {
                    hasError = true;
                    break;
                }
            }
            if (hasError) {
                break;
            }
        }
        送付エラー新規7(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 居宅計画List.get(ORDER_0), 宛名情報);
    }

    private void 予防事業所届出Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        boolean hasError = false;
        for (KyotakuEntity 居宅計画entity : 居宅計画List) {
            if (!コード_4.equals(居宅計画entity.get居宅サービス計画作成区分コード())) {
                continue;
            }
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                if (!(isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 居宅計画entity.get適用開始日())
                        && isBeforeDate(居宅計画entity.get適用開始日(), 受給者台帳.getNinteiYukoKikanShuryoYMD()))) {
                    continue;
                }
                Code 要介護認定状態区分コード = 受給者台帳.getYokaigoJotaiKubunCode();
                if (要介護認定状態区分コード != null && (コード_21.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_22.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_23.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_24.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_25.equals(要介護認定状態区分コード.getColumnValue()))) {
                    hasError = true;
                    break;
                }
            }
            if (hasError) {
                break;
            }
        }
        送付エラー新規8(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 居宅計画List.get(ORDER_0), 宛名情報);
    }

    private void 標準負担減額期間不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<HyojunFutanEntity> 標準負担List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 標準負担List.isEmpty()) {
            return;
        }
        boolean doCheck = false;
        for (HyojunFutanEntity 標準負担entity : 標準負担List) {
            if (isDateEmpty(標準負担entity.get適用開始日()) || isDateEmpty(標準負担entity.get適用終了日())) {
                continue;
            }
            doCheck = true;
            break;
        }
        if (!doCheck) {
            return;
        }
        boolean hasError = true;
        for (HyojunFutanEntity 標準負担entity : 標準負担List) {
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 標準負担entity.get適用開始日())
                        && isBeforeDate(標準負担entity.get適用開始日(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        送付エラー新規9(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 標準負担List.get(ORDER_0), 宛名情報);
    }

    private void 標準負担減額申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<HyojunFutanEntity> 標準負担List, PSMInfoEntity 宛名情報) {
        if (!isDo標準負担減額申請日Check(受給者台帳List, 被保険者台帳List, 標準負担List)) {
            return;
        }
        boolean hasError = true;
        for (HyojunFutanEntity 標準負担entity : 標準負担List) {
            FlexibleDate 申請日 = 標準負担entity.get申請日();
            if (isDateEmpty(申請日)) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 申請日)
                        && isBeforeDate(申請日, 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
                if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
                    continue;
                }
                if (isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 申請日)
                        && isBeforeDate(申請日, 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規10(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 標準負担List.get(ORDER_0), 宛名情報);
        }
    }

    private boolean isDo標準負担減額申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<HyojunFutanEntity> 標準負担List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 標準負担List.isEmpty()) {
            return false;
        }
        boolean doCheck = false;
        for (HyojunFutanEntity 標準負担entity : 標準負担List) {
            if (isDateEmpty(標準負担entity.get適用開始日()) && isDateEmpty(標準負担entity.get適用終了日())) {
                doCheck = true;
                break;
            }
        }
        return doCheck;
    }

    private void 利用者負担減額期間不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 利用者負担List.isEmpty()) {
            return;
        }
        boolean doCheckFlag = false;
        for (DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity : 利用者負担List) {
            if (!isDateEmpty(利用者負担entity.getTekiyoKaishiYMD()) && !isDateEmpty(利用者負担entity.getTekiyoShuryoYMD())) {
                doCheckFlag = true;
                break;
            }
        }
        if (!doCheckFlag) {
            return;
        }
        boolean hasError = true;
        for (DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity : 利用者負担List) {
            if (isDateEmpty(利用者負担entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 利用者負担entity.getTekiyoKaishiYMD())
                        && isBeforeDate(利用者負担entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        送付エラー新規11(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 利用者負担List.get(ORDER_0), 宛名情報);
    }

    private void 利用者負担減免申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List, PSMInfoEntity 宛名情報) {
        if (!isDo利用者負担減免申請日Check(受給者台帳List, 被保険者台帳List, 利用者負担List)) {
            return;
        }
        boolean hasError = true;
        for (DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity : 利用者負担List) {
            FlexibleDate 申請日 = 利用者負担entity.getShinseiYMD();
            if (isDateEmpty(申請日)) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 申請日)
                        && isBeforeDate(申請日, 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
                if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
                    continue;
                }
                if (isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 申請日)
                        && isBeforeDate(申請日, 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規12(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 利用者負担List.get(ORDER_0), 宛名情報);
        }
    }

    private boolean isDo利用者負担減免申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 利用者負担List.isEmpty()) {
            return false;
        }
        boolean doCheck = false;
        for (DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity : 利用者負担List) {
            if (isDateEmpty(利用者負担entity.getTekiyoKaishiYMD()) && isDateEmpty(利用者負担entity.getTekiyoShuryoYMD())) {
                doCheck = true;
                break;
            }
        }
        return doCheck;
    }

    private void 支払方法変更適用開始日不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List, PSMInfoEntity 宛名情報) {
        if (!isDo支払方法変更適用開始日Check(受給者台帳List, 被保険者台帳List, 支払方法変更List)) {
            return;
        }
        boolean hasError = true;
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity : 支払方法変更List) {
            if (isDateEmpty(支払方法変更entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 支払方法変更entity.getTekiyoKaishiYMD())
                        && isBeforeDate(支払方法変更entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規13(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 宛名情報);
        }
    }

    private boolean isDo支払方法変更適用開始日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 支払方法変更List.isEmpty()) {
            return false;
        }
        boolean doCheck = false;
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity : 支払方法変更List) {
            if (!isDateEmpty(支払方法変更entity.getTekiyoKaishiYMD()) && !isDateEmpty(支払方法変更entity.getTekiyoShuryoYMD())) {
                doCheck = true;
                break;
            }
        }
        return doCheck;
    }

    private void 給付額減額適用開始日不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT4021ShiharaiHohoHenkoEntity> 給付額減額List,
            PSMInfoEntity 宛名情報) {
        if (!isDo支払方法変更適用開始日Check(受給者台帳List, 被保険者台帳List, 給付額減額List)) {
            return;
        }
        boolean hasError = true;
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity : 給付額減額List) {
            if (isDateEmpty(支払方法変更entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 支払方法変更entity.getTekiyoKaishiYMD())
                        && isBeforeDate(支払方法変更entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規14(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 宛名情報);
        }
    }

    private void 特定入所者減免期間不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<TokuteiNyusyoshaInfoEntity> 特定入所者List, PSMInfoEntity 宛名情報) {
        if (!isDo特定入所者減免期間不整合Check(受給者台帳List, 被保険者台帳List, 特定入所者List)) {
            return;
        }
        boolean hasError = true;
        for (TokuteiNyusyoshaInfoEntity 特定入所者entity : 特定入所者List) {
            if (isDateEmpty(特定入所者entity.get適用開始日())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 特定入所者entity.get適用開始日())
                        && isBeforeDate(特定入所者entity.get適用開始日(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規15(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 特定入所者List.get(ORDER_0), 宛名情報);
        }
    }

    private boolean isDo特定入所者減免期間不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<TokuteiNyusyoshaInfoEntity> 特定入所者List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 特定入所者List.isEmpty()) {
            return false;
        }
        boolean doCheck = false;
        for (TokuteiNyusyoshaInfoEntity 特定入所者entity : 特定入所者List) {
            if (!isDateEmpty(特定入所者entity.get適用開始日()) && !isDateEmpty(特定入所者entity.get適用終了日())) {
                doCheck = true;
                break;
            }
        }
        return doCheck;
    }

    private void 特定入所者減免申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<TokuteiNyusyoshaInfoEntity> 特定入所者List, PSMInfoEntity 宛名情報) {
        if (!isDo特定入所者減免申請日Check(受給者台帳List, 被保険者台帳List, 特定入所者List)) {
            return;
        }
        boolean hasError = true;
        for (TokuteiNyusyoshaInfoEntity 特定入所者entity : 特定入所者List) {
            FlexibleDate 申請日 = 特定入所者entity.get申請日();
            if (isDateEmpty(申請日)) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 申請日)
                        && isBeforeDate(申請日, 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
                if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
                    continue;
                }
                if (isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 申請日)
                        && isBeforeDate(申請日, 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規16(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 特定入所者List.get(ORDER_0), 宛名情報);
        }
    }

    private boolean isDo特定入所者減免申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<TokuteiNyusyoshaInfoEntity> 特定入所者List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 特定入所者List.isEmpty()) {
            return false;
        }
        boolean doCheck = false;
        for (TokuteiNyusyoshaInfoEntity 利用者負担entity : 特定入所者List) {
            if (isDateEmpty(利用者負担entity.get適用開始日()) && isDateEmpty(利用者負担entity.get適用終了日())) {
                doCheck = true;
                break;
            }
        }
        return doCheck;
    }

    private void 社会福祉法人軽減期間不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<ShafukugemmenEntity> 社福減免List, PSMInfoEntity 宛名情報) {
        if (!isDo社会福祉法人軽減期間不整合Check(受給者台帳List, 被保険者台帳List, 社福減免List)) {
            return;
        }
        boolean hasError = true;
        for (ShafukugemmenEntity 社福減免entity : 社福減免List) {
            if (isDateEmpty(社福減免entity.get適用開始日())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 社福減免entity.get適用開始日())
                        && isBeforeDate(社福減免entity.get適用開始日(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規17(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 社福減免List.get(ORDER_0), 宛名情報);
        }
    }

    private boolean isDo社会福祉法人軽減期間不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<ShafukugemmenEntity> 社福減免List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 社福減免List.isEmpty()) {
            return false;
        }
        boolean doCheck = false;
        for (ShafukugemmenEntity 社福減免entity : 社福減免List) {
            if (!isDateEmpty(社福減免entity.get適用開始日()) && !isDateEmpty(社福減免entity.get適用終了日())) {
                doCheck = true;
                break;
            }
        }
        return doCheck;
    }

    private void 資格_総合事業対象者整合性Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 総合事業対象者List.isEmpty()) {
            return;
        }
        boolean hasError = true;
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者entity : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 総合事業対象者entity.getTekiyoKaishiYMD())
                        && isBeforeDate(総合事業対象者entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    hasError = false;
                    break;
                }
            }
            if (!hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規18(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 宛名情報);
        }
    }

    private void 総合事業受給の終了日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            PSMInfoEntity 宛名情報) {
        if (!isDo総合事業受給の終了日Check(受給者台帳List, 被保険者台帳List, 総合事業対象者List)) {
            return;
        }
        boolean hasError = false;
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者entity : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                if (!(isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 総合事業対象者entity.getTekiyoKaishiYMD())
                        && isBeforeDate(総合事業対象者entity.getTekiyoKaishiYMD(), 受給者台帳.getNinteiYukoKikanShuryoYMD()))) {
                    continue;
                }
                if (!isBeforeDate(総合事業対象者entity.getTekiyoKaishiYMD(), 受給者台帳.getNinteiYMD())) {
                    continue;
                }
                Code 要介護認定状態区分コード = 受給者台帳.getYokaigoJotaiKubunCode();
                if (要介護認定状態区分コード == null || !(コード_21.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_22.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_23.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_24.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_25.equals(要介護認定状態区分コード.getColumnValue()))) {
                    continue;
                }
                if (isDateEmpty(総合事業対象者entity.getTekiyoShuryoYMD())
                        || isBeforeDate(受給者台帳.getNinteiYukoKikanShuryoYMD(), 総合事業対象者entity.getTekiyoShuryoYMD())) {
                    hasError = true;
                    break;
                }
            }
            if (hasError) {
                break;
            }
        }
        if (hasError) {
            送付エラー新規19(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 宛名情報);
        }
    }

    private boolean isDo総合事業受給の終了日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 総合事業対象者List.isEmpty()) {
            return false;
        }
        return true;
    }

    private void 住所地特例者の施設情報Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<JushochitokureiInfoEntity> 住所地特例List,
            PSMInfoEntity 宛名情報) {
        //TODO QA
//        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 住所地特例List.isEmpty()) {
//            return;
//        }
//        boolean hasError = true;
//        for (JushochitokureiInfoEntity 住所地特例entity : 住所地特例List) {
//            if (isDateEmpty(住所地特例entity.get)) {
//                continue;
//            }
//            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
//                if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 総合事業対象者entity.getTekiyoKaishiYMD())
//                        && isBeforeDate(総合事業対象者entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
//                    hasError = false;
//                    break;
//                }
//            }
//            if (!hasError) {
//                break;
//            }
//        }
//        if (hasError) {
//            送付エラー新規18(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 宛名情報);
//        }
    }

    private void 居宅計画サービス届出日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            List<KyotakuEntity> 居宅計画List,
            PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 総合事業対象者List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        boolean hasError = 居宅計画サービス届出日Check1(総合事業対象者List, 居宅計画List);
        if (hasError) {
            送付エラー新規21(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 宛名情報);
            return;
        }
        hasError = 居宅計画サービス届出日Check2(総合事業対象者List, 居宅計画List);
        if (hasError) {
            送付エラー新規21(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 宛名情報);
        }
    }

    private boolean 居宅計画サービス届出日Check1(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            List<KyotakuEntity> 居宅計画List) {
        boolean hasError = true;
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者entity : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (KyotakuEntity 居宅計画 : 居宅計画List) {
                if (isDateEmpty(居宅計画.get適用開始日()) || isDateEmpty(居宅計画.get届出年月日())) {
                    continue;
                }
                if (総合事業対象者entity.getTekiyoKaishiYMD().equals(居宅計画.get適用開始日())
                        && 総合事業対象者entity.getTekiyoKaishiYMD().equals(居宅計画.get届出年月日())
                        && 区分_4.equals(居宅計画.get居宅サービス計画作成区分コード())) {
                    hasError = false;
                }
            }
            if (!hasError) {
                break;
            }
        }
        return hasError;
    }

    private boolean 居宅計画サービス届出日Check2(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            List<KyotakuEntity> 居宅計画List) {
        boolean hasError = true;
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者entity : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者entity.getTekiyoKaishiYMD())) {
                continue;
            }
            if (isDateEmpty(総合事業対象者entity.getTekiyoShuryoYMD())) {
                continue;
            }
            for (KyotakuEntity 居宅計画 : 居宅計画List) {
                if (isDateEmpty(居宅計画.get適用開始日()) || isDateEmpty(居宅計画.get届出年月日())) {
                    continue;
                }
                RString 適用終了日 = new RString(総合事業対象者entity.getTekiyoShuryoYMD().toString());
                if (総合事業対象者entity.getTekiyoKaishiYMD().equals(居宅計画.get適用開始日())
                        && 総合事業対象者entity.getTekiyoKaishiYMD().equals(居宅計画.get届出年月日())
                        && 区分_4.equals(居宅計画.get居宅サービス計画作成区分コード())
                        && MAX_DATE.equals(適用終了日)
                        && 総合事業対象者entity.getTekiyoShuryoYMD().isBeforeOrEquals(居宅計画.get届出年月日())) {
                    hasError = false;
                }
            }
            if (!hasError) {
                break;
            }
        }
        return hasError;
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

    private void 送付エラー新規1(DbT4001JukyushaDaichoEntity 受給者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, null, 宛名情報);
        entity.setエラーコード(エラーコード_25);
        entity.setエラー内容(エラー内容_25);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規2(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_26);
        entity.setエラー内容(エラー内容_26);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規3(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_29);
        entity.setエラー内容(エラー内容_29);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規4(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, KyotakuEntity 居宅計画entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set居宅事業者番号(居宅計画entity.get計画事業者番号());
        entity.set居宅適用開始日(居宅計画entity.get適用開始日());
        entity.setエラーコード(エラーコード_22);
        entity.setエラー内容(エラー内容_22);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規5(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, KyotakuEntity 居宅計画entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set居宅事業者番号(居宅計画entity.get計画事業者番号());
        entity.set居宅適用開始日(居宅計画entity.get適用開始日());
        entity.setエラーコード(エラーコード_40);
        entity.setエラー内容(エラー内容_40);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規6(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, KyotakuEntity 居宅計画entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set居宅事業者番号(居宅計画entity.get計画事業者番号());
        entity.set居宅適用開始日(居宅計画entity.get適用開始日());
        entity.setエラーコード(エラーコード_31);
        entity.setエラー内容(エラー内容_31);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規7(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, KyotakuEntity 居宅計画entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set居宅事業者番号(居宅計画entity.get計画事業者番号());
        entity.set居宅適用開始日(居宅計画entity.get適用開始日());
        entity.setエラーコード(エラーコード_45);
        entity.setエラー内容(エラー内容_45);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規8(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, KyotakuEntity 居宅計画entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set居宅事業者番号(居宅計画entity.get計画事業者番号());
        entity.set居宅適用開始日(居宅計画entity.get適用開始日());
        entity.setエラーコード(エラーコード_44);
        entity.setエラー内容(エラー内容_44);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規9(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, HyojunFutanEntity 標準負担entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set標準負担適用開始日(標準負担entity.get適用開始日());
        entity.set標準負担適用終了日(標準負担entity.get適用終了日());
        entity.setエラーコード(エラーコード_28);
        entity.setエラー内容(エラー内容_28);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規10(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, HyojunFutanEntity 標準負担entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set標準負担適用開始日(標準負担entity.get適用開始日());
        entity.set標準負担適用終了日(標準負担entity.get適用終了日());
        entity.setエラーコード(エラーコード_30);
        entity.setエラー内容(エラー内容_30);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規11(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set利用者負担申請日(利用者負担entity.getShinseiYMD());
        entity.set利用者負担適用開始日(利用者負担entity.getTekiyoKaishiYMD());
        entity.set利用者負担適用終了日(利用者負担entity.getTekiyoShuryoYMD());
        entity.setエラーコード(エラーコード_27);
        entity.setエラー内容(エラー内容_27);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規12(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set利用者負担申請日(利用者負担entity.getShinseiYMD());
        entity.set利用者負担適用開始日(利用者負担entity.getTekiyoKaishiYMD());
        entity.set利用者負担適用終了日(利用者負担entity.getTekiyoShuryoYMD());
        entity.setエラーコード(エラーコード_33);
        entity.setエラー内容(エラー内容_33);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規13(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_32);
        entity.setエラー内容(エラー内容_32);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規14(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_34);
        entity.setエラー内容(エラー内容_34);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規15(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, TokuteiNyusyoshaInfoEntity 特定入所者entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set特定申請日(特定入所者entity.get申請日());
        entity.set特定適用開始日(特定入所者entity.get適用開始日());
        entity.set特定適用終了日(特定入所者entity.get適用終了日());
        entity.setエラーコード(エラーコード_42);
        entity.setエラー内容(エラー内容_42);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規16(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, TokuteiNyusyoshaInfoEntity 特定入所者entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set特定申請日(特定入所者entity.get申請日());
        entity.set特定適用開始日(特定入所者entity.get適用開始日());
        entity.set特定適用終了日(特定入所者entity.get適用終了日());
        entity.setエラーコード(エラーコード_43);
        entity.setエラー内容(エラー内容_43);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規17(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, ShafukugemmenEntity 社福減免entity, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set社会福祉適用開始日(社福減免entity.get適用開始日());
        entity.set社会福祉適用終了日(社福減免entity.get適用終了日());
        entity.setエラーコード(エラーコード_41);
        entity.setエラー内容(エラー内容_41);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規18(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_48);
        entity.setエラー内容(エラー内容_48);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規19(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_49);
        entity.setエラー内容(エラー内容_49);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規21(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_51);
        entity.setエラー内容(エラー内容_51);
        送付エラー一時tableWriter.insert(entity);
    }

    private SoufuErrorTblEntity 送付エラーCommon(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = new SoufuErrorTblEntity();
        entity.set被保険者番号(受給者台帳.getHihokenshaNo());
        if (宛名情報.getカナ名称() != null) {
            entity.set氏名カナ(宛名情報.getカナ名称().getColumnValue());
        }
        if (宛名情報.get名称() != null) {
            entity.set氏名(宛名情報.get名称().getColumnValue());
        }
        if (被保険者台帳 != null) {
            entity.set資格取得日(被保険者台帳.getShikakuShutokuYMD());
            entity.set資格喪失日(被保険者台帳.getShikakuSoshitsuYMD());
        } else {
            entity.set資格取得日(FlexibleDate.EMPTY);
            entity.set資格喪失日(FlexibleDate.EMPTY);
        }
        entity.set要介護状態区分コード(受給者台帳.getYokaigoJotaiKubunCode());
        entity.set要介護認定申請日(受給者台帳.getJukyuShinseiYMD());
        entity.set認定開始日(受給者台帳.getNinteiYukoKikanKaishiYMD());
        entity.set認定終了日(受給者台帳.getNinteiYukoKikanKaishiYMD());
        entity.set居宅事業者番号(JigyoshaNo.EMPTY);
        entity.set居宅適用開始日(FlexibleDate.EMPTY);
        entity.set特定申請日(FlexibleDate.EMPTY);
        entity.set特定適用開始日(FlexibleDate.EMPTY);
        entity.set特定適用終了日(FlexibleDate.EMPTY);
        entity.set利用者負担申請日(FlexibleDate.EMPTY);
        entity.set利用者負担適用開始日(FlexibleDate.EMPTY);
        entity.set利用者負担適用終了日(FlexibleDate.EMPTY);
        entity.set社会福祉適用開始日(FlexibleDate.EMPTY);
        entity.set社会福祉適用終了日(FlexibleDate.EMPTY);
        entity.set標準負担適用開始日(FlexibleDate.EMPTY);
        entity.set標準負担適用終了日(FlexibleDate.EMPTY);
        entity.set償還払化開始日(FlexibleDate.EMPTY);
        entity.set給付率引下げ開始日(FlexibleDate.EMPTY);
        entity.set作成年月日(FlexibleDate.getNowDate());
        //TODO
        entity.set処理年月(RYearMonth.MAX);
        return entity;
    }

    private boolean isBeforeDate(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date1) || isDateEmpty(date2)) {
            return false;
        }
        return date1.isBefore(date2);
    }

    private boolean isDateEmpty(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return true;
        }
        return false;
    }

    private void set宛名情報(IdoTblTmpEntity idoTblTmpEntity, PSMInfoEntity 宛名情報) {
        if (宛名情報.getカナ名称() != null) {
            idoTblTmpEntity.set被保険者氏名カナ(宛名情報.getカナ名称().getColumnValue());
        }
        if (宛名情報.get生年月日() != null) {
            idoTblTmpEntity.set生年月日(new RString(宛名情報.get生年月日().toString()));
        }
        idoTblTmpEntity.set性別コード(宛名情報.get性別());
    }

    private void set受給者台帳(IdoTblTmpEntity idoTblTmpEntity, List<DbT4001JukyushaDaichoEntity> 受給者台帳List) {
        if (受給者台帳List.isEmpty()) {
            return;
        }
        DbT4001JukyushaDaichoEntity 受給者台帳 = 受給者台帳List.get(ORDER_0);
        FlexibleDate 申請年月日 = 受給者台帳.getJukyuShinseiYMD();
        if (申請年月日 != null) {
            idoTblTmpEntity.set申請年月日(new RString(申請年月日.toString()));
        }
        Code みなし要介護状態区分コード = 受給者台帳.getMinashiCode();
        if (みなし要介護状態区分コード != null) {
            idoTblTmpEntity.setみなし要介護状態区分コード(みなし要介護状態区分コード.getColumnValue());
        }
        Code 要介護状態区分コード = 受給者台帳.getYokaigoJotaiKubunCode();
        if (要介護状態区分コード != null) {
            idoTblTmpEntity.set要介護状態区分コード(要介護状態区分コード.getColumnValue());
        }
        FlexibleDate 認定有効期間開始年月日 = 受給者台帳.getNinteiYukoKikanKaishiYMD();
        if (認定有効期間開始年月日 != null) {
            idoTblTmpEntity.set認定有効期間開始年月日(new RString(認定有効期間開始年月日.toString()));
        }
        FlexibleDate 認定有効期間終了年月日 = 受給者台帳.getNinteiYukoKikanShuryoYMD();
        if (認定有効期間終了年月日 != null) {
            idoTblTmpEntity.set認定有効期間終了年月日(new RString(認定有効期間終了年月日.toString()));
        }
        Decimal 訪問通所サービス支給限度基準額 = 受給者台帳.getShikyuGendoTanisu();
        if (訪問通所サービス支給限度基準額 != null) {
            idoTblTmpEntity.set訪問通所サービス支給限度基準額(new RString(訪問通所サービス支給限度基準額.toString()));
        }
        FlexibleDate 訪問通所サービス上限管理適用期間開始年月日 = 受給者台帳.getShikyuGendoKaishiYMD();
        if (訪問通所サービス上限管理適用期間開始年月日 != null) {
            idoTblTmpEntity.set訪問通所サービス上限管理適用期間開始年月日(new RString(訪問通所サービス上限管理適用期間開始年月日.toString()));
        }
        FlexibleDate 訪問通所サービス上限管理適用期間終了年月日 = 受給者台帳.getShikyuGendoShuryoYMD();
        if (訪問通所サービス上限管理適用期間終了年月日 != null) {
            idoTblTmpEntity.set訪問通所サービス上限管理適用期間終了年月日(new RString(訪問通所サービス上限管理適用期間終了年月日.toString()));
        }
        idoTblTmpEntity.set短期入所サービス支給限度基準額(new RString(受給者台帳.getTankiSikyuGendoNissu()));
        FlexibleDate 短期入所サービス上限管理適用期間開始年月日 = 受給者台帳.getTankiShikyuGendoKaishiYMD();
        if (短期入所サービス上限管理適用期間開始年月日 != null) {
            idoTblTmpEntity.set短期入所サービス上限管理適用期間開始年月日(new RString(短期入所サービス上限管理適用期間開始年月日.toString()));
        }
        FlexibleDate 短期入所サービス上限管理適用期間終了年月日 = 受給者台帳.getTankiShikyuGendoShuryoYMD();
        if (短期入所サービス上限管理適用期間終了年月日 != null) {
            idoTblTmpEntity.set短期入所サービス上限管理適用期間終了年月日(new RString(短期入所サービス上限管理適用期間終了年月日.toString()));
        }
        idoTblTmpEntity.set被保険者番号(受給者台帳.getHihokenshaNo().getColumnValue());
    }

    private void set被保険者台帳(IdoTblTmpEntity idoTblTmpEntity, List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        if (被保険者台帳List.isEmpty()) {
            return;
        }
        DbT1001HihokenshaDaichoEntity 被保険者台帳 = 被保険者台帳List.get(ORDER_0);
        FlexibleDate 資格取得年月日 = 被保険者台帳.getShikakuShutokuYMD();
        if (資格取得年月日 != null) {
            idoTblTmpEntity.set資格取得年月日(new RString(資格取得年月日.toString()));
        }
        FlexibleDate 資格喪失年月日 = 被保険者台帳.getShikakuSoshitsuYMD();
        if (資格喪失年月日 != null) {
            idoTblTmpEntity.set資格喪失年月日(new RString(資格喪失年月日.toString()));
        }
        if (被保険者台帳.getShichosonCode() != null) {
            idoTblTmpEntity.set市町村コード(被保険者台帳.getShichosonCode().getColumnValue());
        }
    }

    private void set居宅計画(IdoTblTmpEntity idoTblTmpEntity, List<KyotakuEntity> 居宅計画List) {
        if (居宅計画List.isEmpty()) {
            return;
        }
        KyotakuEntity 居宅計画 = 居宅計画List.get(ORDER_0);
        FlexibleDate 居宅サービス計画適用開始年月日 = 居宅計画.get適用開始日();
        if (居宅サービス計画適用開始年月日 != null) {
            idoTblTmpEntity.set居宅サービス計画適用開始年月日(new RString(居宅サービス計画適用開始年月日.toString()));
        }
        FlexibleDate 居宅サービス計画適用終了年月日 = 居宅計画.get適用終了日();
        if (居宅サービス計画適用終了年月日 != null) {
            idoTblTmpEntity.set居宅サービス計画適用終了年月日(new RString(居宅サービス計画適用終了年月日.toString()));
        }
        idoTblTmpEntity.set居宅サービス計画作成区分コード(居宅計画.get居宅サービス計画作成区分コード());
        if (居宅計画.get委託先事業者番号() != null) {
            idoTblTmpEntity.set居宅介護支援事業所番号(居宅計画.get委託先事業者番号().getColumnValue());
        }
    }

    private void set支払方法変更(IdoTblTmpEntity idoTblTmpEntity, List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List) {
        if (支払方法変更List.isEmpty()) {
            return;
        }
        DbT4021ShiharaiHohoHenkoEntity 支払方法変更Enity = 支払方法変更List.get(ORDER_0);
        FlexibleDate 償還払化開始年月日 = 支払方法変更Enity.getTekiyoKaishiYMD();
        if (償還払化開始年月日 != null) {
            idoTblTmpEntity.set償還払化開始年月日(new RString(償還払化開始年月日.toString()));
        }

        FlexibleDate 給付率引下げ開始年月日 = 支払方法変更Enity.getTekiyoKaishiYMD();
        if (給付率引下げ開始年月日 != null) {
            idoTblTmpEntity.set給付率引下げ開始年月日(new RString(給付率引下げ開始年月日.toString()));
        }

        FlexibleDate 給付率引下げ終了年月日 = 支払方法変更Enity.getTekiyoShuryoYMD();
        if (給付率引下げ終了年月日 != null) {
            idoTblTmpEntity.set給付率引下げ終了年月日(new RString(給付率引下げ終了年月日.toString()));
        }

    }

    private void set利用者負担(IdoTblTmpEntity idoTblTmpEntity, List<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> 利用者負担List) {
        if (利用者負担List.isEmpty()) {
            return;
        }
        DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担 = 利用者負担List.get(ORDER_0);
        FlexibleDate 適用開始年月日 = 利用者負担.getTekiyoKaishiYMD();
        if (適用開始年月日 != null) {
            idoTblTmpEntity.set適用開始年月日(new RString(適用開始年月日.toString()));
        }

        FlexibleDate 適用終了年月日 = 利用者負担.getTekiyoShuryoYMD();
        if (適用終了年月日 != null) {
            idoTblTmpEntity.set適用終了年月日(new RString(適用終了年月日.toString()));
        }
        HokenKyufuRitsu 給付率 = 利用者負担.getKyufuritsu();
        if (給付率 != null) {
            idoTblTmpEntity.set給付率(new RString(給付率.toString()));
        }

    }

    private void set標準負担(IdoTblTmpEntity idoTblTmpEntity, List<HyojunFutanEntity> 標準負担List) {
        if (標準負担List.isEmpty()) {
            return;
        }
        HyojunFutanEntity 標準負担 = 標準負担List.get(ORDER_0);
        FlexibleDate 負担額適用開始年月日 = 標準負担.get適用開始日();
        if (負担額適用開始年月日 != null) {
            idoTblTmpEntity.set負担額適用開始年月日(new RString(負担額適用開始年月日.toString()));
        }

        FlexibleDate 負担額適用終了年月日 = 標準負担.get適用終了日();
        if (負担額適用終了年月日 != null) {
            idoTblTmpEntity.set負担額適用終了年月日(new RString(負担額適用終了年月日.toString()));
        }
        Decimal 負担額 = 標準負担.get負担額();
        if (負担額 != null) {
            idoTblTmpEntity.set負担額(new RString(負担額.toString()));
        }
    }

    private void set特定入所者(IdoTblTmpEntity idoTblTmpEntity, List<TokuteiNyusyoshaInfoEntity> 特定入所者List) {
        if (特定入所者List.isEmpty()) {
            return;
        }
        TokuteiNyusyoshaInfoEntity 特定入所者 = 特定入所者List.get(ORDER_0);
        FlexibleDate 負担限度額適用開始年月日 = 特定入所者.get適用開始日();
        if (負担限度額適用開始年月日 != null) {
            idoTblTmpEntity.set負担限度額適用開始年月日(new RString(負担限度額適用開始年月日.toString()));
        }
        FlexibleDate 負担限度額適用終了年月日 = 特定入所者.get適用終了日();
        if (負担限度額適用終了年月日 != null) {
            idoTblTmpEntity.set負担限度額適用終了年月日(new RString(負担限度額適用終了年月日.toString()));
        }
        Decimal 食費負担限度額 = 特定入所者.get食費負担限度額();
        if (食費負担限度額 != null) {
            idoTblTmpEntity.set食費負担限度額(new RString(食費負担限度額.toString()));
        }

        Decimal 居住費ユニット型個室負担限度額 = 特定入所者.getユニット型個室();
        if (居住費ユニット型個室負担限度額 != null) {
            idoTblTmpEntity.set居住費ユニット型個室負担限度額(new RString(居住費ユニット型個室負担限度額.toString()));
        }

        Decimal 居住費ユニット型準個室負担限度額 = 特定入所者.getユニット型準個室();
        if (居住費ユニット型準個室負担限度額 != null) {
            idoTblTmpEntity.set居住費ユニット型準個室負担限度額(new RString(居住費ユニット型準個室負担限度額.toString()));
        }

        Decimal 居住費従来型個室特養等負担限度額 = 特定入所者.get従来型個室_特養等();
        if (居住費従来型個室特養等負担限度額 != null) {
            idoTblTmpEntity.set居住費従来型個室特養等負担限度額(new RString(居住費従来型個室特養等負担限度額.toString()));
        }

        Decimal 居住費従来型個室老健療養等負担限度額 = 特定入所者.get従来型個室_老健_療養等();
        if (居住費従来型個室老健療養等負担限度額 != null) {
            idoTblTmpEntity.set居住費従来型個室老健療養等負担限度額(new RString(居住費従来型個室老健療養等負担限度額.toString()));
        }

        Decimal 居住費多床室負担限度額 = 特定入所者.get多床室();
        if (居住費多床室負担限度額 != null) {
            idoTblTmpEntity.set居住費多床室負担限度額(new RString(居住費多床室負担限度額.toString()));
        }
    }

    private void set社福減免(IdoTblTmpEntity idoTblTmpEntity, List<ShafukugemmenEntity> 社福減免List) {
        if (社福減免List.isEmpty()) {
            return;
        }
        ShafukugemmenEntity 社福減免 = 社福減免List.get(ORDER_0);
        FlexibleDate 軽減率適用開始年月日 = 社福減免.get適用開始日();
        if (軽減率適用開始年月日 != null) {
            idoTblTmpEntity.set軽減率適用開始年月日(new RString(軽減率適用開始年月日.toString()));
        }
        FlexibleDate 軽減率適用終了年月日 = 社福減免.get適用終了日();
        if (軽減率適用終了年月日 != null) {
            idoTblTmpEntity.set軽減率適用終了年月日(new RString(軽減率適用終了年月日.toString()));
        }
        idoTblTmpEntity.set軽減率(社福減免.get軽減率());
    }

    private void set後期高齢者情報(IdoTblTmpEntity idoTblTmpEntity, List<DbT7124KokiKoreishaInfoEntity> 後期高齢者情報List) {
        if (後期高齢者情報List.isEmpty()) {
            return;
        }
        DbT7124KokiKoreishaInfoEntity 後期高齢者情報 = 後期高齢者情報List.get(ORDER_0);
        idoTblTmpEntity.set後期高齢者医療保険者番号(後期高齢者情報.getKokiHokenshaNoCity());
        idoTblTmpEntity.set後期高齢者医療被保険者番号(後期高齢者情報.getKokikoreiHihokenshaNo());
    }

    private void set国保資格情報(IdoTblTmpEntity idoTblTmpEntity, List<DbT7123KokuhoShikakuInfoEntity> 国保資格情報List) {
        if (国保資格情報List.isEmpty()) {
            return;
        }
        DbT7123KokuhoShikakuInfoEntity 国保資格情報 = 国保資格情報List.get(ORDER_0);
        idoTblTmpEntity.set国民健康保険保険者番号(国保資格情報.getKokuhoHokenshaNo());
        idoTblTmpEntity.set国民健康保険被保険者証番号(国保資格情報.getKokuhoHokenshaNo());
        idoTblTmpEntity.set国民健康保険個人番号(国保資格情報.getKokuhoKojinNo());
    }

    private void set二次予防(IdoTblTmpEntity idoTblTmpEntity, List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List) {
        if (二次予防List.isEmpty()) {
            return;
        }
        DbT3100NijiYoboJigyoTaishoshaEntity 二次予防 = 二次予防List.get(ORDER_0);
        FlexibleDate 二次予防事業有効期間開始年月日 = 二次予防.getTekiyoKaishiYMD();
        if (二次予防事業有効期間開始年月日 != null) {
            idoTblTmpEntity.set二次予防事業有効期間開始年月日(new RString(二次予防事業有効期間開始年月日.toString()));
        }
        FlexibleDate 二次予防事業有効期間終了年月日 = 二次予防.getTekiyoShuryoYMD();
        if (二次予防事業有効期間終了年月日 != null) {
            idoTblTmpEntity.set二次予防事業有効期間終了年月日(new RString(二次予防事業有効期間終了年月日.toString()));
        }
    }

    private void set住所地特例(IdoTblTmpEntity idoTblTmpEntity, List<JushochitokureiInfoEntity> 住所地特例List) {
        if (住所地特例List.isEmpty()) {
            return;
        }
        JushochitokureiInfoEntity 住所地特例 = 住所地特例List.get(ORDER_0);
        FlexibleDate 住所地特例適用開始日 = 住所地特例.get住所地特例適用開始日();
        if (住所地特例適用開始日 != null) {
            idoTblTmpEntity.set住所地特例適用開始日(new RString(住所地特例適用開始日.toString()));
        }

        FlexibleDate 住所地特例適用終了日 = 住所地特例.get住所地特例適用終了日();
        if (住所地特例適用終了日 != null) {
            idoTblTmpEntity.set住所地特例適用終了日(new RString(住所地特例適用終了日.toString()));
        }
        if (住所地特例.get被保険者番号() == null) {
            idoTblTmpEntity.set住所地特例対象者区分コード(RString.EMPTY);
        } else {
            idoTblTmpEntity.set住所地特例対象者区分コード(コード_1);
            idoTblTmpEntity.set施設所在保険者番号(住所地特例.get被保険者番号().getColumnValue());
        }
    }

    private void set二割負担(IdoTblTmpEntity idoTblTmpEntity, List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List) {
        if (二割負担List.isEmpty()) {
            return;
        }
        DbT3114RiyoshaFutanWariaiMeisaiEntity 二割負担 = 二割負担List.get(ORDER_0);
        FlexibleDate 利用者負担割合有効開始日 = 二割負担.getYukoKaishiYMD();
        if (利用者負担割合有効開始日 != null) {
            idoTblTmpEntity.set利用者負担割合有効開始日(new RString(利用者負担割合有効開始日.toString()));
        }
        FlexibleDate 利用者負担割合有効終了日 = 二割負担.getYukoShuryoYMD();
        if (利用者負担割合有効終了日 != null) {
            idoTblTmpEntity.set利用者負担割合有効終了日(new RString(利用者負担割合有効終了日.toString()));
        }
    }
}
