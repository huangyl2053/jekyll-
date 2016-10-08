/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.HyojunFutanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.KyotakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.ShafukugemmenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.SoufuErrorTblEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static final RString SPLIT = new RString("|");
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
    private static final RString 区分_4 = new RString("4");
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

    private List<IdouTblEntity> 異動一時List;
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
        RString 受給者台帳 = entity.get受給者台帳();
        RString 被保険者台帳 = entity.get被保険者台帳管理();
        DbT4001JukyushaDaichoEntity 受給者台帳Entity = get受給者台帳Entity(受給者台帳);
        if (RString.isNullOrEmpty(被保険者台帳) && !RString.isNullOrEmpty(受給者台帳)) {
            送付エラー新規1(受給者台帳Entity);
            異動一時List.clear();
            return;
        }
        DbT1001HihokenshaDaichoEntity 被保険者台帳Entity = get被保険者台帳Entity(被保険者台帳);
        RString 居宅サービス計画 = entity.get居宅計画();
        KyotakuEntity 居宅計画entity = get居宅計画entity(居宅サービス計画);
        RString 標準負担 = entity.get標準負担();
        HyojunFutanEntity 標準負担entity = get標準負担entity(標準負担);
        RString 利用者負担 = entity.get利用者負担額減額();
        DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity = get利用者負担entity(利用者負担);
        RString 支払方法変更 = entity.get支払方法変更_支払方法();
        DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity = get支払方法変更entity(支払方法変更);
        DbT4021ShiharaiHohoHenkoEntity 給付費減額entity = get支払方法変更entity(entity.get支払方法変更_給付費減額());
        ShafukugemmenEntity 社福減免entity = get社福減免entity(entity.get社福減免());
        RString 総合事業対象者 = entity.get総合事業対象者();
        DbT3105SogoJigyoTaishoshaEntity 総合事業対象者entity = get総合事業対象者entity(総合事業対象者);
        資格_受給整合性Check(受給者台帳Entity, 被保険者台帳Entity);
        要介護度変更申請日Check(受給者台帳Entity, 被保険者台帳Entity);
        //TODO
//        計画作成指定事業者が存在Check();
//        居宅サービス計画事業者が終了Check();
        居宅サービス計画開始日不整合Check(受給者台帳Entity, 被保険者台帳Entity, 居宅計画entity);
        //TODO
        // 居宅計画Check();
        標準負担減額期間不整合Check(受給者台帳Entity, 被保険者台帳Entity, 標準負担entity);
        標準負担減額申請日Check(受給者台帳Entity, 被保険者台帳Entity, 標準負担entity);
        利用者負担減額期間不整合Check(受給者台帳Entity, 被保険者台帳Entity, 利用者負担entity);
        利用者負担減免申請日Check(受給者台帳Entity, 被保険者台帳Entity, 利用者負担entity);
        支払方法変更適用開始日不整合Check(受給者台帳Entity, 被保険者台帳Entity, 支払方法変更entity);
        給付額減額適用開始日不整合Check(受給者台帳Entity, 被保険者台帳Entity, 給付費減額entity);
        //TODO
//        特定入所者減免期間不整合Check();
//        特定入所者減免申請日Check();
        社会福祉法人軽減期間不整合Check(受給者台帳Entity, 被保険者台帳Entity, 社福減免entity);
        資格_総合事業対象者整合性Check(受給者台帳Entity, 被保険者台帳Entity, 総合事業対象者entity);
        異動一時List.clear();
