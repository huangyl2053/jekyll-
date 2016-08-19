/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link DbT4102NinteiKekkaJoho}の編集を行うビルダークラスです。
 */
public class DbT4102NinteiKekkaJohoBuilder {

    private final DbT4102NinteiKekkaJohoEntity entity;
    private final DbT4102NinteiKekkaJohoIdentifier id;

    /**
     * {@link DbT4102NinteiKekkaJohoEntity}より{@link DbT4102NinteiKekkaJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4102NinteiKekkaJohoEntity}
     * @param id {@link DbT4102NinteiKekkaJohoIdentifier}
     *
     */
    DbT4102NinteiKekkaJohoBuilder(
            DbT4102NinteiKekkaJohoEntity entity,
            DbT4102NinteiKekkaJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 二次判定年月日を設定します。
     *
     * @param 二次判定年月日 二次判定年月日
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set二次判定年月日(FlexibleDate 二次判定年月日) {
        requireNonNull(二次判定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定年月日"));
        entity.setNijiHanteiYMD(二次判定年月日);
        return this;
    }

    /**
     * 二次判定要介護状態区分コードを設定します。
     *
     * @param 二次判定要介護状態区分コード 二次判定要介護状態区分コード
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set二次判定要介護状態区分コード(Code 二次判定要介護状態区分コード) {
        requireNonNull(二次判定要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定要介護状態区分コード"));
        entity.setNijiHanteiYokaigoJotaiKubunCode(二次判定要介護状態区分コード);
        return this;
    }

    /**
     * 二次判定認定有効期間を設定します。
     *
     * @param 二次判定認定有効期間 二次判定認定有効期間
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set二次判定認定有効期間(int 二次判定認定有効期間) {
        requireNonNull(二次判定認定有効期間, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定認定有効期間"));
        entity.setNijiHanteiNinteiYukoKikan(二次判定認定有効期間);
        return this;
    }

    /**
     * 二次判定認定有効開始年月日を設定します。
     *
     * @param 二次判定認定有効開始年月日 二次判定認定有効開始年月日
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set二次判定認定有効開始年月日(FlexibleDate 二次判定認定有効開始年月日) {
        requireNonNull(二次判定認定有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定認定有効開始年月日"));
        entity.setNijiHanteiNinteiYukoKaishiYMD(二次判定認定有効開始年月日);
        return this;
    }

    /**
     * 二次判定認定有効終了年月日を設定します。
     *
     * @param 二次判定認定有効終了年月日 二次判定認定有効終了年月日
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set二次判定認定有効終了年月日(FlexibleDate 二次判定認定有効終了年月日) {
        requireNonNull(二次判定認定有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定認定有効終了年月日"));
        entity.setNijiHanteiNinteiYukoShuryoYMD(二次判定認定有効終了年月日);
        return this;
    }

    /**
     * 介護認定審査会資料作成年月日を設定します。
     *
     * @param 介護認定審査会資料作成年月日 介護認定審査会資料作成年月日
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set介護認定審査会資料作成年月日(FlexibleDate 介護認定審査会資料作成年月日) {
        requireNonNull(介護認定審査会資料作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会資料作成年月日"));
        entity.setShinsakaiShiryoSakuseiYMD(介護認定審査会資料作成年月日);
        return this;
    }

    /**
     * 介護認定審査会開催番号を設定します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set介護認定審査会開催番号(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        return this;
    }

    /**
     * 介護認定審査会意見を設定します。
     *
     * @param 介護認定審査会意見 介護認定審査会意見
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set介護認定審査会意見(RString 介護認定審査会意見) {
        requireNonNull(介護認定審査会意見, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会意見"));
        entity.setShinsakaiIken(介護認定審査会意見);
        return this;
    }

    /**
     * 一次判定結果変更理由を設定します。
     *
     * @param 一次判定結果変更理由 一次判定結果変更理由
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set一次判定結果変更理由(RString 一次判定結果変更理由) {
        requireNonNull(一次判定結果変更理由, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定結果変更理由"));
        entity.setIchijiHanteiKekkaHenkoRiyu(一次判定結果変更理由);
        return this;
    }

    /**
     * 要介護状態像例コードを設定します。
     *
     * @param 要介護状態像例コード 要介護状態像例コード
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set要介護状態像例コード(Code 要介護状態像例コード) {
        requireNonNull(要介護状態像例コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態像例コード"));
        entity.setYokaigoJotaizoReiCode(要介護状態像例コード);
        return this;
    }

    /**
     * 認定審査会意見種類を設定します。
     *
     * @param 認定審査会意見種類 認定審査会意見種類
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set認定審査会意見種類(RString 認定審査会意見種類) {
        requireNonNull(認定審査会意見種類, UrSystemErrorMessages.値がnull.getReplacedMessage("認定審査会意見種類"));
        entity.setNinteishinsakaiIkenShurui(認定審査会意見種類);
        return this;
    }

    /**
     * 審査会メモを設定します。
     *
     * @param 審査会メモ 審査会メモ
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set審査会メモ(RString 審査会メモ) {
        requireNonNull(審査会メモ, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会メモ"));
        entity.setShinsakaiMemo(審査会メモ);
        return this;
    }

    /**
     * 二次判定結果入力方法を設定します。
     *
     * @param 二次判定結果入力方法 二次判定結果入力方法
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set二次判定結果入力方法(Code 二次判定結果入力方法) {
        requireNonNull(二次判定結果入力方法, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定結果入力方法"));
        entity.setNijiHanteiKekkaInputHoho(二次判定結果入力方法);
        return this;
    }

    /**
     * 二次判定結果入力年月日を設定します。
     *
     * @param 二次判定結果入力年月日 二次判定結果入力年月日
     * @return {@link DbT4102NinteiKekkaJohoBuilder}
     */
    public DbT4102NinteiKekkaJohoBuilder set二次判定結果入力年月日(FlexibleDate 二次判定結果入力年月日) {
        requireNonNull(二次判定結果入力年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定結果入力年月日"));
        entity.setNijiHanteiKekkaInputYMD(二次判定結果入力年月日);
        return this;
    }

    /**
     * {@link DbT4102NinteiKekkaJoho}のインスタンスを生成します。
     *
     * @return {@link DbT4102NinteiKekkaJoho}のインスタンス
     */
    public DbT4102NinteiKekkaJoho build() {
        return new DbT4102NinteiKekkaJoho(entity, id);
    }
}
