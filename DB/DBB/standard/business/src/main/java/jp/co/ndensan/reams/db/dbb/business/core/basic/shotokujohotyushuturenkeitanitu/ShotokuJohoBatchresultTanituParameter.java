/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeitanitu;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJoho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力帳票一覧のクラスです。
 *
 * @reamsid_L DBB-1690-050 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuJohoBatchresultTanituParameter implements Serializable {

    private FlexibleYear 処理年度;
    private List<ShichosonJoho> 市町村情報List;
    private RString 出力順ID;
    private ReportId 帳票ID;
    private RString 共有ファイル名;
    private RString 共有ファイルID;
    private RString 処理区分;
}
