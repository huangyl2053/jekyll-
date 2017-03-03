/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会委員構成一覧RelateEntityクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiIinKoseIchiranRelateEntity {

    private RString shinsakaiIinCode;
    private RString shinsakaiIinShimei;
    private RString shozokukikan;
    private RString seibetsu;
    private RString shinsakaiIinShikakuCode;
    private RString gogitaichoKubunCode;
    private RString shinsakaiIinKaishiYMD;
    private RString shinsakaiIinShuryoYMD;
    private boolean shussekiFlag;
    private boolean haishiFlag;
}
