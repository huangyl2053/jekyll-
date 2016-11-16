/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110020.JukyushaIdoRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.HyojunFutanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.JushochitokureiInfoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.KyotakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.PSMInfoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.ShafukugemmenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.SoufuErrorTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.TokuteiNyusyoshaInfoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
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
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");
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
    private static final int ORDER_15 = 15;
    private static final int ORDER_16 = 16;
    private static final Code コート_1 = new Code("1");
    private static final Code コート_0 = new Code("0");
    private static final FlexibleDate チェック_DATE = new FlexibleDate("20150801");
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");
    private static final RString RST_01 = new RString("01");
    private static final RString コード_1 = new RString("1");
    private static final RString コード_2 = new RString("2");
    private static final RString コード_3 = new RString("3");
    private static final RString コード_4 = new RString("4");
    private static final RString コード_11 = new RString("11");
    private static final RString コード_12 = new RString("12");
    private static final RString コード_13 = new RString("13");
    private static final RString コード_20 = new RString("20");
    private static final RString コード_21 = new RString("21");
    private static final RString コード_22 = new RString("22");
    private static final RString コード_23 = new RString("23");
    private static final RString コード_24 = new RString("24");
    private static final RString コード_25 = new RString("25");
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
    private static final RString エラーコード_52 = new RString("52");
    private static final RString エラー内容_52 = new RString("受給者または事業対象者に利用者負担割合データなし");
    private static final RString エラーコード_54 = new RString("54");
    private static final RString エラー内容_54 = new RString("住所地特例:適用開始エラー");
    private static final RString エラーあり = new RString("1");
    private static final FlexibleDate MIN_DATE = new FlexibleDate(new RString("20150401"));
    private JukyushaIdoRenrakuhyoOutProcessParameter processParameter;
    private List<IdouTblEntity> 異動一時List;
    private KyotakuEntity 最新居宅計画;
    private DbT4001JukyushaDaichoEntity 最新受給者台帳;
    private DbT1001HihokenshaDaichoEntity 最新被保険者台帳;
    private TokuteiNyusyoshaInfoEntity 最新特定入所者;
    private DbT4014RiyoshaFutangakuGengakuEntity 最新利用者負担;
    private ShafukugemmenEntity 最新社福減免;
    private HyojunFutanEntity 最新標準負担;
    private boolean hasCheckErr;
    private HihokenshaNo 被保険者番号;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;
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
        異動一時tableWriter
                = new BatchEntityCreatedTempTableWriter(異動一時_TABLE_NAME, IdouTblEntity.class);
        送付エラー一時tableWriter
                = new BatchEntityCreatedTempTableWriter(送付エラー一時_TABLE_NAME, SoufuErrorTblEntity.class);
    }

    @Override
    protected void process(IdouTblEntity entity) {
        異動一時List.add(entity);
        if (entity.get連番() != entity.get被保険者番号Max連番()) {
            return;
        }
        被保険者番号 = entity.get被保険者番号();
        hasCheckErr = false;
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = get受給者台帳();
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = get被保険者台帳();
        List<DbT1001HihokenshaDaichoEntity> チェック用被保険者台帳List = getチェック使用被保険者台帳(被保険者台帳List);
        List<KyotakuEntity> 居宅計画List = get居宅計画();
        List<HyojunFutanEntity> 標準負担List = get標準負担();
        List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List = get利用者負担();
        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List = get支払方法(支払方法変更);
        List<DbT4021ShiharaiHohoHenkoEntity> 給付額減額List = get支払方法(給付額減額);
        List<TokuteiNyusyoshaInfoEntity> 特定入所者List = get特定入所者();
        List<ShafukugemmenEntity> 社福減免List = get社福減免();
        List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List = get総合事業対象者();
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List = get二割負担();
        List<JushochitokureiInfoEntity> 住所地特例List = get住所地特例();
        PSMInfoEntity 宛名情報 = get宛名();
        if (被保険者台帳List.isEmpty() && !受給者台帳List.isEmpty()) {
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                送付エラー新規1(受給者台帳, 宛名情報);
            }
        } else {
            資格_受給整合性Check(受給者台帳List, 被保険者台帳List, 宛名情報);
            要介護度変更申請日Check(受給者台帳List, チェック用被保険者台帳List, 宛名情報);
            計画作成指定事業者Check(居宅計画List, 宛名情報);
            居宅サービス計画事業者Check(居宅計画List, 宛名情報);
            居宅サービス計画開始日不整合Check(チェック用被保険者台帳List, 居宅計画List, 宛名情報);
            介護事業所届出Check(受給者台帳List, 居宅計画List, 宛名情報);
            予防事業所届出Check(受給者台帳List, 居宅計画List, 宛名情報);
            標準負担減額期間不整合Check(チェック用被保険者台帳List, 標準負担List, 宛名情報);
            標準負担減額申請日Check(受給者台帳List, チェック用被保険者台帳List, 標準負担List, 宛名情報);
            利用者負担減額期間不整合Check(チェック用被保険者台帳List, 利用者負担List, 宛名情報);
            利用者負担減免申請日Check(受給者台帳List, チェック用被保険者台帳List, 利用者負担List, 宛名情報);
            支払方法変更適用開始日不整合Check(受給者台帳List, チェック用被保険者台帳List, 支払方法変更List, 宛名情報);
            給付額減額適用開始日不整合Check(受給者台帳List, チェック用被保険者台帳List, 給付額減額List, 宛名情報);
            特定入所者減免期間不整合Check(受給者台帳List, チェック用被保険者台帳List, 特定入所者List, 宛名情報);
            特定入所者減免申請日Check(受給者台帳List, チェック用被保険者台帳List, 特定入所者List, 宛名情報);
            社会福祉法人軽減期間不整合Check(受給者台帳List, チェック用被保険者台帳List, 社福減免List, 宛名情報);
            資格_総合事業対象者整合性Check(受給者台帳List, チェック用被保険者台帳List, 総合事業対象者List, 宛名情報);
            総合事業受給の終了日Check(受給者台帳List, 被保険者台帳List, 総合事業対象者List, 宛名情報);
            居宅計画サービス届出日Check(受給者台帳List, 被保険者台帳List, 総合事業対象者List, 居宅計画List, 宛名情報);
            受給者または事業対象者に利用者負担割合Check(受給者台帳List, 被保険者台帳List, 総合事業対象者List, 二割負担List, 宛名情報);
            住所地特例Check(被保険者台帳List, 住所地特例List, 宛名情報);
        }
        if (hasCheckErr) {
            for (IdouTblEntity 異動一時 : 異動一時List) {
                異動一時.setエラーフラグ(エラーあり);
                異動一時tableWriter.update(異動一時);
            }
        }
        異動一時List.clear();
    }

    private List<DbT4001JukyushaDaichoEntity> get受給者台帳() {
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = new ArrayList<>();
        List<DbT4001JukyushaDaichoEntity> sort受給者台帳List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT4001JukyushaDaichoEntity 受給者台帳 = get受給者台帳Entity(異動一時.get受給者台帳());
            if (受給者台帳 == null) {
                continue;
            }
            受給者台帳List.add(受給者台帳);
            if (コート_1.equals(受給者台帳.getYukoMukoKubun())) {
                sort受給者台帳List.add(受給者台帳);
            }
        }
        if (!sort受給者台帳List.isEmpty()) {
            sort受給者台帳List(sort受給者台帳List);
            最新受給者台帳 = sort受給者台帳List.get(ORDER_0);
        } else {
            最新受給者台帳 = null;
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
        if (!被保険者台帳List.isEmpty()) {
            sort被保険者台帳ListBy異動日(被保険者台帳List);
            最新被保険者台帳 = 被保険者台帳List.get(ORDER_0);
        } else {
            最新被保険者台帳 = null;
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
        if (!居宅計画List.isEmpty()) {
            sort居宅計画List(居宅計画List);
            最新居宅計画 = 居宅計画List.get(ORDER_0);
        } else {
            最新居宅計画 = null;
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
        if (!標準負担List.isEmpty()) {
            sort標準負担List(標準負担List);
            最新標準負担 = 標準負担List.get(ORDER_0);
        } else {
            最新標準負担 = null;
        }
        return 標準負担List;
    }

    private List<DbT4014RiyoshaFutangakuGengakuEntity> get利用者負担() {
        List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT4014RiyoshaFutangakuGengakuEntity 利用者負担 = get利用者負担entity(異動一時.get利用者負担額減額());
            if (利用者負担 == null) {
                continue;
            }
            利用者負担List.add(利用者負担);
        }
        if (!利用者負担List.isEmpty()) {
            sort利用者負担List(利用者負担List);
            最新利用者負担 = 利用者負担List.get(ORDER_0);
        } else {
            最新利用者負担 = null;
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
        if (!特定入所者List.isEmpty()) {
            sort特定入所者List(特定入所者List);
            最新特定入所者 = 特定入所者List.get(ORDER_0);
        } else {
            最新特定入所者 = null;
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
        if (!社福減免List.isEmpty()) {
            sort社福減免List(社福減免List);
            最新社福減免 = 社福減免List.get(ORDER_0);
        } else {
            最新社福減免 = null;
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
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
            if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                FlexibleDate 認定開始日 = 受給者台帳.getNinteiYukoKikanKaishiYMD();
                FlexibleDate 資格取得日 = 被保険者台帳.getShikakuShutokuYMD();
                if (isDateEmpty(認定開始日)) {
                    continue;
                }
                if (isDateEmpty(資格取得日)) {
                    continue;
                }
                if (認定開始日.isBefore(資格取得日)) {
                    送付エラー新規2(受給者台帳, 被保険者台帳, 宛名情報);
                }
            }
        }
    }

    private void 要介護度変更申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty()) {
            return;
        }
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            Code 受給申請事由 = 受給者台帳.getJukyuShinseiJiyu();
            RString 申請状況区分 = 受給者台帳.getShinseiJokyoKubun();
            if (!(受給申請事由 != null && 区分_4.equals(受給申請事由.getColumnValue()) && 区分_0.equals(申請状況区分))) {
                continue;
            }
            Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
            if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
                continue;
            }
            if (isBeforeOrEqDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 受給者台帳.getJukyuShinseiYMD())
                    && isBeforeOrEqDate(受給者台帳.getJukyuShinseiYMD(), 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 受給者台帳.getJukyuShinseiYMD())
                        && isBeforeOrEqDate喪失年月日(受給者台帳.getJukyuShinseiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                送付エラー新規3(受給者台帳, 被保険者台帳, 宛名情報);
            }
        }

    }

    private void 計画作成指定事業者Check(List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (居宅計画List.isEmpty()) {
            return;
        }
        for (KyotakuEntity 居宅計画 : 居宅計画List) {
            if (居宅計画.get計画事業者番号() == null || RString.isNullOrEmpty(居宅計画.get計画事業者番号().getColumnValue().trim())) {
                continue;
            }
            if (!コード_3.equals(居宅計画.get居宅サービス計画作成区分コード())
                    && RString.isNullOrEmpty(居宅計画.getサービス種類コード())) {
                送付エラー新規4(最新受給者台帳, 最新被保険者台帳, 居宅計画, 宛名情報);
            }
        }
    }

    private void 居宅サービス計画事業者Check(List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (居宅計画List.isEmpty()) {
            return;
        }
        for (KyotakuEntity 居宅計画 : 居宅計画List) {
            if (コード_3.equals(居宅計画.get居宅サービス計画作成区分コード())) {
                continue;
            }
            if (RString.isNullOrEmpty(居宅計画.getサービス種類コード())) {
                continue;
            }
            if (isDateEmpty(居宅計画.get有効終了日())) {
                continue;
            }
            if (居宅計画.get有効終了日().isBefore(居宅計画.get適用開始日())) {
                送付エラー新規5(最新受給者台帳, 最新被保険者台帳, 居宅計画List.get(ORDER_0), 宛名情報);
            }

        }
    }

    private void 居宅サービス計画開始日不整合Check(
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (被保険者台帳List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            for (KyotakuEntity 居宅計画entity : 居宅計画List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 居宅計画entity.get適用開始日())
                        && isBeforeOrEqDate喪失年月日(居宅計画entity.get適用開始日(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                送付エラー新規6(最新受給者台帳, 被保険者台帳, 居宅計画List.get(ORDER_0), 宛名情報);
            }
        }
    }

    private void 介護事業所届出Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        for (KyotakuEntity 居宅計画entity : 居宅計画List) {
            if (isDateEmpty(居宅計画entity.get適用終了日())) {
                continue;
            }
            if (!コード_1.equals(居宅計画entity.get居宅サービス計画作成区分コード())
                    && !コード_2.equals(居宅計画entity.get居宅サービス計画作成区分コード())) {
                continue;
            }
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                if (!コート_1.equals(受給者台帳.getYukoMukoKubun())) {
                    continue;
                }
                if (!(isBeforeYearMonth(受給者台帳.getNinteiYukoKikanKaishiYMD(), 居宅計画entity.get適用開始日())
                        && isBeforeYearMonth(居宅計画entity.get適用開始日(), 受給者台帳.getNinteiYukoKikanShuryoYMD()))) {
                    continue;
                }
                Code 要介護認定状態区分コード = 受給者台帳.getYokaigoJotaiKubunCode();
                if (要介護認定状態区分コード != null && (コード_11.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_12.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_13.equals(要介護認定状態区分コード.getColumnValue()))) {
                    送付エラー新規7(受給者台帳, 最新被保険者台帳, 居宅計画entity, 宛名情報);
                }
            }
        }
    }

    private void 予防事業所届出Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        for (KyotakuEntity 居宅計画entity : 居宅計画List) {
            if (isDateEmpty(居宅計画entity.get適用終了日())) {
                continue;
            }
            if (!コード_4.equals(居宅計画entity.get居宅サービス計画作成区分コード())) {
                continue;
            }
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                if (!コート_1.equals(受給者台帳.getYukoMukoKubun())) {
                    continue;
                }
                if (!(isBeforeYearMonth(受給者台帳.getNinteiYukoKikanKaishiYMD(), 居宅計画entity.get適用開始日())
                        && isBeforeYearMonth(居宅計画entity.get適用開始日(), 受給者台帳.getNinteiYukoKikanShuryoYMD()))) {
                    continue;
                }
                Code 要介護認定状態区分コード = 受給者台帳.getYokaigoJotaiKubunCode();
                if (要介護認定状態区分コード != null && (コード_21.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_22.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_23.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_24.equals(要介護認定状態区分コード.getColumnValue())
                        || コード_25.equals(要介護認定状態区分コード.getColumnValue()))) {
                    送付エラー新規8(受給者台帳, 最新被保険者台帳, 居宅計画entity, 宛名情報);
                }
            }
        }

    }

    private void 標準負担減額期間不整合Check(
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<HyojunFutanEntity> 標準負担List, PSMInfoEntity 宛名情報) {
        if (被保険者台帳List.isEmpty() || 標準負担List.isEmpty()) {
            return;
        }
        for (HyojunFutanEntity 標準負担entity : 標準負担List) {
            if (isDateEmpty(標準負担entity.get適用開始日()) || isDateEmpty(標準負担entity.get適用終了日())) {
                continue;
            }
            if (!区分_1.equals(標準負担entity.get決定区分())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 標準負担entity.get適用開始日())
                        && isBeforeOrEqDate喪失年月日(標準負担entity.get適用開始日(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                送付エラー新規9(最新受給者台帳, 被保険者台帳, 標準負担entity, 宛名情報);
            }
        }

    }

    private void 標準負担減額申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<HyojunFutanEntity> 標準負担List, PSMInfoEntity 宛名情報) {
        if (!is標準負担減額申請日Empty(受給者台帳List, 被保険者台帳List, 標準負担List)) {
            return;
        }
        for (HyojunFutanEntity 標準負担entity : 標準負担List) {
            if (!is標準負担減額申請日Check(標準負担entity)) {
                continue;
            }
            FlexibleDate 申請日 = 標準負担entity.get申請日();
            if (isDateEmpty(申請日)) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 申請日)
                        && isBeforeOrEqDate喪失年月日(申請日, 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                    Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
                    if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
                        continue;
                    }
                    if (isBeforeOrEqDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 申請日)
                            && isBeforeOrEqDate(申請日, 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                        continue;
                    }
                    送付エラー新規10(受給者台帳, 被保険者台帳, 標準負担entity, 宛名情報);
                }
            }
        }
    }

    private boolean is標準負担減額申請日Empty(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<HyojunFutanEntity> 標準負担List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 標準負担List.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean is標準負担減額申請日Check(HyojunFutanEntity 標準負担entity) {
        if (!isDateEmpty(標準負担entity.get適用開始日()) || !isDateEmpty(標準負担entity.get適用終了日())) {
            return false;
        }
        if (!isDateEmpty(標準負担entity.get決定年月日())) {
            return false;
        }
        return true;
    }

    private void 利用者負担減額期間不整合Check(
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List, PSMInfoEntity 宛名情報) {
        if (被保険者台帳List.isEmpty() || 利用者負担List.isEmpty()) {
            return;
        }
        for (DbT4014RiyoshaFutangakuGengakuEntity 利用者負担entity : 利用者負担List) {
            if (isDateEmpty(利用者負担entity.getTekiyoKaishiYMD()) || isDateEmpty(利用者負担entity.getTekiyoShuryoYMD())) {
                continue;
            }
            if (isDateEmpty(利用者負担entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 利用者負担entity.getTekiyoKaishiYMD())
                        && isBeforeOrEqDate喪失年月日(利用者負担entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                送付エラー新規11(最新受給者台帳, 被保険者台帳, 利用者負担entity, 宛名情報);
            }
        }
    }

    private void 利用者負担減免申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List, PSMInfoEntity 宛名情報) {
        if (!isDo利用者負担減免申請日Empty(受給者台帳List, 被保険者台帳List, 利用者負担List)) {
            return;
        }
        for (DbT4014RiyoshaFutangakuGengakuEntity 利用者負担entity : 利用者負担List) {
            if (!isDo利用者負担減免申請日Check(利用者負担entity)) {
                continue;
            }
            FlexibleDate 申請日 = 利用者負担entity.getShinseiYMD();
            if (isDateEmpty(申請日)) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 申請日)
                        && isBeforeOrEqDate喪失年月日(申請日, 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                    Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
                    if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
                        continue;
                    }
                    if (isBeforeOrEqDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 申請日)
                            && isBeforeOrEqDate(申請日, 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                        continue;
                    }
                    送付エラー新規12(受給者台帳, 被保険者台帳, 利用者負担entity, 宛名情報);
                }
            }
        }
    }

    private boolean isDo利用者負担減免申請日Empty(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 利用者負担List.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isDo利用者負担減免申請日Check(DbT4014RiyoshaFutangakuGengakuEntity 利用者負担entity) {
        if (!isDateEmpty(利用者負担entity.getTekiyoKaishiYMD()) || !isDateEmpty(利用者負担entity.getTekiyoShuryoYMD())) {
            return false;
        }
        if (!isDateEmpty(利用者負担entity.getKetteiYMD())) {
            return false;
        }
        return true;
    }

    private void 支払方法変更適用開始日不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更List,
            PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 支払方法変更List.isEmpty()) {
            return;
        }
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity : 支払方法変更List) {
            if (isDateEmpty(支払方法変更entity.getTekiyoKaishiYMD()) || isDateEmpty(支払方法変更entity.getTekiyoShuryoYMD())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 支払方法変更entity.getTekiyoKaishiYMD())
                        && isBeforeOrEqDate喪失年月日(支払方法変更entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                送付エラー新規13(最新受給者台帳, 被保険者台帳, 宛名情報);
            }
        }
    }

    private void 給付額減額適用開始日不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT4021ShiharaiHohoHenkoEntity> 給付額減額List,
            PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 給付額減額List.isEmpty()) {
            return;
        }
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity : 給付額減額List) {
            if (isDateEmpty(支払方法変更entity.getTekiyoKaishiYMD()) || isDateEmpty(支払方法変更entity.getTekiyoShuryoYMD())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 支払方法変更entity.getTekiyoKaishiYMD())
                        && isBeforeOrEqDate喪失年月日(支払方法変更entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                送付エラー新規14(最新受給者台帳, 被保険者台帳, 宛名情報);
            }

        }

    }

    private void 特定入所者減免期間不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<TokuteiNyusyoshaInfoEntity> 特定入所者List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 特定入所者List.isEmpty()) {
            return;
        }
        for (TokuteiNyusyoshaInfoEntity 特定入所者entity : 特定入所者List) {
            if (isDateEmpty(特定入所者entity.get適用開始日()) || isDateEmpty(特定入所者entity.get適用終了日())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 特定入所者entity.get適用開始日())
                        && isBeforeOrEqDate喪失年月日(特定入所者entity.get適用開始日(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                送付エラー新規15(最新受給者台帳, 被保険者台帳, 特定入所者entity, 宛名情報);
            }
        }
    }

    private void 特定入所者減免申請日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<TokuteiNyusyoshaInfoEntity> 特定入所者List, PSMInfoEntity 宛名情報) {
        if (!isDo特定入所者減免申請日Empty(受給者台帳List, 被保険者台帳List, 特定入所者List)) {
            return;
        }
        for (TokuteiNyusyoshaInfoEntity 特定入所者entity : 特定入所者List) {
            if (!isDo特定入所者減免申請日Check(特定入所者entity)) {
                continue;
            }
            FlexibleDate 申請日 = 特定入所者entity.get申請日();
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 申請日)
                        && isBeforeOrEqDate喪失年月日(申請日, 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                    Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
                    if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
                        continue;
                    }
                    if (isBeforeOrEqDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 申請日)
                            && isBeforeOrEqDate(申請日, 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                        continue;
                    }
                    送付エラー新規16(受給者台帳, 被保険者台帳, 特定入所者entity, 宛名情報);
                }
            }
        }
    }

    private boolean isDo特定入所者減免申請日Empty(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
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

    private boolean isDo特定入所者減免申請日Check(TokuteiNyusyoshaInfoEntity 特定入所者entity) {
        if (!isDateEmpty(特定入所者entity.get適用開始日())) {
            return false;
        }
        if (!isDateEmpty(特定入所者entity.get適用終了日())) {
            return false;
        }
        if (isDateEmpty(特定入所者entity.get申請日())) {
            return false;
        }
        return true;
    }

    private void 社会福祉法人軽減期間不整合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<ShafukugemmenEntity> 社福減免List, PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 社福減免List.isEmpty()) {
            return;
        }
        for (ShafukugemmenEntity 社福減免entity : 社福減免List) {
            if (isDateEmpty(社福減免entity.get適用開始日()) || isDateEmpty(社福減免entity.get適用終了日())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 社福減免entity.get適用開始日())
                        && isBeforeOrEqDate喪失年月日(社福減免entity.get適用開始日(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                送付エラー新規17(受給者台帳List.get(ORDER_0), 被保険者台帳List.get(ORDER_0), 社福減免List.get(ORDER_0), 宛名情報);
            }
        }
    }

    private void 資格_総合事業対象者整合性Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 総合事業対象者List.isEmpty()) {
            return;
        }
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者entity : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getShikakuShutokuYMD(), 総合事業対象者entity.getTekiyoKaishiYMD())
                        && isBeforeOrEqDate喪失年月日(総合事業対象者entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
                    continue;
                }
                送付エラー新規18(最新受給者台帳, 被保険者台帳, 宛名情報);
            }
        }
    }

    private void 総合事業受給の終了日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            PSMInfoEntity 宛名情報) {
        if (!isDo総合事業受給の終了日Check(受給者台帳List, 被保険者台帳List, 総合事業対象者List)) {
            return;
        }
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者entity : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                if (isBeforeOrEqDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 総合事業対象者entity.getTekiyoKaishiYMD())
                        && isBeforeOrEqDate(総合事業対象者entity.getTekiyoKaishiYMD(), 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
                    break;
                }
                if (!(isBeforeOrEqDate(総合事業対象者entity.getTekiyoKaishiYMD(), 受給者台帳.getNinteiYukoKikanKaishiYMD())
                        && isBeforeOrEqDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 受給者台帳.getNinteiYukoKikanShuryoYMD()))) {
                    continue;
                }
                if (!isBeforeOrEqDate(総合事業対象者entity.getTekiyoKaishiYMD(), 受給者台帳.getNinteiYMD())) {
                    continue;
                }
                if (!コート_1.equals(受給者台帳.getYukoMukoKubun())) {
                    continue;
                }
                if (check要介護認定状態区分コード(受給者台帳.getYokaigoJotaiKubunCode())) {
                    continue;
                }
                if (isDateEmpty(総合事業対象者entity.getTekiyoShuryoYMD())
                        || isBeforeDate(受給者台帳.getNinteiYukoKikanShuryoYMD(), 総合事業対象者entity.getTekiyoShuryoYMD())) {
                    送付エラー新規19(受給者台帳, 最新被保険者台帳, 宛名情報);
                }
            }
        }
    }

    private boolean isDo総合事業受給の終了日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 総合事業対象者List.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean check要介護認定状態区分コード(Code 要介護認定状態区分コード) {
        if (要介護認定状態区分コード == null || !(コード_21.equals(要介護認定状態区分コード.getColumnValue())
                || コード_22.equals(要介護認定状態区分コード.getColumnValue())
                || コード_23.equals(要介護認定状態区分コード.getColumnValue())
                || コード_24.equals(要介護認定状態区分コード.getColumnValue())
                || コード_25.equals(要介護認定状態区分コード.getColumnValue()))) {
            return false;
        }
        return true;
    }

    private void 居宅計画サービス届出日Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List, List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            List<KyotakuEntity> 居宅計画List,
            PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 被保険者台帳List.isEmpty() || 総合事業対象者List.isEmpty() || 居宅計画List.isEmpty()) {
            return;
        }
        居宅計画サービス届出日Check1(総合事業対象者List, 居宅計画List, 宛名情報);
        居宅計画サービス届出日Check2(総合事業対象者List, 居宅計画List, 宛名情報);
    }

    private void 居宅計画サービス届出日Check1(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者entity : 総合事業対象者List) {
            if (isDateEmpty(総合事業対象者entity.getTekiyoKaishiYMD())) {
                continue;
            }
            for (KyotakuEntity 居宅計画 : 居宅計画List) {
                if (isDateEmpty(居宅計画.get適用開始日()) || isDateEmpty(居宅計画.get届出年月日())) {
                    continue;
                }
                FlexibleDate 届出年月日 = 居宅計画.get届出年月日();
                if (isBeforeDate(居宅計画.get届出年月日(), MIN_DATE)) {
                    届出年月日 = MIN_DATE;
                }
                if (isEqYearMonth(総合事業対象者entity.getTekiyoKaishiYMD(), 居宅計画.get適用開始日())
                        && isEqYearMonth(総合事業対象者entity.getTekiyoKaishiYMD(), 届出年月日)
                        && 区分_4.equals(居宅計画.get居宅サービス計画作成区分コード())) {
                    continue;
                }
                送付エラー新規21(最新受給者台帳, 最新被保険者台帳, 宛名情報);
            }
        }
    }

    private void 居宅計画サービス届出日Check2(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            List<KyotakuEntity> 居宅計画List, PSMInfoEntity 宛名情報) {
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
                RString 適用終了日 = null;
                FlexibleDate tekiyoShuryoYMD = 総合事業対象者entity.getTekiyoShuryoYMD();
                if (tekiyoShuryoYMD != null) {
                    適用終了日 = new RString(tekiyoShuryoYMD.toString());
                }
                FlexibleDate 届出年月日 = 居宅計画.get届出年月日();
                if (isBeforeDate(居宅計画.get届出年月日(), MIN_DATE)) {
                    届出年月日 = MIN_DATE;
                }
                if (isEqYearMonth(総合事業対象者entity.getTekiyoKaishiYMD(), 居宅計画.get適用開始日())
                        && isEqYearMonth(総合事業対象者entity.getTekiyoKaishiYMD(), 届出年月日)
                        && 区分_4.equals(居宅計画.get居宅サービス計画作成区分コード())
                        && MAX_DATE.equals(適用終了日)
                        && isBeforeOrEqDate(総合事業対象者entity.getTekiyoShuryoYMD(), 居宅計画.get届出年月日())) {
                    continue;
                }
                送付エラー新規21(最新受給者台帳, 最新被保険者台帳, 宛名情報);
            }
        }
    }

    private void 受給者または事業対象者に利用者負担割合Check(List<DbT4001JukyushaDaichoEntity> 受給者台帳List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List,
            List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List,
            PSMInfoEntity 宛名情報) {
        if (受給者台帳List.isEmpty() || 二割負担List.isEmpty() || 総合事業対象者List.isEmpty()) {
            return;
        }
        boolean 受給者状況 = get受給者状況(受給者台帳List);
        boolean 総合事業対象者状況 = get総合事業対象者状況(総合事業対象者List);
        boolean 負担割合状況 = get負担割合状況(二割負担List);
        boolean 資格状況 = get資格状況(被保険者台帳List);
        boolean 受給申請状況 = get受給申請状況(受給者台帳List);
        if ((受給者状況 || 総合事業対象者状況) && !負担割合状況 && 資格状況 && !受給申請状況) {
            for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
                送付エラー新規22(受給者台帳, 最新被保険者台帳, 宛名情報);
            }
        }
    }

    private boolean get受給申請状況(List<DbT4001JukyushaDaichoEntity> 受給者台帳List) {
        boolean 受給申請状況 = false;
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (コート_0.equals(受給者台帳.getYukoMukoKubun())) {
                受給申請状況 = true;
                break;
            }
        }
        return 受給申請状況;
    }

    private boolean get受給者状況(List<DbT4001JukyushaDaichoEntity> 受給者台帳List) {
        boolean 受給者状況 = false;
        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            if (コート_1.equals(受給者台帳.getYukoMukoKubun())
                    && チェック_DATE.isBefore(受給者台帳.getNinteiYukoKikanKaishiYMD())) {
                受給者状況 = true;
                break;
            }
        }
        return 受給者状況;
    }

    private boolean get総合事業対象者状況(List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List) {
        boolean 総合事業対象者状況 = false;
        for (DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 : 総合事業対象者List) {
            if (チェック_DATE.isBefore(総合事業対象者.getTekiyoKaishiYMD())) {
                総合事業対象者状況 = true;
                break;
            }
        }
        return 総合事業対象者状況;
    }

    private boolean get負担割合状況(List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List) {
        boolean 負担割合状況 = false;
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity 二割負担 : 二割負担List) {
            if (コード_20.equals(二割負担.getFutanWariaiKubun())) {
                continue;
            }
            負担割合状況 = true;
        }
        return 負担割合状況;
    }

    private boolean get資格状況(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        boolean 資格状況 = false;
        RYearMonth 処理年月 = processParameter.get処理年月();
        FlexibleDate 処理年月日 = new FlexibleDate(処理年月.toDateString().concat(RST_01));
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (isBeforeDate喪失年月日(処理年月日, 被保険者台帳.getShikakuSoshitsuYMD())) {
                資格状況 = true;
                break;
            }
        }
        return 資格状況;
    }

    private void 住所地特例Check(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List,
            List<JushochitokureiInfoEntity> 住所地特例List,
            PSMInfoEntity 宛名情報) {
        if (被保険者台帳List.isEmpty() || 住所地特例List.isEmpty()) {
            return;
        }
        List<DbT1001HihokenshaDaichoEntity> 抽出対象被保険者台帳 = 抽出対象被保険者台帳(被保険者台帳List);
        if (抽出対象被保険者台帳.isEmpty()) {
            return;
        }
        抽出対象住所地特例(住所地特例List);
        for (JushochitokureiInfoEntity 住所地特例 : 住所地特例List) {
            for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
                if (isBeforeOrEqDate(被保険者台帳.getJushochitokureiTekiyoYMD(), 住所地特例.get住所地特例適用開始日())
                        && isBeforeOrEqDate(住所地特例.get住所地特例適用開始日(), 被保険者台帳.getJushochitokureiKaijoYMD())
                        && (住所地特例.get転出先保険者番号() == null || 住所地特例.get転出先保険者番号().isEmpty())) {
                    送付エラー新規20(最新受給者台帳, 被保険者台帳, 宛名情報);
                    return;
                }
                if (isBeforeDate(MIN_DATE, 住所地特例.get住所地特例適用開始日())
                        && isBeforeDate(住所地特例.get住所地特例適用開始日(), 被保険者台帳.getJushochitokureiTekiyoYMD())
                        && isBeforeDate(被保険者台帳.getJushochitokureiTekiyoYMD(), 住所地特例.get住所地特例適用終了日())) {
                    送付エラー新規24(最新受給者台帳, 被保険者台帳, 宛名情報);
                    return;
                }
            }
        }
    }

    private List<DbT1001HihokenshaDaichoEntity> 抽出対象被保険者台帳(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        List<DbT1001HihokenshaDaichoEntity> retrunList = new ArrayList<>();
        List<DbT1001HihokenshaDaichoEntity> sortList = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (!isDateEmpty(被保険者台帳.getJushochitokureiTekiyoYMD())) {
                sortList.add(被保険者台帳);
            }
            if (!isDateEmpty(被保険者台帳.getJushochitokureiKaijoYMD())) {
                retrunList.add(被保険者台帳);
            }
        }
        if (!sortList.isEmpty()) {
            sort被保険者台帳ListBy異動日(sortList);
            retrunList.add(sortList.get(sortList.size() - ORDER_1));
        }
        return retrunList;
    }

    private void 抽出対象住所地特例(List<JushochitokureiInfoEntity> 住所地特例List) {
        for (JushochitokureiInfoEntity 住所地特例 : 住所地特例List) {
            if (isBeforeDate(住所地特例.get住所地特例適用開始日(), MIN_DATE)
                    && isBeforeDate(MIN_DATE, 住所地特例.get住所地特例適用終了日())) {
                住所地特例.set住所地特例適用開始日(MIN_DATE);
            }
        }
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
        entity.setRirekiNo(受給者台帳Info.get(ORDER_15));
        entity.setShinseiJokyoKubun(受給者台帳Info.get(ORDER_16));
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
        entity.setIdoYMD(new FlexibleDate(被保険者台帳Info.get(ORDER_3)));
        entity.setEdaNo(被保険者台帳Info.get(ORDER_4));
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
        entity.set適用終了日(new FlexibleDate(居宅計画Info.get(ORDER_6)));
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
        entity.set決定区分(居宅計画Info.get(ORDER_4));
        return entity;
    }

    private DbT4014RiyoshaFutangakuGengakuEntity get利用者負担entity(RString 利用者負担) {
        if (RString.isNullOrEmpty(利用者負担)) {
            return null;
        }
        DbT4014RiyoshaFutangakuGengakuEntity entity = new DbT4014RiyoshaFutangakuGengakuEntity();
        List<RString> 利用者負担Info = 利用者負担.split(SPLIT.toString());
        entity.setTekiyoKaishiYMD(new FlexibleDate(利用者負担Info.get(ORDER_0)));
        entity.setTekiyoShuryoYMD(new FlexibleDate(利用者負担Info.get(ORDER_1)));
        entity.setShinseiYMD(new FlexibleDate(利用者負担Info.get(ORDER_2)));
        entity.setKetteiYMD(new FlexibleDate(利用者負担Info.get(ORDER_3)));
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
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4014RiyoshaFutangakuGengakuEntity 利用者負担entity,
            PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set利用者負担申請日(利用者負担entity.getShinseiYMD());
        entity.set利用者負担適用開始日(利用者負担entity.getTekiyoKaishiYMD());
        entity.set利用者負担適用終了日(利用者負担entity.getTekiyoShuryoYMD());
        entity.setエラーコード(エラーコード_27);
        entity.setエラー内容(エラー内容_27);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規12(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4014RiyoshaFutangakuGengakuEntity 利用者負担entity,
            PSMInfoEntity 宛名情報) {
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
            DbT1001HihokenshaDaichoEntity 被保険者台帳, TokuteiNyusyoshaInfoEntity 特定入所者entity,
            PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set特定申請日(特定入所者entity.get申請日());
        entity.set特定適用開始日(特定入所者entity.get適用開始日());
        entity.set特定適用終了日(特定入所者entity.get適用終了日());
        entity.setエラーコード(エラーコード_42);
        entity.setエラー内容(エラー内容_42);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規16(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, TokuteiNyusyoshaInfoEntity 特定入所者entity,
            PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.set特定申請日(特定入所者entity.get申請日());
        entity.set特定適用開始日(特定入所者entity.get適用開始日());
        entity.set特定適用終了日(特定入所者entity.get適用終了日());
        entity.setエラーコード(エラーコード_43);
        entity.setエラー内容(エラー内容_43);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規17(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, ShafukugemmenEntity 社福減免entity,
            PSMInfoEntity 宛名情報) {
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

    private void 送付エラー新規20(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_50);
        entity.setエラー内容(エラー内容_50);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規21(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_51);
        entity.setエラー内容(エラー内容_51);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規22(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_52);
        entity.setエラー内容(エラー内容_52);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規24(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳, 宛名情報);
        entity.setエラーコード(エラーコード_54);
        entity.setエラー内容(エラー内容_54);
        送付エラー一時tableWriter.insert(entity);
    }

    private SoufuErrorTblEntity 送付エラーCommon(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, PSMInfoEntity 宛名情報) {
        SoufuErrorTblEntity entity = new SoufuErrorTblEntity();
        entity.set被保険者番号(被保険者番号);
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
        if (受給者台帳 != null) {
            entity.set要介護状態区分コード(受給者台帳.getYokaigoJotaiKubunCode());
            entity.set要介護認定申請日(受給者台帳.getJukyuShinseiYMD());
            entity.set認定開始日(受給者台帳.getNinteiYukoKikanKaishiYMD());
            entity.set認定終了日(受給者台帳.getNinteiYukoKikanShuryoYMD());
        }
        if (最新居宅計画 != null) {
            entity.set居宅事業者番号(最新居宅計画.get計画事業者番号());
            entity.set居宅適用開始日(最新居宅計画.get適用開始日());
        } else {
            entity.set居宅事業者番号(JigyoshaNo.EMPTY);
            entity.set居宅適用開始日(FlexibleDate.EMPTY);
        }
        if (最新特定入所者 != null) {
            entity.set特定申請日(最新特定入所者.get申請日());
            entity.set特定適用開始日(最新特定入所者.get適用開始日());
            entity.set特定適用終了日(最新特定入所者.get適用終了日());
        } else {
            entity.set特定申請日(FlexibleDate.EMPTY);
            entity.set特定適用開始日(FlexibleDate.EMPTY);
            entity.set特定適用終了日(FlexibleDate.EMPTY);
        }
        if (最新利用者負担 != null) {
            entity.set利用者負担申請日(最新利用者負担.getShinseiYMD());
            entity.set利用者負担適用開始日(最新利用者負担.getTekiyoKaishiYMD());
            entity.set利用者負担適用終了日(最新利用者負担.getTekiyoShuryoYMD());
        } else {
            entity.set利用者負担申請日(FlexibleDate.EMPTY);
            entity.set利用者負担適用開始日(FlexibleDate.EMPTY);
            entity.set利用者負担適用終了日(FlexibleDate.EMPTY);
        }
        if (最新社福減免 != null) {
            entity.set社会福祉適用開始日(最新社福減免.get適用開始日());
            entity.set社会福祉適用終了日(最新社福減免.get適用終了日());
        } else {
            entity.set社会福祉適用開始日(FlexibleDate.EMPTY);
            entity.set社会福祉適用終了日(FlexibleDate.EMPTY);
        }
        if (最新標準負担 != null) {
            entity.set標準負担適用開始日(最新標準負担.get適用開始日());
            entity.set標準負担適用終了日(最新標準負担.get適用終了日());
        } else {
            entity.set標準負担適用開始日(FlexibleDate.EMPTY);
            entity.set標準負担適用終了日(FlexibleDate.EMPTY);
        }
        entity.set償還払化開始日(FlexibleDate.EMPTY);
        entity.set給付率引下げ開始日(FlexibleDate.EMPTY);
        entity.set作成年月日(FlexibleDate.getNowDate());
        entity.set処理年月(processParameter.get処理年月().toDateString());
        hasCheckErr = true;
        return entity;
    }

    private boolean isBeforeYearMonth(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date2)) {
            return true;
        }
        if (isDateEmpty(date1)) {
            return false;
        }
        return date1.getYearMonth().isBeforeOrEquals(date2.getYearMonth());
    }

    private boolean isEqYearMonth(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date2)) {
            return false;
        }
        if (isDateEmpty(date1)) {
            return false;
        }
        return date1.getYearMonth().equals(date2.getYearMonth());
    }

    private boolean isBeforeDate(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date1) || isDateEmpty(date2)) {
            return false;
        }
        return date1.isBefore(date2);
    }

    private boolean isBeforeDate喪失年月日(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date2)) {
            return true;
        }
        if (isDateEmpty(date1)) {
            return false;
        }
        return date1.isBefore(date2);
    }

    private boolean isBeforeOrEqDate喪失年月日(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date2)) {
            return true;
        }
        if (isDateEmpty(date1)) {
            return false;
        }
        return date1.isBeforeOrEquals(date2);
    }

    private boolean isBeforeOrEqDate(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date1) || isDateEmpty(date2)) {
            return false;
        }
        return date1.isBeforeOrEquals(date2);
    }

    private boolean isDateEmpty(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return true;
        }
        return false;
    }

    private static void sort居宅計画List(List<KyotakuEntity> 居宅計画List) {
        Collections.sort(居宅計画List, new Comparator<KyotakuEntity>() {
            @Override
            public int compare(KyotakuEntity o1, KyotakuEntity o2) {
                if (o2.get履歴番号() < o1.get履歴番号()) {
                    return -1;
                }
                if (o1.get履歴番号() < o2.get履歴番号()) {
                    return 1;
                }
                return 0;
            }
        });
    }

    private static void sort特定入所者List(List<TokuteiNyusyoshaInfoEntity> 特定入所者List) {
        Collections.sort(特定入所者List, new Comparator<TokuteiNyusyoshaInfoEntity>() {
            @Override
            public int compare(TokuteiNyusyoshaInfoEntity o1, TokuteiNyusyoshaInfoEntity o2) {
                if (o1.get適用開始日() == null || o1.get適用開始日().isEmpty()) {
                    return -1;
                }
                if (o2.get適用開始日() == null || o2.get適用開始日().isEmpty()) {
                    return 1;
                }
                if (o1.get適用開始日().isBefore(o2.get適用開始日())) {
                    return -1;
                }
                return 1;
            }
        });
    }

    private static void sort利用者負担List(List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List) {
        Collections.sort(利用者負担List, new Comparator<DbT4014RiyoshaFutangakuGengakuEntity>() {
            @Override
            public int compare(DbT4014RiyoshaFutangakuGengakuEntity o1, DbT4014RiyoshaFutangakuGengakuEntity o2) {
                if (o2.getRirekiNo() < o1.getRirekiNo()) {
                    return -1;
                }
                if (o1.getRirekiNo() < o2.getRirekiNo()) {
                    return 1;
                }
                return 0;
            }
        });
    }

    private static void sort社福減免List(List<ShafukugemmenEntity> 社福減免List) {
        Collections.sort(社福減免List, new Comparator<ShafukugemmenEntity>() {
            @Override
            public int compare(ShafukugemmenEntity o1, ShafukugemmenEntity o2) {
                if (o2.get履歴番号() < o1.get履歴番号()) {
                    return -1;
                }
                if (o1.get履歴番号() < o2.get履歴番号()) {
                    return 1;
                }
                return 0;
            }
        });
    }

    private static void sort標準負担List(List<HyojunFutanEntity> 標準負担List) {
        Collections.sort(標準負担List, new Comparator<HyojunFutanEntity>() {
            @Override
            public int compare(HyojunFutanEntity o1, HyojunFutanEntity o2) {
                if (o2.get履歴番号() < o1.get履歴番号()) {
                    return -1;
                }
                if (o1.get履歴番号() < o2.get履歴番号()) {
                    return 1;
                }
                return 0;
            }
        });
    }

    private static void sort受給者台帳List(List<DbT4001JukyushaDaichoEntity> 受給者台帳List) {
        Collections.sort(受給者台帳List, new Comparator<DbT4001JukyushaDaichoEntity>() {
            @Override
            public int compare(DbT4001JukyushaDaichoEntity o1, DbT4001JukyushaDaichoEntity o2) {
                return o2.getRirekiNo().compareTo(o1.getRirekiNo());
            }
        });
    }

    private static void sort被保険者台帳ListBy異動日(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        Collections.sort(被保険者台帳List, new Comparator<DbT1001HihokenshaDaichoEntity>() {
            @Override
            public int compare(DbT1001HihokenshaDaichoEntity o1, DbT1001HihokenshaDaichoEntity o2) {
                if (o2.getIdoYMD().isBefore(o1.getIdoYMD())) {
                    return -1;
                }
                if (o1.getIdoYMD().isBefore(o2.getIdoYMD())) {
                    return 1;
                }
                return 0;
            }
        });
    }

    private static void sort被保険者台帳ListBy異動日枝番(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        Collections.sort(被保険者台帳List, new Comparator<DbT1001HihokenshaDaichoEntity>() {
            @Override
            public int compare(DbT1001HihokenshaDaichoEntity o1, DbT1001HihokenshaDaichoEntity o2) {
                if (o1.getIdoYMD().isBefore(o2.getIdoYMD())) {
                    return -1;
                }
                if (o2.getIdoYMD().isBefore(o1.getIdoYMD())) {
                    return 1;
                }
                return o1.getEdaNo().compareTo(o2.getEdaNo());
            }
        });
    }

    private List<DbT1001HihokenshaDaichoEntity> getチェック使用被保険者台帳(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        if (被保険者台帳List.isEmpty()) {
            return new ArrayList<>();
        }
        sort被保険者台帳ListBy異動日枝番(被保険者台帳List);
        List<DbT1001HihokenshaDaichoEntity> チェック使用被保険者台帳 = new ArrayList<>();
        boolean lastRecordAdd = true;
        for (int i = ORDER_0; i < 被保険者台帳List.size(); i++) {
            DbT1001HihokenshaDaichoEntity 被保険者台帳 = 被保険者台帳List.get(i);
            if (isDateEmpty(被保険者台帳.getShikakuSoshitsuYMD())) {
                continue;
            }
            if (i == 被保険者台帳List.size() - ORDER_1) {
                lastRecordAdd = false;
            }
            チェック使用被保険者台帳.add(被保険者台帳);
        }
        if (lastRecordAdd) {
            チェック使用被保険者台帳.add(被保険者台帳List.get(被保険者台帳List.size() - ORDER_1));
        }
        return チェック使用被保険者台帳;
    }
}
