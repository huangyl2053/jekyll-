/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteishinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護保険負担限度額認定申請書の施設情報のEntityです。
 *
 * @reamsid_L DBA-0540-690 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGendogakuNinteiShinseishoEntity {

    private RString 入所施設種類;
    private RString 入所施設コード;
    private RString 事業者郵便番号;
    private RString 事業者住所;
    private RString 事業者電話番号;
    private RString 事業者名称;

}
