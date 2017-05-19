/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.saikinshorisha;

import jp.co.hos.coreports.CoReports;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteisaikinshorisha.NinteiSaikinShorishas;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7501NinteiSaikinShorishaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7501NinteiSaikinShorishaDac;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 最近処理者に関する処理を行うサービスです。
 */
public class SaikinShorishaService {

    /**
     * 現在のコンテキストに一致する、最近処理の対象者一覧を取得します。
     *
     * @return
     */
    public NinteiSaikinShorishas findTarget(ShoKisaiHokenshaNo 証記載保険者番号) {
        DbT7501NinteiSaikinShorishaDac dac = InstanceProvider.create(DbT7501NinteiSaikinShorishaDac.class);
        return new NinteiSaikinShorishas(証記載保険者番号.isEmpty()
                ? dac.selectByUser(ControlDataHolder.getUserId())
                : dac.selectByKey(ControlDataHolder.getUserId(), 証記載保険者番号)
        );
    }

    /**
     * 最近処理者の情報を更新します。<br/>
     * 処理対象が確定した時に呼び出してください。
     *
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaName 被保険者氏名
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void update(RString hihokenshaNo, RString hihokenshaName, ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        if (hihokenshaNo == null || hihokenshaNo.isEmpty()) {   //被保険者番号未指定は保存しない
            return;
        }
        DbT7501NinteiSaikinShorishaDac dac = InstanceProvider.create(DbT7501NinteiSaikinShorishaDac.class);
        dac.save(new DbT7501NinteiSaikinShorishaEntity(ControlDataHolder.getUserId(), shoKisaiHokenshaNo, hihokenshaNo, hihokenshaName));
    }

}
