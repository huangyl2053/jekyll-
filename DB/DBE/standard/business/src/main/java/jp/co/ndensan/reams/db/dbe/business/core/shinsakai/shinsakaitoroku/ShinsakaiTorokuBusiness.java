/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaitoroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaitoroku.ShinsakaiTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会登録画面を管理するクラスです。
 * 
 * @author n3402 猪股祐太
 */
public class ShinsakaiTorokuBusiness {
    
    private final ShinsakaiTorokuRelateEntity entity;
    
    /**
     * 審査会登録項目を返します。
     *
     * @param entity ShinSaKaiToRoKuRelateEntity
     */
    public ShinsakaiTorokuBusiness(ShinsakaiTorokuRelateEntity entity) {
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
     * 認定申請区分法令コードを返します。
     *
     * @return 認定申請区分法令コード
     */
    public Code get認定申請区分法令コード() {
        return entity.getNinteiShinseiHoreiKubunCode();
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
     * 介護認定審査会優先振分区分コードを返します。
     *
     * @return 介護認定審査会優先振分区分コード
     */
    public Code get介護認定審査会優先振分区分コード() {
        return entity.getYusenWaritsukeKubunCode();
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
     * 認定調査完了年月日を返します。
     *
     * @return 認定調査完了年月日
     */
    public FlexibleDate get認定調査完了年月日() {
        return entity.getNinteichosaKanryoYMD();
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
     * マスキング完了年月日を返します。
     *
     * @return マスキング完了年月日
     */
    public FlexibleDate getマスキング完了年月日() {
        return entity.getMaskingKanryoYMD();
    }

    /**
     * 認定審査会完了年月日を返します。
     *
     * @return 認定審査会完了年月日
     */
    public FlexibleDate get認定審査会完了年月日() {
        return entity.getNinteiShinsakaiKanryoYMD();
    }

    /**
     * 認定審査会割当完了年月日を返します。
     *
     * @return 認定審査会割当完了年月日
     */
    public FlexibleDate get認定審査会割当完了年月日() {
        return entity.getKaiWariateKanryoYMD();
    }

    /**
     * 介護認定審査会開催予定年月日を返します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public FlexibleDate get介護認定審査会開催予定年月日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 介護認定審査会開始予定時刻を返します。
     *
     * @return 介護認定審査会開始予定時刻
     */
    public RString get介護認定審査会開始予定時刻() {
        return entity.getShinsakaiKaishiYoteiTime();
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 介護認定審査会割当年月日を返します。
     *
     * @return 介護認定審査会割当年月日
     */
    public FlexibleDate get介護認定審査会割当年月日() {
        return entity.getShinsakaiWariateYMD();
    }
    
    /**
     * 合議体名称を返します。
     * 
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.getGogitaiMei();
    }
}
