/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbd.entity.basic.INinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.SeibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定申請情報（ビジネス）を扱うインターフェースです。
 *
 * @author N8235 船山 洋介
 */
public interface INinteiShinseiJoho {

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    ShinseishoKanriNo get申請書管理番号();

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    Code get厚労省IF識別コード();

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    RString get証記載保険者番号();

    /**
     * 申請年度を返します。
     *
     * @return 申請年度
     */
    FlexibleYear get申請年度();

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    RString get被保険者番号();

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    FlexibleDate get認定申請年月日();

    /**
     * 認定申請枝番コードを返します。
     *
     * @return 認定申請枝番コード
     */
    EdabanCode get認定申請枝番コード();

    /**
     * 認定申請区分_法令_コードを返します。
     *
     * @return 認定申請区分_法令_コード
     */
    Code get認定申請区分_法令_コード();

    /**
     * 認定申請区分_申請時_コードを返します。
     *
     * @return 認定申請区分_申請時_コード
     */
    Code get認定申請区分_申請時_コード();

    /**
     * 取下区分コードを返します。
     *
     * @return 取下区分コード
     */
    Code get取下区分コード();

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    RString get被保険者区分コード();

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    FlexibleDate get生年月日();

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    int get年齢();

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    SeibetsuCode get性別();

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    AtenaKanaMeisho get被保険者氏名カナ();

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    AtenaMeisho get被保険者氏名();

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
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    RString get支所コード();

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    ShikibetsuCode get識別コード();

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    ChikuCode get地区コード();

    /**
     * みなし二号等対象フラグを返します。
     *
     * @return みなし二号等対象フラグ
     */
    boolean isみなし二号等対象フラグ();

    /**
     * 広域内転居区分を返します。
     *
     * @return 広域内転居区分
     */
    Code get広域内転居区分();

    /**
     * 認定申請有効区分を返します。
     *
     * @return 認定申請有効区分
     */
    Code get認定申請有効区分();

    /**
     * 要介護申請_要支援申請の区分を返します。
     *
     * @return 要介護申請_要支援申請の区分
     */
    RString get要介護申請_要支援申請の区分();

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由
     */
    RString get認定申請理由();

    /**
     * 申請サービス削除の理由を返します。
     *
     * @return 申請サービス削除の理由
     */
    RString get申請サービス削除の理由();

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return 前回要介護状態区分コード
     */
    Code get前回要介護状態区分コード();

    /**
     * 前回認定年月日を返します。
     *
     * @return 前回認定年月日
     */
    FlexibleDate get前回認定年月日();

    /**
     * 前回認定有効期間_開始を返します。
     *
     * @return 前回認定有効期間_開始
     */
    FlexibleDate get前回認定有効期間_開始();

    /**
     * 前回認定有効期間_終了を返します。
     *
     * @return 前回認定有効期間_終了
     */
    FlexibleDate get前回認定有効期間_終了();

    /**
     * 二号医療保険者名を返します。
     *
     * @return 二号医療保険者名
     */
    RString get二号医療保険者名();

    /**
     * 二号医療保険記号番号を返します。
     *
     * @return 二号医療保険記号番号
     */
    RString get二号医療保険記号番号();

    /**
     * 二号特定疾病コードを返します。
     *
     * @return 二号特定疾病コード
     */
    Code get二号特定疾病コード();

    /**
     * 自動割当除外者区分を返します。
     *
     * @return 自動割当除外者区分
     */
    RString get自動割当除外者区分();

    /**
     * 情報提供への同意有無を返します。
     *
     * @return 情報提供への同意有無
     */
    boolean is情報提供への同意有無();

    /**
     * 情報提供資料出力年月日を返します。
     *
     * @return 情報提供資料出力年月日
     */
    FlexibleDate get情報提供資料出力年月日();

    /**
     * 調査区分を返します。
     *
     * @return 調査区分
     */
    Code get調査区分();

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    RString get認定調査委託先コード();

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    RString get認定調査員コード();

