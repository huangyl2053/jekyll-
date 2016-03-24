/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakutokusojouho;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * ShikakuRirekiInfo_資格履歴情報のRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuTokusouJouhoRelateEntity implements IDbAccessable {

    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private RString shikakuShutokuJiyuCode;
    private RString hihokennshaKubunCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private RString shikakuSoshitsuJiyuCode;
    private RString jushochiTokureiFlag;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private LasdecCode shichosonCode2;
    private RString shichosonMeisho2;
    private LasdecCode kyuShichosonCode;
    private RString kyuShichosonMeisho;
    private RDateTime lastUpdateTimestamp;
    private RString tanIchi;
}
