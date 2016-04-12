/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaschedule;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査スケジュール登録3戻るのEntity。
 *
 * @reamsid_L DBE-0020-030 wanghui
 */
@lombok.Getter
@lombok.Setter
public class ChikuNinteiChosainRelateEntity {

    private RString ninteiChosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString ninteiChosainCode;
    private RString chosainShimei;
}
