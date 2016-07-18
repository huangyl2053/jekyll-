/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshiharaiuchiwake;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.chosahoshushiharai.ChosaHoshuShiharaiEdit;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshiharaiuchiwake.IkenShiharaiuchiwakeEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
     * @param 認証者 認証者
     * @param 通知文 通知文
     * @param 口座情報 口座情報
     * @return IkenshoHoshuSeikyuEntity
     */
    public IkenShiharaiuchiwakeEntity getIkenShiharaiuchiwakeEntity(HoshuShiharaiJunbiRelateEntity entity, RString 消費税率,
            NinshoshaSource 認証者, Map<Integer, RString> 通知文, Koza 口座情報) {
        IkenShiharaiuchiwakeEntity seikyuEntity = new IkenShiharaiuchiwakeEntity();
        seikyuEntity.set電子公印(認証者.denshiKoin);
        seikyuEntity.set発行日(認証者.hakkoYMD);
        seikyuEntity.set認証者役職名(認証者.ninshoshaYakushokuMei);
        seikyuEntity.set認証者役職名1(認証者.ninshoshaYakushokuMei1);
        seikyuEntity.set公印文字列(認証者.koinMojiretsu);
        seikyuEntity.set認証者役職名2(認証者.ninshoshaYakushokuMei2);
        seikyuEntity.set認証者氏名カナ(認証者.ninshoshaShimeiKakenai);
        seikyuEntity.set認証者氏名掛ける(認証者.ninshoshaShimeiKakeru);
        seikyuEntity.set公印省略(認証者.koinShoryaku);
        seikyuEntity.set通知文1(通知文.get(1));
        seikyuEntity.set通知文2(通知文.get(2));
        seikyuEntity.set口座種別(口座情報.get預金種別().get預金種別名称());
        seikyuEntity.set口座番号(口座情報.get口座番号());
        seikyuEntity.set金融機関(口座情報.getCombined金融機関名and支店名());
        seikyuEntity.set口座名義人(口座情報.get口座名義人().value());
        seikyuEntity.set支店(口座情報.get支店().get支店名称());
        seikyuEntity.set郵便番号(entity.getYubinNo().value());
        seikyuEntity.set住所(entity.getJusho());
        seikyuEntity.set医療機関(entity.getIryoKikanMeisho());
        seikyuEntity.set代表者名(entity.getDaihyoshaName());
        seikyuEntity.set名称付与(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成料支払内訳確認_宛先敬称, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        seikyuEntity.set帳票タイトル(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成報酬請求書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        seikyuEntity.setその他(entity.getShujiiIryoKikanCode());
        seikyuEntity.setバーコード(ChosaHoshuShiharaiEdit.getバーコード(entity));
        seikyuEntity.set被保険者番号(entity.getHihokenshaNo());
        seikyuEntity.set被保険者氏名(entity.getHihokenshaName().value());
        seikyuEntity.set住所(entity.getJusho());
        RStringBuilder builder = new RStringBuilder();
        builder.append(entity.getIkenshoSakuseiryo());
        builder.append("円");
        seikyuEntity.set金額(builder.toRString());
        return seikyuEntity;
    }
}
