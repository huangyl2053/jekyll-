/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param;

import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author xiaomm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KazeiKubunHonninKubun {

    private KazeiKubun 課税区分;
    private HonninKubun 本人区分;
}
