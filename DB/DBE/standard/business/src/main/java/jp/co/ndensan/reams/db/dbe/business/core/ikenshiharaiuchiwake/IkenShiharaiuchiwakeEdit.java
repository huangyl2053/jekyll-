/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshiharaiuchiwake;

import jp.co.ndensan.reams.db.dbe.business.core.shujiihoshushiharai.ShujiiHoshuShiharaiEdit;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshiharaiuchiwake.IkenShiharaiuchiwakeEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成料支払内訳確認書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenShiharaiuchiwakeEdit {

    /**
     * 主治医意見書作成報酬請求書の編集処理です。
     *
     * @param entity 主治医意見書作成報酬請求書
     * @param 消費税率 消費税率
     * @return IkenshoHoshuSeikyuEntity
     */
    public IkenShiharaiuchiwakeEntity getIkenShiharaiuchiwakeEntity(HoshuShiharaiJunbiRelateEntity entity, RString 消費税率) {
        IkenShiharaiuchiwakeEntity seikyuEntity = new IkenShiharaiuchiwakeEntity();
        seikyuEntity.set郵便番号(entity.getYubinNo().value());
        seikyuEntity.set住所(entity.getJusho());
        seikyuEntity.set医療機関(entity.getIryoKikanMeisho());
        seikyuEntity.set代表者名(entity.getDaihyoshaName());
        seikyuEntity.set名称付与(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成料支払内訳確認_宛先敬称, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        seikyuEntity.set帳票タイトル(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成報酬請求書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        seikyuEntity.setその他(entity.getShujiiIryoKikanCode());
        seikyuEntity.set被保険者番号(entity.getHihokenshaNo());
        seikyuEntity.set被保険者氏名(entity.getHihokenshaName().value());
        seikyuEntity.set住所(entity.getJusho());
        RStringBuilder builder = new RStringBuilder();
        builder.append(entity.getIkenshoSakuseiryo());
        builder.append("円");
        seikyuEntity.set金額(builder.toRString());
        seikyuEntity.setバーコード(ShujiiHoshuShiharaiEdit.getバーコード(entity));
        return seikyuEntity;
    }
}
