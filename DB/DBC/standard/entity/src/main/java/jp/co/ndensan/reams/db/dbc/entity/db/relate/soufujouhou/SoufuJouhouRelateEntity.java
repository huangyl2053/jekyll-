/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.soufujouhou;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査申立送付情報RelateEntityクラスです。
 *
 * @reamsid_L DBC-3040-010 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
public class SoufuJouhouRelateEntity {

    private RString 事業所番号;
    private RString 事業所名;
    private RString 被保険者番号;
    private RString 宛名名称;
    private RString サービス提供年月;
    private RString サービス種類コード;
    private RString サービス項目コード;
    private RString サービス略称;
    private RString 証記載保険者番号;
    private RString 申立年月日;
    private RString 申立者区分コード;
    private RString 申立単位数;
    private RString 申立事由コード;
}
