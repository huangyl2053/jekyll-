/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費通知発行一覧表のCSVファイルを作成するクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTuchiHakkoIchiranCSV {

    /**
     * コンストラクタです。
     *
     * @param tuchiHakkoEntity KyufuhiTuchiHakkoEntity
     * @return 介護保険給付費通知書のEntity
     */
    public KyufuhiTuchiHakkoIchiranCsvEntity csvファイル作成(KyufuhiTuchiHakkoEntity tuchiHakkoEntity) {
        KyufuhiTuchiHakkoIchiranCsvEntity hakkoEntity = new KyufuhiTuchiHakkoIchiranCsvEntity();
        hakkoEntity.set作成日時(RDate.getNowDate().toDateString());
        hakkoEntity.set被保険者番号(tuchiHakkoEntity.get被保険者番号());
        hakkoEntity.set被保険者氏名(tuchiHakkoEntity.get名称());
        hakkoEntity.set証記載保険者番号(tuchiHakkoEntity.get証記載保険者名());
        hakkoEntity.setサービス年月(tuchiHakkoEntity.getサービス提供年月());
        hakkoEntity.setサービス事業者コード(tuchiHakkoEntity.get事業所番号());
        hakkoEntity.setサービス事業者名称(tuchiHakkoEntity.get事業者名称());
        hakkoEntity.setサービス種類コード(tuchiHakkoEntity.getサービス種類コード());
        hakkoEntity.setサービス項目コード(tuchiHakkoEntity.getサービス項目コード());
        hakkoEntity.setサービス名称(tuchiHakkoEntity.getサービス名称());
        hakkoEntity.setサービス日数_回数(tuchiHakkoEntity.get日数_回数());
        if (tuchiHakkoEntity.get利用者負担額() != null) {
            hakkoEntity.set利用者負担額(new RString(tuchiHakkoEntity.get利用者負担額().toString()));
        }
        if (tuchiHakkoEntity.getサービス費用合計額() != null) {
            hakkoEntity.setサービス費用(new RString(tuchiHakkoEntity.getサービス費用合計額().toString()));
        }
        if (tuchiHakkoEntity.getサービス提供年月() != null && tuchiHakkoEntity.get要介護状態区分コード() != null) {
            hakkoEntity.set要介護度(YokaigoJotaiKubunSupport.toValue(new FlexibleDate(tuchiHakkoEntity.getサービス提供年月()),
                    tuchiHakkoEntity.get要介護状態区分コード()).getName());
        }
        hakkoEntity.set資格喪失年月日(tuchiHakkoEntity.get資格喪失年月日());
        if (tuchiHakkoEntity.get資格喪失事由コード() != null) {
            hakkoEntity.set資格喪失事由(ShikakuSoshitsuJiyu.toValue(tuchiHakkoEntity.get資格喪失事由コード()).get名称());
        }
        if ((tuchiHakkoEntity.get利用者負担額() != null && 0 < tuchiHakkoEntity.get利用者負担額().intValue())
                || (tuchiHakkoEntity.getサービス費用合計額() != null && 0 < tuchiHakkoEntity.getサービス費用合計額().intValue())) {
            hakkoEntity.set補正有無(new RString("※"));
        }
        return hakkoEntity;
    }
}