    /**
     * 調査員への連絡事項を返します。
     *
     * @return 調査員への連絡事項
     */
    RString get調査員への連絡事項();

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
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    boolean is指定医フラグ();

    /**
     * 意見書データ種別を返します。
     *
     * @return 意見書データ種別
     */
    Code get意見書データ種別();

    /**
     * 主治医への連絡事項を返します。
     *
     * @return 主治医への連絡事項
     */
    RString get主治医への連絡事項();

    /**
     * みなし要介護区分コードを返します。
     *
     * @return みなし要介護区分コード
     */
    Code getみなし要介護区分コード();

    /**
     * 認定延期通知発行しないことに対する同意有無を返します。
     *
     * @return 認定延期通知発行しないことに対する同意有無
     */
    boolean is認定延期通知発行しないことに対する同意有無();

    /**
     * 施設入所の有無を返します。
     *
     * @return 施設入所の有無
     */
    boolean is施設入所の有無();

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    RString get入所施設コード();

    /**
     * 家庭訪問の有無を返します。
     *
     * @return 家庭訪問の有無
     */
    boolean is家庭訪問の有無();

    /**
     * 訪問調査先郵便番号を返します。
     *
     * @return 訪問調査先郵便番号
     */
    YubinNo get訪問調査先郵便番号();

    /**
     * 訪問調査先住所を返します。
     *
     * @return 訪問調査先住所
     */
    AtenaJusho get訪問調査先住所();

    /**
     * 訪問調査先名称を返します。
     *
     * @return 訪問調査先名称
     */
    AtenaMeisho get訪問調査先名称();

    /**
     * 訪問調査先電話番号を返します。
     *
     * @return 訪問調査先電話番号
     */
    TelNo get訪問調査先電話番号();

    /**
     * 市町村連絡事項を返します。
     *
     * @return 市町村連絡事項
     */
    RString get市町村連絡事項();

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    Code get処理状態区分();

    /**
     * 取下年月日を返します。
     *
     * @return 取下年月日
     */
    FlexibleDate get取下年月日();

    /**
     * 取下理由を返します。
     *
     * @return 取下理由
     */
    RString get取下理由();

    /**
     * 却下年月日を返します。
     *
     * @return 却下年月日
     */
    FlexibleDate get却下年月日();

    /**
     * 却下理由を返します。
     *
     * @return 却下理由
     */
    RString get却下理由();

    /**
     * 延期決定年月日を返します。
     *
     * @return 延期決定年月日
     */
    FlexibleDate get延期決定年月日();

    /**
     * 延期理由を返します。
     *
     * @return 延期理由
     */
    RString get延期理由();

    /**
     * 延期通知発行年月日を返します。
     *
     * @return 延期通知発行年月日
     */
    FlexibleDate get延期通知発行年月日();

    /**
     * 延期通知発行回数を返します。
     *
     * @return 延期通知発行回数
     */
    int get延期通知発行回数();

    /**
     * 延期見込期間開始年月日を返します。
     *
     * @return 延期見込期間開始年月日
     */
    FlexibleDate get延期見込期間開始年月日();

    /**
     * 延期見込期間終了年月日を返します。
     *
     * @return 延期見込期間終了年月日
     */
    FlexibleDate get延期見込期間終了年月日();

    /**
     * 審査継続区分を返します。
     *
     * @return 審査継続区分
     */
    boolean is審査継続区分();

    /**
     * 要介護認定審査会優先振分区分コードを返します。
     *
     * @return 要介護認定審査会優先振分区分コード
     */
    Code get要介護認定審査会優先振分区分コード();

    /**
     * 更新通知発行年月日を返します。
     *
     * @return 更新通知発行年月日
     */
    FlexibleDate get更新通知発行年月日();

    /**
     * 更新通知発行完了年月日を返します。
     *
     * @return 更新通知発行完了年月日
     */
    FlexibleDate get更新通知発行完了年月日();

    /**
     * 認定申請情報登録年月日を返します。
     *
     * @return 認定申請情報登録年月日
     */
    FlexibleDate get認定申請情報登録年月日();

