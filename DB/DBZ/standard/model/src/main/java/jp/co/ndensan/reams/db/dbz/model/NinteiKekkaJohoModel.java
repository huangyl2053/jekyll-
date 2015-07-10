/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定結果情報のモデルクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiKekkaJohoModel implements Serializable {

    private DbT5002NinteiKekkaJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public NinteiKekkaJohoModel() {
        entity = new DbT5002NinteiKekkaJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5002NinteiKekkaJohoEntity
     */
    public NinteiKekkaJohoModel(DbT5002NinteiKekkaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5002NinteiKekkaJohoEntityを返します。
     *
     * @return DbT5002NinteiKekkaJohoEntity
     */
    public DbT5002NinteiKekkaJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT5002NinteiKekkaJohoEntityを設定します。
     *
     * @param entity DbT5002NinteiKekkaJohoEntity
     */
    public void setEntity(DbT5002NinteiKekkaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 要介護度認定年月日を返します。
     *
     * @return 要介護度認定年月日
     */
    public FlexibleDate get要介護度認定年月日() {
        return entity.getYoukaigodoNinteiYMD();
    }

    /**
     * 要介護状態区分コードを返します。
     *
     * @return 要介護状態区分コード
     */
    public Code get要介護状態区分コード() {
        return entity.getYoukaigoJotaiKubunCode();
    }

    /**
     * 認定有効期間を返します。
     *
     * @return 認定有効期間
     */
    public int get認定有効期間() {
        return entity.getNinteiYukoKikan();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.getNinteiYukoKaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.getNinteiYukoShuryoYMD();
    }

    /**
     * 介護保険の特定疾病コードを返します。
     *
     * @return 介護保険の特定疾病コード
     */
    public Code get介護保険の特定疾病コード() {
        return entity.getTokuteiShippeiCode();
    }

    /**
     * 施設入所の有無を返します。
     *
     * @return 施設入所の有無 {true:入所有 false:入所無}
     */
    public boolean is施設入所() {
        return entity.getShisetsuNyushoFlag();
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public int get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 介護認定審査会意見を返します。
     *
     * @return 介護認定審査会意見
     */
    public RString get介護認定審査会意見() {
        return entity.getShinsakaiIken();
    }

    /**
     * 一次判定結果変更理由を返します。
     *
     * @return 一次判定結果変更理由
     */
    public RString get一次判定結果変更理由() {
        return entity.getIchijiHnateiKekkaHenkoRiyu();
    }

    /**
     * 要介護状態像例コードを返します。
     *
     * @return 要介護状態像例コード
     */
    public Code get要介護状態像例コード() {
        return entity.getYokaigoJotaizoReiCode();
    }

    /**
     * 認定審査会意見種類を返します。
     *
     * @return 認定審査会意見種類
     */
    public RString get認定審査会意見種類() {
        return entity.getNinteishinsakaiIkenShurui();
    }

    /**
     * 介護サービス種類01を返します。
     *
     * @return 介護サービス種類01
     */
    public RString get介護サービス種類01() {
        return entity.getKaigoServiceShurui01();
    }

    /**
     * 介護サービス種類02を返します。
     *
     * @return 介護サービス種類02
     */
    public RString get介護サービス種類02() {
        return entity.getKaigoServiceShurui02();
    }

    /**
     * 介護サービス種類03を返します。
     *
     * @return 介護サービス種類03
     */
    public RString get介護サービス種類03() {
        return entity.getKaigoServiceShurui03();
    }

    /**
     * 介護サービス種類04を返します。
     *
     * @return 介護サービス種類04
     */
    public RString get介護サービス種類04() {
        return entity.getKaigoServiceShurui04();
    }

    /**
     * 介護サービス種類05を返します。
     *
     * @return 介護サービス種類05
     */
    public RString get介護サービス種類05() {
        return entity.getKaigoServiceShurui05();
    }

    /**
     * 介護サービス種類06を返します。
     *
     * @return 介護サービス種類06
     */
    public RString get介護サービス種類06() {
        return entity.getKaigoServiceShurui06();
    }

    /**
     * 介護サービス種類07を返します。
     *
     * @return 介護サービス種類07
     */
    public RString get介護サービス種類07() {
        return entity.getKaigoServiceShurui07();
    }

    /**
     * 介護サービス種類08を返します。
     *
     * @return 介護サービス種類08
     */
    public RString get介護サービス種類08() {
        return entity.getKaigoServiceShurui08();
    }

    /**
     * 介護サービス種類09を返します。
     *
     * @return 介護サービス種類09
     */
    public RString get介護サービス種類09() {
        return entity.getKaigoServiceShurui09();
    }

    /**
     * 介護サービス種類10を返します。
     *
     * @return 介護サービス種類10
     */
    public RString get介護サービス種類10() {
        return entity.getKaigoServiceShurui10();
    }

    /**
     * 介護サービス種類11を返します。
     *
     * @return 介護サービス種類11
     */
    public RString get介護サービス種類11() {
        return entity.getKaigoServiceShurui11();
    }

    /**
     * 介護サービス種類12を返します。
     *
     * @return 介護サービス種類12
     */
    public RString get介護サービス種類12() {
        return entity.getKaigoServiceShurui12();
    }

    /**
     * 介護サービス種類13を返します。
     *
     * @return 介護サービス種類13
     */
    public RString get介護サービス種類13() {
        return entity.getKaigoServiceShurui13();
    }

    /**
     * 介護サービス種類14を返します。
     *
     * @return 介護サービス種類14
     */
    public RString get介護サービス種類14() {
        return entity.getKaigoServiceShurui14();
    }

    /**
     * 介護サービス種類15を返します。
     *
     * @return 介護サービス種類15
     */
    public RString get介護サービス種類15() {
        return entity.getKaigoServiceShurui15();
    }

    /**
     * 介護サービス種類16を返します。
     *
     * @return 介護サービス種類16
     */
    public RString get介護サービス種類16() {
        return entity.getKaigoServiceShurui16();
    }

    /**
     * 介護サービス種類17を返します。
     *
     * @return 介護サービス種類17
     */
    public RString get介護サービス種類17() {
        return entity.getKaigoServiceShurui17();
    }

    /**
     * 介護サービス種類18を返します。
     *
     * @return 介護サービス種類18
     */
    public RString get介護サービス種類18() {
        return entity.getKaigoServiceShurui18();
    }

    /**
     * 介護サービス種類19を返します。
     *
     * @return 介護サービス種類19
     */
    public RString get介護サービス種類19() {
        return entity.getKaigoServiceShurui19();
    }

    /**
     * 介護サービス種類20を返します。
     *
     * @return 介護サービス種類20
     */
    public RString get介護サービス種類20() {
        return entity.getKaigoServiceShurui20();
    }

    /**
     * 介護サービス種類21を返します。
     *
     * @return 介護サービス種類21
     */
    public RString get介護サービス種類21() {
        return entity.getKaigoServiceShurui21();
    }

    /**
     * 介護サービス種類22を返します。
     *
     * @return 介護サービス種類22
     */
    public RString get介護サービス種類22() {
        return entity.getKaigoServiceShurui22();
    }

    /**
     * 介護サービス種類23を返します。
     *
     * @return 介護サービス種類23
     */
    public RString get介護サービス種類23() {
        return entity.getKaigoServiceShurui23();
    }

    /**
     * 介護サービス種類24を返します。
     *
     * @return 介護サービス種類24
     */
    public RString get介護サービス種類24() {
        return entity.getKaigoServiceShurui24();
    }

    /**
     * 介護サービス種類25を返します。
     *
     * @return 介護サービス種類25
     */
    public RString get介護サービス種類25() {
        return entity.getKaigoServiceShurui25();
    }

    /**
     * 介護サービス種類26を返します。
     *
     * @return 介護サービス種類26
     */
    public RString get介護サービス種類26() {
        return entity.getKaigoServiceShurui26();
    }

    /**
     * 介護サービス種類27を返します。
     *
     * @return 介護サービス種類27
     */
    public RString get介護サービス種類27() {
        return entity.getKaigoServiceShurui27();
    }

    /**
     * 介護サービス種類28を返します。
     *
     * @return 介護サービス種類28
     */
    public RString get介護サービス種類28() {
        return entity.getKaigoServiceShurui28();
    }

    /**
     * 介護サービス種類29を返します。
     *
     * @return 介護サービス種類29
     */
    public RString get介護サービス種類29() {
        return entity.getKaigoServiceShurui29();
    }

    /**
     * 介護サービス種類30を返します。
     *
     * @return 介護サービス種類30
     */
    public RString get介護サービス種類30() {
        return entity.getKaigoServiceShurui30();
    }

    /**
     * 要介護認定結果異動事由を返します。
     *
     * @return 要介護認定結果異動事由
     */
    public RString get要介護認定結果異動事由() {
        return entity.getNinteiKekkaIdoJiyu();
    }

    /**
     * 要介護認定結果異動年月日を返します。
     *
     * @return 要介護認定結果異動年月日
     */
    public FlexibleDate get要介護認定結果異動年月日() {
        return entity.getNinteiKekkaIdoYMD();
    }

    /**
     * 要介護認定取消理由を返します。
     *
     * @return 要介護認定取消理由
     */
    public RString get要介護認定取消理由() {
        return entity.getNinteiTorikeshiRiyu();
    }

    /**
     * 要介護認定取消年月日を返します。
     *
     * @return 要介護認定取消年月日
     */
    public FlexibleDate get要介護認定取消年月日() {
        return entity.getNinteiTorikeshiYMD();
    }

    /**
     * 通知区分を返します。
     *
     * @return 通知区分
     */
    public RString get通知区分() {
        return entity.getTuchiKubun();
    }

    /**
     * 認定理由を返します。
     *
     * @return 認定理由
     */
    public RString get認定理由() {
        return entity.getNinteiRiyu();
    }

    /**
     * 審査会メモを返します。
     *
     * @return 審査会メモ
     */
    public RString get審査会メモ() {
        return entity.getShinsakaiMemo();
    }

    /**
     * IF送付年月日を返します。
     *
     * @return IF送付年月日
     */
    public FlexibleDate getIF送付年月日() {
        return entity.getIfSofuYMD();
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void set申請書管理番号(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(RString 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(RString 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 要介護度認定年月日を設定します。
     *
     * @param 要介護度認定年月日 要介護度認定年月日
     */
    public void set要介護度認定年月日(FlexibleDate 要介護度認定年月日) {
        requireNonNull(要介護度認定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護度認定年月日"));
        entity.setYoukaigodoNinteiYMD(要介護度認定年月日);
    }

    /**
     * 要介護状態区分コードを設定します。
     *
     * @param 要介護状態区分コード 要介護状態区分コード
     */
    public void set要介護状態区分コード(Code 要介護状態区分コード) {
        requireNonNull(要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分コード"));
        entity.setYoukaigoJotaiKubunCode(要介護状態区分コード);
    }

    /**
     * 認定有効期間を設定します。
     *
     * @param 認定有効期間 認定有効期間
     */
    public void set認定有効期間(int 認定有効期間) {
        requireNonNull(認定有効期間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間"));
        entity.setNinteiYukoKikan(認定有効期間);
    }

    /**
     * 認定有効期間開始年月日を設定します。
     *
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     */
    public void set認定有効期間開始年月日(FlexibleDate 認定有効期間開始年月日) {
        requireNonNull(認定有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間開始年月日"));
        entity.setNinteiYukoKaishiYMD(認定有効期間開始年月日);
    }

    /**
     * 認定有効期間終了年月日を設定します。
     *
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     */
    public void set認定有効期間終了年月日(FlexibleDate 認定有効期間終了年月日) {
        requireNonNull(認定有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間終了年月日"));
        entity.setNinteiYukoShuryoYMD(認定有効期間終了年月日);
    }

    /**
     * 介護保険の特定疾病コードを設定します。
     *
     * @param 介護保険の特定疾病コード 介護保険の特定疾病コード
     */
    public void set介護保険の特定疾病コード(Code 介護保険の特定疾病コード) {
        requireNonNull(介護保険の特定疾病コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険の特定疾病コード"));
        entity.setTokuteiShippeiCode(介護保険の特定疾病コード);
    }

    /**
     * 施設入所の有無を設定します。
     *
     * @param 施設入所の有無 施設入所の有無
     */
    public void set施設入所の有無(boolean 施設入所の有無) {
        requireNonNull(施設入所の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("施設入所の有無"));
        entity.setShisetsuNyushoFlag(施設入所の有無);
    }

    /**
     * 介護認定審査会開催番号を設定します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     */
    public void set介護認定審査会開催番号(int 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
    }

    /**
     * 介護認定審査会意見を設定します。
     *
     * @param 介護認定審査会意見 介護認定審査会意見
     */
    public void set介護認定審査会意見(RString 介護認定審査会意見) {
        requireNonNull(介護認定審査会意見, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会意見"));
        entity.setShinsakaiIken(介護認定審査会意見);
    }

    /**
     * 一次判定結果変更理由を設定します。
     *
     * @param 一次判定結果変更理由 一次判定結果変更理由
     */
    public void set一次判定結果変更理由(RString 一次判定結果変更理由) {
        requireNonNull(一次判定結果変更理由, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定結果変更理由"));
        entity.setIchijiHnateiKekkaHenkoRiyu(一次判定結果変更理由);
    }

    /**
     * 要介護状態像例コードを設定します。
     *
     * @param 要介護状態像例コード 要介護状態像例コード
     */
    public void set要介護状態像例コード(Code 要介護状態像例コード) {
        requireNonNull(要介護状態像例コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態像例コード"));
        entity.setYokaigoJotaizoReiCode(要介護状態像例コード);
    }

    /**
     * 認定審査会意見種類を設定します。
     *
     * @param 認定審査会意見種類 認定審査会意見種類
     */
    public void set認定審査会意見種類(RString 認定審査会意見種類) {
        requireNonNull(認定審査会意見種類, UrSystemErrorMessages.値がnull.getReplacedMessage("認定審査会意見種類"));
        entity.setNinteishinsakaiIkenShurui(認定審査会意見種類);
    }

    /**
     * 介護サービス種類01を設定します。
     *
     * @param 介護サービス種類01 介護サービス種類01
     */
    public void set介護サービス種類01(RString 介護サービス種類01) {
        requireNonNull(介護サービス種類01, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類01"));
        entity.setKaigoServiceShurui01(介護サービス種類01);
    }

    /**
     * 介護サービス種類02を設定します。
     *
     * @param 介護サービス種類02 介護サービス種類02
     */
    public void set介護サービス種類02(RString 介護サービス種類02) {
        requireNonNull(介護サービス種類02, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類02"));
        entity.setKaigoServiceShurui02(介護サービス種類02);
    }

    /**
     * 介護サービス種類03を設定します。
     *
     * @param 介護サービス種類03 介護サービス種類03
     */
    public void set介護サービス種類03(RString 介護サービス種類03) {
        requireNonNull(介護サービス種類03, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類03"));
        entity.setKaigoServiceShurui03(介護サービス種類03);
    }

    /**
     * 介護サービス種類04を設定します。
     *
     * @param 介護サービス種類04 介護サービス種類04
     */
    public void set介護サービス種類04(RString 介護サービス種類04) {
        requireNonNull(介護サービス種類04, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類04"));
        entity.setKaigoServiceShurui04(介護サービス種類04);
    }

    /**
     * 介護サービス種類05を設定します。
     *
     * @param 介護サービス種類05 介護サービス種類05
     */
    public void set介護サービス種類05(RString 介護サービス種類05) {
        requireNonNull(介護サービス種類05, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類05"));
        entity.setKaigoServiceShurui05(介護サービス種類05);
    }

    /**
     * 介護サービス種類06を設定します。
     *
     * @param 介護サービス種類06 介護サービス種類06
     */
    public void set介護サービス種類06(RString 介護サービス種類06) {
        requireNonNull(介護サービス種類06, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類06"));
        entity.setKaigoServiceShurui06(介護サービス種類06);
    }

    /**
     * 介護サービス種類07を設定します。
     *
     * @param 介護サービス種類07 介護サービス種類07
     */
    public void set介護サービス種類07(RString 介護サービス種類07) {
        requireNonNull(介護サービス種類07, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類07"));
        entity.setKaigoServiceShurui07(介護サービス種類07);
    }

    /**
     * 介護サービス種類08を設定します。
     *
     * @param 介護サービス種類08 介護サービス種類08
     */
    public void set介護サービス種類08(RString 介護サービス種類08) {
        requireNonNull(介護サービス種類08, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類08"));
        entity.setKaigoServiceShurui08(介護サービス種類08);
    }

    /**
     * 介護サービス種類09を設定します。
     *
     * @param 介護サービス種類09 介護サービス種類09
     */
    public void set介護サービス種類09(RString 介護サービス種類09) {
        requireNonNull(介護サービス種類09, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類09"));
        entity.setKaigoServiceShurui09(介護サービス種類09);
    }

    /**
     * 介護サービス種類10を設定します。
     *
     * @param 介護サービス種類10 介護サービス種類10
     */
    public void set介護サービス種類10(RString 介護サービス種類10) {
        requireNonNull(介護サービス種類10, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類10"));
        entity.setKaigoServiceShurui10(介護サービス種類10);
    }

    /**
     * 介護サービス種類11を設定します。
     *
     * @param 介護サービス種類11 介護サービス種類11
     */
    public void set介護サービス種類11(RString 介護サービス種類11) {
        requireNonNull(介護サービス種類11, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類11"));
        entity.setKaigoServiceShurui11(介護サービス種類11);
    }

    /**
     * 介護サービス種類12を設定します。
     *
     * @param 介護サービス種類12 介護サービス種類12
     */
    public void set介護サービス種類12(RString 介護サービス種類12) {
        requireNonNull(介護サービス種類12, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類12"));
        entity.setKaigoServiceShurui12(介護サービス種類12);
    }

    /**
     * 介護サービス種類13を設定します。
     *
     * @param 介護サービス種類13 介護サービス種類13
     */
    public void set介護サービス種類13(RString 介護サービス種類13) {
        requireNonNull(介護サービス種類13, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類13"));
        entity.setKaigoServiceShurui13(介護サービス種類13);
    }

    /**
     * 介護サービス種類14を設定します。
     *
     * @param 介護サービス種類14 介護サービス種類14
     */
    public void set介護サービス種類14(RString 介護サービス種類14) {
        requireNonNull(介護サービス種類14, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類14"));
        entity.setKaigoServiceShurui14(介護サービス種類14);
    }

    /**
     * 介護サービス種類15を設定します。
     *
     * @param 介護サービス種類15 介護サービス種類15
     */
    public void set介護サービス種類15(RString 介護サービス種類15) {
        requireNonNull(介護サービス種類15, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類15"));
        entity.setKaigoServiceShurui15(介護サービス種類15);
    }

    /**
     * 介護サービス種類16を設定します。
     *
     * @param 介護サービス種類16 介護サービス種類16
     */
    public void set介護サービス種類16(RString 介護サービス種類16) {
        requireNonNull(介護サービス種類16, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類16"));
        entity.setKaigoServiceShurui16(介護サービス種類16);
    }

    /**
     * 介護サービス種類17を設定します。
     *
     * @param 介護サービス種類17 介護サービス種類17
     */
    public void set介護サービス種類17(RString 介護サービス種類17) {
        requireNonNull(介護サービス種類17, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類17"));
        entity.setKaigoServiceShurui17(介護サービス種類17);
    }

    /**
     * 介護サービス種類18を設定します。
     *
     * @param 介護サービス種類18 介護サービス種類18
     */
    public void set介護サービス種類18(RString 介護サービス種類18) {
        requireNonNull(介護サービス種類18, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類18"));
        entity.setKaigoServiceShurui18(介護サービス種類18);
    }

    /**
     * 介護サービス種類19を設定します。
     *
     * @param 介護サービス種類19 介護サービス種類19
     */
    public void set介護サービス種類19(RString 介護サービス種類19) {
        requireNonNull(介護サービス種類19, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類19"));
        entity.setKaigoServiceShurui19(介護サービス種類19);
    }

    /**
     * 介護サービス種類20を設定します。
     *
     * @param 介護サービス種類20 介護サービス種類20
     */
    public void set介護サービス種類20(RString 介護サービス種類20) {
        requireNonNull(介護サービス種類20, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類20"));
        entity.setKaigoServiceShurui20(介護サービス種類20);
    }

    /**
     * 介護サービス種類21を設定します。
     *
     * @param 介護サービス種類21 介護サービス種類21
     */
    public void set介護サービス種類21(RString 介護サービス種類21) {
        requireNonNull(介護サービス種類21, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類21"));
        entity.setKaigoServiceShurui21(介護サービス種類21);
    }

    /**
     * 介護サービス種類22を設定します。
     *
     * @param 介護サービス種類22 介護サービス種類22
     */
    public void set介護サービス種類22(RString 介護サービス種類22) {
        requireNonNull(介護サービス種類22, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類22"));
        entity.setKaigoServiceShurui22(介護サービス種類22);
    }

    /**
     * 介護サービス種類23を設定します。
     *
     * @param 介護サービス種類23 介護サービス種類23
     */
    public void set介護サービス種類23(RString 介護サービス種類23) {
        requireNonNull(介護サービス種類23, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類23"));
        entity.setKaigoServiceShurui23(介護サービス種類23);
    }

    /**
     * 介護サービス種類24を設定します。
     *
     * @param 介護サービス種類24 介護サービス種類24
     */
    public void set介護サービス種類24(RString 介護サービス種類24) {
        requireNonNull(介護サービス種類24, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類24"));
        entity.setKaigoServiceShurui24(介護サービス種類24);
    }

    /**
     * 介護サービス種類25を設定します。
     *
     * @param 介護サービス種類25 介護サービス種類25
     */
    public void set介護サービス種類25(RString 介護サービス種類25) {
        requireNonNull(介護サービス種類25, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類25"));
        entity.setKaigoServiceShurui25(介護サービス種類25);
    }

    /**
     * 介護サービス種類26を設定します。
     *
     * @param 介護サービス種類26 介護サービス種類26
     */
    public void set介護サービス種類26(RString 介護サービス種類26) {
        requireNonNull(介護サービス種類26, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類26"));
        entity.setKaigoServiceShurui26(介護サービス種類26);
    }

    /**
     * 介護サービス種類27を設定します。
     *
     * @param 介護サービス種類27 介護サービス種類27
     */
    public void set介護サービス種類27(RString 介護サービス種類27) {
        requireNonNull(介護サービス種類27, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類27"));
        entity.setKaigoServiceShurui27(介護サービス種類27);
    }

    /**
     * 介護サービス種類28を設定します。
     *
     * @param 介護サービス種類28 介護サービス種類28
     */
    public void set介護サービス種類28(RString 介護サービス種類28) {
        requireNonNull(介護サービス種類28, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類28"));
        entity.setKaigoServiceShurui28(介護サービス種類28);
    }

    /**
     * 介護サービス種類29を設定します。
     *
     * @param 介護サービス種類29 介護サービス種類29
     */
    public void set介護サービス種類29(RString 介護サービス種類29) {
        requireNonNull(介護サービス種類29, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類29"));
        entity.setKaigoServiceShurui29(介護サービス種類29);
    }

    /**
     * 介護サービス種類30を設定します。
     *
     * @param 介護サービス種類30 介護サービス種類30
     */
    public void set介護サービス種類30(RString 介護サービス種類30) {
        requireNonNull(介護サービス種類30, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類30"));
        entity.setKaigoServiceShurui30(介護サービス種類30);
    }

    /**
     * 要介護認定結果異動事由を設定します。
     *
     * @param 要介護認定結果異動事由 要介護認定結果異動事由
     */
    public void set要介護認定結果異動事由(RString 要介護認定結果異動事由) {
        requireNonNull(要介護認定結果異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果異動事由"));
        entity.setNinteiKekkaIdoJiyu(要介護認定結果異動事由);
    }

    /**
     * 要介護認定結果異動年月日を設定します。
     *
     * @param 要介護認定結果異動年月日 要介護認定結果異動年月日
     */
    public void set要介護認定結果異動年月日(FlexibleDate 要介護認定結果異動年月日) {
        requireNonNull(要介護認定結果異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果異動年月日"));
        entity.setNinteiKekkaIdoYMD(要介護認定結果異動年月日);
    }

    /**
     * 要介護認定取消理由を設定します。
     *
     * @param 要介護認定取消理由 要介護認定取消理由
     */
    public void set要介護認定取消理由(RString 要介護認定取消理由) {
        requireNonNull(要介護認定取消理由, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定取消理由"));
        entity.setNinteiTorikeshiRiyu(要介護認定取消理由);
    }

    /**
     * 要介護認定取消年月日を設定します。
     *
     * @param 要介護認定取消年月日 要介護認定取消年月日
     */
    public void set要介護認定取消年月日(FlexibleDate 要介護認定取消年月日) {
        requireNonNull(要介護認定取消年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定取消年月日"));
        entity.setNinteiTorikeshiYMD(要介護認定取消年月日);
    }

    /**
     * 通知区分を設定します。
     *
     * @param 通知区分 通知区分
     */
    public void set通知区分(RString 通知区分) {
        requireNonNull(通知区分, UrSystemErrorMessages.値がnull.getReplacedMessage("通知区分"));
        entity.setTuchiKubun(通知区分);
    }

    /**
     * 認定理由を設定します。
     *
     * @param 認定理由 認定理由
     */
    public void set認定理由(RString 認定理由) {
        requireNonNull(認定理由, UrSystemErrorMessages.値がnull.getReplacedMessage("認定理由"));
        entity.setNinteiRiyu(認定理由);
    }

    /**
     * 審査会メモを設定します。
     *
     * @param 審査会メモ 審査会メモ
     */
    public void set審査会メモ(RString 審査会メモ) {
        requireNonNull(審査会メモ, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会メモ"));
        entity.setShinsakaiMemo(審査会メモ);
    }

    /**
     * IF送付年月日を設定します。
     *
     * @param if送付年月日 IF送付年月日
     */
    public void setIF送付年月日(FlexibleDate if送付年月日) {
        requireNonNull(if送付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("IF送付年月日"));
        entity.setIfSofuYMD(if送付年月日);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
