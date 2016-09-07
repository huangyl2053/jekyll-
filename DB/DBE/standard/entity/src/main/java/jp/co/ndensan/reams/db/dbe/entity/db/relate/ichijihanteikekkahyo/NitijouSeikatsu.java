/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 日常生活自立Entityクラスです。
 *
 * @reamsid_L DBE-0150-330 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NitijouSeikatsu {

    private RString 認知症高齢者自立度;
    private RString 特記事項フラグ;

}
