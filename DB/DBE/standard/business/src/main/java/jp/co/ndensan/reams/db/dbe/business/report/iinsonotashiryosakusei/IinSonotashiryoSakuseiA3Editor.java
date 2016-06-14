/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinsonotashiryosakusei;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinsonotashiryosakusei.IinSonotashiryoSakuseiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinsonotashiryosakusei.SonotashiryoA3ReportSource;

/**
 * 委員用その他資料のEditorです。
 *
 * @reamsid_L DBE-0150-170 wangrenze
 */
public class IinSonotashiryoSakuseiA3Editor implements IIinSonotashiryoSakuseiA3Editor {

    private final IinSonotashiryoSakuseiEntity item;

    /**
     * コンストラクタです。
     *
     * @param item {@link IinSonotashiryoSakuseiEntity}
     */
    protected IinSonotashiryoSakuseiA3Editor(IinSonotashiryoSakuseiEntity item) {
        this.item = item;
    }

    /**
     * 委員用その他資料を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public SonotashiryoA3ReportSource edit(SonotashiryoA3ReportSource source) {
        source.hokenshaNo = item.get保険者番号();
        source.hihokenshaNo = item.get被保険者番号();
        source.hihokenshaName = item.get名前();
        source.sakuseiYY = item.get審査会資料作成年();
        source.sakuseiMM = item.get審査会資料作成月();
        source.sakuseiDD = item.get審査会資料作成日();
        source.shinseiYY = item.get今回認定申請年();
        source.shinseiMM = item.get今回認定申請月();
        source.shinseiDD = item.get今回認定申請日();
        source.chosaYY = item.get今回認定調査実施年();
        source.chosaMM = item.get今回認定調査実施月();
        source.chosaDD = item.get今回認定調査実施日();
        source.shinsaYY = item.get今回認定審査年();
        source.shinsaMM = item.get今回認定審査月();
        source.shinsaDD = item.get今回認定審査日();
        source.imgSonotashiryo1 = item.get左のその他資料イメージ();
        source.imgSonotashiryo2 = item.get右のその他資料イメージ();
        return source;
    }
}
