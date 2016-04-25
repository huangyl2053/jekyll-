/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力対象者明細一覧用RelateEntityクラスです。
 *
 * @reamsid_L DBE-0130-090 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class MonthRelateEntity {

    private List<RString> january;
    private List<RString> february;
    private List<RString> march;
    private List<RString> april;
    private List<RString> may;
    private List<RString> june;
    private List<RString> july;
    private List<RString> august;
    private List<RString> september;
    private List<RString> october;
    private List<RString> november;
    private List<RString> december;
}
