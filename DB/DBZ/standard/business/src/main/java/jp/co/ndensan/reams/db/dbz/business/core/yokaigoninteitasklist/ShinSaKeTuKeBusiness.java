/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKeTuKeRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * タスク一覧共有画面を管理するクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
public class ShinSaKeTuKeBusiness {

    private final ShinSaKeTuKeRelateEntity entity;

    /**
     * 更新対象項目を返します。
     *
     * @param entity ShinSaKeTuKeRelateEntity
     */
    public ShinSaKeTuKeBusiness(ShinSaKeTuKeRelateEntity entity) {
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
     * 認定申請区分（申請時）コードを返します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public Code get認定申請区分_申請時コード() {
        return entity.getShinseijiKubunCode();
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
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
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
     * 保険者を返します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return entity.getShichosonMeisho();
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
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public Code get処理状態区分() {
        return entity.getShoriJotaiKubun();
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }
}
