/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910KoroshoErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911KoroshoErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912KoroshoErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913KoroshoErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913RelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定申請連携データ取込を管理クラスです。
 *
 * @reamsid_L DBE-1490-030 duanzhanli
 */
public class NinteiShinseirenkeiDataInsert {

    private static final int INT10 = 10;
    private static final int INT24 = 24;

    /**
     * DbT5912KoroshoErrorTempEntityの設定メッソドです。
     *
     * @param entity DbT5912RelateEntity
     * @return DbT5912KoroshoErrorTempEntity
     */
    public DbT5912KoroshoErrorTempEntity getDbT5912KoroshoErrorTempEntity(DbT5912RelateEntity entity) {
        RString error = check主治医一時テーブル電算(entity);
        if (!RString.isNullOrEmpty(error)) {
            DbT5912KoroshoErrorTempEntity errorEntity = new DbT5912KoroshoErrorTempEntity();
            errorEntity.setシーケンシャル番号(entity.getDbt5912TempEntity().getシーケンシャル番号());
            errorEntity.set機能コード(entity.getDbt5912TempEntity().get機能コード());
            errorEntity.set識別コード(entity.getDbt5912TempEntity().get識別コード());
            errorEntity.set医療機関コード(entity.getDbt5912TempEntity().get医療機関コード());
            errorEntity.set主治医コード(entity.getDbt5912TempEntity().get主治医コード());
            errorEntity.set主治医名称(entity.getDbt5912TempEntity().get主治医名称());
            errorEntity.set状況(entity.getDbt5912TempEntity().is状況());
            errorEntity.setエラー内容(error);
            return errorEntity;
        }
        return null;
    }

    /**
     * DbT5912ErrorTempEntityの設定メッソドです。
     *
     * @param entity DbT5912RelateEntity
     * @return DbT5912ErrorTempEntity
     */
    public DbT5912ErrorTempEntity getDbT5912ErrorTempEntity(DbT5912RelateEntity entity) {
        RString error = check主治医一時テーブル電算(entity);
        if (!RString.isNullOrEmpty(error)) {
            DbT5912ErrorTempEntity errorEntity = new DbT5912ErrorTempEntity();
            errorEntity.setシーケンシャル番号(entity.getDbt5912TempEntity().getシーケンシャル番号());
            errorEntity.set機能コード(entity.getDbt5912TempEntity().get機能コード());
            errorEntity.set識別コード(entity.getDbt5912TempEntity().get識別コード());
            errorEntity.set医療機関コード(entity.getDbt5912TempEntity().get医療機関コード());
            errorEntity.set主治医コード(entity.getDbt5912TempEntity().get主治医コード());
            errorEntity.set主治医名称(entity.getDbt5912TempEntity().get主治医名称());
            errorEntity.set状況(entity.getDbt5912TempEntity().is状況());
            errorEntity.set主治医名称カナ(entity.getDbt5912TempEntity().get主治医名称カナ());
            errorEntity.setエラー内容(error);
            return errorEntity;
        }
        return null;
    }

    private RString check主治医一時テーブル電算(DbT5912RelateEntity entity) {
        RStringBuilder errorBuilder = new RStringBuilder();
        checkDbT5912同情報(entity, errorBuilder);
        DbT5911ShujiiIryoKikanJohoDac dac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
        if (RString.isNullOrEmpty(entity.getDbt5912TempEntity().get医療機関コード())) {
            errorBuilder.append(new RString("医療機関コードが未入力です;"));
        }
        if (dac.selectBy主治医医療機関コード(new ShujiiIryokikanCode(entity.getDbt5912TempEntity().get医療機関コード())) == null
                || dac.selectBy主治医医療機関コード(new ShujiiIryokikanCode(entity.getDbt5912TempEntity().get医療機関コード())).isEmpty()) {
            errorBuilder.append(new RString("医療機関コードが不正です;"));
        }
        if (RString.isNullOrEmpty(entity.getDbt5912TempEntity().get主治医コード())) {
            errorBuilder.append(new RString("主治医コードが不正です;"));
        }
        return errorBuilder.toRString();
    }