    /**
     * 再調査依頼回数を返します。
     *
     * @return 再調査依頼回数
     */
    int get再調査依頼回数();

    /**
     * 再作成依頼回数を返します。
     *
     * @return 再作成依頼回数
     */
    int get再作成依頼回数();

    /**
     * ＩＦ送付年月日を返します。
     *
     * @return ＩＦ送付年月日
     */
    FlexibleDate getＩＦ送付年月日();

    /**
     * 論理削除区分を返します。
     *
     * @return ＩＦ送付年月日
     */
    boolean is論理削除区分();

    /**
     * INinteiShinseiJohoEntityを取得します。
     *
     * @return INinteiShinseiJohoEntity
     */
    INinteiShinseiJohoEntity getEntity();

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    EntityDataState getState();

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    Builder createBuilderForEdit();

    /**
     * 認定申請情報ビルダーの親クラスです。
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
         * koroshoIfShikibetsuCodeを設定します。
         *
         * @param koroshoIfShikibetsuCode 厚労省IF識別コード
         * @return builder
         */
        public Builder setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {

            return this;
        }

        /**
         * shoKisaiHokenshaNoを設定します。
         *
         * @param shoKisaiHokenshaNo 証記載保険者番号
         * @return builder
         */
        public Builder setShoKisaiHokenshaNo(RString shoKisaiHokenshaNo) {

            return this;
        }

        /**
         * shinseiNendoを設定します。
         *
         * @param shinseiNendo 申請年度
         * @return builder
         */
        public Builder setShinseiNendo(FlexibleYear shinseiNendo) {

            return this;
        }

        /**
         * hihokenshaNoを設定します。
         *
         * @param hihokenshaNo 被保険者番号
         * @return builder
         */
        public Builder setHihokenshaNo(RString hihokenshaNo) {

            return this;
        }

        /**
         * ninteiShinseiYMDを設定します。
         *
         * @param ninteiShinseiYMD 認定申請年月日
         * @return builder
         */
        public Builder setNinteiShinseiYMD(FlexibleDate ninteiShinseiYMD) {
            return this;
        }

        /**
         * ninteiShinseiEdabanCodeを設定します。
         *
         * @param ninteiShinseiEdabanCode 認定申請枝番コード
         * @return builder
         */
        public Builder setNinteiShinseiEdabanCode(EdabanCode ninteiShinseiEdabanCode) {
            return this;
        }

        /**
         * ninteiShinseiHoreiKubunCodeを設定します。
         *
         * @param ninteiHoreiKubunCode 認定申請区分（法令）コード
         * @return builder
         */
        public Builder setNinteiShinseiHoreiKubunCode(Code ninteiHoreiKubunCode) {
            return this;
        }

        /**
         * ninteiShinseiShinseijiKubunCodeを設定します。
         *
         * @param ninteiShinseijiKubunCode 認定申請区分（申請時）コード
         * @return builder
         */
        public Builder setNinteiShinseiShinseijiKubunCode(Code ninteiShinseijiKubunCode) {
            return this;
        }

        /**
         * torisageKubunCodeを設定します。
         *
         * @param torisageKubunCode 取下区分コード
         * @return builder
         */
        public Builder setTorisageKubunCode(Code torisageKubunCode) {
            return this;
        }

        /**
         * hihokenshaKubunCodeを設定します。
         *
         * @param hihokenshaKubunCode 被保険者区分コード
         * @return builder
         */
        public Builder setHihokenshaKubunCode(RString hihokenshaKubunCode) {
            return this;
        }

        /**
         * seinengappiYMDを設定します。
         *
         * @param seinengappiYMD 生年月日
         * @return builder
         */
        public Builder setSeinengappiYMD(FlexibleDate seinengappiYMD) {
            return this;
        }

        /**
         * ageを設定します。
         *
         * @param age 年齢
         * @return builder
         */
        public Builder setAge(int age) {
            return this;
        }

