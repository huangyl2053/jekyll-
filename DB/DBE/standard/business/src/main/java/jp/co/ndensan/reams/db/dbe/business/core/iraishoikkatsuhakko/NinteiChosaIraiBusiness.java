/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko;

import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaIraiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.NinteiChosaIraiRelateEntity;

/**
 *
 * バッチ設計_DBE220003_認定調査依頼発行一覧表のRelateBusinessクラスです。
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
public class NinteiChosaIraiBusiness {

    /**
     * 帳票「帳票設計_DBE220003_認定調査依頼発行一覧表」Headerデータを作成するメッソドです。
     *
     * @param processParamter processParamter
     * @return ChosaIraiHakkoIchiranhyoHeadItem
     */
    public ChosaIraiHakkoIchiranhyoHeadItem setHeadItem(NinteiChosaIraiProcessParamter processParamter) {
        ChosaIraiHakkoIchiranhyoHeadItem headItem = new ChosaIraiHakkoIchiranhyoHeadItem();
        headItem.set認定調査依頼書FLG(processParamter.getNinteiChosaIraisyo());
        headItem.set依頼日From(processParamter.getIraiFromYMD());
        headItem.set依頼日To(processParamter.getIraiToYMD());
        return headItem;
    }

    /**
     * 帳票「帳票設計_DBE220003_認定調査依頼発行一覧表」Bodyデータを作成するメッソドです。
     *
     * @param entity entity
     * @return ChosaIraiHakkoIchiranhyoHeadItem
     */
    public ChosaIraiHakkoIchiranhyoBodyItem setBodyItem(NinteiChosaIraiRelateEntity entity) {
        ChosaIraiHakkoIchiranhyoBodyItem bodyItem = new ChosaIraiHakkoIchiranhyoBodyItem();
        bodyItem.set依頼書作成日(entity.getIraishoShutsuryokuYMD());
        bodyItem.set依頼書提出期限(entity.getNinteichosaKigenYMD());
        bodyItem.set市町村コード(entity.getShichosonCode());
        bodyItem.set市町村名称(entity.getShichosonMeisho());
        bodyItem.set被保険者番号(entity.getHihokenshaNo());
        bodyItem.set被保険者氏名(entity.getHihokenshaName());
        bodyItem.set依頼日(entity.getNinteichosaIraiYMD());
        bodyItem.set委託先名(entity.getJigyoshaMeisho());
        bodyItem.set代表者名(entity.getDaihyoshaName());
        bodyItem.set連絡先(entity.getTelNo());
        bodyItem.set調査員名(entity.getChosainShimei());
        return bodyItem;
    }
}
