/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.ninteishinseijoho;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請情報を取得するクラス。
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public class NinteiShinseiJohoBusiness {

    private final NinteiShinseiJohoEntity entity;

    /**
     * 要介護認定申請情報を返します。
     *
     * @param entity NinteiShinseiJohoEntity
     */
    public NinteiShinseiJohoBusiness(NinteiShinseiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 保険者番号番号を返します。
     *
     * @return 保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 保険者番号カナを返します。
     *
     * @return 保険者番号カナ
     */
    public AtenaKanaMeisho get被保険者カナ() {
        return entity.getHihokenshaKana();
    }

    /**
     * 保険者番号名前を返します。
     *
     * @return 保険者番号名前
     */
    public AtenaMeisho get被保険者名前() {
        return entity.getHihokenshaName();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getSeinengappiYMD();
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
     * 認定申請区分（申請時）コードを返します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public Code get認定申請区分申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }
}
