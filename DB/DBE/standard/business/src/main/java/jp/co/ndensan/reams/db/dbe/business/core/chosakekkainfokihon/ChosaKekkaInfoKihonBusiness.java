/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfokihon.ChosaKekkaInfoKihonRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果情報照会_基本調査クラスです。
 *
 * @reamsid_L DBE-3000-270 lizhuoxuan
 */
public class ChosaKekkaInfoKihonBusiness {

    private final ChosaKekkaInfoKihonRelateEntity kihonRelateEntity;

    /**
     * 認定調査結果情報照会_概況調査項目を返します。
     *
     * @param kihonRelateEntity ChosaKekkaInfoKihonRelateEntity
     */
    public ChosaKekkaInfoKihonBusiness(ChosaKekkaInfoKihonRelateEntity kihonRelateEntity) {
        this.kihonRelateEntity = kihonRelateEntity;
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return kihonRelateEntity.getNinteichosaJisshiYMD();
    }

    /**
     * 認定調査実施場所名称を返します。
     *
     * @return 認定調査実施場所名称
     */
    public RString get認定調査実施場所名称() {
        return kihonRelateEntity.getChosaJisshiBashoMeisho();
    }

    /**
     * 認定調査・認知症高齢者の日常生活自立度コードを返します。
     *
     * @return 認定調査・認知症高齢者の日常生活自立度コード
     */
    public Code get認定調査_認知症高齢者の日常生活自立度コード() {
        return kihonRelateEntity.getNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 認定調査・障害高齢者の日常生活自立度コードを返します。
     *
     * @return 認定調査・障害高齢者の日常生活自立度コード
     */
    public Code get認定調査_障害高齢者の日常生活自立度コード() {
        return kihonRelateEntity.getShogaiNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return kihonRelateEntity.getKoroshoIfShikibetsuCode();
    }
}
