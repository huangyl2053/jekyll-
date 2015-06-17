/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.relate.IKoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 構成市町村マスタ情報（ビジネス）を扱うインタフェースです。
 *
 * @author n8223　朴義一
 */
public interface IKoseiShichosonMaster {

    /**
     * 構成市町村マスタ情報エンティティの情報を返します。
     *
     * @return 構成市町村マスタ情報エンティティの情報
     */
    IKoseiShichosonMasterEntity getEntity();

    /**
     * 市町村識別IDを返します。
     *
     * @return 市町村識別ID
     */
    RString get市町村識別ID();

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    ShoKisaiHokenshaNo get証記載保険者番号();

    /**
     * 国保連広域内市町村番号を返します。
     *
     * @return 国保連広域内市町村番号
     */
    RString get国保連広域内市町村番号();

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    RString get市町村名称();

    /**
     * 都道府県名称を返します。
     *
     * @return 都道府県名称
     */
    RString get都道府県名称();

    /**
     * 郡名称を返します。
     *
     * @return 郡名称
     */
    RString get郡名称();

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
     * 最優先地区コードを返します。
     *
     * @return 最優先地区コード
     */
    RString get最優先地区コード();

    /**
     * 帳票用都道府県名称表示有無を返します。
     *
     * @return 帳票用都道府県名称表示有無
     */
    RString get帳票用都道府県名称表示有無();

    /**
     * 帳票用郡名称表示有無を返します。
     *
     * @return 帳票用郡名称表示有無
     */
    RString get帳票用郡名称表示有無();

    /**
     * 帳票用市町村名称表示有無を返します。
     *
     * @return 帳票用市町村名称表示有無
     */
    RString get帳票用市町村名称表示有無();

    /**
     * 帳票用住所編集方法を返します。
     *
     * @return 帳票用住所編集方法
     */
    RString get帳票用住所編集方法();

    /**
     * 帳票用方書表示有無を返します。
     *
     * @return 帳票用方書表示有無
     */
    RString get帳票用方書表示有無();

    /**
     * 外国人氏名表示方法を返します。
     *
     * @return 外国人氏名表示方法
     */
    RString get外国人氏名表示方法();

    /**
     * 老人保健市町村番号を返します。
     *
     * @return 老人保健市町村番号
     */
    RString get老人保健市町村番号();

    /**
     * 老人保健受給者番号体系を返します。
     *
     * @return 老人保健受給者番号体系
     */
    RString get老人保健受給者番号体系();

    /**
     * 特徴分配集約を返します。
     *
     * @return 特徴分配集約
     */
    RString get特徴分配集約();

    /**
     * 移行日を返します。
     *
     * @return 移行日
     */
    FlexibleDate get移行日();

    /**
     * 加入日を返します。
     *
     * @return 加入日
     */
    FlexibleDate get加入日();

    /**
     * 離脱日を返します。
     *
     * @return 離脱日
     */
    FlexibleDate get離脱日();

    /**
     * 合併旧市町村区分を返します。
     *
     * @return 合併旧市町村区分
     */
    RString get合併旧市町村区分();

    /**
     * 合併旧市町村表示有無を返します。
     *
     * @return 合併旧市町村表示有無
     */
    RString get合併旧市町村表示有無();

    /**
     * 合併情報地域番号を返します。
     *
     * @return 合併情報地域番号
     */
    RString get合併情報地域番号();

    /**
     * 運用保険者番号を返します。
     *
     * @return 運用保険者番号
     */
    ShoKisaiHokenshaNo get運用保険者番号();

    /**
     * 運用開始日を返します。
     *
     * @return 運用開始日
     */
    FlexibleDate get運用開始日();

    /**
     * 運用終了日を返します。
     *
     * @return 運用終了日
     */
    FlexibleDate get運用終了日();

    /**
     * 運用形態区分を返します。
     *
     * @return 運用形態区分
     */
    RString get運用形態区分();

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
     * {@link KaigoKoseiShichosonMaster}を生成するためのビルダーです。
     */
    public class Builder {

        /**
         * shichosonShokibetsuIDを設定します。
         *
         * @param shichosonShokibetsuID 市町村識別ID
         * @return builder
         */
        public Builder setShichosonShokibetsuID(RString shichosonShokibetsuID) {
            return this;
        }

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
         * shoKisaiHokenshaNoを設定します。
         *
         * @param shoKisaiHokenshaNo 証記載保険者番号
         * @return builder
         */
        public Builder setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
            return this;
        }

        /**
         * kokuhorenKoikiShichosonNoを設定します。
         *
         * @param kokuhorenKoikiShichosonNo 国保連広域内市町村番号
         * @return builder
         */
        public Builder setKokuhorenKoikiShichosonNo(RString kokuhorenKoikiShichosonNo) {
            return this;
        }

        /**
         * shichosonMeishoを設定します。
         *
         * @param shichosonMeisho 市町村名称
         * @return builder
         */
        public Builder setShichosonMeisho(RString shichosonMeisho) {
            return this;
        }

        /**
         * todofukenMeishoを設定します。
         *
         * @param todofukenMeisho 都道府県名称
         * @return builder
         */
        public Builder setTodofukenMeisho(RString todofukenMeisho) {
            return this;
        }

