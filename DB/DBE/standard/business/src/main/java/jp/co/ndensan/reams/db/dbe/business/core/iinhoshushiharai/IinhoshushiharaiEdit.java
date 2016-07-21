/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iinhoshushiharai;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.chosahoshushiharai.ChosaHoshuShiharaiEdit;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬支払通知書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinhoshushiharaiEdit {

    /**
     * 介護認定審査会委員報酬支払明細書の編集処理です。
     *
     * @param entity HoshuShiharaiJunbiRelateEntity
     * @param 認証者 認証者
     * @param 通知文 通知文
     * @param 口座情報 口座情報
     * @return Iinhoshushiharai
     */
    public Iinhoshushiharai getIinhoshushiharai(HoshuShiharaiJunbiRelateEntity entity, NinshoshaSource 認証者, Map<Integer, RString> 通知文,
            Koza 口座情報) {
        Decimal 差引支給額 = new Decimal(entity.getHoshu()).subtract(entity.getShinsakaiKojoZeigaku());
        Iinhoshushiharai iinhoshushiharai = new Iinhoshushiharai();
        iinhoshushiharai.set電子公印(認証者.denshiKoin);
        iinhoshushiharai.set発行日(認証者.hakkoYMD);
        iinhoshushiharai.set認証者役職名(認証者.ninshoshaYakushokuMei);
        iinhoshushiharai.set認証者役職名1(認証者.ninshoshaYakushokuMei1);
        iinhoshushiharai.set公印文字列(認証者.koinMojiretsu);
        iinhoshushiharai.set認証者役職名2(認証者.ninshoshaYakushokuMei2);
        iinhoshushiharai.set認証者氏名カナ(認証者.ninshoshaShimeiKakenai);
        iinhoshushiharai.set認証者氏名掛ける(認証者.ninshoshaShimeiKakeru);
        iinhoshushiharai.set公印省略(認証者.koinShoryaku);
        iinhoshushiharai.set通知文1(通知文.get(1));
        iinhoshushiharai.set通知文2(通知文.get(2));
        if (null != 口座情報) {
            iinhoshushiharai.set金融機関(口座情報.getCombined金融機関名and支店名());
            iinhoshushiharai.set名議人(口座情報.get口座名義人().value());
            iinhoshushiharai.set種別(口座情報.get預金種別().get預金種別名称());
            iinhoshushiharai.set番号(口座情報.get口座番号());
        }
        iinhoshushiharai.set郵便番号(entity.getYubinNo().value());
        iinhoshushiharai.set住所(entity.getJusho());
        if (entity.getShujiiCode() != null && !entity.getShujiiCode().isEmpty()) {
            iinhoshushiharai.set審査機関(entity.getIryoKikanMeisho());
            iinhoshushiharai.set代表者名(entity.getT5911_daihyoshaName());
        }
        if (entity.getNinteichosainCode() != null && !entity.getNinteichosainCode().isEmpty()) {
            iinhoshushiharai.set審査機関(entity.getJigyoshaMeisho());
            iinhoshushiharai.set代表者名(entity.getDaihyoshaName());
        }
        if (entity.getSonotaKikanCode() != null && !entity.getSonotaKikanCode().isEmpty()) {
            iinhoshushiharai.set審査機関(entity.getKikanMeisho());
            iinhoshushiharai.set代表者名(new RString(entity.getShinsakaiIinShimei().toString()));
        }
        iinhoshushiharai.set名称付与(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会委員報酬支払通知書_宛先敬称, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        iinhoshushiharai.setバーコード(ChosaHoshuShiharaiEdit.getバーコード(entity));
        iinhoshushiharai.setその他(entity.getShinsakaiIinCode());
        iinhoshushiharai.setタイトル(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会委員報酬支払通知書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        iinhoshushiharai.set審査会委員氏名(entity.getShinsakaiIinShimei().value());
        iinhoshushiharai.set報酬報償費(new RString(entity.getHoshu()));
        iinhoshushiharai.set源泉所得税(new RString(entity.getShinsakaiKojoZeigaku()));
        iinhoshushiharai.set差引支給額(decimalToRString(差引支給額));
        iinhoshushiharai.set費用弁償(new RString(entity.getShinsakaiKotsuhi()));
        iinhoshushiharai.set合計(decimalToRString(差引支給額.add(entity.getShinsakaiKotsuhi())));
        iinhoshushiharai.set審査会出席回数(new RString(entity.getX5603_count()));
        return iinhoshushiharai;
    }

    private RString decimalToRString(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }
}
