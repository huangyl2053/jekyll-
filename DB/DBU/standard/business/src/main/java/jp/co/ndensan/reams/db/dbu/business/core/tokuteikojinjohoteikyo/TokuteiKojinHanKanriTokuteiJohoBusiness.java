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
 * 特定個人版管理特定情報Business。
 *
 * @reamsid_L DBU-4880-110 dingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiKojinHanKanriTokuteiJohoBusiness implements Serializable {

    private static final long serialVersionUID = 7283417203426673863L;

    private RString 版番号;
    private RString 初回提供区分;
    private RString 特定個人情報名コード;
}
