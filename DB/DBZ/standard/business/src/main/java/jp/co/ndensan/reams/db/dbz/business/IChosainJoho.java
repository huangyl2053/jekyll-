/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.IChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 調査員情報を表すインターフェースです。
 *
 * @author n8223　朴義一
 */
public interface IChosainJoho {

    /**
     * 調査員エンティティの情報を返します。
     *
     * @return 調査員情報エンティティの情報
     */
    IChosainJohoEntity getEntity();

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
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    ChosainCode get認定調査員コード();

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    RString get調査員氏名();

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    RString get調査員氏名カナ();

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    RString get性別();

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    RString get調査員資格();

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    RString get地区コード();

    /**
     * 調査可能人数月を返します。
     *
     * @return 調査可能人数月
     */
    int get調査可能人数月();

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
    AtenaJusho get住所();

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
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    boolean has状況フラグ();

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
     * 編集用のビルダーを設定します。
     *
     * @return ビルダー
     */
    Builder createBuilderForEdit();

    /**
     * {@link IChosainJoho}を生成するためのビルダーです。
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
         * ninteiChosainNoを設定します。
         *
         * @param ninteiChosainNo 認定調査員コード
         * @return builder
         */
        public Builder setNinteiChosainNo(ChosainCode ninteiChosainNo) {
            return this;
        }

        /**
         * chosainShimeiを設定します。
         *
         * @param chosainShimei 調査員氏名
         * @return builder
         */
        public Builder setChosainShimei(RString chosainShimei) {
            return this;
        }

        /**
         * chosainKanaShimeiを設定します。
         *
         * @param chosainKanaShimei 調査員氏名カナ
         * @return builder
         */
        public Builder setChosainKanaShimei(RString chosainKanaShimei) {
            return this;
        }

        /**
         * seibetsuを設定します。
         *
         * @param seibetsu 性別
         * @return builder
         */
        public Builder setSeibetsu(RString seibetsu) {
            return this;
        }

        /**
         * chosainShikakuを設定します。
         *
         * @param chosainShikaku 調査員資格
         * @return builder
         */
        public Builder setChosainShikaku(RString chosainShikaku) {
            return this;
        }

        /**
         * chikuCodeを設定します。
         *
         * @param chikuCode 地区コード
         * @return builder
         */
        public Builder setChikuCode(RString chikuCode) {
            return this;
        }

        /**
         * chosaKanoNinzuPerMonthを設定します。
         *
         * @param chosaKanoNinzuPerMonth 調査可能人数／月
         * @return builder
         */
        public Builder setChosaKanoNinzuPerMonth(int chosaKanoNinzuPerMonth) {
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
        public Builder setJusho(AtenaJusho jusho) {
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
         * JokyoFlagを設定します。
         *
         * @param jokyoFlag 状況フラグ
         * @return builder
         */
        public Builder setJokyoFlag(boolean jokyoFlag) {
            return this;
        }

        /**
         * {@link IChosainJoho}を生成します。
         *
         * @return {@link IChosainJoho}
         */
        public IChosainJoho build() {
            return new IChosainJoho.Builder().build();
        }
    };

}
