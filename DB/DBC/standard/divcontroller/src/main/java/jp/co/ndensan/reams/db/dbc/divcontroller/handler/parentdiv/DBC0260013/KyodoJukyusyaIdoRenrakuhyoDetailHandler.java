/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0260013;

import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshoriyojukyushaidorenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.IKyodoJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260013.KyodoJukyusyaIdoRenrakuhyoDetailDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyosakusei.KyodoshoriyoJukyushaIdoRenrakuhyoSakusei;
import jp.co.ndensan.reams.db.dbc.service.report.kyodoshorijukyushaidorenrakuhyo.KyodoShoriJukyushaIdoRenrakuhyoPrintService;
import jp.co.ndensan.reams.db.dbc.service.report.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoPrintService;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * KyodoJukyusyaIdoRenrakuhyoDetail_共同処理用受給者異動連絡票作成Handlerのクラスです。
 *
 * @reamsid_L DBC-1952-010 liuxiaoyu
 */
public class KyodoJukyusyaIdoRenrakuhyoDetailHandler {

    private final KyodoJukyusyaIdoRenrakuhyoDetailDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     */
    public KyodoJukyusyaIdoRenrakuhyoDetailHandler(KyodoJukyusyaIdoRenrakuhyoDetailDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     *
     * @return KyodoJukyusyaIdoRenrakuhyoDetailHandler
     */
    public static KyodoJukyusyaIdoRenrakuhyoDetailHandler of(KyodoJukyusyaIdoRenrakuhyoDetailDiv div) {
        return new KyodoJukyusyaIdoRenrakuhyoDetailHandler(div);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 引き継ぎ情報 KyodoJukyushaTaishoshaEntity
     * @param 照会モード RString
     *
     * @return KyodoshoriyoJukyushaIdoRenrakuhyoParam
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoParam onLoad(RString 照会モード, KyodoJukyushaTaishoshaEntity 引き継ぎ情報) {

        KyodoshoriyoJukyushaIdoRenrakuhyoParam param = div.getCcdKyodoJukyusyaIdoRenrakuhyo().initialize(
                照会モード,
                引き継ぎ情報.get被保番号(),
                引き継ぎ情報.get異動日(),
                引き継ぎ情報.is論理削除フラグ(),
                引き継ぎ情報.get対象年月());

        return param;
    }

    /**
     * 帳票発行処理のメソッドです。
     *
     * @param iKDiv IKyodoJukyushaIdoRenrakuhyoDiv
     *
     * @return SourceDataCollection
     */
    public SourceDataCollection to帳票発行(IKyodoJukyushaIdoRenrakuhyoDiv iKDiv) {

        KyodoshoriyoJukyushaIdoRenrakuhyoSakusei 受給者連絡票データ作成 = KyodoshoriyoJukyushaIdoRenrakuhyoSakusei
                .createInstance();
        KyodoshoriyoJukyushaIdoRenrakuhyoParam param = iKDiv.getNewデータ();
        if ((iKDiv.get基本送付情報を追加活性() && Decimal.ONE.equals(iKDiv.get基本送付_履歴番号()))
                || (iKDiv.get償還送付情報を追加活性() && Decimal.ONE.equals(iKDiv.get償還送付_履歴番号()))
                || (iKDiv.get高額送付情報を追加活性() && Decimal.ONE.equals(iKDiv.get高額送付_履歴番号()))) {
            KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity 異動連絡票データ = 受給者連絡票データ作成
                    .editKyodoshoriyoJukyushaIdoRenrakuhyo(param);
            KyodoShoriJukyushaIdoRenrakuhyoPrintService printService
                    = new KyodoShoriJukyushaIdoRenrakuhyoPrintService();
            return printService.printSingle(異動連絡票データ);
        } else {
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 訂正連絡票データ = 受給者連絡票データ作成
                    .editKyodoshoriyoJukyushaTeiseiRenrakuhyo(param);
            KyodoShoriJukyushaTeiseiRenrakuhyoPrintService printService
                    = new KyodoShoriJukyushaTeiseiRenrakuhyoPrintService();
            return printService.printSingle(訂正連絡票データ);
        }
    }
}
