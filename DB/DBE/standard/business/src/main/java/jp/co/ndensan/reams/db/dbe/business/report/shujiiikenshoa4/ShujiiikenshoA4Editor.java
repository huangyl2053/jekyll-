/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa4;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikensho.ShujiiikenshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1A4.ShujiiikenshoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 事務局用主治医意見書のEditorです。
 *
 * @reamsid_L DBE-0150-090 wangrenze
 */
public class ShujiiikenshoA4Editor implements IShujiiikenshoA4Editor {

    private final ShujiiikenshoEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiikenshoEntity}
     */
    protected ShujiiikenshoA4Editor(ShujiiikenshoEntity item) {
        this.item = item;
    }

    /**
     * 事務局用主治医意見書を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ShujiiikenshoA4ReportSource edit(ShujiiikenshoA4ReportSource source) {
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
        source.imgIkensho1 = item.get主治医意見書イメージ１();
        source.chosaGengo = item.getChosaGengo();
        source.sakuseiGengo = item.getSakuseiGengo();
        source.shinsaGengo = item.getShinsaGengo();
        source.shinseiGengo = item.getShinseiGengo();

        source.two_hokenshaNo = item.get保険者番号();
        source.two_hihokenshaNo = item.get被保険者番号();
        source.two_hihokenshaName = item.get名前();
        source.two_shinseiGengo = item.getShinseiGengo();
        source.two_shinseiYY = item.get今回認定申請年();
        source.two_shinseiMM = item.get今回認定申請月();
        source.two_shinseiDD = item.get今回認定申請日();
        source.two_sakuseiGengo = item.getSakuseiGengo();
        source.two_sakuseiYY = item.get審査会資料作成年();
        source.two_sakuseiMM = item.get審査会資料作成月();
        source.two_sakuseiDD = item.get審査会資料作成日();
        source.two_chosaGengo = item.getChosaGengo();
        source.two_chosaYY = item.get今回認定調査実施年();
        source.two_chosaMM = item.get今回認定調査実施月();
        source.two_chosaDD = item.get今回認定調査実施日();
        source.two_shinsaGengo = item.getShinsaGengo();
        source.two_shinsaYY = item.get今回認定審査年();
        source.two_shinsaMM = item.get今回認定審査月();
        source.two_shinsaDD = item.get今回認定審査日();
        source.two_imgIkensho2 = item.get主治医意見書イメージ２();
        source.shikibetuCode = ShikibetsuCode.EMPTY;

        if (!RString.isNullOrEmpty(item.get被保険者番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    item.get被保険者番号());
        }
        return source;
    }
}
