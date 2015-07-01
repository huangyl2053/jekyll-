/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.entity.basic.INinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 前回認定結果情報（ビジネス）を扱うインターフェースです。
 *
 * @author n8223 朴義一
 */
public interface INinteiKekkaJoho {

    /**
     * 前回認定結果情報のエンティティを返します。
     *
     * @return 前回認定結果情報のエンティティ
     */
    INinteiKekkaJohoEntity getEntity();

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    ShinseishoKanriNo get申請書管理番号();

    /**
     * 二次判定年月日を返します。
     *
     * @return 二次判定年月日
     */
    FlexibleDate get二次判定年月日();

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    Code get二次判定要介護状態区分コード();

    /**
     * 二次判定認定有効期間を返します。
     *
     * @return 二次判定認定有効期間
     */
    Integer get二次判定認定有効期間();

    /**
     * 二次判定認定有効開始年月日を返します。
     *
     * @return 二次判定認定有効開始年月日
     */
    FlexibleDate get二次判定認定有効開始年月日();

    /**
     * 二次判定認定有効終了年月日を返します。
     *
     * @return 二次判定認定有効終了年月日
     */
    FlexibleDate get二次判定認定有効終了年月日();

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    Integer get介護認定審査会開催番号();

    /**
     * 介護認定審査会意見を返します。
     *
     * @return 介護認定審査会意見
     */
    RString get介護認定審査会意見();

    /**
     * 一次判定結果変更理由を返します。
     *
     * @return 一次判定結果変更理由
     */
    RString get一次判定結果変更理由();

    /**
     * 要介護状態像例コードを返します。
     *
     * @return 要介護状態像例コード
     */
    Code get要介護状態像例コード();

    /**
     * 認定審査会意見種類を返します。
     *
     * @return 認定審査会意見種類
     */
    RString get認定審査会意見種類();

    /**
     * 審査会メモを返します。
     *
     * @return 審査会メモ
     */
    RString get審査会メモ();

    /**
     * 二次判定結果入力方法を返します。
     *
     * @return 二次判定結果入力方法
     */
    Code get二次判定結果入力方法();

    /**
     * 二次判定結果入力年月日を返します。
     *
     * @return 二次判定結果入力年月日
     */
    FlexibleDate get二次判定結果入力年月日();

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    EntityDataState getState();

    /**
     * 状態を設定します。
     *
     * @param entityDataState EntityDataState
     */
    void setState(EntityDataState entityDataState);

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    void setDeletedState(boolean deleteFlag);

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    Builder createBuilderForEdit();

    /**
     * {@link HokenshaNinteiKekkaJoho}を生成するためのビルダーです。
     */
    public class Builder {

        /**
         * shinseishoKanriNoを設定します。
         *
         * @param shinseishoKanriNo 申請書管理番号
         * @return builder
         */
        public Builder setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
            return this;
        }

        /**
         * nijiHanteiYMDを設定します。
         *
         * @param nijiHanteiYMD 二次判定年月日
         * @return builder
         */
        public Builder setNijiHanteiYMD(FlexibleDate nijiHanteiYMD) {
            return this;
        }

        /**
         * nijiHanteiYokaigoJotaiKubunCodeを設定します。
         *
         * @param nijiHanteiYokaigoJotaiKubunCode 二次判定要介護状態区分コード
         * @return builder
         */
        public Builder setNijiHanteiYokaigoJotaiKubunCode(Code nijiHanteiYokaigoJotaiKubunCode) {
            return this;
        }

        /**
         * nijiHanteiNinteiYukoKikanを設定します。
         *
         * @param nijiHanteiNinteiYukoKikan 二次判定認定有効期間
         * @return builder
         */
        public Builder setNijiHanteiNinteiYukoKikan(int nijiHanteiNinteiYukoKikan) {
            return this;
        }

        /**
         * nijiHanteiNinteiYukoKaishiYMDを設定します。
         *
         * @param nijiHanteiNinteiYukoKaishiYMD 二次判定認定有効開始年月日
         * @return builder
         */
        public Builder setNijiHanteiNinteiYukoKaishiYMD(FlexibleDate nijiHanteiNinteiYukoKaishiYMD) {
            return this;
        }

        /**
         * nijiHanteiNinteiYukoShuryoYMDを設定します。
         *
         * @param nijiHanteiNinteiYukoShuryoYMD 二次判定認定有効開始年月日
         * @return builder
         */
        public Builder setNijiHanteiNinteiYukoShuryoYMD(FlexibleDate nijiHanteiNinteiYukoShuryoYMD) {
            return this;
        }

        /**
         * shinsakaiKaisaiNoを設定します。
         *
         * @param shinsakaiKaisaiNo 介護認定審査会開催番号
         * @return builder
         */
        public Builder setShinsakaiKaisaiNo(int shinsakaiKaisaiNo) {
            return this;
        }

        /**
         * shinsakaiIkenを設定します。
         *
         * @param shinsakaiIken 介護認定審査会意見
         * @return builder
         */
        public Builder setShinsakaiIken(RString shinsakaiIken) {
            return this;
        }

        /**
         * ichijiHnateiKekkaHenkoRiyuを設定します。
         *
         * @param ichijiHnateiKekkaHenkoRiyu 一次判定結果変更理由
         * @return builder
         */
        public Builder setIchijiHnateiKekkaHenkoRiyu(RString ichijiHnateiKekkaHenkoRiyu) {
            return this;
        }

        /**
         * yokaigoJotaizoReiCodeを設定します。
         *
         * @param yokaigoJotaizoReiCode 要介護状態像例コード
         * @return builder
         */
        public Builder setYokaigoJotaizoReiCode(Code yokaigoJotaizoReiCode) {
            return this;
        }

        /**
         * ninteishinsakaiIkenShuruiを設定します。
         *
         * @param ninteishinsakaiIkenShurui 認定審査会意見種類
         * @return builder
         */
        public Builder setNinteishinsakaiIkenShurui(RString ninteishinsakaiIkenShurui) {
            return this;
        }

        /**
         * shinsakaiMemoを設定します。
         *
         * @param shinsakaiMemo 審査会メモ
         * @return builder
         */
        public Builder setShinsakaiMemo(RString shinsakaiMemo) {
            return this;
        }

        /**
         * nijiHanteiKekkaInputHohoを設定します。
         *
         * @param nijiHanteiKekkaInputHoho 二次判定結果入力方法
         * @return builder
         */
        public Builder setNijiHanteiKekkaInputHoho(Code nijiHanteiKekkaInputHoho) {
            return this;
        }

        /**
         * niniHanteiKekkaInputYMDを設定します。
         *
         * @param niniHanteiKekkaInputYMD 二次判定結果入力年月日
         * @return builder
         */
        public Builder setNiniHanteiKekkaInputYMD(FlexibleDate niniHanteiKekkaInputYMD) {
            return this;
        }

        /**
         * {@link INinteiKekkaJoho}を生成します。
         *
         * @return {@link INinteiKekkaJoho}
         */
        public INinteiKekkaJoho build() {
            return new INinteiKekkaJoho.Builder().build();
        }
    }

}
