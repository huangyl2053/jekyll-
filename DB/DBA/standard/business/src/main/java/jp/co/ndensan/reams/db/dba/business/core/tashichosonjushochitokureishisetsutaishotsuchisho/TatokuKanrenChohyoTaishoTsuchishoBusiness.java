/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureishisetsutaishotsuchisho;

import jp.co.ndensan.reams.db.dba.entity.db.relate.tashitaishotsuchisho.TatokuKanrenChohyoTaishoTsuchishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 他住特施設退所通知書データEntity
 *
 * @reamsid_L DBA-0380-010 huangh
 */
public class TatokuKanrenChohyoTaishoTsuchishoBusiness {

    private final TatokuKanrenChohyoTaishoTsuchishoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity TatokuKanrenChohyoTaishoTsuchishoEntity
     */
    public TatokuKanrenChohyoTaishoTsuchishoBusiness(TatokuKanrenChohyoTaishoTsuchishoEntity entity) {
        this.entity = entity;
    }

    /**
     * 保険者郵便番号を返します。
     *
     * @return 保険者郵便番号
     */
    public RString get保険者郵便番号() {
        return entity.get保険者郵便番号();
    }

    /**
     * 文書番号を返します。
     *
     * @return 文書番号
     */
    public RString get文書番号() {
        return entity.get文書番号();
    }

    /**
     * 保険者住所を返します。
     *
     * @return 保険者住所
     */
    public RString get保険者住所() {
        return entity.get保険者住所();
    }

    /**
     * 発行年月日を返します。
     *
     * @return 発行年月日
     */
    public RString get発行年月日() {
        return entity.get発行年月日();
    }

    /**
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.get保険者名();
    }

    /**
     * 保険者名敬称を返します。
     *
     * @return 保険者名敬称
     */
    public RString get保険者名敬称() {
        return entity.get保険者名敬称();
    }

    /**
     * 担当部署名を返します。
     *
     * @return 担当部署名
     */
    public RString get担当部署名() {
        return entity.get担当部署名();
    }

    /**
     * 担当部署名敬称を返します。
     *
     * @return 担当部署名敬称
     */
    public RString get担当部署名敬称() {
        return entity.get担当部署名敬称();
    }

    /**
     * バーコード情報を返します。
     *
     * @return バーコード情報
     */
    public RString getバーコード情報() {
        return entity.getバーコード情報();
    }

    /**
     * 見出しを返します。
     *
     * @return 見出し
     */
    public RString get見出し() {
        return entity.get見出し();
    }

    /**
     * 被保険者番号１を返します。
     *
     * @return 被保険者番号１
     */
    public RString get被保険者番号１() {
        return entity.get被保険者番号１();
    }

    /**
     * 被保険者番号２を返します。
     *
     * @return 被保険者番号２
     */
    public RString get被保険者番号２() {
        return entity.get被保険者番号２();
    }

    /**
     * 被保険者番号３を返します。
     *
     * @return 被保険者番号３
     */
    public RString get被保険者番号３() {
        return entity.get被保険者番号３();
    }

    /**
     * 被保険者番号４を返します。
     *
     * @return 被保険者番号４
     */
    public RString get被保険者番号４() {
        return entity.get被保険者番号４();
    }

    /**
     * 被保険者番号５を返します。
     *
     * @return 被保険者番号５
     */
    public RString get被保険者番号５() {
        return entity.get被保険者番号５();
    }

    /**
     * 被保険者番号６を返します。
     *
     * @return 被保険者番号６
     */
    public RString get被保険者番号６() {
        return entity.get被保険者番号６();
    }

    /**
     * 被保険者番号７を返します。
     *
     * @return 被保険者番号７
     */
    public RString get被保険者番号７() {
        return entity.get被保険者番号７();
    }

    /**
     * 被保険者番号８を返します。
     *
     * @return 被保険者番号８
     */
    public RString get被保険者番号８() {
        return entity.get被保険者番号８();
    }

    /**
     * 被保険者番号９を返します。
     *
     * @return 被保険者番号９
     */
    public RString get被保険者番号９() {
        return entity.get被保険者番号９();
    }

    /**
     * 被保険者番号１０を返します。
     *
     * @return 被保険者番号１０
     */
    public RString get被保険者番号１０() {
        return entity.get被保険者番号１０();
    }

    /**
     * 対象者名カナを返します。
     *
     * @return 対象者名カナ
     */
    public RString get対象者名カナ() {
        return entity.get対象者名カナ();
    }

    /**
     * 対象者名を返します。
     *
     * @return 対象者名
     */
    public RString get対象者名() {
        return entity.get対象者名();
    }

    /**
     * 誕生日を返します。
     *
     * @return 誕生日
     */
    public RString get誕生日() {
        return entity.get誕生日();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 電子公印を返します。
     *
     * @return 電子公印
     */
    public RString get電子公印() {
        return entity.get電子公印();
    }

    /**
     * 証明発行日を返します。
     *
     * @return 証明発行日
     */
    public FlexibleDate get証明発行日() {
        return entity.get証明発行日();
    }

    /**
     * 首長名を返します。
     *
     * @return 首長名
     */
    public RString get首長名() {
        return entity.get首長名();
    }

    /**
     * 市町村名を返します。
     *
     * @return 市町村名
     */
    public RString get市町村名() {
        return entity.get市町村名();
    }

    /**
     * 公印省略を返します。
     *
     * @return 公印省略
     */
    public RString get公印省略() {
        return entity.get公印省略();
    }

    /**
     * 施設名称を返します。
     *
     * @return 施設名称
     */
    public RString get施設名称() {
        return entity.get施設名称();
    }

    /**
     * 施設電話番号を返します。
     *
     * @return 施設電話番号
     */
    public RString get施設電話番号() {
        return entity.get施設電話番号();
    }

    /**
     * 施設FAX番号を返します。
     *
     * @return 施設FAX番号
     */
    public RString get施設FAX番号() {
        return entity.get施設FAX番号();
    }

    /**
     * 施設郵便番号を返します。
     *
     * @return 施設郵便番号
     */
    public RString get施設郵便番号() {
        return entity.get施設郵便番号();
    }

    /**
     * 施設住所を返します。
     *
     * @return 施設住所
     */
    public RString get施設住所() {
        return entity.get施設住所();
    }

    /**
     * 退所事由を返します。
     *
     * @return 退所事由
     */
    public RString get退所事由() {
        return entity.get退所事由();
    }

    /**
     * 退所年月日を返します。
     *
     * @return 退所年月日
     */
    public RString get退所年月日() {
        return entity.get退所年月日();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.get住所();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.get郵便番号();
    }
}
