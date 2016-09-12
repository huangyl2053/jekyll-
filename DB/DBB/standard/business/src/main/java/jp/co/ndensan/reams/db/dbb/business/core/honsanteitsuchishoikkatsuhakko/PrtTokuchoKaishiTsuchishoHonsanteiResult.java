/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始通知書(本算定）の発行用引数クラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrtTokuchoKaishiTsuchishoHonsanteiResult {

    private List<HonsanteiTsuchishoTempResult> 特徴開始通知書ResultList;
    private FlexibleYear 調定年度;
    private RDate 発行日;
    private RDateTime 帳票作成日時;
    private RString 出力順ID;
    private List<RString> 出力条件リスト;
    private ReportId 帳票ID;
    private RString 帳票名;
    private RString 宛名連番;
    private RString 通知書定型文;
    private ChohyoSeigyoKyotsu 帳票制御共通;
}