//        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = get受給者台帳List();
//        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = get被保険者台帳List();
//        if (被保険者台帳List.isEmpty() && !受給者台帳List.isEmpty()) {
//            送付エラー新規1(受給者台帳List);
//            異動一時List.clear();
//            return;
//        }

    }

    private void 資格_受給整合性Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳) {
        if (受給者台帳 == null || 被保険者台帳 == null) {
            return;
        }
        Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
        if (効無効区分 == null || !区分_1.equals(効無効区分.getColumnValue())) {
            return;
        }
        FlexibleDate 認定開始日 = 受給者台帳.getNinteiYukoKikanKaishiYMD();
        if (isDateEmpty(認定開始日)) {
            return;
        }
        FlexibleDate 資格取得日 = 被保険者台帳.getShikakuShutokuYMD();
        if (isDateEmpty(資格取得日)) {
            return;
        }
        if (資格取得日.isBeforeOrEquals(認定開始日)) {
            送付エラー新規2(受給者台帳, 被保険者台帳);
        }
    }

    private void 要介護度変更申請日Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳) {
        if (受給者台帳 == null || 被保険者台帳 == null) {
            return;
        }
        Code 受給申請事由 = 受給者台帳.getJukyuShinseiJiyu();
        RString 申請状況区分 = 受給者台帳.getShinseiJokyoKubun();
        Code 有効無効区分 = 受給者台帳.getYukoMukoKubun();
        if (!(受給申請事由 != null && 区分_4.equals(受給申請事由.getColumnValue()) && 区分_0.equals(申請状況区分)
                && 有効無効区分 != null && 区分_1.equals(有効無効区分.getColumnValue()))) {
            return;
        }
        boolean 認定日CheckFlag = true;
        if (isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 受給者台帳.getJukyuShinseiYMD())
                && isBeforeDate(受給者台帳.getJukyuShinseiYMD(), 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
            認定日CheckFlag = false;
        }
        boolean 資格日CheckFlag = true;
        if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 受給者台帳.getJukyuShinseiYMD())
                && isBeforeDate(受給者台帳.getJukyuShinseiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
            資格日CheckFlag = false;
        }
        if (資格日CheckFlag && 認定日CheckFlag) {
            送付エラー新規3(受給者台帳, 被保険者台帳);
        }
    }

    private void 居宅サービス計画開始日不整合Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, KyotakuEntity 居宅計画entity) {
        if (受給者台帳 == null || 被保険者台帳 == null || 居宅計画entity == null) {
            return;
        }
        if (isBeforeDate(居宅計画entity.get適用開始日(), 被保険者台帳.getShikakuShutokuYMD())
                || isBeforeDate(被保険者台帳.getShikakuSoshitsuYMD(), 居宅計画entity.get適用開始日())) {
            送付エラー新規6(受給者台帳, 被保険者台帳, 居宅計画entity);
        }
    }

    private void 標準負担減額期間不整合Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, HyojunFutanEntity 標準負担entity) {
        if (受給者台帳 == null || 被保険者台帳 == null || 標準負担entity == null) {
            return;
        }
        //TODO QA1622
        if (isDateEmpty(標準負担entity.get適用開始日()) || isDateEmpty(標準負担entity.get適用終了日())) {
            return;
        }
        if (isBeforeDate(標準負担entity.get適用開始日(), 被保険者台帳.getShikakuShutokuYMD())
                || isBeforeDate(被保険者台帳.getShikakuSoshitsuYMD(), 標準負担entity.get適用開始日())) {
            送付エラー新規9(受給者台帳, 被保険者台帳, 標準負担entity);
        }
    }

    private void 標準負担減額申請日Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, HyojunFutanEntity 標準負担entity) {
        if (受給者台帳 == null || 被保険者台帳 == null || 標準負担entity == null) {
            return;
        }
        FlexibleDate 申請日 = 標準負担entity.get申請日();
        if (isDateEmpty(申請日)) {
            return;
        }
        if (標準負担entity.get決定年月日() != null && !標準負担entity.get決定年月日().isEmpty()) {
            return;
        }
        boolean 認定日CheckFlag = true;
        if (isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 申請日)
                && isBeforeDate(申請日, 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
            認定日CheckFlag = false;
        }
        boolean 資格日CheckFlag = true;
        Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
        if (効無効区分 != null && 区分_1.equals(効無効区分.getColumnValue())
                && isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 申請日)
                && isBeforeDate(申請日, 被保険者台帳.getShikakuSoshitsuYMD())) {
            資格日CheckFlag = false;
        }
        if (資格日CheckFlag && 認定日CheckFlag) {
            送付エラー新規10(受給者台帳, 被保険者台帳, 標準負担entity);
        }
    }

    private void 利用者負担減額期間不整合Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity) {
        if (受給者台帳 == null || 被保険者台帳 == null || 利用者負担entity == null) {
            return;
        }
        if (isDateEmpty(利用者負担entity.getTekiyoKaishiYMD()) || isDateEmpty(利用者負担entity.getTekiyoShuryoYMD())) {
            return;
        }
        if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 利用者負担entity.getTekiyoKaishiYMD())
                && isBeforeDate(利用者負担entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
            送付エラー新規11(受給者台帳, 被保険者台帳, 利用者負担entity);
        }
    }

    private void 利用者負担減免申請日Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity) {
        if (受給者台帳 == null || 被保険者台帳 == null || 利用者負担entity == null) {
            return;
        }
        FlexibleDate 申請日 = 利用者負担entity.getShinseiYMD();
        if (isDateEmpty(申請日)) {
            return;
        }
        if (利用者負担entity.getKetteiYMD() != null && !利用者負担entity.getKetteiYMD().isEmpty()) {
            return;
        }
        boolean 認定日CheckFlag = true;
        if (isBeforeDate(受給者台帳.getNinteiYukoKikanKaishiYMD(), 申請日)
                && isBeforeDate(申請日, 受給者台帳.getNinteiYukoKikanShuryoYMD())) {
            認定日CheckFlag = false;
        }
        boolean 資格日CheckFlag = true;
        Code 効無効区分 = 受給者台帳.getYukoMukoKubun();
        if (効無効区分 != null && 区分_1.equals(効無効区分.getColumnValue())
                && isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 申請日)
                && isBeforeDate(申請日, 被保険者台帳.getShikakuSoshitsuYMD())) {
            資格日CheckFlag = false;
        }
        if (資格日CheckFlag && 認定日CheckFlag) {
            送付エラー新規12(受給者台帳, 被保険者台帳, 利用者負担entity);
        }
    }

    private void 支払方法変更適用開始日不整合Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity) {
        if (受給者台帳 == null || 被保険者台帳 == null || 支払方法変更entity == null) {
            return;
        }
        if (isDateEmpty(支払方法変更entity.getTekiyoKaishiYMD()) || isDateEmpty(支払方法変更entity.getTekiyoShuryoYMD())) {
            return;
        }
        if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 支払方法変更entity.getTekiyoKaishiYMD())
                && isBeforeDate(支払方法変更entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
            送付エラー新規13(受給者台帳, 被保険者台帳, 支払方法変更entity);
        }
    }

    private void 給付額減額適用開始日不整合Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity) {
        if (受給者台帳 == null || 被保険者台帳 == null || 支払方法変更entity == null) {
            return;
        }
        if (isDateEmpty(支払方法変更entity.getTekiyoKaishiYMD()) || isDateEmpty(支払方法変更entity.getTekiyoShuryoYMD())) {
            return;
        }
        if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 支払方法変更entity.getTekiyoKaishiYMD())
                && isBeforeDate(支払方法変更entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
            送付エラー新規14(受給者台帳, 被保険者台帳, 支払方法変更entity);
        }
    }

    private void 社会福祉法人軽減期間不整合Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, ShafukugemmenEntity 社福減免entity) {
        if (受給者台帳 == null || 被保険者台帳 == null || 社福減免entity == null) {
            return;
        }
        if (isDateEmpty(社福減免entity.get適用開始日()) || isDateEmpty(社福減免entity.get適用終了日())) {
            return;
        }
        if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 社福減免entity.get適用開始日())
                && isBeforeDate(社福減免entity.get適用開始日(), 被保険者台帳.getShikakuSoshitsuYMD())) {
            送付エラー新規17(受給者台帳, 被保険者台帳, 社福減免entity);
        }
    }

    private void 資格_総合事業対象者整合性Check(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT3105SogoJigyoTaishoshaEntity 総合事業対象者entity) {
        if (受給者台帳 == null || 被保険者台帳 == null || 総合事業対象者entity == null) {
            return;
        }
        if (isBeforeDate(被保険者台帳.getShikakuShutokuYMD(), 総合事業対象者entity.getTekiyoKaishiYMD())
                && isBeforeDate(総合事業対象者entity.getTekiyoKaishiYMD(), 被保険者台帳.getShikakuSoshitsuYMD())) {
            送付エラー新規18(受給者台帳, 被保険者台帳);
        }
    }

