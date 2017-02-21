/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadatatorikomi.NinteiChosaDataTorikomiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 認定調査データ取込のRelateクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class NinteiChosaDataTorikomiRelate {

    private final NinteiChosaDataTorikomiRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity NinteiChosaDataTorikomiRelateEntity
     */
    public NinteiChosaDataTorikomiRelate(NinteiChosaDataTorikomiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.get認定申請情報Entity().getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return (entity.get認定調査依頼情報Entity() != null)
                ? entity.get認定調査依頼情報Entity().getNinteichosaIraiRirekiNo()
                : 0;
    }

    /**
     * 認定調査依頼完了日を返します。
     *
     * @return 認定調査依頼完了日
     */
    public FlexibleDate get認定調査依頼完了日() {
        return (entity.get認定完了情報Entity() != null)
                ? entity.get認定完了情報Entity().getNinteichosaIraiKanryoYMD()
                : null;
    }

    /**
     * 認定調査完了日を返します。
     *
     * @return 認定調査完了日
     */
    public FlexibleDate get認定調査完了日() {
        return (entity.get認定完了情報Entity() != null)
                ? entity.get認定完了情報Entity().getNinteichosaKanryoYMD()
                : null;
    }

    /**
     * 本判定一次判定データがあるか返します。
     *
     * @return true：本判定一次判定データがある場合<br/>
     * false：本判定一次判定データがない場合
     */
    public boolean exist本判定一次判定データ() {
        if (entity.get一次判定結果情報Entity() == null) {
            return false;
        }
        return !entity.get一次判定結果情報Entity().getKariIchijiHanteiKubun();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean exist論理削除フラグ() {
        if (entity.get認定調査依頼情報Entity() == null) {
            return false;
        }
        return entity.get認定調査依頼情報Entity().getLogicalDeletedFlag();
    }

    /**
     * 認定調査依頼情報が存在するか返します。
     *
     * @return true：認定調査依頼情報が存在する場合<br/>
     * false：認定調査依頼情報が存在しない場合
     */
    public boolean exist認定調査依頼情報() {
        return entity.get認定調査依頼情報Entity() != null;
    }
}
