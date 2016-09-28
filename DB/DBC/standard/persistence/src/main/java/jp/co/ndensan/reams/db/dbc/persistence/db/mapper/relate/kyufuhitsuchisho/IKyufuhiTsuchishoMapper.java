/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufuhitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranRelateEntity;

/**
 * 給付費通知書作成(一括)作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public interface IKyufuhiTsuchishoMapper {

    /**
     * 給付費通知書作成(一括)一時を取得します。
     *
     * @return 給付費通知書作成(一括)一時
     */
    KyufuhiTuchiHakkoEntity getSeikatsuHogoJukyusha();

    /**
     * 保険者構成＝単一の場合を取得します。
     *
     * @return 保険者構成＝単一の場合
     */
    KyufuhiTuchiHakkoIchiranRelateEntity get単一の場合();

    /**
     * 保険者構成＝広域の場合を取得します。
     *
     * @return 保険者構成＝広域の場合
     */
    KyufuhiTuchiHakkoIchiranRelateEntity get広域の場合();
}
