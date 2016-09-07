/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinseiikkatushinsa;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 未審査支給申請情報用クラスです。
 *
 * @reamsid_L DBC-0991-040 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MiShinsaSikyuShinsei implements Serializable {

    private ShokanShinsei entity;
    private ShikibetsuCode 識別コード;
    private AtenaMeisho 氏名;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     * @param 識別コード 識別コード
     * @param 氏名 氏名
     */
    public MiShinsaSikyuShinsei(ShokanShinsei entity,
            ShikibetsuCode 識別コード,
            AtenaMeisho 氏名) {
        this.entity = entity;
        this.識別コード = 識別コード;
        this.氏名 = 氏名;
    }
}