    /**
     * DbT5911KoroshoErrorTempEntityの設定メッソドです。
     *
     * @param entity DbT5911RelateEntity
     * @return DbT5911KoroshoErrorTempEntity
     */
    public DbT5911KoroshoErrorTempEntity getDbT5911KoroshoErrorTempEntity(DbT5911RelateEntity entity) {
        RString error = check医療機関一時テーブル電算(entity);
        if (!RString.isNullOrEmpty(error)) {
            DbT5911KoroshoErrorTempEntity errorEntity = new DbT5911KoroshoErrorTempEntity();
            errorEntity.setシーケンシャル番号(entity.getDbt5911TempEntity().getシーケンシャル番号());
            errorEntity.set機能コード(entity.getDbt5911TempEntity().get機能コード());
            errorEntity.set識別コード(entity.getDbt5911TempEntity().get識別コード());
            errorEntity.set医療機関コード(entity.getDbt5911TempEntity().get医療機関コード());
            errorEntity.set医療機関名称(entity.getDbt5911TempEntity().get医療機関名称());
            errorEntity.set郵便番号(entity.getDbt5911TempEntity().get郵便番号());
            errorEntity.set住所(entity.getDbt5911TempEntity().get住所());
            errorEntity.set電話番号(entity.getDbt5911TempEntity().get電話番号());
            errorEntity.set状況(entity.getDbt5911TempEntity().is状況());
            errorEntity.setエラー内容(error);
            return errorEntity;
        }
        return null;
    }

    /**
     * DbT5911ErrorTempEntityの設定メッソドです。
     *
     * @param entity DbT5911RelateEntity
     * @return DbT5911ErrorTempEntity
     */
    public DbT5911ErrorTempEntity getDbT5911ErrorTempEntity(DbT5911RelateEntity entity) {
        RString error = check医療機関一時テーブル電算(entity);
        if (!RString.isNullOrEmpty(error)) {
            DbT5911ErrorTempEntity errorEntity = new DbT5911ErrorTempEntity();
            errorEntity.setシーケンシャル番号(entity.getDbt5911TempEntity().getシーケンシャル番号());
            errorEntity.set機能コード(entity.getDbt5911TempEntity().get機能コード());
            errorEntity.set識別コード(entity.getDbt5911TempEntity().get識別コード());
            errorEntity.set医療機関コード(entity.getDbt5911TempEntity().get医療機関コード());
            errorEntity.set医療機関名称(entity.getDbt5911TempEntity().get医療機関名称());
            errorEntity.set郵便番号(entity.getDbt5911TempEntity().get郵便番号());
            errorEntity.set住所(entity.getDbt5911TempEntity().get住所());
            errorEntity.set電話番号(entity.getDbt5911TempEntity().get電話番号());
            errorEntity.set状況(entity.getDbt5911TempEntity().is状況());
            errorEntity.set医療機関名称カナ(entity.getDbt5911TempEntity().get医療機関名称カナ());
            errorEntity.setエラー内容(error);
            return errorEntity;
        }
        return null;
    }

    private RString check医療機関一時テーブル電算(DbT5911RelateEntity entity) {
        RStringBuilder errorBuilder = new RStringBuilder();
        checkDbT5911同情報(entity, errorBuilder);
        if (entity.getDbt5911TempEntity().get医療機関コード() == null 
                || entity.getDbt5911TempEntity().get医療機関コード() == ShujiiIryokikanCode.EMPTY) {
            errorBuilder = errorBuilder.append(new RString("医療機関コードが未入力です；"));
        }
        return errorBuilder.toRString();
    }

