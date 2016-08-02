/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.INinteiShinseiJohoEntity;
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
 * 要介護認定申請情報のビジネスクラスです。
 *
 * @author n8235 船山洋介
 */
public class ShinsakaiNinteiShinseiJoho implements INinteiShinseiJoho {

    private DbT5101NinteiShinseiJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShinsakaiNinteiShinseiJoho() {
        entity = new DbT5101NinteiShinseiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5101NinteiShinseiJohoEntity
     */
    public ShinsakaiNinteiShinseiJoho(DbT5101NinteiShinseiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5101NinteiShinseiJohoEntityを返します。
     *
     * @return DbT5101NinteiShinseiJohoEntity
     */
//    @Override
//    public DbT5101NinteiShinseiJohoEntity getEntity() {
//        return entity;
//    }
    /**
     * DbT5101NinteiShinseiJohoEntityを設定します。
     *
     * @param entity DbT5101NinteiShinseiJohoEntity
     */
    public void setEntity(DbT5101NinteiShinseiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    @Override
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    @Override
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    @Override
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 申請年度を返します。
     *
     * @return 申請年度
     */
    @Override
    public FlexibleYear get申請年度() {
        return entity.getShinseiNendo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    @Override
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    @Override
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請枝番コードを返します。
     *
     * @return 認定申請枝番コード
     */
    @Override
    public EdabanCode get認定申請枝番コード() {
        return entity.getNinteiShinseiEdabanCode();
    }

    /**
     * 認定申請区分_法令_コードを返します。
     *
     * @return 認定申請区分_法令_コード
     */
    @Override
    public Code get認定申請区分_法令_コード() {
        return entity.getNinteiShinseiHoreiKubunCode();
    }

    /**
     * 認定申請区分_申請時_コードを返します。
     *
     * @return 認定申請区分_申請時_コード
     */
    @Override
    public Code get認定申請区分_申請時_コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 取下区分コードを返します。
     *
     * @return 取下区分コード
     */
    @Override
    public Code get取下区分コード() {
        return entity.getTorisageKubunCode();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    @Override
    public RString get被保険者区分コード() {
        return entity.getHihokenshaKubunCode();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    @Override
    public FlexibleDate get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    @Override
    public int get年齢() {
        return entity.getAge();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    @Override
    public Code get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    @Override
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.getHihokenshaKana();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    @Override
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    @Override
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    @Override
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    @Override
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    @Override
    public RString get支所コード() {
        return entity.getShishoCode();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    @Override
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    @Override
    public ChikuCode get地区コード() {
        return entity.getChikuCode();
    }

    /**
     * みなし二号等対象フラグを返します。
     *
     * @return みなし二号等対象フラグ
     */
    @Override
    public boolean isみなし二号等対象フラグ() {
        return entity.getMinashiNigoEtcTaishoFlag();
    }

    /**
     * 広域内転居区分を返します。
     *
     * @return 広域内転居区分
     */
    @Override
    public Code get広域内転居区分() {
        return entity.getKoikinaiTenkyoKubun();
    }

    /**
     * 認定申請有効区分を返します。
     *
     * @return 認定申請有効区分
     */
    @Override
    public Code get認定申請有効区分() {
        return entity.getNinteiShinseiYukoKubunCode();
    }

    /**
     * 要介護申請_要支援申請の区分を返します。
     *
     * @return 要介護申請_要支援申請の区分
     */
    @Override
    public RString get要介護申請_要支援申請の区分() {
        return entity.getShienShinseiKubun();
    }

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由
     */
    @Override
    public RString get認定申請理由() {
        return entity.getNinteiShinseiRiyu();
    }

    /**
     * 申請サービス削除の理由を返します。
     *
     * @return 申請サービス削除の理由
     */
    @Override
    public RString get申請サービス削除の理由() {
        return entity.getShinseiServiceDeleteRiyu();
    }

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return 前回要介護状態区分コード
     */
    @Override
    public Code get前回要介護状態区分コード() {
        return entity.getZenYokaigoKubunCode();
    }

    /**
     * 前回認定年月日を返します。
     *
     * @return 前回認定年月日
     */
    @Override
    public FlexibleDate get前回認定年月日() {
        return entity.getZenkaiNinteiYMD();
    }

    /**
     * 前回認定有効期間_開始を返します。
     *
     * @return 前回認定有効期間_開始
     */
    @Override
    public FlexibleDate get前回認定有効期間_開始() {
        return entity.getZenkaiYukoKikanStart();
    }

    /**
     * 前回認定有効期間_終了を返します。
     *
     * @return 前回認定有効期間_終了
     */
    @Override
    public FlexibleDate get前回認定有効期間_終了() {
        return entity.getZenkaiYukoKikanEnd();
    }

    /**
     * 二号医療保険者名を返します。
     *
     * @return 二号医療保険者名
     */
    @Override
    public RString get二号医療保険者名() {
        return entity.getNigoIryoHokenshaName();
    }

    /**
     * 二号医療保険記号番号を返します。
     *
     * @return 二号医療保険記号番号
     */
    @Override
    public RString get二号医療保険記号番号() {
        return entity.getNigoIryoHokenKigoBango();
    }

    /**
     * 二号特定疾病コードを返します。
     *
     * @return 二号特定疾病コード
     */
    @Override
    public Code get二号特定疾病コード() {
        return entity.getNigoTokuteiShippeiCode();
    }

    /**
     * 自動割当除外者区分を返します。
     *
     * @return 自動割当除外者区分
     */
    @Override
    public RString get自動割当除外者区分() {
        return entity.getJidoWariateJogaishaKubun();
    }

    /**
     * 情報提供への同意有無を返します。
     *
     * @return 情報提供への同意有無
     */
    @Override
    public boolean is情報提供への同意有無() {
        return entity.getJohoteikyoDoiFlag();
    }

    /**
     * 情報提供資料出力年月日を返します。
     *
     * @return 情報提供資料出力年月日
     */
    @Override
    public FlexibleDate get情報提供資料出力年月日() {
        return entity.getJohoteikyoSiryoOutputYMD();
    }

    /**
     * 調査区分を返します。
     *
     * @return 調査区分
     */
    @Override
    public Code get調査区分() {
        return entity.getChosaKubun();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    @Override
    public ChosaItakusakiCode get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    @Override
    public ChosainCode get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 調査員への連絡事項を返します。
     *
     * @return 調査員への連絡事項
     */
    @Override
    public RString get調査員への連絡事項() {
        return entity.getRenrakuJikoToChosain();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    @Override
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode().value();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    @Override
    public RString get主治医コード() {
        return entity.getShujiiCode().value();
    }

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    @Override
    public boolean is指定医フラグ() {
        return entity.getShiteiiFlag();
    }

    /**
     * 意見書データ種別を返します。
     *
     * @return 意見書データ種別
     */
    @Override
    public Code get意見書データ種別() {
        return entity.getIkenshoDataShubetsu();
    }

    /**
     * 主治医への連絡事項を返します。
     *
     * @return 主治医への連絡事項
     */
    @Override
    public RString get主治医への連絡事項() {
        return entity.getRenrakuJikoToShujii();
    }

    /**
     * 認定延期通知発行しないことに対する同意有無を返します。
     *
     * @return 認定延期通知発行しないことに対する同意有無
     */
    @Override
    public boolean is認定延期通知発行しないことに対する同意有無() {
        return entity.getEnkitsuchiNashiDoiFlag();
    }

    /**
     * 施設入所の有無を返します。
     *
     * @return 施設入所の有無
     */
    @Override
    public boolean is施設入所の有無() {
        return entity.getShisetsuNyushoFlag();
    }

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    @Override
    public JigyoshaNo get入所施設コード() {
        return entity.getNyushoShisetsuCode();
    }

    /**
     * 家庭訪問の有無を返します。
     *
     * @return 家庭訪問の有無
     */
    @Override
    public boolean is家庭訪問の有無() {
        return entity.getKateiHomonFlag();
    }

    /**
     * 訪問調査先郵便番号を返します。
     *
     * @return 訪問調査先郵便番号
     */
    @Override
    public YubinNo get訪問調査先郵便番号() {
        return entity.getHomonChosasakiYubinNo();
    }

    /**
     * 訪問調査先住所を返します。
     *
     * @return 訪問調査先住所
     */
    @Override
    public AtenaJusho get訪問調査先住所() {
        return entity.getHomonChosasakiJusho();
    }

    /**
     * 訪問調査先名称を返します。
     *
     * @return 訪問調査先名称
     */
    @Override
    public AtenaMeisho get訪問調査先名称() {
        return entity.getHomonChosasakiName();
    }

    /**
     * 訪問調査先電話番号を返します。
     *
     * @return 訪問調査先電話番号
     */
    @Override
    public TelNo get訪問調査先電話番号() {
        return entity.getHomonChosasakiTelNo();
    }

    /**
     * 市町村連絡事項を返します。
     *
     * @return 市町村連絡事項
     */
    @Override
    public RString get市町村連絡事項() {
        return entity.getShichosonRenrakuJiko();
    }

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    @Override
    public Code get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 取下年月日を返します。
     *
     * @return 取下年月日
     */
    @Override
    public FlexibleDate get取下年月日() {
        return entity.getTorisageYMD();
    }

    /**
     * 取下理由を返します。
     *
     * @return 取下理由
     */
    @Override
    public RString get取下理由() {
        return entity.getTorisageRiyu();
    }

    /**
     * 却下年月日を返します。
     *
     * @return 却下年月日
     */
    @Override
    public FlexibleDate get却下年月日() {
        return entity.getKyakkaYMD();
    }

    /**
     * 却下理由を返します。
     *
     * @return 却下理由
     */
    @Override
    public RString get却下理由() {
        return entity.getKyakkaRiyu();
    }

    /**
     * 延期決定年月日を返します。
     *
     * @return 延期決定年月日
     */
    @Override
    public FlexibleDate get延期決定年月日() {
        return entity.getEnkiKetteiYMD();
    }

    /**
     * 延期理由を返します。
     *
     * @return 延期理由
     */
    @Override
    public RString get延期理由() {
        return entity.getEnkiRiyu();
    }

    /**
     * 延期通知発行年月日を返します。
     *
     * @return 延期通知発行年月日
     */
    @Override
    public FlexibleDate get延期通知発行年月日() {
        return entity.getEnkiTsuchiHakkoYMD();
    }

    /**
     * 延期通知発行回数を返します。
     *
     * @return 延期通知発行回数
     */
    @Override
    public int get延期通知発行回数() {
        return entity.getEnkiTsuchiHakkoKaisu();
    }

    /**
     * 延期見込期間開始年月日を返します。
     *
     * @return 延期見込期間開始年月日
     */
    @Override
    public FlexibleDate get延期見込期間開始年月日() {
        return entity.getEnkiMikomiKaishiYMD();
    }

    /**
     * 延期見込期間終了年月日を返します。
     *
     * @return 延期見込期間終了年月日
     */
    @Override
    public FlexibleDate get延期見込期間終了年月日() {
        return entity.getEnkiMikomiShuryoYMD();
    }

    /**
     * 審査継続区分を返します。
     *
     * @return 審査継続区分
     */
    @Override
    public boolean is審査継続区分() {
        return entity.getShinsaKeizokuFlag();
    }

    /**
     * 要介護認定審査会優先振分区分コードを返します。
     *
     * @return 要介護認定審査会優先振分区分コード
     */
    @Override
    public Code get要介護認定審査会優先振分区分コード() {
        return entity.getShinsakaiYusenWaritsukeKubunCode();
    }

    /**
     * 更新通知発行年月日を返します。
     *
     * @return 更新通知発行年月日
     */
    @Override
    public FlexibleDate get更新通知発行年月日() {
        return entity.getKoshinTsuchiHakkoYMD();
    }

    /**
     * 更新通知発行完了年月日を返します。
     *
     * @return 更新通知発行完了年月日
     */
    @Override
    public FlexibleDate get更新通知発行完了年月日() {
        return entity.getKoshinTsuchiHakkoKanryoYMD();
    }

    /**
     * 認定申請情報登録年月日を返します。
     *
     * @return 認定申請情報登録年月日
     */
    @Override
    public FlexibleDate get認定申請情報登録年月日() {
        return entity.getNinteiShinseiJohoTorokuYMD();
    }

    /**
     * 再調査依頼回数を返します。
     *
     * @return 再調査依頼回数
     */
    @Override
    public int get再調査依頼回数() {
        return entity.getSaiChosaIraiKaisu();
    }

    /**
     * 再作成依頼回数を返します。
     *
     * @return 再作成依頼回数
     */
    @Override
    public int get再作成依頼回数() {
        return entity.getSaiSakuseiIraiKaisu();
    }

    /**
     * ＩＦ送付年月日を返します。
     *
     * @return ＩＦ送付年月日
     */
    @Override
    public FlexibleDate getＩＦ送付年月日() {
        return entity.getIfSofuYMD();
    }

    /**
     * 論理削除区分を返します。
     *
     * @return ＩＦ送付年月日
     */
    @Override
    public boolean is論理削除区分() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    @Override
    public EntityDataState getState() {
        return entity.getState();
    }

    private ShinsakaiNinteiShinseiJoho(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    @Override
    public Builder createBuilderForEdit() {
        return new Builder(this);
    }

    /**
     * 新しい{@link ShinsakaiNinteiShinseiJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public INinteiShinseiJohoEntity getEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * {@link ShinsakaiNinteiShinseiJoho}を生成するためのビルダーです。
     */
    public static final class Builder extends INinteiShinseiJoho.Builder {

        private DbT5101NinteiShinseiJohoEntity entity;

        Builder() {
            this.entity = new DbT5101NinteiShinseiJohoEntity();
        }

        Builder(ShinsakaiNinteiShinseiJoho shinsakaiNinteiShinseiJoho) {
            this.entity = shinsakaiNinteiShinseiJoho.entity.clone();
        }

        /**
         * insertDantaiCdを設定します。
         *
         * @param insertDantaiCd 挿入市町村
         * @return builder
         */
        public Builder setInsertDantaiCd(RString insertDantaiCd) {
            Objects.requireNonNull(insertDantaiCd);
            this.entity.setInsertDantaiCd(insertDantaiCd);
            return this;
        }

        /**
         * isDeletedを設定します。
         *
         * @param isDeleted 論理削除フラグ
         * @return builder
         */
        public Builder setIsDeleted(boolean isDeleted) {
            this.entity.setIsDeleted(isDeleted);
            return this;
        }

        /**
         * lastUpdateReamsLoginIdを設定します。
         *
         * @param lastUpdateReamsLoginId 最終更新ユーザーId
         * @return builder
         */
        public Builder setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
            Objects.requireNonNull(lastUpdateReamsLoginId);
            this.entity.setLastUpdateReamsLoginId(lastUpdateReamsLoginId);
            return this;
        }

        /**
         * shinseishoKanriNoを設定します。
         *
         * @param shinseishoKanriNo 申請書管理番号
         * @return builder
         */
        @Override
        public Builder setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
            Objects.requireNonNull(shinseishoKanriNo);
            this.entity.setShinseishoKanriNo(shinseishoKanriNo);
            return this;
        }

        /**
         * koroshoIfShikibetsuCodeを設定します。
         *
         * @param koroshoIfShikibetsuCode 厚労省IF識別コード
         * @return builder
         */
        @Override
        public Builder setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
            Objects.requireNonNull(koroshoIfShikibetsuCode);
            this.entity.setKoroshoIfShikibetsuCode(koroshoIfShikibetsuCode);
            return this;
        }

        /**
         * shoKisaiHokenshaNoを設定します。
         *
         * @param shoKisaiHokenshaNo 証記載保険者番号
         * @return builder
         */
        @Override
        public Builder setShoKisaiHokenshaNo(RString shoKisaiHokenshaNo) {
            Objects.requireNonNull(shoKisaiHokenshaNo);
            this.entity.setShoKisaiHokenshaNo(shoKisaiHokenshaNo);
            return this;
        }

        /**
         * shinseiNendoを設定します。
         *
         * @param shinseiNendo 申請年度
         * @return builder
         */
        @Override
        public Builder setShinseiNendo(FlexibleYear shinseiNendo) {
            Objects.requireNonNull(shinseiNendo);
            this.entity.setShinseiNendo(shinseiNendo);
            return this;
        }

        /**
         * hihokenshaNoを設定します。
         *
         * @param hihokenshaNo 被保険者番号
         * @return builder
         */
        @Override
        public Builder setHihokenshaNo(RString hihokenshaNo) {
            Objects.requireNonNull(hihokenshaNo);
            this.entity.setHihokenshaNo(hihokenshaNo);
            return this;
        }

        /**
         * ninteiShinseiYMDを設定します。
         *
         * @param ninteiShinseiYMD 認定申請年月日
         * @return builder
         */
        @Override
        public Builder setNinteiShinseiYMD(FlexibleDate ninteiShinseiYMD) {
            Objects.requireNonNull(ninteiShinseiYMD);
            this.entity.setNinteiShinseiYMD(ninteiShinseiYMD);
            return this;
        }

        /**
         * ninteiShinseiEdabanCodeを設定します。
         *
         * @param ninteiShinseiEdabanCode 認定申請枝番コード
         * @return builder
         */
        @Override
        public Builder setNinteiShinseiEdabanCode(EdabanCode ninteiShinseiEdabanCode) {
            Objects.requireNonNull(ninteiShinseiEdabanCode);
            this.entity.setNinteiShinseiEdabanCode(ninteiShinseiEdabanCode);
            return this;
        }

        /**
         * ninteiShinseiHoreiKubunCodeを設定します。
         *
         * @param ninteiShinseiHoreiKubunCode 認定申請区分（法令）コード
         * @return builder
         */
        @Override
        public Builder setNinteiShinseiHoreiKubunCode(Code ninteiShinseiHoreiKubunCode) {
            Objects.requireNonNull(ninteiShinseiHoreiKubunCode);
            this.entity.setNinteiShinseiHoreiKubunCode(ninteiShinseiHoreiKubunCode);
            return this;
        }

        /**
         * ninteiShinseijiKubunCodeを設定します。
         *
         * @param ninteiShinseijiKubunCode 認定申請区分（申請時）コード
         * @return builder
         */
        @Override
        public Builder setNinteiShinseiShinseijiKubunCode(Code ninteiShinseijiKubunCode) {
            Objects.requireNonNull(ninteiShinseijiKubunCode);
            this.entity.setNinteiShinseiShinseijiKubunCode(ninteiShinseijiKubunCode);
            return this;
        }

        /**
         * torisageKubunCodeを設定します。
         *
         * @param torisageKubunCode 取下区分コード
         * @return builder
         */
        @Override
        public Builder setTorisageKubunCode(Code torisageKubunCode) {
            Objects.requireNonNull(torisageKubunCode);
            this.entity.setTorisageKubunCode(torisageKubunCode);
            return this;
        }

        /**
         * hihokenshaKubunCodeを設定します。
         *
         * @param hihokenshaKubunCode 被保険者区分コード
         * @return builder
         */
        @Override
        public Builder setHihokenshaKubunCode(RString hihokenshaKubunCode) {
            Objects.requireNonNull(hihokenshaKubunCode);
            this.entity.setHihokenshaKubunCode(hihokenshaKubunCode);
            return this;
        }

        /**
         * seinengappiYMDを設定します。
         *
         * @param seinengappiYMD 生年月日
         * @return builder
         */
        @Override
        public Builder setSeinengappiYMD(FlexibleDate seinengappiYMD) {
            Objects.requireNonNull(seinengappiYMD);
            this.entity.setSeinengappiYMD(seinengappiYMD);
            return this;
        }

        /**
         * ageを設定します。
         *
         * @param age 年齢
         * @return builder
         */
        @Override
        public Builder setAge(int age) {
            this.entity.setAge(age);
            return this;
        }

        /**
         * seibetsuを設定します。
         *
         * @param seibetsu 性別
         * @return builder
         */
        @Override
        public Builder setSeibetsu(Code seibetsu) {
            Objects.requireNonNull(seibetsu);
            this.entity.setSeibetsu(seibetsu);
            return this;
        }

        /**
         * hihokenshaKanaを設定します。
         *
         * @param hihokenshaKana 被保険者氏名カナ
         * @return builder
         */
        @Override
        public Builder setHihokenshaKana(AtenaKanaMeisho hihokenshaKana) {
            Objects.requireNonNull(hihokenshaKana);
            this.entity.setHihokenshaKana(hihokenshaKana);
            return this;
        }

        /**
         * hihokenshaNameを設定します。
         *
         * @param hihokenshaName 被保険者氏名
         * @return builder
         */
        @Override
        public Builder setHihokenshaName(AtenaMeisho hihokenshaName) {
            Objects.requireNonNull(hihokenshaName);
            this.entity.setHihokenshaName(hihokenshaName);
            return this;
        }

        /**
         * yubinNoを設定します。
         *
         * @param yubinNo 郵便番号
         * @return builder
         */
        @Override
        public Builder setYubinNo(YubinNo yubinNo) {
            Objects.requireNonNull(yubinNo);
            this.entity.setYubinNo(yubinNo);
            return this;
        }

        /**
         * jushoを設定します。
         *
         * @param jusho 住所
         * @return builder
         */
        @Override
        public Builder setJusho(AtenaJusho jusho) {
            Objects.requireNonNull(jusho);
            this.entity.setJusho(jusho);
            return this;
        }

        /**
         * telNoを設定します。
         *
         * @param telNo 電話番号
         * @return builder
         */
        @Override
        public Builder setTelNo(TelNo telNo) {
            Objects.requireNonNull(telNo);
            this.entity.setTelNo(telNo);
            return this;
        }

        /**
         * shishoCodeを設定します。
         *
         * @param shishoCode 支所コード
         * @return builder
         */
        @Override
        public Builder setShishoCode(RString shishoCode) {
            Objects.requireNonNull(shishoCode);
            this.entity.setShishoCode(shishoCode);
            return this;
        }

        /**
         * shikibetsuCodeを設定します。
         *
         * @param shikibetsuCode 識別コード
         * @return builder
         */
        @Override
        public Builder setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
            Objects.requireNonNull(shikibetsuCode);
            this.entity.setShikibetsuCode(shikibetsuCode);
            return this;
        }

        /**
         * chikuCodeを設定します。
         *
         * @param chikuCode 地区コード
         * @return builder
         */
        @Override
        public Builder setChikuCode(ChikuCode chikuCode) {
            Objects.requireNonNull(chikuCode);
            this.entity.setChikuCode(chikuCode);
            return this;
        }

        /**
         * minashiNigoEtcTaishoFlagを設定します。
         *
         * @param minashiNigoEtcTaishoFlag みなし２号等対象フラグ
         * @return builder
         */
        @Override
        public Builder setMinashiNigoEtcTaishoFlag(boolean minashiNigoEtcTaishoFlag) {
            this.entity.setMinashiNigoEtcTaishoFlag(minashiNigoEtcTaishoFlag);
            return this;
        }

        /**
         * koikinaiTenkyoKubunを設定します。
         *
         * @param koikinaiTenkyoKubun 広域内転居区分
         * @return builder
         */
        @Override
        public Builder setKoikinaiTenkyoKubun(Code koikinaiTenkyoKubun) {
            Objects.requireNonNull(koikinaiTenkyoKubun);
            this.entity.setKoikinaiTenkyoKubun(koikinaiTenkyoKubun);
            return this;
        }

        /**
         * ninteiShinseiYukoKubunCodeを設定します。
         *
         * @param ninteiShinseiYukoKubunCode 認定申請有効区分
         * @return builder
         */
        @Override
        public Builder setNinteiShinseiYukoKubunCode(Code ninteiShinseiYukoKubunCode) {
            Objects.requireNonNull(ninteiShinseiYukoKubunCode);
            this.entity.setNinteiShinseiYukoKubunCode(ninteiShinseiYukoKubunCode);
            return this;
        }

        /**
         * shienShinseiKubunを設定します。
         *
         * @param shienShinseiKubun 要介護申請・要支援申請の区分
         * @return builder
         */
        @Override
        public Builder setShienShinseiKubun(RString shienShinseiKubun) {
            Objects.requireNonNull(shienShinseiKubun);
            this.entity.setShienShinseiKubun(shienShinseiKubun);
            return this;
        }

        /**
         * ninteiShinseiRiyuを設定します。
         *
         * @param ninteiShinseiRiyu 認定申請理由
         * @return builder
         */
        @Override
        public Builder setNinteiShinseiRiyu(RString ninteiShinseiRiyu) {
            Objects.requireNonNull(ninteiShinseiRiyu);
            this.entity.setNinteiShinseiRiyu(ninteiShinseiRiyu);
            return this;
        }

        /**
         * shinseiServiceDeleteRiyuを設定します。
         *
         * @param shinseiServiceDeleteRiyu 申請サービス削除の理由
         * @return builder
         */
        @Override
        public Builder setShinseiServiceDeleteRiyu(RString shinseiServiceDeleteRiyu) {
            Objects.requireNonNull(shinseiServiceDeleteRiyu);
            this.entity.setShinseiServiceDeleteRiyu(shinseiServiceDeleteRiyu);
            return this;
        }

        /**
         * zenYokaigoKubunCodeを設定します。
         *
         * @param zenYokaigoKubunCode 前回要介護状態区分コード
         * @return builder
         */
        @Override
        public Builder setZenYokaigoKubunCode(Code zenYokaigoKubunCode) {
            Objects.requireNonNull(zenYokaigoKubunCode);
            this.entity.setZenYokaigoKubunCode(zenYokaigoKubunCode);
            return this;
        }

        /**
         * zenkaiNinteiYMDを設定します。
         *
         * @param zenkaiNinteiYMD 前回認定年月日
         * @return builder
         */
        @Override
        public Builder setZenkaiNinteiYMD(FlexibleDate zenkaiNinteiYMD) {
            Objects.requireNonNull(zenkaiNinteiYMD);
            this.entity.setZenkaiNinteiYMD(zenkaiNinteiYMD);
            return this;
        }

        /**
         * zenkaiYukoKikanStartを設定します。
         *
         * @param zenkaiYukoKikanStart 前回認定有効期間（開始）
         * @return builder
         */
        @Override
        public Builder setZenkaiYukoKikanStart(FlexibleDate zenkaiYukoKikanStart) {
            Objects.requireNonNull(zenkaiYukoKikanStart);
            this.entity.setZenkaiYukoKikanStart(zenkaiYukoKikanStart);
            return this;
        }

        /**
         * zenkaiYukoKikanEndを設定します。
         *
         * @param zenkaiYukoKikanEnd 前回認定有効期間（終了）
         * @return builder
         */
        @Override
        public Builder setZenkaiYukoKikanEnd(FlexibleDate zenkaiYukoKikanEnd) {
            Objects.requireNonNull(zenkaiYukoKikanEnd);
            this.entity.setZenkaiYukoKikanEnd(zenkaiYukoKikanEnd);
            return this;
        }

        /**
         * nigoIryoHokenshaNameを設定します。
         *
         * @param nigoIryoHokenshaName ２号医療保険者名
         * @return builder
         */
        @Override
        public Builder setNigoIryoHokenshaName(RString nigoIryoHokenshaName) {
            Objects.requireNonNull(nigoIryoHokenshaName);
            this.entity.setNigoIryoHokenshaName(nigoIryoHokenshaName);
            return this;
        }

        /**
         * nigoIryoHokenKigoBangoを設定します。
         *
         * @param nigoIryoHokenKigoBango ２号医療保険記号番号
         * @return builder
         */
        @Override
        public Builder setNigoIryoHokenKigoBango(RString nigoIryoHokenKigoBango) {
            Objects.requireNonNull(nigoIryoHokenKigoBango);
            this.entity.setNigoIryoHokenKigoBango(nigoIryoHokenKigoBango);
            return this;
        }

        /**
         * nigoTokuteiShippeiCodeを設定します。
         *
         * @param nigoTokuteiShippeiCode ２号特定疾病コード
         * @return builder
         */
        @Override
        public Builder setNigoTokuteiShippeiCode(Code nigoTokuteiShippeiCode) {
            Objects.requireNonNull(nigoTokuteiShippeiCode);
            this.entity.setNigoTokuteiShippeiCode(nigoTokuteiShippeiCode);
            return this;
        }

        /**
         * jidoWariateJogaishaKubunを設定します。
         *
         * @param jidoWariateJogaishaKubun 自動割当除外者区分
         * @return builder
         */
        @Override
        public Builder setJidoWariateJogaishaKubun(RString jidoWariateJogaishaKubun) {
            Objects.requireNonNull(jidoWariateJogaishaKubun);
            this.entity.setJidoWariateJogaishaKubun(jidoWariateJogaishaKubun);
            return this;
        }

        /**
         * johoteikyoDoiFlagを設定します。
         *
         * @param johoteikyoDoiFlag 情報提供への同意有無
         * @return builder
         */
        @Override
        public Builder setJohoteikyoDoiFlag(boolean johoteikyoDoiFlag) {
            this.entity.setJohoteikyoDoiFlag(johoteikyoDoiFlag);
            return this;
        }

        /**
         * johoteikyoSiryoOutputYMDを設定します。
         *
         * @param johoteikyoSiryoOutputYMD 情報提供資料出力年月日
         * @return builder
         */
        @Override
        public Builder setJohoteikyoSiryoOutputYMD(FlexibleDate johoteikyoSiryoOutputYMD) {
            Objects.requireNonNull(johoteikyoSiryoOutputYMD);
            this.entity.setJohoteikyoSiryoOutputYMD(johoteikyoSiryoOutputYMD);
            return this;
        }

        /**
         * chosaKubunを設定します。
         *
         * @param chosaKubun 調査区分
         * @return builder
         */
        @Override
        public Builder setChosaKubun(Code chosaKubun) {
            Objects.requireNonNull(chosaKubun);
            this.entity.setChosaKubun(chosaKubun);
            return this;
        }

        /**
         * ninteichosaItakusakiCodeを設定します。
         *
         * @param ninteichosaItakusakiCode 認定調査委託先コード
         * @return builder
         */
        @Override
        public Builder setNinteiChosaItakusakiCode(ChosaItakusakiCode ninteichosaItakusakiCode) {
            Objects.requireNonNull(ninteichosaItakusakiCode);
            this.entity.setNinteiChosaItakusakiCode(ninteichosaItakusakiCode);
            return this;
        }

        /**
         * ninteiChosainCodeを設定します。
         *
         * @param ninteiChosainCode 認定調査員コード
         * @return builder
         */
        @Override
        public Builder setNinteiChosainCode(ChosainCode ninteiChosainCode) {
            Objects.requireNonNull(ninteiChosainCode);
            this.entity.setNinteiChosainCode(ninteiChosainCode);
            return this;
        }

        /**
         * renrakuJikoToChosainを設定します。
         *
         * @param renrakuJikoToChosain 調査員への連絡事項
         * @return builder
         */
        @Override
        public Builder setRenrakuJikoToChosain(RString renrakuJikoToChosain) {
            Objects.requireNonNull(renrakuJikoToChosain);
            this.entity.setRenrakuJikoToChosain(renrakuJikoToChosain);
            return this;
        }

        /**
         * shujiiIryokikanCodeを設定します。
         *
         * @param shujiiIryokikanCode 主治医医療機関コード
         * @return builder
         */
        @Override
        public Builder setShujiiIryokikanCode(RString shujiiIryokikanCode) {
            Objects.requireNonNull(shujiiIryokikanCode);
            this.entity.setShujiiIryokikanCode(new ShujiiIryokikanCode(shujiiIryokikanCode));
            return this;
        }

        /**
         * shujiiCodeを設定します。
         *
         * @param shujiiCode 主治医コード
         * @return builder
         */
        @Override
        public Builder setShujiiCode(RString shujiiCode) {
            Objects.requireNonNull(shujiiCode);
            this.entity.setShujiiCode(new ShujiiCode(shujiiCode));
            return this;
        }

        /**
         * shiteiiFlagを設定します。
         *
         * @param shiteiiFlag 指定医フラグ
         * @return builder
         */
        @Override
        public Builder setShiteiiFlag(boolean shiteiiFlag) {
            this.entity.setShiteiiFlag(shiteiiFlag);
            return this;
        }

        /**
         * ikenshoDataShubetsuを設定します。
         *
         * @param ikenshoDataShubetsu 意見書データ種別
         * @return builder
         */
        @Override
        public Builder setIkenshoDataShubetsu(Code ikenshoDataShubetsu) {
            Objects.requireNonNull(ikenshoDataShubetsu);
            this.entity.setIkenshoDataShubetsu(ikenshoDataShubetsu);
            return this;
        }

        /**
         * renrakuJikoToShujiiを設定します。
         *
         * @param renrakuJikoToShujii 主治医への連絡事項
         * @return builder
         */
        @Override
        public Builder setRenrakuJikoToShujii(RString renrakuJikoToShujii) {
            Objects.requireNonNull(renrakuJikoToShujii);
            this.entity.setRenrakuJikoToShujii(renrakuJikoToShujii);
            return this;
        }

        /**
         * enkitsuchiNashiDoiFlagを設定します。
         *
         * @param enkitsuchiNashiDoiFlag 認定延期通知発行しないことに対する同意有無
         * @return builder
         */
        @Override
        public Builder setEnkitsuchiNashiDoiFlag(boolean enkitsuchiNashiDoiFlag) {
            this.entity.setEnkitsuchiNashiDoiFlag(enkitsuchiNashiDoiFlag);
            return this;
        }

        /**
         * shisetsuNyushoFlagを設定します。
         *
         * @param shisetsuNyushoFlag 施設入所の有無
         * @return builder
         */
        @Override
        public Builder setShisetsuNyushoFlag(boolean shisetsuNyushoFlag) {
            this.entity.setShisetsuNyushoFlag(shisetsuNyushoFlag);
            return this;
        }

        /**
         * nyushoShisetsuCodeを設定します。
         *
         * @param nyushoShisetsuCode 入所施設コード
         * @return builder
         */
        @Override
        public Builder setNyushoShisetsuCode(JigyoshaNo nyushoShisetsuCode) {
            Objects.requireNonNull(nyushoShisetsuCode);
            this.entity.setNyushoShisetsuCode(nyushoShisetsuCode);
            return this;
        }

        /**
         * kateiHomonFlagを設定します。
         *
         * @param kateiHomonFlag 家庭訪問の有無
         * @return builder
         */
        @Override
        public Builder setKateiHomonFlag(boolean kateiHomonFlag) {
            this.entity.setKateiHomonFlag(kateiHomonFlag);
            return this;
        }

        /**
         * homonChosasakiYubinNoを設定します。
         *
         * @param homonChosasakiYubinNo 訪問調査先郵便番号
         * @return builder
         */
        @Override
        public Builder setHomonChosasakiYubinNo(YubinNo homonChosasakiYubinNo) {
            Objects.requireNonNull(homonChosasakiYubinNo);
            this.entity.setHomonChosasakiYubinNo(homonChosasakiYubinNo);
            return this;
        }

        /**
         * homonChosasakiJushoを設定します。
         *
         * @param homonChosasakiJusho 訪問調査先住所
         * @return builder
         */
        @Override
        public Builder setHomonChosasakiJusho(AtenaJusho homonChosasakiJusho) {
            Objects.requireNonNull(homonChosasakiJusho);
            this.entity.setHomonChosasakiJusho(homonChosasakiJusho);
            return this;
        }

        /**
         * homonChosasakiNameを設定します。
         *
         * @param homonChosasakiName 訪問調査先名称
         * @return builder
         */
        @Override
        public Builder setHomonChosasakiName(AtenaMeisho homonChosasakiName) {
            Objects.requireNonNull(homonChosasakiName);
            this.entity.setHomonChosasakiName(homonChosasakiName);
            return this;
        }

        /**
         * homonChosasakiTelNoを設定します。
         *
         * @param homonChosasakiTelNo 訪問調査先電話番号
         * @return builder
         */
        @Override
        public Builder setHomonChosasakiTelNo(TelNo homonChosasakiTelNo) {
            Objects.requireNonNull(homonChosasakiTelNo);
            this.entity.setHomonChosasakiTelNo(homonChosasakiTelNo);
            return this;
        }

        /**
         * sichosonRenrakuJikoを設定します。
         *
         * @param sichosonRenrakuJiko 市町村連絡事項
         * @return builder
         */
        @Override
        public Builder setSichosonRenrakuJiko(RString sichosonRenrakuJiko) {
            Objects.requireNonNull(sichosonRenrakuJiko);
            this.entity.setShichosonRenrakuJiko(sichosonRenrakuJiko);
            return this;
        }

        /**
         * shoriJotaiKubunを設定します。
         *
         * @param shoriJotaiKubun 処理状態区分
         * @return builder
         */
        @Override
        public Builder setShoriJotaiKubun(Code shoriJotaiKubun) {
            Objects.requireNonNull(shoriJotaiKubun);
            this.entity.setShoriJotaiKubun(shoriJotaiKubun);
            return this;
        }

        /**
         * torisageYMDを設定します。
         *
         * @param torisageYMD 取下年月日
         * @return builder
         */
        @Override
        public Builder setTorisageYMD(FlexibleDate torisageYMD) {
            Objects.requireNonNull(torisageYMD);
            this.entity.setTorisageYMD(torisageYMD);
            return this;
        }

        /**
         * torisageRiyuを設定します。
         *
         * @param torisageRiyu 取下理由
         * @return builder
         */
        @Override
        public Builder setTorisageRiyu(RString torisageRiyu) {
            Objects.requireNonNull(torisageRiyu);
            this.entity.setTorisageRiyu(torisageRiyu);
            return this;
        }

        /**
         * kyakkaYMDを設定します。
         *
         * @param kyakkaYMD 却下年月日
         * @return builder
         */
        @Override
        public Builder setKyakkaYMD(FlexibleDate kyakkaYMD) {
            Objects.requireNonNull(kyakkaYMD);
            this.entity.setKyakkaYMD(kyakkaYMD);
            return this;
        }

        /**
         * kyakkaRiyuを設定します。
         *
         * @param kyakkaRiyu 却下理由
         * @return builder
         */
        @Override
        public Builder setKyakkaRiyu(RString kyakkaRiyu) {
            Objects.requireNonNull(kyakkaRiyu);
            this.entity.setKyakkaRiyu(kyakkaRiyu);
            return this;
        }

        /**
         * enkiKetteiYMDを設定します。
         *
         * @param enkiKetteiYMD 延期決定年月日
         * @return builder
         */
        @Override
        public Builder setEnkiKetteiYMD(FlexibleDate enkiKetteiYMD) {
            Objects.requireNonNull(enkiKetteiYMD);
            this.entity.setEnkiKetteiYMD(enkiKetteiYMD);
            return this;
        }

        /**
         * enkiRiyuを設定します。
         *
         * @param enkiRiyu 延期理由
         * @return builder
         */
        @Override
        public Builder setEnkiRiyu(RString enkiRiyu) {
            Objects.requireNonNull(enkiRiyu);
            this.entity.setEnkiRiyu(enkiRiyu);
            return this;
        }

        /**
         * enkitsuchiHakkoYMDを設定します。
         *
         * @param enkitsuchiHakkoYMD 延期通知発行年月日
         * @return builder
         */
        @Override
        public Builder setEnkiTsuchiHakkoYMD(FlexibleDate enkitsuchiHakkoYMD) {
            Objects.requireNonNull(enkitsuchiHakkoYMD);
            this.entity.setEnkiTsuchiHakkoYMD(enkitsuchiHakkoYMD);
            return this;
        }

        /**
         * enkitsuchiHakkoKaisuを設定します。
         *
         * @param enkitsuchiHakkoKaisu 延期通知発行回数
         * @return builder
         */
        @Override
        public Builder setEnkiTsuchiHakkoKaisu(int enkitsuchiHakkoKaisu) {
            this.entity.setEnkiTsuchiHakkoKaisu(enkitsuchiHakkoKaisu);
            return this;
        }

        /**
         * enkiMikomiKaishiYMDを設定します。
         *
         * @param enkiMikomiKaishiYMD 延期見込期間開始年月日
         * @return builder
         */
        @Override
        public Builder setEnkiMikomiKaishiYMD(FlexibleDate enkiMikomiKaishiYMD) {
            Objects.requireNonNull(enkiMikomiKaishiYMD);
            this.entity.setEnkiMikomiKaishiYMD(enkiMikomiKaishiYMD);
            return this;
        }

        /**
         * enkiMikomiShuryoYMDを設定します。
         *
         * @param enkiMikomiShuryoYMD 延期見込期間終了年月日
         * @return builder
         */
        @Override
        public Builder setEnkiMikomiShuryoYMD(FlexibleDate enkiMikomiShuryoYMD) {
            Objects.requireNonNull(enkiMikomiShuryoYMD);
            this.entity.setEnkiMikomiShuryoYMD(enkiMikomiShuryoYMD);
            return this;
        }

        /**
         * shinsaKeizokuFlagを設定します。
         *
         * @param shinsaKeizokuFlag 審査継続区分
         * @return builder
         */
        @Override
        public Builder setShinsaKeizokuFlag(boolean shinsaKeizokuFlag) {
            this.entity.setShinsaKeizokuFlag(shinsaKeizokuFlag);
            return this;
        }

        /**
         * shinsakaiYusenWaritsukeKubunCodeを設定します。
         *
         * @param shinsakaiYusenWaritsukeCode 要介護認定審査会優先振分区分コード
         * @return builder
         */
        @Override
        public Builder setShinsakaiYusenWaritsukeKubunCode(Code shinsakaiYusenWaritsukeCode) {
            Objects.requireNonNull(shinsakaiYusenWaritsukeCode);
            this.entity.setShinsakaiYusenWaritsukeKubunCode(shinsakaiYusenWaritsukeCode);
            return this;
        }

        /**
         * kosinTsuchiHakkoYMDを設定します。
         *
         * @param kosinTsuchiHakkoYMD 更新通知発行年月日
         * @return builder
         */
        @Override
        public Builder setKosinTsuchiHakkoYMD(FlexibleDate kosinTsuchiHakkoYMD) {
            Objects.requireNonNull(kosinTsuchiHakkoYMD);
            this.entity.setKoshinTsuchiHakkoYMD(kosinTsuchiHakkoYMD);
            return this;
        }

        /**
         * kosinTsuchiHakkoKanryoYMDを設定します。
         *
         * @param kosinTsuchiHakkoKanryoYMD 更新通知発行完了年月日
         * @return builder
         */
        @Override
        public Builder setKosinTsuchiHakkoKanryoYMD(FlexibleDate kosinTsuchiHakkoKanryoYMD) {
            Objects.requireNonNull(kosinTsuchiHakkoKanryoYMD);
            this.entity.setKoshinTsuchiHakkoKanryoYMD(kosinTsuchiHakkoKanryoYMD);
            return this;
        }

        /**
         * ninteiShinseiJohoTorokuYMDを設定します。
         *
         * @param ninteiShinseiJohoTorokuYMD 認定申請情報登録年月日
         * @return builder
         */
        @Override
        public Builder setNinteiShinseiJohoTorokuYMD(FlexibleDate ninteiShinseiJohoTorokuYMD) {
            Objects.requireNonNull(ninteiShinseiJohoTorokuYMD);
            this.entity.setNinteiShinseiJohoTorokuYMD(ninteiShinseiJohoTorokuYMD);
            return this;
        }

        /**
         * saiChosaIraiKaisuを設定します。
         *
         * @param saiChosaIraiKaisu 再調査依頼回数
         * @return builder
         */
        @Override
        public Builder setSaiChosaIraiKaisu(int saiChosaIraiKaisu) {
            this.entity.setSaiChosaIraiKaisu(saiChosaIraiKaisu);
            return this;
        }

        /**
         * saiSakuseiIraiKaisuを設定します。
         *
         * @param saiSakuseiIraiKaisu 再作成依頼回数
         * @return builder
         */
        @Override
        public Builder setSaiSakuseiIraiKaisu(int saiSakuseiIraiKaisu) {
            this.entity.setSaiSakuseiIraiKaisu(saiSakuseiIraiKaisu);
            return this;
        }

        /**
         * ifSofuYMDを設定します。
         *
         * @param ifSofuYMD ＩＦ送付年月日
         * @return builder
         */
        @Override
        public Builder setIfSofuYMD(FlexibleDate ifSofuYMD) {
            Objects.requireNonNull(ifSofuYMD);
            this.entity.setIfSofuYMD(ifSofuYMD);
            return this;
        }

        /**
         * logicalDeletedFlagを設定します。
         *
         * @param logicalDeletedFlag 論理削除フラグ
         * @return builder
         */
        @Override
        public Builder setLogicalDeletedFlag(boolean logicalDeletedFlag) {
            this.entity.setLogicalDeletedFlag(logicalDeletedFlag);
            return this;
        }

        /**
         * {@link ShinsakaiNinteiShinseiJoho}を生成します。
         *
         * @return {@link ShinsakaiNinteiShinseiJoho}
         */
        @Override
        public ShinsakaiNinteiShinseiJoho build() {
            return new ShinsakaiNinteiShinseiJoho(this);
        }
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -3930132174466763042L;

        private final DbT5101NinteiShinseiJohoEntity entity;

        private _SerializationProxy(ShinsakaiNinteiShinseiJoho shinsakaiNinteiShinseiJoho) {
            this.entity = shinsakaiNinteiShinseiJoho.entity;
        }

        private Object readResolve() {
            return new ShinsakaiNinteiShinseiJoho(entity);
        }
    }
}
