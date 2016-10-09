/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.tokuteikojinjohoteikyo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特定個人情報項目版管理Business。
 *
 * @reamsid_L DBU-4880-110 dingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiKojinJohoKoumokuHanKanriBusiness implements Serializable {

    private static final long serialVersionUID = 8826522275267795442L;

    private RString 特定個人情報項目コード;
    private RString バージョン情報;
    private RString 特定個人情報項目区分;
    private RString 無効化フラグ;
    private RString 提供内容項目番号;
}
