/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.IShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医医療機関情報のインターフェースです。
 *
 * @author N8235 船山 洋介
 */
public interface IShujiiIryokikanJoho {

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
    ShujiiIryokikanCode get主治医医療機関コード();

    /**
     * 医療機関コードを返します。
     *
     * @return 医療機関コード
     */
    IryoKikanCode get医療機関コード();

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    RString get医療機関名称();

    /**
     * 医療機関名称カナを返します。
     *
     * @return 医療機関名称カナ
     */
    RString get医療機関名称カナ();

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
    RString get代表者名();

    /**
     * 代表者名カナを返します。
     *
     * @return 代表者名カナ
     */
    RString get代表者名カナ();

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
     * ShujiiIryoKikanJohoEntityを返します。
     *
     * @return DbT4911ShujiiIryoKikanJohoEntity
     */
    IShujiiIryoKikanJohoEntity getEntity();

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    Builder createBuilderForEdit();

    /**
     * {@link IShujiiIryokikanJoho}を生成するためのビルダーです。
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
        public Builder setShujiiIryokikanCode(ShujiiIryokikanCode shujiiIryokikanCode) {
            return this;
        }

        /**
         * iryokikanCodeを設定します。
         *
         * @param iryokikanCode 医療機関コード
         * @return builder
         */
        public Builder setIryokikanCode(IryoKikanCode iryokikanCode) {
            return this;
        }

        /**
         * iryoKikanMeishoを設定します。
         *
         * @param iryoKikanMeisho 医療機関名称
         * @return builder
         */
        public Builder setIryoKikanMeisho(RString iryoKikanMeisho) {
            return this;
        }

        /**
         * iryoKikanMeishoKanaを設定します。
         *
         * @param iryoKikanMeishoKana 医療機関名称カナ
         * @return builder
         */
        public Builder setIryoKikanMeishoKana(RString iryoKikanMeishoKana) {
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
        public Builder setDaihyoshaName(RString daihyoshaName) {
            return this;
        }

        /**
         * daihyoshaNameKanaを設定します。
         *
         * @param daihyoshaNameKana 代表者名カナ
         * @return builder
         */
        public Builder setDaihyoshaNameKana(RString daihyoshaNameKana) {
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
         * {@link IShujiiIryokikanJoho}を生成します。
         *
         * @return {@link IShujiiIryokikanJoho}
         */
        public IShujiiIryokikanJoho build() {
            return new IShujiiIryokikanJoho.Builder().build();
        }
    }
}
