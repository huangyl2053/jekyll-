/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kaigoshiensenmoninjouhou;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManeger;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護支援専門員情報です。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoShienSenmoninJouhouResult implements Serializable {

    private CareManeger careManeger;
    private RString 所属事業者番号;
    private RString 事業者名称;

    /**
     * コンストラクタです。
     *
     * @param careManeger CareManeger
     * @param 所属事業者番号 RString
     * @param 事業者名称 RString
     */
    public KaigoShienSenmoninJouhouResult(CareManeger careManeger, RString 所属事業者番号, RString 事業者名称) {
        this.careManeger = careManeger;
        this.所属事業者番号 = 所属事業者番号;
        this.事業者名称 = 事業者名称;
    }

    /**
     * コンストラクタです。
     *
     * @param careManegerentity DbT7064CareManegerEntity
     * @param 所属事業者番号 RString
     * @param 事業者名称 RString
     */
    public KaigoShienSenmoninJouhouResult(DbT7064CareManegerEntity careManegerentity, RString 所属事業者番号,
            RString 事業者名称) {
        this.careManeger = new CareManeger(careManegerentity);
        this.所属事業者番号 = 所属事業者番号;
        this.事業者名称 = 事業者名称;
    }
}