    /**
     * DbT5913KoroshoErrorTempEntityの設定メッソドです。
     *
     * @param entity DbT5913RelateEntity
     * @return DbT5913KoroshoErrorTempEntity
     */
    public DbT5913KoroshoErrorTempEntity getDbT5913KoroshoErrorTempEntity(DbT5913RelateEntity entity) {
        RString error = check調査員一時テーブル電算(entity);
        if (!RString.isNullOrEmpty(error)) {
            DbT5913KoroshoErrorTempEntity errorEntity = new DbT5913KoroshoErrorTempEntity();
            errorEntity.setシーケンシャル番号(entity.getDbt5913TempEntity().getシーケンシャル番号());
            errorEntity.set機能コード(entity.getDbt5913TempEntity().get機能コード());
            errorEntity.set識別コード(entity.getDbt5913TempEntity().get識別コード());
            errorEntity.set委託先コード(entity.getDbt5913TempEntity().get委託先コード());
            errorEntity.set調査員コード(entity.getDbt5913TempEntity().get調査員コード());
            errorEntity.set調査員名称(entity.getDbt5913TempEntity().get調査員名称());
            errorEntity.set資格コード(entity.getDbt5913TempEntity().get資格コード());
            errorEntity.set状況(entity.getDbt5913TempEntity().is状況());
            errorEntity.setエラー内容(error);
            return errorEntity;
        }
        return null;
    }

    /**
     * DbT5913ErrorTempEntityの設定メッソドです。
     *
     * @param entity DbT5913RelateEntity
     * @return DbT5913ErrorTempEntity
     */
    public DbT5913ErrorTempEntity getDbT5913ErrorTempEntity(DbT5913RelateEntity entity) {
        RString error = check調査員一時テーブル電算(entity);
        if (!RString.isNullOrEmpty(error)) {
            DbT5913ErrorTempEntity errorEntity = new DbT5913ErrorTempEntity();
            errorEntity.setシーケンシャル番号(entity.getDbt5913TempEntity().getシーケンシャル番号());
            errorEntity.set機能コード(entity.getDbt5913TempEntity().get機能コード());
            errorEntity.set識別コード(entity.getDbt5913TempEntity().get識別コード());
            errorEntity.set委託先コード(entity.getDbt5913TempEntity().get委託先コード());
            errorEntity.set調査員コード(entity.getDbt5913TempEntity().get調査員コード());
            errorEntity.set調査員名称(entity.getDbt5913TempEntity().get調査員名称());
            errorEntity.set資格コード(entity.getDbt5913TempEntity().get資格コード());
            errorEntity.set状況(entity.getDbt5913TempEntity().is状況());
            errorEntity.set調査員名称カナ(entity.getDbt5913TempEntity().get調査員名称カナ());
            errorEntity.setエラー内容(error);
            return errorEntity;
        }
        return null;
    }

    private RString check調査員一時テーブル電算(DbT5913RelateEntity entity) {
        RStringBuilder errorBuilder = new RStringBuilder();
        checkDbT5913同情報(entity, errorBuilder);
        if (RString.isNullOrEmpty(entity.getDbt5913TempEntity().get委託先コード())) {
            errorBuilder.append(new RString("調査機関コードが未入力です;"));
        }
        DbT5910NinteichosaItakusakiJohoDac dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        if (dac.selectBy認定調査委託先コード(entity.getDbt5913TempEntity().get委託先コード()) == null 
                || dac.selectBy認定調査委託先コード(entity.getDbt5913TempEntity().get委託先コード()).isEmpty()) {
            errorBuilder.append(new RString("調査機関コードが不正です;"));
        }
        if (RString.isNullOrEmpty(entity.getDbt5913TempEntity().get調査員コード())) {
            errorBuilder.append(new RString("調査員コードが不正です;"));
        }
        return errorBuilder.toRString();
    }

