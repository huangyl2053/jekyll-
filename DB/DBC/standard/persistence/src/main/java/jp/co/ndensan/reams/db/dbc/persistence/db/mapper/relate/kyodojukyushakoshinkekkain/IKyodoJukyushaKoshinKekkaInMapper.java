/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyodojukyushakoshinkekkain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportData;

/**
 * バッチ設計書_DBCMNF2002-5C3、5D3、5E3_共同処理用受給者情報更新結果情報取込Mapperクラスです。
 *
 * @reamsid_L DBC-2780-010 lishengli
 */
public interface IKyodoJukyushaKoshinKekkaInMapper {

    /**
     * 帳票出力対象データ取得する。
     *
     * @return List<KyodoJukyushaKoshinkekkaIchiranReportData>
     */
    List<KyodoJukyushaKoshinkekkaIchiranReportData> 帳票出力対象データ取得();

}
