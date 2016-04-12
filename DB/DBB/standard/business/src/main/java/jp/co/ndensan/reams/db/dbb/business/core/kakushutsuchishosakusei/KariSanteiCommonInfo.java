/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei;

import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.TotalShunyuRelateEntity;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 仮算定通知書情報クラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariSanteiCommonInfo {

    private FlexibleDate 発行日;
    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private ShoriKubun 処理区分;
    private Association 地方公共団体;
    private Fuka 賦課の情報_更正後;
    private Fuka 賦課の情報_更正前;
    private CaFt703FindNokumiEntity 納組情報;
    private List<NokiJoho> 普徴納期情報List;
    private List<NokiJoho> 特徴収入情報List;
    private IAtesaki 宛先情報;
    private Fuka 前年度賦課情報;
    private IKoza 口座情報;
    private ChoshuHoho 徴収方法情報_更正前;
    private ChoshuHoho 徴収方法情報_更正後;
    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者_追加含む_の情報_更正前;
    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者_追加含む_の情報_更正後;
    private TotalShunyuRelateEntity 収入情報;
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
}
