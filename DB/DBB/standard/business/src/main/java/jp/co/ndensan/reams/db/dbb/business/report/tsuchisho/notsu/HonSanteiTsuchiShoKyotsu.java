/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fuka.DbT2002FukaEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * 本算定通知書情報です。
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
    private DbT2002FukaEntity 賦課の情報_更正前;
    private DbT2002FukaEntity 賦課の情報_更正後;
//納組情報;TODO CaFt703FindNokumiEntity
    private List<NokiJoho> 普徴納期情報リスト;
    private List<NokiJoho> 特徴納期情報リスト;
    private IAtesaki 宛先情報;
    private IKoza 口座情報;
    private ChoshuHoho 徴収方法情報_更正前;
    private ChoshuHoho 徴収方法情報_更正後_;
//対象者_追加含む_情報_更正前_;TODO
//対象者_追加含む_情報_更正後_;TODO
    private List<ShunyuJoho> 収入情報;
//帳票制御共通;	TODO

}
