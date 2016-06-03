/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteichosairaishokai;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteichosairaishokai.NinteiChosaIraiShokaiRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査情報を取得のクラスです。
 *
 * @reamsid_L DBE-0200-020 zhangguopeng
 */
public class NinteiChosaIraiShokaiMaster {

    private final NinteiChosaIraiShokaiRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity NinteiChosaIraiShokaiRelateEntity
     */
    public NinteiChosaIraiShokaiMaster(NinteiChosaIraiShokaiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定申請日を取得します。
     *
     * @return 認定申請日
     */
    public FlexibleDate getNinteiShinseiYMD() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 申請区分（申請時）を取得します。
     *
     * @return 申請区分（申請時）
     */
    public Code getNinteiShinseiShinseijiKubunCode() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 取下年月日を取得します。
     *
     * @return 取下年月日
     */
    public FlexibleDate getTorisageYMD() {
        return entity.getTorisageYMD();
    }

    /**
     * 二次判定年月日を取得します。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate getNijiHanteiYMD() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 二次判定要介護状態区分コードを取得します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code getNijiHanteiYokaigoJotaiKubunCode() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定認定有効期間を取得します。
     *
     * @return 二次判定認定有効期間
     */
    public int getNijiHanteiNinteiYukoKikan() {
        return entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString getJigyoshaMeisho() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 認定調査委託先コードを取得します。
     *
     * @return 認定調査委託先コード
     */
    public ChosaItakusakiCode getNinteiChosaItakusakiCode() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public ChosainCode getNinteiChosainCode() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString getChosainShimei() {
        return entity.getChosainShimei();
    }

    /**
     * 認定調査依頼区分コードを取得します。
     *
     * @return 認定調査依頼区分コード
     */
    public Code getNinteichosaIraiKubunCode() {
        return entity.getNinteichosaIraiKubunCode();
    }
}
