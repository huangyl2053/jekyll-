/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710060.HanyoListKyodoJukyushaKogakuProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710060.DBC710060_HanyoListKyodoJukyushaKogakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710060.HanyoListKyodoJukyushaKogakuProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 汎用リスト 共同処理用受給者情報（高額）のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3098-020 xushouyue
 */
public class DBC710060_HanyoListKyodoJukyushaKogaku extends BatchFlowBase<DBC710060_HanyoListKyodoJukyushaKogakuParameter> {

    private static final String 共同処理用受給者情報_高額 = "hanyoListKyodoJukyushaKogakuProcess";
    private RDateTime システム日時;

    @Override
    protected void defineFlow() {
        システム日時 = RDateTime.now();
        executeStep(共同処理用受給者情報_高額);
    }

    @Step(共同処理用受給者情報_高額)
    IBatchFlowCommand hanyoListKagoKekkaOutputProcess() {
        return loopBatch(HanyoListKyodoJukyushaKogakuProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    private HanyoListKyodoJukyushaKogakuProcessParameter getProcessParameter() {
        HanyoListKyodoJukyushaKogakuProcessParameter param = new HanyoListKyodoJukyushaKogakuProcessParameter();
        param.set帳票ID(getParameter().getChohyoId());
        param.set出力順ID(getParameter().getShutsuryokujunId());
        param.set出力項目ID(getParameter().getShutsuryokukomokuId());
        param.set項目名付加(getParameter().isKomokumeFuka());
        param.set連番付加(getParameter().isRenbanFuka());
        param.set日付編集(getParameter().isHitsukeHenshu());
        param.set保険者コード(getParameter().getHokenshaKodo());
        param.set日付抽出区分(getParameter().getHitsukeChushutsuKubun());
        param.set処理対象年月From(getParameter().getShoriTaishoNengetsuFrom());
        param.set処理対象年月To(getParameter().getShoriTaishoNengetsuTo());
        param.set異動年月From(getParameter().getIdoNengetsuFrom());
        param.set異動年月To(getParameter().getIdoNengetsuTo());
        param.set各異動月の最新のみ(getParameter().isKakuidozukinoSaishinNomi());
        param.set異動区分s(getParameter().getIdoKubun());
        param.set世帯所得区分s(getParameter().getSeidaiKubun());
        param.set所得区分s(getParameter().getShotokuKubun());
        param.set老齢年金受給区分s(getParameter().getRoreiNenkinJyukyuKubun());
        param.set利用者負担第２段階s(getParameter().getRyoshaFutanDainiDankai());
        param.set削除含める(getParameter().isSakujyoMeru());
        param.setシステム日時(システム日時);
        param.setSearchKey(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).setデータ取得区分(DataShutokuKubun.直近レコード).build());
        return param;
    }
}
