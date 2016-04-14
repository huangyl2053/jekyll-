/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 資格得喪履歴情報のクラスです。
 *
 * @reamsid_L DBA-0521-010 dongyabin
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuRirekiJoho implements Serializable {

    private RString state;
    private FlexibleDate shutokuDate;
    private FlexibleDate shutokuTodokedeDate;
    private RString shutokuJiyuKey;
    private RString shutokuJiyu;
    private RString hihokenshaKubun;
    private RString hihokenshaKubunKey;
    private FlexibleDate soshitsuDate;
    private FlexibleDate soshitsuTodokedeDate;
    private RString soshitsuJiyuKey;
    private RString soshitsuJiyu;
    private RString jutokuKubun;
    private RString shozaiHokensha;
    private RString sochimotoHokensha;
    private RString kyuHokensha;
    private RString shikibetsuCode;
    private RString shoriDateTime;
    private RString hihokenshaNo;
    private RString daNo;
    private RString shikakuShutokuJiyuCode;
}