        /**
         * seibetsuを設定します。
         *
         * @param seibetsu 性別
         * @return builder
         */
        public Builder setSeibetsu(SeibetsuCode seibetsu) {
            return this;
        }

        /**
         * hihokenshaKanaを設定します。
         *
         * @param hihokenshaKana 被保険者氏名カナ
         * @return builder
         */
        public Builder setHihokenshaKana(AtenaKanaMeisho hihokenshaKana) {
            return this;
        }

        /**
         * hihokenshaNameを設定します。
         *
         * @param hihokenshaName 被保険者氏名
         * @return builder
         */
        public Builder setHihokenshaName(AtenaMeisho hihokenshaName) {
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
         * shishoCodeを設定します。
         *
         * @param shishoCode 支所コード
         * @return builder
         */
        public Builder setShishoCode(RString shishoCode) {
            return this;
        }

        /**
         * shikibetsuCodeを設定します。
         *
         * @param shikibetsuCode 識別コード
         * @return builder
         */
        public Builder setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
            return this;
        }

        /**
         * chikuCodeを設定します。
         *
         * @param chikuCode 地区コード
         * @return builder
         */
        public Builder setChikuCode(ChikuCode chikuCode) {
            return this;
        }

        /**
         * minashiNigoEtcTaishoFlagを設定します。
         *
         * @param minashiNigoEtcTaishoFlag みなし２号等対象フラグ
         * @return builder
         */
        public Builder setMinashiNigoEtcTaishoFlag(boolean minashiNigoEtcTaishoFlag) {
            return this;
        }

        /**
         * koikinaiTenkyoKubunを設定します。
         *
         * @param koikinaiTenkyoKubun 広域内転居区分
         * @return builder
         */
        public Builder setKoikinaiTenkyoKubun(Code koikinaiTenkyoKubun) {
            return this;
        }

        /**
         * ninteiShinseiYukoKubunCodeを設定します。
         *
         * @param ninteiShinseiYukoKubunCode 認定申請有効区分
         * @return builder
         */
        public Builder setNinteiShinseiYukoKubunCode(Code ninteiShinseiYukoKubunCode) {
            return this;
        }

        /**
         * shienShinseiKubunを設定します。
         *
         * @param shienShinseiKubun 要介護申請・要支援申請の区分
         * @return builder
         */
        public Builder setShienShinseiKubun(RString shienShinseiKubun) {
            return this;
        }

        /**
         * ninteiShinseiRiyuを設定します。
         *
         * @param ninteiShinseiRiyu 認定申請理由
         * @return builder
         */
        public Builder setNinteiShinseiRiyu(RString ninteiShinseiRiyu) {
            return this;
        }

        /**
         * shinseiServiceDeleteRiyuを設定します。
         *
         * @param shinseiServiceDeleteRiyu 申請サービス削除の理由
         * @return builder
         */
        public Builder setShinseiServiceDeleteRiyu(RString shinseiServiceDeleteRiyu) {
            return this;
        }

        /**
         * zenYokaigoKubunCodeを設定します。
         *
         * @param zenYokaigoKubunCode 前回要介護状態区分コード
         * @return builder
         */
        public Builder setZenYokaigoKubunCode(Code zenYokaigoKubunCode) {
            return this;
        }

        /**
         * zenkaiNinteiYMDを設定します。
         *
         * @param zenkaiNinteiYMD 前回認定年月日
         * @return builder
         */
        public Builder setZenkaiNinteiYMD(FlexibleDate zenkaiNinteiYMD) {
            return this;
        }

        /**
         * zenkaiYukoKikanStartを設定します。
         *
         * @param zenkaiYukoKikanStart 前回認定有効期間（開始）
         * @return builder
         */
        public Builder setZenkaiYukoKikanStart(FlexibleDate zenkaiYukoKikanStart) {
            return this;
        }

        /**
         * zenkaiYukoKikanEndを設定します。
         *
         * @param zenkaiYukoKikanEnd 前回認定有効期間（終了）
         * @return builder
         */
        public Builder setZenkaiYukoKikanEnd(FlexibleDate zenkaiYukoKikanEnd) {
            return this;
        }

