/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710050.HanyoListKyodoJukyushaNoRobanOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710050.HanyoListKyodoJukyushaOutputProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710050.DBC710050_HanyoListKyodoJukyushaKihonParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710050.HanyoListKyodoJukyushaProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_共同処理用受給者情報（基本）のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3097-020 qinzhen
 */
public class DBC710050_HanyoListKyodoJukyushaKihon extends BatchFlowBase<DBC710050_HanyoListKyodoJukyushaKihonParameter> {

    private static final String 共同受給者基本情報 = "hanyoListKyodoJukyushaOutputProcess";
    private static final String 共同受給者基本情報_連番しない = "hanyoListKyodoJukyushaNoRobanOutputProcess";
    private RDateTime システム日時;

    @Override
    protected void defineFlow() {
        システム日時 = RDateTime.now();
        if (getParameter().isRenbanFuka()) {
            executeStep(共同受給者基本情報);
        } else {
            executeStep(共同受給者基本情報_連番しない);
        }
    }

    @Step(共同受給者基本情報)
    IBatchFlowCommand hanyoListKyodoJukyushaOutputProcess() {
        return loopBatch(HanyoListKyodoJukyushaOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(共同受給者基本情報_連番しない)
    IBatchFlowCommand hanyoListKyodoJukyushaNoRobanOutputProcess() {
        return loopBatch(HanyoListKyodoJukyushaNoRobanOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    private HanyoListKyodoJukyushaProcessParameter getProcessParameter() {
        HanyoListKyodoJukyushaProcessParameter param = new HanyoListKyodoJukyushaProcessParameter();
        param.set帳票ID(getParameter().getChohyoId());
        if (getParameter().getShutsuryokujunId() != null) {
            param.set出力順ID(new RString(getParameter().getShutsuryokujunId()));
        }
        param.set出力項目ID(getParameter().getShutsuryokukomokuId());
        param.set保険者コード(new LasdecCode(getParameter().getHokenshaKodo()));
        if (getParameter().getShoriTaishoNengetsuFrom() != null) {
            param.set処理対象年月FROM(new FlexibleYearMonth(getParameter().getShoriTaishoNengetsuFrom()));
        }
        if (getParameter().getShoriTaishoNengetsuTo() != null) {
            param.set処理対象年月TO(new FlexibleYearMonth(getParameter().getShoriTaishoNengetsuTo()));
        }
        if (getParameter().getIdoNengetsuFrom() != null) {
            param.set異動年月FROM(new FlexibleYearMonth(getParameter().getIdoNengetsuFrom()));
        }
        if (getParameter().getIdoNengetsuTo() != null) {
            param.set異動年月TO(new FlexibleYearMonth(getParameter().getIdoNengetsuTo()));
        }
        param.set各異動月の最新のみ(getParameter().isKakuidozukinoSaishinNomi());
        param.set日付抽出区分(getParameter().getHitsukeChushutsuKubun());
        param.set日付編集(getParameter().isHitsukeHenshu());
        param.set異動区分S(getParameter().getIdoKubun());
        param.set項目名付加(getParameter().isKomokumeFuka());
        param.setシステム日付(new FlexibleDate(システム日時.getDate().toDateString()));
        param.setシステム日時(システム日時);
        param.set削除含める(getParameter().isSakujyoMeru());
        param.setSearchKey(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).setデータ取得区分(DataShutokuKubun.直近レコード).build());
        return param;
    }
}