    /**
     * DbT5910KoroshoErrorTempEntityの設定メッソドです。
     *
     * @param entity DbT5910RelateEntity
     * @return DbT5910KoroshoErrorTempEntity
     */
    public DbT5910KoroshoErrorTempEntity getDbT5910KoroshoErrorTempEntity(DbT5910RelateEntity entity) {
        RString error = check委託先情報一時テーブル電算(entity);
        if (!RString.isNullOrEmpty(error)) {
            DbT5910KoroshoErrorTempEntity errorEntity = new DbT5910KoroshoErrorTempEntity();
            errorEntity.setシーケンシャル番号(entity.getDbt5910TempEntity().getシーケンシャル番号());
            errorEntity.set機能コード(entity.getDbt5910TempEntity().get機能コード());
            errorEntity.set識別コード(entity.getDbt5910TempEntity().get識別コード());
            errorEntity.set委託先コード(entity.getDbt5910TempEntity().get委託先コード());
            errorEntity.set委託先名称(entity.getDbt5910TempEntity().get委託先名称());
            errorEntity.set郵便番号(entity.getDbt5910TempEntity().get郵便番号());
            errorEntity.set住所(entity.getDbt5910TempEntity().get住所());
            errorEntity.set電話番号(entity.getDbt5910TempEntity().get電話番号());
            errorEntity.set状況(entity.getDbt5910TempEntity().is状況());
            errorEntity.set委託区分コード(entity.getDbt5910TempEntity().get委託区分コード());
            if (!RString.isNullOrEmpty(entity.getDbt5910TempEntity().get委託区分コード())) {
                errorEntity.set委託区分名称(ChosaItakuKubunCode.toValue(entity.getDbt5910TempEntity().get委託区分コード()).get名称());
            }
            errorEntity.setエラー内容(error);
            return errorEntity;
        }
        return null;
    }

    /**
     * DbT5910ErrorTempEntityの設定メッソドです。
     *
     * @param entity DbT5910RelateEntity
     * @return DbT5910ErrorTempEntity
     */
    public DbT5910ErrorTempEntity getDbT5910ErrorTempEntity(DbT5910RelateEntity entity) {
        RString error = check委託先情報一時テーブル電算(entity);
        if (!RString.isNullOrEmpty(error)) {
            DbT5910ErrorTempEntity errorEntity = new DbT5910ErrorTempEntity();
            errorEntity.setシーケンシャル番号(entity.getDbt5910TempEntity().getシーケンシャル番号());
            errorEntity.set機能コード(entity.getDbt5910TempEntity().get機能コード());
            errorEntity.set識別コード(entity.getDbt5910TempEntity().get識別コード());
            errorEntity.set委託先コード(entity.getDbt5910TempEntity().get委託先コード());
            errorEntity.set委託先名称(entity.getDbt5910TempEntity().get委託先名称());
            errorEntity.set郵便番号(entity.getDbt5910TempEntity().get郵便番号());
            errorEntity.set住所(entity.getDbt5910TempEntity().get住所());
            errorEntity.set電話番号(entity.getDbt5910TempEntity().get電話番号());
            errorEntity.set状況(entity.getDbt5910TempEntity().is状況());
            errorEntity.set委託区分コード(entity.getDbt5910TempEntity().get委託区分コード());
            if (!RString.isNullOrEmpty(entity.getDbt5910TempEntity().get委託区分コード())) {
                errorEntity.set委託区分名称(ChosaItakuKubunCode.toValue(entity.getDbt5910TempEntity().get委託区分コード()).get名称());
            }
            errorEntity.set委託先名称カナ(entity.getDbt5910TempEntity().get委託先名称カナ());
            errorEntity.setエラー内容(error);
            return errorEntity;
        }
        return null;
    }

    private RString check委託先情報一時テーブル電算(DbT5910RelateEntity entity) {
        RStringBuilder errorBuilder = new RStringBuilder();
        checkDbT5910同情報(entity, errorBuilder);
        if (RString.isNullOrEmpty(entity.getDbt5910TempEntity().get委託先コード())) {
            errorBuilder = errorBuilder.append(new RString("調査機関コードが不正です;"));
        }
        return errorBuilder.toRString();
    }

