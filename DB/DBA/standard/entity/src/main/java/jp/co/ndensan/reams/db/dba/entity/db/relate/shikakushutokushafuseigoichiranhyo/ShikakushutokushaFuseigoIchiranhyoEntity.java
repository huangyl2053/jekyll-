/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得者不整合リスト帳票用データEntityクラスです。
 *
 * @reamsid_L DBU-4020-040 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakushutokushaFuseigoIchiranhyoEntity {

    private RString タイトル;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 被保険者番号;
    private RString ﾌﾘｶﾞﾅ;
    private RString 氏名;
    private RString 識別コード;
    private FlexibleDate 生年月日;
    private RString 前住所;
    private RString 現住所;
    private RString 市町村コードList;
    private RString 資格区分;
    private RString 住特;
    private RString 不整合情報;
}
