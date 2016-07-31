/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfogaikyo.RembanServiceJokyoRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査結果情報照会_概況調査クラスです。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
public class RembanServiceJokyoBusiness {

    private final RembanServiceJokyoRelateEntity jokyoRelateEntity;

    /**
     * 認定調査結果情報照会_概況調査項目を返します。
     *
     * @param jokyoRelateEntity RembanServiceJokyoRelateEntity
     */
    public RembanServiceJokyoBusiness(RembanServiceJokyoRelateEntity jokyoRelateEntity) {
        this.jokyoRelateEntity = jokyoRelateEntity;
    }

    /**
     * 記入項目連番を返します。
     *
     * @return 記入項目連番
     */
    public int get連番() {
        return jokyoRelateEntity.getRemban();
    }

    /**
     * サービスの状況フラグを返します。
     *
     * @return サービスの状況フラグ
     */
    public int getサービスの状況フラグ() {
        return jokyoRelateEntity.getServiceJokyoFlag();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return jokyoRelateEntity.getKoroshoIfShikibetsuCode();
    }

    /**
     * Enum区分を返します。
     *
     * @return Enum区分
     */
    public RString getEnum区分() {
        return jokyoRelateEntity.getNumber();
    }
}