    /**
     * DbT5101ErrorTempEntityの設定メッソドです。
     *
     * @param entity DbT5101RelateEntity
     * @param processParamter RenkeiDataTorikomiProcessParamter
     * @return DbT5101ErrorTempEntity
     */
    public DbT5101ErrorTempEntity getDbT5101ErrorTempEntity(DbT5101RelateEntity entity, RenkeiDataTorikomiProcessParamter processParamter) {
        RString error;
        if (processParamter.is東芝版フラグ()) {
            error = check申請情報一時テーブル_東芝版(entity);
        } else {
            error = check申請情報一時テーブル電算(entity, processParamter);
        }
        if (!RString.isNullOrEmpty(error)) {
            DbT5101ErrorTempEntity errorEntity = new DbT5101ErrorTempEntity();
            errorEntity.setシーケンシャル番号(entity.getDbt5101TempEntity().getシーケンシャル番号());
            errorEntity.set機能コード(entity.getDbt5101TempEntity().get機能コード());
            errorEntity.set識別コード(entity.getDbt5101TempEntity().get識別コード());
            errorEntity.set保険者番号(entity.getDbt5101TempEntity().get保険者番号());
            errorEntity.set被保険者番号(entity.getDbt5101TempEntity().get被保険者番号());
            errorEntity.set認定申請日(entity.getDbt5101TempEntity().get認定申請日());
            errorEntity.set主キー補助項目(entity.getDbt5101TempEntity().get主キー補助項目());
            errorEntity.set申請種別コード(entity.getDbt5101TempEntity().get申請区分_申請時コード());
            errorEntity.set申請種別名称(NinteiShinseiShinseijiKubunCode.toValue(entity.getDbt5101TempEntity().get申請区分_申請時コード()).get名称());
            errorEntity.set取下区分コード(entity.getDbt5101TempEntity().get取下区分コード());
            errorEntity.set取下区分名称(TorisageKubunCode.toValue(entity.getDbt5101TempEntity().get取下区分コード()).get名称());
            errorEntity.set被保険者区分コード(entity.getDbt5101TempEntity().get被保険者区分コード());
            errorEntity.set被保険者区分名称(HihokenshaKubunCode.toValue(entity.getDbt5101TempEntity().get被保険者区分コード()).get名称());
            errorEntity.set申請代行区分コード(entity.getDbt5101TempEntity().get申請代行区分コード());
            errorEntity.set申請代行区分名称(ShinseiTodokedeDaikoKubunCode.toValue(entity.getDbt5101TempEntity().get申請代行区分コード()).get名称());
            errorEntity.set生年月日(entity.getDbt5101TempEntity().get生年月日());
            errorEntity.set年齢(entity.getDbt5101TempEntity().get年齢());
            errorEntity.set性別コード(entity.getDbt5101TempEntity().get性別());
            errorEntity.set性別(entity.getDbt5101TempEntity().get性別());
            errorEntity.set氏名カナ(entity.getDbt5101TempEntity().get氏名_カナ());
            errorEntity.set氏名(entity.getDbt5101TempEntity().get氏名());
            errorEntity.set郵便番号(entity.getDbt5101TempEntity().get郵便番号());
            errorEntity.set住所(entity.getDbt5101TempEntity().get住所());
            errorEntity.setエラー内容(error);
            return errorEntity;
        }
        return null;

    }

    private RString check申請情報一時テーブル電算(DbT5101RelateEntity entity, RenkeiDataTorikomiProcessParamter processParamter) {
        RStringBuilder errorBuilder = new RStringBuilder();
        checkDbT5101同情報(entity, errorBuilder);
        nullCheck申請区分(entity.getDbt5101TempEntity().get申請区分_申請時コード(), errorBuilder);
        if (!RString.isNullOrEmpty(processParamter.get市町村コード())
                && processParamter.get市町村コード().equals(entity.getDbt5101TempEntity().get市町村コード())) {
            errorBuilder.append(new RString("市町村コードが不正です;"));
        }
        check申請区分不正(entity.getDbt5101TempEntity().get申請区分_申請時コード(), errorBuilder);
        if (RString.isNullOrEmpty(entity.getDbt5101TempEntity().get認定申請日()) || new RString("00000000").equals(entity.getDbt5101TempEntity().get認定申請日())) {
            errorBuilder.append(new RString("申請日の入力がありません;"));
        }
        check被保険者番号未入力(entity.getDbt5101TempEntity().get被保険者番号(), errorBuilder);
        check特定疾病コード(entity.getDbt5101TempEntity().get被保険者区分コード(), entity.getDbt5101TempEntity().get特定疾病コード(), errorBuilder);
        check生年月日(entity.getDbt5101TempEntity().get生年月日(), errorBuilder);
        check年齢(entity.getDbt5101TempEntity().get生年月日(), errorBuilder);
        check市町村コード未入力(entity.getDbt5101TempEntity().get市町村コード(), errorBuilder);
        check認定申請日入力不正(entity.getDbt5101TempEntity().get認定申請日(), errorBuilder);
        check生年月日入力不正(entity.getDbt5101TempEntity().get生年月日(), errorBuilder);
        check性別未入力(entity.getDbt5101TempEntity().get性別(), errorBuilder);
        check被保険者番号入力不正(entity.getDbt5101TempEntity().get被保険者番号(), errorBuilder);
        check性別入力不正(entity.getDbt5101TempEntity().get性別(), errorBuilder);
        check有効期間(entity.getDbt5101TempEntity().get前回の認定有効開始期間(), 
                entity.getDbt5101TempEntity().get前回の認定有効終了期間(), 
                entity.getDbt5101TempEntity().get申請区分_申請時コード(), errorBuilder);
        return errorBuilder.toRString();
    }

