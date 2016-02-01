/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力対象者明細一覧用RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KaigoNinteiShinsakaiScheduleRelateEntity {

    private RString shinsakai;
    private RString kaisaiYMD;
    private RString time;
    private RString gogitai;
    private RString kaijyo;
    private RString kaijyoJusho;
    private RString kaijyoTelNo;
}
