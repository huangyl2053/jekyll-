/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.NiJiHanTeiRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * タスク一覧共有画面を管理するクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
public class NiJiHanTeiBusiness {

    private final NiJiHanTeiRelateEntity entity;

    /**
     * 二次判定項目を返します。
     *
     * @param entity NiJiHanTeiRelateEntity
     */
    public NiJiHanTeiBusiness(NiJiHanTeiRelateEntity entity) {
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
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
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
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public Code get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 再調査依頼回数を返します。
     *
     * @return 再調査依頼回数
     */
    public int get再調査依頼回数() {
        return entity.getSaiChosaIraiKaisu();
    }

    /**
     * 再意見書回数を返します。
     *
     * @return 再意見書回数
     */
    public int get再意見書回数() {
        return entity.getSaiSakuseiIraiKaisu();
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
     * 介介護認定審査会開始予定時刻を返します。
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
     * 調合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 二次判定年月日を返します。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate get二次判定年月日() {
        return entity.getNijiHanteiYMD();
    }
    /**
     * 二次判定結果入力年月日を返します。
     *
     * @return 二次判定結果入力年月日
     */
    public FlexibleDate get二次判定結果入力年月日() {
        return entity.getNijiHanteiKekkaInputYMD();
    }

    /**
     * 二次判定結果入力方法を返します。
     *
     * @return 二次判定結果入力方法
     */
    public Code get二次判定結果入力方法() {
        return entity.getNijiHanteiKekkaInputHoho();
    }

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code get二次判定要介護状態区分コード() {
        return entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定認定有効期間を返します。
     *
     * @return 二次判定認定有効期間
     */
    public int get二次判定認定有効期間() {
        return entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 介護認定審査会開催年月日を返します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }
}
