/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteishinsakaiiinguide;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会委員一覧情報取得_戻る用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinsakaiIinGuideEntity {

    private RString shinsakaiIinCode;
    private AtenaMeisho shinsakaiIinName;
    private AtenaKanaMeisho shinsakaiIinKanaName;
    private RString seibetsu;
    private Code shinsakaiIinShikaku;
}
