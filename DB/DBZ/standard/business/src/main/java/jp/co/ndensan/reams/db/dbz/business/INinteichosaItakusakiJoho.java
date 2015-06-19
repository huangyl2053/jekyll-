/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.INinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査委託先情報を表すインターフェースです。
 *
 * @author n8223　朴義一
 */
public interface INinteichosaItakusakiJoho {

    /**
     * 認定調査委託先エンティティの情報を返します。
     *
     * @return 認定調査委託先エンティティの情報
     */
    INinteichosaItakusakiJohoEntity getEntity();

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    ChosaItakusakiCode get認定調査委託先コード();

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    JigyoshaNo get事業者番号();

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    RString get事業者名称();

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    RString get事業者名称カナ();

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    YubinNo get郵便番号();

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    RString get住所();

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    TelNo get電話番号();

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    TelNo getFAX番号();

    /**
     * 代表者名を返します。
     *
     * @return 代表者名
     */
    AtenaMeisho get代表者名();

    /**
     * 調査委託区分を返します。
     *
     * @return 調査委託区分
     */
    RString get調査委託区分();

    /**
     * 割付定員を返します。
     *
     * @return 割付定員
     */
    int get割付定員();

    /**
     * 割付地区を返します。
     *
     * @return 割付地区
     */
    ChikuCode get割付地区();

    /**
     * 自動割付フラグを返します。
     *
     * @return 自動割付フラグ
     */
    boolean get自動割付フラグ();

    /**
     * 機関の区分を返します。
     *
     * @return 機関の区分
     */
    RString get機関の区分();

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    boolean get状況フラグ();

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
     * {@link INinteichosaItakusakiJoho}を生成するためのビルダーです。
     */
    public class Builder {

        /**
         * shichosonCodeを設定します。
         *
         * @param shichosonCode 市町村コード
         * @return builder
         */
        public Builder setShichosonCode(LasdecCode shichosonCode) {
            return this;
        }

        /**
         * ninteichosaItakusakiCodeを設定します。
         *
         * @param ninteichosaItakusakiCode 認定調査委託先コード
         * @return builder
         */
        public Builder setNinteichosaItakusakiCode(ChosaItakusakiCode ninteichosaItakusakiCode) {
            return this;
        }

        /**
         * jigyoshaNoを設定します。
         *
         * @param jigyoshaNo 事業者番号
         * @return builder
         */
        public Builder setJigyoshaNo(JigyoshaNo jigyoshaNo) {
            return this;
        }

        /**
         * jigyoshaMeishoを設定します。
         *
         * @param jigyoshaMeisho 事業者名称
         * @return builder
         */
        public Builder setJigyoshaMeisho(RString jigyoshaMeisho) {
            return this;
        }

        /**
         * jigyoshaMeishoKanaを設定します。
         *
         * @param jigyoshaMeishoKana 事業者名称カナ
         * @return builder
         */
        public Builder setJigyoshaMeishoKana(RString jigyoshaMeishoKana) {
            return this;
        }

        /**
         * yubinNoを設定します。
         *
         * @param yubinNo 郵便番号
         * @return builder
         */
        public Builder setYubinNo(YubinNo yubinNo) {
            return this;
        }

        /**
         * jushoを設定します。
         *
         * @param jusho 住所
         * @return builder
         */
        public Builder setJusho(RString jusho) {
            return this;
        }

        /**
         * telNoを設定します。
         *
         * @param telNo 電話番号
         * @return builder
         */
        public Builder setTelNo(TelNo telNo) {
            return this;
        }

        /**
         * faxNoを設定します。
         *
         * @param faxNo FAX番号
         * @return builder
         */
        public Builder setFaxNo(TelNo faxNo) {
            return this;
        }

        /**
         * daihyoshaNameを設定します。
         *
         * @param daihyoshaName 代表者名
         * @return builder
         */
        public Builder setDaihyoshaName(AtenaMeisho daihyoshaName) {
            return this;
        }

        /**
         * chosaItakuKubunを設定します。
         *
         * @param chosaItakuKubun 調査委託区分
         * @return builder
         */
        public Builder setChosaItakuKubun(RString chosaItakuKubun) {
            return this;
        }

        /**
         * waritsukeTeiinを設定します。
         *
         * @param waritsukeTeiin 割付定員
         * @return builder
         */
        public Builder setWaritsukeTeiin(int waritsukeTeiin) {
            return this;
        }

        /**
         * waritsukeChikuを設定します。
         *
         * @param waritsukeChiku 割付地区
         * @return builder
         */
        public Builder setWaritsukeChiku(ChikuCode waritsukeChiku) {

            return this;
        }

        /**
         * autoWaritsukeFlagを設定します。
         *
         * @param autoWaritsukeFlag 自動割付フラグ
         * @return builder
         */
        public Builder setAutoWaritsukeFlag(boolean autoWaritsukeFlag) {

            return this;
        }

        /**
         * kikanKubunを設定します。
         *
         * @param kikanKubun 機関の区分
         * @return builder
         */
        public Builder setKikanKubun(RString kikanKubun) {

            return this;
        }

        /**
         * JokyoFlagを設定します。
         *
         * @param jokyoFlag 状況フラグ
         * @return builder
         */
        public Builder setJokyoFlag(boolean jokyoFlag) {

            return this;
        }

        /**
         * {@link HokenshaNinteichosaItakusakiJoho}を生成します。
         *
         * @return {@link HokenshaNinteichosaItakusakiJoho}
         */
        public INinteichosaItakusakiJoho build() {
            return new INinteichosaItakusakiJoho.Builder().build();
        }
    };

}
