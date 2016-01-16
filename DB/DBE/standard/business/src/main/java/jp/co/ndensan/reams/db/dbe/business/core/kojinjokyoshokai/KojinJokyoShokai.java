/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinjokyoshokai.KojinJokyoShokaiRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author soft863
 */
public class KojinJokyoShokai {
    
    private final KojinJokyoShokaiRelateEntity entity;
    
    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link KojinJokyoShokaiRelateEntity}より{@link ShujiiJoho}を生成します。
     *
     * @param entity DBより取得した{@link KojinJokyoShokaiRelateEntity}
     */
    public KojinJokyoShokai(KojinJokyoShokaiRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定個人状況照会情報"));
    }
    
    /**
     * 認定調査依頼予定年月日を返します。
     *
     * @return 認定調査依頼予定年月日
     */
    public FlexibleDate get認定調査依頼予定年月日() {
        return entity.getNinteichosaIraiYoteiYMD();
    }
    
     /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日
     */
    public FlexibleDate get認定調査予定年月日() {
        return entity.getNinteichosaYoteiYMD();
    }

     /**
     * 主治医意見書作成依頼予定年月日を返します。
     *
     * @return 主治医意見書作成依頼予定年月日
     */
    public FlexibleDate get主治医意見書作成依頼予定年月日() {
        return entity.getIkenshoSakuseiIraiYoteiYMD();
    }
    
     /**
     * 主治医意見書登録予定年月日を返します。
     *
     * @return 主治医意見書登録予定年月日
     */
    public FlexibleDate get主治医意見書登録予定年月日() {
        return entity.getIkenshoTorokuYoteiYMD();
    }
    
     /**
     * 要介護認定一次判定予定年月日を返します。
     *
     * @return 要介護認定一次判定予定年月日
     */
    public FlexibleDate get要介護認定一次判定予定年月日() {
        return entity.getIchijiHanteiYoteiYMD();
    }
    
     /**
     * 認定審査会割当予定年月日を返します。
     *
     * @return 認定審査会割当予定年月日
     */
    public FlexibleDate get認定審査会割当予定年月日() {
        return entity.getNinteiShinsakaiWariateYoteiYMD();
    }
    
     /**
     * 認定審査会予定年月日を返します。
     *
     * @return 認定審査会予定年月日
     */
    public FlexibleDate get認定審査会予定年月日() {
        return entity.getNinteiShinsakaiYoteiYMD();
    }
    
     /**
     * 認定調査依頼完了年月日を返します。
     *
     * @return 認定調査依頼完了年月日
     */
    public FlexibleDate get認定調査依頼完了年月日() {
        return entity.getNinteichosaIraiKanryoYMD();
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
     * 要介護認定一次判定完了年月日を返します。
     *
     * @return 要介護認定一次判定完了年月日
     */
    public FlexibleDate get要介護認定一次判定完了年月日() {
        return entity.getIchijiHanteiKanryoYMD();
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
     * 認定審査会割当完了年月日を返します。
     *
     * @return 認定審査会割当完了年月日
     */
    public FlexibleDate get認定審査会割当完了年月日() {
        return entity.getNinteiShinsakaiWariateKanryoYMD();
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
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }
    
     /**
     * 認定申請区分申請時を返します。
     *
     * @return 認定申請区分申請時
     */
    public Code get認定申請区分申請時() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }
    
     /**
     * 認定申請区分法令時を返します。
     *
     * @return 認定申請区分法令時
     */
    public Code get認定申請区分法令時() {
        return entity.getNinteiShinseiHoreiKubunCode();
    }
    
     /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code get二次判定要介護状態区分コード() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode();
    }
    
     /**
     * 二次判定認定有効開始年月日を返します。
     *
     * @return 二次判定認定有効開始年月日
     */
    public FlexibleDate get二次判定認定有効開始年月日() {
        return entity.getNijiHanteiNinteiYukoKaishiYMD();
    }
    
     /**
     * 二次判定認定有効終了年月日を返します。
     *
     * @return 二次判定認定有効終了年月日
     */
    public FlexibleDate get二次判定認定有効終了年月日() {
        return entity.getNijiHanteiNinteiYukoShuryoYMD();
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
     * 要支援申請の区分を返します。
     *
     * @return 要支援申請の区分
     */
    public RString get要支援申請の区分() {
        return entity.getShienShinseiKubun();
    }
    
     /**
     * 二号特定疾病コードを返します。
     *
     * @return 二号特定疾病コード
     */
    public Code get二号特定疾病コード() {
        return entity.getNigoTokuteiShippeiCode();
    }
    
     /**
     * 情報提供への同意有無を返します。
     *
     * @return 情報提供への同意有無
     */
    public boolean get情報提供への同意有無() {
        return entity.isJohoteikyoDoiFlag();
    }
    
     /**
     * 要介護認定一次判定結果コードを返します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public Code get要介護認定一次判定結果コード() {
        return entity.getIchijiHanteiKekkaCode();
    }
    
     /**
     * 審査会開催年月日を返します。
     *
     * @return 審査会開催年月日
     */
    public FlexibleDate get審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }
     /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public Code get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }
}