    private RString check申請情報一時テーブル_東芝版(DbT5101RelateEntity entity) {
        RStringBuilder errorBuilder = new RStringBuilder();
        checkDbT5101同情報(entity, errorBuilder);
        nullCheck申請区分(entity.getDbt5101TempEntity().get申請区分_申請時コード(), errorBuilder);
        check申請区分不正(entity.getDbt5101TempEntity().get申請区分_申請時コード(), errorBuilder);
        if (RString.isNullOrEmpty(entity.getDbt5101TempEntity().get認定申請日()) || new RString("00000000").equals(entity.getDbt5101TempEntity().get認定申請日())) {
            errorBuilder.append(new RString("申請日の入力がありません;"));
        }
        check被保険者番号未入力(entity.getDbt5101TempEntity().get被保険者番号(), errorBuilder);
        check特定疾病コード(entity.getDbt5101TempEntity().get被保険者区分コード(), entity.getDbt5101TempEntity().get特定疾病コード(), errorBuilder);
        check生年月日(entity.getDbt5101TempEntity().get生年月日(), errorBuilder);
        check認定申請日入力不正(entity.getDbt5101TempEntity().get認定申請日(), errorBuilder);
        check生年月日入力不正(entity.getDbt5101TempEntity().get生年月日(), errorBuilder);
        check性別未入力(entity.getDbt5101TempEntity().get性別(), errorBuilder);
        check被保険者番号入力不正(entity.getDbt5101TempEntity().get被保険者番号(), errorBuilder);
        check性別入力不正(entity.getDbt5101TempEntity().get性別(), errorBuilder);
        check有効期間(entity.getDbt5101TempEntity().get前回の認定有効開始期間(), 
                entity.getDbt5101TempEntity().get前回の認定有効終了期間(), 
                entity.getDbt5101TempEntity().get申請区分_申請時コード(), errorBuilder);
        return errorBuilder.toRString();
    }

    private boolean check歴上日(RString value) {
        return !RString.isNullOrEmpty(value) && !new FlexibleDate(value.toString()).isValid();
    }

