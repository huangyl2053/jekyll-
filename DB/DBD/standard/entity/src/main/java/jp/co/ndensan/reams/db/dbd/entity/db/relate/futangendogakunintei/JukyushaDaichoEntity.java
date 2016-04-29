/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakunintei;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 個人情報を含むDBのエンティティクラスです。
 *
 * @reamsid_L DBD-3570-010 wangchao
 */
@lombok.Getter
@lombok.Setter
public class JukyushaDaichoEntity {

    private ShikibetsuCode 識別コード;
    private Code コード;
    private RString name;
    private RString value;
}
