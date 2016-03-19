/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiShukeiIchijiEntity {

    private RString 識別コード;
    private RString 資格喪失事由;
    private RString 資格喪失年月日;
    private RString 全国住所コード;
    private RString 郵便番号;
    private RString 住所;
    private RString 行政区コード;
    private RString 行政区;
    private RString 氏名カナ;
    private RString 氏名;

}