    private RStringBuilder check認定申請日入力不正(RString 認定申請日, RStringBuilder errorBuilder) {
        if (check歴上日(認定申請日)) {
            errorBuilder.append(new RString("申請日のデータが不正です;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check市町村コード未入力(RString value, RStringBuilder errorBuilder) {
        if (RString.isNullOrEmpty(value) || value.equals(new RString("000000"))) {
            errorBuilder.append(new RString("性別の入力がありません;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check性別未入力(RString value, RStringBuilder errorBuilder) {
        if (RString.isNullOrEmpty(value)) {
            errorBuilder.append(new RString("性別の入力がありません;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check性別入力不正(RString value, RStringBuilder errorBuilder) {
        if (!Seibetsu.女.getコード().equals(value) && !Seibetsu.男.getコード().equals(value)) {
            errorBuilder.append(new RString("性別のデータが不正です;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check被保険者番号未入力(RString value, RStringBuilder errorBuilder) {
        if (RString.isNullOrEmpty(value) || new RString("0000000000").equals(value)) {
            errorBuilder.append(new RString("被保険者番号の入力がありません;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check被保険者番号入力不正(RString value, RStringBuilder errorBuilder) {
        if (!RString.isNullOrEmpty(value) && value.length() != INT10) {
            errorBuilder.append(new RString("被保険者番号の桁数が間違っています;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check生年月日入力不正(RString value, RStringBuilder errorBuilder) {
        if (!RString.isNullOrEmpty(value) && check歴上日(value)) {
            errorBuilder.append(new RString("生年月日のデータが不正です;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check生年月日(RString value, RStringBuilder errorBuilder) {
        if (RString.isNullOrEmpty(value) || new RString("00000000").equals(value)) {
            errorBuilder.append(new RString("生年月日の入力がありません;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check年齢(RString value, RStringBuilder errorBuilder) {
        if (check歴上日(value)) {
            errorBuilder.append(new RString("年齢の算出が出来ませんでした;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check有効期間(RString 開始期間, RString 終了期間, RString 申請区分, RStringBuilder errorBuilder) {
        if (check歴上日(開始期間)) {
            errorBuilder.append(new RString("認定有効期間開始日のデータが不正です;"));
        }
        if (check歴上日(終了期間)) {
            errorBuilder.append(new RString("認定有効期間終了日のデータが不正です;"));
        }
        if ((NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(申請区分)
                || NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(申請区分))
                && !RString.isNullOrEmpty(開始期間) && !RString.isNullOrEmpty(終了期間)
                && INT24 < new FlexibleDate(終了期間).getBetweenMonths(new FlexibleDate(開始期間))) {
            errorBuilder.append(new RString("認定有効期間のデータが不正です;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check特定疾病コード(RString 被保険者区分コード, RString 特定疾病コード, RStringBuilder errorBuilder) {
        if (new RString("2").equals(被保険者区分コード)) {
            List<RString> codeList = new ArrayList<>();
            for (TokuteiShippei enumValue : TokuteiShippei.values()) {
                codeList.add(enumValue.getコード());
            }
            if (!codeList.contains(特定疾病コード)) {
                errorBuilder.append(new RString("特定疾病コードが不正です;"));
            }
        }
        return errorBuilder;
    }

    private RStringBuilder nullCheck申請区分(RString value, RStringBuilder errorBuilder) {
        if (RString.isNullOrEmpty(value)) {
            errorBuilder.append(new RString("申請区分の入力がありません;"));
        }
        return errorBuilder;
    }

    private RStringBuilder check申請区分不正(RString value, RStringBuilder errorBuilder) {
        List<RString> codeList = new ArrayList<>();
        for (NinteiShinseiShinseijiKubunCode code : NinteiShinseiShinseijiKubunCode.values()) {
            codeList.add(code.getコード());
        }
        if (!codeList.contains(value)) {
            errorBuilder.append(new RString("申請区分が不正です;"));
        }
        return errorBuilder;
    }
    
    private RStringBuilder checkDbT5101同情報(DbT5101RelateEntity entity, RStringBuilder errorBuilder) {
        if (entity.getDbT5101Entity() != null) {
            errorBuilder.append(new RString("既に登録されています;"));
        }
        return errorBuilder;
    }
    
    private RStringBuilder checkDbT5910同情報(DbT5910RelateEntity entity, RStringBuilder errorBuilder) {
        if (entity.getDbT5910Entity() != null) {
            errorBuilder.append(new RString("既に登録されています；"));
        }
        return errorBuilder;
    }
    
    private RStringBuilder checkDbT5911同情報(DbT5911RelateEntity entity, RStringBuilder errorBuilder) {
        if (entity.getDbT5911Entity() != null) {
            errorBuilder.append(new RString("既に登録されています；"));
        }
        return errorBuilder;
    }
    
    private RStringBuilder checkDbT5912同情報(DbT5912RelateEntity entity, RStringBuilder errorBuilder) {
        if (entity.getDbT5912Entity() != null) {
            errorBuilder.append(new RString("既に登録されています；"));
        }
        return errorBuilder;
    }
    
    private RStringBuilder checkDbT5913同情報(DbT5913RelateEntity entity, RStringBuilder errorBuilder) {
        if (entity.getDbT5913Entity() != null) {
            errorBuilder.append(new RString("既に登録されています；"));
        }
        return errorBuilder;
    }
}
