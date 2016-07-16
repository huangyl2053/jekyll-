/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko;

import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;

/**
 * 本算定通知書一時テーブル情報クラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiTsuchishoTempResult {

    private DbT2015KeisangoJohoEntity 計算後情報_更正後;
    private DbT2015KeisangoJohoEntity 計算後情報_更正前;
    private FukaAtena 賦課の情報_更正前;
    private FukaAtena 賦課の情報_更正後;
    private CaFt703FindNokumiEntity 納組情報;
    private IAtesaki 宛先情報;
    private IKoza 口座情報;
    private IAtesaki 宛先代納;
    private ChoshuHoho 徴収方法情報_更正前;
    private ChoshuHoho 徴収方法情報_更正後;
    private NenkinTokuchoKaifuJoho 対象者_追加含む_情報_更正前;
    private NenkinTokuchoKaifuJoho 対象者_追加含む_情報_更正後;
    private ShunyuJoho 収入情報;
}
