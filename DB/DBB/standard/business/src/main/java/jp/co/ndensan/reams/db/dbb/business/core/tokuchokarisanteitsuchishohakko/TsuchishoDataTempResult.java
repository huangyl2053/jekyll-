/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteitsuchishohakko;

import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import lombok.Getter;
import lombok.Setter;

/**
 * 仮算定のデータのエンティティクラスです。
 *
 * @reamsid_L DBB-0790-040 chenaoqi
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchishoDataTempResult {

    private NenkinTokuchoKaifuJoho 対象者_追加含む_情報;
    private DbTKeisangoJohoTempTableEntity 計算後情報Entity;
    private FukaAtena 賦課の情報;
    private CaFt703FindNokumiEntity 納組情報;
    private IAtesaki 宛先情報;
    private ChoshuHoho 徴収方法情報;
    private FukaJoho 前年度賦課情報;
}
