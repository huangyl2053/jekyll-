/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko;

import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouHeadItem;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoSakuseiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * バッチ設計_DBE230003_主治医意見書作成依頼発行一覧表のRelateBusinessクラスです。
 *
 * @reamsid_L DBE-0080-150 duanzhanli
 */
public class ShujiiIkenshoSakuseiBusiness {

    /**
     * 帳票「帳票設計_DBE230002_主治医意見書作成依頼一覧表」Headerデータを作成するメッソドです。
     *
     * @param processParamter processParamter
     * @return SyujiyikenshosakuseyiraihakouHeadItem
     */
    public SyujiyikenshosakuseyiraihakouHeadItem setHeaderItem(ShujiiIkenshoSakuseiProcessParamter processParamter) {
        return new SyujiyikenshosakuseyiraihakouHeadItem(processParamter.getIraiFromYMD(),
                processParamter.getIraiToYMD(),
                processParamter.getShujiiIkenshoSakuseiIraisho());
    }

    /**
     * 帳票「帳票設計_DBE230002_主治医意見書作成依頼一覧表」Bodyデータを作成するメッソドです。
     *
     * @param entity entity
     * @return SyujiyikenshosakuseyiraihakouBodyItem
     */
    public SyujiyikenshosakuseyiraihakouBodyItem setBodyItem(ShujiiIkenshoSakuseiRelateEntity entity) {
        return new SyujiyikenshosakuseyiraihakouBodyItem(entity.get被保険者番号(),
                entity.get被保険者氏名(),
                entity.get依頼日(),
                entity.get医療機関名称(),
                entity.get代表者名(),
                entity.get連絡先(),
                entity.get主治医名(),
                RString.EMPTY,
                RString.EMPTY,
                entity.get依頼書作成日(),
                entity.get依頼書提出期限(),
                entity.get市町村コード(),
                entity.get市町村名称());
    }
}
