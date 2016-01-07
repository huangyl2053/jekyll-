/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.definition.koikinaijushochitokurei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 広域内住所地特例者Entityクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiJushochiTokureiEntity {
    
    private RString 被保険者番号;
    private RString 氏名カナ;
    private RString 生年月日;
    private RString 住所コード;
    private RString 行政区CD;
    private RString 行政区;
    private RString 取得日;
    private RString 取得届出日;
    private RString 喪失日;
    private RString 喪失届出日;
    private RString 資格区分;
    private RString 住特;
    private RString 識別コード;
    private RString 氏名;
    private RString 性別;
    private RString 世帯コード;
    private RString 住所;
    private RString 広住取得日;
    private RString 広住取得届出日;
    private RString 広住喪失日;
    private RString 広住喪失届出日;
    private RString 措置市町村コード;
    private RString 措置市町村名称;
    private RString 住民種別コード;
    
}
