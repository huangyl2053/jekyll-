/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kihonchosainput.KihonChosaSpecialEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査特記情報を管理するビジネスです。
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class KihonChosaSpecial {

    private final KihonChosaSpecialEntity entity;

    /**
     * コンストラクタです。<br/>
     *
     * @param entity 認定調査特記情報
     * @link KihonChosaSpecialEntity より{@link KihonChosaInput}を生成します。
     */
    public KihonChosaSpecial(KihonChosaSpecialEntity entity) {
        this.entity = entity;
    }

    /**
     * 原本マスク区分を返します。
     *
     * @return 原本マスク区分
     */
    public Code get原本マスク区分() {
        return entity.get原本マスク区分();
    }

    /**
     * 特記事項を返します。
     *
     * @return 特記事項
     */
    public RString get特記事項() {
        return entity.get特記事項();
    }

    /**
     * 認定調査特記事項番号を返します。
     *
     * @return 認定調査特記事項番号
     */
    public RString get認定調査特記事項番号() {
        return entity.get認定調査特記事項番号();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.get認定調査依頼履歴番号();
    }

    /**
     * 認定調査特記事項連番を返します。
     *
     * @return 認定調査特記事項連番
     */
    public int get認定調査特記事項連番() {
        return entity.get認定調査特記事項連番();
    }

}
