/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ininteichosaschebusiness;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaschedule.INinteichosaScheduleRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査スケジュール登録3Businessです。
 */
public class NinteichosaSchedulBusiness {

    private final INinteichosaScheduleRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link NinteiChosainMasterRelateEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link NinteiChosainMasterRelateEntity}
     */
    public NinteichosaSchedulBusiness(INinteichosaScheduleRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    public RString get被保険者氏名カナ() {
        return entity.getHihokenshaKana();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 生年月日称を返します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日
     */
    public RString get認定調査予定年月日() {
        return entity.getNinteiChosaYoteiYMD();
    }

    /**
     * 予約状況を返します。
     *
     * @return 予約状況
     */
    public RString get予約状況() {
        return entity.getYoyakuJokyo();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public RString get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請区分を返します。
     *
     * @return 認定申請区分
     */
    public RString get認定申請区分() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 対象者メモを返します。
     *
     * @return 対象者メモ
     */
    public RString get対象者メモ() {
        return entity.getTaishoshaMemo();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 認定調査時間枠を返します。
     *
     * @return 認定調査時間枠
     */
    public RString get認定調査時間枠() {
        return entity.getNinteiChosaJikanWaku();
    }

    /**
     * 予約可能フラグを返します。
     *
     * @return 予約可能フラグ
     */
    public RString get予約可能フラグ() {
        return entity.getYoyakuKaoFlag();
    }

    /**
     * get認定調査委託先を返します。
     *
     * @return 予約可能フラグ
     */
    public RString get認定調査委託先() {
        return entity.getNinteiChosaItakusakiCode2();
    }

    /**
     * 認定調査委託先名称を返します。
     *
     * @return 認定調査委託先名称
     */
    public RString get認定調査委託先名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 認定調査員を返します。
     *
     * @return 認定調査員
     */
    public RString get認定調査員() {
        return entity.getNinteiChosainCode2();
    }

    /**
     * 認定調査員氏名を返します。
     *
     * @return 認定調査員氏名
     */
    public RString get認定調査員氏名() {
        return entity.getChosainShimei();
    }

}
