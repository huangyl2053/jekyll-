/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績該当者のbusinessです。
 *
 * @reamsid_L DBC-2230-030 chenxiangyu
 */
public class KyufuJissekiGaitoshaBusiness implements Serializable {

    private final SaishinsaMoshitateTourokuRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 護給付費再審査申立書作成のRelateEntity
     */
    public KyufuJissekiGaitoshaBusiness(SaishinsaMoshitateTourokuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return entity.get氏名();
    }

    /**
     * 証記載保険者名を取得します。
     *
     * @return 証記載保険者名
     */
    public RString get証記載保険者名() {
        return entity.get証記載保険者名();
    }

    /**
     * 事業者名を取得します。
     *
     * @return 事業者名
     */
    public RString get事業者名() {
        return entity.get事業者名();
    }

    /**
     * 行番号を取得します。
     *
     * @return 行番号
     */
    public RString get行番号() {
        return entity.get行番号();
    }

    /**
     * insertDantaiCdを取得します。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return entity.getInsertDantaiCd();
    }

    /**
     * insertTimestampを取得します。
     *
     * @return insertTimestamp
     */
    public RString getInsertTimestamp() {
        return entity.getInsertTimestamp();
    }

    /**
     * insertReamsLoginIdを取得します。
     *
     * @return insertReamsLoginId
     */
    public RString getInsertReamsLoginId() {
        return entity.getInsertReamsLoginId();
    }

    /**
     * insertContextIdを取得します。
     *
     * @return insertContextId
     */
    public RString getInsertContextId() {
        return entity.getInsertContextId();
    }

    /**
     * isDeletedを取得します。
     *
     * @return isDeleted
     */
    public RString getIsDeleted() {
        return entity.getIsDeleted();
    }

    /**
     * updateCountを取得します。
     *
     * @return updateCount
     */
    public RString getUpdateCount() {
        return entity.getUpdateCount();
    }

    /**
     * lastUpdateTimestampを取得します。
     *
     * @return lastUpdateTimestamp
     */
    public RString getLastUpdateTimestamp() {
        return entity.getLastUpdateTimestamp();
    }

    /**
     * lastUpdateReamsLoginIdを取得します。
     *
     * @return lastUpdateReamsLoginId
     */
    public RString getLastUpdateReamsLoginId() {
        return entity.getLastUpdateReamsLoginId();
    }

    /**
     * 交換情報識別番号を取得します。
     *
     * @return 交換情報識別番号
     */
    public RString get交換情報識別番号() {
        return entity.get交換情報識別番号();
    }

    /**
     * 入力識別番号を取得します。
     *
     * @return 入力識別番号
     */
    public RString get入力識別番号() {
        return entity.get入力識別番号();
    }

