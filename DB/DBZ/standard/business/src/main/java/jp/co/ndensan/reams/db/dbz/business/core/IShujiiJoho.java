/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.IShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医情報のインターフェースです。
 *
 * @author N8235 船山 洋介
 */
public interface IShujiiJoho {

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    RString get主治医医療機関コード();

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    RString get主治医コード();

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    RString get主治医氏名();

    /**
     * 主治医カナを返します。
     *
     * @return 主治医カナ
     */
    AtenaKanaMeisho get主治医カナ();

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
     * 診療科名称を返します。
     *
     * @return 診療科名称
     */
    RString get診療科名称();

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    boolean is指定医フラグ();

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    boolean is状況フラグ();

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    EntityDataState getState();

    /**
     * IShujiiJohoEntityを返します。
     *
     * @return IShujiiJohoEntity
     */
    IShujiiJohoEntity getEntity();

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    Builder createBuilderForEdit();

    /**
     * {@link IShujiiJoho}を生成するためのビルダーです。
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
         * shujiiIryokikanCodeを設定します。
         *
         * @param shujiiIryokikanCode 主治医医療機関コード
         * @return builder
         */
        public Builder setShujiiIryokikanCode(RString shujiiIryokikanCode) {
            return this;
        }

        /**
         * shujiiCodeを設定します。
         *
         * @param shujiiCode 主治医コード
         * @return builder
         */
        public Builder setShujiiCode(RString shujiiCode) {
            return this;
        }

        /**
         * shujiiNameを設定します。
         *
         * @param shujiiName 主治医氏名
         * @return builder
         */
        public Builder setShujiiName(RString shujiiName) {
            return this;
        }

        /**
         * shujiiKanaを設定します。
         *
         * @param shujiiKana 主治医カナ
         * @return builder
         */
        public Builder setShujiiKana(AtenaKanaMeisho shujiiKana) {
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
         * shinryokaNameを設定します。
         *
         * @param shinryokaName 診療科名称
         * @return builder
         */
        public Builder setShinryokaName(RString shinryokaName) {
            return this;
        }

        /**
         * shiteiiFlagを設定します。
         *
         * @param shiteiiFlag 指定医フラグ
         * @return builder
         */
        public Builder setShiteiiFlag(boolean shiteiiFlag) {
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
         * {@link IShujiiJoho}を生成します。
         *
         * @return {@link IShujiiJoho}
         */
        public IShujiiJoho build() {
            return new IShujiiJoho.Builder().build();
        }
    }

}
