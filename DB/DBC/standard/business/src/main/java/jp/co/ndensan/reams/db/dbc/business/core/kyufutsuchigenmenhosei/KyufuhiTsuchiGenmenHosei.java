/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufutsuchigenmenhosei;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費通知減免補正一覧表のbusinessクラスです。
 *
 * @reamsid_L DBC-2270-030 lijia
 */
public class KyufuhiTsuchiGenmenHosei {

    /**
     * コンストラクタです。
     *
     * @param entity 給付費通知減免補正一覧表情報
     * @param 保険者コード RString
     * @param 保険者名 RString
     * @return KyufuhiTuchiGenmenhoseiIchiranEntity 付費通知減免補正一覧表の帳票情報
     */
    public KyufuhiTuchiGenmenhoseiIchiranEntity get給付費通知減免補正一覧表の帳票情報(
            KyufuTsuchiGenmenHoseiEntity entity, RString 保険者コード, RString 保険者名) {
        KyufuhiTuchiGenmenhoseiIchiranEntity reportEntity = new KyufuhiTuchiGenmenhoseiIchiranEntity();
        reportEntity.set保険者コード(保険者コード);
        reportEntity.set保険者名(保険者名);
        reportEntity.set出力順1(RString.EMPTY);
        reportEntity.set出力順2(RString.EMPTY);
        reportEntity.set出力順3(RString.EMPTY);
        reportEntity.set出力順4(RString.EMPTY);
        reportEntity.set出力順5(RString.EMPTY);
        reportEntity.set改ページ条件1(RString.EMPTY);
        reportEntity.set改ページ条件2(RString.EMPTY);
        reportEntity.set改ページ条件3(RString.EMPTY);
        reportEntity.set改ページ条件4(RString.EMPTY);
        reportEntity.set改ページ条件5(RString.EMPTY);
        reportEntity.set被保険者番号(entity.getHiHokenshaNo().value());
        reportEntity.set被保険者名(entity.getPsmName());
        reportEntity.set年月(entity.getServiceTeikyoYM().toDateString());
        reportEntity.setサービス事業者コード(entity.getJigyoshoNo().value());
        reportEntity.setサービス事業者(entity.getJigyoshaName());
        reportEntity.setサービス種類コード(entity.getServiceShuruiCode().value());
        reportEntity.setサービス種類(entity.getServiceShuruiMeisho());
        reportEntity.set利用者負担額(entity.getRiyoshaFutangaku());
        reportEntity.setサービス費用(entity.getServiceHiyoTotal());
        return reportEntity;
    }
}
