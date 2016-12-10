/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinnteiRiriRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定履歴一覧ビジネスクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class NinnteiRiriBusiness implements Serializable {

    private final NinnteiRiriRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity NinnteiRiriRelateEntity
     */
    public NinnteiRiriBusiness(NinnteiRiriRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定申請日のgetメソッドです。
     *
     * @return 認定申請日
     */
    public FlexibleDate get認定申請日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 申請区分(申請時)のgetメソッドです。
     *
     * @return 申請区分(申請時)
     */
    public Code get申請区分_申請時() {
        return entity.getNinteiShinseiShinseiKubunCode();
    }

    /**
     * 申請区分(法令)のgetメソッドです。
     *
     * @return 申請区分(法令)
     */
    public Code get申請区分_法令() {
        return entity.getNinteiShinseiHoreiKubunCode();
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードのgetメソッドです。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 取下年月日のgetメソッドです。
     *
     * @return 取下年月日
     */
    public FlexibleDate get取下年月日() {
        return entity.getTorisageYMD();
    }

    /**
     * 主治医コードのgetメソッドです。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 主治医医療機関コードのgetメソッドです。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 情報提供資料出力年月日のgetメソッドです。
     *
     * @return 情報提供資料出力年月日
     */
    public FlexibleDate get出力年月日() {
        return entity.getJohoteikyoSiryoOutputYMD();
    }

    /**
     * 二次判定年月日のgetメソッドです。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate get二次判定年月日() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 二次判定要介護状態区分コードのgetメソッドです。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code get二次判定区分コード() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定認定有効期間のgetメソッドです。
     *
     * @return 二次判定認定有効期間
     */
    public int get二次判定認定有効期間() {
        return entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 二次判定認定有効開始期間のgetメソッドです。
     *
     * @return 二次判定認定有効開始期間
     */
    public FlexibleDate get二次判定認定有効開始期間() {
        return entity.getNijiHanteiNinteiYukoKaishiYMD();
    }

    /**
     * 二次判定認定有効終了期間のgetメソッドです。
     *
     * @return 二次判定認定有効終了期間
     */
    public FlexibleDate get二次判定認定有効終了期間() {
        return entity.getNijiHanteiNinteiYukoShuryoYMD();
    }

    /**
     * 認定調査実施年月日のgetメソッドです。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 認定調査受領年月日のgetメソッドです。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return entity.getNinteichosaJuryoYMD();
    }

    /**
     * 認定調査依頼年月日のgetメソッドです。
     *
     * @return 認定調査依頼年月日
     */
    public FlexibleDate get認定調査依頼年月日() {
        return entity.getNinteichosaIraiYMD();
    }

    /**
     * 事業者名称のgetメソッドです。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 調査員氏名のgetメソッドです。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 主治医意見書受領年月日のgetメソッドです。
     *
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate get主治医意見書受領年月日() {
        return entity.getIkenshoJuryoYMD();
    }

    /**
     * 主治医意見書作成依頼年月日のgetメソッドです。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return entity.getIkenshoSakuseiIraiYMD();
    }

    /**
     * 医療機関名称のgetメソッドです。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 主治医氏名のgetメソッドです。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.getShujiiName();
    }

    /**
     * 審査会開催予定日のgetメソッドです。
     *
     * @return 審査会開催予定日
     */
    public FlexibleDate get審査会開催予定日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 審査会開催日のgetメソッドです。
     *
     * @return 審査会開催日
     */
    public FlexibleDate get審査会開催日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 認定審査会完了年月日のgetメソッドです。
     *
     * @return 認定審査会完了年月日
     */
    public FlexibleDate get認定審査会完了年月日() {
        return entity.getNinteiShinsakaiKanryoYMD();
    }

    /**
     * 申請書管理番号のgetメソッドです。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 情報提供への同意有無のgetメソッドです。
     *
     * @return 情報提供への同意有無
     */
    public boolean is情報提供への同意有無() {
        return entity.isJohoteikyoDoiFlag();
    }

    /**
     * 意見書同意フラグのgetメソッドです。
     *
     * @return 意見書同意フラグ
     */
    public boolean is意見書同意フラグ() {
        return entity.isIkenshoDoiFlag();
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return entity.getShichosonCode();
    }
}
