/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * 本算定通知書情報です。
 *
 * @reamsid_L DBB-9020-160 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonSanteiTsuchiShoKyotsu {

    private GennenKanen 現年度_過年度区分;
    private RDate 発行日;
    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private ShoriKubun 処理区分;
    private Association 地方公共団体;
    private FukaAtena 賦課の情報_更正前;
    private FukaAtena 賦課の情報_更正後;
    private CaFt703FindNokumiEntity 納組情報;
    private List<NokiJoho> 普徴納期情報リスト;
    private List<NokiJoho> 特徴納期情報リスト;
    private IAtesaki 宛先情報;
    private IKoza 口座情報;
    private ChoshuHoho 徴収方法情報_更正前;
    private ChoshuHoho 徴収方法情報_更正後;
    private NenkinTokuchoKaifuJoho 対象者_追加含む_情報_更正前;
    private NenkinTokuchoKaifuJoho 対象者_追加含む_情報_更正後;
    private ShunyuJoho 収入情報;
    private ChohyoSeigyoKyotsu 帳票制御共通;
}
