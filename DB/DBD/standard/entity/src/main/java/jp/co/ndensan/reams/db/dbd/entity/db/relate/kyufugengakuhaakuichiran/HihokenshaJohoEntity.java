/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報Entity
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaJohoEntity {

    private RString 被保険者番号;
    private RString 識別コード;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 世帯番号;
    private RString 行政区ｺｰﾄﾞ;
    private RString 行政区;
    private RString 住所コード;
    private RString 郵便番号;
    private RString 住所;
    private ShikakuJoho 資格情報;
    private NinteiJoho 認定情報;
    private GengakuTaishoSaishinJoho 減額対象最新情報;

}
