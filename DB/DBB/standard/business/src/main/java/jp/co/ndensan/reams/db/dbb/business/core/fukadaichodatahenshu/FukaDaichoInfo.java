/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fukadaichodatahenshu;

import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 賦課台帳情報クラスです。
 *
 * @reamsid_L DBB-9100-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaDaichoInfo {

    private YMDHMS 基準日時;
    private FukaAtena 賦課の情報_更正後;
    private FukaAtena 賦課の情報_更正前;
    private IKoza 口座情報;
    private IShikibetsuTaisho 代納人情報_更正後;
    private ShunyuJoho 収入情報;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳情報;
    private List<SetaiinShotoku> 世帯員所得情報;
    private FukaJoho 前年度情報;
    private DbT1006KyokaisoGaitoshaEntity 境界層当該者情報;
    private ChoshuHoho 徴収方法情報;
    private NenkinTokuchoKaifuJoho 対象者_追加含む_情報;
    private CaFt703FindNokumiEntity 納組情報;
    private Association 地方公共団体;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private TelNo 本人連絡先1;
    private TelNo 本人連絡先2;
    private TelNo 代納人連絡先1;
    private TelNo 代納人連絡先2;
    private List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更リスト;
    private DbV4001JukyushaDaichoEntity 受給者台帳情報;
}