        /**
         * gunMeishoを設定します。
         *
         * @param gunMeisho 郡名称
         * @return builder
         */
        public Builder setGunMeisho(RString gunMeisho) {
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
         * yusenChikuCodeを設定します。
         *
         * @param yusenChikuCode 電話番号
         * @return builder
         */
        public Builder setYusenChikuCode(RString yusenChikuCode) {
            return this;
        }

        /**
         * tyohyoTodoufukenHyojiUmuを設定します。
         *
         * @param tyohyoTodoufukenHyojiUmu 帳票用都道府県名称表示有無
         * @return builder
         */
        public Builder setTyohyoTodoufukenHyojiUmu(RString tyohyoTodoufukenHyojiUmu) {
            return this;
        }

        /**
         * tyohyoGunHyojiUmuを設定します。
         *
         * @param tyohyoGunHyojiUmu 帳票用郡名称表示有無
         * @return builder
         */
        public Builder setTyohyoGunHyojiUmu(RString tyohyoGunHyojiUmu) {
            return this;
        }

        /**
         * tyohyoShichosonHyojiUmuを設定します。
         *
         * @param tyohyoShichosonHyojiUmu 帳票用市町村名称表示有無
         * @return builder
         */
        public Builder setTyohyoShichosonHyojiUmu(RString tyohyoShichosonHyojiUmu) {
            return this;
        }

        /**
         * tyohyoJushoHenshuHouhouを設定します。
         *
         * @param tyohyoJushoHenshuHouhou 帳票用住所編集方法
         * @return builder
         */
        public Builder setTyohyoJushoHenshuHouhou(RString tyohyoJushoHenshuHouhou) {
            return this;
        }

        /**
         * tyohyoKatagakiHyojiUmuを設定します。
         *
         * @param tyohyoKatagakiHyojiUmu 帳票用方書表示有無
         * @return builder
         */
        public Builder setTyohyoKatagakiHyojiUmu(RString tyohyoKatagakiHyojiUmu) {
            return this;
        }

        /**
         * gaikokujinHyojiHouhouを設定します。
         *
         * @param gaikokujinHyojiHouhou 外国人氏名表示方法
         * @return builder
         */
        public Builder setGaikokujinHyojiHouhou(RString gaikokujinHyojiHouhou) {
            return this;
        }

        /**
         * rojinhokenShichosonNoを設定します。
         *
         * @param rojinhokenShichosonNo 老人保健市町村番号
         * @return builder
         */
        public Builder setRojinhokenShichosonNo(RString rojinhokenShichosonNo) {
            return this;
        }

        /**
         * rokenJukyushaNoTaikeiを設定します。
         *
         * @param rokenJukyushaNoTaikei 老人保健受給者番号体系
         * @return builder
         */
        public Builder setRokenJukyushaNoTaikei(RString rokenJukyushaNoTaikei) {
            return this;
        }

        /**
         * tokuchoBunpaishuyakuを設定します。
         *
         * @param tokuchoBunpaishuyaku 特徴分配集約
         * @return builder
         */
        public Builder setTokuchoBunpaishuyaku(RString tokuchoBunpaishuyaku) {
            return this;
        }

        /**
         * ikoYMDを設定します。
         *
         * @param ikoYMD 移行日
         * @return builder
         */
        public Builder setIkoYMD(FlexibleDate ikoYMD) {
            return this;
        }

        /**
         * kanyuYMDを設定します。
         *
         * @param kanyuYMD 加入日
         * @return builder
         */
        public Builder setKanyuYMD(FlexibleDate kanyuYMD) {
            return this;
        }

        /**
         * ridatsuYMDを設定します。
         *
         * @param ridatsuYMD 離脱日
         * @return builder
         */
        public Builder setRidatsuYMD(FlexibleDate ridatsuYMD) {
            return this;
        }

        /**
         * gappeiKyuShichosonKubunを設定します。
         *
         * @param gappeiKyuShichosonKubun 合併旧市町村区分
         * @return builder
         */
        public Builder setGappeiKyuShichosonKubun(RString gappeiKyuShichosonKubun) {
            return this;
        }

        /**
         * gappeiKyuShichosonHyojiUmuを設定します。
         *
         * @param gappeiKyuShichosonHyojiUmu 合併旧市町村表示有無
         * @return builder
         */
        public Builder setGappeiKyuShichosonHyojiUmu(RString gappeiKyuShichosonHyojiUmu) {
            return this;
        }

        /**
         * gappeiChiikiNoを設定します。
         *
         * @param gappeiChiikiNo 合併情報地域番号
         * @return builder
         */
        public Builder setGappeiChiikiNo(RString gappeiChiikiNo) {
            return this;
        }

        /**
         * unyoHokenshaNoを設定します。
         *
         * @param unyoHokenshaNo 運用保険者番号
         * @return builder
         */
        public Builder setUnyoHokenshaNo(ShoKisaiHokenshaNo unyoHokenshaNo) {
            return this;
        }

        /**
         * unyoKaishiYMDを設定します。
         *
         * @param unyoKaishiYMD 運用開始日
         * @return builder
         */
        public Builder setUnyoKaishiYMD(FlexibleDate unyoKaishiYMD) {
            return this;
        }

        /**
         * unyoShuryoYMDを設定します。
         *
         * @param unyoShuryoYMD 運用終了日
         * @return builder
         */
        public Builder setUnyoShuryoYMD(FlexibleDate unyoShuryoYMD) {
            return this;
        }

        /**
         * unyoKeitaiKubunを設定します。
         *
         * @param unyoKeitaiKubun 運用形態区分
         * @return builder
         */
        public Builder setUnyoKeitaiKubun(RString unyoKeitaiKubun) {
            return this;
        }

        /**
         * {@link KaigoKoseiShichosonMaster}を生成します。
         *
         * @return {@link KaigoKoseiShichosonMaster}
         */
        public IKoseiShichosonMaster build() {
            return this.build();
        }
    };

}