    /**
     * レコード種別コードを取得します。
     *
     * @return レコード種別コード
     */
    public RString getレコード種別コード() {
        return entity.getレコード種別コード();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public RString getサービス提供年月() {
        return entity.getサービス提供年月();
    }

    /**
     * 事業所番号を取得します。
     *
     * @return 事業所番号
     */
    public RString get事業所番号() {
        return entity.get事業所番号();
    }

    /**
     * 給付実績情報作成区分コードを取得します。
     *
     * @return 給付実績情報作成区分コード
     */
    public RString get給付実績情報作成区分コード() {
        return entity.get給付実績情報作成区分コード();
    }

    /**
     * 給付実績区分コードを取得します。
     *
     * @return 給付実績区分コード
     */
    public RString get給付実績区分コード() {
        return entity.get給付実績区分コード();
    }

    /**
     * 通し番号を取得します。
     *
     * @return 通し番号
     */
    public RString get通し番号() {
        return entity.get通し番号();
    }

    /**
     * 公費1_負担者番号を取得します。
     *
     * @return 公費1_負担者番号
     */
    public RString get公費1_負担者番号() {
        return entity.get公費1_負担者番号();
    }

    /**
     * 公費1_受給者番号を取得します。
     *
     * @return 公費1_受給者番号
     */
    public RString get公費1_受給者番号() {
        return entity.get公費1_受給者番号();
    }

    /**
     * 公費2_負担者番号を取得します。
     *
     * @return 公費2_負担者番号
     */
    public RString get公費2_負担者番号() {
        return entity.get公費2_負担者番号();
    }

    /**
     * 公費2_受給者番号を取得します。
     *
     * @return 公費2_受給者番号
     */
    public RString get公費2_受給者番号() {
        return entity.get公費2_受給者番号();
    }

    /**
     * 公費3_負担者番号を取得します。
     *
     * @return 公費3_負担者番号
     */
    public RString get公費3_負担者番号() {
        return entity.get公費3_負担者番号();
    }

    /**
     * 公費3_受給者番号を取得します。
     *
     * @return 公費3_受給者番号
     */
    public RString get公費3_受給者番号() {
        return entity.get公費3_受給者番号();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 性別コードを取得します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return entity.get性別コード();
    }

    /**
     * 要介護状態区分コードを取得します。
     *
     * @return 要介護状態区分コード
     */
    public RString get要介護状態区分コード() {
        return entity.get要介護状態区分コード();
    }

    /**
     * 旧措置入所者特例コードを取得します。
     *
     * @return 旧措置入所者特例コード
     */
    public RString get旧措置入所者特例コード() {
        return entity.get旧措置入所者特例コード();
    }

    /**
     * 認定有効期間_開始年月日を取得します。
     *
     * @return 認定有効期間_開始年月日
     */
    public RString get認定有効期間_開始年月日() {
        return entity.get認定有効期間_開始年月日();
    }

    /**
     * 認定有功期間_終了年月日を取得します。
     *
     * @return 認定有功期間_終了年月日
     */
    public RString get認定有功期間_終了年月日() {
        return entity.get認定有功期間_終了年月日();
    }

    /**
     * 老人保健市町村番号を取得します。
     *
     * @return 老人保健市町村番号
     */
    public RString get老人保健市町村番号() {
        return entity.get老人保健市町村番号();
    }

    /**
     * 老人保健受給者番号を取得します。
     *
     * @return 老人保健受給者番号
     */
    public RString get老人保健受給者番号() {
        return entity.get老人保健受給者番号();
    }

    /**
     * 保険者番号_後期を取得します。
     *
     * @return 保険者番号_後期
     */
    public RString get保険者番号_後期() {
        return entity.get保険者番号_後期();
    }

    /**
     * 被保険者番号_後期を取得します。
     *
     * @return 被保険者番号_後期
     */
    public RString get被保険者番号_後期() {
        return entity.get被保険者番号_後期();
    }

    /**
     * 保険者番号_国保を取得します。
     *
     * @return 保険者番号_国保
     */
    public RString get保険者番号_国保() {
        return entity.get保険者番号_国保();
    }

    /**
     * 被保険者証番号_国保を取得します。
     *
     * @return 被保険者証番号_国保
     */
    public RString get被保険者証番号_国保() {
        return entity.get被保険者証番号_国保();
    }

    /**
     * 個人番号_国保を取得します。
     *
     * @return 個人番号_国保
     */
    public RString get個人番号_国保() {
        return entity.get個人番号_国保();
    }

    /**
     * 居宅サービス計画作成区分コードを取得します。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString get居宅サービス計画作成区分コード() {
        return entity.get居宅サービス計画作成区分コード();
    }

    /**
     * 事業所番号_居宅介護支援事業所等を取得します。
     *
     * @return 事業所番号_居宅介護支援事業所等
     */
    public RString get事業所番号_居宅介護支援事業所等() {
        return entity.get事業所番号_居宅介護支援事業所等();
    }

    /**
     * 開始年月日を取得します。
     *
     * @return 開始年月日
     */
    public RString get開始年月日() {
        return entity.get開始年月日();
    }

    /**
     * 中止年月日を取得します。
     *
     * @return 中止年月日
     */
    public RString get中止年月日() {
        return entity.get中止年月日();
    }

    /**
     * 中止理由_入所前の状況コードを取得します。
     *
     * @return 中止理由_入所前の状況コード
     */
    public RString get中止理由_入所前の状況コード() {
        return entity.get中止理由_入所前の状況コード();
    }

    /**
     * 入所年月日を取得します。
     *
     * @return 入所年月日
     */
    public RString get入所年月日() {
        return entity.get入所年月日();
    }

    /**
     * 退所年月日を取得します。
     *
     * @return 退所年月日
     */
    public RString get退所年月日() {
        return entity.get退所年月日();
    }

    /**
     * 入所実日数を取得します。
     *
     * @return 入所実日数
     */
    public RString get入所実日数() {
        return entity.get入所実日数();
    }

    /**
     * 外泊日数を取得します。
     *
     * @return 外泊日数
     */
    public RString get外泊日数() {
        return entity.get外泊日数();
    }

    /**
     * 退所後の状態コードを取得します。
     *
     * @return 退所後の状態コード
     */
    public RString get退所後の状態コード() {
        return entity.get退所後の状態コード();
    }

    /**
     * 保険給付率を取得します。
     *
     * @return 保険給付率
     */
    public RString get保険給付率() {
        return entity.get保険給付率();
    }

    /**
     * 公費1給付率を取得します。
     *
     * @return 公費1給付率
     */
    public RString get公費1給付率() {
        return entity.get公費1給付率();
    }

    /**
     * 公費2給付率を取得します。
     *
     * @return 公費2給付率
     */
    public RString get公費2給付率() {
        return entity.get公費2給付率();
    }

    /**
     * 公費3給付率を取得します。
     *
     * @return 公費3給付率
     */
    public RString get公費3給付率() {
        return entity.get公費3給付率();
    }

    /**
     * 前_保険_サービス単位数を取得します。
     *
     * @return 前_保険_サービス単位数
     */
    public RString get前_保険_サービス単位数() {
        return entity.get前_保険_サービス単位数();
    }

    /**
     * 前_保険_請求額を取得します。
     *
     * @return 前_保険_請求額
     */
    public RString get前_保険_請求額() {
        return entity.get前_保険_請求額();
    }

    /**
     * 前_保険_利用者負担額を取得します。
     *
     * @return 前_保険_利用者負担額
     */
    public RString get前_保険_利用者負担額() {
        return entity.get前_保険_利用者負担額();
    }

    /**
     * 前_保険_緊急時施設療養費請求額を取得します。
     *
     * @return 前_保険_緊急時施設療養費請求額
     */
    public RString get前_保険_緊急時施設療養費請求額() {
        return entity.get前_保険_緊急時施設療養費請求額();
    }

    /**
     * 前_保険_特定診療費請求額を取得します。
     *
     * @return 前_保険_特定診療費請求額
     */
    public RString get前_保険_特定診療費請求額() {
        return entity.get前_保険_特定診療費請求額();
    }

    /**
     * 前_保険_特定入所者介護サービス費等請求額を取得します。
     *
     * @return 前_保険_特定入所者介護サービス費等請求額
     */
    public RString get前_保険_特定入所者介護サービス費等請求額() {
        return entity.get前_保険_特定入所者介護サービス費等請求額();
    }

    /**
     * 前_公費1_サービス単位数を取得します。
     *
     * @return 前_公費1_サービス単位数
     */
    public RString get前_公費1_サービス単位数() {
        return entity.get前_公費1_サービス単位数();
    }

    /**
     * 前_公費1_請求額を取得します。
     *
     * @return 前_公費1_請求額
     */
    public RString get前_公費1_請求額() {
        return entity.get前_公費1_請求額();
    }

    /**
     * 前_公費1_本人負担額を取得します。
     *
     * @return 前_公費1_本人負担額
     */
    public RString get前_公費1_本人負担額() {
        return entity.get前_公費1_本人負担額();
    }

    /**
     * 前_公費1_緊急時施設療養費請求額を取得します。
     *
     * @return 前_公費1_緊急時施設療養費請求額
     */
    public RString get前_公費1_緊急時施設療養費請求額() {
        return entity.get前_公費1_緊急時施設療養費請求額();
    }

    /**
     * 前_公費1_特定診療費請求額を取得します。
     *
     * @return 前_公費1_特定診療費請求額
     */
    public RString get前_公費1_特定診療費請求額() {
        return entity.get前_公費1_特定診療費請求額();
    }

    /**
     * 前_公費1_特定入所者介護サービス費等請求額を取得します。
     *
     * @return 前_公費1_特定入所者介護サービス費等請求額
     */
    public RString get前_公費1_特定入所者介護サービス費等請求額() {
        return entity.get前_公費1_特定入所者介護サービス費等請求額();
    }

    /**
     * 前_公費2_サービス単位数を取得します。
     *
     * @return 前_公費2_サービス単位数
     */
    public RString get前_公費2_サービス単位数() {
        return entity.get前_公費2_サービス単位数();
    }

    /**
     * 前_公費2_請求額を取得します。
     *
     * @return 前_公費2_請求額
     */
    public RString get前_公費2_請求額() {
        return entity.get前_公費2_請求額();
    }

    /**
     * 前_公費2_本人負担額を取得します。
     *
     * @return 前_公費2_本人負担額
     */
    public RString get前_公費2_本人負担額() {
        return entity.get前_公費2_本人負担額();
    }

    /**
     * 前_公費2_緊急時施設療養費請求額を取得します。
     *
     * @return 前_公費2_緊急時施設療養費請求額
     */
    public RString get前_公費2_緊急時施設療養費請求額() {
        return entity.get前_公費2_緊急時施設療養費請求額();
    }

    /**
     * 前_公費2_特定診療費請求額を取得します。
     *
     * @return 前_公費2_特定診療費請求額
     */
    public RString get前_公費2_特定診療費請求額() {
        return entity.get前_公費2_特定診療費請求額();
    }

    /**
     * 前_公費2_特定入所者介護サービス費等請求額を取得します。
     *
     * @return 前_公費2_特定入所者介護サービス費等請求額
     */
    public RString get前_公費2_特定入所者介護サービス費等請求額() {
        return entity.get前_公費2_特定入所者介護サービス費等請求額();
    }

    /**
     * 前_公費3_サービス単位数を取得します。
     *
     * @return 前_公費3_サービス単位数
     */
    public RString get前_公費3_サービス単位数() {
        return entity.get前_公費3_サービス単位数();
    }

    /**
     * 前_公費3_請求額を取得します。
     *
     * @return 前_公費3_請求額
     */
    public RString get前_公費3_請求額() {
        return entity.get前_公費3_請求額();
    }

    /**
     * 前_公費3_本人負担額を取得します。
     *
     * @return 前_公費3_本人負担額
     */
    public RString get前_公費3_本人負担額() {
        return entity.get前_公費3_本人負担額();
    }

    /**
     * 前_公費3_緊急時施設療養費請求額を取得します。
     *
     * @return 前_公費3_緊急時施設療養費請求額
     */
    public RString get前_公費3_緊急時施設療養費請求額() {
        return entity.get前_公費3_緊急時施設療養費請求額();
    }

    /**
     * 前_公費3_特定診療費請求額を取得します。
     *
     * @return 前_公費3_特定診療費請求額
     */
    public RString get前_公費3_特定診療費請求額() {
        return entity.get前_公費3_特定診療費請求額();
    }

    /**
     * 前_公費3_特定入所者介護サービス費等請求額を取得します。
     *
     * @return 前_公費3_特定入所者介護サービス費等請求額
     */
    public RString get前_公費3_特定入所者介護サービス費等請求額() {
        return entity.get前_公費3_特定入所者介護サービス費等請求額();
    }

    /**
     * 後_保険_サービス単位数を取得します。
     *
     * @return 後_保険_サービス単位数
     */
    public RString get後_保険_サービス単位数() {
        return entity.get後_保険_サービス単位数();
    }

    /**
     * 後_保険_請求額を取得します。
     *
     * @return 後_保険_請求額
     */
    public RString get後_保険_請求額() {
        return entity.get後_保険_請求額();
    }

    /**
     * 後_保険_利用者負担額を取得します。
     *
     * @return 後_保険_利用者負担額
     */
    public RString get後_保険_利用者負担額() {
        return entity.get後_保険_利用者負担額();
    }

    /**
     * 後_緊急時施設療養費請求額を取得します。
     *
     * @return 後_緊急時施設療養費請求額
     */
    public RString get後_緊急時施設療養費請求額() {
        return entity.get後_緊急時施設療養費請求額();
    }

    /**
     * 後_保険_特定診療費請求額を取得します。
     *
     * @return 後_保険_特定診療費請求額
     */
    public RString get後_保険_特定診療費請求額() {
        return entity.get後_保険_特定診療費請求額();
    }

    /**
     * 後_保険_特定入所者介護サービス費等請求額を取得します。
     *
     * @return 後_保険_特定入所者介護サービス費等請求額
     */
    public RString get後_保険_特定入所者介護サービス費等請求額() {
        return entity.get後_保険_特定入所者介護サービス費等請求額();
    }

    /**
     * 後_公費1_サービス単位数を取得します。
     *
     * @return 後_公費1_サービス単位数
     */
    public RString get後_公費1_サービス単位数() {
        return entity.get後_公費1_サービス単位数();
    }

    /**
     * 後_公費1_請求額を取得します。
     *
     * @return 後_公費1_請求額
     */
    public RString get後_公費1_請求額() {
        return entity.get後_公費1_請求額();
    }

    /**
     * 後_公費1_本人負担額を取得します。
     *
     * @return 後_公費1_本人負担額
     */
    public RString get後_公費1_本人負担額() {
        return entity.get後_公費1_本人負担額();
    }

    /**
     * 後_公費1_緊急時施設療養費請求額を取得します。
     *
     * @return 後_公費1_緊急時施設療養費請求額
     */
    public RString get後_公費1_緊急時施設療養費請求額() {
        return entity.get後_公費1_緊急時施設療養費請求額();
    }

    /**
     * 後_公費1_特定診療費請求額を取得します。
     *
     * @return 後_公費1_特定診療費請求額
     */
    public RString get後_公費1_特定診療費請求額() {
        return entity.get後_公費1_特定診療費請求額();
    }

    /**
     * 後_公費1_特定入所者介護サービス費等請求額を取得します。
     *
     * @return 後_公費1_特定入所者介護サービス費等請求額
     */
    public RString get後_公費1_特定入所者介護サービス費等請求額() {
        return entity.get後_公費1_特定入所者介護サービス費等請求額();
    }

    /**
     * 後_公費2_サービス単位数を取得します。
     *
     * @return 後_公費2_サービス単位数
     */
    public RString get後_公費2_サービス単位数() {
        return entity.get後_公費2_サービス単位数();
    }

    /**
     * 後_公費2_請求額を取得します。
     *
     * @return 後_公費2_請求額
     */
    public RString get後_公費2_請求額() {
        return entity.get後_公費2_請求額();
    }

    /**
     * 後_公費2_利用者負担額を取得します。
     *
     * @return 後_公費2_利用者負担額
     */
    public RString get後_公費2_利用者負担額() {
        return entity.get後_公費2_利用者負担額();
    }

    /**
     * 後_公費2_緊急時施設療養費請求額を取得します。
     *
     * @return 後_公費2_緊急時施設療養費請求額
     */
    public RString get後_公費2_緊急時施設療養費請求額() {
        return entity.get後_公費2_緊急時施設療養費請求額();
    }

    /**
     * 後_公費2_特定診療費請求額を取得します。
     *
     * @return 後_公費2_特定診療費請求額
     */
    public RString get後_公費2_特定診療費請求額() {
        return entity.get後_公費2_特定診療費請求額();
    }

    /**
     * 後_公費2_特定入所者介護サービス費等請求額を取得します。
     *
     * @return 後_公費2_特定入所者介護サービス費等請求額
     */
    public RString get後_公費2_特定入所者介護サービス費等請求額() {
        return entity.get後_公費2_特定入所者介護サービス費等請求額();
    }

    /**
     * 後_公費3_サービス単位数を取得します。
     *
     * @return 後_公費3_サービス単位数
     */
    public RString get後_公費3_サービス単位数() {
        return entity.get後_公費3_サービス単位数();
    }

    /**
     * 後_公費3_請求額を取得します。
     *
     * @return 後_公費3_請求額
     */
    public RString get後_公費3_請求額() {
        return entity.get後_公費3_請求額();
    }

    /**
     * 後_公費3_利用者負担額を取得します。
     *
     * @return 後_公費3_利用者負担額
     */
    public RString get後_公費3_利用者負担額() {
        return entity.get後_公費3_利用者負担額();
    }

    /**
     * 後_公費3_緊急時施設療養費請求額を取得します。
     *
     * @return 後_公費3_緊急時施設療養費請求額
     */
    public RString get後_公費3_緊急時施設療養費請求額() {
        return entity.get後_公費3_緊急時施設療養費請求額();
    }

    /**
     * 後_公費3_特定診療費請求額を取得します。
     *
     * @return 後_公費3_特定診療費請求額
     */
    public RString get後_公費3_特定診療費請求額() {
        return entity.get後_公費3_特定診療費請求額();
    }

    /**
     * 後_公費3_特定入所者介護サービス費等請求額を取得します。
     *
     * @return 後_公費3_特定入所者介護サービス費等請求額
     */
    public RString get後_公費3_特定入所者介護サービス費等請求額() {
        return entity.get後_公費3_特定入所者介護サービス費等請求額();
    }

    /**
     * 警告区分コードを取得します。
     *
     * @return 警告区分コード
     */
    public RString get警告区分コード() {
        return entity.get警告区分コード();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public RString get審査年月() {
        return entity.get審査年月();
    }

    /**
     * 整理番号を取得します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.get整理番号();
    }

    /**
     * 送付年月を取得します。
     *
     * @return 送付年月
     */
    public RString get送付年月() {
        return entity.get送付年月();
    }

    /**
     * 取込年月を取得します。
     *
     * @return 取込年月
     */
    public RString get取込年月() {
        return entity.get取込年月();
    }

    /**
     * 独自作成区分を取得します。
     *
     * @return 独自作成区分
     */
    public RString get独自作成区分() {
        return entity.get独自作成区分();
    }

    /**
     * 保険者保有給付実績情報削除済フラグを取得します。
     *
     * @return 保険者保有給付実績情報削除済フラグ
     */
    public RString get保険者保有給付実績情報削除済フラグ() {
        return entity.get保険者保有給付実績情報削除済フラグ();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.get識別コード();
    }
}
