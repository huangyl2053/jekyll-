/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinsonotashiryosakusei;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinsonotashiryosakusei.IinSonotashiryoSakuseiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinsonotashiryosakusei.SonotashiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 委員用その他資料のEditorです。
 *
 * @reamsid_L DBE-0150-170 wangrenze
 */
public class IinSonotashiryoSakuseiA4Editor implements IIinSonotashiryoSakuseiA4Editor {

    private final IinSonotashiryoSakuseiEntity item;

    /**
     * コンストラクタです。
     *
     * @param item {@link IinSonotashiryoSakuseiEntity}
     */
    protected IinSonotashiryoSakuseiA4Editor(IinSonotashiryoSakuseiEntity item) {
        this.item = item;
    }

    /**
     * 委員用その他資料を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public SonotashiryoA4ReportSource edit(SonotashiryoA4ReportSource source) {
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
        source.imgSonotashiryo = item.getその他資料();
        source.chosaGengo = item.getChosaGengo();
        source.sakuseiGengo = item.getSakuseiGengo();
        source.shinsaGengo = item.getShinsaGengo();
        source.shinseiGengo = item.getShinseiGengo();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(item.get申請書管理番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    item.get申請書管理番号());
        }

        return source;
    }
}
