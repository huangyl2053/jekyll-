/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 関連データであることを表します。
 */
public interface IRelatedData {

    /**
     * @return 被保険者の氏名
     */
    RString get被保険者氏名();

    /**
     * @return 被保険者のカナ氏名
     */
    RString get被保険者カナ();
}
