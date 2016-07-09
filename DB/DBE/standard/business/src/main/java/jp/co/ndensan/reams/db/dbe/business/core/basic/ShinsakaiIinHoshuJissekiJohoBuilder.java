/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5603ShinsakaiIinHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinsakaiIinHoshuJissekiJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-011 zhengsongling
 */
public class ShinsakaiIinHoshuJissekiJohoBuilder {

    private final DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity;
    private final ShinsakaiIinHoshuJissekiJohoIdentifier id;

    /**
     * {@link DbT5603ShinsakaiIinHoshuJissekiJohoEntity}より{@link ShinsakaiIinHoshuJissekiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5603ShinsakaiIinHoshuJissekiJohoEntity}
     * @param id {@link ShinsakaiIinHoshuJissekiJohoIdentifier}
     *
     */
    ShinsakaiIinHoshuJissekiJohoBuilder(
            DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity,
            ShinsakaiIinHoshuJissekiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 介護認定審査会委員コードを設定します。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査会委員コード(RString 介護認定審査会委員コード) {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        entity.setShinsakaiIinCode(介護認定審査会委員コード);
        return this;
    }

    /**
     * 審査会委員報酬区分を設定します。
     *
     * @param 審査会委員報酬区分 審査会委員報酬区分
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set審査会委員報酬区分(Code 審査会委員報酬区分) {
        requireNonNull(審査会委員報酬区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員報酬区分"));
        entity.setShinsakaiIinHoshuKubun(審査会委員報酬区分);
        return this;
    }

    /**
     * 実施年月日を設定します。
     *
     * @param 実施年月日 実施年月日
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set実施年月日(FlexibleDate 実施年月日) {
        requireNonNull(実施年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("実施年月日"));
        entity.setShinsakaiKaisaiYMD(実施年月日);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRemban(連番);
        return this;
    }

    /**
     * 介護認定審査会開催番号を設定します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査会開催番号(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        return this;
    }

    /**
     * 介護認定審査会報酬税率を設定します。
     *
     * @param 介護認定審査会報酬税率 介護認定審査会報酬税率
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査会報酬税率(int 介護認定審査会報酬税率) {
        requireNonNull(介護認定審査会報酬税率, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会報酬税率"));
        entity.setShinsakaiHoshuZeiritsu(介護認定審査会報酬税率);
        return this;
    }

    /**
     * 介護認定審査報酬を設定します。
     *
     * @param 介護認定審査報酬 介護認定審査報酬
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査報酬(int 介護認定審査報酬) {
        requireNonNull(介護認定審査報酬, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査報酬"));
        entity.setShinsakaiHoshu(介護認定審査報酬);
        return this;
    }

    /**
     * 介護認定審査その他報酬を設定します。
     *
     * @param 介護認定審査その他報酬 介護認定審査その他報酬
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査その他報酬(int 介護認定審査その他報酬) {
        requireNonNull(介護認定審査その他報酬, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査その他報酬"));
        entity.setShinsakaiSonotaHoshu(介護認定審査その他報酬);
        return this;
    }

    /**
     * 介護認定審査交通費等を設定します。
     *
     * @param 介護認定審査交通費等 介護認定審査交通費等
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査交通費等(int 介護認定審査交通費等) {
        requireNonNull(介護認定審査交通費等, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査交通費等"));
        entity.setShinsakaiKotsuhi(介護認定審査交通費等);
        return this;
    }

    /**
     * 介護認定審査控除税額を設定します。
     *
     * @param 介護認定審査控除税額 介護認定審査控除税額
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査控除税額(int 介護認定審査控除税額) {
        requireNonNull(介護認定審査控除税額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査控除税額"));
        entity.setShinsakaiKojoZeigaku(介護認定審査控除税額);
        return this;
    }

    /**
     * 介護認定審査報酬合計を設定します。
     *
     * @param 介護認定審査報酬合計 介護認定審査報酬合計
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査報酬合計(int 介護認定審査報酬合計) {
        requireNonNull(介護認定審査報酬合計, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査報酬合計"));
        entity.setShinsakaiHoshuGokei(介護認定審査報酬合計);
        return this;
    }

    /**
     * 介護認定審査報酬支払年月日を設定します。
     *
     * @param 介護認定審査報酬支払年月日 介護認定審査報酬支払年月日
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査報酬支払年月日(FlexibleDate 介護認定審査報酬支払年月日) {
        requireNonNull(介護認定審査報酬支払年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査報酬支払年月日"));
        entity.setHoshuShiharaiYMD(介護認定審査報酬支払年月日);
        return this;
    }

    /**
     * 介護認定審査報酬支払メモを設定します。
     *
     * @param 介護認定審査報酬支払メモ 介護認定審査報酬支払メモ
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set介護認定審査報酬支払メモ(RString 介護認定審査報酬支払メモ) {
        requireNonNull(介護認定審査報酬支払メモ, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査報酬支払メモ"));
        entity.setHoshuShiharaiMemo(介護認定審査報酬支払メモ);
        return this;
    }

    /**
     * 銀行振込出力フラグを設定します。
     *
     * @param 銀行振込出力フラグ 銀行振込出力フラグ
     * @return {@link ShinsakaiIinHoshuJissekiJohoBuilder}
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder set銀行振込出力フラグ(boolean 銀行振込出力フラグ) {
        requireNonNull(銀行振込出力フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("銀行振込出力フラグ"));
        entity.setGinkoFurikomiShutsuryokuFlag(銀行振込出力フラグ);
        return this;
    }

    /**
     * {@link ShinsakaiIinHoshuJissekiJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiIinHoshuJissekiJoho}のインスタンス
     */
    public ShinsakaiIinHoshuJissekiJoho build() {
        return new ShinsakaiIinHoshuJissekiJoho(entity, id);
    }
}