//    private List<DbT4001JukyushaDaichoEntity> get受給者台帳List() {
//        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = new ArrayList<>();
//
//        for (IdouTblEntity 異動一時 : 異動一時List) {
//            RString 受給者台帳 = 異動一時.get受給者台帳();
//            if (RString.isNullOrEmpty(受給者台帳)) {
//                continue;
//            }
//            受給者台帳List.add(get受給者台帳Entity(受給者台帳));
//        }
//        return 受給者台帳List;
//    }
//
//    private List<DbT1001HihokenshaDaichoEntity> get被保険者台帳List() {
//        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = new ArrayList<>();
//
//        for (IdouTblEntity 異動一時 : 異動一時List) {
//            RString 被保険者台帳 = 異動一時.get被保険者台帳管理();
//            if (RString.isNullOrEmpty(被保険者台帳)) {
//                continue;
//            }
//            被保険者台帳List.add(get被保険者台帳Entity(被保険者台帳));
//        }
//        return 被保険者台帳List;
//    }
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
        entity.setShikyuGendoTanisu(new Decimal(受給者台帳Info.get(ORDER_6).toString()));
        entity.setShikyuGendoKaishiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_7)));
        entity.setShikyuGendoShuryoYMD(new FlexibleDate(受給者台帳Info.get(ORDER_8)));
        entity.setTankiSikyuGendoNissu(Integer.parseInt(受給者台帳Info.get(ORDER_9).toString()));
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
        entity.setJushochiTokureiFlag(被保険者台帳Info.get(ORDER_3));
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

    private void 送付エラー新規1(DbT4001JukyushaDaichoEntity 受給者台帳) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, null);
        entity.setエラーコード(エラーコード_25);
        entity.setエラー内容(エラー内容_25);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規2(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.setエラーコード(エラーコード_26);
        entity.setエラー内容(エラー内容_26);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規3(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.setエラーコード(エラーコード_29);
        entity.setエラー内容(エラー内容_29);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規6(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, KyotakuEntity 居宅計画entity) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.set居宅事業者番号(居宅計画entity.get計画事業者番号());
        entity.set居宅適用開始日(居宅計画entity.get適用開始日());
        entity.setエラーコード(エラーコード_31);
        entity.setエラー内容(エラー内容_31);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規9(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, HyojunFutanEntity 標準負担entity) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.set標準負担適用開始日(標準負担entity.get適用開始日());
        entity.set標準負担適用終了日(標準負担entity.get適用終了日());
        entity.setエラーコード(エラーコード_28);
        entity.setエラー内容(エラー内容_28);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規10(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, HyojunFutanEntity 標準負担entity) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.set標準負担適用開始日(標準負担entity.get適用開始日());
        entity.set標準負担適用終了日(標準負担entity.get適用終了日());
        entity.setエラーコード(エラーコード_30);
        entity.setエラー内容(エラー内容_30);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規11(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.set利用者負担申請日(利用者負担entity.getShinseiYMD());
        entity.set利用者負担適用開始日(利用者負担entity.getTekiyoKaishiYMD());
        entity.set利用者負担適用終了日(利用者負担entity.getTekiyoShuryoYMD());
        entity.setエラーコード(エラーコード_27);
        entity.setエラー内容(エラー内容_27);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規12(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 利用者負担entity) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.set利用者負担申請日(利用者負担entity.getShinseiYMD());
        entity.set利用者負担適用開始日(利用者負担entity.getTekiyoKaishiYMD());
        entity.set利用者負担適用終了日(利用者負担entity.getTekiyoShuryoYMD());
        entity.setエラーコード(エラーコード_33);
        entity.setエラー内容(エラー内容_33);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規13(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.setエラーコード(エラーコード_32);
        entity.setエラー内容(エラー内容_32);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規14(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, DbT4021ShiharaiHohoHenkoEntity 支払方法変更entity) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.setエラーコード(エラーコード_34);
        entity.setエラー内容(エラー内容_34);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規17(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳, ShafukugemmenEntity 社福減免entity) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.set社会福祉適用開始日(社福減免entity.get適用開始日());
        entity.set社会福祉適用終了日(社福減免entity.get適用終了日());
        entity.setエラーコード(エラーコード_41);
        entity.setエラー内容(エラー内容_41);
        送付エラー一時tableWriter.insert(entity);
    }

    private void 送付エラー新規18(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳) {
        SoufuErrorTblEntity entity = 送付エラーCommon(受給者台帳, 被保険者台帳);
        entity.setエラーコード(エラーコード_48);
        entity.setエラー内容(エラー内容_48);
        送付エラー一時tableWriter.insert(entity);
    }

    private SoufuErrorTblEntity 送付エラーCommon(DbT4001JukyushaDaichoEntity 受給者台帳,
            DbT1001HihokenshaDaichoEntity 被保険者台帳) {
        SoufuErrorTblEntity entity = new SoufuErrorTblEntity();
        entity.set被保険者番号(受給者台帳.getHihokenshaNo());
        //TODO QA1622
        entity.set氏名カナ(RString.EMPTY);
        entity.set氏名(RString.EMPTY);
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

}
