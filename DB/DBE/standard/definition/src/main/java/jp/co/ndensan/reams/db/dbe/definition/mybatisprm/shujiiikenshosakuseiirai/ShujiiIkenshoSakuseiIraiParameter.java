/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseikensaku.ShinseiKensakuMapperParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書一覧のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoSakuseiIraiParameter extends ShinseiKensakuMapperParameter {

    private RString shoriJotaiKubunTsujo;
    private RString shoriJotaiKubunEnki;
    private boolean useZenkaiNinteiShinseiJoho;
}
