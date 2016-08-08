/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局概況特記情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuGaikyouBusiness {

    private final ShinsakaiSiryoKyotsuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity ShinsakaiSiryoKyotsuEntity
     */
    public JimuGaikyouBusiness(ShinsakaiSiryoKyotsuEntity entity) {
        this.entity = entity;
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo().getColumnValue();
    }

    /**
     * 名前を取得します。
     *
     * @return 名前
     */
    public RString get名前() {
        return entity.getHihokenshaName().getColumnValue();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 介護認定審査会開催年月日を取得します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 概況特記テキスト_イメージ区分を取得します。
     *
     * @return 概況特記テキスト_イメージ区分
     */
    public RString get概況特記テキスト_イメージ区分() {
        return entity.getGaikyoChosaTextImageKubun();
    }

    /**
     * 住宅改修テキストを取得します。
     *
     * @return 住宅改修テキスト
     */
    public RString get住宅改修テキスト() {
        return entity.getJutakuKaishu();
    }

    /**
     * 市町村特別給付のサービス種類名テキストを取得します。
     *
     * @return 市町村特別給付のサービス種類名テキスト
     */
    public RString get市町村特別給付のサービス種類名テキスト() {
        return entity.getTokubetsuKyufuService();
    }

    /**
     * 介護保険給付外の在宅サービス種類名テキストを取得します。
     *
     * @return 介護保険給付外の在宅サービス種類名テキスト
     */
    public RString get介護保険給付外の在宅サービス種類名テキスト() {
        return entity.getZaitakuService();
    }

    /**
     * 概況特記事項_主訴_テキストを取得します。
     *
     * @return 概況特記事項_主訴_テキスト
     */
    public RString get概況特記事項_主訴_テキスト() {
        return entity.getShuso();
    }

    /**
     * 概況特記事項_家族状況_テキストを取得します。
     *
     * @return 概況特記事項_家族状況_テキスト
     */
    public RString get概況特記事項_家族状況_テキスト() {
        return entity.getKazokuJokyo();
    }

    /**
     * 概況特記事項_居住環境_テキストを取得します。
     *
     * @return 概況特記事項_居住環境_テキスト
     */
    public RString get概況特記事項_居住環境_テキスト() {
        return entity.getKyojuKankyo();
    }

    /**
     * 概況特記事項_機器_機械_テキストを取得します。
     *
     * @return 概況特記事項_機器_機械_テキスト
     */
    public RString get概況特記事項_機器_機械_テキスト() {
        return entity.getKikaiKiki();
    }
}
