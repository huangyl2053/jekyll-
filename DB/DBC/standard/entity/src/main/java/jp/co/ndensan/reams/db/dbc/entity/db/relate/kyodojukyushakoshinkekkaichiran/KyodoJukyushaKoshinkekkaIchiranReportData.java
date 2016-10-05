/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者情報一覧表のReportデータクラスです。
 *
 * @reamsid_L DBC-2780-030 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoJukyushaKoshinkekkaIchiranReportData {

    private RString 帳票タイトル;
    private DbWT5C30KyoudouShoriEntity 共同処理一時TBL;
    private DbWT0001HihokenshaEntity 被保険者一時TBL;
    private DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity 共同処理用受給者異動基本送付TBL;

}
