/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報項目版管理のRelateEntityクラスです。
 *
 * @reamsid_L DBU-4880-110 dingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuteiKojinJohoKoumokuHanKanriRelateEntity {

    private RString 特定個人情報名コード;
    private RString 特定個人情報項目コード;
    private RString 特定個人情報項目区分;
    private RString 提供内容項目番号;
    private RString バージョン情報;
    private RString 無効化フラグ;

}