        /**
         * nigoIryoHokenshaNameを設定します。
         *
         * @param nigoIryoHokenshaName ２号医療保険者名
         * @return builder
         */
        public Builder setNigoIryoHokenshaName(RString nigoIryoHokenshaName) {
            return this;
        }

        /**
         * nigoIryoHokenKigoBangoを設定します。
         *
         * @param nigoIryoHokenKigoBango ２号医療保険記号番号
         * @return builder
         */
        public Builder setNigoIryoHokenKigoBango(RString nigoIryoHokenKigoBango) {
            return this;
        }

        /**
         * nigoTokuteiShippeiCodeを設定します。
         *
         * @param nigoTokuteiShippeiCode ２号特定疾病コード
         * @return builder
         */
        public Builder setNigoTokuteiShippeiCode(Code nigoTokuteiShippeiCode) {
            return this;
        }

        /**
         * jidoWariateJogaishaKubunを設定します。
         *
         * @param jidoWariateJogaishaKubun 自動割当除外者区分
         * @return builder
         */
        public Builder setJidoWariateJogaishaKubun(RString jidoWariateJogaishaKubun) {
            return this;
        }

        /**
         * johoteikyoDoiFlagを設定します。
         *
         * @param johoteikyoDoiFlag 情報提供への同意有無
         * @return builder
         */
        public Builder setJohoteikyoDoiFlag(boolean johoteikyoDoiFlag) {
            return this;
        }

        /**
         * johoteikyoSiryoOutputYMDを設定します。
         *
         * @param johoteikyoSiryoOutputYMD 情報提供資料出力年月日
         * @return builder
         */
        public Builder setJohoteikyoSiryoOutputYMD(FlexibleDate johoteikyoSiryoOutputYMD) {
            return this;
        }

        /**
         * chosaKubunを設定します。
         *
         * @param chosaKubun 調査区分
         * @return builder
         */
        public Builder setChosaKubun(Code chosaKubun) {
            return this;
        }

        /**
         * ninteichosaItakusakiCodeを設定します。
         *
         * @param ninteichosaItakusakiCode 認定調査委託先コード
         * @return builder
         */
        public Builder setNinteichosaItakusakiCode(RString ninteichosaItakusakiCode) {
            return this;
        }

        /**
         * ninteiChousainCodeを設定します。
         *
         * @param ninteiChousainCode 認定調査員コード
         * @return builder
         */
        public Builder setNinteiChousainCode(RString ninteiChousainCode) {
            return this;
        }

