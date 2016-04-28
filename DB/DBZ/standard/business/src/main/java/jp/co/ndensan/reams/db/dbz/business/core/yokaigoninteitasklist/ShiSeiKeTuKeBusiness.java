/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShiSeiKeTuKeRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * タスク一覧共有画面を管理するクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
public class ShiSeiKeTuKeBusiness {

    private final ShiSeiKeTuKeRelateEntity entity;

    /**
     * 申請受付項目を返します。
     *
     * @param entity ShiSeiKeTuKeRelateEntity
     */
    public ShiSeiKeTuKeBusiness(ShiSeiKeTuKeRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
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
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 認定申請区分申請時コードを返します。
     *
     * @return 認定申請区分申請時コード
     */
    public Code get認定申請区分申請時コード() {
        return entity.getShinseijiKubunCode();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 更新通知発行年月日を返します。
     *
     * @return 更新通知発行年月日
     */
    public FlexibleDate get更新通知発行年月日() {
        return entity.getKoshinTsuchiHakkoYMD();
    }

    /**
     * 更新通知発行完了年月日を返します。
     *
     * @return 更新通知発行完了年月日
     */
    public FlexibleDate get更新通知発行完了年月日() {
        return entity.getKoshinTsuchiHakkoKanryoYMD();
    }

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public Code get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 保険者を返します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return entity.getShichosonMeisho();
    }

    /**
     * 認定申請情報登録完了年月日を返します。
     *
     * @return 認定申請情報登録完了年月日
     */
    public FlexibleDate get認定申請情報登録完了年月日() {
        return entity.getJohoTorokuKanryoYMD();
    }

    /**
     * 依頼書出力年月日を返します。
     *
     * @return 依頼書出力年月日
     */
    public FlexibleDate get依頼書出力年月日() {
        return entity.getIraishoShutsuryokuYMD();
    }

    /**
     * 調査票等出力年月日を返します。
     *
     * @return 調査票等出力年月日
     */
    public FlexibleDate get調査票等出力年月日() {
        return entity.getChosahyoTouShutsuryokuYMD();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaIraiRirekiNo();
    }
}
