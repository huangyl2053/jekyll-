/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.IShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 申請届出情報（ビジネス）を扱うインターフェースです。
 *
 * @author n8223 朴義一
 */
public interface IShinseitodokedeJoho {

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    ShinseishoKanriNo get申請書管理番号();

    /**
     * 申請届出代行区分コードを返します。
     *
     * @return 申請届出代行区分コード
     */
    Code get申請届出代行区分コード();

    /**
     * 申請届出者氏名を返します。
     *
     * @return 申請届出者氏名
     */
    RString get申請届出者氏名();

    /**
     * 申請届出者氏名カナを返します。
     *
     * @return 申請届出者氏名カナ
     */
    RString get申請届出者氏名カナ();

    /**
     * 申請届出者続柄コードを返します。
     *
     * @return 申請届出者続柄コード
     */
    RString get申請届出者続柄コード();

    /**
     * 申請届出代行事業者番号を返します。
     *
     * @return 申請届出代行事業者番号
     */
    JigyoshaNo get申請届出代行事業者番号();

    /**
     * 事業者区分を返します。
     *
     * @return 事業者区分
     */
    RString get事業者区分();

    /**
     * 申請届出者郵便番号を返します。
     *
     * @return 申請届出者郵便番号
     */
    YubinNo get申請届出者郵便番号();

    /**
     * 申請届出者住所を返します。
     *
     * @return 申請届出者住所
     */
    RString get申請届出者住所();

    /**
     * 申請届出者電話番号を返します。
     *
     * @return 申請届出者電話番号
     */
    TelNo get申請届出者電話番号();

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    EntityDataState getState();

    /**
     * DbT4120ShinseitodokedeJohoEntityを返します。
     *
     * @return DbT4120ShinseitodokedeJohoEntity
     */
    IShinseitodokedeJohoEntity getEntity();

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    Builder createBuilderForEdit();

    /**
     * {@link ShinsakaiShinseitodokedeJoho}を生成するためのビルダーです。
     */
    class Builder {

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
         * shinseiTodokedeDaikoKubunCodeを設定します。
         *
         * @param shinseiTodokedeDaikoKubunCode 申請届出代行区分コード
         * @return builder
         */
        public Builder setShinseiTodokedeDaikoKubunCode(Code shinseiTodokedeDaikoKubunCode) {
            return this;
        }

        /**
         * shinseiTodokedeshaShimeiを設定します。
         *
         * @param shinseiTodokedeshaShimei 申請届出者氏名
         * @return builder
         */
        public Builder setShinseiTodokedeshaShimei(AtenaMeisho shinseiTodokedeshaShimei) {

            return this;
        }

        /**
         * shinseiTodokedeshaKanaShimeiを設定します。
         *
         * @param shinseiTodokedeshaKanaShimei 申請届出者氏名カナ
         * @return builder
         */
        public Builder setShinseiTodokedeshaKanaShimei(AtenaKanaMeisho shinseiTodokedeshaKanaShimei) {
            return this;
        }

        /**
         * shinseiTodokedeshaTsuzukigaraCodeを設定します。
         *
         * @param todokedeshaTsuzukigaraCode 申請届出者続柄コード
         * @return builder
         */
        public Builder setShinseiTodokedeshaTsuzukigaraCode(RString todokedeshaTsuzukigaraCode) {
            return this;
        }

        /**
         * shinseiTodokedeDaikoJigyoshaNoを設定します。
         *
         * @param shinseiTodokedeDaikoJigyoshaNo 申請届出代行事業者番号
         * @return builder
         */
        public Builder setShinseiTodokedeDaikoJigyoshaNo(JigyoshaNo shinseiTodokedeDaikoJigyoshaNo) {
            return this;
        }

        /**
         * jigyoshaKubunを設定します。
         *
         * @param jigyoshaKubun 事業者区分
         * @return builder
         */
        public Builder setJigyoshaKubun(RString jigyoshaKubun) {
            return this;
        }

        /**
         * shinseiTodokedeshaYubinNoを設定します。
         *
         * @param shinseiTodokedeshaYubinNo 申請届出者郵便番号
         * @return builder
         */
        public Builder setShinseiTodokedeshaYubinNo(YubinNo shinseiTodokedeshaYubinNo) {
            return this;
        }

        /**
         * shinseiTodokedeshaJushoを設定します。
         *
         * @param shinseiTodokedeshaJusho 申請届出者住所
         * @return builder
         */
        public Builder setShinseiTodokedeshaJusho(AtenaJusho shinseiTodokedeshaJusho) {
            return this;
        }

        /**
         * shinseiTodokedeshaTelNoを設定します。
         *
         * @param shinseiTodokedeshaTelNo 申請届出者電話番号
         * @return builder
         */
        public Builder setShinseiTodokedeshaTelNo(TelNo shinseiTodokedeshaTelNo) {
            return this;
        }

        /**
         * {@link IShinseitodokedeJoho}を生成します。
         *
         * @return {@link IShinseitodokedeJoho}
         */
        public IShinseitodokedeJoho build() {
            return new IShinseitodokedeJoho.Builder().build();
        }
    }

}
