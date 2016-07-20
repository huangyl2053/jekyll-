/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfokihon.TokiJikouRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果情報照会_基本調査クラスです。
 *
 * @reamsid_L DBE-3000-270 lizhuoxuan
 */
public class TokiJikouBusiness {

    private final TokiJikouRelateEntity jikouRelateEntity;

    /**
     * 認定調査結果情報照会_概況調査項目を返します。
     *
     * @param jikouRelateEntity TokiJikouRelateEntity
     */
    public TokiJikouBusiness(TokiJikouRelateEntity jikouRelateEntity) {
        this.jikouRelateEntity = jikouRelateEntity;
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return jikouRelateEntity.getRemban();
    }

    /**
     * 調査項目を返します。
     *
     * @return 調査項目
     */
    public RString get調査項目() {
        return jikouRelateEntity.getResearchItem();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return jikouRelateEntity.getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return jikouRelateEntity.getNinteichosaRirekiNo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return jikouRelateEntity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 件数を返します。
     *
     * @return 件数
     */
    public int get件数() {
        return jikouRelateEntity.getCOUNT();
    }
}
