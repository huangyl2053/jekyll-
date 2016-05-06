/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 各月資格のEntityクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GetuSikaku {

    private RString hihokenshaNo;
    private FlexibleDate ichigoShikakuShutokuYMD;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString yoGetuSikakuumuFlg;
    private RString goGetuSikakuumuFlg;
    private RString rokuGetuSikakuumuFlg;
    private RString nanaGetuSikakuumuFlg;
    private RString hakuGetuSikakuumuFlg;
    private RString kyuGetuSikakuumuFlg;
    private RString jyuGetuSikakuumuFlg;
    private RString jyuitiGetuSikakuumuFlg;
    private RString jyuniGetuSikakuumuFlg;
    private RString itiGetuSikakuumuFlg;
    private RString niGetuSikakuumuFlg;
    private RString sanGetuSikakuumuFlg;

}
