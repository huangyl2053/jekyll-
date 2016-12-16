/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.IkenSyoNyuSyuRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * タスク一覧共有画面を管理するクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
public class IkenSyoNyuSyuBusiness {

    private final IkenSyoNyuSyuRelateEntity entity;

    /**
     * 意見書入手項目を返します。
     *
     * @param entity IkenSyoNyuSyuRelateEntity
     */
    public IkenSyoNyuSyuBusiness(IkenSyoNyuSyuRelateEntity entity) {
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
     * 状態を返します。
     *
     * @return 状態
     */
    public RString get状態() {
        return entity.getJyotai();
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
    public AtenaMeisho get氏名() {
        return entity.getHihokenshaName();
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
     * 主治医意見書作成依頼完了年月日を返します。
     *
     * @return 主治医意見書作成依頼完了年月日
     */
    public FlexibleDate get主治医意見書作成依頼完了年月日() {
        return entity.getIkenshoSakuseiIraiKanryoYMD();
    }

    /**
     * 主治医意見書登録完了年月日を返します。
     *
     * @return 主治医意見書登録完了年月日
     */
    public FlexibleDate get主治医意見書登録完了年月日() {
        return entity.getIkenshoTorokuKanryoYMD();
    }

    /**
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getShichosonMeisho();
    }

    /**
     * 主治医意見書作成督促年月日を返します。
     *
     * @return 主治医意見書作成督促年月日
     */
    public FlexibleDate get主治医意見書作成督促年月日() {
        return entity.getIkenshoSakuseiTokusokuYMD();
    }

    /**
     * 主治医意見書作成督促方法を返します。
     *
     * @return 主治医意見書作成督促方法
     */
    public RString get主治医意見書作成督促方法() {
        return entity.getIkenshoSakuseiTokusokuHoho();
    }

    /**
     * 主治医意見書作成督促回数を返します。
     *
     * @return 主治医意見書作成督促回数
     */
    public int get主治医意見書作成督促回数() {
        return entity.getIkenshoTokusokuKaisu();
    }

    /**
     * 主治医意見書作成期限年月日を返します。
     *
     * @return 主治医意見書作成期限年月日
     */
    public FlexibleDate get主治医意見書作成期限年月日() {
        return entity.getIkenshoSakuseiKigenYMD();
    }

    /**
     * 主治医意見書作成依頼年月日を返します。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return entity.getIkenshoSakuseiIraiYMD();
    }

    /**
     * 主治医意見書作成依頼履歴番号を返します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.getIkenshoIraiRirekiNo();
    }

    /**
     * 意見書作成回数区分を返します。
     *
     * @return 意見書作成回数区分
     */
    public Code get意見書作成回数区分() {
        return entity.getIkenshoSakuseiKaisuKubun();
    }

    /**
     * 主治医意見書読取年月日を返します。
     *
     * @return 主治医意見書読取年月日
     */
    public FlexibleDate get主治医意見書読取年月日() {
        return entity.getIkenshoReadYMD();
    }

    /**
     * 主治医意見書記入年月日を返します。
     *
     * @return 主治医意見書記入年月日
     */
    public FlexibleDate get主治医意見書記入年月日() {
        return entity.getIkenshoKinyuYMD();
    }

    /**
     * 医療機関を返します。
     *
     * @return 医療機関
     */
    public RString get医療機関() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 主治医を返します。
     *
     * @return 主治医
     */
    public RString get主治医() {
        return entity.getShujiiName();
    }
}
