/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力用一時デーブルクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class UpdateParameterEntity {

    private int kubun;
    private RString no;
    private RString ページNo;
    private RString 区分;
    private RString 要介護状態区分コード;
    private boolean hiGaitouflag;
    private boolean yoSien1flag;
    private boolean yoSien2flag;
    private boolean keikatekiYoSienflag;
    private boolean youKaigo1flag;
    private boolean youKaigo2flag;
    private boolean youKaigo3flag;
    private boolean youKaigo4flag;
    private boolean youKaigo5flag;

}