        /**
         * renrakuJikoToChosainを設定します。
         *
         * @param renrakuJikoToChosain 調査員への連絡事項
         * @return builder
         */
        public Builder setRenrakuJikoToChosain(RString renrakuJikoToChosain) {
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
         * shiteiiFlagを設定します。
         *
         * @param shiteiiFlag 指定医フラグ
         * @return builder
         */
        public Builder setShiteiiFlag(boolean shiteiiFlag) {
            return this;
        }

        /**
         * ikenshoDataShubetsuを設定します。
         *
         * @param ikenshoDataShubetsu 意見書データ種別
         * @return builder
         */
        public Builder setIkenshoDataShubetsu(Code ikenshoDataShubetsu) {
            return this;
        }

        /**
         * renrakuJikoToShujiiを設定します。
         *
         * @param renrakuJikoToShujii 主治医への連絡事項
         * @return builder
         */
        public Builder setRenrakuJikoToShujii(RString renrakuJikoToShujii) {
            return this;
        }

        /**
         * minashiCodeを設定します。
         *
         * @param minashiCode みなし要介護区分コード
         * @return builder
         */
        public Builder setMinashiCode(Code minashiCode) {
            return this;
        }

        /**
         * enkitsuchiNashiDoiFlagを設定します。
         *
         * @param enkitsuchiNashiDoiFlag 認定延期通知発行しないことに対する同意有無
         * @return builder
         */
        public Builder setEnkitsuchiNashiDoiFlag(boolean enkitsuchiNashiDoiFlag) {
            return this;
        }

        /**
         * shisetsuNyushoFlagを設定します。
         *
         * @param shisetsuNyushoFlag 施設入所の有無
         * @return builder
         */
        public Builder setShisetsuNyushoFlag(boolean shisetsuNyushoFlag) {
            return this;
        }

        /**
         * nyushoShisetsuCodeを設定します。
         *
         * @param nyushoShisetsuCode 入所施設コード
         * @return builder
         */
        public Builder setNyushoShisetsuCode(RString nyushoShisetsuCode) {
            return this;
        }

        /**
         * kateiHomonFlagを設定します。
         *
         * @param kateiHomonFlag 家庭訪問の有無
         * @return builder
         */
        public Builder setKateiHomonFlag(boolean kateiHomonFlag) {
            return this;
        }

        /**
         * homonChosasakiYubinNoを設定します。
         *
         * @param homonChosasakiYubinNo 訪問調査先郵便番号
         * @return builder
         */
        public Builder setHomonChosasakiYubinNo(YubinNo homonChosasakiYubinNo) {
            return this;
        }

        /**
         * homonChosasakiJushoを設定します。
         *
         * @param homonChosasakiJusho 訪問調査先住所
         * @return builder
         */
        public Builder setHomonChosasakiJusho(AtenaJusho homonChosasakiJusho) {
            return this;
        }

        /**
         * homonChosasakiNameを設定します。
         *
         * @param homonChosasakiName 訪問調査先名称
         * @return builder
         */
        public Builder setHomonChosasakiName(AtenaMeisho homonChosasakiName) {
            return this;
        }

        /**
         * homonChosasakiTelNoを設定します。
         *
         * @param homonChosasakiTelNo 訪問調査先電話番号
         * @return builder
         */
        public Builder setHomonChosasakiTelNo(TelNo homonChosasakiTelNo) {
            return this;
        }

        /**
         * sichosonRenrakuJikoを設定します。
         *
         * @param sichosonRenrakuJiko 市町村連絡事項
         * @return builder
         */
        public Builder setSichosonRenrakuJiko(RString sichosonRenrakuJiko) {
            return this;
        }

        /**
         * shoriJotaiKubunを設定します。
         *
         * @param shoriJotaiKubun 処理状態区分
         * @return builder
         */
        public Builder setShoriJotaiKubun(Code shoriJotaiKubun) {
            return this;
        }

        /**
         * torisageYMDを設定します。
         *
         * @param torisageYMD 取下年月日
         * @return builder
         */
        public Builder setTorisageYMD(FlexibleDate torisageYMD) {
            return this;
        }

        /**
         * torisageRiyuを設定します。
         *
         * @param torisageRiyu 取下理由
         * @return builder
         */
        public Builder setTorisageRiyu(RString torisageRiyu) {
            return this;
        }

        /**
         * kyakkaYMDを設定します。
         *
         * @param kyakkaYMD 却下年月日
         * @return builder
         */
        public Builder setKyakkaYMD(FlexibleDate kyakkaYMD) {
            return this;
        }

        /**
         * kyakkaRiyuを設定します。
         *
         * @param kyakkaRiyu 却下理由
         * @return builder
         */
        public Builder setKyakkaRiyu(RString kyakkaRiyu) {
            return this;
        }

        /**
         * enkiKetteiYMDを設定します。
         *
         * @param enkiKetteiYMD 延期決定年月日
         * @return builder
         */
        public Builder setEnkiKetteiYMD(FlexibleDate enkiKetteiYMD) {
            return this;
        }

        /**
         * enkiRiyuを設定します。
         *
         * @param enkiRiyu 延期理由
         * @return builder
         */
        public Builder setEnkiRiyu(RString enkiRiyu) {
            return this;
        }

        /**
         * enkitsuchiHakkoYMDを設定します。
         *
         * @param enkitsuchiHakkoYMD 延期通知発行年月日
         * @return builder
         */
        public Builder setEnkitsuchiHakkoYMD(FlexibleDate enkitsuchiHakkoYMD) {
            return this;
        }

        /**
         * enkitsuchiHakkoKaisuを設定します。
         *
         * @param enkitsuchiHakkoKaisu 延期通知発行回数
         * @return builder
         */
        public Builder setEnkitsuchiHakkoKaisu(int enkitsuchiHakkoKaisu) {
            return this;
        }

        /**
         * enkiMikomiKaishiYMDを設定します。
         *
         * @param enkiMikomiKaishiYMD 延期見込期間開始年月日
         * @return builder
         */
        public Builder setEnkiMikomiKaishiYMD(FlexibleDate enkiMikomiKaishiYMD) {
            return this;
        }

        /**
         * enkiMikomiShuryoYMDを設定します。
         *
         * @param enkiMikomiShuryoYMD 延期見込期間終了年月日
         * @return builder
         */
        public Builder setEnkiMikomiShuryoYMD(FlexibleDate enkiMikomiShuryoYMD) {
            return this;
        }

        /**
         * shinsaKeizokuFlagを設定します。
         *
         * @param shinsaKeizokuFlag 審査継続区分
         * @return builder
         */
        public Builder setShinsaKeizokuFlag(boolean shinsaKeizokuFlag) {
            return this;
        }

        /**
         * shinsakaiYusenWaritsukeKubunCodeを設定します。
         *
         * @param shinsakaiYusenWaritsukeCode 要介護認定審査会優先振分区分コード
         * @return builder
         */
        public Builder setShinsakaiYusenWaritsukeKubunCode(Code shinsakaiYusenWaritsukeCode) {
            return this;
        }

        /**
         * kosinTsuchiHakkoYMDを設定します。
         *
         * @param kosinTsuchiHakkoYMD 更新通知発行年月日
         * @return builder
         */
        public Builder setKosinTsuchiHakkoYMD(FlexibleDate kosinTsuchiHakkoYMD) {
            return this;
        }

        /**
         * kosinTsuchiHakkoKanryoYMDを設定します。
         *
         * @param kosinTsuchiHakkoKanryoYMD 更新通知発行完了年月日
         * @return builder
         */
        public Builder setKosinTsuchiHakkoKanryoYMD(FlexibleDate kosinTsuchiHakkoKanryoYMD) {
            return this;
        }

        /**
         * ninteiShinseiJohoTorokuYMDを設定します。
         *
         * @param ninteiShinseiJohoTorokuYMD 認定申請情報登録年月日
         * @return builder
         */
        public Builder setNinteiShinseiJohoTorokuYMD(FlexibleDate ninteiShinseiJohoTorokuYMD) {
            return this;
        }

        /**
         * saiChosaIraiKaisuを設定します。
         *
         * @param saiChosaIraiKaisu 再調査依頼回数
         * @return builder
         */
        public Builder setSaiChosaIraiKaisu(int saiChosaIraiKaisu) {
            return this;
        }

        /**
         * saiSakuseiIraiKaisuを設定します。
         *
         * @param saiSakuseiIraiKaisu 再作成依頼回数
         * @return builder
         */
        public Builder setSaiSakuseiIraiKaisu(int saiSakuseiIraiKaisu) {
            return this;
        }

        /**
         * ifSofuYMDを設定します。
         *
         * @param ifSofuYMD ＩＦ送付年月日
         * @return builder
         */
        public Builder setIfSofuYMD(FlexibleDate ifSofuYMD) {
            return this;
        }

        /**
         * logicalDeletedFlagを設定します。
         *
         * @param logicalDeletedFlag 論理削除フラグ
         * @return builder
         */
        public Builder setLogicalDeletedFlag(boolean logicalDeletedFlag) {
            return this;
        }

        /**
         * {@link HokenshaNinteiShinseiJoho}を生成します。
         *
         * @return {@link HokenshaNinteiShinseiJoho}
         */
        public INinteiShinseiJoho build() {
            return new INinteiShinseiJoho.Builder().build();
        }
    }

}
