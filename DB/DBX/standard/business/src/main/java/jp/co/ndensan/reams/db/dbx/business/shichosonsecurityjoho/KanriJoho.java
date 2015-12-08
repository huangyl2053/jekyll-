/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.shichosonsecurityjoho;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 管理情報のクラス。
 */
@Getter
@Setter
public class KanriJoho {

    private Code 導入形態コード;
    private boolean 支所管理有無フラグ;
    private RString 広域タイプ;
    private Integer 市町村ＩＤ有効桁数;
    private KoseiShichosonJoho 市町村情報;

}
