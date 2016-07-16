/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei;

import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;

/**
 * 通知書共通情報クラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KakushuTsuchishoCommonInfo {

    private Association 地方公共団体;
    private FukaAtena 賦課の情報_更正後;
    private FukaAtena 賦課の情報_更正前;
    private CaFt703FindNokumiEntity 納組情報;
    private List<NokiJoho> 普徴納期情報List;
    private List<NokiJoho> 特徴収入情報List;
    private IKojin 宛名情報;
    private IAtesaki 宛先情報;
    private IKoza 口座情報;
    private IKoza マスク口座情報;
    private ChoshuHoho 徴収方法情報_更正前;
    private ChoshuHoho 徴収方法情報_更正後;
    private NenkinTokuchoKaifuJoho 対象者_追加含む_の情報_更正前;
    private NenkinTokuchoKaifuJoho 対象者_追加含む_の情報_更正後;
    private ShunyuJoho 収入情報;
    private GennenKanen 年度区分;
}
