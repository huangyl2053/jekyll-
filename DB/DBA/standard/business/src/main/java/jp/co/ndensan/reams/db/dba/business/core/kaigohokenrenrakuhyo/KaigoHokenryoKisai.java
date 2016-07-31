/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険料記載Entityクラスです。
 *
 * @reamsid_L DBA-1290-070 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenryoKisai {

    private boolean is介護保険料の記載あり;
    private List<Hokenryo> 保険料段階一覧;
    private RString 対象者保険料段階区分;
}
